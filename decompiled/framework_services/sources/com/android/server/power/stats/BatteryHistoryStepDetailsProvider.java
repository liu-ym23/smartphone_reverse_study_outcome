package com.android.server.power.stats;

import android.hardware.power.stats.PowerEntity;
import android.hardware.power.stats.State;
import android.hardware.power.stats.StateResidency;
import android.hardware.power.stats.StateResidencyResult;
import android.os.BatteryStats;
import android.power.PowerStatsInternal;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
class BatteryHistoryStepDetailsProvider {
    private static final boolean DEBUG = false;
    private static final int MAX_LOW_POWER_STATS_SIZE = 32768;
    private static final int POWER_STATS_QUERY_TIMEOUT_MILLIS = 2000;
    public static final String TAG = "BatteryHistoryStepDetails";
    private final BatteryStatsImpl mBatteryStats;
    private long mCurStepCpuSystemTimeMs;
    private long mCurStepCpuUserTimeMs;
    private long mCurStepStatIOWaitTimeMs;
    private long mCurStepStatIdleTimeMs;
    private long mCurStepStatIrqTimeMs;
    private long mCurStepStatSoftIrqTimeMs;
    private long mCurStepStatSystemTimeMs;
    private long mCurStepStatUserTimeMs;
    private final BatteryStats.HistoryStepDetails mDetails;
    private final Map<Integer, String> mEntityNames;
    private boolean mHasHistoryStepDetails;
    private long mLastStepCpuSystemTimeMs;
    private long mLastStepCpuUserTimeMs;
    private long mLastStepStatIOWaitTimeMs;
    private long mLastStepStatIdleTimeMs;
    private long mLastStepStatIrqTimeMs;
    private long mLastStepStatSoftIrqTimeMs;
    private long mLastStepStatSystemTimeMs;
    private long mLastStepStatUserTimeMs;
    private PowerStatsInternal mPowerStatsInternal;
    private final Map<Integer, Map<Integer, String>> mStateNames;

    BatteryHistoryStepDetailsProvider(BatteryStatsImpl batteryStats) {
        this.mDetails = new BatteryStats.HistoryStepDetails();
        this.mEntityNames = new HashMap();
        this.mStateNames = new HashMap();
        this.mBatteryStats = batteryStats;
    }

    void onSystemReady() {
        this.mPowerStatsInternal = (PowerStatsInternal) LocalServices.getService(PowerStatsInternal.class);
        if (this.mPowerStatsInternal == null) goto L6;
        populatePowerEntityMaps();
        return;
    }

    void requestUpdate() {
        this.mBatteryStats.mHandler.post(new BatteryHistoryStepDetailsProvider$$ExternalSyntheticLambda0(this));
    }

    void update() {
        this.mHasHistoryStepDetails = false;
        this.mBatteryStats.updateCpuDetails();
        calculateHistoryStepDetails();
        updateStateResidency();
        this.mBatteryStats.getHistory().recordHistoryStepDetails(this.mDetails, this.mBatteryStats.mClock.elapsedRealtime(), this.mBatteryStats.mClock.uptimeMillis());
    }

    private void calculateHistoryStepDetails() {
        if (this.mHasHistoryStepDetails == true) goto L5;
        return;
    L5:
        BatteryStats.HistoryStepDetails r0 = this.mDetails;
        r0.userTime = (int) (this.mCurStepCpuUserTimeMs - this.mLastStepCpuUserTimeMs);
        BatteryStats.HistoryStepDetails r1 = this.mDetails;
        r1.systemTime = (int) (this.mCurStepCpuSystemTimeMs - this.mLastStepCpuSystemTimeMs);
        BatteryStats.HistoryStepDetails r2 = this.mDetails;
        r2.statUserTime = (int) (this.mCurStepStatUserTimeMs - this.mLastStepStatUserTimeMs);
        BatteryStats.HistoryStepDetails r3 = this.mDetails;
        r3.statSystemTime = (int) (this.mCurStepStatSystemTimeMs - this.mLastStepStatSystemTimeMs);
        BatteryStats.HistoryStepDetails r4 = this.mDetails;
        r4.statIOWaitTime = (int) (this.mCurStepStatIOWaitTimeMs - this.mLastStepStatIOWaitTimeMs);
        BatteryStats.HistoryStepDetails r5 = this.mDetails;
        r5.statIrqTime = (int) (this.mCurStepStatIrqTimeMs - this.mLastStepStatIrqTimeMs);
        BatteryStats.HistoryStepDetails r6 = this.mDetails;
        r6.statSoftIrqTime = (int) (this.mCurStepStatSoftIrqTimeMs - this.mLastStepStatSoftIrqTimeMs);
        BatteryStats.HistoryStepDetails r7 = this.mDetails;
        r7.statIdlTime = (int) (this.mCurStepStatIdleTimeMs - this.mLastStepStatIdleTimeMs);
        BatteryStats.HistoryStepDetails r8 = this.mDetails;
        BatteryStats.HistoryStepDetails r9 = this.mDetails;
        this.mDetails.appCpuUid3 = -1;
        r9.appCpuUid2 = -1;
        r8.appCpuUid1 = -1;
        BatteryStats.HistoryStepDetails r10 = this.mDetails;
        BatteryStats.HistoryStepDetails r11 = this.mDetails;
        this.mDetails.appCpuUTime3 = 0;
        r11.appCpuUTime2 = 0;
        r10.appCpuUTime1 = 0;
        BatteryStats.HistoryStepDetails r12 = this.mDetails;
        BatteryStats.HistoryStepDetails r13 = this.mDetails;
        this.mDetails.appCpuSTime3 = 0;
        r13.appCpuSTime2 = 0;
        r12.appCpuSTime1 = 0;
        SparseArray<? extends BatteryStats.Uid> uidStats = this.mBatteryStats.getUidStats();
        int uidCount = uidStats.size();
        int i = 0;
    L6:
        if (i >= uidCount) goto L18;
        BatteryStatsImpl.Uid uid = (BatteryStatsImpl.Uid) uidStats.valueAt(i);
        int totalUTimeMs = (int) (uid.mCurStepUserTimeMs - uid.mLastStepUserTimeMs);
        int totalSTimeMs = (int) (uid.mCurStepSystemTimeMs - uid.mLastStepSystemTimeMs);
        int totalTimeMs = totalUTimeMs + totalSTimeMs;
        uid.mLastStepUserTimeMs = uid.mCurStepUserTimeMs;
        uid.mLastStepSystemTimeMs = uid.mCurStepSystemTimeMs;
        if (totalTimeMs <= (this.mDetails.appCpuUTime3 + this.mDetails.appCpuSTime3)) goto L17;
        if (totalTimeMs > (this.mDetails.appCpuUTime2 + this.mDetails.appCpuSTime2)) goto L13;
        BatteryStats.HistoryStepDetails r14 = this.mDetails;
        r14.appCpuUid3 = uid.mUid;
        this.mDetails.appCpuUTime3 = totalUTimeMs;
        this.mDetails.appCpuSTime3 = totalSTimeMs;
        goto L17
    L13:
        BatteryStats.HistoryStepDetails r15 = this.mDetails;
        r15.appCpuUid3 = this.mDetails.appCpuUid2;
        BatteryStats.HistoryStepDetails r16 = this.mDetails;
        r16.appCpuUTime3 = this.mDetails.appCpuUTime2;
        BatteryStats.HistoryStepDetails r17 = this.mDetails;
        r17.appCpuSTime3 = this.mDetails.appCpuSTime2;
        if (totalTimeMs > (this.mDetails.appCpuUTime1 + this.mDetails.appCpuSTime1)) goto L16;
        BatteryStats.HistoryStepDetails r18 = this.mDetails;
        r18.appCpuUid2 = uid.mUid;
        this.mDetails.appCpuUTime2 = totalUTimeMs;
        this.mDetails.appCpuSTime2 = totalSTimeMs;
        goto L17
    L16:
        BatteryStats.HistoryStepDetails r19 = this.mDetails;
        r19.appCpuUid2 = this.mDetails.appCpuUid1;
        BatteryStats.HistoryStepDetails r20 = this.mDetails;
        r20.appCpuUTime2 = this.mDetails.appCpuUTime1;
        BatteryStats.HistoryStepDetails r21 = this.mDetails;
        r21.appCpuSTime2 = this.mDetails.appCpuSTime1;
        BatteryStats.HistoryStepDetails r22 = this.mDetails;
        r22.appCpuUid1 = uid.mUid;
        this.mDetails.appCpuUTime1 = totalUTimeMs;
        this.mDetails.appCpuSTime1 = totalSTimeMs;
    L17:
        i = i + 1;
        goto L6
    L18:
        this.mLastStepCpuUserTimeMs = this.mCurStepCpuUserTimeMs;
        this.mLastStepCpuSystemTimeMs = this.mCurStepCpuSystemTimeMs;
        this.mLastStepStatUserTimeMs = this.mCurStepStatUserTimeMs;
        this.mLastStepStatSystemTimeMs = this.mCurStepStatSystemTimeMs;
        this.mLastStepStatIOWaitTimeMs = this.mCurStepStatIOWaitTimeMs;
        this.mLastStepStatIrqTimeMs = this.mCurStepStatIrqTimeMs;
        this.mLastStepStatSoftIrqTimeMs = this.mCurStepStatSoftIrqTimeMs;
        this.mLastStepStatIdleTimeMs = this.mCurStepStatIdleTimeMs;
    }

    public void addCpuStats(int totalUTimeMs, int totalSTimeMs, int statUserTimeMs, int statSystemTimeMs, int statIOWaitTimeMs, int statIrqTimeMs, int statSoftIrqTimeMs, int statIdleTimeMs) {
        this.mCurStepCpuUserTimeMs += (long) totalUTimeMs;
        this.mCurStepCpuSystemTimeMs += (long) totalSTimeMs;
        this.mCurStepStatUserTimeMs += (long) statUserTimeMs;
        this.mCurStepStatSystemTimeMs += (long) statSystemTimeMs;
        this.mCurStepStatIOWaitTimeMs += (long) statIOWaitTimeMs;
        this.mCurStepStatIrqTimeMs += (long) statIrqTimeMs;
        this.mCurStepStatSoftIrqTimeMs += (long) statSoftIrqTimeMs;
        this.mCurStepStatIdleTimeMs += (long) statIdleTimeMs;
    }

    public void finishAddingCpuLocked() {
        this.mHasHistoryStepDetails = true;
    }

    public void reset() {
        this.mHasHistoryStepDetails = false;
        this.mCurStepCpuUserTimeMs = 0;
        this.mLastStepCpuUserTimeMs = 0;
        this.mCurStepCpuSystemTimeMs = 0;
        this.mLastStepCpuSystemTimeMs = 0;
        this.mCurStepStatUserTimeMs = 0;
        this.mLastStepStatUserTimeMs = 0;
        this.mCurStepStatSystemTimeMs = 0;
        this.mLastStepStatSystemTimeMs = 0;
        this.mCurStepStatIOWaitTimeMs = 0;
        this.mLastStepStatIOWaitTimeMs = 0;
        this.mCurStepStatIrqTimeMs = 0;
        this.mLastStepStatIrqTimeMs = 0;
        this.mCurStepStatSoftIrqTimeMs = 0;
        this.mLastStepStatSoftIrqTimeMs = 0;
        this.mCurStepStatIdleTimeMs = 0;
        this.mLastStepStatIdleTimeMs = 0;
    }

    private void updateStateResidency() {
        this.mDetails.statSubsystemPowerState = null;
        if (this.mPowerStatsInternal != null) goto L5;
        return;
    L5:
        if (this.mEntityNames.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.mStateNames.isEmpty() == true) goto L39;
        StateResidencyResult[] results = this.mPowerStatsInternal.getStateResidencyAsync(new int[0]).get(ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L28
        if (results != null) goto L12;
        return;
    L12:
        if (results.length == 0) goto L37;
        StringBuilder builder = new StringBuilder("SubsystemPowerState");
        int i = 0;
    L16:
        if (i >= results.length) goto L25;
        StateResidencyResult result = results[i];
        int length = builder.length();
        builder.append(" subsystem_");
        builder.append(i);
        builder.append(" name=");
        builder.append(this.mEntityNames.get(Integer.valueOf(result.id)));
        int j = 0;
    L19:
        if (j >= result.stateResidencyData.length) goto L22;
        StateResidency stateResidency = result.stateResidencyData[j];
        builder.append(" state_");
        builder.append(j);
        builder.append(" name=");
        builder.append(this.mStateNames.get(Integer.valueOf(result.id)).get(Integer.valueOf(stateResidency.id)));
        builder.append(" time=");
        builder.append(stateResidency.totalTimeInStateMs);
        builder.append(" count=");
        builder.append(stateResidency.totalStateEntryCount);
        builder.append(" last entry=");
        builder.append(stateResidency.lastEntryTimestampMs);
        j = j + 1;
        goto L19
    L22:
        if (builder.length() > 32768) goto L23;
        i = i + 1;
        goto L16
    L23:
        Slog.e(TAG, "updateStateResidency: buffer not enough");
        builder.setLength(length);
    L25:
        BatteryStats.HistoryStepDetails r0 = this.mDetails;
        r0.statSubsystemPowerState = builder.toString();
        return;
    L37:
        return;
    L28:
        e = move-exception;
        Slog.e(TAG, "Failed to getStateResidencyAsync", e);
        return;
    }

    private void populatePowerEntityMaps() {
        PowerEntity[] entities = this.mPowerStatsInternal.getPowerEntityInfo();
        if (entities != null) goto L5;
        return;
    L5:
        int r1 = entities.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        PowerEntity entity = entities[r2];
        Map<Integer, String> states = new HashMap();
        int j = 0;
    L9:
        if (j >= entity.states.length) goto L11;
        State state = entity.states[j];
        states.put(Integer.valueOf(state.id), state.name);
        j = j + 1;
        goto L9
    L11:
        this.mEntityNames.put(Integer.valueOf(entity.id), entity.name);
        this.mStateNames.put(Integer.valueOf(entity.id), states);
        r2 = r2 + 1;
        goto L6
    }
}
