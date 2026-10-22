package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeZipArray$ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final MaybeZipArray$ZipCoordinator<T, ?> parent;

    public MaybeZipArray$ZipMaybeObserver(MaybeZipArray$ZipCoordinator<T, ?> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.parent.innerError(r10, this.index);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        this.parent.innerSuccess(r10, this.index);
    }
}
