package kotlinx.coroutines.flow;

/* loaded from: classes4.dex */
public abstract class a implements p9.c {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v4, types: [S7.n, kotlin.coroutines.jvm.internal.SuspendLambda] */
    @Override // p9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(p9.d r6, H7.c r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.AbstractFlow$collect$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = (kotlinx.coroutines.flow.AbstractFlow$collect$1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = new kotlinx.coroutines.flow.AbstractFlow$collect$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            C7.r r3 = C7.r.f317a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            kotlinx.coroutines.flow.internal.SafeCollector r5 = r0.f5195a
            kotlin.b.b(r7)     // Catch: java.lang.Throwable -> L2b
            goto L55
        L2b:
            r6 = move-exception
            goto L61
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.b.b(r7)
            kotlinx.coroutines.flow.internal.SafeCollector r7 = new kotlinx.coroutines.flow.internal.SafeCollector
            H7.h r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f5195a = r7     // Catch: java.lang.Throwable -> L5f
            r0.d = r4     // Catch: java.lang.Throwable -> L5f
            p9.m r5 = (p9.m) r5     // Catch: java.lang.Throwable -> L5b
            kotlin.coroutines.jvm.internal.SuspendLambda r5 = r5.f5563a     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r5 = r5.invoke(r7, r0)     // Catch: java.lang.Throwable -> L5b
            if (r5 != r1) goto L50
            goto L51
        L50:
            r5 = r3
        L51:
            if (r5 != r1) goto L54
            return r1
        L54:
            r5 = r7
        L55:
            r5.releaseIntercepted()
            return r3
        L59:
            r6 = r5
            goto L5d
        L5b:
            r5 = move-exception
            goto L59
        L5d:
            r5 = r7
            goto L61
        L5f:
            r6 = move-exception
            goto L5d
        L61:
            r5.releaseIntercepted()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.a.collect(p9.d, H7.c):java.lang.Object");
    }
}
