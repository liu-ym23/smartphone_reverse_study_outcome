package com.bytedance.android.shopping.sku.inner.slice;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.sku.inner.container.e0;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ecom.arch.slice.render.cache.a {
    @Override // com.bytedance.android.ecom.arch.slice.render.cache.a
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.cache.b
    public final String getElementType() {
        return "View";
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.cache.a
    public final int b() {
        int r100 = e0.f182840a;
        return ECSettingKeys.Y().e();
    }

    public a() {
    }
}
