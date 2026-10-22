package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.LambdaConsumerIntrospection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -6076952298809384986L;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onSuccess;

    public MaybeCallbackObserver(Consumer<? super T> r10, Consumer<? super Throwable> r11, Action r12) {
        this.onSuccess = r10;
        this.onError = r11;
        this.onComplete = r12;
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
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        lazySet(DisposableHelper.DISPOSED);
        this.onSuccess.accept(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
    }
}
