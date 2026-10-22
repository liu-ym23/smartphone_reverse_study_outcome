package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableReduce$ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -4663883003264602070L;
    final BiFunction<T, T, T> reducer;
    Subscription upstream;

    public FlowableReduce$ReduceSubscriber(Subscriber<? super T> r10, BiFunction<T, T, T> r11) {
        super(r10);
        this.reducer = r11;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription r10 = this.upstream;
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 != r11) goto L5;
        return;
    L5:
        this.upstream = r11;
        T r12 = this.value;
        if (r12 == null) goto L8;
        complete(r12);
        return;
    L8:
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        Subscription r11 = this.upstream;
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 != r12) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.upstream = r12;
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.upstream != SubscriptionHelper.CANCELLED) goto L5;
        return;
    L5:
        T r11 = this.value;
        if (r11 != null) goto L13;
        this.value = r10;
        return;
    L13:
        this.value = (T) io.reactivex.internal.functions.a.b(this.reducer.apply(r11, r10), "The reducer returned a null value");     // Catch: Throwable -> L10
        return;
    L10:
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
