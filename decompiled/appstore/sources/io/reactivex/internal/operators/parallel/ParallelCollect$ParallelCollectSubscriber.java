package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import qf.a;

/* JADX INFO: loaded from: classes4.dex */
final class ParallelCollect$ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
    private static final long serialVersionUID = -4767392946044436228L;
    C collection;
    final BiConsumer<? super C, ? super T> collector;
    boolean done;

    public ParallelCollect$ParallelCollectSubscriber(Subscriber<? super C> r10, C r11, BiConsumer<? super C, ? super T> r12) {
        super(r10);
        this.collection = r11;
        this.collector = r12;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        C r10 = this.collection;
        this.collection = null;
        complete(r10);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        a.e(r10);
        return;
    L6:
        this.done = true;
        this.collection = null;
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L10;
        return;
    L10:
        this.collector.accept(this.collection, r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        onError(th);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }
}
