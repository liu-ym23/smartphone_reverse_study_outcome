package com.bytedance.android.gamecp.live_impl.toolbar;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f58001a = null;

    static {
        f58001a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.gamecp.base.network.response.i r101 = (com.bytedance.android.gamecp.base.network.response.i) r100;
        Logger.e("introduce-card", "上传小手柄点击事件 Success");
    }
}
