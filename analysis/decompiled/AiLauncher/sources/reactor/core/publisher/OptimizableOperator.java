package reactor.core.publisher;

import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
interface OptimizableOperator<IN, OUT> extends CorePublisher<IN> {
    @Nullable
    OptimizableOperator<?, ? extends OUT> nextOptimizableSource();

    CorePublisher<? extends OUT> source();

    @Override // reactor.core.CorePublisher, qc.b
    /* synthetic */ void subscribe(qc.c cVar);

    @Nullable
    CoreSubscriber<? super OUT> subscribeOrReturn(CoreSubscriber<? super IN> coreSubscriber) throws Throwable;
}
