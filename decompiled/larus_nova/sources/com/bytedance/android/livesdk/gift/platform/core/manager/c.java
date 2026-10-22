package com.bytedance.android.livesdk.gift.platform.core.manager;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f130793a = null;

    static {
        f130793a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        kq2.a r101 = (kq2.a) r100;
        GiftEffectManager.f130733e = true;
    }
}
