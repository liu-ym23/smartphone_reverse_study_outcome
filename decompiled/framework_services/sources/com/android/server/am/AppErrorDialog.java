package com.android.server.am;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.text.BidiFormatter;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
final class AppErrorDialog extends BaseErrorDialog implements View.OnClickListener {
    static int ALREADY_SHOWING = 0;
    static final int APP_INFO = 8;
    static int BACKGROUND_USER = 0;
    static final int CANCEL = 7;
    static int CANT_SHOW = 0;
    static final long DISMISS_TIMEOUT = 300000;
    static final int FORCE_QUIT = 1;
    static final int FORCE_QUIT_AND_REPORT = 2;
    static final int MUTE = 5;
    static final int RESTART = 3;
    static final int TIMEOUT = 6;
    private IExtSystemServerDialogHelper mExt;
    private final Handler mHandler;
    private final boolean mIsRestartable;
    private CharSequence mMessage;
    private final ProcessRecord mProc;
    private final ActivityManagerGlobalLock mProcLock;
    private final AppErrorResult mResult;
    private final ActivityManagerService mService;

    static class Data {
        boolean isRestartableForService;
        ProcessRecord proc;
        boolean repeating;
        AppErrorResult result;
        int taskId;

        Data() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$msetResult, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1288$$Nest$msetResult(AppErrorDialog r0, int r1) {
        r0.setResult(r1);
    }

    static {
        CANT_SHOW = -1;
        BACKGROUND_USER = -2;
        ALREADY_SHOWING = -3;
    }

    public AppErrorDialog(Context context, ActivityManagerService service, Data data) {
        super(context);
        this.mHandler = new AnonymousClass1(this);
        this.mExt = (IExtSystemServerDialogHelper) ExtImplFactory.getImpl(IExtSystemServerDialogHelper.class, new Object[]{this});
        Resources res = context.getResources();
        this.mService = service;
        this.mProcLock = service.mProcLock;
        this.mProc = data.proc;
        this.mResult = data.result;
        boolean r3 = false;
        if (data.taskId != (-1)) goto L7;
        if (data.isRestartableForService == true) goto L7;
    L10:
        this.mIsRestartable = r3;
        BidiFormatter bidi = BidiFormatter.getInstance();
        if (this.mProc.getPkgList().size() != 1) goto L19;
        CharSequence name = context.getPackageManager().getApplicationLabel(this.mProc.info);
        if (name == null) goto L19;
        if (data.repeating == false) goto L17;
        int r2 = R.string.alert_windows_notification_turn_off_action;
    L18:
        this.mMessage = res.getString(r2, new Object[]{bidi.unicodeWrap(name.toString()), bidi.unicodeWrap(this.mProc.info.processName)});
    L24:
        setCancelable(true);
        setCancelMessage(this.mHandler.obtainMessage(7));
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.setTitle("Application Error: " + this.mProc.info.processName);
        attrs.privateFlags = attrs.privateFlags | 272;
        getWindow().setAttributes(attrs);
        if (this.mProc.isPersistent() == false) goto L27;
        getWindow().setType(2010);
    L27:
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(6), 300000);
        return;
    L17:
        r2 = R.string.alert_windows_notification_title;
    L19:
        CharSequence name2 = this.mProc.processName;
        if (data.repeating == false) goto L22;
        int r4 = R.string.alternative_fp_setup_notification_content;
    L23:
        this.mMessage = res.getString(r4, new Object[]{bidi.unicodeWrap(name2.toString())});
        goto L24
    L22:
        r4 = R.string.alternative_face_setup_notification_content;
    L7:
        if (Settings.Global.getInt(context.getContentResolver(), "show_restart_in_crash_dialog", 0) == 0) goto L10;
        r3 = true;
        goto L10
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View customView = getExt().getAppErrorDialog(getContext(), this.mMessage, this);
        applyObricModalMaterial(customView, "AppErrorDialog");
        setContentView(customView);
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.width = -1;
        attrs.gravity = 80;
        int offSet = getContext().getResources().getDimensionPixelOffset(R.dimen.keyguard_avatar_name_size);
        attrs.y = offSet;
        attrs.flags |= 512;
        attrs.setFitInsetsSides(0);
        getWindow().setAttributes(attrs);
        getWindow().setBackgroundDrawableResource(R.drawable.switch_bg_focused_holo_dark);
        getWindow().getDecorView().setSystemUiVisibility(4866);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mResult.mHasResult == true) goto L5;
        setResult(1);
    L5:
        super.dismiss();
    }

    private void setResult(int result) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L5:
        if (this.mProc == null) goto L9;
        this.mProc.mErrorState.getDialogController().clearCrashDialogs(false);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        this.mResult.set(result);
        this.mHandler.removeMessages(6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch(v.getId()) {
            case 16908793: goto L9;
            case 16908794: goto L8;
            case 16908795: goto L7;
            case 16908796: goto L6;
            case 16908797: goto L5;
            default: goto L15;
        };
    L5:
        this.mHandler.obtainMessage(3).sendToTarget();
        return;
    L6:
        this.mHandler.obtainMessage(2).sendToTarget();
        return;
    L7:
        this.mHandler.obtainMessage(5).sendToTarget();
        return;
    L8:
        this.mHandler.obtainMessage(1).sendToTarget();
        return;
    L9:
        this.mHandler.obtainMessage(8).sendToTarget();
        return;
    }

    public IExtSystemServerDialogHelper getExt() {
        return this.mExt;
    }
}
