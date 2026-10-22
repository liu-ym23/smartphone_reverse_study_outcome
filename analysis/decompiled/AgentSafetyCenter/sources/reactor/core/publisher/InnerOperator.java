package reactor.core.publisher;

import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
interface InnerOperator<I, O> extends InnerConsumer<I>, InnerProducer<O> {
    /* synthetic */ void cancel();

    @Override // reactor.core.CoreSubscriber
    default Context currentContext() {
        return actual().currentContext();
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    /* synthetic */ void onComplete();

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    /* synthetic */ void onError(Throwable th);

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    /* synthetic */ void onNext(Object obj);

    /* synthetic */ void request(long j10);
}
