package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class q3<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q3 f184375a = null;

    static {
        f184375a = new q3();
    }

    public q3() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECExceptionMonitor.e((Throwable) r100);
    }
}
