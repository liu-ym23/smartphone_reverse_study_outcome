package z8;

import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class w extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12421i;

    /* renamed from: j, reason: collision with root package name */
    public int f12422j;

    /* renamed from: k, reason: collision with root package name */
    public int f12423k;

    /* renamed from: l, reason: collision with root package name */
    public int f12424l;

    /* renamed from: m, reason: collision with root package name */
    public p0 f12425m;

    /* renamed from: n, reason: collision with root package name */
    public int f12426n;

    /* renamed from: o, reason: collision with root package name */
    public List f12427o;

    /* renamed from: p, reason: collision with root package name */
    public p0 f12428p;

    /* renamed from: q, reason: collision with root package name */
    public int f12429q;

    /* renamed from: r, reason: collision with root package name */
    public List f12430r;

    /* renamed from: s, reason: collision with root package name */
    public List f12431s;

    /* renamed from: t, reason: collision with root package name */
    public List f12432t;

    /* renamed from: u, reason: collision with root package name */
    public v0 f12433u;

    /* renamed from: v, reason: collision with root package name */
    public List f12434v;

    /* renamed from: w, reason: collision with root package name */
    public m f12435w;

    public static w f() {
        w wVar = new w();
        wVar.f12422j = 6;
        wVar.f12423k = 6;
        p0 p0Var = p0.f12298y;
        wVar.f12425m = p0Var;
        List list = Collections.EMPTY_LIST;
        wVar.f12427o = list;
        wVar.f12428p = p0Var;
        wVar.f12430r = list;
        wVar.f12431s = list;
        wVar.f12432t = list;
        wVar.f12433u = v0.f12413l;
        wVar.f12434v = list;
        wVar.f12435w = m.f12247j;
        return wVar;
    }

    @Override // f9.j
    public final f9.a a() {
        x xVarE = e();
        if (xVarE.isInitialized()) {
            return xVarE;
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
            c9.a r1 = z8.x.A     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.x r1 = new z8.x     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.g(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.x r4 = (z8.x) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: z8.w.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        g((x) oVar);
        return this;
    }

    public final Object clone() {
        w wVarF = f();
        wVarF.g(e());
        return wVarF;
    }

    public final x e() {
        x xVar = new x(this);
        int i2 = this.f12421i;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        xVar.f12446i = this.f12422j;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        xVar.f12447j = this.f12423k;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        xVar.f12448k = this.f12424l;
        if ((i2 & 8) == 8) {
            i10 |= 8;
        }
        xVar.f12449l = this.f12425m;
        if ((i2 & 16) == 16) {
            i10 |= 16;
        }
        xVar.f12450m = this.f12426n;
        if ((i2 & 32) == 32) {
            this.f12427o = Collections.unmodifiableList(this.f12427o);
            this.f12421i &= -33;
        }
        xVar.f12451n = this.f12427o;
        if ((i2 & 64) == 64) {
            i10 |= 32;
        }
        xVar.f12452o = this.f12428p;
        if ((i2 & 128) == 128) {
            i10 |= 64;
        }
        xVar.f12453p = this.f12429q;
        if ((this.f12421i & 256) == 256) {
            this.f12430r = Collections.unmodifiableList(this.f12430r);
            this.f12421i &= -257;
        }
        xVar.f12454q = this.f12430r;
        if ((this.f12421i & 512) == 512) {
            this.f12431s = Collections.unmodifiableList(this.f12431s);
            this.f12421i &= -513;
        }
        xVar.f12455r = this.f12431s;
        if ((this.f12421i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
            this.f12432t = Collections.unmodifiableList(this.f12432t);
            this.f12421i &= -1025;
        }
        xVar.f12457t = this.f12432t;
        if ((i2 & 2048) == 2048) {
            i10 |= 128;
        }
        xVar.f12458u = this.f12433u;
        if ((this.f12421i & 4096) == 4096) {
            this.f12434v = Collections.unmodifiableList(this.f12434v);
            this.f12421i &= -4097;
        }
        xVar.f12459v = this.f12434v;
        if ((i2 & NanoHTTPD.HTTPSession.BUFSIZE) == 8192) {
            i10 |= 256;
        }
        xVar.f12460w = this.f12435w;
        xVar.f12445h = i10;
        return xVar;
    }

    public final void g(x xVar) {
        m mVar;
        v0 v0Var;
        p0 p0Var;
        p0 p0Var2;
        if (xVar == x.f12443z) {
            return;
        }
        int i2 = xVar.f12445h;
        if ((i2 & 1) == 1) {
            int i10 = xVar.f12446i;
            this.f12421i = 1 | this.f12421i;
            this.f12422j = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = xVar.f12447j;
            this.f12421i = 2 | this.f12421i;
            this.f12423k = i11;
        }
        if ((i2 & 4) == 4) {
            int i12 = xVar.f12448k;
            this.f12421i = 4 | this.f12421i;
            this.f12424l = i12;
        }
        if ((i2 & 8) == 8) {
            p0 p0Var3 = xVar.f12449l;
            if ((this.f12421i & 8) != 8 || (p0Var2 = this.f12425m) == p0.f12298y) {
                this.f12425m = p0Var3;
            } else {
                o0 o0VarP = p0.p(p0Var2);
                o0VarP.g(p0Var3);
                this.f12425m = o0VarP.e();
            }
            this.f12421i |= 8;
        }
        if ((xVar.f12445h & 16) == 16) {
            int i13 = xVar.f12450m;
            this.f12421i = 16 | this.f12421i;
            this.f12426n = i13;
        }
        if (!xVar.f12451n.isEmpty()) {
            if (this.f12427o.isEmpty()) {
                this.f12427o = xVar.f12451n;
                this.f12421i &= -33;
            } else {
                if ((this.f12421i & 32) != 32) {
                    this.f12427o = new ArrayList(this.f12427o);
                    this.f12421i |= 32;
                }
                this.f12427o.addAll(xVar.f12451n);
            }
        }
        if ((xVar.f12445h & 32) == 32) {
            p0 p0Var4 = xVar.f12452o;
            if ((this.f12421i & 64) != 64 || (p0Var = this.f12428p) == p0.f12298y) {
                this.f12428p = p0Var4;
            } else {
                o0 o0VarP2 = p0.p(p0Var);
                o0VarP2.g(p0Var4);
                this.f12428p = o0VarP2.e();
            }
            this.f12421i |= 64;
        }
        if ((xVar.f12445h & 64) == 64) {
            int i14 = xVar.f12453p;
            this.f12421i |= 128;
            this.f12429q = i14;
        }
        if (!xVar.f12454q.isEmpty()) {
            if (this.f12430r.isEmpty()) {
                this.f12430r = xVar.f12454q;
                this.f12421i &= -257;
            } else {
                if ((this.f12421i & 256) != 256) {
                    this.f12430r = new ArrayList(this.f12430r);
                    this.f12421i |= 256;
                }
                this.f12430r.addAll(xVar.f12454q);
            }
        }
        if (!xVar.f12455r.isEmpty()) {
            if (this.f12431s.isEmpty()) {
                this.f12431s = xVar.f12455r;
                this.f12421i &= -513;
            } else {
                if ((this.f12421i & 512) != 512) {
                    this.f12431s = new ArrayList(this.f12431s);
                    this.f12421i |= 512;
                }
                this.f12431s.addAll(xVar.f12455r);
            }
        }
        if (!xVar.f12457t.isEmpty()) {
            if (this.f12432t.isEmpty()) {
                this.f12432t = xVar.f12457t;
                this.f12421i &= -1025;
            } else {
                if ((this.f12421i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 1024) {
                    this.f12432t = new ArrayList(this.f12432t);
                    this.f12421i |= NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
                }
                this.f12432t.addAll(xVar.f12457t);
            }
        }
        if ((xVar.f12445h & 128) == 128) {
            v0 v0Var2 = xVar.f12458u;
            if ((this.f12421i & 2048) != 2048 || (v0Var = this.f12433u) == v0.f12413l) {
                this.f12433u = v0Var2;
            } else {
                e eVarG = v0.g(v0Var);
                eVarG.j(v0Var2);
                this.f12433u = eVarG.f();
            }
            this.f12421i |= 2048;
        }
        if (!xVar.f12459v.isEmpty()) {
            if (this.f12434v.isEmpty()) {
                this.f12434v = xVar.f12459v;
                this.f12421i &= -4097;
            } else {
                if ((this.f12421i & 4096) != 4096) {
                    this.f12434v = new ArrayList(this.f12434v);
                    this.f12421i |= 4096;
                }
                this.f12434v.addAll(xVar.f12459v);
            }
        }
        if ((xVar.f12445h & 256) == 256) {
            m mVar2 = xVar.f12460w;
            if ((this.f12421i & NanoHTTPD.HTTPSession.BUFSIZE) != 8192 || (mVar = this.f12435w) == m.f12247j) {
                this.f12435w = mVar2;
            } else {
                l lVar = new l(0);
                lVar.f12242i = Collections.EMPTY_LIST;
                lVar.h(mVar);
                lVar.h(mVar2);
                this.f12435w = lVar.d();
            }
            this.f12421i |= NanoHTTPD.HTTPSession.BUFSIZE;
        }
        d(xVar);
        this.f3565f = this.f3565f.f(xVar.f12444g);
    }
}
