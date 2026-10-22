package com.android.server.policy;

import android.R;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class SideFpsEventHandler implements View.OnClickListener {
    private static final int DEBOUNCE_DELAY_MILLIS = 500;
    private static final String TAG = "SideFpsEventHandler";
    private final AccessibilityManager mAccessibilityManager;
    private int mBiometricState;
    private final Context mContext;
    private SideFpsToast mDialog;
    private DialogProvider mDialogProvider;
    private final int mDismissDialogTimeout;
    private FingerprintManager mFingerprintManager;
    private final Handler mHandler;
    private long mLastPowerPressTime;
    private final PowerManager mPowerManager;
    private final AtomicBoolean mSideFpsEventHandlerReady;
    private final Runnable mTurnOffDialog;

    interface DialogProvider {
        SideFpsToast provideDialog(Context r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$7WCpULzQqurwXvcr-S5fl0eDrnQ, reason: not valid java name */
    public static /* synthetic */ void m7262$r8$lambda$7WCpULzQqurwXvcrS5fl0eDrnQ(SideFpsEventHandler r0, long r1) {
        r0.lambda$shouldConsumeSinglePress$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$hUl7AR5H7QymGA_diiCu63ix0v4(SideFpsEventHandler r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$rrQJZCWA_XBACvHifL-BSzsAKtA, reason: not valid java name */
    public static /* synthetic */ SideFpsToast m7263$r8$lambda$rrQJZCWA_XBACvHifLBSzsAKtA(Context r0) {
        return lambda$new$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccessibilityManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityManager m7264$$Nest$fgetmAccessibilityManager(SideFpsEventHandler r0) {
        return r0.mAccessibilityManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ SideFpsToast m7265$$Nest$fgetmDialog(SideFpsEventHandler r0) {
        return r0.mDialog;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7266$$Nest$fgetmHandler(SideFpsEventHandler r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSideFpsEventHandlerReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m7267$$Nest$fgetmSideFpsEventHandlerReady(SideFpsEventHandler r0) {
        return r0.mSideFpsEventHandlerReady;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBiometricState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7268$$Nest$fputmBiometricState(SideFpsEventHandler r0, int r1) {
        r0.mBiometricState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7269$$Nest$fputmDialog(SideFpsEventHandler r0, SideFpsToast r1) {
        r0.mDialog = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdismissDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7270$$Nest$mdismissDialog(SideFpsEventHandler r0, String r1) {
        r0.dismissDialog(r1);
    }

    private /* synthetic */ void lambda$new$0() {
        dismissDialog("mTurnOffDialog");
    }

    SideFpsEventHandler(Context context, Handler handler, PowerManager powerManager) {
        this(context, handler, powerManager, new SideFpsEventHandler$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ SideFpsToast lambda$new$1(Context ctx) {
        SideFpsToast dialog = new SideFpsToast(ctx);
        dialog.getWindow().setType(2017);
        dialog.requestWindowFeature(1);
        return dialog;
    }

    SideFpsEventHandler(Context context, Handler handler, PowerManager powerManager, DialogProvider provider) {
        this.mTurnOffDialog = new SideFpsEventHandler$$ExternalSyntheticLambda0(this);
        this.mContext = context;
        this.mHandler = handler;
        this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService(AccessibilityManager.class);
        this.mPowerManager = powerManager;
        this.mBiometricState = 0;
        this.mSideFpsEventHandlerReady = new AtomicBoolean(false);
        this.mDialogProvider = provider;
        context.registerReceiver(new AnonymousClass1(this), new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.mDismissDialogTimeout = context.getResources().getInteger(R.integer.config_toastDefaultGravity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        goToSleep(this.mLastPowerPressTime);
    }

    public void notifyPowerPressed() {
        Log.i(TAG, "notifyPowerPressed");
        if (this.mFingerprintManager != null) goto L8;
        if (this.mSideFpsEventHandlerReady.get() == false) goto L8;
        this.mFingerprintManager = (FingerprintManager) this.mContext.getSystemService(FingerprintManager.class);
    L8:
        if (this.mFingerprintManager != null) goto L10;
        return;
    L10:
        this.mFingerprintManager.onPowerPressed();
    }

    public boolean shouldConsumeSinglePress(final long eventTime) {
        if (this.mSideFpsEventHandlerReady.get() == true) goto L6;
        return false;
    L6:
        switch(this.mBiometricState) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    L8:
        return true;
    L9:
        this.mHandler.post(new SideFpsEventHandler$$ExternalSyntheticLambda2(this, eventTime));
        return true;
    }

    private /* synthetic */ void lambda$shouldConsumeSinglePress$2(long eventTime) {
        if (this.mHandler.hasCallbacks(this.mTurnOffDialog) == false) goto L5;
        Log.v(TAG, "Detected a tap to turn off dialog, ignoring");
        this.mHandler.removeCallbacks(this.mTurnOffDialog);
    L5:
        showDialog(eventTime, "Enroll Power Press");
        if (this.mAccessibilityManager.isEnabled() == true) goto L9;
        this.mHandler.postDelayed(this.mTurnOffDialog, this.mDismissDialogTimeout);
        return;
    }

    private void goToSleep(long eventTime) {
        this.mPowerManager.goToSleep(eventTime, 4, 0);
    }

    public void onFingerprintSensorReady() {
        PackageManager pm = this.mContext.getPackageManager();
        if (pm.hasSystemFeature("android.hardware.fingerprint") == true) goto L5;
        return;
    L5:
        final FingerprintManager fingerprintManager = (FingerprintManager) this.mContext.getSystemService(FingerprintManager.class);
        fingerprintManager.addAuthenticatorsRegisteredCallback(new AnonymousClass2(this, fingerprintManager));
    }

    private void dismissDialog(String reason) {
        Log.d(TAG, "Dismissing dialog with reason: " + reason);
        if (this.mDialog != null) goto L5;
        return;
    L5:
        if (this.mDialog.isShowing() == false) goto L9;
        this.mDialog.dismiss();
        return;
    }

    private void showDialog(long time, String reason) {
        Log.d(TAG, "Showing dialog with reason: " + reason);
        if (this.mDialog != null) goto L5;
    L8:
        this.mDialog = this.mDialogProvider.provideDialog(this.mContext);
        this.mLastPowerPressTime = time;
        this.mDialog.show();
        this.mDialog.setOnClickListener(this);
        if (this.mAccessibilityManager.isEnabled() == false) goto L12;
        this.mDialog.addAccessibilityDelegate();
        return;
    L12:
        return;
    L5:
        if (this.mDialog.isShowing() == false) goto L8;
        Log.d(TAG, "Ignoring show dialog");
    }
}
