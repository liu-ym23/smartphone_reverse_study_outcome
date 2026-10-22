package com.bytedance.android.live.room.navi.tetris;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f99759a = null;

    static {
        f99759a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        SafetyGuard.a(null, null, "anchor_new_close_live_popup_error");
    }
}
