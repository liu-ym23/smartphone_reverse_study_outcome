package com.bytedance.android.shopping.anchorv4.floatwidget.replay;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f166849a = null;

    static {
        f166849a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECExceptionMonitor.e((Throwable) r100);
    }
}
