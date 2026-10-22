package kotlinx.coroutines.flow.internal;

import C7.r;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.BufferOverflow;
import o9.InterfaceC1786l;

/* loaded from: classes4.dex */
public abstract class b extends a {
    public final p9.c d;

    public b(p9.c cVar, H7.h hVar, int i, BufferOverflow bufferOverflow) {
        super(hVar, i, bufferOverflow);
        this.d = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    @Override // kotlinx.coroutines.flow.internal.a, p9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(p9.d r5, H7.c r6) {
        /*
            r4 = this;
            int r0 = r4.b
            r1 = -3
            if (r0 != r1) goto L6f
            H7.h r0 = r6.getContext()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            com.stepos.core.a r2 = new com.stepos.core.a
            r3 = 10
            r2.<init>(r3)
            H7.h r3 = r4.f5244a
            java.lang.Object r1 = r3.fold(r1, r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L25
            H7.h r1 = r0.plus(r3)
            goto L2a
        L25:
            r1 = 0
            H7.h r1 = m9.AbstractC1683A.g(r0, r3, r1)
        L2a:
            boolean r2 = kotlin.jvm.internal.k.b(r1, r0)
            if (r2 == 0) goto L39
            java.lang.Object r4 = r4.i(r5, r6)
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            if (r4 != r5) goto L78
            return r4
        L39:
            H7.d r2 = H7.d.f758a
            H7.f r3 = r1.get(r2)
            H7.f r0 = r0.get(r2)
            boolean r0 = kotlin.jvm.internal.k.b(r3, r0)
            if (r0 == 0) goto L6f
            H7.h r0 = r6.getContext()
            boolean r2 = r5 instanceof q9.j
            if (r2 != 0) goto L5c
            boolean r2 = r5 instanceof q9.i
            if (r2 == 0) goto L56
            goto L5c
        L56:
            kotlinx.coroutines.flow.internal.j r2 = new kotlinx.coroutines.flow.internal.j
            r2.<init>(r5, r0)
            r5 = r2
        L5c:
            kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2
            r2 = 0
            r0.<init>(r4, r2)
            java.lang.Object r4 = s9.AbstractC1921a.k(r1)
            java.lang.Object r4 = q9.b.b(r1, r5, r4, r0, r6)
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            if (r4 != r5) goto L78
            return r4
        L6f:
            java.lang.Object r4 = super.collect(r5, r6)
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            if (r4 != r5) goto L78
            return r4
        L78:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.b.collect(p9.d, H7.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final Object e(InterfaceC1786l interfaceC1786l, H7.c cVar) {
        Object objI = i(new q9.j(interfaceC1786l), cVar);
        return objI == CoroutineSingletons.f4909a ? objI : r.f317a;
    }

    public abstract Object i(p9.d dVar, H7.c cVar);

    @Override // kotlinx.coroutines.flow.internal.a
    public final String toString() {
        return this.d + " -> " + super.toString();
    }
}
