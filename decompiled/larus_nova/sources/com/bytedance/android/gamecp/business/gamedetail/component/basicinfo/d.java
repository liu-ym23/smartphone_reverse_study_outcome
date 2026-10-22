package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f f53680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f53685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f53686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f53687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f53688i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f53680a, r101.f53680a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53681b, r101.f53681b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53682c, r101.f53682c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53683d, r101.f53683d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53684e, r101.f53684e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53685f, r101.f53685f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53686g, r101.f53686g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f53687h, r101.f53687h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53688i, r101.f53688i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r100 = this.f53680a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53681b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f53682c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f53683d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f53684e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f53685f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f53686g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f53687h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f53688i;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "AudienceGameDetailInfoV5FiveElement(officialAccountInfo=" + this.f53680a + ", company=" + this.f53681b + ", ageLimit=" + this.f53682c + ", version=" + this.f53683d + ", packageSize=" + this.f53684e + ", authorizationUrl=" + this.f53685f + ", privacyUrl=" + this.f53686g + ", icpRegistration=" + this.f53687h + ", icpFillingEntityName=" + this.f53688i + ")";
    }

    public d(com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108) {
        this.f53680a = r100;
        this.f53681b = r101;
        this.f53682c = r102;
        this.f53683d = r103;
        this.f53684e = r104;
        this.f53685f = r105;
        this.f53686g = r106;
        this.f53687h = r107;
        this.f53688i = r108;
    }
}
