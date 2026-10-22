package com.bytedance.android.shopping.orderlist.common.monitor.fps;

import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.kmp.ec.yata.chain.trigger.ChainStartSource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonFpsMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f179913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f179914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f179915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f179916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MonitorScenes f179917e;

    public OrderCommonFpsMonitor(MonitorScenes r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorScenes");
        this.f179917e = r100;
        this.f179913a = ChainStartSource.YATA;
        this.f179915c = LazyKt.lazy(OrderCommonFpsMonitor$eventParams$2.INSTANCE);
        this.f179916d = LazyKt.lazy(new OrderCommonFpsMonitor$fpsTracker$2(this));
    }
}
