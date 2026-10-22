package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableSequenceEqual$EqualCoordinator f20674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.a f20675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f20677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f20678e;

    public g(ObservableSequenceEqual$EqualCoordinator r10, int r11, int r12) {
        this.f20674a = r10;
        this.f20676c = r11;
        this.f20675b = new io.reactivex.internal.queue.a(r12);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f20677d = true;
        this.f20674a.drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.f20678e = r10;
        this.f20677d = true;
        this.f20674a.drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        this.f20675b.offer(r10);
        this.f20674a.drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        this.f20674a.setDisposable(r10, this.f20676c);
    }
}
