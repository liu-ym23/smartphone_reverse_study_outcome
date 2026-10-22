package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
interface InnerConsumer<I> extends CoreSubscriber<I>, Scannable {
    @Override // reactor.core.CoreSubscriber, Z9.d
    /* synthetic */ void onComplete();

    @Override // reactor.core.CoreSubscriber, Z9.d
    /* synthetic */ void onError(Throwable th);

    @Override // reactor.core.CoreSubscriber, Z9.d
    /* synthetic */ void onNext(Object obj);
}
