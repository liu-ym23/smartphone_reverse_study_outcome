package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableOnErrorNext$OnErrorNextSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 4063763155303814625L;
    final boolean allowFatal;
    boolean done;
    final Subscriber<? super T> downstream;
    final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
    boolean once;
    long produced;

    public FlowableOnErrorNext$OnErrorNextSubscriber(Subscriber<? super T> r10, Function<? super Throwable, ? extends Publisher<? extends T>> r11, boolean r12) {
        super(false);
        this.downstream = r10;
        this.nextSupplier = r11;
        this.allowFatal = r12;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.once = true;
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.once == true) goto L5;
        this.once = true;
        if (this.allowFatal == true) goto L13;
    L25:
        Publisher r11 = (Publisher) io.reactivex.internal.functions.a.b(this.nextSupplier.apply(r10), "The nextSupplier returned a null Publisher");     // Catch: Throwable -> L22
        long r12 = this.produced;
        if (r12 == 0) goto L20;
        produced(r12);
    L20:
        r11.subscribe(this);
        return;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
        return;
    L13:
        if ((r10 instanceof Exception) == true) goto L25;
        this.downstream.onError(r10);
        return;
    L5:
        if (this.done == false) goto L8;
        qf.a.e(r10);
        return;
    L8:
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.once == true) goto L8;
        this.produced++;
    L8:
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        setSubscription(r10);
    }
}
