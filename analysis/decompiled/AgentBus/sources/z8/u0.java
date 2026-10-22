package z8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class u0 extends f9.l {

    /* renamed from: r, reason: collision with root package name */
    public static final u0 f12387r;

    /* renamed from: s, reason: collision with root package name */
    public static final c9.a f12388s = new c9.a(24);

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12389g;

    /* renamed from: h, reason: collision with root package name */
    public int f12390h;

    /* renamed from: i, reason: collision with root package name */
    public int f12391i;

    /* renamed from: j, reason: collision with root package name */
    public int f12392j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12393k;

    /* renamed from: l, reason: collision with root package name */
    public t0 f12394l;

    /* renamed from: m, reason: collision with root package name */
    public List f12395m;

    /* renamed from: n, reason: collision with root package name */
    public List f12396n;

    /* renamed from: o, reason: collision with root package name */
    public int f12397o;

    /* renamed from: p, reason: collision with root package name */
    public byte f12398p;

    /* renamed from: q, reason: collision with root package name */
    public int f12399q;

    static {
        u0 u0Var = new u0();
        f12387r = u0Var;
        u0Var.f12391i = 0;
        u0Var.f12392j = 0;
        u0Var.f12393k = false;
        u0Var.f12394l = t0.INV;
        List list = Collections.EMPTY_LIST;
        u0Var.f12395m = list;
        u0Var.f12396n = list;
    }

    public u0(s0 s0Var) {
        super(s0Var);
        this.f12397o = -1;
        this.f12398p = (byte) -1;
        this.f12399q = -1;
        this.f12389g = s0Var.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12399q;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12390h & 1) == 1 ? f9.f.b(1, this.f12391i) : 0;
        if ((this.f12390h & 2) == 2) {
            iB += f9.f.b(2, this.f12392j);
        }
        if ((this.f12390h & 4) == 4) {
            iB += f9.f.h(3) + 1;
        }
        if ((this.f12390h & 8) == 8) {
            iB += f9.f.a(4, this.f12394l.f12381f);
        }
        for (int i10 = 0; i10 < this.f12395m.size(); i10++) {
            iB += f9.f.d(5, (f9.a) this.f12395m.get(i10));
        }
        int iC = 0;
        for (int i11 = 0; i11 < this.f12396n.size(); i11++) {
            iC += f9.f.c(((Integer) this.f12396n.get(i11)).intValue());
        }
        int iC2 = iB + iC;
        if (!this.f12396n.isEmpty()) {
            iC2 = iC2 + 1 + f9.f.c(iC);
        }
        this.f12397o = iC;
        int size = this.f12389g.size() + h() + iC2;
        this.f12399q = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return s0.f();
    }

    @Override // f9.a
    public final f9.j c() {
        s0 s0VarF = s0.f();
        s0VarF.g(this);
        return s0VarF;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12390h & 1) == 1) {
            fVar.m(1, this.f12391i);
        }
        if ((this.f12390h & 2) == 2) {
            fVar.m(2, this.f12392j);
        }
        if ((this.f12390h & 4) == 4) {
            boolean z4 = this.f12393k;
            fVar.x(3, 0);
            fVar.q(z4 ? 1 : 0);
        }
        if ((this.f12390h & 8) == 8) {
            fVar.l(4, this.f12394l.f12381f);
        }
        for (int i2 = 0; i2 < this.f12395m.size(); i2++) {
            fVar.o(5, (f9.a) this.f12395m.get(i2));
        }
        if (this.f12396n.size() > 0) {
            fVar.v(50);
            fVar.v(this.f12397o);
        }
        for (int i10 = 0; i10 < this.f12396n.size(); i10++) {
            fVar.n(((Integer) this.f12396n.get(i10)).intValue());
        }
        bVar.Q0(1000, fVar);
        fVar.r(this.f12389g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12387r;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12398p;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        int i2 = this.f12390h;
        if ((i2 & 1) != 1) {
            this.f12398p = (byte) 0;
            return false;
        }
        if ((i2 & 2) != 2) {
            this.f12398p = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < this.f12395m.size(); i10++) {
            if (!((p0) this.f12395m.get(i10)).isInitialized()) {
                this.f12398p = (byte) 0;
                return false;
            }
        }
        if (g()) {
            this.f12398p = (byte) 1;
            return true;
        }
        this.f12398p = (byte) 0;
        return false;
    }

    public u0() {
        this.f12397o = -1;
        this.f12398p = (byte) -1;
        this.f12399q = -1;
        this.f12389g = f9.d.f3536f;
    }

    public u0(f9.e eVar, f9.h hVar) {
        t0 t0Var;
        this.f12397o = -1;
        this.f12398p = (byte) -1;
        this.f12399q = -1;
        this.f12391i = 0;
        this.f12392j = 0;
        this.f12393k = false;
        t0 t0Var2 = t0.INV;
        this.f12394l = t0Var2;
        List list = Collections.EMPTY_LIST;
        this.f12395m = list;
        this.f12396n = list;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        int i2 = 0;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.f12390h |= 1;
                            this.f12391i = eVar.k();
                        } else if (iN == 16) {
                            this.f12390h |= 2;
                            this.f12392j = eVar.k();
                        } else if (iN == 24) {
                            this.f12390h |= 4;
                            this.f12393k = eVar.l() != 0;
                        } else if (iN == 32) {
                            int iK = eVar.k();
                            if (iK == 0) {
                                t0Var = t0.IN;
                            } else if (iK != 1) {
                                t0Var = iK != 2 ? null : t0Var2;
                            } else {
                                t0Var = t0.OUT;
                            }
                            if (t0Var == null) {
                                fVarJ.v(iN);
                                fVarJ.v(iK);
                            } else {
                                this.f12390h |= 8;
                                this.f12394l = t0Var;
                            }
                        } else if (iN == 42) {
                            if ((i2 & 16) != 16) {
                                this.f12395m = new ArrayList();
                                i2 |= 16;
                            }
                            this.f12395m.add(eVar.g(p0.f12299z, hVar));
                        } else if (iN == 48) {
                            if ((i2 & 32) != 32) {
                                this.f12396n = new ArrayList();
                                i2 |= 32;
                            }
                            this.f12396n.add(Integer.valueOf(eVar.k()));
                        } else if (iN != 50) {
                            if (!l(eVar, fVarJ, hVar, iN)) {
                            }
                        } else {
                            int iD = eVar.d(eVar.k());
                            if ((i2 & 32) != 32 && eVar.b() > 0) {
                                this.f12396n = new ArrayList();
                                i2 |= 32;
                            }
                            while (eVar.b() > 0) {
                                this.f12396n.add(Integer.valueOf(eVar.k()));
                            }
                            eVar.c(iD);
                        }
                    }
                    z4 = true;
                } catch (Throwable th) {
                    if ((i2 & 16) == 16) {
                        this.f12395m = Collections.unmodifiableList(this.f12395m);
                    }
                    if ((i2 & 32) == 32) {
                        this.f12396n = Collections.unmodifiableList(this.f12396n);
                    }
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f12389g = cVar.d();
                        throw th2;
                    }
                    this.f12389g = cVar.d();
                    k();
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
        if ((i2 & 16) == 16) {
            this.f12395m = Collections.unmodifiableList(this.f12395m);
        }
        if ((i2 & 32) == 32) {
            this.f12396n = Collections.unmodifiableList(this.f12396n);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12389g = cVar.d();
            throw th3;
        }
        this.f12389g = cVar.d();
        k();
    }
}
