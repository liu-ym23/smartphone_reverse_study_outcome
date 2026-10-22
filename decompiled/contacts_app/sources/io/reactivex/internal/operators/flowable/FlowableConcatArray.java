package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableConcatArray<T> extends Flowable<T> {
    final boolean delayError;
    final Publisher<? extends T>[] sources;

    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final boolean delayError;
        final Subscriber<? super T> downstream;
        List<Throwable> errors;
        int index;
        long produced;
        final Publisher<? extends T>[] sources;
        final AtomicInteger wip;

        ConcatArraySubscriber(Publisher<? extends T>[] r2, boolean r3, Subscriber<? super T> r4) {
            super(false);
            this.downstream = r4;
            this.sources = r2;
            this.delayError = r3;
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r1) {
            setSubscription(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r4) {
            if (this.delayError == false) goto L8;
            List r0 = this.errors;
            if (r0 != null) goto L7;
            r0 = new ArrayList((this.sources.length - this.index) + 1);
            this.errors = r0;
        L7:
            r0.add(r4);
            onComplete();
            return;
        L8:
            this.downstream.onError(r4);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.wip.getAndIncrement() != 0) goto L30;
            Publisher<? extends T>[] r0 = this.sources;
            int r1 = r0.length;
            int r2 = this.index;
        L6:
            if (r2 == r1) goto L7;
            Publisher<? extends T> r4 = r0[r2];
            if (r4 == null) goto L17;
            long r5 = this.produced;
            if (r5 == 0) goto L28;
            this.produced = 0;
            produced(r5);
        L28:
            r4.subscribe(this);
            r2 = r2 + 1;
            this.index = r2;
            if (this.wip.decrementAndGet() != 0) goto L6;
            return;
        L17:
            NullPointerException r6 = new NullPointerException("A Publisher entry is null");
            if (this.delayError == false) goto L23;
            List r7 = this.errors;
            if (r7 != null) goto L22;
            r7 = new ArrayList((r1 - r2) + 1);
            this.errors = r7;
        L22:
            r7.add(r6);
            r2 = r2 + 1;
            goto L6
        L23:
            this.downstream.onError(r6);
            return;
        L7:
            List<Throwable> r3 = this.errors;
            if (r3 != null) goto L10;
            this.downstream.onComplete();
            return;
        L10:
            if (r3.size() != 1) goto L12;
            this.downstream.onError(r3.get(0));
            return;
        L12:
            this.downstream.onError(new CompositeException(r3));
            return;
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] r1, boolean r2) {
        this.sources = r1;
        this.delayError = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        ConcatArraySubscriber r0 = new ConcatArraySubscriber(this.sources, this.delayError, r3);
        r3.onSubscribe(r0);
        r0.onComplete();
    }
}
