package com.bytedance.android.livesdk.chatroom.end;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class j0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f106080a = null;

    static {
        f106080a = new j0();
    }

    public j0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Logger.e(((Throwable) r100).getMessage());
    }
}
