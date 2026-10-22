package com.android.server.utils.quota;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.LongArrayQueue;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.usage.UnixCalendar;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class CountQuotaTracker extends QuotaTracker {
    private static final String ALARM_TAG_CLEANUP = null;
    private static final boolean DEBUG = false;
    private static final int MSG_CLEAN_UP_EVENTS = 1;
    private static final String TAG = null;
    private final ArrayMap<Category, Long> mCategoryCountWindowSizesMs;
    private Function<Void, ExecutionStats> mCreateExecutionStats;
    private Function<Void, LongArrayQueue> mCreateLongArrayQueue;
    private final DeleteEventTimesFunctor mDeleteOldEventTimesFunctor;
    private final EarliestEventTimeFunctor mEarliestEventTimeFunctor;
    private final AlarmManager.OnAlarmListener mEventCleanupAlarmListener;
    private final UptcMap<LongArrayQueue> mEventTimes;
    private final UptcMap<ExecutionStats> mExecutionStatsCache;
    private final Handler mHandler;
    private final ArrayMap<Category, Integer> mMaxCategoryCounts;
    private long mMaxPeriodMs;
    private long mNextCleanupTimeElapsed;

    private class CqtHandler extends Handler {
        final /* synthetic */ CountQuotaTracker this$0;

        CqtHandler(CountQuotaTracker r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            switch(msg.what) {
                case 1: goto L7;
                default: goto L8;
            };     // Catch: Throwable -> L10
        L7:
            this.this$0.deleteObsoleteEventsLocked();     // Catch: Throwable -> L10
            this.this$0.maybeScheduleCleanupAlarmLocked();     // Catch: Throwable -> L10
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
        }
    }

    private final class DeleteEventTimesFunctor implements Consumer<LongArrayQueue> {
        private long mMaxPeriodMs;
        final /* synthetic */ CountQuotaTracker this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmMaxPeriodMs, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m9276$$Nest$fgetmMaxPeriodMs(DeleteEventTimesFunctor r2) {
            return r2.mMaxPeriodMs;
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateMaxPeriod, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9277$$Nest$mupdateMaxPeriod(DeleteEventTimesFunctor r0) {
            r0.updateMaxPeriod();
        }

        /* synthetic */ DeleteEventTimesFunctor(CountQuotaTracker r1, CountQuotaTrackerIA r2) {
            this(r1);
        }

        private DeleteEventTimesFunctor(CountQuotaTracker r1) {
            this.this$0 = r1;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(LongArrayQueue r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(LongArrayQueue times) {
            if (times != null) goto L4;
            return;
        L4:
            if (times.size() <= 0) goto L11;
            if (times.peekFirst() > (this.this$0.mInjector.getElapsedRealtime() - this.mMaxPeriodMs)) goto L12;
            times.removeFirst();
            goto L4
        L12:
            return;
        }

        private void updateMaxPeriod() {
            long maxPeriodMs = 0;
            int i = CountQuotaTracker.m9275$$Nest$fgetmCategoryCountWindowSizesMs(this.this$0).size() - 1;
        L3:
            if (i < 0) goto L5;
            maxPeriodMs = Long.max(maxPeriodMs, ((Long) CountQuotaTracker.m9275$$Nest$fgetmCategoryCountWindowSizesMs(this.this$0).valueAt(i)).longValue());
            i = i - 1;
            goto L3
        L5:
            this.mMaxPeriodMs = maxPeriodMs;
        }
    }

    private static final class EarliestEventTimeFunctor implements Consumer<LongArrayQueue> {
        long earliestTimeElapsed;

        /* synthetic */ EarliestEventTimeFunctor(CountQuotaTrackerIA r1) {
            this();
        }

        private EarliestEventTimeFunctor() {
            this.earliestTimeElapsed = Long.MAX_VALUE;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(LongArrayQueue r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(LongArrayQueue events) {
            if (events != null) goto L4;
            return;
        L4:
            if (events.size() <= 0) goto L8;
            this.earliestTimeElapsed = Math.min(this.earliestTimeElapsed, events.get(0));
            return;
        }

        void reset() {
            this.earliestTimeElapsed = Long.MAX_VALUE;
        }
    }

    static class ExecutionStats {
        public int countInWindow;
        public int countLimit;
        public long expirationTimeElapsed;
        public long inQuotaTimeElapsed;
        public long windowSizeMs;

        ExecutionStats() {
        }

        public String toString() {
            return "expirationTime=" + this.expirationTimeElapsed + ", windowSizeMs=" + this.windowSizeMs + ", countLimit=" + this.countLimit + ", countInWindow=" + this.countInWindow + ", inQuotaTime=" + this.inQuotaTimeElapsed;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ExecutionStats) == false) goto L16;
            ExecutionStats other = (ExecutionStats) obj;
            if (this.expirationTimeElapsed == other.expirationTimeElapsed) goto L7;
            return false;
        L7:
            if (this.windowSizeMs == other.windowSizeMs) goto L9;
            return false;
        L9:
            if (this.countLimit == other.countLimit) goto L11;
            return false;
        L11:
            if (this.countInWindow == other.countInWindow) goto L13;
            return false;
        L13:
            if (this.inQuotaTimeElapsed != other.inQuotaTimeElapsed) goto L21;
            return true;
        L21:
            return false;
        L16:
            return false;
        }

        public int hashCode() {
            int result = (0 * 31) + Long.hashCode(this.expirationTimeElapsed);
            return (((((((result * 31) + Long.hashCode(this.windowSizeMs)) * 31) + this.countLimit) * 31) + this.countInWindow) * 31) + Long.hashCode(this.inQuotaTimeElapsed);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$22S4fPERakaIsJJ-YO3wZmGu4eo, reason: not valid java name */
    public static /* synthetic */ void m9273$r8$lambda$22S4fPERakaIsJJYO3wZmGu4eo(CountQuotaTracker r0, ProtoOutputStream r1, int r2, String r3, String r4, ExecutionStats r5) {
        r0.lambda$dump$8(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$360T7gdnVB0V0D04-5D-51fvB5g, reason: not valid java name */
    public static /* synthetic */ void m9274$r8$lambda$360T7gdnVB0V0D045D51fvB5g(IndentingPrintWriter r0, int r1, String r2, String r3, LongArrayQueue r4) {
        lambda$dump$6(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$GWcz4Ik7FTI__gHddSYzxcG8CG8(CountQuotaTracker r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$VOFxslBKkJSf6eCdyl4QrLMLIQA(long r0, ExecutionStats r2) {
        lambda$invalidateAllExecutionStatsLocked$2(r0, r2);
    }

    public static /* synthetic */ ExecutionStats $r8$lambda$bpXgHbASkT73xHBfIQStDjbYyHs(Void r0) {
        return lambda$new$5(r0);
    }

    public static /* synthetic */ LongArrayQueue $r8$lambda$cM9jWlqtuFAt3Et9NwUilONDTpc(Void r0) {
        return lambda$new$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$hkNDg6KgiJQSwxtKIIgXVYX6j30(CountQuotaTracker r0, UptcMap r1, int r2, String r3, String r4, LongArrayQueue r5) {
        r0.lambda$maybeUpdateAllQuotaStatusLocked$1(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$qV8EA3F5sjjjybYSibYkmhiaSGQ(IndentingPrintWriter r0, int r1, String r2, String r3, ExecutionStats r4) {
        lambda$dump$7(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$w9XmmIeUpLYB8ojBSWrwFkd08AU(CountQuotaTracker r0, UptcMap r1, int r2, String r3, boolean[] r4, String r5, LongArrayQueue r6) {
        r0.lambda$maybeUpdateStatusForPkgLocked$3(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCategoryCountWindowSizesMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m9275$$Nest$fgetmCategoryCountWindowSizesMs(CountQuotaTracker r0) {
        return r0.mCategoryCountWindowSizesMs;
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    public /* bridge */ /* synthetic */ boolean isWithinQuota(int r1, String r2, String r3) {
        return super.isWithinQuota(r1, r2, r3);
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    public /* bridge */ /* synthetic */ void registerQuotaChangeListener(QuotaChangeListener r1) {
        super.registerQuotaChangeListener(r1);
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    public /* bridge */ /* synthetic */ void setEnabled(boolean r1) {
        super.setEnabled(r1);
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    public /* bridge */ /* synthetic */ void setQuotaFree(int r1, String r2, boolean r3) {
        super.setQuotaFree(r1, r2, r3);
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    public /* bridge */ /* synthetic */ void setQuotaFree(boolean r1) {
        super.setQuotaFree(r1);
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    public /* bridge */ /* synthetic */ void unregisterQuotaChangeListener(QuotaChangeListener r1) {
        super.unregisterQuotaChangeListener(r1);
    }

    static {
        TAG = CountQuotaTracker.class.getSimpleName();
        ALARM_TAG_CLEANUP = SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER + TAG + ".cleanup*";
    }

    private /* synthetic */ void lambda$new$0() {
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    public CountQuotaTracker(Context context, Categorizer categorizer) {
        this(context, categorizer, new QuotaTracker.Injector());
    }

    CountQuotaTracker(Context context, Categorizer categorizer, QuotaTracker.Injector injector) {
        super(context, categorizer, injector);
        this.mEventTimes = new UptcMap();
        this.mExecutionStatsCache = new UptcMap();
        this.mNextCleanupTimeElapsed = 0;
        this.mEventCleanupAlarmListener = new CountQuotaTracker$$ExternalSyntheticLambda6(this);
        this.mCategoryCountWindowSizesMs = new ArrayMap();
        this.mMaxCategoryCounts = new ArrayMap();
        this.mMaxPeriodMs = 0;
        CountQuotaTrackerIA r1 = null;
        this.mEarliestEventTimeFunctor = new EarliestEventTimeFunctor(r1);
        this.mDeleteOldEventTimesFunctor = new DeleteEventTimesFunctor(this, r1);
        this.mCreateLongArrayQueue = new CountQuotaTracker$$ExternalSyntheticLambda7();
        this.mCreateExecutionStats = new CountQuotaTracker$$ExternalSyntheticLambda8();
        this.mHandler = new CqtHandler(this, context.getMainLooper());
    }

    public boolean noteEvent(int userId, String packageName, String tag) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (isEnabledLocked() == false) goto L29;
        if (isQuotaFreeLocked(userId, packageName) == true) goto L29;
        long nowElapsed = this.mInjector.getElapsedRealtime();     // Catch: Throwable -> L17
        LongArrayQueue times = this.mEventTimes.getOrCreate(userId, packageName, tag, this.mCreateLongArrayQueue);     // Catch: Throwable -> L17
        times.addLast(nowElapsed);     // Catch: Throwable -> L17
        ExecutionStats stats = getExecutionStatsLocked(userId, packageName, tag);     // Catch: Throwable -> L17
        stats.countInWindow++;     // Catch: Throwable -> L17
        stats.expirationTimeElapsed = Math.min(stats.expirationTimeElapsed, stats.windowSizeMs + nowElapsed);     // Catch: Throwable -> L17
        if (stats.countInWindow != stats.countLimit) goto L22;
        long windowEdgeElapsed = nowElapsed - stats.windowSizeMs;     // Catch: Throwable -> L17
    L13:
        if (times.size() <= 0) goto L19;
        if (times.peekFirst() >= windowEdgeElapsed) goto L19;
        times.removeFirst();     // Catch: Throwable -> L17
    L19:
        stats.inQuotaTimeElapsed = times.peekFirst() + stats.windowSizeMs;     // Catch: Throwable -> L17
        postQuotaStatusChanged(userId, packageName, tag);     // Catch: Throwable -> L17
    L26:
        maybeScheduleCleanupAlarmLocked();     // Catch: Throwable -> L17
        boolean r2 = isWithinQuotaLocked(stats);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r2;
    L22:
        if (stats.countLimit <= 9) goto L26;
        if (stats.countInWindow != ((stats.countLimit * 4) / 5)) goto L26;
        Slog.w(TAG, Uptc.string(userId, packageName, tag) + " has reached 80% of it's count limit of " + stats.countLimit);     // Catch: Throwable -> L17
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    }

    public void setCountLimit(Category category, int limit, long timeWindowMs) {
        if (limit < 0) goto L25;
        if (timeWindowMs < 0) goto L25;
        Object r0 = this.mLock;
        monitor-enter(r0);
        Integer oldLimit = this.mMaxCategoryCounts.put(category, Integer.valueOf(limit));     // Catch: Throwable -> L16
        long newWindowSizeMs = Math.max(20000, Math.min(timeWindowMs, UnixCalendar.MONTH_IN_MILLIS));     // Catch: Throwable -> L16
        Long oldWindowSizeMs = this.mCategoryCountWindowSizesMs.put(category, Long.valueOf(newWindowSizeMs));     // Catch: Throwable -> L16
        if (oldLimit == null) goto L18;
        if (oldWindowSizeMs == null) goto L18;
        if (oldLimit.intValue() != limit) goto L18;
        if (oldWindowSizeMs.longValue() != newWindowSizeMs) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L18:
        DeleteEventTimesFunctor.m9277$$Nest$mupdateMaxPeriod(this.mDeleteOldEventTimesFunctor);     // Catch: Throwable -> L16
        this.mMaxPeriodMs = DeleteEventTimesFunctor.m9276$$Nest$fgetmMaxPeriodMs(this.mDeleteOldEventTimesFunctor);     // Catch: Throwable -> L16
        invalidateAllExecutionStatsLocked();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        scheduleQuotaCheck();
        return;
    L16:
        th = move-exception;
        throw th;
    L25:
        throw new IllegalArgumentException("Limit and window size must be nonnegative.");
    }

    public int getLimit(Category category) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Integer limit = this.mMaxCategoryCounts.get(category);     // Catch: Throwable -> L9
        if (limit == null) goto L12;
        int r2 = limit.intValue();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        throw new IllegalArgumentException("Limit for " + category + " not defined");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public long getWindowSizeMs(Category category) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Long limitMs = this.mCategoryCountWindowSizesMs.get(category);     // Catch: Throwable -> L9
        if (limitMs == null) goto L12;
        long r2 = limitMs.longValue();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        throw new IllegalArgumentException("Limit for " + category + " not defined");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    void dropEverythingLocked() {
        this.mExecutionStatsCache.clear();
        this.mEventTimes.clear();
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    Handler getHandler() {
        return this.mHandler;
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    long getInQuotaTimeElapsedLocked(int userId, String packageName, String tag) {
        return getExecutionStatsLocked(userId, packageName, tag).inQuotaTimeElapsed;
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    void handleRemovedAppLocked(int userId, String packageName) {
        if (packageName != null) goto L5;
        Slog.wtf(TAG, "Told app removed but given null package name.");
        return;
    L5:
        this.mEventTimes.delete(userId, packageName);
        this.mExecutionStatsCache.delete(userId, packageName);
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    void handleRemovedUserLocked(int userId) {
        this.mEventTimes.delete(userId);
        this.mExecutionStatsCache.delete(userId);
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    boolean isWithinQuotaLocked(int userId, String packageName, String tag) {
        if (isEnabledLocked() == true) goto L6;
        return true;
    L6:
        if (isQuotaFreeLocked(userId, packageName) == false) goto L9;
        return true;
    L9:
        return isWithinQuotaLocked(getExecutionStatsLocked(userId, packageName, tag));
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    void maybeUpdateAllQuotaStatusLocked() {
        final UptcMap<Boolean> doneMap = new UptcMap();
        this.mEventTimes.forEach(new CountQuotaTracker$$ExternalSyntheticLambda0(this, doneMap));
    }

    private /* synthetic */ void lambda$maybeUpdateAllQuotaStatusLocked$1(UptcMap doneMap, int userId, String packageName, String tag, LongArrayQueue events) {
        if (doneMap.contains(userId, packageName, tag) == true) goto L6;
        maybeUpdateStatusForUptcLocked(userId, packageName, tag);
        doneMap.add(userId, packageName, tag, Boolean.TRUE);
        return;
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    void maybeUpdateQuotaStatus(int userId, String packageName, String tag) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        maybeUpdateStatusForUptcLocked(userId, packageName, tag);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    void onQuotaFreeChangedLocked(boolean isFree) {
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    void onQuotaFreeChangedLocked(int userId, String packageName, boolean isFree) {
        maybeUpdateStatusForPkgLocked(userId, packageName);
    }

    private boolean isWithinQuotaLocked(ExecutionStats stats) {
        return isUnderCountQuotaLocked(stats);
    }

    private boolean isUnderCountQuotaLocked(ExecutionStats stats) {
        if (stats.countInWindow >= stats.countLimit) goto L5;
        return true;
    L5:
        return false;
    }

    ExecutionStats getExecutionStatsLocked(int userId, String packageName, String tag) {
        return getExecutionStatsLocked(userId, packageName, tag, true);
    }

    private ExecutionStats getExecutionStatsLocked(int userId, String packageName, String tag, boolean refreshStatsIfOld) {
        ExecutionStats stats = this.mExecutionStatsCache.getOrCreate(userId, packageName, tag, this.mCreateExecutionStats);
        if (refreshStatsIfOld == false) goto L11;
        Category category = this.mCategorizer.getCategory(userId, packageName, tag);
        long countWindowSizeMs = this.mCategoryCountWindowSizesMs.getOrDefault(category, Long.MAX_VALUE).longValue();
        int countLimit = this.mMaxCategoryCounts.getOrDefault(category, Integer.MAX_VALUE).intValue();
        if (stats.expirationTimeElapsed > this.mInjector.getElapsedRealtime()) goto L7;
    L10:
        stats.windowSizeMs = countWindowSizeMs;
        stats.countLimit = countLimit;
        updateExecutionStatsLocked(userId, packageName, tag, stats);
        goto L11
    L7:
        if (stats.windowSizeMs != countWindowSizeMs) goto L10;
        if (stats.countLimit != countLimit) goto L10;
    L11:
        return stats;
    }

    void updateExecutionStatsLocked(int userId, String packageName, String tag, ExecutionStats stats) {
        stats.countInWindow = 0;
        if (stats.countLimit != 0) goto L5;
        stats.inQuotaTimeElapsed = Long.MAX_VALUE;
    L6:
        long nowElapsed = this.mInjector.getElapsedRealtime();
        stats.expirationTimeElapsed = this.mMaxPeriodMs + nowElapsed;
        LongArrayQueue events = this.mEventTimes.get(userId, packageName, tag);
        if (events != null) goto L9;
        return;
    L9:
        long emptyTimeMs = Long.MAX_VALUE - nowElapsed;
        long eventStartWindowElapsed = nowElapsed - stats.windowSizeMs;
        int i = events.size() - 1;
    L10:
        if (i < 0) goto L20;
        long eventTimeElapsed = events.get(i);
        if (eventTimeElapsed < eventStartWindowElapsed) goto L20;
        stats.countInWindow++;
        long nowElapsed2 = nowElapsed;
        long emptyTimeMs2 = Math.min(emptyTimeMs, eventTimeElapsed - eventStartWindowElapsed);
        if (stats.countInWindow < stats.countLimit) goto L18;
        stats.inQuotaTimeElapsed = Math.max(stats.inQuotaTimeElapsed, stats.windowSizeMs + eventTimeElapsed);
    L18:
        i = i - 1;
        nowElapsed = nowElapsed2;
        events = events;
        emptyTimeMs = emptyTimeMs2;
    L20:
        stats.expirationTimeElapsed = nowElapsed + emptyTimeMs;
        return;
    L5:
        stats.inQuotaTimeElapsed = 0;
        goto L6
    }

    private void invalidateAllExecutionStatsLocked() {
        final long nowElapsed = this.mInjector.getElapsedRealtime();
        this.mExecutionStatsCache.forEach(new CountQuotaTracker$$ExternalSyntheticLambda3(nowElapsed));
    }

    private static /* synthetic */ void lambda$invalidateAllExecutionStatsLocked$2(long nowElapsed, ExecutionStats appStats) {
        if (appStats == null) goto L5;
        appStats.expirationTimeElapsed = nowElapsed;
        return;
    }

    private void invalidateAllExecutionStatsLocked(int userId, String packageName) {
        ArrayMap<String, ExecutionStats> appStats = this.mExecutionStatsCache.get(userId, packageName);
        if (appStats == null) goto L10;
        long nowElapsed = this.mInjector.getElapsedRealtime();
        int numStats = appStats.size();
        int i = 0;
    L5:
        if (i >= numStats) goto L14;
        ExecutionStats stats = appStats.valueAt(i);
        if (stats == null) goto L9;
        stats.expirationTimeElapsed = nowElapsed;
    L9:
        i = i + 1;
        goto L5
    L14:
        return;
    }

    private void invalidateExecutionStatsLocked(int userId, String packageName, String tag) {
        ExecutionStats stats = this.mExecutionStatsCache.get(userId, packageName, tag);
        if (stats == null) goto L6;
        stats.expirationTimeElapsed = this.mInjector.getElapsedRealtime();
        return;
    }

    void maybeScheduleCleanupAlarmLocked() {
        if (this.mNextCleanupTimeElapsed <= this.mInjector.getElapsedRealtime()) goto L5;
        return;
    L5:
        this.mEarliestEventTimeFunctor.reset();
        this.mEventTimes.forEach(this.mEarliestEventTimeFunctor);
        long earliestEndElapsed = this.mEarliestEventTimeFunctor.earliestTimeElapsed;
        if (earliestEndElapsed != Long.MAX_VALUE) goto L8;
        return;
    L8:
        long nextCleanupElapsed = this.mMaxPeriodMs + earliestEndElapsed;
        if ((nextCleanupElapsed - this.mNextCleanupTimeElapsed) > 600000) goto L11;
        long nextCleanupElapsed2 = nextCleanupElapsed + 600000;
    L12:
        this.mNextCleanupTimeElapsed = nextCleanupElapsed2;
        scheduleAlarm(3, nextCleanupElapsed2, ALARM_TAG_CLEANUP, this.mEventCleanupAlarmListener);
        return;
    L11:
        nextCleanupElapsed2 = nextCleanupElapsed;
        goto L12
    }

    private boolean maybeUpdateStatusForPkgLocked(final int userId, final String packageName) {
        final UptcMap<Boolean> done = new UptcMap();
        if (this.mEventTimes.contains(userId, packageName) == true) goto L5;
        return false;
    L5:
        ArrayMap<String, LongArrayQueue> events = this.mEventTimes.get(userId, packageName);
        if (events != null) goto L9;
        Slog.wtf(TAG, "Events map was null even though mEventTimes said it contained " + Uptc.string(userId, packageName, null));
        return false;
    L9:
        final boolean[] changed = {false};
        events.forEach(new CountQuotaTracker$$ExternalSyntheticLambda2(this, done, userId, packageName, changed));
        return changed[0];
    }

    private /* synthetic */ void lambda$maybeUpdateStatusForPkgLocked$3(UptcMap done, int userId, String packageName, boolean[] changed, String tag, LongArrayQueue eventList) {
        if (done.contains(userId, packageName, tag) == true) goto L6;
        changed[0] = changed[0] | maybeUpdateStatusForUptcLocked(userId, packageName, tag);
        done.add(userId, packageName, tag, Boolean.TRUE);
        return;
    }

    private boolean maybeUpdateStatusForUptcLocked(int userId, String packageName, String tag) {
        boolean oldInQuota = isWithinQuotaLocked(getExecutionStatsLocked(userId, packageName, tag, false));
        if (isEnabledLocked() == true) goto L5;
    L8:
        boolean newInQuota = true;
    L9:
        if (newInQuota == true) goto L11;
        maybeScheduleStartAlarmLocked(userId, packageName, tag);
    L12:
        if (oldInQuota == newInQuota) goto L15;
        postQuotaStatusChanged(userId, packageName, tag);
        return true;
    L15:
        return false;
    L11:
        cancelScheduledStartAlarmLocked(userId, packageName, tag);
        goto L12
    L5:
        if (isQuotaFreeLocked(userId, packageName) == true) goto L8;
        newInQuota = isWithinQuotaLocked(getExecutionStatsLocked(userId, packageName, tag, true));
        goto L9
    }

    void deleteObsoleteEventsLocked() {
        this.mEventTimes.forEach(this.mDeleteOldEventTimesFunctor);
    }

    private static /* synthetic */ LongArrayQueue lambda$new$4(Void aVoid) {
        return new LongArrayQueue();
    }

    private static /* synthetic */ ExecutionStats lambda$new$5(Void aVoid) {
        return new ExecutionStats();
    }

    LongArrayQueue getEvents(int userId, String packageName, String tag) {
        return this.mEventTimes.get(userId, packageName, tag);
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    public void dump(final IndentingPrintWriter pw) {
        pw.print(TAG);
        pw.println(":");
        pw.increaseIndent();
        Object r0 = this.mLock;
        monitor-enter(r0);
        super.dump(pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("Instantaneous events:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        this.mEventTimes.forEach(new CountQuotaTracker$$ExternalSyntheticLambda4(pw));     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("Cached execution stats:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        this.mExecutionStatsCache.forEach(new CountQuotaTracker$$ExternalSyntheticLambda5(pw));     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("Limits:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        int numCategories = this.mCategoryCountWindowSizesMs.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= numCategories) goto L9;
        Category category = this.mCategoryCountWindowSizesMs.keyAt(i);     // Catch: Throwable -> L7
        pw.print(category);     // Catch: Throwable -> L7
        pw.print(": ");     // Catch: Throwable -> L7
        pw.print(this.mMaxCategoryCounts.get(category));     // Catch: Throwable -> L7
        pw.print(" events in ");     // Catch: Throwable -> L7
        pw.println(TimeUtils.formatDuration(this.mCategoryCountWindowSizesMs.get(category).longValue()));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        pw.decreaseIndent();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dump$6(IndentingPrintWriter pw, int userId, String pkgName, String tag, LongArrayQueue events) {
        if (events.size() <= 0) goto L11;
        pw.print(Uptc.string(userId, pkgName, tag));
        pw.println(":");
        pw.increaseIndent();
        pw.print(events.get(0));
        int i = 1;
    L6:
        if (i >= events.size()) goto L8;
        pw.print(", ");
        pw.print(events.get(i));
        i = i + 1;
        goto L6
    L8:
        pw.decreaseIndent();
        pw.println();
        return;
    }

    private static /* synthetic */ void lambda$dump$7(IndentingPrintWriter pw, int userId, String pkgName, String tag, ExecutionStats stats) {
        if (stats == null) goto L5;
        pw.print(Uptc.string(userId, pkgName, tag));
        pw.println(":");
        pw.increaseIndent();
        pw.println(stats);
        pw.decreaseIndent();
        return;
    }

    @Override // com.android.server.utils.quota.QuotaTracker
    public void dump(final ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        Object r3 = this.mLock;
        monitor-enter(r3);
        super.dump(proto, 1146756268033L);     // Catch: Throwable -> L9
        int i = 0;
    L7:
        if (i >= this.mCategoryCountWindowSizesMs.size()) goto L11;
        Category category = this.mCategoryCountWindowSizesMs.keyAt(i);     // Catch: Throwable -> L9
        long clToken = proto.start(2246267895810L);     // Catch: Throwable -> L9
        category.dumpDebug(proto, 1146756268033L);     // Catch: Throwable -> L9
        proto.write(1120986464258L, this.mMaxCategoryCounts.get(category).intValue());     // Catch: Throwable -> L9
        proto.write(1112396529667L, this.mCategoryCountWindowSizesMs.get(category).longValue());     // Catch: Throwable -> L9
        proto.end(clToken);     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        this.mExecutionStatsCache.forEach(new CountQuotaTracker$$ExternalSyntheticLambda1(this, proto));     // Catch: Throwable -> L9
        proto.end(token);     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$dump$8(ProtoOutputStream proto, int userId, String pkgName, String tag, ExecutionStats stats) {
        boolean isQuotaFree = isIndividualQuotaFreeLocked(userId, pkgName);
        long r6 = 2246267895811L;
        long usToken = proto.start(2246267895811L);
        new Uptc(userId, pkgName, tag).dumpDebug(proto, 1146756268033L);
        proto.write(1133871366146L, isQuotaFree);
        LongArrayQueue events = this.mEventTimes.get(userId, pkgName, tag);
        if (events == null) goto L7;
        int j = events.size() - 1;
    L5:
        if (j < 0) goto L7;
        long eToken = proto.start(r6);
        proto.write(1112396529665L, events.get(j));
        proto.end(eToken);
        j = j - 1;
        r6 = 2246267895811L;
    L7:
        long statsToken = proto.start(2246267895812L);
        proto.write(1112396529665L, stats.expirationTimeElapsed);
        proto.write(1112396529666L, stats.windowSizeMs);
        proto.write(1120986464259L, stats.countLimit);
        proto.write(1120986464260L, stats.countInWindow);
        proto.write(1112396529669L, stats.inQuotaTimeElapsed);
        proto.end(statsToken);
        proto.end(usToken);
    }
}
