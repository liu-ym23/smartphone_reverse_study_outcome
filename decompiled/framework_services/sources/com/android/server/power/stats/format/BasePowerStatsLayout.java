package com.android.server.power.stats.format;

import android.os.PersistableBundle;
import com.android.internal.os.PowerStats;

/* JADX INFO: loaded from: classes3.dex */
public class BasePowerStatsLayout extends PowerStatsLayout {
    private static final String EXTRA_DEVICE_BATTERY_DISCHARGE = "d-bd";
    private static final String EXTRA_DEVICE_BATTERY_DISCHARGE_DURATION = "d-bdd";
    private static final String EXTRA_DEVICE_BATTERY_DISCHARGE_PCT = "d-bdp";
    private final int mDeviceBatteryDischargeDurationPosition;
    private final int mDeviceBatteryDischargePercentPosition;
    private final int mDeviceBatteryDischargePosition;

    public BasePowerStatsLayout() {
        addDeviceSectionUsageDuration();
        addUidSectionUsageDuration();
        this.mDeviceBatteryDischargePosition = addDeviceSection(1, "discharge");
        this.mDeviceBatteryDischargePercentPosition = addDeviceSection(1, "discharge-pct", 4);
        this.mDeviceBatteryDischargeDurationPosition = addDeviceSection(1, "discharge-duration");
    }

    public BasePowerStatsLayout(PowerStats.Descriptor descriptor) {
        super(descriptor);
        PersistableBundle extras = descriptor.extras;
        this.mDeviceBatteryDischargePosition = extras.getInt(EXTRA_DEVICE_BATTERY_DISCHARGE);
        this.mDeviceBatteryDischargePercentPosition = extras.getInt(EXTRA_DEVICE_BATTERY_DISCHARGE_PCT);
        this.mDeviceBatteryDischargeDurationPosition = extras.getInt(EXTRA_DEVICE_BATTERY_DISCHARGE_DURATION);
    }

    @Override // com.android.server.power.stats.format.PowerStatsLayout
    public void toExtras(PersistableBundle extras) {
        super.toExtras(extras);
        extras.putInt(EXTRA_DEVICE_BATTERY_DISCHARGE, this.mDeviceBatteryDischargePosition);
        extras.putInt(EXTRA_DEVICE_BATTERY_DISCHARGE_PCT, this.mDeviceBatteryDischargePercentPosition);
        extras.putInt(EXTRA_DEVICE_BATTERY_DISCHARGE_DURATION, this.mDeviceBatteryDischargeDurationPosition);
    }

    public void addBatteryDischargeUah(long[] stats, long dischargeUah) {
        int r0 = this.mDeviceBatteryDischargePosition;
        stats[r0] = stats[r0] + dischargeUah;
    }

    public long getBatteryDischargeUah(long[] stats) {
        return stats[this.mDeviceBatteryDischargePosition];
    }

    public void addBatteryDischargePercent(long[] stats, int dischargePct) {
        int r0 = this.mDeviceBatteryDischargePercentPosition;
        stats[r0] = stats[r0] + (((long) dischargePct) * 1000000);
    }

    public double getBatteryDischargePercent(long[] stats) {
        return ((double) ((int) stats[this.mDeviceBatteryDischargePercentPosition])) / 1000000.0d;
    }

    public void addBatteryDischargeDuration(long[] stats, long durationMs) {
        int r0 = this.mDeviceBatteryDischargeDurationPosition;
        stats[r0] = stats[r0] + durationMs;
    }

    public long getBatteryDischargeDuration(long[] stats) {
        return (int) stats[this.mDeviceBatteryDischargeDurationPosition];
    }
}
