package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class h4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e4 f63418a;

    public h4(e4 r100) {
        this.f63418a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        e4 r101 = this.f63418a;
        r101.finishWithFailure((Throwable) r100);
    }
}
