package com.bytedance.android.ecom.arch.slice.render.util;

import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcDimensExtensionsKt {
    public static final int a(Number r100, com.bytedance.android.ecom.arch.slice.render.context.b r101) {
        return Math.round(c(r100, r101));
    }

    @Deprecated(message = "已废弃，请使用Number.slcDp(templateContext: SlcTemplateContext)或Number.slcDp(slcDisplayMetrics: SlcDisplayMetrics)")
    public static final int b(Number r100, SlcRenderContext r101) {
        return Math.round(c(r100, r101.f50172f));
    }

    public static final float c(Number r100, com.bytedance.android.ecom.arch.slice.render.context.b r101) {
        float r102 = r100.floatValue();
        if (r102 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return r102 * r101.f50240b;
    }

    public static final float d(Number r100, com.bytedance.android.ecom.arch.slice.render.context.b r101) {
        float r102 = r100.floatValue();
        if (r102 == 0.0f) goto L10;
        float r103 = r101.f50240b;
        if (r103 != 0.0f) goto L9;
        nq.a.c(null, SlcDimensExtensionsKt$slcPxToDpFloat$1.INSTANCE, 1);
        r103 = 3.0f;
    L9:
        return r102 / r103;
    L10:
        return 0.0f;
    }

    public static final float e(Number r100, com.bytedance.android.ecom.arch.slice.render.context.b r101) {
        float r102 = r100.floatValue();
        if (r102 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return r102 * r101.f50241c;
    }
}
