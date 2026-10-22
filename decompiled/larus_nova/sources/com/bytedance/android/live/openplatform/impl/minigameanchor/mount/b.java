package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f85225a = null;

    static {
        f85225a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qo0.a.b("LiveMgMountContextService", "request live minigame meta config fail", (Throwable) r100);
    }
}
