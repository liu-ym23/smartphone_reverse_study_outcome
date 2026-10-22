package a3;

/* loaded from: classes2.dex */
public abstract class r {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v0, types: [a3.t] */
    /* JADX WARN: Type inference failed for: r5v0, types: [U.b, kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r5v5, types: [kotlin.jvm.functions.Function0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(a3.t r4, U.b r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof a3.C0172q
            if (r0 == 0) goto L13
            r0 = r6
            a3.q r0 = (a3.C0172q) r0
            int r1 = r0.f2321c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2321c = r1
            goto L18
        L13:
            a3.q r0 = new a3.q
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f2320b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2321c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlin.jvm.functions.Function0 r5 = r0.f2319a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L2b
            goto L72
        L2b:
            r4 = move-exception
            goto L78
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.get$context()
            Z2.n0 r2 = Z2.n0.f2230a
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            if (r6 != r4) goto L7c
            r0.getClass()     // Catch: java.lang.Throwable -> L2b
            r0.f2319a = r5     // Catch: java.lang.Throwable -> L2b
            r0.f2321c = r3     // Catch: java.lang.Throwable -> L2b
            Z2.h r6 = new Z2.h     // Catch: java.lang.Throwable -> L2b
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)     // Catch: java.lang.Throwable -> L2b
            r6.<init>(r3, r2)     // Catch: java.lang.Throwable -> L2b
            r6.u()     // Catch: java.lang.Throwable -> L2b
            S.s r2 = new S.s     // Catch: java.lang.Throwable -> L2b
            r3 = 5
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L2b
            a3.j r4 = (a3.AbstractC0165j) r4     // Catch: java.lang.Throwable -> L2b
            r4.p(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r4 = r6.t()     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch: java.lang.Throwable -> L2b
            if (r4 != r6) goto L6f
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch: java.lang.Throwable -> L2b
        L6f:
            if (r4 != r1) goto L72
            return r1
        L72:
            r5.invoke()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L78:
            r5.invoke()
            throw r4
        L7c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.r.a(a3.t, U.b, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
