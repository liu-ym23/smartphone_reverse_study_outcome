package kotlinx.coroutines.flow.internal;

import C7.r;
import S7.o;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.AbstractC1683A;

/* loaded from: classes4.dex */
public final class d extends b {
    public final SuspendLambda e;

    /* JADX WARN: Multi-variable type inference failed */
    public d(o oVar, p9.c cVar, H7.h hVar, int i, BufferOverflow bufferOverflow) {
        super(cVar, hVar, i, bufferOverflow);
        this.e = (SuspendLambda) oVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [S7.o, kotlin.coroutines.jvm.internal.SuspendLambda] */
    @Override // kotlinx.coroutines.flow.internal.a
    public final a f(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return new d(this.e, this.d, hVar, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.b
    public final Object i(p9.d dVar, H7.c cVar) {
        Object objF = AbstractC1683A.f(new ChannelFlowTransformLatest$flowCollect$3(this, dVar, null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }
}
