package com.bytedance.android.livesdk.gamecp.utils;

import com.bytedance.android.gamecp.base.network.exception.CustomApiServerException;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Observer<T>, SingleObserver<T> {
    public e() {
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T r100) {
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        yr.b.a("LiveEmptyObserver", r100);
        if ((r100 instanceof CustomApiServerException) == false) goto L6;
        yr.b.b(6, "LiveEmptyObserver", "ApiServerException thrown, url: " + ((CustomApiServerException) r100).getUrl());
        return;
    }
}
