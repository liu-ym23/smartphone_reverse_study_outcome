package kotlinx.coroutines.flow;

import kotlin.coroutines.d;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class ReadonlyStateFlow<T> implements StateFlow<T>, Flow, FusibleFlow<T> {
    private final /* synthetic */ StateFlow<T> $$delegate_0;
    private final Job job;

    /* JADX WARN: Multi-variable type inference failed */
    public ReadonlyStateFlow(StateFlow<? extends T> stateFlow, Job job) {
        this.$$delegate_0 = stateFlow;
        this.job = job;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, qb.b<?> bVar) {
        return this.$$delegate_0.collect(flowCollector, bVar);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(d dVar, int i10, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, dVar, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        return this.$$delegate_0.getValue();
    }
}
