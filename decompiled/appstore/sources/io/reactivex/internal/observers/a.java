package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements SingleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f20611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SingleObserver f20612b;

    public a(AtomicReference r10, SingleObserver r11) {
        this.f20611a = r10;
        this.f20612b = r11;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.f20612b.onError(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.replace(this.f20611a, r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object r10) {
        this.f20612b.onSuccess(r10);
    }
}
