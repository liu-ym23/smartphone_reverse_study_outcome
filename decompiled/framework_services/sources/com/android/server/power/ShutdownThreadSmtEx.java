package com.android.server.power;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import bytedanceos.app.SmtProgressDialog;

/* JADX INFO: loaded from: classes3.dex */
public class ShutdownThreadSmtEx {
    private ShutdownThread mBase;
    private Object mHideLock;
    ResultReceiver mHideResultReceiver;

    /* JADX INFO: renamed from: -$$Nest$fgetmHideLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7567$$Nest$fgetmHideLock(ShutdownThreadSmtEx r0) {
        return r0.mHideLock;
    }

    public ShutdownThreadSmtEx(ShutdownThread base) {
        this.mHideLock = new Object();
        final Handler r1 = null;
        this.mHideResultReceiver = new AnonymousClass1(this, r1);
        this.mBase = base;
    }

    public void requestHideSoftInput() {
        if (InputMethodManager.getSmtEx().hideCurrentSoft(0, this.mHideResultReceiver) == true) goto L5;
        return;
    L5:
        Object r0 = this.mHideLock;
        monitor-enter(r0);
        this.mHideLock.wait(1000);     // Catch: Throwable -> L9 Exception -> L11
    L9:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public SmtProgressDialog showDialog(Context context, boolean reboot) {
        SmtProgressDialog dialog = new SmtProgressDialog(context, R.style.Animation.SearchBar);
        dialog.setSystemUiVisibility(1284);
        dialog.setMessageColor(Color.parseColor("#4CFFFFFF"));
        if (reboot == false) goto L5;
        dialog.setMessage(context.getText(R.string.sim_added_title));
    L6:
        dialog.setMessageColor(-1);
        dialog.getWindow().setType(2021);
        dialog.setCancelable(false);
        dialog.show();
        return dialog;
    L5:
        dialog.setMessage(context.getText(R.string.wfcSpnFormat_wifi));
        goto L6
    }
}
