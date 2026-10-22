package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
class CameraPowerStatsProcessor extends BinaryStatePowerStatsProcessor {
    CameraPowerStatsProcessor(PowerProfile powerProfile) {
        super(3, powerProfile.getAveragePower("camera.avg"));
    }

    @Override // com.android.server.power.stats.processor.BinaryStatePowerStatsProcessor
    protected int getBinaryState(BatteryStats.HistoryItem item) {
        if ((item.states2 & 2097152) == 0) goto L5;
        return 1;
    L5:
        return 0;
    }
}
