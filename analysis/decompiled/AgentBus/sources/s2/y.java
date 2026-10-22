package s2;

/* loaded from: classes.dex */
public final class y extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public q7.t f9457f;

    /* renamed from: g, reason: collision with root package name */
    public int f9458g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9459h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ q7.t f9460i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z f9461j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f9462k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f9463l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(q7.t tVar, z zVar, Object obj, boolean z4, g7.d dVar) {
        super(2, dVar);
        this.f9460i = tVar;
        this.f9461j = zVar;
        this.f9462k = obj;
        this.f9463l = z4;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        y yVar = new y(this.f9460i, this.f9461j, this.f9462k, this.f9463l, dVar);
        yVar.f9459h = obj;
        return yVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((y) create((u2.k) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        if (r6.b(r2, r7) == r0) goto L16;
     */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r7.f9458g
            java.lang.Object r2 = r7.f9462k
            s2.z r3 = r7.f9461j
            q7.t r4 = r7.f9460i
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L28
            if (r1 == r6) goto L1e
            if (r1 != r5) goto L16
            w7.e0.N(r8)
            goto L65
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1e:
            q7.t r1 = r7.f9457f
            java.lang.Object r6 = r7.f9459h
            u2.k r6 = (u2.k) r6
            w7.e0.N(r8)
            goto L4f
        L28:
            w7.e0.N(r8)
            java.lang.Object r8 = r7.f9459h
            u2.k r8 = (u2.k) r8
            s2.g0 r1 = r3.d()
            r7.f9459h = r8
            r7.f9457f = r4
            r7.f9458g = r6
            o4.d0 r1 = r1.f9369b
            java.lang.Object r1 = r1.f7326g
            java.util.concurrent.atomic.AtomicInteger r1 = (java.util.concurrent.atomic.AtomicInteger) r1
            int r1 = r1.incrementAndGet()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r1)
            if (r6 != r0) goto L4b
            goto L64
        L4b:
            r1 = r6
            r6 = r8
            r8 = r1
            r1 = r4
        L4f:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r1.f8818f = r8
            r8 = 0
            r7.f9459h = r8
            r7.f9457f = r8
            r7.f9458g = r5
            java.lang.Object r8 = r6.b(r2, r7)
            if (r8 != r0) goto L65
        L64:
            return r0
        L65:
            boolean r7 = r7.f9463l
            if (r7 == 0) goto L7d
            o4.d0 r7 = r3.f9470l
            s2.c r8 = new s2.c
            if (r2 == 0) goto L74
            int r0 = r2.hashCode()
            goto L75
        L74:
            r0 = 0
        L75:
            int r1 = r4.f8818f
            r8.<init>(r0, r1, r2)
            r7.T(r8)
        L7d:
            c7.r r7 = c7.r.f1986a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.y.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
