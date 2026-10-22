package com.bytedance.android.shopping.collect.monitor.fps;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.shopping.collect.monitor.error.CollectRunCatchExtKt;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CollectYataFpsMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MonitorScenes f172244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f172245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CollectParams f172246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f172247d;

    public final void a(final RecyclerView r100) {
        CollectRunCatchExtKt.a(this.f172246c.getMonitorId(), "CollectYataFpsMonitor", new CollectYataFpsMonitor$start$1(this, r100));
    }

    public CollectYataFpsMonitor(CollectParams r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "collectParams");
        Intrinsics.checkNotNullParameter(r101, "baseCategory");
        this.f172246c = r100;
        this.f172247d = r101;
        this.f172244a = MonitorScenes.FPS_SCENE_COLLECT;
        this.f172245b = LazyKt.lazy(new CollectYataFpsMonitor$fpsTracker$2(this));
    }
}
