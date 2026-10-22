package b3;

import kotlin.jvm.internal.Ref;

/* renamed from: b3.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0377f implements InterfaceC0380i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0378g f4402a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4403b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0380i f4404c;

    public C0377f(C0378g c0378g, Ref.ObjectRef objectRef, InterfaceC0380i interfaceC0380i) {
        this.f4402a = c0378g;
        this.f4403b = objectRef;
        this.f4404c = interfaceC0380i;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    @Override // b3.InterfaceC0380i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof b3.C0376e
            if (r0 == 0) goto L13
            r0 = r9
            b3.e r0 = (b3.C0376e) r0
            int r1 = r0.f4401c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4401c = r1
            goto L18
        L13:
            b3.e r0 = new b3.e
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f4399a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4401c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r9)
            goto L63
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            kotlin.ResultKt.throwOnFailure(r9)
            b3.g r9 = r7.f4402a
            kotlin.jvm.functions.Function1 r2 = r9.f4406b
            java.lang.Object r2 = r2.invoke(r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = r7.f4403b
            T r5 = r4.element
            X.r r6 = c3.m.f4505a
            if (r5 == r6) goto L56
            kotlin.jvm.functions.Function2 r9 = r9.f4407c
            java.lang.Object r9 = r9.invoke(r5, r2)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L53
            goto L56
        L53:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L56:
            r4.element = r2
            r0.f4401c = r3
            b3.i r7 = r7.f4404c
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L63
            return r1
        L63:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.C0377f.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
