package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.Ref$ObjectRef;
import m9.InterfaceC1733z;

/* loaded from: classes4.dex */
public final class c implements p9.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f5245a;
    public final /* synthetic */ InterfaceC1733z b;
    public final /* synthetic */ d c;
    public final /* synthetic */ p9.d d;

    public c(Ref$ObjectRef ref$ObjectRef, InterfaceC1733z interfaceC1733z, d dVar, p9.d dVar2) {
        this.f5245a = ref$ObjectRef;
        this.b = interfaceC1733z;
        this.c = dVar;
        this.d = dVar2;
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
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r6 = r0.b
            kotlinx.coroutines.flow.internal.c r5 = r0.f5235a
            kotlin.b.b(r7)
            goto L53
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.b.b(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = r5.f5245a
            java.lang.Object r7 = r7.f4920a
            m9.c0 r7 = (m9.c0) r7
            if (r7 == 0) goto L53
            kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
            r2.<init>()
            r7.cancel(r2)
            r0.f5235a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r7 = r7.g(r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            kotlin.jvm.internal.Ref$ObjectRef r7 = r5.f5245a
            m9.z r0 = r5.b
            kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.f5175a
            kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r1 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
            kotlinx.coroutines.flow.internal.d r2 = r5.c
            p9.d r5 = r5.d
            r4 = 0
            r1.<init>(r2, r5, r6, r4)
            m9.q0 r5 = m9.AbstractC1683A.n(r0, r4, r1, r3)
            r7.f4920a = r5
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.c.emit(java.lang.Object, H7.c):java.lang.Object");
    }
}
