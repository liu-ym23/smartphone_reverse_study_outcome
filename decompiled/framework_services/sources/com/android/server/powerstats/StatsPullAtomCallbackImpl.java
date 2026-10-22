package com.android.server.powerstats;

import android.app.StatsManager;
import android.content.Context;
import android.hardware.power.stats.Channel;
import android.hardware.power.stats.EnergyMeasurement;
import android.hardware.power.stats.PowerEntity;
import android.hardware.power.stats.State;
import android.hardware.power.stats.StateResidency;
import android.hardware.power.stats.StateResidencyResult;
import android.power.PowerStatsInternal;
import android.util.Slog;
import android.util.StatsEvent;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.ISmtResourceControl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class StatsPullAtomCallbackImpl implements StatsManager.StatsPullAtomCallback {
    private static final boolean DEBUG = false;
    private static final int STATS_PULL_TIMEOUT_MILLIS = 2000;
    private static final String TAG = null;
    private Map<Integer, Channel> mChannels;
    private Context mContext;
    private Map<Integer, String> mEntityNames;
    private PowerStatsInternal mPowerStatsInternal;
    private Map<Integer, Map<Integer, String>> mStateNames;

    static {
        TAG = StatsPullAtomCallbackImpl.class.getSimpleName();
    }

    public int onPullAtom(int atomTag, List<StatsEvent> data) {
        switch(atomTag) {
            case 10005: goto L8;
            case 10038: goto L6;
            default: goto L4;
        };
    L4:
        throw new UnsupportedOperationException("Unknown tagId=" + atomTag);
    L6:
        return pullOnDevicePowerMeasurement(atomTag, data);
    L8:
        return pullSubsystemSleepState(atomTag, data);
    }

    private boolean initPullOnDevicePowerMeasurement() {
        Channel[] channels = this.mPowerStatsInternal.getEnergyMeterInfo();
        if (channels != null) goto L5;
    L13:
        Slog.e(TAG, "Failed to init OnDevicePowerMeasurement puller");
        return false;
    L5:
        if (channels.length == 0) goto L13;
        int i = 0;
    L9:
        if (i >= channels.length) goto L11;
        Channel channel = channels[i];
        this.mChannels.put(Integer.valueOf(channel.id), channel);
        i = i + 1;
        goto L9
    L11:
        return true;
    }

    private int pullOnDevicePowerMeasurement(int atomTag, List<StatsEvent> events) {
        EnergyMeasurement[] energyMeasurements = this.mPowerStatsInternal.readEnergyMeterAsync(new int[0]).get(ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L16
        if (energyMeasurements != null) goto L6;
        return 1;
    L6:
        int i = 0;
    L8:
        if (i >= energyMeasurements.length) goto L15;
        EnergyMeasurement energyMeasurement = energyMeasurements[i];
        if (energyMeasurement.durationMs != energyMeasurement.timestampMs) goto L12;
        int atomTag2 = atomTag;
        events.add(FrameworkStatsLog.buildStatsEvent(atomTag2, this.mChannels.get(Integer.valueOf(energyMeasurement.id)).subsystem, this.mChannels.get(Integer.valueOf(energyMeasurement.id)).name, energyMeasurement.durationMs, energyMeasurement.energyUWs));
    L13:
        i = i + 1;
        atomTag = atomTag2;
        goto L8
    L12:
        atomTag2 = atomTag;
        goto L13
    L15:
        return 0;
    L16:
        e = move-exception;
        Slog.e(TAG, "Failed to readEnergyMeterAsync", e);
        return 1;
    }

    private boolean initSubsystemSleepState() {
        PowerEntity[] entities = this.mPowerStatsInternal.getPowerEntityInfo();
        if (entities != null) goto L5;
    L17:
        Slog.e(TAG, "Failed to init SubsystemSleepState puller");
        return false;
    L5:
        if (entities.length == 0) goto L17;
        int i = 0;
    L9:
        if (i >= entities.length) goto L15;
        PowerEntity entity = entities[i];
        Map<Integer, String> states = new HashMap();
        int j = 0;
    L12:
        if (j >= entity.states.length) goto L14;
        State state = entity.states[j];
        states.put(Integer.valueOf(state.id), state.name);
        j = j + 1;
        goto L12
    L14:
        this.mEntityNames.put(Integer.valueOf(entity.id), entity.name);
        this.mStateNames.put(Integer.valueOf(entity.id), states);
        i = i + 1;
        goto L9
    L15:
        return true;
    }

    private int pullSubsystemSleepState(int atomTag, List<StatsEvent> events) {
        StateResidencyResult[] results = this.mPowerStatsInternal.getStateResidencyAsync(new int[0]).get(ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L16
        if (results != null) goto L6;
        return 1;
    L6:
        int i = 0;
    L8:
        if (i >= results.length) goto L15;
        StateResidencyResult result = results[i];
        int j = 0;
    L11:
        if (j >= result.stateResidencyData.length) goto L13;
        StateResidency stateResidency = result.stateResidencyData[j];
        events.add(FrameworkStatsLog.buildStatsEvent(atomTag, this.mEntityNames.get(Integer.valueOf(result.id)), this.mStateNames.get(Integer.valueOf(result.id)).get(Integer.valueOf(stateResidency.id)), stateResidency.totalStateEntryCount, stateResidency.totalTimeInStateMs));
        j = j + 1;
        goto L11
    L13:
        i = i + 1;
        goto L8
    L15:
        return 0;
    L16:
        e = move-exception;
        Slog.e(TAG, "Failed to getStateResidencyAsync", e);
        return 1;
    }

    public StatsPullAtomCallbackImpl(Context context, PowerStatsInternal powerStatsInternal) {
        this.mChannels = new HashMap();
        this.mEntityNames = new HashMap();
        this.mStateNames = new HashMap();
        this.mContext = context;
        this.mPowerStatsInternal = powerStatsInternal;
        if (powerStatsInternal != null) goto L6;
        Slog.e(TAG, "Failed to start PowerStatsService statsd pullers");
        return;
    L6:
        StatsManager manager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        if (initPullOnDevicePowerMeasurement() == false) goto L10;
        manager.setPullAtomCallback(FrameworkStatsLog.ON_DEVICE_POWER_MEASUREMENT, null, ConcurrentUtils.DIRECT_EXECUTOR, this);
    L10:
        if (initSubsystemSleepState() == false) goto L13;
        manager.setPullAtomCallback(10005, null, ConcurrentUtils.DIRECT_EXECUTOR, this);
        return;
    }
}
