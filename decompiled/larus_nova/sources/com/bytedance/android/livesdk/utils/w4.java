package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class w4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w4 f159203a = null;

    static {
        f159203a = new w4();
    }

    public w4() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("MdnsServiceManager", (Throwable) r100);
    }
}
