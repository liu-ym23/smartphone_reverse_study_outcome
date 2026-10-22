package com.android.server.am.compaction;

import com.android.server.slice.SliceClientPermissions;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
class AggregatedCompactionStats {
    public long mFullCompactPerformed;
    public long mFullCompactRequested;
    public double mMaxCompactEfficiency;
    public double mMaxSwapEfficiency;
    public long mProcCompactionsMiscThrottled;
    public long mProcCompactionsNoPidThrottled;
    public long mProcCompactionsOomAdjThrottled;
    public long mProcCompactionsRSSThrottled;
    public long mProcCompactionsTimeThrottled;
    public long mSomeCompactPerformed;
    public long mSomeCompactRequested;
    public long mSumOrigAnonRss;
    public long mTotalAnonMemFreedKBs;
    public long mTotalCpuTimeMillis;
    public long mTotalDeltaAnonRssKBs;
    public long mTotalZramConsumedKBs;

    AggregatedCompactionStats() {
    }

    public long getThrottledSome() {
        return this.mSomeCompactRequested - this.mSomeCompactPerformed;
    }

    public long getThrottledFull() {
        return this.mFullCompactRequested - this.mFullCompactPerformed;
    }

    public void addMemStats(long anonRssSaved, long zramConsumed, long memFreed, long origAnonRss, long totalCpuTimeMillis) {
        double compactEfficiency = memFreed / origAnonRss;
        if (compactEfficiency <= this.mMaxCompactEfficiency) goto L5;
        this.mMaxCompactEfficiency = compactEfficiency;
    L5:
        double swapEfficiency = anonRssSaved / origAnonRss;
        if (swapEfficiency <= this.mMaxSwapEfficiency) goto L8;
        this.mMaxSwapEfficiency = swapEfficiency;
    L8:
        this.mTotalDeltaAnonRssKBs += anonRssSaved;
        this.mTotalZramConsumedKBs += zramConsumed;
        this.mTotalAnonMemFreedKBs += memFreed;
        this.mSumOrigAnonRss += origAnonRss;
        this.mTotalCpuTimeMillis += totalCpuTimeMillis;
    }

    @NeverCompile
    public void dump(PrintWriter pw) {
        long totalCompactRequested = this.mSomeCompactRequested + this.mFullCompactRequested;
        long totalCompactPerformed = this.mSomeCompactPerformed + this.mFullCompactPerformed;
        pw.println("    Performed / Requested:");
        pw.println("      Some: (" + this.mSomeCompactPerformed + SliceClientPermissions.SliceAuthority.DELIMITER + this.mSomeCompactRequested + ")");
        pw.println("      Full: (" + this.mFullCompactPerformed + SliceClientPermissions.SliceAuthority.DELIMITER + this.mFullCompactRequested + ")");
        long throttledSome = getThrottledSome();
        long throttledFull = getThrottledFull();
        if (throttledSome <= 0) goto L5;
    L8:
        pw.println("    Throttled:");
        pw.println("       Some: " + throttledSome + " Full: " + throttledFull);
        pw.println("    Throttled by Type:");
        long compactionsThrottled = totalCompactRequested - totalCompactPerformed;
        long unaccountedThrottled = ((((compactionsThrottled - this.mProcCompactionsNoPidThrottled) - this.mProcCompactionsOomAdjThrottled) - this.mProcCompactionsTimeThrottled) - this.mProcCompactionsRSSThrottled) - this.mProcCompactionsMiscThrottled;
        StringBuilder r10 = new StringBuilder();
        r10.append("       NoPid: ");
        long totalCompactPerformed2 = this.mProcCompactionsNoPidThrottled;
        r10.append(totalCompactPerformed2);
        r10.append(" OomAdj: ");
        r10.append(this.mProcCompactionsOomAdjThrottled);
        r10.append(" Time: ");
        r10.append(this.mProcCompactionsTimeThrottled);
        r10.append(" RSS: ");
        r10.append(this.mProcCompactionsRSSThrottled);
        r10.append(" Misc: ");
        r10.append(this.mProcCompactionsMiscThrottled);
        r10.append(" Unaccounted: ");
        r10.append(unaccountedThrottled);
        pw.println(r10.toString());
        double compactThrottlePercentage = (compactionsThrottled / totalCompactRequested) * 100.0d;
        pw.println("    Throttle Percentage: " + compactThrottlePercentage);
    L10:
        if (this.mFullCompactPerformed <= r10) goto L17;
        pw.println("    -----Memory Stats----");
        pw.println("    Total Delta Anon RSS (KB) : " + this.mTotalDeltaAnonRssKBs);
        pw.println("    Total Physical ZRAM Consumed (KB): " + this.mTotalZramConsumedKBs);
        pw.println("    Total Anon Memory Freed (KB): " + this.mTotalAnonMemFreedKBs);
        pw.println("    Avg Swap Efficiency (KB) (Delta Anon RSS/Orig Anon RSS): " + (((double) this.mTotalDeltaAnonRssKBs) / ((double) this.mSumOrigAnonRss)));
        pw.println("    Max Swap Efficiency: " + this.mMaxSwapEfficiency);
        pw.println("    Avg Compaction Efficiency (Anon Freed/Anon RSS): " + (((double) this.mTotalAnonMemFreedKBs) / ((double) this.mSumOrigAnonRss)));
        pw.println("    Max Compaction Efficiency: " + this.mMaxCompactEfficiency);
        pw.println("    Avg Compression Ratio (1 - ZRAM Consumed/DeltaAnonRSS): " + (1.0d - (((double) this.mTotalZramConsumedKBs) / ((double) this.mTotalDeltaAnonRssKBs))));
        if (this.mFullCompactPerformed <= r10) goto L14;
        long avgKBsPerProcCompact = this.mTotalAnonMemFreedKBs / this.mFullCompactPerformed;
    L15:
        pw.println("    Avg Anon Mem Freed/Compaction (KB) : " + avgKBsPerProcCompact);
        double compactionCost = ((double) this.mTotalCpuTimeMillis) / (((double) this.mTotalAnonMemFreedKBs) / 1024.0d);
        pw.println("    Compaction Cost (ms/MB): " + compactionCost);
        return;
    L14:
        avgKBsPerProcCompact = 0;
        goto L15
    L17:
        return;
    L5:
        if (throttledFull <= 0) goto L10;
        goto L8
    }
}
