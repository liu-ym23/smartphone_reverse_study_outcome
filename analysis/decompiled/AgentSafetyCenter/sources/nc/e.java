package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8836c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ h f8837f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ yb.u f8838g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // nc.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r7, nb.c r8) {
        /*
            r6 = this;
            int r0 = r6.f8836c
            switch(r0) {
                case 0: goto L4f;
                default: goto L5;
            }
        L5:
            boolean r0 = r8 instanceof nc.p
            if (r0 == 0) goto L18
            r0 = r8
            nc.p r0 = (nc.p) r0
            int r1 = r0.f8899h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L18
            int r1 = r1 - r2
            r0.f8899h = r1
            goto L1d
        L18:
            nc.p r0 = new nc.p
            r0.<init>(r6, r8)
        L1d:
            java.lang.Object r8 = r0.f8897f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8899h
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L30
            nc.e r6 = r0.f8896c
            id.c.I(r8)     // Catch: java.lang.Throwable -> L2e
            goto L47
        L2e:
            r7 = move-exception
            goto L4a
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r1 = 0
            goto L49
        L37:
            id.c.I(r8)
            nc.h r8 = r6.f8837f     // Catch: java.lang.Throwable -> L2e
            r0.f8896c = r6     // Catch: java.lang.Throwable -> L2e
            r0.f8899h = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r8.emit(r7, r0)     // Catch: java.lang.Throwable -> L2e
            if (r6 != r1) goto L47
            goto L49
        L47:
            jb.v r1 = jb.v.f6774a
        L49:
            return r1
        L4a:
            yb.u r6 = r6.f8838g
            r6.f16098c = r7
            throw r7
        L4f:
            yb.u r0 = r6.f8838g
            boolean r1 = r8 instanceof nc.d
            if (r1 == 0) goto L64
            r1 = r8
            nc.d r1 = (nc.d) r1
            int r2 = r1.f8834g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L64
            int r2 = r2 - r3
            r1.f8834g = r2
            goto L69
        L64:
            nc.d r1 = new nc.d
            r1.<init>(r6, r8)
        L69:
            java.lang.Object r8 = r1.f8832c
            ob.a r2 = ob.a.f9351c
            int r3 = r1.f8834g
            jb.v r4 = jb.v.f6774a
            r5 = 1
            if (r3 == 0) goto L82
            if (r3 != r5) goto L7b
            id.c.I(r8)
        L79:
            r2 = r4
            goto L9d
        L7b:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r2 = 0
            goto L9d
        L82:
            id.c.I(r8)
            java.lang.Object r8 = r0.f16098c
            pc.t r3 = oc.c.f9367b
            if (r8 == r3) goto L91
            boolean r8 = yb.k.a(r8, r7)
            if (r8 != 0) goto L79
        L91:
            r0.f16098c = r7
            nc.h r6 = r6.f8837f
            r1.f8834g = r5
            java.lang.Object r6 = r6.emit(r7, r1)
            if (r6 != r2) goto L79
        L9d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.e.emit(java.lang.Object, nb.c):java.lang.Object");
    }
}
