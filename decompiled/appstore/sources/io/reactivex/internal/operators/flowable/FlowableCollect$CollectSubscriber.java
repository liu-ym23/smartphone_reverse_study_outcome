package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableCollect$CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -3589550218733891694L;
    final BiConsumer<? super U, ? super T> collector;
    boolean done;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final U f20617u;
    Subscription upstream;

    public FlowableCollect$CollectSubscriber(Subscriber<? super U> r10, U r11, BiConsumer<? super U, ? super T> r12) {
        super(r10);
        this.collector = r12;
        this.f20617u = r11;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        complete(this.f20617u);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L10;
        return;
    L10:
        this.collector.accept(this.f20617u, r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }
}
