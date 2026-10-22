package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class SingleFlatMapPublisher$SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements SingleObserver<S>, FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 7759721921468635667L;
    Disposable disposable;
    final Subscriber<? super T> downstream;
    final Function<? super S, ? extends Publisher<? extends T>> mapper;
    final AtomicReference<Subscription> parent;

    public SingleFlatMapPublisher$SingleFlatMapPublisherObserver(Subscriber<? super T> r10, Function<? super S, ? extends Publisher<? extends T>> r11) {
        this.downstream = r10;
        this.mapper = r11;
        this.parent = new AtomicReference();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.disposable.dispose();
        SubscriptionHelper.cancel(this.parent);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        this.disposable = r10;
        this.downstream.onSubscribe(this);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(S r10) {
        ((Publisher) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "the mapper returned a null Publisher")).subscribe(this);
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.parent, this, r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this.parent, this, r10);
    }
}
