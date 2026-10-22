package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements CompletableObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f20615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompletableObserver f20616b;

    public a(AtomicReference r10, CompletableObserver r11) {
        this.f20615a = r10;
        this.f20616b = r11;
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        this.f20616b.onComplete();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        this.f20616b.onError(r10);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.replace(this.f20615a, r10);
    }
}
