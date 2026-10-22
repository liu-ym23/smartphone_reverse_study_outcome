package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f51677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f51678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51679d;

    public w0() {
        this(0, false, false, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w0) == false) goto L14;
        w0 r101 = (w0) r100;
        if (this.f51676a == r101.f51676a) goto L8;
        return false;
    L8:
        if (this.f51677b == r101.f51677b) goto L10;
        return false;
    L10:
        if (this.f51678c == r101.f51678c) goto L12;
        return false;
    L12:
        if (this.f51679d == r101.f51679d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.f51676a * 31;
        boolean r101 = this.f51677b;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f51678c;
        if (r105 == true) goto L10;
        r102 = r105;
    L10:
        return ((r104 + r102) * 31) + this.f51679d;
    }

    public final String toString() {
        return "OrderGameDetailInfoUIStyle(gameIntroPaddingTop=" + this.f51676a + ", isInfoNeedBackground=" + this.f51677b + ", alphaTopVisible=" + this.f51678c + ", topBackgroundHeight=" + this.f51679d + ")";
    }

    public w0(int r100, boolean r101, boolean r102, int r103) {
        this.f51676a = r100;
        this.f51677b = r101;
        this.f51678c = r102;
        this.f51679d = r103;
    }
}
