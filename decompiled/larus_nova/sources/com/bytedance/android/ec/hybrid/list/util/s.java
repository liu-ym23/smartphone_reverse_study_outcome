package com.bytedance.android.ec.hybrid.list.util;

/* JADX INFO: loaded from: classes44.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f47357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f47358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f47359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f47360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f47361e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L16;
        s r101 = (s) r100;
        if (Double.compare(this.f47357a, r101.f47357a) == 0) goto L8;
        return false;
    L8:
        if (this.f47358b == r101.f47358b) goto L10;
        return false;
    L10:
        if (this.f47359c == r101.f47359c) goto L12;
        return false;
    L12:
        if (this.f47360d == r101.f47360d) goto L14;
        return false;
    L14:
        if (this.f47361e == r101.f47361e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f47357a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f47358b;
        ?? r103 = 1;
        ?? r104 = r102;
        if (r102 == false) goto L5;
        r104 = 1;
    L5:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.f47359c;
        ?? r107 = r106;
        if (r106 == false) goto L8;
        r107 = 1;
    L8:
        int r108 = (r105 + r107) * 31;
        boolean r109 = this.f47360d;
        ?? r110 = r109;
        if (r109 == false) goto L11;
        r110 = 1;
    L11:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.f47361e;
        if (r112 == true) goto L16;
        r103 = r112;
    L16:
        return r111 + r103;
    }

    public final String toString() {
        return "ViewVisibilityInfo(visiblePercent=" + this.f47357a + ", isLeftBlocked=" + this.f47358b + ", isRightBlocked=" + this.f47359c + ", isTopBlocked=" + this.f47360d + ", isBottomBlocked=" + this.f47361e + ")";
    }

    public s(double r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f47357a = r100;
        this.f47358b = r101;
        this.f47359c = r102;
        this.f47360d = r103;
        this.f47361e = r104;
    }
}
