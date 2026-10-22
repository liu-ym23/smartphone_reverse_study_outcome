package b3;

import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class r implements InterfaceC0380i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0380i f4432a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4433b;

    public r(InterfaceC0380i interfaceC0380i, Ref.ObjectRef objectRef) {
        this.f4432a = interfaceC0380i;
        this.f4433b = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Throwable] */
    @Override // b3.InterfaceC0380i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof b3.q
            if (r0 == 0) goto L13
            r0 = r6
            b3.q r0 = (b3.q) r0
            int r1 = r0.f4431d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4431d = r1
            goto L18
        L13:
            b3.q r0 = new b3.q
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f4429b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4431d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            b3.r r4 = r0.f4428a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L2b
            goto L45
        L2b:
            r5 = move-exception
            goto L48
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            b3.i r6 = r4.f4432a     // Catch: java.lang.Throwable -> L2b
            r0.f4428a = r4     // Catch: java.lang.Throwable -> L2b
            r0.f4431d = r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r4 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L2b
            if (r4 != r1) goto L45
            return r1
        L45:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L48:
            kotlin.jvm.internal.Ref$ObjectRef r4 = r4.f4433b
            r4.element = r5
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.r.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
