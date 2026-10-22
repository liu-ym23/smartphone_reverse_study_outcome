package com.bytedance.android.shopping.sku.common.monitor.fps;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuYataFpsMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MonitorScenes f182759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f182760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SkuParams f182761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f182762d;

    public final void b() {
        SkuRunCatchExtKt.a(this.f182761c.getMonitorId(), "SkuYataFpsMonitor", new SkuYataFpsMonitor$stop$1(this));
    }

    public final void a(final RecyclerView r100) {
        SkuRunCatchExtKt.a(this.f182761c.getMonitorId(), "SkuYataFpsMonitor", new SkuYataFpsMonitor$start$1(this, r100));
    }

    public SkuYataFpsMonitor(SkuParams r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        Intrinsics.checkNotNullParameter(r101, "baseCategory");
        this.f182761c = r100;
        this.f182762d = r101;
        this.f182759a = MonitorScenes.FPS_SCENE_YATA_SKU;
        this.f182760b = LazyKt.lazy(new SkuYataFpsMonitor$fpsTracker$2(this));
    }
}
