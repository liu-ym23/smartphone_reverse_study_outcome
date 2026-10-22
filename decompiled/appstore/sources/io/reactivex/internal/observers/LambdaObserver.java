package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.LambdaConsumerIntrospection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final Consumer<? super Disposable> onSubscribe;

    public LambdaObserver(Consumer<? super T> r10, Consumer<? super Throwable> r11, Action r12, Consumer<? super Disposable> r13) {
        this.onNext = r10;
        this.onError = r11;
        this.onComplete = r12;
        this.onSubscribe = r13;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
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
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (isDisposed() == true) goto L12;
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.run();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (isDisposed() == true) goto L9;
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(new CompositeException(new Throwable[]{r10, th}));
        return;
    L9:
        qf.a.e(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (isDisposed() == true) goto L11;
        this.onNext.accept(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        get().dispose();
        onError(th);
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.dispose();
        onError(th);
        return;
    }
}
