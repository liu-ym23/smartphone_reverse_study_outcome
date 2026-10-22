package z8;

import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f0 extends f9.l {
    public static final c9.a A = new c9.a(17);

    /* renamed from: z, reason: collision with root package name */
    public static final f0 f12132z;

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12133g;

    /* renamed from: h, reason: collision with root package name */
    public int f12134h;

    /* renamed from: i, reason: collision with root package name */
    public int f12135i;

    /* renamed from: j, reason: collision with root package name */
    public int f12136j;

    /* renamed from: k, reason: collision with root package name */
    public int f12137k;

    /* renamed from: l, reason: collision with root package name */
    public p0 f12138l;

    /* renamed from: m, reason: collision with root package name */
    public int f12139m;

    /* renamed from: n, reason: collision with root package name */
    public List f12140n;

    /* renamed from: o, reason: collision with root package name */
    public p0 f12141o;

    /* renamed from: p, reason: collision with root package name */
    public int f12142p;

    /* renamed from: q, reason: collision with root package name */
    public List f12143q;

    /* renamed from: r, reason: collision with root package name */
    public List f12144r;

    /* renamed from: s, reason: collision with root package name */
    public int f12145s;

    /* renamed from: t, reason: collision with root package name */
    public x0 f12146t;

    /* renamed from: u, reason: collision with root package name */
    public int f12147u;

    /* renamed from: v, reason: collision with root package name */
    public int f12148v;

    /* renamed from: w, reason: collision with root package name */
    public List f12149w;

    /* renamed from: x, reason: collision with root package name */
    public byte f12150x;

    /* renamed from: y, reason: collision with root package name */
    public int f12151y;

    static {
        f0 f0Var = new f0();
        f12132z = f0Var;
        f0Var.n();
    }

    public f0(e0 e0Var) {
        super(e0Var);
        this.f12145s = -1;
        this.f12150x = (byte) -1;
        this.f12151y = -1;
        this.f12133g = e0Var.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12151y;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12134h & 2) == 2 ? f9.f.b(1, this.f12136j) : 0;
        if ((this.f12134h & 4) == 4) {
            iB += f9.f.b(2, this.f12137k);
        }
        if ((this.f12134h & 8) == 8) {
            iB += f9.f.d(3, this.f12138l);
        }
        for (int i10 = 0; i10 < this.f12140n.size(); i10++) {
            iB += f9.f.d(4, (f9.a) this.f12140n.get(i10));
        }
        if ((this.f12134h & 32) == 32) {
            iB += f9.f.d(5, this.f12141o);
        }
        if ((this.f12134h & 128) == 128) {
            iB += f9.f.d(6, this.f12146t);
        }
        if ((this.f12134h & 256) == 256) {
            iB += f9.f.b(7, this.f12147u);
        }
        if ((this.f12134h & 512) == 512) {
            iB += f9.f.b(8, this.f12148v);
        }
        if ((this.f12134h & 16) == 16) {
            iB += f9.f.b(9, this.f12139m);
        }
        if ((this.f12134h & 64) == 64) {
            iB += f9.f.b(10, this.f12142p);
        }
        if ((this.f12134h & 1) == 1) {
            iB += f9.f.b(11, this.f12135i);
        }
        for (int i11 = 0; i11 < this.f12143q.size(); i11++) {
            iB += f9.f.d(12, (f9.a) this.f12143q.get(i11));
        }
        int iC = 0;
        for (int i12 = 0; i12 < this.f12144r.size(); i12++) {
            iC += f9.f.c(((Integer) this.f12144r.get(i12)).intValue());
        }
        int iC2 = iB + iC;
        if (!this.f12144r.isEmpty()) {
            iC2 = iC2 + 1 + f9.f.c(iC);
        }
        this.f12145s = iC;
        int iC3 = 0;
        for (int i13 = 0; i13 < this.f12149w.size(); i13++) {
            iC3 += f9.f.c(((Integer) this.f12149w.get(i13)).intValue());
        }
        int size = this.f12133g.size() + h() + (this.f12149w.size() * 2) + iC2 + iC3;
        this.f12151y = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return e0.f();
    }

    @Override // f9.a
    public final f9.j c() {
        e0 e0VarF = e0.f();
        e0VarF.g(this);
        return e0VarF;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12134h & 2) == 2) {
            fVar.m(1, this.f12136j);
        }
        if ((this.f12134h & 4) == 4) {
            fVar.m(2, this.f12137k);
        }
        if ((this.f12134h & 8) == 8) {
            fVar.o(3, this.f12138l);
        }
        for (int i2 = 0; i2 < this.f12140n.size(); i2++) {
            fVar.o(4, (f9.a) this.f12140n.get(i2));
        }
        if ((this.f12134h & 32) == 32) {
            fVar.o(5, this.f12141o);
        }
        if ((this.f12134h & 128) == 128) {
            fVar.o(6, this.f12146t);
        }
        if ((this.f12134h & 256) == 256) {
            fVar.m(7, this.f12147u);
        }
        if ((this.f12134h & 512) == 512) {
            fVar.m(8, this.f12148v);
        }
        if ((this.f12134h & 16) == 16) {
            fVar.m(9, this.f12139m);
        }
        if ((this.f12134h & 64) == 64) {
            fVar.m(10, this.f12142p);
        }
        if ((this.f12134h & 1) == 1) {
            fVar.m(11, this.f12135i);
        }
        for (int i10 = 0; i10 < this.f12143q.size(); i10++) {
            fVar.o(12, (f9.a) this.f12143q.get(i10));
        }
        if (this.f12144r.size() > 0) {
            fVar.v(106);
            fVar.v(this.f12145s);
        }
        for (int i11 = 0; i11 < this.f12144r.size(); i11++) {
            fVar.n(((Integer) this.f12144r.get(i11)).intValue());
        }
        for (int i12 = 0; i12 < this.f12149w.size(); i12++) {
            fVar.m(31, ((Integer) this.f12149w.get(i12)).intValue());
        }
        bVar.Q0(19000, fVar);
        fVar.r(this.f12133g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12132z;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12150x;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        int i2 = this.f12134h;
        if ((i2 & 4) != 4) {
            this.f12150x = (byte) 0;
            return false;
        }
        if ((i2 & 8) == 8 && !this.f12138l.isInitialized()) {
            this.f12150x = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < this.f12140n.size(); i10++) {
            if (!((u0) this.f12140n.get(i10)).isInitialized()) {
                this.f12150x = (byte) 0;
                return false;
            }
        }
        if ((this.f12134h & 32) == 32 && !this.f12141o.isInitialized()) {
            this.f12150x = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < this.f12143q.size(); i11++) {
            if (!((p0) this.f12143q.get(i11)).isInitialized()) {
                this.f12150x = (byte) 0;
                return false;
            }
        }
        if ((this.f12134h & 128) == 128 && !this.f12146t.isInitialized()) {
            this.f12150x = (byte) 0;
            return false;
        }
        if (g()) {
            this.f12150x = (byte) 1;
            return true;
        }
        this.f12150x = (byte) 0;
        return false;
    }

    public final void n() {
        this.f12135i = 518;
        this.f12136j = 2054;
        this.f12137k = 0;
        p0 p0Var = p0.f12298y;
        this.f12138l = p0Var;
        this.f12139m = 0;
        List list = Collections.EMPTY_LIST;
        this.f12140n = list;
        this.f12141o = p0Var;
        this.f12142p = 0;
        this.f12143q = list;
        this.f12144r = list;
        this.f12146t = x0.f12463q;
        this.f12147u = 0;
        this.f12148v = 0;
        this.f12149w = list;
    }

    public f0() {
        this.f12145s = -1;
        this.f12150x = (byte) -1;
        this.f12151y = -1;
        this.f12133g = f9.d.f3536f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public f0(f9.e eVar, f9.h hVar) {
        this.f12145s = -1;
        this.f12150x = (byte) -1;
        this.f12151y = -1;
        n();
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        char c10 = 0;
        while (true) {
            ?? L = 256;
            if (!z4) {
                try {
                    try {
                        try {
                            int iN = eVar.n();
                            o0 o0VarP = null;
                            w0 w0Var = null;
                            o0 o0VarP2 = null;
                            switch (iN) {
                                case 0:
                                    z4 = true;
                                case 8:
                                    this.f12134h |= 2;
                                    this.f12136j = eVar.k();
                                case 16:
                                    this.f12134h |= 4;
                                    this.f12137k = eVar.k();
                                case 26:
                                    if ((this.f12134h & 8) == 8) {
                                        p0 p0Var = this.f12138l;
                                        p0Var.getClass();
                                        o0VarP = p0.p(p0Var);
                                    }
                                    p0 p0Var2 = (p0) eVar.g(p0.f12299z, hVar);
                                    this.f12138l = p0Var2;
                                    if (o0VarP != null) {
                                        o0VarP.g(p0Var2);
                                        this.f12138l = o0VarP.e();
                                    }
                                    this.f12134h |= 8;
                                case 34:
                                    int i2 = (c10 == true ? 1 : 0) & 32;
                                    c10 = c10;
                                    if (i2 != 32) {
                                        this.f12140n = new ArrayList();
                                        c10 = (c10 == true ? 1 : 0) | ' ';
                                    }
                                    this.f12140n.add(eVar.g(u0.f12388s, hVar));
                                case 42:
                                    if ((this.f12134h & 32) == 32) {
                                        p0 p0Var3 = this.f12141o;
                                        p0Var3.getClass();
                                        o0VarP2 = p0.p(p0Var3);
                                    }
                                    p0 p0Var4 = (p0) eVar.g(p0.f12299z, hVar);
                                    this.f12141o = p0Var4;
                                    if (o0VarP2 != null) {
                                        o0VarP2.g(p0Var4);
                                        this.f12141o = o0VarP2.e();
                                    }
                                    this.f12134h |= 32;
                                case 50:
                                    if ((this.f12134h & 128) == 128) {
                                        x0 x0Var = this.f12146t;
                                        x0Var.getClass();
                                        w0Var = new w0();
                                        p0 p0Var5 = p0.f12298y;
                                        w0Var.f12439l = p0Var5;
                                        w0Var.f12441n = p0Var5;
                                        w0Var.f(x0Var);
                                    }
                                    x0 x0Var2 = (x0) eVar.g(x0.f12464r, hVar);
                                    this.f12146t = x0Var2;
                                    if (w0Var != null) {
                                        w0Var.f(x0Var2);
                                        this.f12146t = w0Var.e();
                                    }
                                    this.f12134h |= 128;
                                case 56:
                                    this.f12134h |= 256;
                                    this.f12147u = eVar.k();
                                case 64:
                                    this.f12134h |= 512;
                                    this.f12148v = eVar.k();
                                case 72:
                                    this.f12134h |= 16;
                                    this.f12139m = eVar.k();
                                case 80:
                                    this.f12134h |= 64;
                                    this.f12142p = eVar.k();
                                case 88:
                                    this.f12134h |= 1;
                                    this.f12135i = eVar.k();
                                case 98:
                                    int i10 = (c10 == true ? 1 : 0) & 256;
                                    c10 = c10;
                                    if (i10 != 256) {
                                        this.f12143q = new ArrayList();
                                        c10 = (c10 == true ? 1 : 0) | 256;
                                    }
                                    this.f12143q.add(eVar.g(p0.f12299z, hVar));
                                case 104:
                                    int i11 = (c10 == true ? 1 : 0) & 512;
                                    c10 = c10;
                                    if (i11 != 512) {
                                        this.f12144r = new ArrayList();
                                        c10 = (c10 == true ? 1 : 0) | 512;
                                    }
                                    this.f12144r.add(Integer.valueOf(eVar.k()));
                                case 106:
                                    int iD = eVar.d(eVar.k());
                                    int i12 = (c10 == true ? 1 : 0) & 512;
                                    c10 = c10;
                                    if (i12 != 512) {
                                        c10 = c10;
                                        if (eVar.b() > 0) {
                                            this.f12144r = new ArrayList();
                                            c10 = (c10 == true ? 1 : 0) | 512;
                                        }
                                    }
                                    while (eVar.b() > 0) {
                                        this.f12144r.add(Integer.valueOf(eVar.k()));
                                    }
                                    eVar.c(iD);
                                case 248:
                                    int i13 = (c10 == true ? 1 : 0) & NanoHTTPD.HTTPSession.BUFSIZE;
                                    c10 = c10;
                                    if (i13 != 8192) {
                                        this.f12149w = new ArrayList();
                                        c10 = (c10 == true ? 1 : 0) | 8192;
                                    }
                                    this.f12149w.add(Integer.valueOf(eVar.k()));
                                case 250:
                                    int iD2 = eVar.d(eVar.k());
                                    int i14 = (c10 == true ? 1 : 0) & NanoHTTPD.HTTPSession.BUFSIZE;
                                    c10 = c10;
                                    if (i14 != 8192) {
                                        c10 = c10;
                                        if (eVar.b() > 0) {
                                            this.f12149w = new ArrayList();
                                            c10 = (c10 == true ? 1 : 0) | 8192;
                                        }
                                    }
                                    while (eVar.b() > 0) {
                                        this.f12149w.add(Integer.valueOf(eVar.k()));
                                    }
                                    eVar.c(iD2);
                                default:
                                    L = l(eVar, fVarJ, hVar, iN);
                                    if (L == 0) {
                                        z4 = true;
                                    }
                            }
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
                        this.f12140n = Collections.unmodifiableList(this.f12140n);
                    }
                    if (((c10 == true ? 1 : 0) & 256) == L) {
                        this.f12143q = Collections.unmodifiableList(this.f12143q);
                    }
                    if (((c10 == true ? 1 : 0) & 512) == 512) {
                        this.f12144r = Collections.unmodifiableList(this.f12144r);
                    }
                    if (((c10 == true ? 1 : 0) & NanoHTTPD.HTTPSession.BUFSIZE) == 8192) {
                        this.f12149w = Collections.unmodifiableList(this.f12149w);
                    }
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f12133g = cVar.d();
                        throw th2;
                    }
                    this.f12133g = cVar.d();
                    k();
                    throw th;
                }
            } else {
                if (((c10 == true ? 1 : 0) & 32) == 32) {
                    this.f12140n = Collections.unmodifiableList(this.f12140n);
                }
                if (((c10 == true ? 1 : 0) & 256) == 256) {
                    this.f12143q = Collections.unmodifiableList(this.f12143q);
                }
                if (((c10 == true ? 1 : 0) & 512) == 512) {
                    this.f12144r = Collections.unmodifiableList(this.f12144r);
                }
                if (((c10 == true ? 1 : 0) & NanoHTTPD.HTTPSession.BUFSIZE) == 8192) {
                    this.f12149w = Collections.unmodifiableList(this.f12149w);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f12133g = cVar.d();
                    throw th3;
                }
                this.f12133g = cVar.d();
                k();
                return;
            }
        }
    }
}
