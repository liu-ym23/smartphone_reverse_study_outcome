package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import com.bytedance.android.live.openplatform.impl.miniappcommon.monitor.MiniAppMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f84472a = null;

    static {
        f84472a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qo0.a.b("MemoryContextService", "requestMemoryData fail", (Throwable) r100);
        int r101 = MiniAppMonitor.f85046a;
        MiniAppMonitor.a(MiniAppMonitor.ExceptionType.Mount, "requestMemoryData fail");
    }
}
