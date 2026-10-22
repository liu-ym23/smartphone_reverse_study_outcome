package com.bytedance.android.livesdk.chatroom.detail;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f105619a = null;

    static {
        f105619a = new a0();
    }

    public a0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LiveRoomDurationRetrieveLogger.g("storeJsonObject end error", (Throwable) r100);
    }
}
