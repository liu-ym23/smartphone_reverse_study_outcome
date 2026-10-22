package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import cf.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECProductCardPresenter$onUnBind$1 extends MutablePropertyReference0Impl {
    public ECProductCardPresenter$onUnBind$1(ECProductCardPresenter r100) {
        super(r100, ECProductCardPresenter.class, "promotionItem", "getPromotionItem()Lcom/bytedance/android/ec/common/api/IPromotionListItem;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        r r100 = ((ECProductCardPresenter) this.receiver).f149287e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionItem");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        r r101 = (r) r100;
        ((ECProductCardPresenter) this.receiver).f149287e = r101;
    }
}
