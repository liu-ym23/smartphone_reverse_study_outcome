package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f182273a = null;

    static {
        f182273a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECExceptionMonitor.e((Throwable) r100);
    }
}
