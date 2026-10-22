package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f113343a = null;

    static {
        f113343a = new g0();
    }

    public g0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        ALogger.i("LongPressPanelPromptWidget", "report reason success");
    }
}
