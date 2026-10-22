package z8;

/* loaded from: classes.dex */
public final class w0 extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12436i;

    /* renamed from: j, reason: collision with root package name */
    public int f12437j;

    /* renamed from: k, reason: collision with root package name */
    public int f12438k;

    /* renamed from: l, reason: collision with root package name */
    public p0 f12439l;

    /* renamed from: m, reason: collision with root package name */
    public int f12440m;

    /* renamed from: n, reason: collision with root package name */
    public p0 f12441n;

    /* renamed from: o, reason: collision with root package name */
    public int f12442o;

    @Override // f9.j
    public final f9.a a() {
        x0 x0VarE = e();
        if (x0VarE.isInitialized()) {
            return x0VarE;
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
            c9.a r1 = z8.x0.f12464r     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.x0 r1 = new z8.x0     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.x0 r4 = (z8.x0) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: z8.w0.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        f((x0) oVar);
        return this;
    }

    public final Object clone() {
        w0 w0Var = new w0();
        p0 p0Var = p0.f12298y;
        w0Var.f12439l = p0Var;
        w0Var.f12441n = p0Var;
        w0Var.f(e());
        return w0Var;
    }

    public final x0 e() {
        x0 x0Var = new x0(this);
        int i2 = this.f12436i;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        x0Var.f12467i = this.f12437j;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        x0Var.f12468j = this.f12438k;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        x0Var.f12469k = this.f12439l;
        if ((i2 & 8) == 8) {
            i10 |= 8;
        }
        x0Var.f12470l = this.f12440m;
        if ((i2 & 16) == 16) {
            i10 |= 16;
        }
        x0Var.f12471m = this.f12441n;
        if ((i2 & 32) == 32) {
            i10 |= 32;
        }
        x0Var.f12472n = this.f12442o;
        x0Var.f12466h = i10;
        return x0Var;
    }

    public final void f(x0 x0Var) {
        p0 p0Var;
        p0 p0Var2;
        if (x0Var == x0.f12463q) {
            return;
        }
        int i2 = x0Var.f12466h;
        if ((i2 & 1) == 1) {
            int i10 = x0Var.f12467i;
            this.f12436i = 1 | this.f12436i;
            this.f12437j = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = x0Var.f12468j;
            this.f12436i = 2 | this.f12436i;
            this.f12438k = i11;
        }
        if ((i2 & 4) == 4) {
            p0 p0Var3 = x0Var.f12469k;
            if ((this.f12436i & 4) != 4 || (p0Var2 = this.f12439l) == p0.f12298y) {
                this.f12439l = p0Var3;
            } else {
                o0 o0VarP = p0.p(p0Var2);
                o0VarP.g(p0Var3);
                this.f12439l = o0VarP.e();
            }
            this.f12436i |= 4;
        }
        int i12 = x0Var.f12466h;
        if ((i12 & 8) == 8) {
            int i13 = x0Var.f12470l;
            this.f12436i = 8 | this.f12436i;
            this.f12440m = i13;
        }
        if ((i12 & 16) == 16) {
            p0 p0Var4 = x0Var.f12471m;
            if ((this.f12436i & 16) != 16 || (p0Var = this.f12441n) == p0.f12298y) {
                this.f12441n = p0Var4;
            } else {
                o0 o0VarP2 = p0.p(p0Var);
                o0VarP2.g(p0Var4);
                this.f12441n = o0VarP2.e();
            }
            this.f12436i |= 16;
        }
        if ((x0Var.f12466h & 32) == 32) {
            int i14 = x0Var.f12472n;
            this.f12436i = 32 | this.f12436i;
            this.f12442o = i14;
        }
        d(x0Var);
        this.f3565f = this.f3565f.f(x0Var.f12465g);
    }
}
