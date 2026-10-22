package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import android.util.SparseBooleanArray;
import com.android.internal.os.BatteryStatsHistory;
import com.android.internal.os.BatteryStatsHistoryIterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class PowerStatsAggregator {
    private static final long UNINITIALIZED = -1;
    private final AggregatedPowerStatsConfig mAggregatedPowerStatsConfig;
    private int mCurrentBatteryState;
    private int mCurrentScreenState;
    private final SparseBooleanArray mEnabledComponents;
    private AggregatedPowerStats mStats;

    public PowerStatsAggregator() {
        this(new AggregatedPowerStatsConfig());
    }

    PowerStatsAggregator(AggregatedPowerStatsConfig aggregatedPowerStatsConfig) {
        this.mEnabledComponents = new SparseBooleanArray(29);
        this.mCurrentBatteryState = 0;
        this.mCurrentScreenState = 1;
        this.mAggregatedPowerStatsConfig = aggregatedPowerStatsConfig;
    }

    AggregatedPowerStatsConfig getConfig() {
        return this.mAggregatedPowerStatsConfig;
    }

    public void setPowerComponentEnabled(int powerComponentId, boolean enabled) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mStats == null) goto L8;
        this.mStats = null;     // Catch: Throwable -> L6
    L8:
        this.mEnabledComponents.put(powerComponentId, enabled);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    public void aggregatePowerStats(BatteryStatsHistory history, long startTimeMs, long endTimeMs, Consumer<AggregatedPowerStats> consumer) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mStats != null) goto L10;
        this.mStats = new AggregatedPowerStats(this.mAggregatedPowerStatsConfig, this.mEnabledComponents);     // Catch: Throwable -> L7
    L10:
        if (startTimeMs <= 0) goto L12;
        long baseTime = startTimeMs;
    L13:
        BatteryStatsHistoryIterator iterator = history.iterate(startTimeMs, endTimeMs);     // Catch: Throwable -> L7
        int lastBatteryLevel = 0;
        int lastBatteryLevel2 = -1;
        long lastTime = 0;
        long lastTime2 = baseTime;
        int lastStates = -1;
        int lastStates2 = 0;
    L205:
        boolean startedSession = iterator.hasNext();     // Catch: Throwable -> L144
        if (startedSession == false) goto L146;
        BatteryStats.HistoryItem item = iterator.next();     // Catch: Throwable -> L144
        if (lastStates2 == 0) goto L199;
        long baseTime2 = lastTime2;
        long lastTime3 = lastTime;
        long r21 = -1;
    L142:
        th = move-exception;
        Throwable r3 = th;
    L159:
        if (iterator == null) goto L213;
        iterator.close();     // Catch: Throwable -> L162
    L214:
        throw r3;     // Catch: Throwable -> L7
    L162:
        th = move-exception;
        r3.addSuppressed(th);     // Catch: Throwable -> L7
        throw r3;     // Catch: Throwable -> L7
    L213:
        throw r3;     // Catch: Throwable -> L7
    L41:
        if (item.cmd != 5) goto L44;
    L45:
        if (this.mStats.addClockUpdate(item.time, item.currentTime) == false) goto L47;
    L48:
        long baseTime3 = baseTime2;
    L184:
        lastTime = item.time;     // Catch: Throwable -> L140
        if (item.cmd == 0) goto L182;
    L63:
        long baseTime4 = baseTime3;
    L192:
    L134:
        th = move-exception;
        r3 = th;
        goto L159
    L65:
        if ((item.states & 524288) == 0) goto L67;
        int batteryState = 1;
    L69:
        if (batteryState != this.mCurrentBatteryState) goto L195;
        int lastStates3 = lastStates;
        int r15 = 0;
    L203:
    L136:
        th = move-exception;
        r3 = th;
        goto L159
    L80:
        if ((item.states & 1048576) == 0) goto L82;
        int screenState = r15;
    L84:
        if (screenState == this.mCurrentScreenState) goto L88;
        this.mStats.setDeviceState(1, screenState, item.time);     // Catch: Throwable -> L74
        this.mCurrentScreenState = screenState;     // Catch: Throwable -> L74
    L88:
        if ((item.states & 1623195648) == lastStates3) goto L91;
    L94:
        this.mStats.noteStateChange(item);     // Catch: Throwable -> L136
        lastStates = item.states & 1623195648;
        lastBatteryLevel2 = item.states2 & 1210057088;
    L98:
        if (item.processStateChange == null) goto L176;
        this.mStats.setUidState(item.processStateChange.uid, 2, item.processStateChange.processState, item.time);     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        r3 = th;
    L106:
        th = move-exception;
        r3 = th;
    L176:
    L130:
        th = move-exception;
        r3 = th;
        goto L159
    L110:
        if (item.powerStats == null) goto L132;
        if (this.mStats.isCompatible(item.powerStats) == false) goto L114;
        lastTime2 = baseTime4;
    L170:
        int lastStates4 = lastStates;
        this.mStats.addPowerStats(item.powerStats, item.time);     // Catch: Throwable -> L126
    L133:
        lastStates = lastStates4;
        lastStates2 = lastStates2;
    L126:
        th = move-exception;
        r3 = th;
    L128:
        th = move-exception;
        r3 = th;
        goto L159
    L114:
        if (lastTime <= baseTime4) goto L116;
        this.mStats.setDuration(lastTime - baseTime4);     // Catch: Throwable -> L104
        this.mStats.finish(lastTime);     // Catch: Throwable -> L104
        consumer.accept(this.mStats);     // Catch: Throwable -> L104
    L116:
        this.mStats.reset();     // Catch: Throwable -> L104
        if (this.mStats.addClockUpdate(item.time, item.currentTime) == false) goto L118;
        lastTime2 = item.time;     // Catch: Throwable -> L104
        lastTime = lastTime2;
        goto L170
    L118:
        lastStates2 = lastStates2;
        long baseTime5 = baseTime4;
    L148:
        iterator.close();     // Catch: Throwable -> L7
        if (lastStates2 != 0) goto L151;
    L156:
        this.mStats.reset();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L151:
        if (endTimeMs == r21) goto L154;
        lastTime = endTimeMs;
    L154:
        if (lastTime <= baseTime5) goto L156;
        this.mStats.setDuration(lastTime - baseTime5);     // Catch: Throwable -> L7
        this.mStats.finish(lastTime);     // Catch: Throwable -> L7
        consumer.accept(this.mStats);     // Catch: Throwable -> L7
        goto L156
    L132:
        lastStates4 = lastStates;
        lastTime2 = baseTime4;
        goto L133
    L91:
        if ((item.states2 & 1210057088) != lastBatteryLevel2) goto L94;
        lastStates = lastStates3;
        goto L98
    L82:
        screenState = 1;
        goto L84
    L195:
        lastStates3 = lastStates;
        r15 = 0;
        this.mStats.setDeviceState(0, batteryState, item.time);     // Catch: Throwable -> L74
        this.mCurrentBatteryState = batteryState;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        r3 = th;
    L76:
        th = move-exception;
        r3 = th;
        goto L159
    L67:
        batteryState = 0;
        goto L69
    L182:
    L61:
        th = move-exception;
        r3 = th;
        goto L159
    L54:
        if (item.batteryLevel == lastBatteryLevel) goto L63;
        AggregatedPowerStats r4 = this.mStats;     // Catch: Throwable -> L61
        byte r5 = item.batteryLevel;     // Catch: Throwable -> L61
        int r14 = item.batteryChargeUah;     // Catch: Throwable -> L61
        baseTime4 = baseTime3;
        long baseTime6 = item.time;     // Catch: Throwable -> L59
        r4.noteBatteryLevel(r5, r14, baseTime6);     // Catch: Throwable -> L59
        lastBatteryLevel = item.batteryLevel;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        r3 = th;
    L138:
        th = move-exception;
        r3 = th;
    L140:
        th = move-exception;
        r3 = th;
        goto L159
    L47:
        r21 = -1;
    L147:
        lastTime = lastTime3;
        baseTime5 = baseTime2;
        goto L148
    L44:
        if (item.cmd != 7) goto L48;
    L199:
        r21 = -1;
        this.mStats.start(item.time);     // Catch: Throwable -> L36
        AggregatedPowerStats r6 = this.mStats;     // Catch: Throwable -> L36
        baseTime2 = lastTime2;
        long baseTime7 = item.time;     // Catch: Throwable -> L34
        lastTime3 = lastTime;
        long lastTime4 = item.currentTime;     // Catch: Throwable -> L30
        if (r6.addClockUpdate(baseTime7, lastTime4) == false) goto L25;
        if (baseTime2 == (-1)) goto L29;
        baseTime3 = baseTime2;
    L33:
        lastStates2 = 1;
        goto L184
    L29:
        baseTime3 = item.time;     // Catch: Throwable -> L30
        goto L33
    L25:
        r21 = -1;
    L30:
        th = move-exception;
        r3 = th;
    L34:
        th = move-exception;
        r3 = th;
    L36:
        th = move-exception;
        r3 = th;
        goto L159
    L146:
        baseTime2 = lastTime2;
        lastTime3 = lastTime;
        r21 = -1;
    L144:
        th = move-exception;
        r3 = th;
        goto L159
    L12:
        baseTime = -1;
        goto L13
    }

    public void reset() {
        monitor-enter(this);
        this.mStats = null;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
