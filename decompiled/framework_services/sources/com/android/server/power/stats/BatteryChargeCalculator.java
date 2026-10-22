package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryChargeCalculator extends PowerCalculator {
    public BatteryChargeCalculator() {
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        return true;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        builder.addDischargePercentage(batteryStats.getDischargeAmount(0));
        int batteryCapacityMah = batteryStats.getBatteryCapacity();
        builder.setBatteryCapacity(batteryCapacityMah);
        double dischargedPowerLowerBoundMah = ((double) (batteryStats.getLowDischargeAmountSinceCharge() * batteryCapacityMah)) / 100.0d;
        double dischargedPowerUpperBoundMah = ((double) (batteryStats.getHighDischargeAmountSinceCharge() * batteryCapacityMah)) / 100.0d;
        builder.addDischargedPowerRange(dischargedPowerLowerBoundMah, dischargedPowerUpperBoundMah).addDischargeDurationMs(batteryStats.getBatteryRealtime(rawRealtimeUs) / 1000);
        long batteryTimeRemainingMs = batteryStats.computeBatteryTimeRemaining(rawRealtimeUs);
        if (batteryTimeRemainingMs == (-1)) goto L5;
        builder.setBatteryTimeRemainingMs(batteryTimeRemainingMs / 1000);
    L5:
        long chargeTimeRemainingMs = batteryStats.computeChargeTimeRemaining(rawRealtimeUs);
        if (chargeTimeRemainingMs == (-1)) goto L8;
        builder.setChargeTimeRemainingMs(chargeTimeRemainingMs / 1000);
    L8:
        long dischargeMah = batteryStats.getUahDischarge(0) / 1000;
        if (dischargeMah != 0) goto L11;
        dischargeMah = (long) (((dischargedPowerLowerBoundMah + dischargedPowerUpperBoundMah) / 2.0d) + 0.5d);
    L11:
        builder.getAggregateBatteryConsumerBuilder(0).setConsumedPower(dischargeMah);
    }
}
