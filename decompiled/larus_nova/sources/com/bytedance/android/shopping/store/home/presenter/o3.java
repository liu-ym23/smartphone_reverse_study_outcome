package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class o3<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o3 f184260a = null;

    static {
        f184260a = new o3();
    }

    public o3() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECExceptionMonitor.e((Throwable) r100);
    }
}
