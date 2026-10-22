package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableLimit$LimitSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 2288246011222124525L;
    final Subscriber<? super T> downstream;
    long remaining;
    Subscription upstream;

    public FlowableLimit$LimitSubscriber(Subscriber<? super T> r10, long r11) {
        this.downstream = r10;
        this.remaining = r11;
        lazySet(r11);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.remaining <= 0) goto L6;
        this.remaining = 0;
        this.downstream.onComplete();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.remaining <= 0) goto L5;
        this.remaining = 0;
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        long r11 = this.remaining;
        if (r11 <= 0) goto L8;
        long r12 = r11 - 1;
        this.remaining = r12;
        this.downstream.onNext(r10);
        if (r12 != 0) goto L9;
        this.upstream.cancel();
        this.downstream.onComplete();
        return;
    L9:
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == true) goto L5;
        return;
    L5:
        if (this.remaining != 0) goto L7;
        r10.cancel();
        EmptySubscription.complete(this.downstream);
        return;
    L7:
        this.upstream = r10;
        this.downstream.onSubscribe(this);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L18;
    L4:
        long r11 = get();
        if (r11 == 0) goto L19;
        if (r11 > r10) goto L10;
        long r12 = r11;
    L12:
        if (compareAndSet(r11, r11 - r12) == false) goto L4;
        this.upstream.request(r12);
        return;
    L10:
        r12 = r10;
        goto L12
    L19:
        return;
    }
}
