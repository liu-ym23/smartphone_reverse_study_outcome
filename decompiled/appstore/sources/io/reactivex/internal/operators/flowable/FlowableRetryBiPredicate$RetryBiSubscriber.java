package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableRetryBiPredicate$RetryBiSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Subscriber<? super T> downstream;
    final BiPredicate<? super Integer, ? super Throwable> predicate;
    long produced;
    int retries;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f20626sa;
    final Publisher<? extends T> source;

    public FlowableRetryBiPredicate$RetryBiSubscriber(Subscriber<? super T> r10, BiPredicate<? super Integer, ? super Throwable> r11, SubscriptionArbiter r12, Publisher<? extends T> r13) {
        this.downstream = r10;
        this.f20626sa = r12;
        this.source = r13;
        this.predicate = r11;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        BiPredicate<? super Integer, ? super Throwable> r11 = this.predicate;     // Catch: Throwable -> L8
        int r12 = this.retries + 1;     // Catch: Throwable -> L8
        this.retries = r12;     // Catch: Throwable -> L8
        if (r11.test(Integer.valueOf(r12), r10) == true) goto L6;
        this.downstream.onError(r10);
        return;
    L6:
        subscribeNext();
        return;
    L8:
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
        this.f20626sa.setSubscription(r10);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r10 = 1;
    L6:
        if (this.f20626sa.isCancelled() == true) goto L7;
        long r11 = this.produced;
        if (r11 == 0) goto L11;
        this.produced = 0;
        this.f20626sa.produced(r11);
    L11:
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
