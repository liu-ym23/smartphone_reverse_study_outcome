package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class WakelockPowerCalculator extends PowerCalculator {
    private static final boolean DEBUG = false;
    private static final String TAG = "WakelockPowerCalculator";
    private final UsageBasedPowerEstimator mPowerEstimator;

    private static class PowerAndDuration {
        public long durationMs;
        public double powerMah;

        /* synthetic */ PowerAndDuration(WakelockPowerCalculatorIA r1) {
            this();
        }

        private PowerAndDuration() {
        }
    }

    public WakelockPowerCalculator(PowerProfile profile) {
        this.mPowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("cpu.idle"));
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 12) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        PowerAndDuration result = new PowerAndDuration(null);
        UidBatteryConsumer.Builder osBatteryConsumer = null;
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
        double appPowerMah = 0.0d;
        double appPowerMah2 = 0.0d;
        long totalAppDurationMs = 0;
        long osDurationMs = 0;
    L4:
        if (i < 0) goto L14;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        double osPowerMah = appPowerMah;
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders2 = uidBatteryConsumerBuilders;
        double appPowerMah3 = appPowerMah2;
        calculateApp(result, app.getBatteryStatsUid(), rawRealtimeUs, 0);
        app.setUsageDurationMillis(12, result.durationMs).setConsumedPower(12, result.powerMah);
        if (app.isVirtualUid() == true) goto L8;
        totalAppDurationMs = totalAppDurationMs + result.durationMs;
        appPowerMah2 = result.powerMah + appPowerMah3;
    L10:
        if (app.getUid() != 0) goto L12;
        osBatteryConsumer = app;
        long osDurationMs2 = result.durationMs;
        osDurationMs = osDurationMs2;
        appPowerMah = result.powerMah;
    L13:
        i = i - 1;
        uidBatteryConsumerBuilders = uidBatteryConsumerBuilders2;
        goto L4
    L12:
        appPowerMah = osPowerMah;
        goto L13
    L8:
        appPowerMah2 = appPowerMah3;
        goto L10
    L14:
        double osPowerMah2 = appPowerMah;
        double appPowerMah4 = appPowerMah2;
        calculateRemaining(result, batteryStats, rawRealtimeUs, rawUptimeUs, 0, osPowerMah2, osDurationMs, totalAppDurationMs);
        long totalAppDurationMs2 = totalAppDurationMs;
        double remainingPowerMah = result.powerMah;
        if (osBatteryConsumer == null) goto L17;
        osBatteryConsumer.setUsageDurationMillis(12, result.durationMs).setConsumedPower(12, remainingPowerMah);
    L17:
        long wakeTimeMs = calculateWakeTimeMillis(batteryStats, rawRealtimeUs, rawUptimeUs);
        if (wakeTimeMs >= 0) goto L20;
        wakeTimeMs = 0;
    L20:
        builder.getAggregateBatteryConsumerBuilder(0).setUsageDurationMillis(12, wakeTimeMs).setConsumedPower(12, appPowerMah4 + remainingPowerMah);
        builder.getAggregateBatteryConsumerBuilder(1).setUsageDurationMillis(12, totalAppDurationMs2).setConsumedPower(12, appPowerMah4);
    }

    private void calculateApp(PowerAndDuration result, BatteryStats.Uid u, long rawRealtimeUs, int statsType) {
        long wakeLockTimeUs = 0;
        ArrayMap<String, ? extends BatteryStats.Uid.Wakelock> wakelockStats = u.getWakelockStats();
        int wakelockStatsCount = wakelockStats.size();
        int i = 0;
    L3:
        if (i >= wakelockStatsCount) goto L8;
        BatteryStats.Uid.Wakelock wakelock = (BatteryStats.Uid.Wakelock) wakelockStats.valueAt(i);
        BatteryStats.Timer timer = wakelock.getWakeTime(0);
        if (timer == null) goto L7;
        wakeLockTimeUs = wakeLockTimeUs + timer.getTotalTimeLocked(rawRealtimeUs, statsType);
    L7:
        i = i + 1;
        goto L3
    L8:
        result.durationMs = wakeLockTimeUs / 1000;
        result.powerMah = this.mPowerEstimator.calculatePower(result.durationMs);
    }

    private void calculateRemaining(PowerAndDuration result, BatteryStats stats, long rawRealtimeUs, long rawUptimeUs, int statsType, double osPowerMah, long osDurationMs, long totalAppDurationMs) {
        long wakeTimeMillis = calculateWakeTimeMillis(stats, rawRealtimeUs, rawUptimeUs) - totalAppDurationMs;
        if (wakeTimeMillis <= 0) goto L5;
        double power = this.mPowerEstimator.calculatePower(wakeTimeMillis);
        result.durationMs = osDurationMs + wakeTimeMillis;
        result.powerMah = osPowerMah + power;
        return;
    L5:
        result.durationMs = 0;
        result.powerMah = 0.0d;
    }

    private long calculateWakeTimeMillis(BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs) {
        long batteryUptimeUs = batteryStats.getBatteryUptime(rawUptimeUs);
        long screenOnTimeUs = batteryStats.getScreenOnTime(rawRealtimeUs, 0);
        return (batteryUptimeUs - screenOnTimeUs) / 1000;
    }
}
