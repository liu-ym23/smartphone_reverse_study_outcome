package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableSkipLastTimed$SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    Throwable error;
    final io.reactivex.internal.queue.a queue;
    final AtomicLong requested;
    final mf.f scheduler;
    final long time;
    final TimeUnit unit;
    Subscription upstream;

    public FlowableSkipLastTimed$SkipLastTimedSubscriber(Subscriber<? super T> r10, long r11, TimeUnit r12, mf.f r13, int r14, boolean r15) {
        this.requested = new AtomicLong();
        this.downstream = r10;
        this.time = r11;
        this.unit = r12;
        this.queue = new io.reactivex.internal.queue.a(r14);
        this.delayError = r15;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    public boolean checkTerminated(boolean r10, boolean r11, Subscriber<? super T> r12, boolean r13) {
        if (this.cancelled == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r10 == false) goto L21;
        if (r13 == false) goto L14;
        if (r11 == false) goto L23;
        Throwable r14 = this.error;
        if (r14 == null) goto L12;
        r12.onError(r14);
    L13:
        return true;
    L12:
        r12.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r15 = this.error;
        if (r15 == null) goto L18;
        this.queue.clear();
        r12.onError(r15);
        return true;
    L18:
        if (r11 == false) goto L24;
        r12.onComplete();
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.a r10 = this.queue;
        int r11 = 1;
    L7:
        if (0 != this.requested.get()) goto L14;
        if (0 == 0) goto L11;
        io.reactivex.internal.util.a.e(this.requested, 0);
    L11:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L7;
        return;
    L14:
        Long r12 = (Long) r10.peek();
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        throw null;
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
