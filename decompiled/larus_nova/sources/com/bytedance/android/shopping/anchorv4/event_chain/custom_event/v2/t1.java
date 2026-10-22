package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public final class t1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t1 f166714a = null;

    static {
        f166714a = new t1();
    }

    public t1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECExceptionMonitor.e((Throwable) r100);
    }
}
