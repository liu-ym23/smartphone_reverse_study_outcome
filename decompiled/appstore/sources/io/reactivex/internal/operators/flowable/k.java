package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends io.reactivex.subscribers.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber f20647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20648c;

    public k(FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber r10) {
        this.f20647b = r10;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f20648c == false) goto L5;
        return;
    L5:
        this.f20648c = true;
        this.f20647b.innerComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.f20648c == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.f20648c = true;
        this.f20647b.innerError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        if (this.f20648c == false) goto L5;
        return;
    L5:
        this.f20648c = true;
        dispose();
        this.f20647b.innerNext(this);
    }
}
