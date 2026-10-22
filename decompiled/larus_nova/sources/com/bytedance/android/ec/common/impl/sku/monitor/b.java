package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SkuParams f43102b;

    public b(SkuParams r110) {
        Intrinsics.checkNotNullParameter(r110, "skuParams");
        this.f43102b = r110;
        Map<String, com.bytedance.android.ec.core.monitor.a> r100 = com.bytedance.android.ec.core.monitor.c.f45142a;
        String r101 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_SKU_PANEL_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r101, "sku_from", r110.getMethod());
        String r102 = r110.getRoomId();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        com.bytedance.android.ec.core.monitor.c.f(r101, "room_id", r102);
        String r103 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r110.getMethod(), new String[]{"_"}, false, 0, 6, null));
        if (r103 == null) goto L10;
        String r104 = a2.d(r103);
        if (r104 == null) goto L10;
        com.bytedance.android.ec.core.monitor.c.e(r101, "tag", r104);
    L10:
        r110.setMonitorId(r101);
    }

    public final void a(boolean r100) {
        this.f43101a++;
        if (r100 == false) goto L6;
        Map<String, com.bytedance.android.ec.core.monitor.a> r101 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(this.f43102b.getMonitorId(), MetricNames.API_DURATION);
        return;
    }
}
