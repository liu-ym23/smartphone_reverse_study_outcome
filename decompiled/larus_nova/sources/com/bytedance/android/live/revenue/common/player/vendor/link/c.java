package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f90963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f90964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f90965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f90966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f90967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f90968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f90969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f90970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f90971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RevSeiFrame f90972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f90973k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f90974l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f90975m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L32;
        c r101 = (c) r100;
        if (this.f90963a == r101.f90963a) goto L8;
        return false;
    L8:
        if (this.f90964b == r101.f90964b) goto L10;
        return false;
    L10:
        if (this.f90965c == r101.f90965c) goto L12;
        return false;
    L12:
        if (this.f90966d == r101.f90966d) goto L14;
        return false;
    L14:
        if (this.f90967e == r101.f90967e) goto L16;
        return false;
    L16:
        if (this.f90968f == r101.f90968f) goto L18;
        return false;
    L18:
        if (this.f90969g == r101.f90969g) goto L20;
        return false;
    L20:
        if (this.f90970h == r101.f90970h) goto L22;
        return false;
    L22:
        if (this.f90971i == r101.f90971i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f90972j, r101.f90972j) == true) goto L26;
        return false;
    L26:
        if (this.f90973k == r101.f90973k) goto L28;
        return false;
    L28:
        if (this.f90974l == r101.f90974l) goto L30;
        return false;
    L30:
        if (this.f90975m == r101.f90975m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f90963a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f90964b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f90965c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (((((((((((r106 + r108) * 31) + this.f90966d) * 31) + this.f90967e) * 31) + this.f90968f) * 31) + this.f90969g) * 31) + this.f90970h) * 31;
        boolean r110 = this.f90971i;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        RevSeiFrame r113 = this.f90972j;
        if (r113 == null) goto L17;
        int r114 = r113.hashCode();
    L18:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f90973k;
        ?? r117 = r116;
        if (r116 == false) goto L21;
        r117 = 1;
    L21:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f90974l;
        ?? r120 = r119;
        if (r119 == false) goto L24;
        r120 = 1;
    L24:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f90975m;
        if (r122 == true) goto L29;
        r101 = r122;
    L29:
        return r121 + r101;
    L17:
        r114 = 0;
        goto L18
    }

    public final String toString() {
        return "StrategyReduceContext(isPad=" + this.f90963a + ", isFoldScreenFullType=" + this.f90964b + ", isPortrait=" + this.f90965c + ", containerWidth=" + this.f90966d + ", containerHeight=" + this.f90967e + ", videoWidth=" + this.f90968f + ", videoHeight=" + this.f90969g + ", topOffset=" + this.f90970h + ", hasStatusBar=" + this.f90971i + ", seiFrame=" + this.f90972j + ", isPcVrRoom=" + this.f90973k + ", isLiveTypeAudio=" + this.f90974l + ", isScreenRecord=" + this.f90975m + ")";
    }

    public c(boolean r100, boolean r101, boolean r102, int r103, int r104, int r105, int r106, int r107, RevSeiFrame r110, boolean r111, boolean r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "seiFrame");
        this.f90963a = r100;
        this.f90964b = r101;
        this.f90965c = r102;
        this.f90966d = r103;
        this.f90967e = r104;
        this.f90968f = r105;
        this.f90969g = r106;
        this.f90970h = r107;
        this.f90971i = true;
        this.f90972j = r110;
        this.f90973k = r111;
        this.f90974l = r112;
        this.f90975m = r113;
    }
}
