package com.bytedance.android.livesdk.announcement;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class o0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f103534a = null;

    static {
        f103534a = new o0();
    }

    public o0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        x8.a.b("announcement", "webcast/anchor/announcement/video_list fail", false);
    }
}
