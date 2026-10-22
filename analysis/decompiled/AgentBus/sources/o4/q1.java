package o4;

/* loaded from: classes.dex */
public final class q1 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f7521f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7522g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t1 f7523h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f7524i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(t1 t1Var, long j2, g7.d dVar) {
        super(2, dVar);
        this.f7523h = t1Var;
        this.f7524i = j2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        q1 q1Var = new q1(this.f7523h, this.f7524i, dVar);
        q1Var.f7522g = obj;
        return q1Var;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((q1) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
    
        if (r1.n(r11) == r0) goto L15;
     */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r11.f7521f
            r2 = 2
            r3 = 1
            r8 = 0
            if (r1 == 0) goto L21
            if (r1 == r3) goto L19
            if (r1 != r2) goto L11
            w7.e0.N(r12)
            goto L57
        L11:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L19:
            java.lang.Object r1 = r11.f7522g
            ia.g0 r1 = (ia.g0) r1
            w7.e0.N(r12)
            goto L4c
        L21:
            w7.e0.N(r12)
            java.lang.Object r12 = r11.f7522g
            ia.b0 r12 = (ia.b0) r12
            o4.p1 r4 = new o4.p1
            r9 = 1
            o4.t1 r5 = r11.f7523h
            long r6 = r11.f7524i
            r4.<init>(r5, r6, r8, r9)
            r1 = 3
            ia.h0 r10 = ia.d0.d(r12, r8, r4, r1)
            o4.p1 r4 = new o4.p1
            r9 = 0
            r4.<init>(r5, r6, r8, r9)
            ia.h0 r1 = ia.d0.d(r12, r8, r4, r1)
            r11.f7522g = r1
            r11.f7521f = r3
            java.lang.Object r12 = r10.A(r11)
            if (r12 != r0) goto L4c
            goto L56
        L4c:
            r11.f7522g = r8
            r11.f7521f = r2
            java.lang.Object r11 = r1.n(r11)
            if (r11 != r0) goto L57
        L56:
            return r0
        L57:
            c7.r r11 = c7.r.f1986a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.q1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
