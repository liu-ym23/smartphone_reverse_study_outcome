package com.bytedance.android.live.revlink.link.core.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f98372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f98373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f98374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f98375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f98376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f98377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f98378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f98379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f98380j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L26;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f98371a, r101.f98371a) == true) goto L8;
        return false;
    L8:
        if (this.f98372b == r101.f98372b) goto L10;
        return false;
    L10:
        if (this.f98373c == r101.f98373c) goto L12;
        return false;
    L12:
        if (this.f98374d == r101.f98374d) goto L14;
        return false;
    L14:
        if (this.f98375e == r101.f98375e) goto L16;
        return false;
    L16:
        if (this.f98376f == r101.f98376f) goto L18;
        return false;
    L18:
        if (this.f98377g == r101.f98377g) goto L20;
        return false;
    L20:
        if (this.f98378h == r101.f98378h) goto L22;
        return false;
    L22:
        if (this.f98379i == r101.f98379i) goto L24;
        return false;
    L24:
        if (this.f98380j == r101.f98380j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        String r100 = this.f98371a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((((((((((((((r101 * 31) + this.f98372b) * 31) + this.f98373c) * 31) + this.f98374d) * 31) + this.f98375e) * 31) + this.f98376f) * 31) + this.f98377g) * 31) + this.f98378h) * 31;
        boolean r103 = this.f98379i;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f98380j;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return r106 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "LayoutState(streamID=" + this.f98371a + ", x=" + this.f98372b + ", y=" + this.f98373c + ", w=" + this.f98374d + ", h=" + this.f98375e + ", position=" + this.f98376f + ", zOrder=" + this.f98377g + ", type=" + this.f98378h + ", visible=" + this.f98379i + ", realWindow=" + this.f98380j + ")";
    }

    public final int getType() {
        return this.f98378h;
    }

    public q(String r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "streamID");
        this.f98371a = r100;
        this.f98372b = r101;
        this.f98373c = r102;
        this.f98374d = r103;
        this.f98375e = r104;
        this.f98376f = r105;
        this.f98377g = r106;
        this.f98378h = r107;
        this.f98379i = r110;
        this.f98380j = r111;
    }
}
