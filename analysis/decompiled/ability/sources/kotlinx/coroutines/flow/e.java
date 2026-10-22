package kotlinx.coroutines.flow;

import o9.InterfaceC1786l;

/* loaded from: classes4.dex */
public final class e implements p9.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1786l f5225a;

    public e(InterfaceC1786l interfaceC1786l) {
        this.f5225a = interfaceC1786l;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r5, H7.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f5203a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r6)
            goto L45
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r6)
            if (r5 != 0) goto L36
            a5.d r5 = q9.b.b
        L36:
            r0.c = r3
            o9.l r4 = r4.f5225a
            o9.k r4 = (o9.C1785k) r4
            kotlinx.coroutines.channels.a r4 = r4.d
            java.lang.Object r4 = r4.p(r0, r5)
            if (r4 != r1) goto L45
            return r1
        L45:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.e.emit(java.lang.Object, H7.c):java.lang.Object");
    }
}
