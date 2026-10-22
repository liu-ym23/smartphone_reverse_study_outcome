package com.bytedance.android.shopping.collect.container;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CollectYataFragment$initSubscribe$3 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new CollectYataFragment$initSubscribe$3();
    }

    public CollectYataFragment$initSubscribe$3() {
        super(CollectYataState.class, "collectLoadingStatus", "getCollectLoadingStatus()Lcom/bytedance/android/shopping/collect/container/CollectLoadingStatus;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ((CollectYataState) r100).f172145a;
    }
}
