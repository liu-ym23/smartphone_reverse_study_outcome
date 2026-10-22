package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements g {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ l5.j f8874c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ v3.m f8875f;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // nc.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(nc.h r9, nb.c r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof nc.k
            if (r0 == 0) goto L13
            r0 = r10
            nc.k r0 = (nc.k) r0
            int r1 = r0.f8868f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8868f = r1
            goto L18
        L13:
            nc.k r0 = new nc.k
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f8867c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8868f
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L51
            if (r2 == r5) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L34
            java.lang.Object r8 = r0.f8870h
            oc.u r8 = (oc.u) r8
            id.c.I(r10)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r9 = move-exception
            goto L84
        L34:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            return r6
        L3a:
            java.lang.Object r8 = r0.f8870h
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            id.c.I(r10)
            goto La1
        L42:
            nc.h r9 = r0.i
            java.lang.Object r8 = r0.f8870h
            nc.l r8 = (nc.l) r8
            id.c.I(r10)     // Catch: java.lang.Throwable -> L4c
            goto L63
        L4c:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L88
        L51:
            id.c.I(r10)
            l5.j r10 = r8.f8874c     // Catch: java.lang.Throwable -> L4c
            r0.f8870h = r8     // Catch: java.lang.Throwable -> L4c
            r0.i = r9     // Catch: java.lang.Throwable -> L4c
            r0.f8868f = r5     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L4c
            if (r10 != r1) goto L63
            goto La0
        L63:
            oc.u r10 = new oc.u
            nb.g r2 = r0.getContext()
            r10.<init>(r9, r2)
            v3.m r8 = r8.f8875f     // Catch: java.lang.Throwable -> L82
            r0.f8870h = r10     // Catch: java.lang.Throwable -> L82
            r0.i = r6     // Catch: java.lang.Throwable -> L82
            r0.f8868f = r3     // Catch: java.lang.Throwable -> L82
            java.lang.Object r8 = r8.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L82
            if (r8 != r1) goto L7b
            goto La0
        L7b:
            r8 = r10
        L7c:
            r8.releaseIntercepted()
            jb.v r8 = jb.v.f6774a
            return r8
        L82:
            r9 = move-exception
            r8 = r10
        L84:
            r8.releaseIntercepted()
            throw r9
        L88:
            nc.v0 r10 = new nc.v0
            r10.<init>()
            r10.f8939c = r8
            java.lang.invoke.VarHandle.storeStoreFence()
            v3.m r9 = r9.f8875f
            r0.f8870h = r8
            r0.i = r6
            r0.f8868f = r4
            java.lang.Object r9 = nc.k0.b(r10, r9, r8, r0)
            if (r9 != r1) goto La1
        La0:
            return r1
        La1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.l.collect(nc.h, nb.c):java.lang.Object");
    }
}
