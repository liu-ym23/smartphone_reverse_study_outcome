package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableDebounceTimed$DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final Subscriber<? super T> downstream;
    volatile long index;
    final long timeout;
    Disposable timer;
    final TimeUnit unit;
    Subscription upstream;
    final mf.f.a worker;

    public FlowableDebounceTimed$DebounceTimedSubscriber(Subscriber<? super T> r10, long r11, TimeUnit r12, mf.f.a r13) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
        throw null;
    }

    public void emit(long r10, T r11, FlowableDebounceTimed$DebounceEmitter<T> r12) {
        if (r10 == this.index) goto L5;
        return;
    L5:
        if (get() == 0) goto L7;
        this.downstream.onNext(r11);
        io.reactivex.internal.util.a.e(this, 1);
        r12.dispose();
        return;
    L7:
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        Disposable r10 = this.timer;
        if (r10 == null) goto L8;
        r10.dispose();
    L8:
        FlowableDebounceTimed$DebounceEmitter r11 = (FlowableDebounceTimed$DebounceEmitter) r10;
        if (r11 == null) goto L11;
        r11.emit();
    L11:
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
        Disposable r11 = this.timer;
        if (r11 == null) goto L9;
        r11.dispose();
    L9:
        this.downstream.onError(r10);
        throw null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r11 = this.index + 1;
        this.index = r11;
        Disposable r12 = this.timer;
        if (r12 == null) goto L8;
        r12.dispose();
    L8:
        this.timer = new FlowableDebounceTimed$DebounceEmitter(r10, r11, this);
        throw null;
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
}
