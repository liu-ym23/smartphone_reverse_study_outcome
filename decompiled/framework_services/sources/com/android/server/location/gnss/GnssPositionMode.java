package com.android.server.location.gnss;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class GnssPositionMode {
    private final boolean mLowPowerMode;
    private final int mMinInterval;
    private final int mMode;
    private final int mPreferredAccuracy;
    private final int mPreferredTime;
    private final int mRecurrence;

    public GnssPositionMode(int mode, int recurrence, int minInterval, int preferredAccuracy, int preferredTime, boolean lowPowerMode) {
        this.mMode = mode;
        this.mRecurrence = recurrence;
        this.mMinInterval = minInterval;
        this.mPreferredAccuracy = preferredAccuracy;
        this.mPreferredTime = preferredTime;
        this.mLowPowerMode = lowPowerMode;
    }

    public boolean equals(Object other) {
        if ((other instanceof GnssPositionMode) == false) goto L21;
        GnssPositionMode that = (GnssPositionMode) other;
        if (this.mMode == that.mMode) goto L7;
        return false;
    L7:
        if (this.mRecurrence == that.mRecurrence) goto L9;
        return false;
    L9:
        if (this.mMinInterval == that.mMinInterval) goto L11;
        return false;
    L11:
        if (this.mPreferredAccuracy == that.mPreferredAccuracy) goto L13;
        return false;
    L13:
        if (this.mPreferredTime == that.mPreferredTime) goto L15;
        return false;
    L15:
        if (this.mLowPowerMode == that.mLowPowerMode) goto L17;
        return false;
    L17:
        if (getClass() != that.getClass()) goto L28;
        return true;
    L28:
        return false;
    L21:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mMode), Integer.valueOf(this.mRecurrence), Integer.valueOf(this.mMinInterval), Integer.valueOf(this.mPreferredAccuracy), Integer.valueOf(this.mPreferredTime), Boolean.valueOf(this.mLowPowerMode), getClass()});
    }
}
