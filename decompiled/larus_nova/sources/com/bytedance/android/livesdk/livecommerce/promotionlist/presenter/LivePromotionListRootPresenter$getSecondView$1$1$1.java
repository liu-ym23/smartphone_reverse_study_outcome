package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListRootPresenter$getSecondView$1$1$1 extends MutablePropertyReference0Impl {
    public LivePromotionListRootPresenter$getSecondView$1$1$1(LivePromotionListRootPresenter r100) {
        super(r100, LivePromotionListRootPresenter.class, "viewPager", "getViewPager()Landroidx/viewpager/widget/ViewPager;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        ViewPager r100 = ((LivePromotionListRootPresenter) this.receiver).f150986j;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ViewPager r101 = (ViewPager) r100;
        ((LivePromotionListRootPresenter) this.receiver).f150986j = r101;
    }
}
