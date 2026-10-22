package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.new_cart.slice.widgets.CartCircleLoadingView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends com.bytedance.android.ecom.arch.slice.render.elements.b<CartCircleLoadingView> {
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void I0(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "styles");
    }

    public e(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.b
    public final View n1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new CartCircleLoadingView(r100, null, 6, 0);
    }
}
