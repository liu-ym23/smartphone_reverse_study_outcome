package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeEqualSingle$EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
    private static final long serialVersionUID = -3031974433025990931L;
    final MaybeEqualSingle$EqualCoordinator<T> parent;
    Object value;

    public MaybeEqualSingle$EqualObserver(MaybeEqualSingle$EqualCoordinator<T> r10) {
        this.parent = r10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.parent.done();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.parent.error(this, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        this.value = r10;
        this.parent.done();
    }
}
