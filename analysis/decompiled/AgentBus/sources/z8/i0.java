package z8;

import java.io.IOException;

/* loaded from: classes.dex */
public final class i0 extends f9.o {

    /* renamed from: m, reason: collision with root package name */
    public static final i0 f12206m;

    /* renamed from: n, reason: collision with root package name */
    public static final c9.a f12207n = new c9.a(19);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12208f;

    /* renamed from: g, reason: collision with root package name */
    public int f12209g;

    /* renamed from: h, reason: collision with root package name */
    public int f12210h;

    /* renamed from: i, reason: collision with root package name */
    public int f12211i;

    /* renamed from: j, reason: collision with root package name */
    public h0 f12212j;

    /* renamed from: k, reason: collision with root package name */
    public byte f12213k;

    /* renamed from: l, reason: collision with root package name */
    public int f12214l;

    static {
        i0 i0Var = new i0();
        f12206m = i0Var;
        i0Var.f12210h = -1;
        i0Var.f12211i = 0;
        i0Var.f12212j = h0.PACKAGE;
    }

    public i0() {
        this.f12213k = (byte) -1;
        this.f12214l = -1;
        this.f12208f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12214l;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12209g & 1) == 1 ? f9.f.b(1, this.f12210h) : 0;
        if ((this.f12209g & 2) == 2) {
            iB += f9.f.b(2, this.f12211i);
        }
        if ((this.f12209g & 4) == 4) {
            iB += f9.f.a(3, this.f12212j.f12185f);
        }
        int size = this.f12208f.size() + iB;
        this.f12214l = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return g0.e();
    }

    @Override // f9.a
    public final f9.j c() {
        g0 g0VarE = g0.e();
        g0VarE.f(this);
        return g0VarE;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f12209g & 1) == 1) {
            fVar.m(1, this.f12210h);
        }
        if ((this.f12209g & 2) == 2) {
            fVar.m(2, this.f12211i);
        }
        if ((this.f12209g & 4) == 4) {
            fVar.l(3, this.f12212j.f12185f);
        }
        fVar.r(this.f12208f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12213k;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if ((this.f12209g & 2) == 2) {
            this.f12213k = (byte) 1;
            return true;
        }
        this.f12213k = (byte) 0;
        return false;
    }

    public i0(f9.e eVar) {
        h0 h0Var;
        this.f12213k = (byte) -1;
        this.f12214l = -1;
        this.f12210h = -1;
        boolean z4 = false;
        this.f12211i = 0;
        h0 h0Var2 = h0.PACKAGE;
        this.f12212j = h0Var2;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.f12209g |= 1;
                            this.f12210h = eVar.k();
                        } else if (iN == 16) {
                            this.f12209g |= 2;
                            this.f12211i = eVar.k();
                        } else if (iN != 24) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            int iK = eVar.k();
                            if (iK == 0) {
                                h0Var = h0.CLASS;
                            } else if (iK != 1) {
                                h0Var = iK != 2 ? null : h0.LOCAL;
                            } else {
                                h0Var = h0Var2;
                            }
                            if (h0Var == null) {
                                fVarJ.v(iN);
                                fVarJ.v(iK);
                            } else {
                                this.f12209g |= 4;
                                this.f12212j = h0Var;
                            }
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
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12208f = cVar.d();
                    throw th2;
                }
                this.f12208f = cVar.d();
                throw th;
            }
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12208f = cVar.d();
            throw th3;
        }
        this.f12208f = cVar.d();
    }

    public i0(g0 g0Var) {
        this.f12213k = (byte) -1;
        this.f12214l = -1;
        this.f12208f = g0Var.f3565f;
    }
}
