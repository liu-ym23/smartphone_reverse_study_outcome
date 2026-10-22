package p;

import b0.f2;

/* loaded from: classes.dex */
public final class k extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8131f = 1;

    /* renamed from: g, reason: collision with root package name */
    public int f8132g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f8133h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f8134i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f8135j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(int i2, g7.d dVar, x4.i iVar) {
        super(2, dVar);
        this.f8135j = iVar;
        this.f8133h = i2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f8131f) {
            case 0:
                return new k((a4.p) this.f8134i, this.f8133h, (f2) this.f8135j, dVar);
            default:
                k kVar = new k(this.f8133h, dVar, (x4.i) this.f8135j);
                kVar.f8134i = obj;
                return kVar;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f8131f) {
        }
        return ((k) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            int r0 = r9.f8131f
            switch(r0) {
                case 0: goto L72;
                default: goto L5;
            }
        L5:
            h7.a r0 = h7.a.f4212f
            int r1 = r9.f8132g
            r2 = 1
            if (r1 == 0) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r9.f8134i
            ia.b0 r1 = (ia.b0) r1
            w7.e0.N(r10)
            goto L45
        L16:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1e:
            w7.e0.N(r10)
            java.lang.Object r10 = r9.f8134i
            ia.b0 r10 = (ia.b0) r10
            r1 = r10
        L26:
            boolean r10 = ia.d0.q(r1)
            if (r10 == 0) goto L6f
            java.lang.Object r10 = r9.f8135j
            x4.i r10 = (x4.i) r10
            boolean r10 = r10.f11196p
            if (r10 == 0) goto L6f
            int r10 = r9.f8133h
            long r3 = (long) r10
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            r9.f8134i = r1
            r9.f8132g = r2
            java.lang.Object r10 = ia.d0.g(r3, r9)
            if (r10 != r0) goto L45
            goto L71
        L45:
            java.lang.Object r10 = r9.f8135j
            x4.i r10 = (x4.i) r10
            boolean r10 = r10.f11196p
            if (r10 == 0) goto L6f
            java.lang.Object r10 = r9.f8135j
            x4.i r10 = (x4.i) r10
            x4.k r10 = r10.f11190j
            if (r10 == 0) goto L26
            l4.h r3 = l4.i.p()
            com.google.protobuf.i2 r3 = r3.build()
            l4.i r3 = (l4.i) r3
            com.google.protobuf.l r3 = r3.toByteString()
            com.google.protobuf.k r3 = (com.google.protobuf.k) r3
            java.lang.String r4 = "Heartbeat"
            byte[] r3 = s7.a.W(r4, r3)
            r10.c(r3)
            goto L26
        L6f:
            c7.r r0 = c7.r.f1986a
        L71:
            return r0
        L72:
            h7.a r0 = h7.a.f4212f
            int r1 = r9.f8132g
            r2 = 1
            if (r1 == 0) goto L87
            if (r1 != r2) goto L7f
            w7.e0.N(r10)
            goto Lb8
        L7f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L87:
            w7.e0.N(r10)
            java.lang.Object r10 = r9.f8134i
            a4.p r10 = (a4.p) r10
            java.lang.Object r1 = r10.f194h
            r5 = r1
            o.p0 r5 = (o.p0) r5
            java.lang.Object r1 = r10.f193g
            r7 = r1
            p.l r7 = (p.l) r7
            int r4 = r9.f8133h
            b0.f2 r6 = new b0.f2
            java.lang.Object r1 = r9.f8135j
            b0.f2 r1 = (b0.f2) r1
            r3 = 0
            r8 = 12
            r6.<init>(r10, r1, r3, r8)
            r9.f8132g = r2
            r5.getClass()
            o.o0 r3 = new o.o0
            r8 = 0
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r9 = ia.d0.f(r3, r9)
            if (r9 != r0) goto Lb8
            goto Lba
        Lb8:
            c7.r r0 = c7.r.f1986a
        Lba:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(a4.p pVar, int i2, f2 f2Var, g7.d dVar) {
        super(2, dVar);
        this.f8134i = pVar;
        this.f8133h = i2;
        this.f8135j = f2Var;
    }
}
