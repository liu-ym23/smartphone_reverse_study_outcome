package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LRUCleanStrategy f129309a;

    public q(LRUCleanStrategy r100) {
        this.f129309a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        t r102 = this.f129309a.f129225k;
        if (r102 == null) goto L6;
        r102.b();
        return;
    }
}
