package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f129724a;

    public p(q r100) {
        this.f129724a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        q r101 = this.f129724a;
        r101.finishWithFailure((Throwable) r100);
    }
}
