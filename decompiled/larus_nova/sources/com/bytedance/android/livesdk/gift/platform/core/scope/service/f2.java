package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftResourceFileCacheService f131549a;

    public f2(GiftResourceFileCacheService r100) {
        this.f131549a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f131549a.f131406m.onNext(Boolean.TRUE);
    }
}
