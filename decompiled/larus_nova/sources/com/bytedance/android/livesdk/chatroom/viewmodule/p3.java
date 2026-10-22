package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class p3<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p3 f115331a = null;

    static {
        f115331a = new p3();
    }

    public p3() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Logger.e(((Throwable) r100).getMessage());
    }
}
