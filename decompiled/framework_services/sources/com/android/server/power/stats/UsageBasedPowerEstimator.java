package com.android.server.power.stats;

import android.os.BatteryStats;

/* JADX INFO: loaded from: classes3.dex */
public class UsageBasedPowerEstimator {
    private static final double MILLIS_IN_HOUR = 3600000.0d;
    private final double mAveragePowerMahPerMs;

    public UsageBasedPowerEstimator(double averagePowerMilliAmp) {
        this.mAveragePowerMahPerMs = averagePowerMilliAmp / MILLIS_IN_HOUR;
    }

    public boolean isSupported() {
        if (this.mAveragePowerMahPerMs == 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    public long calculateDuration(BatteryStats.Timer timer, long rawRealtimeUs, int statsType) {
        if (timer != null) goto L5;
        return 0;
    L5:
        return timer.getTotalTimeLocked(rawRealtimeUs, statsType) / 1000;
    }

    public double calculatePower(long durationMs) {
        return this.mAveragePowerMahPerMs * durationMs;
    }
}
