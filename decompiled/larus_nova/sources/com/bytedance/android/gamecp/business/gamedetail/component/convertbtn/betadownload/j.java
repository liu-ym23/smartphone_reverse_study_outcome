package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements com.bytedance.ies.sve_core.s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f54012h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f54013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f54016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f54017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f54019g;

    public static final class a {
        public static com.bytedance.ies.sve_core.u a() {
            return new com.bytedance.ies.sve_core.u("game_qualification_state");
        }
    }

    static {
    }

    public j() {
        this(false, "", 0, false, 0, "", false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L20;
        j r101 = (j) r100;
        if (this.f54013a == r101.f54013a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54014b, r101.f54014b) == true) goto L10;
        return false;
    L10:
        if (this.f54015c == r101.f54015c) goto L12;
        return false;
    L12:
        if (this.f54016d == r101.f54016d) goto L14;
        return false;
    L14:
        if (this.f54017e == r101.f54017e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54018f, r101.f54018f) == true) goto L18;
        return false;
    L18:
        if (this.f54019g == r101.f54019g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f54013a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f54014b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (((r103 + r106) * 31) + this.f54015c) * 31;
        boolean r108 = this.f54016d;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (((r107 + r109) * 31) + this.f54017e) * 31;
        String r111 = this.f54018f;
        if (r111 == null) goto L15;
        r105 = r111.hashCode();
    L15:
        int r112 = (r110 + r105) * 31;
        boolean r113 = this.f54019g;
        if (r113 == true) goto L20;
        r101 = r113;
    L20:
        return r112 + r101;
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "BetaDownloadQualificationState(showLoading=" + this.f54013a + ", planId=" + this.f54014b + ", reservedStatus=" + this.f54015c + ", isQualified=" + this.f54016d + ", testQualificationType=" + this.f54017e + ", activationCode=" + this.f54018f + ", onBetaQualificationReady=" + this.f54019g + ")";
    }

    public static j c(j r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        boolean r100 = r110.f54013a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r101 = r110.f54014b;
    L11:
        if ((r112 & 4) == 0) goto L13;
        r111 = r110.f54015c;
    L13:
        int r102 = r111;
        if ((r112 & 8) == 0) goto L16;
        boolean r103 = r110.f54016d;
    L18:
        if ((r112 & 16) == 0) goto L20;
        int r104 = r110.f54017e;
    L22:
        if ((r112 & 32) == 0) goto L24;
        String r105 = r110.f54018f;
    L26:
        if ((r112 & 64) == 0) goto L28;
        boolean r106 = r110.f54019g;
    L29:
        r110.getClass();
        return new j(r100, r101, r102, r103, r104, r105, r106);
    L28:
        r106 = false;
        goto L29
    L24:
        r105 = null;
        goto L26
    L20:
        r104 = 0;
        goto L22
    L16:
        r103 = false;
        goto L18
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public j(boolean r100, String r101, int r102, boolean r103, int r104, String r105, boolean r106) {
        this.f54013a = r100;
        this.f54014b = r101;
        this.f54015c = r102;
        this.f54016d = r103;
        this.f54017e = r104;
        this.f54018f = r105;
        this.f54019g = r106;
    }
}
