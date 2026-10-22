package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f62489a = null;

    static {
        f62489a = new z();
    }

    public z() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.g("开播后恢复app/stop请求成功", "XplayGlobalService");
    }
}
