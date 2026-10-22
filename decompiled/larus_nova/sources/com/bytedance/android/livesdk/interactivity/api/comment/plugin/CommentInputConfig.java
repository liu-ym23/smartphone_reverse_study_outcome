package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
public final class CommentInputConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f133062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final State f133063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final State f133064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final State f133065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final State f133066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final State f133067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final State f133068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final State f133069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final State f133070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final State f133071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final State f133072k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final State f133073l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f133074m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f133075n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f133076o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f133077p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final State f133078q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f133079r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f133080s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f133081t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final State f133082u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final State f133083v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f133084w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final State f133085x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final State f133086y;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentInputConfig$State;", "", "ForceOpen", "ForeClose", "NotCare", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State ForceOpen = null;
        public static final State ForeClose = null;
        public static final State NotCare = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f133087a = null;

        static {
            State r100 = new State("ForceOpen", 0);
            ForceOpen = r100;
            State r101 = new State("ForeClose", 1);
            ForeClose = r101;
            State r102 = new State("NotCare", 2);
            NotCare = r102;
            f133087a = new State[]{r100, r101, r102};
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f133087a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CommentInputConfig() {
        this(null, null, null, null, null, null, null, null, null, null, false, false, false, false, null, null, false, null, null, null, 33554431);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommentInputConfig) == false) goto L56;
        CommentInputConfig r101 = (CommentInputConfig) r100;
        if (Intrinsics.areEqual(this.f133062a, r101.f133062a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f133063b, r101.f133063b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f133064c, r101.f133064c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f133065d, r101.f133065d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f133066e, r101.f133066e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f133067f, r101.f133067f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f133068g, r101.f133068g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f133069h, r101.f133069h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f133070i, r101.f133070i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f133071j, r101.f133071j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f133072k, r101.f133072k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f133073l, r101.f133073l) == true) goto L30;
        return false;
    L30:
        if (this.f133074m == r101.f133074m) goto L32;
        return false;
    L32:
        if (this.f133075n == r101.f133075n) goto L34;
        return false;
    L34:
        if (this.f133076o == r101.f133076o) goto L36;
        return false;
    L36:
        if (this.f133077p == r101.f133077p) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f133078q, r101.f133078q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f133079r, r101.f133079r) == true) goto L42;
        return false;
    L42:
        if (this.f133080s == r101.f133080s) goto L44;
        return false;
    L44:
        if (this.f133081t == r101.f133081t) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f133082u, r101.f133082u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f133083v, r101.f133083v) == true) goto L50;
        return false;
    L50:
        if (this.f133084w == r101.f133084w) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f133085x, r101.f133085x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f133086y, r101.f133086y) == true) goto L85;
        return false;
    L85:
        return true;
    L56:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50, types: [int] */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        State r100 = this.f133062a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        State r104 = this.f133063b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        State r107 = this.f133064c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        State r110 = this.f133065d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        State r113 = this.f133066e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        State r116 = this.f133067f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        State r119 = this.f133068g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        State r122 = this.f133069h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        State r125 = this.f133070i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        State r128 = this.f133071j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        State r131 = this.f133072k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        State r134 = this.f133073l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        boolean r137 = this.f133074m;
        ?? r138 = 1;
        ?? r139 = r137;
        if (r137 == false) goto L53;
        r139 = 1;
    L53:
        int r140 = (r136 + r139) * 31;
        boolean r141 = this.f133075n;
        ?? r142 = r141;
        if (r141 == false) goto L56;
        r142 = 1;
    L56:
        int r143 = (r140 + r142) * 31;
        boolean r144 = this.f133076o;
        ?? r145 = r144;
        if (r144 == false) goto L59;
        r145 = 1;
    L59:
        int r146 = (r143 + r145) * 31;
        boolean r147 = this.f133077p;
        ?? r148 = r147;
        if (r147 == false) goto L62;
        r148 = 1;
    L62:
        int r149 = (r146 + r148) * 31;
        State r150 = this.f133078q;
        if (r150 == null) goto L65;
        int r151 = r150.hashCode();
    L66:
        int r152 = (r149 + r151) * 31;
        String r153 = this.f133079r;
        if (r153 == null) goto L69;
        int r154 = r153.hashCode();
    L70:
        int r155 = (r152 + r154) * 31;
        boolean r156 = this.f133080s;
        ?? r157 = r156;
        if (r156 == false) goto L73;
        r157 = 1;
    L73:
        int r158 = (r155 + r157) * 31;
        boolean r159 = this.f133081t;
        ?? r160 = r159;
        if (r159 == false) goto L76;
        r160 = 1;
    L76:
        int r161 = (r158 + r160) * 31;
        State r162 = this.f133082u;
        if (r162 == null) goto L79;
        int r163 = r162.hashCode();
    L80:
        int r164 = (r161 + r163) * 31;
        State r165 = this.f133083v;
        if (r165 == null) goto L83;
        int r166 = r165.hashCode();
    L84:
        int r167 = (r164 + r166) * 31;
        boolean r168 = this.f133084w;
        if (r168 == true) goto L88;
        r138 = r168;
    L88:
        int r169 = (r167 + r138) * 31;
        State r170 = this.f133085x;
        if (r170 == null) goto L91;
        int r171 = r170.hashCode();
    L92:
        int r172 = (r169 + r171) * 31;
        State r173 = this.f133086y;
        if (r173 == null) goto L96;
        r101 = r173.hashCode();
    L96:
        return r172 + r101;
    L91:
        r171 = 0;
        goto L92
    L83:
        r166 = 0;
        goto L84
    L79:
        r163 = 0;
        goto L80
    L69:
        r154 = 0;
        goto L70
    L65:
        r151 = 0;
        goto L66
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
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
        return "CommentInputConfig(enableDanmu=" + this.f133062a + ", enableSubscribeEmoji=" + this.f133063b + ", enableVoiceEntry=" + this.f133064c + ", enableAsr=" + this.f133065d + ", enableVideoEntry=" + this.f133066e + ", enableHotMsg=" + this.f133067f + ", enableEmotionalText=" + this.f133068g + ", enableCustomerEntrance=" + this.f133069h + ", enableFrequentChat=" + this.f133070i + ", enableAI=" + this.f133071j + ", enableInteractivityShare=" + this.f133072k + ", enableRaisePublicScreen=" + this.f133073l + ", ignoreUserBanned=" + this.f133074m + ", ignoreAnchorBanned=" + this.f133075n + ", ignoreFixComment=" + this.f133076o + ", ignoreLandscapeBarrageBlock=" + this.f133077p + ", enableQuickComment=" + this.f133078q + ", hintText=" + this.f133079r + ", enableMention=" + this.f133080s + ", enableMentionFriend=" + this.f133081t + ", enableActivityEmoji=" + this.f133082u + ", enableGuideChat=" + this.f133083v + ", enableHighlight=" + this.f133084w + ", enableFusionEmoji=" + this.f133085x + ", enableWordAssociate=" + this.f133086y + ")";
    }

    public CommentInputConfig(State r210, State r211, State r212, State r213, State r214, State r310, State r311, State r312, State r313, State r314, boolean r315, boolean r316, boolean r317, boolean r318, State r319, String r410, boolean r411, State r412, State r413, State r414, int r415) {
        if ((r415 & 1) == 0) goto L5;
        State r100 = State.NotCare;
    L7:
        if ((r415 & 2) == 0) goto L9;
        State r101 = State.NotCare;
    L11:
        if ((r415 & 4) == 0) goto L13;
        State r102 = State.NotCare;
    L15:
        if ((r415 & 8) == 0) goto L17;
        State r103 = State.NotCare;
    L19:
        if ((r415 & 16) == 0) goto L21;
        State r104 = State.NotCare;
    L23:
        if ((r415 & 32) == 0) goto L25;
        State r105 = State.NotCare;
    L27:
        if ((r415 & 64) == 0) goto L29;
        State r106 = State.NotCare;
    L31:
        if ((r415 & 128) == 0) goto L33;
        State r110 = State.NotCare;
    L35:
        if ((r415 & 256) == 0) goto L37;
        State r111 = State.NotCare;
    L39:
        if ((r415 & 512) == 0) goto L41;
        State r112 = State.NotCare;
    L43:
        if ((r415 & 1024) == 0) goto L45;
        State r113 = State.NotCare;
    L47:
        if ((r415 & 2048) == 0) goto L49;
        State r114 = State.NotCare;
    L51:
        if ((r415 & 4096) == 0) goto L53;
        boolean r115 = false;
    L55:
        if ((r415 & 8192) == 0) goto L57;
        boolean r107 = false;
    L58:
        boolean r215 = r107;
        if ((r415 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r415 & 32768) == 0) goto L65;
        boolean r116 = false;
    L67:
        if ((r415 & 65536) == 0) goto L69;
        State r109 = State.NotCare;
    L71:
        if ((r415 & 131072) == 0) goto L73;
        String r117 = null;
    L75:
        if ((r415 & 262144) == 0) goto L77;
        boolean r216 = false;
    L79:
        if ((r415 & 1048576) == 0) goto L81;
        State r118 = State.NotCare;
    L83:
        if ((r415 & 2097152) == 0) goto L85;
        State r119 = State.ForeClose;
    L87:
        if ((r415 & 8388608) == 0) goto L89;
        State r217 = State.NotCare;
    L91:
        if ((r415 & 16777216) == 0) goto L93;
        State r218 = State.NotCare;
    L94:
        Intrinsics.checkNotNullParameter(r100, "enableDanmu");
        Intrinsics.checkNotNullParameter(r101, "enableSubscribeEmoji");
        Intrinsics.checkNotNullParameter(r102, "enableVoiceEntry");
        Intrinsics.checkNotNullParameter(r103, "enableAsr");
        Intrinsics.checkNotNullParameter(r104, "enableVideoEntry");
        Intrinsics.checkNotNullParameter(r105, "enableHotMsg");
        Intrinsics.checkNotNullParameter(r106, "enableEmotionalText");
        Intrinsics.checkNotNullParameter(r110, "enableCustomerEntrance");
        Intrinsics.checkNotNullParameter(r111, "enableFrequentChat");
        Intrinsics.checkNotNullParameter(r112, "enableAI");
        Intrinsics.checkNotNullParameter(r113, "enableInteractivityShare");
        Intrinsics.checkNotNullParameter(r114, "enableRaisePublicScreen");
        Intrinsics.checkNotNullParameter(r109, "enableQuickComment");
        Intrinsics.checkNotNullParameter(r118, "enableActivityEmoji");
        Intrinsics.checkNotNullParameter(r119, "enableGuideChat");
        State r219 = r119;
        Intrinsics.checkNotNullParameter(r217, "enableFusionEmoji");
        Intrinsics.checkNotNullParameter(r218, "enableWordAssociate");
        this.f133062a = r100;
        this.f133063b = r101;
        this.f133064c = r102;
        this.f133065d = r103;
        this.f133066e = r104;
        this.f133067f = r105;
        this.f133068g = r106;
        this.f133069h = r110;
        this.f133070i = r111;
        this.f133071j = r112;
        this.f133072k = r113;
        this.f133073l = r114;
        this.f133074m = r115;
        this.f133075n = r215;
        this.f133076o = r108;
        this.f133077p = r116;
        this.f133078q = r109;
        this.f133079r = r117;
        this.f133080s = r216;
        this.f133081t = false;
        this.f133082u = r118;
        this.f133083v = r219;
        this.f133084w = false;
        this.f133085x = r217;
        this.f133086y = r218;
        return;
    L93:
        r218 = r414;
        goto L94
    L89:
        r217 = r413;
        goto L91
    L85:
        r119 = null;
        goto L87
    L81:
        r118 = r412;
        goto L83
    L77:
        r216 = r411;
        goto L79
    L73:
        r117 = r410;
        goto L75
    L69:
        r109 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r107 = r316;
        goto L58
    L53:
        r115 = r315;
        goto L55
    L49:
        r114 = null;
        goto L51
    L45:
        r113 = r314;
        goto L47
    L41:
        r112 = r313;
        goto L43
    L37:
        r111 = r312;
        goto L39
    L33:
        r110 = r311;
        goto L35
    L29:
        r106 = r310;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
