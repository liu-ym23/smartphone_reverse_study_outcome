package p;

/* loaded from: classes.dex */
public final class b1 extends i7.h implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public int f8056g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8057h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ia.b0 f8058i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o.q f8059j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ c1.w f8060k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ h0 f8061l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(ia.b0 b0Var, o.q qVar, c1.w wVar, h0 h0Var, g7.d dVar) {
        super(2, dVar);
        this.f8058i = b0Var;
        this.f8059j = qVar;
        this.f8060k = wVar;
        this.f8061l = h0Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        b1 b1Var = new b1(this.f8058i, this.f8059j, this.f8060k, this.f8061l, dVar);
        b1Var.f8057h = obj;
        return b1Var;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((b1) create((c1.v) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        if (r13 == r0) goto L18;
     */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r12.f8056g
            ia.b0 r2 = r12.f8058i
            r3 = 3
            r4 = 2
            r5 = 1
            p.h0 r8 = r12.f8061l
            r10 = 0
            if (r1 == 0) goto L26
            if (r1 == r5) goto L1e
            if (r1 != r4) goto L16
            w7.e0.N(r13)
            goto L66
        L16:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1e:
            java.lang.Object r1 = r12.f8057h
            c1.v r1 = (c1.v) r1
            w7.e0.N(r13)
            goto L43
        L26:
            w7.e0.N(r13)
            java.lang.Object r13 = r12.f8057h
            r1 = r13
            c1.v r1 = (c1.v) r1
            a6.r r13 = new a6.r
            r6 = 10
            r13.<init>(r8, r10, r6)
            ia.d0.s(r2, r10, r10, r13, r3)
            r12.f8057h = r1
            r12.f8056g = r5
            java.lang.Object r13 = p.d1.b(r1, r12, r3)
            if (r13 != r0) goto L43
            goto L65
        L43:
            r9 = r13
            c1.l r9 = (c1.l) r9
            r9.a()
            p.a0 r13 = p.d1.f8077a
            o.q r7 = r12.f8059j
            if (r7 == r13) goto L59
            b0.f2 r6 = new b0.f2
            r11 = 15
            r6.<init>(r7, r8, r9, r10, r11)
            ia.d0.s(r2, r10, r10, r6, r3)
        L59:
            r12.f8057h = r10
            r12.f8056g = r4
            c1.g r13 = c1.g.f1798g
            java.lang.Object r13 = p.d1.c(r1, r13, r12)
            if (r13 != r0) goto L66
        L65:
            return r0
        L66:
            c1.l r13 = (c1.l) r13
            if (r13 != 0) goto L74
            p.a1 r12 = new p.a1
            r13 = 0
            r12.<init>(r8, r10, r13)
            ia.d0.s(r2, r10, r10, r12, r3)
            goto L8f
        L74:
            r13.a()
            p.a1 r13 = new p.a1
            r0 = 1
            r13.<init>(r8, r10, r0)
            ia.d0.s(r2, r10, r10, r13, r3)
            c1.w r12 = r12.f8060k
            java.lang.Object r12 = r12.f1849h
            o.r r12 = (o.r) r12
            boolean r13 = r12.f7120x
            if (r13 == 0) goto L8f
            p7.a r12 = r12.f7121y
            r12.c()
        L8f:
            c7.r r12 = c7.r.f1986a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p.b1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
