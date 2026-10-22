package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f51612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f51613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51614d;

    public k0() {
        this(0, false, false, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k0) == false) goto L14;
        k0 r101 = (k0) r100;
        if (this.f51611a == r101.f51611a) goto L8;
        return false;
    L8:
        if (this.f51612b == r101.f51612b) goto L10;
        return false;
    L10:
        if (this.f51613c == r101.f51613c) goto L12;
        return false;
    L12:
        if (this.f51614d == r101.f51614d) goto L22;
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
        int r100 = this.f51611a * 31;
        boolean r101 = this.f51612b;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f51613c;
        if (r105 == true) goto L10;
        r102 = r105;
    L10:
        return ((r104 + r102) * 31) + this.f51614d;
    }

    public final String toString() {
        return "GameDetailInfoUIStyle(gameIntroPaddingTop=" + this.f51611a + ", isInfoNeedBackground=" + this.f51612b + ", alphaTopVisible=" + this.f51613c + ", topBackgroundHeight=" + this.f51614d + ")";
    }

    public k0(int r100, boolean r101, boolean r102, int r103) {
        this.f51611a = r100;
        this.f51612b = r101;
        this.f51613c = r102;
        this.f51614d = r103;
    }
}
