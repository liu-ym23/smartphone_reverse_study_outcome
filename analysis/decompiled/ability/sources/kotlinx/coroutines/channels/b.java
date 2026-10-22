package kotlinx.coroutines.channels;

/* loaded from: classes4.dex */
public abstract class b {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(o9.InterfaceC1786l r4, S7.a r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            S7.a r5 = r0.f5192a
            kotlin.b.b(r6)     // Catch: java.lang.Throwable -> L29
            goto L65
        L29:
            r4 = move-exception
            goto L6b
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            H7.h r6 = r0.getContext()
            m9.b0 r2 = m9.b0.f5325a
            H7.f r6 = r6.get(r2)
            if (r6 != r4) goto L6f
            r0.f5192a = r5     // Catch: java.lang.Throwable -> L29
            r0.c = r3     // Catch: java.lang.Throwable -> L29
            m9.k r6 = new m9.k     // Catch: java.lang.Throwable -> L29
            H7.c r0 = U7.a.I(r0)     // Catch: java.lang.Throwable -> L29
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L29
            r6.y()     // Catch: java.lang.Throwable -> L29
            J4.b r0 = new J4.b     // Catch: java.lang.Throwable -> L29
            r2 = 16
            r0.<init>(r6, r2)     // Catch: java.lang.Throwable -> L29
            o9.k r4 = (o9.C1785k) r4     // Catch: java.lang.Throwable -> L29
            r4.j0(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.x()     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L65
            return r1
        L65:
            r5.invoke()
            C7.r r4 = C7.r.f317a
            return r4
        L6b:
            r5.invoke()
            throw r4
        L6f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.b.a(o9.l, S7.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
