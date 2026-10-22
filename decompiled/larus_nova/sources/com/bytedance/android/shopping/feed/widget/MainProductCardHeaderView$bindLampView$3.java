package com.bytedance.android.shopping.feed.widget;

import android.view.View;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class MainProductCardHeaderView$bindLampView$3 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Function3 $detailOnClickListener;
    final /* synthetic */ PromotionProductStruct $promotion;
    final /* synthetic */ MainProductCardHeaderView this$0;

    public MainProductCardHeaderView$bindLampView$3(MainProductCardHeaderView r100, PromotionProductStruct r101, Function3 r102) {
        this.this$0 = r100;
        this.$promotion = r101;
        this.$detailOnClickListener = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (this.$promotion == null) goto L6;
        this.$detailOnClickListener.invoke(this.this$0, "click", "pic");
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
