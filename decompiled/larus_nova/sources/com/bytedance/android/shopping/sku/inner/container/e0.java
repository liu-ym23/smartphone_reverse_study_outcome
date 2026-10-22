package com.bytedance.android.shopping.sku.inner.container;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f182840a = 0;

    static {
        Map r100 = SkuPerformanceOpt.b();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("ec_sku_slice_enable_layout_dirty_opt");
    L6:
        Intrinsics.areEqual(r102, 1);
        Map r103 = SkuPerformanceOpt.b();
        if (r103 == null) goto L9;
        Object r104 = r103.get("ec_sku_slice_enable_layout_param_opt");
    L10:
        Intrinsics.areEqual(r104, 1);
        Map r105 = SkuPerformanceOpt.b();
        if (r105 == null) goto L13;
        r101 = r105.get("ec_sku_slice_enable_style_merge_opt");
    L13:
        Intrinsics.areEqual(r101, 1);
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static com.bytedance.android.ecom.arch.slice.render.context.b a() {
        ECSettingKeys.f43625j.getClass();
        float r100 = 1.0f;
        if (ECSettingKeys.T() != 1) goto L7;
        int r101 = com.bytedance.android.shopping.utils.o.f187155a;
        if (ECAppInfoService.f48114e.f() == false) goto L7;
        float r102 = 1.15f;
    L9:
        if (ECSettingKeys.T() != 1) goto L12;
        r100 = com.bytedance.android.shopping.utils.o.a();
    L12:
        if (ECSettingKeys.V() == false) goto L14;
        com.bytedance.android.ecom.arch.slice.render.context.b.f50238f.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.d(390.0f, r102, r100);
    L14:
        com.bytedance.android.ecom.arch.slice.render.context.b.f50238f.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.c(true);
    L7:
        r102 = 1.0f;
        goto L9
    }
}
