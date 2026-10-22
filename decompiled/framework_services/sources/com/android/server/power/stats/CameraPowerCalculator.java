package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class CameraPowerCalculator extends PowerCalculator {
    private final UsageBasedPowerEstimator mPowerEstimator;

    public CameraPowerCalculator(PowerProfile profile) {
        this.mPowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("camera.avg"));
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        super.calculate(builder, batteryStats, rawRealtimeUs, rawUptimeUs, query);
        long consumptionUc = batteryStats.getCameraEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumptionUc, query);
        long durationMs = batteryStats.getCameraOnTime(rawRealtimeUs, 0) / 1000;
        if (powerModel != 2) goto L5;
        double powerMah = PowerCalculator.uCtoMah(consumptionUc);
    L6:
        builder.getAggregateBatteryConsumerBuilder(0).setUsageDurationMillis(3, durationMs).setConsumedPower(3, powerMah, powerModel);
        builder.getAggregateBatteryConsumerBuilder(1).setUsageDurationMillis(3, durationMs).setConsumedPower(3, powerMah, powerModel);
        return;
    L5:
        powerMah = this.mPowerEstimator.calculatePower(durationMs);
        goto L6
    }

    @Override // com.android.server.power.stats.PowerCalculator
    protected void calculateApp(UidBatteryConsumer.Builder app, BatteryStats.Uid u, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        long consumptionUc = app.getBatteryStatsUid().getCameraEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumptionUc, query);
        long durationMs = this.mPowerEstimator.calculateDuration(u.getCameraTurnedOnTimer(), rawRealtimeUs, 0);
        if (powerModel != 2) goto L5;
        double powerMah = PowerCalculator.uCtoMah(consumptionUc);
    L6:
        app.setUsageDurationMillis(3, durationMs).setConsumedPower(3, powerMah, powerModel);
        return;
    L5:
        powerMah = this.mPowerEstimator.calculatePower(durationMs);
        goto L6
    }
}
