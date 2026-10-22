package z8;

/* loaded from: classes.dex */
public final class r extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12338i;

    /* renamed from: j, reason: collision with root package name */
    public int f12339j;

    @Override // f9.j
    public final f9.a a() {
        s sVar = new s(this);
        int i2 = (this.f12338i & 1) != 1 ? 0 : 1;
        sVar.f12359i = this.f12339j;
        sVar.f12358h = i2;
        if (sVar.isInitialized()) {
            return sVar;
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
            c9.a r1 = z8.s.f12356m     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.s r1 = new z8.s     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.s r4 = (z8.s) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.e(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.r.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        e((s) oVar);
        return this;
    }

    public final Object clone() {
        r rVar = new r();
        s sVar = new s(this);
        int i2 = (this.f12338i & 1) != 1 ? 0 : 1;
        sVar.f12359i = this.f12339j;
        sVar.f12358h = i2;
        rVar.e(sVar);
        return rVar;
    }

    public final void e(s sVar) {
        if (sVar == s.f12355l) {
            return;
        }
        if ((sVar.f12358h & 1) == 1) {
            int i2 = sVar.f12359i;
            this.f12338i = 1 | this.f12338i;
            this.f12339j = i2;
        }
        d(sVar);
        this.f3565f = this.f3565f.f(sVar.f12357g);
    }
}
