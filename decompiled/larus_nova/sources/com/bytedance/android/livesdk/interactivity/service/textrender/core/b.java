package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f141004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f141005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tb2.c f141006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final py.k f141007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f141008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f141009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f141010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final wb2.g f141011h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (this.f141004a == r101.f141004a) goto L8;
        return false;
    L8:
        if (this.f141005b == r101.f141005b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f141006c, r101.f141006c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f141007d, r101.f141007d) == true) goto L14;
        return false;
    L14:
        if (this.f141008e == r101.f141008e) goto L16;
        return false;
    L16:
        if (this.f141009f == r101.f141009f) goto L18;
        return false;
    L18:
        if (Float.compare(this.f141010g, r101.f141010g) == 0) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f141011h, r101.f141011h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f141004a * 31) + this.f141005b) * 31;
        tb2.c r101 = this.f141006c;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        py.k r105 = this.f141007d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((((((r104 + r106) * 31) + this.f141008e) * 31) + this.f141009f) * 31) + Float.floatToIntBits(this.f141010g)) * 31;
        wb2.g r108 = this.f141011h;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "AsyncPieceInfo(startIndex=" + this.f141004a + ", endIndex=" + this.f141005b + ", tar=" + this.f141006c + ", toloadImg=" + this.f141007d + ", w=" + this.f141008e + ", h=" + this.f141009f + ", scale=" + this.f141010g + ", placeHolderSpan=" + this.f141011h + ")";
    }

    public b(int r100, int r101, tb2.c r102, py.k r103, int r104, int r105, float r106, wb2.g r107) {
        Intrinsics.checkNotNullParameter(r102, "tar");
        this.f141004a = r100;
        this.f141005b = r101;
        this.f141006c = r102;
        this.f141007d = r103;
        this.f141008e = r104;
        this.f141009f = r105;
        this.f141010g = r106;
        this.f141011h = r107;
    }
}
