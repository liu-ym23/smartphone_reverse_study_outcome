package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class BoundedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;
    final int bufferSize;
    int consumed;
    final int limit;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final Consumer<? super Subscription> onSubscribe;

    public BoundedSubscriber(Consumer<? super T> r1, Consumer<? super Throwable> r2, Action r3, Consumer<? super Subscription> r4, int r5) {
        this.onNext = r1;
        this.onError = r2;
        this.onComplete = r3;
        this.onSubscribe = r4;
        this.bufferSize = r5;
        this.limit = r5 - (r5 >> 2);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r2) {
        if (SubscriptionHelper.setOnce(this, r2) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r2.cancel();
        onError(th);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r3) {
        if (isDisposed() == true) goto L16;
        this.onNext.accept(r3);     // Catch: Throwable -> L9
        int r4 = this.consumed + 1;     // Catch: Throwable -> L9
        if (r4 != this.limit) goto L7;
        this.consumed = 0;     // Catch: Throwable -> L9
        get().request(this.limit);     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        this.consumed = r4;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        get().cancel();
        onError(th);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r4) {
        if (get() == SubscriptionHelper.CANCELLED) goto L9;
        lazySet(SubscriptionHelper.CANCELLED);
        this.onError.accept(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r4, th}));
        return;
    L9:
        RxJavaPlugins.onError(r4);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (get() == SubscriptionHelper.CANCELLED) goto L12;
        lazySet(SubscriptionHelper.CANCELLED);
        this.onComplete.run();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
        get().request(r1);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.observers.LambdaConsumerIntrospection
    public boolean hasCustomOnError() {
        if (this.onError == Functions.ON_ERROR_MISSING) goto L5;
        return true;
    L5:
        return false;
    }
}
