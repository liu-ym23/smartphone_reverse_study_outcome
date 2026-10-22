package com.android.server;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class BasePermissionDialog extends AlertDialog {
    private final Handler mInfoHandler;
    private boolean mState;

    /* JADX INFO: renamed from: -$$Nest$fputmState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m80$$Nest$fputmState(BasePermissionDialog r0, boolean r1) {
        r0.mState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$msetEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m81$$Nest$msetEnabled(BasePermissionDialog r0, boolean r1) {
        r0.setEnabled(r1);
    }

    public BasePermissionDialog(Context dialogCon) {
        super(dialogCon, 0);
        this.mInfoHandler = new AnonymousClass1(this);
        this.mState = true;
        getWindow().setType(2010);
        getWindow().setFlags(131072, 131072);
        WindowManager.LayoutParams permInfo = getWindow().getAttributes();
        permInfo.setTitle("Permission Dialog");
        permInfo.flags |= 67108864;
        getWindow().setAttributes(permInfo);
        setIconAttribute(R.attr.alertDialogIcon);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (this.mState == false) goto L7;
        return true;
    L7:
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        setEnabled(false);
        Button b = (Button) findViewById(R.id.button1);
        if (b == null) goto L5;
        b.setFocusable(true);
        b.setFocusableInTouchMode(true);
        b.requestFocus();
    L5:
        this.mInfoHandler.sendMessage(this.mInfoHandler.obtainMessage(0));
    }

    private void setEnabled(boolean setState) {
        Button btn = getButton(-1);
        if (btn == null) goto L5;
        btn.setEnabled(setState);
    L5:
        Button btn2 = getButton(-2);
        if (btn2 == null) goto L8;
        btn2.setEnabled(setState);
    L8:
        Button btn3 = getButton(-3);
        if (btn3 == null) goto L12;
        btn3.setEnabled(setState);
        return;
    }
}
