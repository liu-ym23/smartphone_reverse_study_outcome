package kotlinx.coroutines.flow;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class SafeFlow<T> extends AbstractFlow<T> {
    private final p<FlowCollector<? super T>, qb.b<? super n>, Object> block;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeFlow(p<? super FlowCollector<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        this.block = pVar;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object collectSafely(FlowCollector<? super T> flowCollector, qb.b<? super n> bVar) {
        Object objInvoke = this.block.invoke(flowCollector, bVar);
        return objInvoke == CoroutineSingletons.f10059a ? objInvoke : n.f10413a;
    }
}
