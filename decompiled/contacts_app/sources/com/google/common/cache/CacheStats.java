package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheStats {
    private final long evictionCount;
    private final long hitCount;
    private final long loadExceptionCount;
    private final long loadSuccessCount;
    private final long missCount;
    private final long totalLoadTime;

    public CacheStats(long r19, long r21, long r23, long r25, long r27, long r29) {
        boolean r16 = true;
        if (r19 < 0) goto L5;
        boolean r15 = true;
    L6:
        Preconditions.checkArgument(r15);
        if (r21 < 0) goto L9;
        boolean r17 = true;
    L10:
        Preconditions.checkArgument(r17);
        if (r23 < 0) goto L13;
        boolean r18 = true;
    L14:
        Preconditions.checkArgument(r18);
        if (r25 < 0) goto L17;
        boolean r110 = true;
    L18:
        Preconditions.checkArgument(r110);
        if (r27 < 0) goto L21;
        boolean r111 = true;
    L22:
        Preconditions.checkArgument(r111);
        if (r29 >= 0) goto L26;
        r16 = false;
    L26:
        Preconditions.checkArgument(r16);
        this.hitCount = r19;
        this.missCount = r21;
        this.loadSuccessCount = r23;
        this.loadExceptionCount = r25;
        this.totalLoadTime = r27;
        this.evictionCount = r29;
        return;
    L21:
        r111 = false;
        goto L22
    L17:
        r110 = false;
        goto L18
    L13:
        r18 = false;
        goto L14
    L9:
        r17 = false;
        goto L10
    L5:
        r15 = false;
        goto L6
    }

    public long requestCount() {
        return this.hitCount + this.missCount;
    }

    public long hitCount() {
        return this.hitCount;
    }

    public double hitRate() {
        long r0 = requestCount();
        if (r0 != 0) goto L6;
        return 1.0d;
    L6:
        return this.hitCount / r0;
    }

    public long missCount() {
        return this.missCount;
    }

    public double missRate() {
        long r0 = requestCount();
        if (r0 != 0) goto L6;
        return 0.0d;
    L6:
        return this.missCount / r0;
    }

    public long loadCount() {
        return this.loadSuccessCount + this.loadExceptionCount;
    }

    public long loadSuccessCount() {
        return this.loadSuccessCount;
    }

    public long loadExceptionCount() {
        return this.loadExceptionCount;
    }

    public double loadExceptionRate() {
        long r0 = this.loadSuccessCount;
        long r2 = this.loadExceptionCount;
        long r1 = r0 + r2;
        if (r1 != 0) goto L6;
        return 0.0d;
    L6:
        return r2 / r1;
    }

    public long totalLoadTime() {
        return this.totalLoadTime;
    }

    public double averageLoadPenalty() {
        long r0 = this.loadSuccessCount + this.loadExceptionCount;
        if (r0 != 0) goto L6;
        return 0.0d;
    L6:
        return this.totalLoadTime / r0;
    }

    public long evictionCount() {
        return this.evictionCount;
    }

    public CacheStats minus(CacheStats r19) {
        return new CacheStats(Math.max(0, this.hitCount - r19.hitCount), Math.max(0, this.missCount - r19.missCount), Math.max(0, this.loadSuccessCount - r19.loadSuccessCount), Math.max(0, this.loadExceptionCount - r19.loadExceptionCount), Math.max(0, this.totalLoadTime - r19.totalLoadTime), Math.max(0, this.evictionCount - r19.evictionCount));
    }

    public CacheStats plus(CacheStats r15) {
        return new CacheStats(this.hitCount + r15.hitCount, this.missCount + r15.missCount, this.loadSuccessCount + r15.loadSuccessCount, this.loadExceptionCount + r15.loadExceptionCount, this.totalLoadTime + r15.totalLoadTime, this.evictionCount + r15.evictionCount);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.hitCount), Long.valueOf(this.missCount), Long.valueOf(this.loadSuccessCount), Long.valueOf(this.loadExceptionCount), Long.valueOf(this.totalLoadTime), Long.valueOf(this.evictionCount)});
    }

    public boolean equals(@Nullable Object r7) {
        if ((r7 instanceof CacheStats) == false) goto L18;
        CacheStats r8 = (CacheStats) r7;
        if (this.hitCount == r8.hitCount) goto L7;
        return false;
    L7:
        if (this.missCount == r8.missCount) goto L9;
        return false;
    L9:
        if (this.loadSuccessCount == r8.loadSuccessCount) goto L11;
        return false;
    L11:
        if (this.loadExceptionCount == r8.loadExceptionCount) goto L13;
        return false;
    L13:
        if (this.totalLoadTime == r8.totalLoadTime) goto L15;
        return false;
    L15:
        if (this.evictionCount != r8.evictionCount) goto L24;
        return true;
    L24:
        return false;
    L18:
        return false;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("hitCount", this.hitCount).add("missCount", this.missCount).add("loadSuccessCount", this.loadSuccessCount).add("loadExceptionCount", this.loadExceptionCount).add("totalLoadTime", this.totalLoadTime).add("evictionCount", this.evictionCount).toString();
    }
}
