package c9;

import f9.o;
import f9.r;
import f9.u;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class j extends o {

    /* renamed from: r, reason: collision with root package name */
    public static final j f2140r;

    /* renamed from: s, reason: collision with root package name */
    public static final a f2141s = new a(4);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f2142f;

    /* renamed from: g, reason: collision with root package name */
    public int f2143g;

    /* renamed from: h, reason: collision with root package name */
    public int f2144h;

    /* renamed from: i, reason: collision with root package name */
    public int f2145i;

    /* renamed from: j, reason: collision with root package name */
    public Object f2146j;

    /* renamed from: k, reason: collision with root package name */
    public i f2147k;

    /* renamed from: l, reason: collision with root package name */
    public List f2148l;

    /* renamed from: m, reason: collision with root package name */
    public int f2149m;

    /* renamed from: n, reason: collision with root package name */
    public List f2150n;

    /* renamed from: o, reason: collision with root package name */
    public int f2151o;

    /* renamed from: p, reason: collision with root package name */
    public byte f2152p;

    /* renamed from: q, reason: collision with root package name */
    public int f2153q;

    static {
        j jVar = new j();
        f2140r = jVar;
        jVar.f2144h = 1;
        jVar.f2145i = 0;
        jVar.f2146j = "";
        jVar.f2147k = i.NONE;
        List list = Collections.EMPTY_LIST;
        jVar.f2148l = list;
        jVar.f2150n = list;
    }

    public j() {
        this.f2149m = -1;
        this.f2151o = -1;
        this.f2152p = (byte) -1;
        this.f2153q = -1;
        this.f2142f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        f9.d uVar;
        int i2 = this.f2153q;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f2143g & 1) == 1 ? f9.f.b(1, this.f2144h) : 0;
        if ((this.f2143g & 2) == 2) {
            iB += f9.f.b(2, this.f2145i);
        }
        if ((this.f2143g & 8) == 8) {
            iB += f9.f.a(3, this.f2147k.f2139f);
        }
        int iC = 0;
        for (int i10 = 0; i10 < this.f2148l.size(); i10++) {
            iC += f9.f.c(((Integer) this.f2148l.get(i10)).intValue());
        }
        int iC2 = iB + iC;
        if (!this.f2148l.isEmpty()) {
            iC2 = iC2 + 1 + f9.f.c(iC);
        }
        this.f2149m = iC;
        int iC3 = 0;
        for (int i11 = 0; i11 < this.f2150n.size(); i11++) {
            iC3 += f9.f.c(((Integer) this.f2150n.get(i11)).intValue());
        }
        int size = iC2 + iC3;
        if (!this.f2150n.isEmpty()) {
            size = size + 1 + f9.f.c(iC3);
        }
        this.f2151o = iC3;
        if ((this.f2143g & 4) == 4) {
            Object obj = this.f2146j;
            if (obj instanceof String) {
                try {
                    uVar = new u(((String) obj).getBytes("UTF-8"));
                    this.f2146j = uVar;
                } catch (UnsupportedEncodingException e10) {
                    throw new RuntimeException("UTF-8 not supported?", e10);
                }
            } else {
                uVar = (f9.d) obj;
            }
            size += uVar.size() + f9.f.f(uVar.size()) + f9.f.h(6);
        }
        int size2 = this.f2142f.size() + size;
        this.f2153q = size2;
        return size2;
    }

    @Override // f9.a
    public final f9.j b() {
        return h.e();
    }

    @Override // f9.a
    public final f9.j c() {
        h hVarE = h.e();
        hVarE.f(this);
        return hVarE;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        f9.d uVar;
        a();
        if ((this.f2143g & 1) == 1) {
            fVar.m(1, this.f2144h);
        }
        if ((this.f2143g & 2) == 2) {
            fVar.m(2, this.f2145i);
        }
        if ((this.f2143g & 8) == 8) {
            fVar.l(3, this.f2147k.f2139f);
        }
        if (this.f2148l.size() > 0) {
            fVar.v(34);
            fVar.v(this.f2149m);
        }
        for (int i2 = 0; i2 < this.f2148l.size(); i2++) {
            fVar.n(((Integer) this.f2148l.get(i2)).intValue());
        }
        if (this.f2150n.size() > 0) {
            fVar.v(42);
            fVar.v(this.f2151o);
        }
        for (int i10 = 0; i10 < this.f2150n.size(); i10++) {
            fVar.n(((Integer) this.f2150n.get(i10)).intValue());
        }
        if ((this.f2143g & 4) == 4) {
            Object obj = this.f2146j;
            if (obj instanceof String) {
                try {
                    uVar = new u(((String) obj).getBytes("UTF-8"));
                    this.f2146j = uVar;
                } catch (UnsupportedEncodingException e10) {
                    throw new RuntimeException("UTF-8 not supported?", e10);
                }
            } else {
                uVar = (f9.d) obj;
            }
            fVar.x(6, 2);
            fVar.v(uVar.size());
            fVar.r(uVar);
        }
        fVar.r(this.f2142f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        if (this.f2152p == 1) {
            return true;
        }
        this.f2152p = (byte) 1;
        return true;
    }

    public j(h hVar) {
        this.f2149m = -1;
        this.f2151o = -1;
        this.f2152p = (byte) -1;
        this.f2153q = -1;
        this.f2142f = hVar.f3565f;
    }

    public j(f9.e eVar) {
        i iVar;
        this.f2149m = -1;
        this.f2151o = -1;
        this.f2152p = (byte) -1;
        this.f2153q = -1;
        this.f2144h = 1;
        boolean z4 = false;
        this.f2145i = 0;
        this.f2146j = "";
        i iVar2 = i.NONE;
        this.f2147k = iVar2;
        List list = Collections.EMPTY_LIST;
        this.f2148l = list;
        this.f2150n = list;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        int i2 = 0;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.f2143g |= 1;
                            this.f2144h = eVar.k();
                        } else if (iN == 16) {
                            this.f2143g |= 2;
                            this.f2145i = eVar.k();
                        } else if (iN == 24) {
                            int iK = eVar.k();
                            if (iK == 0) {
                                iVar = iVar2;
                            } else if (iK != 1) {
                                iVar = iK != 2 ? null : i.DESC_TO_CLASS_ID;
                            } else {
                                iVar = i.INTERNAL_TO_CLASS_ID;
                            }
                            if (iVar == null) {
                                fVarJ.v(iN);
                                fVarJ.v(iK);
                            } else {
                                this.f2143g |= 8;
                                this.f2147k = iVar;
                            }
                        } else if (iN == 32) {
                            if ((i2 & 16) != 16) {
                                this.f2148l = new ArrayList();
                                i2 |= 16;
                            }
                            this.f2148l.add(Integer.valueOf(eVar.k()));
                        } else if (iN == 34) {
                            int iD = eVar.d(eVar.k());
                            if ((i2 & 16) != 16 && eVar.b() > 0) {
                                this.f2148l = new ArrayList();
                                i2 |= 16;
                            }
                            while (eVar.b() > 0) {
                                this.f2148l.add(Integer.valueOf(eVar.k()));
                            }
                            eVar.c(iD);
                        } else if (iN == 40) {
                            if ((i2 & 32) != 32) {
                                this.f2150n = new ArrayList();
                                i2 |= 32;
                            }
                            this.f2150n.add(Integer.valueOf(eVar.k()));
                        } else if (iN == 42) {
                            int iD2 = eVar.d(eVar.k());
                            if ((i2 & 32) != 32 && eVar.b() > 0) {
                                this.f2150n = new ArrayList();
                                i2 |= 32;
                            }
                            while (eVar.b() > 0) {
                                this.f2150n.add(Integer.valueOf(eVar.k()));
                            }
                            eVar.c(iD2);
                        } else if (iN != 50) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            u uVarE = eVar.e();
                            this.f2143g |= 4;
                            this.f2146j = uVarE;
                        }
                    }
                    z4 = true;
                } catch (Throwable th) {
                    if ((i2 & 16) == 16) {
                        this.f2148l = Collections.unmodifiableList(this.f2148l);
                    }
                    if ((i2 & 32) == 32) {
                        this.f2150n = Collections.unmodifiableList(this.f2150n);
                    }
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f2142f = cVar.d();
                        throw th2;
                    }
                    this.f2142f = cVar.d();
                    throw th;
                }
            } catch (r e10) {
                e10.f3597f = this;
                throw e10;
            } catch (IOException e11) {
                r rVar = new r(e11.getMessage());
                rVar.f3597f = this;
                throw rVar;
            }
        }
        if ((i2 & 16) == 16) {
            this.f2148l = Collections.unmodifiableList(this.f2148l);
        }
        if ((i2 & 32) == 32) {
            this.f2150n = Collections.unmodifiableList(this.f2150n);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f2142f = cVar.d();
            throw th3;
        }
        this.f2142f = cVar.d();
    }
}
