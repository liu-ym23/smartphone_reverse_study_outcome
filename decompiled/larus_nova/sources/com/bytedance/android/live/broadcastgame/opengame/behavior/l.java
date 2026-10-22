package com.bytedance.android.live.broadcastgame.opengame.behavior;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f59775a = null;

    static {
        f59775a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r100, "LiveBasePluginManager", "on registerShowPanelEvent login Error");
    }
}
