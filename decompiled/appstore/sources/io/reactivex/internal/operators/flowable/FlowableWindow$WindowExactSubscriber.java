package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableWindow$WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
    private static final long serialVersionUID = -2365647875069161133L;
    final int bufferSize;
    final Subscriber<? super mf.b> downstream;
    long index;
    final AtomicBoolean once;
    final long size;
    Subscription upstream;
    UnicastProcessor window;

    public FlowableWindow$WindowExactSubscriber(Subscriber<? super mf.b> r10, long r11, int r12) {
        super(1);
        this.downstream = r10;
        this.size = r11;
        this.once = new AtomicBoolean();
        this.bufferSize = r12;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        run();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        UnicastProcessor r10 = this.window;
        if (r10 == null) goto L5;
        this.window = null;
        r10.onComplete();
    L5:
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        UnicastProcessor r11 = this.window;
        if (r11 == null) goto L5;
        this.window = null;
        r11.onError(r10);
    L5:
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        long r11 = this.index;
        UnicastProcessor r12 = this.window;
        if (r11 != 0) goto L5;
        getAndIncrement();
        r12 = UnicastProcessor.f(this.bufferSize, this);
        this.window = r12;
        this.downstream.onNext(r12);
    L5:
        long r13 = r11 + 1;
        r12.onNext(r10);
        if (r13 != this.size) goto L8;
        this.index = 0;
        this.window = null;
        r12.onComplete();
        return;
    L8:
        this.index = r13;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        long r11 = io.reactivex.internal.util.a.d(this.size, r10);
        this.upstream.request(r11);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() != 0) goto L6;
        this.upstream.cancel();
        return;
    }
}
