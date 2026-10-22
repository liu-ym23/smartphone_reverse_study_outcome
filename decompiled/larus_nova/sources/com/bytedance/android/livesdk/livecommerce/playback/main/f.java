package com.bytedance.android.livesdk.livecommerce.playback.main;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.playback.ReplayCards;
import com.bytedance.android.ec.model.response.ECRitTag;
import dj2.i;
import dj2.j;
import dj2.k;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements com.bytedance.android.ec.core.arch.state.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f149940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f149941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f149942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj2.h f149943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECUrlModel f149944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f149945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECRitTag f149946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f149947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final dj2.b f149948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final dj2.a f149949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f149950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final dj2.c f149951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ReplayCards f149952m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f149953n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final dj2.g f149954o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<com.bytedance.android.ec.model.live.b> f149955p;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L38;
        f r101 = (f) r100;
        if (this.f149940a == r101.f149940a) goto L8;
        return false;
    L8:
        if (this.f149941b == r101.f149941b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f149942c, r101.f149942c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f149943d, r101.f149943d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f149944e, r101.f149944e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f149945f, r101.f149945f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f149946g, r101.f149946g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f149947h, r101.f149947h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f149948i, r101.f149948i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f149949j, r101.f149949j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f149950k, r101.f149950k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f149951l, r101.f149951l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f149952m, r101.f149952m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f149953n, r101.f149953n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f149954o, r101.f149954o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f149955p, r101.f149955p) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v55 */
    public final int hashCode() {
        boolean r100 = this.f149940a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f149941b;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        k r106 = this.f149942c;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        dj2.h r110 = this.f149943d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        ECUrlModel r113 = this.f149944e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f149945f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        ECRitTag r119 = this.f149946g;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        j r122 = this.f149947h;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        dj2.b r125 = this.f149948i;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        dj2.a r128 = this.f149949j;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        i r131 = this.f149950k;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        dj2.c r134 = this.f149951l;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        ReplayCards r137 = this.f149952m;
        if (r137 == null) goto L52;
        int r138 = r137.hashCode();
    L53:
        int r139 = (r136 + r138) * 31;
        k r140 = this.f149953n;
        if (r140 == null) goto L56;
        int r141 = r140.hashCode();
    L57:
        int r142 = (r139 + r141) * 31;
        dj2.g r143 = this.f149954o;
        if (r143 == null) goto L60;
        int r144 = r143.hashCode();
    L61:
        int r145 = (r142 + r144) * 31;
        List<com.bytedance.android.ec.model.live.b> r146 = this.f149955p;
        if (r146 == null) goto L65;
        r107 = r146.hashCode();
    L65:
        return r145 + r107;
    L60:
        r144 = 0;
        goto L61
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
    }

    public final String toString() {
        return "ExplainPlaybackState(isLoading=" + this.f149940a + ", showBackToLive=" + this.f149941b + ", videoInfoEntity=" + this.f149942c + ", promotionInfo=" + this.f149943d + ", backgroundPic=" + this.f149944e + ", headerTitle=" + this.f149945f + ", commentaryTag=" + this.f149946g + ", topRightButtonEntity=" + this.f149947h + ", bottomEnterLiveEntity=" + this.f149948i + ", authorInfoEntity=" + this.f149949j + ", replayViewCntEntity=" + this.f149950k + ", bottomLivingButtonEntity=" + this.f149951l + ", replayCards=" + this.f149952m + ", videoInfoEntityV2=" + this.f149953n + ", interactionEntity=" + this.f149954o + ", topBanner=" + this.f149955p + ")";
    }

    public /* synthetic */ f(int r110) {
        this(true, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public f(boolean r100, boolean r101, k r102, dj2.h r103, ECUrlModel r104, String r105, ECRitTag r106, j r110, dj2.b r111, dj2.a r112, i r113, dj2.c r114, ReplayCards r115, k r116, dj2.g r117, List<com.bytedance.android.ec.model.live.b> r118) {
        this.f149940a = r100;
        this.f149941b = r101;
        this.f149942c = r102;
        this.f149943d = r103;
        this.f149944e = r104;
        this.f149945f = r105;
        this.f149946g = r106;
        this.f149947h = r110;
        this.f149948i = r111;
        this.f149949j = r112;
        this.f149950k = r113;
        this.f149951l = r114;
        this.f149952m = r115;
        this.f149953n = r116;
        this.f149954o = r117;
        this.f149955p = r118;
    }

    public static f a(f r110, boolean r111, boolean r112, k r210, dj2.h r211, ECUrlModel r212, String r213, ECRitTag r214, j r215, dj2.b r216, dj2.a r217, i r218, dj2.c r219, ReplayCards r310, k r311, dj2.g r312, List r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        boolean r100 = r110.f149940a;
    L7:
        if ((r314 & 2) == 0) goto L9;
        boolean r101 = r110.f149941b;
    L11:
        if ((r314 & 4) == 0) goto L13;
        k r102 = r110.f149942c;
    L15:
        if ((r314 & 8) == 0) goto L17;
        dj2.h r103 = r110.f149943d;
    L19:
        if ((r314 & 16) == 0) goto L21;
        ECUrlModel r104 = r110.f149944e;
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = r110.f149945f;
    L27:
        if ((r314 & 64) == 0) goto L29;
        ECRitTag r106 = r110.f149946g;
    L31:
        if ((r314 & 128) == 0) goto L33;
        j r107 = r110.f149947h;
    L35:
        if ((r314 & 256) == 0) goto L37;
        dj2.b r113 = r110.f149948i;
    L39:
        if ((r314 & 512) == 0) goto L41;
        dj2.a r114 = r110.f149949j;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        i r115 = r110.f149950k;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        dj2.c r116 = r110.f149951l;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        ReplayCards r117 = r110.f149952m;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        k r118 = r110.f149953n;
    L58:
        k r315 = r118;
        if ((r314 & 16384) == 0) goto L61;
        dj2.g r119 = r110.f149954o;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        List r108 = r110.f149955p;
    L66:
        r110.getClass();
        return new f(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r315, r119, r108);
    L65:
        r108 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
