package com.bytedance.android.livesdk.user;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes11.dex */
public class h<T> implements Observer<T>, SingleObserver<T> {
    public h() {
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
    }

    @Override // io.reactivex.Observer
    public void onNext(T r100) {
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
    }

    public void onSuccess(T r100) {
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        ALogger.e("LiveEmptyObserver", r100);
        if ((r100 instanceof CustomApiServerException) == false) goto L6;
        ALogger.e("LiveEmptyObserver", "ApiServerException thrown, url: " + ((CustomApiServerException) r100).getUrl());
        return;
    }
}
