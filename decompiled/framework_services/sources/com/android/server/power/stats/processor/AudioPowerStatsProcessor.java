package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
class AudioPowerStatsProcessor extends BinaryStatePowerStatsProcessor {
    AudioPowerStatsProcessor(PowerProfile powerProfile) {
        super(4, powerProfile.getAveragePower("audio"));
    }

    @Override // com.android.server.power.stats.processor.BinaryStatePowerStatsProcessor
    protected int getBinaryState(BatteryStats.HistoryItem item) {
        if ((item.states & 4194304) == 0) goto L5;
        return 1;
    L5:
        return 0;
    }
}
