package com.android.server.power.stats.format;

import android.os.PersistableBundle;
import com.android.internal.os.PowerStats;

/* JADX INFO: loaded from: classes3.dex */
public class GnssPowerStatsLayout extends BinaryStatePowerStatsLayout {
    private static final String EXTRA_DEVICE_TIME_SIGNAL_LEVEL_POSITION = "dt-sig";
    private static final String EXTRA_UID_TIME_SIGNAL_LEVEL_POSITION = "ut-sig";
    private final int mDeviceSignalLevelTimePosition;
    private final int mUidSignalLevelTimePosition;

    public GnssPowerStatsLayout() {
        this.mDeviceSignalLevelTimePosition = addDeviceSection(2, "level");
        this.mUidSignalLevelTimePosition = addUidSection(2, "level");
    }

    public GnssPowerStatsLayout(PowerStats.Descriptor descriptor) {
        super(descriptor);
        PersistableBundle extras = descriptor.extras;
        this.mDeviceSignalLevelTimePosition = extras.getInt(EXTRA_DEVICE_TIME_SIGNAL_LEVEL_POSITION);
        this.mUidSignalLevelTimePosition = extras.getInt(EXTRA_UID_TIME_SIGNAL_LEVEL_POSITION);
    }

    @Override // com.android.server.power.stats.format.PowerStatsLayout
    public void toExtras(PersistableBundle extras) {
        super.toExtras(extras);
        extras.putInt(EXTRA_DEVICE_TIME_SIGNAL_LEVEL_POSITION, this.mDeviceSignalLevelTimePosition);
        extras.putInt(EXTRA_UID_TIME_SIGNAL_LEVEL_POSITION, this.mUidSignalLevelTimePosition);
    }

    public void setDeviceSignalLevelTime(long[] stats, int signalLevel, long durationMillis) {
        stats[this.mDeviceSignalLevelTimePosition + signalLevel] = durationMillis;
    }

    public long getDeviceSignalLevelTime(long[] stats, int signalLevel) {
        return stats[this.mDeviceSignalLevelTimePosition + signalLevel];
    }

    public void setUidSignalLevelTime(long[] stats, int signalLevel, long durationMillis) {
        stats[this.mUidSignalLevelTimePosition + signalLevel] = durationMillis;
    }

    public long getUidSignalLevelTime(long[] stats, int signalLevel) {
        return stats[this.mUidSignalLevelTimePosition + signalLevel];
    }
}
