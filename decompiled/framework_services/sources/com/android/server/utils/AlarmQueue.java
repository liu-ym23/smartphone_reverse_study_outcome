package com.android.server.utils;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AlarmQueue<K> implements AlarmManager.OnAlarmListener {
    private static final boolean DEBUG = false;
    private static final long NOT_SCHEDULED = -1;
    private static final long SIGNIFICANT_TRIGGER_TIME_CHANGE_THRESHOLD_MS = 60000;
    private static final String TAG = null;
    private final AlarmPriorityQueue<K> mAlarmPriorityQueue;
    private final String mAlarmTag;
    private final Context mContext;
    private final String mDumpTitle;
    private final boolean mExactAlarm;
    private final Handler mHandler;
    private final Injector mInjector;
    private long mLastFireTimeElapsed;
    private final Object mLock;
    private long mMinTimeBetweenAlarmsMs;
    private final Runnable mScheduleAlarmRunnable;
    private long mTriggerTimeElapsed;

    private static class AlarmPriorityQueue<Q> extends PriorityQueue<Pair<Q, Long>> {
        private static final Comparator<Pair<?, Long>> sTimeComparator = null;

        public static /* synthetic */ int $r8$lambda$a9G3NCnbGSjGaU6KBkUKenfyhOo(Pair r0, Pair r1) {
            return lambda$static$0(r0, r1);
        }

        static {
            sTimeComparator = new AlarmQueue$AlarmPriorityQueue$$ExternalSyntheticLambda0();
        }

        private static /* synthetic */ int lambda$static$0(Pair o1, Pair o2) {
            return Long.compare(((Long) o1.second).longValue(), ((Long) o2.second).longValue());
        }

        AlarmPriorityQueue() {
            super(1, sTimeComparator);
        }

        public boolean removeKey(Q key) {
            boolean removed = false;
            Pair[] alarms = (Pair[]) toArray(new Pair[size()]);
            int i = alarms.length - 1;
        L3:
            if (i < 0) goto L9;
            if (key.equals(alarms[i].first) == false) goto L7;
            remove(alarms[i]);
            removed = true;
        L7:
            i = i - 1;
            goto L3
        L9:
            return removed;
        }
    }

    static class Injector {
        Injector() {
        }

        long getElapsedRealtime() {
            return SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$DeDtocjgDWALOI-1DvzM6Os-uU4, reason: not valid java name */
    public static /* synthetic */ void m9216$r8$lambda$DeDtocjgDWALOI1DvzM6OsuU4(AlarmQueue r0) {
        r0.lambda$setNextAlarmLocked$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAlarmTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9217$$Nest$fgetmAlarmTag(AlarmQueue r0) {
        return r0.mAlarmTag;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9218$$Nest$fgetmContext(AlarmQueue r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExactAlarm, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9219$$Nest$fgetmExactAlarm(AlarmQueue r0) {
        return r0.mExactAlarm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9220$$Nest$fgetmHandler(AlarmQueue r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9221$$Nest$fgetmLock(AlarmQueue r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMinTimeBetweenAlarmsMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m9222$$Nest$fgetmMinTimeBetweenAlarmsMs(AlarmQueue r2) {
        return r2.mMinTimeBetweenAlarmsMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTriggerTimeElapsed, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m9223$$Nest$fgetmTriggerTimeElapsed(AlarmQueue r2) {
        return r2.mTriggerTimeElapsed;
    }

    protected abstract boolean isForUser(K r1, int r2);

    protected abstract void processExpiredAlarms(ArraySet<K> r1);

    static {
        TAG = AlarmQueue.class.getSimpleName();
    }

    public AlarmQueue(Context context, Looper looper, String alarmTag, String dumpTitle, boolean exactAlarm, long minTimeBetweenAlarmsMs) {
        this(context, looper, alarmTag, dumpTitle, exactAlarm, minTimeBetweenAlarmsMs, new Injector());
    }

    AlarmQueue(Context context, Looper looper, String alarmTag, String dumpTitle, boolean exactAlarm, long minTimeBetweenAlarmsMs, Injector injector) {
        this.mScheduleAlarmRunnable = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mAlarmPriorityQueue = new AlarmPriorityQueue();
        this.mTriggerTimeElapsed = -1;
        this.mContext = context;
        this.mAlarmTag = alarmTag;
        this.mDumpTitle = dumpTitle.trim();
        this.mExactAlarm = exactAlarm;
        this.mHandler = new Handler(looper);
        this.mInjector = injector;
        if (minTimeBetweenAlarmsMs < 0) goto L7;
        this.mMinTimeBetweenAlarmsMs = minTimeBetweenAlarmsMs;
        return;
    L7:
        throw new IllegalArgumentException("min time between alarms must be non-negative");
    }

    public void addAlarm(K key, long alarmTimeElapsed) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean removed = this.mAlarmPriorityQueue.removeKey(key);     // Catch: Throwable -> L10
        this.mAlarmPriorityQueue.offer(new Pair(key, Long.valueOf(alarmTimeElapsed)));     // Catch: Throwable -> L10
        if (this.mTriggerTimeElapsed == (-1)) goto L12;
        if (removed == true) goto L12;
        if (alarmTimeElapsed < this.mTriggerTimeElapsed) goto L12;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        setNextAlarmLocked();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public long getMinTimeBetweenAlarmsMs() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mMinTimeBetweenAlarmsMs;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAlarmForKey(K key) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAlarmPriorityQueue.removeKey(key) == false) goto L9;
        setNextAlarmLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeAlarmsForUserId(int userId) {
        boolean removed = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        Pair[] alarms = (Pair[]) this.mAlarmPriorityQueue.toArray(new Pair[this.mAlarmPriorityQueue.size()]);     // Catch: Throwable -> L9
        int i = alarms.length - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        if (isForUser(alarms[i].first, userId) == false) goto L11;
        this.mAlarmPriorityQueue.remove(alarms[i]);     // Catch: Throwable -> L9
        removed = true;
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        if (removed == false) goto L15;
        setNextAlarmLocked();     // Catch: Throwable -> L9
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void removeAllAlarms() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAlarmPriorityQueue.clear();     // Catch: Throwable -> L7
        setNextAlarmLocked(0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void removeAlarmsIf(Predicate<K> r8) {
        boolean removed = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        Pair[] alarms = (Pair[]) this.mAlarmPriorityQueue.toArray(new Pair[this.mAlarmPriorityQueue.size()]);     // Catch: Throwable -> L9
        int i = alarms.length - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        if (r8.test(alarms[i].first) == false) goto L11;
        this.mAlarmPriorityQueue.remove(alarms[i]);     // Catch: Throwable -> L9
        removed = true;
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        if (removed == false) goto L15;
        setNextAlarmLocked();     // Catch: Throwable -> L9
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setMinTimeBetweenAlarmsMs(long minTimeMs) {
        if (minTimeMs < 0) goto L13;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMinTimeBetweenAlarmsMs = minTimeMs;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalArgumentException("min time between alarms must be non-negative");
    }

    private void setNextAlarmLocked() {
        setNextAlarmLocked(this.mLastFireTimeElapsed + this.mMinTimeBetweenAlarmsMs);
    }

    private void setNextAlarmLocked(long earliestTriggerElapsed) {
        if (this.mAlarmPriorityQueue.size() != 0) goto L6;
        this.mHandler.post(new AlarmQueue$$ExternalSyntheticLambda0(this));
        this.mTriggerTimeElapsed = -1;
        return;
    L6:
        Pair alarm = this.mAlarmPriorityQueue.peek();
        long nextTriggerTimeElapsed = Math.max(earliestTriggerElapsed, ((Long) alarm.second).longValue());
        long timeShiftThresholdMs = Math.min(60000, this.mMinTimeBetweenAlarmsMs);
        if (this.mTriggerTimeElapsed != (-1)) goto L9;
    L12:
        this.mTriggerTimeElapsed = nextTriggerTimeElapsed;
        this.mHandler.post(this.mScheduleAlarmRunnable);
        return;
    L9:
        if (nextTriggerTimeElapsed < (this.mTriggerTimeElapsed - timeShiftThresholdMs)) goto L12;
        if (this.mTriggerTimeElapsed < nextTriggerTimeElapsed) goto L12;
    }

    private /* synthetic */ void lambda$setNextAlarmLocked$0() {
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        if (alarmManager == null) goto L6;
        alarmManager.cancel(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.AlarmManager.OnAlarmListener
    public void onAlarm() {
        ArraySet r0 = new ArraySet();
        Object r1 = this.mLock;
        monitor-enter(r1);
        long nowElapsed = this.mInjector.getElapsedRealtime();     // Catch: Throwable -> L10
        this.mLastFireTimeElapsed = nowElapsed;     // Catch: Throwable -> L10
    L6:
        if (this.mAlarmPriorityQueue.size() <= 0) goto L12;
        Pair alarm = this.mAlarmPriorityQueue.peek();     // Catch: Throwable -> L10
        if (((Long) alarm.second).longValue() > nowElapsed) goto L12;
        r0.add(alarm.first);     // Catch: Throwable -> L10
        this.mAlarmPriorityQueue.remove(alarm);     // Catch: Throwable -> L10
    L12:
        setNextAlarmLocked(this.mMinTimeBetweenAlarmsMs + nowElapsed);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (r0.size() <= 0) goto L24;
        processExpiredAlarms(r0);
        return;
    L24:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.print(this.mDumpTitle);     // Catch: Throwable -> L7
        pw.println(" alarms:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        if (this.mAlarmPriorityQueue.size() != 0) goto L9;
        pw.println("NOT WAITING");     // Catch: Throwable -> L7
    L13:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Pair[] alarms = (Pair[]) this.mAlarmPriorityQueue.toArray(new Pair[this.mAlarmPriorityQueue.size()]);     // Catch: Throwable -> L7
        int i = 0;
    L11:
        if (i >= alarms.length) goto L13;
        pw.print(alarms[i].first);     // Catch: Throwable -> L7
        pw.print(": ");     // Catch: Throwable -> L7
        pw.print(alarms[i].second);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
