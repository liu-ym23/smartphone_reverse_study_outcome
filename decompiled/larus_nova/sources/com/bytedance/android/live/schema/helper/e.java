package com.bytedance.android.live.schema.helper;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f100517a = null;

    static {
        f100517a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("LynxCacheHelper", "evict failed", (Throwable) r100);
    }
}
