package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
abstract class ParallelJoin$JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = 3100232009247827843L;
    volatile boolean cancelled;
    final AtomicInteger done;
    final Subscriber<? super T> downstream;
    final AtomicThrowable errors;
    final AtomicLong requested;
    final ParallelJoin$JoinInnerSubscriber<T>[] subscribers;

    public ParallelJoin$JoinSubscriptionBase(Subscriber<? super T> r10, int r11, int r12) {
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.done = new AtomicInteger();
        this.downstream = r10;
        ParallelJoin$JoinInnerSubscriber<T>[] r13 = new ParallelJoin$JoinInnerSubscriber[r11];
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13[r14] = new ParallelJoin$JoinInnerSubscriber(this, r12);
        r14 = r14 + 1;
        goto L3
    L5:
        this.subscribers = r13;
        this.done.lazySet(r11);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) goto L9;
        cleanup();
        return;
    L9:
        return;
    }

    public void cancelAll() {
        ParallelJoin$JoinInnerSubscriber<T>[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].cancel();
        r12 = r12 + 1;
        goto L3
    }

    public void cleanup() {
        ParallelJoin$JoinInnerSubscriber<T>[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].queue = null;
        r12 = r12 + 1;
        goto L3
    }

    public abstract void drain();

    public abstract void onComplete();

    public abstract void onError(Throwable r10);

    public abstract void onNext(ParallelJoin$JoinInnerSubscriber<T> r10, T r11);

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        a.a(this.requested, r10);
        drain();
        return;
    }
}
