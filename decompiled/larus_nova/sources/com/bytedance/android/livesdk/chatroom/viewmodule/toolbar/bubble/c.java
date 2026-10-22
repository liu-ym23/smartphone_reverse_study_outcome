package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f115844a = null;

    static {
        f115844a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        EnsureManager.ensureNotReachHere((Throwable) r100, "bubbleController");
    }
}
