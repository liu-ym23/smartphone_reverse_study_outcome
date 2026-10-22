package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f161681a = null;

    static {
        f161681a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("CountdownTaskWidget", "doActionWithToken failed", (Throwable) r100);
    }
}
