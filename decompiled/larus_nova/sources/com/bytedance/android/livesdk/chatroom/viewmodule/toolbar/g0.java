package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f116306a = null;

    static {
        f116306a = new g0();
    }

    public g0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.d("LandscapeTopMoreHolder", "bitmap download error: " + ((Throwable) r100).toString());
    }
}
