package com.bytedance.android.gamecp.business.gamedetail.base.track;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f53504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f53505g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f53499a, r101.f53499a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53500b, r101.f53500b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53501c, r101.f53501c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53502d, r101.f53502d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53503e, r101.f53503e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53504f, r101.f53504f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53505g, r101.f53505g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f53499a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53500b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f53501c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f53502d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f53503e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f53504f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f53505g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoAdParams(adLogExtra=" + this.f53499a + ", groupId=" + this.f53500b + ", authorId=" + this.f53501c + ", anchorId=" + this.f53502d + ", anchorType=" + this.f53503e + ", value=" + this.f53504f + ", downloadStatus=" + this.f53505g + ")";
    }

    public b() {
        this("", "", "", "", "", "", "");
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.f53499a = r100;
        this.f53500b = r101;
        this.f53501c = r102;
        this.f53502d = r103;
        this.f53503e = r104;
        this.f53504f = r105;
        this.f53505g = r106;
    }
}
