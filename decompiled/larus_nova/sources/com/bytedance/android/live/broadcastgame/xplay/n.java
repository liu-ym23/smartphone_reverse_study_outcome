package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f62284a = null;

    static {
        f62284a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = XplayLog.f61931a;
        XplayLog.c("XplayCoreService", "ask for switch guide resp failed, code=" + com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r101) + ", message=" + r101.getMessage());
    }
}
