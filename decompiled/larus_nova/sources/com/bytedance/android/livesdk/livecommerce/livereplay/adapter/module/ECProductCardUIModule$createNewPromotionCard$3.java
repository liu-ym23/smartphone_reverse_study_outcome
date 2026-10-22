package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECProductCardUIModule$createNewPromotionCard$3 extends MutablePropertyReference0Impl {
    public ECProductCardUIModule$createNewPromotionCard$3(f r100) {
        super(r100, f.class, "promotionCard", "getPromotionCard()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/ILivePromotionCard;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r100 = ((f) this.receiver).f149283l;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        f r101 = (f) this.receiver;
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r102 = (com.bytedance.android.livesdk.livecommerce.promotion.card.b) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f149283l = r102;
    }
}
