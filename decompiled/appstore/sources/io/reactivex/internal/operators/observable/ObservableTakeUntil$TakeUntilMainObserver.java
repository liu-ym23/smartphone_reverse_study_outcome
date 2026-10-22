package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableTakeUntil$TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = 1418547743690811973L;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final ObservableTakeUntil$TakeUntilMainObserver<T, U>.OtherObserver otherObserver;
    final AtomicReference<Disposable> upstream;

    public final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -8693423678067375039L;
        final /* synthetic */ ObservableTakeUntil$TakeUntilMainObserver this$0;

        public OtherObserver(ObservableTakeUntil$TakeUntilMainObserver r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.this$0.otherComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r10) {
            this.this$0.otherError(r10);
        }

        @Override // io.reactivex.Observer
        public void onNext(U r10) {
            DisposableHelper.dispose(this);
            this.this$0.otherComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    public ObservableTakeUntil$TakeUntilMainObserver(Observer<? super T> r10) {
        this.downstream = r10;
        this.upstream = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        DisposableHelper.dispose(this.otherObserver);
        io.reactivex.internal.util.d.a(this.downstream, this, this.error);
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
        DisposableHelper.setOnce(this.upstream, r10);
    }

    public void otherComplete() {
        DisposableHelper.dispose(this.upstream);
        io.reactivex.internal.util.d.a(this.downstream, this, this.error);
    }

    public void otherError(Throwable r10) {
        DisposableHelper.dispose(this.upstream);
        io.reactivex.internal.util.d.c(this.downstream, r10, this, this.error);
    }
}
