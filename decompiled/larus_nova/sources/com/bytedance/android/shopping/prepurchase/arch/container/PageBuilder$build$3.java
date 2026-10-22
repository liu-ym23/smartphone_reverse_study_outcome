package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PageBuilder$build$3 extends MutablePropertyReference0Impl {
    public PageBuilder$build$3(b r100) {
        super(r100, b.class, "monitorService", "getMonitorService$ec_shopping_impl_saasRelease()Lcom/bytedance/android/shopping/prepurchase/arch/container/intf/IMonitorService;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        i r100 = ((b) this.receiver).f180731c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("monitorService");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        b r101 = (b) this.receiver;
        i r102 = (i) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f180731c = r102;
    }
}
