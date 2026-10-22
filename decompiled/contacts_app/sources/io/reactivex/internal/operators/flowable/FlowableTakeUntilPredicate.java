package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableTakeUntilPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    static final class InnerSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super T> downstream;
        final Predicate<? super T> predicate;
        Subscription upstream;

        InnerSubscriber(Subscriber<? super T> r1, Predicate<? super T> r2) {
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
        public void onNext(T r2) {
            if (this.done == true) goto L13;
            this.downstream.onNext(r2);
            if (this.predicate.test(r2) == false) goto L14;
            this.done = true;
            this.upstream.cancel();
            this.downstream.onComplete();
            return;
        L14:
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == true) goto L5;
            this.done = true;
            this.downstream.onError(r2);
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onComplete();
            return;
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

    public FlowableTakeUntilPredicate(Flowable<T> r1, Predicate<? super T> r2) {
        super(r1);
        this.predicate = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        this.source.subscribe(new InnerSubscriber(r3, this.predicate));
    }
}
