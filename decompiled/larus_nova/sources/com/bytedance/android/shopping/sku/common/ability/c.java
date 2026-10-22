package com.bytedance.android.shopping.sku.common.ability;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Map;
import ul.f;

/* JADX INFO: loaded from: classes13.dex */
public interface c {
    SkuParams a();

    void b(Context r100, PageFinder r101, Map<String, ? extends Object> r102, String r103);

    void c(Context r100, Map<String, ? extends Object> r101, f r102, SkuAbilityType r103);

    void d(Context r100, Map<String, ? extends Object> r101);

    void e(SkuParams r100);

    void f(Context r100, PageFinder r101, String r102, String r103, Map<String, ? extends Object> r104, boolean r105);

    void g(Context r100, f r101);

    void h(Context r100, PageFinder r101, Map<String, ? extends Object> r102);

    void i(Context r100, PageFinder r101, Map<String, ? extends Object> r102);

    void j(Context r100, View r101, PageFinder r102, com.bytedance.android.shopping.sku.inner.container.b r103, Map r104, com.bytedance.android.shopping.sku.inner.function.business.a r105, float[] r106);
}
