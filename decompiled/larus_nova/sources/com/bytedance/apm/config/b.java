package com.bytedance.apm.config;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f190424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f190425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f190426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f190427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f190428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f190429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f190430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f190431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.apm.config.a f190432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f190433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f190434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ns3.c f190435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f190436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f190437n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f190438o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f190439p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final tr3.e f190440q;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f190441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f190442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f190443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f190444d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f190445e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f190446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f190447g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f190448h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f190449i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f190450j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f190451k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public com.bytedance.apm.config.a f190452l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ns3.c f190453m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f190454n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f190455o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f190456p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f190457q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final tr3.e f190458r;

        public a() {
            this.f190447g = false;
            this.f190451k = false;
            this.f190441a = false;
            this.f190442b = 20000;
            this.f190443c = false;
            this.f190444d = 1000;
            this.f190458r = new tr3.e();
        }
    }

    public final String toString() {
        return "ApmInitConfig{mCacheBufferCount=1000, isReportCacheException=false, mViewIdmonitorPageSwitch=" + this.f190424a + ", mMaxValidPageLoadTimeMs=" + this.f190425b + ", mMaxValidLaunchTimeMs=15000, mTraceListener=null, mReportEvilMethodSwitch=" + this.f190426c + ", mEvilMethodThresholdMs=" + this.f190427d + ", mLimitEvilMethodDepth=" + this.f190428e + ", mFullFpsTracer=" + this.f190429f + ", mDisableFpsTracer=false, mChangeFpsLifeCycle=false, mActivityFps=" + this.f190430g + ", mBinderMonitor=" + this.f190431h + ", mTraceExtraFlag=0, mTraceExtraCollectTimeMs=30000, mActivityLeakDetectConfig=" + this.f190432i + ", mIgnoreNetMonitorUserAgentLabel='null', mProcessName='" + this.f190433j + "', mEnableDeviceInfoOnPerfData=" + this.f190434k + ", mLaunchConfig=" + this.f190435l + ", mSupportMultiFrameRate=" + this.f190436m + ", mEnableSliverDump=false, mEnableCpuAllocOpt=" + this.f190437n + ", mEnableCloseListener=false, mEnableLooperOpt=" + this.f190438o + ", mAlogUploadStrategy=" + this.f190440q + '}';
    }

    public b(a r100) {
        this.f190424a = r100.f190441a;
        this.f190425b = r100.f190442b;
        this.f190426c = r100.f190443c;
        this.f190427d = r100.f190444d;
        this.f190428e = r100.f190445e;
        this.f190429f = r100.f190446f;
        this.f190430g = r100.f190447g;
        this.f190431h = r100.f190448h;
        this.f190433j = r100.f190449i;
        this.f190432i = r100.f190452l;
        this.f190435l = r100.f190453m;
        this.f190436m = r100.f190454n;
        com.bytedance.apm.d.f190514b = r100.f190450j;
        xu3.a.f565088a = com.bytedance.apm.d.j();
        com.bytedance.apm.d.f190515c = false;
        this.f190434k = r100.f190451k;
        this.f190440q = r100.f190458r;
        this.f190437n = r100.f190455o;
        this.f190438o = r100.f190456p;
        this.f190439p = r100.f190457q;
    }
}
