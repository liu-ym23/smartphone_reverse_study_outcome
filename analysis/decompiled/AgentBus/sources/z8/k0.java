package z8;

import java.io.IOException;

/* loaded from: classes.dex */
public final class k0 extends f9.o {

    /* renamed from: j, reason: collision with root package name */
    public static final k0 f12234j;

    /* renamed from: k, reason: collision with root package name */
    public static final c9.a f12235k = new c9.a(20);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12236f;

    /* renamed from: g, reason: collision with root package name */
    public f9.t f12237g;

    /* renamed from: h, reason: collision with root package name */
    public byte f12238h;

    /* renamed from: i, reason: collision with root package name */
    public int f12239i;

    static {
        k0 k0Var = new k0();
        f12234j = k0Var;
        k0Var.f12237g = f9.s.f3598g;
    }

    public k0() {
        this.f12238h = (byte) -1;
        this.f12239i = -1;
        this.f12236f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12239i;
        if (i2 != -1) {
            return i2;
        }
        int size = 0;
        for (int i10 = 0; i10 < this.f12237g.size(); i10++) {
            f9.d byteString = this.f12237g.getByteString(i10);
            size += byteString.size() + f9.f.f(byteString.size());
        }
        int size2 = this.f12236f.size() + this.f12237g.size() + size;
        this.f12239i = size2;
        return size2;
    }

    @Override // f9.a
    public final f9.j b() {
        l lVar = new l(3);
        lVar.f12242i = f9.s.f3598g;
        return lVar;
    }

    @Override // f9.a
    public final f9.j c() {
        l lVar = new l(3);
        lVar.f12242i = f9.s.f3598g;
        lVar.j(this);
        return lVar;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        for (int i2 = 0; i2 < this.f12237g.size(); i2++) {
            f9.d byteString = this.f12237g.getByteString(i2);
            fVar.x(1, 2);
            fVar.v(byteString.size());
            fVar.r(byteString);
        }
        fVar.r(this.f12236f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        if (this.f12238h == 1) {
            return true;
        }
        this.f12238h = (byte) 1;
        return true;
    }

    public k0(f9.e eVar) {
        this.f12238h = (byte) -1;
        this.f12239i = -1;
        this.f12237g = f9.s.f3598g;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        boolean z10 = false;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN != 10) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            f9.u uVarE = eVar.e();
                            if (!z10) {
                                this.f12237g = new f9.s();
                                z10 = true;
                            }
                            this.f12237g.c(uVarE);
                        }
                    }
                    z4 = true;
                } catch (f9.r e10) {
                    e10.f3597f = this;
                    throw e10;
                } catch (IOException e11) {
                    f9.r rVar = new f9.r(e11.getMessage());
                    rVar.f3597f = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                if (z10) {
                    this.f12237g = this.f12237g.getUnmodifiableView();
                }
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12236f = cVar.d();
                    throw th2;
                }
                this.f12236f = cVar.d();
                throw th;
            }
        }
        if (z10) {
            this.f12237g = this.f12237g.getUnmodifiableView();
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12236f = cVar.d();
            throw th3;
        }
        this.f12236f = cVar.d();
    }

    public k0(l lVar) {
        this.f12238h = (byte) -1;
        this.f12239i = -1;
        this.f12236f = lVar.f3565f;
    }
}
