package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
abstract class FlowableConcatMap$BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, FlowableConcatMap$ConcatMapSupport<R>, Subscription {
    private static final long serialVersionUID = -3511336836796789179L;
    volatile boolean active;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final AtomicThrowable errors;
    final FlowableConcatMap$ConcatMapInner<R> inner;
    final int limit;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    SimpleQueue<T> queue;
    int sourceMode;
    Subscription upstream;

    public FlowableConcatMap$BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> r10, int r11) {
        this.mapper = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
        this.inner = new FlowableConcatMap$ConcatMapInner(this);
        this.errors = new AtomicThrowable();
    }

    public abstract void drain();

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapSupport
    public final void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T r10) {
        if (this.sourceMode != 2) goto L5;
    L8:
        drain();
        return;
    L5:
        if (this.queue.offer(r10) == true) goto L8;
        this.upstream.cancel();
        onError(new IllegalStateException("Queue full?!"));
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof QueueSubscription) == false) goto L14;
        QueueSubscription r11 = (QueueSubscription) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.sourceMode = r12;
        this.queue = r11;
        this.done = true;
        subscribeActual();
        drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = r12;
        this.queue = r11;
        subscribeActual();
        r10.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        subscribeActual();
        r10.request(this.prefetch);
        return;
    }

    public abstract void subscribeActual();
}
