package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
class FlashlightPowerStatsProcessor extends BinaryStatePowerStatsProcessor {
    FlashlightPowerStatsProcessor(PowerProfile powerProfile) {
        super(6, powerProfile.getAveragePower("camera.flashlight"));
    }

    @Override // com.android.server.power.stats.processor.BinaryStatePowerStatsProcessor
    protected int getBinaryState(BatteryStats.HistoryItem item) {
        if ((item.states2 & 134217728) == 0) goto L5;
        return 1;
    L5:
        return 0;
    }
}
