package com.bytedance.android.gamecp.common.setting.config;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f56737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f56739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f56740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f56741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f56742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f56743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f56744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f56745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f56746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f56747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f56748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f56749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f56750n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f56751o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e2) == false) goto L36;
        e2 r101 = (e2) r100;
        if (this.f56737a == r101.f56737a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f56738b, r101.f56738b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f56739c, r101.f56739c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f56740d, r101.f56740d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f56741e, r101.f56741e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f56742f, r101.f56742f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f56743g, r101.f56743g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f56744h, r101.f56744h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f56745i, r101.f56745i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f56746j, r101.f56746j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f56747k, r101.f56747k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f56748l, r101.f56748l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f56749m, r101.f56749m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f56750n, r101.f56750n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f56751o, r101.f56751o) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    public final int hashCode() {
        boolean r100 = this.f56737a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f56738b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f56739c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f56740d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f56741e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f56742f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f56743g;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f56744h;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f56745i;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f56746j;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f56747k;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f56748l;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f56749m;
        if (r137 == null) goto L52;
        int r138 = r137.hashCode();
    L53:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f56750n;
        if (r140 == null) goto L56;
        int r141 = r140.hashCode();
    L57:
        int r142 = (r139 + r141) * 31;
        String r143 = this.f56751o;
        if (r143 == null) goto L61;
        r104 = r143.hashCode();
    L61:
        return r142 + r104;
    L56:
        r141 = 0;
        goto L57
    L52:
        r138 = 0;
        goto L53
    L48:
        r135 = 0;
        goto L49
    L44:
        r132 = 0;
        goto L45
    L40:
        r129 = 0;
        goto L41
    L36:
        r126 = 0;
        goto L37
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
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
        return "{isLiving=" + this.f56737a + ", liveType=" + this.f56738b + ", userId=" + this.f56739c + ", enterFrom=" + this.f56740d + ", anchorId=" + this.f56741e + ", roomId=" + this.f56742f + ", category=" + this.f56745i + ", promotionScene=" + this.f56746j + ", route=" + this.f56751o + '}';
    }

    public e2(String r100, String r101, String r102, String r103, Integer r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "liveType");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter("live_detail", "enterFrom");
        this.f56737a = true;
        this.f56738b = r100;
        this.f56739c = r101;
        this.f56740d = "live_detail";
        this.f56741e = r102;
        this.f56742f = r103;
        this.f56743g = "";
        this.f56744h = "";
        this.f56745i = null;
        this.f56746j = r104;
        this.f56747k = "live_detail";
        this.f56748l = "creator";
        this.f56749m = "";
        this.f56750n = "";
        this.f56751o = r105;
    }
}
