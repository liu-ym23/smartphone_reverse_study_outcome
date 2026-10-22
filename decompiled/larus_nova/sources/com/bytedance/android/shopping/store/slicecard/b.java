package com.bytedance.android.shopping.store.slicecard;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface b {
    Map<String, Object> a();

    void b(Context r100, boolean r101);

    void c(Map<String, ? extends Object> r100);

    void d(Map<String, ShopSliceItemConfig> r100);

    void e();

    void f(com.bytedance.android.ecom.arch.slice.render.context.a r100);

    void g();

    SlcRenderContext getContext();

    void h(com.bytedance.android.ecom.arch.slice.render.context.a r100);
}
