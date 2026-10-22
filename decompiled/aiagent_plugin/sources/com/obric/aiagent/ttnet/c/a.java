package com.obric.aiagent.ttnet.c;

import android.net.Uri;
import com.bytedance.ttnet.TTNetInit;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.os.libs.NetworkCapability;
import com.obric.aiagent.os.libs.NetworkInfo;
import com.obric.aiagent.os.libs.NetworkStateInfo;
import com.obric.aiagent.os.libs.VipStrategyReport;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.autogui.common.a.d;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.o.f;
import d.o.i;
import d.o.k;
import d.x;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: compiled from: ObricTTNetEventReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "ObricTTNetReport";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile C0480a f22215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile long f22216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ExecutorService f22217d = null;

    /* JADX INFO: renamed from: com.obric.aiagent.ttnet.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObricTTNetEventReporter.kt */
    private static final class C0480a {
        private final int A;
        private final int B;
        private final int C;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f22219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f22220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f22221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f22222e;
        private final boolean f;
        private final boolean g;
        private final boolean h;
        private final boolean i;
        private final boolean j;
        private final boolean k;
        private final boolean l;
        private final int m;
        private final String n;
        private final int o;
        private final int p;
        private final int q;
        private final int r;
        private final int s;
        private final int t;
        private final int u;
        private final int v;
        private final int w;
        private final int x;
        private final boolean y;
        private final int z;

        public C0480a() {
            this(null, 0, 0, 0, 0, false, false, false, false, false, false, false, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 536870911, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0480a.class) == true) goto L8;
            return false;
        L8:
            C0480a r6 = (C0480a) ZeusTransformUtils.preCheckCast(r5, C0480a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f22218a, r6.f22218a) == true) goto L12;
            return false;
        L12:
            if (this.f22219b == r6.f22219b) goto L15;
            return false;
        L15:
            if (this.f22220c == r6.f22220c) goto L18;
            return false;
        L18:
            if (this.f22221d == r6.f22221d) goto L21;
            return false;
        L21:
            if (this.f22222e == r6.f22222e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (o.a(this.n, r6.n) == true) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L54;
            return false;
        L54:
            if (this.p == r6.p) goto L57;
            return false;
        L57:
            if (this.q == r6.q) goto L60;
            return false;
        L60:
            if (this.r == r6.r) goto L63;
            return false;
        L63:
            if (this.s == r6.s) goto L66;
            return false;
        L66:
            if (this.t == r6.t) goto L69;
            return false;
        L69:
            if (this.u == r6.u) goto L72;
            return false;
        L72:
            if (this.v == r6.v) goto L75;
            return false;
        L75:
            if (this.w == r6.w) goto L78;
            return false;
        L78:
            if (this.x == r6.x) goto L81;
            return false;
        L81:
            if (this.y == r6.y) goto L84;
            return false;
        L84:
            if (this.z == r6.z) goto L87;
            return false;
        L87:
            if (this.A == r6.A) goto L90;
            return false;
        L90:
            if (this.B == r6.B) goto L93;
            return false;
        L93:
            if (this.C == r6.C) goto L95;
            return false;
        L95:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((((this.f22218a.hashCode() * 31) + Integer.hashCode(this.f22219b)) * 31) + Integer.hashCode(this.f22220c)) * 31) + Integer.hashCode(this.f22221d)) * 31) + Integer.hashCode(this.f22222e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + Boolean.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + this.n.hashCode()) * 31) + Integer.hashCode(this.o)) * 31) + Integer.hashCode(this.p)) * 31) + Integer.hashCode(this.q)) * 31) + Integer.hashCode(this.r)) * 31) + Integer.hashCode(this.s)) * 31) + Integer.hashCode(this.t)) * 31) + Integer.hashCode(this.u)) * 31) + Integer.hashCode(this.v)) * 31) + Integer.hashCode(this.w)) * 31) + Integer.hashCode(this.x)) * 31) + Boolean.hashCode(this.y)) * 31) + Integer.hashCode(this.z)) * 31) + Integer.hashCode(this.A)) * 31) + Integer.hashCode(this.B)) * 31) + Integer.hashCode(this.C);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("OsNetworkCache(osCapabilityType=").append(this.f22218a).append(", osNetworkFreq=").append(this.f22219b).append(", osNetworkRssi=").append(this.f22220c).append(", osNetworkLinkSpeed=").append(this.f22221d).append(", osNetworkRxLinkSpeed=").append(this.f22222e).append(", osIsIdleMode=").append(this.f).append(", osIsPowerSaveMode=").append(this.g).append(", osIsSleepMode=").append(this.h).append(", isVipNetworkFeatureEnabled=").append(this.i).append(", isWifiAccelEnabled=").append(this.j).append(", isSuperStableEnabled=").append(this.k).append(", isVipChannelEnabled=");
            r0.append(this.l).append(", rateStrategyType=").append(this.m).append(", foregroundAppPkg=").append(this.n).append(", foregroundRateLimit=").append(this.o).append(", vipChannelRateLimit=").append(this.p).append(", backgroundRateLimit=").append(this.q).append(", foregroundThroughput=").append(this.r).append(", vipChannelThroughput=").append(this.s).append(", backgroundThroughput=").append(this.t).append(", doubaoRtt=").append(this.u).append(", doubaoAvgRttFiveSec=").append(this.v).append(", doubaoMaxRttFiveSec=").append(this.w);
            r0.append(", doubaoMinRttFiveSec=").append(this.x).append(", isVpnEnabled=").append(this.y).append(", wifiCurrentThroughput=").append(this.z).append(", wifiRtt=").append(this.A).append(", cellularThroughput=").append(this.B).append(", cellularRtt=").append(this.C).append(')');
            return r0.toString();
        }

        public C0480a(String r5, int r6, int r7, int r8, int r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, int r17, String r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, boolean r29, int r30, int r31, int r32, int r33) {
            o.e(r5, "osCapabilityType");
            o.e(r18, "foregroundAppPkg");
            this.f22218a = r5;
            this.f22219b = r6;
            this.f22220c = r7;
            this.f22221d = r8;
            this.f22222e = r9;
            this.f = r10;
            this.g = r11;
            this.h = r12;
            this.i = r13;
            this.j = r14;
            this.k = r15;
            this.l = r16;
            this.m = r17;
            this.n = r18;
            this.o = r19;
            this.p = r20;
            this.q = r21;
            this.r = r22;
            this.s = r23;
            this.t = r24;
            this.u = r25;
            this.v = r26;
            this.w = r27;
            this.x = r28;
            this.y = r29;
            this.z = r30;
            this.A = r31;
            this.B = r32;
            this.C = r33;
        }

        public /* synthetic */ C0480a(String r31, int r32, int r33, int r34, int r35, boolean r36, boolean r37, boolean r38, boolean r39, boolean r40, boolean r41, boolean r42, int r43, String r44, int r45, int r46, int r47, int r48, int r49, int r50, int r51, int r52, int r53, int r54, boolean r55, int r56, int r57, int r58, int r59, int r60, h r61) {
            String r2 = "UNKNOWN";
            if ((r60 & 1) == 0) goto L5;
            String r1 = "UNKNOWN";
        L7:
            if ((r60 & 2) == 0) goto L9;
            int r3 = -1;
        L11:
            if ((r60 & 4) == 0) goto L13;
            int r5 = -1;
        L15:
            if ((r60 & 8) == 0) goto L17;
            int r6 = -1;
        L19:
            if ((r60 & 16) == 0) goto L21;
            int r7 = -1;
        L23:
            if ((r60 & 32) == 0) goto L25;
            boolean r8 = false;
        L27:
            if ((r60 & 64) == 0) goto L29;
            boolean r10 = false;
        L31:
            if ((r60 & 128) == 0) goto L33;
            boolean r11 = false;
        L35:
            if ((r60 & 256) == 0) goto L37;
            boolean r12 = false;
        L39:
            if ((r60 & 512) == 0) goto L41;
            boolean r13 = false;
        L43:
            if ((r60 & 1024) == 0) goto L45;
            boolean r14 = false;
        L47:
            if ((r60 & 2048) == 0) goto L49;
            boolean r15 = false;
        L51:
            if ((r60 & 4096) == 0) goto L53;
            int r4 = -1;
        L55:
            if ((r60 & 8192) != 0) goto L59;
            r2 = r44;
        L59:
            if ((r60 & 16384) == 0) goto L61;
            int r9 = -1;
        L63:
            if ((r60 & 32768) == 0) goto L65;
            int r16 = -1;
        L67:
            if ((r60 & 65536) == 0) goto L69;
            int r17 = -1;
        L71:
            if ((r60 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
            int r18 = -1;
        L75:
            if ((r60 & 262144) == 0) goto L77;
            int r19 = -1;
        L79:
            if ((r60 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
            int r20 = -1;
        L83:
            if ((r60 & 1048576) == 0) goto L85;
            int r21 = -1;
        L87:
            if ((r60 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
            int r22 = -1;
        L91:
            if ((r60 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
            int r23 = -1;
        L95:
            if ((r60 & UiType.FLAG_APPLET_CARD) == 0) goto L97;
            int r24 = -1;
        L99:
            if ((r60 & 16777216) == 0) goto L101;
            boolean r25 = false;
        L103:
            if ((r60 & 33554432) == 0) goto L105;
            int r26 = -1;
        L107:
            if ((r60 & 67108864) == 0) goto L109;
            int r27 = -1;
        L111:
            if ((r60 & 134217728) == 0) goto L113;
            int r28 = -1;
        L115:
            if ((r60 & 268435456) == 0) goto L117;
            int r0 = -1;
        L118:
            this(r1, r3, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r4, r2, r9, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r0);
            return;
        L117:
            r0 = r59;
            goto L118
        L113:
            r28 = r58;
            goto L115
        L109:
            r27 = r57;
            goto L111
        L105:
            r26 = r56;
            goto L107
        L101:
            r25 = r55;
            goto L103
        L97:
            r24 = r54;
            goto L99
        L93:
            r23 = r53;
            goto L95
        L89:
            r22 = r52;
            goto L91
        L85:
            r21 = r51;
            goto L87
        L81:
            r20 = r50;
            goto L83
        L77:
            r19 = r49;
            goto L79
        L73:
            r18 = r48;
            goto L75
        L69:
            r17 = r47;
            goto L71
        L65:
            r16 = r46;
            goto L67
        L61:
            r9 = r45;
            goto L63
        L53:
            r4 = r43;
            goto L55
        L49:
            r15 = r42;
            goto L51
        L45:
            r14 = r41;
            goto L47
        L41:
            r13 = r40;
            goto L43
        L37:
            r12 = r39;
            goto L39
        L33:
            r11 = r38;
            goto L35
        L29:
            r10 = r37;
            goto L31
        L25:
            r8 = r36;
            goto L27
        L21:
            r7 = r35;
            goto L23
        L17:
            r6 = r34;
            goto L19
        L13:
            r5 = r33;
            goto L15
        L9:
            r3 = r32;
            goto L11
        L5:
            r1 = r31;
            goto L7
        }

        public final String a() {
            return this.f22218a;
        }

        public final int b() {
            return this.f22219b;
        }

        public final int c() {
            return this.f22220c;
        }

        public final int d() {
            return this.f22221d;
        }

        public final int e() {
            return this.f22222e;
        }

        public final boolean f() {
            return this.f;
        }

        public final boolean g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public final boolean i() {
            return this.i;
        }

        public final boolean j() {
            return this.j;
        }

        public final boolean k() {
            return this.k;
        }

        public final boolean l() {
            return this.l;
        }

        public final int m() {
            return this.m;
        }

        public final String n() {
            return this.n;
        }

        public final int o() {
            return this.o;
        }

        public final int p() {
            return this.p;
        }

        public final int q() {
            return this.q;
        }

        public final int r() {
            return this.r;
        }

        public final int s() {
            return this.s;
        }

        public final int t() {
            return this.t;
        }

        public final int u() {
            return this.u;
        }

        public final int v() {
            return this.v;
        }

        public final int w() {
            return this.w;
        }

        public final int x() {
            return this.x;
        }

        public final boolean y() {
            return this.y;
        }

        public final int z() {
            return this.z;
        }

        public final int A() {
            return this.A;
        }

        public final int B() {
            return this.B;
        }

        public final int C() {
            return this.C;
        }
    }

    public static /* synthetic */ void lambda$0gMrtdV5tUlSAgERf4ePNtCeKhg(Long r0, Long r1, String r2, String r3, String r4, Integer r5, JSONObject r6, String r7) {
        e(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: lambda$8VlP3-am3VEXy-J64l5S7dXGSn4, reason: not valid java name */
    public static /* synthetic */ Thread m386lambda$8VlP3am3VEXyJ64l5S7dXGSn4(Runnable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$CTXhSRSDgQKE7ctEZ53nuJ-iUjw, reason: not valid java name */
    public static /* synthetic */ void m387lambda$CTXhSRSDgQKE7ctEZ53nuJiUjw(Long r0, Long r1, String r2, String r3, String r4, Integer r5, JSONObject r6, String r7) {
        d(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: lambda$z6wG6uj0MU8F-im7NZGoIBI3SR0, reason: not valid java name */
    public static /* synthetic */ x m388lambda$z6wG6uj0MU8Fim7NZGoIBI3SR0() {
        return c();
    }

    private a() {
    }

    static {
        f22214a = new a();
        f22215b = new C0480a(null, 0, 0, 0, 0, false, false, false, false, false, false, false, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 536870911, null);
        f22217d = Executors.newSingleThreadExecutor($$Lambda$a$8VlP3am3VEXyJ64l5S7dXGSn4.INSTANCE);
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "obric_ttnet_event_reporter");
    }

    public final void a(final Long r12, final Long r13, final String r14, final String r15, final String r16, final Integer r17, final JSONObject r18, final String r19) {
        if (b() == true) goto L5;
        return;
    L5:
        f22217d.execute(new $$Lambda$a$CTXhSRSDgQKE7ctEZ53nuJiUjw(r12, r13, r14, r15, r16, r17, r18, r19));
    }

    private static final void d(Long r10, Long r11, String r12, String r13, String r14, Integer r15, JSONObject r16, String r17) {
        f22214a.a("obric_ttnet_api_error_event", r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public final void b(final Long r12, final Long r13, final String r14, final String r15, final String r16, final Integer r17, final JSONObject r18, final String r19) {
        if (b() == true) goto L5;
        return;
    L5:
        f22217d.execute(new $$Lambda$a$0gMrtdV5tUlSAgERf4ePNtCeKhg(r12, r13, r14, r15, r16, r17, r18, r19));
    }

    private static final void e(Long r10, Long r11, String r12, String r13, String r14, Integer r15, JSONObject r16, String r17) {
        f22214a.a("obric_ttnet_api_ok_event", r10, r11, r12, r13, r14, r15, r16, r17);
    }

    private final void a(String r10, Long r11, Long r12, String r13, String r14, String r15, Integer r16, JSONObject r17, String r18) {
        if (a(r13) == false) goto L5;
        return;
    L5:
        JSONObject r0 = c(r11, r12, r13, r14, r15, r16, r17, r18);
        IAppLog r1 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        r1.reportToFlow(r10, r0);
        return;
    }

    private final JSONObject c(Long r14, Long r15, String r16, String r17, String r18, Integer r19, JSONObject r20, String r21) {
        Object r3 = "UNKNOWN";
        JSONObject r4 = new JSONObject();
        boolean r0 = IRuntimeContext.Companion.isMainProcess();     // Catch: Throwable -> L5
    L7:
        boolean r5 = r0;
        String r6 = IRuntimeContext.Companion.getProcessName();     // Catch: Throwable -> L10
    L61:
        int r1 = TTNetInit.getEffectiveConnectionType();     // Catch: Throwable -> L14
    L16:
        if (r16 == null) goto L25;
        Uri r2 = Uri.parse(r16);
        if (r2 == null) goto L25;
        String r7 = r2.getHost();
        if (r7 != null) goto L22;
        r7 = "UNKNOWN";
    L22:
        String r8 = r2.getPath();
        if (r8 != null) goto L26;
        r8 = "UNKNOWN";
    L26:
        a r9 = f22214a;
        String r10 = r9.a(r21, "mn_state");
        if (r10 != null) goto L29;
        r10 = "UNKNOWN";
    L29:
        String r11 = r9.a(r21, "proxy");
        if (r11 != null) goto L32;
        r11 = "UNKNOWN";
    L32:
        r4.put("o_is_main_pro", r5);
        r4.put("o_pro_name", r6);
        r4.put("o_screen_state", r9.a().toString());
        r4.put("o_project_name", "aa");
        long r12 = -1;
        if (r14 == null) goto L35;
        long r13 = r14.longValue();
    L36:
        r4.put("o_send_dur", r13);
        if (r15 == null) goto L39;
        r12 = r15.longValue();
    L39:
        r4.put("o_send_time", r12);
        if (r16 != null) goto L42;
        String r22 = "UNKNOWN";
    L43:
        r4.put("o_send_url", r22);
        r4.put("o_send_api", r7);
        r4.put("o_send_path", r8);
        if (r17 != null) goto L46;
        String r23 = "UNKNOWN";
    L47:
        r4.put("o_send_ip", r23);
        if (r18 != null) goto L50;
        String r24 = "EMPTY_CODE";
    L51:
        r4.put("o_trace_code", r24);
        if (r19 == null) goto L55;
        r3 = r19;
    L55:
        r4.put("o_net_status", r3);
        r4.put("ot_ec_type", r1);
        r4.put("ot_mn_state", r10);
        r4.put("ot_proxy", r11);
        r9.a(r4);
        return r4;
    L50:
        r24 = r18;
        goto L51
    L46:
        r23 = r17;
        goto L47
    L42:
        r22 = r16;
        goto L43
    L35:
        r13 = -1;
    L25:
        r8 = "UNKNOWN";
        r7 = r8;
    L14:
        th = move-exception;
        ILogDepend.Companion.w(TAG, th);
        r1 = -404;
    L10:
        th = move-exception;
        ILogDepend.Companion.w(TAG, th);
        r6 = "UNKNOWN";
    L5:
        th = move-exception;
        ILogDepend.Companion.w(TAG, th);
        r0 = true;
        goto L7
    }

    private final void a(JSONObject r38) {
        long r2 = System.currentTimeMillis();
        boolean r4 = false;
        if ((r2 - f22216c) <= 1000) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L174;
    L172:
        C0480a r1 = f22215b;
        r38.put("os_capability_type", r1.a());
        r38.put("os_frep_type", r1.b());
        r38.put("os_rssi", r1.c());
        r38.put("os_link_speed", r1.d());
        r38.put("os_rx_link_speed", r1.e());
        r38.put("os_is_idle_mode", r1.f());
        r38.put("os_is_power_save_mode", r1.g());
        r38.put("os_is_sleep_mode", r1.h());
        r38.put("os_is_vip_network_feature_enabled", r1.i());
        r38.put("os_is_wifi_accel_enabled", r1.j());
        r38.put("os_is_super_stable_enabled", r1.k());
        r38.put("os_is_vip_channel_enabled", r1.l());
        r38.put("os_rate_strategy_type", r1.m());
        r38.put("os_foreground_app_pkg", r1.n());
        r38.put("os_foreground_rate_limit", r1.o());
        r38.put("os_vip_channel_rate_limit", r1.p());
        r38.put("os_background_rate_limit", r1.q());
        r38.put("os_foreground_throughput", r1.r());
        r38.put("os_vip_channel_throughput", r1.s());
        r38.put("os_background_throughput", r1.t());
        r38.put("os_doubao_rtt", r1.u());
        r38.put("os_doubao_avg_rtt_five_sec", r1.v());
        r38.put("os_doubao_max_rtt_five_sec", r1.w());
        r38.put("os_doubao_min_rtt_five_sec", r1.x());
        r38.put("os_is_vpn_enabled", r1.y());
        r38.put("os_wifi_current_throughput", r1.z());
        r38.put("os_wifi_rtt", r1.A());
        r38.put("os_cellular_throughput", r1.B());
        r38.put("os_cellular_rtt", r1.C());
        return;
    L174:
        NetworkStateInfo r3 = com.obric.aiagent.os.libs.a.a().b();     // Catch: Throwable -> L167
        if (r3 == null) goto L165;
        VipStrategyReport r5 = r3.getVipStrategyReport();     // Catch: Throwable -> L167
        NetworkInfo r6 = r3.getDefaultNetworkInfo();     // Catch: Throwable -> L167
        if (r6 == null) goto L13;
        String r7 = r6.getCapabilityType();     // Catch: Throwable -> L167
        if (r7 == null) goto L13;
    L14:
        String r8 = r7;
        NetworkInfo r9 = r3.getDefaultNetworkInfo();     // Catch: Throwable -> L167
        if (r9 == null) goto L21;
        NetworkCapability r10 = r9.getCapability();     // Catch: Throwable -> L167
        if (r10 == null) goto L21;
        Integer r11 = r10.getFreq();     // Catch: Throwable -> L167
        if (r11 == null) goto L21;
        int r12 = r11.intValue();     // Catch: Throwable -> L167
    L22:
        NetworkInfo r13 = r3.getDefaultNetworkInfo();     // Catch: Throwable -> L167
        if (r13 == null) goto L29;
        NetworkCapability r14 = r13.getCapability();     // Catch: Throwable -> L167
        if (r14 == null) goto L29;
        Integer r15 = r14.getRssi();     // Catch: Throwable -> L167
        if (r15 == null) goto L29;
        int r16 = r15.intValue();     // Catch: Throwable -> L167
    L30:
        NetworkInfo r17 = r3.getDefaultNetworkInfo();     // Catch: Throwable -> L167
        if (r17 == null) goto L37;
        NetworkCapability r18 = r17.getCapability();     // Catch: Throwable -> L167
        if (r18 == null) goto L37;
        Integer r19 = r18.getLinkSpeed();     // Catch: Throwable -> L167
        if (r19 == null) goto L37;
        int r110 = r19.intValue();     // Catch: Throwable -> L167
    L38:
        NetworkInfo r20 = r3.getDefaultNetworkInfo();     // Catch: Throwable -> L167
        if (r20 == null) goto L45;
        NetworkCapability r21 = r20.getCapability();     // Catch: Throwable -> L167
        if (r21 == null) goto L45;
        Integer r22 = r21.getRxLinkSpeed();     // Catch: Throwable -> L167
        if (r22 == null) goto L45;
        int r111 = r22.intValue();     // Catch: Throwable -> L167
    L46:
        Boolean r23 = r3.isIdleMode();     // Catch: Throwable -> L167
        if (r23 == null) goto L49;
        boolean r112 = r23.booleanValue();     // Catch: Throwable -> L167
    L50:
        Boolean r24 = r3.isPowerSaveMode();     // Catch: Throwable -> L167
        if (r24 == null) goto L53;
        boolean r113 = r24.booleanValue();     // Catch: Throwable -> L167
    L54:
        Boolean r25 = r3.isSleepMode();     // Catch: Throwable -> L167
        if (r25 == null) goto L57;
        boolean r26 = r25.booleanValue();     // Catch: Throwable -> L167
    L58:
        if (r5 == null) goto L62;
        Boolean r27 = r5.isVipNetworkFeatureEnabled();     // Catch: Throwable -> L167
        if (r27 == null) goto L62;
        boolean r114 = r27.booleanValue();     // Catch: Throwable -> L167
    L63:
        if (r5 == null) goto L67;
        Boolean r28 = r5.isWifiAccelEnabled();     // Catch: Throwable -> L167
        if (r28 == null) goto L67;
        boolean r115 = r28.booleanValue();     // Catch: Throwable -> L167
    L68:
        if (r5 == null) goto L72;
        Boolean r29 = r5.isSuperStableEnabled();     // Catch: Throwable -> L167
        if (r29 == null) goto L72;
        boolean r116 = r29.booleanValue();     // Catch: Throwable -> L167
    L73:
        if (r5 == null) goto L77;
        Boolean r30 = r5.isVipChannelEnabled();     // Catch: Throwable -> L167
        if (r30 == null) goto L77;
        boolean r117 = r30.booleanValue();     // Catch: Throwable -> L167
    L79:
        if (r5 == null) goto L83;
        Integer r31 = r5.getRateStrategyType();     // Catch: Throwable -> L167
        if (r31 == null) goto L83;
        int r118 = r31.intValue();     // Catch: Throwable -> L167
    L84:
        if (r5 == null) goto L87;
        String r32 = r5.getForegroundAppPkg();     // Catch: Throwable -> L167
        if (r32 == null) goto L87;
    L88:
        String r210 = r32;
        if (r5 == null) goto L93;
        Integer r33 = r5.getForegroundRateLimit();     // Catch: Throwable -> L167
        if (r33 == null) goto L93;
        int r211 = r33.intValue();     // Catch: Throwable -> L167
    L94:
        if (r5 == null) goto L98;
        Integer r34 = r5.getVipChannelRateLimit();     // Catch: Throwable -> L167
        if (r34 == null) goto L98;
        int r212 = r34.intValue();     // Catch: Throwable -> L167
    L99:
        if (r5 == null) goto L103;
        Integer r35 = r5.getBackgroundRateLimit();     // Catch: Throwable -> L167
        if (r35 == null) goto L103;
        int r213 = r35.intValue();     // Catch: Throwable -> L167
    L104:
        if (r5 == null) goto L108;
        Integer r36 = r5.getForegroundThroughput();     // Catch: Throwable -> L167
        if (r36 == null) goto L108;
        int r214 = r36.intValue();     // Catch: Throwable -> L167
    L109:
        if (r5 == null) goto L113;
        Integer r37 = r5.getVipChannelThroughput();     // Catch: Throwable -> L167
        if (r37 == null) goto L113;
        int r215 = r37.intValue();     // Catch: Throwable -> L167
    L114:
        if (r5 == null) goto L118;
        Integer r39 = r5.getBackgroundThroughput();     // Catch: Throwable -> L167
        if (r39 == null) goto L118;
        int r216 = r39.intValue();     // Catch: Throwable -> L167
    L119:
        if (r5 == null) goto L123;
        Integer r40 = r5.getDoubaoRtt();     // Catch: Throwable -> L167
        if (r40 == null) goto L123;
        int r217 = r40.intValue();     // Catch: Throwable -> L167
    L124:
        if (r5 == null) goto L128;
        Integer r41 = r5.getDoubaoAvgRttFiveSec();     // Catch: Throwable -> L167
        if (r41 == null) goto L128;
        int r218 = r41.intValue();     // Catch: Throwable -> L167
    L129:
        if (r5 == null) goto L133;
        Integer r42 = r5.getDoubaoMaxRttFiveSec();     // Catch: Throwable -> L167
        if (r42 == null) goto L133;
        int r219 = r42.intValue();     // Catch: Throwable -> L167
    L134:
        if (r5 == null) goto L138;
        Integer r43 = r5.getDoubaoMinRttFiveSec();     // Catch: Throwable -> L167
        if (r43 == null) goto L138;
        int r310 = r43.intValue();     // Catch: Throwable -> L167
    L139:
        if (r5 == null) goto L143;
        Boolean r44 = r5.isVpnEnabled();     // Catch: Throwable -> L167
        if (r44 == null) goto L143;
        r4 = r44.booleanValue();     // Catch: Throwable -> L167
    L143:
        boolean r311 = r4;
        if (r5 == null) goto L148;
        Integer r45 = r5.getWifiCurrentThroughput();     // Catch: Throwable -> L167
        if (r45 == null) goto L148;
        int r312 = r45.intValue();     // Catch: Throwable -> L167
    L149:
        if (r5 == null) goto L153;
        Integer r46 = r5.getWifiRtt();     // Catch: Throwable -> L167
        if (r46 == null) goto L153;
        int r313 = r46.intValue();     // Catch: Throwable -> L167
    L154:
        if (r5 == null) goto L158;
        Integer r47 = r5.getCellularThroughput();     // Catch: Throwable -> L167
        if (r47 == null) goto L158;
        int r314 = r47.intValue();     // Catch: Throwable -> L167
    L159:
        if (r5 == null) goto L163;
        Integer r48 = r5.getCellularRtt();     // Catch: Throwable -> L167
        if (r48 == null) goto L163;
        int r315 = r48.intValue();     // Catch: Throwable -> L167
    L164:
        f22215b = new C0480a(r8, r12, r16, r110, r111, r112, r113, r26, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315);     // Catch: Throwable -> L167
        f22216c = r2;     // Catch: Throwable -> L167
    L163:
        r315 = -1;
    L158:
        r314 = -1;
    L153:
        r313 = -1;
    L148:
        r312 = -1;
    L138:
        r310 = -1;
    L133:
        r219 = -1;
    L128:
        r218 = -1;
    L123:
        r217 = -1;
    L118:
        r216 = -1;
    L113:
        r215 = -1;
    L108:
        r214 = -1;
    L103:
        r213 = -1;
    L98:
        r212 = -1;
    L93:
        r211 = -1;
    L87:
        r32 = "UNKNOWN";
    L83:
        r118 = -1;
    L77:
        r117 = false;
    L72:
        r116 = false;
    L67:
        r115 = false;
    L62:
        r114 = false;
        goto L63
    L57:
        r26 = false;
        goto L58
    L53:
        r113 = false;
        goto L54
    L49:
        r112 = false;
    L45:
        r111 = -404;
    L37:
        r110 = -404;
    L29:
        r16 = -404;
    L21:
        r12 = -404;
    L13:
        r7 = "EMPTY_TYPE";
        goto L14
    L165:
        $$Lambda$a$z6wG6uj0MU8Fim7NZGoIBI3SR0 r49 = $$Lambda$a$z6wG6uj0MU8Fim7NZGoIBI3SR0.INSTANCE;     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        if (IAppContext.Companion.isDebug() == true) goto L171;
        ILogDepend.Companion.e(TAG, "ERROR_USING_CAE", th);
        goto L172
    L171:
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    private static final x c() {
        ILogDepend.Companion.i(TAG, "EMPTY_RESULT_USING_CAE");
        return x.f38692a;
    }

    private final String a() {
        if (com.obric.aiagent.utils.a.b.f22307a.a() == false) goto L5;
        String r3 = "SCREEN_ON";
    L6:
        ILogDepend.Companion.i(TAG, "getScreenState, state: " + r3);
        return r3;
    L5:
        r3 = "SCREEN_OFF";
        goto L6
    }

    private final String a(String r7, String r8) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        if (r2 != null) goto L6;
    L9:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        ILogDepend.Companion.i(TAG, "parseRawLogValueByKey raw log is empty");     // Catch: Exception -> L28
        return null;
    L13:
        i r9 = k.a(new k("\\\\?\"" + r8 + "\\\\?\"\\s*:\\s*(\\\\?\"(.*?)\\\\?\"|([^,}]+))"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Exception -> L28
        if (r9 != null) goto L16;
        return null;
    L16:
        f r10 = r9.c().a(2);     // Catch: Exception -> L28
        if (r10 == null) goto L22;
        String r11 = r10.a();     // Catch: Exception -> L28
        if (r11 == null) goto L22;
        return r11;
    L22:
        f r12 = r9.c().a(3);     // Catch: Exception -> L28
        if (r12 == null) goto L33;
        String r13 = r12.a();     // Catch: Exception -> L28
        if (r13 != null) goto L27;
        return null;
    L27:
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L33:
        return null;
    L6:
        if (r2.length() == 0) goto L9;
        r3 = false;
    L28:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "parseRawLogValueByKey failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private final boolean b() {
        if (d.f28974a.ac() == true) goto L6;
        return false;
    L6:
        if (Math.random() >= n.a(d.f28974a.ad(), 0.0f, 1.0f)) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean a(String r6) {
        if (r6 != null) goto L19;
        return true;
    L19:
        Uri r7 = Uri.parse(r6);     // Catch: Exception -> L18
        if (r7 == null) goto L10;
        String r8 = r7.getHost();     // Catch: Exception -> L18
        if (r8 == null) goto L10;
    L12:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("log", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L15;
        return true;
    L15:
        if (d.o.o.b(r8, "dig.bdurl.net", false, 2, null) == false) goto L17;
        return true;
    L10:
        r8 = "";
    L17:
        return false;
    }
}
