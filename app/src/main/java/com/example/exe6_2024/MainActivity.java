package com.example.exe6_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener {
    int count = 0;
    TextView tvc;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvc = findViewById(R.id.tvc);
        et = findViewById(R.id.et);
        strt();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.btnc){
            save();
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }
        return true;
    }
    public void save(){
        SharedPreferences settings = getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Counter",count);
        editor.putString("String",et.getText().toString());
        editor.commit();
    }

    public void add(View view) {
        count++;
        tvc.setText(count+"");
        }
    public void res(View view) {
        count = 0;
        tvc.setText(count+"");
    }

    public void out(View view) {
        save();
        finish();
    }
    public void strt(){
        SharedPreferences settings = getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        tvc.setText(settings.getInt("Counter",0)+"");
        et.setHint(settings.getString("String","Enter Text"));
    }
}