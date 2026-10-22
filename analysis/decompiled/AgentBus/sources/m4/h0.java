package m4;

/* loaded from: classes.dex */
public final class h0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public q0 f6212f;

    /* renamed from: g, reason: collision with root package name */
    public String f6213g;

    /* renamed from: h, reason: collision with root package name */
    public a6.w f6214h;

    /* renamed from: i, reason: collision with root package name */
    public q0 f6215i;

    /* renamed from: j, reason: collision with root package name */
    public String f6216j;

    /* renamed from: k, reason: collision with root package name */
    public int f6217k;

    /* renamed from: l, reason: collision with root package name */
    public int f6218l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ q0 f6219m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ a6.w f6220n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f6221o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f6222p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(int i2, a6.w wVar, g7.d dVar, String str, q0 q0Var) {
        super(2, dVar);
        this.f6219m = q0Var;
        this.f6220n = wVar;
        this.f6221o = i2;
        this.f6222p = str;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new h0(this.f6221o, this.f6220n, dVar, this.f6222p, this.f6219m);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((h0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b1  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            h7.a r0 = h7.a.f4212f
            int r1 = r12.f6218l
            r2 = 1
            if (r1 == 0) goto L25
            if (r1 != r2) goto L1d
            int r1 = r12.f6217k
            java.lang.String r2 = r12.f6216j
            m4.q0 r3 = r12.f6215i
            a6.w r4 = r12.f6214h
            java.lang.String r5 = r12.f6213g
            m4.q0 r12 = r12.f6212f
            w7.e0.N(r13)     // Catch: java.lang.Throwable -> L19
            goto L72
        L19:
            r0 = move-exception
            r13 = r0
            goto L80
        L1d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L25:
            w7.e0.N(r13)
            java.lang.String r5 = "readCronRunLogs"
            a6.w r13 = a6.w.EDGE
            m4.q0 r3 = r12.f6219m
            a6.w r4 = r12.f6220n
            int r1 = r12.f6221o
            java.lang.String r6 = r12.f6222p
            if (r4 != r13) goto L3b
            java.util.List r12 = m4.q0.Q(r3, r1, r6)
            return r12
        L3b:
            java.util.List r13 = m4.q0.f6311l
            o4.t1 r13 = r3.d0()
            if (r13 != 0) goto L54
            a6.w r12 = a6.w.CLOUD
            if (r4 == r12) goto L4c
            java.util.List r12 = m4.q0.Q(r3, r1, r6)
            return r12
        L4c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "readCronRunLogs: source=CLOUD but cloud OFFLINE"
            r12.<init>(r13)
            throw r12
        L54:
            m4.x r7 = m4.x.f6364a     // Catch: java.lang.Throwable -> L7d
            r12.f6212f = r3     // Catch: java.lang.Throwable -> L7d
            r12.f6213g = r5     // Catch: java.lang.Throwable -> L7d
            r12.f6214h = r4     // Catch: java.lang.Throwable -> L7d
            r12.f6215i = r3     // Catch: java.lang.Throwable -> L7d
            r12.f6216j = r6     // Catch: java.lang.Throwable -> L7d
            r12.f6217k = r1     // Catch: java.lang.Throwable -> L7d
            r12.f6218l = r2     // Catch: java.lang.Throwable -> L7d
            m4.w0 r2 = new m4.w0     // Catch: java.lang.Throwable -> L77
            r2.<init>(r13)     // Catch: java.lang.Throwable -> L77
            java.io.Serializable r13 = r7.m(r2, r1, r6, r12)     // Catch: java.lang.Throwable -> L77
            if (r13 != r0) goto L70
            return r0
        L70:
            r12 = r3
            r2 = r6
        L72:
            java.util.List r13 = (java.util.List) r13     // Catch: java.lang.Throwable -> L19
            goto L84
        L75:
            r13 = r12
            goto L7a
        L77:
            r0 = move-exception
            r12 = r0
            goto L75
        L7a:
            r12 = r3
            r2 = r6
            goto L80
        L7d:
            r0 = move-exception
            r13 = r0
            goto L7a
        L80:
            c7.l r13 = w7.e0.n(r13)
        L84:
            java.lang.Throwable r0 = c7.m.a(r13)
            if (r0 == 0) goto La9
            k5.t r6 = r12.f6315d
            java.lang.String r12 = r0.getMessage()
            a6.w r0 = a6.w.CLOUD
            if (r4 != r0) goto L97
            java.lang.String r0 = "throw (source=CLOUD)"
            goto L99
        L97:
            java.lang.String r0 = "fallback local"
        L99:
            java.lang.String r7 = " cloud RPC failed: "
            java.lang.String r8 = "; "
            java.lang.String r8 = m.x.l(r5, r7, r12, r8, r0)
            r10 = 4
            r11 = 0
            java.lang.String r7 = "OpenClawBackend"
            r9 = 0
            k5.s.info$default(r6, r7, r8, r9, r10, r11)
        La9:
            boolean r12 = r13 instanceof c7.l
            if (r12 != 0) goto Lb1
            w7.e0.N(r13)
            goto Lb9
        Lb1:
            a6.w r12 = a6.w.CLOUD
            if (r4 == r12) goto Lba
            java.util.List r13 = m4.q0.Q(r3, r1, r2)
        Lb9:
            return r13
        Lba:
            java.lang.Throwable r12 = c7.m.a(r13)
            q7.k.b(r12)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.h0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
