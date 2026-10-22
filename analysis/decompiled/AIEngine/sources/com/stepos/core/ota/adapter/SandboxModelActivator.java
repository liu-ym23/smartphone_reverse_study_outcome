package com.stepos.core.ota.adapter;

import com.stepos.core.ota.domain.port.ModelActivator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SandboxModelActivator implements ModelActivator {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.port.ModelActivator
    /* renamed from: activate-yxL6bBk */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo115activateyxL6bBk(java.lang.String r10, int r11, java.lang.String r12, java.lang.String r13, qb.b<? super kotlin.Result<lb.n>> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.stepos.core.ota.adapter.SandboxModelActivator$activate$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.core.ota.adapter.SandboxModelActivator$activate$1 r0 = (com.stepos.core.ota.adapter.SandboxModelActivator$activate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.adapter.SandboxModelActivator$activate$1 r0 = new com.stepos.core.ota.adapter.SandboxModelActivator$activate$1
            r0.<init>(r9, r14)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r14 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.c.b(r9)
            goto L49
        L27:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2f:
            kotlin.c.b(r9)
            kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.adapter.SandboxModelActivator$activate$2 r3 = new com.stepos.core.ota.adapter.SandboxModelActivator$activate$2
            r8 = 0
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            r0.label = r2
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r3, r0)
            if (r9 != r14) goto L49
            return r14
        L49:
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r9 = r9.f9987a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.SandboxModelActivator.mo115activateyxL6bBk(java.lang.String, int, java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }
}
