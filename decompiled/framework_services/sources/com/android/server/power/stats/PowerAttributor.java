package com.android.server.power.stats;

import android.os.BatteryUsageStats;
import android.util.IndentingPrintWriter;
import com.android.internal.os.BatteryStatsHistory;

/* JADX INFO: loaded from: classes3.dex */
public interface PowerAttributor {
    void dumpEstimatedPowerConsumption(IndentingPrintWriter r1, BatteryStatsHistory r2, long r3, long r5);

    void estimatePowerConsumption(BatteryUsageStats.Builder r1, BatteryStatsHistory r2, long r3, long r5);

    long getLastSavedEstimatesPowerConsumptionTimestamp();

    boolean isPowerComponentSupported(int r1);

    long storeEstimatedPowerConsumption(BatteryStatsHistory r1, long r2, long r4);
}
