package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.util.LongSparseArray;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryPowerCalculator extends PowerCalculator {
    public static final String TAG = "MemoryPowerCalculator";
    private final UsageBasedPowerEstimator[] mPowerEstimators;

    public MemoryPowerCalculator(PowerProfile profile) {
        int numBuckets = profile.getNumElements("memory.bandwidths");
        this.mPowerEstimators = new UsageBasedPowerEstimator[numBuckets];
        int i = 0;
    L3:
        if (i >= numBuckets) goto L6;
        this.mPowerEstimators[i] = new UsageBasedPowerEstimator(profile.getAveragePower("memory.bandwidths", i));
        i = i + 1;
        goto L3
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 13) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        long durationMs = calculateDuration(batteryStats, rawRealtimeUs, 0);
        double powerMah = calculatePower(batteryStats, rawRealtimeUs, 0);
        builder.getAggregateBatteryConsumerBuilder(0).setUsageDurationMillis(13, durationMs).setConsumedPower(13, powerMah);
    }

    private long calculateDuration(BatteryStats batteryStats, long rawRealtimeUs, int statsType) {
        long usageDurationMs = 0;
        LongSparseArray<? extends BatteryStats.Timer> timers = batteryStats.getKernelMemoryStats();
        int i = 0;
    L4:
        if (i >= timers.size()) goto L8;
        if (i >= this.mPowerEstimators.length) goto L8;
        usageDurationMs = usageDurationMs + this.mPowerEstimators[i].calculateDuration((BatteryStats.Timer) timers.valueAt(i), rawRealtimeUs, statsType);
        i = i + 1;
    L8:
        return usageDurationMs;
    }

    private double calculatePower(BatteryStats batteryStats, long rawRealtimeUs, int statsType) {
        double powerMah = 0.0d;
        LongSparseArray<? extends BatteryStats.Timer> timers = batteryStats.getKernelMemoryStats();
        int i = 0;
    L4:
        if (i >= timers.size()) goto L8;
        if (i >= this.mPowerEstimators.length) goto L8;
        UsageBasedPowerEstimator estimator = this.mPowerEstimators[(int) timers.keyAt(i)];
        long usageDurationMs = estimator.calculateDuration((BatteryStats.Timer) timers.valueAt(i), rawRealtimeUs, statsType);
        powerMah = powerMah + estimator.calculatePower(usageDurationMs);
        i = i + 1;
    L8:
        return powerMah;
    }
}
