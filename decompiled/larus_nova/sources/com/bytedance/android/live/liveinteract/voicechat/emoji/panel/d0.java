package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f80205a = null;

    static {
        f80205a = new d0();
    }

    public d0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("interact_emoji", "query_user failed " + ((Throwable) r100));
    }
}
