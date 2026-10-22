package com.bytedance.android.shopping.sku.inner.controller;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.sku.inner.container.b f182900a;

    public e(com.bytedance.android.shopping.sku.inner.container.b r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f182900a = r100;
    }

    public final int a(int r100) {
        if (r100 >= 50) goto L5;
    L6:
        r100 = 73;
    L7:
        int r101 = com.bytedance.android.shopping.sku.common.utils.c.f182779a;
        return (int) ((r100 / 100.0f) * com.bytedance.android.shopping.sku.common.utils.c.a(this.f182900a.P2()).f182787b);
    L5:
        if (r100 <= 100) goto L7;
        goto L6
    }
}
