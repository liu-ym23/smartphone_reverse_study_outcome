package x0;

import b3.InterfaceC0380i;

/* loaded from: classes.dex */
public final class i implements InterfaceC0380i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15881a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15882b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15883c;

    public /* synthetic */ i(int i4, Object obj, Object obj2) {
        this.f15881a = i4;
        this.f15882b = obj;
        this.f15883c = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    @Override // b3.InterfaceC0380i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            int r0 = r8.f15881a
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r2 = 1
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.Object r4 = r8.f15883c
            java.lang.Object r5 = r8.f15882b
            switch(r0) {
                case 0: goto Laa;
                case 1: goto L65;
                default: goto Le;
            }
        Le:
            boolean r0 = r10 instanceof com.stepos.policy.sdk.V
            if (r0 == 0) goto L1f
            r0 = r10
            com.stepos.policy.sdk.V r0 = (com.stepos.policy.sdk.V) r0
            int r6 = r0.f12063b
            r7 = r6 & r3
            if (r7 == 0) goto L1f
            int r6 = r6 - r3
            r0.f12063b = r6
            goto L24
        L1f:
            com.stepos.policy.sdk.V r0 = new com.stepos.policy.sdk.V
            r0.<init>(r8, r10)
        L24:
            java.lang.Object r8 = r0.f12062a
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.f12063b
            if (r3 == 0) goto L3a
            if (r3 != r2) goto L34
            kotlin.ResultKt.throwOnFailure(r8)
            goto L62
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
            throw r8
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            b3.i r5 = (b3.InterfaceC0380i) r5
            V.h r9 = (V.h) r9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "local_"
            r8.<init>(r1)
            java.lang.String r4 = (java.lang.String) r4
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            V.f r8 = com.airbnb.lottie.h.I(r8)
            java.lang.Object r8 = r9.b(r8)
            r0.f12063b = r2
            java.lang.Object r8 = r5.emit(r8, r0)
            if (r8 != r10) goto L62
            goto L64
        L62:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L64:
            return r10
        L65:
            boolean r0 = r10 instanceof com.stepos.policy.sdk.P
            if (r0 == 0) goto L76
            r0 = r10
            com.stepos.policy.sdk.P r0 = (com.stepos.policy.sdk.P) r0
            int r6 = r0.f12049b
            r7 = r6 & r3
            if (r7 == 0) goto L76
            int r6 = r6 - r3
            r0.f12049b = r6
            goto L7b
        L76:
            com.stepos.policy.sdk.P r0 = new com.stepos.policy.sdk.P
            r0.<init>(r8, r10)
        L7b:
            java.lang.Object r8 = r0.f12048a
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.f12049b
            if (r3 == 0) goto L91
            if (r3 != r2) goto L8b
            kotlin.ResultKt.throwOnFailure(r8)
            goto La7
        L8b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
            throw r8
        L91:
            kotlin.ResultKt.throwOnFailure(r8)
            b3.i r5 = (b3.InterfaceC0380i) r5
            V.h r9 = (V.h) r9
            V.f r4 = (V.f) r4
            java.lang.Object r8 = r9.b(r4)
            r0.f12049b = r2
            java.lang.Object r8 = r5.emit(r8, r0)
            if (r8 != r10) goto La7
            goto La9
        La7:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        La9:
            return r10
        Laa:
            x0.c r9 = (x0.c) r9
            x0.e r5 = (x0.e) r5
            B0.r r4 = (B0.r) r4
            r5.b(r4, r9)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.i.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
