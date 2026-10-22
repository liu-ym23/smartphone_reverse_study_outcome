package com.obric.aiagent.skill.manager.api;

import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class al {
    private static final al M = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19195a = null;
    private final boolean A;
    private final boolean B;
    private final boolean C;
    private final boolean D;
    private final boolean E;
    private final boolean F;
    private final boolean G;
    private final boolean H;
    private final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final boolean f19196J;
    private final ai K;
    private final int L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f19200e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final long l;
    private final int m;
    private final long n;
    private final long o;
    private final long p;
    private final long q;
    private final int r;
    private final long s;
    private final long t;
    private final long u;
    private final boolean v;
    private final boolean w;
    private final boolean x;
    private final boolean y;
    private final boolean z;

    /* JADX INFO: compiled from: SkillSettings.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final al a() {
            ISkillSettingsService r0 = ISkillSettingsService.Companion.a();
            if (r0 == null) goto L7;
            al r1 = r0.getSettings();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return al.L();
        }
    }

    public al() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, null, false, null, 0, -1, 31, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, al.class) == true) goto L8;
        return false;
    L8:
        al r10 = (al) ZeusTransformUtils.preCheckCast(r9, al.class, "com.obric.aiagent.plugin");
        if (this.f19197b == r10.f19197b) goto L12;
        return false;
    L12:
        if (this.f19198c == r10.f19198c) goto L15;
        return false;
    L15:
        if (this.f19199d == r10.f19199d) goto L18;
        return false;
    L18:
        if (this.f19200e == r10.f19200e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (this.h == r10.h) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L33;
        return false;
    L33:
        if (this.j == r10.j) goto L36;
        return false;
    L36:
        if (this.k == r10.k) goto L39;
        return false;
    L39:
        if (this.l == r10.l) goto L42;
        return false;
    L42:
        if (this.m == r10.m) goto L45;
        return false;
    L45:
        if (this.n == r10.n) goto L48;
        return false;
    L48:
        if (this.o == r10.o) goto L51;
        return false;
    L51:
        if (this.p == r10.p) goto L54;
        return false;
    L54:
        if (this.q == r10.q) goto L57;
        return false;
    L57:
        if (this.r == r10.r) goto L60;
        return false;
    L60:
        if (this.s == r10.s) goto L63;
        return false;
    L63:
        if (this.t == r10.t) goto L66;
        return false;
    L66:
        if (this.u == r10.u) goto L69;
        return false;
    L69:
        if (this.v == r10.v) goto L72;
        return false;
    L72:
        if (this.w == r10.w) goto L75;
        return false;
    L75:
        if (this.x == r10.x) goto L78;
        return false;
    L78:
        if (this.y == r10.y) goto L81;
        return false;
    L81:
        if (this.z == r10.z) goto L84;
        return false;
    L84:
        if (this.A == r10.A) goto L87;
        return false;
    L87:
        if (this.B == r10.B) goto L90;
        return false;
    L90:
        if (this.C == r10.C) goto L93;
        return false;
    L93:
        if (this.D == r10.D) goto L96;
        return false;
    L96:
        if (this.E == r10.E) goto L99;
        return false;
    L99:
        if (this.F == r10.F) goto L102;
        return false;
    L102:
        if (this.G == r10.G) goto L105;
        return false;
    L105:
        if (this.H == r10.H) goto L108;
        return false;
    L108:
        if (d.h.b.o.a(this.I, r10.I) == true) goto L111;
        return false;
    L111:
        if (this.f19196J == r10.f19196J) goto L114;
        return false;
    L114:
        if (d.h.b.o.a(this.K, r10.K) == true) goto L117;
        return false;
    L117:
        if (this.L == r10.L) goto L119;
        return false;
    L119:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.f19197b) * 31) + Integer.hashCode(this.f19198c)) * 31) + Integer.hashCode(this.f19199d)) * 31) + Integer.hashCode(this.f19200e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Long.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Long.hashCode(this.n)) * 31) + Long.hashCode(this.o)) * 31) + Long.hashCode(this.p)) * 31) + Long.hashCode(this.q)) * 31) + Integer.hashCode(this.r)) * 31) + Long.hashCode(this.s)) * 31) + Long.hashCode(this.t)) * 31) + Long.hashCode(this.u)) * 31) + Boolean.hashCode(this.v)) * 31) + Boolean.hashCode(this.w)) * 31) + Boolean.hashCode(this.x)) * 31) + Boolean.hashCode(this.y)) * 31) + Boolean.hashCode(this.z)) * 31) + Boolean.hashCode(this.A)) * 31) + Boolean.hashCode(this.B)) * 31) + Boolean.hashCode(this.C)) * 31) + Boolean.hashCode(this.D)) * 31) + Boolean.hashCode(this.E)) * 31) + Boolean.hashCode(this.F)) * 31) + Boolean.hashCode(this.G)) * 31) + Boolean.hashCode(this.H)) * 31) + this.I.hashCode()) * 31) + Boolean.hashCode(this.f19196J)) * 31) + this.K.hashCode()) * 31) + Integer.hashCode(this.L);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SkillSettings(loadSkillContentLimitChars=").append(this.f19197b).append(", maxEnabledSkillCount=").append(this.f19198c).append(", createSkillMaxNameChars=").append(this.f19199d).append(", createSkillMaxDescriptionChars=").append(this.f19200e).append(", importSkillMaxNameChars=").append(this.f).append(", importSkillMaxDescriptionChars=").append(this.g).append(", importSkillDescriptionPreviewLimitChars=").append(this.h).append(", importSkillBodyPreviewLimitChars=").append(this.i).append(", maxSkillMarkdownChars=").append(this.j).append(", maxAssistedSkillMarkdownChars=").append(this.k).append(", maxLocalSkillPackageBytes=").append(this.l).append(", maxSkillPackageEntries=");
        r0.append(this.m).append(", maxSkillPackageEntryBytes=").append(this.n).append(", maxSkillPackageUncompressedBytes=").append(this.o).append(", maxSkillMarkdownBytes=").append(this.p).append(", maxSkillCoverBytes=").append(this.q).append(", shellOutputLimitChars=").append(this.r).append(", shellDefaultTimeoutMs=").append(this.s).append(", shellHardTimeoutMs=").append(this.t).append(", shellHardTimeoutMarginMs=").append(this.u).append(", exportFilesEnableMediaInfo=").append(this.v).append(", importFilesRestrictHostPathToExternalFilesDir=").append(this.w).append(", skillEnabled=").append(this.x);
        r0.append(", createSkillEnabled=").append(this.y).append(", importSkillEnabled=").append(this.z).append(", importLinkEnabled=").append(this.A).append(", securityAppealEnabled=").append(this.B).append(", securityScanningWarningEnabled=").append(this.C).append(", skillShopUseBoe=").append(this.D).append(", automaticMaintenanceEnabled=").append(this.E).append(", networkRetryAndPollingEnabled=").append(this.F).append(", shellEnabled=").append(this.G).append(", shellManagementEntryEnabled=").append(this.H).append(", defaultShellEnvironmentConfig=").append(this.I).append(", shellOutputSanitiseEnabled=");
        r0.append(this.f19196J).append(", purge=").append(this.K).append(", securityScanProcessingReportThreshold=").append(this.L).append(')');
        return r0.toString();
    }

    public al(int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, long r16, int r18, long r19, long r21, long r23, long r25, int r27, long r28, long r30, long r32, boolean r34, boolean r35, boolean r36, boolean r37, boolean r38, boolean r39, boolean r40, boolean r41, boolean r42, boolean r43, boolean r44, boolean r45, boolean r46, String r47, boolean r48, ai r49, int r50) {
        d.h.b.o.e(r47, "defaultShellEnvironmentConfig");
        d.h.b.o.e(r49, "purge");
        this.f19197b = r6;
        this.f19198c = r7;
        this.f19199d = r8;
        this.f19200e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r18;
        this.n = r19;
        this.o = r21;
        this.p = r23;
        this.q = r25;
        this.r = r27;
        this.s = r28;
        this.t = r30;
        this.u = r32;
        this.v = r34;
        this.w = r35;
        this.x = r36;
        this.y = r37;
        this.z = r38;
        this.A = r39;
        this.B = r40;
        this.C = r41;
        this.D = r42;
        this.E = r43;
        this.F = r44;
        this.G = r45;
        this.H = r46;
        this.I = r47;
        this.f19196J = r48;
        this.K = r49;
        this.L = r50;
    }

    public static final /* synthetic */ al L() {
        return M;
    }

    public final int a() {
        return this.f19197b;
    }

    public final int b() {
        return this.f19198c;
    }

    public final int c() {
        return this.f19199d;
    }

    public final int d() {
        return this.f19200e;
    }

    public final int e() {
        return this.f;
    }

    public final int f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final int h() {
        return this.i;
    }

    public final int i() {
        return this.j;
    }

    public final int j() {
        return this.k;
    }

    public final long k() {
        return this.l;
    }

    public final int l() {
        return this.m;
    }

    public final long m() {
        return this.n;
    }

    public final long n() {
        return this.o;
    }

    public final long o() {
        return this.p;
    }

    public final long p() {
        return this.q;
    }

    public final int q() {
        return this.r;
    }

    public final long r() {
        return this.s;
    }

    public final long s() {
        return this.t;
    }

    public final long t() {
        return this.u;
    }

    public final boolean u() {
        return this.v;
    }

    public final boolean v() {
        return this.w;
    }

    public final boolean w() {
        return this.x;
    }

    public final boolean x() {
        return this.y;
    }

    public final boolean y() {
        return this.z;
    }

    public final boolean z() {
        return this.A;
    }

    public final boolean A() {
        return this.B;
    }

    public final boolean B() {
        return this.C;
    }

    public final boolean C() {
        return this.D;
    }

    public final boolean D() {
        return this.E;
    }

    public final boolean E() {
        return this.F;
    }

    public final boolean F() {
        return this.G;
    }

    public final boolean G() {
        return this.H;
    }

    public final String H() {
        return this.I;
    }

    public final boolean I() {
        return this.f19196J;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ al(int r45, int r46, int r47, int r48, int r49, int r50, int r51, int r52, int r53, int r54, long r55, int r57, long r58, long r60, long r62, long r64, int r66, long r67, long r69, long r71, boolean r73, boolean r74, boolean r75, boolean r76, boolean r77, boolean r78, boolean r79, boolean r80, boolean r81, boolean r82, boolean r83, boolean r84, boolean r85, String r86, boolean r87, ai r88, int r89, int r90, int r91, d.h.b.h r92) {
        if ((r90 & 1) == 0) goto L5;
        int r1 = 16000;
    L6:
        int r3 = 30;
        if ((r90 & 2) == 0) goto L9;
        int r2 = 30;
    L11:
        if ((r90 & 4) == 0) goto L13;
        int r4 = 30;
    L14:
        int r6 = 300;
        if ((r90 & 8) == 0) goto L17;
        int r5 = 300;
    L19:
        if ((r90 & 16) != 0) goto L23;
        r3 = r49;
    L23:
        if ((r90 & 32) == 0) goto L25;
        int r7 = 8192;
    L27:
        if ((r90 & 64) != 0) goto L31;
        r6 = r51;
    L31:
        if ((r90 & 128) == 0) goto L33;
        int r9 = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
    L35:
        if ((r90 & 256) == 0) goto L37;
        int r10 = 1048577;
    L39:
        if ((r90 & 512) == 0) goto L41;
        int r11 = 20000;
    L42:
        long r13 = 1048576;
        if ((r90 & 1024) == 0) goto L45;
        long r15 = 1048576;
    L47:
        if ((r90 & 2048) == 0) goto L49;
        int r12 = 512;
    L51:
        if ((r90 & 4096) == 0) goto L53;
        long r17 = 1048576;
    L55:
        if ((r90 & 8192) == 0) goto L57;
        long r19 = 1048576;
    L59:
        if ((r90 & 16384) != 0) goto L63;
        r13 = r62;
    L63:
        if ((32768 & r90) == 0) goto L65;
        long r21 = 10485760;
    L67:
        if ((65536 & r90) == 0) goto L69;
        int r8 = 8192;
    L70:
        long r24 = 10000;
        if ((r90 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
        long r26 = 10000;
    L75:
        if ((r90 & 262144) == 0) goto L77;
        long r28 = DownloadConstants.HOUR;
    L79:
        if ((r90 & UiType.FLAG_WIFI_QRCODE_CARD) != 0) goto L82;
        r24 = r71;
    L82:
        int r68 = r8;
        int r14 = 1;
        if ((r90 & 1048576) == 0) goto L85;
        boolean r23 = true;
    L87:
        if ((r90 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
        boolean r30 = true;
    L90:
        boolean r32 = false;
        if ((r90 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
        boolean r31 = false;
    L95:
        if ((r90 & UiType.FLAG_APPLET_CARD) == 0) goto L97;
        boolean r33 = false;
    L99:
        if ((r90 & 16777216) == 0) goto L101;
        boolean r34 = false;
    L103:
        if ((r90 & 33554432) == 0) goto L105;
        boolean r35 = true;
    L107:
        if ((r90 & 67108864) == 0) goto L109;
        boolean r36 = false;
    L111:
        if ((r90 & 134217728) == 0) goto L113;
        boolean r37 = false;
    L115:
        if ((r90 & 268435456) == 0) goto L117;
        boolean r38 = false;
    L119:
        if ((r90 & 536870912) == 0) goto L121;
        boolean r39 = true;
    L123:
        if ((r90 & 1073741824) == 0) goto L125;
        boolean r40 = true;
    L127:
        if ((r90 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r0 = false;
    L131:
        if ((r91 & 1) != 0) goto L135;
        r32 = r85;
    L135:
        if ((r91 & 2) == 0) goto L137;
        String r41 = "";
    L139:
        if ((r91 & 4) == 0) goto L141;
        boolean r42 = true;
    L142:
        boolean r810 = r0;
        if ((r91 & 8) == 0) goto L145;
        ai r16 = new ai(null, r14, 0 == true ? 1 : 0);
    L147:
        if ((r91 & 16) == 0) goto L149;
        int r18 = 200;
    L150:
        this(r1, r2, r4, r5, r3, r7, r6, r9, r10, r11, r15, r12, r17, r19, r13, r21, r68, r26, r28, r24, r23, r30, r31, r33, r34, r35, r36, r37, r38, r39, r40, r810, r32, r41, r42, r16, r18);
        return;
    L149:
        r18 = r89;
        goto L150
    L145:
        r16 = r88;
        goto L147
    L141:
        r42 = r87;
        goto L142
    L137:
        r41 = r86;
        goto L139
    L129:
        r0 = r84;
        goto L131
    L125:
        r40 = r83;
        goto L127
    L121:
        r39 = r82;
        goto L123
    L117:
        r38 = r81;
        goto L119
    L113:
        r37 = r80;
        goto L115
    L109:
        r36 = r79;
        goto L111
    L105:
        r35 = r78;
        goto L107
    L101:
        r34 = r77;
        goto L103
    L97:
        r33 = r76;
        goto L99
    L93:
        r31 = r75;
        goto L95
    L89:
        r30 = r74;
        goto L90
    L85:
        r23 = r73;
        goto L87
    L77:
        r28 = r69;
        goto L79
    L73:
        r26 = r67;
        goto L75
    L69:
        r8 = r66;
        goto L70
    L65:
        r21 = r64;
        goto L67
    L57:
        r19 = r60;
        goto L59
    L53:
        r17 = r58;
        goto L55
    L49:
        r12 = r57;
        goto L51
    L45:
        r15 = r55;
        goto L47
    L41:
        r11 = r54;
        goto L42
    L37:
        r10 = r53;
        goto L39
    L33:
        r9 = r52;
        goto L35
    L25:
        r7 = r50;
        goto L27
    L17:
        r5 = r48;
        goto L19
    L13:
        r4 = r47;
        goto L14
    L9:
        r2 = r46;
        goto L11
    L5:
        r1 = r45;
        goto L6
    }

    public final ai J() {
        return this.K;
    }

    public final int K() {
        return this.L;
    }

    public final long a(long r11) {
        Long r0 = Long.valueOf(this.t);
        boolean r3 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Long r7 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        long r2 = r0.longValue();
    L13:
        Long r10 = Long.valueOf(this.u);
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).longValue() > 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r7 = r10;
    L19:
        if (r7 == null) goto L21;
        long r4 = r7.longValue();
    L22:
        long r5 = Long.MAX_VALUE;
        if ((Long.MAX_VALUE - r11) < r4) goto L27;
        r5 = r11 + r4;
    L27:
        return Math.max(r2, r5);
    L21:
        r4 = M.u;
        goto L22
    L12:
        r2 = M.t;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    static {
        f19195a = new a(null);
        M = new al(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, null, false, null, 0, -1, 31, null);
    }
}
