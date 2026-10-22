package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class u1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f45731a = null;

    static {
        f45731a = new u1();
    }

    public u1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        String r102 = r101.getMessage();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        ECExceptionMonitor.f(r101, r102);
    }
}
