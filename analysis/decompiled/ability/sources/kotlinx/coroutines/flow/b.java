package kotlinx.coroutines.flow;

import S7.n;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: classes4.dex */
public final class b extends kotlinx.coroutines.flow.internal.a {
    public final SuspendLambda d;
    public final SuspendLambda e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(n nVar, H7.h hVar, int i, BufferOverflow bufferOverflow) {
        super(hVar, i, bufferOverflow);
        this.d = (SuspendLambda) nVar;
        this.e = (SuspendLambda) nVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v1, types: [S7.n, kotlin.coroutines.jvm.internal.SuspendLambda] */
    @Override // kotlinx.coroutines.flow.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(o9.InterfaceC1786l r6, H7.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = (kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L1a
        L13:
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = new kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r7 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r7
            r0.<init>(r5, r7)
        L1a:
            java.lang.Object r7 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            C7.r r3 = C7.r.f317a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            o9.l r6 = r0.f5196a
            kotlin.b.b(r7)
            goto L49
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.b.b(r7)
            r0.f5196a = r6
            r0.d = r4
            kotlin.coroutines.jvm.internal.SuspendLambda r5 = r5.d
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L45
            goto L46
        L45:
            r5 = r3
        L46:
            if (r5 != r1) goto L49
            return r1
        L49:
            o9.k r6 = (o9.C1785k) r6
            kotlinx.coroutines.channels.a r5 = r6.d
            boolean r5 = r5.z()
            if (r5 == 0) goto L54
            return r3
        L54:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.b.e(o9.l, H7.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [S7.n, kotlin.coroutines.jvm.internal.SuspendLambda] */
    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.a f(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return new b(this.e, hVar, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final String toString() {
        return "block[" + this.d + "] -> " + super.toString();
    }
}
