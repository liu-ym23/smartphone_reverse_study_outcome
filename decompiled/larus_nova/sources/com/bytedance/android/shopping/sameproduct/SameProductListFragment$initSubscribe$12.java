package com.bytedance.android.shopping.sameproduct;

import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductState;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SameProductListFragment$initSubscribe$12 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new SameProductListFragment$initSubscribe$12();
    }

    public SameProductListFragment$initSubscribe$12() {
        super(SameProductState.class, "isProductListApiError", "isProductListApiError()Z", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Boolean.valueOf(((SameProductState) r100).f182448g);
    }
}
