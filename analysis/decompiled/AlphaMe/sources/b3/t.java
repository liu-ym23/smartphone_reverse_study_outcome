package b3;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class t implements InterfaceC0380i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f4439a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0380i f4440b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f4441c;

    public t(Ref.BooleanRef booleanRef, InterfaceC0380i interfaceC0380i, Function2 function2) {
        this.f4439a = booleanRef;
        this.f4440b = interfaceC0380i;
        this.f4441c = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b3.InterfaceC0380i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof b3.s
            if (r0 == 0) goto L13
            r0 = r8
            b3.s r0 = (b3.s) r0
            int r1 = r0.f4438e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4438e = r1
            goto L18
        L13:
            b3.s r0 = new b3.s
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f4436c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4438e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L43
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r8)
            goto L85
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            java.lang.Object r7 = r0.f4435b
            b3.t r6 = r0.f4434a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L69
        L3f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L57
        L43:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f4439a
            boolean r8 = r8.element
            if (r8 == 0) goto L5a
            r0.f4438e = r5
            b3.i r6 = r6.f4440b
            java.lang.Object r6 = r6.emit(r7, r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L5a:
            r0.f4434a = r6
            r0.f4435b = r7
            r0.f4438e = r4
            kotlin.jvm.functions.Function2 r8 = r6.f4441c
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L69
            return r1
        L69:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L88
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f4439a
            r8.element = r5
            r8 = 0
            r0.f4434a = r8
            r0.f4435b = r8
            r0.f4438e = r3
            b3.i r6 = r6.f4440b
            java.lang.Object r6 = r6.emit(r7, r0)
            if (r6 != r1) goto L85
            return r1
        L85:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L88:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.t.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
