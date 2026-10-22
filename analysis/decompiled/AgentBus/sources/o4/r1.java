package o4;

/* loaded from: classes.dex */
public final class r1 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f7540f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f7541g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t1 f7542h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(boolean z4, t1 t1Var, g7.d dVar) {
        super(2, dVar);
        this.f7541g = z4;
        this.f7542h = t1Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new r1(this.f7541g, this.f7542h, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((r1) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (o4.t1.b(r1, r4) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (o4.t1.a(r1, r4) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        return r0;
     */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r4.f7540f
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L19
            if (r1 == r3) goto L15
            if (r1 != r2) goto Ld
            goto L15
        Ld:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L15:
            w7.e0.N(r5)
            goto L34
        L19:
            w7.e0.N(r5)
            boolean r5 = r4.f7541g
            o4.t1 r1 = r4.f7542h
            if (r5 == 0) goto L2b
            r4.f7540f = r3
            java.lang.Object r4 = o4.t1.b(r1, r4)
            if (r4 != r0) goto L34
            goto L33
        L2b:
            r4.f7540f = r2
            java.lang.Object r4 = o4.t1.a(r1, r4)
            if (r4 != r0) goto L34
        L33:
            return r0
        L34:
            c7.r r4 = c7.r.f1986a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.r1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
