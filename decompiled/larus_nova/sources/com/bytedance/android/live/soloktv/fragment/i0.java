package com.bytedance.android.live.soloktv.fragment;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class i0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f101216a = null;

    static {
        f101216a = new i0();
    }

    public i0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("SoloKtvPreviewFragment", "update background error : gen cover bitmap error");
    }
}
