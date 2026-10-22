package com.bytedance.android.live.base;

import com.bytedance.android.live.base.service.IServiceCast;

/* JADX INFO: loaded from: classes45.dex */
public class BaseServices {
    private static IServiceCast sServiceCast;

    public BaseServices() {
    }

    public static <T> T as(Class<T> r100) {
        IServiceCast r101 = sServiceCast;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.as(r100);
    }

    public static synchronized void install(IServiceCast r100) {
        monitor-enter(BaseServices.class);
        sServiceCast = r100;     // Catch: Throwable -> L7
        monitor-exit(BaseServices.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
