package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f179022a = 0;

    static {
    }

    public static com.bytedance.android.ecom.arch.slice.render.context.b a(Boolean r100) {
        com.bytedance.android.ecom.arch.slice.render.context.b.a r101 = com.bytedance.android.ecom.arch.slice.render.context.b.f50238f;
        float r102 = 1.0f;
        if (CartSettingUtils.b() == false) goto L7;
        Float r103 = ECAppInfoService.f48114e.getCurrentFontScale();
        if (r103 == null) goto L7;
        float r104 = r103.floatValue();
    L9:
        if (CartSettingUtils.b() == false) goto L14;
        Float r105 = ECAppInfoService.f48114e.getCurrentFontScale();
        if (r105 == null) goto L14;
        r102 = r105.floatValue();
    L14:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L19;
        nj.d r106 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r106 == null) goto L18;
        r106.getSpiltWidth();
        int r107 = 0;
    L20:
        r101.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.b(375.0f, r102, r104, r107);
    L18:
        r107 = 360;
        goto L20
    L19:
        r107 = -1;
    L7:
        r104 = 1.0f;
        goto L9
    }
}
