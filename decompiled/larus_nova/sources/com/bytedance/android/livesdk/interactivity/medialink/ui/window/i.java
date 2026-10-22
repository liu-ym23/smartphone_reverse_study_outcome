package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f138428a = null;

    static {
        f138428a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("ttlive_anchor_link_wm", (Throwable) r100);
    }
}
