package com.android.server.am;

import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
final class AppWaitingForDebuggerDialog extends BaseErrorDialog {
    private CharSequence mAppName;
    private final Handler mHandler;
    final ProcessRecord mProc;
    final ActivityManagerService mService;

    public AppWaitingForDebuggerDialog(ActivityManagerService service, Context context, ProcessRecord app) {
        super(context);
        this.mHandler = new AnonymousClass1(this);
        this.mService = service;
        this.mProc = app;
        this.mAppName = context.getPackageManager().getApplicationLabel(app.info);
        setCancelable(false);
        StringBuilder text = new StringBuilder();
        if (this.mAppName != null) goto L5;
    L7:
        text.append("Process ");
        text.append(app.processName);
    L8:
        text.append(" is waiting for the debugger to attach.");
        setMessage(text.toString());
        setButton(-1, "Force Close", this.mHandler.obtainMessage(1, app));
        setTitle("Waiting For Debugger");
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.privateFlags |= 16;
        attrs.setTitle("Waiting For Debugger: " + app.info.processName);
        getWindow().setAttributes(attrs);
        return;
    L5:
        if (this.mAppName.length() <= 0) goto L7;
        text.append("Application ");
        text.append(this.mAppName);
        text.append(" (process ");
        text.append(app.processName);
        text.append(")");
        goto L8
    }

    @Override // com.android.server.am.BaseErrorDialog
    protected void closeDialog() {
    }
}
