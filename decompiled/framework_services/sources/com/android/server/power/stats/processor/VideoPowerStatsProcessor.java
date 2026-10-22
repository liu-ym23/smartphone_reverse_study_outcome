package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
class VideoPowerStatsProcessor extends BinaryStatePowerStatsProcessor {
    VideoPowerStatsProcessor(PowerProfile powerProfile) {
        super(5, powerProfile.getAveragePower("video"));
    }

    @Override // com.android.server.power.stats.processor.BinaryStatePowerStatsProcessor
    protected int getBinaryState(BatteryStats.HistoryItem item) {
        if ((item.states2 & 1073741824) == 0) goto L5;
        return 1;
    L5:
        return 0;
    }
}
