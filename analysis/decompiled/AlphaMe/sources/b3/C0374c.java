package b3;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* renamed from: b3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0374c extends AbstractC0375d {

    /* renamed from: e, reason: collision with root package name */
    public final Function2 f4394e;

    public C0374c(y0.c cVar) {
        super(cVar, EmptyCoroutineContext.INSTANCE, -2, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v0, types: [a3.t, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v5, types: [a3.t] */
    @Override // b3.AbstractC0375d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(a3.t r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof b3.C0373b
            if (r0 == 0) goto L13
            r0 = r6
            b3.b r0 = (b3.C0373b) r0
            int r1 = r0.f4393d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4393d = r1
            goto L18
        L13:
            b3.b r0 = new b3.b
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f4391b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4393d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            a3.t r5 = r0.f4390a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f4390a = r5
            r0.f4393d = r3
            kotlin.jvm.functions.Function2 r4 = r4.f4398d
            java.lang.Object r4 = r4.invoke(r5, r0)
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r6) goto L47
            goto L49
        L47:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L49:
            if (r4 != r1) goto L4c
            return r1
        L4c:
            a3.j r5 = (a3.AbstractC0165j) r5
            a3.i r4 = r5.f2312d
            boolean r4 = r4.n()
            if (r4 == 0) goto L59
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L59:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.C0374c.a(a3.t, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
