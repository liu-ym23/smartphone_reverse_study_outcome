package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PowerCalculator {
    protected static final boolean DEBUG = false;
    protected static final double MILLIAMPHOUR_PER_MICROCOULOMB = 2.777777777777778E-7d;

    public abstract boolean isPowerComponentSupported(int r1);

    public PowerCalculator() {
    }

    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
    L3:
        if (i < 0) goto L6;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        calculateApp(app, app.getBatteryStatsUid(), rawRealtimeUs, rawUptimeUs, query);
        i = i - 1;
        goto L3
    }

    protected void calculateApp(UidBatteryConsumer.Builder app, BatteryStats.Uid u, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
    }

    public void reset() {
    }

    protected static int getPowerModel(long consumedEnergyUC, BatteryUsageStatsQuery query) {
        if (consumedEnergyUC != (-1)) goto L5;
        return 1;
    L5:
        if (query.shouldForceUsePowerProfileModel() == true) goto L10;
        return 2;
    L10:
        return 1;
    }

    protected static int getPowerModel(long consumedEnergyUC) {
        if (consumedEnergyUC == (-1)) goto L5;
        return 2;
    L5:
        return 1;
    }

    public static double uCtoMah(long chargeUC) {
        return chargeUC * MILLIAMPHOUR_PER_MICROCOULOMB;
    }
}
