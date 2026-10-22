package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f89530a = null;

    static {
        f89530a = new x();
    }

    public x() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("LiveStream", (Throwable) r100);
    }
}
