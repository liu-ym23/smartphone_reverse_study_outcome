package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public final class n0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f166457a = null;

    static {
        f166457a = new n0();
    }

    public n0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECExceptionMonitor.e((Throwable) r100);
    }
}
