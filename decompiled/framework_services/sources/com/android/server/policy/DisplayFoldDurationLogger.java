package com.android.server.policy;

import android.metrics.LogMaker;
import android.os.SystemClock;
import com.android.internal.logging.MetricsLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
class DisplayFoldDurationLogger {
    private static final int LOG_SUBTYPE_DURATION_MASK = Integer.MIN_VALUE;
    private static final int LOG_SUBTYPE_FOLDED = 1;
    private static final int LOG_SUBTYPE_UNFOLDED = 0;
    static final int SCREEN_STATE_OFF = 0;
    static final int SCREEN_STATE_ON_FOLDED = 2;
    static final int SCREEN_STATE_ON_UNFOLDED = 1;
    static final int SCREEN_STATE_UNKNOWN = -1;
    private volatile Long mLastChanged;
    private final MetricsLogger mLogger;
    private volatile int mScreenState;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScreenState {
    }

    DisplayFoldDurationLogger() {
        this.mScreenState = -1;
        this.mLastChanged = null;
        this.mLogger = new MetricsLogger();
    }

    void onFinishedWakingUp(Boolean folded) {
        if (folded != null) goto L5;
        this.mScreenState = -1;
    L8:
        this.mLastChanged = Long.valueOf(SystemClock.uptimeMillis());
        return;
    L5:
        if (folded.booleanValue() == false) goto L7;
        this.mScreenState = 2;
        goto L8
    L7:
        this.mScreenState = 1;
        goto L8
    }

    void onFinishedGoingToSleep() {
        log();
        this.mScreenState = 0;
        this.mLastChanged = null;
    }

    void setDeviceFolded(boolean folded) {
        if (isOn() == true) goto L5;
        return;
    L5:
        log();
        if (folded == false) goto L8;
        int r0 = 2;
    L9:
        this.mScreenState = r0;
        this.mLastChanged = Long.valueOf(SystemClock.uptimeMillis());
        return;
    L8:
        r0 = 1;
        goto L9
    }

    void logFocusedAppWithFoldState(boolean r4, String r5) {
        this.mLogger.write(new LogMaker(1594).setType(4).setSubtype(r4 ? 1 : 0).setPackageName(r5));
    }

    private void log() {
        if (this.mLastChanged != null) goto L6;
        return;
    L6:
        switch(this.mScreenState) {
            case 1: goto L9;
            case 2: goto L8;
            default: goto L7;
        };
    L7:
        return;
    L8:
        int subtype = -2147483647;
    L10:
        this.mLogger.write(new LogMaker(1594).setType(4).setSubtype(subtype).setLatency(SystemClock.uptimeMillis() - this.mLastChanged.longValue()));
        return;
    L9:
        subtype = Integer.MIN_VALUE;
        goto L10
    }

    private boolean isOn() {
        if (this.mScreenState != 1) goto L5;
        return true;
    L5:
        if (this.mScreenState == 2) goto L10;
        return false;
    L10:
        return true;
    }
}
