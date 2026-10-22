package com.bytedance.monitor.collector;

/* JADX INFO: compiled from: MonitorConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9006e;
    private int f;
    private long g;

    /* JADX INFO: compiled from: MonitorConfig.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f9011e;
        private int f;

        @Deprecated
        public a a(boolean r1) {
            return this;
        }

        public a() {
        }

        static /* synthetic */ boolean a(a r0) {
            return r0.f9007a;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.f9008b;
        }

        static /* synthetic */ boolean c(a r0) {
            return r0.f9009c;
        }

        static /* synthetic */ long d(a r2) {
            return r2.f9011e;
        }

        static /* synthetic */ int e(a r0) {
            return r0.f;
        }

        static /* synthetic */ boolean f(a r0) {
            return r0.f9010d;
        }

        public a b(boolean r1) {
            this.f9007a = r1;
            return this;
        }

        public a c(boolean r1) {
            this.f9008b = r1;
            return this;
        }

        public a d(boolean r1) {
            this.f9009c = r1;
            return this;
        }

        public a e(boolean r1) {
            this.f9010d = r1;
            return this;
        }

        public a a(long r1) {
            this.f9011e = r1;
            return this;
        }

        public a a(int r1) {
            this.f = r1;
            return this;
        }

        public j a() {
            return new j(this);
        }
    }

    public j(a r3) {
        this.g = 0;
        this.f9002a = a.a(r3);
        this.f9003b = a.b(r3);
        this.f9004c = a.c(r3);
        this.f9006e = a.d(r3);
        this.f = a.e(r3);
        this.f9005d = a.f(r3);
    }

    public boolean a() {
        return this.f9002a;
    }

    public boolean b() {
        return this.f9003b;
    }

    public boolean c() {
        return this.f9004c;
    }

    public boolean d() {
        return this.f9005d;
    }

    public long e() {
        return this.f9006e;
    }

    public int f() {
        return this.f;
    }

    public String toString() {
        return "MonitorConfig{enableAtrace=" + this.f9002a + ", enableBinder=" + this.f9003b + ", enableLooperMonitor=" + this.f9004c + ", enableStackSampling=" + this.f9005d + ", atraceTag=" + this.f9006e + ", runMode=" + this.f + ", alogRef=" + this.g + '}';
    }
}
