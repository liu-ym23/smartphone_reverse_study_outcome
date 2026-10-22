package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import com.bytedance.android.window.shop.innerflow.widget.ECExpandableTextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/window/shop/innerflow/widget/ECExpandableTextView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class ECWindowInnerFlowRecommendTextElementPresenter$tvRecommend$2 extends Lambda implements Function0<ECExpandableTextView> {
    final /* synthetic */ ECWindowInnerFlowRecommendTextElementPresenter this$0;

    public ECWindowInnerFlowRecommendTextElementPresenter$tvRecommend$2(ECWindowInnerFlowRecommendTextElementPresenter r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ECExpandableTextView invoke() {
        ECExpandableTextView r100 = (ECExpandableTextView) this.this$0.w().b(R.id.ec_shop_inner_flow_expandable_text).f();
        r100.setClickCallback(new ECWindowInnerFlowRecommendTextElementPresenter$tvRecommend$2$$special$$inlined$also$lambda$1(this));
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ECExpandableTextView invoke() {
        return invoke();
    }
}
