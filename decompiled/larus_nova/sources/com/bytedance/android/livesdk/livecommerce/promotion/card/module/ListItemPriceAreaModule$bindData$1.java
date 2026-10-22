package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ListItemPriceAreaModule$bindData$1 extends MutablePropertyReference0Impl {
    public ListItemPriceAreaModule$bindData$1(ListItemPriceAreaModule r100) {
        super(r100, ListItemPriceAreaModule.class, "promotion", "getPromotion()Lcom/bytedance/android/ec/model/promotion/ECUIPromotion;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        ECUIPromotion r100 = ((ListItemPriceAreaModule) this.receiver).f150148d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ECUIPromotion r101 = (ECUIPromotion) r100;
        ((ListItemPriceAreaModule) this.receiver).f150148d = r101;
    }
}
