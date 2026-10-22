package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableRepeatUntil$RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Subscriber<? super T> downstream;
    long produced;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f20625sa;
    final Publisher<? extends T> source;
    final BooleanSupplier stop;

    public FlowableRepeatUntil$RepeatSubscriber(Subscriber<? super T> r10, BooleanSupplier r11, SubscriptionArbiter r12, Publisher<? extends T> r13) {
        this.downstream = r10;
        this.f20625sa = r12;
        this.source = r13;
        this.stop = r11;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.stop.getAsBoolean() == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        subscribeNext();
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        this.f20625sa.setSubscription(r10);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r10 = 1;
    L6:
        if (this.f20625sa.isCancelled() == true) goto L7;
        long r11 = this.produced;
        if (r11 == 0) goto L11;
        this.produced = 0;
        this.f20625sa.produced(r11);
    L11:
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
