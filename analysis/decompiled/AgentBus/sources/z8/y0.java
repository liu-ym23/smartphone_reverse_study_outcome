package z8;

/* loaded from: classes.dex */
public final class y0 extends f9.j implements f9.v {

    /* renamed from: g, reason: collision with root package name */
    public int f12477g;

    /* renamed from: h, reason: collision with root package name */
    public int f12478h;

    /* renamed from: i, reason: collision with root package name */
    public int f12479i;

    /* renamed from: j, reason: collision with root package name */
    public z0 f12480j;

    /* renamed from: k, reason: collision with root package name */
    public int f12481k;

    /* renamed from: l, reason: collision with root package name */
    public int f12482l;

    /* renamed from: m, reason: collision with root package name */
    public a1 f12483m;

    public static y0 e() {
        y0 y0Var = new y0();
        y0Var.f12480j = z0.ERROR;
        y0Var.f12483m = a1.LANGUAGE_VERSION;
        return y0Var;
    }

    @Override // f9.j
    public final f9.a a() {
        b1 b1VarD = d();
        b1VarD.isInitialized();
        return b1VarD;
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
            c9.a r0 = z8.b1.f12046q     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.b1 r0 = new z8.b1     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.f(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            f9.a r0 = r2.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.b1 r0 = (z8.b1) r0     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: z8.y0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        f((b1) oVar);
        return this;
    }

    public final Object clone() {
        y0 y0VarE = e();
        y0VarE.f(d());
        return y0VarE;
    }

    public final b1 d() {
        b1 b1Var = new b1(this);
        int i2 = this.f12477g;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        b1Var.f12049h = this.f12478h;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        b1Var.f12050i = this.f12479i;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        b1Var.f12051j = this.f12480j;
        if ((i2 & 8) == 8) {
            i10 |= 8;
        }
        b1Var.f12052k = this.f12481k;
        if ((i2 & 16) == 16) {
            i10 |= 16;
        }
        b1Var.f12053l = this.f12482l;
        if ((i2 & 32) == 32) {
            i10 |= 32;
        }
        b1Var.f12054m = this.f12483m;
        b1Var.f12048g = i10;
        return b1Var;
    }

    public final void f(b1 b1Var) {
        if (b1Var == b1.f12045p) {
            return;
        }
        int i2 = b1Var.f12048g;
        if ((i2 & 1) == 1) {
            int i10 = b1Var.f12049h;
            this.f12477g = 1 | this.f12477g;
            this.f12478h = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = b1Var.f12050i;
            this.f12477g = 2 | this.f12477g;
            this.f12479i = i11;
        }
        if ((i2 & 4) == 4) {
            z0 z0Var = b1Var.f12051j;
            z0Var.getClass();
            this.f12477g = 4 | this.f12477g;
            this.f12480j = z0Var;
        }
        int i12 = b1Var.f12048g;
        if ((i12 & 8) == 8) {
            int i13 = b1Var.f12052k;
            this.f12477g = 8 | this.f12477g;
            this.f12481k = i13;
        }
        if ((i12 & 16) == 16) {
            int i14 = b1Var.f12053l;
            this.f12477g = 16 | this.f12477g;
            this.f12482l = i14;
        }
        if ((i12 & 32) == 32) {
            a1 a1Var = b1Var.f12054m;
            a1Var.getClass();
            this.f12477g = 32 | this.f12477g;
            this.f12483m = a1Var;
        }
        this.f3565f = this.f3565f.f(b1Var.f12047f);
    }
}
