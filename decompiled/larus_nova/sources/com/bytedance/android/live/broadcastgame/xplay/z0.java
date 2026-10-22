package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class z0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f62490a = null;

    static {
        f62490a = new z0();
    }

    public z0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r100, "XplayPanelService", "on registerShowPanelEvent login Error");
    }
}
