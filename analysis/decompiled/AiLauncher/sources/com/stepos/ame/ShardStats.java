package com.stepos.ame;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\nR\u0017\u0010\u0014\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/stepos/ame/ShardStats;", "", "", Const.INTENT_KEY_APIKEY, "()D", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTotalShards", "totalShards", Const.INTENT_KEY_PKGNAME, "getMappedShards", "mappedShards", "", "c", "J", "getCacheHits", "()J", "cacheHits", Const.INTENT_KEY_UMID, "getCacheMisses", "cacheMisses", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ShardStats {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int total;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int mapped;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final long hits;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final long misses;

    public final double a() {
        long j10 = this.hits;
        long j11 = this.misses + j10;
        if (j11 > 0) {
            return (j10 * 100.0d) / j11;
        }
        return 0.0d;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShardStats)) {
            return false;
        }
        ShardStats shardStats = (ShardStats) other;
        return this.total == shardStats.total && this.mapped == shardStats.mapped && this.hits == shardStats.hits && this.misses == shardStats.misses;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.total) * 31) + Integer.hashCode(this.mapped)) * 31) + Long.hashCode(this.hits)) * 31) + Long.hashCode(this.misses);
    }

    public String toString() {
        int i10 = this.total;
        int i11 = this.mapped;
        long j10 = this.hits;
        long j11 = this.misses;
        y yVar = y.f34840a;
        String str = String.format("%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(a())}, 1));
        p.h(str, "format(...)");
        return "ShardStats(total=" + i10 + ", mapped=" + i11 + ", hits=" + j10 + ", misses=" + j11 + ", hitRate=" + str + ")";
    }
}
