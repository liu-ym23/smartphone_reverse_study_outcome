package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductServiceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.shopping.anchorv3.detail.widget.InflowFeedServiceView;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardBuyButton;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardTitleView;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR*\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/FlowTinyProductView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getProductImage", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "productImage", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "f", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "getBuyButton", "()Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "buyButton", "", "value", "l", "I", "getStyle", "()I", "setStyle", "(I)V", "style", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FlowTinyProductView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f175845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f175846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProductFlowCardTitleView f175847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TinyCardPriceView f175848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InflowFeedServiceView f175849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProductFlowCardBuyButton f175850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SellPointView f175851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f175852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f175853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f175854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f175855k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f175856l;

    public static final class a {
    }

    static {
    }

    public FlowTinyProductView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowTinyProductView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ProductFlowCardBuyButton getBuyButton() {
        return this.f175850f;
    }

    public final ECDraweeView getProductImage() {
        return this.f175845a;
    }

    public final int getStyle() {
        return this.f175856l;
    }

    public final void a(PromotionProductStruct r110) {
        Intrinsics.checkNotNullParameter(r110, "promotion");
        ImageExtensionsKt.D(this.f175845a, new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_tiny"));
        ECDraweeView r100 = this.f175845a;
        PromotionProductBaseStruct r101 = r110.getBaseInfo();
        String r102 = null;
        if (r101 == null) goto L7;
        List<ECUrlModel> r103 = r101.getImages();
        if (r103 == null) goto L7;
        ECUrlModel r104 = (ECUrlModel) CollectionsKt.firstOrNull(r103);
    L8:
        y.a(r100, r104);
        ProductFlowCardTitleView r105 = this.f175847c;
        PromotionProductBaseStruct r106 = r110.getBaseInfo();
        if (r106 == null) goto L11;
        String r107 = r106.getTitle();
    L12:
        PromotionProductPrivilegesStruct r108 = r110.getPrivilegeInfo();
        if (r108 == null) goto L19;
        PromotionProductActivitiesStruct r109 = r108.getActivities();
        if (r109 == null) goto L19;
        PromotionMarketFloor r111 = r109.getPlatformTextActivity();
        if (r111 == null) goto L19;
        ECUrlModel r112 = r111.getIcon();
    L20:
        int r113 = com.bytedance.android.shopping.anchorv3.utils.y.f165360a;
        r105.a(r107, r112, com.bytedance.android.shopping.anchorv3.utils.y.c(r110));
        this.f175848d.a(r110);
        boolean r114 = true;
        if (this.f175849e.getVisibility() != 0) goto L23;
        boolean r115 = true;
    L25:
        if (r115 == false) goto L50;
        PromotionProductPrivilegesStruct r116 = r110.getPrivilegeInfo();
        if (r116 == null) goto L50;
        List<PromotionProductServiceStruct> r117 = r116.getServices();
        if (r117 == null) goto L50;
        List<PromotionProductServiceStruct> r118 = r117;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator<T> r120 = r118.iterator();
    L32:
        if (r120.hasNext() == false) goto L35;
        r119.add(((PromotionProductServiceStruct) r120.next()).getTitle());
        goto L32
    L35:
        if (this.f175856l != 2) goto L49;
        PromotionProductBaseStruct r121 = r110.getBaseInfo();
        if (r121 == null) goto L49;
        Long r122 = r121.getSales();
        if (r122 == null) goto L49;
        if (r122.longValue() <= 0) goto L43;
        boolean r123 = true;
    L44:
        if (r123 == true) goto L47;
        r122 = null;
    L47:
        if (r122 == null) goto L49;
        ListProtector.add(r119, 0, th.a.h(getContext(), R.string.shopping_product_feed_commerce_sales, new Object[]{k0.a(r122.longValue())}));
        goto L49
    L43:
        r123 = false;
    L49:
        this.f175849e.b(r119);
    L50:
        int r124 = this.f175856l;
        if (r124 == 6) goto L53;
        if (r124 == 5) goto L53;
    L61:
        if (this.f175851g.getVisibility() != 0) goto L63;
        boolean r125 = true;
    L64:
        if (r125 == false) goto L94;
        int r126 = this.f175856l;
        if (r126 == 6) goto L70;
        if (r126 == 5) goto L70;
        this.f175851g.a(r110);
    L70:
        PromotionProductPrivilegesStruct r127 = r110.getPrivilegeInfo();
        if (r127 == null) goto L93;
        List<PromotionProductServiceStruct> r128 = r127.getServices();
        if (r128 == null) goto L93;
        List<PromotionProductServiceStruct> r129 = r128;
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator<T> r131 = r129.iterator();
    L76:
        if (r131.hasNext() == false) goto L78;
        r130.add(((PromotionProductServiceStruct) r131.next()).getTitle());
        goto L76
    L78:
        SellPointView r132 = this.f175851g;
        r132.getClass();
        Intrinsics.checkNotNullParameter(r130, "list");
        r132.removeAllViews();
        Iterator r133 = r130.iterator();
    L80:
        if (r133.hasNext() == false) goto L94;
        String r134 = (String) r133.next();
        if (cg4.a.a("#FE496A") == true) goto L83;
        int r135 = g1.f45599a;
        r132.addView(r132.b(r134, g1.a.a(r132.getContext(), R.color.shopping_color_FFFE2C55), null, false));
        goto L80
    L83:
        Integer r136 = com.bytedance.android.ec.core.utils.s.b("#FE496A");
        if (r136 == null) goto L86;
        int r137 = r136.intValue();
    L87:
        Integer r138 = com.bytedance.android.ec.core.utils.s.b("#57FE496A");
        if (r138 == null) goto L90;
        int r139 = r138.intValue();
    L91:
        r132.addView(r132.b(r134, r137, Integer.valueOf(r139), true));
        goto L80
    L90:
        r139 = 0;
        goto L91
    L86:
        r137 = 0;
    L93:
        this.f175851g.setVisibility(8);
    L94:
        this.f175853i.setText(d63.r.a(r110).f467182p);
        TextView r140 = this.f175854j;
        if (r140 != null) goto L97;
    L109:
        ViewGroup.LayoutParams r141 = this.f175851g.getLayoutParams();
        if (r141 == null) goto L131;
        ViewGroup.MarginLayoutParams r142 = (ViewGroup.MarginLayoutParams) r141;
        if (this.f175851g.getChildCount() <= 0) goto L114;
        boolean r143 = true;
    L115:
        if (r143 == true) goto L117;
        r142.topMargin = com.bytedance.android.shopping.extensions.b.b(6);
    L118:
        ViewGroup.LayoutParams r144 = this.f175851g.getLayoutParams();
        if (r144 == null) goto L129;
        ViewGroup.MarginLayoutParams r145 = (ViewGroup.MarginLayoutParams) r144;
        if (this.f175849e.getChildCount() > 0) goto L124;
        r114 = false;
    L124:
        if (r114 == true) goto L126;
        r145.topMargin = com.bytedance.android.shopping.extensions.b.b(6);
        return;
    L126:
        r145.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        return;
    L129:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L117:
        r142.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        goto L118
    L114:
        r143 = false;
        goto L115
    L131:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L97:
        if (r140.getVisibility() != 0) goto L99;
        boolean r146 = true;
    L100:
        if (r146 != true) goto L109;
        TextView r147 = this.f175854j;
        if (r147 == null) goto L109;
        PromotionProductBaseStruct r148 = r110.getBaseInfo();
        if (r148 == null) goto L108;
        SalesInfoStruct r149 = r148.getSalesInfo();
        if (r149 == null) goto L108;
        r102 = r149.getText();
    L108:
        r147.setText(r102);
        goto L109
    L99:
        r146 = false;
        goto L100
    L63:
        r125 = false;
    L53:
        ProductFlowCardBuyButton r150 = this.f175850f;
        PromotionProductExtraStruct r151 = r110.getExtraInfo();
        if (r151 == null) goto L58;
        PromotionProductButtonStruct r152 = r151.getBuyButton();
        if (r152 == null) goto L58;
        String r153 = r152.getText();
    L59:
        r150.setText(r153);
    L58:
        r153 = null;
        goto L59
    L23:
        r115 = false;
    L19:
        r112 = null;
        goto L20
    L11:
        r107 = null;
    L7:
        r104 = null;
        goto L8
    }

    public final void b(rd3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorInflowFeedItem");
        Promotion r101 = r100.f();
        if (r101 == null) goto L9;
        PromotionProductStruct r102 = r101.getPromotionInfo();
        if (r102 == null) goto L10;
        a(r102);
        return;
    L10:
        return;
    }

    public final void setStyle(int r110) {
        this.f175856l = r110;
        ViewGroup.LayoutParams r100 = null;
        switch(r110) {
            case 1: goto L61;
            case 2: goto L51;
            case 3: goto L41;
            case 4: goto L38;
            case 5: goto L23;
            case 6: goto L23;
            case 7: goto L5;
            default: goto L76;
        };
    L5:
        ViewGroup r111 = this.f175855k;
        if (r111 == null) goto L8;
        r111.setVisibility(0);
    L8:
        ProductFlowCardTitleView r112 = this.f175847c;
        if (r112 == null) goto L11;
        r112.setVisibility(8);
    L11:
        this.f175848d.setVisibility(8);
        InflowFeedServiceView r113 = this.f175849e;
        if (r113 == null) goto L14;
        r113.setVisibility(8);
    L14:
        SellPointView r114 = this.f175851g;
        if (r114 == null) goto L17;
        r114.setVisibility(8);
    L17:
        ProductFlowCardBuyButton r115 = this.f175850f;
        if (r115 == null) goto L20;
        r115.setVisibility(8);
    L20:
        ViewGroup.LayoutParams r116 = this.f175846b.getLayoutParams();
        r116.width = com.bytedance.android.shopping.extensions.b.b(94);
        r116.height = com.bytedance.android.shopping.extensions.b.b(94);
        TextView r117 = this.f175854j;
        if (r117 == null) goto L65;
        r117.setVisibility(8);
        return;
    L65:
        return;
    L23:
        this.f175847c.setMaxLine(1);
        this.f175848d.setNeedShowSuffixButNoSales(true);
        ViewGroup.LayoutParams r118 = this.f175846b.getLayoutParams();
        if (this.f175856l != 6) goto L26;
        int r101 = 110;
    L27:
        r118.width = com.bytedance.android.shopping.extensions.b.b(r101);
        if (this.f175856l != 6) goto L30;
        int r102 = 110;
    L31:
        r118.height = com.bytedance.android.shopping.extensions.b.b(r102);
        this.f175850f.setVisibility(0);
        this.f175850f.setBackgroundResource(R.drawable.shopping_bg_product_feed_bug_button_unenable);
        ProductFlowCardBuyButton r119 = this.f175850f;
        float r103 = com.bytedance.android.shopping.extensions.b.b(6);
        float r104 = com.bytedance.android.shopping.extensions.b.b(6);
        float r105 = com.bytedance.android.shopping.extensions.b.b(6);
        float r106 = com.bytedance.android.shopping.extensions.b.b(6);
        Drawable r120 = r119.getBackground().mutate();
        if (r120 == null) goto L37;
        ((GradientDrawable) r120).setCornerRadii(new float[]{r103, r103, r104, r104, r105, r105, r106, r106});
        this.f175849e.setVisibility(8);
        this.f175851g.setVisibility(0);
        this.f175851g.getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(14);
        ViewGroup.LayoutParams r121 = this.f175850f.getLayoutParams();
        r121.width = com.bytedance.android.shopping.extensions.b.b(54);
        r121.height = com.bytedance.android.shopping.extensions.b.b(28);
        TextView r122 = this.f175854j;
        if (r122 == null) goto L67;
        r122.setVisibility(0);
        return;
    L67:
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L30:
        r102 = 130;
        goto L31
    L26:
        r101 = 130;
        goto L27
    L38:
        this.f175849e.setVisibility(8);
        this.f175847c.setMaxLine(2);
        this.f175851g.setVisibility(8);
        this.f175848d.getNeedShowSalesAndSuffixText();
        this.f175850f.setVisibility(0);
        ViewGroup.LayoutParams r123 = this.f175846b.getLayoutParams();
        r123.width = com.bytedance.android.shopping.extensions.b.b(94);
        r123.height = com.bytedance.android.shopping.extensions.b.b(94);
        ViewGroup.LayoutParams r124 = this.f175850f.getLayoutParams();
        r124.width = com.bytedance.android.shopping.extensions.b.b(64);
        r124.height = com.bytedance.android.shopping.extensions.b.b(24);
        this.f175852h.setVisibility(0);
        TextView r125 = this.f175854j;
        if (r125 == null) goto L69;
        r125.setVisibility(8);
        return;
    L69:
        return;
    L41:
        this.f175848d.setNeedShowSalesAndSuffixText(false);
        this.f175849e.setVisibility(0);
        this.f175850f.setVisibility(0);
        setBackgroundResource(R.drawable.ec_commerce_bg_flow_tiny_product);
        setPadding(com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8));
        ViewGroup.LayoutParams r126 = this.f175850f.getLayoutParams();
        if ((r126 instanceof ViewGroup.MarginLayoutParams) == false) goto L45;
        r100 = r126;
    L45:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r100;
        if (r107 == null) goto L48;
        r107.rightMargin = com.bytedance.android.shopping.extensions.b.b(2);
    L48:
        ViewGroup.LayoutParams r127 = this.f175846b.getLayoutParams();
        r127.width = com.bytedance.android.shopping.extensions.b.b(94);
        r127.height = com.bytedance.android.shopping.extensions.b.b(94);
        this.f175847c.setMaxLine(1);
        wg.a.g(this.f175850f, 12);
        TextView r128 = this.f175854j;
        if (r128 == null) goto L71;
        r128.setVisibility(8);
        return;
    L71:
        return;
    L51:
        this.f175848d.setNeedShowSalesAndSuffixText(false);
        this.f175849e.setVisibility(0);
        this.f175850f.setVisibility(0);
        setBackgroundResource(R.drawable.ec_commerce_bg_flow_tiny_product);
        setPadding(com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8));
        ViewGroup.LayoutParams r129 = this.f175850f.getLayoutParams();
        if ((r129 instanceof ViewGroup.MarginLayoutParams) == false) goto L55;
        r100 = r129;
    L55:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r100;
        if (r108 == null) goto L58;
        r108.rightMargin = com.bytedance.android.shopping.extensions.b.b(2);
    L58:
        this.f175847c.setMaxLine(2);
        wg.a.g(this.f175850f, 12);
        TextView r130 = this.f175854j;
        if (r130 == null) goto L73;
        r130.setVisibility(8);
        return;
    L73:
        return;
    L61:
        this.f175848d.setNeedShowSalesAndSuffixText(true);
        this.f175849e.setVisibility(8);
        this.f175850f.setVisibility(8);
        this.f175847c.setMaxLine(2);
        TextView r131 = this.f175854j;
        if (r131 == null) goto L75;
        r131.setVisibility(8);
        return;
    L75:
        return;
    }

    public FlowTinyProductView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f175856l = 1;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_flow_tiny_prouct_view, this, true);
        this.f175845a = (ECDraweeView) findViewById(R.id.tiny_product_img);
        this.f175846b = (ViewGroup) findViewById(R.id.tiny_product_img_container);
        ProductFlowCardTitleView r103 = (ProductFlowCardTitleView) findViewById(R.id.tiny_product_title);
        this.f175847c = r103;
        TinyCardPriceView r104 = (TinyCardPriceView) findViewById(R.id.tiny_product_price_and_sales);
        this.f175848d = r104;
        this.f175852h = findViewById(R.id.tiny_product_sold_out_tag);
        this.f175853i = (TextView) findViewById(R.id.tiny_product_sold_out_tv);
        this.f175855k = (ViewGroup) findViewById(R.id.tiny_skeleton_view);
        wg.a.g(r104.getMinPriceView(), 18);
        wg.a.g(r104.getSalesTextView(), 11);
        InflowFeedServiceView r105 = (InflowFeedServiceView) findViewById(R.id.tiny_product_service_view);
        this.f175849e = r105;
        r105.setDividerDrawableRes(R.drawable.commerce_dot_divider_product_card_service);
        r105.setDesiredChildHeight(com.bytedance.android.shopping.extensions.b.b(12));
        r105.setTextSizeDP(10.0f);
        int r106 = g1.f45599a;
        r105.setTextColor(g1.a.a(r100, R.color.commerce_color_57161823));
        ProductFlowCardBuyButton r107 = (ProductFlowCardBuyButton) findViewById(R.id.tiny_product_buy_button);
        this.f175850f = r107;
        this.f175851g = (SellPointView) findViewById(R.id.tiny_product_sell_point_view);
        r107.setRadius(com.bytedance.android.shopping.extensions.b.b(4));
        r107.setText(R.string.commerce_buy);
        se3.a.c(r107, 2, 14.0f);
        r103.setTextStyle(false);
        r103.setTextAndIconSizeDP(14.0f);
        r103.setArrowStyleVisible(false);
        r104.setSalesMarginLeft(com.bytedance.android.shopping.extensions.b.b(4));
        this.f175854j = (TextView) findViewById(R.id.tiny_product_sell_info_tv);
        setStyle(1);
    }

    public /* synthetic */ FlowTinyProductView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
