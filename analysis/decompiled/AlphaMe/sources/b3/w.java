package b3;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class w implements InterfaceC0380i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f4448a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4449b;

    public w(Function2 function2, Ref.ObjectRef objectRef) {
        this.f4448a = function2;
        this.f4449b = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b3.InterfaceC0380i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof b3.v
            if (r0 == 0) goto L13
            r0 = r6
            b3.v r0 = (b3.v) r0
            int r1 = r0.f4445c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4445c = r1
            goto L18
        L13:
            b3.v r0 = new b3.v
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f4444b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4445c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f4447e
            b3.w r4 = r0.f4443a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f4443a = r4
            r0.f4447e = r5
            r0.f4445c = r3
            r6 = 6
            kotlin.jvm.internal.InlineMarker.mark(r6)
            kotlin.jvm.functions.Function2 r6 = r4.f4448a
            java.lang.Object r6 = r6.invoke(r5, r0)
            r0 = 7
            kotlin.jvm.internal.InlineMarker.mark(r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L5a
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L5a:
            kotlin.jvm.internal.Ref$ObjectRef r6 = r4.f4449b
            r6.element = r5
            c3.a r5 = new c3.a
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.w.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
