package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> downstream;
        boolean notSkipping;
        final Predicate<? super T> predicate;
        Subscription upstream;

        SkipWhileSubscriber(Subscriber<? super T> r1, Predicate<? super T> r2) {
            this.downstream = r1;
            this.predicate = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.notSkipping == false) goto L13;
            this.downstream.onNext(r3);
            return;
        L13:
            if (this.predicate.test(r3) == false) goto L8;
            this.upstream.request(1);
            return;
        L8:
            this.notSkipping = true;
            this.downstream.onNext(r3);
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }
    }

    public FlowableSkipWhile(Flowable<T> r1, Predicate<? super T> r2) {
        super(r1);
        this.predicate = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        this.source.subscribe(new SkipWhileSubscriber(r3, this.predicate));
    }
}
