package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
interface InnerConsumer<I> extends CoreSubscriber<I>, Scannable {
    @Override // reactor.core.CoreSubscriber, qd.d
    /* synthetic */ void onComplete();

    @Override // reactor.core.CoreSubscriber, qd.d
    /* synthetic */ void onError(Throwable th);

    @Override // reactor.core.CoreSubscriber, qd.d
    /* synthetic */ void onNext(Object obj);
}
