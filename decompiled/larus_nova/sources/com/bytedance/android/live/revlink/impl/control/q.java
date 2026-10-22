package com.bytedance.android.live.revlink.impl.control;

/* JADX INFO: loaded from: classes47.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f92450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f92451b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L10;
        q r101 = (q) r100;
        if (this.f92450a == r101.f92450a) goto L8;
        return false;
    L8:
        if (this.f92451b == r101.f92451b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f92450a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f92451b;
    }

    public final String toString() {
        return "MergeInfo(channelId=" + this.f92450a + ", classicScene=" + this.f92451b + ")";
    }

    public q(long r100, int r101) {
        this.f92450a = r100;
        this.f92451b = r101;
    }
}
