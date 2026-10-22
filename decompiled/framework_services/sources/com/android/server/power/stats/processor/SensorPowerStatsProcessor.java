package com.android.server.power.stats.processor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.BatteryStats;
import android.os.PersistableBundle;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.SensorPowerStatsLayout;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
class SensorPowerStatsProcessor extends PowerStatsProcessor {
    private static final String ANDROID_SENSOR_TYPE_PREFIX = "android.sensor.";
    private static final long INITIAL_TIMESTAMP = -1;
    private static final double MILLIS_IN_HOUR = 3600000.0d;
    private static final String SENSOR_EVENT_TAG_PREFIX = "sensor:0x";
    private static final String TAG = "SensorPowerStatsProcessor";
    private PowerStats.Descriptor mDescriptor;
    private boolean mIsInitialized;
    private long mLastUpdateTimestamp;
    private PowerStatsProcessor.PowerEstimationPlan mPlan;
    private PowerStats mPowerStats;
    private SensorManager mSensorManager;
    private final Supplier<SensorManager> mSensorManagerSupplier;
    private final SparseArray<SensorState> mSensorStates;
    private SensorPowerStatsLayout mStatsLayout;
    private long[] mTmpDeviceStatsArray;
    private long[] mTmpUidStatsArray;

    private static class Intermediates {
        public double power;

        /* synthetic */ Intermediates(SensorPowerStatsProcessorIA r1) {
            this();
        }

        private Intermediates() {
        }
    }

    private static class SensorState {
        public int sensorHandle;
        public long startTime;
        public boolean stateOn;
        public int uid;

        /* synthetic */ SensorState(SensorPowerStatsProcessorIA r1) {
            this();
        }

        private SensorState() {
            this.startTime = -1;
        }
    }

    public static /* synthetic */ String $r8$lambda$eEoAms27NfR9dYafFcEqohrO0c0(SensorPowerStatsProcessor r0, List r1, Sensor r2) {
        return r0.lambda$ensureInitialized$0(r1, r2);
    }

    SensorPowerStatsProcessor(Supplier<SensorManager> sensorManagerSupplier) {
        this.mSensorStates = new SparseArray();
        this.mSensorManagerSupplier = sensorManagerSupplier;
    }

    private boolean ensureInitialized() {
        if (this.mIsInitialized == false) goto L5;
        return true;
    L5:
        this.mSensorManager = this.mSensorManagerSupplier.get();
        if (this.mSensorManager != null) goto L9;
        return false;
    L9:
        final List<Sensor> sensorList = this.mSensorManager.getSensorList(-1);
        this.mStatsLayout = new SensorPowerStatsLayout((Map) sensorList.stream().collect(Collectors.toMap(new SensorPowerStatsProcessor$$ExternalSyntheticLambda0(), new SensorPowerStatsProcessor$$ExternalSyntheticLambda1(this, sensorList))));
        PersistableBundle extras = new PersistableBundle();
        this.mStatsLayout.toExtras(extras);
        this.mDescriptor = new PowerStats.Descriptor(9, this.mStatsLayout.getDeviceStatsArrayLength(), null, 0, this.mStatsLayout.getUidStatsArrayLength(), extras);
        this.mPowerStats = new PowerStats(this.mDescriptor);
        this.mTmpUidStatsArray = new long[this.mDescriptor.uidStatsArrayLength];
        this.mTmpDeviceStatsArray = new long[this.mDescriptor.statsArrayLength];
        this.mIsInitialized = true;
        return true;
    }

    private /* synthetic */ String lambda$ensureInitialized$0(List sensorList, Sensor sensor) {
        return makeLabel(sensor, sensorList);
    }

    private String makeLabel(Sensor sensor, List<Sensor> sensorList) {
        int type = sensor.getType();
        String label = sensor.getStringType();
        boolean isSingleton = true;
        int i = sensorList.size() - 1;
    L3:
        if (i < 0) goto L11;
        Sensor s = sensorList.get(i);
        if (s == sensor) goto L10;
        if (s.getType() != type) goto L10;
        isSingleton = false;
    L10:
        i = i - 1;
    L11:
        if (isSingleton == true) goto L18;
        StringBuilder sb = new StringBuilder(label).append('.');
        if (sensor.getId() <= 0) goto L15;
        sb.append(sensor.getId());
    L16:
        label = sb.toString();
        goto L18
    L15:
        sb.append(sensor.getName());
    L18:
        if (label.startsWith(ANDROID_SENSOR_TYPE_PREFIX) == false) goto L21;
        label = label.substring(ANDROID_SENSOR_TYPE_PREFIX.length());
    L21:
        return label.replace(' ', '_');
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void start(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        if (ensureInitialized() == true) goto L5;
        return;
    L5:
        this.mLastUpdateTimestamp = timestampMs;
        flushPowerStats(stats, timestampMs);
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void noteStateChange(PowerComponentAggregatedPowerStats stats, BatteryStats.HistoryItem item) {
        if (this.mIsInitialized == true) goto L6;
        return;
    L6:
        if ((item.eventCode & (-49153)) == 21) goto L8;
        return;
    L8:
        if (item.eventTag != null) goto L10;
        return;
    L10:
        if (item.eventTag.string != null) goto L12;
        return;
    L12:
        if (item.eventTag.string.startsWith(SENSOR_EVENT_TAG_PREFIX) == false) goto L45;
        int sensorHandle = Integer.parseInt(item.eventTag.string, SENSOR_EVENT_TAG_PREFIX.length(), item.eventTag.string.length(), 16);     // Catch: NumberFormatException -> L33
        SensorState sensor = this.mSensorStates.get(sensorHandle);
        if (sensor != null) goto L18;
        sensor = new SensorState(null);
        sensor.sensorHandle = sensorHandle;
        this.mSensorStates.put(sensorHandle, sensor);
    L18:
        int uid = item.eventTag.uid;
        if ((item.states & 8388608) == 0) goto L21;
        boolean sensorOn = true;
    L22:
        if (sensorOn == false) goto L30;
        if (sensor.stateOn == true) goto L27;
        sensor.stateOn = true;
        sensor.uid = uid;
        sensor.startTime = item.time;
        return;
    L27:
        if (sensor.uid == uid) goto L40;
        recordUsageDuration(sensor, item.time);
        sensor.uid = uid;
        return;
    L40:
        return;
    L30:
        if (sensor.stateOn == false) goto L42;
        recordUsageDuration(sensor, item.time);
        sensor.stateOn = false;
        return;
    L42:
        return;
    L21:
        sensorOn = false;
    L34:
        Slog.wtf(TAG, "Bad format of event tag: " + item.eventTag.string);
        return;
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void finish(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        if (this.mIsInitialized == true) goto L5;
        return;
    L5:
        int i = this.mSensorStates.size() - 1;
    L6:
        if (i < 0) goto L11;
        SensorState sensor = this.mSensorStates.valueAt(i);
        if (sensor.stateOn == false) goto L10;
        recordUsageDuration(sensor, timestampMs);
    L10:
        i = i - 1;
        goto L6
    L11:
        flushPowerStats(stats, timestampMs);
        if (this.mPlan != null) goto L14;
        this.mPlan = new PowerStatsProcessor.PowerEstimationPlan(stats.getConfig());
    L14:
        IntArray uids = stats.getActiveUids();
        if (uids.size() == 0) goto L17;
        computeUidPowerEstimates(stats, uids);
        computeDevicePowerEstimates(stats);
    L17:
        this.mPlan.resetIntermediates();
    }

    protected void recordUsageDuration(SensorState sensorState, long time) {
        long durationMs = Math.max(0, time - sensorState.startTime);
        if (durationMs <= 0) goto L8;
        long[] uidStats = (long[]) this.mPowerStats.uidStats.get(sensorState.uid);
        if (uidStats != null) goto L7;
        uidStats = new long[this.mDescriptor.uidStatsArrayLength];
        this.mPowerStats.uidStats.put(sensorState.uid, uidStats);
    L7:
        this.mStatsLayout.addUidSensorDuration(uidStats, sensorState.sensorHandle, durationMs);
    L8:
        sensorState.startTime = time;
    }

    private void flushPowerStats(PowerComponentAggregatedPowerStats stats, long timestamp) {
        PowerStats r0 = this.mPowerStats;
        r0.durationMs = timestamp - this.mLastUpdateTimestamp;
        stats.addProcessedPowerStats(this.mPowerStats, timestamp);
        Arrays.fill(this.mPowerStats.stats, 0);
        this.mPowerStats.uidStats.clear();
        this.mLastUpdateTimestamp = timestamp;
    }

    private void computeUidPowerEstimates(PowerComponentAggregatedPowerStats stats, IntArray uids) {
        SensorPowerStatsProcessor r0 = this;
        List<Sensor> sensorList = r0.mSensorManager.getSensorList(-1);
        int[] uidSensorDurationPositions = new int[sensorList.size()];
        double[] sensorPower = new double[sensorList.size()];
        int i = sensorList.size() - 1;
    L3:
        if (i < 0) goto L5;
        Sensor sensor = sensorList.get(i);
        uidSensorDurationPositions[i] = r0.mStatsLayout.getUidSensorDurationPosition(sensor.getHandle());
        sensorPower[i] = ((double) sensor.getPower()) / MILLIS_IN_HOUR;
        i = i - 1;
        goto L3
    L5:
        int i2 = r0.mPlan.uidStateEstimates.size() - 1;
    L6:
        if (i2 < 0) goto L36;
        PowerStatsProcessor.UidStateEstimate uidStateEstimate = r0.mPlan.uidStateEstimates.get(i2);
        List<PowerStatsProcessor.UidStateProportionalEstimate> proportionalEstimates = uidStateEstimate.proportionalEstimates;
        int j = proportionalEstimates.size() - 1;
    L8:
        if (j < 0) goto L34;
        PowerStatsProcessor.UidStateProportionalEstimate proportionalEstimate = proportionalEstimates.get(j);
        int k = uids.size() - 1;
    L10:
        if (k < 0) goto L33;
        int uid = uids.get(k);
        if (stats.getUidStats(r0.mTmpUidStatsArray, uid, proportionalEstimate.stateValues) == true) goto L14;
        List<Sensor> sensorList2 = sensorList;
    L32:
        k = k - 1;
        r0 = this;
        stats = stats;
        sensorList = sensorList2;
        goto L10
    L14:
        double power = 0.0d;
        int m = 0;
    L15:
        sensorList2 = sensorList;
        if (m >= uidSensorDurationPositions.length) goto L26;
        int position = uidSensorDurationPositions[m];
        int m2 = m;
        if (position == (-1)) goto L24;
        if (r0.mTmpUidStatsArray[position] == 0) goto L24;
        power = power + (sensorPower[m2] * r0.mTmpUidStatsArray[position]);
    L24:
        m = m2 + 1;
        sensorList = sensorList2;
        goto L15
    L26:
        if (power == 0.0d) goto L32;
        r0.mStatsLayout.setUidPowerEstimate(r0.mTmpUidStatsArray, power);
        stats.setUidStats(uid, proportionalEstimate.stateValues, r0.mTmpUidStatsArray);
        Intermediates intermediates = (Intermediates) uidStateEstimate.combinedDeviceStateEstimate.intermediates;
        if (intermediates != null) goto L31;
        intermediates = new Intermediates(null);
        uidStateEstimate.combinedDeviceStateEstimate.intermediates = intermediates;
    L31:
        intermediates.power += power;
        goto L32
    L33:
        j = j - 1;
        r0 = this;
        stats = stats;
        goto L8
    L34:
        i2 = i2 - 1;
        r0 = this;
        goto L6
    }

    private void computeDevicePowerEstimates(PowerComponentAggregatedPowerStats stats) {
        int i = this.mPlan.combinedDeviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L16;
        PowerStatsProcessor.CombinedDeviceStateEstimate estimation = this.mPlan.combinedDeviceStateEstimations.get(i);
        if (estimation.intermediates == null) goto L14;
        double power = ((Intermediates) estimation.intermediates).power;
        if (power == 0.0d) goto L14;
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, estimation.stateValues) == true) goto L13;
        Arrays.fill(this.mTmpDeviceStatsArray, 0);
    L13:
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, power);
        stats.setDeviceStats(estimation.stateValues, this.mTmpDeviceStatsArray);
    L14:
        i = i - 1;
        goto L3
    }
}
