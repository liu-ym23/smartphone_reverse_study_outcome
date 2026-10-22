package z8;

import java.io.IOException;

/* loaded from: classes.dex */
public final class d extends f9.o {

    /* renamed from: l, reason: collision with root package name */
    public static final d f12085l;

    /* renamed from: m, reason: collision with root package name */
    public static final c9.a f12086m = new c9.a(6);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12087f;

    /* renamed from: g, reason: collision with root package name */
    public int f12088g;

    /* renamed from: h, reason: collision with root package name */
    public int f12089h;

    /* renamed from: i, reason: collision with root package name */
    public c f12090i;

    /* renamed from: j, reason: collision with root package name */
    public byte f12091j;

    /* renamed from: k, reason: collision with root package name */
    public int f12092k;

    static {
        d dVar = new d();
        f12085l = dVar;
        dVar.f12089h = 0;
        dVar.f12090i = c.f12057u;
    }

    public d() {
        this.f12091j = (byte) -1;
        this.f12092k = -1;
        this.f12087f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12092k;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12088g & 1) == 1 ? f9.f.b(1, this.f12089h) : 0;
        if ((this.f12088g & 2) == 2) {
            iB += f9.f.d(2, this.f12090i);
        }
        int size = this.f12087f.size() + iB;
        this.f12092k = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        e eVar = new e(2);
        eVar.f12107i = c.f12057u;
        return eVar;
    }

    @Override // f9.a
    public final f9.j c() {
        e eVar = new e(2);
        eVar.f12107i = c.f12057u;
        eVar.h(this);
        return eVar;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f12088g & 1) == 1) {
            fVar.m(1, this.f12089h);
        }
        if ((this.f12088g & 2) == 2) {
            fVar.o(2, this.f12090i);
        }
        fVar.r(this.f12087f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12091j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        int i2 = this.f12088g;
        if ((i2 & 1) != 1) {
            this.f12091j = (byte) 0;
            return false;
        }
        if ((i2 & 2) != 2) {
            this.f12091j = (byte) 0;
            return false;
        }
        if (this.f12090i.isInitialized()) {
            this.f12091j = (byte) 1;
            return true;
        }
        this.f12091j = (byte) 0;
        return false;
    }

    public d(f9.e eVar, f9.h hVar) {
        a aVarE;
        this.f12091j = (byte) -1;
        this.f12092k = -1;
        boolean z4 = false;
        this.f12089h = 0;
        this.f12090i = c.f12057u;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        while (!z4) {
            try {
                try {
                    try {
                        int iN = eVar.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.f12088g |= 1;
                                this.f12089h = eVar.k();
                            } else if (iN != 18) {
                                if (!eVar.q(iN, fVarJ)) {
                                }
                            } else {
                                if ((this.f12088g & 2) == 2) {
                                    c cVar2 = this.f12090i;
                                    cVar2.getClass();
                                    aVarE = a.e();
                                    aVarE.f(cVar2);
                                } else {
                                    aVarE = null;
                                }
                                c cVar3 = (c) eVar.g(c.f12058v, hVar);
                                this.f12090i = cVar3;
                                if (aVarE != null) {
                                    aVarE.f(cVar3);
                                    this.f12090i = aVarE.d();
                                }
                                this.f12088g |= 2;
                            }
                        }
                        z4 = true;
                    } catch (IOException e10) {
                        f9.r rVar = new f9.r(e10.getMessage());
                        rVar.f3597f = this;
                        throw rVar;
                    }
                } catch (f9.r e11) {
                    e11.f3597f = this;
                    throw e11;
                }
            } catch (Throwable th) {
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12087f = cVar.d();
                    throw th2;
                }
                this.f12087f = cVar.d();
                throw th;
            }
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12087f = cVar.d();
            throw th3;
        }
        this.f12087f = cVar.d();
    }

    public d(e eVar) {
        this.f12091j = (byte) -1;
        this.f12092k = -1;
        this.f12087f = eVar.f3565f;
    }
}
