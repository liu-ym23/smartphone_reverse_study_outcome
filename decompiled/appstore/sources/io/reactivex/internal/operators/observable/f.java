package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableSampleWithObservable$SampleMainObserver f20673a;

    public f(ObservableSampleWithObservable$SampleMainObserver r10) {
        this.f20673a = r10;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f20673a.complete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.f20673a.error(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        this.f20673a.run();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        this.f20673a.setOther(r10);
    }
}
