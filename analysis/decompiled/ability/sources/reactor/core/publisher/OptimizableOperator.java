package reactor.core.publisher;

import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
interface OptimizableOperator<IN, OUT> extends CorePublisher<IN> {
    @Nullable
    OptimizableOperator<?, ? extends OUT> nextOptimizableSource();

    CorePublisher<? extends OUT> source();

    @Override // reactor.core.CorePublisher, Z9.c
    /* synthetic */ void subscribe(Z9.d dVar);

    @Nullable
    CoreSubscriber<? super OUT> subscribeOrReturn(CoreSubscriber<? super IN> coreSubscriber) throws Throwable;
}
