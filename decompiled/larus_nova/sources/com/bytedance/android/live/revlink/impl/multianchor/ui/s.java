package com.bytedance.android.live.revlink.impl.multianchor.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f94821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f94822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f94823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f94824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f94825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f94826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f94827g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L20;
        s r101 = (s) r100;
        if (this.f94821a == r101.f94821a) goto L8;
        return false;
    L8:
        if (this.f94822b == r101.f94822b) goto L10;
        return false;
    L10:
        if (this.f94823c == r101.f94823c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f94824d, r101.f94824d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f94825e, r101.f94825e) == true) goto L16;
        return false;
    L16:
        if (this.f94826f == r101.f94826f) goto L18;
        return false;
    L18:
        if (this.f94827g == r101.f94827g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        int r100 = ((this.f94821a * 31) + this.f94822b) * 31;
        boolean r101 = this.f94823c;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        c r104 = this.f94824d;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        d r108 = this.f94825e;
        if (r108 == null) goto L13;
        r105 = r108.hashCode();
    L13:
        return ((((r107 + r105) * 31) + this.f94826f) * 31) + this.f94827g;
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "PkBarLayoutParams(width=" + this.f94821a + ", height=" + this.f94822b + ", isFloat=" + this.f94823c + ", fixParam=" + this.f94824d + ", floatOffset=" + this.f94825e + ", horizontalContentMargin=" + this.f94826f + ", horizontalScreenMargin=" + this.f94827g + ")";
    }

    public s(int r100, int r101, boolean r102, c r103, d r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r103, "fixParam");
        Intrinsics.checkNotNullParameter(r104, "floatOffset");
        this.f94821a = r100;
        this.f94822b = r101;
        this.f94823c = r102;
        this.f94824d = r103;
        this.f94825e = r104;
        this.f94826f = r105;
        this.f94827g = r106;
    }
}
