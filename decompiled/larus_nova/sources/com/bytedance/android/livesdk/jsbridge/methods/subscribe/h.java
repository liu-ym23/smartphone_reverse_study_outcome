package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f142198a;

    public h(e r100) {
        this.f142198a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        e r101 = this.f142198a;
        r101.finishWithFailure((Throwable) r100);
    }
}
