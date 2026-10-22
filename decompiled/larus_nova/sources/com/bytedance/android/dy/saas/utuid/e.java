package com.bytedance.android.dy.saas.utuid;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f42644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f42645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f42646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f42647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f42648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f42649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f42650g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L20;
        e r101 = (e) r100;
        if (this.f42644a == r101.f42644a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f42645b, r101.f42645b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f42646c, r101.f42646c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f42647d, r101.f42647d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f42648e, r101.f42648e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f42649f, r101.f42649f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f42650g, r101.f42650g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean r100 = this.f42644a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f42645b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f42646c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f42647d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f42648e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f42649f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f42650g;
        if (r119 == null) goto L29;
        r104 = r119.hashCode();
    L29:
        return r118 + r104;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "UtUidConfig(enable=" + this.f42644a + ", webcastAppId=" + this.f42645b + ", generalAppId=" + this.f42646c + ", partner=" + this.f42647d + ", partnerSecret=" + this.f42648e + ", originalPartner=" + this.f42649f + ", originalUUID=" + this.f42650g + ")";
    }

    public e(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.f42644a = r100;
        this.f42645b = r101;
        this.f42646c = r102;
        this.f42647d = r103;
        this.f42648e = r104;
        this.f42649f = r105;
        this.f42650g = r106;
    }
}
