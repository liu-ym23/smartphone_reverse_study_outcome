package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import lb.n;
import qb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    private final Object countOrElement;
    private final d emitContext;
    private final p<T, b<? super n>, Object> emitRef;

    public UndispatchedContextCollector(FlowCollector<? super T> flowCollector, d dVar) {
        this.emitContext = dVar;
        this.countOrElement = ThreadContextKt.threadContextElements(dVar);
        this.emitRef = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t8, b<? super n> bVar) {
        Object objWithContextUndispatched = ChannelFlowKt.withContextUndispatched(this.emitContext, t8, this.countOrElement, this.emitRef, bVar);
        return objWithContextUndispatched == CoroutineSingletons.f10059a ? objWithContextUndispatched : n.f10413a;
    }
}
