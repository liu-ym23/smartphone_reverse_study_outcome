package p;

/* loaded from: classes.dex */
public final class d0 extends i7.h implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public int f8073g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8074h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g7.l f8075i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ i7.h f8076j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d0(g7.l lVar, p7.n nVar, g7.d dVar) {
        super(2, dVar);
        this.f8075i = lVar;
        this.f8076j = (i7.h) nVar;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [i7.h, p7.n] */
    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        d0 d0Var = new d0(this.f8075i, this.f8076j, dVar);
        d0Var.f8074h = obj;
        return d0Var;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((d0) create((c1.v) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        if (r9 != r0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
    
        if (r9 == r0) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3, types: [c1.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [i7.h, p7.n] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0057 -> B:12:0x0028). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x006c -> B:12:0x0028). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r8.f8073g
            g7.l r2 = r8.f8075i
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L34
            if (r1 == r5) goto L2c
            if (r1 == r4) goto L21
            if (r1 != r3) goto L19
            java.lang.Object r1 = r8.f8074h
            c1.v r1 = (c1.v) r1
            w7.e0.N(r9)
            goto L28
        L19:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L21:
            java.lang.Object r1 = r8.f8074h
            c1.v r1 = (c1.v) r1
            w7.e0.N(r9)     // Catch: java.util.concurrent.CancellationException -> L2a
        L28:
            r9 = r1
            goto L3b
        L2a:
            r9 = move-exception
            goto L5e
        L2c:
            java.lang.Object r1 = r8.f8074h
            c1.v r1 = (c1.v) r1
            w7.e0.N(r9)     // Catch: java.util.concurrent.CancellationException -> L2a
            goto L4f
        L34:
            w7.e0.N(r9)
            java.lang.Object r9 = r8.f8074h
            c1.v r9 = (c1.v) r9
        L3b:
            boolean r1 = ia.d0.p(r2)
            if (r1 == 0) goto L70
            i7.h r1 = r8.f8076j     // Catch: java.util.concurrent.CancellationException -> L5a
            r8.f8074h = r9     // Catch: java.util.concurrent.CancellationException -> L5a
            r8.f8073g = r5     // Catch: java.util.concurrent.CancellationException -> L5a
            java.lang.Object r1 = r1.invoke(r9, r8)     // Catch: java.util.concurrent.CancellationException -> L5a
            if (r1 != r0) goto L4e
            goto L6e
        L4e:
            r1 = r9
        L4f:
            r8.f8074h = r1     // Catch: java.util.concurrent.CancellationException -> L2a
            r8.f8073g = r4     // Catch: java.util.concurrent.CancellationException -> L2a
            java.lang.Object r9 = n7.a.b(r1, r8)     // Catch: java.util.concurrent.CancellationException -> L2a
            if (r9 != r0) goto L28
            goto L6e
        L5a:
            r1 = move-exception
            r7 = r1
            r1 = r9
            r9 = r7
        L5e:
            boolean r6 = ia.d0.p(r2)
            if (r6 == 0) goto L6f
            r8.f8074h = r1
            r8.f8073g = r3
            java.lang.Object r9 = n7.a.b(r1, r8)
            if (r9 != r0) goto L28
        L6e:
            return r0
        L6f:
            throw r9
        L70:
            c7.r r8 = c7.r.f1986a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p.d0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
