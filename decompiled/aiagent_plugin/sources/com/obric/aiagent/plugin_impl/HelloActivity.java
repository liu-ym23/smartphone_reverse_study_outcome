package com.obric.aiagent.plugin_impl;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes2.dex */
public class HelloActivity extends FragmentActivity {
    public HelloActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        TextView r3 = new TextView(this);
        r3.setText("Hello");
        r3.setTextSize(18.0f);
        r3.setGravity(17);
        setContentView(r3);
    }
}
