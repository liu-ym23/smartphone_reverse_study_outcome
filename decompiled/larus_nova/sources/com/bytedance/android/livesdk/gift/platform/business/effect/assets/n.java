package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.b f129119a;

    public n(k.b r100) {
        this.f129119a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        k.b r101 = this.f129119a;
        r101.onFailed((Throwable) r100);
    }
}
