package r1;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f23684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f23685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f23686g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f23687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f23688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f23689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f23690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f23691e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f23692f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f23693g;

        public a() {
            this.f23687a = false;
            this.f23688b = false;
            this.f23689c = false;
            this.f23690d = false;
            this.f23691e = false;
            this.f23692f = -1;
            this.f23693g = 1000;
        }

        public c a() {
            return new c(this.f23687a, this.f23688b, this.f23689c, this.f23692f, this.f23690d, this.f23693g, this.f23691e);
        }

        public a b() {
            this.f23690d = true;
            return this;
        }

        public a c() {
            this.f23688b = true;
            return this;
        }

        public a d() {
            this.f23687a = true;
            return this;
        }

        public a e() {
            this.f23689c = true;
            return this;
        }

        public a f(long r10) {
            this.f23692f = r10;
            return this;
        }
    }

    public c(boolean r10, boolean r11, boolean r12, long r13, boolean r14, long r15, boolean r16) {
        this.f23680a = r10;
        this.f23681b = r11;
        this.f23682c = r12;
        this.f23685f = r13;
        this.f23683d = r14;
        this.f23686g = r15;
        this.f23684e = r16;
    }

    public long a() {
        return this.f23685f;
    }

    public boolean b() {
        return this.f23683d;
    }

    public boolean c() {
        return this.f23681b;
    }

    public boolean d() {
        return this.f23680a;
    }
}
