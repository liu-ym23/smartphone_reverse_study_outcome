package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableThrottleFirstTimed$DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final Subscriber<? super T> downstream;
    volatile boolean gate;
    final long timeout;
    final SequentialDisposable timer;
    final TimeUnit unit;
    Subscription upstream;
    final mf.f.a worker;

    public FlowableThrottleFirstTimed$DebounceTimedSubscriber(Subscriber<? super T> r10, long r11, TimeUnit r12, mf.f.a r13) {
        this.timer = new SequentialDisposable();
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.gate == true) goto L16;
        this.gate = true;
        if (get() == 0) goto L14;
        this.downstream.onNext(r10);
        io.reactivex.internal.util.a.e(this, 1);
        Disposable r11 = this.timer.get();
        if (r11 == null) goto L13;
        r11.dispose();
    L13:
        throw null;
    L14:
        this.done = true;
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this, r10);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
