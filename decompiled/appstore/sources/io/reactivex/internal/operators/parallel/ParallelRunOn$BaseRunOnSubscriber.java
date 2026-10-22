package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mf.f;
import org.reactivestreams.Subscription;
import qf.a;

/* JADX INFO: loaded from: classes4.dex */
abstract class ParallelRunOn$BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
    private static final long serialVersionUID = 9222303586456402150L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    Throwable error;
    final int limit;
    final int prefetch;
    final SpscArrayQueue<T> queue;
    final AtomicLong requested;
    Subscription upstream;
    final f.a worker;

    public ParallelRunOn$BaseRunOnSubscriber(int r10, SpscArrayQueue<T> r11, f.a r12) {
        this.requested = new AtomicLong();
        this.prefetch = r10;
        this.queue = r11;
        this.limit = r10 - (r10 >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        this.upstream.cancel();
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        schedule();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable r10) {
        if (this.done == false) goto L6;
        a.e(r10);
        return;
    L6:
        this.error = r10;
        this.done = true;
        schedule();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.queue.offer(r10) == true) goto L9;
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue is full?!"));
        return;
    L9:
        schedule();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        schedule();
        return;
    }

    public final void schedule() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        throw null;
    }
}
