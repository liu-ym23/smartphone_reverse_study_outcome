package z8;

import com.stepos.account.oauth.OAuthConstants;
import java.io.IOException;

/* loaded from: classes.dex */
public final class x0 extends f9.l {

    /* renamed from: q, reason: collision with root package name */
    public static final x0 f12463q;

    /* renamed from: r, reason: collision with root package name */
    public static final c9.a f12464r = new c9.a(26);

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12465g;

    /* renamed from: h, reason: collision with root package name */
    public int f12466h;

    /* renamed from: i, reason: collision with root package name */
    public int f12467i;

    /* renamed from: j, reason: collision with root package name */
    public int f12468j;

    /* renamed from: k, reason: collision with root package name */
    public p0 f12469k;

    /* renamed from: l, reason: collision with root package name */
    public int f12470l;

    /* renamed from: m, reason: collision with root package name */
    public p0 f12471m;

    /* renamed from: n, reason: collision with root package name */
    public int f12472n;

    /* renamed from: o, reason: collision with root package name */
    public byte f12473o;

    /* renamed from: p, reason: collision with root package name */
    public int f12474p;

    static {
        x0 x0Var = new x0();
        f12463q = x0Var;
        x0Var.f12467i = 0;
        x0Var.f12468j = 0;
        p0 p0Var = p0.f12298y;
        x0Var.f12469k = p0Var;
        x0Var.f12470l = 0;
        x0Var.f12471m = p0Var;
        x0Var.f12472n = 0;
    }

    public x0(w0 w0Var) {
        super(w0Var);
        this.f12473o = (byte) -1;
        this.f12474p = -1;
        this.f12465g = w0Var.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12474p;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12466h & 1) == 1 ? f9.f.b(1, this.f12467i) : 0;
        if ((this.f12466h & 2) == 2) {
            iB += f9.f.b(2, this.f12468j);
        }
        if ((this.f12466h & 4) == 4) {
            iB += f9.f.d(3, this.f12469k);
        }
        if ((this.f12466h & 16) == 16) {
            iB += f9.f.d(4, this.f12471m);
        }
        if ((this.f12466h & 8) == 8) {
            iB += f9.f.b(5, this.f12470l);
        }
        if ((this.f12466h & 32) == 32) {
            iB += f9.f.b(6, this.f12472n);
        }
        int size = this.f12465g.size() + h() + iB;
        this.f12474p = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        w0 w0Var = new w0();
        p0 p0Var = p0.f12298y;
        w0Var.f12439l = p0Var;
        w0Var.f12441n = p0Var;
        return w0Var;
    }

    @Override // f9.a
    public final f9.j c() {
        w0 w0Var = new w0();
        p0 p0Var = p0.f12298y;
        w0Var.f12439l = p0Var;
        w0Var.f12441n = p0Var;
        w0Var.f(this);
        return w0Var;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12466h & 1) == 1) {
            fVar.m(1, this.f12467i);
        }
        if ((this.f12466h & 2) == 2) {
            fVar.m(2, this.f12468j);
        }
        if ((this.f12466h & 4) == 4) {
            fVar.o(3, this.f12469k);
        }
        if ((this.f12466h & 16) == 16) {
            fVar.o(4, this.f12471m);
        }
        if ((this.f12466h & 8) == 8) {
            fVar.m(5, this.f12470l);
        }
        if ((this.f12466h & 32) == 32) {
            fVar.m(6, this.f12472n);
        }
        bVar.Q0(OAuthConstants.RESPONSE_CODE_OK, fVar);
        fVar.r(this.f12465g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12463q;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12473o;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        int i2 = this.f12466h;
        if ((i2 & 2) != 2) {
            this.f12473o = (byte) 0;
            return false;
        }
        if ((i2 & 4) == 4 && !this.f12469k.isInitialized()) {
            this.f12473o = (byte) 0;
            return false;
        }
        if ((this.f12466h & 16) == 16 && !this.f12471m.isInitialized()) {
            this.f12473o = (byte) 0;
            return false;
        }
        if (g()) {
            this.f12473o = (byte) 1;
            return true;
        }
        this.f12473o = (byte) 0;
        return false;
    }

    public x0() {
        this.f12473o = (byte) -1;
        this.f12474p = -1;
        this.f12465g = f9.d.f3536f;
    }

    public x0(f9.e eVar, f9.h hVar) {
        this.f12473o = (byte) -1;
        this.f12474p = -1;
        boolean z4 = false;
        this.f12467i = 0;
        this.f12468j = 0;
        p0 p0Var = p0.f12298y;
        this.f12469k = p0Var;
        this.f12470l = 0;
        this.f12471m = p0Var;
        this.f12472n = 0;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.f12466h |= 1;
                            this.f12467i = eVar.k();
                        } else if (iN != 16) {
                            o0 o0VarP = null;
                            if (iN == 26) {
                                if ((this.f12466h & 4) == 4) {
                                    p0 p0Var2 = this.f12469k;
                                    p0Var2.getClass();
                                    o0VarP = p0.p(p0Var2);
                                }
                                p0 p0Var3 = (p0) eVar.g(p0.f12299z, hVar);
                                this.f12469k = p0Var3;
                                if (o0VarP != null) {
                                    o0VarP.g(p0Var3);
                                    this.f12469k = o0VarP.e();
                                }
                                this.f12466h |= 4;
                            } else if (iN == 34) {
                                if ((this.f12466h & 16) == 16) {
                                    p0 p0Var4 = this.f12471m;
                                    p0Var4.getClass();
                                    o0VarP = p0.p(p0Var4);
                                }
                                p0 p0Var5 = (p0) eVar.g(p0.f12299z, hVar);
                                this.f12471m = p0Var5;
                                if (o0VarP != null) {
                                    o0VarP.g(p0Var5);
                                    this.f12471m = o0VarP.e();
                                }
                                this.f12466h |= 16;
                            } else if (iN == 40) {
                                this.f12466h |= 8;
                                this.f12470l = eVar.k();
                            } else if (iN != 48) {
                                if (!l(eVar, fVarJ, hVar, iN)) {
                                }
                            } else {
                                this.f12466h |= 32;
                                this.f12472n = eVar.k();
                            }
                        } else {
                            this.f12466h |= 2;
                            this.f12468j = eVar.k();
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
                    this.f12465g = cVar.d();
                    throw th2;
                }
                this.f12465g = cVar.d();
                k();
                throw th;
            }
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12465g = cVar.d();
            throw th3;
        }
        this.f12465g = cVar.d();
        k();
    }
}
