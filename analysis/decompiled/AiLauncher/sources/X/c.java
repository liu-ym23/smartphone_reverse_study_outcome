package X;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final X.a f6808a;

    /* renamed from: b, reason: collision with root package name */
    public final d f6809b;

    /* renamed from: c, reason: collision with root package name */
    public final b f6810c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6811d;

    public c(X.a aVar, d dVar, b bVar, int i10) {
        this.f6808a = aVar;
        this.f6809b = dVar;
        this.f6810c = bVar;
        this.f6811d = i10;
    }

    public int a() {
        return this.f6811d;
    }

    public X.a b() {
        return this.f6808a;
    }

    public b c() {
        return this.f6810c;
    }

    public d d() {
        return this.f6809b;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public X.a f6812a;

        /* renamed from: b, reason: collision with root package name */
        public d f6813b;

        /* renamed from: c, reason: collision with root package name */
        public b f6814c;

        /* renamed from: d, reason: collision with root package name */
        public int f6815d;

        public a() {
            this.f6812a = X.a.f6804c;
            this.f6813b = null;
            this.f6814c = null;
            this.f6815d = 0;
        }

        public static a b(c cVar) {
            return new a(cVar);
        }

        public c a() {
            return new c(this.f6812a, this.f6813b, this.f6814c, this.f6815d);
        }

        public a c(int i10) {
            this.f6815d = i10;
            return this;
        }

        public a d(X.a aVar) {
            this.f6812a = aVar;
            return this;
        }

        public a e(b bVar) {
            this.f6814c = bVar;
            return this;
        }

        public a f(d dVar) {
            this.f6813b = dVar;
            return this;
        }

        public a(c cVar) {
            this.f6812a = X.a.f6804c;
            this.f6813b = null;
            this.f6814c = null;
            this.f6815d = 0;
            this.f6812a = cVar.b();
            this.f6813b = cVar.d();
            this.f6814c = cVar.c();
            this.f6815d = cVar.a();
        }
    }
}
