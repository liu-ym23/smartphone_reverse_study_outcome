package com.bytedance.android.live.broadcastgame;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f59629a = null;

    static {
        f59629a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r100, "LiveBasePluginManager", "on registerShowPanelEvent login Error");
    }
}
