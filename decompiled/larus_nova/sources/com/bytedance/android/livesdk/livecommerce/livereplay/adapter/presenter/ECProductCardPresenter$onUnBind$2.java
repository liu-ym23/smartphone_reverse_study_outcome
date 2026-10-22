package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import com.bytedance.android.livesdk.livecommerce.promotion.card.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECProductCardPresenter$onUnBind$2 extends MutablePropertyReference0Impl {
    public ECProductCardPresenter$onUnBind$2(ECProductCardPresenter r100) {
        super(r100, ECProductCardPresenter.class, "promotionCard", "getPromotionCard()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/ILivePromotionCard;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        b r100 = ((ECProductCardPresenter) this.receiver).f149288f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        b r101 = (b) r100;
        ((ECProductCardPresenter) this.receiver).f149288f = r101;
    }
}
