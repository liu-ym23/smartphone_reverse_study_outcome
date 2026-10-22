package com.android.server.power.stats.format;

import com.android.internal.os.PowerStats;

/* JADX INFO: loaded from: classes3.dex */
public class WakelockPowerStatsLayout extends PowerStatsLayout {
    public WakelockPowerStatsLayout() {
        addDeviceSectionUsageDuration();
        addDeviceSectionPowerEstimate();
        addUidSectionUsageDuration();
        addUidSectionPowerEstimate();
    }

    public WakelockPowerStatsLayout(PowerStats.Descriptor descriptor) {
        super(descriptor);
    }
}
