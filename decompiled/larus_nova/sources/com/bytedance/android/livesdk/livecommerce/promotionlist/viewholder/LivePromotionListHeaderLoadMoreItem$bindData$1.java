package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$m;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$m;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LivePromotionListHeaderLoadMoreItem$bindData$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m, Unit> {
    public LivePromotionListHeaderLoadMoreItem$bindData$1(LivePromotionListHeaderLoadMoreItem r100) {
        super(1, r100, LivePromotionListHeaderLoadMoreItem.class, "updateStatus", "updateStatus(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$LoadBeforeStatusChangeEvent;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((LivePromotionListHeaderLoadMoreItem) this.receiver).b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
