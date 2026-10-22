package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableMergeWithCompletable$MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = -4592979584110982903L;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final AtomicReference<Disposable> mainDisposable;
    volatile boolean mainDone;
    volatile boolean otherDone;
    final OtherObserver otherObserver;

    public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
        private static final long serialVersionUID = -2935427570954647017L;
        final ObservableMergeWithCompletable$MergeWithObserver<?> parent;

        public OtherObserver(ObservableMergeWithCompletable$MergeWithObserver<?> r10) {
            this.parent = r10;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r10) {
            this.parent.otherError(r10);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    public ObservableMergeWithCompletable$MergeWithObserver(Observer<? super T> r10) {
        this.downstream = r10;
        this.mainDisposable = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.mainDisposable.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone == false) goto L6;
        io.reactivex.internal.util.d.a(this.downstream, this, this.error);
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.otherObserver);
        io.reactivex.internal.util.d.c(this.downstream, r10, this, this.error);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        io.reactivex.internal.util.d.e(this.downstream, r10, this, this.error);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this.mainDisposable, r10);
    }

    public void otherComplete() {
        this.otherDone = true;
        if (this.mainDone == false) goto L6;
        io.reactivex.internal.util.d.a(this.downstream, this, this.error);
        return;
    }

    public void otherError(Throwable r10) {
        DisposableHelper.dispose(this.mainDisposable);
        io.reactivex.internal.util.d.c(this.downstream, r10, this, this.error);
    }
}
