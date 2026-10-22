package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class SingleZipArray$ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final SingleZipArray$ZipCoordinator<T, ?> parent;

    public SingleZipArray$ZipSingleObserver(SingleZipArray$ZipCoordinator<T, ?> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.parent.innerError(r10, this.index);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        this.parent.innerSuccess(r10, this.index);
    }
}
