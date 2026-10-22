package la;

/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: j, reason: collision with root package name */
    public final a5.b f5911j;

    public c(a5.b bVar, g7.l lVar, int i2, ka.a aVar) {
        super(bVar, lVar, i2, aVar);
        this.f5911j = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // la.e, ma.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ka.t r5, g7.d r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof la.b
            if (r0 == 0) goto L13
            r0 = r6
            la.b r0 = (la.b) r0
            int r1 = r0.f5907i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5907i = r1
            goto L1a
        L13:
            la.b r0 = new la.b
            i7.c r6 = (i7.c) r6
            r0.<init>(r4, r6)
        L1a:
            java.lang.Object r6 = r0.f5905g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5907i
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            ka.t r5 = r0.f5904f
            w7.e0.N(r6)
            goto L41
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            w7.e0.N(r6)
            r0.f5904f = r5
            r0.f5907i = r3
            java.lang.Object r4 = super.b(r5, r0)
            if (r4 != r1) goto L41
            return r1
        L41:
            ka.s r5 = (ka.s) r5
            ka.g r4 = r5.f5719i
            boolean r4 = r4.y()
            if (r4 == 0) goto L4e
            c7.r r4 = c7.r.f1986a
            return r4
        L4e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: la.c.b(ka.t, g7.d):java.lang.Object");
    }

    @Override // la.e, ma.e
    public final ma.e c(g7.l lVar, int i2, ka.a aVar) {
        return new c(this.f5911j, lVar, i2, aVar);
    }
}
