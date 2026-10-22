package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.SparseArray;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class AudioPowerCalculator extends PowerCalculator {
    private final UsageBasedPowerEstimator mPowerEstimator;

    private static class PowerAndDuration {
        public long durationMs;
        public double powerMah;

        /* synthetic */ PowerAndDuration(AudioPowerCalculatorIA r1) {
            this();
        }

        private PowerAndDuration() {
        }
    }

    public AudioPowerCalculator(PowerProfile powerProfile) {
        this.mPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("audio"));
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        PowerAndDuration total = new PowerAndDuration(null);
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
    L3:
        if (i < 0) goto L5;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        calculateApp(app, total, app.getBatteryStatsUid(), rawRealtimeUs);
        i = i - 1;
        goto L3
    L5:
        builder.getAggregateBatteryConsumerBuilder(0).setUsageDurationMillis(4, total.durationMs).setConsumedPower(4, total.powerMah);
        builder.getAggregateBatteryConsumerBuilder(1).setUsageDurationMillis(4, total.durationMs).setConsumedPower(4, total.powerMah);
    }

    private void calculateApp(UidBatteryConsumer.Builder app, PowerAndDuration total, BatteryStats.Uid u, long rawRealtimeUs) {
        long durationMs = this.mPowerEstimator.calculateDuration(u.getAudioTurnedOnTimer(), rawRealtimeUs, 0);
        double powerMah = this.mPowerEstimator.calculatePower(durationMs);
        app.setUsageDurationMillis(4, durationMs).setConsumedPower(4, powerMah);
        if (app.isVirtualUid() == true) goto L6;
        total.durationMs += durationMs;
        total.powerMah += powerMah;
        return;
    }
}
