package com.bytedance.android.livesdk.announcement;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class p0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f103536a = null;

    static {
        f103536a = new p0();
    }

    public p0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        x8.a.b("announcement", "webcast/anchor/announcement/video_list fail", false);
    }
}
