package z8;

import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class o0 extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12278i;

    /* renamed from: j, reason: collision with root package name */
    public List f12279j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12280k;

    /* renamed from: l, reason: collision with root package name */
    public int f12281l;

    /* renamed from: m, reason: collision with root package name */
    public p0 f12282m;

    /* renamed from: n, reason: collision with root package name */
    public int f12283n;

    /* renamed from: o, reason: collision with root package name */
    public int f12284o;

    /* renamed from: p, reason: collision with root package name */
    public int f12285p;

    /* renamed from: q, reason: collision with root package name */
    public int f12286q;

    /* renamed from: r, reason: collision with root package name */
    public int f12287r;

    /* renamed from: s, reason: collision with root package name */
    public p0 f12288s;

    /* renamed from: t, reason: collision with root package name */
    public int f12289t;

    /* renamed from: u, reason: collision with root package name */
    public p0 f12290u;

    /* renamed from: v, reason: collision with root package name */
    public int f12291v;

    /* renamed from: w, reason: collision with root package name */
    public int f12292w;

    public static o0 f() {
        o0 o0Var = new o0();
        o0Var.f12279j = Collections.EMPTY_LIST;
        p0 p0Var = p0.f12298y;
        o0Var.f12282m = p0Var;
        o0Var.f12288s = p0Var;
        o0Var.f12290u = p0Var;
        return o0Var;
    }

    @Override // f9.j
    public final f9.a a() {
        p0 p0VarE = e();
        if (p0VarE.isInitialized()) {
            return p0VarE;
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
            c9.a r1 = z8.p0.f12299z     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.p0 r1 = new z8.p0     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.g(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.p0 r4 = (z8.p0) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: z8.o0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        g((p0) oVar);
        return this;
    }

    public final Object clone() {
        o0 o0VarF = f();
        o0VarF.g(e());
        return o0VarF;
    }

    public final p0 e() {
        p0 p0Var = new p0(this);
        int i2 = this.f12278i;
        if ((i2 & 1) == 1) {
            this.f12279j = Collections.unmodifiableList(this.f12279j);
            this.f12278i &= -2;
        }
        p0Var.f12302i = this.f12279j;
        int i10 = (i2 & 2) != 2 ? 0 : 1;
        p0Var.f12303j = this.f12280k;
        if ((i2 & 4) == 4) {
            i10 |= 2;
        }
        p0Var.f12304k = this.f12281l;
        if ((i2 & 8) == 8) {
            i10 |= 4;
        }
        p0Var.f12305l = this.f12282m;
        if ((i2 & 16) == 16) {
            i10 |= 8;
        }
        p0Var.f12306m = this.f12283n;
        if ((i2 & 32) == 32) {
            i10 |= 16;
        }
        p0Var.f12307n = this.f12284o;
        if ((i2 & 64) == 64) {
            i10 |= 32;
        }
        p0Var.f12308o = this.f12285p;
        if ((i2 & 128) == 128) {
            i10 |= 64;
        }
        p0Var.f12309p = this.f12286q;
        if ((i2 & 256) == 256) {
            i10 |= 128;
        }
        p0Var.f12310q = this.f12287r;
        if ((i2 & 512) == 512) {
            i10 |= 256;
        }
        p0Var.f12311r = this.f12288s;
        if ((i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
            i10 |= 512;
        }
        p0Var.f12312s = this.f12289t;
        if ((i2 & 2048) == 2048) {
            i10 |= NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
        }
        p0Var.f12313t = this.f12290u;
        if ((i2 & 4096) == 4096) {
            i10 |= 2048;
        }
        p0Var.f12314u = this.f12291v;
        if ((i2 & NanoHTTPD.HTTPSession.BUFSIZE) == 8192) {
            i10 |= 4096;
        }
        p0Var.f12315v = this.f12292w;
        p0Var.f12301h = i10;
        return p0Var;
    }

    public final o0 g(p0 p0Var) {
        p0 p0Var2;
        p0 p0Var3;
        p0 p0Var4;
        p0 p0Var5 = p0.f12298y;
        if (p0Var == p0Var5) {
            return this;
        }
        if (!p0Var.f12302i.isEmpty()) {
            if (this.f12279j.isEmpty()) {
                this.f12279j = p0Var.f12302i;
                this.f12278i &= -2;
            } else {
                if ((this.f12278i & 1) != 1) {
                    this.f12279j = new ArrayList(this.f12279j);
                    this.f12278i |= 1;
                }
                this.f12279j.addAll(p0Var.f12302i);
            }
        }
        int i2 = p0Var.f12301h;
        if ((i2 & 1) == 1) {
            boolean z4 = p0Var.f12303j;
            this.f12278i |= 2;
            this.f12280k = z4;
        }
        if ((i2 & 2) == 2) {
            int i10 = p0Var.f12304k;
            this.f12278i |= 4;
            this.f12281l = i10;
        }
        if ((i2 & 4) == 4) {
            p0 p0Var6 = p0Var.f12305l;
            if ((this.f12278i & 8) != 8 || (p0Var4 = this.f12282m) == p0Var5) {
                this.f12282m = p0Var6;
            } else {
                o0 o0VarP = p0.p(p0Var4);
                o0VarP.g(p0Var6);
                this.f12282m = o0VarP.e();
            }
            this.f12278i |= 8;
        }
        if ((p0Var.f12301h & 8) == 8) {
            int i11 = p0Var.f12306m;
            this.f12278i |= 16;
            this.f12283n = i11;
        }
        if (p0Var.n()) {
            int i12 = p0Var.f12307n;
            this.f12278i |= 32;
            this.f12284o = i12;
        }
        int i13 = p0Var.f12301h;
        if ((i13 & 32) == 32) {
            int i14 = p0Var.f12308o;
            this.f12278i |= 64;
            this.f12285p = i14;
        }
        if ((i13 & 64) == 64) {
            int i15 = p0Var.f12309p;
            this.f12278i |= 128;
            this.f12286q = i15;
        }
        if ((i13 & 128) == 128) {
            int i16 = p0Var.f12310q;
            this.f12278i |= 256;
            this.f12287r = i16;
        }
        if ((i13 & 256) == 256) {
            p0 p0Var7 = p0Var.f12311r;
            if ((this.f12278i & 512) != 512 || (p0Var3 = this.f12288s) == p0Var5) {
                this.f12288s = p0Var7;
            } else {
                o0 o0VarP2 = p0.p(p0Var3);
                o0VarP2.g(p0Var7);
                this.f12288s = o0VarP2.e();
            }
            this.f12278i |= 512;
        }
        int i17 = p0Var.f12301h;
        if ((i17 & 512) == 512) {
            int i18 = p0Var.f12312s;
            this.f12278i |= NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
            this.f12289t = i18;
        }
        if ((i17 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
            p0 p0Var8 = p0Var.f12313t;
            if ((this.f12278i & 2048) != 2048 || (p0Var2 = this.f12290u) == p0Var5) {
                this.f12290u = p0Var8;
            } else {
                o0 o0VarP3 = p0.p(p0Var2);
                o0VarP3.g(p0Var8);
                this.f12290u = o0VarP3.e();
            }
            this.f12278i |= 2048;
        }
        int i19 = p0Var.f12301h;
        if ((i19 & 2048) == 2048) {
            int i20 = p0Var.f12314u;
            this.f12278i |= 4096;
            this.f12291v = i20;
        }
        if ((i19 & 4096) == 4096) {
            int i21 = p0Var.f12315v;
            this.f12278i |= NanoHTTPD.HTTPSession.BUFSIZE;
            this.f12292w = i21;
        }
        d(p0Var);
        this.f3565f = this.f3565f.f(p0Var.f12300g);
        return this;
    }
}
