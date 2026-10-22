package com.bytedance.android.live.profit.dress;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class v extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f87181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f87182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f87183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final py.k f87184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final py.k f87185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final py.k f87186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final py.k f87187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.d f87188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final py.k f87189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.d f87190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final py.k f87191k;

    public final int hashCode() {
        long r100 = this.f87181a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f87182b;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f87183c) * 31;
        py.k r104 = this.f87184d;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        py.k r108 = this.f87185e;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        py.k r111 = this.f87186f;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        py.k r114 = this.f87187g;
        if (r114 == null) goto L17;
        int r115 = r114.hashCode();
    L18:
        int r116 = (r113 + r115) * 31;
        com.bytedance.android.live.base.model.d r117 = this.f87188h;
        if (r117 == null) goto L21;
        int r118 = r117.hashCode();
    L22:
        int r119 = (r116 + r118) * 31;
        py.k r120 = this.f87189i;
        if (r120 == null) goto L25;
        int r121 = r120.hashCode();
    L26:
        int r122 = (r119 + r121) * 31;
        com.bytedance.android.live.base.model.d r123 = this.f87190j;
        if (r123 == null) goto L29;
        int r124 = r123.hashCode();
    L30:
        int r125 = (r122 + r124) * 31;
        py.k r126 = this.f87191k;
        if (r126 == null) goto L34;
        r105 = r126.hashCode();
    L34:
        return r125 + r105;
    L29:
        r124 = 0;
        goto L30
    L25:
        r121 = 0;
        goto L26
    L21:
        r118 = 0;
        goto L22
    L17:
        r115 = 0;
        goto L18
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "ProfileSkinDress(parallaxAssetId=" + this.f87181a + ", otherAssetId=" + this.f87182b + ", flashCardAssetId=" + this.f87183c + ", panelBgPng=" + this.f87184d + ", panelEnterWebp=" + this.f87185e + ", panelLoopWebp=" + this.f87186f + ", panelRightPng=" + this.f87187g + ", border9Png=" + this.f87188h + ", borderPng=" + this.f87189i + ", mainButton9Png=" + this.f87190j + ", mainButtonWebp=" + this.f87191k + ")";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L28;
        v r101 = (v) r100;
        if (this.f87181a == r101.f87181a) goto L8;
        return false;
    L8:
        if (this.f87182b == r101.f87182b) goto L10;
        return false;
    L10:
        if (this.f87183c == r101.f87183c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f87184d, r101.f87184d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f87185e, r101.f87185e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f87186f, r101.f87186f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f87187g, r101.f87187g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f87188h, r101.f87188h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f87189i, r101.f87189i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f87190j, r101.f87190j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f87191k, r101.f87191k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public v(long r100, long r101, int r102, py.k r103, py.k r104, py.k r105, py.k r106, com.bytedance.android.live.base.model.d r110, py.k r111, com.bytedance.android.live.base.model.d r112, py.k r113) {
        this.f87181a = r100;
        this.f87182b = r101;
        this.f87183c = r102;
        this.f87184d = r103;
        this.f87185e = r104;
        this.f87186f = r105;
        this.f87187g = r106;
        this.f87188h = r110;
        this.f87189i = r111;
        this.f87190j = r112;
        this.f87191k = r113;
    }
}
