package L4;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: h, reason: collision with root package name */
    public static final a f3973h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3974a;

    /* renamed from: b, reason: collision with root package name */
    public int f3975b;

    /* renamed from: c, reason: collision with root package name */
    public int f3976c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3977d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3978e;

    /* renamed from: f, reason: collision with root package name */
    public t f3979f;

    /* renamed from: g, reason: collision with root package name */
    public t f3980g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(j4.g gVar) {
            this();
        }
    }

    public t() {
        this.f3974a = new byte[8192];
        this.f3978e = true;
        this.f3977d = false;
    }

    public final void a() {
        int i5;
        t tVar = this.f3980g;
        if (tVar == this) {
            throw new IllegalStateException("cannot compact");
        }
        if (tVar == null) {
            j4.k.p();
        }
        if (tVar.f3978e) {
            int i6 = this.f3976c - this.f3975b;
            t tVar2 = this.f3980g;
            if (tVar2 == null) {
                j4.k.p();
            }
            int i7 = 8192 - tVar2.f3976c;
            t tVar3 = this.f3980g;
            if (tVar3 == null) {
                j4.k.p();
            }
            if (tVar3.f3977d) {
                i5 = 0;
            } else {
                t tVar4 = this.f3980g;
                if (tVar4 == null) {
                    j4.k.p();
                }
                i5 = tVar4.f3975b;
            }
            if (i6 > i7 + i5) {
                return;
            }
            t tVar5 = this.f3980g;
            if (tVar5 == null) {
                j4.k.p();
            }
            f(tVar5, i6);
            b();
            u.a(this);
        }
    }

    public final t b() {
        t tVar = this.f3979f;
        if (tVar == this) {
            tVar = null;
        }
        t tVar2 = this.f3980g;
        if (tVar2 == null) {
            j4.k.p();
        }
        tVar2.f3979f = this.f3979f;
        t tVar3 = this.f3979f;
        if (tVar3 == null) {
            j4.k.p();
        }
        tVar3.f3980g = this.f3980g;
        this.f3979f = null;
        this.f3980g = null;
        return tVar;
    }

    public final t c(t tVar) {
        j4.k.h(tVar, "segment");
        tVar.f3980g = this;
        tVar.f3979f = this.f3979f;
        t tVar2 = this.f3979f;
        if (tVar2 == null) {
            j4.k.p();
        }
        tVar2.f3980g = tVar;
        this.f3979f = tVar;
        return tVar;
    }

    public final t d() {
        this.f3977d = true;
        return new t(this.f3974a, this.f3975b, this.f3976c, true, false);
    }

    public final t e(int i5) {
        t tVarB;
        if (i5 <= 0 || i5 > this.f3976c - this.f3975b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i5 >= 1024) {
            tVarB = d();
        } else {
            tVarB = u.b();
            b.a(this.f3974a, this.f3975b, tVarB.f3974a, 0, i5);
        }
        tVarB.f3976c = tVarB.f3975b + i5;
        this.f3975b += i5;
        t tVar = this.f3980g;
        if (tVar == null) {
            j4.k.p();
        }
        tVar.c(tVarB);
        return tVarB;
    }

    public final void f(t tVar, int i5) {
        j4.k.h(tVar, "sink");
        if (!tVar.f3978e) {
            throw new IllegalStateException("only owner can write");
        }
        int i6 = tVar.f3976c;
        if (i6 + i5 > 8192) {
            if (tVar.f3977d) {
                throw new IllegalArgumentException();
            }
            int i7 = tVar.f3975b;
            if ((i6 + i5) - i7 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = tVar.f3974a;
            b.a(bArr, i7, bArr, 0, i6 - i7);
            tVar.f3976c -= tVar.f3975b;
            tVar.f3975b = 0;
        }
        b.a(this.f3974a, this.f3975b, tVar.f3974a, tVar.f3976c, i5);
        tVar.f3976c += i5;
        this.f3975b += i5;
    }

    public t(byte[] bArr, int i5, int i6, boolean z5, boolean z6) {
        j4.k.h(bArr, "data");
        this.f3974a = bArr;
        this.f3975b = i5;
        this.f3976c = i6;
        this.f3977d = z5;
        this.f3978e = z6;
    }
}
