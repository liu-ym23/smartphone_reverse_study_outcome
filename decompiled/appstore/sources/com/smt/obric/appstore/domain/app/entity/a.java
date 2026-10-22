package com.smt.obric.appstore.domain.app.entity;

import com.bytedanceos.common.ui.AppPermissionActivity;
import com.google.common.primitives.Ints;
import com.obric.capabilitykit.common.UiType;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final C0217a I = null;
    public final int A;
    public final AppInstallMode B;
    public final Integer C;
    public final String D;
    public final String E;
    public final long F;
    public final boolean G;
    public final String H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppStatus f17999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f18000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f18002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f18003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f18004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f18005l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f18006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f18007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Long f18008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Long f18009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Long f18010q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f18011r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f18012s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f18013t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f18014u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f18015v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Float f18016w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f18017x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f18018y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f18019z;

    /* JADX INFO: renamed from: com.smt.obric.appstore.domain.app.entity.a$a, reason: collision with other inner class name */
    public static final class C0217a {
        public /* synthetic */ C0217a(DefaultConstructorMarker r10) {
            this();
        }

        public C0217a() {
        }
    }

    static {
        I = new C0217a(null);
    }

    public a(long r10, String r11, long r12, String r13, String r14, AppStatus r15, String r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, String r22, List r23, Long r24, Long r25, Long r26, String r27, float r28, String r29, long r30, long r32, Float r34, String r35, int r36, int r37, int r38, AppInstallMode r39, Integer r40, String r41, String r42, long r43, boolean r45, String r46) {
        q.g(r11, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r13, "appName");
        q.g(r15, "status");
        q.g(r39, "installMode");
        this.f17994a = r10;
        this.f17995b = r11;
        this.f17996c = r12;
        this.f17997d = r13;
        this.f17998e = r14;
        this.f17999f = r15;
        this.f18000g = r16;
        this.f18001h = r17;
        this.f18002i = r18;
        this.f18003j = r19;
        this.f18004k = r20;
        this.f18005l = r21;
        this.f18006m = r22;
        this.f18007n = r23;
        this.f18008o = r24;
        this.f18009p = r25;
        this.f18010q = r26;
        this.f18011r = r27;
        this.f18012s = r28;
        this.f18013t = r29;
        this.f18014u = r30;
        this.f18015v = r32;
        this.f18016w = r34;
        this.f18017x = r35;
        this.f18018y = r36;
        this.f18019z = r37;
        this.A = r38;
        this.B = r39;
        this.C = r40;
        this.D = r41;
        this.E = r42;
        this.F = r43;
        this.G = r45;
        this.H = r46;
    }

    public static /* synthetic */ a b(a r17, long r18, String r20, long r21, String r23, String r24, AppStatus r25, String r26, String r27, boolean r28, boolean r29, boolean r30, boolean r31, String r32, List r33, Long r34, Long r35, Long r36, String r37, float r38, String r39, long r40, long r42, Float r44, String r45, int r46, int r47, int r48, AppInstallMode r49, Integer r50, String r51, String r52, long r53, boolean r55, String r56, int r57, int r58, Object r59) {
        if ((r57 & 1) == 0) goto L5;
        long r10 = r17.f17994a;
    L7:
        if ((r57 & 2) == 0) goto L9;
        String r11 = r17.f17995b;
    L11:
        if ((r57 & 4) == 0) goto L13;
        long r12 = r17.f17996c;
    L15:
        if ((r57 & 8) == 0) goto L17;
        String r13 = r17.f17997d;
    L19:
        if ((r57 & 16) == 0) goto L21;
        String r14 = r17.f17998e;
    L23:
        if ((r57 & 32) == 0) goto L25;
        AppStatus r15 = r17.f17999f;
    L27:
        if ((r57 & 64) == 0) goto L29;
        String r16 = r17.f18000g;
    L31:
        if ((r57 & 128) == 0) goto L33;
        String r19 = r17.f18001h;
    L35:
        if ((r57 & 256) == 0) goto L37;
        boolean r110 = r17.f18002i;
    L39:
        if ((r57 & 512) == 0) goto L41;
        boolean r111 = r17.f18003j;
    L43:
        if ((r57 & 1024) == 0) goto L45;
        boolean r112 = r17.f18004k;
    L47:
        if ((r57 & 2048) == 0) goto L49;
        boolean r113 = r17.f18005l;
    L50:
        boolean r310 = r113;
        if ((r57 & 4096) == 0) goto L53;
        String r114 = r17.f18006m;
    L54:
        String r311 = r114;
        if ((r57 & 8192) == 0) goto L57;
        List r115 = r17.f18007n;
    L58:
        List r312 = r115;
        if ((r57 & 16384) == 0) goto L61;
        Long r116 = r17.f18008o;
    L62:
        Long r313 = r116;
        if ((r57 & UiType.FLAG_SETTINGS_CARD) == 0) goto L65;
        Long r117 = r17.f18009p;
    L66:
        Long r314 = r117;
        if ((r57 & 65536) == 0) goto L69;
        Long r118 = r17.f18010q;
    L70:
        Long r315 = r118;
        if ((r57 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
        String r119 = r17.f18011r;
    L74:
        String r316 = r119;
        if ((r57 & UiType.FLAG_TIMER_CARD) == 0) goto L77;
        float r120 = r17.f18012s;
    L78:
        float r317 = r120;
        if ((r57 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
        String r121 = r17.f18013t;
    L82:
        boolean r318 = r112;
        String r319 = r121;
        if ((r57 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L85;
        long r122 = r17.f18014u;
    L86:
        long r41 = r122;
        if ((r57 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
        long r123 = r17.f18015v;
    L90:
        long r43 = r123;
        if ((r57 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
        Float r124 = r17.f18016w;
    L95:
        if ((8388608 & r57) == 0) goto L97;
        String r125 = r17.f18017x;
    L98:
        String r410 = r125;
        if ((r57 & 16777216) == 0) goto L101;
        int r126 = r17.f18018y;
    L102:
        int r411 = r126;
        if ((r57 & 33554432) == 0) goto L105;
        int r127 = r17.f18019z;
    L106:
        int r412 = r127;
        if ((r57 & 67108864) == 0) goto L109;
        int r128 = r17.A;
    L110:
        int r413 = r128;
        if ((r57 & 134217728) == 0) goto L113;
        AppInstallMode r129 = r17.B;
    L114:
        AppInstallMode r414 = r129;
        if ((r57 & 268435456) == 0) goto L117;
        Integer r130 = r17.C;
    L118:
        Integer r54 = r130;
        if ((r57 & 536870912) == 0) goto L121;
        String r131 = r17.D;
    L122:
        String r510 = r131;
        if ((r57 & Ints.MAX_POWER_OF_TWO) == 0) goto L125;
        String r132 = r17.E;
    L126:
        Float r415 = r124;
        String r511 = r132;
        if ((r57 & Integer.MIN_VALUE) == 0) goto L129;
        long r133 = r17.F;
    L131:
        if ((r58 & 1) == 0) goto L133;
        boolean r22 = r17.G;
    L134:
        boolean r512 = r22;
        if ((r58 & 2) == 0) goto L137;
        String r60 = r17.H;
    L139:
        return r17.a(r10, r11, r12, r13, r14, r15, r16, r19, r110, r111, r318, r310, r311, r312, r313, r314, r315, r316, r317, r319, r41, r43, r415, r410, r411, r412, r413, r414, r54, r510, r511, r133, r512, r60);
    L137:
        r60 = r56;
        goto L139
    L133:
        r22 = r55;
        goto L134
    L129:
        r133 = r53;
        goto L131
    L125:
        r132 = r52;
        goto L126
    L121:
        r131 = r51;
        goto L122
    L117:
        r130 = r50;
        goto L118
    L113:
        r129 = r49;
        goto L114
    L109:
        r128 = r48;
        goto L110
    L105:
        r127 = r47;
        goto L106
    L101:
        r126 = r46;
        goto L102
    L97:
        r125 = r45;
        goto L98
    L93:
        r124 = r44;
        goto L95
    L89:
        r123 = r42;
        goto L90
    L85:
        r122 = r40;
        goto L86
    L81:
        r121 = r39;
        goto L82
    L77:
        r120 = r38;
        goto L78
    L73:
        r119 = r37;
        goto L74
    L69:
        r118 = r36;
        goto L70
    L65:
        r117 = r35;
        goto L66
    L61:
        r116 = r34;
        goto L62
    L57:
        r115 = r33;
        goto L58
    L53:
        r114 = r32;
        goto L54
    L49:
        r113 = r31;
        goto L50
    L45:
        r112 = r30;
        goto L47
    L41:
        r111 = r29;
        goto L43
    L37:
        r110 = r28;
        goto L39
    L33:
        r19 = r27;
        goto L35
    L29:
        r16 = r26;
        goto L31
    L25:
        r15 = r25;
        goto L27
    L21:
        r14 = r24;
        goto L23
    L17:
        r13 = r23;
        goto L19
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r20;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    public final long A() {
        return this.f17994a;
    }

    public final int B() {
        return this.A;
    }

    public final AppInstallMode C() {
        return this.B;
    }

    public final Integer D() {
        return this.C;
    }

    public final String E() {
        return this.f17995b;
    }

    public final String F() {
        return this.H;
    }

    public final AppStatus G() {
        return this.f17999f;
    }

    public final long H() {
        return this.f18015v;
    }

    public final int I() {
        return this.f18018y;
    }

    public final long J() {
        return this.f17996c;
    }

    public final String K() {
        return "AppInstallTask(pkg=" + this.f17995b + ", verCode=" + this.f17996c + ", appName=" + this.f17997d + ", dlId=" + this.f18008o + ')';
    }

    public final boolean L() {
        return this.f18003j;
    }

    public final boolean M() {
        if (this.f18018y == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean N() {
        if (this.f18018y == 3) goto L5;
    L7:
        return false;
    L5:
        if (this.f18019z != 1) goto L7;
        return true;
    }

    public final boolean O() {
        return this.f18002i;
    }

    public final String P() {
        return "AppInstallTask(pkg=" + this.f17995b + ", verCode=" + this.f17996c + ", appName=" + this.f17997d + ", status=" + u.b(this.f17999f.getClass()).getSimpleName() + ", dlId=" + this.f18008o + ", dlStatus=" + this.f18009p + ", dlErrCode=" + this.f18010q + ", dlErrMsg=" + this.f18011r + ", dlProg=" + this.f18012s + ", dlSpeed=" + this.f18016w + ", dlMTime=" + this.f18017x + ", updateMode=" + this.f18018y + ", complianceMode=" + this.f18019z + ", isAutoUpdate=" + this.f18003j + ", dlWifiRequired=" + this.f18004k + ", installFlag=" + this.A + ", installMode=" + this.B.getOrdinal() + ", installResultCode=" + this.C + ", createdAt=" + this.F + ", apkFilePath=" + c() + ", downloadUrl=" + d() + ')';
    }

    public final a a(long r42, String r44, long r45, String r47, String r48, AppStatus r49, String r50, String r51, boolean r52, boolean r53, boolean r54, boolean r55, String r56, List r57, Long r58, Long r59, Long r60, String r61, float r62, String r63, long r64, long r66, Float r68, String r69, int r70, int r71, int r72, AppInstallMode r73, Integer r74, String r75, String r76, long r77, boolean r79, String r80) {
        q.g(r44, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r47, "appName");
        q.g(r49, "status");
        q.g(r73, "installMode");
        return new a(r42, r44, r45, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r66, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r79, r80);
    }

    public final String c() {
        return "***";
    }

    public final String d() {
        return "***";
    }

    public final String e() {
        return this.f18000g;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f17994a == r11.f17994a) goto L12;
        return false;
    L12:
        if (q.b(this.f17995b, r11.f17995b) == true) goto L15;
        return false;
    L15:
        if (this.f17996c == r11.f17996c) goto L18;
        return false;
    L18:
        if (q.b(this.f17997d, r11.f17997d) == true) goto L21;
        return false;
    L21:
        if (q.b(this.f17998e, r11.f17998e) == true) goto L24;
        return false;
    L24:
        if (q.b(this.f17999f, r11.f17999f) == true) goto L27;
        return false;
    L27:
        if (q.b(this.f18000g, r11.f18000g) == true) goto L30;
        return false;
    L30:
        if (q.b(this.f18001h, r11.f18001h) == true) goto L33;
        return false;
    L33:
        if (this.f18002i == r11.f18002i) goto L36;
        return false;
    L36:
        if (this.f18003j == r11.f18003j) goto L39;
        return false;
    L39:
        if (this.f18004k == r11.f18004k) goto L42;
        return false;
    L42:
        if (this.f18005l == r11.f18005l) goto L45;
        return false;
    L45:
        if (q.b(this.f18006m, r11.f18006m) == true) goto L48;
        return false;
    L48:
        if (q.b(this.f18007n, r11.f18007n) == true) goto L51;
        return false;
    L51:
        if (q.b(this.f18008o, r11.f18008o) == true) goto L54;
        return false;
    L54:
        if (q.b(this.f18009p, r11.f18009p) == true) goto L57;
        return false;
    L57:
        if (q.b(this.f18010q, r11.f18010q) == true) goto L60;
        return false;
    L60:
        if (q.b(this.f18011r, r11.f18011r) == true) goto L63;
        return false;
    L63:
        if (Float.compare(this.f18012s, r11.f18012s) == 0) goto L66;
        return false;
    L66:
        if (q.b(this.f18013t, r11.f18013t) == true) goto L69;
        return false;
    L69:
        if (this.f18014u == r11.f18014u) goto L72;
        return false;
    L72:
        if (this.f18015v == r11.f18015v) goto L75;
        return false;
    L75:
        if (q.b(this.f18016w, r11.f18016w) == true) goto L78;
        return false;
    L78:
        if (q.b(this.f18017x, r11.f18017x) == true) goto L81;
        return false;
    L81:
        if (this.f18018y == r11.f18018y) goto L84;
        return false;
    L84:
        if (this.f18019z == r11.f18019z) goto L87;
        return false;
    L87:
        if (this.A == r11.A) goto L90;
        return false;
    L90:
        if (q.b(this.B, r11.B) == true) goto L93;
        return false;
    L93:
        if (q.b(this.C, r11.C) == true) goto L96;
        return false;
    L96:
        if (q.b(this.D, r11.D) == true) goto L99;
        return false;
    L99:
        if (q.b(this.E, r11.E) == true) goto L102;
        return false;
    L102:
        if (this.F == r11.F) goto L105;
        return false;
    L105:
        if (this.G == r11.G) goto L108;
        return false;
    L108:
        if (q.b(this.H, r11.H) == true) goto L110;
        return false;
    L110:
        return true;
    }

    public final String f() {
        return this.f17997d;
    }

    public final String g() {
        return this.D;
    }

    public final int h() {
        return this.f18019z;
    }

    public int hashCode() {
        int r10 = ((((((Long.hashCode(this.f17994a) * 31) + this.f17995b.hashCode()) * 31) + Long.hashCode(this.f17996c)) * 31) + this.f17997d.hashCode()) * 31;
        String r11 = this.f17998e;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (((r10 + r13) * 31) + this.f17999f.hashCode()) * 31;
        String r15 = this.f18000g;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        String r18 = this.f18001h;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (((((((((r17 + r19) * 31) + Boolean.hashCode(this.f18002i)) * 31) + Boolean.hashCode(this.f18003j)) * 31) + Boolean.hashCode(this.f18004k)) * 31) + Boolean.hashCode(this.f18005l)) * 31;
        String r21 = this.f18006m;
        if (r21 != null) goto L17;
        int r22 = 0;
    L18:
        int r23 = (r20 + r22) * 31;
        List r24 = this.f18007n;
        if (r24 != null) goto L21;
        int r25 = 0;
    L22:
        int r26 = (r23 + r25) * 31;
        Long r27 = this.f18008o;
        if (r27 != null) goto L25;
        int r28 = 0;
    L26:
        int r29 = (r26 + r28) * 31;
        Long r30 = this.f18009p;
        if (r30 != null) goto L29;
        int r31 = 0;
    L30:
        int r32 = (r29 + r31) * 31;
        Long r33 = this.f18010q;
        if (r33 != null) goto L33;
        int r34 = 0;
    L34:
        int r35 = (r32 + r34) * 31;
        String r36 = this.f18011r;
        if (r36 != null) goto L37;
        int r37 = 0;
    L38:
        int r38 = (((r35 + r37) * 31) + Float.hashCode(this.f18012s)) * 31;
        String r39 = this.f18013t;
        if (r39 != null) goto L41;
        int r40 = 0;
    L42:
        int r41 = (((((r38 + r40) * 31) + Long.hashCode(this.f18014u)) * 31) + Long.hashCode(this.f18015v)) * 31;
        Float r42 = this.f18016w;
        if (r42 != null) goto L45;
        int r43 = 0;
    L46:
        int r44 = (r41 + r43) * 31;
        String r45 = this.f18017x;
        if (r45 != null) goto L49;
        int r46 = 0;
    L50:
        int r47 = (((((((((r44 + r46) * 31) + Integer.hashCode(this.f18018y)) * 31) + Integer.hashCode(this.f18019z)) * 31) + Integer.hashCode(this.A)) * 31) + this.B.hashCode()) * 31;
        Integer r48 = this.C;
        if (r48 != null) goto L53;
        int r49 = 0;
    L54:
        int r50 = (r47 + r49) * 31;
        String r51 = this.D;
        if (r51 != null) goto L57;
        int r52 = 0;
    L58:
        int r53 = (r50 + r52) * 31;
        String r54 = this.E;
        if (r54 != null) goto L61;
        int r55 = 0;
    L62:
        int r56 = (((((r53 + r55) * 31) + Long.hashCode(this.F)) * 31) + Boolean.hashCode(this.G)) * 31;
        String r57 = this.H;
        if (r57 == null) goto L67;
        r12 = r57.hashCode();
    L67:
        return r56 + r12;
    L61:
        r55 = r54.hashCode();
        goto L62
    L57:
        r52 = r51.hashCode();
        goto L58
    L53:
        r49 = r48.hashCode();
        goto L54
    L49:
        r46 = r45.hashCode();
        goto L50
    L45:
        r43 = r42.hashCode();
        goto L46
    L41:
        r40 = r39.hashCode();
        goto L42
    L37:
        r37 = r36.hashCode();
        goto L38
    L33:
        r34 = r33.hashCode();
        goto L34
    L29:
        r31 = r30.hashCode();
        goto L30
    L25:
        r28 = r27.hashCode();
        goto L26
    L21:
        r25 = r24.hashCode();
        goto L22
    L17:
        r22 = r21.hashCode();
        goto L18
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final long i() {
        return this.F;
    }

    public final long j() {
        return this.f18014u;
    }

    public final String k() {
        return this.E;
    }

    public final Long l() {
        return this.f18010q;
    }

    public final String m() {
        return this.f18011r;
    }

    public final String n() {
        return this.f18013t;
    }

    public final Long o() {
        return this.f18008o;
    }

    public final String p() {
        return this.f18017x;
    }

    public final float q() {
        return this.f18012s;
    }

    public final Float r() {
        return this.f18016w;
    }

    public final Long s() {
        return this.f18009p;
    }

    public final String t() {
        return this.f18006m;
    }

    public String toString() {
        return "AppInstallTask(id=" + this.f17994a + ", pkg=" + this.f17995b + ", versionCode=" + this.f17996c + ", appName=" + this.f17997d + ", iconUrl=" + this.f17998e + ", status=" + this.f17999f + ", apkFilePath=" + this.f18000g + ", expectedMd5=" + this.f18001h + ", isUpdate=" + this.f18002i + ", isAutoUpdate=" + this.f18003j + ", downloadWifiRequired=" + this.f18004k + ", downloadWaitWifi=" + this.f18005l + ", downloadUrl=" + this.f18006m + ", downloadUrlBackups=" + this.f18007n + ", downloadId=" + this.f18008o + ", downloadStatus=" + this.f18009p + ", downloadErrorCode=" + this.f18010q + ", downloadErrorMessage=" + this.f18011r + ", downloadProgress=" + this.f18012s + ", downloadFilePath=" + this.f18013t + ", curBytes=" + this.f18014u + ", totalBytes=" + this.f18015v + ", downloadSpeed=" + this.f18016w + ", downloadModifiedTime=" + this.f18017x + ", updateMode=" + this.f18018y + ", complianceMode=" + this.f18019z + ", installFlag=" + this.A + ", installMode=" + this.B + ", installResultCode=" + this.C + ", businessExtra=" + this.D + ", debugExtra=" + this.E + ", createdAt=" + this.F + ", force=" + this.G + ", sha256=" + this.H + ')';
    }

    public final List u() {
        return this.f18007n;
    }

    public final boolean v() {
        return this.f18005l;
    }

    public final boolean w() {
        return this.f18004k;
    }

    public final String x() {
        return this.f18001h;
    }

    public final boolean y() {
        return this.G;
    }

    public final String z() {
        return this.f17998e;
    }

    public /* synthetic */ a(long r45, String r47, long r48, String r50, String r51, AppStatus r52, String r53, String r54, boolean r55, boolean r56, boolean r57, boolean r58, String r59, List r60, Long r61, Long r62, Long r63, String r64, float r65, String r66, long r67, long r69, Float r71, String r72, int r73, int r74, int r75, AppInstallMode r76, Integer r77, String r78, String r79, long r80, boolean r82, String r83, int r84, int r85, DefaultConstructorMarker r86) {
        if ((r84 & 1) == 0) goto L5;
        long r10 = 0;
    L7:
        if ((r84 & 64) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r84 & 128) == 0) goto L13;
        String r14 = null;
    L15:
        if ((r84 & 1024) == 0) goto L17;
        boolean r17 = true;
    L19:
        if ((r84 & 2048) == 0) goto L21;
        boolean r18 = false;
    L23:
        if ((r84 & 4096) == 0) goto L25;
        String r19 = null;
    L27:
        if ((r84 & 8192) == 0) goto L29;
        List r20 = null;
    L31:
        if ((r84 & 16384) == 0) goto L33;
        Long r21 = null;
    L35:
        if ((32768 & r84) == 0) goto L37;
        Long r22 = null;
    L39:
        if ((65536 & r84) == 0) goto L41;
        Long r23 = null;
    L43:
        if ((131072 & r84) == 0) goto L45;
        String r24 = null;
    L47:
        if ((262144 & r84) == 0) goto L49;
        float r25 = 0.0f;
    L51:
        if ((524288 & r84) == 0) goto L53;
        String r26 = null;
    L55:
        if ((1048576 & r84) == 0) goto L57;
        long r27 = 0;
    L59:
        if ((2097152 & r84) == 0) goto L61;
        long r29 = 0;
    L63:
        if ((4194304 & r84) == 0) goto L65;
        Float r31 = null;
    L67:
        if ((8388608 & r84) == 0) goto L69;
        String r32 = null;
    L71:
        if ((33554432 & r84) == 0) goto L73;
        int r34 = 0;
    L75:
        if ((67108864 & r84) == 0) goto L77;
        int r35 = 0;
    L79:
        if ((134217728 & r84) == 0) goto L81;
        AppInstallMode r36 = AppInstallMode.c.f17964a;
    L83:
        if ((268435456 & r84) == 0) goto L85;
        Integer r37 = null;
    L87:
        if ((536870912 & r84) == 0) goto L89;
        String r38 = null;
    L91:
        if ((r84 & Ints.MAX_POWER_OF_TWO) == 0) goto L93;
        String r39 = null;
    L95:
        if ((r85 & 1) == 0) goto L97;
        boolean r42 = false;
    L99:
        if ((r85 & 2) == 0) goto L101;
        String r43 = null;
    L102:
        this(r10, r47, r48, r50, r51, r52, r13, r14, r55, r56, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r31, r32, r73, r34, r35, r36, r37, r38, r39, r80, r42, r43);
        return;
    L101:
        r43 = r83;
        goto L102
    L97:
        r42 = r82;
        goto L99
    L93:
        r39 = r79;
        goto L95
    L89:
        r38 = r78;
        goto L91
    L85:
        r37 = r77;
        goto L87
    L81:
        r36 = r76;
        goto L83
    L77:
        r35 = r75;
        goto L79
    L73:
        r34 = r74;
        goto L75
    L69:
        r32 = r72;
        goto L71
    L65:
        r31 = r71;
        goto L67
    L61:
        r29 = r69;
        goto L63
    L57:
        r27 = r67;
        goto L59
    L53:
        r26 = r66;
        goto L55
    L49:
        r25 = r65;
        goto L51
    L45:
        r24 = r64;
        goto L47
    L41:
        r23 = r63;
        goto L43
    L37:
        r22 = r62;
        goto L39
    L33:
        r21 = r61;
        goto L35
    L29:
        r20 = r60;
        goto L31
    L25:
        r19 = r59;
        goto L27
    L21:
        r18 = r58;
        goto L23
    L17:
        r17 = r57;
        goto L19
    L13:
        r14 = r54;
        goto L15
    L9:
        r13 = r53;
        goto L11
    L5:
        r10 = r45;
        goto L7
    }
}
