package com.bytedance.android.gamecp.business.gamedetail.page.root;

/* JADX INFO: loaded from: classes44.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f55574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f55575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f55576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f55577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f55578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f55579f;

    public p0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p0) == false) goto L18;
        p0 r101 = (p0) r100;
        if (Float.compare(this.f55574a, r101.f55574a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f55575b, r101.f55575b) == 0) goto L10;
        return false;
    L10:
        if (this.f55576c == r101.f55576c) goto L12;
        return false;
    L12:
        if (Float.compare(this.f55577d, r101.f55577d) == 0) goto L14;
        return false;
    L14:
        if (this.f55578e == r101.f55578e) goto L16;
        return false;
    L16:
        if (this.f55579f == r101.f55579f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((((((Float.floatToIntBits(this.f55574a) * 31) + Float.floatToIntBits(this.f55575b)) * 31) + this.f55576c) * 31) + Float.floatToIntBits(this.f55577d)) * 31;
        boolean r101 = this.f55578e;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f55579f;
        if (r105 == true) goto L10;
        r102 = r105;
    L10:
        return r104 + r102;
    }

    public final String toString() {
        return "OuterRVScrollData(scrollOffsetRatio=" + this.f55574a + ", maxScrollOffset=" + this.f55575b + ", dy=" + this.f55576c + ", scrollTotalDy=" + this.f55577d + ", isScrollTop=" + this.f55578e + ", isScrollBottom=" + this.f55579f + ")";
    }

    public /* synthetic */ p0(int r100) {
        this(0.0f, 0.0f, 0, 0.0f, false, false);
    }

    public p0(float r100, float r101, int r102, float r103, boolean r104, boolean r105) {
        this.f55574a = r100;
        this.f55575b = r101;
        this.f55576c = r102;
        this.f55577d = r103;
        this.f55578e = r104;
        this.f55579f = r105;
    }
}
