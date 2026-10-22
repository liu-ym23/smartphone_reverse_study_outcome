package com.android.server.power.stats.format;

import com.android.internal.os.PowerStats;

/* JADX INFO: loaded from: classes3.dex */
public class EnergyConsumerPowerStatsLayout extends PowerStatsLayout {
    public EnergyConsumerPowerStatsLayout() {
        addDeviceSectionEnergyConsumers(1);
        addDeviceSectionPowerEstimate();
        addUidSectionEnergyConsumers(1);
        addUidSectionPowerEstimate();
    }

    public EnergyConsumerPowerStatsLayout(PowerStats.Descriptor descriptor) {
        super(descriptor);
    }
}
