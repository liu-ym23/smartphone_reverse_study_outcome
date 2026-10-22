package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableSequenceEqualSingle$EqualCoordinator f20679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.a f20680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f20682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f20683e;

    public h(ObservableSequenceEqualSingle$EqualCoordinator r10, int r11, int r12) {
        this.f20679a = r10;
        this.f20681c = r11;
        this.f20680b = new io.reactivex.internal.queue.a(r12);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f20682d = true;
        this.f20679a.drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.f20683e = r10;
        this.f20682d = true;
        this.f20679a.drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        this.f20680b.offer(r10);
        this.f20679a.drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        this.f20679a.setDisposable(r10, this.f20681c);
    }
}
