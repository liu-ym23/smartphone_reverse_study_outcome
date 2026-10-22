package com.bytedance.android.shopping.sku.inner.container;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SkuYataFragment$initSubscribe$3 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new SkuYataFragment$initSubscribe$3();
    }

    public SkuYataFragment$initSubscribe$3() {
        super(SkuYataState.class, "skuLoadingStatus", "getSkuLoadingStatus()Lcom/bytedance/android/shopping/sku/inner/container/SkuLoadingStatus;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ((SkuYataState) r100).f182831a;
    }
}
