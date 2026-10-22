package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Consumer<Throwable>, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -4361286194466301354L;
    final Action onComplete;
    final Consumer<? super Throwable> onError;

    public CallbackCompletableObserver(Action r10) {
        this.onError = this;
        this.onComplete = r10;
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Throwable r10) throws Exception {
        accept2(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.observers.LambdaConsumerIntrospection
    public boolean hasCustomOnError() {
        if (this.onError == this) goto L5;
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

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        this.onComplete.run();     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        goto L6
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        this.onError.accept(r10);     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        goto L6
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Throwable r10) {
        qf.a.e(new OnErrorNotImplementedException(r10));
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> r10, Action r11) {
        this.onError = r10;
        this.onComplete = r11;
    }
}
