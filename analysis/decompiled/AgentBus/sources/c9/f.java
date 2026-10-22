package c9;

import f9.o;
import f9.r;
import java.io.IOException;

/* loaded from: classes.dex */
public final class f extends o {

    /* renamed from: o, reason: collision with root package name */
    public static final f f2114o;

    /* renamed from: p, reason: collision with root package name */
    public static final a f2115p = new a(2);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f2116f;

    /* renamed from: g, reason: collision with root package name */
    public int f2117g;

    /* renamed from: h, reason: collision with root package name */
    public c f2118h;

    /* renamed from: i, reason: collision with root package name */
    public d f2119i;

    /* renamed from: j, reason: collision with root package name */
    public d f2120j;

    /* renamed from: k, reason: collision with root package name */
    public d f2121k;

    /* renamed from: l, reason: collision with root package name */
    public d f2122l;

    /* renamed from: m, reason: collision with root package name */
    public byte f2123m;

    /* renamed from: n, reason: collision with root package name */
    public int f2124n;

    static {
        f fVar = new f();
        f2114o = fVar;
        fVar.f2118h = c.f2092l;
        d dVar = d.f2100l;
        fVar.f2119i = dVar;
        fVar.f2120j = dVar;
        fVar.f2121k = dVar;
        fVar.f2122l = dVar;
    }

    public f() {
        this.f2123m = (byte) -1;
        this.f2124n = -1;
        this.f2116f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f2124n;
        if (i2 != -1) {
            return i2;
        }
        int iD = (this.f2117g & 1) == 1 ? f9.f.d(1, this.f2118h) : 0;
        if ((this.f2117g & 2) == 2) {
            iD += f9.f.d(2, this.f2119i);
        }
        if ((this.f2117g & 4) == 4) {
            iD += f9.f.d(3, this.f2120j);
        }
        if ((this.f2117g & 8) == 8) {
            iD += f9.f.d(4, this.f2121k);
        }
        if ((this.f2117g & 16) == 16) {
            iD += f9.f.d(5, this.f2122l);
        }
        int size = this.f2116f.size() + iD;
        this.f2124n = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return e.e();
    }

    @Override // f9.a
    public final f9.j c() {
        e eVarE = e.e();
        eVarE.f(this);
        return eVarE;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f2117g & 1) == 1) {
            fVar.o(1, this.f2118h);
        }
        if ((this.f2117g & 2) == 2) {
            fVar.o(2, this.f2119i);
        }
        if ((this.f2117g & 4) == 4) {
            fVar.o(3, this.f2120j);
        }
        if ((this.f2117g & 8) == 8) {
            fVar.o(4, this.f2121k);
        }
        if ((this.f2117g & 16) == 16) {
            fVar.o(5, this.f2122l);
        }
        fVar.r(this.f2116f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        if (this.f2123m == 1) {
            return true;
        }
        this.f2123m = (byte) 1;
        return true;
    }

    public f(e eVar) {
        this.f2123m = (byte) -1;
        this.f2124n = -1;
        this.f2116f = eVar.f3565f;
    }

    public f(f9.e eVar, f9.h hVar) {
        this.f2123m = (byte) -1;
        this.f2124n = -1;
        this.f2118h = c.f2092l;
        d dVar = d.f2100l;
        this.f2119i = dVar;
        this.f2120j = dVar;
        this.f2121k = dVar;
        this.f2122l = dVar;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        b bVarG = null;
                        if (iN == 10) {
                            if ((this.f2117g & 1) == 1) {
                                c cVar2 = this.f2118h;
                                cVar2.getClass();
                                bVarG = new b(0);
                                bVarG.f(cVar2);
                            }
                            c cVar3 = (c) eVar.g(c.f2093m, hVar);
                            this.f2118h = cVar3;
                            if (bVarG != null) {
                                bVarG.f(cVar3);
                                this.f2118h = bVarG.d();
                            }
                            this.f2117g |= 1;
                        } else if (iN == 18) {
                            if ((this.f2117g & 2) == 2) {
                                d dVar2 = this.f2119i;
                                dVar2.getClass();
                                bVarG = d.g(dVar2);
                            }
                            d dVar3 = (d) eVar.g(d.f2101m, hVar);
                            this.f2119i = dVar3;
                            if (bVarG != null) {
                                bVarG.g(dVar3);
                                this.f2119i = bVarG.e();
                            }
                            this.f2117g |= 2;
                        } else if (iN == 26) {
                            if ((this.f2117g & 4) == 4) {
                                d dVar4 = this.f2120j;
                                dVar4.getClass();
                                bVarG = d.g(dVar4);
                            }
                            d dVar5 = (d) eVar.g(d.f2101m, hVar);
                            this.f2120j = dVar5;
                            if (bVarG != null) {
                                bVarG.g(dVar5);
                                this.f2120j = bVarG.e();
                            }
                            this.f2117g |= 4;
                        } else if (iN == 34) {
                            if ((this.f2117g & 8) == 8) {
                                d dVar6 = this.f2121k;
                                dVar6.getClass();
                                bVarG = d.g(dVar6);
                            }
                            d dVar7 = (d) eVar.g(d.f2101m, hVar);
                            this.f2121k = dVar7;
                            if (bVarG != null) {
                                bVarG.g(dVar7);
                                this.f2121k = bVarG.e();
                            }
                            this.f2117g |= 8;
                        } else if (iN != 42) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            if ((this.f2117g & 16) == 16) {
                                d dVar8 = this.f2122l;
                                dVar8.getClass();
                                bVarG = d.g(dVar8);
                            }
                            d dVar9 = (d) eVar.g(d.f2101m, hVar);
                            this.f2122l = dVar9;
                            if (bVarG != null) {
                                bVarG.g(dVar9);
                                this.f2122l = bVarG.e();
                            }
                            this.f2117g |= 16;
                        }
                    }
                    z4 = true;
                } catch (r e10) {
                    e10.f3597f = this;
                    throw e10;
                } catch (IOException e11) {
                    r rVar = new r(e11.getMessage());
                    rVar.f3597f = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f2116f = cVar.d();
                    throw th2;
                }
                this.f2116f = cVar.d();
                throw th;
            }
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f2116f = cVar.d();
            throw th3;
        }
        this.f2116f = cVar.d();
    }
}
