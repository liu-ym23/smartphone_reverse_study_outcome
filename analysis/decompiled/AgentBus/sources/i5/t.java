package i5;

import ia.b0;

/* loaded from: classes.dex */
public final class t extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public long f4717f;

    /* renamed from: g, reason: collision with root package name */
    public int f4718g;

    /* renamed from: h, reason: collision with root package name */
    public int f4719h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ u f4720i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, g7.d dVar) {
        super(2, dVar);
        this.f4720i = uVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new t(this.f4720i, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((t) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        if (r0 == r1) goto L16;
     */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f4719h
            r3 = 2
            i5.u r4 = r0.f4720i
            r5 = 1
            if (r2 == 0) goto L29
            if (r2 == r5) goto L21
            if (r2 != r3) goto L19
            int r0 = r0.f4718g
            w7.e0.N(r18)
            r2 = r0
            r0 = r18
            goto L65
        L19:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L21:
            long r5 = r0.f4717f
            w7.e0.N(r18)
            r2 = r18
            goto L48
        L29:
            w7.e0.N(r18)
            long r6 = java.lang.System.currentTimeMillis()
            i5.f r2 = r4.f4728h
            r0.f4717f = r6
            r0.f4719h = r5
            java.lang.Object r5 = r2.f4653g
            com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl r5 = (com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl) r5
            i5.e r8 = new i5.e
            r9 = 0
            r8.<init>(r9, r6, r2)
            java.lang.Object r2 = g3.d.b(r5, r8, r0)
            if (r2 != r1) goto L47
            goto L64
        L47:
            r5 = r6
        L48:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            i5.l r7 = r4.f4729i
            r0.f4718g = r2
            r0.f4719h = r3
            java.lang.Object r3 = r7.f4687g
            com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl r3 = (com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl) r3
            i5.e r8 = new i5.e
            r9 = 2
            r8.<init>(r9, r5, r7)
            java.lang.Object r0 = g3.d.b(r3, r8, r0)
            if (r0 != r1) goto L65
        L64:
            return r1
        L65:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            java.lang.String r1 = "purged "
            if (r2 <= 0) goto L7f
            k5.t r5 = r4.f4725e
            java.lang.String r3 = " expired frames"
            java.lang.String r7 = a1.a.f(r2, r1, r3)
            r9 = 4
            r10 = 0
            java.lang.String r6 = "OfflineQueue"
            r8 = 0
            k5.s.info$default(r5, r6, r7, r8, r9, r10)
        L7f:
            if (r0 <= 0) goto L92
            k5.t r11 = r4.f4725e
            java.lang.String r3 = " expired tombstones"
            java.lang.String r13 = a1.a.f(r0, r1, r3)
            r15 = 4
            r16 = 0
            java.lang.String r12 = "OfflineQueue"
            r14 = 0
            k5.s.info$default(r11, r12, r13, r14, r15, r16)
        L92:
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.t.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
