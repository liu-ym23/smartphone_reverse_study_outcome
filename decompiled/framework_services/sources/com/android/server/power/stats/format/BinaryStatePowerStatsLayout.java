package com.android.server.power.stats.format;

import com.android.internal.os.PowerStats;

/* JADX INFO: loaded from: classes3.dex */
public class BinaryStatePowerStatsLayout extends EnergyConsumerPowerStatsLayout {
    public BinaryStatePowerStatsLayout() {
        addDeviceSectionUsageDuration();
        addDeviceSectionPowerEstimate();
        addUidSectionUsageDuration();
        addUidSectionPowerEstimate();
    }

    public BinaryStatePowerStatsLayout(PowerStats.Descriptor descriptor) {
        super(descriptor);
    }
}
