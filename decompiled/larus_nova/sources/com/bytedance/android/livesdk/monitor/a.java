package com.bytedance.android.livesdk.monitor;

import b30.f0;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f153975a = null;

    static {
        f153975a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LiveBroadcastLifecycleMonitor.a r101 = LiveBroadcastLifecycleMonitor.f153970a;
        NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_PAGE_SHOW, null, null, 14);
        r102.c("WebView");
        r102.i("url", ((f0) r100).f17122a);
        r102.i("status_msg", "WebView");
        r102.a().report();
    }
}
