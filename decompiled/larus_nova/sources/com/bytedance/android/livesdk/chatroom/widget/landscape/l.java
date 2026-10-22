package com.bytedance.android.livesdk.chatroom.widget.landscape;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f119100a = null;

    static {
        f119100a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        x8.a.b("LandscapeQuickShotWindow", "autodismiss Fail", false);
    }
}
