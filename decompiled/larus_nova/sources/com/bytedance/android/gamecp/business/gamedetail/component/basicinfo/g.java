package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.o f53706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f f53707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f53711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f53712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f53713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<f1.b> f53714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f53715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f53716k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L28;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f53706a, r101.f53706a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53707b, r101.f53707b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53708c, r101.f53708c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53709d, r101.f53709d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53710e, r101.f53710e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53711f, r101.f53711f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53712g, r101.f53712g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f53713h, r101.f53713h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53714i, r101.f53714i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f53715j, r101.f53715j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f53716k, r101.f53716k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.gamecp.business.gamedetail.base.model.o r100 = this.f53706a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r104 = this.f53707b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f53708c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f53709d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f53710e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f53711f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f53712g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f53713h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<f1.b> r125 = this.f53714i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f53715j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f53716k;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
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
        return "AudienceGameDetailInfoV6FiveElement(officialSamePackageTips=" + this.f53706a + ", officialAccountInfo=" + this.f53707b + ", company=" + this.f53708c + ", ageLimit=" + this.f53709d + ", version=" + this.f53710e + ", packageSize=" + this.f53711f + ", authorizationUrl=" + this.f53712g + ", privacyUrl=" + this.f53713h + ", pcConfigsInfo=" + this.f53714i + ", icpRegistration=" + this.f53715j + ", icpFillingEntityName=" + this.f53716k + ")";
    }

    public g(com.bytedance.android.gamecp.business.gamedetail.base.model.o r100, com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r101, String r102, String r103, String r104, String r105, String r106, String r107, List<f1.b> r108, String r110, String r111) {
        this.f53706a = r100;
        this.f53707b = r101;
        this.f53708c = r102;
        this.f53709d = r103;
        this.f53710e = r104;
        this.f53711f = r105;
        this.f53712g = r106;
        this.f53713h = r107;
        this.f53714i = r108;
        this.f53715j = r110;
        this.f53716k = r111;
    }
}
