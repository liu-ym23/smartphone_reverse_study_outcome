package com.bytedance.android.live.browser.schema.impl.gecko;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f64234a;

    public b(a r100) {
        this.f64234a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.browser.schema.core.d r101 = (com.bytedance.android.live.browser.schema.core.d) r100;
        com.bytedance.android.live.schema.api.utils.a.d("GeckoCDNCacheInterceptor", "update from updater");
        Object r102 = this.f64234a.f64227b;
        monitor-enter(r102);
        this.f64234a.f64231f.a(r101);     // Catch: Throwable -> L7
        a r103 = this.f64234a;     // Catch: Throwable -> L7
        int r104 = com.bytedance.android.live.browser.schema.core.c.f64200d;     // Catch: Throwable -> L7
        r103.f64226a = com.bytedance.android.live.browser.schema.core.c.b.b(r101, r103.f64230e);     // Catch: Throwable -> L7
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
