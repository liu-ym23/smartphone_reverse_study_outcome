package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f115841a = null;

    static {
        f115841a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("FetchRoomDataSource", "getRoomInfoByScene error: " + ((Throwable) r100).getMessage());
    }
}
