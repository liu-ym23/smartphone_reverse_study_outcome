package com.bytedance.android.shopping.feed.event;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class q0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f174853a = null;

    static {
        f174853a = new q0();
    }

    public q0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((com.bytedance.android.ec.core.event.a) r100).newPost();
    }
}
