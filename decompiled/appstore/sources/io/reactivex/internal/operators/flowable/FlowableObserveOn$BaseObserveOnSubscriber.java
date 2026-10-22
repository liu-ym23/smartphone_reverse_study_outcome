package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
abstract class FlowableObserveOn$BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
    private static final long serialVersionUID = -8241002408341274697L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final int limit;
    boolean outputFused;
    final int prefetch;
    long produced;
    SimpleQueue<T> queue;
    final AtomicLong requested;
    int sourceMode;
    Subscription upstream;
    final mf.f.a worker;

    public FlowableObserveOn$BaseObserveOnSubscriber(mf.f.a r10, boolean r11, int r12) {
        this.delayError = r11;
        this.prefetch = r12;
        this.requested = new AtomicLong();
        this.limit = r12 - (r12 >> 2);
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

    public final boolean checkTerminated(boolean r10, boolean r11, Subscriber<?> r12) {
        if (this.cancelled == false) goto L6;
        clear();
        return true;
    L6:
        if (r10 == true) goto L8;
        return false;
    L8:
        if (this.delayError == false) goto L15;
        if (r11 == false) goto L26;
        this.cancelled = true;
        Throwable r13 = this.error;
        if (r13 == null) goto L13;
        r12.onError(r13);
        throw null;
    L13:
        r12.onComplete();
        throw null;
    L26:
        return false;
    L15:
        Throwable r14 = this.error;
        if (r14 != null) goto L21;
        if (r11 == false) goto L27;
        this.cancelled = true;
        r12.onComplete();
        throw null;
    L27:
        return false;
    L21:
        this.cancelled = true;
        clear();
        r12.onError(r14);
        throw null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        this.queue.clear();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        trySchedule();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.error = r10;
        this.done = true;
        trySchedule();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.sourceMode != 2) goto L10;
        trySchedule();
        return;
    L10:
        if (this.queue.offer(r10) == true) goto L12;
        this.upstream.cancel();
        this.error = new MissingBackpressureException("Queue is full?!");
        this.done = true;
    L12:
        trySchedule();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        trySchedule();
        return;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.outputFused == false) goto L6;
        runBackfused();
        return;
    L6:
        if (this.sourceMode != 1) goto L8;
        runSync();
        return;
    L8:
        runAsync();
    }

    public abstract void runAsync();

    public abstract void runBackfused();

    public abstract void runSync();

    public final void trySchedule() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        throw null;
    }
}
