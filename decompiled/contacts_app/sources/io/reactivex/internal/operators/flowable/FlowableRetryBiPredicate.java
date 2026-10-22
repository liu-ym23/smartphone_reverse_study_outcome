package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableRetryBiPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiPredicate<? super Integer, ? super Throwable> predicate;

    static final class RetryBiSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Subscriber<? super T> downstream;
        final BiPredicate<? super Integer, ? super Throwable> predicate;
        long produced;
        int retries;
        final SubscriptionArbiter sa;
        final Publisher<? extends T> source;

        RetryBiSubscriber(Subscriber<? super T> r1, BiPredicate<? super Integer, ? super Throwable> r2, SubscriptionArbiter r3, Publisher<? extends T> r4) {
            this.downstream = r1;
            this.sa = r3;
            this.source = r4;
            this.predicate = r2;
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
        public void onError(Throwable r6) {
            BiPredicate<? super Integer, ? super Throwable> r1 = this.predicate;     // Catch: Throwable -> L9
            int r2 = this.retries + 1;     // Catch: Throwable -> L9
            this.retries = r2;     // Catch: Throwable -> L9
            if (r1.test(Integer.valueOf(r2), r6) == true) goto L7;
            this.downstream.onError(r6);
            return;
        L7:
            subscribeNext();
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r6, th}));
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

    public FlowableRetryBiPredicate(Flowable<T> r1, BiPredicate<? super Integer, ? super Throwable> r2) {
        super(r1);
        this.predicate = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r4) {
        SubscriptionArbiter r0 = new SubscriptionArbiter(false);
        r4.onSubscribe(r0);
        new RetryBiSubscriber(r4, this.predicate, r0, this.source).subscribeNext();
    }
}
