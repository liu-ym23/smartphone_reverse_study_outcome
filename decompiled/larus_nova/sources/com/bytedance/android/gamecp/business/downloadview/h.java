package com.bytedance.android.gamecp.business.downloadview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f53044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f53045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f53046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f53048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f53049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f53050i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L24;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f53042a, r101.f53042a) == true) goto L8;
        return false;
    L8:
        if (this.f53043b == r101.f53043b) goto L10;
        return false;
    L10:
        if (this.f53044c == r101.f53044c) goto L12;
        return false;
    L12:
        if (this.f53045d == r101.f53045d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53046e, r101.f53046e) == true) goto L16;
        return false;
    L16:
        if (this.f53047f == r101.f53047f) goto L18;
        return false;
    L18:
        if (this.f53048g == r101.f53048g) goto L20;
        return false;
    L20:
        if (this.f53049h == r101.f53049h) goto L22;
        return false;
    L22:
        if (this.f53050i == r101.f53050i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f53042a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((r102 * 31) + this.f53043b) * 31) + this.f53044c) * 31) + this.f53045d) * 31;
        Integer r104 = this.f53046e;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((((((((r103 + r101) * 31) + this.f53047f) * 31) + this.f53048g) * 31) + this.f53049h) * 31) + this.f53050i;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DownloadTextInfo(text=" + this.f53042a + ", textSize=" + this.f53043b + ", textSizeUnit=" + this.f53044c + ", textFontWeight=" + this.f53045d + ", textColor=" + this.f53046e + ", leftMargin=" + this.f53047f + ", rightMargin=" + this.f53048g + ", topMargin=" + this.f53049h + ", bottomMargin=" + this.f53050i + ")";
    }

    public h() {
        this("", 0, 0, 0, null, 0, 0, 0, 0);
    }

    public h(String r100, int r101, int r102, int r103, Integer r104, int r105, int r106, int r107, int r110) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f53042a = r100;
        this.f53043b = r101;
        this.f53044c = r102;
        this.f53045d = r103;
        this.f53046e = r104;
        this.f53047f = r105;
        this.f53048g = r106;
        this.f53049h = r107;
        this.f53050i = r110;
    }
}
