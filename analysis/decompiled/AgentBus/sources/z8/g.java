package z8;

import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends f9.k {
    public int A;
    public List B;
    public List C;
    public List D;
    public v0 E;
    public List F;
    public c1 G;

    /* renamed from: i, reason: collision with root package name */
    public int f12152i;

    /* renamed from: j, reason: collision with root package name */
    public int f12153j;

    /* renamed from: k, reason: collision with root package name */
    public int f12154k;

    /* renamed from: l, reason: collision with root package name */
    public int f12155l;

    /* renamed from: m, reason: collision with root package name */
    public List f12156m;

    /* renamed from: n, reason: collision with root package name */
    public List f12157n;

    /* renamed from: o, reason: collision with root package name */
    public List f12158o;

    /* renamed from: p, reason: collision with root package name */
    public List f12159p;

    /* renamed from: q, reason: collision with root package name */
    public List f12160q;

    /* renamed from: r, reason: collision with root package name */
    public List f12161r;

    /* renamed from: s, reason: collision with root package name */
    public List f12162s;

    /* renamed from: t, reason: collision with root package name */
    public List f12163t;

    /* renamed from: u, reason: collision with root package name */
    public List f12164u;

    /* renamed from: v, reason: collision with root package name */
    public List f12165v;

    /* renamed from: w, reason: collision with root package name */
    public List f12166w;

    /* renamed from: x, reason: collision with root package name */
    public List f12167x;

    /* renamed from: y, reason: collision with root package name */
    public int f12168y;

    /* renamed from: z, reason: collision with root package name */
    public p0 f12169z;

    public static g f() {
        g gVar = new g();
        gVar.f12153j = 6;
        List list = Collections.EMPTY_LIST;
        gVar.f12156m = list;
        gVar.f12157n = list;
        gVar.f12158o = list;
        gVar.f12159p = list;
        gVar.f12160q = list;
        gVar.f12161r = list;
        gVar.f12162s = list;
        gVar.f12163t = list;
        gVar.f12164u = list;
        gVar.f12165v = list;
        gVar.f12166w = list;
        gVar.f12167x = list;
        gVar.f12169z = p0.f12298y;
        gVar.B = list;
        gVar.C = list;
        gVar.D = list;
        gVar.E = v0.f12413l;
        gVar.F = list;
        gVar.G = c1.f12079j;
        return gVar;
    }

    @Override // f9.j
    public final f9.a a() {
        i iVarE = e();
        if (iVarE.isInitialized()) {
            return iVarE;
        }
        throw new a4.u(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // f9.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.j b(f9.e r3, f9.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            c9.a r1 = z8.i.P     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.i r1 = new z8.i     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.g(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.i r4 = (z8.i) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.g(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.g.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        g((i) oVar);
        return this;
    }

    public final Object clone() {
        g gVarF = f();
        gVarF.g(e());
        return gVarF;
    }

    public final i e() {
        i iVar = new i(this);
        int i2 = this.f12152i;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        iVar.f12188i = this.f12153j;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        iVar.f12189j = this.f12154k;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        iVar.f12190k = this.f12155l;
        if ((i2 & 8) == 8) {
            this.f12156m = Collections.unmodifiableList(this.f12156m);
            this.f12152i &= -9;
        }
        iVar.f12191l = this.f12156m;
        if ((this.f12152i & 16) == 16) {
            this.f12157n = Collections.unmodifiableList(this.f12157n);
            this.f12152i &= -17;
        }
        iVar.f12192m = this.f12157n;
        if ((this.f12152i & 32) == 32) {
            this.f12158o = Collections.unmodifiableList(this.f12158o);
            this.f12152i &= -33;
        }
        iVar.f12193n = this.f12158o;
        if ((this.f12152i & 64) == 64) {
            this.f12159p = Collections.unmodifiableList(this.f12159p);
            this.f12152i &= -65;
        }
        iVar.f12195p = this.f12159p;
        if ((this.f12152i & 128) == 128) {
            this.f12160q = Collections.unmodifiableList(this.f12160q);
            this.f12152i &= -129;
        }
        iVar.f12197r = this.f12160q;
        if ((this.f12152i & 256) == 256) {
            this.f12161r = Collections.unmodifiableList(this.f12161r);
            this.f12152i &= -257;
        }
        iVar.f12198s = this.f12161r;
        if ((this.f12152i & 512) == 512) {
            this.f12162s = Collections.unmodifiableList(this.f12162s);
            this.f12152i &= -513;
        }
        iVar.f12200u = this.f12162s;
        if ((this.f12152i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
            this.f12163t = Collections.unmodifiableList(this.f12163t);
            this.f12152i &= -1025;
        }
        iVar.f12201v = this.f12163t;
        if ((this.f12152i & 2048) == 2048) {
            this.f12164u = Collections.unmodifiableList(this.f12164u);
            this.f12152i &= -2049;
        }
        iVar.f12202w = this.f12164u;
        if ((this.f12152i & 4096) == 4096) {
            this.f12165v = Collections.unmodifiableList(this.f12165v);
            this.f12152i &= -4097;
        }
        iVar.f12203x = this.f12165v;
        if ((this.f12152i & NanoHTTPD.HTTPSession.BUFSIZE) == 8192) {
            this.f12166w = Collections.unmodifiableList(this.f12166w);
            this.f12152i &= -8193;
        }
        iVar.f12204y = this.f12166w;
        if ((this.f12152i & 16384) == 16384) {
            this.f12167x = Collections.unmodifiableList(this.f12167x);
            this.f12152i &= -16385;
        }
        iVar.f12205z = this.f12167x;
        if ((i2 & 32768) == 32768) {
            i10 |= 8;
        }
        iVar.B = this.f12168y;
        if ((i2 & 65536) == 65536) {
            i10 |= 16;
        }
        iVar.C = this.f12169z;
        if ((i2 & 131072) == 131072) {
            i10 |= 32;
        }
        iVar.D = this.A;
        if ((this.f12152i & 262144) == 262144) {
            this.B = Collections.unmodifiableList(this.B);
            this.f12152i &= -262145;
        }
        iVar.E = this.B;
        if ((this.f12152i & 524288) == 524288) {
            this.C = Collections.unmodifiableList(this.C);
            this.f12152i &= -524289;
        }
        iVar.G = this.C;
        if ((this.f12152i & 1048576) == 1048576) {
            this.D = Collections.unmodifiableList(this.D);
            this.f12152i &= -1048577;
        }
        iVar.H = this.D;
        if ((i2 & 2097152) == 2097152) {
            i10 |= 64;
        }
        iVar.J = this.E;
        if ((this.f12152i & 4194304) == 4194304) {
            this.F = Collections.unmodifiableList(this.F);
            this.f12152i &= -4194305;
        }
        iVar.K = this.F;
        if ((i2 & 8388608) == 8388608) {
            i10 |= 128;
        }
        iVar.L = this.G;
        iVar.f12187h = i10;
        return iVar;
    }

    public final void g(i iVar) {
        c1 c1Var;
        v0 v0Var;
        p0 p0Var;
        if (iVar == i.O) {
            return;
        }
        int i2 = iVar.f12187h;
        if ((i2 & 1) == 1) {
            int i10 = iVar.f12188i;
            this.f12152i = 1 | this.f12152i;
            this.f12153j = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = iVar.f12189j;
            this.f12152i = 2 | this.f12152i;
            this.f12154k = i11;
        }
        if ((i2 & 4) == 4) {
            int i12 = iVar.f12190k;
            this.f12152i = 4 | this.f12152i;
            this.f12155l = i12;
        }
        if (!iVar.f12191l.isEmpty()) {
            if (this.f12156m.isEmpty()) {
                this.f12156m = iVar.f12191l;
                this.f12152i &= -9;
            } else {
                if ((this.f12152i & 8) != 8) {
                    this.f12156m = new ArrayList(this.f12156m);
                    this.f12152i |= 8;
                }
                this.f12156m.addAll(iVar.f12191l);
            }
        }
        if (!iVar.f12192m.isEmpty()) {
            if (this.f12157n.isEmpty()) {
                this.f12157n = iVar.f12192m;
                this.f12152i &= -17;
            } else {
                if ((this.f12152i & 16) != 16) {
                    this.f12157n = new ArrayList(this.f12157n);
                    this.f12152i |= 16;
                }
                this.f12157n.addAll(iVar.f12192m);
            }
        }
        if (!iVar.f12193n.isEmpty()) {
            if (this.f12158o.isEmpty()) {
                this.f12158o = iVar.f12193n;
                this.f12152i &= -33;
            } else {
                if ((this.f12152i & 32) != 32) {
                    this.f12158o = new ArrayList(this.f12158o);
                    this.f12152i |= 32;
                }
                this.f12158o.addAll(iVar.f12193n);
            }
        }
        if (!iVar.f12195p.isEmpty()) {
            if (this.f12159p.isEmpty()) {
                this.f12159p = iVar.f12195p;
                this.f12152i &= -65;
            } else {
                if ((this.f12152i & 64) != 64) {
                    this.f12159p = new ArrayList(this.f12159p);
                    this.f12152i |= 64;
                }
                this.f12159p.addAll(iVar.f12195p);
            }
        }
        if (!iVar.f12197r.isEmpty()) {
            if (this.f12160q.isEmpty()) {
                this.f12160q = iVar.f12197r;
                this.f12152i &= -129;
            } else {
                if ((this.f12152i & 128) != 128) {
                    this.f12160q = new ArrayList(this.f12160q);
                    this.f12152i |= 128;
                }
                this.f12160q.addAll(iVar.f12197r);
            }
        }
        if (!iVar.f12198s.isEmpty()) {
            if (this.f12161r.isEmpty()) {
                this.f12161r = iVar.f12198s;
                this.f12152i &= -257;
            } else {
                if ((this.f12152i & 256) != 256) {
                    this.f12161r = new ArrayList(this.f12161r);
                    this.f12152i |= 256;
                }
                this.f12161r.addAll(iVar.f12198s);
            }
        }
        if (!iVar.f12200u.isEmpty()) {
            if (this.f12162s.isEmpty()) {
                this.f12162s = iVar.f12200u;
                this.f12152i &= -513;
            } else {
                if ((this.f12152i & 512) != 512) {
                    this.f12162s = new ArrayList(this.f12162s);
                    this.f12152i |= 512;
                }
                this.f12162s.addAll(iVar.f12200u);
            }
        }
        if (!iVar.f12201v.isEmpty()) {
            if (this.f12163t.isEmpty()) {
                this.f12163t = iVar.f12201v;
                this.f12152i &= -1025;
            } else {
                if ((this.f12152i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 1024) {
                    this.f12163t = new ArrayList(this.f12163t);
                    this.f12152i |= NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
                }
                this.f12163t.addAll(iVar.f12201v);
            }
        }
        if (!iVar.f12202w.isEmpty()) {
            if (this.f12164u.isEmpty()) {
                this.f12164u = iVar.f12202w;
                this.f12152i &= -2049;
            } else {
                if ((this.f12152i & 2048) != 2048) {
                    this.f12164u = new ArrayList(this.f12164u);
                    this.f12152i |= 2048;
                }
                this.f12164u.addAll(iVar.f12202w);
            }
        }
        if (!iVar.f12203x.isEmpty()) {
            if (this.f12165v.isEmpty()) {
                this.f12165v = iVar.f12203x;
                this.f12152i &= -4097;
            } else {
                if ((this.f12152i & 4096) != 4096) {
                    this.f12165v = new ArrayList(this.f12165v);
                    this.f12152i |= 4096;
                }
                this.f12165v.addAll(iVar.f12203x);
            }
        }
        if (!iVar.f12204y.isEmpty()) {
            if (this.f12166w.isEmpty()) {
                this.f12166w = iVar.f12204y;
                this.f12152i &= -8193;
            } else {
                if ((this.f12152i & NanoHTTPD.HTTPSession.BUFSIZE) != 8192) {
                    this.f12166w = new ArrayList(this.f12166w);
                    this.f12152i |= NanoHTTPD.HTTPSession.BUFSIZE;
                }
                this.f12166w.addAll(iVar.f12204y);
            }
        }
        if (!iVar.f12205z.isEmpty()) {
            if (this.f12167x.isEmpty()) {
                this.f12167x = iVar.f12205z;
                this.f12152i &= -16385;
            } else {
                if ((this.f12152i & 16384) != 16384) {
                    this.f12167x = new ArrayList(this.f12167x);
                    this.f12152i |= 16384;
                }
                this.f12167x.addAll(iVar.f12205z);
            }
        }
        int i13 = iVar.f12187h;
        if ((i13 & 8) == 8) {
            int i14 = iVar.B;
            this.f12152i |= 32768;
            this.f12168y = i14;
        }
        if ((i13 & 16) == 16) {
            p0 p0Var2 = iVar.C;
            if ((this.f12152i & 65536) != 65536 || (p0Var = this.f12169z) == p0.f12298y) {
                this.f12169z = p0Var2;
            } else {
                o0 o0VarP = p0.p(p0Var);
                o0VarP.g(p0Var2);
                this.f12169z = o0VarP.e();
            }
            this.f12152i |= 65536;
        }
        if ((iVar.f12187h & 32) == 32) {
            int i15 = iVar.D;
            this.f12152i |= 131072;
            this.A = i15;
        }
        if (!iVar.E.isEmpty()) {
            if (this.B.isEmpty()) {
                this.B = iVar.E;
                this.f12152i &= -262145;
            } else {
                if ((this.f12152i & 262144) != 262144) {
                    this.B = new ArrayList(this.B);
                    this.f12152i |= 262144;
                }
                this.B.addAll(iVar.E);
            }
        }
        if (!iVar.G.isEmpty()) {
            if (this.C.isEmpty()) {
                this.C = iVar.G;
                this.f12152i &= -524289;
            } else {
                if ((this.f12152i & 524288) != 524288) {
                    this.C = new ArrayList(this.C);
                    this.f12152i |= 524288;
                }
                this.C.addAll(iVar.G);
            }
        }
        if (!iVar.H.isEmpty()) {
            if (this.D.isEmpty()) {
                this.D = iVar.H;
                this.f12152i &= -1048577;
            } else {
                if ((this.f12152i & 1048576) != 1048576) {
                    this.D = new ArrayList(this.D);
                    this.f12152i |= 1048576;
                }
                this.D.addAll(iVar.H);
            }
        }
        if ((iVar.f12187h & 64) == 64) {
            v0 v0Var2 = iVar.J;
            if ((this.f12152i & 2097152) != 2097152 || (v0Var = this.E) == v0.f12413l) {
                this.E = v0Var2;
            } else {
                e eVarG = v0.g(v0Var);
                eVarG.j(v0Var2);
                this.E = eVarG.f();
            }
            this.f12152i |= 2097152;
        }
        if (!iVar.K.isEmpty()) {
            if (this.F.isEmpty()) {
                this.F = iVar.K;
                this.f12152i &= -4194305;
            } else {
                if ((this.f12152i & 4194304) != 4194304) {
                    this.F = new ArrayList(this.F);
                    this.f12152i |= 4194304;
                }
                this.F.addAll(iVar.K);
            }
        }
        if ((iVar.f12187h & 128) == 128) {
            c1 c1Var2 = iVar.L;
            if ((this.f12152i & 8388608) != 8388608 || (c1Var = this.G) == c1.f12079j) {
                this.G = c1Var2;
            } else {
                l lVar = new l(2);
                lVar.f12242i = Collections.EMPTY_LIST;
                lVar.k(c1Var);
                lVar.k(c1Var2);
                this.G = lVar.g();
            }
            this.f12152i |= 8388608;
        }
        d(iVar);
        this.f3565f = this.f3565f.f(iVar.f12186g);
    }
}
