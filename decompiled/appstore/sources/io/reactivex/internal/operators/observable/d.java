package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends of.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableGroupBy$State f20672b;

    public d(Object r10, ObservableGroupBy$State r11) {
        super(r10);
        this.f20672b = r11;
    }

    public static d c(Object r10, int r11, ObservableGroupBy$GroupByObserver r12, boolean r13) {
        return new d(r10, new ObservableGroupBy$State(r11, r12, r10, r13));
    }

    @Override // mf.e
    public void b(Observer r10) {
        this.f20672b.subscribe(r10);
    }

    public void onComplete() {
        this.f20672b.onComplete();
    }

    public void onError(Throwable r10) {
        this.f20672b.onError(r10);
    }

    public void onNext(Object r10) {
        this.f20672b.onNext(r10);
    }
}
