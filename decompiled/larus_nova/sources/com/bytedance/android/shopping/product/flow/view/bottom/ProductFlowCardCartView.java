package com.bytedance.android.shopping.product.flow.view.bottom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardCartView;", "Landroid/widget/FrameLayout;", "", "enable", "", "setEnable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFlowCardCartView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f182370a;

    public ProductFlowCardCartView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductFlowCardCartView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setEnable(boolean r100) {
        ImageView r101 = this.f182370a;
        if (r100 == false) goto L5;
        int r102 = R.drawable.commerce_inflow_card_cart;
    L6:
        r101.setImageResource(r102);
        setClickable(r100);
        return;
    L5:
        r102 = R.drawable.commerce_inflow_card_un_cart;
        goto L6
    }

    public ProductFlowCardCartView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_product_flow_card_cart_view, this);
        this.f182370a = (ImageView) findViewById(R.id.commerce_product_feed_card_cart_iv);
    }

    public /* synthetic */ ProductFlowCardCartView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
