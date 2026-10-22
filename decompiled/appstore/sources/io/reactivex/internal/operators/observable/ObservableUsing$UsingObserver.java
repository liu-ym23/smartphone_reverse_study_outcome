package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableUsing$UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
    private static final long serialVersionUID = 5904473792286235046L;
    final Consumer<? super D> disposer;
    final Observer<? super T> downstream;
    final boolean eager;
    final D resource;
    Disposable upstream;

    public ObservableUsing$UsingObserver(Observer<? super T> r10, D r11, Consumer<? super D> r12, boolean r13) {
        this.downstream = r10;
        this.resource = r11;
        this.disposer = r12;
        this.eager = r13;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        disposeAfter();
        this.upstream.dispose();
    }

    public void disposeAfter() {
        if (compareAndSet(false, true) == false) goto L11;
        this.disposer.accept(this.resource);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.eager == true) goto L5;
        this.downstream.onComplete();
        this.upstream.dispose();
        disposeAfter();
        return;
    L5:
        if (compareAndSet(false, true) == true) goto L14;
    L11:
        this.upstream.dispose();
        this.downstream.onComplete();
        return;
    L14:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.eager == true) goto L5;
        this.downstream.onError(r10);
        this.upstream.dispose();
        disposeAfter();
        return;
    L5:
        if (compareAndSet(false, true) == true) goto L13;
    L10:
        this.upstream.dispose();
        this.downstream.onError(r10);
        return;
    L13:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10 = new CompositeException(new Throwable[]{r10, th});
        goto L10
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
