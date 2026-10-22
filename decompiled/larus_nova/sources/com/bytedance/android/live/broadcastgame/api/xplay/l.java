package com.bytedance.android.live.broadcastgame.api.xplay;

import com.bytedance.android.live.broadcastgame.api.model.q0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f59484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f59487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f59488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f59489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f59490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f59491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f59492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f59493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f59494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final q0 f59495l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Integer> f59496m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f59497n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L34;
        l r101 = (l) r100;
        if (this.f59484a == r101.f59484a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59485b, r101.f59485b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f59486c, r101.f59486c) == true) goto L12;
        return false;
    L12:
        if (this.f59487d == r101.f59487d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f59488e, r101.f59488e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f59489f, r101.f59489f) == true) goto L18;
        return false;
    L18:
        if (this.f59490g == r101.f59490g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f59491h, r101.f59491h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f59492i, r101.f59492i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f59493j, r101.f59493j) == true) goto L26;
        return false;
    L26:
        if (this.f59494k == r101.f59494k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f59495l, r101.f59495l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f59496m, r101.f59496m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f59497n, r101.f59497n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v43 */
    public final int hashCode() {
        int r100 = this.f59484a * 31;
        String r101 = this.f59485b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f59486c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        long r107 = this.f59487d;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f59488e;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f59489f;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (((r111 + r113) * 31) + this.f59490g) * 31;
        String r115 = this.f59491h;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f59492i;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f59493j;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        boolean r124 = this.f59494k;
        ?? r125 = r124;
        if (r124 == false) goto L33;
        r125 = 1;
    L33:
        int r126 = (r123 + r125) * 31;
        q0 r127 = this.f59495l;
        if (r127 == null) goto L36;
        int r128 = r127.hashCode();
    L37:
        int r129 = (r126 + r128) * 31;
        List<Integer> r130 = this.f59496m;
        if (r130 == null) goto L40;
        int r131 = r130.hashCode();
    L41:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f59497n;
        if (r133 == null) goto L45;
        r102 = r133.hashCode();
    L45:
        return r132 + r102;
    L40:
        r131 = 0;
        goto L41
    L36:
        r128 = 0;
        goto L37
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "XplayGameItem(interactId=" + this.f59484a + ", appId=" + this.f59485b + ", gameName=" + this.f59486c + ", gameId=" + this.f59487d + ", gameIconUrl=" + this.f59488e + ", schema=" + this.f59489f + ", businessType=" + this.f59490g + ", developer=" + this.f59491h + ", version=" + this.f59492i + ", unityVersion=" + this.f59493j + ", isDebugUnity=" + this.f59494k + ", xplayInfo=" + this.f59495l + ", supportLiveScene=" + this.f59496m + ", playRule=" + this.f59497n + ")";
    }

    public l(int r110, String r111, String r112, long r113, String r114, String r115, int r116, String r210, String r211, String r212, boolean r213, q0 r214, List<Integer> r215, String r216) {
        Intrinsics.checkNotNullParameter(r111, "appId");
        Intrinsics.checkNotNullParameter(r112, "gameName");
        Intrinsics.checkNotNullParameter(r114, "gameIconUrl");
        Intrinsics.checkNotNullParameter(r115, "schema");
        Intrinsics.checkNotNullParameter(r210, "developer");
        Intrinsics.checkNotNullParameter(r211, "version");
        Intrinsics.checkNotNullParameter(r212, "unityVersion");
        Intrinsics.checkNotNullParameter(r215, "supportLiveScene");
        Intrinsics.checkNotNullParameter(r216, "playRule");
        this.f59484a = r110;
        this.f59485b = r111;
        this.f59486c = r112;
        this.f59487d = r113;
        this.f59488e = r114;
        this.f59489f = r115;
        this.f59490g = r116;
        this.f59491h = r210;
        this.f59492i = r211;
        this.f59493j = r212;
        this.f59494k = r213;
        this.f59495l = r214;
        this.f59496m = r215;
        this.f59497n = r216;
    }
}
