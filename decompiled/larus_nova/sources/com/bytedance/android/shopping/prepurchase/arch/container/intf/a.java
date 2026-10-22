package com.bytedance.android.shopping.prepurchase.arch.container.intf;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f180784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f180785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f180786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f180787d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f180784a == r101.f180784a) goto L8;
        return false;
    L8:
        if (this.f180785b == r101.f180785b) goto L10;
        return false;
    L10:
        if (this.f180786c == r101.f180786c) goto L12;
        return false;
    L12:
        if (this.f180787d == r101.f180787d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f180784a * 31) + this.f180785b) * 31) + this.f180786c) * 31) + this.f180787d;
    }

    public final String toString() {
        return "ContainerArea(width=" + this.f180784a + ", height=" + this.f180785b + ", topSafeSpace=" + this.f180786c + ", bottomSafeSpace=" + this.f180787d + ")";
    }

    public a(int r100, int r101, int r102, int r103) {
        this.f180784a = r100;
        this.f180785b = r101;
        this.f180786c = r102;
        this.f180787d = r103;
    }
}
