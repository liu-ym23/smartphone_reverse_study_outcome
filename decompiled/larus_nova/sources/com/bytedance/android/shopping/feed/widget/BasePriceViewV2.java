package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStructV2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/BasePriceViewV2;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/widget/price/PriceView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/core/widget/price/PriceView;", "getMainPriceView", "()Lcom/bytedance/android/ec/core/widget/price/PriceView;", "setMainPriceView", "(Lcom/bytedance/android/ec/core/widget/price/PriceView;)V", "mainPriceView", "b", "getSubPriceView", "setSubPriceView", "subPriceView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getPriceDescriptionView", "()Landroid/widget/TextView;", "setPriceDescriptionView", "(Landroid/widget/TextView;)V", "priceDescriptionView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePriceViewV2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PriceView f175825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PriceView f175826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f175827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout f175828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PromotionProductPriceStructV2 f175829e;

    public BasePriceViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BasePriceViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void a(Context r100);

    public final PriceView getMainPriceView() {
        return this.f175825a;
    }

    public final TextView getPriceDescriptionView() {
        return this.f175827c;
    }

    public final PriceView getSubPriceView() {
        return this.f175826b;
    }

    public final void setMainPriceView(PriceView r100) {
        this.f175825a = r100;
    }

    public final void setPriceDescriptionView(TextView r100) {
        this.f175827c = r100;
    }

    public final void setSubPriceView(PriceView r100) {
        this.f175826b = r100;
    }

    public BasePriceViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a(r100);
        this.f175825a = (PriceView) findViewById(R.id.main_price);
        this.f175826b = (PriceView) findViewById(R.id.sub_price);
        this.f175827c = (TextView) findViewById(R.id.price_description);
        this.f175828d = (RelativeLayout) findViewById(R.id.ec_inflow_full_price_view_relativelayout);
        PriceView r103 = this.f175825a;
        if (r103 == null) goto L5;
        PriceView.z(r103, 0, 6);
    L5:
        PriceView r104 = this.f175826b;
        if (r104 == null) goto L9;
        PriceView.z(r104, 0, 6);
    L9:
        if (ld3.c.h() == false) goto L17;
        PriceView r105 = this.f175825a;
        if (r105 == null) goto L13;
        r105.B(se3.a.a(26.0f));
    L13:
        PriceView r106 = this.f175826b;
        if (r106 == null) goto L18;
        r106.B(se3.a.a(13.0f));
        return;
    L18:
        return;
    }

    public /* synthetic */ BasePriceViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
