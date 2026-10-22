package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableRetryPredicate$RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Subscriber<? super T> downstream;
    final Predicate<? super Throwable> predicate;
    long produced;
    long remaining;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f20627sa;
    final Publisher<? extends T> source;

    public FlowableRetryPredicate$RetrySubscriber(Subscriber<? super T> r10, long r11, Predicate<? super Throwable> r12, SubscriptionArbiter r13, Publisher<? extends T> r14) {
        this.downstream = r10;
        this.f20627sa = r13;
        this.source = r14;
        this.predicate = r12;
        this.remaining = r11;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        long r11 = this.remaining;
        if (r11 == Long.MAX_VALUE) goto L6;
        this.remaining = r11 - 1;
    L6:
        if (r11 != 0) goto L17;
        this.downstream.onError(r10);
        return;
    L17:
        if (this.predicate.test(r10) == true) goto L12;
        this.downstream.onError(r10);
        return;
    L12:
        subscribeNext();
        return;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        this.f20627sa.setSubscription(r10);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r10 = 1;
    L6:
        if (this.f20627sa.isCancelled() == true) goto L7;
        long r11 = this.produced;
        if (r11 == 0) goto L11;
        this.produced = 0;
        this.f20627sa.produced(r11);
    L11:
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
