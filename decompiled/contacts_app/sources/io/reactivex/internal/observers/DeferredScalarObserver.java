package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected Disposable upstream;

    public DeferredScalarObserver(Observer<? super R> r1) {
        super(r1);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r2) {
        if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
        this.upstream = r2;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r2) {
        this.value = null;
        error(r2);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        T r0 = this.value;
        if (r0 == null) goto L5;
        this.value = null;
        complete(r0);
        return;
    L5:
        complete();
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }
}
