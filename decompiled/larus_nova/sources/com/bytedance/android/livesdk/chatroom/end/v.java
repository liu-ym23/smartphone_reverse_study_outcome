package com.bytedance.android.livesdk.chatroom.end;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f106124a = null;

    static {
        f106124a = new v();
    }

    public v() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
