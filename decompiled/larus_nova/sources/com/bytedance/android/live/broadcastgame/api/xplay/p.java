package com.bytedance.android.live.broadcastgame.api.xplay;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f59501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f59502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f59504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f59505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final XplayScene f59506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f59507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f59508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f59509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s f59510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j f59511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f59512l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f59513m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L32;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f59501a, r101.f59501a) == true) goto L8;
        return false;
    L8:
        if (this.f59502b == r101.f59502b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f59503c, r101.f59503c) == true) goto L12;
        return false;
    L12:
        if (this.f59504d == r101.f59504d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f59505e, r101.f59505e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f59506f, r101.f59506f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f59507g, r101.f59507g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f59508h, r101.f59508h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f59509i, r101.f59509i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f59510j, r101.f59510j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f59511k, r101.f59511k) == true) goto L28;
        return false;
    L28:
        if (this.f59512l == r101.f59512l) goto L30;
        return false;
    L30:
        if (this.f59513m == r101.f59513m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        Context r100 = this.f59501a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f59502b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f59503c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f59504d;
        ?? r109 = 1;
        ?? r110 = r108;
        if (r108 == false) goto L13;
        r110 = 1;
    L13:
        int r111 = (r107 + r110) * 31;
        String r112 = this.f59505e;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (r111 + r113) * 31;
        XplayScene r115 = this.f59506f;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f59507g;
        if (r118 == null) goto L24;
        int r119 = r118.hashCode();
    L25:
        int r120 = (r117 + r119) * 31;
        l r121 = this.f59508h;
        if (r121 == null) goto L28;
        int r122 = r121.hashCode();
    L29:
        int r123 = (r120 + r122) * 31;
        DataCenter r124 = this.f59509i;
        if (r124 == null) goto L32;
        int r125 = r124.hashCode();
    L33:
        int r126 = (r123 + r125) * 31;
        s r127 = this.f59510j;
        if (r127 == null) goto L36;
        int r128 = r127.hashCode();
    L37:
        int r129 = (r126 + r128) * 31;
        j r130 = this.f59511k;
        if (r130 == null) goto L40;
        r101 = r130.hashCode();
    L40:
        int r131 = (r129 + r101) * 31;
        boolean r132 = this.f59512l;
        ?? r133 = r132;
        if (r132 == false) goto L43;
        r133 = 1;
    L43:
        int r134 = (r131 + r133) * 31;
        boolean r135 = this.f59513m;
        if (r135 == true) goto L48;
        r109 = r135;
    L48:
        return r134 + r109;
    L36:
        r128 = 0;
        goto L37
    L32:
        r125 = 0;
        goto L33
    L28:
        r122 = 0;
        goto L29
    L24:
        r119 = 0;
        goto L25
    L20:
        r116 = 0;
        goto L21
    L16:
        r113 = 0;
        goto L17
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "XplayNewEnv(context=" + this.f59501a + ", roomId=" + this.f59502b + ", roomOwnerUserId=" + this.f59503c + ", isAnchor=" + this.f59504d + ", userId=" + this.f59505e + ", scene=" + this.f59506f + ", openId=" + this.f59507g + ", xplayGameItem=" + this.f59508h + ", dataCenter=" + this.f59509i + ", startExtra=" + this.f59510j + ", alogExtra=" + this.f59511k + ", showSeiDelay=" + this.f59512l + ", isSwitchGame=" + this.f59513m + ")";
    }

    public final Context getContext() {
        return this.f59501a;
    }

    public p(Context r110, long r111, String r112, boolean r113, String r210, XplayScene r211, String r212, l r213, DataCenter r214, s r215, j r216, boolean r217, boolean r218, int r219) {
        if ((r219 & 64) == 0) goto L5;
        String r100 = "";
    L6:
        j r101 = null;
        if ((r219 & 512) == 0) goto L9;
        s r102 = null;
    L11:
        if ((r219 & 1024) != 0) goto L14;
        r101 = r216;
    L14:
        boolean r114 = false;
        if ((r219 & 2048) == 0) goto L17;
        boolean r115 = false;
    L19:
        if ((r219 & 4096) != 0) goto L22;
        r114 = r218;
    L22:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "roomOwnerUserId");
        Intrinsics.checkNotNullParameter(r210, "userId");
        Intrinsics.checkNotNullParameter(r211, "scene");
        Intrinsics.checkNotNullParameter(r213, "xplayGameItem");
        this.f59501a = r110;
        this.f59502b = r111;
        this.f59503c = r112;
        this.f59504d = r113;
        this.f59505e = r210;
        this.f59506f = r211;
        this.f59507g = r100;
        this.f59508h = r213;
        this.f59509i = r214;
        this.f59510j = r102;
        this.f59511k = r101;
        this.f59512l = r115;
        this.f59513m = r114;
        return;
    L17:
        r115 = r217;
        goto L19
    L9:
        r102 = r215;
        goto L11
    L5:
        r100 = r212;
        goto L6
    }
}
