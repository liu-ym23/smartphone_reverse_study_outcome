package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f132876a = null;

    static {
        f132876a = new y();
    }

    public y() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f2.c(((Throwable) r100).getMessage(), 0);
    }
}
