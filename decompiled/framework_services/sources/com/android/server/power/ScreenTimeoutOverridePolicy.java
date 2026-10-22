package com.android.server.power;

import android.R;
import android.content.Context;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
final class ScreenTimeoutOverridePolicy {
    public static final int RELEASE_REASON_NON_INTERACTIVE = 1;
    public static final int RELEASE_REASON_SCREEN_LOCK = 2;
    public static final int RELEASE_REASON_UNKNOWN = -1;
    public static final int RELEASE_REASON_USER_ACTIVITY_ACCESSIBILITY = 7;
    public static final int RELEASE_REASON_USER_ACTIVITY_ATTENTION = 3;
    public static final int RELEASE_REASON_USER_ACTIVITY_BUTTON = 5;
    public static final int RELEASE_REASON_USER_ACTIVITY_OTHER = 4;
    public static final int RELEASE_REASON_USER_ACTIVITY_TOUCH = 6;
    public static final int RELEASE_REASON_WAKE_LOCK_DEATH = 8;
    private static final String TAG = "ScreenTimeoutOverridePolicy";
    private int mLastAutoReleaseReason;
    private PolicyCallback mPolicyCallback;
    private long mScreenTimeoutOverrideConfig;

    interface PolicyCallback {
        void releaseAllScreenTimeoutOverrideWakelocks(int r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReleaseReason {
    }

    ScreenTimeoutOverridePolicy(Context context, long minimumScreenOffTimeoutConfig, PolicyCallback callback) {
        this.mLastAutoReleaseReason = -1;
        this.mScreenTimeoutOverrideConfig = context.getResources().getInteger(R.integer.config_shutdownBatteryTemperature);
        if (this.mScreenTimeoutOverrideConfig >= minimumScreenOffTimeoutConfig) goto L5;
        Slog.w(TAG, "Screen timeout override is smaller than the minimum timeout : " + this.mScreenTimeoutOverrideConfig);
        this.mScreenTimeoutOverrideConfig = -1;
    L5:
        this.mPolicyCallback = callback;
    }

    long getScreenTimeoutOverrideLocked(int wakeLockSummary, long screenOffTimeout) {
        if (isWakeLockAcquired(wakeLockSummary) == true) goto L6;
        return screenOffTimeout;
    L6:
        if (this.mScreenTimeoutOverrideConfig >= 0) goto L9;
        return screenOffTimeout;
    L9:
        return Math.min(this.mScreenTimeoutOverrideConfig, screenOffTimeout);
    }

    void onUserActivity(int wakeLockSummary, int event) {
        if (isWakeLockAcquired(wakeLockSummary) == true) goto L5;
        return;
    L5:
        switch(event) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            default: goto L6;
        };
    L6:
        return;
    L7:
        releaseAllWakeLocks(3);
        return;
    L9:
        releaseAllWakeLocks(7);
        return;
    L11:
        releaseAllWakeLocks(6);
        return;
    L13:
        releaseAllWakeLocks(5);
        return;
    L15:
        releaseAllWakeLocks(4);
    }

    void checkScreenWakeLock(int wakeLockSummary) {
        if (isWakeLockAcquired(wakeLockSummary) == true) goto L6;
        return;
    L6:
        if ((wakeLockSummary & 14) == 0) goto L9;
        releaseAllWakeLocks(2);
        return;
    }

    void onWakefulnessChange(int wakeLockSummary, int globalWakefulness) {
        if (isWakeLockAcquired(wakeLockSummary) == true) goto L6;
        return;
    L6:
        if (globalWakefulness == 1) goto L9;
        releaseAllWakeLocks(1);
        return;
    }

    private boolean isWakeLockAcquired(int wakeLockSummary) {
        if ((wakeLockSummary & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void logReleaseReason() {
        Slog.i(TAG, "Releasing all screen timeout override wake lock. (reason=" + this.mLastAutoReleaseReason + ")");
    }

    private void releaseAllWakeLocks(int reason) {
        this.mPolicyCallback.releaseAllScreenTimeoutOverrideWakelocks(reason);
        this.mLastAutoReleaseReason = reason;
        logReleaseReason();
    }

    void dump(PrintWriter pw) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        ipw.println();
        ipw.println("ScreenTimeoutOverridePolicy:");
        ipw.increaseIndent();
        ipw.println("mScreenTimeoutOverrideConfig=" + this.mScreenTimeoutOverrideConfig);
        ipw.println("mLastAutoReleaseReason=" + this.mLastAutoReleaseReason);
    }
}
