package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.SparseArray;
import com.android.internal.os.PowerProfile;
import com.android.server.am.ProcessList;

/* JADX INFO: loaded from: classes3.dex */
public class GnssPowerCalculator extends PowerCalculator {
    private final double mAveragePowerGnssOn;
    private final double[] mAveragePowerPerSignalQuality;

    public GnssPowerCalculator(PowerProfile profile) {
        this.mAveragePowerGnssOn = profile.getAveragePowerOrDefault("gps.on", -1.0d);
        this.mAveragePowerPerSignalQuality = new double[2];
        int i = 0;
    L3:
        if (i >= 2) goto L6;
        this.mAveragePowerPerSignalQuality[i] = profile.getAveragePower("gps.signalqualitybased", i);
        i = i + 1;
        goto L3
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        double appsPowerMah = 0.0d;
        GnssPowerCalculator r5 = this;
        double averageGnssPowerMa = r5.getAverageGnssPower(batteryStats, rawRealtimeUs, 0);
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
    L3:
        if (i < 0) goto L8;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        long consumptionUC = app.getBatteryStatsUid().getGnssEnergyConsumptionUC();
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders2 = uidBatteryConsumerBuilders;
        int i2 = i;
        double powerMah = r5.calculateApp(app, app.getBatteryStatsUid(), PowerCalculator.getPowerModel(consumptionUC, query), rawRealtimeUs, averageGnssPowerMa, consumptionUC);
        if (app.isVirtualUid() == true) goto L7;
        appsPowerMah = appsPowerMah + powerMah;
    L7:
        i = i2 - 1;
        r5 = this;
        uidBatteryConsumerBuilders = uidBatteryConsumerBuilders2;
        goto L3
    L8:
        long consumptionUC2 = batteryStats.getGnssEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumptionUC2, query);
        if (powerModel != 2) goto L11;
        double powerMah2 = PowerCalculator.uCtoMah(consumptionUC2);
    L12:
        builder.getAggregateBatteryConsumerBuilder(0).setConsumedPower(10, powerMah2, powerModel);
        builder.getAggregateBatteryConsumerBuilder(1).setConsumedPower(10, appsPowerMah, powerModel);
        return;
    L11:
        powerMah2 = appsPowerMah;
        goto L12
    }

    private double calculateApp(UidBatteryConsumer.Builder app, BatteryStats.Uid u, int powerModel, long rawRealtimeUs, double averageGnssPowerMa, long consumedEnergyUC) {
        long durationMs = computeDuration(u, rawRealtimeUs, 0);
        switch(powerModel) {
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        double powerMah = computePower(durationMs, averageGnssPowerMa);
    L6:
        app.setUsageDurationMillis(10, durationMs).setConsumedPower(10, powerMah, powerModel);
        return powerMah;
    L5:
        powerMah = PowerCalculator.uCtoMah(consumedEnergyUC);
        goto L6
    }

    private long computeDuration(BatteryStats.Uid u, long rawRealtimeUs, int statsType) {
        SparseArray<? extends BatteryStats.Uid.Sensor> sensorStats = u.getSensorStats();
        BatteryStats.Uid.Sensor sensor = (BatteryStats.Uid.Sensor) sensorStats.get(ProcessList.INVALID_ADJ);
        if (sensor != null) goto L6;
        return 0;
    L6:
        BatteryStats.Timer timer = sensor.getSensorTime();
        return timer.getTotalTimeLocked(rawRealtimeUs, statsType) / 1000;
    }

    private double computePower(long sensorTime, double averageGnssPowerMa) {
        return (sensorTime * averageGnssPowerMa) / 3600000.0d;
    }

    private double getAverageGnssPower(BatteryStats stats, long rawRealtimeUs, int statsType) {
        GnssPowerCalculator r0 = this;
        double averagePower = r0.mAveragePowerGnssOn;
        if (averagePower == (-1.0d)) goto L5;
        return averagePower;
    L5:
        double averagePower2 = 0.0d;
        long totalTime = 0;
        double totalPower = 0.0d;
        int i = 0;
    L7:
        if (i >= 2) goto L9;
        long timePerLevel = stats.getGpsSignalQualityTime(i, rawRealtimeUs, statsType) / 1000;
        totalTime = totalTime + timePerLevel;
        totalPower = totalPower + (r0.mAveragePowerPerSignalQuality[i] * timePerLevel);
        i = i + 1;
        r0 = this;
        averagePower2 = averagePower2;
        goto L7
    L9:
        double averagePower3 = averagePower2;
        if (totalTime == 0) goto L13;
        return totalPower / totalTime;
    L13:
        return averagePower3;
    }
}
