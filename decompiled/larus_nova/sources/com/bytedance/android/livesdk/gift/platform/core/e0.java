package com.bytedance.android.livesdk.gift.platform.core;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SeriesSendType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e0 {
    public final String A;
    public final boolean B;
    public final String C;
    public final String D;
    public final Map<String, String> E;
    public final Map<String, String> F;
    public final Map<String, String> G;
    public final Function1<Integer, Unit> H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f130484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f130485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f130486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f130487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f130488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SendGiftSource f130489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f130490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IBaseUser f130491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f130492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<e3> f130493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f130494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f130495l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f130496m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ReceiverType f130497n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Long f130498o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f130499p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f130500q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<IBaseUser> f130501r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<k3> f130502s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SeriesSendType f130503t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f130504u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f130505v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f130506w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f130507x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.core.model.k f130508y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.core.model.k f130509z;

    public e0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L74;
        e0 r101 = (e0) r100;
        if (this.f130484a == r101.f130484a) goto L8;
        return false;
    L8:
        if (this.f130485b == r101.f130485b) goto L10;
        return false;
    L10:
        if (this.f130486c == r101.f130486c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f130487d, r101.f130487d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f130488e, r101.f130488e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f130489f, r101.f130489f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f130490g, r101.f130490g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f130491h, r101.f130491h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f130492i, r101.f130492i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f130493j, r101.f130493j) == true) goto L26;
        return false;
    L26:
        if (this.f130494k == r101.f130494k) goto L28;
        return false;
    L28:
        if (this.f130495l == r101.f130495l) goto L30;
        return false;
    L30:
        if (this.f130496m == r101.f130496m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f130497n, r101.f130497n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f130498o, r101.f130498o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f130499p, r101.f130499p) == true) goto L38;
        return false;
    L38:
        if (this.f130500q == r101.f130500q) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f130501r, r101.f130501r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f130502s, r101.f130502s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f130503t, r101.f130503t) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f130504u, r101.f130504u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f130505v, r101.f130505v) == true) goto L50;
        return false;
    L50:
        if (this.f130506w == r101.f130506w) goto L52;
        return false;
    L52:
        if (this.f130507x == r101.f130507x) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f130508y, r101.f130508y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f130509z, r101.f130509z) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L60;
        return false;
    L60:
        if (this.B == r101.B) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.D, r101.D) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.E, r101.E) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.F, r101.F) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.G, r101.G) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.H, r101.H) == true) goto L112;
        return false;
    L112:
        return true;
    L74:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v104 */
    /* JADX WARN: Type inference failed for: r0v112 */
    /* JADX WARN: Type inference failed for: r0v113 */
    /* JADX WARN: Type inference failed for: r0v114 */
    /* JADX WARN: Type inference failed for: r0v115 */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v39, types: [int] */
    /* JADX WARN: Type inference failed for: r0v56, types: [int] */
    /* JADX WARN: Type inference failed for: r0v58, types: [int] */
    /* JADX WARN: Type inference failed for: r0v93 */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final int hashCode() {
        long r100 = this.f130484a;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f130485b) * 31) + this.f130486c) * 31;
        String r102 = this.f130487d;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f130488e;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        SendGiftSource r109 = this.f130489f;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f130490g;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        IBaseUser r115 = this.f130491h;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f130492i;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        ArrayList<e3> r121 = this.f130493j;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        boolean r124 = this.f130494k;
        ?? r125 = 1;
        ?? r126 = r124;
        if (r124 == false) goto L33;
        r126 = 1;
    L33:
        long r127 = this.f130495l;
        int r128 = (((((r123 + r126) * 31) + ((int) (r127 ^ (r127 >>> 32)))) * 31) + this.f130496m) * 31;
        ReceiverType r129 = this.f130497n;
        if (r129 == null) goto L36;
        int r130 = r129.hashCode();
    L37:
        int r131 = (r128 + r130) * 31;
        Long r132 = this.f130498o;
        if (r132 == null) goto L40;
        int r133 = r132.hashCode();
    L41:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f130499p;
        if (r135 == null) goto L44;
        int r136 = r135.hashCode();
    L45:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.f130500q;
        ?? r139 = r138;
        if (r138 == false) goto L48;
        r139 = 1;
    L48:
        int r140 = (r137 + r139) * 31;
        List<IBaseUser> r141 = this.f130501r;
        if (r141 == null) goto L51;
        int r142 = r141.hashCode();
    L52:
        int r143 = (r140 + r142) * 31;
        List<k3> r144 = this.f130502s;
        if (r144 == null) goto L55;
        int r145 = r144.hashCode();
    L56:
        int r146 = (r143 + r145) * 31;
        SeriesSendType r147 = this.f130503t;
        if (r147 == null) goto L59;
        int r148 = r147.hashCode();
    L60:
        int r149 = (r146 + r148) * 31;
        String r150 = this.f130504u;
        if (r150 == null) goto L63;
        int r151 = r150.hashCode();
    L64:
        int r152 = (r149 + r151) * 31;
        String r153 = this.f130505v;
        if (r153 == null) goto L67;
        int r154 = r153.hashCode();
    L68:
        int r155 = (r152 + r154) * 31;
        boolean r156 = this.f130506w;
        ?? r157 = r156;
        if (r156 == false) goto L71;
        r157 = 1;
    L71:
        int r158 = (r155 + r157) * 31;
        boolean r159 = this.f130507x;
        ?? r160 = r159;
        if (r159 == false) goto L74;
        r160 = 1;
    L74:
        int r161 = (r158 + r160) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.k r162 = this.f130508y;
        if (r162 == null) goto L77;
        int r163 = r162.hashCode();
    L78:
        int r164 = (r161 + r163) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.k r165 = this.f130509z;
        if (r165 == null) goto L81;
        int r166 = r165.hashCode();
    L82:
        int r167 = (r164 + r166) * 31;
        String r168 = this.A;
        if (r168 == null) goto L85;
        int r169 = r168.hashCode();
    L86:
        int r170 = (r167 + r169) * 31;
        boolean r171 = this.B;
        if (r171 == true) goto L90;
        r125 = r171;
    L90:
        int r172 = (r170 + r125) * 31;
        String r173 = this.C;
        if (r173 == null) goto L93;
        int r174 = r173.hashCode();
    L94:
        int r175 = (r172 + r174) * 31;
        String r176 = this.D;
        if (r176 == null) goto L97;
        int r177 = r176.hashCode();
    L98:
        int r178 = (r175 + r177) * 31;
        Map<String, String> r179 = this.E;
        if (r179 == null) goto L101;
        int r180 = r179.hashCode();
    L102:
        int r181 = (r178 + r180) * 31;
        Map<String, String> r182 = this.F;
        if (r182 == null) goto L105;
        int r183 = r182.hashCode();
    L106:
        int r184 = (r181 + r183) * 31;
        Map<String, String> r185 = this.G;
        if (r185 == null) goto L109;
        int r186 = r185.hashCode();
    L110:
        int r187 = (r184 + r186) * 31;
        Function1<Integer, Unit> r188 = this.H;
        if (r188 == null) goto L114;
        r103 = r188.hashCode();
    L114:
        return r187 + r103;
    L109:
        r186 = 0;
        goto L110
    L105:
        r183 = 0;
        goto L106
    L101:
        r180 = 0;
        goto L102
    L97:
        r177 = 0;
        goto L98
    L93:
        r174 = 0;
        goto L94
    L85:
        r169 = 0;
        goto L86
    L81:
        r166 = 0;
        goto L82
    L77:
        r163 = 0;
        goto L78
    L67:
        r154 = 0;
        goto L68
    L63:
        r151 = 0;
        goto L64
    L59:
        r148 = 0;
        goto L60
    L55:
        r145 = 0;
        goto L56
    L51:
        r142 = 0;
        goto L52
    L44:
        r136 = 0;
        goto L45
    L40:
        r133 = 0;
        goto L41
    L36:
        r130 = 0;
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
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenBigGiftInfo(giftId=" + this.f130484a + ", buffLevel=" + this.f130485b + ", count=" + this.f130486c + ", giftType=" + this.f130487d + ", extra=" + this.f130488e + ", source=" + this.f130489f + ", vsSource=" + this.f130490g + ", user=" + this.f130491h + ", giftSourceLog=" + this.f130492i + ", pluginInfo=" + this.f130493j + ", isCustomizeGift=" + this.f130494k + ", configId=" + this.f130495l + ", sendScene=" + this.f130496m + ", receiverType=" + this.f130497n + ", roomId=" + this.f130498o + ", anchorId=" + this.f130499p + ", sendGiftToMultiUsers=" + this.f130500q + ", toUsers=" + this.f130501r + ", seriesGiftsInfo=" + this.f130502s + ", seriesSendType=" + this.f130503t + ", seriesName=" + this.f130504u + ", afterSendSchema=" + this.f130505v + ", panelLocateRemember=" + this.f130506w + ", disableDisableGiftCombo=" + this.f130507x + ", defaultGiftInfo=" + this.f130508y + ", curSendGiftInfo=" + this.f130509z + ", giftSortExtra=" + this.A + ", isSearchResult=" + this.B + ", searchWord=" + this.C + ", searchId=" + this.D + ", toRechargeParams=" + this.E + ", jsbLogExtra=" + this.F + ", tagsExtra=" + this.G + ", callback=" + this.H + ")";
    }

    public e0(long r310, int r311, int r312, String r313, String r410, SendGiftSource r411, String r412, IBaseUser r413, String r414, ArrayList r415, boolean r416, long r417, int r418, ReceiverType r510, Long r511, boolean r512, List r513, List r514, SeriesSendType r515, String r516, String r517, boolean r518, boolean r519, com.bytedance.android.livesdk.gift.platform.core.model.k r610, com.bytedance.android.livesdk.gift.platform.core.model.k r611, String r612, boolean r613, String r614, String r615, Map r616, Map r617, Map r618, Function1 r619, int r710, int r711) {
        if ((r710 & 8) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r710 & 16) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r710 & 32) == 0) goto L13;
        SendGiftSource r102 = SendGiftSource.GiftDialog;
    L15:
        if ((r710 & 128) == 0) goto L17;
        IBaseUser r103 = null;
    L19:
        if ((r710 & 256) == 0) goto L21;
        String r110 = "";
    L23:
        if ((r710 & 512) == 0) goto L25;
        ArrayList r111 = null;
    L27:
        if ((r710 & 1024) == 0) goto L29;
        boolean r112 = false;
    L31:
        if ((r710 & 2048) == 0) goto L33;
        long r113 = 0;
    L35:
        if ((r710 & 4096) == 0) goto L37;
        int r114 = 0;
    L39:
        if ((r710 & 8192) == 0) goto L41;
        ReceiverType r104 = null;
    L43:
        if ((r710 & 16384) == 0) goto L45;
        Long r105 = null;
    L47:
        if ((r710 & 65536) == 0) goto L49;
        boolean r115 = false;
    L51:
        if ((r710 & 131072) == 0) goto L53;
        List r116 = null;
    L55:
        if ((r710 & 262144) == 0) goto L57;
        List r210 = null;
    L59:
        if ((r710 & 524288) == 0) goto L61;
        SeriesSendType r106 = SeriesSendType.NONE;
    L63:
        if ((r710 & 1048576) == 0) goto L65;
        String r211 = null;
    L67:
        if ((r710 & 2097152) == 0) goto L69;
        String r212 = null;
    L71:
        if ((r710 & 4194304) == 0) goto L73;
        boolean r213 = false;
    L75:
        if ((r710 & 8388608) == 0) goto L77;
        boolean r214 = false;
    L79:
        if ((r710 & 16777216) == 0) goto L81;
        com.bytedance.android.livesdk.gift.platform.core.model.k r215 = null;
    L83:
        if ((r710 & 33554432) == 0) goto L85;
        com.bytedance.android.livesdk.gift.platform.core.model.k r216 = null;
    L87:
        if ((r710 & 67108864) == 0) goto L89;
        String r217 = null;
    L91:
        if ((r710 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L93;
        boolean r218 = false;
    L95:
        if ((r710 & 268435456) == 0) goto L97;
        String r107 = "";
    L99:
        if ((r710 & 536870912) == 0) goto L101;
        String r117 = "";
    L103:
        if ((r710 & 1073741824) == 0) goto L105;
        Map r314 = null;
    L107:
        if ((r710 & Integer.MIN_VALUE) == 0) goto L109;
        Map r108 = null;
    L111:
        if ((r711 & 1) == 0) goto L113;
        Map r315 = null;
    L114:
        Intrinsics.checkNotNullParameter(r100, "giftType");
        Intrinsics.checkNotNullParameter(r101, "extra");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r412, "vsSource");
        Intrinsics.checkNotNullParameter(r110, "giftSourceLog");
        Intrinsics.checkNotNullParameter(r106, "seriesSendType");
        Intrinsics.checkNotNullParameter(r107, "searchWord");
        Intrinsics.checkNotNullParameter(r117, "searchId");
        Intrinsics.checkNotNullParameter(r619, "callback");
        this.f130484a = r310;
        this.f130485b = r311;
        this.f130486c = r312;
        this.f130487d = r100;
        this.f130488e = r101;
        this.f130489f = r102;
        this.f130490g = r412;
        this.f130491h = r103;
        this.f130492i = r110;
        this.f130493j = r111;
        this.f130494k = r112;
        this.f130495l = r113;
        this.f130496m = r114;
        this.f130497n = r104;
        this.f130498o = r105;
        this.f130499p = null;
        this.f130500q = r115;
        this.f130501r = r116;
        this.f130502s = r210;
        this.f130503t = r106;
        this.f130504u = r211;
        this.f130505v = r212;
        this.f130506w = r213;
        this.f130507x = r214;
        this.f130508y = r215;
        this.f130509z = r216;
        this.A = r217;
        this.B = r218;
        this.C = r107;
        this.D = r117;
        this.E = r314;
        this.F = r108;
        this.G = r315;
        this.H = r619;
        return;
    L113:
        r315 = r618;
        goto L114
    L109:
        r108 = r617;
        goto L111
    L105:
        r314 = r616;
        goto L107
    L101:
        r117 = r615;
        goto L103
    L97:
        r107 = r614;
        goto L99
    L93:
        r218 = r613;
        goto L95
    L89:
        r217 = r612;
        goto L91
    L85:
        r216 = r611;
        goto L87
    L81:
        r215 = r610;
        goto L83
    L77:
        r214 = r519;
        goto L79
    L73:
        r213 = r518;
        goto L75
    L69:
        r212 = r517;
        goto L71
    L65:
        r211 = r516;
        goto L67
    L61:
        r106 = r515;
        goto L63
    L57:
        r210 = r514;
        goto L59
    L53:
        r116 = r513;
        goto L55
    L49:
        r115 = r512;
        goto L51
    L45:
        r105 = r511;
        goto L47
    L41:
        r104 = r510;
        goto L43
    L37:
        r114 = r418;
        goto L39
    L33:
        r113 = r417;
        goto L35
    L29:
        r112 = r416;
        goto L31
    L25:
        r111 = r415;
        goto L27
    L21:
        r110 = r414;
        goto L23
    L17:
        r103 = r413;
        goto L19
    L13:
        r102 = r411;
        goto L15
    L9:
        r101 = r410;
        goto L11
    L5:
        r100 = r313;
        goto L7
    }
}
