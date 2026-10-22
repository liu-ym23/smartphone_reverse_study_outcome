package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
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

    public BoundedSubscriber(Consumer<? super T> r10, Consumer<? super Throwable> r11, Action r12, Consumer<? super Subscription> r13, int r14) {
        this.onNext = r10;
        this.onError = r11;
        this.onComplete = r12;
        this.onSubscribe = r13;
        this.bufferSize = r14;
        this.limit = r14 - (r14 >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        cancel();
    }

    @Override // io.reactivex.observers.LambdaConsumerIntrospection
    public boolean hasCustomOnError() {
        if (this.onError == Functions.f20603f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L12;
        lazySet(r11);
        this.onComplete.run();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a.a(th);
        qf.a.e(th);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        Subscription r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L9;
        lazySet(r12);
        this.onError.accept(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a.a(th);
        qf.a.e(new CompositeException(new Throwable[]{r10, th}));
        return;
    L9:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (isDisposed() == true) goto L17;
        this.onNext.accept(r10);     // Catch: Throwable -> L7
        int r11 = this.consumed + 1;     // Catch: Throwable -> L7
        if (r11 != this.limit) goto L9;
        this.consumed = 0;     // Catch: Throwable -> L7
        get().request(this.limit);     // Catch: Throwable -> L7
    L13:
        return;
    L9:
        this.consumed = r11;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        a.a(th);
        get().cancel();
        onError(th);
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.setOnce(this, r10) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a.a(th);
        r10.cancel();
        onError(th);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        get().request(r10);
    }
}
