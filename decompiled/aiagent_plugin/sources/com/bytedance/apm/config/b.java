package com.bytedance.apm.config;

import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApmInitConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private boolean A;
    private com.bytedance.apm.b.f B;
    private com.bytedance.apm.net.a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4478e;
    private com.bytedance.apm.trace.a f;
    private boolean g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private long p;
    private com.bytedance.apm.config.a q;
    private String r;
    private String s;
    private boolean t;
    private com.bytedance.apm.f.c u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: renamed from: com.bytedance.apm.config.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: ApmInitConfig.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: ApmInitConfig.java */
    public static final class a {
        private boolean A;
        private boolean B;
        private boolean C;
        private com.bytedance.apm.b.f D;
        private com.bytedance.apm.net.a E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f4480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4481c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f4482d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f4483e;
        private com.bytedance.apm.trace.a f;
        private boolean g;
        private long h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private boolean n;
        private String o;
        private int p;
        private long q;
        private String r;
        private boolean s;
        private boolean t;
        private boolean u;
        private com.bytedance.apm.config.a v;
        private com.bytedance.apm.f.c w;
        private boolean x;
        private boolean y;
        private boolean z;

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean A(a r0) {
            return r0.z;
        }

        static /* synthetic */ boolean B(a r0) {
            return r0.A;
        }

        static /* synthetic */ boolean C(a r0) {
            return r0.B;
        }

        static /* synthetic */ boolean D(a r0) {
            return r0.C;
        }

        static /* synthetic */ com.bytedance.apm.net.a E(a r0) {
            return r0.E;
        }

        static /* synthetic */ int a(a r0) {
            return r0.f4479a;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.f4481c;
        }

        static /* synthetic */ long c(a r2) {
            return r2.f4482d;
        }

        static /* synthetic */ long d(a r2) {
            return r2.f4483e;
        }

        static /* synthetic */ com.bytedance.apm.trace.a e(a r0) {
            return r0.f;
        }

        static /* synthetic */ boolean f(a r0) {
            return r0.g;
        }

        static /* synthetic */ long g(a r2) {
            return r2.h;
        }

        static /* synthetic */ boolean h(a r0) {
            return r0.i;
        }

        static /* synthetic */ boolean i(a r0) {
            return r0.j;
        }

        static /* synthetic */ boolean j(a r0) {
            return r0.k;
        }

        static /* synthetic */ boolean k(a r0) {
            return r0.l;
        }

        static /* synthetic */ boolean l(a r0) {
            return r0.m;
        }

        static /* synthetic */ boolean m(a r0) {
            return r0.n;
        }

        static /* synthetic */ long n(a r2) {
            return r2.q;
        }

        static /* synthetic */ int o(a r0) {
            return r0.p;
        }

        static /* synthetic */ String p(a r0) {
            return r0.r;
        }

        static /* synthetic */ String q(a r0) {
            return r0.o;
        }

        static /* synthetic */ com.bytedance.apm.config.a r(a r0) {
            return r0.v;
        }

        static /* synthetic */ com.bytedance.apm.f.c s(a r0) {
            return r0.w;
        }

        static /* synthetic */ boolean t(a r0) {
            return r0.x;
        }

        static /* synthetic */ boolean u(a r0) {
            return r0.s;
        }

        static /* synthetic */ boolean v(a r0) {
            return r0.t;
        }

        static /* synthetic */ boolean w(a r0) {
            return r0.u;
        }

        static /* synthetic */ com.bytedance.apm.b.f x(a r0) {
            return r0.D;
        }

        static /* synthetic */ boolean y(a r0) {
            return r0.f4480b;
        }

        static /* synthetic */ boolean z(a r0) {
            return r0.y;
        }

        private a() {
            this.k = false;
            this.l = false;
            this.m = false;
            this.u = false;
            this.f4479a = 1000;
            this.f4481c = false;
            this.f4482d = 20000;
            this.f4483e = 15000;
            this.g = false;
            this.h = 1000;
            this.p = 0;
            this.q = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
            this.D = new com.bytedance.apm.b.c();
        }

        public a a(com.bytedance.apm.f.c r1) {
            this.w = r1;
            return this;
        }

        public a a(boolean r1) {
            this.f4481c = r1;
            return this;
        }

        public a a(com.bytedance.apm.config.a r1) {
            this.v = r1;
            return this;
        }

        public a a(long r1) {
            this.f4482d = r1;
            return this;
        }

        public a b(boolean r1) {
            this.j = r1;
            return this;
        }

        public a c(boolean r1) {
            this.m = r1;
            return this;
        }

        public a d(boolean r1) {
            this.n = r1;
            return this;
        }

        public a e(boolean r1) {
            this.s = r1;
            return this;
        }

        public a f(boolean r1) {
            this.u = r1;
            return this;
        }

        public a g(boolean r1) {
            this.x = r1;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public int a() {
        return this.f4474a;
    }

    public boolean b() {
        return this.f4476c;
    }

    public long c() {
        return this.f4477d;
    }

    public com.bytedance.apm.trace.a d() {
        return this.f;
    }

    public boolean e() {
        return this.g;
    }

    public long f() {
        return this.h;
    }

    public boolean g() {
        return this.i;
    }

    public boolean h() {
        return this.j;
    }

    public boolean i() {
        return this.k;
    }

    public boolean j() {
        return this.l;
    }

    public boolean k() {
        return this.x;
    }

    public boolean l() {
        return this.y;
    }

    public boolean m() {
        return this.z;
    }

    public boolean n() {
        return this.m;
    }

    public boolean o() {
        return this.n;
    }

    public com.bytedance.apm.config.a p() {
        return this.q;
    }

    public void a(boolean r1) {
        this.f4476c = r1;
    }

    public void a(long r1) {
        this.f4477d = r1;
    }

    public long q() {
        return this.f4478e;
    }

    public void a(com.bytedance.apm.trace.a r3) {
        this.f = (com.bytedance.apm.trace.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.trace.a.class, "com.obric.aiagent.plugin");
    }

    public void b(boolean r1) {
        this.g = r1;
    }

    public void b(long r1) {
        this.h = r1;
    }

    public int r() {
        return this.o;
    }

    public long s() {
        long r0 = com.bytedance.apm.f.a.a().b().d();
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        return this.p;
    }

    public boolean t() {
        return this.f4475b;
    }

    public String u() {
        return this.s;
    }

    public com.bytedance.apm.f.c v() {
        if (this.u != null) goto L6;
        this.u = new com.bytedance.apm.f.c.a().f();
    L6:
        return this.u;
    }

    public com.bytedance.apm.b.f w() {
        return this.B;
    }

    public boolean x() {
        return this.v;
    }

    public boolean y() {
        return this.t;
    }

    public boolean z() {
        return this.A;
    }

    public com.bytedance.apm.net.a A() {
        return this.C;
    }

    public static a B() {
        return new a(null);
    }

    public b(a r3) {
        this.f4474a = a.a(r3);
        this.f4476c = a.b(r3);
        this.f4477d = a.c(r3);
        this.f4478e = a.d(r3);
        this.f = a.e(r3);
        this.g = a.f(r3);
        this.h = a.g(r3);
        this.i = a.h(r3);
        this.j = a.i(r3);
        this.k = a.j(r3);
        this.l = a.k(r3);
        this.m = a.l(r3);
        this.n = a.m(r3);
        this.p = a.n(r3);
        this.o = a.o(r3);
        this.r = a.p(r3);
        this.s = a.q(r3);
        this.q = a.r(r3);
        this.u = a.s(r3);
        this.v = a.t(r3);
        com.bytedance.apm.c.b(a.u(r3));
        com.bytedance.apm.c.c(a.v(r3));
        this.t = a.w(r3);
        this.B = a.x(r3);
        this.f4475b = a.y(r3);
        this.w = a.z(r3);
        this.x = a.A(r3);
        this.y = a.B(r3);
        this.z = a.C(r3);
        this.A = a.D(r3);
        this.C = a.E(r3);
    }

    public String toString() {
        return "ApmInitConfig{mCacheBufferCount=" + this.f4474a + ", isReportCacheException=" + this.f4475b + ", mViewIdmonitorPageSwitch=" + this.f4476c + ", mMaxValidPageLoadTimeMs=" + this.f4477d + ", mMaxValidLaunchTimeMs=" + this.f4478e + ", mTraceListener=" + this.f + ", mReportEvilMethodSwitch=" + this.g + ", mEvilMethodThresholdMs=" + this.h + ", mLimitEvilMethodDepth=" + this.i + ", mFullFpsTracer=" + this.j + ", mDisableFpsTracer=" + this.k + ", mChangeFpsLifeCycle=" + this.l + ", mActivityFps=" + this.m + ", mBinderMonitor=" + this.n + ", mTraceExtraFlag=" + this.o + ", mTraceExtraCollectTimeMs=" + this.p + ", mActivityLeakDetectConfig=" + this.q + ", mIgnoreNetMonitorUserAgentLabel='" + this.r + "', mProcessName='" + this.s + "', mEnableDeviceInfoOnPerfData=" + this.t + ", mLaunchConfig=" + this.u + ", mSupportMultiFrameRate=" + this.v + ", mEnableSliverDump=" + this.w + ", mEnableCpuAllocOpt=" + this.x + ", mEnableCloseListener=" + this.y + ", mEnableLooperOpt=" + this.z + ", mAlogUploadStrategy=" + this.B + '}';
    }

    public boolean C() {
        return this.w;
    }
}
