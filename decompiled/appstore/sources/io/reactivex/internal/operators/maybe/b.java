package io.reactivex.internal.operators.maybe;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements SingleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f20660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SingleObserver f20661b;

    public b(AtomicReference r10, SingleObserver r11) {
        this.f20660a = r10;
        this.f20661b = r11;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.f20661b.onError(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.replace(this.f20660a, r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object r10) {
        this.f20661b.onSuccess(r10);
    }
}
