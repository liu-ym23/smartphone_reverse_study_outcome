package com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f108261a = null;

    static {
        f108261a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("ReplayByteCastHelper", ((Throwable) r100).toString());
    }
}
