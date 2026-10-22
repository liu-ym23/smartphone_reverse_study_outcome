package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableUnsubscribeOn$UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
    private static final long serialVersionUID = 1015244841293359600L;
    final Observer<? super T> downstream;
    final mf.f scheduler;
    Disposable upstream;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableUnsubscribeOn$UnsubscribeObserver f20671a;

        public a(ObservableUnsubscribeOn$UnsubscribeObserver r10) {
            this.f20671a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20671a.upstream.dispose();
        }
    }

    public ObservableUnsubscribeOn$UnsubscribeObserver(Observer<? super T> r10, mf.f r11) {
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        new a(this);
        throw null;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (get() == true) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (get() == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (get() == true) goto L6;
        this.downstream.onNext(r10);
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
