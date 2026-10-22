package z8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c0 extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12074i;

    /* renamed from: j, reason: collision with root package name */
    public k0 f12075j;

    /* renamed from: k, reason: collision with root package name */
    public j0 f12076k;

    /* renamed from: l, reason: collision with root package name */
    public b0 f12077l;

    /* renamed from: m, reason: collision with root package name */
    public List f12078m;

    public static c0 f() {
        c0 c0Var = new c0();
        c0Var.f12075j = k0.f12234j;
        c0Var.f12076k = j0.f12219j;
        c0Var.f12077l = b0.f12034p;
        c0Var.f12078m = Collections.EMPTY_LIST;
        return c0Var;
    }

    @Override // f9.j
    public final f9.a a() {
        d0 d0VarE = e();
        if (d0VarE.isInitialized()) {
            return d0VarE;
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
            c9.a r1 = z8.d0.f12094p     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.d0 r1 = new z8.d0     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.g(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.d0 r4 = (z8.d0) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: z8.c0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        g((d0) oVar);
        return this;
    }

    public final Object clone() {
        c0 c0VarF = f();
        c0VarF.g(e());
        return c0VarF;
    }

    public final d0 e() {
        d0 d0Var = new d0(this);
        int i2 = this.f12074i;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        d0Var.f12097i = this.f12075j;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        d0Var.f12098j = this.f12076k;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        d0Var.f12099k = this.f12077l;
        if ((i2 & 8) == 8) {
            this.f12078m = Collections.unmodifiableList(this.f12078m);
            this.f12074i &= -9;
        }
        d0Var.f12100l = this.f12078m;
        d0Var.f12096h = i10;
        return d0Var;
    }

    public final void g(d0 d0Var) {
        b0 b0Var;
        j0 j0Var;
        k0 k0Var;
        if (d0Var == d0.f12093o) {
            return;
        }
        if ((d0Var.f12096h & 1) == 1) {
            k0 k0Var2 = d0Var.f12097i;
            if ((this.f12074i & 1) != 1 || (k0Var = this.f12075j) == k0.f12234j) {
                this.f12075j = k0Var2;
            } else {
                l lVar = new l(3);
                lVar.f12242i = f9.s.f3598g;
                lVar.j(k0Var);
                lVar.j(k0Var2);
                this.f12075j = lVar.f();
            }
            this.f12074i |= 1;
        }
        if ((d0Var.f12096h & 2) == 2) {
            j0 j0Var2 = d0Var.f12098j;
            if ((this.f12074i & 2) != 2 || (j0Var = this.f12076k) == j0.f12219j) {
                this.f12076k = j0Var2;
            } else {
                l lVar2 = new l(1);
                lVar2.f12242i = Collections.EMPTY_LIST;
                lVar2.i(j0Var);
                lVar2.i(j0Var2);
                this.f12076k = lVar2.e();
            }
            this.f12074i |= 2;
        }
        if ((d0Var.f12096h & 4) == 4) {
            b0 b0Var2 = d0Var.f12099k;
            if ((this.f12074i & 4) != 4 || (b0Var = this.f12077l) == b0.f12034p) {
                this.f12077l = b0Var2;
            } else {
                a0 a0VarF = a0.f();
                a0VarF.g(b0Var);
                a0VarF.g(b0Var2);
                this.f12077l = a0VarF.e();
            }
            this.f12074i |= 4;
        }
        if (!d0Var.f12100l.isEmpty()) {
            if (this.f12078m.isEmpty()) {
                this.f12078m = d0Var.f12100l;
                this.f12074i &= -9;
            } else {
                if ((this.f12074i & 8) != 8) {
                    this.f12078m = new ArrayList(this.f12078m);
                    this.f12074i |= 8;
                }
                this.f12078m.addAll(d0Var.f12100l);
            }
        }
        d(d0Var);
        this.f3565f = this.f3565f.f(d0Var.f12095g);
    }
}
