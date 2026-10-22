package com.android.server.power.stats.processor;

import com.android.internal.os.PowerProfile;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.UsageBasedPowerEstimator;
import com.android.server.power.stats.format.WakelockPowerStatsLayout;

/* JADX INFO: loaded from: classes3.dex */
class WakelockPowerStatsProcessor extends PowerStatsProcessor {
    private static final WakelockPowerStatsLayout sStatsLayout = null;
    private final UsageBasedPowerEstimator mPowerEstimator;

    static {
        sStatsLayout = new WakelockPowerStatsLayout();
    }

    WakelockPowerStatsProcessor(PowerProfile powerProfile) {
        this.mPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("cpu.idle"));
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void addPowerStats(PowerComponentAggregatedPowerStats stats, PowerStats powerStats, long timestampMs) {
        long durationMs = sStatsLayout.getUsageDuration(powerStats.stats);
        if (durationMs != 0) goto L5;
        return;
    L5:
        double power = this.mPowerEstimator.calculatePower(durationMs);
        sStatsLayout.setDevicePowerEstimate(powerStats.stats, power);
        long totalDuration = 0;
        int i = powerStats.uidStats.size() - 1;
    L6:
        if (i < 0) goto L9;
        totalDuration = totalDuration + sStatsLayout.getUidUsageDuration((long[]) powerStats.uidStats.valueAt(i));
        i = i - 1;
        goto L6
    L9:
        if (totalDuration == 0) goto L13;
        int i2 = powerStats.uidStats.size() - 1;
    L11:
        if (i2 < 0) goto L13;
        long[] uidStats = (long[]) powerStats.uidStats.valueAt(i2);
        sStatsLayout.setUidPowerEstimate(uidStats, (sStatsLayout.getUidUsageDuration(uidStats) * power) / totalDuration);
        i2 = i2 - 1;
    L13:
        super.addPowerStats(stats, powerStats, timestampMs);
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void finish(PowerComponentAggregatedPowerStats stats, long timestampMs) {
    }
}
