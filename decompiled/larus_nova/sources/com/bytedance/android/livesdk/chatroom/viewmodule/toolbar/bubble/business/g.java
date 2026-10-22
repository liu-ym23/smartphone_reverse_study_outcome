package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f115832a = null;

    static {
        f115832a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        EnsureManager.ensureNotReachHere((Throwable) r100, "PadBubbleLoader");
    }
}
