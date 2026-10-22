package com.bytedance.android.live.revlink.impl.jsb;

/* JADX INFO: loaded from: classes47.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f92581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f92582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f92583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f92584d;

    public h0() {
        this(0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h0) == false) goto L14;
        h0 r101 = (h0) r100;
        if (this.f92581a == r101.f92581a) goto L8;
        return false;
    L8:
        if (this.f92582b == r101.f92582b) goto L10;
        return false;
    L10:
        if (this.f92583c == r101.f92583c) goto L12;
        return false;
    L12:
        if (this.f92584d == r101.f92584d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f92581a * 31) + this.f92582b) * 31) + this.f92583c) * 31) + this.f92584d;
    }

    public final String toString() {
        return "TeamTaskAddition(operationType=" + this.f92581a + ", anchorType=" + this.f92582b + ", selfReward=" + this.f92583c + ", oppoReward=" + this.f92584d + ")";
    }

    public h0(int r100, int r101, int r102, int r103) {
        this.f92581a = r100;
        this.f92582b = r101;
        this.f92583c = r102;
        this.f92584d = r103;
    }
}
