package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class AmbientDisplayPowerCalculator extends PowerCalculator {
    private final UsageBasedPowerEstimator[] mPowerEstimators;

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 15) goto L5;
        return true;
    L5:
        return false;
    }

    public AmbientDisplayPowerCalculator(PowerProfile powerProfile) {
        int numDisplays = powerProfile.getNumDisplays();
        this.mPowerEstimators = new UsageBasedPowerEstimator[numDisplays];
        int display = 0;
    L3:
        if (display >= numDisplays) goto L6;
        this.mPowerEstimators[display] = new UsageBasedPowerEstimator(powerProfile.getAveragePowerForOrdinal("ambient.on.display", display));
        display = display + 1;
        goto L3
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        long energyConsumerUC = batteryStats.getScreenDozeEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(energyConsumerUC, query);
        long durationMs = calculateDuration(batteryStats, rawRealtimeUs, 0);
        double powerMah = calculateTotalPower(powerModel, batteryStats, rawRealtimeUs, energyConsumerUC);
        builder.getAggregateBatteryConsumerBuilder(0).setUsageDurationMillis(15, durationMs).setConsumedPower(15, powerMah, powerModel);
    }

    private long calculateDuration(BatteryStats batteryStats, long rawRealtimeUs, int statsType) {
        return batteryStats.getScreenDozeTime(rawRealtimeUs, statsType) / 1000;
    }

    private double calculateTotalPower(int powerModel, BatteryStats batteryStats, long rawRealtimeUs, long consumptionUC) {
        switch(powerModel) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return calculateEstimatedPower(batteryStats, rawRealtimeUs);
    L6:
        return PowerCalculator.uCtoMah(consumptionUC);
    }

    private double calculateEstimatedPower(BatteryStats batteryStats, long rawRealtimeUs) {
        int numDisplays = this.mPowerEstimators.length;
        double power = 0.0d;
        int display = 0;
    L3:
        if (display >= numDisplays) goto L6;
        long dozeTime = batteryStats.getDisplayScreenDozeTime(display, rawRealtimeUs) / 1000;
        power = power + this.mPowerEstimators[display].calculatePower(dozeTime);
        display = display + 1;
        goto L3
    L6:
        return power;
    }
}
