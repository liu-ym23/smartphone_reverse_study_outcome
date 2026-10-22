package com.android.server.power.stats;

import android.app.AlarmManager;
import android.os.ConditionVariable;
import android.os.Handler;
import android.util.IndentingPrintWriter;
import com.android.internal.os.BatteryStatsHistory;
import com.android.internal.os.Clock;
import com.android.internal.os.MonotonicClock;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class PowerStatsScheduler {
    private static final long HOUR_IN_MILLIS = 0;
    private static final long MINUTE_IN_MILLIS = 0;
    private final long mAggregatedPowerStatsSpanDuration;
    private final AlarmScheduler mAlarmScheduler;
    private final BatteryStatsHistory mBatteryStatsHistory;
    private final Clock mClock;
    private final Supplier<Long> mEarliestAvailableBatteryHistoryTimeMs;
    private boolean mEnablePeriodicPowerStatsCollection;
    private final Handler mHandler;
    private long mLastSavedSpanEndMonotonicTime;
    private final MonotonicClock mMonotonicClock;
    private final PowerAttributor mPowerAttributor;
    private final long mPowerStatsAggregationPeriod;
    private final Runnable mPowerStatsCollector;
    private final PowerStatsStore mPowerStatsStore;

    public interface AlarmScheduler {
        void scheduleAlarm(long r1, String r3, AlarmManager.OnAlarmListener r4, Handler r5);
    }

    public static /* synthetic */ void $r8$lambda$A6OydxDj4LKVteNt5ZYU4lToLmU(PowerStatsScheduler r0) {
        r0.scheduleNextPowerStatsAggregation();
    }

    public static /* synthetic */ void $r8$lambda$GEaV9AQjfxC9uJ1Tfs7f2eF4_H0(PowerStatsScheduler r0) {
        r0.aggregateAndStorePowerStats();
    }

    public static /* synthetic */ void $r8$lambda$bBYp7BRsiXHz0vRORJ0fnRsuTms(PowerStatsScheduler r0) {
        r0.lambda$scheduleNextPowerStatsAggregation$0();
    }

    public static /* synthetic */ void $r8$lambda$zdu2Z7OeqOXZT7qd3JiK1VMbnoE(PowerStatsScheduler r0, IndentingPrintWriter r1) {
        r0.lambda$aggregateAndDumpPowerStats$1(r1);
    }

    static {
        MINUTE_IN_MILLIS = TimeUnit.MINUTES.toMillis(1);
        HOUR_IN_MILLIS = TimeUnit.HOURS.toMillis(1);
    }

    public PowerStatsScheduler(Runnable powerStatsCollector, BatteryStatsHistory batteryStatsHistory, PowerAttributor powerAttributor, long aggregatedPowerStatsSpanDuration, long powerStatsAggregationPeriod, PowerStatsStore powerStatsStore, AlarmScheduler alarmScheduler, Clock clock, MonotonicClock monotonicClock, Supplier<Long> earliestAvailableBatteryHistoryTimeMs, Handler handler) {
        this.mBatteryStatsHistory = batteryStatsHistory;
        this.mPowerAttributor = powerAttributor;
        this.mAggregatedPowerStatsSpanDuration = aggregatedPowerStatsSpanDuration;
        this.mPowerStatsAggregationPeriod = powerStatsAggregationPeriod;
        this.mPowerStatsStore = powerStatsStore;
        this.mAlarmScheduler = alarmScheduler;
        this.mClock = clock;
        this.mMonotonicClock = monotonicClock;
        this.mHandler = handler;
        this.mPowerStatsCollector = powerStatsCollector;
        this.mEarliestAvailableBatteryHistoryTimeMs = earliestAvailableBatteryHistoryTimeMs;
    }

    public void start(boolean enablePeriodicPowerStatsCollection) {
        this.mEnablePeriodicPowerStatsCollection = enablePeriodicPowerStatsCollection;
        if (this.mEnablePeriodicPowerStatsCollection == false) goto L6;
        schedulePowerStatsAggregation();
        scheduleNextPowerStatsAggregation();
        return;
    }

    private void scheduleNextPowerStatsAggregation() {
        this.mAlarmScheduler.scheduleAlarm(this.mClock.elapsedRealtime() + this.mPowerStatsAggregationPeriod, "PowerStats", new PowerStatsScheduler$$ExternalSyntheticLambda3(this), this.mHandler);
    }

    private /* synthetic */ void lambda$scheduleNextPowerStatsAggregation$0() {
        schedulePowerStatsAggregation();
        this.mHandler.post(new PowerStatsScheduler$$ExternalSyntheticLambda0(this));
    }

    public void schedulePowerStatsAggregation() {
        this.mPowerStatsCollector.run();
        this.mHandler.post(new PowerStatsScheduler$$ExternalSyntheticLambda1(this));
    }

    private void aggregateAndStorePowerStats() {
        long currentTimeMillis = this.mClock.currentTimeMillis();
        long currentMonotonicTime = this.mMonotonicClock.monotonicTime();
        long startTime = getLastSavedSpanEndMonotonicTime();
        if (startTime >= 0) goto L5;
        long startTime2 = this.mEarliestAvailableBatteryHistoryTimeMs.get().longValue();
    L6:
        long endTimeMs = alignToWallClock(startTime2 + this.mAggregatedPowerStatsSpanDuration, this.mAggregatedPowerStatsSpanDuration, currentMonotonicTime, currentTimeMillis);
        long startTime3 = startTime2;
    L8:
        if (endTimeMs > currentMonotonicTime) goto L10;
        this.mLastSavedSpanEndMonotonicTime = this.mPowerAttributor.storeEstimatedPowerConsumption(this.mBatteryStatsHistory, startTime3, endTimeMs);
        startTime3 = endTimeMs;
        endTimeMs = endTimeMs + this.mAggregatedPowerStatsSpanDuration;
        goto L8
    L10:
        return;
    L5:
        startTime2 = startTime;
        goto L6
    }

    public void aggregateAndDumpPowerStats(PrintWriter pw) {
        if (this.mHandler.getLooper().isCurrentThread() == true) goto L7;
        schedulePowerStatsAggregation();
        awaitCompletion();
        final IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        this.mHandler.post(new PowerStatsScheduler$$ExternalSyntheticLambda2(this, ipw));
        awaitCompletion();
        return;
    L7:
        throw new IllegalStateException("Should not be executed on the bg handler thread.");
    }

    private /* synthetic */ void lambda$aggregateAndDumpPowerStats$1(IndentingPrintWriter ipw) {
        this.mPowerStatsStore.dump(ipw);
        long powerStoreEndMonotonicTime = getLastSavedSpanEndMonotonicTime();
        this.mPowerAttributor.dumpEstimatedPowerConsumption(ipw, this.mBatteryStatsHistory, powerStoreEndMonotonicTime, -1);
    }

    public static long alignToWallClock(long targetMonotonicTime, long interval, long currentMonotonicTime, long currentTimeMillis) {
        long targetWallClockTime = currentTimeMillis + (targetMonotonicTime - currentMonotonicTime);
        if (interval < MINUTE_IN_MILLIS) goto L9;
        if ((TimeUnit.HOURS.toMillis(1) % interval) != 0) goto L9;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis((MINUTE_IN_MILLIS + targetWallClockTime) - 1);
        cal.set(13, 0);
        cal.set(14, 0);
        int intervalInMinutes = (int) (interval / MINUTE_IN_MILLIS);
        cal.set(12, (((cal.get(12) + intervalInMinutes) - 1) / intervalInMinutes) * intervalInMinutes);
        long adjustment = cal.getTimeInMillis() - targetWallClockTime;
        return targetMonotonicTime + adjustment;
    L9:
        if (interval >= HOUR_IN_MILLIS) goto L11;
    L14:
        return targetMonotonicTime;
    L11:
        if ((TimeUnit.DAYS.toMillis(1) % interval) != 0) goto L14;
        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeInMillis((HOUR_IN_MILLIS + targetWallClockTime) - 1);
        cal2.set(12, 0);
        cal2.set(13, 0);
        cal2.set(14, 0);
        int intervalInHours = (int) (interval / HOUR_IN_MILLIS);
        cal2.set(11, (((cal2.get(11) + intervalInHours) - 1) / intervalInHours) * intervalInHours);
        long adjustment2 = cal2.getTimeInMillis() - targetWallClockTime;
        return targetMonotonicTime + adjustment2;
    }

    private long getLastSavedSpanEndMonotonicTime() {
        if (this.mLastSavedSpanEndMonotonicTime != 0) goto L6;
        this.mLastSavedSpanEndMonotonicTime = this.mPowerAttributor.getLastSavedEstimatesPowerConsumptionTimestamp();
    L6:
        return this.mLastSavedSpanEndMonotonicTime;
    }

    private void awaitCompletion() {
        ConditionVariable done = new ConditionVariable();
        this.mHandler.post(new BatteryStatsImpl$$ExternalSyntheticLambda8(done));
        done.block();
    }
}
