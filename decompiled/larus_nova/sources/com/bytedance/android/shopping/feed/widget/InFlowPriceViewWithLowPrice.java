package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InFlowPriceViewWithLowPrice;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowPriceViewWithLowPrice extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f175896e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriceView f175897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f175898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PromotionProductPriceStruct f175899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PromotionProductStruct f175900d;

    public static final class a {
    }

    static {
    }

    public InFlowPriceViewWithLowPrice(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InFlowPriceViewWithLowPrice(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public InFlowPriceViewWithLowPrice(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_inflow_card_price_with_low_price_view, this, true);
        PriceView r103 = (PriceView) findViewById(R.id.min_price);
        this.f175897a = r103;
        this.f175898b = (TextView) findViewById(R.id.tv_low_price_text);
        if (ld3.c.d() == false) goto L6;
        PriceView.z(r103, 0, 6);
        return;
    }

    public /* synthetic */ InFlowPriceViewWithLowPrice(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
