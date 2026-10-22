package b3;

import kotlin.jvm.functions.Function3;

/* loaded from: classes2.dex */
public final class o implements InterfaceC0379h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0379h f4423a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f4424b;

    public o(InterfaceC0379h interfaceC0379h, Function3 function3) {
        this.f4423a = interfaceC0379h;
        this.f4424b = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b3.InterfaceC0379h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(b3.InterfaceC0380i r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof b3.n
            if (r0 == 0) goto L13
            r0 = r7
            b3.n r0 = (b3.n) r0
            int r1 = r0.f4419b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4419b = r1
            goto L18
        L13:
            b3.n r0 = new b3.n
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f4418a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4419b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            b3.i r6 = r0.f4422e
            b3.o r5 = r0.f4421d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f4421d = r5
            r0.f4422e = r6
            r0.f4419b = r4
            b3.h r7 = r5.f4423a
            java.lang.Object r7 = Z2.I.d(r0, r7, r6)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            if (r7 == 0) goto L6a
            kotlin.jvm.functions.Function3 r5 = r5.f4424b
            r2 = 0
            r0.f4421d = r2
            r0.f4422e = r2
            r0.f4419b = r3
            r2 = 6
            kotlin.jvm.internal.InlineMarker.mark(r2)
            java.lang.Object r5 = r5.invoke(r6, r7, r0)
            r6 = 7
            kotlin.jvm.internal.InlineMarker.mark(r6)
            if (r5 != r1) goto L6a
            return r1
        L6a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.o.collect(b3.i, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
