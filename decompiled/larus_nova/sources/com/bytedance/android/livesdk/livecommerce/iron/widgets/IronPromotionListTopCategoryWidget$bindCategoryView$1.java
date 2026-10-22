package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/TopCategoryView;", "category", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class IronPromotionListTopCategoryWidget$bindCategoryView$1 extends Lambda implements Function2<TopCategoryView, PromotionCategory, Unit> {
    final /* synthetic */ IronPromotionListTopCategoryWidget this$0;

    public IronPromotionListTopCategoryWidget$bindCategoryView$1(IronPromotionListTopCategoryWidget r100) {
        this.this$0 = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TopCategoryView r100, PromotionCategory r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "category");
        if ((!Intrinsics.areEqual(r100, this.this$0.f149137c)) == false) goto L12;
        TopCategoryView r102 = this.this$0.f149137c;
        if (r102 == null) goto L7;
        r102.b(false);
    L7:
        IronPromotionListTopCategoryWidget r103 = this.this$0;
        if (r103.f149137c == null) goto L10;
        r103.getClass();
    L10:
        this.this$0.f149137c = r100;
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TopCategoryView r100, PromotionCategory r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
