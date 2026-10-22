package com.stepos.ame.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/stepos/ame/sdk/CollectionRuntimeStats;", "", "count", "", "dataBufferBytes", "currentCapacityVectors", "<init>", "(JJJ)V", "getCount", "()J", "getDataBufferBytes", "getCurrentCapacityVectors", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CollectionRuntimeStats {
    private final long count;
    private final long currentCapacityVectors;
    private final long dataBufferBytes;

    public CollectionRuntimeStats(long j10, long j11, long j12) {
        this.count = j10;
        this.dataBufferBytes = j11;
        this.currentCapacityVectors = j12;
    }

    public static /* synthetic */ CollectionRuntimeStats copy$default(CollectionRuntimeStats collectionRuntimeStats, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = collectionRuntimeStats.count;
        }
        long j13 = j10;
        if ((i10 & 2) != 0) {
            j11 = collectionRuntimeStats.dataBufferBytes;
        }
        long j14 = j11;
        if ((i10 & 4) != 0) {
            j12 = collectionRuntimeStats.currentCapacityVectors;
        }
        return collectionRuntimeStats.copy(j13, j14, j12);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCount() {
        return this.count;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDataBufferBytes() {
        return this.dataBufferBytes;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCurrentCapacityVectors() {
        return this.currentCapacityVectors;
    }

    public final CollectionRuntimeStats copy(long count, long dataBufferBytes, long currentCapacityVectors) {
        return new CollectionRuntimeStats(count, dataBufferBytes, currentCapacityVectors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionRuntimeStats)) {
            return false;
        }
        CollectionRuntimeStats collectionRuntimeStats = (CollectionRuntimeStats) other;
        return this.count == collectionRuntimeStats.count && this.dataBufferBytes == collectionRuntimeStats.dataBufferBytes && this.currentCapacityVectors == collectionRuntimeStats.currentCapacityVectors;
    }

    public final long getCount() {
        return this.count;
    }

    public final long getCurrentCapacityVectors() {
        return this.currentCapacityVectors;
    }

    public final long getDataBufferBytes() {
        return this.dataBufferBytes;
    }

    public int hashCode() {
        return (((Long.hashCode(this.count) * 31) + Long.hashCode(this.dataBufferBytes)) * 31) + Long.hashCode(this.currentCapacityVectors);
    }

    public String toString() {
        return "CollectionRuntimeStats(count=" + this.count + ", dataBufferBytes=" + this.dataBufferBytes + ", currentCapacityVectors=" + this.currentCapacityVectors + ")";
    }
}
