package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f78793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f78795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f78796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f78797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f78798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f78799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IRoom f78800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f78801i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f78802j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f78803k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f78804l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f78805m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f78806n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, String> f78807o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m0) == false) goto L36;
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f78793a, r101.f78793a) == true) goto L8;
        return false;
    L8:
        if (this.f78794b == r101.f78794b) goto L10;
        return false;
    L10:
        if (this.f78795c == r101.f78795c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f78796d, r101.f78796d) == true) goto L14;
        return false;
    L14:
        if (this.f78797e == r101.f78797e) goto L16;
        return false;
    L16:
        if (this.f78798f == r101.f78798f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f78799g, r101.f78799g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f78800h, r101.f78800h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f78801i, r101.f78801i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f78802j, r101.f78802j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f78803k, r101.f78803k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f78804l, r101.f78804l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f78805m, r101.f78805m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f78806n, r101.f78806n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f78807o, r101.f78807o) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f78793a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f78794b) * 31;
        boolean r104 = this.f78795c;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f78796d;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f78797e;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f78798f;
        if (r114 == true) goto L20;
        r105 = r114;
    L20:
        int r115 = (r113 + r105) * 31;
        String r116 = this.f78799g;
        if (r116 == null) goto L23;
        int r117 = r116.hashCode();
    L24:
        int r118 = (r115 + r117) * 31;
        IRoom r119 = this.f78800h;
        if (r119 == null) goto L27;
        int r120 = r119.hashCode();
    L28:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f78801i;
        if (r122 == null) goto L31;
        int r123 = r122.hashCode();
    L32:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.f78802j;
        if (r125 == null) goto L35;
        int r126 = r125.hashCode();
    L36:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f78803k;
        if (r128 == null) goto L39;
        int r129 = r128.hashCode();
    L40:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f78804l;
        if (r131 == null) goto L43;
        int r132 = r131.hashCode();
    L44:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.f78805m;
        if (r134 == null) goto L47;
        int r135 = r134.hashCode();
    L48:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f78806n;
        if (r137 == null) goto L51;
        int r138 = r137.hashCode();
    L52:
        int r139 = (r136 + r138) * 31;
        Map<String, String> r140 = this.f78807o;
        if (r140 == null) goto L56;
        r101 = r140.hashCode();
    L56:
        return r139 + r101;
    L51:
        r138 = 0;
        goto L52
    L47:
        r135 = 0;
        goto L48
    L43:
        r132 = 0;
        goto L44
    L39:
        r129 = 0;
        goto L40
    L35:
        r126 = 0;
        goto L36
    L31:
        r123 = 0;
        goto L32
    L27:
        r120 = 0;
        goto L28
    L23:
        r117 = 0;
        goto L24
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LogParamsWithPk(connectionType=" + this.f78793a + ", applySource=" + this.f78794b + ", isAutoJoin=" + this.f78795c + ", linkCnt=" + this.f78796d + ", isFollowApply=" + this.f78797e + ", isCameraOpen=" + this.f78798f + ", isQuickInvite=" + this.f78799g + ", room=" + this.f78800h + ", functionType=" + this.f78801i + ", waitTime=" + this.f78802j + ", overType=" + this.f78803k + ", breakPage=" + this.f78804l + ", connectionDuration=" + this.f78805m + ", cameraDuration=" + this.f78806n + ", logMap=" + this.f78807o + ")";
    }

    public /* synthetic */ m0(String r210, int r211, boolean r212, String r213, boolean r214, boolean r215, String r216, IRoom r217, String r218, Long r219, Map r310, int r311) {
        if ((r311 & 256) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r311 & 512) == 0) goto L9;
        Long r111 = null;
    L11:
        if ((r311 & 1024) == 0) goto L13;
        String r112 = "";
    L15:
        if ((r311 & 2048) == 0) goto L17;
        String r113 = "";
    L19:
        if ((r311 & 4096) == 0) goto L21;
        Long r114 = 0L;
    L23:
        if ((r311 & 16384) == 0) goto L25;
        Map r115 = null;
    L26:
        this(r210, r211, r212, r213, r214, r215, r216, r217, r110, r111, r112, r113, r114, null, r115);
        return;
    L25:
        r115 = r310;
        goto L26
    L21:
        r114 = null;
        goto L23
    L17:
        r113 = null;
        goto L19
    L13:
        r112 = null;
        goto L15
    L9:
        r111 = r219;
        goto L11
    L5:
        r110 = r218;
        goto L7
    }

    public m0(String r100, int r101, boolean r102, String r103, boolean r104, boolean r110, String r111, IRoom r112, String r113, Long r114, String r115, String r116, Long r117, String r118, Map<String, String> r119) {
        Intrinsics.checkNotNullParameter(r103, "linkCnt");
        Intrinsics.checkNotNullParameter(r111, "isQuickInvite");
        this.f78793a = r100;
        this.f78794b = r101;
        this.f78795c = r102;
        this.f78796d = r103;
        this.f78797e = r104;
        this.f78798f = r110;
        this.f78799g = r111;
        this.f78800h = r112;
        this.f78801i = r113;
        this.f78802j = r114;
        this.f78803k = r115;
        this.f78804l = r116;
        this.f78805m = r117;
        this.f78806n = r118;
        this.f78807o = r119;
    }
}
