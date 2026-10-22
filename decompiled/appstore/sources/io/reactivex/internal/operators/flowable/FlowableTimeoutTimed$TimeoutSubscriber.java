package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableTimeoutTimed$TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, FlowableTimeoutTimed$TimeoutSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    final Subscriber<? super T> downstream;
    final AtomicLong requested;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<Subscription> upstream;
    final mf.f.a worker;

    public FlowableTimeoutTimed$TimeoutSubscriber(Subscriber<? super T> r10, long r11, TimeUnit r12, mf.f.a r13) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) goto L5;
        return;
    L5:
        this.task.dispose();
        this.downstream.onComplete();
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.task.dispose();
        this.downstream.onError(r10);
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        long r11 = get();
        if (r11 == Long.MAX_VALUE) goto L9;
        long r12 = 1 + r11;
        if (compareAndSet(r11, r12) == false) goto L10;
        this.task.get().dispose();
        this.downstream.onNext(r10);
        startTimeout(r12);
        return;
    L10:
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSupport
    public void onTimeout(long r10) {
        if (compareAndSet(r10, Long.MAX_VALUE) == true) goto L5;
        return;
    L5:
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(new TimeoutException(ExceptionHelper.c(this.timeout, this.unit)));
        throw null;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }

    public void startTimeout(long r10) {
        new i(r10, this);
        throw null;
    }
}
