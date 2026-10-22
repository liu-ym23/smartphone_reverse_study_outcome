package reactor.core.publisher;

import reactor.util.context.Context;

/* loaded from: classes5.dex */
interface InnerOperator<I, O> extends InnerConsumer<I>, InnerProducer<O> {
    /* synthetic */ void cancel();

    @Override // reactor.core.CoreSubscriber
    default Context currentContext() {
        return actual().currentContext();
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    /* synthetic */ void onComplete();

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    /* synthetic */ void onError(Throwable th);

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    /* synthetic */ void onNext(Object obj);

    /* synthetic */ void request(long j10);
}
