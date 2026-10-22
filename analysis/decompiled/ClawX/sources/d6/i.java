package d6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1874a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0.n f1875b;

    public i(e eVar, j0.n nVar) {
        this.f1874a = eVar;
        this.f1875b = nVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d6.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(d6.c r9, f5.c r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof d6.h
            if (r0 == 0) goto L13
            r0 = r10
            d6.h r0 = (d6.h) r0
            int r1 = r0.f1871b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1871b = r1
            goto L18
        L13:
            d6.h r0 = new d6.h
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f1870a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f1871b
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L53
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r8 = r0.d
            e6.j r8 = (e6.j) r8
            a.a.c0(r10)     // Catch: java.lang.Throwable -> L32
            goto L7e
        L32:
            r9 = move-exception
            goto L86
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            java.lang.Object r8 = r0.d
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            a.a.c0(r10)
            goto L9e
        L44:
            d6.c r9 = r0.f1873e
            java.lang.Object r8 = r0.d
            d6.i r8 = (d6.i) r8
            a.a.c0(r10)     // Catch: java.lang.Throwable -> L4e
            goto L65
        L4e:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L8a
        L53:
            a.a.c0(r10)
            d6.e r10 = r8.f1874a     // Catch: java.lang.Throwable -> L4e
            r0.d = r8     // Catch: java.lang.Throwable -> L4e
            r0.f1873e = r9     // Catch: java.lang.Throwable -> L4e
            r0.f1871b = r5     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L4e
            if (r10 != r1) goto L65
            goto L9d
        L65:
            e6.j r10 = new e6.j
            f5.h r2 = r0.getContext()
            r10.<init>(r9, r2)
            j0.n r8 = r8.f1875b     // Catch: java.lang.Throwable -> L84
            r0.d = r10     // Catch: java.lang.Throwable -> L84
            r0.f1873e = r6     // Catch: java.lang.Throwable -> L84
            r0.f1871b = r3     // Catch: java.lang.Throwable -> L84
            java.lang.Object r8 = r8.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L84
            if (r8 != r1) goto L7d
            goto L9d
        L7d:
            r8 = r10
        L7e:
            r8.releaseIntercepted()
            b5.a0 r8 = b5.a0.f883a
            return r8
        L84:
            r9 = move-exception
            r8 = r10
        L86:
            r8.releaseIntercepted()
            throw r9
        L8a:
            d6.b0 r10 = new d6.b0
            r10.<init>(r8)
            j0.n r9 = r9.f1875b
            r0.d = r8
            r0.f1873e = r6
            r0.f1871b = r4
            java.lang.Object r9 = d6.z.b(r10, r9, r8, r0)
            if (r9 != r1) goto L9e
        L9d:
            return r1
        L9e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.i.collect(d6.c, f5.c):java.lang.Object");
    }
}
