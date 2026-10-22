package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleFlatMapPublisher<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final SingleSource<T> source;

    static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements SingleObserver<S>, FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7759721921468635667L;
        Disposable disposable;
        final Subscriber<? super T> downstream;
        final Function<? super S, ? extends Publisher<? extends T>> mapper;
        final AtomicReference<Subscription> parent;

        SingleFlatMapPublisherObserver(Subscriber<? super T> r1, Function<? super S, ? extends Publisher<? extends T>> r2) {
            this.downstream = r1;
            this.mapper = r2;
            this.parent = new AtomicReference();
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.disposable = r1;
            this.downstream.onSubscribe(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(S r2) {
            ((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(r2), "the mapper returned a null Publisher")).subscribe(this);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this.parent, this, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.parent, this, r2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.disposable.dispose();
            SubscriptionHelper.cancel(this.parent);
        }
    }

    public SingleFlatMapPublisher(SingleSource<T> r1, Function<? super T, ? extends Publisher<? extends R>> r2) {
        this.source = r1;
        this.mapper = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r3) {
        this.source.subscribe(new SingleFlatMapPublisherObserver(r3, this.mapper));
    }
}
