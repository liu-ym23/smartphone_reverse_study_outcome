package la;

/* loaded from: classes.dex */
public final class g implements k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5919f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5920g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5921h;

    public /* synthetic */ g(int i2, Object obj, Object obj2) {
        this.f5919f = i2;
        this.f5921h = obj;
        this.f5920g = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(int r6, g7.d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof la.p0
            if (r0 == 0) goto L13
            r0 = r7
            la.p0 r0 = (la.p0) r0
            int r1 = r0.f5979h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5979h = r1
            goto L18
        L13:
            la.p0 r0 = new la.p0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f5977f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5979h
            c7.r r3 = c7.r.f1986a
            r4 = 1
            if (r2 == 0) goto L31
            if (r2 != r4) goto L29
            w7.e0.N(r7)
            return r3
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            w7.e0.N(r7)
            if (r6 <= 0) goto L4f
            java.lang.Object r6 = r5.f5921h
            q7.r r6 = (q7.r) r6
            boolean r7 = r6.f8816f
            if (r7 != 0) goto L4f
            r6.f8816f = r4
            java.lang.Object r5 = r5.f5920g
            la.k r5 = (la.k) r5
            la.m0 r6 = la.m0.f5958f
            r0.f5979h = r4
            java.lang.Object r5 = r5.emit(r6, r0)
            if (r5 != r1) goto L4f
            return r1
        L4f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: la.g.a(int, g7.d):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        if (r10 == r8) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c9, code lost:
    
        if (r11.l(r2, r3, "STEPCLAW_TRANSPORT_ERROR", r5, true, r7) == r8) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cb, code lost:
    
        return r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(c5.b r11, g7.d r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof q5.h
            if (r0 == 0) goto L14
            r0 = r12
            q5.h r0 = (q5.h) r0
            int r1 = r0.f8691j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f8691j = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            q5.h r0 = new q5.h
            r0.<init>(r10, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r7.f8689h
            h7.a r8 = h7.a.f4212f
            int r0 = r7.f8691j
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L42
            if (r0 == r2) goto L35
            if (r0 != r1) goto L2d
            w7.e0.N(r12)
            goto Lcc
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            c5.b r11 = r7.f8688g
            la.g r10 = r7.f8687f
            w7.e0.N(r12)     // Catch: java.lang.Throwable -> L3e java.util.concurrent.CancellationException -> L5a
            goto Lcc
        L3e:
            r0 = move-exception
            r12 = r0
            r2 = r11
            goto L5d
        L42:
            w7.e0.N(r12)
            java.lang.Object r12 = r10.f5921h     // Catch: java.lang.Throwable -> L3e java.util.concurrent.CancellationException -> L5a
            q5.q r12 = (q5.q) r12     // Catch: java.lang.Throwable -> L3e java.util.concurrent.CancellationException -> L5a
            java.lang.Object r0 = r10.f5920g     // Catch: java.lang.Throwable -> L3e java.util.concurrent.CancellationException -> L5a
            d5.e r0 = (d5.e) r0     // Catch: java.lang.Throwable -> L3e java.util.concurrent.CancellationException -> L5a
            r7.f8687f = r10     // Catch: java.lang.Throwable -> L3e java.util.concurrent.CancellationException -> L5a
            r7.f8688g = r11     // Catch: java.lang.Throwable -> L3e java.util.concurrent.CancellationException -> L5a
            r7.f8691j = r2     // Catch: java.lang.Throwable -> L3e java.util.concurrent.CancellationException -> L5a
            java.lang.Object r10 = r12.i(r11, r0, r7)     // Catch: java.lang.Throwable -> L3e java.util.concurrent.CancellationException -> L5a
            if (r10 != r8) goto Lcc
            goto Lcb
        L5a:
            r0 = move-exception
            r10 = r0
            goto Lcf
        L5d:
            java.lang.Object r11 = r10.f5921h
            q5.q r11 = (q5.q) r11
            k5.t r11 = r11.f8755i
            java.lang.Object r0 = r10.f5920g
            d5.e r0 = (d5.e) r0
            java.lang.String r0 = r0.getId()
            java.lang.String r3 = r2.b()
            java.lang.String r4 = r2.d()
            if (r4 != 0) goto L79
            java.lang.String r4 = r2.a()
        L79:
            java.lang.String r5 = " id="
            java.lang.String r6 = " method="
            java.lang.String r9 = "handle failed for "
            java.lang.StringBuilder r0 = a1.a.p(r9, r0, r5, r3, r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            k5.g r11 = (k5.g) r11
            java.lang.String r3 = "Dispatcher"
            r11.a(r3, r0, r12)
            java.lang.String r11 = r2.f1896a
            java.lang.String r0 = "req"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto La7
            java.lang.String r11 = r2.a()
            java.lang.String r0 = "node.invoke.request"
            boolean r11 = q7.k.a(r11, r0)
            if (r11 == 0) goto Lcc
        La7:
            java.lang.Object r11 = r10.f5921h
            q5.q r11 = (q5.q) r11
            java.lang.Object r10 = r10.f5920g
            r3 = r10
            d5.e r3 = (d5.e) r3
            java.lang.String r10 = r12.getMessage()
            java.lang.String r12 = "handle failed: "
            java.lang.String r5 = a1.a.w(r12, r10)
            r10 = 0
            r7.f8687f = r10
            r7.f8688g = r10
            r7.f8691j = r1
            java.lang.String r4 = "STEPCLAW_TRANSPORT_ERROR"
            r6 = 1
            r1 = r11
            java.lang.Object r10 = r1.l(r2, r3, r4, r5, r6, r7)
            if (r10 != r8) goto Lcc
        Lcb:
            return r8
        Lcc:
            c7.r r10 = c7.r.f1986a
            return r10
        Lcf:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: la.g.b(c5.b, g7.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01e2  */
    @Override // la.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r12, g7.d r13) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: la.g.emit(java.lang.Object, g7.d):java.lang.Object");
    }

    public /* synthetic */ g(int i2, Object obj, Object obj2, boolean z4) {
        this.f5919f = i2;
        this.f5920g = obj;
        this.f5921h = obj2;
    }

    public g(h hVar, q7.v vVar, k kVar) {
        this.f5919f = 0;
        this.f5921h = vVar;
        this.f5920g = kVar;
    }
}
