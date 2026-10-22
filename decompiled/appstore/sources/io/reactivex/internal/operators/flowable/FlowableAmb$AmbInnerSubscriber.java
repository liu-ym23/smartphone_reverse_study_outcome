package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableAmb$AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -1185974347409665484L;
    final Subscriber<? super T> downstream;
    final int index;
    final AtomicLong missedRequested;
    final b parent;
    boolean won;

    public FlowableAmb$AmbInnerSubscriber(b r10, int r11, Subscriber<? super T> r12) {
        this.missedRequested = new AtomicLong();
        this.index = r11;
        this.downstream = r12;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.won == false) goto L7;
        this.downstream.onComplete();
        return;
    L7:
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.won == false) goto L7;
        this.downstream.onError(r10);
        return;
    L7:
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.won == false) goto L7;
        this.downstream.onNext(r10);
        return;
    L7:
        throw null;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this, this.missedRequested, r10);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this, this.missedRequested, r10);
    }
}
