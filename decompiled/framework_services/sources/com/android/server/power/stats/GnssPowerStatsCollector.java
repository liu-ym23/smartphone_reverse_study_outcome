package com.android.server.power.stats;

import android.os.BatteryConsumer;
import com.android.server.power.stats.format.GnssPowerStatsLayout;

/* JADX INFO: loaded from: classes3.dex */
public class GnssPowerStatsCollector extends EnergyConsumerPowerStatsCollector {
    public GnssPowerStatsCollector(EnergyConsumerPowerStatsCollector.Injector injector) {
        super(injector, 10, BatteryConsumer.powerComponentIdToString(10), 4, new GnssPowerStatsLayout());
    }
}
