package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends h5.i implements p5.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6419a;

    /* renamed from: b, reason: collision with root package name */
    public int f6420b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ v4.f f6421c;
    public /* synthetic */ Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p5.q f6422e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(p5.q qVar, f5.c cVar, int i8) {
        super(3, cVar);
        this.f6419a = i8;
        this.f6422e = qVar;
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        v4.f fVar = (v4.f) obj;
        f5.c cVar = (f5.c) obj3;
        switch (this.f6419a) {
            case 0:
                b bVar = new b(this.f6422e, cVar, 0);
                bVar.f6421c = fVar;
                bVar.d = obj2;
                return bVar.invokeSuspend(b5.a0.f883a);
            default:
                b bVar2 = new b(this.f6422e, cVar, 1);
                bVar2.f6421c = fVar;
                bVar2.d = obj2;
                return bVar2.invokeSuspend(b5.a0.f883a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = r6.f6419a
            switch(r0) {
                case 0: goto L4c;
                default: goto L5;
            }
        L5:
            g5.a r0 = g5.a.f2984a
            int r1 = r6.f6420b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            a.a.c0(r7)
            goto L49
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1d:
            v4.f r1 = r6.f6421c
            a.a.c0(r7)
            goto L39
        L23:
            a.a.c0(r7)
            v4.f r1 = r6.f6421c
            java.lang.Object r7 = r6.d
            java.lang.Object r4 = r1.f5973a
            r6.f6421c = r1
            r6.f6420b = r3
            p5.q r3 = r6.f6422e
            java.lang.Object r7 = r3.invoke(r4, r7, r6)
            if (r7 != r0) goto L39
            goto L4b
        L39:
            n4.e r7 = (n4.e) r7
            if (r7 == 0) goto L49
            r3 = 0
            r6.f6421c = r3
            r6.f6420b = r2
            java.lang.Object r6 = r1.e(r6, r7)
            if (r6 != r0) goto L49
            goto L4b
        L49:
            b5.a0 r0 = b5.a0.f883a
        L4b:
            return r0
        L4c:
            g5.a r0 = g5.a.f2984a
            int r1 = r6.f6420b
            r2 = 2
            r3 = 1
            b5.a0 r4 = b5.a0.f883a
            if (r1 == 0) goto L6d
            if (r1 == r3) goto L67
            if (r1 != r2) goto L5f
            a.a.c0(r7)
        L5d:
            r0 = r4
            goto L98
        L5f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L67:
            v4.f r1 = r6.f6421c
            a.a.c0(r7)
            goto L88
        L6d:
            a.a.c0(r7)
            v4.f r1 = r6.f6421c
            java.lang.Object r7 = r6.d
            boolean r5 = r7 instanceof n4.e
            if (r5 != 0) goto L79
            goto L5d
        L79:
            java.lang.Object r5 = r1.f5973a
            r6.f6421c = r1
            r6.f6420b = r3
            p5.q r3 = r6.f6422e
            java.lang.Object r7 = r3.invoke(r5, r7, r6)
            if (r7 != r0) goto L88
            goto L98
        L88:
            n4.e r7 = (n4.e) r7
            if (r7 != 0) goto L8d
            goto L5d
        L8d:
            r3 = 0
            r6.f6421c = r3
            r6.f6420b = r2
            java.lang.Object r6 = r1.e(r6, r7)
            if (r6 != r0) goto L5d
        L98:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.b.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
