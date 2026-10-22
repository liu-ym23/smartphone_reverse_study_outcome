package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.util.Pair;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CronetEngineBuilderImpl extends com.ttnet.org.chromium.net.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f37918b = null;
    private static String q;
    private String A;
    private String B;
    private boolean C;
    private boolean D;
    private long E;
    private String F;
    private boolean G;
    private int H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f37919J;
    private String K;
    private TTAppInfoProvider.AppInfo L;
    private boolean M;
    private boolean N;
    private boolean O;
    private long P;
    private ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> Q;
    private TTThreadConfigInfoProvider.b R;
    private TTSamplingSettingProvider.TTSlaSamplingSetting S;
    private boolean T;
    private String U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f37920a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f37921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<c> f37922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<b> f37923e;
    private boolean f;
    private String g;
    private String h;
    private boolean i;
    private boolean j;
    private boolean k;
    private a l;
    private long m;
    private String n;
    private boolean o;
    private int p;
    private boolean r;
    private boolean s;
    private TTAppInfoProvider t;
    private com.ttnet.org.chromium.net.aa u;
    private com.ttnet.org.chromium.net.z v;
    private String w;
    private ArrayList<byte[]> x;
    private Map<String[], Pair<byte[], byte[]>> y;
    private String z;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37924a = null;

        static {
            int[] r0 = new int[a.values().length];
            f37924a = r0;
            r0[a.f37925a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f37924a[a.f37927c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f37924a[a.f37926b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f37924a[a.f37928d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f37925a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f37926b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f37927c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f37928d = null;
        private static final /* synthetic */ a[] g = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f37929e;
        private final boolean f;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("DISABLED", 0, 0, false);
            f37925a = r0;
            a r1 = new a("DISK", 1, 1, true);
            f37926b = r1;
            a r3 = new a("DISK_NO_HTTP", 2, 1, false);
            f37927c = r3;
            a r5 = new a("MEMORY", 3, 2, true);
            f37928d = r5;
            g = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2, int r3, boolean r4) {
            super(r1, r2);
            this.f = r4;
            this.f37929e = r3;
        }

        int getType() {
            return this.f37929e;
        }

        boolean a() {
            return this.f;
        }

        int b() {
            int r2 = AnonymousClass1.f37924a[ordinal()];
            if (r2 == 1) goto L14;
            int r1 = 2;
            if (r2 == 2) goto L13;
            r1 = 3;
            if (r2 == 3) goto L13;
            if (r2 != 4) goto L12;
            return 1;
        L12:
            throw new IllegalArgumentException("Unknown internal builder cache mode");
        L13:
            return r1;
        L14:
            return 0;
        }

        static a a(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 != 3) goto L12;
            return f37926b;
        L12:
            throw new IllegalArgumentException("Unknown public builder cache mode");
        L14:
            return f37927c;
        L16:
            return f37928d;
        L18:
            return f37925a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f37930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[][] f37931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f37932c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Date f37933d;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f37934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f37935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f37936c;

        c(String r1, int r2, int r3) {
            this.f37934a = r1;
            this.f37935b = r2;
            this.f37936c = r3;
        }
    }

    public CronetEngineBuilderImpl b(com.ttnet.org.chromium.net.d.a.AbstractC1027a r1) {
        return this;
    }

    VersionSafeCallbacks.b f() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a() {
        return l();
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(int r1) {
        return c(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(int r1, long r2) {
        return b(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(long r1) {
        return c(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(TTAppInfoProvider.AppInfo r1) {
        return b(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(TTAppInfoProvider r1) {
        return b(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
        return b(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(TTThreadConfigInfoProvider.b r3) {
        return b((TTThreadConfigInfoProvider.b) ZeusTransformUtils.wrapperContextForParams(r3, TTThreadConfigInfoProvider.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(com.ttnet.org.chromium.net.aa r1) {
        return b(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(com.ttnet.org.chromium.net.d.a.AbstractC1027a r1) {
        return b(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(com.ttnet.org.chromium.net.z r1) {
        return b(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(String r1) {
        return k(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(String r1, int r2, int r3) {
        return b(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(ArrayList r1) {
        return c(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(Map r3) {
        return b((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(boolean r1) {
        return m(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(boolean r1, String r2) {
        return b(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(boolean r1, boolean r2) {
        return b(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k b(int r1) {
        return d(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k b(long r1) {
        return d(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k b(String r1) {
        return l(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k b(ArrayList r1) {
        return d(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k b(boolean r1) {
        return l(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k c(String r1) {
        return m(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k c(boolean r1) {
        return o(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k d(String r1) {
        return n(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k d(boolean r1) {
        return p(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k e(String r1) {
        return o(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k e(boolean r1) {
        return q(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k f(boolean r1) {
        return r(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k g(String r1) {
        return j(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k g(boolean r1) {
        return s(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k h(String r1) {
        return i(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k h(boolean r1) {
        return t(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k i(boolean r1) {
        return u(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k j(boolean r1) {
        return n(r1);
    }

    @Override // com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k k(boolean r1) {
        return w(r1);
    }

    static {
        f37918b = Pattern.compile("^[0-9\\.]*$");
    }

    public CronetEngineBuilderImpl(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f37922d = new LinkedList();
        this.f37923e = new LinkedList();
        this.p = 20;
        this.f37921c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        l(true);
        m(true);
        n(false);
        b(0, 0);
        w(false);
        v(true);
        o(false);
        p(false);
        if (r5 == true) goto L5;
        q = CronetEngineBuilderImpl.class.getSimpleName();
        return;
    L5:
        q = "CronetEngineBuilderImpl";
    }

    public String c() {
        return ai.a(this.f37921c);
    }

    public CronetEngineBuilderImpl i(String r1) {
        this.g = r1;
        return this;
    }

    String d() {
        return this.g;
    }

    public CronetEngineBuilderImpl j(String r3) {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L10;
        if (r0.mkdirs() == true) goto L10;
        throw new IllegalArgumentException("create Storage path failed");
    L10:
        if (r0.isDirectory() == false) goto L14;
        this.h = r3;
        return this;
    L14:
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    String e() {
        return this.h;
    }

    public CronetEngineBuilderImpl l(boolean r1) {
        this.i = r1;
        return this;
    }

    boolean g() {
        return this.i;
    }

    String h() {
        if (this.i == true) goto L7;
        return "";
    L7:
        return ai.b(this.f37921c);
    }

    public CronetEngineBuilderImpl m(boolean r1) {
        this.j = r1;
        return this;
    }

    boolean i() {
        return this.j;
    }

    public CronetEngineBuilderImpl n(boolean r1) {
        this.k = r1;
        return this;
    }

    public CronetEngineBuilderImpl o(boolean r1) {
        this.r = r1;
        return this;
    }

    boolean j() {
        return this.r;
    }

    public CronetEngineBuilderImpl p(boolean r1) {
        this.G = r1;
        return this;
    }

    boolean k() {
        return this.G;
    }

    public CronetEngineBuilderImpl l() {
        this.s = true;
        return this;
    }

    boolean m() {
        return this.s;
    }

    public CronetEngineBuilderImpl b(TTAppInfoProvider r1) {
        this.t = r1;
        return this;
    }

    TTAppInfoProvider n() {
        return this.t;
    }

    public CronetEngineBuilderImpl b(com.ttnet.org.chromium.net.aa r1) {
        this.u = r1;
        return this;
    }

    com.ttnet.org.chromium.net.aa o() {
        return this.u;
    }

    public CronetEngineBuilderImpl b(com.ttnet.org.chromium.net.z r1) {
        this.v = r1;
        return this;
    }

    com.ttnet.org.chromium.net.z p() {
        return this.v;
    }

    public CronetEngineBuilderImpl k(String r1) {
        this.w = r1;
        return this;
    }

    public CronetEngineBuilderImpl c(ArrayList<byte[]> r1) {
        this.x = r1;
        return this;
    }

    public CronetEngineBuilderImpl b(Map<String[], Pair<byte[], byte[]>> r3) {
        this.y = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return this;
    }

    String q() {
        return this.w;
    }

    ArrayList<byte[]> r() {
        return this.x;
    }

    Map<String[], Pair<byte[], byte[]>> s() {
        return this.y;
    }

    public CronetEngineBuilderImpl l(String r1) {
        this.z = r1;
        return this;
    }

    String t() {
        return this.z;
    }

    public CronetEngineBuilderImpl m(String r1) {
        this.A = r1;
        return this;
    }

    String u() {
        return this.A;
    }

    public CronetEngineBuilderImpl n(String r1) {
        this.B = r1;
        return this;
    }

    String v() {
        return this.B;
    }

    @Override // com.ttnet.org.chromium.net.k
    public com.ttnet.org.chromium.net.k f(String r1) {
        this.F = r1;
        return this;
    }

    public String w() {
        return this.F;
    }

    public CronetEngineBuilderImpl q(boolean r1) {
        this.C = r1;
        return this;
    }

    boolean x() {
        return this.C;
    }

    public CronetEngineBuilderImpl r(boolean r1) {
        this.D = r1;
        return this;
    }

    boolean y() {
        return this.D;
    }

    public CronetEngineBuilderImpl c(long r1) {
        this.E = r1;
        return this;
    }

    long z() {
        return this.E;
    }

    public CronetEngineBuilderImpl c(int r1) {
        this.H = r1;
        return this;
    }

    int A() {
        return this.H;
    }

    public CronetEngineBuilderImpl s(boolean r1) {
        this.I = r1;
        return this;
    }

    boolean B() {
        return this.I;
    }

    public CronetEngineBuilderImpl t(boolean r1) {
        this.f37919J = r1;
        return this;
    }

    boolean C() {
        return this.f37919J;
    }

    public CronetEngineBuilderImpl o(String r1) {
        this.K = r1;
        return this;
    }

    String D() {
        return this.K;
    }

    public CronetEngineBuilderImpl b(TTAppInfoProvider.AppInfo r1) {
        this.L = r1;
        return this;
    }

    TTAppInfoProvider.AppInfo E() {
        return this.L;
    }

    public CronetEngineBuilderImpl u(boolean r1) {
        this.M = r1;
        return this;
    }

    boolean F() {
        return this.M;
    }

    public CronetEngineBuilderImpl b(boolean r1, boolean r2) {
        this.N = r1;
        this.O = r2;
        return this;
    }

    boolean G() {
        return this.N;
    }

    boolean H() {
        return this.O;
    }

    public CronetEngineBuilderImpl d(long r1) {
        this.P = r1;
        return this;
    }

    long I() {
        return this.P;
    }

    public CronetEngineBuilderImpl d(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r1) {
        this.Q = r1;
        return this;
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> J() {
        return this.Q;
    }

    public CronetEngineBuilderImpl b(TTThreadConfigInfoProvider.b r3) {
        this.R = (TTThreadConfigInfoProvider.b) ZeusTransformUtils.wrapperContextForParams(r3, TTThreadConfigInfoProvider.b.class, "com.obric.aiagent.plugin");
        return this;
    }

    TTThreadConfigInfoProvider.b K() {
        return this.R;
    }

    public CronetEngineBuilderImpl b(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
        this.S = r1;
        return this;
    }

    TTSamplingSettingProvider.TTSlaSamplingSetting L() {
        return this.S;
    }

    public CronetEngineBuilderImpl b(boolean r1, String r2) {
        this.T = r1;
        this.U = r2;
        return this;
    }

    boolean M() {
        return this.T;
    }

    String N() {
        return this.U;
    }

    boolean O() {
        return this.k;
    }

    public CronetEngineBuilderImpl b(int r3, long r4) {
        a r5 = a.a(r3);
        if (r5.getType() == 1) goto L5;
    L9:
        this.l = r5;
        this.m = r4;
        return this;
    L5:
        if (e() != null) goto L9;
        throw new IllegalArgumentException("Storage path must be set");
    }

    boolean P() {
        return !this.l.a();
    }

    long Q() {
        return this.m;
    }

    int R() {
        return this.l.getType();
    }

    int S() {
        return this.l.b();
    }

    public CronetEngineBuilderImpl b(String r3, int r4, int r5) {
        if (r3.contains("/") == true) goto L7;
        this.f37922d.add(new c(r3, r4, r5));
        return this;
    L7:
        throw new IllegalArgumentException("Illegal QUIC Hint Host: " + r3);
    }

    List<c> T() {
        return this.f37922d;
    }

    List<b> U() {
        return this.f37923e;
    }

    public CronetEngineBuilderImpl v(boolean r1) {
        this.f = r1;
        return this;
    }

    boolean V() {
        return this.f;
    }

    public String W() {
        return this.n;
    }

    long X() {
        return this.f37920a;
    }

    boolean Y() {
        return this.o;
    }

    public CronetEngineBuilderImpl w(boolean r1) {
        this.o = r1;
        return this;
    }

    public CronetEngineBuilderImpl d(int r2) {
        if (r2 > 19) goto L9;
        if (r2 < (-20)) goto L9;
        this.p = r2;
        return this;
    L9:
        throw new IllegalArgumentException("Thread priority invalid");
    }

    int e(int r2) {
        int r1 = this.p;
        if (r1 != 20) goto L6;
        return r2;
    L6:
        return r1;
    }

    Context getContext() {
        return this.f37921c;
    }
}
