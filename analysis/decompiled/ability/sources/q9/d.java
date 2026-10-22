package q9;

import C7.r;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: classes4.dex */
public final class d extends kotlinx.coroutines.flow.internal.b {
    public d(p9.c cVar, H7.h hVar, int i, BufferOverflow bufferOverflow, int i6) {
        super(cVar, (i6 & 2) != 0 ? EmptyCoroutineContext.f4908a : hVar, (i6 & 4) != 0 ? -3 : i, (i6 & 8) != 0 ? BufferOverflow.f5184a : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.a f(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return new d(this.d, hVar, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final p9.c g() {
        return this.d;
    }

    @Override // kotlinx.coroutines.flow.internal.b
    public final Object i(p9.d dVar, H7.c cVar) {
        Object objCollect = this.d.collect(dVar, cVar);
        return objCollect == CoroutineSingletons.f4909a ? objCollect : r.f317a;
    }
}
