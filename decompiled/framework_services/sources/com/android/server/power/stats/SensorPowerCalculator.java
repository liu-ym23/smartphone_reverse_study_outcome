package com.android.server.power.stats;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.SparseArray;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SensorPowerCalculator extends PowerCalculator {
    private final SparseArray<Sensor> mSensors;

    public SensorPowerCalculator(SensorManager sensorManager) {
        List<Sensor> sensors = sensorManager.getSensorList(-1);
        this.mSensors = new SparseArray(sensors.size());
        int i = 0;
    L4:
        if (i >= sensors.size()) goto L7;
        Sensor sensor = sensors.get(i);
        this.mSensors.put(sensor.getHandle(), sensor);
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 9) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        double appsPowerMah = 0.0d;
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
    L3:
        if (i < 0) goto L8;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        if (app.isVirtualUid() == true) goto L7;
        appsPowerMah = appsPowerMah + calculateApp(app, app.getBatteryStatsUid(), rawRealtimeUs);
    L7:
        i = i - 1;
        goto L3
    L8:
        builder.getAggregateBatteryConsumerBuilder(0).setConsumedPower(9, appsPowerMah);
        builder.getAggregateBatteryConsumerBuilder(1).setConsumedPower(9, appsPowerMah);
    }

    private double calculateApp(UidBatteryConsumer.Builder app, BatteryStats.Uid u, long rawRealtimeUs) {
        double powerMah = calculatePowerMah(u, rawRealtimeUs, 0);
        app.setUsageDurationMillis(9, calculateDuration(u, rawRealtimeUs, 0)).setConsumedPower(9, powerMah);
        return powerMah;
    }

    private long calculateDuration(BatteryStats.Uid u, long rawRealtimeUs, int statsType) {
        long durationMs = 0;
        SparseArray<? extends BatteryStats.Uid.Sensor> sensorStats = u.getSensorStats();
        int NSE = sensorStats.size();
        int ise = 0;
    L3:
        if (ise >= NSE) goto L10;
        int sensorHandle = sensorStats.keyAt(ise);
        if (sensorHandle == (-10000)) goto L8;
        BatteryStats.Uid.Sensor sensor = (BatteryStats.Uid.Sensor) sensorStats.valueAt(ise);
        BatteryStats.Timer timer = sensor.getSensorTime();
        durationMs = durationMs + (timer.getTotalTimeLocked(rawRealtimeUs, statsType) / 1000);
    L8:
        ise = ise + 1;
        goto L3
    L10:
        return durationMs;
    }

    private double calculatePowerMah(BatteryStats.Uid u, long rawRealtimeUs, int statsType) {
        double powerMah = 0.0d;
        SparseArray<? extends BatteryStats.Uid.Sensor> sensorStats = u.getSensorStats();
        int count = sensorStats.size();
        int ise = 0;
    L3:
        if (ise >= count) goto L17;
        int sensorHandle = sensorStats.keyAt(ise);
        if (sensorHandle == (-10000)) goto L14;
        BatteryStats.Uid.Sensor sensor = (BatteryStats.Uid.Sensor) sensorStats.valueAt(ise);
        BatteryStats.Timer timer = sensor.getSensorTime();
        long sensorTime = timer.getTotalTimeLocked(rawRealtimeUs, statsType) / 1000;
        if (sensorTime == 0) goto L14;
        Sensor s = this.mSensors.get(sensorHandle);
        if (s == null) goto L14;
        double powerMah2 = powerMah;
        double powerMah3 = (sensorTime * s.getPower()) / 3600000.0f;
        powerMah = powerMah2 + powerMah3;
    L15:
        ise = ise + 1;
    L14:
        powerMah = powerMah;
        goto L15
    L17:
        return powerMah;
    }
}
