package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {
    final SingleObserver<? super T> downstream;
    final AtomicReference<Disposable> parent;

    public ResumeSingleObserver(AtomicReference<Disposable> r1, SingleObserver<? super T> r2) {
        this.parent = r1;
        this.downstream = r2;
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r1) {
        DisposableHelper.replace(this.parent, r1);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r1) {
        this.downstream.onSuccess(r1);
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r1) {
        this.downstream.onError(r1);
    }
}
