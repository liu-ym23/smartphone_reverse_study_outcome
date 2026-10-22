package com.android.server.power.stats;

import android.os.BatteryConsumer;
import com.android.server.power.stats.format.BinaryStatePowerStatsLayout;

/* JADX INFO: loaded from: classes3.dex */
public class CameraPowerStatsCollector extends EnergyConsumerPowerStatsCollector {
    public CameraPowerStatsCollector(EnergyConsumerPowerStatsCollector.Injector injector) {
        super(injector, 3, BatteryConsumer.powerComponentIdToString(3), 7, new BinaryStatePowerStatsLayout());
    }
}
