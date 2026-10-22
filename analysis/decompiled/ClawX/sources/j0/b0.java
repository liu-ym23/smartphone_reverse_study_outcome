package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b0 extends h5.i implements p5.p {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.w f3313a;

    /* renamed from: b, reason: collision with root package name */
    public int f3314b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3315c;
    public final /* synthetic */ kotlin.jvm.internal.w d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c0 f3316e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3317f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f3318g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(kotlin.jvm.internal.w wVar, c0 c0Var, Object obj, boolean z, f5.c cVar) {
        super(2, cVar);
        this.d = wVar;
        this.f3316e = c0Var;
        this.f3317f = obj;
        this.f3318g = z;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        b0 b0Var = new b0(this.d, this.f3316e, this.f3317f, this.f3318g, cVar);
        b0Var.f3315c = obj;
        return b0Var;
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        return ((b0) create((l0) obj, (f5.c) obj2)).invokeSuspend(b5.a0.f883a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        if (r6.b(r2, r7) == r0) goto L16;
     */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            g5.a r0 = g5.a.f2984a
            int r1 = r7.f3314b
            java.lang.Object r2 = r7.f3317f
            j0.c0 r3 = r7.f3316e
            kotlin.jvm.internal.w r4 = r7.d
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L28
            if (r1 == r6) goto L1e
            if (r1 != r5) goto L16
            a.a.c0(r8)
            goto L65
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1e:
            kotlin.jvm.internal.w r1 = r7.f3313a
            java.lang.Object r6 = r7.f3315c
            j0.l0 r6 = (j0.l0) r6
            a.a.c0(r8)
            goto L4f
        L28:
            a.a.c0(r8)
            java.lang.Object r8 = r7.f3315c
            j0.l0 r8 = (j0.l0) r8
            j0.u0 r1 = r3.g()
            r7.f3315c = r8
            r7.f3313a = r4
            r7.f3314b = r6
            androidx.emoji2.text.m r1 = r1.f3443b
            java.lang.Object r1 = r1.f621a
            java.util.concurrent.atomic.AtomicInteger r1 = (java.util.concurrent.atomic.AtomicInteger) r1
            int r1 = r1.incrementAndGet()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r1)
            if (r6 != r0) goto L4b
            goto L64
        L4b:
            r1 = r6
            r6 = r8
            r8 = r1
            r1 = r4
        L4f:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r1.f3684a = r8
            r8 = 0
            r7.f3315c = r8
            r7.f3313a = r8
            r7.f3314b = r5
            java.lang.Object r8 = r6.b(r2, r7)
            if (r8 != r0) goto L65
        L64:
            return r0
        L65:
            boolean r7 = r7.f3318g
            if (r7 == 0) goto L7d
            androidx.emoji2.text.m r7 = r3.f3327h
            j0.c r8 = new j0.c
            if (r2 == 0) goto L74
            int r0 = r2.hashCode()
            goto L75
        L74:
            r0 = 0
        L75:
            int r1 = r4.f3684a
            r8.<init>(r2, r0, r1)
            r7.q(r8)
        L7d:
            b5.a0 r7 = b5.a0.f883a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.b0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
