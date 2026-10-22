package d6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1888a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1889b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1890c;
    public final h5.i d;

    public m(kotlin.jvm.internal.v vVar, c cVar, o4.e eVar) {
        this.f1889b = vVar;
        this.f1890c = cVar;
        this.d = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    @Override // d6.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, f5.c r9) {
        /*
            r7 = this;
            int r0 = r7.f1888a
            switch(r0) {
                case 0: goto L1b;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r7.f1889b
            f5.h r0 = (f5.h) r0
            h5.i r1 = r7.d
            c4.c r1 = (c4.c) r1
            java.lang.Object r7 = r7.f1890c
            java.lang.Object r7 = e6.i.a(r0, r8, r7, r1, r9)
            g5.a r8 = g5.a.f2984a
            if (r7 != r8) goto L18
            goto L1a
        L18:
            b5.a0 r7 = b5.a0.f883a
        L1a:
            return r7
        L1b:
            boolean r0 = r9 instanceof d6.l
            if (r0 == 0) goto L2e
            r0 = r9
            d6.l r0 = (d6.l) r0
            int r1 = r0.f1887e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L2e
            int r1 = r1 - r2
            r0.f1887e = r1
            goto L33
        L2e:
            d6.l r0 = new d6.l
            r0.<init>(r7, r9)
        L33:
            java.lang.Object r9 = r0.f1886c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f1887e
            r3 = 3
            r4 = 2
            b5.a0 r5 = b5.a0.f883a
            r6 = 1
            if (r2 == 0) goto L5b
            if (r2 == r6) goto L46
            if (r2 == r4) goto L53
            if (r2 != r3) goto L4b
        L46:
            a.a.c0(r9)
        L49:
            r1 = r5
            goto La3
        L4b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L53:
            java.lang.Object r8 = r0.f1885b
            d6.m r7 = r0.f1884a
            a.a.c0(r9)
            goto L84
        L5b:
            a.a.c0(r9)
            java.lang.Object r9 = r7.f1889b
            kotlin.jvm.internal.v r9 = (kotlin.jvm.internal.v) r9
            boolean r9 = r9.f3683a
            if (r9 == 0) goto L73
            java.lang.Object r7 = r7.f1890c
            d6.c r7 = (d6.c) r7
            r0.f1887e = r6
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L49
            goto La3
        L73:
            h5.i r9 = r7.d
            o4.e r9 = (o4.e) r9
            r0.f1884a = r7
            r0.f1885b = r8
            r0.f1887e = r4
            java.lang.Object r9 = r9.invoke(r8, r0)
            if (r9 != r1) goto L84
            goto La3
        L84:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L49
            java.lang.Object r9 = r7.f1889b
            kotlin.jvm.internal.v r9 = (kotlin.jvm.internal.v) r9
            r9.f3683a = r6
            java.lang.Object r7 = r7.f1890c
            d6.c r7 = (d6.c) r7
            r9 = 0
            r0.f1884a = r9
            r0.f1885b = r9
            r0.f1887e = r3
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L49
        La3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.m.emit(java.lang.Object, f5.c):java.lang.Object");
    }

    public m(c cVar, f5.h hVar) {
        this.f1889b = hVar;
        this.f1890c = f6.a.m(hVar);
        this.d = new c4.c(cVar, 1, (f5.c) null);
    }
}
