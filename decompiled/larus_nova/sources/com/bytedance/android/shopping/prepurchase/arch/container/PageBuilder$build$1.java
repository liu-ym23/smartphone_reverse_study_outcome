package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PageBuilder$build$1 extends MutablePropertyReference0Impl {
    public PageBuilder$build$1(b r100) {
        super(r100, b.class, "eventTrackerService", "getEventTrackerService$ec_shopping_impl_saasRelease()Lcom/bytedance/android/shopping/prepurchase/arch/container/intf/IEventTrackerService;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        h r100 = ((b) this.receiver).f180729a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("eventTrackerService");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        b r101 = (b) this.receiver;
        h r102 = (h) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f180729a = r102;
    }
}
