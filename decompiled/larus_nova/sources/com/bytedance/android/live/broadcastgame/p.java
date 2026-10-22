package com.bytedance.android.live.broadcastgame;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f61761a = null;

    static {
        f61761a = new p();
    }

    public p() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r100, "LiveBasePluginManager", "on registerShowPanelEvent login Error");
    }
}
