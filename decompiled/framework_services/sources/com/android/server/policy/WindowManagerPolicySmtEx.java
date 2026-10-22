package com.android.server.policy;

import android.view.WindowManagerPolicyConstantsSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public interface WindowManagerPolicySmtEx extends WindowManagerPolicyConstantsSmtEx {

    public interface OnKeyguardFaceIDVerifyResult {
        void onFaceAuthenticationSucceeded();
    }

    public interface OnKeyguardFingerprintVerifyResult {
        void onAuthenticationAcquired(int r1);

        void onAuthenticationError(int r1, CharSequence r2);

        void onAuthenticationFailed();

        void onAuthenticationHelp(int r1, CharSequence r2);

        void onAuthenticationSucceeded();
    }

    public interface OnKeyguardVerifyResult {
        void onKeyguardVerifyResult(boolean r1, int r2);
    }

    public interface WindowManagerFuncsSmtEx {
        int getLidState(int r1);

        boolean isCameraRecordingVisibleAndTop();

        boolean isInCallCardVisibleAndTop();

        void onScreenOnOrOffChangedExt(boolean r1);

        void screenStateChanged(boolean r1);
    }

    public interface WindowStateSmtEx {
        int getHintWidth();

        int getTaskId();

        WindowManagerPolicy.WindowState getTopParentWindow();

        boolean isChildWindow();

        boolean isInActivityStackView();

        boolean isOverlapKeyguard();

        boolean isSidebarSideView();
    }

    void dispatchScreenDim(boolean r1);

    long getLastGoingToSleepTime();

    long getLastWakingUpTime();

    boolean isKeyguardShowing();

    boolean isKeyguardVerified();

    boolean isTwistRotateWindow();

    void notifyActivityDrawnForKeyguardLw();

    void registerFaceIDVerifyCallback(OnKeyguardFaceIDVerifyResult r1, boolean r2);

    void registerFingerprintVerifyCallback(OnKeyguardFingerprintVerifyResult r1, boolean r2);

    void setForceHideKeyguardExt(boolean r1);

    void verifyKeyguardSecurely(OnKeyguardVerifyResult r1, String r2);

    static int getWindowLayerFromTypeLw(int type) {
        switch(type) {
            case 2000: goto L20;
            case 2018: goto L19;
            case 2020: goto L20;
            case 2051: goto L17;
            case 2052: goto L17;
            case 2053: goto L15;
            case 2054: goto L13;
            case 2058: goto L11;
            case 2059: goto L9;
            case 2060: goto L8;
            case 2063: goto L11;
            case 2064: goto L6;
            default: goto L4;
        };
    L4:
        return -1;
    L6:
        return 33;
    L8:
        return 34;
    L9:
        return 30;
    L11:
        return 7;
    L13:
        return 35;
    L15:
        return 29;
    L17:
        return 28;
    L19:
        return 34;
    L20:
        return 26;
    }
}
