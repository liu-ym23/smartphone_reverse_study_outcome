package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableTimeout$TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, FlowableTimeout$TimeoutSelectorSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    final Subscriber<? super T> downstream;
    final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
    final AtomicLong requested;
    final SequentialDisposable task;
    final AtomicReference<Subscription> upstream;

    public FlowableTimeout$TimeoutSubscriber(Subscriber<? super T> r10, Function<? super T, ? extends Publisher<?>> r11) {
        this.downstream = r10;
        this.itemTimeoutIndicator = r11;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.task.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        long r11 = get();
        if (r11 == Long.MAX_VALUE) goto L22;
        long r12 = 1 + r11;
        if (compareAndSet(r11, r12) == false) goto L23;
        Disposable r13 = this.task.get();
        if (r13 == null) goto L10;
        r13.dispose();
    L10:
        this.downstream.onNext(r10);
        Publisher r14 = (Publisher) io.reactivex.internal.functions.a.b(this.itemTimeoutIndicator.apply(r10), "The itemTimeoutIndicator returned a null Publisher.");     // Catch: Throwable -> L16
        FlowableTimeout$TimeoutConsumer r15 = new FlowableTimeout$TimeoutConsumer(r12, this);
        if (this.task.replace(r15) == false) goto L21;
        r14.subscribe(r15);
        return;
    L21:
        return;
    L16:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.get().cancel();
        getAndSet(Long.MAX_VALUE);
        this.downstream.onError(th);
        return;
    L23:
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSupport
    public void onTimeout(long r10) {
        if (compareAndSet(r10, Long.MAX_VALUE) == false) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(new TimeoutException());
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutSelectorSupport
    public void onTimeoutError(long r10, Throwable r11) {
        if (compareAndSet(r10, Long.MAX_VALUE) == false) goto L5;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(r11);
        return;
    L5:
        qf.a.e(r11);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }

    public void startFirstTimeout(Publisher<?> r10) {
        if (r10 == null) goto L7;
        FlowableTimeout$TimeoutConsumer r11 = new FlowableTimeout$TimeoutConsumer(0, this);
        if (this.task.replace(r11) == false) goto L8;
        r10.subscribe(r11);
        return;
    L8:
        return;
    }
}
