package com.bytedance.android.shopping.sku.inner.controller;

import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuYataAssembleDataController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.sku.inner.container.b f182879a;

    public SkuYataAssembleDataController(com.bytedance.android.shopping.sku.inner.container.b r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f182879a = r100;
    }

    public final void a(final Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "trackCommonInfo");
        SkuRunCatchExtKt.a(this.f182879a.qn().getSkuParams().getMonitorId(), "SkuYataAssembleDataController", new SkuYataAssembleDataController$putDataToTransmissibleJson$1(this, r100));
    }
}
