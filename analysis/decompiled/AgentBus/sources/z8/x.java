package z8;

import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class x extends f9.l {
    public static final c9.a A = new c9.a(14);

    /* renamed from: z, reason: collision with root package name */
    public static final x f12443z;

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12444g;

    /* renamed from: h, reason: collision with root package name */
    public int f12445h;

    /* renamed from: i, reason: collision with root package name */
    public int f12446i;

    /* renamed from: j, reason: collision with root package name */
    public int f12447j;

    /* renamed from: k, reason: collision with root package name */
    public int f12448k;

    /* renamed from: l, reason: collision with root package name */
    public p0 f12449l;

    /* renamed from: m, reason: collision with root package name */
    public int f12450m;

    /* renamed from: n, reason: collision with root package name */
    public List f12451n;

    /* renamed from: o, reason: collision with root package name */
    public p0 f12452o;

    /* renamed from: p, reason: collision with root package name */
    public int f12453p;

    /* renamed from: q, reason: collision with root package name */
    public List f12454q;

    /* renamed from: r, reason: collision with root package name */
    public List f12455r;

    /* renamed from: s, reason: collision with root package name */
    public int f12456s;

    /* renamed from: t, reason: collision with root package name */
    public List f12457t;

    /* renamed from: u, reason: collision with root package name */
    public v0 f12458u;

    /* renamed from: v, reason: collision with root package name */
    public List f12459v;

    /* renamed from: w, reason: collision with root package name */
    public m f12460w;

    /* renamed from: x, reason: collision with root package name */
    public byte f12461x;

    /* renamed from: y, reason: collision with root package name */
    public int f12462y;

    static {
        x xVar = new x();
        f12443z = xVar;
        xVar.n();
    }

    public x(w wVar) {
        super(wVar);
        this.f12456s = -1;
        this.f12461x = (byte) -1;
        this.f12462y = -1;
        this.f12444g = wVar.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12462y;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12445h & 2) == 2 ? f9.f.b(1, this.f12447j) : 0;
        if ((this.f12445h & 4) == 4) {
            iB += f9.f.b(2, this.f12448k);
        }
        if ((this.f12445h & 8) == 8) {
            iB += f9.f.d(3, this.f12449l);
        }
        for (int i10 = 0; i10 < this.f12451n.size(); i10++) {
            iB += f9.f.d(4, (f9.a) this.f12451n.get(i10));
        }
        if ((this.f12445h & 32) == 32) {
            iB += f9.f.d(5, this.f12452o);
        }
        for (int i11 = 0; i11 < this.f12457t.size(); i11++) {
            iB += f9.f.d(6, (f9.a) this.f12457t.get(i11));
        }
        if ((this.f12445h & 16) == 16) {
            iB += f9.f.b(7, this.f12450m);
        }
        if ((this.f12445h & 64) == 64) {
            iB += f9.f.b(8, this.f12453p);
        }
        if ((this.f12445h & 1) == 1) {
            iB += f9.f.b(9, this.f12446i);
        }
        for (int i12 = 0; i12 < this.f12454q.size(); i12++) {
            iB += f9.f.d(10, (f9.a) this.f12454q.get(i12));
        }
        int iC = 0;
        for (int i13 = 0; i13 < this.f12455r.size(); i13++) {
            iC += f9.f.c(((Integer) this.f12455r.get(i13)).intValue());
        }
        int iD = iB + iC;
        if (!this.f12455r.isEmpty()) {
            iD = iD + 1 + f9.f.c(iC);
        }
        this.f12456s = iC;
        if ((this.f12445h & 128) == 128) {
            iD += f9.f.d(30, this.f12458u);
        }
        int iC2 = 0;
        for (int i14 = 0; i14 < this.f12459v.size(); i14++) {
            iC2 += f9.f.c(((Integer) this.f12459v.get(i14)).intValue());
        }
        int size = (this.f12459v.size() * 2) + iD + iC2;
        if ((this.f12445h & 256) == 256) {
            size += f9.f.d(32, this.f12460w);
        }
        int size2 = this.f12444g.size() + h() + size;
        this.f12462y = size2;
        return size2;
    }

    @Override // f9.a
    public final f9.j b() {
        return w.f();
    }

    @Override // f9.a
    public final f9.j c() {
        w wVarF = w.f();
        wVarF.g(this);
        return wVarF;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12445h & 2) == 2) {
            fVar.m(1, this.f12447j);
        }
        if ((this.f12445h & 4) == 4) {
            fVar.m(2, this.f12448k);
        }
        if ((this.f12445h & 8) == 8) {
            fVar.o(3, this.f12449l);
        }
        for (int i2 = 0; i2 < this.f12451n.size(); i2++) {
            fVar.o(4, (f9.a) this.f12451n.get(i2));
        }
        if ((this.f12445h & 32) == 32) {
            fVar.o(5, this.f12452o);
        }
        for (int i10 = 0; i10 < this.f12457t.size(); i10++) {
            fVar.o(6, (f9.a) this.f12457t.get(i10));
        }
        if ((this.f12445h & 16) == 16) {
            fVar.m(7, this.f12450m);
        }
        if ((this.f12445h & 64) == 64) {
            fVar.m(8, this.f12453p);
        }
        if ((this.f12445h & 1) == 1) {
            fVar.m(9, this.f12446i);
        }
        for (int i11 = 0; i11 < this.f12454q.size(); i11++) {
            fVar.o(10, (f9.a) this.f12454q.get(i11));
        }
        if (this.f12455r.size() > 0) {
            fVar.v(90);
            fVar.v(this.f12456s);
        }
        for (int i12 = 0; i12 < this.f12455r.size(); i12++) {
            fVar.n(((Integer) this.f12455r.get(i12)).intValue());
        }
        if ((this.f12445h & 128) == 128) {
            fVar.o(30, this.f12458u);
        }
        for (int i13 = 0; i13 < this.f12459v.size(); i13++) {
            fVar.m(31, ((Integer) this.f12459v.get(i13)).intValue());
        }
        if ((this.f12445h & 256) == 256) {
            fVar.o(32, this.f12460w);
        }
        bVar.Q0(19000, fVar);
        fVar.r(this.f12444g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12443z;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12461x;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        int i2 = this.f12445h;
        if ((i2 & 4) != 4) {
            this.f12461x = (byte) 0;
            return false;
        }
        if ((i2 & 8) == 8 && !this.f12449l.isInitialized()) {
            this.f12461x = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < this.f12451n.size(); i10++) {
            if (!((u0) this.f12451n.get(i10)).isInitialized()) {
                this.f12461x = (byte) 0;
                return false;
            }
        }
        if ((this.f12445h & 32) == 32 && !this.f12452o.isInitialized()) {
            this.f12461x = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < this.f12454q.size(); i11++) {
            if (!((p0) this.f12454q.get(i11)).isInitialized()) {
                this.f12461x = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < this.f12457t.size(); i12++) {
            if (!((x0) this.f12457t.get(i12)).isInitialized()) {
                this.f12461x = (byte) 0;
                return false;
            }
        }
        if ((this.f12445h & 128) == 128 && !this.f12458u.isInitialized()) {
            this.f12461x = (byte) 0;
            return false;
        }
        if ((this.f12445h & 256) == 256 && !this.f12460w.isInitialized()) {
            this.f12461x = (byte) 0;
            return false;
        }
        if (g()) {
            this.f12461x = (byte) 1;
            return true;
        }
        this.f12461x = (byte) 0;
        return false;
    }

    public final void n() {
        this.f12446i = 6;
        this.f12447j = 6;
        this.f12448k = 0;
        p0 p0Var = p0.f12298y;
        this.f12449l = p0Var;
        this.f12450m = 0;
        List list = Collections.EMPTY_LIST;
        this.f12451n = list;
        this.f12452o = p0Var;
        this.f12453p = 0;
        this.f12454q = list;
        this.f12455r = list;
        this.f12457t = list;
        this.f12458u = v0.f12413l;
        this.f12459v = list;
        this.f12460w = m.f12247j;
    }

    public x() {
        this.f12456s = -1;
        this.f12461x = (byte) -1;
        this.f12462y = -1;
        this.f12444g = f9.d.f3536f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public x(f9.e eVar, f9.h hVar) {
        this.f12456s = -1;
        this.f12461x = (byte) -1;
        this.f12462y = -1;
        n();
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        char c10 = 0;
        while (true) {
            ?? L = 1024;
            if (!z4) {
                try {
                    try {
                        int iN = eVar.n();
                        o0 o0VarP = null;
                        l lVar = null;
                        e eVarG = null;
                        o0 o0VarP2 = null;
                        switch (iN) {
                            case 0:
                                z4 = true;
                            case 8:
                                this.f12445h |= 2;
                                this.f12447j = eVar.k();
                            case 16:
                                this.f12445h |= 4;
                                this.f12448k = eVar.k();
                            case 26:
                                if ((this.f12445h & 8) == 8) {
                                    p0 p0Var = this.f12449l;
                                    p0Var.getClass();
                                    o0VarP = p0.p(p0Var);
                                }
                                p0 p0Var2 = (p0) eVar.g(p0.f12299z, hVar);
                                this.f12449l = p0Var2;
                                if (o0VarP != null) {
                                    o0VarP.g(p0Var2);
                                    this.f12449l = o0VarP.e();
                                }
                                this.f12445h |= 8;
                            case 34:
                                int i2 = (c10 == true ? 1 : 0) & 32;
                                c10 = c10;
                                if (i2 != 32) {
                                    this.f12451n = new ArrayList();
                                    c10 = (c10 == true ? 1 : 0) | ' ';
                                }
                                this.f12451n.add(eVar.g(u0.f12388s, hVar));
                            case 42:
                                if ((this.f12445h & 32) == 32) {
                                    p0 p0Var3 = this.f12452o;
                                    p0Var3.getClass();
                                    o0VarP2 = p0.p(p0Var3);
                                }
                                p0 p0Var4 = (p0) eVar.g(p0.f12299z, hVar);
                                this.f12452o = p0Var4;
                                if (o0VarP2 != null) {
                                    o0VarP2.g(p0Var4);
                                    this.f12452o = o0VarP2.e();
                                }
                                this.f12445h |= 32;
                            case 50:
                                int i10 = (c10 == true ? 1 : 0) & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
                                c10 = c10;
                                if (i10 != 1024) {
                                    this.f12457t = new ArrayList();
                                    c10 = (c10 == true ? 1 : 0) | 1024;
                                }
                                this.f12457t.add(eVar.g(x0.f12464r, hVar));
                            case 56:
                                this.f12445h |= 16;
                                this.f12450m = eVar.k();
                            case 64:
                                this.f12445h |= 64;
                                this.f12453p = eVar.k();
                            case 72:
                                this.f12445h |= 1;
                                this.f12446i = eVar.k();
                            case 82:
                                int i11 = (c10 == true ? 1 : 0) & 256;
                                c10 = c10;
                                if (i11 != 256) {
                                    this.f12454q = new ArrayList();
                                    c10 = (c10 == true ? 1 : 0) | 256;
                                }
                                this.f12454q.add(eVar.g(p0.f12299z, hVar));
                            case 88:
                                int i12 = (c10 == true ? 1 : 0) & 512;
                                c10 = c10;
                                if (i12 != 512) {
                                    this.f12455r = new ArrayList();
                                    c10 = (c10 == true ? 1 : 0) | 512;
                                }
                                this.f12455r.add(Integer.valueOf(eVar.k()));
                            case 90:
                                int iD = eVar.d(eVar.k());
                                int i13 = (c10 == true ? 1 : 0) & 512;
                                c10 = c10;
                                if (i13 != 512) {
                                    c10 = c10;
                                    if (eVar.b() > 0) {
                                        this.f12455r = new ArrayList();
                                        c10 = (c10 == true ? 1 : 0) | 512;
                                    }
                                }
                                while (eVar.b() > 0) {
                                    this.f12455r.add(Integer.valueOf(eVar.k()));
                                }
                                eVar.c(iD);
                            case 242:
                                if ((this.f12445h & 128) == 128) {
                                    v0 v0Var = this.f12458u;
                                    v0Var.getClass();
                                    eVarG = v0.g(v0Var);
                                }
                                v0 v0Var2 = (v0) eVar.g(v0.f12414m, hVar);
                                this.f12458u = v0Var2;
                                if (eVarG != null) {
                                    eVarG.j(v0Var2);
                                    this.f12458u = eVarG.f();
                                }
                                this.f12445h |= 128;
                            case 248:
                                int i14 = (c10 == true ? 1 : 0) & 4096;
                                c10 = c10;
                                if (i14 != 4096) {
                                    this.f12459v = new ArrayList();
                                    c10 = (c10 == true ? 1 : 0) | 4096;
                                }
                                this.f12459v.add(Integer.valueOf(eVar.k()));
                            case 250:
                                int iD2 = eVar.d(eVar.k());
                                int i15 = (c10 == true ? 1 : 0) & 4096;
                                c10 = c10;
                                if (i15 != 4096) {
                                    c10 = c10;
                                    if (eVar.b() > 0) {
                                        this.f12459v = new ArrayList();
                                        c10 = (c10 == true ? 1 : 0) | 4096;
                                    }
                                }
                                while (eVar.b() > 0) {
                                    this.f12459v.add(Integer.valueOf(eVar.k()));
                                }
                                eVar.c(iD2);
                            case 258:
                                if ((this.f12445h & 256) == 256) {
                                    m mVar = this.f12460w;
                                    mVar.getClass();
                                    lVar = new l(0);
                                    lVar.f12242i = Collections.EMPTY_LIST;
                                    lVar.h(mVar);
                                }
                                m mVar2 = (m) eVar.g(m.f12248k, hVar);
                                this.f12460w = mVar2;
                                if (lVar != null) {
                                    lVar.h(mVar2);
                                    this.f12460w = lVar.d();
                                }
                                this.f12445h |= 256;
                            default:
                                L = l(eVar, fVarJ, hVar, iN);
                                if (L == 0) {
                                    z4 = true;
                                }
                        }
                    } catch (f9.r e10) {
                        e10.f3597f = this;
                        throw e10;
                    } catch (IOException e11) {
                        f9.r rVar = new f9.r(e11.getMessage());
                        rVar.f3597f = this;
                        throw rVar;
                    }
                } catch (Throwable th) {
                    if (((c10 == true ? 1 : 0) & 32) == 32) {
                        this.f12451n = Collections.unmodifiableList(this.f12451n);
                    }
                    if (((c10 == true ? 1 : 0) & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == L) {
                        this.f12457t = Collections.unmodifiableList(this.f12457t);
                    }
                    if (((c10 == true ? 1 : 0) & 256) == 256) {
                        this.f12454q = Collections.unmodifiableList(this.f12454q);
                    }
                    if (((c10 == true ? 1 : 0) & 512) == 512) {
                        this.f12455r = Collections.unmodifiableList(this.f12455r);
                    }
                    if (((c10 == true ? 1 : 0) & 4096) == 4096) {
                        this.f12459v = Collections.unmodifiableList(this.f12459v);
                    }
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f12444g = cVar.d();
                        throw th2;
                    }
                    this.f12444g = cVar.d();
                    k();
                    throw th;
                }
            } else {
                if (((c10 == true ? 1 : 0) & 32) == 32) {
                    this.f12451n = Collections.unmodifiableList(this.f12451n);
                }
                if (((c10 == true ? 1 : 0) & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
                    this.f12457t = Collections.unmodifiableList(this.f12457t);
                }
                if (((c10 == true ? 1 : 0) & 256) == 256) {
                    this.f12454q = Collections.unmodifiableList(this.f12454q);
                }
                if (((c10 == true ? 1 : 0) & 512) == 512) {
                    this.f12455r = Collections.unmodifiableList(this.f12455r);
                }
                if (((c10 == true ? 1 : 0) & 4096) == 4096) {
                    this.f12459v = Collections.unmodifiableList(this.f12459v);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f12444g = cVar.d();
                    throw th3;
                }
                this.f12444g = cVar.d();
                k();
                return;
            }
        }
    }
}
