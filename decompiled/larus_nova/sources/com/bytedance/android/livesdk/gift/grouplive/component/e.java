package com.bytedance.android.livesdk.gift.grouplive.component;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f126298a = null;

    static {
        f126298a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.c("GroupComponentView", "request failed: " + ((Throwable) r100), null, 4);
    }
}
