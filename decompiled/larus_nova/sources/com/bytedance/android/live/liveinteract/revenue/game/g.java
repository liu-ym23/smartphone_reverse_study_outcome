package com.bytedance.android.live.liveinteract.revenue.game;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f78332a = null;

    static {
        f78332a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("LinkMicGameWidget", "[preEnterRoom] error: url=get_play_mode_info, errorCode=" + com.bytedance.android.live.broadcastgame.api.openplatform.h.a((Throwable) r100));
    }
}
