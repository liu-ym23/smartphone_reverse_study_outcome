package com.bytedance.android.live.network.impl.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f83931a = null;

    static {
        f83931a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.stacktrace(6, "NinePatchUtil", ((Throwable) r100).getStackTrace());
    }
}
