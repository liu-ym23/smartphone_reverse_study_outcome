package com.bytedance.android.live.revlink.impl.player;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f97426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f97427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f97428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f97429d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L14;
        h r101 = (h) r100;
        if (this.f97426a == r101.f97426a) goto L8;
        return false;
    L8:
        if (this.f97427b == r101.f97427b) goto L10;
        return false;
    L10:
        if (this.f97428c == r101.f97428c) goto L12;
        return false;
    L12:
        if (this.f97429d == r101.f97429d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f97426a * 31) + this.f97427b) * 31) + this.f97428c) * 31) + this.f97429d;
    }

    public final String toString() {
        return "PlayerLayout(width=" + this.f97426a + ", height=" + this.f97427b + ", leftMargin=" + this.f97428c + ", topMargin=" + this.f97429d + ")";
    }

    public h(int r100, int r101, int r102, int r103) {
        this.f97426a = r100;
        this.f97427b = r101;
        this.f97428c = r102;
        this.f97429d = r103;
    }
}
