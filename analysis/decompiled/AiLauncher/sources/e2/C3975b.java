package e2;

import e2.l;

/* renamed from: e2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3975b extends l {

    /* renamed from: a, reason: collision with root package name */
    public final m f32240a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32241b;

    /* renamed from: c, reason: collision with root package name */
    public final b2.c<?> f32242c;

    /* renamed from: d, reason: collision with root package name */
    public final b2.d<?, byte[]> f32243d;

    /* renamed from: e, reason: collision with root package name */
    public final b2.b f32244e;

    /* renamed from: e2.b$b, reason: collision with other inner class name */
    public static final class C0393b extends l.a {

        /* renamed from: a, reason: collision with root package name */
        public m f32245a;

        /* renamed from: b, reason: collision with root package name */
        public String f32246b;

        /* renamed from: c, reason: collision with root package name */
        public b2.c<?> f32247c;

        /* renamed from: d, reason: collision with root package name */
        public b2.d<?, byte[]> f32248d;

        /* renamed from: e, reason: collision with root package name */
        public b2.b f32249e;

        @Override // e2.l.a
        public l a() {
            String str = "";
            if (this.f32245a == null) {
                str = " transportContext";
            }
            if (this.f32246b == null) {
                str = str + " transportName";
            }
            if (this.f32247c == null) {
                str = str + " event";
            }
            if (this.f32248d == null) {
                str = str + " transformer";
            }
            if (this.f32249e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new C3975b(this.f32245a, this.f32246b, this.f32247c, this.f32248d, this.f32249e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e2.l.a
        public l.a b(b2.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f32249e = bVar;
            return this;
        }

        @Override // e2.l.a
        public l.a c(b2.c<?> cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f32247c = cVar;
            return this;
        }

        @Override // e2.l.a
        public l.a d(b2.d<?, byte[]> dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f32248d = dVar;
            return this;
        }

        @Override // e2.l.a
        public l.a e(m mVar) {
            if (mVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f32245a = mVar;
            return this;
        }

        @Override // e2.l.a
        public l.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f32246b = str;
            return this;
        }
    }

    @Override // e2.l
    public b2.b b() {
        return this.f32244e;
    }

    @Override // e2.l
    public b2.c<?> c() {
        return this.f32242c;
    }

    @Override // e2.l
    public b2.d<?, byte[]> e() {
        return this.f32243d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f32240a.equals(lVar.f()) && this.f32241b.equals(lVar.g()) && this.f32242c.equals(lVar.c()) && this.f32243d.equals(lVar.e()) && this.f32244e.equals(lVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // e2.l
    public m f() {
        return this.f32240a;
    }

    @Override // e2.l
    public String g() {
        return this.f32241b;
    }

    public int hashCode() {
        return this.f32244e.hashCode() ^ ((((((((this.f32240a.hashCode() ^ 1000003) * 1000003) ^ this.f32241b.hashCode()) * 1000003) ^ this.f32242c.hashCode()) * 1000003) ^ this.f32243d.hashCode()) * 1000003);
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f32240a + ", transportName=" + this.f32241b + ", event=" + this.f32242c + ", transformer=" + this.f32243d + ", encoding=" + this.f32244e + "}";
    }

    public C3975b(m mVar, String str, b2.c<?> cVar, b2.d<?, byte[]> dVar, b2.b bVar) {
        this.f32240a = mVar;
        this.f32241b = str;
        this.f32242c = cVar;
        this.f32243d = dVar;
        this.f32244e = bVar;
    }
}
