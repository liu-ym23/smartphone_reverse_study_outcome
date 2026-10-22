package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes4.dex */
public final class l extends io.reactivex.observers.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableWindowBoundarySupplier$WindowBoundaryMainObserver f20690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20691c;

    public l(ObservableWindowBoundarySupplier$WindowBoundaryMainObserver r10) {
        this.f20690b = r10;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f20691c == false) goto L5;
        return;
    L5:
        this.f20691c = true;
        this.f20690b.innerComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.f20691c == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.f20691c = true;
        this.f20690b.innerError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        if (this.f20691c == false) goto L5;
        return;
    L5:
        this.f20691c = true;
        dispose();
        this.f20690b.innerNext(this);
    }
}
