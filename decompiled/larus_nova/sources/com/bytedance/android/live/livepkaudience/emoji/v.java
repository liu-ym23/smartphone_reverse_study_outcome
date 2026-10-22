package com.bytedance.android.live.livepkaudience.emoji;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f81995a = null;

    static {
        f81995a = new v();
    }

    public v() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = x8.a.f562881a;
        x8.a.b("interact_emoji", "query_user failed " + ((Throwable) r100), false);
    }
}
