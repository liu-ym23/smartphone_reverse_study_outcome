package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f132150a = null;

    static {
        f132150a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
