package com.android.server.am.compaction;

import com.android.server.am.CachedAppOptimizer;

/* JADX INFO: loaded from: classes.dex */
final class AggregatedSourceCompactionStats extends AggregatedCompactionStats {
    public final CachedAppOptimizer.CompactSource mSourceType;

    public AggregatedSourceCompactionStats(CachedAppOptimizer.CompactSource sourceType) {
        this.mSourceType = sourceType;
    }
}
