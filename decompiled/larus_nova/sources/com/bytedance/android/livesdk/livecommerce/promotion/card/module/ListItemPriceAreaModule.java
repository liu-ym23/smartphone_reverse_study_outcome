package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPreSaleData;
import com.bytedance.android.ec.model.response.ECPriceDescription;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.i;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemPriceAreaModule;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/model/LivePromotionCardArgs;", "argument", "", "setArgument", "", "getReadableText", "Lq83/a;", ce.f26396k, "Lkotlin/Lazy;", "getLotteryTickListener", "()Lq83/a;", "lotteryTickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemPriceAreaModule extends ECLargePriceAutoLocateLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f150147l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECUIPromotion f150148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LivePromotionCardArgs f150149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PriceView f150150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f150151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PriceView f150152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PriceView f150153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f150154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f150155k;

    public static final class a {
    }

    static {
    }

    public ListItemPriceAreaModule(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ListItemPriceAreaModule(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final q83.a getLotteryTickListener() {
        return (q83.a) this.f150155k.getValue();
    }

    public final void c() {
        if (this.f150154j != 2) goto L11;
        LivePromotionCardArgs r100 = this.f150149e;
        if (r100 == null) goto L9;
        ILivePromotionCardContainerHandler r101 = r100.f150038b;
        if (r101 == null) goto L9;
        r101.a();
    L9:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(getLotteryTickListener());
        return;
    }

    public final String getReadableText() {
        boolean r100 = true;
        if (this.f150150f.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        String r102 = "";
        if (r101 == false) goto L10;
        r102 = "" + this.f150150f.A();
    L10:
        if (this.f150152h.getVisibility() != 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        r102 = (r102 + th.a.g(getContext(), R.string.shopping_original_price)) + this.f150152h.A();
    L16:
        if (this.f150153i.getVisibility() == 0) goto L19;
        r100 = false;
    L19:
        if (r100 == true) goto L21;
        return r102;
    L21:
        return r102 + this.f150153i.A();
    L12:
        r103 = false;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    public final void b(final i r110) {
        Intrinsics.checkNotNullParameter(r110, "promotionCardItem");
        ECUIPromotion r100 = r110.f150059a.f42855a;
        ECUIPromotion r101 = this.f150148d;
        if (r101 != null) goto L5;
    L6:
        c();
        this.f150148d = r100;
    L7:
        this.f150150f.C(new ListItemPriceAreaModule$initSkinStyle$1(r110));
        this.f150152h.C(new ListItemPriceAreaModule$initSkinStyle$2(r110));
        IPromotionUIConfig.d r102 = r110.f150061c.a(PromotionCardModuleName.DescPriceAreaModule);
        if (r102 == null) goto L10;
        int r103 = UIConfigHelper.f150297a;
        UIConfigHelper.d(this.f150151g, r102);
    L10:
        String r104 = null;
        r100.setRealPrice(null);
        r100.setCostPrice(null);
        setMode(ECLargePriceAutoLocateLayout.AutoLocateMode.HIDE_MODE);
        if (r100.isPreSale() == false) goto L23;
        ECUICampaign r105 = r100.getCampaign();
        if (r105 == null) goto L23;
        if (r105.inCampaignTime() != true) goto L23;
        ECUICampaign r106 = r100.getCampaign();
        if (r106 == null) goto L70;
        setMode(ECLargePriceAutoLocateLayout.AutoLocateMode.DEFAULT_MODE);
        f(1);
        ECPreSaleData r107 = r106.preSaleData;
        if (r107 == null) goto L21;
        final Long r111 = Long.valueOf(r107.getDepositPrice());
    L22:
        String r108 = r106.price;
        String r109 = r106.maxPrice;
        e(r100.getPriceHeader(), com.bytedance.android.ec.core.widget.price.b.a(r108), Long.valueOf(com.bytedance.android.ec.core.widget.price.b.a(r109)), Long.valueOf(com.bytedance.android.ec.core.widget.price.b.a(null)), null, null);
        this.f150153i.C(new ListItemPriceAreaModule$bindData$2$1(r111));
        return;
    L21:
        r111 = null;
        goto L22
    L70:
        return;
    L23:
        int r112 = 0;
        if (r100.isAuction() == false) goto L36;
        f(0);
        ECPromotionAuctionInfo r113 = r100.getAuctionInfo();
        if (r113 == null) goto L28;
        r104 = r113.getPriceLabel();
    L28:
        String r114 = r104;
        ECPromotionAuctionInfo r115 = r100.getAuctionInfo();
        if (r115 == null) goto L33;
        Long r116 = r115.getPrice();
        if (r116 == null) goto L33;
        long r117 = r116.longValue();
    L34:
        e(r114, r117, null, null, null, null);
        return;
    L33:
        r117 = 0;
        goto L34
    L36:
        if (r100.isCommonLottery() == false) goto L38;
    L68:
        f(2);
        d(true);
        return;
    L38:
        if (r100.isScarceLotteryFinish() == true) goto L68;
        ECPriceDescription r118 = r100.priceDescription;
        if (r118 == null) goto L43;
        r112 = 3;
    L43:
        if (r118 == null) goto L45;
        r118.getColor();
    L45:
        f(r112);
        ECUICampaign r119 = r100.getCampaign();
        if (r100.isCampaignActive() == false) goto L49;
        if (r119 == null) goto L49;
        String r120 = r119.price;
    L50:
        String r121 = r120;
        if (r100.isCampaignActive() == false) goto L54;
        if (r119 == null) goto L54;
        String r122 = r119.maxPrice;
    L56:
        if (r100.isCampaignActive() == false) goto L59;
        if (r119 == null) goto L59;
        String r123 = r119.marketPrice;
    L60:
        String r124 = r123;
        if (r100.isPriceDeduce() == true) goto L63;
    L67:
        String r125 = r100.getPriceHeader();
        ECPriceDescription r126 = r100.priceDescription;
        long r127 = com.bytedance.android.ec.core.widget.price.b.a(r121);
        long r128 = com.bytedance.android.ec.core.widget.price.b.a(r122);
        long r129 = com.bytedance.android.ec.core.widget.price.b.a(r124);
        e(r125, r127, Long.valueOf(r128), Long.valueOf(r129), r126, r104);
        r100.setRealPrice(r124);
        r100.setCostPrice(r121);
        return;
    L63:
        if (r100.isCampaignActive() == false) goto L66;
        if (r119 == null) goto L66;
        r104 = r119.priceStr;
    L66:
        r104 = r100.minPriceStr;
    L59:
        r123 = r100.getMarketPrice();
    L54:
        r122 = r100.getMaxPrice();
    L49:
        r120 = r100.price;
        goto L50
    L5:
        if ((!Intrinsics.areEqual(r101, r100)) == false) goto L7;
        goto L6
    }

    public final void d(boolean r100) {
        ECUIPromotion r101 = this.f150148d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUILotteryInfo r102 = r101.getLotteryInfo();
        if (r102 != null) goto L8;
        return;
    L8:
        int r103 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.c.f150308a;
        String r104 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.c.a(r102.getCountDownTime());
        if (r102.isLotteryFinish() == false) goto L17;
        String r105 = r102.getResultLabel();
        LivePromotionCardArgs r106 = this.f150149e;
        if (r106 == null) goto L15;
        ILivePromotionCardContainerHandler r107 = r106.f150038b;
        if (r107 == null) goto L15;
        r107.a();
    L15:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(getLotteryTickListener());
    L23:
        this.f150150f.C(ListItemPriceAreaModule$updateLotteryStatus$1.INSTANCE);
        this.f150150f.setText(r105);
        if (r100 == false) goto L45;
        ECUIPromotion r108 = this.f150148d;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L28:
        ECUILotteryInfo r109 = r108.getLotteryInfo();
        if (r109 != null) goto L31;
    L38:
        LivePromotionCardArgs r110 = this.f150149e;
        if (r110 == null) goto L43;
        ILivePromotionCardContainerHandler r111 = r110.f150038b;
        if (r111 == null) goto L43;
        r111.a();
    L43:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(getLotteryTickListener());
        return;
    L31:
        if (r109.needCountDown() != true) goto L38;
        LivePromotionCardArgs r112 = this.f150149e;
        if (r112 == null) goto L37;
        ILivePromotionCardContainerHandler r113 = r112.f150038b;
        if (r113 == null) goto L37;
        r113.a();
    L37:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.a(getLotteryTickListener());
        return;
    L45:
        return;
    L17:
        if (r104.length() <= 0) goto L19;
        boolean r114 = true;
    L20:
        if (r114 == false) goto L22;
        r105 = th.a.h(getContext(), R.string.ec_lottery_count_down, new Object[]{r104});
        goto L23
    L22:
        r105 = null;
        goto L23
    L19:
        r114 = false;
        goto L20
    }

    public final void f(int r100) {
        if (this.f150154j != r100) goto L5;
        return;
    L5:
        this.f150154j = r100;
        boolean r101 = true;
        if (r100 == 0) goto L13;
        if (r100 != 1) goto L9;
        this.f150150f.C(ListItemPriceAreaModule$updateStyle$4.INSTANCE);
        this.f150152h.setVisibility(8);
        this.f150153i.setVisibility(0);
        boolean r102 = true;
    L17:
        if (r102 == false) goto L19;
        this.f150150f.setMaxWidth(UtilityKotlinExtentionsKt.c(Float.valueOf(55.0f)));
    L21:
        if (this.f150154j == 1) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L31;
        this.f150150f.getLayoutParams().width = 0;
        ViewGroup.LayoutParams r103 = this.f150150f.getLayoutParams();
        if (r103 == null) goto L30;
        ((LinearLayout.LayoutParams) r103).weight = 1.0f;
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L31:
        this.f150150f.getLayoutParams().width = -2;
        ViewGroup.LayoutParams r104 = this.f150150f.getLayoutParams();
        if (r104 == null) goto L36;
        ((LinearLayout.LayoutParams) r104).weight = 0.0f;
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L19:
        this.f150150f.setMaxWidth(Integer.MAX_VALUE);
        goto L21
    L9:
        if (r100 != 2) goto L16;
        this.f150150f.C(ListItemPriceAreaModule$updateStyle$5.INSTANCE);
        this.f150151g.setVisibility(8);
        this.f150152h.setVisibility(8);
        this.f150153i.setVisibility(8);
    L16:
        r102 = false;
        goto L17
    L13:
        this.f150153i.setVisibility(8);
        this.f150150f.C(ListItemPriceAreaModule$updateStyle$1.INSTANCE);
        this.f150152h.C(new ListItemPriceAreaModule$updateStyle$2(this));
        this.f150152h.setBackgroundColor(0);
        this.f150152h.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r105 = this.f150152h.getLayoutParams();
        if (r105 == null) goto L38;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        r106.setMargins(r106.leftMargin, r106.topMargin, r106.rightMargin, 0);
        goto L16
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setArgument(LivePromotionCardArgs r100) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        this.f150149e = r100;
        this.f150150f.C(ListItemPriceAreaModule$initOptStyle$1.INSTANCE);     // Catch: Exception -> L5
        this.f150153i.C(ListItemPriceAreaModule$initOptStyle$2.INSTANCE);     // Catch: Exception -> L5
    L8:
        if (isBaselineAligned() == false) goto L13;
        setBaselineAligned(false);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f150154j != 1) goto L15;
        float r102 = this.f150150f.getTextSize();
        if (r102 < q.b(Float.valueOf(12.0f))) goto L7;
        int r103 = (int) ((r102 - q.b(Float.valueOf(12.0f))) * 0.6f);
    L8:
        ViewGroup.LayoutParams r104 = this.f150153i.getLayoutParams();
        if (r104 == null) goto L14;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105.bottomMargin == r103) goto L16;
        r105.setMargins(r105.leftMargin, r105.topMargin, r105.rightMargin, r103);
        return;
    L16:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L7:
        r103 = 0;
        goto L8
    }

    public ListItemPriceAreaModule(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f150155k = LazyKt.lazy(new ListItemPriceAreaModule$lotteryTickListener$2(this));
        th.a.c(r100, R.layout.shopping_layout_promotion_card_price_widget, this, true);
        this.f150150f = (PriceView) findViewById(R.id.pv_first_price);
        this.f150151g = (TextView) findViewById(R.id.tv_describe);
        this.f150152h = (PriceView) findViewById(R.id.pv_origin_price);
        PriceView r103 = (PriceView) findViewById(R.id.pv_deposit_price_view);
        this.f150153i = r103;
        r103.setMaxWidth(UtilityKotlinExtentionsKt.c(Float.valueOf(46.0f)));
    }

    public /* synthetic */ ListItemPriceAreaModule(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void e(final String r110, final long r111, final Long r112, final Long r113, final ECPriceDescription r114, final String r115) {
        this.f150150f.C(new ListItemPriceAreaModule$updatePriceViews$1(this, r110, r114, r111, r112, r115));
        if (r114 == null) goto L5;
        this.f150152h.setVisibility(0);
        this.f150152h.setText(r114.getName());
    L11:
        if (this.f150151g.getVisibility() != 8) goto L13;
        boolean r100 = true;
    L14:
        if (r100 == false) goto L28;
        ECUIPromotion r101 = this.f150148d;
        if (r101 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L19:
        if (r101.stockNum > 0) goto L21;
        return;
    L21:
        if (isBaselineAligned() == false) goto L23;
        setBaselineAligned(false);
    L23:
        this.f150151g.setVisibility(0);
        TextView r102 = this.f150151g;
        Context r103 = getContext();
        Object[] r104 = new Object[1];
        ECUIPromotion r105 = this.f150148d;
        if (r105 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L26:
        r104[0] = Long.valueOf(r105.stockNum);
        r102.setText(th.a.h(r103, R.string.ec_stock_num, r104));
        return;
    L28:
        return;
    L13:
        r100 = false;
        goto L14
    L5:
        if (r113 != null) goto L7;
    L9:
        this.f150152h.setVisibility(8);
        goto L11
    L7:
        if (r113.longValue() <= 0) goto L9;
        this.f150152h.setVisibility(0);
        this.f150152h.C(new ListItemPriceAreaModule$updatePriceViews$2(r113));
        goto L11
    }
}
