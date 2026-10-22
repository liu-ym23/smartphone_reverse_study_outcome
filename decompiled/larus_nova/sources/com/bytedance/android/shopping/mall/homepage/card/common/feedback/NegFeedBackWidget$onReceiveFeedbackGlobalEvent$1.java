package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "feedbackData", "Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class NegFeedBackWidget$onReceiveFeedbackGlobalEvent$1 extends Lambda implements Function1<FeedbackData, Unit> {
    final /* synthetic */ BaseViewHolder $this_onReceiveFeedbackGlobalEvent;
    final /* synthetic */ int $triggerBy;

    public NegFeedBackWidget$onReceiveFeedbackGlobalEvent$1(BaseViewHolder r100, int r101) {
        this.$this_onReceiveFeedbackGlobalEvent = r100;
        this.$triggerBy = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FeedbackData r100) {
        Intrinsics.checkNotNullParameter(r100, "feedbackData");
        int r101 = this.$triggerBy;
        if (r101 != 1) goto L6;
        d.c(this.$this_onReceiveFeedbackGlobalEvent, r100, "3");
        return;
    L6:
        if (r101 != 2) goto L10;
        d.c(this.$this_onReceiveFeedbackGlobalEvent, r100, "4");
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedbackData r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
