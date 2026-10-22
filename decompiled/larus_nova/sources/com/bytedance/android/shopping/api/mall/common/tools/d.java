package com.bytedance.android.shopping.api.mall.common.tools;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f170426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f170427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f170428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f170429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f170430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f170431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f170432g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (this.f170426a == r101.f170426a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170427b, r101.f170427b) == true) goto L10;
        return false;
    L10:
        if (this.f170428c == r101.f170428c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170429d, r101.f170429d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f170430e, r101.f170430e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f170431f, r101.f170431f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f170432g, r101.f170432g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f170426a * 31;
        String r101 = this.f170427b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.f170428c) * 31;
        Integer r105 = this.f170429d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Boolean r108 = this.f170430e;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f170431f;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f170432g;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "CategoryTabItem(tabId=" + this.f170426a + ", tabName=" + this.f170427b + ", order=" + this.f170428c + ", tabType=" + this.f170429d + ", isHybrid=" + this.f170430e + ", hybridMetaStr=" + this.f170431f + ", titleText=" + this.f170432g + ")";
    }

    public d(int r100, String r101, int r102, Integer r103, Boolean r104, String r105, String r106) {
        this.f170426a = r100;
        this.f170427b = r101;
        this.f170428c = r102;
        this.f170429d = r103;
        this.f170430e = r104;
        this.f170431f = r105;
        this.f170432g = r106;
    }
}
