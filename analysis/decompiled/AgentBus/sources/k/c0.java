package k;

/* loaded from: classes.dex */
public final class c0 extends i7.h implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public fa.h f5462g;

    /* renamed from: h, reason: collision with root package name */
    public d0 f5463h;

    /* renamed from: i, reason: collision with root package name */
    public long[] f5464i;

    /* renamed from: j, reason: collision with root package name */
    public int f5465j;

    /* renamed from: k, reason: collision with root package name */
    public int f5466k;

    /* renamed from: l, reason: collision with root package name */
    public int f5467l;

    /* renamed from: m, reason: collision with root package name */
    public int f5468m;

    /* renamed from: n, reason: collision with root package name */
    public long f5469n;

    /* renamed from: o, reason: collision with root package name */
    public int f5470o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f5471p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ d0 f5472q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ fa.h f5473r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(d0 d0Var, fa.h hVar, g7.d dVar) {
        super(2, dVar);
        this.f5472q = d0Var;
        this.f5473r = hVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        c0 c0Var = new c0(this.f5472q, this.f5473r, dVar);
        c0Var.f5471p = obj;
        return c0Var;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((c0) create((fa.k) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0052 -> B:22:0x00a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0054 -> B:14:0x0067). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0070 -> B:19:0x0097). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5470o
            r3 = 0
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L2f
            if (r2 != r5) goto L27
            int r2 = r0.f5468m
            int r6 = r0.f5467l
            long r7 = r0.f5469n
            int r9 = r0.f5466k
            int r10 = r0.f5465j
            long[] r11 = r0.f5464i
            k.d0 r12 = r0.f5463h
            fa.h r13 = r0.f5462g
            java.lang.Object r14 = r0.f5471p
            fa.k r14 = (fa.k) r14
            w7.e0.N(r22)
            goto L97
        L27:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2f:
            w7.e0.N(r22)
            java.lang.Object r2 = r0.f5471p
            fa.k r2 = (fa.k) r2
            k.d0 r6 = r0.f5472q
            k.b0 r7 = r6.f5476g
            long[] r7 = r7.f5453a
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto La7
            fa.h r9 = r0.f5473r
            r10 = r3
        L44:
            r11 = r7[r10]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto La2
            int r13 = r10 - r8
            int r13 = ~r13
            int r13 = r13 >>> 31
            int r13 = 8 - r13
            r14 = r2
            r2 = r3
            r19 = r11
            r12 = r6
            r11 = r7
            r6 = r13
            r13 = r9
            r9 = r10
            r10 = r8
            r7 = r19
        L67:
            if (r2 >= r6) goto L9a
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r7
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L97
            int r3 = r9 << 3
            int r3 = r3 + r2
            r13.f3630g = r3
            k.b0 r4 = r12.f5476g
            java.lang.Object[] r4 = r4.f5454b
            r3 = r4[r3]
            r0.f5471p = r14
            r0.f5462g = r13
            r0.f5463h = r12
            r0.f5464i = r11
            r0.f5465j = r10
            r0.f5466k = r9
            r0.f5469n = r7
            r0.f5467l = r6
            r0.f5468m = r2
            r0.f5470o = r5
            r14.d(r3, r0)
            h7.a r0 = h7.a.f4212f
            return r1
        L97:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L67
        L9a:
            if (r6 != r4) goto La7
            r8 = r10
            r7 = r11
            r6 = r12
            r2 = r14
            r10 = r9
            r9 = r13
        La2:
            if (r10 == r8) goto La7
            int r10 = r10 + 1
            goto L44
        La7:
            c7.r r0 = c7.r.f1986a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.c0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
