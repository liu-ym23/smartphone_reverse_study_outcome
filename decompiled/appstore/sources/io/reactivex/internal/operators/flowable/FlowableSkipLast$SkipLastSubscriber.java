package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableSkipLast$SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -3807491841935125653L;
    final Subscriber<? super T> downstream;
    final int skip;
    Subscription upstream;

    public FlowableSkipLast$SkipLastSubscriber(Subscriber<? super T> r10, int r11) {
        super(r11);
        this.downstream = r10;
        this.skip = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.skip != size()) goto L5;
        this.downstream.onNext(poll());
    L6:
        offer(r10);
        return;
    L5:
        this.upstream.request(1);
        goto L6
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        this.upstream.request(r10);
    }
}
