package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class a2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f118746a = null;

    static {
        f118746a = new a2();
    }

    public a2() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        x8.a.b("LandscapeQuickShotWindow", "autodismiss Fail", false);
    }
}
