package ac0;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.j;
import gc0.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zb0.a f2538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bc0.b f2539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f2540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final fc0.a f2541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<ViewGroup, View> f2542i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<ViewGroup, View> f2543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f2544k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ec0.a f2545l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f2546m;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L34;
        b r101 = (b) r100;
        if (this.f2534a == r101.f2534a) goto L8;
        return false;
    L8:
        if (this.f2535b == r101.f2535b) goto L10;
        return false;
    L10:
        if (this.f2536c == r101.f2536c) goto L12;
        return false;
    L12:
        if (this.f2537d == r101.f2537d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f2538e, r101.f2538e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f2539f, r101.f2539f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f2540g, r101.f2540g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(null, null) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f2541h, r101.f2541h) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f2542i, r101.f2542i) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f2543j, r101.f2543j) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f2544k, r101.f2544k) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f2545l, r101.f2545l) == true) goto L32;
        return false;
    L32:
        if (this.f2546m == r101.f2546m) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f2534a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f2535b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f2536c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f2537d;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        zb0.a r113 = this.f2538e;
        int r114 = 0;
        if (r113 == null) goto L17;
        int r115 = r113.hashCode();
    L18:
        int r116 = (r112 + r115) * 31;
        bc0.b r117 = this.f2539f;
        if (r117 == null) goto L21;
        int r118 = r117.hashCode();
    L22:
        int r119 = (r116 + r118) * 31;
        d r120 = this.f2540g;
        if (r120 == null) goto L25;
        int r121 = r120.hashCode();
    L26:
        int r122 = (((r119 + r121) * 31) + 0) * 31;
        fc0.a r123 = this.f2541h;
        if (r123 == null) goto L29;
        int r124 = r123.hashCode();
    L30:
        int r125 = (r122 + r124) * 31;
        Function1<ViewGroup, View> r126 = this.f2542i;
        if (r126 == null) goto L33;
        int r127 = r126.hashCode();
    L34:
        int r128 = (r125 + r127) * 31;
        Function1<ViewGroup, View> r129 = this.f2543j;
        if (r129 == null) goto L37;
        int r130 = r129.hashCode();
    L38:
        int r131 = (r128 + r130) * 31;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r132 = this.f2544k;
        if (r132 == null) goto L41;
        int r133 = r132.hashCode();
    L42:
        int r134 = (r131 + r133) * 31;
        ec0.a r135 = this.f2545l;
        if (r135 == null) goto L45;
        r114 = r135.hashCode();
    L45:
        int r136 = (r134 + r114) * 31;
        boolean r137 = this.f2546m;
        if (r137 == true) goto L50;
        r101 = r137;
    L50:
        return r136 + r101;
    L41:
        r133 = 0;
        goto L42
    L37:
        r130 = 0;
        goto L38
    L33:
        r127 = 0;
        goto L34
    L29:
        r124 = 0;
        goto L30
    L25:
        r121 = 0;
        goto L26
    L21:
        r118 = 0;
        goto L22
    L17:
        r115 = 0;
        goto L18
    }

    public final String toString() {
        return "TuningPanelConfig(isShowTuningMusicControlArea=" + this.f2534a + ", isShowTuningButtonArea=" + this.f2535b + ", isShowTuningEffectArea=" + this.f2536c + ", isShowTuningVolumeArea=" + this.f2537d + ", tuningPanelOuterCallback=" + this.f2538e + ", tuningButtonOuterCallback=" + this.f2539f + ", tuningVolumeOuterCallback=" + this.f2540g + ", tuningEffectOuterCallback=null, tuningMusicControlOuterCallback=" + this.f2541h + ", createCustomEntranceView=" + this.f2542i + ", createBottomEntranceView=" + this.f2543j + ", tuningCore=" + this.f2544k + ", tuningMusicControl=" + this.f2545l + ", enableFontAdapt=" + this.f2546m + ")";
    }

    public b(boolean r110, zb0.a r111, bc0.b r112, d r113, j r210, Function1 r211, Function1 r212, com.bytedance.android.live.ktv.common.tuningpanel.ability.a r213, ec0.a r214, boolean r215, int r216) {
        boolean r100 = false;
        boolean r101 = true;
        if ((r216 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r216 & 2) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r216 & 4) == 0) goto L13;
        boolean r104 = true;
    L15:
        if ((r216 & 8) != 0) goto L18;
        r101 = false;
    L18:
        ec0.a r105 = null;
        if ((r216 & 16) == 0) goto L21;
        zb0.a r106 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        bc0.b r107 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        d r114 = null;
    L31:
        if ((r216 & 256) == 0) goto L33;
        j r115 = null;
    L35:
        if ((r216 & 512) == 0) goto L37;
        Function1 r116 = null;
    L39:
        if ((r216 & 1024) == 0) goto L41;
        Function1 r117 = null;
    L43:
        if ((r216 & 4096) != 0) goto L47;
        r105 = r214;
    L47:
        if ((r216 & 8192) != 0) goto L50;
        r100 = r215;
    L50:
        this.f2534a = r102;
        this.f2535b = r103;
        this.f2536c = r104;
        this.f2537d = r101;
        this.f2538e = r106;
        this.f2539f = r107;
        this.f2540g = r114;
        this.f2541h = r115;
        this.f2542i = r116;
        this.f2543j = r117;
        this.f2544k = r213;
        this.f2545l = r105;
        this.f2546m = r100;
        return;
    L41:
        r117 = r212;
        goto L43
    L37:
        r116 = r211;
        goto L39
    L33:
        r115 = r210;
        goto L35
    L29:
        r114 = r113;
        goto L31
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L13:
        r104 = r110;
        goto L15
    L9:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L7
    }
}
