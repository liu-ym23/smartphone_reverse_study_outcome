package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableSequenceEqual$EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 4804128302091633067L;
    volatile boolean done;
    final int limit;
    final FlowableSequenceEqual$EqualCoordinatorHelper parent;
    final int prefetch;
    long produced;
    volatile SimpleQueue<T> queue;
    int sourceMode;

    public FlowableSequenceEqual$EqualSubscriber(FlowableSequenceEqual$EqualCoordinatorHelper r10, int r11) {
        this.parent = r10;
        this.limit = r11 - (r11 >> 2);
        this.prefetch = r11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void clear() {
        SimpleQueue<T> r10 = this.queue;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.parent.innerError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.sourceMode == 0) goto L5;
    L8:
        this.parent.drain();
        return;
    L5:
        if (this.queue.offer(r10) == true) goto L8;
        onError(new MissingBackpressureException());
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof QueueSubscription) == false) goto L14;
        QueueSubscription r11 = (QueueSubscription) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.sourceMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = r12;
        this.queue = r11;
        r10.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        r10.request(this.prefetch);
    }

    public void request() {
        if (this.sourceMode == 1) goto L9;
        long r10 = this.produced + 1;
        if (r10 < this.limit) goto L7;
        this.produced = 0;
        get().request(r10);
        return;
    L7:
        this.produced = r10;
        return;
    }
}
