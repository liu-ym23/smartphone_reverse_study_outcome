package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PackDataParser$updateResponse$1 extends MutablePropertyReference0Impl {
    public PackDataParser$updateResponse$1(g r100) {
        super(r100, g.class, "componentList", "getComponentList()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r100 = ((g) this.receiver).f181929e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r101 = (List) r100;
        ((g) this.receiver).f181929e = r101;
    }
}
