package com.bytedance.android.shopping.mall.opt;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f178567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f178568b;

    public d() {
        this(0, false, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (this.f178567a == r101.f178567a) goto L8;
        return false;
    L8:
        if (this.f178568b == r101.f178568b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        int r100 = this.f178567a * 31;
        boolean r101 = this.f178568b;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "GulReqByPitayaData(hitRule=" + this.f178567a + ", refresh=" + this.f178568b + ")";
    }

    public d(int r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this.f178567a = r100;
        this.f178568b = r101;
    }
}
