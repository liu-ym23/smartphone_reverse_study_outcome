package com.android.server.power.stats.format;

import android.os.PersistableBundle;
import android.util.Slog;
import android.util.SparseIntArray;
import com.android.internal.os.PowerStats;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SensorPowerStatsLayout extends PowerStatsLayout {
    private static final String EXTRA_DEVICE_SENSOR_HANDLES = "dshs";
    private static final String EXTRA_DEVICE_SENSOR_HANDLES_COMPAT = "dsh";
    private static final String EXTRA_UID_SENSOR_POSITIONS = "usp";
    private static final String EXTRA_UID_SENSOR_POSITIONS_COMPAT = "usps";
    private static final String TAG = "SensorPowerStatsLayout";
    private final SparseIntArray mSensorPositions;

    public SensorPowerStatsLayout(Map<Integer, String> idToLabelMap) {
        this.mSensorPositions = new SparseIntArray();
        Integer[] keys = new Integer[idToLabelMap.size()];
        idToLabelMap.keySet().toArray(keys);
        Arrays.sort(keys);
        int i = 0;
    L4:
        if (i >= keys.length) goto L6;
        addUidSensorSection(keys[i].intValue(), idToLabelMap.get(keys[i]));
        i = i + 1;
        goto L4
    L6:
        addUidSectionPowerEstimate();
        addDeviceSectionPowerEstimate();
    }

    public SensorPowerStatsLayout(PowerStats.Descriptor descriptor) {
        super(descriptor);
        this.mSensorPositions = new SparseIntArray();
        PersistableBundle extras = descriptor.extras;
        int[] handlers = getIntArray(extras, EXTRA_DEVICE_SENSOR_HANDLES);
        if (handlers != null) goto L5;
        handlers = extras.getIntArray(EXTRA_DEVICE_SENSOR_HANDLES_COMPAT);
    L5:
        int[] uidDurationPositions = getIntArray(extras, EXTRA_UID_SENSOR_POSITIONS);
        if (uidDurationPositions != null) goto L8;
        uidDurationPositions = extras.getIntArray(EXTRA_UID_SENSOR_POSITIONS_COMPAT);
    L8:
        if (handlers == null) goto L14;
        if (uidDurationPositions == null) goto L16;
        int i = 0;
    L12:
        if (i >= handlers.length) goto L17;
        this.mSensorPositions.put(handlers[i], uidDurationPositions[i]);
        i = i + 1;
        goto L12
    L17:
        return;
    L16:
        return;
    }

    @Override // com.android.server.power.stats.format.PowerStatsLayout
    public void toExtras(PersistableBundle extras) {
        super.toExtras(extras);
        int[] handlers = new int[this.mSensorPositions.size()];
        int[] uidDurationPositions = new int[this.mSensorPositions.size()];
        int i = 0;
    L4:
        if (i >= this.mSensorPositions.size()) goto L6;
        handlers[i] = this.mSensorPositions.keyAt(i);
        uidDurationPositions[i] = this.mSensorPositions.valueAt(i);
        i = i + 1;
        goto L4
    L6:
        putIntArray(extras, EXTRA_DEVICE_SENSOR_HANDLES, handlers);
        putIntArray(extras, EXTRA_UID_SENSOR_POSITIONS, uidDurationPositions);
    }

    private void addUidSensorSection(int handle, String label) {
        this.mSensorPositions.put(handle, addUidSection(1, label, 1));
    }

    public int getUidSensorDurationPosition(int handle) {
        return this.mSensorPositions.get(handle, -1);
    }

    public void addUidSensorDuration(long[] stats, int handle, long durationMs) {
        int position = this.mSensorPositions.get(handle, -1);
        if (position != (-1)) goto L6;
        Slog.e(TAG, "Unknown sensor: " + handle);
        return;
    L6:
        stats[position] = stats[position] + durationMs;
    }
}
