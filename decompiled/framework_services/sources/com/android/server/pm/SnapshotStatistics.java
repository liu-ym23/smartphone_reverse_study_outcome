package com.android.server.pm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.EventLogTags;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class SnapshotStatistics {
    private static final int REBUILD_LATENCY_BUCKET_LESS_THAN_100_MILLIS = 100;
    private static final int REBUILD_LATENCY_BUCKET_LESS_THAN_10_MILLIS = 10;
    private static final int REBUILD_LATENCY_BUCKET_LESS_THAN_1_MILLIS = 1;
    private static final int REBUILD_LATENCY_BUCKET_LESS_THAN_20_MILLIS = 20;
    private static final int REBUILD_LATENCY_BUCKET_LESS_THAN_2_MILLIS = 2;
    private static final int REBUILD_LATENCY_BUCKET_LESS_THAN_50_MILLIS = 50;
    private static final int REBUILD_LATENCY_BUCKET_LESS_THAN_5_MILLIS = 5;
    private static final int REUSE_COUNT_BUCKET_LESS_THAN_1 = 1;
    private static final int REUSE_COUNT_BUCKET_LESS_THAN_10 = 10;
    private static final int REUSE_COUNT_BUCKET_LESS_THAN_100 = 100;
    private static final int REUSE_COUNT_BUCKET_LESS_THAN_1000 = 1000;
    private static final int REUSE_COUNT_BUCKET_LESS_THAN_10000 = 10000;
    public static final int SNAPSHOT_BIG_BUILD_TIME_US = 10000;
    public static final int SNAPSHOT_BUILD_REPORT_LIMIT = 10;
    private static final long SNAPSHOT_LOG_INTERVAL_US = 0;
    public static final int SNAPSHOT_REPORTABLE_BUILD_TIME_US = 30000;
    public static final int SNAPSHOT_SHORT_LIFETIME = 5;
    public static final int SNAPSHOT_TICK_INTERVAL_MS = 60000;
    private static final int US_IN_MS = 1000;
    private int mEventsReported;
    private Handler mHandler;
    private long mLastLogTimeUs;
    private final Object mLock;
    private final Stats[] mLong;
    private int mPackageCount;
    private final Stats[] mShort;
    private final BinMap mTimeBins;
    private final BinMap mUseBins;

    private static class BinMap {
        private final int mCount;
        private final int mMaxBin;
        private final int[] mUserKey;

        BinMap(int[] userKey) {
            this.mUserKey = Arrays.copyOf(userKey, userKey.length);
            this.mCount = this.mUserKey.length + 1;
            this.mMaxBin = this.mUserKey[this.mUserKey.length - 1] + 1;
        }

        public int getBin(int x) {
            if (x < 0) goto L16;
            if (x >= this.mMaxBin) goto L16;
            int i = 0;
        L8:
            if (i >= this.mUserKey.length) goto L14;
            if (x <= this.mUserKey[i]) goto L11;
            i = i + 1;
            goto L8
        L11:
            return i;
        L14:
            return 0;
        L16:
            if (x >= this.mMaxBin) goto L18;
            return 0;
        L18:
            return this.mUserKey.length;
        }

        public int count() {
            return this.mCount;
        }

        public int[] userKeys() {
            return this.mUserKey;
        }
    }

    public class Stats {
        public int mBigBuilds;
        public int mMaxBuildTimeUs;
        public int mMaxUsedCount;
        public int mShortLived;
        public long mStartTimeUs;
        public long mStopTimeUs;
        public final int[] mTimes;
        public int mTotalBuilds;
        public long mTotalTimeUs;
        public int mTotalUsed;
        public final int[] mUsed;
        final /* synthetic */ SnapshotStatistics this$0;

        /* JADX INFO: renamed from: -$$Nest$mcomplete, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6960$$Nest$mcomplete(Stats r0, long r1) {
            r0.complete(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6961$$Nest$mdump(Stats r0, PrintWriter r1, String r2, long r3, boolean r5, String r6) {
            r0.dump(r1, r2, r3, r5, r6);
        }

        /* JADX INFO: renamed from: -$$Nest$mlogSnapshotStatistics, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6962$$Nest$mlogSnapshotStatistics(Stats r0, int r1) {
            r0.logSnapshotStatistics(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mrebuild, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6963$$Nest$mrebuild(Stats r0, int r1, int r2, int r3, int r4, boolean r5, boolean r6) {
            r0.rebuild(r1, r2, r3, r4, r5, r6);
        }

        /* synthetic */ Stats(SnapshotStatistics r1, long r2, SnapshotStatisticsIA r4) {
            this(r1, r2);
        }

        /* synthetic */ Stats(SnapshotStatistics r1, Stats r2, SnapshotStatisticsIA r3) {
            this(r1, r2);
        }

        private void rebuild(int duration, int used, int buildBin, int useBin, boolean big, boolean quick) {
            this.mTotalBuilds++;
            int[] r0 = this.mTimes;
            r0[buildBin] = r0[buildBin] + 1;
            if (used < 0) goto L5;
            this.mTotalUsed += used;
            int[] r1 = this.mUsed;
            r1[useBin] = r1[useBin] + 1;
        L5:
            this.mTotalTimeUs += (long) duration;
            if (big == false) goto L8;
            this.mBigBuilds++;
        L8:
            if (quick == false) goto L11;
            this.mShortLived++;
        L11:
            if (this.mMaxBuildTimeUs >= duration) goto L14;
            this.mMaxBuildTimeUs = duration;
        L14:
            if (this.mMaxUsedCount >= used) goto L17;
            this.mMaxUsedCount = used;
            return;
        }

        private Stats(SnapshotStatistics this$0, long now) {
            this.this$0 = this$0;
            this.mStartTimeUs = 0;
            this.mStopTimeUs = 0;
            this.mTotalBuilds = 0;
            this.mTotalUsed = 0;
            this.mBigBuilds = 0;
            this.mShortLived = 0;
            this.mTotalTimeUs = 0;
            this.mMaxBuildTimeUs = 0;
            this.mMaxUsedCount = 0;
            this.mStartTimeUs = now;
            this.mTimes = new int[SnapshotStatistics.m6957$$Nest$fgetmTimeBins(this$0).count()];
            this.mUsed = new int[SnapshotStatistics.m6958$$Nest$fgetmUseBins(this$0).count()];
        }

        private Stats(SnapshotStatistics this$0, Stats orig) {
            this.this$0 = this$0;
            this.mStartTimeUs = 0;
            this.mStopTimeUs = 0;
            this.mTotalBuilds = 0;
            this.mTotalUsed = 0;
            this.mBigBuilds = 0;
            this.mShortLived = 0;
            this.mTotalTimeUs = 0;
            this.mMaxBuildTimeUs = 0;
            this.mMaxUsedCount = 0;
            this.mStartTimeUs = orig.mStartTimeUs;
            this.mStopTimeUs = orig.mStopTimeUs;
            this.mTimes = Arrays.copyOf(orig.mTimes, orig.mTimes.length);
            this.mUsed = Arrays.copyOf(orig.mUsed, orig.mUsed.length);
            this.mTotalBuilds = orig.mTotalBuilds;
            this.mTotalUsed = orig.mTotalUsed;
            this.mBigBuilds = orig.mBigBuilds;
            this.mShortLived = orig.mShortLived;
            this.mTotalTimeUs = orig.mTotalTimeUs;
            this.mMaxBuildTimeUs = orig.mMaxBuildTimeUs;
            this.mMaxUsedCount = orig.mMaxUsedCount;
        }

        private void complete(long stop) {
            this.mStopTimeUs = stop;
        }

        private String durationToString(long us) {
            int s = (int) (us / 1000000);
            int m = s / 60;
            int s2 = s % 60;
            int h = m / 60;
            int m2 = m % 60;
            int d = h / 24;
            int h2 = h % 24;
            if (d == 0) goto L7;
            return TextUtils.formatSimple("%2d:%02d:%02d:%02d", new Object[]{Integer.valueOf(d), Integer.valueOf(h2), Integer.valueOf(m2), Integer.valueOf(s2)});
        L7:
            if (h2 == 0) goto L11;
            return TextUtils.formatSimple("%2s %02d:%02d:%02d", new Object[]{"", Integer.valueOf(h2), Integer.valueOf(m2), Integer.valueOf(s2)});
        L11:
            return TextUtils.formatSimple("%2s %2s %2d:%02d", new Object[]{"", "", Integer.valueOf(m2), Integer.valueOf(s2)});
        }

        private void dumpPrefix(PrintWriter pw, String indent, long now, boolean header, String title) {
            pw.print(indent + " ");
            if (header == false) goto L5;
            pw.format(Locale.US, "%-23s", new Object[]{title});
            return;
        L5:
            pw.format(Locale.US, "%11s", new Object[]{durationToString(now - this.mStartTimeUs)});
            if (this.mStopTimeUs == 0) goto L8;
            pw.format(Locale.US, " %11s", new Object[]{durationToString(now - this.mStopTimeUs)});
            return;
        L8:
            pw.format(Locale.US, " %11s", new Object[]{"now"});
        }

        private void dumpStats(PrintWriter pw, String indent, long now, boolean header) {
            dumpPrefix(pw, indent, now, header, "Summary stats");
            if (header == false) goto L5;
            pw.format(Locale.US, "  %10s  %10s  %10s  %10s  %10s  %10s", new Object[]{"TotBlds", "TotUsed", "BigBlds", "ShortLvd", "TotTime", "MaxTime"});
        L6:
            pw.println();
            return;
        L5:
            pw.format(Locale.US, "  %10d  %10d  %10d  %10d  %10d  %10d", new Object[]{Integer.valueOf(this.mTotalBuilds), Integer.valueOf(this.mTotalUsed), Integer.valueOf(this.mBigBuilds), Integer.valueOf(this.mShortLived), Long.valueOf(this.mTotalTimeUs / 1000), Integer.valueOf(this.mMaxBuildTimeUs / 1000)});
            goto L6
        }

        private void dumpTimes(PrintWriter pw, String indent, long now, boolean header) {
            dumpPrefix(pw, indent, now, header, "Build times");
            if (header == false) goto L9;
            int[] keys = SnapshotStatistics.m6957$$Nest$fgetmTimeBins(this.this$0).userKeys();
            int i = 0;
        L6:
            if (i >= keys.length) goto L8;
            pw.format(Locale.US, "  %10s", new Object[]{TextUtils.formatSimple("<= %dms", new Object[]{Integer.valueOf(keys[i])})});
            i = i + 1;
            goto L6
        L8:
            pw.format(Locale.US, "  %10s", new Object[]{TextUtils.formatSimple("> %dms", new Object[]{Integer.valueOf(keys[keys.length - 1])})});
        L13:
            pw.println();
            return;
        L9:
            int i2 = 0;
        L11:
            if (i2 >= this.mTimes.length) goto L13;
            pw.format(Locale.US, "  %10d", new Object[]{Integer.valueOf(this.mTimes[i2])});
            i2 = i2 + 1;
            goto L11
        }

        private void dumpUsage(PrintWriter pw, String indent, long now, boolean header) {
            dumpPrefix(pw, indent, now, header, "Use counters");
            if (header == false) goto L9;
            int[] keys = SnapshotStatistics.m6958$$Nest$fgetmUseBins(this.this$0).userKeys();
            int i = 0;
        L6:
            if (i >= keys.length) goto L8;
            pw.format(Locale.US, "  %10s", new Object[]{TextUtils.formatSimple("<= %d", new Object[]{Integer.valueOf(keys[i])})});
            i = i + 1;
            goto L6
        L8:
            pw.format(Locale.US, "  %10s", new Object[]{TextUtils.formatSimple("> %d", new Object[]{Integer.valueOf(keys[keys.length - 1])})});
        L13:
            pw.println();
            return;
        L9:
            int i2 = 0;
        L11:
            if (i2 >= this.mUsed.length) goto L13;
            pw.format(Locale.US, "  %10d", new Object[]{Integer.valueOf(this.mUsed[i2])});
            i2 = i2 + 1;
            goto L11
        }

        private void dump(PrintWriter pw, String indent, long now, boolean header, String what) {
            if (what.equals("stats") == false) goto L6;
            dumpStats(pw, indent, now, header);
            return;
        L6:
            if (what.equals("times") == false) goto L9;
            dumpTimes(pw, indent, now, header);
            return;
        L9:
            if (what.equals("usage") == false) goto L13;
            dumpUsage(pw, indent, now, header);
            return;
        L13:
            throw new IllegalArgumentException("unrecognized choice: " + what);
        }

        private void logSnapshotStatistics(int packageCount) {
            if (this.mTotalBuilds != 0) goto L5;
            long r0 = 0;
        L6:
            long avgLatencyUs = r0;
            if (this.mTotalBuilds != 0) goto L10;
            int r1 = 0;
        L9:
            int avgUsedCount = r1;
            FrameworkStatsLog.write(FrameworkStatsLog.PACKAGE_MANAGER_SNAPSHOT_REPORTED, this.mTimes, this.mUsed, this.mMaxBuildTimeUs, this.mMaxUsedCount, avgLatencyUs, avgUsedCount, packageCount);
            return;
        L10:
            r1 = this.mTotalUsed / this.mTotalBuilds;
            goto L9
        L5:
            r0 = this.mTotalTimeUs / ((long) this.mTotalBuilds);
            goto L6
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimeBins, reason: not valid java name */
    static /* bridge */ /* synthetic */ BinMap m6957$$Nest$fgetmTimeBins(SnapshotStatistics r0) {
        return r0.mTimeBins;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUseBins, reason: not valid java name */
    static /* bridge */ /* synthetic */ BinMap m6958$$Nest$fgetmUseBins(SnapshotStatistics r0) {
        return r0.mUseBins;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6959$$Nest$mhandleMessage(SnapshotStatistics r0, Message r1) {
        r0.handleMessage(r1);
    }

    static {
        SNAPSHOT_LOG_INTERVAL_US = TimeUnit.DAYS.toMicros(1);
    }

    private int usToMs(int us) {
        return us / 1000;
    }

    public SnapshotStatistics() {
        this.mLock = new Object();
        this.mEventsReported = 0;
        SnapshotStatisticsIA r1 = null;
        this.mHandler = null;
        this.mTimeBins = new BinMap(new int[]{1, 2, 5, 10, 20, 50, 100});
        this.mUseBins = new BinMap(new int[]{1, 10, 100, 1000, 10000});
        long now = SystemClock.currentTimeMicro();
        this.mLong = new Stats[2];
        this.mLong[0] = new Stats(this, now, r1);
        this.mShort = new Stats[10];
        this.mShort[0] = new Stats(this, now, r1);
        this.mLastLogTimeUs = now;
        final Looper r2 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r2);
        scheduleTick();
    }

    private void handleMessage(Message msg) {
        tick();
        scheduleTick();
    }

    private void scheduleTick() {
        this.mHandler.sendEmptyMessageDelayed(0, 60000);
    }

    public final void rebuild(long now, long done, int hits, int packageCount) {
        int duration = (int) (done - now);
        boolean reportEvent = false;
        Object r8 = this.mLock;
        monitor-enter(r8);
        this.mPackageCount = packageCount;     // Catch: Throwable -> L21
        int timeBin = this.mTimeBins.getBin(duration / 1000);     // Catch: Throwable -> L21
        int useBin = this.mUseBins.getBin(hits);     // Catch: Throwable -> L21
        if (duration < 10000) goto L8;
        boolean big = true;
    L10:
        if (hits > 5) goto L12;
        boolean quick = true;
    L13:
        boolean big2 = big;
        Stats.m6963$$Nest$mrebuild(this.mShort[0], duration, hits, timeBin, useBin, big2, quick);     // Catch: Throwable -> L21
        Stats.m6963$$Nest$mrebuild(this.mLong[0], duration, hits, timeBin, useBin, big2, quick);     // Catch: Throwable -> L21
        if (duration < 30000) goto L23;
        int r0 = this.mEventsReported;     // Catch: Throwable -> L21
        this.mEventsReported = r0 + 1;     // Catch: Throwable -> L21
        if (r0 >= 10) goto L23;
        reportEvent = true;
    L23:
        monitor-exit(r8);     // Catch: Throwable -> L21
        if (reportEvent == false) goto L34;
        EventLogTags.writePmSnapshotRebuild(duration / 1000, hits);
        return;
    L34:
        return;
    L27:
        th = th;
    L29:
        monitor-exit(r8);     // Catch: Throwable -> L21
        throw th;
    L12:
        quick = false;
        goto L13
    L8:
        big = false;
    L21:
        th = th;
        goto L29
    }

    private void shift(Stats[] s, long now) {
        Stats.m6960$$Nest$mcomplete(s[0], now);
        int i = s.length - 1;
    L3:
        if (i <= 0) goto L5;
        s[i] = s[i - 1];
        i = i - 1;
        goto L3
    L5:
        s[0] = new Stats(this, now, null);
    }

    private void tick() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long now = SystemClock.currentTimeMicro();     // Catch: Throwable -> L7
        if ((now - this.mLastLogTimeUs) <= SNAPSHOT_LOG_INTERVAL_US) goto L9;
        shift(this.mLong, now);     // Catch: Throwable -> L7
        this.mLastLogTimeUs = now;     // Catch: Throwable -> L7
        Stats.m6962$$Nest$mlogSnapshotStatistics(this.mLong[this.mLong.length - 1], this.mPackageCount);     // Catch: Throwable -> L7
    L9:
        shift(this.mShort, now);     // Catch: Throwable -> L7
        this.mEventsReported = 0;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void dump(PrintWriter pw, String indent, long now, Stats[] l, Stats[] s, String what) {
        Stats.m6961$$Nest$mdump(l[0], pw, indent, now, true, what);
        int i = 0;
    L4:
        if (i >= s.length) goto L9;
        if (s[i] == null) goto L8;
        Stats.m6961$$Nest$mdump(s[i], pw, indent, now, false, what);
    L8:
        i = i + 1;
        goto L4
    L9:
        int i2 = 0;
    L11:
        if (i2 >= l.length) goto L17;
        if (l[i2] == null) goto L15;
        Stats.m6961$$Nest$mdump(l[i2], pw, indent, now, false, what);
    L15:
        i2 = i2 + 1;
        goto L11
    }

    public void dump(PrintWriter pw, String indent, long now, int unrecorded, boolean brief) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        Stats[] l = (Stats[]) Arrays.copyOf(this.mLong, this.mLong.length);     // Catch: Throwable -> L11
        SnapshotStatisticsIA r5 = null;
        l[0] = new Stats(this, l[0], r5);     // Catch: Throwable -> L11
        Stats[] s = (Stats[]) Arrays.copyOf(this.mShort, this.mShort.length);     // Catch: Throwable -> L11
        s[0] = new Stats(this, s[0], r5);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        pw.format(Locale.US, "%s Unrecorded-hits: %d", new Object[]{indent, Integer.valueOf(unrecorded)});
        pw.println();
        dump(pw, indent, now, l, s, "stats");
        if (brief == false) goto L9;
        return;
    L9:
        pw.println();
        dump(pw, indent, now, l, s, "times");
        pw.println();
        dump(pw, indent, now, l, s, "usage");
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
