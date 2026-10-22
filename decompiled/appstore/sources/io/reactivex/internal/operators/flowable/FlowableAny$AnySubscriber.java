package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableAny$AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -2311252482644620661L;
    boolean done;
    final Predicate<? super T> predicate;
    Subscription upstream;

    public FlowableAny$AnySubscriber(Subscriber<? super Boolean> r10, Predicate<? super T> r11) {
        super(r10);
        this.predicate = r11;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        complete(Boolean.FALSE);
        return;
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
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.predicate.test(r10) == false) goto L14;
        this.done = true;
        this.upstream.cancel();
        complete(Boolean.TRUE);
        return;
    L14:
        return;
    L9:
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
