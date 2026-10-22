package la;

/* loaded from: classes.dex */
public final class t extends i7.i implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public int f6000f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ k f6001g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6002h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ a0 f6003i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(a0 a0Var, g7.d dVar) {
        super(3, dVar);
        this.f6003i = a0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if (r1.emit(r5, r4) == r0) goto L15;
     */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r4.f6000f
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            w7.e0.N(r5)
            goto L3e
        L10:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L18:
            la.k r1 = r4.f6001g
            w7.e0.N(r5)
            goto L32
        L1e:
            w7.e0.N(r5)
            la.k r1 = r4.f6001g
            java.lang.Object r5 = r4.f6002h
            r4.f6001g = r1
            r4.f6000f = r3
            la.a0 r3 = r4.f6003i
            java.lang.Object r5 = r3.invoke(r5, r4)
            if (r5 != r0) goto L32
            goto L3d
        L32:
            r3 = 0
            r4.f6001g = r3
            r4.f6000f = r2
            java.lang.Object r4 = r1.emit(r5, r4)
            if (r4 != r0) goto L3e
        L3d:
            return r0
        L3e:
            c7.r r4 = c7.r.f1986a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: la.t.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        t tVar = new t(this.f6003i, (g7.d) obj3);
        tVar.f6001g = (k) obj;
        tVar.f6002h = obj2;
        return tVar.invokeSuspend(c7.r.f1986a);
    }
}
