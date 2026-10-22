package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableZip$ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4627193790118206028L;
    volatile boolean done;
    final int limit;
    final FlowableZip$ZipCoordinator<T, R> parent;
    final int prefetch;
    long produced;
    SimpleQueue<T> queue;
    int sourceMode;

    public FlowableZip$ZipSubscriber(FlowableZip$ZipCoordinator<T, R> r10, int r11) {
        this.parent = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.parent.error(this, r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.sourceMode == 2) goto L5;
        this.queue.offer(r10);
    L5:
        this.parent.drain();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof QueueSubscription) == false) goto L14;
        QueueSubscription r11 = (QueueSubscription) r10;
        int r12 = r11.requestFusion(7);
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

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (this.sourceMode == 1) goto L9;
        long r11 = this.produced + r10;
        if (r11 < this.limit) goto L7;
        this.produced = 0;
        get().request(r11);
        return;
    L7:
        this.produced = r11;
        return;
    }
}
