package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Predicate<? super T> onNext;

    public ForEachWhileObserver(Predicate<? super T> r10, Consumer<? super Throwable> r11, Action r12) {
        this.onNext = r10;
        this.onError = r11;
        this.onComplete = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.onComplete.run();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        this.onError.accept(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.onNext.test(r10) == true) goto L14;
        dispose();
        onComplete();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dispose();
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
