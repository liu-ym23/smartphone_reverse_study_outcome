package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class v3<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v3 f117540a = null;

    static {
        f117540a = new v3();
    }

    public v3() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Logger.e(((Throwable) r100).getMessage());
    }
}
