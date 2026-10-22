package com.bytedance.android.live.broadcastgame.api.xplay.basic;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f59454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f59455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f59456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f59457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f59458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f59459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f59460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f59461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f59462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f59463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f59464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f59465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f59466o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f59467p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f59468q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f59469r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<String> f59470s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f59471t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f59472u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final JSONArray f59473v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f59474w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f59475x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f59476y;

    public e() {
        this(null, null, 0, 0, 0, 0, null, null, false, false, false, false, false, false, null, false, null, null, 33554431);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L56;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f59452a, r101.f59452a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59453b, r101.f59453b) == true) goto L10;
        return false;
    L10:
        if (this.f59454c == r101.f59454c) goto L12;
        return false;
    L12:
        if (this.f59455d == r101.f59455d) goto L14;
        return false;
    L14:
        if (this.f59456e == r101.f59456e) goto L16;
        return false;
    L16:
        if (this.f59457f == r101.f59457f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f59458g, r101.f59458g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f59459h, r101.f59459h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f59460i, r101.f59460i) == true) goto L24;
        return false;
    L24:
        if (this.f59461j == r101.f59461j) goto L26;
        return false;
    L26:
        if (this.f59462k == r101.f59462k) goto L28;
        return false;
    L28:
        if (this.f59463l == r101.f59463l) goto L30;
        return false;
    L30:
        if (this.f59464m == r101.f59464m) goto L32;
        return false;
    L32:
        if (this.f59465n == r101.f59465n) goto L34;
        return false;
    L34:
        if (this.f59466o == r101.f59466o) goto L36;
        return false;
    L36:
        if (this.f59467p == r101.f59467p) goto L38;
        return false;
    L38:
        if (this.f59468q == r101.f59468q) goto L40;
        return false;
    L40:
        if (this.f59469r == r101.f59469r) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f59470s, r101.f59470s) == true) goto L44;
        return false;
    L44:
        if (this.f59471t == r101.f59471t) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f59472u, r101.f59472u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f59473v, r101.f59473v) == true) goto L50;
        return false;
    L50:
        if (this.f59474w == r101.f59474w) goto L52;
        return false;
    L52:
        if (this.f59475x == r101.f59475x) goto L54;
        return false;
    L54:
        if (this.f59476y == r101.f59476y) goto L85;
        return false;
    L85:
        return true;
    L56:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48, types: [int] */
    /* JADX WARN: Type inference failed for: r0v50, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f59452a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f59453b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((((((r103 + r105) * 31) + this.f59454c) * 31) + this.f59455d) * 31) + this.f59456e) * 31) + this.f59457f) * 31;
        Map<String, Object> r107 = this.f59458g;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.f59459h;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.f59460i;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f59461j;
        ?? r117 = 1;
        ?? r118 = r116;
        if (r116 == false) goto L25;
        r118 = 1;
    L25:
        int r119 = (r115 + r118) * 31;
        boolean r120 = this.f59462k;
        ?? r121 = r120;
        if (r120 == false) goto L28;
        r121 = 1;
    L28:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.f59463l;
        ?? r124 = r123;
        if (r123 == false) goto L31;
        r124 = 1;
    L31:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f59464m;
        ?? r127 = r126;
        if (r126 == false) goto L34;
        r127 = 1;
    L34:
        int r128 = (((r125 + r127) * 31) + this.f59465n) * 31;
        boolean r129 = this.f59466o;
        ?? r130 = r129;
        if (r129 == false) goto L37;
        r130 = 1;
    L37:
        int r131 = (((r128 + r130) * 31) + this.f59467p) * 31;
        boolean r132 = this.f59468q;
        ?? r133 = r132;
        if (r132 == false) goto L40;
        r133 = 1;
    L40:
        int r134 = (r131 + r133) * 31;
        boolean r135 = this.f59469r;
        ?? r136 = r135;
        if (r135 == false) goto L43;
        r136 = 1;
    L43:
        int r137 = (r134 + r136) * 31;
        List<String> r138 = this.f59470s;
        if (r138 == null) goto L46;
        int r139 = r138.hashCode();
    L47:
        int r140 = (r137 + r139) * 31;
        boolean r141 = this.f59471t;
        ?? r142 = r141;
        if (r141 == false) goto L50;
        r142 = 1;
    L50:
        int r143 = (r140 + r142) * 31;
        Context r144 = this.f59472u;
        if (r144 == null) goto L53;
        int r145 = r144.hashCode();
    L54:
        int r146 = (r143 + r145) * 31;
        JSONArray r147 = this.f59473v;
        if (r147 == null) goto L57;
        r101 = r147.hashCode();
    L57:
        int r148 = (((r146 + r101) * 31) + this.f59474w) * 31;
        boolean r149 = this.f59475x;
        ?? r150 = r149;
        if (r149 == false) goto L60;
        r150 = 1;
    L60:
        int r151 = (r148 + r150) * 31;
        boolean r152 = this.f59476y;
        if (r152 == true) goto L65;
        r117 = r152;
    L65:
        return r151 + r117;
    L53:
        r145 = 0;
        goto L54
    L46:
        r139 = 0;
        goto L47
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
        return "XplayBasicStartParams(gameId=" + this.f59452a + ", channel=" + this.f59453b + ", displayWidth=" + this.f59454c + ", displayHeight=" + this.f59455d + ", widthRatio=" + this.f59456e + ", heightRatio=" + this.f59457f + ", extraToGame=" + this.f59458g + ", extraToServer=" + this.f59459h + ", monitorCommonParams=" + this.f59460i + ", enableRTCMulti=" + this.f59461j + ", muteAudioPlayback=" + this.f59462k + ", enableVideoFrame=" + this.f59463l + ", enableAudioFrame=" + this.f59464m + ", renderBackgroundColor=" + this.f59465n + ", isUseTextureView=" + this.f59466o + ", videoFrameFormat=" + this.f59467p + ", enableFrameSEIData=" + this.f59468q + ", enableExternalRender=" + this.f59469r + ", cloudPlayers=" + this.f59470s + ", useApplicationContext=" + this.f59471t + ", applicationContext=" + this.f59472u + ", videoSimulcast=" + this.f59473v + ", roomGuestType=" + this.f59474w + ", isPodMergeStream=" + this.f59475x + ", disableAudioFocus=" + this.f59476y + ")";
    }

    public e(String r210, String r211, int r212, int r213, int r214, int r215, Map r216, Map r217, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, List r316, boolean r317, Context r318, JSONArray r319, int r410) {
        String r100 = "";
        if ((r410 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r410 & 2) != 0) goto L11;
        r100 = r211;
    L11:
        if ((r410 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r410 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r410 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r410 & 32) == 0) goto L25;
        int r105 = 0;
    L27:
        if ((r410 & 64) == 0) goto L29;
        Map r106 = new LinkedHashMap();
    L31:
        if ((r410 & 128) == 0) goto L33;
        Map r110 = new LinkedHashMap();
    L35:
        if ((r410 & 256) == 0) goto L37;
        LinkedHashMap r111 = new LinkedHashMap();
    L39:
        if ((r410 & 512) == 0) goto L41;
        boolean r112 = false;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        boolean r113 = false;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        boolean r114 = false;
    L51:
        if ((r410 & 16384) == 0) goto L53;
        boolean r115 = false;
    L55:
        if ((r410 & 65536) == 0) goto L57;
        boolean r116 = false;
    L59:
        if ((r410 & 131072) == 0) goto L61;
        boolean r117 = false;
    L63:
        if ((r410 & 262144) == 0) goto L65;
        List r107 = new ArrayList();
    L67:
        if ((r410 & 524288) == 0) goto L69;
        boolean r118 = false;
    L71:
        if ((r410 & 1048576) == 0) goto L73;
        Context r218 = null;
    L75:
        if ((r410 & 2097152) == 0) goto L77;
        JSONArray r108 = null;
    L78:
        Intrinsics.checkNotNullParameter(r101, "gameId");
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r106, "extraToGame");
        Intrinsics.checkNotNullParameter(r110, "extraToServer");
        Intrinsics.checkNotNullParameter(r111, "monitorCommonParams");
        Intrinsics.checkNotNullParameter(r107, "cloudPlayers");
        this.f59452a = r101;
        this.f59453b = r100;
        this.f59454c = r102;
        this.f59455d = r103;
        this.f59456e = r104;
        this.f59457f = r105;
        this.f59458g = r106;
        this.f59459h = r110;
        this.f59460i = r111;
        this.f59461j = r112;
        this.f59462k = r113;
        this.f59463l = r114;
        this.f59464m = false;
        this.f59465n = 0;
        this.f59466o = r115;
        this.f59467p = 0;
        this.f59468q = r116;
        this.f59469r = r117;
        this.f59470s = r107;
        this.f59471t = r118;
        this.f59472u = r218;
        this.f59473v = r108;
        this.f59474w = 0;
        this.f59475x = false;
        this.f59476y = false;
        return;
    L77:
        r108 = r319;
        goto L78
    L73:
        r218 = r318;
        goto L75
    L69:
        r118 = r317;
        goto L71
    L65:
        r107 = r316;
        goto L67
    L61:
        r117 = r315;
        goto L63
    L57:
        r116 = r314;
        goto L59
    L53:
        r115 = r313;
        goto L55
    L49:
        r114 = r312;
        goto L51
    L45:
        r113 = r311;
        goto L47
    L41:
        r112 = r310;
        goto L43
    L37:
        r111 = null;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L5:
        r101 = r210;
        goto L7
    }
}
