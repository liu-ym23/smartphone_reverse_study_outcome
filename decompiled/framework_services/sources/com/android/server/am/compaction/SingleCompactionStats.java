package com.android.server.am.compaction;

import com.android.internal.util.FrameworkStatsLog;
import com.android.server.am.CachedAppOptimizer;
import com.android.server.am.OomAdjuster;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class SingleCompactionStats {
    private static final float STATSD_SAMPLE_RATE = 0.1f;
    private static final Random mRandom = null;
    public long mAnonMemFreedKBs;
    public float mCpuTimeMillis;
    public long mDeltaAnonRssKBs;
    public int mOomAdj;
    public int mOomAdjReason;
    public long mOrigAnonRss;
    public int mProcState;
    public String mProcessName;
    private final long[] mRssAfterCompaction;
    public CachedAppOptimizer.CompactSource mSourceType;
    public final int mUid;
    public long mZramConsumedKBs;

    static {
        mRandom = new Random();
    }

    SingleCompactionStats(long[] rss, CachedAppOptimizer.CompactSource source, String processName, long deltaAnonRss, long zramConsumed, long anonMemFreed, long origAnonRss, long cpuTimeMillis, int procState, int oomAdj, int oomAdjReason, int uid) {
        this.mRssAfterCompaction = rss;
        this.mSourceType = source;
        this.mProcessName = processName;
        this.mUid = uid;
        this.mDeltaAnonRssKBs = deltaAnonRss;
        this.mZramConsumedKBs = zramConsumed;
        this.mAnonMemFreedKBs = anonMemFreed;
        this.mCpuTimeMillis = cpuTimeMillis;
        this.mOrigAnonRss = origAnonRss;
        this.mProcState = procState;
        this.mOomAdj = oomAdj;
        this.mOomAdjReason = oomAdjReason;
    }

    double getCompactEfficiency() {
        return this.mAnonMemFreedKBs / this.mOrigAnonRss;
    }

    double getSwapEfficiency() {
        return this.mDeltaAnonRssKBs / this.mOrigAnonRss;
    }

    double getCompactCost() {
        return (((double) this.mCpuTimeMillis) / this.mAnonMemFreedKBs) * 1024.0d;
    }

    public long[] getRssAfterCompaction() {
        return this.mRssAfterCompaction;
    }

    @NeverCompile
    void dump(PrintWriter pw) {
        pw.println("    (" + this.mProcessName + "," + this.mSourceType.name() + "," + this.mDeltaAnonRssKBs + "," + this.mZramConsumedKBs + "," + this.mAnonMemFreedKBs + "," + getSwapEfficiency() + "," + getCompactEfficiency() + "," + getCompactCost() + "," + this.mProcState + "," + this.mOomAdj + "," + OomAdjuster.oomAdjReasonToString(this.mOomAdjReason) + ")");
    }

    void sendStat() {
        if (mRandom.nextFloat() >= STATSD_SAMPLE_RATE) goto L6;
        FrameworkStatsLog.write(FrameworkStatsLog.APP_COMPACTED_V2, this.mUid, this.mProcState, this.mOomAdj, this.mDeltaAnonRssKBs, this.mZramConsumedKBs, this.mCpuTimeMillis, this.mOrigAnonRss, this.mOomAdjReason);
        return;
    }
}
