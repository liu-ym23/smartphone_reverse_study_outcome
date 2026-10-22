package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LiveExplainCardPresenterV2$onUnBind$1 extends MutablePropertyReference0Impl {
    public LiveExplainCardPresenterV2$onUnBind$1(LiveExplainCardPresenterV2 r100) {
        super(r100, LiveExplainCardPresenterV2.class, "explainCardController", "getExplainCardController()Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/ExplainCardController;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r100 = ((LiveExplainCardPresenterV2) this.receiver).f152419h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r101 = (com.bytedance.android.livesdk.livecommerce.room.controller.business.n) r100;
        ((LiveExplainCardPresenterV2) this.receiver).f152419h = r101;
    }
}
