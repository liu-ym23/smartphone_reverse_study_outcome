package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = 8663801314800248617L;
    final MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> parent;

    public MaybeTimeoutPublisher$TimeoutOtherMaybeObserver(MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> r10) {
        this.parent = r10;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.otherComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.parent.otherError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        get().cancel();
        this.parent.otherComplete();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
