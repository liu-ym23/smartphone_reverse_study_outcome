package com.bytedance.android.livesdk.lottie;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f153474a;

    public h(k r100) {
        this.f153474a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ((LottieService.a) this.f153474a.f153478c).f153466a.onNext(0);
    }
}
