package com.bytedance.android.livesdk.chatroom.detail;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f105734a = null;

    static {
        f105734a = new x();
    }

    public x() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        LiveRoomDurationRetrieveLogger.c().erase("live_room_duration_retrieve_logger_key");
        LiveRoomDurationRetrieveLogger.b().onError(r101);
        LiveRoomDurationRetrieveLogger.b().onComplete();
        LiveRoomDurationRetrieveLogger.g("logRetrieveLogger end error", r101);
        LiveRoomDurationRetrieveLogger.f105615e = true;
    }
}
