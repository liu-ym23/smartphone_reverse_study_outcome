package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f51635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f51636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f51637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f51639e;

    /* JADX WARN: Multi-variable type inference failed */
    public n0() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(false, r100, r101, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L16;
        n0 r101 = (n0) r100;
        if (this.f51635a == r101.f51635a) goto L8;
        return false;
    L8:
        if (this.f51636b == r101.f51636b) goto L10;
        return false;
    L10:
        if (this.f51637c == r101.f51637c) goto L12;
        return false;
    L12:
        if (this.f51638d == r101.f51638d) goto L14;
        return false;
    L14:
        if (this.f51639e == r101.f51639e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        boolean r100 = this.f51635a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f51636b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (((((r103 + r105) * 31) + this.f51637c) * 31) + this.f51638d) * 31;
        boolean r107 = this.f51639e;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public final String toString() {
        return "GameMultiTabUIStyle(isSkipDrawDecoration=" + this.f51635a + ", isShowTopDragWidget=" + this.f51636b + ", offset=" + this.f51637c + ", paddingTop=" + this.f51638d + ", setPaddingTopAfterLoading=" + this.f51639e + ")";
    }

    public /* synthetic */ n0(boolean r100, boolean r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r112 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r112 & 4) == 0) goto L13;
        int r103 = 0;
    L14:
        this(r101, r102, r103, 0, false);
        return;
    L13:
        r103 = r111;
        goto L14
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public n0(boolean r100, boolean r101, int r102, int r103, boolean r104) {
        this.f51635a = r100;
        this.f51636b = r101;
        this.f51637c = r102;
        this.f51638d = r103;
        this.f51639e = r104;
    }
}
