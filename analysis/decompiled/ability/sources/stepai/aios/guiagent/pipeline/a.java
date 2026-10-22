package stepai.aios.guiagent.pipeline;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6109a;

    public a() {
        this.f6109a = new ConcurrentHashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b4, code lost:
    
        if (r13.b(r12, r7) != r1) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r12, java.lang.String r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.a.a(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x013a A[PHI: r1 r2 r6
      0x013a: PHI (r1v4 za.e) = (r1v3 za.e), (r1v10 za.e) binds: [B:56:0x0137, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x013a: PHI (r2v17 java.lang.Object) = (r2v16 java.lang.Object), (r2v1 java.lang.Object) binds: [B:56:0x0137, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x013a: PHI (r6v25 java.lang.String) = (r6v24 java.lang.String), (r6v27 java.lang.String) binds: [B:56:0x0137, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r27, kotlin.coroutines.jvm.internal.ContinuationImpl r28) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.a.b(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
    
        if (r10 == r1) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0, types: [stepai.aios.guiagent.pipeline.a] */
    /* JADX WARN: Type inference failed for: r7v1, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r7v10, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r9v0, types: [S7.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(int r8, S7.k r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof stepai.aios.guiagent.pipeline.PerDisplayUiLockProvider$withLock$1
            if (r0 == 0) goto L13
            r0 = r10
            stepai.aios.guiagent.pipeline.PerDisplayUiLockProvider$withLock$1 r0 = (stepai.aios.guiagent.pipeline.PerDisplayUiLockProvider$withLock$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            stepai.aios.guiagent.pipeline.PerDisplayUiLockProvider$withLock$1 r0 = new stepai.aios.guiagent.pipeline.PerDisplayUiLockProvider$withLock$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.g
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            w9.a r7 = r0.d
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L2e
            goto L96
        L2e:
            r8 = move-exception
            goto L9a
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            int r7 = r0.b
            int r8 = r0.f6108a
            w9.a r9 = r0.d
            kotlin.coroutines.jvm.internal.SuspendLambda r2 = r0.c
            S7.k r2 = (S7.k) r2
            kotlin.b.b(r10)
            r6 = r8
            r8 = r7
            r7 = r9
        L49:
            r9 = r6
            goto L85
        L4b:
            kotlin.b.b(r10)
            java.lang.Object r7 = r7.f6109a
            java.util.concurrent.ConcurrentHashMap r7 = (java.util.concurrent.ConcurrentHashMap) r7
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)
            java.lang.Object r2 = r7.get(r10)
            if (r2 != 0) goto L69
            kotlinx.coroutines.sync.a r2 = new kotlinx.coroutines.sync.a
            r2.<init>()
            java.lang.Object r7 = r7.putIfAbsent(r10, r2)
            if (r7 != 0) goto L68
            goto L69
        L68:
            r2 = r7
        L69:
            w9.a r2 = (w9.InterfaceC2108a) r2
            r7 = r9
            kotlin.coroutines.jvm.internal.SuspendLambda r7 = (kotlin.coroutines.jvm.internal.SuspendLambda) r7
            r0.c = r7
            r0.d = r2
            r0.f6108a = r8
            r7 = 0
            r0.b = r7
            r0.g = r4
            java.lang.Object r10 = r2.lock(r5, r0)
            if (r10 != r1) goto L80
            goto L95
        L80:
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r9
            goto L49
        L85:
            r0.c = r5     // Catch: java.lang.Throwable -> L2e
            r0.d = r7     // Catch: java.lang.Throwable -> L2e
            r0.f6108a = r9     // Catch: java.lang.Throwable -> L2e
            r0.b = r8     // Catch: java.lang.Throwable -> L2e
            r0.g = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r10 = r2.invoke(r0)     // Catch: java.lang.Throwable -> L2e
            if (r10 != r1) goto L96
        L95:
            return r1
        L96:
            r7.unlock(r5)
            return r10
        L9a:
            r7.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.a.c(int, S7.k, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public a(b bVar) {
        this.f6109a = bVar;
    }
}
