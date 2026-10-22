package com.bytedance.android.gamecp.base.core.service.depend;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f51438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f51439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f51440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f51441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f51442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f51443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f51444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f51445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f51446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f51447k;

    public x() {
        this(0, null, 0, null, 0, 0, 0, 0.0f, null, false, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L28;
        x r101 = (x) r100;
        if (this.f51437a == r101.f51437a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f51438b, r101.f51438b) == true) goto L10;
        return false;
    L10:
        if (this.f51439c == r101.f51439c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f51440d, r101.f51440d) == true) goto L14;
        return false;
    L14:
        if (this.f51441e == r101.f51441e) goto L16;
        return false;
    L16:
        if (this.f51442f == r101.f51442f) goto L18;
        return false;
    L18:
        if (this.f51443g == r101.f51443g) goto L20;
        return false;
    L20:
        if (Float.compare(this.f51444h, r101.f51444h) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f51445i, r101.f51445i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f51446j, r101.f51446j) == true) goto L26;
        return false;
    L26:
        if (this.f51447k == r101.f51447k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v22 */
    public final int hashCode() {
        int r100 = this.f51437a * 31;
        String r101 = this.f51438b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.f51439c) * 31;
        String r105 = this.f51440d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + this.f51441e) * 31;
        long r108 = this.f51442f;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f51443g;
        int r111 = (((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + Float.floatToIntBits(this.f51444h)) * 31;
        String r112 = this.f51445i;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f51446j;
        if (r115 == null) goto L17;
        r102 = r115.hashCode();
    L17:
        int r116 = (r114 + r102) * 31;
        boolean r117 = this.f51447k;
        ?? r118 = r117;
        if (r117 == false) goto L21;
        r118 = 1;
    L21:
        return r116 + r118;
    L13:
        r113 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "{progress=" + this.f51437a + ", speed=" + this.f51438b + ", lastRealSpeed=" + this.f51444h + ", progressTransformed=" + this.f51439c + ",speedTransformed=" + this.f51440d + ", disguisedProgress=" + this.f51441e + "},downloadRedeemText=" + this.f51445i;
    }

    public x(int r110, String r111, int r112, String r113, int r210, long r211, long r212, float r213, String r214, boolean r215, int r216) {
        boolean r100 = false;
        if ((r216 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        String r102 = "0Kb/s";
        if ((r216 & 2) == 0) goto L9;
        String r103 = "0Kb/s";
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r216 & 8) != 0) goto L19;
        r102 = r113;
    L19:
        if ((r216 & 16) == 0) goto L21;
        int r105 = 0;
    L22:
        long r106 = 0;
        if ((r216 & 32) == 0) goto L25;
        long r114 = 0;
    L27:
        if ((r216 & 64) != 0) goto L31;
        r106 = r212;
    L31:
        if ((r216 & 128) == 0) goto L33;
        float r107 = 0.0f;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r115 = "";
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r116 = "0";
    L43:
        if ((r216 & 1024) != 0) goto L46;
        r100 = r215;
    L46:
        Intrinsics.checkNotNullParameter(r103, "speed");
        Intrinsics.checkNotNullParameter(r102, "speedTransformed");
        Intrinsics.checkNotNullParameter(r115, "downloadRedeemText");
        Intrinsics.checkNotNullParameter(r116, "disguisedOptProgress");
        this.f51437a = r101;
        this.f51438b = r103;
        this.f51439c = r104;
        this.f51440d = r102;
        this.f51441e = r105;
        this.f51442f = r114;
        this.f51443g = r106;
        this.f51444h = r107;
        this.f51445i = r115;
        this.f51446j = r116;
        this.f51447k = r100;
        return;
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L25:
        r114 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L22
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
