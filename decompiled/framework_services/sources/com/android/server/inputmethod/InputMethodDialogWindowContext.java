package com.android.server.inputmethod;

import android.R;
import android.app.ActivityThread;
import android.content.Context;
import android.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class InputMethodDialogWindowContext {
    private Context mDialogWindowContext;

    public InputMethodDialogWindowContext() {
    }

    public Context get(int displayId) {
        if (this.mDialogWindowContext != null) goto L5;
    L6:
        Context systemUiContext = ActivityThread.currentActivityThread().getSystemUiContext(displayId);
        Context windowContext = systemUiContext.createWindowContext(2012, null);
        this.mDialogWindowContext = new ContextThemeWrapper(windowContext, R.style.Theme.DeviceDefault.Settings);
    L7:
        Context systemUiContext2 = this.mDialogWindowContext;
        return systemUiContext2;
    L5:
        if (this.mDialogWindowContext.getDisplayId() == displayId) goto L7;
        goto L6
    }
}
