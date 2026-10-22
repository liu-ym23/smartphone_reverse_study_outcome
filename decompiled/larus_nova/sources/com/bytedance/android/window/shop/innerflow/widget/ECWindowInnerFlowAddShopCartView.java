package com.bytedance.android.window.shop.innerflow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECWindowInnerFlowAddShopCartView;", "Lcom/bytedance/android/window/shop/innerflow/widget/ECWindowAddShopCartView;", "Landroid/widget/TextView;", "getAndAddDotTextView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowAddShopCartView extends ECWindowAddShopCartView {
    public ECWindowInnerFlowAddShopCartView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECWindowInnerFlowAddShopCartView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.window.shop.innerflow.widget.ECWindowAddShopCartView
    public final FrameLayout.LayoutParams b() {
        FrameLayout.LayoutParams r100 = super.b();
        r100.gravity = 17;
        return r100;
    }

    @Override // com.bytedance.android.window.shop.innerflow.widget.ECWindowAddShopCartView
    public TextView getAndAddDotTextView() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.ec_shop_layout_inner_flow_shop_cart_product_count, this, false);
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L7;
        ((FrameLayout.LayoutParams) r101).gravity = 53;
        addView(r100);
        return (TextView) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public ECWindowInnerFlowAddShopCartView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ECWindowInnerFlowAddShopCartView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
