package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableZip$ZipCoordinator f20692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.a f20693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f20694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f20695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference f20696e;

    public m(ObservableZip$ZipCoordinator r10, int r11) {
        this.f20696e = new AtomicReference();
        this.f20692a = r10;
        this.f20693b = new io.reactivex.internal.queue.a(r11);
    }

    public void a() {
        DisposableHelper.dispose(this.f20696e);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f20694c = true;
        this.f20692a.drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.f20695d = r10;
        this.f20694c = true;
        this.f20692a.drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        this.f20693b.offer(r10);
        this.f20692a.drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this.f20696e, r10);
    }
}
