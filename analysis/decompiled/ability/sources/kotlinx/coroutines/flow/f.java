package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref$IntRef;

/* loaded from: classes4.dex */
public final class f implements p9.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f5226a;
    public final /* synthetic */ p9.d b;

    public f(Ref$IntRef ref$IntRef, p9.d dVar) {
        this.f5226a = ref$IntRef;
        this.b = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r6, H7.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f5208a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            C7.r r3 = C7.r.f317a
            r4 = 1
            if (r2 == 0) goto L31
            if (r2 != r4) goto L29
            kotlin.b.b(r7)
            return r3
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.b.b(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = r5.f5226a
            int r2 = r7.f4918a
            if (r2 < r4) goto L46
            r0.c = r4
            p9.d r5 = r5.b
            java.lang.Object r5 = r5.emit(r6, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r3
        L46:
            int r2 = r2 + r4
            r7.f4918a = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.f.emit(java.lang.Object, H7.c):java.lang.Object");
    }
}
