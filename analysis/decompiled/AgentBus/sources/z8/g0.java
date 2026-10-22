package z8;

/* loaded from: classes.dex */
public final class g0 extends f9.j implements f9.v {

    /* renamed from: g, reason: collision with root package name */
    public int f12170g;

    /* renamed from: h, reason: collision with root package name */
    public int f12171h;

    /* renamed from: i, reason: collision with root package name */
    public int f12172i;

    /* renamed from: j, reason: collision with root package name */
    public h0 f12173j;

    public static g0 e() {
        g0 g0Var = new g0();
        g0Var.f12171h = -1;
        g0Var.f12173j = h0.PACKAGE;
        return g0Var;
    }

    @Override // f9.j
    public final f9.a a() {
        i0 i0VarD = d();
        if (i0VarD.isInitialized()) {
            return i0VarD;
        }
        throw new a4.u(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // f9.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.j b(f9.e r2, f9.h r3) throws java.lang.Throwable {
        /*
            r1 = this;
            r3 = 0
            c9.a r0 = z8.i0.f12207n     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.i0 r0 = new z8.i0     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.f(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            f9.a r0 = r2.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.i0 r0 = (z8.i0) r0     // Catch: java.lang.Throwable -> Lf
            throw r2     // Catch: java.lang.Throwable -> L17
        L17:
            r2 = move-exception
            r3 = r0
        L19:
            if (r3 == 0) goto L1e
            r1.f(r3)
        L1e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.g0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        f((i0) oVar);
        return this;
    }

    public final Object clone() {
        g0 g0VarE = e();
        g0VarE.f(d());
        return g0VarE;
    }

    public final i0 d() {
        i0 i0Var = new i0(this);
        int i2 = this.f12170g;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        i0Var.f12210h = this.f12171h;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        i0Var.f12211i = this.f12172i;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        i0Var.f12212j = this.f12173j;
        i0Var.f12209g = i10;
        return i0Var;
    }

    public final void f(i0 i0Var) {
        if (i0Var == i0.f12206m) {
            return;
        }
        int i2 = i0Var.f12209g;
        if ((i2 & 1) == 1) {
            int i10 = i0Var.f12210h;
            this.f12170g = 1 | this.f12170g;
            this.f12171h = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = i0Var.f12211i;
            this.f12170g = 2 | this.f12170g;
            this.f12172i = i11;
        }
        if ((i2 & 4) == 4) {
            h0 h0Var = i0Var.f12212j;
            h0Var.getClass();
            this.f12170g = 4 | this.f12170g;
            this.f12173j = h0Var;
        }
        this.f3565f = this.f3565f.f(i0Var.f12208f);
    }
}
