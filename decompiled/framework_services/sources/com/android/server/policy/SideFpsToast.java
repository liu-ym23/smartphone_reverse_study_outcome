package com.android.server.policy;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/* JADX INFO: loaded from: classes2.dex */
public class SideFpsToast extends Dialog {
    SideFpsToast(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(17367466);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.0f;
        windowParams.flags |= 2;
        windowParams.gravity = 80;
        window.setAttributes(windowParams);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        Button turnOffScreen = (Button) findViewById(16909946);
        if (turnOffScreen == null) goto L6;
        turnOffScreen.setOnClickListener(listener);
        return;
    }

    public void addAccessibilityDelegate() {
        Button turnOffScreen = (Button) findViewById(16909946);
        if (turnOffScreen == null) goto L6;
        turnOffScreen.setAccessibilityDelegate(new AnonymousClass1(this));
        return;
    }
}
