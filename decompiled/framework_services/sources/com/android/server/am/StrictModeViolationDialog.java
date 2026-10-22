package com.android.server.am;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
final class StrictModeViolationDialog extends BaseErrorDialog {
    static final int ACTION_OK = 0;
    static final int ACTION_OK_AND_REPORT = 1;
    static final long DISMISS_TIMEOUT = 60000;
    private static final String TAG = "StrictModeViolationDialog";
    private final Handler mHandler;
    private final ProcessRecord mProc;
    private final AppErrorResult mResult;
    private final ActivityManagerService mService;

    /* JADX INFO: renamed from: -$$Nest$fgetmProc, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProcessRecord m1581$$Nest$fgetmProc(StrictModeViolationDialog r0) {
        return r0.mProc;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmResult, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppErrorResult m1582$$Nest$fgetmResult(StrictModeViolationDialog r0) {
        return r0.mResult;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1583$$Nest$fgetmService(StrictModeViolationDialog r0) {
        return r0.mService;
    }

    public StrictModeViolationDialog(Context context, ActivityManagerService service, AppErrorResult result, ProcessRecord app) {
        super(context);
        this.mHandler = new AnonymousClass1(this);
        Resources res = context.getResources();
        this.mService = service;
        this.mProc = app;
        this.mResult = result;
        if (app.getPkgList().size() != 1) goto L7;
        CharSequence name = context.getPackageManager().getApplicationLabel(app.info);
        if (name == null) goto L7;
        setMessage(res.getString(R.string.whichViewApplication, new Object[]{name.toString(), app.info.processName}));
    L8:
        setCancelable(false);
        setButton(-1, res.getText(R.string.expand_button_content_description_collapsed), this.mHandler.obtainMessage(0));
        if (app.mErrorState.getErrorReportReceiver() == null) goto L11;
        setButton(-2, res.getText(R.string.status_bar_call_strength), this.mHandler.obtainMessage(1));
    L11:
        getWindow().addPrivateFlags(256);
        getWindow().setTitle("Strict Mode Violation: " + app.info.processName);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), 60000);
        return;
    L7:
        setMessage(res.getString(R.string.whichViewApplicationLabel, new Object[]{app.processName.toString()}));
        goto L8
    }

    @Override // com.android.server.am.BaseErrorDialog
    protected void closeDialog() {
        this.mHandler.obtainMessage(0).sendToTarget();
    }
}
