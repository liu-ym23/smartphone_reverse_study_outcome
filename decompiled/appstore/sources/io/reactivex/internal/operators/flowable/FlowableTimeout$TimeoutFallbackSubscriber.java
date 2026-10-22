package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableTimeout$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, FlowableTimeout$TimeoutSelectorSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    long consumed;
    final Subscriber<? super T> downstream;
    Publisher<? extends T> fallback;
    final AtomicLong index;
    final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<Subscription> upstream;

    public FlowableTimeout$TimeoutFallbackSubscriber(Subscriber<? super T> r10, Function<? super T, ? extends Publisher<?>> r11, Publisher<? extends T> r12) {
        super(true);
        this.downstream = r10;
        this.itemTimeoutIndicator = r11;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.fallback = r12;
        this.index = new AtomicLong();
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.task.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        this.task.dispose();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        this.task.dispose();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        long r11 = this.index.get();
        if (r11 == Long.MAX_VALUE) goto L22;
        long r12 = r11 + 1;
        if (this.index.compareAndSet(r11, r12) == false) goto L23;
        Disposable r13 = this.task.get();
        if (r13 == null) goto L10;
        r13.dispose();
    L10:
        this.consumed++;
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
        this.index.getAndSet(Long.MAX_VALUE);
        this.downstream.onError(th);
        return;
    L23:
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
        Publisher<? extends T> r11 = this.fallback;
        this.fallback = null;
        long r12 = this.consumed;
        if (r12 == 0) goto L7;
        produced(r12);
    L7:
        r11.subscribe(new h(this.downstream, this));
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutSelectorSupport
    public void onTimeoutError(long r10, Throwable r11) {
        if (this.index.compareAndSet(r10, Long.MAX_VALUE) == false) goto L5;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(r11);
        return;
    L5:
        qf.a.e(r11);
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
