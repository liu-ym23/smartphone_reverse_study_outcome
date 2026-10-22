package com.bytedance.android.shopping.orderlist.common.widgets.linkedlist;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f180047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f180048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f180049c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.f180047a == r101.f180047a) goto L8;
        return false;
    L8:
        if (this.f180048b == r101.f180048b) goto L10;
        return false;
    L10:
        if (this.f180049c == r101.f180049c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f180047a * 31) + this.f180048b) * 31) + this.f180049c;
    }

    public final String toString() {
        return "LinkedScrollViewVerticalOffset(yataVerticalOffset=" + this.f180047a + ", gulVerticalOffset=" + this.f180048b + ", linkedScrollY=" + this.f180049c + ")";
    }

    public b(int r100, int r101, int r102) {
        this.f180047a = r100;
        this.f180048b = r101;
        this.f180049c = r102;
    }
}
