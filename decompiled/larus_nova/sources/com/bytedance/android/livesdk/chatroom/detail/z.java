package com.bytedance.android.livesdk.chatroom.detail;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f105738a = null;

    static {
        f105738a = new z();
    }

    public z() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        LiveRoomDurationRetrieveLogger.h("storeJsonObject success");
    }
}
