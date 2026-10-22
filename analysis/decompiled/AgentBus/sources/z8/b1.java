package z8;

import java.io.IOException;

/* loaded from: classes.dex */
public final class b1 extends f9.o {

    /* renamed from: p, reason: collision with root package name */
    public static final b1 f12045p;

    /* renamed from: q, reason: collision with root package name */
    public static final c9.a f12046q = new c9.a(27);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12047f;

    /* renamed from: g, reason: collision with root package name */
    public int f12048g;

    /* renamed from: h, reason: collision with root package name */
    public int f12049h;

    /* renamed from: i, reason: collision with root package name */
    public int f12050i;

    /* renamed from: j, reason: collision with root package name */
    public z0 f12051j;

    /* renamed from: k, reason: collision with root package name */
    public int f12052k;

    /* renamed from: l, reason: collision with root package name */
    public int f12053l;

    /* renamed from: m, reason: collision with root package name */
    public a1 f12054m;

    /* renamed from: n, reason: collision with root package name */
    public byte f12055n;

    /* renamed from: o, reason: collision with root package name */
    public int f12056o;

    static {
        b1 b1Var = new b1();
        f12045p = b1Var;
        b1Var.f12049h = 0;
        b1Var.f12050i = 0;
        b1Var.f12051j = z0.ERROR;
        b1Var.f12052k = 0;
        b1Var.f12053l = 0;
        b1Var.f12054m = a1.LANGUAGE_VERSION;
    }

    public b1() {
        this.f12055n = (byte) -1;
        this.f12056o = -1;
        this.f12047f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12056o;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12048g & 1) == 1 ? f9.f.b(1, this.f12049h) : 0;
        if ((this.f12048g & 2) == 2) {
            iB += f9.f.b(2, this.f12050i);
        }
        if ((this.f12048g & 4) == 4) {
            iB += f9.f.a(3, this.f12051j.f12490f);
        }
        if ((this.f12048g & 8) == 8) {
            iB += f9.f.b(4, this.f12052k);
        }
        if ((this.f12048g & 16) == 16) {
            iB += f9.f.b(5, this.f12053l);
        }
        if ((this.f12048g & 32) == 32) {
            iB += f9.f.a(6, this.f12054m.f12018f);
        }
        int size = this.f12047f.size() + iB;
        this.f12056o = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return y0.e();
    }

    @Override // f9.a
    public final f9.j c() {
        y0 y0VarE = y0.e();
        y0VarE.f(this);
        return y0VarE;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f12048g & 1) == 1) {
            fVar.m(1, this.f12049h);
        }
        if ((this.f12048g & 2) == 2) {
            fVar.m(2, this.f12050i);
        }
        if ((this.f12048g & 4) == 4) {
            fVar.l(3, this.f12051j.f12490f);
        }
        if ((this.f12048g & 8) == 8) {
            fVar.m(4, this.f12052k);
        }
        if ((this.f12048g & 16) == 16) {
            fVar.m(5, this.f12053l);
        }
        if ((this.f12048g & 32) == 32) {
            fVar.l(6, this.f12054m.f12018f);
        }
        fVar.r(this.f12047f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        if (this.f12055n == 1) {
            return true;
        }
        this.f12055n = (byte) 1;
        return true;
    }

    public b1(f9.e eVar) {
        this.f12055n = (byte) -1;
        this.f12056o = -1;
        boolean z4 = false;
        this.f12049h = 0;
        this.f12050i = 0;
        z0 z0Var = z0.ERROR;
        this.f12051j = z0Var;
        this.f12052k = 0;
        this.f12053l = 0;
        a1 a1Var = a1.LANGUAGE_VERSION;
        this.f12054m = a1Var;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.f12048g |= 1;
                            this.f12049h = eVar.k();
                        } else if (iN != 16) {
                            a1 a1Var2 = null;
                            z0 z0Var2 = null;
                            if (iN == 24) {
                                int iK = eVar.k();
                                if (iK == 0) {
                                    z0Var2 = z0.WARNING;
                                } else if (iK == 1) {
                                    z0Var2 = z0Var;
                                } else if (iK == 2) {
                                    z0Var2 = z0.HIDDEN;
                                }
                                if (z0Var2 == null) {
                                    fVarJ.v(iN);
                                    fVarJ.v(iK);
                                } else {
                                    this.f12048g |= 4;
                                    this.f12051j = z0Var2;
                                }
                            } else if (iN == 32) {
                                this.f12048g |= 8;
                                this.f12052k = eVar.k();
                            } else if (iN == 40) {
                                this.f12048g |= 16;
                                this.f12053l = eVar.k();
                            } else if (iN != 48) {
                                if (!eVar.q(iN, fVarJ)) {
                                }
                            } else {
                                int iK2 = eVar.k();
                                if (iK2 == 0) {
                                    a1Var2 = a1Var;
                                } else if (iK2 == 1) {
                                    a1Var2 = a1.COMPILER_VERSION;
                                } else if (iK2 == 2) {
                                    a1Var2 = a1.API_VERSION;
                                }
                                if (a1Var2 == null) {
                                    fVarJ.v(iN);
                                    fVarJ.v(iK2);
                                } else {
                                    this.f12048g |= 32;
                                    this.f12054m = a1Var2;
                                }
                            }
                        } else {
                            this.f12048g |= 2;
                            this.f12050i = eVar.k();
                        }
                    }
                    z4 = true;
                } catch (Throwable th) {
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f12047f = cVar.d();
                        throw th2;
                    }
                    this.f12047f = cVar.d();
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
            this.f12047f = cVar.d();
            throw th3;
        }
        this.f12047f = cVar.d();
    }

    public b1(y0 y0Var) {
        this.f12055n = (byte) -1;
        this.f12056o = -1;
        this.f12047f = y0Var.f3565f;
    }
}
