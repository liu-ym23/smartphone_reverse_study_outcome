package z8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class v extends f9.o {

    /* renamed from: q, reason: collision with root package name */
    public static final v f12400q;

    /* renamed from: r, reason: collision with root package name */
    public static final c9.a f12401r = new c9.a(13);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12402f;

    /* renamed from: g, reason: collision with root package name */
    public int f12403g;

    /* renamed from: h, reason: collision with root package name */
    public int f12404h;

    /* renamed from: i, reason: collision with root package name */
    public int f12405i;

    /* renamed from: j, reason: collision with root package name */
    public u f12406j;

    /* renamed from: k, reason: collision with root package name */
    public p0 f12407k;

    /* renamed from: l, reason: collision with root package name */
    public int f12408l;

    /* renamed from: m, reason: collision with root package name */
    public List f12409m;

    /* renamed from: n, reason: collision with root package name */
    public List f12410n;

    /* renamed from: o, reason: collision with root package name */
    public byte f12411o;

    /* renamed from: p, reason: collision with root package name */
    public int f12412p;

    static {
        v vVar = new v();
        f12400q = vVar;
        vVar.f12404h = 0;
        vVar.f12405i = 0;
        vVar.f12406j = u.TRUE;
        vVar.f12407k = p0.f12298y;
        vVar.f12408l = 0;
        List list = Collections.EMPTY_LIST;
        vVar.f12409m = list;
        vVar.f12410n = list;
    }

    public v() {
        this.f12411o = (byte) -1;
        this.f12412p = -1;
        this.f12402f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12412p;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12403g & 1) == 1 ? f9.f.b(1, this.f12404h) : 0;
        if ((this.f12403g & 2) == 2) {
            iB += f9.f.b(2, this.f12405i);
        }
        if ((this.f12403g & 4) == 4) {
            iB += f9.f.a(3, this.f12406j.f12386f);
        }
        if ((this.f12403g & 8) == 8) {
            iB += f9.f.d(4, this.f12407k);
        }
        if ((this.f12403g & 16) == 16) {
            iB += f9.f.b(5, this.f12408l);
        }
        for (int i10 = 0; i10 < this.f12409m.size(); i10++) {
            iB += f9.f.d(6, (f9.a) this.f12409m.get(i10));
        }
        for (int i11 = 0; i11 < this.f12410n.size(); i11++) {
            iB += f9.f.d(7, (f9.a) this.f12410n.get(i11));
        }
        int size = this.f12402f.size() + iB;
        this.f12412p = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return t.e();
    }

    @Override // f9.a
    public final f9.j c() {
        t tVarE = t.e();
        tVarE.f(this);
        return tVarE;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f12403g & 1) == 1) {
            fVar.m(1, this.f12404h);
        }
        if ((this.f12403g & 2) == 2) {
            fVar.m(2, this.f12405i);
        }
        if ((this.f12403g & 4) == 4) {
            fVar.l(3, this.f12406j.f12386f);
        }
        if ((this.f12403g & 8) == 8) {
            fVar.o(4, this.f12407k);
        }
        if ((this.f12403g & 16) == 16) {
            fVar.m(5, this.f12408l);
        }
        for (int i2 = 0; i2 < this.f12409m.size(); i2++) {
            fVar.o(6, (f9.a) this.f12409m.get(i2));
        }
        for (int i10 = 0; i10 < this.f12410n.size(); i10++) {
            fVar.o(7, (f9.a) this.f12410n.get(i10));
        }
        fVar.r(this.f12402f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12411o;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if ((this.f12403g & 8) == 8 && !this.f12407k.isInitialized()) {
            this.f12411o = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < this.f12409m.size(); i2++) {
            if (!((v) this.f12409m.get(i2)).isInitialized()) {
                this.f12411o = (byte) 0;
                return false;
            }
        }
        for (int i10 = 0; i10 < this.f12410n.size(); i10++) {
            if (!((v) this.f12410n.get(i10)).isInitialized()) {
                this.f12411o = (byte) 0;
                return false;
            }
        }
        this.f12411o = (byte) 1;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    public v(f9.e eVar, f9.h hVar) {
        u uVar;
        this.f12411o = (byte) -1;
        this.f12412p = -1;
        boolean z4 = false;
        this.f12404h = 0;
        this.f12405i = 0;
        u uVar2 = u.TRUE;
        this.f12406j = uVar2;
        this.f12407k = p0.f12298y;
        this.f12408l = 0;
        List list = Collections.EMPTY_LIST;
        this.f12409m = list;
        this.f12410n = list;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        char c10 = 0;
        while (!z4) {
            try {
                try {
                    try {
                        int iN = eVar.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.f12403g |= 1;
                                this.f12404h = eVar.k();
                            } else if (iN != 16) {
                                o0 o0VarP = null;
                                u uVar3 = null;
                                if (iN == 24) {
                                    int iK = eVar.k();
                                    if (iK != 0) {
                                        if (iK == 1) {
                                            uVar3 = u.FALSE;
                                        } else if (iK == 2) {
                                            uVar3 = u.NULL;
                                        }
                                        uVar = uVar3;
                                    } else {
                                        uVar = uVar2;
                                    }
                                    if (uVar == null) {
                                        fVarJ.v(iN);
                                        fVarJ.v(iK);
                                    } else {
                                        this.f12403g |= 4;
                                        this.f12406j = uVar;
                                    }
                                } else if (iN == 34) {
                                    if ((this.f12403g & 8) == 8) {
                                        p0 p0Var = this.f12407k;
                                        p0Var.getClass();
                                        o0VarP = p0.p(p0Var);
                                    }
                                    o0 o0Var = o0VarP;
                                    p0 p0Var2 = (p0) eVar.g(p0.f12299z, hVar);
                                    this.f12407k = p0Var2;
                                    if (o0Var != null) {
                                        o0Var.g(p0Var2);
                                        this.f12407k = o0Var.e();
                                    }
                                    this.f12403g |= 8;
                                } else if (iN != 40) {
                                    c9.a aVar = f12401r;
                                    if (iN == 50) {
                                        int i2 = (c10 == true ? 1 : 0) & 32;
                                        c10 = c10;
                                        if (i2 != 32) {
                                            this.f12409m = new ArrayList();
                                            c10 = (c10 == true ? 1 : 0) | ' ';
                                        }
                                        this.f12409m.add(eVar.g(aVar, hVar));
                                    } else if (iN != 58) {
                                        if (!eVar.q(iN, fVarJ)) {
                                        }
                                    } else {
                                        int i10 = (c10 == true ? 1 : 0) & 64;
                                        c10 = c10;
                                        if (i10 != 64) {
                                            this.f12410n = new ArrayList();
                                            c10 = (c10 == true ? 1 : 0) | '@';
                                        }
                                        this.f12410n.add(eVar.g(aVar, hVar));
                                    }
                                } else {
                                    this.f12403g |= 16;
                                    this.f12408l = eVar.k();
                                }
                            } else {
                                this.f12403g |= 2;
                                this.f12405i = eVar.k();
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
                if (((c10 == true ? 1 : 0) & 32) == 32) {
                    this.f12409m = Collections.unmodifiableList(this.f12409m);
                }
                if (((c10 == true ? 1 : 0) & 64) == 64) {
                    this.f12410n = Collections.unmodifiableList(this.f12410n);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12402f = cVar.d();
                    throw th2;
                }
                this.f12402f = cVar.d();
                throw th;
            }
        }
        if (((c10 == true ? 1 : 0) & 32) == 32) {
            this.f12409m = Collections.unmodifiableList(this.f12409m);
        }
        if (((c10 == true ? 1 : 0) & 64) == 64) {
            this.f12410n = Collections.unmodifiableList(this.f12410n);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12402f = cVar.d();
            throw th3;
        }
        this.f12402f = cVar.d();
    }

    public v(t tVar) {
        this.f12411o = (byte) -1;
        this.f12412p = -1;
        this.f12402f = tVar.f3565f;
    }
}
