package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import android.os.PersistableBundle;
import android.util.IntArray;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.UsageBasedPowerEstimator;
import com.android.server.power.stats.format.BinaryStatePowerStatsLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class BinaryStatePowerStatsProcessor extends PowerStatsProcessor {
    static final int STATE_OFF = 0;
    static final int STATE_ON = 1;
    private PowerStats.Descriptor mDescriptor;
    private boolean mEnergyConsumerSupported;
    private int mInitiatingUid;
    private int mLastState;
    private long mLastStateTimestamp;
    private long mLastUpdateTimestamp;
    private PowerStatsProcessor.PowerEstimationPlan mPlan;
    private final int mPowerComponentId;
    private PowerStats mPowerStats;
    private final BinaryStatePowerStatsLayout mStatsLayout;
    private long[] mTmpDeviceStatsArray;
    private long[] mTmpUidStatsArray;
    private final UsageBasedPowerEstimator mUsageBasedPowerEstimator;

    @Retention(RetentionPolicy.SOURCE)
    protected @interface BinaryState {
    }

    private static class Intermediates {
        public long duration;
        public double power;

        /* synthetic */ Intermediates(BinaryStatePowerStatsProcessorIA r1) {
            this();
        }

        private Intermediates() {
        }
    }

    protected abstract int getBinaryState(BatteryStats.HistoryItem r1);

    BinaryStatePowerStatsProcessor(int powerComponentId, double averagePowerMilliAmp) {
        this(powerComponentId, averagePowerMilliAmp, new BinaryStatePowerStatsLayout());
    }

    BinaryStatePowerStatsProcessor(int powerComponentId, double averagePowerMilliAmp, BinaryStatePowerStatsLayout statsLayout) {
        this.mInitiatingUid = -1;
        this.mLastState = 0;
        this.mPowerComponentId = powerComponentId;
        this.mUsageBasedPowerEstimator = new UsageBasedPowerEstimator(averagePowerMilliAmp);
        this.mStatsLayout = statsLayout;
    }

    private void ensureInitialized() {
        if (this.mDescriptor == null) goto L5;
        return;
    L5:
        PersistableBundle extras = new PersistableBundle();
        this.mStatsLayout.toExtras(extras);
        this.mDescriptor = new PowerStats.Descriptor(this.mPowerComponentId, this.mStatsLayout.getDeviceStatsArrayLength(), null, 0, this.mStatsLayout.getUidStatsArrayLength(), extras);
        this.mPowerStats = new PowerStats(this.mDescriptor);
        PowerStats r0 = this.mPowerStats;
        r0.stats = new long[this.mDescriptor.statsArrayLength];
        this.mTmpDeviceStatsArray = new long[this.mDescriptor.statsArrayLength];
        this.mTmpUidStatsArray = new long[this.mDescriptor.uidStatsArrayLength];
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void start(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        ensureInitialized();
        this.mLastState = 0;
        this.mLastStateTimestamp = timestampMs;
        this.mInitiatingUid = -1;
        flushPowerStats(stats, this.mLastStateTimestamp);
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void noteStateChange(PowerComponentAggregatedPowerStats stats, BatteryStats.HistoryItem item) {
        int state = getBinaryState(item);
        if (state != this.mLastState) goto L6;
        return;
    L6:
        if (state != 1) goto L11;
        if (item.eventCode != 32789) goto L18;
        this.mInitiatingUid = item.eventTag.uid;
    L18:
        this.mLastStateTimestamp = item.time;
        this.mLastState = state;
        return;
    L11:
        if (this.mInitiatingUid == (-1)) goto L13;
    L15:
        recordUsageDuration(this.mPowerStats, this.mInitiatingUid, item.time);
        this.mInitiatingUid = -1;
        if (this.mEnergyConsumerSupported == true) goto L18;
        flushPowerStats(stats, item.time);
        goto L18
    L13:
        if (item.eventCode != 16405) goto L15;
        this.mInitiatingUid = item.eventTag.uid;
        goto L15
    }

    protected void recordUsageDuration(PowerStats powerStats, int uid, long time) {
        long durationMs = time - this.mLastStateTimestamp;
        this.mStatsLayout.setUsageDuration(this.mPowerStats.stats, this.mStatsLayout.getUsageDuration(this.mPowerStats.stats) + durationMs);
        if (uid != (-1)) goto L5;
    L8:
        this.mLastStateTimestamp = time;
        return;
    L5:
        if (((long[]) this.mPowerStats.uidStats.get(uid)) != null) goto L7;
        long[] uidStats = new long[this.mDescriptor.uidStatsArrayLength];
        this.mPowerStats.uidStats.put(uid, uidStats);
        this.mStatsLayout.setUidUsageDuration(uidStats, durationMs);
        goto L8
    L7:
        this.mStatsLayout.setUsageDuration(this.mPowerStats.stats, this.mStatsLayout.getUsageDuration(this.mPowerStats.stats) + durationMs);
        goto L8
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void addPowerStats(PowerComponentAggregatedPowerStats stats, PowerStats powerStats, long timestampMs) {
        ensureInitialized();
        if (this.mLastState != 1) goto L5;
        recordUsageDuration(this.mPowerStats, this.mInitiatingUid, timestampMs);
    L5:
        long consumedEnergy = this.mStatsLayout.getConsumedEnergy(powerStats.stats, 0);
        if (consumedEnergy == (-1)) goto L8;
        this.mEnergyConsumerSupported = true;
        this.mStatsLayout.setConsumedEnergy(this.mPowerStats.stats, 0, consumedEnergy);
    L8:
        flushPowerStats(stats, timestampMs);
    }

    private void flushPowerStats(PowerComponentAggregatedPowerStats stats, long timestamp) {
        PowerStats r0 = this.mPowerStats;
        r0.durationMs = timestamp - this.mLastUpdateTimestamp;
        stats.addProcessedPowerStats(this.mPowerStats, timestamp);
        Arrays.fill(this.mPowerStats.stats, 0);
        this.mPowerStats.uidStats.clear();
        this.mLastUpdateTimestamp = timestamp;
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void finish(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        if (this.mLastState != 1) goto L5;
        recordUsageDuration(this.mPowerStats, this.mInitiatingUid, timestampMs);
    L5:
        flushPowerStats(stats, timestampMs);
        if (this.mPlan != null) goto L8;
        this.mPlan = new PowerStatsProcessor.PowerEstimationPlan(stats.getConfig());
    L8:
        computeDevicePowerEstimates(stats, this.mPlan, this.mEnergyConsumerSupported);
        IntArray uids = stats.getActiveUids();
        if (uids.size() == 0) goto L12;
        combineDevicePowerEstimates(stats);
        computeUidActivityTotals(stats, uids);
        computeUidPowerEstimates(stats, uids);
        return;
    }

    protected void computeDevicePowerEstimates(PowerComponentAggregatedPowerStats stats, PowerStatsProcessor.PowerEstimationPlan plan, boolean energyConsumerSupported) {
        int i = plan.deviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L15;
        PowerStatsProcessor.DeviceStateEstimation estimation = plan.deviceStateEstimations.get(i);
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, estimation.stateValues) == false) goto L13;
        long duration = this.mStatsLayout.getUsageDuration(this.mTmpDeviceStatsArray);
        if (duration <= 0) goto L13;
        if (energyConsumerSupported == false) goto L11;
        double power = PowerStatsProcessor.uCtoMah(this.mStatsLayout.getConsumedEnergy(this.mTmpDeviceStatsArray, 0));
    L12:
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, power);
        stats.setDeviceStats(estimation.stateValues, this.mTmpDeviceStatsArray);
        goto L13
    L11:
        power = this.mUsageBasedPowerEstimator.calculatePower(duration);
    L13:
        i = i - 1;
        goto L3
    }

    private void combineDevicePowerEstimates(PowerComponentAggregatedPowerStats stats) {
        int i = this.mPlan.combinedDeviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L13;
        PowerStatsProcessor.CombinedDeviceStateEstimate estimation = this.mPlan.combinedDeviceStateEstimations.get(i);
        Intermediates intermediates = new Intermediates(null);
        estimation.intermediates = intermediates;
        int j = estimation.deviceStateEstimations.size() - 1;
    L5:
        if (j < 0) goto L11;
        PowerStatsProcessor.DeviceStateEstimation deviceStateEstimation = estimation.deviceStateEstimations.get(j);
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, deviceStateEstimation.stateValues) == false) goto L10;
        intermediates.power += this.mStatsLayout.getDevicePowerEstimate(this.mTmpDeviceStatsArray);
    L10:
        j = j - 1;
        goto L5
    L11:
        i = i - 1;
        goto L3
    }

    private void computeUidActivityTotals(PowerComponentAggregatedPowerStats stats, IntArray uids) {
        int i = this.mPlan.uidStateEstimates.size() - 1;
    L3:
        if (i < 0) goto L16;
        PowerStatsProcessor.UidStateEstimate uidStateEstimate = this.mPlan.uidStateEstimates.get(i);
        Intermediates intermediates = (Intermediates) uidStateEstimate.combinedDeviceStateEstimate.intermediates;
        int j = uids.size() - 1;
    L5:
        if (j < 0) goto L14;
        int uid = uids.get(j);
        Iterator<PowerStatsProcessor.UidStateProportionalEstimate> r5 = uidStateEstimate.proportionalEstimates.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        PowerStatsProcessor.UidStateProportionalEstimate proportionalEstimate = r5.next();
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, proportionalEstimate.stateValues) == false) goto L8;
        intermediates.duration += this.mStatsLayout.getUidUsageDuration(this.mTmpUidStatsArray);
        goto L8
    L13:
        j = j - 1;
        goto L5
    L14:
        i = i - 1;
        goto L3
    }

    private void computeUidPowerEstimates(PowerComponentAggregatedPowerStats stats, IntArray uids) {
        int i = this.mPlan.uidStateEstimates.size() - 1;
    L3:
        if (i < 0) goto L23;
        PowerStatsProcessor.UidStateEstimate uidStateEstimate = this.mPlan.uidStateEstimates.get(i);
        Intermediates intermediates = (Intermediates) uidStateEstimate.combinedDeviceStateEstimate.intermediates;
        long r7 = 0;
        if (intermediates.duration != 0) goto L7;
        int i2 = i;
    L21:
        i = i2 - 1;
        goto L3
    L7:
        List<PowerStatsProcessor.UidStateProportionalEstimate> proportionalEstimates = uidStateEstimate.proportionalEstimates;
        int j = proportionalEstimates.size() - 1;
    L8:
        if (j < 0) goto L20;
        PowerStatsProcessor.UidStateProportionalEstimate proportionalEstimate = proportionalEstimates.get(j);
        int k = uids.size() - 1;
    L10:
        if (k < 0) goto L19;
        int uid = uids.get(k);
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, proportionalEstimate.stateValues) == false) goto L18;
        long duration = this.mStatsLayout.getUidUsageDuration(this.mTmpUidStatsArray);
        if (duration == r7) goto L18;
        double power = (intermediates.power * duration) / intermediates.duration;
        this.mStatsLayout.setUidPowerEstimate(this.mTmpUidStatsArray, power);
        stats.setUidStats(uid, proportionalEstimate.stateValues, this.mTmpUidStatsArray);
    L18:
        k = k - 1;
        i = i;
        uidStateEstimate = uidStateEstimate;
        r7 = 0;
        goto L10
    L19:
        j = j - 1;
        r7 = 0;
        goto L8
    L20:
        i2 = i;
        goto L21
    }
}
