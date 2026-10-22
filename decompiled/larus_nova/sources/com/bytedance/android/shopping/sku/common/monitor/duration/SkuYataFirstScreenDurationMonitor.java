package com.bytedance.android.shopping.sku.common.monitor.duration;

import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import hd3.d;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuYataFirstScreenDurationMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f182742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<SkuYataFirstScreenPoint, Long> f182743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f182744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f182745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f182746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f182747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f182748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f182749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONObject f182750i;

    public SkuYataFirstScreenDurationMonitor(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "baseParams");
        this.f182749h = r100;
        this.f182750i = r101;
        i r102 = i.f47987a;
        String r103 = r102.create("ec_perf_duration_sku_panel");
        this.f182742a = r103;
        this.f182743b = new ConcurrentHashMap();
        this.f182744c = LazyKt.lazy(SkuYataFirstScreenDurationMonitor$extraParams$2.INSTANCE);
        com.bytedance.android.ec.monitor.duration.d r104 = r102.get(r103);
        if (r104 == null) goto L8;
        Iterator<String> r105 = r101.keys();
    L6:
        if (r105.hasNext() == false) goto L10;
        String r106 = r105.next();
        r104.b(r106, this.f182750i.get(r106));
        goto L6
    L10:
        return;
    }

    public static void b(final SkuYataFirstScreenDurationMonitor r100, final SkuYataFirstScreenPoint r101) {
        Intrinsics.checkNotNullParameter(r101, "point");
        final Long r102 = null;
        SkuRunCatchExtKt.a(r100.f182749h, "SkuYataFirstScreenDurationMonitor-addPointSafely", new SkuYataFirstScreenDurationMonitor$addPointSafely$1(r100, r101, r102));
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ((JSONObject) this.f182744c.getValue()).put(r100, r101);
    }
}
