package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableTimeoutTimed$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, FlowableTimeoutTimed$TimeoutSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    long consumed;
    final Subscriber<? super T> downstream;
    Publisher<? extends T> fallback;
    final AtomicLong index;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<Subscription> upstream;
    final mf.f.a worker;

    public FlowableTimeoutTimed$TimeoutFallbackSubscriber(Subscriber<? super T> r10, long r11, TimeUnit r12, mf.f.a r13, Publisher<? extends T> r14) {
        super(true);
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.fallback = r14;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.index = new AtomicLong();
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) goto L5;
        return;
    L5:
        this.task.dispose();
        this.downstream.onComplete();
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.task.dispose();
        this.downstream.onError(r10);
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        long r11 = this.index.get();
        if (r11 == Long.MAX_VALUE) goto L9;
        long r12 = r11 + 1;
        if (this.index.compareAndSet(r11, r12) == false) goto L10;
        this.task.get().dispose();
        this.consumed++;
        this.downstream.onNext(r10);
        startTimeout(r12);
        return;
    L10:
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.setOnce(this.upstream, r10) == false) goto L6;
        setSubscription(r10);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSupport
    public void onTimeout(long r10) {
        if (this.index.compareAndSet(r10, Long.MAX_VALUE) == false) goto L9;
        SubscriptionHelper.cancel(this.upstream);
        long r11 = this.consumed;
        if (r11 == 0) goto L7;
        produced(r11);
    L7:
        Publisher<? extends T> r12 = this.fallback;
        this.fallback = null;
        r12.subscribe(new h(this.downstream, this));
        throw null;
    }

    public void startTimeout(long r10) {
        new i(r10, this);
        throw null;
    }
}
