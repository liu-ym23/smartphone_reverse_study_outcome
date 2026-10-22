package com.bytedance.android.gamecp.base.gamedetail;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l0 implements com.bytedance.ies.sve_core.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1 f51619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudienceReverseBtnConfig.b f51620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f51621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0 f51622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f51623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0 f51624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w0 f51625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f0 f51626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m0 f51627i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f51628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i0 f51629k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l0) == false) goto L28;
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f51619a, r101.f51619a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f51620b, r101.f51620b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f51621c, r101.f51621c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f51622d, r101.f51622d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f51623e, r101.f51623e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f51624f, r101.f51624f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f51625g, r101.f51625g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f51626h, r101.f51626h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f51627i, r101.f51627i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f51628j, r101.f51628j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f51629k, r101.f51629k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final String toString() {
        return "GameDetailPageStyleState(titleBarStyle=" + this.f51619a + ", orderBarStyle=" + this.f51620b + ", gameDetailStyle=" + this.f51621c + ", gameMultiTabStyle=" + this.f51622d + ", gameDetailTabStyle=" + this.f51623e + ", gameTabStyle=" + this.f51624f + ", orderGameDetailInfoStyle=" + this.f51625g + ", downloadItemStyle=" + this.f51626h + ", developerStyle=" + this.f51627i + ", itemLayoutStyle=" + this.f51628j + ", gameDetailDialogStyle=" + this.f51629k + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v38 */
    public final int hashCode() {
        a1 r100 = this.f51619a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AudienceReverseBtnConfig.b r104 = this.f51620b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k0 r107 = this.f51621c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        n0 r110 = this.f51622d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        j0 r113 = this.f51623e;
        if (r113 == null) goto L23;
        boolean r114 = r113.f51606a;
        ?? r115 = r114;
        if (r114 == false) goto L24;
        r115 = 1;
    L24:
        int r116 = (r112 + r115) * 31;
        o0 r117 = this.f51624f;
        if (r117 == null) goto L27;
        int r118 = r117.hashCode();
    L28:
        int r119 = (r116 + r118) * 31;
        w0 r120 = this.f51625g;
        if (r120 == null) goto L31;
        int r121 = r120.hashCode();
    L32:
        int r122 = (r119 + r121) * 31;
        f0 r123 = this.f51626h;
        if (r123 == null) goto L35;
        int r124 = r123.hashCode();
    L36:
        int r125 = (r122 + r124) * 31;
        m0 r126 = this.f51627i;
        if (r126 == null) goto L39;
        int r127 = r126.f51632a;
    L40:
        int r128 = (r125 + r127) * 31;
        c0 r129 = this.f51628j;
        if (r129 == null) goto L43;
        int r130 = r129.hashCode();
    L44:
        int r131 = (r128 + r130) * 31;
        i0 r132 = this.f51629k;
        if (r132 == null) goto L48;
        r101 = r132.hashCode();
    L48:
        return r131 + r101;
    L43:
        r130 = 0;
        goto L44
    L39:
        r127 = 0;
        goto L40
    L35:
        r124 = 0;
        goto L36
    L31:
        r121 = 0;
        goto L32
    L27:
        r118 = 0;
        goto L28
    L23:
        r115 = 0;
        goto L24
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

    public l0(a1 r100, AudienceReverseBtnConfig.b r101, k0 r102, n0 r103, j0 r104, o0 r105, w0 r106, f0 r107, m0 r110, c0 r111, i0 r112, int r113) {
        if ((r113 & 512) == 0) goto L6;
        r111 = new c0(0);
    L6:
        if ((r113 & 1024) == 0) goto L8;
        r112 = new i0(null, UnixStat.PERM_MASK);
    L8:
        Intrinsics.checkNotNullParameter(r100, "titleBarStyle");
        Intrinsics.checkNotNullParameter(r101, "orderBarStyle");
        Intrinsics.checkNotNullParameter(r102, "gameDetailStyle");
        Intrinsics.checkNotNullParameter(r103, "gameMultiTabStyle");
        Intrinsics.checkNotNullParameter(r104, "gameDetailTabStyle");
        Intrinsics.checkNotNullParameter(r105, "gameTabStyle");
        Intrinsics.checkNotNullParameter(r106, "orderGameDetailInfoStyle");
        Intrinsics.checkNotNullParameter(r107, "downloadItemStyle");
        Intrinsics.checkNotNullParameter(r110, "developerStyle");
        Intrinsics.checkNotNullParameter(r111, "itemLayoutStyle");
        Intrinsics.checkNotNullParameter(r112, "gameDetailDialogStyle");
        this.f51619a = r100;
        this.f51620b = r101;
        this.f51621c = r102;
        this.f51622d = r103;
        this.f51623e = r104;
        this.f51624f = r105;
        this.f51625g = r106;
        this.f51626h = r107;
        this.f51627i = r110;
        this.f51628j = r111;
        this.f51629k = r112;
    }
}
