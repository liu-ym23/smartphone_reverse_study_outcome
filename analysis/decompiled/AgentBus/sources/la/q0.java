package la;

/* loaded from: classes.dex */
public final class q0 extends i7.i implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public int f5985f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ k f5986g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ int f5987h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ r0 f5988i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(r0 r0Var, g7.d dVar) {
        super(3, dVar);
        this.f5988i = r0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
    
        if (r12.emit(r0, r11) == r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
    
        if (r0.emit(r12, r11) != r3) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078 A[PHI: r0
      0x0078: PHI (r0v6 la.k) = (r0v4 la.k), (r0v5 la.k), (r0v9 la.k) binds: [B:26:0x005e, B:31:0x0075, B:12:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            la.r0 r0 = r11.f5988i
            long r1 = r0.f5994g
            h7.a r3 = h7.a.f4212f
            int r4 = r11.f5985f
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            if (r4 == 0) goto L38
            if (r4 == r9) goto L34
            if (r4 == r8) goto L2e
            if (r4 == r7) goto L28
            if (r4 == r6) goto L22
            if (r4 != r5) goto L1a
            goto L34
        L1a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L22:
            la.k r0 = r11.f5986g
            w7.e0.N(r12)
            goto L78
        L28:
            la.k r0 = r11.f5986g
            w7.e0.N(r12)
            goto L6d
        L2e:
            la.k r0 = r11.f5986g
            w7.e0.N(r12)
            goto L5a
        L34:
            w7.e0.N(r12)
            goto L86
        L38:
            w7.e0.N(r12)
            la.k r12 = r11.f5986g
            int r4 = r11.f5987h
            if (r4 <= 0) goto L4c
            la.m0 r0 = la.m0.f5958f
            r11.f5985f = r9
            java.lang.Object r11 = r12.emit(r0, r11)
            if (r11 != r3) goto L86
            goto L85
        L4c:
            long r9 = r0.f5993f
            r11.f5986g = r12
            r11.f5985f = r8
            java.lang.Object r0 = ia.d0.g(r9, r11)
            if (r0 != r3) goto L59
            goto L85
        L59:
            r0 = r12
        L5a:
            r8 = 0
            int r12 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r12 <= 0) goto L78
            la.m0 r12 = la.m0.f5959g
            r11.f5986g = r0
            r11.f5985f = r7
            java.lang.Object r12 = r0.emit(r12, r11)
            if (r12 != r3) goto L6d
            goto L85
        L6d:
            r11.f5986g = r0
            r11.f5985f = r6
            java.lang.Object r12 = ia.d0.g(r1, r11)
            if (r12 != r3) goto L78
            goto L85
        L78:
            la.m0 r12 = la.m0.f5960h
            r1 = 0
            r11.f5986g = r1
            r11.f5985f = r5
            java.lang.Object r11 = r0.emit(r12, r11)
            if (r11 != r3) goto L86
        L85:
            return r3
        L86:
            c7.r r11 = c7.r.f1986a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: la.q0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj2).intValue();
        q0 q0Var = new q0(this.f5988i, (g7.d) obj3);
        q0Var.f5986g = (k) obj;
        q0Var.f5987h = iIntValue;
        return q0Var.invokeSuspend(c7.r.f1986a);
    }
}
