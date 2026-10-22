package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableOnBackpressureDrop$BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -6246093802440953054L;
    boolean done;
    final Subscriber<? super T> downstream;
    final Consumer<? super T> onDrop;
    Subscription upstream;

    public FlowableOnBackpressureDrop$BackpressureDropSubscriber(Subscriber<? super T> r10, Consumer<? super T> r11) {
        this.downstream = r10;
        this.onDrop = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (get() == 0) goto L13;
        this.downstream.onNext(r10);
        io.reactivex.internal.util.a.e(this, 1);
        return;
    L13:
        this.onDrop.accept(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        onError(th);
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
