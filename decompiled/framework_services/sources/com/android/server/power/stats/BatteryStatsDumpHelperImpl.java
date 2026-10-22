package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryStatsDumpHelperImpl implements BatteryStats.BatteryStatsDumpHelper {
    private final BatteryUsageStatsProvider mBatteryUsageStatsProvider;

    public BatteryStatsDumpHelperImpl(BatteryUsageStatsProvider batteryUsageStatsProvider) {
        this.mBatteryUsageStatsProvider = batteryUsageStatsProvider;
    }

    public BatteryUsageStats getBatteryUsageStats(BatteryStats batteryStats, boolean detailed) {
        BatteryUsageStatsQuery.Builder builder = new BatteryUsageStatsQuery.Builder().setMaxStatsAgeMs(0);
        if (detailed == false) goto L6;
        builder.includePowerModels().includeProcessStateData().includeVirtualUids();
        builder.includePowerStateData().includeScreenStateData();
    L6:
        return this.mBatteryUsageStatsProvider.getBatteryUsageStats((BatteryStatsImpl) batteryStats, builder.build());
    }
}
