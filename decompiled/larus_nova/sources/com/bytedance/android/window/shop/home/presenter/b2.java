package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class b2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f188499a = null;

    static {
        f188499a = new b2();
    }

    public b2() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECExceptionMonitor.e((Throwable) r100);
    }
}
