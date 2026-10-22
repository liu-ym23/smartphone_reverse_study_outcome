package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PromotionProductCouponsStructKt$getIsShow$1 extends Lambda implements Function1<PromotionDiscountLabel, CharSequence> {
    public static final PromotionProductCouponsStructKt$getIsShow$1 INSTANCE = null;

    static {
        INSTANCE = new PromotionProductCouponsStructKt$getIsShow$1();
    }

    public PromotionProductCouponsStructKt$getIsShow$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(PromotionDiscountLabel r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(PromotionDiscountLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return String.valueOf(r100.isShow());
    }
}
