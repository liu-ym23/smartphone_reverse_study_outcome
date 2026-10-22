package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class i1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f63433a;

    public i1(l1 r100) {
        this.f63433a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        l1 r101 = this.f63433a;
        r101.finishWithFailure((Throwable) r100);
    }
}
