package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeObserver<T> implements Observer<T>, Disposable {
    boolean done;
    final Observer<? super T> downstream;
    Disposable upstream;

    public SafeObserver(Observer<? super T> r1) {
        this.downstream = r1;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L18;
        this.upstream = r5;
        this.downstream.onSubscribe(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.done = true;
        r5.dispose();     // Catch: Throwable -> L11
        RxJavaPlugins.onError(th);
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th}));
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r6) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.upstream != null) goto L10;
        onNextNoSubscription();
        return;
    L10:
        if (r6 != null) goto L32;
        NullPointerException r7 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.upstream.dispose();     // Catch: Throwable -> L15
        onError(r7);
        return;
    L15:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        onError(new CompositeException(new Throwable[]{r7, th}));
        return;
    L32:
        this.downstream.onNext(r6);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.upstream.dispose();     // Catch: Throwable -> L25
        onError(th);
        return;
    L25:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        onError(new CompositeException(new Throwable[]{th, th}));
    }

    void onNextNoSubscription() {
        this.done = true;
        NullPointerException r1 = new NullPointerException("Subscription not set!");
        this.downstream.onSubscribe(EmptyDisposable.INSTANCE);     // Catch: Throwable -> L9
        this.downstream.onError(r1);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r1, th}));
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r1, th}));
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r8) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r8);
        return;
    L6:
        this.done = true;
        if (this.upstream != null) goto L18;
        NullPointerException r1 = new NullPointerException("Subscription not set!");
        this.downstream.onSubscribe(EmptyDisposable.INSTANCE);     // Catch: Throwable -> L15
        this.downstream.onError(new CompositeException(new Throwable[]{r8, r1}));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r8, r1, th}));
        return;
    L15:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r8, r1, th}));
        return;
    L18:
        if (r8 != null) goto L29;
        r8 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L29:
        this.downstream.onError(r8);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r8, th}));
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        if (this.upstream != null) goto L14;
        onCompleteNoSubscription();
        return;
    L14:
        this.downstream.onComplete();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    void onCompleteNoSubscription() {
        NullPointerException r0 = new NullPointerException("Subscription not set!");
        this.downstream.onSubscribe(EmptyDisposable.INSTANCE);     // Catch: Throwable -> L9
        this.downstream.onError(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r0, th}));
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r0, th}));
    }
}
