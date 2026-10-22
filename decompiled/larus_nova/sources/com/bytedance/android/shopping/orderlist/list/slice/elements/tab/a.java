package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f180295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f180296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f180297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f180298d;

    public a() {
        this(0, 18, 16, 16);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f180295a == r101.f180295a) goto L8;
        return false;
    L8:
        if (this.f180296b == r101.f180296b) goto L10;
        return false;
    L10:
        if (this.f180297c == r101.f180297c) goto L12;
        return false;
    L12:
        if (this.f180298d == r101.f180298d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f180295a * 31) + this.f180296b) * 31) + this.f180297c) * 31) + this.f180298d;
    }

    public final String toString() {
        return "AdaptiveGapConfig(enable=" + this.f180295a + ", minGap=" + this.f180296b + ", leftPadding=" + this.f180297c + ", rightPadding=" + this.f180298d + ")";
    }

    public a(int r100, int r101, int r102, int r103) {
        this.f180295a = r100;
        this.f180296b = r101;
        this.f180297c = r102;
        this.f180298d = r103;
    }
}
