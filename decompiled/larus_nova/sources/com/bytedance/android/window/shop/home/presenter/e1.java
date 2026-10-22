package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class e1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f188521a = null;

    static {
        f188521a = new e1();
    }

    public e1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECExceptionMonitor.e((Throwable) r100);
    }
}
