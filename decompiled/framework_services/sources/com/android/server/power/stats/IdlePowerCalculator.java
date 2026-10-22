package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class IdlePowerCalculator extends PowerCalculator {
    private static final boolean DEBUG = false;
    private static final String TAG = "IdlePowerCalculator";
    private final double mAveragePowerCpuIdleMahPerUs;
    private final double mAveragePowerCpuSuspendMahPerUs;
    public long mDurationMs;
    public double mPowerMah;

    public IdlePowerCalculator(PowerProfile powerProfile) {
        this.mAveragePowerCpuSuspendMahPerUs = powerProfile.getAveragePower("cpu.suspend") / 3.6E9d;
        this.mAveragePowerCpuIdleMahPerUs = powerProfile.getAveragePower("cpu.idle") / 3.6E9d;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 16) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        calculatePowerAndDuration(batteryStats, rawRealtimeUs, rawUptimeUs, 0);
        if (this.mPowerMah == 0.0d) goto L6;
        builder.getAggregateBatteryConsumerBuilder(0).setConsumedPower(16, this.mPowerMah).setUsageDurationMillis(16, this.mDurationMs);
        return;
    }

    private void calculatePowerAndDuration(BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, int statsType) {
        long batteryRealtimeUs = batteryStats.computeBatteryRealtime(rawRealtimeUs, statsType);
        long batteryUptimeUs = batteryStats.computeBatteryUptime(rawUptimeUs, statsType);
        double suspendPowerMah = batteryRealtimeUs * this.mAveragePowerCpuSuspendMahPerUs;
        double idlePowerMah = batteryUptimeUs * this.mAveragePowerCpuIdleMahPerUs;
        this.mPowerMah = suspendPowerMah + idlePowerMah;
        this.mDurationMs = batteryRealtimeUs / 1000;
    }
}
