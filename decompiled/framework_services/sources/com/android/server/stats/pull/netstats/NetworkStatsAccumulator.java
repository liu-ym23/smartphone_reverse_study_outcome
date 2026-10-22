package com.android.server.stats.pull.netstats;

import android.net.NetworkStats;
import android.net.NetworkTemplate;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkStatsAccumulator {
    private static final String TAG = "NetworkStatsAccumulator";
    private final long mBucketDurationMillis;
    private NetworkStats mSnapshot;
    private long mSnapshotEndTimeMillis;
    private final NetworkTemplate mTemplate;
    private final boolean mWithTags;

    @FunctionalInterface
    public interface StatsQueryFunction {
        NetworkStats queryNetworkStats(NetworkTemplate r1, boolean r2, long r3, long r5);
    }

    public NetworkStatsAccumulator(NetworkTemplate template, boolean withTags, long bucketDurationMillis, long snapshotEndTimeMillis) {
        this.mTemplate = template;
        this.mWithTags = withTags;
        this.mBucketDurationMillis = bucketDurationMillis;
        this.mSnapshot = new NetworkStats(0, 1);
        this.mSnapshotEndTimeMillis = snapshotEndTimeMillis;
    }

    public NetworkStats queryStats(long currentTimeMillis, StatsQueryFunction queryFunction) {
        NetworkStats completeStats = snapshotPlusFollowingStats(currentTimeMillis, queryFunction);
        maybeExpandSnapshot(currentTimeMillis, completeStats, queryFunction);
        return completeStats;
    }

    public boolean hasEqualParameters(NetworkTemplate template, boolean withTags) {
        if (Objects.equals(this.mTemplate, template) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mWithTags != withTags) goto L7;
        return true;
    }

    private void maybeExpandSnapshot(long currentTimeMillis, NetworkStats completeStatsUntilCurrentTime, StatsQueryFunction queryFunction) {
        long newEndTimeMillis = currentTimeMillis - this.mBucketDurationMillis;
        if ((newEndTimeMillis - this.mSnapshotEndTimeMillis) <= this.mBucketDurationMillis) goto L6;
        Log.v(TAG, "Expanding snapshot (mTemplate=" + this.mTemplate + ", mWithTags=" + this.mWithTags + ") from " + this.mSnapshotEndTimeMillis + " to " + newEndTimeMillis + " at " + currentTimeMillis);
        NetworkStats extraStats = queryFunction.queryNetworkStats(this.mTemplate, this.mWithTags, this.mSnapshotEndTimeMillis, newEndTimeMillis);
        this.mSnapshot = this.mSnapshot.add(extraStats);
        this.mSnapshotEndTimeMillis = newEndTimeMillis;
        NetworkStats newStats = snapshotPlusFollowingStats(currentTimeMillis, queryFunction);
        NetworkStats interpolationLoss = completeStatsUntilCurrentTime.subtract(newStats);
        this.mSnapshot = this.mSnapshot.add(interpolationLoss);
        return;
    }

    private NetworkStats snapshotPlusFollowingStats(long currentTimeMillis, StatsQueryFunction queryFunction) {
        NetworkStats extraStats = queryFunction.queryNetworkStats(this.mTemplate, this.mWithTags, this.mSnapshotEndTimeMillis, this.mBucketDurationMillis + currentTimeMillis);
        return this.mSnapshot.add(extraStats);
    }
}
