package com.bytedance.android.live.browser.jsbridge.prefetch;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.c f63798a;

    public d(a.c r100) {
        this.f63798a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        a r101 = this.f63798a.f63792a;
        r101.finishWithFailure((Throwable) r100);
    }
}
