package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes5.dex */
interface InnerConsumer<I> extends CoreSubscriber<I>, Scannable {
    @Override // reactor.core.CoreSubscriber, qc.c
    /* synthetic */ void onComplete();

    @Override // reactor.core.CoreSubscriber, qc.c
    /* synthetic */ void onError(Throwable th);

    @Override // reactor.core.CoreSubscriber, qc.c
    /* synthetic */ void onNext(Object obj);
}
