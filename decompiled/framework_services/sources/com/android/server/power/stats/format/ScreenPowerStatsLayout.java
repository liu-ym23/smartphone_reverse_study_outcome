package com.android.server.power.stats.format;

import android.os.BatteryStats;
import android.os.PersistableBundle;
import com.android.internal.os.PowerStats;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenPowerStatsLayout extends PowerStatsLayout {
    private static final String EXTRA_DEVICE_BRIGHTNESS_DURATION_POSITIONS = "dbds";
    private static final String EXTRA_DEVICE_BRIGHTNESS_DURATION_POSITIONS_COMPAT = "dbd";
    private static final String EXTRA_DEVICE_DOZE_DURATION_POSITION = "ddd";
    private static final String EXTRA_DEVICE_DOZE_POWER_POSITION = "ddp";
    private static final String EXTRA_DEVICE_SCREEN_COUNT = "dsc";
    private static final String EXTRA_DEVICE_SCREEN_ON_DURATION_POSITION = "dsd";
    private static final String EXTRA_UID_FOREGROUND_DURATION = "uf";
    private int[] mDeviceBrightnessDurationPositions;
    private int mDeviceScreenDozeDurationPosition;
    private int mDeviceScreenDozePowerPosition;
    private int mDeviceScreenOnDurationPosition;
    private int mDisplayCount;
    private int mUidTopActivityTimePosition;

    public ScreenPowerStatsLayout(int energyConsumerCount, int displayCount) {
        addDeviceScreenUsageDurationSection(displayCount);
        addDeviceSectionEnergyConsumers(energyConsumerCount);
        addDeviceSectionUsageDuration();
        addDeviceSectionPowerEstimate();
        addUidTopActivitiyDuration();
        addUidSectionPowerEstimate();
    }

    public ScreenPowerStatsLayout(PowerStats.Descriptor descriptor) {
        super(descriptor);
        PersistableBundle extras = descriptor.extras;
        this.mDisplayCount = extras.getInt(EXTRA_DEVICE_SCREEN_COUNT, 1);
        this.mDeviceScreenOnDurationPosition = extras.getInt(EXTRA_DEVICE_SCREEN_ON_DURATION_POSITION);
        this.mDeviceBrightnessDurationPositions = getIntArray(extras, EXTRA_DEVICE_BRIGHTNESS_DURATION_POSITIONS);
        if (this.mDeviceBrightnessDurationPositions != null) goto L5;
        this.mDeviceBrightnessDurationPositions = extras.getIntArray(EXTRA_DEVICE_BRIGHTNESS_DURATION_POSITIONS_COMPAT);
    L5:
        this.mDeviceScreenDozeDurationPosition = extras.getInt(EXTRA_DEVICE_DOZE_DURATION_POSITION);
        this.mDeviceScreenDozePowerPosition = extras.getInt(EXTRA_DEVICE_DOZE_POWER_POSITION);
        this.mUidTopActivityTimePosition = extras.getInt(EXTRA_UID_FOREGROUND_DURATION);
    }

    @Override // com.android.server.power.stats.format.PowerStatsLayout
    public void toExtras(PersistableBundle extras) {
        super.toExtras(extras);
        extras.putInt(EXTRA_DEVICE_SCREEN_COUNT, this.mDisplayCount);
        extras.putInt(EXTRA_DEVICE_SCREEN_ON_DURATION_POSITION, this.mDeviceScreenOnDurationPosition);
        putIntArray(extras, EXTRA_DEVICE_BRIGHTNESS_DURATION_POSITIONS, this.mDeviceBrightnessDurationPositions);
        extras.putInt(EXTRA_DEVICE_DOZE_DURATION_POSITION, this.mDeviceScreenDozeDurationPosition);
        extras.putInt(EXTRA_DEVICE_DOZE_POWER_POSITION, this.mDeviceScreenDozePowerPosition);
        extras.putInt(EXTRA_UID_FOREGROUND_DURATION, this.mUidTopActivityTimePosition);
    }

    private void addDeviceScreenUsageDurationSection(int displayCount) {
        this.mDisplayCount = displayCount;
        this.mDeviceScreenOnDurationPosition = addDeviceSection(displayCount, "on");
        this.mDeviceBrightnessDurationPositions = new int[5];
        int level = 0;
    L3:
        if (level >= 5) goto L5;
        this.mDeviceBrightnessDurationPositions[level] = addDeviceSection(displayCount, BatteryStats.SCREEN_BRIGHTNESS_NAMES[level]);
        level = level + 1;
        goto L3
    L5:
        this.mDeviceScreenDozeDurationPosition = addDeviceSection(displayCount, "doze");
    }

    @Override // com.android.server.power.stats.format.PowerStatsLayout
    protected void addDeviceSectionPowerEstimate() {
        super.addDeviceSectionPowerEstimate();
        this.mDeviceScreenDozePowerPosition = addDeviceSection(1, "doze-power", 2);
    }

    public int getDisplayCount() {
        return this.mDisplayCount;
    }

    public void setScreenOnDuration(long[] stats, int display, long durationMs) {
        stats[this.mDeviceScreenOnDurationPosition + display] = durationMs;
    }

    public long getScreenOnDuration(long[] stats, int display) {
        return stats[this.mDeviceScreenOnDurationPosition + display];
    }

    public void setBrightnessLevelDuration(long[] stats, int display, int brightnessLevel, long durationMs) {
        stats[this.mDeviceBrightnessDurationPositions[brightnessLevel] + display] = durationMs;
    }

    public long getBrightnessLevelDuration(long[] stats, int display, int brightnessLevel) {
        return stats[this.mDeviceBrightnessDurationPositions[brightnessLevel] + display];
    }

    public void setScreenDozeDuration(long[] stats, int display, long durationMs) {
        stats[this.mDeviceScreenDozeDurationPosition + display] = durationMs;
    }

    public long getScreenDozeDuration(long[] stats, int display) {
        return stats[this.mDeviceScreenDozeDurationPosition + display];
    }

    public void setScreenDozePowerEstimate(long[] stats, double power) {
        stats[this.mDeviceScreenDozePowerPosition] = (long) (1000000.0d * power);
    }

    public double getScreenDozePowerEstimate(long[] stats) {
        return stats[this.mDeviceScreenDozePowerPosition] / 1000000.0d;
    }

    private void addUidTopActivitiyDuration() {
        this.mUidTopActivityTimePosition = addUidSection(1, "top");
    }

    public void setUidTopActivityDuration(long[] stats, long durationMs) {
        stats[this.mUidTopActivityTimePosition] = durationMs;
    }

    public long getUidTopActivityDuration(long[] stats) {
        return stats[this.mUidTopActivityTimePosition];
    }
}
