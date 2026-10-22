package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableFlatMap$InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
    private static final long serialVersionUID = -4606175640614850599L;
    final int bufferSize;
    volatile boolean done;
    int fusionMode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    final long f20623id;
    final int limit;
    final FlowableFlatMap$MergeSubscriber<T, U> parent;
    long produced;
    volatile SimpleQueue<U> queue;

    public FlowableFlatMap$InnerSubscriber(FlowableFlatMap$MergeSubscriber<T, U> r10, long r11) {
        this.f20623id = r11;
        this.parent = r10;
        int r12 = r10.bufferSize;
        this.bufferSize = r12;
        this.limit = r12 >> 2;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        lazySet(SubscriptionHelper.CANCELLED);
        this.parent.innerError(this, r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(U r10) {
        if (this.fusionMode == 2) goto L5;
        this.parent.tryEmit(r10, this);
        return;
    L5:
        this.parent.drain();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof QueueSubscription) == false) goto L13;
        QueueSubscription r11 = (QueueSubscription) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r12 != 2) goto L13;
        this.fusionMode = r12;
        this.queue = r11;
    L13:
        r10.request(this.bufferSize);
    }

    public void requestMore(long r10) {
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
}
