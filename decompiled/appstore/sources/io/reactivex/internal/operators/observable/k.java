package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends io.reactivex.observers.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableWindowBoundary$WindowBoundaryMainObserver f20688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20689c;

    public k(ObservableWindowBoundary$WindowBoundaryMainObserver r10) {
        this.f20688b = r10;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f20689c == false) goto L5;
        return;
    L5:
        this.f20689c = true;
        this.f20688b.innerComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.f20689c == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.f20689c = true;
        this.f20688b.innerError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        if (this.f20689c == false) goto L5;
        return;
    L5:
        this.f20688b.innerNext();
    }
}
