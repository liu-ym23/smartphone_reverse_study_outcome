package com.bytedance.android.livesdk.chatroom.widget.landscape;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f119076a = null;

    static {
        f119076a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        x8.a.b("LandscapeQuickShotWindow", "autodismiss Fail", false);
    }
}
