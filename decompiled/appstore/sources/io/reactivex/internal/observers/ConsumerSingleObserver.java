package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.LambdaConsumerIntrospection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7012088219455310787L;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onSuccess;

    public ConsumerSingleObserver(Consumer<? super T> r10, Consumer<? super Throwable> r11) {
        this.onSuccess = r10;
        this.onError = r11;
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

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.SingleObserver
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
