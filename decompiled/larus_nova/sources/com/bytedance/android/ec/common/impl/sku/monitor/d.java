package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.core.monitor.k;
import com.bytedance.android.ec.model.sku.SkuParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43103a;

    public d(SkuParams r100) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
    }

    public final void a(boolean r100) {
        this.f43103a++;
        if (r100 == false) goto L6;
        k.e("request_end");
        k.e("render_start");
        return;
    }
}
