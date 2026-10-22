package com.bytedance.android.ec.hybrid.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECHybridDataEngine$Builder$build$1 extends MutablePropertyReference0Impl {
    public ECHybridDataEngine$Builder$build$1(ECHybridDataEngine.a r100) {
        super(r100, ECHybridDataEngine.a.class, "resourceDataLoader", "getResourceDataLoader()Lcom/bytedance/android/ec/hybrid/data/gecko/IGeckoDataLoader;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        com.bytedance.android.ec.hybrid.data.gecko.d r100 = ((ECHybridDataEngine.a) this.receiver).f46644b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resourceDataLoader");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        com.bytedance.android.ec.hybrid.data.gecko.d r101 = (com.bytedance.android.ec.hybrid.data.gecko.d) r100;
        ((ECHybridDataEngine.a) this.receiver).f46644b = r101;
    }
}
