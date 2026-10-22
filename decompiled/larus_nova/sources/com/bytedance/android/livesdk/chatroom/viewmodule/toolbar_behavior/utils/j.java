package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f117412a = null;

    static {
        f117412a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        Logger.e("introduce-card", "成功更新直播间状态: 取消联运");
    }
}
