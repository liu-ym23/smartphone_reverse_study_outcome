package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableTakeLast$TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 7240042530241604978L;
    volatile boolean cancelled;
    final int count;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    final AtomicLong requested;
    Subscription upstream;
    final AtomicInteger wip;

    public FlowableTakeLast$TakeLastSubscriber(Subscriber<? super T> r10, int r11) {
        this.requested = new AtomicLong();
        this.wip = new AtomicInteger();
        this.downstream = r10;
        this.count = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    public void drain() {
        if (this.wip.getAndIncrement() != 0) goto L28;
        Subscriber<? super T> r10 = this.downstream;
        long r11 = this.requested.get();
    L6:
        if (this.cancelled == true) goto L7;
        if (this.done == false) goto L27;
        long r12 = 0;
    L12:
        if (r12 == r11) goto L22;
        if (this.cancelled == true) goto L15;
        T r13 = poll();
        if (r13 == null) goto L18;
        r10.onNext(r13);
        r12 = r12 + 1;
        goto L12
    L18:
        r10.onComplete();
        return;
    L15:
        return;
    L22:
        if (r12 == 0) goto L27;
        if (r11 == Long.MAX_VALUE) goto L27;
        r11 = this.requested.addAndGet(-r12);
    L27:
        if (this.wip.decrementAndGet() != 0) goto L6;
        return;
    L7:
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.count != size()) goto L5;
        poll();
    L5:
        offer(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
        return;
    }
}
