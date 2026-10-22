package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftRoomCleanCacheService f129284a;

    public g(GiftRoomCleanCacheService r100) {
        this.f129284a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f129284a.c();
    }
}
