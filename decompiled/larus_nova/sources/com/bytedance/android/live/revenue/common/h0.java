package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class h0 implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f90836a = null;

    public static final class a {
    }

    public h0() {
    }

    static {
        f90836a = new h0();
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) {
        Throwable r101 = r100;
        if (r101 == null) goto L6;
        ALogger.stacktrace(6, "RxErrorConsumer", r101.getStackTrace());
        return;
    }
}
