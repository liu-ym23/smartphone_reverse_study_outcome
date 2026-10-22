package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f102759a;

    public m(n r100) {
        this.f102759a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        n r101 = this.f102759a;
        r101.finishWithFailure(r100);
    }
}
