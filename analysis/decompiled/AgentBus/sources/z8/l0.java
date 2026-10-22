package z8;

/* loaded from: classes.dex */
public final class l0 extends f9.j implements f9.v {

    /* renamed from: g, reason: collision with root package name */
    public int f12243g;

    /* renamed from: h, reason: collision with root package name */
    public m0 f12244h;

    /* renamed from: i, reason: collision with root package name */
    public p0 f12245i;

    /* renamed from: j, reason: collision with root package name */
    public int f12246j;

    public static l0 e() {
        l0 l0Var = new l0();
        l0Var.f12244h = m0.INV;
        l0Var.f12245i = p0.f12298y;
        return l0Var;
    }

    @Override // f9.j
    public final f9.a a() {
        n0 n0VarD = d();
        if (n0VarD.isInitialized()) {
            return n0VarD;
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
            c9.a r1 = z8.n0.f12265n     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.n0 r1 = new z8.n0     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.n0 r4 = (z8.n0) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.f(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.l0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        f((n0) oVar);
        return this;
    }

    public final Object clone() {
        l0 l0VarE = e();
        l0VarE.f(d());
        return l0VarE;
    }

    public final n0 d() {
        n0 n0Var = new n0(this);
        int i2 = this.f12243g;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        n0Var.f12268h = this.f12244h;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        n0Var.f12269i = this.f12245i;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        n0Var.f12270j = this.f12246j;
        n0Var.f12267g = i10;
        return n0Var;
    }

    public final void f(n0 n0Var) {
        p0 p0Var;
        if (n0Var == n0.f12264m) {
            return;
        }
        if ((n0Var.f12267g & 1) == 1) {
            m0 m0Var = n0Var.f12268h;
            m0Var.getClass();
            this.f12243g = 1 | this.f12243g;
            this.f12244h = m0Var;
        }
        if ((n0Var.f12267g & 2) == 2) {
            p0 p0Var2 = n0Var.f12269i;
            if ((this.f12243g & 2) != 2 || (p0Var = this.f12245i) == p0.f12298y) {
                this.f12245i = p0Var2;
            } else {
                o0 o0VarP = p0.p(p0Var);
                o0VarP.g(p0Var2);
                this.f12245i = o0VarP.e();
            }
            this.f12243g |= 2;
        }
        if ((n0Var.f12267g & 4) == 4) {
            int i2 = n0Var.f12270j;
            this.f12243g = 4 | this.f12243g;
            this.f12246j = i2;
        }
        this.f3565f = this.f3565f.f(n0Var.f12266f);
    }
}
