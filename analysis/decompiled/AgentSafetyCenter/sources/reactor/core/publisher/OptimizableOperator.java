package reactor.core.publisher;

import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
interface OptimizableOperator<IN, OUT> extends CorePublisher<IN> {
    @Nullable
    OptimizableOperator<?, ? extends OUT> nextOptimizableSource();

    CorePublisher<? extends OUT> source();

    @Override // reactor.core.CorePublisher, qd.c
    /* synthetic */ void subscribe(qd.d dVar);

    @Nullable
    CoreSubscriber<? super OUT> subscribeOrReturn(CoreSubscriber<? super IN> coreSubscriber);
}
