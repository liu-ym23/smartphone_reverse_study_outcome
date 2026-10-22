package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableCollect<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;

    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final BiConsumer<? super U, ? super T> collector;
        boolean done;
        final U u;
        Subscription upstream;

        CollectSubscriber(Subscriber<? super U> r1, U r2, BiConsumer<? super U, ? super T> r3) {
            super(r1);
            this.collector = r3;
            this.u = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.done == false) goto L10;
            return;
        L10:
            this.collector.accept(this.u, r3);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            complete(this.u);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }

    public FlowableCollect(Flowable<T> r1, Callable<? extends U> r2, BiConsumer<? super U, ? super T> r3) {
        super(r1);
        this.initialSupplier = r2;
        this.collector = r3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> r4) {
        Object r0 = ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initial value supplied is null");     // Catch: Throwable -> L5
        this.source.subscribe(new CollectSubscriber(r4, r0, this.collector));
        return;
    L5:
        th = move-exception;
        EmptySubscription.error(th, r4);
    }
}
