package com.android.server.power.stats.format;

import android.os.PersistableBundle;
import android.util.Slog;
import com.android.internal.os.PowerStats;

/* JADX INFO: loaded from: classes3.dex */
public class PowerStatsLayout {
    private static final String EXTRA_DEVICE_DURATION_POSITION = "dd";
    private static final String EXTRA_DEVICE_ENERGY_CONSUMERS_COUNT = "dec";
    private static final String EXTRA_DEVICE_ENERGY_CONSUMERS_POSITION = "de";
    private static final String EXTRA_DEVICE_POWER_POSITION = "dp";
    private static final String EXTRA_UID_DURATION_POSITION = "ud";
    private static final String EXTRA_UID_ENERGY_CONSUMERS_COUNT = "uec";
    private static final String EXTRA_UID_ENERGY_CONSUMERS_POSITION = "ue";
    private static final String EXTRA_UID_POWER_POSITION = "up";
    protected static final int FLAG_FORMAT_AS_POWER = 4;
    protected static final int FLAG_HIDDEN = 2;
    protected static final int FLAG_OPTIONAL = 1;
    protected static final double MILLI_TO_NANO_MULTIPLIER = 1000000.0d;
    private static final String TAG = "PowerStatsLayout";
    public static final int UNSUPPORTED = -1;
    protected int mDeviceDurationPosition;
    private int mDeviceEnergyConsumerCount;
    private int mDeviceEnergyConsumerPosition;
    private final StringBuilder mDeviceFormat;
    private int mDevicePowerEstimatePosition;
    private int mDeviceStatsArrayLength;
    private final StringBuilder mStateFormat;
    private int mStateStatsArrayLength;
    private int mUidDurationPosition;
    private int mUidEnergyConsumerCount;
    private int mUidEnergyConsumerPosition;
    private final StringBuilder mUidFormat;
    private int mUidPowerEstimatePosition;
    private int mUidStatsArrayLength;

    public PowerStatsLayout() {
        this.mDeviceFormat = new StringBuilder();
        this.mStateFormat = new StringBuilder();
        this.mUidFormat = new StringBuilder();
        this.mDeviceDurationPosition = -1;
        this.mDevicePowerEstimatePosition = -1;
        this.mUidDurationPosition = -1;
        this.mUidEnergyConsumerPosition = -1;
        this.mUidPowerEstimatePosition = -1;
    }

    public PowerStatsLayout(PowerStats.Descriptor descriptor) {
        this.mDeviceFormat = new StringBuilder();
        this.mStateFormat = new StringBuilder();
        this.mUidFormat = new StringBuilder();
        this.mDeviceDurationPosition = -1;
        this.mDevicePowerEstimatePosition = -1;
        this.mUidDurationPosition = -1;
        this.mUidEnergyConsumerPosition = -1;
        this.mUidPowerEstimatePosition = -1;
        PersistableBundle extras = descriptor.extras;
        this.mDeviceDurationPosition = extras.getInt(EXTRA_DEVICE_DURATION_POSITION);
        this.mDeviceEnergyConsumerPosition = extras.getInt(EXTRA_DEVICE_ENERGY_CONSUMERS_POSITION);
        this.mDeviceEnergyConsumerCount = extras.getInt(EXTRA_DEVICE_ENERGY_CONSUMERS_COUNT);
        this.mDevicePowerEstimatePosition = extras.getInt(EXTRA_DEVICE_POWER_POSITION);
        this.mUidDurationPosition = extras.getInt(EXTRA_UID_DURATION_POSITION);
        this.mUidEnergyConsumerPosition = extras.getInt(EXTRA_UID_ENERGY_CONSUMERS_POSITION);
        this.mUidEnergyConsumerCount = extras.getInt(EXTRA_UID_ENERGY_CONSUMERS_COUNT);
        this.mUidPowerEstimatePosition = extras.getInt("up");
    }

    public void toExtras(PersistableBundle extras) {
        extras.putInt(EXTRA_DEVICE_DURATION_POSITION, this.mDeviceDurationPosition);
        extras.putInt(EXTRA_DEVICE_ENERGY_CONSUMERS_POSITION, this.mDeviceEnergyConsumerPosition);
        extras.putInt(EXTRA_DEVICE_ENERGY_CONSUMERS_COUNT, this.mDeviceEnergyConsumerCount);
        extras.putInt(EXTRA_DEVICE_POWER_POSITION, this.mDevicePowerEstimatePosition);
        extras.putInt(EXTRA_UID_DURATION_POSITION, this.mUidDurationPosition);
        extras.putInt(EXTRA_UID_ENERGY_CONSUMERS_POSITION, this.mUidEnergyConsumerPosition);
        extras.putInt(EXTRA_UID_ENERGY_CONSUMERS_COUNT, this.mUidEnergyConsumerCount);
        extras.putInt("up", this.mUidPowerEstimatePosition);
        extras.putString("format-device", this.mDeviceFormat.toString());
        extras.putString("format-state", this.mStateFormat.toString());
        extras.putString("format-uid", this.mUidFormat.toString());
    }

    public int getDeviceStatsArrayLength() {
        return this.mDeviceStatsArrayLength;
    }

    public int getStateStatsArrayLength() {
        return this.mStateStatsArrayLength;
    }

    public int getUidStatsArrayLength() {
        return this.mUidStatsArrayLength;
    }

    private void appendFormat(StringBuilder sb, int position, int length, String label, int flags) {
        if ((flags & 2) == 0) goto L6;
        return;
    L6:
        if (sb.isEmpty() == true) goto L8;
        sb.append(' ');
    L8:
        sb.append(label);
        sb.append(':');
        sb.append(position);
        if (length == 1) goto L12;
        sb.append('[');
        sb.append(length);
        sb.append(']');
    L12:
        if ((flags & 4) == 0) goto L15;
        sb.append('p');
    L15:
        if ((flags & 1) == 0) goto L18;
        sb.append('?');
        return;
    }

    protected int addDeviceSection(int length, String label, int flags) {
        int position = this.mDeviceStatsArrayLength;
        this.mDeviceStatsArrayLength += length;
        appendFormat(this.mDeviceFormat, position, length, label, flags);
        return position;
    }

    protected int addDeviceSection(int length, String label) {
        return addDeviceSection(length, label, 0);
    }

    protected int addStateSection(int length, String label, int flags) {
        int position = this.mStateStatsArrayLength;
        this.mStateStatsArrayLength += length;
        appendFormat(this.mStateFormat, position, length, label, flags);
        return position;
    }

    protected int addStateSection(int length, String label) {
        return addStateSection(length, label, 0);
    }

    protected int addUidSection(int length, String label, int flags) {
        int position = this.mUidStatsArrayLength;
        this.mUidStatsArrayLength += length;
        appendFormat(this.mUidFormat, position, length, label, flags);
        return position;
    }

    protected int addUidSection(int length, String label) {
        return addUidSection(length, label, 0);
    }

    protected void addDeviceSectionUsageDuration() {
        this.mDeviceDurationPosition = addDeviceSection(1, "usage", 1);
    }

    public void setUsageDuration(long[] stats, long value) {
        stats[this.mDeviceDurationPosition] = value;
    }

    public long getUsageDuration(long[] stats) {
        if (this.mDeviceDurationPosition != (-1)) goto L7;
        return 0;
    L7:
        return stats[this.mDeviceDurationPosition];
    }

    protected void addDeviceSectionEnergyConsumers(int energyConsumerCount) {
        this.mDeviceEnergyConsumerPosition = addDeviceSection(energyConsumerCount, "energy", 1);
        this.mDeviceEnergyConsumerCount = energyConsumerCount;
    }

    public int getEnergyConsumerCount() {
        return this.mDeviceEnergyConsumerCount;
    }

    public void setConsumedEnergy(long[] stats, int index, long energy) {
        stats[this.mDeviceEnergyConsumerPosition + index] = energy;
    }

    public long getConsumedEnergy(long[] stats, int index) {
        return stats[this.mDeviceEnergyConsumerPosition + index];
    }

    protected void addDeviceSectionPowerEstimate() {
        this.mDevicePowerEstimatePosition = addDeviceSection(1, "power", 5);
    }

    public void setDevicePowerEstimate(long[] stats, double power) {
        stats[this.mDevicePowerEstimatePosition] = (long) (MILLI_TO_NANO_MULTIPLIER * power);
    }

    public double getDevicePowerEstimate(long[] stats) {
        if (this.mDevicePowerEstimatePosition != (-1)) goto L7;
        return 0.0d;
    L7:
        return stats[this.mDevicePowerEstimatePosition] / MILLI_TO_NANO_MULTIPLIER;
    }

    protected void addUidSectionUsageDuration() {
        this.mUidDurationPosition = addUidSection(1, "time");
    }

    protected void addUidSectionPowerEstimate() {
        this.mUidPowerEstimatePosition = addUidSection(1, "power", 5);
    }

    public boolean isUidPowerAttributionSupported() {
        if (this.mUidPowerEstimatePosition == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.mUidDurationPosition != (-1)) goto L8;
        return false;
    }

    public void setUidUsageDuration(long[] stats, long durationMs) {
        stats[this.mUidDurationPosition] = durationMs;
    }

    public long getUidUsageDuration(long[] stats) {
        if (this.mUidDurationPosition != (-1)) goto L7;
        return 0;
    L7:
        return stats[this.mUidDurationPosition];
    }

    protected void addUidSectionEnergyConsumers(int energyConsumerCount) {
        this.mUidEnergyConsumerPosition = addUidSection(energyConsumerCount, "energy", 1);
        this.mUidEnergyConsumerCount = energyConsumerCount;
    }

    public int getUidEnergyConsumerCount() {
        return this.mUidEnergyConsumerCount;
    }

    public void setUidConsumedEnergy(long[] stats, int index, long energy) {
        stats[this.mUidEnergyConsumerPosition + index] = energy;
    }

    public long getUidConsumedEnergy(long[] stats, int index) {
        return stats[this.mUidEnergyConsumerPosition + index];
    }

    public void setUidPowerEstimate(long[] stats, double power) {
        stats[this.mUidPowerEstimatePosition] = (long) (MILLI_TO_NANO_MULTIPLIER * power);
    }

    public double getUidPowerEstimate(long[] stats) {
        if (this.mUidPowerEstimatePosition != (-1)) goto L7;
        return 0.0d;
    L7:
        return stats[this.mUidPowerEstimatePosition] / MILLI_TO_NANO_MULTIPLIER;
    }

    protected void putIntArray(PersistableBundle extras, String key, int[] array) {
        if (array != null) goto L4;
        return;
    L4:
        StringBuilder sb = new StringBuilder();
        int r1 = array.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        int value = array[r2];
        if (sb.isEmpty() == true) goto L9;
        sb.append(',');
    L9:
        sb.append(value);
        r2 = r2 + 1;
        goto L5
    L10:
        extras.putString(key, sb.toString());
    }

    protected int[] getIntArray(PersistableBundle extras, String key) {
        String string = extras.getString(key);
        if (string != null) goto L5;
        return null;
    L5:
        String[] values = string.trim().split(",");
        int[] result = new int[values.length];
        int i = 0;
    L7:
        if (i >= values.length) goto L14;
        result[i] = Integer.parseInt(values[i]);     // Catch: NumberFormatException -> L10
        i = i + 1;
    L11:
        Slog.wtf(TAG, "Invalid CSV format: " + string);
        return null;
    L14:
        return result;
    }
}
