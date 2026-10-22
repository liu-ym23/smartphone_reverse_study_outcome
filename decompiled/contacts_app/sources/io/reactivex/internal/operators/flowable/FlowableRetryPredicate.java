package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
    final long count;
    final Predicate<? super Throwable> predicate;

    static final class RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Subscriber<? super T> downstream;
        final Predicate<? super Throwable> predicate;
        long produced;
        long remaining;
        final SubscriptionArbiter sa;
        final Publisher<? extends T> source;

        RetrySubscriber(Subscriber<? super T> r1, long r2, Predicate<? super Throwable> r4, SubscriptionArbiter r5, Publisher<? extends T> r6) {
            this.downstream = r1;
            this.sa = r5;
            this.source = r6;
            this.predicate = r4;
            this.remaining = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r1) {
            this.sa.setSubscription(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r5) {
            long r0 = this.remaining;
            if (r0 == Long.MAX_VALUE) goto L6;
            this.remaining = r0 - 1;
        L6:
            if (r0 != 0) goto L17;
            this.downstream.onError(r5);
            return;
        L17:
            if (this.predicate.test(r5) == true) goto L12;
            this.downstream.onError(r5);
            return;
        L12:
            subscribeNext();
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        void subscribeNext() {
            if (getAndIncrement() != 0) goto L13;
            int r0 = 1;
        L6:
            if (this.sa.isCancelled() == true) goto L7;
            long r1 = this.produced;
            if (r1 == 0) goto L11;
            this.produced = 0;
            this.sa.produced(r1);
        L11:
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L7:
            return;
        }
    }

    public FlowableRetryPredicate(Flowable<T> r1, long r2, Predicate<? super Throwable> r4) {
        super(r1);
        this.predicate = r4;
        this.count = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r9) {
        SubscriptionArbiter r5 = new SubscriptionArbiter(false);
        r9.onSubscribe(r5);
        new RetrySubscriber(r9, this.count, this.predicate, r5, this.source).subscribeNext();
    }
}
