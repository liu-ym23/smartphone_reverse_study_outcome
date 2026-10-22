package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class SingleSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    final SingleObserver<? super T> downstream;
    final SingleSource<? extends T> source;
    final SequentialDisposable task;

    public SingleSubscribeOn$SubscribeOnObserver(SingleObserver<? super T> r10, SingleSource<? extends T> r11) {
        this.downstream = r10;
        this.source = r11;
        this.task = new SequentialDisposable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.subscribe(this);
    }
}
