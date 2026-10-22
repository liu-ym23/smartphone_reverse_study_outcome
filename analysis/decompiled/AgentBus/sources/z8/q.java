package z8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class q extends f9.o {

    /* renamed from: n, reason: collision with root package name */
    public static final q f12318n;

    /* renamed from: o, reason: collision with root package name */
    public static final c9.a f12319o = new c9.a(11);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12320f;

    /* renamed from: g, reason: collision with root package name */
    public int f12321g;

    /* renamed from: h, reason: collision with root package name */
    public o f12322h;

    /* renamed from: i, reason: collision with root package name */
    public List f12323i;

    /* renamed from: j, reason: collision with root package name */
    public v f12324j;

    /* renamed from: k, reason: collision with root package name */
    public p f12325k;

    /* renamed from: l, reason: collision with root package name */
    public byte f12326l;

    /* renamed from: m, reason: collision with root package name */
    public int f12327m;

    static {
        q qVar = new q();
        f12318n = qVar;
        qVar.f12322h = o.RETURNS_CONSTANT;
        qVar.f12323i = Collections.EMPTY_LIST;
        qVar.f12324j = v.f12400q;
        qVar.f12325k = p.AT_MOST_ONCE;
    }

    public q() {
        this.f12326l = (byte) -1;
        this.f12327m = -1;
        this.f12320f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12327m;
        if (i2 != -1) {
            return i2;
        }
        int iA = (this.f12321g & 1) == 1 ? f9.f.a(1, this.f12322h.f12277f) : 0;
        for (int i10 = 0; i10 < this.f12323i.size(); i10++) {
            iA += f9.f.d(2, (f9.a) this.f12323i.get(i10));
        }
        if ((this.f12321g & 2) == 2) {
            iA += f9.f.d(3, this.f12324j);
        }
        if ((this.f12321g & 4) == 4) {
            iA += f9.f.a(4, this.f12325k.f12297f);
        }
        int size = this.f12320f.size() + iA;
        this.f12327m = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return n.e();
    }

    @Override // f9.a
    public final f9.j c() {
        n nVarE = n.e();
        nVarE.f(this);
        return nVarE;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f12321g & 1) == 1) {
            fVar.l(1, this.f12322h.f12277f);
        }
        for (int i2 = 0; i2 < this.f12323i.size(); i2++) {
            fVar.o(2, (f9.a) this.f12323i.get(i2));
        }
        if ((this.f12321g & 2) == 2) {
            fVar.o(3, this.f12324j);
        }
        if ((this.f12321g & 4) == 4) {
            fVar.l(4, this.f12325k.f12297f);
        }
        fVar.r(this.f12320f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12326l;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.f12323i.size(); i2++) {
            if (!((v) this.f12323i.get(i2)).isInitialized()) {
                this.f12326l = (byte) 0;
                return false;
            }
        }
        if ((this.f12321g & 2) != 2 || this.f12324j.isInitialized()) {
            this.f12326l = (byte) 1;
            return true;
        }
        this.f12326l = (byte) 0;
        return false;
    }

    public q(f9.e eVar, f9.h hVar) {
        this.f12326l = (byte) -1;
        this.f12327m = -1;
        o oVar = o.RETURNS_CONSTANT;
        this.f12322h = oVar;
        this.f12323i = Collections.EMPTY_LIST;
        this.f12324j = v.f12400q;
        p pVar = p.AT_MOST_ONCE;
        this.f12325k = pVar;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        char c10 = 0;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        p pVar2 = null;
                        o oVar2 = null;
                        t tVarE = null;
                        if (iN == 8) {
                            int iK = eVar.k();
                            if (iK == 0) {
                                oVar2 = oVar;
                            } else if (iK == 1) {
                                oVar2 = o.CALLS;
                            } else if (iK == 2) {
                                oVar2 = o.RETURNS_NOT_NULL;
                            }
                            if (oVar2 == null) {
                                fVarJ.v(iN);
                                fVarJ.v(iK);
                            } else {
                                this.f12321g |= 1;
                                this.f12322h = oVar2;
                            }
                        } else if (iN == 18) {
                            int i2 = (c10 == true ? 1 : 0) & 2;
                            c10 = c10;
                            if (i2 != 2) {
                                this.f12323i = new ArrayList();
                                c10 = 2;
                            }
                            this.f12323i.add(eVar.g(v.f12401r, hVar));
                        } else if (iN == 26) {
                            if ((this.f12321g & 2) == 2) {
                                v vVar = this.f12324j;
                                vVar.getClass();
                                tVarE = t.e();
                                tVarE.f(vVar);
                            }
                            v vVar2 = (v) eVar.g(v.f12401r, hVar);
                            this.f12324j = vVar2;
                            if (tVarE != null) {
                                tVarE.f(vVar2);
                                this.f12324j = tVarE.d();
                            }
                            this.f12321g |= 2;
                        } else if (iN != 32) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            int iK2 = eVar.k();
                            if (iK2 == 0) {
                                pVar2 = pVar;
                            } else if (iK2 == 1) {
                                pVar2 = p.EXACTLY_ONCE;
                            } else if (iK2 == 2) {
                                pVar2 = p.AT_LEAST_ONCE;
                            }
                            if (pVar2 == null) {
                                fVarJ.v(iN);
                                fVarJ.v(iK2);
                            } else {
                                this.f12321g |= 4;
                                this.f12325k = pVar2;
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
                if (((c10 == true ? 1 : 0) & 2) == 2) {
                    this.f12323i = Collections.unmodifiableList(this.f12323i);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12320f = cVar.d();
                    throw th2;
                }
                this.f12320f = cVar.d();
                throw th;
            }
        }
        if (((c10 == true ? 1 : 0) & 2) == 2) {
            this.f12323i = Collections.unmodifiableList(this.f12323i);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12320f = cVar.d();
            throw th3;
        }
        this.f12320f = cVar.d();
    }

    public q(n nVar) {
        this.f12326l = (byte) -1;
        this.f12327m = -1;
        this.f12320f = nVar.f3565f;
    }
}
