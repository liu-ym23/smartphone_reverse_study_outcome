package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.p1;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AdInfoStruct;
import com.bytedance.android.ec.model.response.anchorv3.ProductDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SeckillInfo;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardRecommendReasonStruct;
import com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.android.shopping.widget.PriceView;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3GuessULikeProductView;", "Landroid/widget/RelativeLayout;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3GuessULikeProductView extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f165436j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f165437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f165438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j63.c f165439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f165440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f165441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f165442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f165443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f165444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f165445i;

    public static final class a {
    }

    static {
    }

    public AnchorV3GuessULikeProductView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3GuessULikeProductView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f165437a != null) goto L5;
        this.f165437a = new LinkedHashMap();
    L5:
        View r101 = this.f165437a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f165437a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void d(SeckillInfo r100, List<PromotionDiscountLabel> r101) {
        if (r100 != null) goto L5;
    L6:
        List<PromotionDiscountLabel> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L26;
    L14:
        ((LinearLayout) a(R.id.ll_guess_u_like_extra_info_area)).setVisibility(0);
        TextView r104 = (TextView) a(R.id.anchor_v3_guess_u_like_seckill_tag);
        if (r100 != null) goto L17;
    L19:
        int r105 = 8;
    L20:
        r104.setVisibility(r105);
        if (r101 == null) goto L25;
        PromotionDiscountLabel r106 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r101);
        if (r106 == null) goto L25;
        ((LinearLayout) a(R.id.cv_guess_u_like_coupon)).setVisibility(0);
        ((TextView) ((LinearLayout) a(R.id.cv_guess_u_like_coupon)).findViewById(R.id.anchor_v4_gul_coupon_text)).setText(r106.getTag());
        return;
    L25:
        ((LinearLayout) a(R.id.cv_guess_u_like_coupon)).setVisibility(8);
        return;
    L17:
        if (r100.isInSecKill() != true) goto L19;
        r105 = 0;
        goto L20
    L26:
        ((LinearLayout) a(R.id.ll_guess_u_like_extra_info_area)).setVisibility(8);
        return;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        if (r100.isInSecKill() == true) goto L14;
        goto L6
    }

    public AnchorV3GuessULikeProductView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f165437a = new LinkedHashMap();
        u63.a.a(r100, R.layout.ec_commerce_anchor_v3_recommend_product_layout, this, true);
        View r103 = a(R.id.anchor_v3_guess_u_like_rootview);
        if (r103 == null) goto L5;
        r103.setOnLongClickListener(new m(this));
    L5:
        View r104 = a(R.id.iv_guess_u_like_image);
        if (r104 == null) goto L8;
        r104.setOnLongClickListener(new m(this));
    L8:
        this.f165441e = ECAppInfoService.f48114e.f();
        this.f165440d = "";
        this.f165443g = SystemClock.elapsedRealtime();
        this.f165444h = true;
    }

    public static void e(RoundedLinearLayout r100, View r101, int r102) {
        int r103 = r100.indexOfChild(r101);
        if (r103 == 1) goto L8;
        if (r102 == r103) goto L9;
        r100.removeView(r101);
        r100.addView(r101, r102);
        return;
    L9:
        return;
    }

    public /* synthetic */ AnchorV3GuessULikeProductView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void b(AnchorV3GuessULikeProductView r100, Function1 r101, Integer r102, String r103) {
        if (((AnchorV3GuessULikeFeedbackView) r100.a(R.id.anchor_v3_recommend_feedback_view)).getVisibility() != 0) goto L5;
        ((AnchorV3GuessULikeFeedbackView) r100.a(R.id.anchor_v3_recommend_feedback_view)).T5(false, r100, "1");
        return;
    L5:
        if (r101 == null) goto L7;
        Unit r104 = (Unit) r101.invoke(r102);
    L7:
        int r105 = com.bytedance.android.shopping.anchorv3.utils.g.f165309a;
        com.bytedance.android.shopping.anchorv3.utils.g.c("click", r100.f165439c, Long.valueOf(SystemClock.elapsedRealtime() - r100.f165443g), r103);
        j63.c r106 = r100.f165439c;
        if (r106 == null) goto L10;
        AdInfoStruct r107 = r106.a();
    L11:
        com.bytedance.android.shopping.anchorv3.utils.g.d("click", r107);
        return;
    L10:
        r107 = null;
        goto L11
    }

    public static void g(View r100, int r101, int r102, int r103, int r104) {
        ViewGroup.LayoutParams r105 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
    L7:
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        r105 = r106;
    L10:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r105;
        if (r107 != null) goto L14;
        return;
    L14:
        if (r101 <= (-1)) goto L16;
        r107.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r101));
    L16:
        if (r102 <= (-1)) goto L18;
        r107.topMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102));
    L18:
        if (r103 <= (-1)) goto L20;
        r107.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r103));
    L20:
        if (r104 <= (-1)) goto L22;
        r107.bottomMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r104));
    L22:
        r100.setLayoutParams(r107);
        return;
    L5:
        r106 = null;
        goto L7
    }

    public static /* synthetic */ void h(View r100, int r101, int r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = -1;
    L6:
        if ((r104 & 4) == 0) goto L8;
        int r105 = -1;
    L10:
        if ((r104 & 8) == 0) goto L13;
        r102 = -1;
    L13:
        if ((r104 & 16) == 0) goto L15;
        r103 = -1;
    L15:
        g(r100, r101, r105, r102, r103);
        return;
    L8:
        r105 = 0;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r9v13, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v6, types: [T, java.lang.String] */
    public final void c(ItemCardRecommendReasonStruct r110, PromotionProductStruct r111, boolean r112, Integer r210, String r211, AnchorV4GuessBaseVH.a r212) {
        ViewGroup.LayoutParams r100 = null;
        if (r112 == false) goto L5;
        int r101 = com.bytedance.android.shopping.feed.utils.n.f175460a;
        com.bytedance.android.shopping.feed.viewmodel.d r102 = com.bytedance.android.shopping.feed.utils.n.a(r111, getContext());
        String r113 = r102.f175750a;
        if (r113 != null) goto L73;
        return;
    L73:
        if (r113.length() <= 0) goto L75;
        boolean r114 = true;
    L76:
        if (r114 == true) goto L78;
        return;
    L78:
        if (r102.f175751b < 0) goto L100;
        a(R.id.anchor_v3_recommend_reason_info).setVisibility(0);
        Ref.IntRef r103 = new Ref.IntRef();
        r103.element = 0;
        if (r102.f175751b != 0) goto L89;
        ((SimpleDraweeView) a(R.id.anchor_v3_sv_recommend_reason_icon)).setVisibility(0);
        ViewGroup.LayoutParams r104 = ((SimpleDraweeView) a(R.id.anchor_v3_sv_recommend_reason_icon)).getLayoutParams();
        if ((r104 instanceof LinearLayout.LayoutParams) == false) goto L85;
        r100 = r104;
    L85:
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r100;
        if (r105 == null) goto L88;
        r105.width = getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_product_recommend_good_comment_icon_size);
        r105.height = getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_product_recommend_good_comment_icon_size);
        ((SimpleDraweeView) a(R.id.anchor_v3_sv_recommend_reason_icon)).setLayoutParams(r105);
        r103.element = getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_product_recommend_good_comment_icon_size);
    L88:
        ((SimpleDraweeView) a(R.id.anchor_v3_sv_recommend_reason_icon)).setBackgroundResource(R.drawable.ec_commerce_recommend_good_comment);
    L90:
        ((TextView) a(R.id.anchor_v3_sv_recommend_content)).setText(r102.f175750a);
        a(R.id.anchor_v3_recommend_reason_info).post(new r(r103, this));
        ((ImageView) a(R.id.anchor_v3_sv_recommend_more_btn)).setOnClickListener(new s(this));
        return;
    L89:
        ((SimpleDraweeView) a(R.id.anchor_v3_sv_recommend_reason_icon)).setVisibility(8);
        ((SimpleDraweeView) a(R.id.anchor_v3_sv_recommend_reason_icon)).setBackgroundResource(R.color.transparent);
        goto L90
    L100:
        return;
    L75:
        r114 = false;
        goto L76
    L5:
        if (r110 == null) goto L35;
        String r115 = r110.getContent();
        if (r115 == null) goto L35;
        String r116 = a2.d(r115);
        if (r116 == null) goto L35;
        Integer r117 = r110.getReasonType();
        if (r117 != null) goto L14;
    L16:
        SimpleDraweeView r118 = (SimpleDraweeView) a(R.id.anchor_v3_sv_recommend_reason_icon);
    L17:
        a(R.id.anchor_v3_recommend_reason_info).setVisibility(0);
        ECUrlModel r119 = r110.getCover();
        if (r119 == null) goto L33;
        int r120 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r119.getWidth()));
        int r121 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r119.getHeight()));
        r118.setVisibility(0);
        Integer r122 = r110.getReasonType();
        if (r122 != null) goto L23;
    L25:
        ((SimpleDraweeView) a(R.id.anchor_v3_sv_rank_recommend_reason_icon)).setVisibility(8);
        ((SimpleDraweeView) a(R.id.anchor_v3_sv_recommend_reason_icon)).setVisibility(0);
    L26:
        ((TextView) a(R.id.anchor_v3_sv_recommend_content)).setText(r116);
        a(R.id.anchor_v3_recommend_reason_info).post(new n(r120, this));
        ViewGroup.LayoutParams r106 = r118.getLayoutParams();
        if ((r106 instanceof LinearLayout.LayoutParams) == true) goto L29;
        r106 = null;
    L29:
        LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r106;
        if (r107 == null) goto L32;
        r107.width = r120;
        r107.height = r121;
        r118.setLayoutParams(r107);
    L32:
        com.bytedance.android.ec.core.utils.y.c(r118, r110.getCover(), r120, r121, null);
    L34:
        ((ImageView) a(R.id.anchor_v3_sv_recommend_more_btn)).setOnClickListener(new o(this));
    L36:
        if (r110 == null) goto L69;
        String r108 = r110.getContent();
        if (r108 == null) goto L69;
        String r109 = a2.d(r108);
        if (r109 == null) goto L69;
        Integer r123 = r110.getReasonType();
        if (r123 != null) goto L45;
        return;
    L45:
        if (r123.intValue() != 4) goto L92;
        Integer r124 = r110.getRankStyle();
        if (r124 == null) goto L49;
        int r125 = r124.intValue();
    L50:
        if (r125 == 0) goto L93;
        Ref.ObjectRef r126 = new Ref.ObjectRef();
        String r127 = r110.getLink();
        ?? r128 = r127;
        if (r127 != null) goto L54;
        r128 = "";
    L54:
        r126.element = r128;
        ?? r129 = p0.d(r128, "enter_from", "product_detail_guessyoulike");
        r126.element = r129;
        String r130 = this.f165442f;
        if (r130 == null) goto L57;
        r126.element = p0.d(r129, "ecom_scene_id", r130);
    L57:
        final int r131 = ContextCompat.getColor(getContext(), R.color.commerce_color_BDFFF4F7);
        Drawable r132 = com.bytedance.commerce.base.drawable.a.a(new AnchorV3GuessULikeProductView$showAnchorV3GuessRecommendView$4$gd$1(r131));
        Integer r133 = r110.getRankNo();
        int r134 = 11;
        if (r133 == null) goto L60;
        int r135 = r133.intValue();
    L62:
        if (10 >= r135) goto L64;
        ((TextView) a(R.id.anchor_v3_sv_recommend_content)).setTextColor(ContextCompat.getColor(getContext(), R.color.commerce_color_FE2C55));
        ((LinearLayout) a(R.id.anchor_v3_ll_recommend_reason_container)).setBackground(r132);
        ((ImageView) a(R.id.anchor_v3_rank_arrow_normal_style)).setVisibility(0);
        ((ImageView) a(R.id.anchor_v3_sv_recommend_more_btn)).setVisibility(8);
        a(R.id.anchor_v3_recommend_reason_info).setOnClickListener(new p(r126, this, r110, r212, r210, r211));
        return;
    L64:
        Integer r136 = r110.getRankNo();
        if (r136 == null) goto L67;
        r134 = r136.intValue();
    L67:
        if (10 < r134) goto L95;
        ((RelativeLayout) a(R.id.anchor_v3_recommend)).setVisibility(8);
        ((RelativeLayout) a(R.id.anchor_v3_rank)).setVisibility(0);
        ((RelativeLayout) a(R.id.anchor_v3_rank)).setBackground(r132);
        ((TextView) a(R.id.anchor_v3_rank_No)).setText(th.a.f(getContext()).getString(R.string.TOP, new Object[]{String.valueOf(r110.getRankNo())}));
        ((AppCompatTextView) a(R.id.anchor_v3_rank_content)).setText(r109);
        ((TextView) a(R.id.anchor_v3_rank_No)).getPaint().setFakeBoldText(true);
        ((RelativeLayout) a(R.id.anchor_v3_rank)).setOnClickListener(new q(r126, this, r110, r212, r210, r211));
        return;
    L95:
        return;
    L60:
        r135 = 11;
        goto L62
    L93:
        return;
    L49:
        r125 = 0;
        goto L50
    L92:
        return;
    L69:
        a(R.id.anchor_v3_recommend_reason_info).setVisibility(8);
        return;
    L23:
        if (r122.intValue() != 4) goto L25;
        ((SimpleDraweeView) a(R.id.anchor_v3_sv_rank_recommend_reason_icon)).setVisibility(0);
        ((SimpleDraweeView) a(R.id.anchor_v3_sv_recommend_reason_icon)).setVisibility(8);
        goto L26
    L33:
        r118.setVisibility(8);
        goto L34
    L14:
        if (r117.intValue() != 4) goto L16;
        r118 = (SimpleDraweeView) a(R.id.anchor_v3_sv_rank_recommend_reason_icon);
    L35:
        a(R.id.anchor_v3_recommend_reason_info).setVisibility(8);
        goto L36
    }

    public static void f(final AnchorV3GuessULikeProductView r210, j63.c r211, CompositeDisposable r212, final Function1 r213, RecyclerView.Adapter r310, RecyclerView r311, Function0 r312, final Integer r313, String r314, String r315, AnchorV4GuessBaseVH.a r316, boolean r317) {
        Intrinsics.checkNotNullParameter(r211, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r212, "compositeDisposable");
        Intrinsics.checkNotNullParameter(r310, "adapter");
        Intrinsics.checkNotNullParameter(r311, "recyclerView");
        Intrinsics.checkNotNullParameter(r314, "packApiLogId");
        r210.f165439c = r211;
        r210.f165442f = r315;
        com.bytedance.android.ec.core.widget.f.c(r210.a(R.id.anchor_v3_guess_u_like_rootview), null, null, new AnchorV3GuessULikeProductView$fill$1(r210, r213, r313), 3);
        com.bytedance.android.ec.core.widget.f.c(r210.a(R.id.iv_guess_u_like_image), null, null, new AnchorV3GuessULikeProductView$fill$2(r210, r213, r313), 3);
        RoundedLinearLayout r100 = (RoundedLinearLayout) r210.findViewById(R.id.anchor_v3_guess_u_like_touch_area);
        LinearLayout r101 = (LinearLayout) r210.findViewById(R.id.ll_guess_u_like_extra_info_area);
        RelativeLayout r102 = (RelativeLayout) r210.findViewById(R.id.anchorv3_price_info_layout);
        RelativeLayout r110 = (RelativeLayout) r210.findViewById(R.id.anchorv3_recommend_price_info_layout);
        e(r100, r101, 2);
        ECUrlModel r103 = r211.f();
        if (r103 == null) goto L5;
        ImageExtensionsKt.D((GenericDraweeView) r210.a(R.id.iv_guess_u_like_image), new com.bytedance.android.ec.core.imagex.r("ec_detail", "ec_recommend_product_image"));
        com.bytedance.android.ec.core.utils.y.c((GenericDraweeView) r210.a(R.id.iv_guess_u_like_image), r103, -1, -1, new z53.a(r103.getUrlList(), ImagePosition.GOODS_RECOMMEND.getValue(), null, false, 28));
    L5:
        ItemCardProductStruct r104 = r211.d();
        if (r104 == null) goto L10;
        PromotionMarketFloor r105 = r104.getPlatformTextActivity();
        if (r105 == null) goto L10;
        ECUrlModel r106 = r105.getIcon();
    L11:
        ItemCardProductStruct r107 = r211.d();
        if (r107 == null) goto L14;
        String r214 = r107.getTitle();
    L15:
        ItemCardProductStruct r108 = r211.d();
        if (r108 == null) goto L18;
        ECUrlModel r109 = r108.getProductIcon();
    L19:
        Disposable r111 = r210.f165438b;
        if (r111 == null) goto L22;
        r212.remove(r111);
    L22:
        ArrayList r112 = new ArrayList();
        if (r106 == null) goto L25;
        r112.add(r106);
    L25:
        if (r109 == null) goto L27;
        r112.add(r109);
    L27:
        Disposable r113 = p1.b(p1.f45668d, r112, r214, 4.0f, 16.0f, (TextView) r210.a(R.id.tv_guess_u_like_title));
        if (r113 == null) goto L30;
        r210.f165438b = r113;
        r212.add(r113);
    L30:
        ((TextView) r210.a(R.id.tv_guess_u_like_title)).setMaxLines(2);
        ((TextView) r210.a(R.id.tv_guess_u_like_title)).setTypeface(Typeface.DEFAULT);
        ItemCardProductStruct r114 = r211.d();
        if (r114 == null) goto L33;
        PromotionProductPrice r115 = r114.getPrice();
    L34:
        ItemCardProductStruct r116 = r211.d();
        if (r116 == null) goto L37;
        ItemCardRecommendReasonStruct r117 = r116.getRecommendReason();
    L38:
        ItemCardProductStruct r118 = r211.d();
        if (r118 == null) goto L41;
        Boolean r119 = r118.getHideSales();
    L42:
        Boolean r120 = Boolean.TRUE;
        if (Intrinsics.areEqual(r119, r120) == true) goto L48;
        ItemCardProductStruct r121 = r211.d();
        if (r121 == null) goto L48;
        Long r122 = r121.getSales();
    L49:
        if (r115 == null) goto L53;
        ProductDiscountPrice r123 = r115.getDiscountPrice();
        if (r123 == null) goto L53;
        Long r124 = Long.valueOf(r123.getPrice());
    L54:
        if (r115 == null) goto L56;
        Long r125 = r115.getMinPrice();
    L57:
        if (r117 == null) goto L59;
        String r126 = r117.getContent();
    L60:
        if (r126 != null) goto L62;
    L65:
        boolean r127 = true;
    L67:
        if (r127 == true) goto L69;
        ((RelativeLayout) r210.a(R.id.anchorv3_price_info_layout)).setVisibility(8);
        ((RelativeLayout) r210.a(R.id.anchorv3_recommend_price_info_layout)).setVisibility(0);
        ((PriceView) r210.a(R.id.anchorv3_recommend_guess_u_like_price)).post(new l(r210));
        PriceView r128 = (PriceView) r210.a(R.id.anchorv3_recommend_guess_u_like_price);
        TextView r129 = (TextView) r210.a(R.id.anchorv3_recommend_tv_guess_u_like_sales);
    L70:
        if (r125 == null) goto L80;
        long r215 = r125.longValue();
        if (r124 != null) goto L74;
    L78:
        r128.setPriceText(com.bytedance.android.shopping.utils.g.d(r215));
        goto L80
    L74:
        if (r124.longValue() >= r215) goto L78;
        if (r124.longValue() <= 0) goto L78;
        int r130 = com.bytedance.android.shopping.utils.g.f187081a;
        r128.setPriceText(com.bytedance.android.shopping.utils.g.d(r124.longValue()));
    L80:
        if (r210.f165441e == true) goto L84;
        if (r122 == null) goto L84;
        int r131 = g1.f45599a;
        Context r132 = r210.getContext();
        int r133 = k0.f187151a;
        r129.setText(g1.a.c(r132, R.string.commerce_seeds_sell_count, new Object[]{k0.a(r122.longValue())}));
    L85:
        if (r115 == null) goto L87;
        String r134 = r115.getTypeText();
    L88:
        r128.setExtraText(r134);
        int r135 = g1.f45599a;
        r128.setExtraTextColor(g1.a.a(r128.getContext(), R.color.primary));
        ((AnchorV3GuessULikeFeedbackView) r210.a(R.id.anchor_v3_recommend_feedback_view)).R5(r211, new AnchorV3GuessULikeProductView$fill$3(r210), r311, r310, true, r316, r312);
        SeckillInfo r136 = r211.g();
        ItemCardProductStruct r137 = r211.d();
        if (r137 == null) goto L91;
        List<PromotionDiscountLabel> r138 = r137.getDiscountLabels();
    L92:
        r210.d(r136, r138);
        ItemCardProductStruct r139 = r211.d();
        if (r139 == null) goto L95;
        ItemCardRecommendReasonStruct r140 = r139.getRecommendReason();
    L96:
        r210.c(r140, r211.e(), false, r313, r314, r316);
        h(r210.a(R.id.tv_guess_u_like_title), 10, 10, 0, 20);
        g(r210.a(R.id.ll_guess_u_like_extra_info_area), 10, 8, 10, 0);
        h(r210.a(R.id.anchorv3_price_info_layout), 10, 0, 0, 12);
        AdInfoStruct r141 = r211.a();
        View r142 = r210.findViewById(R.id.tv_ad_tag);
        if (r141 == null) goto L99;
        Boolean r143 = r141.getShowAdTag();
    L101:
        if (Intrinsics.areEqual(r143, r120) == false) goto L103;
        r142.setVisibility(0);
    L104:
        if (r317 == false) goto L107;
        ((RoundedLinearLayout) r210.a(R.id.anchor_v3_recommend_product_container)).setRadius(com.bytedance.android.shopping.extensions.b.b(8));
        return;
    L107:
        return;
    L103:
        r142.setVisibility(8);
        goto L104
    L99:
        r143 = null;
        goto L101
    L95:
        r140 = null;
        goto L96
    L91:
        r138 = null;
        goto L92
    L87:
        r134 = null;
    L84:
        r129.setVisibility(8);
        goto L85
    L69:
        ((RelativeLayout) r210.a(R.id.anchorv3_price_info_layout)).setVisibility(0);
        ((RelativeLayout) r210.a(R.id.anchorv3_recommend_price_info_layout)).setVisibility(8);
        ((PriceView) r210.a(R.id.anchorv3_guess_u_like_price)).post(new j(r210));
        ((ImageView) r210.a(R.id.anchor_v3_iv_guess_u_like_more)).setOnClickListener(new k(r210));
        r128 = (PriceView) r210.a(R.id.anchorv3_guess_u_like_price);
        r129 = (TextView) r210.a(R.id.anchorv3_guess_u_like_sales);
        goto L70
    L62:
        if (r126.length() == 0) goto L65;
        r127 = false;
        goto L67
    L59:
        r126 = null;
        goto L60
    L56:
        r125 = null;
    L53:
        r124 = null;
    L48:
        r122 = null;
        goto L49
    L41:
        r119 = null;
        goto L42
    L37:
        r117 = null;
        goto L38
    L33:
        r115 = null;
        goto L34
    L18:
        r109 = null;
        goto L19
    L14:
        r214 = null;
    L10:
        r106 = null;
        goto L11
    }
}
