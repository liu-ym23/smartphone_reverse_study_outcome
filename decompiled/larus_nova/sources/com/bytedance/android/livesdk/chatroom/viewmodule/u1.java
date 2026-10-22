package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class u1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f117534a = null;

    static {
        f117534a = new u1();
    }

    public u1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
