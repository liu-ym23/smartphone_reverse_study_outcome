package com.bytedance.android.live.profit.dress;

import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f87160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f87161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f87162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f87163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f87164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f87165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f87166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f87167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final py.k f87168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Integer> f87169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.profit.dress.config.l f87170l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L30;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f87159a, r101.f87159a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87160b, r101.f87160b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f87161c, r101.f87161c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f87162d, r101.f87162d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f87163e, r101.f87163e) == true) goto L16;
        return false;
    L16:
        if (this.f87164f == r101.f87164f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f87165g, r101.f87165g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f87166h, r101.f87166h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f87167i, r101.f87167i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f87168j, r101.f87168j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f87169k, r101.f87169k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f87170l, r101.f87170l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v40 */
    public final int hashCode() {
        String r100 = this.f87159a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f87160b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f87161c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f87162d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f87163e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f87164f;
        ?? r117 = r116;
        if (r116 == false) goto L25;
        r117 = 1;
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f87165g;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f87166h;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f87167i;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        py.k r128 = this.f87168j;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        List<Integer> r131 = this.f87169k;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        com.bytedance.android.live.profit.dress.config.l r134 = this.f87170l;
        if (r134 == null) goto L49;
        r101 = r134.hashCode();
    L49:
        return r133 + r101;
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
        return "LinkmicDecoration(name=" + this.f87159a + ", playValueIcon=" + this.f87160b + ", linkmicDynamicEffect=" + this.f87161c + ", beautyEffectId=" + this.f87162d + ", linkmicStaticEffect=" + this.f87163e + ", showFlymicEffect=" + this.f87164f + ", valueBgColor=" + this.f87165g + ", valueNumberColor=" + this.f87166h + ", sponsorBgColor=" + this.f87167i + ", honorIcon=" + this.f87168j + ", playMode=" + this.f87169k + ", starWishConfig=" + this.f87170l + ")";
    }

    public s(String r100, String r101, String r102, String r103, String r104, boolean r105, String r106, String r107, String r110, py.k r111, List<Integer> r112, com.bytedance.android.live.profit.dress.config.l r113) {
        Intrinsics.checkNotNullParameter(r112, Keys.API_EVENT_KEY_PLAY_MODE);
        this.f87159a = r100;
        this.f87160b = r101;
        this.f87161c = r102;
        this.f87162d = r103;
        this.f87163e = r104;
        this.f87164f = r105;
        this.f87165g = r106;
        this.f87166h = r107;
        this.f87167i = r110;
        this.f87168j = r111;
        this.f87169k = r112;
        this.f87170l = r113;
    }
}
