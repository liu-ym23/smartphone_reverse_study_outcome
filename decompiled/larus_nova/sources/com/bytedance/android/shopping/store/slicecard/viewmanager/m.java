package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.store.view.ECShopProgressBarView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECShopProgressBarView> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
    }

    public m(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.b
    public final View n1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ECShopProgressBarView(r100);
    }
}
