package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class x1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f131838a;

    public x1(w1 r100) {
        this.f131838a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        w1 r102 = this.f131838a;
        r102.f131826a.stopMonitorFps("open_gift_panel", r102.f131831f);
        this.f131838a.f131826a.releaseFpsMonitor("open_gift_panel");
        this.f131838a.f131830e = true;
    }
}
