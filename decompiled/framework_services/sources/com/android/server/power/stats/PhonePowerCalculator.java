package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class PhonePowerCalculator extends PowerCalculator {
    private final UsageBasedPowerEstimator mPowerEstimator;

    public PhonePowerCalculator(PowerProfile powerProfile) {
        this.mPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("radio.active"));
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 14) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        long energyConsumerUC = batteryStats.getPhoneEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(energyConsumerUC, query);
        long phoneOnTimeMs = batteryStats.getPhoneOnTime(rawRealtimeUs, 0) / 1000;
        switch(powerModel) {
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        double phoneOnPower = this.mPowerEstimator.calculatePower(phoneOnTimeMs);
    L7:
        if (phoneOnPower != 0.0d) goto L9;
        return;
    L9:
        builder.getAggregateBatteryConsumerBuilder(0).setConsumedPower(14, phoneOnPower, powerModel).setUsageDurationMillis(14, phoneOnTimeMs);
        return;
    L5:
        phoneOnPower = PowerCalculator.uCtoMah(energyConsumerUC);
        goto L7
    }
}
