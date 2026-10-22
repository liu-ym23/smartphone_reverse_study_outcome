package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class ParallelJoin$JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 8410034718427740355L;
    final int limit;
    final ParallelJoin$JoinSubscriptionBase<T> parent;
    final int prefetch;
    long produced;
    volatile SimplePlainQueue<T> queue;

    public ParallelJoin$JoinInnerSubscriber(ParallelJoin$JoinSubscriptionBase<T> r10, int r11) {
        this.parent = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
    }

    public boolean cancel() {
        return SubscriptionHelper.cancel(this);
    }

    public SimplePlainQueue<T> getQueue() {
        SimplePlainQueue<T> r10 = this.queue;
        if (r10 != null) goto L6;
        SpscArrayQueue r11 = new SpscArrayQueue(this.prefetch);
        this.queue = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.parent.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.parent.onNext(this, r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, this.prefetch);
    }

    public void request(long r10) {
        long r11 = this.produced + r10;
        if (r11 < this.limit) goto L5;
        this.produced = 0;
        get().request(r11);
        return;
    L5:
        this.produced = r11;
    }

    public void requestOne() {
        long r10 = this.produced + 1;
        if (r10 != this.limit) goto L5;
        this.produced = 0;
        get().request(r10);
        return;
    L5:
        this.produced = r10;
    }
}
