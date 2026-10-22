package com.bytedance.android.livesdk.jsbridge.methods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j5<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h5 f142147a;

    public j5(h5 r100) {
        this.f142147a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f142147a.finishWithFailure();
    }
}
