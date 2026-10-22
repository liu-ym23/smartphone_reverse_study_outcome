package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
abstract class FlowableSamplePublisher$SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -3517602651313910099L;
    final Subscriber<? super T> downstream;
    final AtomicReference<Subscription> other;
    final AtomicLong requested;
    final Publisher<?> sampler;
    Subscription upstream;

    public FlowableSamplePublisher$SamplePublisherSubscriber(Subscriber<? super T> r10, Publisher<?> r11) {
        this.requested = new AtomicLong();
        this.other = new AtomicReference();
        this.downstream = r10;
        this.sampler = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        this.upstream.cancel();
    }

    public void complete() {
        this.upstream.cancel();
        completion();
    }

    public abstract void completion();

    public void emit() {
        T r10 = getAndSet(null);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.requested.get() == 0) goto L7;
        this.downstream.onNext(r10);
        io.reactivex.internal.util.a.e(this.requested, 1);
        return;
    L7:
        cancel();
        this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
    }

    public void error(Throwable r10) {
        this.upstream.cancel();
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        completion();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        lazySet(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L8;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        if (this.other.get() != null) goto L9;
        this.sampler.subscribe(new g(this));
        r10.request(Long.MAX_VALUE);
        return;
    L9:
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        return;
    }

    public abstract void run();

    public void setOther(Subscription r10) {
        SubscriptionHelper.setOnce(this.other, r10, Long.MAX_VALUE);
    }
}
