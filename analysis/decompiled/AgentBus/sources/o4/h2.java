package o4;

/* loaded from: classes.dex */
public final class h2 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f7380f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7381g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t2 f7382h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7383i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7384j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f7385k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f7386l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h2(t2 t2Var, int i2, int i10, String str, String str2, g7.d dVar) {
        super(2, dVar);
        this.f7382h = t2Var;
        this.f7383i = i2;
        this.f7384j = i10;
        this.f7385k = str;
        this.f7386l = str2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        h2 h2Var = new h2(this.f7382h, this.f7383i, this.f7384j, this.f7385k, this.f7386l, dVar);
        h2Var.f7381g = obj;
        return h2Var;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((h2) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x001d, B:21:0x004a, B:23:0x0050, B:25:0x0058, B:27:0x0063), top: B:34:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r17
            ia.z r1 = ia.z.f5027g
            java.lang.String r2 = r0.f7385k
            o4.t2 r3 = r0.f7382h
            java.util.concurrent.ConcurrentHashMap r4 = r3.f7612k
            o4.u r5 = r3.f7602a
            java.lang.String r6 = "renew deferred run end watch runId="
            h7.a r7 = h7.a.f4212f
            int r8 = r0.f7380f
            java.lang.String r9 = r0.f7386l
            r10 = 1
            if (r8 == 0) goto L2c
            if (r8 != r10) goto L24
            java.lang.Object r7 = r0.f7381g
            ia.b0 r7 = (ia.b0) r7
            w7.e0.N(r18)     // Catch: java.lang.Throwable -> L21
            goto L41
        L21:
            r0 = move-exception
            goto La8
        L24:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2c:
            w7.e0.N(r18)
            java.lang.Object r8 = r0.f7381g
            ia.b0 r8 = (ia.b0) r8
            r0.f7381g = r8     // Catch: java.lang.Throwable -> La6
            r0.f7380f = r10     // Catch: java.lang.Throwable -> La6
            r11 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r11 = ia.d0.g(r11, r0)     // Catch: java.lang.Throwable -> La6
            if (r11 != r7) goto L40
            return r7
        L40:
            r7 = r8
        L41:
            int r8 = r0.f7384j
            int r0 = r0.f7383i
            if (r0 < r8) goto L49
            r11 = r10
            goto L4a
        L49:
            r11 = 0
        L4a:
            c5.b r12 = r5.t(r2, r11)     // Catch: java.lang.Throwable -> L21
            if (r12 == 0) goto L56
            ia.j1 r0 = r3.f7606e     // Catch: java.lang.Throwable -> L21
            r0.invoke(r12)     // Catch: java.lang.Throwable -> L21
            goto L94
        L56:
            if (r11 != 0) goto L94
            r5.getClass()     // Catch: java.lang.Throwable -> L21
            java.util.Map r5 = r5.B     // Catch: java.lang.Throwable -> L21
            boolean r5 = r5.containsKey(r2)     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L94
            k5.t r11 = r3.f7605d     // Catch: java.lang.Throwable -> L21
            java.lang.String r12 = "OpenClawStreamRecovery"
            r5 = 20
            java.lang.String r5 = ga.k.L0(r5, r2)     // Catch: java.lang.Throwable -> L21
            int r0 = r0 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21
            r10.<init>(r6)     // Catch: java.lang.Throwable -> L21
            r10.append(r5)     // Catch: java.lang.Throwable -> L21
            java.lang.String r5 = " renew="
            r10.append(r5)     // Catch: java.lang.Throwable -> L21
            r10.append(r0)     // Catch: java.lang.Throwable -> L21
            java.lang.String r5 = "/"
            r10.append(r5)     // Catch: java.lang.Throwable -> L21
            r10.append(r8)     // Catch: java.lang.Throwable -> L21
            java.lang.String r13 = r10.toString()     // Catch: java.lang.Throwable -> L21
            r15 = 4
            r16 = 0
            r14 = 0
            k5.s.info$default(r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L21
            r3.d(r0, r2)     // Catch: java.lang.Throwable -> L21
        L94:
            g7.l r0 = r7.k()
            g7.j r0 = r0.o(r1)
            java.util.Map r1 = q7.z.a(r4)
            r1.remove(r9, r0)
            c7.r r0 = c7.r.f1986a
            return r0
        La6:
            r0 = move-exception
            r7 = r8
        La8:
            g7.l r2 = r7.k()
            g7.j r1 = r2.o(r1)
            java.util.Map r2 = q7.z.a(r4)
            r2.remove(r9, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.h2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
