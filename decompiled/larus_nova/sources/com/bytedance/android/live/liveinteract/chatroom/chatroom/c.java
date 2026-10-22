package com.bytedance.android.live.liveinteract.chatroom.chatroom;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.model.interact.q1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f71856a = null;

    static {
        f71856a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        if (r101 == null) goto L6;
        ALogger.d("ApplyPop", "count : " + ((q1) r101.data).getShowGuidelineCount());
        return;
    }
}
