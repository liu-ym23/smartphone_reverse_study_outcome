package com.bytedance.android.shopping.product.flow;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.response.anchorv3.PromotionBottomButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ShortVideoProductFlowCard$bindAbilityBarView$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ PromotionProductStruct $promotionProductStruct;
    final /* synthetic */ ShortVideoProductFlowCard this$0;

    public ShortVideoProductFlowCard$bindAbilityBarView$2(ShortVideoProductFlowCard r100, PromotionProductStruct r101) {
        this.this$0 = r100;
        this.$promotionProductStruct = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        p r101 = p.f48130a;
        Context r102 = this.this$0.getContext();
        PromotionProductStruct r103 = this.$promotionProductStruct;
        if (r103 == null) goto L9;
        PromotionProductExtraStruct r104 = r103.getExtraInfo();
        if (r104 == null) goto L9;
        PromotionBottomButtonStruct r105 = r104.getShopEntry();
        if (r105 == null) goto L9;
        String r106 = r105.getSchema();
    L10:
        r101.openSchema(r102, r106);
        return;
    L9:
        r106 = null;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
