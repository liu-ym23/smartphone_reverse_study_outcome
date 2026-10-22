package com.bytedance.android.live.broadcastgame.api.openplatform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f59392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f59395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f59396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f59397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f59398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f59399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f59400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f59401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f59402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f59403l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L30;
        a r101 = (a) r100;
        if (this.f59392a == r101.f59392a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59393b, r101.f59393b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f59394c, r101.f59394c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f59395d, r101.f59395d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f59396e, r101.f59396e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f59397f, r101.f59397f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f59398g, r101.f59398g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f59399h, r101.f59399h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f59400i, r101.f59400i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f59401j, r101.f59401j) == true) goto L26;
        return false;
    L26:
        if (this.f59402k == r101.f59402k) goto L28;
        return false;
    L28:
        if (this.f59403l == r101.f59403l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f59392a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f59393b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f59394c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f59395d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f59396e;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f59397f;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f59398g;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f59399h;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f59400i;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        Long r129 = this.f59401j;
        if (r129 == null) goto L40;
        r105 = r129.hashCode();
    L40:
        int r130 = (((r128 + r105) * 31) + this.f59402k) * 31;
        boolean r131 = this.f59403l;
        if (r131 == true) goto L45;
        r101 = r131;
    L45:
        return r130 + r101;
    L36:
        r127 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "GameIntroCardInfo(show=" + this.f59392a + ", icon=" + this.f59393b + ", backImage=" + this.f59394c + ", appName=" + this.f59395d + ", title=" + this.f59396e + ", description=" + this.f59397f + ", btnText=" + this.f59398g + ", backColor=" + this.f59399h + ", url=" + this.f59400i + ", duration=" + this.f59401j + ", manualCloseTime=" + this.f59402k + ", autoLaunch=" + this.f59403l + ")";
    }

    public static a a(a r110, String r111, String r112, String r210, int r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        boolean r100 = r110.f59392a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.f59393b;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.f59394c;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.f59395d;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.f59396e;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r113 = r110.f59397f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r114 = r110.f59398g;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r115 = r110.f59399h;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r116 = r110.f59400i;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Long r117 = r110.f59401j;
    L43:
        if ((r212 & 1024) == 0) goto L45;
        int r118 = r110.f59402k;
    L47:
        if ((r212 & 2048) == 0) goto L49;
        boolean r119 = r110.f59403l;
    L50:
        r110.getClass();
        return new a(r100, r101, r102, r103, r104, r113, r114, r115, r116, r117, r118, r119);
    L49:
        r119 = false;
        goto L50
    L45:
        r118 = r211;
        goto L47
    L41:
        r117 = null;
        goto L43
    L37:
        r116 = r210;
        goto L39
    L33:
        r115 = null;
        goto L35
    L29:
        r114 = null;
        goto L31
    L25:
        r113 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r112;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public a(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, Long r110, int r111, boolean r112) {
        this.f59392a = r100;
        this.f59393b = r101;
        this.f59394c = r102;
        this.f59395d = r103;
        this.f59396e = r104;
        this.f59397f = r105;
        this.f59398g = r106;
        this.f59399h = r107;
        this.f59400i = r108;
        this.f59401j = r110;
        this.f59402k = r111;
        this.f59403l = r112;
    }
}
