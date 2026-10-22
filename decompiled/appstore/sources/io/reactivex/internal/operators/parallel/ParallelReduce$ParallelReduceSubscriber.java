package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import qf.a;

/* JADX INFO: loaded from: classes4.dex */
final class ParallelReduce$ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
    private static final long serialVersionUID = 8200530050639449080L;
    R accumulator;
    boolean done;
    final BiFunction<R, ? super T, R> reducer;

    public ParallelReduce$ParallelReduceSubscriber(Subscriber<? super R> r10, R r11, BiFunction<R, ? super T, R> r12) {
        super(r10);
        this.accumulator = r11;
        this.reducer = r12;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        R r10 = this.accumulator;
        this.accumulator = null;
        complete(r10);
        return;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        a.e(r10);
        return;
    L6:
        this.done = true;
        this.accumulator = null;
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == true) goto L11;
        this.accumulator = (R) io.reactivex.internal.functions.a.b(this.reducer.apply(this.accumulator, r10), "The reducer returned a null value");
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        onError(th);
        return;
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
