package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l0 extends e0 {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r6, h5.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof j0.k0
            if (r0 == 0) goto L13
            r0 = r7
            j0.k0 r0 = (j0.k0) r0
            int r1 = r0.f3387e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3387e = r1
            goto L18
        L13:
            j0.k0 r0 = new j0.k0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f3386c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3387e
            b5.a0 r3 = b5.a0.f883a
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.io.FileOutputStream r5 = r0.f3385b
            java.io.FileOutputStream r6 = r0.f3384a
            a.a.c0(r7)     // Catch: java.lang.Throwable -> L2d
            goto L5e
        L2d:
            r5 = move-exception
            goto L6c
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            a.a.c0(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r5.f3341b
            boolean r7 = r7.get()
            if (r7 != 0) goto L72
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r5 = r5.f3340a
            r7.<init>(r5)
            m0.h r5 = m0.h.f3893a     // Catch: java.lang.Throwable -> L6a
            j0.x0 r2 = new j0.x0     // Catch: java.lang.Throwable -> L6a
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L6a
            r0.f3384a = r7     // Catch: java.lang.Throwable -> L6a
            r0.f3385b = r7     // Catch: java.lang.Throwable -> L6a
            r0.f3387e = r4     // Catch: java.lang.Throwable -> L6a
            r5.b(r6, r2)     // Catch: java.lang.Throwable -> L6a
            if (r3 != r1) goto L5c
            return r1
        L5c:
            r5 = r7
            r6 = r5
        L5e:
            java.io.FileDescriptor r5 = r5.getFD()     // Catch: java.lang.Throwable -> L2d
            r5.sync()     // Catch: java.lang.Throwable -> L2d
            r5 = 0
            k4.z.h(r6, r5)
            return r3
        L6a:
            r5 = move-exception
            r6 = r7
        L6c:
            throw r5     // Catch: java.lang.Throwable -> L6d
        L6d:
            r7 = move-exception
            k4.z.h(r6, r5)
            throw r7
        L72:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "This scope has already been closed."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.l0.b(java.lang.Object, h5.c):java.lang.Object");
    }
}
