package com.android.server.policy;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Slog;
import android.view.KeyEvent;
import bytedanceos.app.BytedanceGlobalActions;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneWindowManagerSmtEx extends PhoneWindowManagerSmtBase implements WindowManagerPolicySmtEx {
    public static final int MSG_DO_MEMORY_ACTION = 35;
    public static final int MSG_LAUNCH_ASSIST_ACTION_CANCEL = 34;
    public static final int MSG_LAUNCH_ASSIST_ACTION_DOWN = 32;
    public static final int MSG_LAUNCH_ASSIST_ACTION_UP = 33;
    private static final String TAG = "PhoneWindowManagerSmtEx";
    volatile boolean mAiKeyHandled;
    private Context mContext;
    boolean mDeviceProvisioned;
    public BytedanceGlobalActions mGlobalActions;
    private PhoneWindowManager mPhoneWindowManager;
    private PowerManager mPowerManager;

    public PhoneWindowManagerSmtEx(PhoneWindowManager manager, Handler handler) {
        super(manager, handler);
        this.mDeviceProvisioned = false;
        this.mPhoneWindowManager = manager;
    }

    public void init(Context context) {
        this.mContext = context;
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
    }

    void showGlobalActionsDialog() {
        boolean keyguardShowing = isKeyguardShowingAndNotOccluded();
        if (this.mGlobalActions != null) goto L5;
        this.mGlobalActions = new BytedanceGlobalActions(this.mContext);
    L5:
        this.mGlobalActions.showDialog(false, this.mDeviceProvisioned);
        if (keyguardShowing == false) goto L9;
        this.mPowerManager.userActivity(SystemClock.uptimeMillis(), false);
        return;
    }

    private boolean isKeyguardShowingAndNotOccluded() {
        return this.mPhoneWindowManager.isKeyguardShowingAndNotOccluded();
    }

    void onObserveSettings(ContentObserver observer) {
        ContentResolver resolver = this.mContext.getContentResolver();
        resolver.registerContentObserver(Settings.Global.getUriFor("device_provisioned"), false, observer, -1);
    }

    public void onUpdateSettings() {
        ContentResolver resolver = this.mContext.getContentResolver();
        boolean r2 = false;
        if (Settings.Global.getInt(resolver, "device_provisioned", 0) == 0) goto L5;
        r2 = true;
    L5:
        this.mDeviceProvisioned = r2;
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public boolean isKeyguardVerified() {
        return keyguardSecViewOff();
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public boolean isTwistRotateWindow() {
        return false;
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public void setForceHideKeyguardExt(boolean hide) {
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public long getLastWakingUpTime() {
        return 0;
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public long getLastGoingToSleepTime() {
        return 0;
    }

    boolean keyguardSecViewOff() {
        return false;
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public boolean isKeyguardShowing() {
        return false;
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public void dispatchScreenDim(boolean isScreenDim) {
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public void notifyActivityDrawnForKeyguardLw() {
        if (this.mPhoneWindowManager.mKeyguardDelegate == null) goto L6;
        this.mHandler.post(new AnonymousClass1(this));
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public void verifyKeyguardSecurely(WindowManagerPolicySmtEx.OnKeyguardVerifyResult callback, String pwd) {
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public void registerFingerprintVerifyCallback(WindowManagerPolicySmtEx.OnKeyguardFingerprintVerifyResult callback, boolean register) {
    }

    @Override // com.android.server.policy.WindowManagerPolicySmtEx
    public void registerFaceIDVerifyCallback(WindowManagerPolicySmtEx.OnKeyguardFaceIDVerifyResult callback, boolean register) {
    }

    public boolean isGlobalActionShown() {
        if (this.mGlobalActions != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mGlobalActions.isBytedanceGlobalActionShow() == false) goto L7;
        return true;
    }

    public void interceptAiKey(KeyEvent event, boolean down) {
        Slog.d(TAG, "interceptAiKey on Ai key action isDown=" + down + " mAiKeyHandled=" + this.mAiKeyHandled);
        Handler r0 = this.mHandler;
        Handler r1 = this.mHandler;
        if (down == false) goto L5;
        int r2 = 32;
    L6:
        r0.sendMessage(r1.obtainMessage(r2, Long.valueOf(event.getEventTime())));
        return;
    L5:
        r2 = 33;
        goto L6
    }
}
