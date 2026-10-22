package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECShopCroppedStyleRootPresenterV2$adjustInfoGroupAndSlideElements$1 extends MutablePropertyReference0Impl {
    public ECShopCroppedStyleRootPresenterV2$adjustInfoGroupAndSlideElements$1(ECShopCroppedStyleRootPresenterV2 r100) {
        super(r100, ECShopCroppedStyleRootPresenterV2.class, "slideIndicator", "getSlideIndicator()Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        View r100 = ((ECShopCroppedStyleRootPresenterV2) this.receiver).f183912z;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        View r101 = (View) r100;
        ((ECShopCroppedStyleRootPresenterV2) this.receiver).f183912z = r101;
    }
}
