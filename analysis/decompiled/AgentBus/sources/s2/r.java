package s2;

/* loaded from: classes.dex */
public final class r implements la.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9419f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ la.k f9420g;

    public /* synthetic */ r(la.k kVar, int i2) {
        this.f9419f = i2;
        this.f9420g = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // la.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r5, g7.d r6) throws java.lang.Throwable {
        /*
            r4 = this;
            int r0 = r4.f9419f
            switch(r0) {
                case 0: goto L4c;
                default: goto L5;
            }
        L5:
            boolean r0 = r6 instanceof y4.s
            if (r0 == 0) goto L18
            r0 = r6
            y4.s r0 = (y4.s) r0
            int r1 = r0.f11650g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L18
            int r1 = r1 - r2
            r0.f11650g = r1
            goto L1d
        L18:
            y4.s r0 = new y4.s
            r0.<init>(r4, r6)
        L1d:
            java.lang.Object r6 = r0.f11649f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f11650g
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            w7.e0.N(r6)
            goto L49
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            w7.e0.N(r6)
            r6 = r5
            o4.h1 r6 = (o4.h1) r6
            o4.h1 r2 = o4.h1.ONLINE
            if (r6 != r2) goto L49
            r0.f11650g = r3
            la.k r4 = r4.f9420g
            java.lang.Object r4 = r4.emit(r5, r0)
            if (r4 != r1) goto L49
            goto L4b
        L49:
            c7.r r1 = c7.r.f1986a
        L4b:
            return r1
        L4c:
            boolean r0 = r6 instanceof s2.q
            if (r0 == 0) goto L5f
            r0 = r6
            s2.q r0 = (s2.q) r0
            int r1 = r0.f9417g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L5f
            int r1 = r1 - r2
            r0.f9417g = r1
            goto L64
        L5f:
            s2.q r0 = new s2.q
            r0.<init>(r4, r6)
        L64:
            java.lang.Object r6 = r0.f9416f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f9417g
            r3 = 1
            if (r2 == 0) goto L7b
            if (r2 != r3) goto L73
            w7.e0.N(r6)
            goto L97
        L73:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L7b:
            w7.e0.N(r6)
            s2.h0 r5 = (s2.h0) r5
            boolean r6 = r5 instanceof s2.c0
            if (r6 != 0) goto Lb1
            boolean r6 = r5 instanceof s2.c
            if (r6 == 0) goto L9a
            s2.c r5 = (s2.c) r5
            java.lang.Object r5 = r5.f9341b
            r0.f9417g = r3
            la.k r4 = r4.f9420g
            java.lang.Object r4 = r4.emit(r5, r0)
            if (r4 != r1) goto L97
            goto L99
        L97:
            c7.r r1 = c7.r.f1986a
        L99:
            return r1
        L9a:
            boolean r4 = r5 instanceof s2.a0
            if (r4 == 0) goto L9f
            goto La1
        L9f:
            boolean r3 = r5 instanceof s2.j0
        La1:
            if (r3 == 0) goto Lab
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
            r4.<init>(r5)
            throw r4
        Lab:
            a4.u r4 = new a4.u
            r4.<init>()
            throw r4
        Lb1:
            s2.c0 r5 = (s2.c0) r5
            java.lang.Throwable r4 = r5.f9343b
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.r.emit(java.lang.Object, g7.d):java.lang.Object");
    }
}
