package z8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class s0 extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12362i;

    /* renamed from: j, reason: collision with root package name */
    public int f12363j;

    /* renamed from: k, reason: collision with root package name */
    public int f12364k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12365l;

    /* renamed from: m, reason: collision with root package name */
    public t0 f12366m;

    /* renamed from: n, reason: collision with root package name */
    public List f12367n;

    /* renamed from: o, reason: collision with root package name */
    public List f12368o;

    public static s0 f() {
        s0 s0Var = new s0();
        s0Var.f12366m = t0.INV;
        List list = Collections.EMPTY_LIST;
        s0Var.f12367n = list;
        s0Var.f12368o = list;
        return s0Var;
    }

    @Override // f9.j
    public final f9.a a() {
        u0 u0VarE = e();
        if (u0VarE.isInitialized()) {
            return u0VarE;
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
            c9.a r1 = z8.u0.f12388s     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.u0 r1 = new z8.u0     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.g(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.u0 r4 = (z8.u0) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: z8.s0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        g((u0) oVar);
        return this;
    }

    public final Object clone() {
        s0 s0VarF = f();
        s0VarF.g(e());
        return s0VarF;
    }

    public final u0 e() {
        u0 u0Var = new u0(this);
        int i2 = this.f12362i;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        u0Var.f12391i = this.f12363j;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        u0Var.f12392j = this.f12364k;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        u0Var.f12393k = this.f12365l;
        if ((i2 & 8) == 8) {
            i10 |= 8;
        }
        u0Var.f12394l = this.f12366m;
        if ((i2 & 16) == 16) {
            this.f12367n = Collections.unmodifiableList(this.f12367n);
            this.f12362i &= -17;
        }
        u0Var.f12395m = this.f12367n;
        if ((this.f12362i & 32) == 32) {
            this.f12368o = Collections.unmodifiableList(this.f12368o);
            this.f12362i &= -33;
        }
        u0Var.f12396n = this.f12368o;
        u0Var.f12390h = i10;
        return u0Var;
    }

    public final void g(u0 u0Var) {
        if (u0Var == u0.f12387r) {
            return;
        }
        int i2 = u0Var.f12390h;
        if ((i2 & 1) == 1) {
            int i10 = u0Var.f12391i;
            this.f12362i = 1 | this.f12362i;
            this.f12363j = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = u0Var.f12392j;
            this.f12362i = 2 | this.f12362i;
            this.f12364k = i11;
        }
        if ((i2 & 4) == 4) {
            boolean z4 = u0Var.f12393k;
            this.f12362i = 4 | this.f12362i;
            this.f12365l = z4;
        }
        if ((i2 & 8) == 8) {
            t0 t0Var = u0Var.f12394l;
            t0Var.getClass();
            this.f12362i = 8 | this.f12362i;
            this.f12366m = t0Var;
        }
        if (!u0Var.f12395m.isEmpty()) {
            if (this.f12367n.isEmpty()) {
                this.f12367n = u0Var.f12395m;
                this.f12362i &= -17;
            } else {
                if ((this.f12362i & 16) != 16) {
                    this.f12367n = new ArrayList(this.f12367n);
                    this.f12362i |= 16;
                }
                this.f12367n.addAll(u0Var.f12395m);
            }
        }
        if (!u0Var.f12396n.isEmpty()) {
            if (this.f12368o.isEmpty()) {
                this.f12368o = u0Var.f12396n;
                this.f12362i &= -33;
            } else {
                if ((this.f12362i & 32) != 32) {
                    this.f12368o = new ArrayList(this.f12368o);
                    this.f12362i |= 32;
                }
                this.f12368o.addAll(u0Var.f12396n);
            }
        }
        d(u0Var);
        this.f3565f = this.f3565f.f(u0Var.f12389g);
    }
}
