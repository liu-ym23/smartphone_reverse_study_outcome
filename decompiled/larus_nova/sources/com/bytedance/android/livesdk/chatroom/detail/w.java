package com.bytedance.android.livesdk.chatroom.detail;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f105733a = null;

    static {
        f105733a = new w();
    }

    public w() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        LiveRoomDurationRetrieveLogger.b().onNext(Boolean.TRUE);
        LiveRoomDurationRetrieveLogger.b().onComplete();
        LiveRoomDurationRetrieveLogger.h("logRetrieveLogger end");
        LiveRoomDurationRetrieveLogger.f105615e = true;
    }
}
