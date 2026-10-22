package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f62019a = null;

    static {
        f62019a = new a0();
    }

    public a0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r100, "XplayGlobalService", "开播后恢复app/stop");
    }
}
