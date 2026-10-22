package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.p1;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AdInfoStruct;
import com.bytedance.android.ec.model.response.anchorv3.ProductDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrice;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardLiveStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH;
import com.bytedance.android.shopping.widget.PriceView;
import com.bytedance.mt.protector.impl.UriProtector;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3GuessULikeLiveView;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3GuessULikeLiveView extends FrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f165417l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f165418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f165419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j63.c f165420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f165421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.guess.f f165422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f165423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f165424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f165425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f165426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f165427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f165428k;

    public static final class a {
    }

    static {
    }

    public AnchorV3GuessULikeLiveView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3GuessULikeLiveView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f165418a != null) goto L5;
        this.f165418a = new LinkedHashMap();
    L5:
        View r101 = this.f165418a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f165418a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public AnchorV3GuessULikeLiveView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f165418a = new LinkedHashMap();
        u63.a.a(r100, R.layout.ec_commerce_anchor_v3_recommend_live_layout, this, true);
        i r103 = new i(this);
        ((RelativeLayout) a(R.id.anchor_v3_recommend_live_rl_container)).setOnLongClickListener(r103);
        ((RelativeLayout) a(R.id.anchor_v3_recommend_product_container)).setOnLongClickListener(r103);
        ((LinearLayout) a(R.id.anchor_v3_recommend_bottom_info_container)).setOnLongClickListener(r103);
        h r104 = new h(this);
        ((RelativeLayout) a(R.id.anchor_v3_recommend_live_rl_container)).setOnClickListener(r104);
        ((LinearLayout) a(R.id.anchor_v3_recommend_bottom_info_container)).setOnClickListener(r104);
        ((RelativeLayout) a(R.id.anchor_v3_recommend_product_container)).setOnClickListener(new g(this));
        this.f165421d = "";
        this.f165425h = 0L;
        SystemClock.elapsedRealtime();
        this.f165426i = true;
    }

    public /* synthetic */ AnchorV3GuessULikeLiveView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final String b(AnchorV3GuessULikeLiveView r110, String r111, AdInfoStruct r112, int r113) {
        r110.getClass();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L20
        String r101 = null;
        if (r112 == null) goto L6;
        String r114 = r112.getRawData();     // Catch: Throwable -> L20
    L7:
        String r115 = a2.d(r114);     // Catch: Throwable -> L20
        if (r115 == null) goto L27;
        JSONObject r116 = com.bytedance.android.shopping.extensions.k.w(r115);     // Catch: Throwable -> L20
        if (r116 == null) goto L28;
        JSONObject r117 = r116.optJSONObject("raw_ad_data");     // Catch: Throwable -> L20
        if (r117 == null) goto L29;
        int r102 = p0.f45664a;     // Catch: Throwable -> L20
        String r103 = p0.d(p0.d(p0.d(p0.d(p0.d(r111, "creative_id", r117.optString("creative_id")), "log_extra", r117.optString("log_extra")), "ad_id", r117.optString("ad_id")), "is_other_channel", com.bytedance.android.ec.core.event.a.VALUE_EFFECTIVE_AD), "outflow_order", String.valueOf(r113));     // Catch: Throwable -> L20
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L20
        r104.put("creative_id", r117.optString("creative_id"));     // Catch: Throwable -> L20
        r104.put("log_extra", r117.optString("log_extra"));     // Catch: Throwable -> L20
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
        String r106 = p0.d(r103, ILiveRoomPlayFragmentConstant.IES_LIVE_EFFECT_AD_TRACK_EXTRA_SERVICE, r104.toString());     // Catch: Throwable -> L20
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L20
        r107.put("creative_id", r117.optString("creative_id"));     // Catch: Throwable -> L20
        r107.put("log_extra", r117.optString("log_extra"));     // Catch: Throwable -> L20
        r107.put("is_other_channel", com.bytedance.android.ec.core.event.a.VALUE_EFFECTIVE_AD);     // Catch: Throwable -> L20
        String r118 = p0.d(r106, "extra_params", r107.toString());     // Catch: Throwable -> L20
        r107.put("outflow_order", String.valueOf(r113));     // Catch: Throwable -> L20
        JSONObject r119 = com.bytedance.android.shopping.extensions.k.w(UriProtector.getQueryParameter(UriProtector.parse(r118), ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS));     // Catch: Throwable -> L20
        if (r119 == null) goto L16;
        r119.put("pass_through_log_data", r107.toString());     // Catch: Throwable -> L20
        r101 = r119.toString();     // Catch: Throwable -> L20
    L16:
        if (r101 != null) goto L18;
        r101 = "";
    L18:
        return p0.d(r118, ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r101);
    L29:
        return r111;
    L28:
        return r111;
    L27:
        return r111;
    L6:
        r114 = null;
    L20:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Throwable r121 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r121 == null) goto L30;
        ECExceptionMonitor.e(r121);
        return r111;
    L30:
        return r111;
    }

    public static void c(final AnchorV3GuessULikeLiveView r210, j63.c r211, CompositeDisposable r212, RecyclerView.Adapter r213, RecyclerView r214, String r215, Function0 r216, String r217, AnchorV4GuessBaseVH.a r218, int r219, boolean r310) {
        Intrinsics.checkNotNullParameter(r211, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r212, "compositeDisposable");
        Intrinsics.checkNotNullParameter(r213, "adapter");
        Intrinsics.checkNotNullParameter(r214, "recyclerView");
        Intrinsics.checkNotNullParameter(r217, "packApiLogId");
        Intrinsics.checkNotNullParameter(r218, "logAction");
        r210.f165420c = r211;
        r210.f165422e = r218;
        r210.f165423f = r215;
        r210.f165424g = r217;
        r210.f165425h = 0L;
        r210.f165428k = r219;
        ItemCardProductStruct r100 = r211.d();
        ((RelativeLayout) r210.a(R.id.anchor_v3_recommend_product_container)).setVisibility(0);
        ((LinearLayout) r210.a(R.id.anchor_v3_recommend_bottom_info_container)).setVisibility(8);
        if (r100 != null) goto L5;
    L7:
        GenericDraweeView r101 = (GenericDraweeView) r210.a(R.id.anchor_v3_sv_recommend_product_cover);
        Boolean r110 = null;
        if (r100 == null) goto L10;
        ECUrlModel r102 = r100.getCover();
    L11:
        com.bytedance.android.ec.core.utils.y.c(r101, r102, r210.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_live_product_size), r210.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_live_product_size), null);
        Disposable r103 = r210.f165419b;
        if (r103 == null) goto L14;
        r212.remove(r103);
    L14:
        ArrayList r111 = new ArrayList();
        if (r100 == null) goto L21;
        PromotionMarketFloor r104 = r100.getPlatformTextActivity();
        if (r104 == null) goto L21;
        ECUrlModel r105 = r104.getIcon();
        if (r105 == null) goto L21;
        r111.add(r105);
    L21:
        if (r100 == null) goto L25;
        ECUrlModel r106 = r100.getProductIcon();
        if (r106 == null) goto L25;
        r111.add(r106);
    L25:
        p1 r112 = p1.f45668d;
        if (r100 == null) goto L28;
        String r113 = r100.getTitle();
    L29:
        Disposable r107 = p1.b(r112, r111, r113, 4.0f, 16.0f, (TextView) r210.a(R.id.anchor_v3_tv_recommend_product_title));
        if (r107 == null) goto L33;
        r210.f165419b = r107;
        r212.add(r107);
    L33:
        if (r100 == null) goto L50;
        PromotionProductPrice r108 = r100.getPrice();
        if (r108 == null) goto L50;
        ProductDiscountPrice r109 = r108.getDiscountPrice();
        if (r109 == null) goto L39;
        Long r114 = Long.valueOf(r109.getPrice());
    L40:
        Long r115 = r108.getMinPrice();
        if (r115 == null) goto L50;
        long r116 = r115.longValue();
        if (r114 != null) goto L45;
    L49:
        ((PriceView) r210.a(R.id.anchor_v3_tv_product_price)).setPriceText(com.bytedance.android.shopping.utils.g.d(r116));
        goto L50
    L45:
        if (r114.longValue() >= r116) goto L49;
        if (r114.longValue() <= 0) goto L49;
        PriceView r117 = (PriceView) r210.a(R.id.anchor_v3_tv_product_price);
        int r118 = com.bytedance.android.shopping.utils.g.f187081a;
        r117.setPriceText(com.bytedance.android.shopping.utils.g.d(r114.longValue()));
        goto L50
    L39:
        r114 = null;
    L50:
        ((PriceView) r210.a(R.id.anchor_v3_tv_product_price)).post(new e(r210));
        ((ImageView) r210.a(R.id.anchor_v3_sv_recommend_live_more_btn)).setOnClickListener(new f(r210));
        ItemCardLiveStruct r119 = r211.b();
        ((FrameLayout) r210.a(R.id.anchor_v3_recommend_live_rootview)).post(new d(r210, r119));
        ((LinearLayout) r210.a(R.id.anchor_v3_live_author_container)).setVisibility(0);
        GenericDraweeView r120 = (GenericDraweeView) r210.a(R.id.anchor_v3_sv_live_avatar);
        if (r119 == null) goto L53;
        ECUrlModel r121 = r119.getAvatar();
    L54:
        com.bytedance.android.ec.core.utils.y.c(r120, r121, r210.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_live_avatar_size), r210.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_live_avatar_size), null);
        TextView r122 = (TextView) r210.a(R.id.anchor_v3_tv_live_author_name);
        if (r119 == null) goto L57;
        String r123 = r119.getNickName();
    L58:
        r122.setText(r123);
        if (r119 == null) goto L65;
        List<String> r124 = r119.getRelationTags();
        if (r124 == null) goto L65;
        String r125 = (String) CollectionsKt.firstOrNull(r124);
        if (r125 == null) goto L65;
        ((TextView) r210.a(R.id.anchor_v3_tv_author_relationship)).setVisibility(0);
        ((TextView) r210.a(R.id.anchor_v3_tv_author_relationship)).setText(r125);
    L66:
        TextView r126 = (TextView) r210.a(R.id.anchor_v3_tv_recommend_live_audience_count);
        if (r119 == null) goto L69;
        String r127 = r119.getLiveDescription();
    L70:
        r126.setText(r127);
        if (r119 == null) goto L81;
        ECUrlModel r128 = r119.getLiveIcon();
        if (r128 == null) goto L81;
        ((SimpleDraweeView) r210.a(R.id.anchor_v3_recommend_live_desc_icon)).setVisibility(0);
        ViewGroup.LayoutParams r129 = ((SimpleDraweeView) r210.a(R.id.anchor_v3_recommend_live_desc_icon)).getLayoutParams();
        if ((r129 instanceof LinearLayout.LayoutParams) == true) goto L77;
        r129 = null;
    L77:
        LinearLayout.LayoutParams r130 = (LinearLayout.LayoutParams) r129;
        if (r130 == null) goto L80;
        r130.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128.getWidth()));
        r130.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128.getHeight()));
        ((SimpleDraweeView) r210.a(R.id.anchor_v3_recommend_live_desc_icon)).setLayoutParams(r130);
    L80:
        com.bytedance.android.ec.core.utils.y.c((GenericDraweeView) r210.a(R.id.anchor_v3_recommend_live_desc_icon), r128, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128.getWidth())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128.getHeight())), null);
    L82:
        ((LottieAnimationView) r210.a(R.id.anchor_v3_recommend_live_lottie_anim_view)).setAnimation("ec_commerce_recommend_live_anim.json");
        ((LottieAnimationView) r210.a(R.id.anchor_v3_recommend_live_lottie_anim_view)).playAnimation();
        ((AnchorV3GuessULikeFeedbackView) r210.a(R.id.anchor_v3_recommend_feedback_view)).R5(r211, new AnchorV3GuessULikeLiveView$fill$1(r210), r214, r213, false, r218, r216);
        AdInfoStruct r131 = r211.a();
        View r132 = r210.findViewById(R.id.tv_ad_tag);
        if (r131 == null) goto L86;
        r110 = r131.getShowAdTag();
    L86:
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == false) goto L88;
        r132.setVisibility(0);
        int r133 = 8;
    L89:
        if (r310 == false) goto L92;
        ((RoundedLinearLayout) r210.a(R.id.anchor_v3_recommend_live_container)).setRadius(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r133)));
        return;
    L92:
        return;
    L88:
        r133 = 8;
        r132.setVisibility(8);
    L81:
        ((SimpleDraweeView) r210.a(R.id.anchor_v3_recommend_live_desc_icon)).setVisibility(8);
        goto L82
    L69:
        r127 = null;
    L65:
        ((TextView) r210.a(R.id.anchor_v3_tv_author_relationship)).setVisibility(8);
        goto L66
    L57:
        r123 = null;
        goto L58
    L53:
        r121 = null;
        goto L54
    L28:
        r113 = null;
        goto L29
    L10:
        r102 = null;
        goto L11
    L5:
        if (r100.getCover() == null) goto L7;
        ImageExtensionsKt.D((GenericDraweeView) r210.a(R.id.anchor_v3_sv_recommend_product_cover), new com.bytedance.android.ec.core.imagex.r("ec_detail", "ec_recommend_product_image"));
        goto L7
    }
}
