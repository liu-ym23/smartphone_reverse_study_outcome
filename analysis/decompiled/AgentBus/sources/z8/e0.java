package z8;

import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class e0 extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12109i;

    /* renamed from: j, reason: collision with root package name */
    public int f12110j;

    /* renamed from: k, reason: collision with root package name */
    public int f12111k;

    /* renamed from: l, reason: collision with root package name */
    public int f12112l;

    /* renamed from: m, reason: collision with root package name */
    public p0 f12113m;

    /* renamed from: n, reason: collision with root package name */
    public int f12114n;

    /* renamed from: o, reason: collision with root package name */
    public List f12115o;

    /* renamed from: p, reason: collision with root package name */
    public p0 f12116p;

    /* renamed from: q, reason: collision with root package name */
    public int f12117q;

    /* renamed from: r, reason: collision with root package name */
    public List f12118r;

    /* renamed from: s, reason: collision with root package name */
    public List f12119s;

    /* renamed from: t, reason: collision with root package name */
    public x0 f12120t;

    /* renamed from: u, reason: collision with root package name */
    public int f12121u;

    /* renamed from: v, reason: collision with root package name */
    public int f12122v;

    /* renamed from: w, reason: collision with root package name */
    public List f12123w;

    public static e0 f() {
        e0 e0Var = new e0();
        e0Var.f12110j = 518;
        e0Var.f12111k = 2054;
        p0 p0Var = p0.f12298y;
        e0Var.f12113m = p0Var;
        List list = Collections.EMPTY_LIST;
        e0Var.f12115o = list;
        e0Var.f12116p = p0Var;
        e0Var.f12118r = list;
        e0Var.f12119s = list;
        e0Var.f12120t = x0.f12463q;
        e0Var.f12123w = list;
        return e0Var;
    }

    @Override // f9.j
    public final f9.a a() {
        f0 f0VarE = e();
        if (f0VarE.isInitialized()) {
            return f0VarE;
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
            c9.a r1 = z8.f0.A     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.f0 r1 = new z8.f0     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.g(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.f0 r4 = (z8.f0) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: z8.e0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        g((f0) oVar);
        return this;
    }

    public final Object clone() {
        e0 e0VarF = f();
        e0VarF.g(e());
        return e0VarF;
    }

    public final f0 e() {
        f0 f0Var = new f0(this);
        int i2 = this.f12109i;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        f0Var.f12135i = this.f12110j;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        f0Var.f12136j = this.f12111k;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        f0Var.f12137k = this.f12112l;
        if ((i2 & 8) == 8) {
            i10 |= 8;
        }
        f0Var.f12138l = this.f12113m;
        if ((i2 & 16) == 16) {
            i10 |= 16;
        }
        f0Var.f12139m = this.f12114n;
        if ((i2 & 32) == 32) {
            this.f12115o = Collections.unmodifiableList(this.f12115o);
            this.f12109i &= -33;
        }
        f0Var.f12140n = this.f12115o;
        if ((i2 & 64) == 64) {
            i10 |= 32;
        }
        f0Var.f12141o = this.f12116p;
        if ((i2 & 128) == 128) {
            i10 |= 64;
        }
        f0Var.f12142p = this.f12117q;
        if ((this.f12109i & 256) == 256) {
            this.f12118r = Collections.unmodifiableList(this.f12118r);
            this.f12109i &= -257;
        }
        f0Var.f12143q = this.f12118r;
        if ((this.f12109i & 512) == 512) {
            this.f12119s = Collections.unmodifiableList(this.f12119s);
            this.f12109i &= -513;
        }
        f0Var.f12144r = this.f12119s;
        if ((i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
            i10 |= 128;
        }
        f0Var.f12146t = this.f12120t;
        if ((i2 & 2048) == 2048) {
            i10 |= 256;
        }
        f0Var.f12147u = this.f12121u;
        if ((i2 & 4096) == 4096) {
            i10 |= 512;
        }
        f0Var.f12148v = this.f12122v;
        if ((this.f12109i & NanoHTTPD.HTTPSession.BUFSIZE) == 8192) {
            this.f12123w = Collections.unmodifiableList(this.f12123w);
            this.f12109i &= -8193;
        }
        f0Var.f12149w = this.f12123w;
        f0Var.f12134h = i10;
        return f0Var;
    }

    public final void g(f0 f0Var) {
        x0 x0Var;
        p0 p0Var;
        p0 p0Var2;
        if (f0Var == f0.f12132z) {
            return;
        }
        int i2 = f0Var.f12134h;
        if ((i2 & 1) == 1) {
            int i10 = f0Var.f12135i;
            this.f12109i = 1 | this.f12109i;
            this.f12110j = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = f0Var.f12136j;
            this.f12109i = 2 | this.f12109i;
            this.f12111k = i11;
        }
        if ((i2 & 4) == 4) {
            int i12 = f0Var.f12137k;
            this.f12109i = 4 | this.f12109i;
            this.f12112l = i12;
        }
        if ((i2 & 8) == 8) {
            p0 p0Var3 = f0Var.f12138l;
            if ((this.f12109i & 8) != 8 || (p0Var2 = this.f12113m) == p0.f12298y) {
                this.f12113m = p0Var3;
            } else {
                o0 o0VarP = p0.p(p0Var2);
                o0VarP.g(p0Var3);
                this.f12113m = o0VarP.e();
            }
            this.f12109i |= 8;
        }
        if ((f0Var.f12134h & 16) == 16) {
            int i13 = f0Var.f12139m;
            this.f12109i = 16 | this.f12109i;
            this.f12114n = i13;
        }
        if (!f0Var.f12140n.isEmpty()) {
            if (this.f12115o.isEmpty()) {
                this.f12115o = f0Var.f12140n;
                this.f12109i &= -33;
            } else {
                if ((this.f12109i & 32) != 32) {
                    this.f12115o = new ArrayList(this.f12115o);
                    this.f12109i |= 32;
                }
                this.f12115o.addAll(f0Var.f12140n);
            }
        }
        if ((f0Var.f12134h & 32) == 32) {
            p0 p0Var4 = f0Var.f12141o;
            if ((this.f12109i & 64) != 64 || (p0Var = this.f12116p) == p0.f12298y) {
                this.f12116p = p0Var4;
            } else {
                o0 o0VarP2 = p0.p(p0Var);
                o0VarP2.g(p0Var4);
                this.f12116p = o0VarP2.e();
            }
            this.f12109i |= 64;
        }
        if ((f0Var.f12134h & 64) == 64) {
            int i14 = f0Var.f12142p;
            this.f12109i |= 128;
            this.f12117q = i14;
        }
        if (!f0Var.f12143q.isEmpty()) {
            if (this.f12118r.isEmpty()) {
                this.f12118r = f0Var.f12143q;
                this.f12109i &= -257;
            } else {
                if ((this.f12109i & 256) != 256) {
                    this.f12118r = new ArrayList(this.f12118r);
                    this.f12109i |= 256;
                }
                this.f12118r.addAll(f0Var.f12143q);
            }
        }
        if (!f0Var.f12144r.isEmpty()) {
            if (this.f12119s.isEmpty()) {
                this.f12119s = f0Var.f12144r;
                this.f12109i &= -513;
            } else {
                if ((this.f12109i & 512) != 512) {
                    this.f12119s = new ArrayList(this.f12119s);
                    this.f12109i |= 512;
                }
                this.f12119s.addAll(f0Var.f12144r);
            }
        }
        if ((f0Var.f12134h & 128) == 128) {
            x0 x0Var2 = f0Var.f12146t;
            if ((this.f12109i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 1024 || (x0Var = this.f12120t) == x0.f12463q) {
                this.f12120t = x0Var2;
            } else {
                w0 w0Var = new w0();
                p0 p0Var5 = p0.f12298y;
                w0Var.f12439l = p0Var5;
                w0Var.f12441n = p0Var5;
                w0Var.f(x0Var);
                w0Var.f(x0Var2);
                this.f12120t = w0Var.e();
            }
            this.f12109i |= NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
        }
        int i15 = f0Var.f12134h;
        if ((i15 & 256) == 256) {
            int i16 = f0Var.f12147u;
            this.f12109i |= 2048;
            this.f12121u = i16;
        }
        if ((i15 & 512) == 512) {
            int i17 = f0Var.f12148v;
            this.f12109i |= 4096;
            this.f12122v = i17;
        }
        if (!f0Var.f12149w.isEmpty()) {
            if (this.f12123w.isEmpty()) {
                this.f12123w = f0Var.f12149w;
                this.f12109i &= -8193;
            } else {
                if ((this.f12109i & NanoHTTPD.HTTPSession.BUFSIZE) != 8192) {
                    this.f12123w = new ArrayList(this.f12123w);
                    this.f12109i |= NanoHTTPD.HTTPSession.BUFSIZE;
                }
                this.f12123w.addAll(f0Var.f12149w);
            }
        }
        d(f0Var);
        this.f3565f = this.f3565f.f(f0Var.f12133g);
    }
}
