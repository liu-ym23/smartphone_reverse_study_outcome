package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f113388a = null;

    static {
        f113388a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("GestureDetectEvent", "receive GestureDetectEvent fail.");
    }
}
