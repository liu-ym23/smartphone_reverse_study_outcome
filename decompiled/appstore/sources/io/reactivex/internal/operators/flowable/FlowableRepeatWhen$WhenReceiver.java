package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableRepeatWhen$WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
    private static final long serialVersionUID = 2827772011130406689L;
    final AtomicLong requested;
    final Publisher<T> source;
    FlowableRepeatWhen$WhenSourceSubscriber<T, U> subscriber;
    final AtomicReference<Subscription> upstream;

    public FlowableRepeatWhen$WhenReceiver(Publisher<T> r10) {
        this.source = r10;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.subscriber.cancel();
        this.subscriber.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.subscriber.cancel();
        this.subscriber.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        if (this.upstream.get() == SubscriptionHelper.CANCELLED) goto L6;
        this.source.subscribe(this.subscriber);
        if (decrementAndGet() != 0) goto L5;
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }
}
