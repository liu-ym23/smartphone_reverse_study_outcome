package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class m3<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m3 f184237a = null;

    static {
        f184237a = new m3();
    }

    public m3() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECExceptionMonitor.e((Throwable) r100);
    }
}
