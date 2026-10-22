package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
abstract class FlowableSampleTimed$SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final Subscriber<? super T> downstream;
    final long period;
    final AtomicLong requested;
    final mf.f scheduler;
    final SequentialDisposable timer;
    final TimeUnit unit;
    Subscription upstream;

    public FlowableSampleTimed$SampleTimedSubscriber(Subscriber<? super T> r10, long r11, TimeUnit r12, mf.f r13) {
        this.requested = new AtomicLong();
        this.timer = new SequentialDisposable();
        this.downstream = r10;
        this.period = r11;
        this.unit = r12;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        cancelTimer();
        this.upstream.cancel();
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

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

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        cancelTimer();
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        lazySet(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == true) goto L5;
        return;
    L5:
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        throw null;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        return;
    }
}
