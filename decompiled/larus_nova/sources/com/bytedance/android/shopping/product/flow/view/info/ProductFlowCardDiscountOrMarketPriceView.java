package com.bytedance.android.shopping.product.flow.view.info;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.utils.y;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import d63.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardDiscountOrMarketPriceView;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFlowCardDiscountOrMarketPriceView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f182373i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriceView f182374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f182375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriceView f182376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PriceView f182377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f182378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f182379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f182380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ActivityVO f182381h;

    public static final class a {
    }

    static {
    }

    public ProductFlowCardDiscountOrMarketPriceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductFlowCardDiscountOrMarketPriceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public ProductFlowCardDiscountOrMarketPriceView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f182379f = th.a.g(r100, R.string.commerce_tip_price_append_text);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_product_flow_card_price_view, this, true);
    L6:
        this.f182374a = (PriceView) findViewById(R.id.normal_text_min_price);
        this.f182376c = (PriceView) findViewById(R.id.normal_text_market_price);
        this.f182375b = (ViewGroup) findViewById(R.id.container_discount_price);
        this.f182377d = (PriceView) findViewById(R.id.tv_discount_price);
        this.f182378e = (TextView) findViewById(R.id.tv_discount_price_text);
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_product_flow_card_price_view, this, true);
        goto L6
    }

    public /* synthetic */ ProductFlowCardDiscountOrMarketPriceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(final long r110, final long r111, final long r210, final long r211) {
        ActivityVO r100 = this.f182381h;
        if (r100 == null) goto L5;
        Boolean r112 = Boolean.valueOf(r100.isDepositActivity());
    L7:
        if (r110 == 0) goto L41;
        this.f182374a.C(new ProductFlowCardDiscountOrMarketPriceView$updatePrice$1(this, r110, r111));
        boolean r101 = true;
        if (r112 != null) goto L11;
    L19:
        boolean r102 = false;
    L20:
        if (r102 == false) goto L28;
        this.f182375b.setVisibility(0);
        this.f182376c.setVisibility(8);
        TextView r103 = this.f182378e;
        j r104 = this.f182380g;
        if (r104 == null) goto L26;
        PromotionDiscountPrice r105 = r104.f467142q;
        if (r105 == null) goto L26;
        String r113 = r105.getHeader();
    L27:
        r103.setText(r113);
        this.f182377d.C(new ProductFlowCardDiscountOrMarketPriceView$updatePrice$2(this, r210));
        return;
    L26:
        r113 = null;
        goto L27
    L28:
        this.f182375b.setVisibility(8);
        if (r211 > r110) goto L32;
        r101 = false;
    L32:
        if (r101 == false) goto L34;
        this.f182376c.setVisibility(0);
        this.f182376c.C(new ProductFlowCardDiscountOrMarketPriceView$updatePrice$3(r211));
    L36:
        if (r210 > 0) goto L38;
        return;
    L38:
        if (r210 >= r110) goto L45;
        this.f182374a.C(new ProductFlowCardDiscountOrMarketPriceView$updatePrice$4(this, r210, r111, r110));
        return;
    L45:
        return;
    L34:
        this.f182376c.setVisibility(8);
        goto L36
    L11:
        if ((!r112.booleanValue()) != true) goto L19;
        j r106 = this.f182380g;
        if (r106 == null) goto L19;
        PromotionDiscountPrice r107 = r106.f467142q;
        if (r107 == null) goto L19;
        int r108 = y.f165360a;
        if (y.u(Long.valueOf(r110), r107, Long.valueOf(r210)) != true) goto L19;
        r102 = true;
        goto L20
    L41:
        setVisibility(8);
        return;
    L5:
        r112 = null;
        goto L7
    }
}
