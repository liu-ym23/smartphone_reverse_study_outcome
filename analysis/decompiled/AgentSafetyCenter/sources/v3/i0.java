package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends b0 {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r7, pb.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof v3.h0
            if (r0 == 0) goto L13
            r0 = r8
            v3.h0 r0 = (v3.h0) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            v3.h0 r0 = new v3.h0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f14651g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            jb.v r3 = jb.v.f6774a
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L36
            if (r2 != r4) goto L30
            java.io.FileOutputStream r6 = r0.f14650f
            java.io.FileOutputStream r7 = r0.f14649c
            id.c.I(r8)     // Catch: java.lang.Throwable -> L2e
            goto L60
        L2e:
            r6 = move-exception
            goto L6d
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            return r5
        L36:
            id.c.I(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r6.f14609b
            boolean r8 = r8.get()
            if (r8 != 0) goto L73
            java.io.FileOutputStream r8 = new java.io.FileOutputStream
            java.io.File r6 = r6.f14608a
            r8.<init>(r6)
            od.h r6 = new od.h     // Catch: java.lang.Throwable -> L6b
            r6.<init>()     // Catch: java.lang.Throwable -> L6b
            r6.f9451f = r8     // Catch: java.lang.Throwable -> L6b
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L6b
            r0.f14649c = r8     // Catch: java.lang.Throwable -> L6b
            r0.f14650f = r8     // Catch: java.lang.Throwable -> L6b
            r0.i = r4     // Catch: java.lang.Throwable -> L6b
            y3.h.b(r7, r6)     // Catch: java.lang.Throwable -> L6b
            if (r3 != r1) goto L5e
            return r1
        L5e:
            r6 = r8
            r7 = r6
        L60:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L2e
            r6.sync()     // Catch: java.lang.Throwable -> L2e
            t.o.d(r7, r5)
            return r3
        L6b:
            r6 = move-exception
            r7 = r8
        L6d:
            throw r6     // Catch: java.lang.Throwable -> L6e
        L6e:
            r8 = move-exception
            t.o.d(r7, r6)
            throw r8
        L73:
            java.lang.String r6 = "This scope has already been closed."
            od.f.e(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.i0.b(java.lang.Object, pb.c):java.lang.Object");
    }
}
