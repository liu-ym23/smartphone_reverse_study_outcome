package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f132847a = null;

    static {
        f132847a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("update switch status failed", (Throwable) r100);
    }
}
