package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class FlashlightPowerCalculator extends PowerCalculator {
    private final UsageBasedPowerEstimator mPowerEstimator;

    public FlashlightPowerCalculator(PowerProfile profile) {
        this.mPowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("camera.flashlight"));
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        super.calculate(builder, batteryStats, rawRealtimeUs, rawUptimeUs, query);
        long durationMs = batteryStats.getFlashlightOnTime(rawRealtimeUs, 0) / 1000;
        double powerMah = this.mPowerEstimator.calculatePower(durationMs);
        builder.getAggregateBatteryConsumerBuilder(0).setUsageDurationMillis(6, durationMs).setConsumedPower(6, powerMah);
        builder.getAggregateBatteryConsumerBuilder(1).setUsageDurationMillis(6, durationMs).setConsumedPower(6, powerMah);
    }

    @Override // com.android.server.power.stats.PowerCalculator
    protected void calculateApp(UidBatteryConsumer.Builder app, BatteryStats.Uid u, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        long durationMs = this.mPowerEstimator.calculateDuration(u.getFlashlightTurnedOnTimer(), rawRealtimeUs, 0);
        double powerMah = this.mPowerEstimator.calculatePower(durationMs);
        app.setUsageDurationMillis(6, durationMs).setConsumedPower(6, powerMah);
    }
}
