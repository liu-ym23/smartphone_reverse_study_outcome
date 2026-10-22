package com.bytedance.android.ecom.arch.slice.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f50691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f50692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f50693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f50694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f50695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f50696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f50697g;

    public p() {
        this(null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L20;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f50691a, r101.f50691a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f50692b, r101.f50692b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f50693c, r101.f50693c) == true) goto L12;
        return false;
    L12:
        if (this.f50694d == r101.f50694d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f50695e, r101.f50695e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f50696f, r101.f50696f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f50697g, r101.f50697g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f50691a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f50692b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f50693c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f50694d;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.f50695e;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f50696f;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f50697g;
        if (r118 == null) goto L26;
        r101 = r118.hashCode();
    L26:
        return r117 + r101;
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
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
        return "SlcTemplateInfo(url=" + this.f50691a + ", name=" + this.f50692b + ", version=" + this.f50693c + ", geckoVersion=" + this.f50694d + ", templateFrom=" + this.f50695e + ", loadSeq=" + this.f50696f + ", templateJsonStr=" + this.f50697g + ")";
    }

    public /* synthetic */ p(String r110, String r111, String r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r114 & 16) == 0) goto L17;
        String r103 = null;
    L18:
        this(r100, r101, r102, 0, r103, null, null);
        return;
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public p(String r100, String r101, String r102, long r103, String r104, String r105, String r106) {
        this.f50691a = r100;
        this.f50692b = r101;
        this.f50693c = r102;
        this.f50694d = r103;
        this.f50695e = r104;
        this.f50696f = r105;
        this.f50697g = r106;
    }
}
