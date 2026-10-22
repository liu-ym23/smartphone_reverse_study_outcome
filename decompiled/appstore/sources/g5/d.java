package g5;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f19926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f19928g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f19930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f19932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f19933e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19934f;

        public a() {
        }

        public static /* synthetic */ boolean a(a r10) {
            return r10.f19929a;
        }

        public static /* synthetic */ boolean b(a r10) {
            return r10.f19930b;
        }

        public static /* synthetic */ boolean c(a r10) {
            return r10.f19931c;
        }

        public static /* synthetic */ long d(a r10) {
            return r10.f19933e;
        }

        public static /* synthetic */ int e(a r10) {
            return r10.f19934f;
        }

        public static /* synthetic */ boolean f(a r10) {
            return r10.f19932d;
        }

        public a g(long r10) {
            this.f19933e = r10;
            return this;
        }

        public d h() {
            return new d(this);
        }

        public a i(boolean r10) {
            this.f19929a = r10;
            return this;
        }

        public a j(boolean r10) {
            this.f19930b = r10;
            return this;
        }

        public a k(boolean r10) {
            return this;
        }

        public a l(boolean r10) {
            this.f19931c = r10;
            return this;
        }

        public a m(boolean r10) {
            this.f19932d = r10;
            return this;
        }

        public a n(int r10) {
            this.f19934f = r10;
            return this;
        }
    }

    public d(a r10) {
        this.f19928g = 0;
        this.f19922a = a.a(r10);
        this.f19923b = a.b(r10);
        this.f19924c = a.c(r10);
        this.f19926e = a.d(r10);
        this.f19927f = a.e(r10);
        this.f19925d = a.f(r10);
    }

    public long a() {
        return this.f19926e;
    }

    public int b() {
        return this.f19927f;
    }

    public boolean c() {
        return this.f19922a;
    }

    public boolean d() {
        return this.f19923b;
    }

    public boolean e() {
        return this.f19924c;
    }

    public boolean f() {
        return this.f19925d;
    }

    public String toString() {
        return "MonitorConfig{enableAtrace=" + this.f19922a + ", enableBinder=" + this.f19923b + ", enableLooperMonitor=" + this.f19924c + ", enableStackSampling=" + this.f19925d + ", atraceTag=" + this.f19926e + ", runMode=" + this.f19927f + ", alogRef=" + this.f19928g + '}';
    }
}
