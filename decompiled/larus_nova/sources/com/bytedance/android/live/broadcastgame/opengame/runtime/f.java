package com.bytedance.android.live.broadcastgame.opengame.runtime;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f60833a = null;

    static {
        f60833a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r100, "LiveBasePluginManager", "fetchCollectStatus error");
    }
}
