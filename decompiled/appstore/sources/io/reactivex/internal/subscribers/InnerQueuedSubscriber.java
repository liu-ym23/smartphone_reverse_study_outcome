package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.g;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final InnerQueuedSubscriberSupport<T> parent;
    final int prefetch;
    long produced;
    volatile SimpleQueue<T> queue;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> r10, int r11) {
        this.parent = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.parent.innerError(this, r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r10);
        return;
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
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r12 != 2) goto L14;
        this.fusionMode = r12;
        this.queue = r11;
        g.f(r10, this.prefetch);
        return;
    L14:
        this.queue = g.a(this.prefetch);
        g.f(r10, this.prefetch);
    }

    public SimpleQueue<T> queue() {
        return this.queue;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (this.fusionMode == 1) goto L9;
        long r11 = this.produced + r10;
        if (r11 < this.limit) goto L7;
        this.produced = 0;
        get().request(r11);
        return;
    L7:
        this.produced = r11;
        return;
    }

    public void requestOne() {
        if (this.fusionMode == 1) goto L9;
        long r10 = this.produced + 1;
        if (r10 != this.limit) goto L7;
        this.produced = 0;
        get().request(r10);
        return;
    L7:
        this.produced = r10;
        return;
    }

    public void setDone() {
        this.done = true;
    }
}
