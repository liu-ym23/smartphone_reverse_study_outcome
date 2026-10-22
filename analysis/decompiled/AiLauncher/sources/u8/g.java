package u8;

import v8.C5671a;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final C5671a f42470a;

    /* renamed from: b, reason: collision with root package name */
    public final io.noties.markwon.image.b f42471b;

    /* renamed from: c, reason: collision with root package name */
    public final M8.d f42472c;

    /* renamed from: d, reason: collision with root package name */
    public final c f42473d;

    /* renamed from: e, reason: collision with root package name */
    public final H8.a f42474e;

    /* renamed from: f, reason: collision with root package name */
    public final io.noties.markwon.image.i f42475f;

    /* renamed from: g, reason: collision with root package name */
    public final k f42476g;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public C5671a f42477a;

        /* renamed from: b, reason: collision with root package name */
        public io.noties.markwon.image.b f42478b;

        /* renamed from: c, reason: collision with root package name */
        public M8.d f42479c;

        /* renamed from: d, reason: collision with root package name */
        public c f42480d;

        /* renamed from: e, reason: collision with root package name */
        public H8.a f42481e;

        /* renamed from: f, reason: collision with root package name */
        public io.noties.markwon.image.i f42482f;

        /* renamed from: g, reason: collision with root package name */
        public k f42483g;

        public b h(io.noties.markwon.image.b bVar) {
            this.f42478b = bVar;
            return this;
        }

        public g i(C5671a c5671a, k kVar) {
            this.f42477a = c5671a;
            this.f42483g = kVar;
            if (this.f42478b == null) {
                this.f42478b = io.noties.markwon.image.b.c();
            }
            if (this.f42479c == null) {
                this.f42479c = new M8.e();
            }
            if (this.f42480d == null) {
                this.f42480d = new d();
            }
            if (this.f42481e == null) {
                this.f42481e = H8.a.a();
            }
            if (this.f42482f == null) {
                this.f42482f = new io.noties.markwon.image.j();
            }
            return new g(this);
        }

        public b j(H8.a aVar) {
            this.f42481e = aVar;
            return this;
        }

        public b k(io.noties.markwon.image.i iVar) {
            this.f42482f = iVar;
            return this;
        }

        public b l(c cVar) {
            this.f42480d = cVar;
            return this;
        }

        public b m(M8.d dVar) {
            this.f42479c = dVar;
            return this;
        }
    }

    public io.noties.markwon.image.b a() {
        return this.f42471b;
    }

    public H8.a b() {
        return this.f42474e;
    }

    public io.noties.markwon.image.i c() {
        return this.f42475f;
    }

    public c d() {
        return this.f42473d;
    }

    public k e() {
        return this.f42476g;
    }

    public M8.d f() {
        return this.f42472c;
    }

    public C5671a g() {
        return this.f42470a;
    }

    public g(b bVar) {
        this.f42470a = bVar.f42477a;
        this.f42471b = bVar.f42478b;
        this.f42472c = bVar.f42479c;
        this.f42473d = bVar.f42480d;
        this.f42474e = bVar.f42481e;
        this.f42475f = bVar.f42482f;
        this.f42476g = bVar.f42483g;
    }
}
