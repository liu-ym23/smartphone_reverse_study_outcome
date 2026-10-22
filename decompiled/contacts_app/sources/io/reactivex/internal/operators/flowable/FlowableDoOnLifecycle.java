package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {
    private final Action onCancel;
    private final LongConsumer onRequest;
    private final Consumer<? super Subscription> onSubscribe;

    static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> downstream;
        final Action onCancel;
        final LongConsumer onRequest;
        final Consumer<? super Subscription> onSubscribe;
        Subscription upstream;

        SubscriptionLambdaSubscriber(Subscriber<? super T> r1, Consumer<? super Subscription> r2, LongConsumer r3, Action r4) {
            this.downstream = r1;
            this.onSubscribe = r2;
            this.onCancel = r4;
            this.onRequest = r3;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            this.onSubscribe.accept(r2);     // Catch: Throwable -> L7
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L12;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        L12:
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
            EmptySubscription.error(th, this.downstream);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            if (this.upstream == SubscriptionHelper.CANCELLED) goto L5;
            this.downstream.onError(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.upstream == SubscriptionHelper.CANCELLED) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            this.onRequest.accept(r2);     // Catch: Throwable -> L4
        L6:
            this.upstream.request(r2);
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            goto L6
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Subscription r0 = this.upstream;
            if (r0 == SubscriptionHelper.CANCELLED) goto L13;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.onCancel.run();     // Catch: Throwable -> L7
        L9:
            r0.cancel();
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            goto L9
        }
    }

    public FlowableDoOnLifecycle(Flowable<T> r1, Consumer<? super Subscription> r2, LongConsumer r3, Action r4) {
        super(r1);
        this.onSubscribe = r2;
        this.onRequest = r3;
        this.onCancel = r4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r5) {
        this.source.subscribe(new SubscriptionLambdaSubscriber(r5, this.onSubscribe, this.onRequest, this.onCancel));
    }
}
