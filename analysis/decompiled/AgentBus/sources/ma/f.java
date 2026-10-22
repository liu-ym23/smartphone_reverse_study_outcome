package ma;

/* loaded from: classes.dex */
public abstract class f extends e {

    /* renamed from: i, reason: collision with root package name */
    public final la.j f6485i;

    public f(int i2, g7.l lVar, ka.a aVar, la.j jVar) {
        super(lVar, i2, aVar);
        this.f6485i = jVar;
    }

    @Override // ma.e
    public final Object b(ka.t tVar, g7.d dVar) {
        Object objF = f(new u(tVar), dVar);
        return objF == h7.a.f4212f ? objF : c7.r.f1986a;
    }

    public abstract Object f(la.k kVar, g7.d dVar);

    @Override // ma.e
    public final String toString() {
        return this.f6485i + " -> " + super.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    @Override // ma.e, la.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(la.k r5, g7.d r6) {
        /*
            r4 = this;
            int r0 = r4.f6483g
            r1 = -3
            if (r0 != r1) goto L70
            g7.l r0 = r6.getContext()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            g7.b r2 = new g7.b
            r3 = 2
            r2.<init>(r3)
            g7.l r3 = r4.f6482f
            java.lang.Object r1 = r3.r(r1, r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L24
            g7.l r1 = r0.Q(r3)
            goto L29
        L24:
            r1 = 0
            g7.l r1 = ia.d0.i(r0, r3, r1)
        L29:
            boolean r2 = q7.k.a(r1, r0)
            if (r2 == 0) goto L38
            java.lang.Object r4 = r4.f(r5, r6)
            h7.a r5 = h7.a.f4212f
            if (r4 != r5) goto L79
            return r4
        L38:
            g7.f r2 = g7.f.f3865f
            g7.j r3 = r1.o(r2)
            g7.j r0 = r0.o(r2)
            boolean r0 = q7.k.a(r3, r0)
            if (r0 == 0) goto L70
            g7.l r0 = r6.getContext()
            boolean r2 = r5 instanceof ma.u
            if (r2 != 0) goto L5b
            boolean r2 = r5 instanceof ma.q
            if (r2 == 0) goto L55
            goto L5b
        L55:
            d5.k r2 = new d5.k
            r2.<init>(r5, r0)
            r5 = r2
        L5b:
            a5.b r0 = new a5.b
            r2 = 0
            r3 = 14
            r0.<init>(r4, r2, r3)
            java.lang.Object r4 = na.b.m(r1)
            java.lang.Object r4 = ma.c.a(r1, r5, r4, r0, r6)
            h7.a r5 = h7.a.f4212f
            if (r4 != r5) goto L79
            return r4
        L70:
            java.lang.Object r4 = super.x(r5, r6)
            h7.a r5 = h7.a.f4212f
            if (r4 != r5) goto L79
            return r4
        L79:
            c7.r r4 = c7.r.f1986a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.f.x(la.k, g7.d):java.lang.Object");
    }
}
