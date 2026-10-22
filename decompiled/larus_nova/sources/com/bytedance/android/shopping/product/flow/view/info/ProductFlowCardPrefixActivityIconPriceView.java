package com.bytedance.android.shopping.product.flow.view.info;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.n;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.utils.y;
import com.bytedance.android.shopping.utils.g;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import d63.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardPrefixActivityIconPriceView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFlowCardPrefixActivityIconPriceView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f182382i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f182383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriceView f182384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriceView f182385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PriceView f182386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PromotionProductStruct f182387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f182388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActivityVO f182389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f182390h;

    public static final class a {
    }

    static {
    }

    public ProductFlowCardPrefixActivityIconPriceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductFlowCardPrefixActivityIconPriceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        j r100 = this.f182390h;
        long r101 = 0;
        if (r100 == null) goto L7;
        Long r102 = r100.f467130e;
        if (r102 == null) goto L7;
        long r110 = r102.longValue();
    L8:
        j r103 = this.f182390h;
        if (r103 == null) goto L13;
        Long r104 = r103.f467128c;
        if (r104 == null) goto L13;
        long r105 = r104.longValue();
    L14:
        j r106 = this.f182390h;
        if (r106 == null) goto L19;
        Long r107 = r106.f467129d;
        if (r107 == null) goto L19;
        long r111 = r107.longValue();
    L20:
        j r108 = this.f182390h;
        if (r108 == null) goto L27;
        PromotionDiscountPrice r109 = r108.f467142q;
        if (r109 == null) goto L27;
        Long r112 = r109.getMinPrice();
        if (r112 == null) goto L27;
        r101 = r112.longValue();
    L27:
        b(r101, r105, r111, r110);
        return;
    L19:
        r111 = 0;
    L13:
        r105 = 0;
    L7:
        r110 = 0;
        goto L8
    }

    public ProductFlowCardPrefixActivityIconPriceView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f182388f = th.a.g(r100, R.string.commerce_tip_price_append_text);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_product_flow_card_price_and_activity_view, this, true);
    L6:
        this.f182383a = (TextView) findViewById(R.id.prefix_text_view);
        this.f182384b = (PriceView) findViewById(R.id.pre_sale_deposit_price_view);
        this.f182385c = (PriceView) findViewById(R.id.min_price_view);
        this.f182386d = (PriceView) findViewById(R.id.market_price_view);
        RelativeLayout r104 = (RelativeLayout) findViewById(R.id.product_feed_container_price);
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_product_flow_card_price_and_activity_view, this, true);
        goto L6
    }

    public /* synthetic */ ProductFlowCardPrefixActivityIconPriceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(final long r110, final long r111, final long r210, final long r211) {
        j r100 = this.f182390h;
        if (r100 == null) goto L5;
        PromotionDiscountPrice r101 = r100.f467142q;
    L6:
        final PromotionDiscountPrice r102 = r101;
        if (r102 == null) goto L14;
        int r103 = y.f165360a;
        if (y.u(Long.valueOf(r111), r102, Long.valueOf(r110)) == false) goto L14;
        this.f182385c.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$1(this, r110, r210, r111, r102));
        if (r211 <= r111) goto L13;
        this.f182386d.setVisibility(0);
        this.f182386d.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$2(r211));
    L48:
        int r104 = 8;
    L51:
        if (a53.a.a() != 1) goto L63;
        ActivityVO r105 = this.f182389g;
        if (r105 != null) goto L55;
        return;
    L55:
        if (r105.getActivityType() != r104) goto L72;
        ActivityVO r106 = this.f182389g;
        if (r106 == null) goto L73;
        PromotionDepositPresaleActivity r107 = r106.getDepositPresaleActivity();
        if (r107 != null) goto L61;
        return;
    L61:
        if (n.b(r107) != true) goto L75;
        this.f182385c.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$7(this));
        TextView r108 = this.f182383a;
        int r109 = g1.f45599a;
        r108.setTextColor(g1.a.a(getContext(), R.color.ec_inner_flow_presale_activity_color));
        return;
    L75:
        return;
    L73:
        return;
    L72:
        return;
    L63:
        ActivityVO r112 = this.f182389g;
        if (r112 == null) goto L68;
        int r113 = 8;
        if (r112.getActivityType() != 8) goto L69;
        this.f182384b.setVisibility(0);
        this.f182384b.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$8(this));
        return;
    L69:
        this.f182384b.setVisibility(r113);
        return;
    L68:
        r113 = 8;
        goto L69
    L13:
        this.f182386d.setVisibility(8);
    L14:
        ActivityVO r114 = this.f182389g;
        if (r114 == null) goto L20;
        if (r114.isSubsidizedActivity() != true) goto L20;
        this.f182385c.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$3(this));
    L22:
        ActivityVO r115 = this.f182389g;
        if (r115 == null) goto L49;
        int r116 = y.f165360a;
        Intrinsics.checkNotNullParameter(r115, "activityVO");
        if (r115.getActivityType() != 1) goto L27;
    L32:
        boolean r117 = true;
    L33:
        if (r117 != true) goto L49;
        if (r211 <= 0) goto L45;
        String r118 = g.d(r211);
        if (StringsKt.indexOf$default(r118, ".", 0, false, 6, null) == (-1)) goto L43;
        if (r118.length() > 6) goto L45;
    L44:
        boolean r119 = true;
    L46:
        if (r119 == false) goto L49;
        this.f182386d.setVisibility(0);
        this.f182386d.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$6(r211));
        goto L48
    L43:
        if (r118.length() < 6) goto L44;
    L45:
        r119 = false;
        goto L46
    L27:
        if (r115.getActivityType() == 6) goto L32;
        if (r115.getActivityType() == 12) goto L32;
        r117 = false;
    L49:
        r104 = 8;
        this.f182386d.setVisibility(8);
    L20:
        if (r111 <= 0) goto L22;
        this.f182385c.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$4(this, r110, r111, r210));
        goto L22
    L5:
        r101 = null;
        goto L6
    }
}
