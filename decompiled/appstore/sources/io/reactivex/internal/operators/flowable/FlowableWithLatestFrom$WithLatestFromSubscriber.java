package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiFunction;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableWithLatestFrom$WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
    private static final long serialVersionUID = -312246233408980075L;
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Subscriber<? super R> downstream;
    final AtomicReference<Subscription> other;
    final AtomicLong requested;
    final AtomicReference<Subscription> upstream;

    public FlowableWithLatestFrom$WithLatestFromSubscriber(Subscriber<? super R> r10, BiFunction<? super T, ? super U, ? extends R> r11) {
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.other = new AtomicReference();
        this.downstream = r10;
        this.combiner = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (tryOnNext(r10) == true) goto L6;
        this.upstream.get().request(1);
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    public void otherError(Throwable r10) {
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }

    public boolean setOther(Subscription r10) {
        return SubscriptionHelper.setOnce(this.other, r10);
    }

    @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
    public boolean tryOnNext(T r10) {
        U r11 = get();
        if (r11 != null) goto L10;
    L9:
        return false;
    L10:
        Object r12 = io.reactivex.internal.functions.a.b(this.combiner.apply(r10, r11), "The combiner returned a null value");     // Catch: Throwable -> L7
        this.downstream.onNext(r12);
        return true;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        this.downstream.onError(th);
        goto L9
    }
}
