package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean allowFatal;
    final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;

    static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4063763155303814625L;
        final boolean allowFatal;
        boolean done;
        final Subscriber<? super T> downstream;
        final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
        boolean once;
        long produced;

        OnErrorNextSubscriber(Subscriber<? super T> r2, Function<? super Throwable, ? extends Publisher<? extends T>> r3, boolean r4) {
            super(false);
            this.downstream = r2;
            this.nextSupplier = r3;
            this.allowFatal = r4;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r1) {
            setSubscription(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.once == true) goto L8;
            this.produced++;
        L8:
            this.downstream.onNext(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r7) {
            if (this.once == true) goto L5;
            this.once = true;
            if (this.allowFatal == true) goto L13;
        L25:
            Publisher r1 = (Publisher) ObjectHelper.requireNonNull(this.nextSupplier.apply(r7), "The nextSupplier returned a null Publisher");     // Catch: Throwable -> L22
            long r2 = this.produced;
            if (r2 == 0) goto L20;
            produced(r2);
        L20:
            r1.subscribe(this);
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r7, th}));
            return;
        L13:
            if ((r7 instanceof Exception) == true) goto L25;
            this.downstream.onError(r7);
            return;
        L5:
            if (this.done == false) goto L8;
            RxJavaPlugins.onError(r7);
            return;
        L8:
            this.downstream.onError(r7);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }
    }

    public FlowableOnErrorNext(Flowable<T> r1, Function<? super Throwable, ? extends Publisher<? extends T>> r2, boolean r3) {
        super(r1);
        this.nextSupplier = r2;
        this.allowFatal = r3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r4) {
        OnErrorNextSubscriber r0 = new OnErrorNextSubscriber(r4, this.nextSupplier, this.allowFatal);
        r4.onSubscribe(r0);
        this.source.subscribe(r0);
    }
}
