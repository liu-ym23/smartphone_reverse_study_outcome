package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f85345a = null;

    static {
        f85345a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = qo0.a.f534145a;
        String r102 = ((Throwable) r100).getMessage();
        if (r102 != null) goto L5;
        r102 = "receive anchor exit room event";
    L5:
        qo0.a.b("MiniGameDetailPageDialog", r102, null);
    }
}
