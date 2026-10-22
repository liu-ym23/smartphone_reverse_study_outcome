package com.bytedance.android.shopping.collect.slice;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends com.bytedance.android.ecom.arch.slice.render.cache.a {
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
        int r100 = com.bytedance.android.shopping.collect.container.c.f172155a;
        return ECSettingKeys.t().d();
    }

    public b() {
    }
}
