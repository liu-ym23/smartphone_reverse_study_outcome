package z8;

import java.io.IOException;

/* loaded from: classes.dex */
public final class n0 extends f9.o {

    /* renamed from: m, reason: collision with root package name */
    public static final n0 f12264m;

    /* renamed from: n, reason: collision with root package name */
    public static final c9.a f12265n = new c9.a(22);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12266f;

    /* renamed from: g, reason: collision with root package name */
    public int f12267g;

    /* renamed from: h, reason: collision with root package name */
    public m0 f12268h;

    /* renamed from: i, reason: collision with root package name */
    public p0 f12269i;

    /* renamed from: j, reason: collision with root package name */
    public int f12270j;

    /* renamed from: k, reason: collision with root package name */
    public byte f12271k;

    /* renamed from: l, reason: collision with root package name */
    public int f12272l;

    static {
        n0 n0Var = new n0();
        f12264m = n0Var;
        n0Var.f12268h = m0.INV;
        n0Var.f12269i = p0.f12298y;
        n0Var.f12270j = 0;
    }

    public n0() {
        this.f12271k = (byte) -1;
        this.f12272l = -1;
        this.f12266f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12272l;
        if (i2 != -1) {
            return i2;
        }
        int iA = (this.f12267g & 1) == 1 ? f9.f.a(1, this.f12268h.f12258f) : 0;
        if ((this.f12267g & 2) == 2) {
            iA += f9.f.d(2, this.f12269i);
        }
        if ((this.f12267g & 4) == 4) {
            iA += f9.f.b(3, this.f12270j);
        }
        int size = this.f12266f.size() + iA;
        this.f12272l = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return l0.e();
    }

    @Override // f9.a
    public final f9.j c() {
        l0 l0VarE = l0.e();
        l0VarE.f(this);
        return l0VarE;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f12267g & 1) == 1) {
            fVar.l(1, this.f12268h.f12258f);
        }
        if ((this.f12267g & 2) == 2) {
            fVar.o(2, this.f12269i);
        }
        if ((this.f12267g & 4) == 4) {
            fVar.m(3, this.f12270j);
        }
        fVar.r(this.f12266f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12271k;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if ((this.f12267g & 2) != 2 || this.f12269i.isInitialized()) {
            this.f12271k = (byte) 1;
            return true;
        }
        this.f12271k = (byte) 0;
        return false;
    }

    public n0(f9.e eVar, f9.h hVar) {
        this.f12271k = (byte) -1;
        this.f12272l = -1;
        m0 m0Var = m0.INV;
        this.f12268h = m0Var;
        this.f12269i = p0.f12298y;
        boolean z4 = false;
        this.f12270j = 0;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        o0 o0VarP = null;
                        m0 m0Var2 = null;
                        if (iN == 8) {
                            int iK = eVar.k();
                            if (iK == 0) {
                                m0Var2 = m0.IN;
                            } else if (iK == 1) {
                                m0Var2 = m0.OUT;
                            } else if (iK == 2) {
                                m0Var2 = m0Var;
                            } else if (iK == 3) {
                                m0Var2 = m0.STAR;
                            }
                            if (m0Var2 == null) {
                                fVarJ.v(iN);
                                fVarJ.v(iK);
                            } else {
                                this.f12267g |= 1;
                                this.f12268h = m0Var2;
                            }
                        } else if (iN == 18) {
                            if ((this.f12267g & 2) == 2) {
                                p0 p0Var = this.f12269i;
                                p0Var.getClass();
                                o0VarP = p0.p(p0Var);
                            }
                            p0 p0Var2 = (p0) eVar.g(p0.f12299z, hVar);
                            this.f12269i = p0Var2;
                            if (o0VarP != null) {
                                o0VarP.g(p0Var2);
                                this.f12269i = o0VarP.e();
                            }
                            this.f12267g |= 2;
                        } else if (iN != 24) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            this.f12267g |= 4;
                            this.f12270j = eVar.k();
                        }
                    }
                    z4 = true;
                } catch (Throwable th) {
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f12266f = cVar.d();
                        throw th2;
                    }
                    this.f12266f = cVar.d();
                    throw th;
                }
            } catch (f9.r e10) {
                e10.f3597f = this;
                throw e10;
            } catch (IOException e11) {
                f9.r rVar = new f9.r(e11.getMessage());
                rVar.f3597f = this;
                throw rVar;
            }
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12266f = cVar.d();
            throw th3;
        }
        this.f12266f = cVar.d();
    }

    public n0(l0 l0Var) {
        this.f12271k = (byte) -1;
        this.f12272l = -1;
        this.f12266f = l0Var.f3565f;
    }
}
