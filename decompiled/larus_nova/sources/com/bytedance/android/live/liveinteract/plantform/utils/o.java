package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f77508a = null;

    static {
        f77508a = new o();
    }

    public o() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.i("IMStreamInfoSender", String.valueOf(((Throwable) r100).getMessage()));
    }
}
