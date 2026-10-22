package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements SingleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f20662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MaybeObserver f20663b;

    public c(AtomicReference r10, MaybeObserver r11) {
        this.f20662a = r10;
        this.f20663b = r11;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.f20663b.onError(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.replace(this.f20662a, r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object r10) {
        this.f20663b.onSuccess(r10);
    }
}
