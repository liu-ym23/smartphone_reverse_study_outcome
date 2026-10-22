package io.reactivex.internal.operators.single;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements MaybeObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f20704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MaybeObserver f20705b;

    public a(AtomicReference r10, MaybeObserver r11) {
        this.f20704a = r10;
        this.f20705b = r11;
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.f20705b.onComplete();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.f20705b.onError(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.replace(this.f20704a, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object r10) {
        this.f20705b.onSuccess(r10);
    }
}
