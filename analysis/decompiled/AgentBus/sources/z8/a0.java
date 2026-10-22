package z8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class a0 extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12008i;

    /* renamed from: j, reason: collision with root package name */
    public List f12009j;

    /* renamed from: k, reason: collision with root package name */
    public List f12010k;

    /* renamed from: l, reason: collision with root package name */
    public List f12011l;

    /* renamed from: m, reason: collision with root package name */
    public v0 f12012m;

    /* renamed from: n, reason: collision with root package name */
    public c1 f12013n;

    public static a0 f() {
        a0 a0Var = new a0();
        List list = Collections.EMPTY_LIST;
        a0Var.f12009j = list;
        a0Var.f12010k = list;
        a0Var.f12011l = list;
        a0Var.f12012m = v0.f12413l;
        a0Var.f12013n = c1.f12079j;
        return a0Var;
    }

    @Override // f9.j
    public final f9.a a() {
        b0 b0VarE = e();
        if (b0VarE.isInitialized()) {
            return b0VarE;
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
            c9.a r1 = z8.b0.f12035q     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.b0 r1 = new z8.b0     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.g(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.b0 r4 = (z8.b0) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: z8.a0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        g((b0) oVar);
        return this;
    }

    public final Object clone() {
        a0 a0VarF = f();
        a0VarF.g(e());
        return a0VarF;
    }

    public final b0 e() {
        b0 b0Var = new b0(this);
        int i2 = this.f12008i;
        if ((i2 & 1) == 1) {
            this.f12009j = Collections.unmodifiableList(this.f12009j);
            this.f12008i &= -2;
        }
        b0Var.f12038i = this.f12009j;
        if ((this.f12008i & 2) == 2) {
            this.f12010k = Collections.unmodifiableList(this.f12010k);
            this.f12008i &= -3;
        }
        b0Var.f12039j = this.f12010k;
        if ((this.f12008i & 4) == 4) {
            this.f12011l = Collections.unmodifiableList(this.f12011l);
            this.f12008i &= -5;
        }
        b0Var.f12040k = this.f12011l;
        int i10 = (i2 & 8) != 8 ? 0 : 1;
        b0Var.f12041l = this.f12012m;
        if ((i2 & 16) == 16) {
            i10 |= 2;
        }
        b0Var.f12042m = this.f12013n;
        b0Var.f12037h = i10;
        return b0Var;
    }

    public final void g(b0 b0Var) {
        c1 c1Var;
        v0 v0Var;
        if (b0Var == b0.f12034p) {
            return;
        }
        if (!b0Var.f12038i.isEmpty()) {
            if (this.f12009j.isEmpty()) {
                this.f12009j = b0Var.f12038i;
                this.f12008i &= -2;
            } else {
                if ((this.f12008i & 1) != 1) {
                    this.f12009j = new ArrayList(this.f12009j);
                    this.f12008i |= 1;
                }
                this.f12009j.addAll(b0Var.f12038i);
            }
        }
        if (!b0Var.f12039j.isEmpty()) {
            if (this.f12010k.isEmpty()) {
                this.f12010k = b0Var.f12039j;
                this.f12008i &= -3;
            } else {
                if ((this.f12008i & 2) != 2) {
                    this.f12010k = new ArrayList(this.f12010k);
                    this.f12008i |= 2;
                }
                this.f12010k.addAll(b0Var.f12039j);
            }
        }
        if (!b0Var.f12040k.isEmpty()) {
            if (this.f12011l.isEmpty()) {
                this.f12011l = b0Var.f12040k;
                this.f12008i &= -5;
            } else {
                if ((this.f12008i & 4) != 4) {
                    this.f12011l = new ArrayList(this.f12011l);
                    this.f12008i |= 4;
                }
                this.f12011l.addAll(b0Var.f12040k);
            }
        }
        if ((b0Var.f12037h & 1) == 1) {
            v0 v0Var2 = b0Var.f12041l;
            if ((this.f12008i & 8) != 8 || (v0Var = this.f12012m) == v0.f12413l) {
                this.f12012m = v0Var2;
            } else {
                e eVarG = v0.g(v0Var);
                eVarG.j(v0Var2);
                this.f12012m = eVarG.f();
            }
            this.f12008i |= 8;
        }
        if ((b0Var.f12037h & 2) == 2) {
            c1 c1Var2 = b0Var.f12042m;
            if ((this.f12008i & 16) != 16 || (c1Var = this.f12013n) == c1.f12079j) {
                this.f12013n = c1Var2;
            } else {
                l lVar = new l(2);
                lVar.f12242i = Collections.EMPTY_LIST;
                lVar.k(c1Var);
                lVar.k(c1Var2);
                this.f12013n = lVar.g();
            }
            this.f12008i |= 16;
        }
        d(b0Var);
        this.f3565f = this.f3565f.f(b0Var.f12036g);
    }
}
