package p9;

import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes4.dex */
public final class g implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5559a = 0;
    public final /* synthetic */ c b;
    public final /* synthetic */ SuspendLambda c;

    /* JADX WARN: Multi-variable type inference failed */
    public g(c cVar, S7.n nVar) {
        this.b = cVar;
        this.c = (SuspendLambda) nVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Type inference failed for: r2v0, types: [S7.n, kotlin.coroutines.jvm.internal.SuspendLambda] */
    /* JADX WARN: Type inference failed for: r4v4, types: [S7.n, kotlin.coroutines.jvm.internal.SuspendLambda] */
    @Override // p9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(p9.d r5, H7.c r6) {
        /*
            r4 = this;
            int r0 = r4.f5559a
            switch(r0) {
                case 0: goto L59;
                default: goto L5;
            }
        L5:
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1
            if (r0 == 0) goto L18
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L18
            int r1 = r1 - r2
            r0.b = r1
            goto L1d
        L18:
            kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1
            r0.<init>(r4, r6)
        L1d:
            java.lang.Object r6 = r0.f5206a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            com.stepos.policy.sdk.d r4 = r0.d
            kotlin.b.b(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2e
            goto L55
        L2e:
            r5 = move-exception
            goto L51
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.b.b(r6)
            p9.c r6 = r4.b
            com.stepos.policy.sdk.d r2 = new com.stepos.policy.sdk.d
            kotlin.coroutines.jvm.internal.SuspendLambda r4 = r4.c
            r2.<init>(r4, r5)
            r0.d = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4f
            r0.b = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4f
            java.lang.Object r4 = r6.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4f
            if (r4 != r1) goto L55
            goto L57
        L4f:
            r5 = move-exception
            r4 = r2
        L51:
            java.lang.Object r6 = r5.f5229a
            if (r6 != r4) goto L58
        L55:
            C7.r r1 = C7.r.f317a
        L57:
            return r1
        L58:
            throw r5
        L59:
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            kotlinx.coroutines.flow.c r1 = new kotlinx.coroutines.flow.c
            kotlin.coroutines.jvm.internal.SuspendLambda r2 = r4.c
            r1.<init>(r0, r5, r2)
            p9.c r4 = r4.b
            java.lang.Object r4 = r4.collect(r1, r6)
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            if (r4 != r5) goto L70
            goto L72
        L70:
            C7.r r4 = C7.r.f317a
        L72:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p9.g.collect(p9.d, H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(n nVar, S7.n nVar2) {
        this.b = nVar;
        this.c = (SuspendLambda) nVar2;
    }
}
