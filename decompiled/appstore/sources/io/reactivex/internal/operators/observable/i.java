package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer f20684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f20685b;

    public i(Observer r10, AtomicReference r11) {
        this.f20684a = r10;
        this.f20685b = r11;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f20684a.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.f20684a.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        this.f20684a.onNext(r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.replace(this.f20685b, r10);
    }
}
