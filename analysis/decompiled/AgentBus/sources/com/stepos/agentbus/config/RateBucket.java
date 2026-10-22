package com.stepos.agentbus.config;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentbus/config/RateBucket;", "", "reqPerSec", "", "burstSize", "<init>", "(II)V", "getReqPerSec", "()I", "getBurstSize", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RateBucket {
    private final int burstSize;
    private final int reqPerSec;

    public RateBucket(int i2, int i10) {
        this.reqPerSec = i2;
        this.burstSize = i10;
    }

    public static /* synthetic */ RateBucket copy$default(RateBucket rateBucket, int i2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i2 = rateBucket.reqPerSec;
        }
        if ((i11 & 2) != 0) {
            i10 = rateBucket.burstSize;
        }
        return rateBucket.copy(i2, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getReqPerSec() {
        return this.reqPerSec;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBurstSize() {
        return this.burstSize;
    }

    public final RateBucket copy(int reqPerSec, int burstSize) {
        return new RateBucket(reqPerSec, burstSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RateBucket)) {
            return false;
        }
        RateBucket rateBucket = (RateBucket) other;
        return this.reqPerSec == rateBucket.reqPerSec && this.burstSize == rateBucket.burstSize;
    }

    public final int getBurstSize() {
        return this.burstSize;
    }

    public final int getReqPerSec() {
        return this.reqPerSec;
    }

    public int hashCode() {
        return Integer.hashCode(this.burstSize) + (Integer.hashCode(this.reqPerSec) * 31);
    }

    public String toString() {
        return "RateBucket(reqPerSec=" + this.reqPerSec + ", burstSize=" + this.burstSize + ")";
    }
}
