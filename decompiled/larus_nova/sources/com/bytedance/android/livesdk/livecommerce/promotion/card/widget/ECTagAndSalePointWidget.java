package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECAuctionStatusLayout;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.ECSalePointCarouselData;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class ECTagAndSalePointWidget extends LinearLayout implements ij2.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f150427n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LivePromotionCardArgs f150428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECLiveImageUtils.ECNetImageInfo f150429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECPromotionAuctionInfo f150430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f150431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.ec.common.api.jump.model.e f150432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ECNetImageView f150433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ECAuctionStatusLayout f150434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ECSalePointView f150435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ECSalePointView f150436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f150437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public StringBuilder f150438k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f150439l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f150440m;

    public static final class a {
    }

    static {
    }

    public ECTagAndSalePointWidget(Context r100) {
        this(r100, false, 14);
    }

    private final q83.a getLotteryTickListener() {
        return (q83.a) this.f150439l.getValue();
    }

    @Override // ij2.a
    public String getType() {
        return "tag_and_sales_point";
    }

    public final void c() {
        Unit r100 = null;
        if (this.f150440m == false) goto L12;
        ECNetImageView r101 = this.f150433f;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L7:
        r101.setVisibility(8);
        ECAuctionStatusLayout r102 = this.f150434g;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L10:
        r102.setVisibility(8);
    L58:
        ECSalePointView r103 = this.f150435h;
        if (r103 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L61:
        r103.setVisibility(8);
        ECSalePointView r104 = this.f150436i;
        if (r104 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L64:
        r104.setVisibility(8);
        com.bytedance.android.ec.common.api.jump.model.e r105 = this.f150432e;
        if (r105 == null) goto L67;
        ECUIPromotion r106 = r105.f42855a;
    L69:
        if (this.f150440m == false) goto L72;
        if (r106 != null) goto L76;
    L77:
        ECSalePointCarouselData r107 = null;
    L79:
        if (r107 == null) goto L85;
        List<ECCarouselData> r108 = r107.getData();
        if (r108 == null) goto L85;
        if ((!r108.isEmpty()) == false) goto L85;
        List<ECCarouselData> r109 = r108;
    L86:
        if (r107 == null) goto L127;
        if (r109 == null) goto L127;
        g r110 = this.f150437j;
        if (r110 == null) goto L91;
        r110.a();
    L91:
        this.f150437j = null;
        StringBuilder r111 = this.f150438k;
        if (r111 == null) goto L95;
        StringsKt.clear(r111);
    L95:
        if (r107.getCarouselTime() > 0) goto L97;
    L116:
        ECCarouselData r112 = (ECCarouselData) CollectionsKt.first(r109);
        ECSalePointView r113 = this.f150435h;
        if (r113 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L119:
        r113.setVisibility(0);
        ECSalePointView r114 = this.f150435h;
        if (r114 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L122:
        r114.a(r112);
        StringBuilder r115 = this.f150438k;
        if (r115 == null) goto L125;
        StringsKt.append(r115, new String[]{r112.getBefore(), r112.getContent()});
    L125:
        d((ECCarouselData) CollectionsKt.first(r109));
    L126:
        r100 = Unit.INSTANCE;
        goto L127
    L97:
        if (r109.size() == 1) goto L116;
        if (r109.size() <= 1) goto L126;
        long r116 = r107.getCarouselTime();
        g r117 = this.f150437j;
        if (r117 == null) goto L104;
        r117.a();
    L104:
        this.f150437j = null;
        LivePromotionCardArgs r118 = this.f150428a;
        if (r118 == null) goto L109;
        ILivePromotionCardContainerHandler r119 = r118.f150038b;
        if (r119 == null) goto L109;
        boolean r120 = r119.h(Decision.DEGRADE_SALE_POINT_LOOP);
    L110:
        this.f150437j = new g(this, r109, r109, r116, r116, r120);
        ECSalePointView r121 = this.f150435h;
        if (r121 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L113:
        r121.setVisibility(0);
        g r122 = this.f150437j;
        if (r122 == null) goto L126;
        r122.j();
    L109:
        r120 = false;
    L127:
        if (r100 != null) goto L136;
        ECSalePointView r123 = this.f150435h;
        if (r123 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L131:
        r123.setVisibility(0);
        ECSalePointView r124 = this.f150435h;
        if (r124 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L134:
        r124.a(new ECCarouselData(null, 0, this.f150431d, null, null, 27, null));
        Unit r125 = Unit.INSTANCE;
        return;
    L136:
        return;
    L85:
        r109 = null;
    L76:
        r107 = r106.recommendPointData;
        goto L79
    L72:
        if (r106 == null) goto L75;
        r107 = r106.getRealSalePointCarouselData();
        if (r107 != null) goto L79;
    L75:
        if (r106 == null) goto L77;
    L67:
        r106 = null;
        goto L69
    L12:
        if (this.f150429b == null) goto L21;
        ECNetImageView r126 = this.f150433f;
        if (r126 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L16:
        r126.setVisibility(0);
        ECNetImageView r127 = this.f150433f;
        if (r127 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L19:
        ECLiveImageUtils.b(r127, this.f150429b);
        goto L58
    L21:
        if (this.f150430c == null) goto L51;
        ECAuctionStatusLayout r128 = this.f150434g;
        if (r128 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L25:
        r128.setVisibility(0);
        ECAuctionStatusLayout r129 = this.f150434g;
        if (r129 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L28:
        ECPromotionAuctionInfo r130 = this.f150430c;
        Intrinsics.checkNotNull(r130);
        Function0<Unit> r131 = new ECTagAndSalePointWidget$refresh$1(this);
        r129.getClass();
        Intrinsics.checkNotNullParameter(r130, "auctionInfo");
        r129.f45892d = false;
        r129.f45895g = r131;
        r129.f45891c = r130;
        int r132 = wl.a.f560165b;
        r129.f45896h = wl.a.a(r130.getEndTime());
        r129.a(r130);
        ECAuctionStatusLayout r133 = this.f150434g;
        if (r133 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L32:
        if (r133.d(null) == false) goto L42;
        LivePromotionCardArgs r134 = this.f150428a;
        if (r134 == null) goto L38;
        ILivePromotionCardContainerHandler r135 = r134.f150038b;
        if (r135 == null) goto L38;
        r135.a();
    L38:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r136 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a;
        ECAuctionStatusLayout r137 = this.f150434g;
        if (r137 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L41:
        r136.a(r137);
        goto L58
    L42:
        LivePromotionCardArgs r138 = this.f150428a;
        if (r138 == null) goto L47;
        ILivePromotionCardContainerHandler r139 = r138.f150038b;
        if (r139 == null) goto L47;
        r139.a();
    L47:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r140 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a;
        ECAuctionStatusLayout r141 = this.f150434g;
        if (r141 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L50:
        r140.b(r141);
        e();
        goto L58
    L51:
        ECNetImageView r142 = this.f150433f;
        if (r142 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L54:
        r142.setVisibility(8);
        ECAuctionStatusLayout r143 = this.f150434g;
        if (r143 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L57:
        r143.setVisibility(8);
        goto L58
    }

    public final void e() {
        ECPromotionAuctionInfo r100 = this.f150430c;
        if (r100 == null) goto L19;
        ECAuctionStatusLayout r101 = this.f150434g;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L8:
        if (r101.e(r100) == false) goto L20;
        c();
        com.bytedance.android.ec.common.api.jump.model.e r102 = this.f150432e;
        if (r102 == null) goto L21;
        ECUIPromotion r103 = r102.f42855a;
        if (r103 == null) goto L22;
        LivePromotionCardArgs r104 = this.f150428a;
        if (r104 == null) goto L23;
        ILivePromotionCardContainerHandler r105 = r104.f150038b;
        if (r105 == null) goto L24;
        r105.f(r103);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // ij2.a
    public String getCurrentContentDescription() {
        StringBuilder r100 = this.f150438k;
        if (r100 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r100);
    }

    @Override // ij2.a
    public final void release() {
        LivePromotionCardArgs r100 = this.f150428a;
        if (r100 == null) goto L7;
        ILivePromotionCardContainerHandler r101 = r100.f150038b;
        if (r101 == null) goto L7;
        r101.a();
    L7:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r102 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a;
        r102.b(getLotteryTickListener());
        LivePromotionCardArgs r103 = this.f150428a;
        if (r103 == null) goto L12;
        ILivePromotionCardContainerHandler r104 = r103.f150038b;
        if (r104 == null) goto L12;
        r104.a();
    L12:
        ECAuctionStatusLayout r105 = this.f150434g;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L15:
        r102.b(r105);
        g r106 = this.f150437j;
        if (r106 == null) goto L18;
        r106.a();
    L18:
        this.f150437j = null;
    }

    @Override // ij2.a
    public final boolean a() {
        return ij2.a.C6273a.b(this);
    }

    @Override // ij2.a
    public ij2.b getParentContainer() {
        return ij2.a.C6273a.a(this);
    }

    @Override // ij2.a
    public final void b(com.bytedance.android.ec.common.api.jump.model.e r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ECUIPromotion r101 = r100.f42855a;
        this.f150438k = new StringBuilder();
        this.f150432e = r100;
        ViewGroup.LayoutParams r102 = null;
        if (r101.isAuction() == false) goto L5;
        ECUIPromotion r103 = r101;
    L6:
        if (r103 == null) goto L8;
        ECPromotionAuctionInfo r104 = r103.getAuctionInfo();
    L9:
        this.f150430c = r104;
        this.f150431d = null;
        if (this.f150440m == true) goto L14;
        ECSalePointCarouselData r105 = r101.getRealSalePointCarouselData();
        if (r105 == null) goto L14;
    L15:
        if (r105 == null) goto L17;
        ECUrlModel r106 = r105.getLeftIcon();
    L19:
        if (r106 == null) goto L34;
        ECLiveImageUtils.ECNetImageInfo r107 = new ECLiveImageUtils.ECNetImageInfo();
        String r108 = r106.getFirstUrl();
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        r107.url = r108;
        r107.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r106.getWidth()));
        r107.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r106.getHeight()));
        Unit r109 = Unit.INSTANCE;
        this.f150429b = r107;
        ECNetImageView r110 = this.f150433f;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L26:
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if ((r111 instanceof LinearLayout.LayoutParams) == false) goto L30;
        r102 = r111;
    L30:
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r102;
        if (r112 == null) goto L40;
        r112.gravity = 16;
    L40:
        f(true);
        c();
        return;
    L34:
        if (r101.isFindGoods() == false) goto L39;
        ECLiveImageUtils.ECNetImageInfo r113 = new ECLiveImageUtils.ECNetImageInfo();
        r113.url = r101.findGoodsInfo;
        ECNetImageView r114 = this.f150433f;
        if (r114 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L38:
        r113.height = r114.getLayoutParams().height;
        r113.width = -3;
        r113.autoScaleOneSide = true;
        Unit r115 = Unit.INSTANCE;
        this.f150429b = r113;
        goto L40
    L39:
        this.f150429b = null;
        goto L40
    L17:
        r106 = null;
    L14:
        r105 = r101.recommendPointData;
        goto L15
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final void d(ECCarouselData r100) {
        if (r100.getType() != 3) goto L11;
        com.bytedance.android.ec.common.api.jump.model.e r101 = this.f150432e;
        if (r101 == null) goto L21;
        LivePromotionCardArgs r102 = this.f150428a;
        if (r102 == null) goto L22;
        PromotionListEventActionImpl r103 = r102.f150099h;
        if (r103 == null) goto L23;
        r103.f(r100.getEventParam(), r101.f42856b, null);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L11:
        LivePromotionCardArgs r104 = this.f150428a;
        if (r104 == null) goto L25;
        PromotionListEventActionImpl r105 = r104.f150099h;
        if (r105 == null) goto L26;
        Map<String, String> r106 = r100.getEventParam();
        com.bytedance.android.ec.common.api.jump.model.e r107 = this.f150432e;
        if (r107 == null) goto L18;
        com.bytedance.android.ec.common.api.jump.model.g r108 = r107.f42856b;
    L19:
        r105.a(r106, r108, null);
        return;
    L18:
        r108 = null;
        goto L19
    L26:
        return;
    }

    public final void f(boolean r100) {
        com.bytedance.android.ec.common.api.jump.model.e r101 = this.f150432e;
        if (r101 == null) goto L36;
        ECUIPromotion r102 = r101.f42855a;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.isScarceLottery() == true) goto L9;
        return;
    L9:
        String r103 = r102.getLotteryElasticTitleText();
        if (r103 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L18;
        this.f150431d = r103;
    L18:
        if (r100 == false) goto L38;
        ECUILotteryInfo r105 = r102.getLotteryInfo();
        if (r105 != null) goto L22;
    L29:
        LivePromotionCardArgs r106 = this.f150428a;
        if (r106 == null) goto L34;
        ILivePromotionCardContainerHandler r107 = r106.f150038b;
        if (r107 == null) goto L34;
        r107.a();
    L34:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(getLotteryTickListener());
        return;
    L22:
        if (r105.needCountDown() != true) goto L29;
        LivePromotionCardArgs r108 = this.f150428a;
        if (r108 == null) goto L28;
        ILivePromotionCardContainerHandler r109 = r108.f150038b;
        if (r109 == null) goto L28;
        r109.a();
    L28:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.a(getLotteryTickListener());
        return;
    L38:
        return;
    L12:
        if (r103.length() == 0) goto L15;
        r104 = false;
        goto L16
    }

    public final void setArgument(LivePromotionCardArgs r100) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        this.f150428a = r100;
    }

    public ECTagAndSalePointWidget(Context r100, boolean r101, int r110) {
        if ((r110 & 2) == 0) goto L5;
        r101 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f150440m = r101;
        ECNetImageView r102 = new ECNetImageView(getContext());
        Float r103 = Float.valueOf(16.0f);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(r103)));
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if (r104 == null) goto L29;
        ((LinearLayout.LayoutParams) r104).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)), 0);
        r102.setVisibility(8);
        Unit r105 = Unit.INSTANCE;
        this.f150433f = r102;
        addView(r102);
        ECAuctionStatusLayout r106 = new ECAuctionStatusLayout(getContext(), null);
        r106.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(r103)));
        ViewGroup.LayoutParams r111 = r106.getLayoutParams();
        if (r111 == null) goto L27;
        ((LinearLayout.LayoutParams) r111).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)), 0);
        r106.setVisibility(8);
        this.f150434g = r106;
        addView(r106);
        this.f150435h = new ECSalePointView(getContext());
        this.f150436i = new ECSalePointView(getContext());
        if (r101 == false) goto L18;
        ECSalePointView r107 = this.f150435h;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L14:
        r107.f150426d = true;
        ECSalePointView r108 = this.f150436i;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L17:
        r108.f150426d = true;
    L18:
        FrameLayout r109 = new FrameLayout(getContext());
        ECSalePointView r112 = this.f150435h;
        if (r112 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L21:
        r109.addView(r112);
        ECSalePointView r113 = this.f150436i;
        if (r113 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L24:
        r109.addView(r113);
        addView(r109);
        this.f150439l = LazyKt.lazy(new ECTagAndSalePointWidget$lotteryTickListener$2(this));
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
}
