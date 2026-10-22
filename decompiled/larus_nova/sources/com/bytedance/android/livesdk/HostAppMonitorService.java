package com.bytedance.android.livesdk;

import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class HostAppMonitorService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f102946c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<IHostAppMonitorListener> f102947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f102948b;

    public static final class a {
        public static HostAppMonitorService a() {
            return (HostAppMonitorService) HostAppMonitorService.f102946c.getValue();
        }
    }

    static {
        f102946c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, HostAppMonitorService$Companion$inst$2.INSTANCE);
    }

    public HostAppMonitorService() {
        this.f102947a = new ArrayList();
    }

    public final void a(IHostAppMonitorListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f102948b != null) goto L9;
        this.f102948b = new l(this);
        IMiddlewareHostApp r101 = (IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class);
        if (r101 == null) goto L9;
        r101.registerLiveLifeCycleListener(this.f102948b);
    L9:
        if (this.f102947a.contains(r100) == true) goto L12;
        this.f102947a.add(r100);
        return;
    }

    public final void b(IHostAppMonitorListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f102947a.remove(r100);
    }
}
