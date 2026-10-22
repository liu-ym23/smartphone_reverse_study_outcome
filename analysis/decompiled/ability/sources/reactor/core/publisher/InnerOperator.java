package reactor.core.publisher;

import reactor.util.context.Context;

/* loaded from: classes4.dex */
interface InnerOperator<I, O> extends InnerConsumer<I>, InnerProducer<O> {
    /* synthetic */ void cancel();

    @Override // reactor.core.CoreSubscriber
    default Context currentContext() {
        return actual().currentContext();
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    /* synthetic */ void onComplete();

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    /* synthetic */ void onError(Throwable th);

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    /* synthetic */ void onNext(Object obj);

    /* synthetic */ void request(long j5);
}
