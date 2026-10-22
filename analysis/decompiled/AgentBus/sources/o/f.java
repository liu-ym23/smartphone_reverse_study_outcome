package o;

/* loaded from: classes.dex */
public final class f extends i7.h implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public int f7043g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7044h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g f7045i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, g7.d dVar) {
        super(2, dVar);
        this.f7045i = gVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        f fVar = new f(this.f7045i, dVar);
        fVar.f7044h = obj;
        return fVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((f) create((c1.v) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (r13 == r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r13 != r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        return r0;
     */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0057 -> B:17:0x005a). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r12.f7043g
            r2 = 2
            o.g r3 = r12.f7045i
            r4 = 1
            if (r1 == 0) goto L26
            if (r1 == r4) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r12.f7044h
            c1.v r1 = (c1.v) r1
            w7.e0.N(r13)
            goto L5a
        L16:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1e:
            java.lang.Object r1 = r12.f7044h
            c1.v r1 = (c1.v) r1
            w7.e0.N(r13)
            goto L39
        L26:
            w7.e0.N(r13)
            java.lang.Object r13 = r12.f7044h
            r1 = r13
            c1.v r1 = (c1.v) r1
            r12.f7044h = r1
            r12.f7043g = r4
            java.lang.Object r13 = p.d1.b(r1, r12, r2)
            if (r13 != r0) goto L39
            goto L59
        L39:
            c1.l r13 = (c1.l) r13
            long r4 = r13.f1804a
            c1.k r6 = new c1.k
            r6.<init>(r4)
            r3.f7054l = r6
            long r4 = r13.f1806c
            t0.b r13 = new t0.b
            r13.<init>(r4)
            r3.f7048f = r13
        L4d:
            r12.f7044h = r1
            r12.f7043g = r2
            c1.g r13 = c1.g.f1798g
            java.lang.Object r13 = r1.b(r13, r12)
            if (r13 != r0) goto L5a
        L59:
            return r0
        L5a:
            c1.f r13 = (c1.f) r13
            java.lang.Object r13 = r13.f1795a
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r13.size()
            r4.<init>(r5)
            int r5 = r13.size()
            r6 = 0
            r7 = r6
        L6d:
            if (r7 >= r5) goto L80
            java.lang.Object r8 = r13.get(r7)
            r9 = r8
            c1.l r9 = (c1.l) r9
            boolean r9 = r9.f1807d
            if (r9 == 0) goto L7d
            r4.add(r8)
        L7d:
            int r7 = r7 + 1
            goto L6d
        L80:
            int r13 = r4.size()
        L84:
            r5 = 0
            if (r6 >= r13) goto L9e
            java.lang.Object r7 = r4.get(r6)
            r8 = r7
            c1.l r8 = (c1.l) r8
            long r8 = r8.f1804a
            c1.k r10 = r3.f7054l
            if (r10 != 0) goto L95
            goto L9b
        L95:
            long r10 = r10.f1803a
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L9f
        L9b:
            int r6 = r6 + 1
            goto L84
        L9e:
            r7 = r5
        L9f:
            c1.l r7 = (c1.l) r7
            if (r7 != 0) goto Laa
            java.lang.Object r13 = d7.r.P0(r4)
            r7 = r13
            c1.l r7 = (c1.l) r7
        Laa:
            if (r7 == 0) goto Lbe
            long r8 = r7.f1804a
            c1.k r13 = new c1.k
            r13.<init>(r8)
            r3.f7054l = r13
            long r6 = r7.f1806c
            t0.b r13 = new t0.b
            r13.<init>(r6)
            r3.f7048f = r13
        Lbe:
            boolean r13 = r4.isEmpty()
            if (r13 == 0) goto L4d
            r3.f7054l = r5
            c7.r r12 = c7.r.f1986a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: o.f.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
