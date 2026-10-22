package com.bytedance.android.shopping.feed.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.ec.model.response.anchorv3.InnerFlowCouponExtra;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.e2;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.repository.api.AnchorV3Api;
import com.bytedance.android.shopping.feed.repository.dto.SearchSuggestWordResponse;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InnerFeedPageHeadWidget;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerFeedPageHeadWidget extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f175566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f175567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f175568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f175569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECLottieAnimationView f175570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f175571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f175572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f175573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f175574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f175575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f175576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f175577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f175578m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SearchSuggestWordResponse f175579n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ProductFeedViewModel f175580o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final FrameLayout f175581p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ViewGroup f175582q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public n83.j f175583r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f175584s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f175585t;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InnerFeedPageHeadWidget f175586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hl.g f175587b;

        public b(InnerFeedPageHeadWidget r100, hl.g r101) {
            this.f175586a = r100;
            this.f175587b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = ld3.c.f508687a;     // Catch: Throwable -> L15
            InnerFeedPageHeadWidget.a(this.f175586a);     // Catch: Exception -> L5 Throwable -> L15
        L7:
            TextView r101 = this.f175586a.f175572g;     // Catch: Throwable -> L15
            if (r101 == null) goto L18;
            int r102 = this.f175587b.f485639a;     // Catch: Throwable -> L15
            if (r102 <= 99) goto L12;
            String r103 = "99+";
        L13:
            r101.setText(r103);     // Catch: Throwable -> L15
            return;
        L12:
            r103 = String.valueOf(r102);     // Catch: Throwable -> L15
            goto L13
        L18:
            return;
        L5:
            e = move-exception;
            ECExceptionMonitor.e(e);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InnerFeedPageHeadWidget f175588a;

        public c(InnerFeedPageHeadWidget r100) {
            this.f175588a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f175588a.f175585t;     // Catch: Throwable -> L12
            if (r100 == null) goto L5;
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L12
        L6:
            if (r101 == null) goto L8;
            r101.height = com.bytedance.android.shopping.extensions.b.b(70);     // Catch: Throwable -> L12
        L8:
            View r102 = this.f175588a.f175585t;     // Catch: Throwable -> L12
            if (r102 == null) goto L15;
            r102.setLayoutParams(r101);     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L5:
            r101 = null;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    static {
    }

    public final void d() {
        View r100 = this.f175566a;
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        View r101 = this.f175569d;
        if (r101 == null) goto L8;
        r101.setVisibility(0);
    L8:
        FrameLayout r102 = this.f175581p;
        if (r102 == null) goto L11;
        r102.setVisibility(0);
    L11:
        View r103 = this.f175571f;
        if (r103 == null) goto L14;
        r103.setVisibility(0);
    L14:
        ProductFeedViewModel r104 = this.f175580o;
        String r105 = null;
        if (r104 == null) goto L45;
        InnerFlowPageStyleDTO r106 = r104.getInnerFlowPageStyle();
        if (r106 == null) goto L19;
        PageStyle r107 = r106.getPageStyle();
    L20:
        f(r107, r104);
        if (r107 == null) goto L23;
        Integer r108 = r107.getHeaderMallDisplay();
    L24:
        if (r108 != null) goto L27;
    L31:
        View r109 = this.f175569d;
        if (r109 == null) goto L34;
        r109.setVisibility(8);
    L34:
        if (r107 == null) goto L36;
        Integer r110 = r107.getHeaderCouponDisplay();
    L37:
        if (r110 != null) goto L40;
    L44:
        this.f175567b.setVisibility(8);
        goto L45
    L40:
        if (r110.intValue() != 1) goto L44;
        if (ld3.c.i() == false) goto L44;
        this.f175567b.setVisibility(0);
        goto L45
    L36:
        r110 = null;
        goto L37
    L27:
        if (r108.intValue() != 1) goto L31;
        View r111 = this.f175569d;
        if (r111 == null) goto L34;
        r111.setVisibility(0);
        goto L34
    L23:
        r108 = null;
        goto L24
    L19:
        r107 = null;
    L45:
        ProductFeedViewModel r112 = this.f175580o;
        if (r112 == null) goto L52;
        InnerFlowPageStyleDTO r113 = r112.getInnerFlowPageStyle();
        if (r113 == null) goto L52;
        PageStyle r114 = r113.getPageStyle();
        if (r114 == null) goto L52;
        Integer r115 = r114.getHeaderSearchDisplay();
    L53:
        if (r115 != null) goto L56;
    L58:
        this.f175566a.setVisibility(8);
    L59:
        ProductFeedViewModel r116 = this.f175580o;
        if (r116 == null) goto L62;
        AnchorV3Param r117 = r116.m8290getAnchorV3Param();
    L63:
        AnchorV3Api.f175159a.getClass();
        AnchorV3Api r118 = AnchorV3Api.a.f175160a;
        if (r118 != null) goto L66;
        return;
    L66:
        if (r117 == null) goto L68;
        r105 = r117.getProductId();
    L68:
        Observable<SearchSuggestWordResponse> r119 = r118.getSearchSuggestWords("30070", "video_product_inner", "video_product_inner", "video_product_inner", r105);
        if (r119 == null) goto L77;
        Observable<SearchSuggestWordResponse> r120 = r119.subscribeOn(Schedulers.io());
        if (r120 == null) goto L78;
        Observable<SearchSuggestWordResponse> r121 = r120.observeOn(AndroidSchedulers.mainThread());
        if (r121 == null) goto L79;
        r121.subscribe(new l(this));
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L62:
        r117 = null;
        goto L63
    L56:
        if (r115.intValue() != 1) goto L58;
        this.f175566a.setVisibility(0);
    L52:
        r115 = null;
        goto L53
    }

    public final void e() {
        int r100 = ld3.c.f508687a;
        View r101 = this.f175585t;
        if (r101 == null) goto L5;
        r101.post(new c(this));
    L5:
        ProductFeedViewModel r102 = this.f175580o;
        Integer r103 = null;
        if (r102 == null) goto L12;
        InnerFlowPageStyleDTO r104 = r102.getInnerFlowPageStyle();
        if (r104 == null) goto L12;
        PageStyle r105 = r104.getPageStyle();
        if (r105 == null) goto L12;
        Integer r106 = r105.getHeaderSearchDisplay();
    L13:
        boolean r107 = false;
        if (r106 != null) goto L17;
    L21:
        View r108 = this.f175566a;
        if (r108 == null) goto L24;
        r108.setVisibility(8);
    L24:
        ProductFeedViewModel r109 = this.f175580o;
        if (r109 == null) goto L31;
        InnerFlowPageStyleDTO r110 = r109.getInnerFlowPageStyle();
        if (r110 == null) goto L31;
        PageStyle r111 = r110.getPageStyle();
        if (r111 == null) goto L31;
        Integer r112 = r111.getHeaderCouponDisplay();
    L32:
        if (r112 != null) goto L35;
    L39:
        this.f175567b.setVisibility(8);
    L40:
        View r113 = this.f175569d;
        if (r113 == null) goto L43;
        r113.setVisibility(8);
    L43:
        FrameLayout r114 = this.f175581p;
        if (r114 == null) goto L46;
        r114.setVisibility(8);
    L46:
        View r115 = this.f175571f;
        if (r115 == null) goto L49;
        r115.setVisibility(8);
    L49:
        ProductFeedViewModel r116 = this.f175580o;
        if (r116 == null) goto L56;
        InnerFlowPageStyleDTO r117 = r116.getInnerFlowPageStyle();
        if (r117 == null) goto L54;
        PageStyle r118 = r117.getPageStyle();
    L55:
        f(r118, r116);
        goto L56
    L54:
        r118 = null;
    L56:
        View r119 = this.f175571f;
        if (r119 != null) goto L59;
        return;
    L59:
        if (r119.getVisibility() != 0) goto L61;
        r107 = true;
    L61:
        if (r107 != true) goto L80;
        ProductFeedViewModel r120 = this.f175580o;
        if (r120 == null) goto L69;
        InnerFlowPageStyleDTO r121 = r120.getInnerFlowPageStyle();
        if (r121 == null) goto L69;
        PageStyle r122 = r121.getPageStyle();
        if (r122 == null) goto L69;
        r103 = r122.getHeaderCartDisplay();
    L69:
        if (r103 != null) goto L72;
        return;
    L72:
        if (r103.intValue() == 1) goto L74;
        return;
    L74:
        if (this.f175575j == true) goto L82;
        this.f175575j = true;
        String r123 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c0472.d8100", Boolean.FALSE).withView(this.f175571f).build());
        Context r124 = getContext();
        if (r124 == null) goto L83;
        FeedProductEventTracker.N(FeedProductEventTracker.f174442a, r124, r123, "half_screen", 2);
        return;
    L83:
        return;
    L82:
        return;
    L80:
        return;
    L35:
        if (r112.intValue() != 1) goto L39;
        if (ld3.c.i() == false) goto L39;
        this.f175567b.setVisibility(0);
    L31:
        r112 = null;
        goto L32
    L17:
        if (r106.intValue() != 1) goto L21;
        View r125 = this.f175566a;
        if (r125 == null) goto L24;
        r125.setVisibility(0);
    L12:
        r106 = null;
        goto L13
    }

    public InnerFeedPageHeadWidget(Context r100) {
        this(r100, null);
    }

    public static final void a(InnerFeedPageHeadWidget r100) {
        r100.getClass();
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{1.0f, 1.25f});
        r101.addUpdateListener(new j(r100));
        r101.setDuration(100);
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{1.25f, 1.0f});
        r102.addUpdateListener(new k(r100));
        r102.setDuration(100);
        AnimatorSet r103 = new AnimatorSet();
        r103.playSequentially(new Animator[]{r101, r102});
        r103.start();
    }

    public final void c(hl.g r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.f485639a > 0) goto L8;
        TextView r101 = this.f175572g;
        if (r101 == null) goto L24;
        r101.setVisibility(8);
        return;
    L24:
        return;
    L8:
        TextView r102 = this.f175572g;
        if (r102 == null) goto L12;
        r102.setVisibility(0);
    L12:
        if (r100.f485640b == false) goto L16;
        TextView r103 = this.f175572g;
        if (r103 == null) goto L25;
        r103.postDelayed(new b(this, r100), AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        return;
    L25:
        return;
    L16:
        TextView r104 = this.f175572g;
        if (r104 == null) goto L27;
        int r105 = r100.f485639a;
        if (r105 <= 99) goto L21;
        String r106 = "99+";
    L22:
        r104.setText(r106);
        return;
    L21:
        r106 = String.valueOf(r105);
        goto L22
    }

    public final void g(boolean r100) {
        if (r100 == false) goto L8;
        this.f175573h.setVisibility(0);
        if (ld3.d.e(ld3.d.a()) == false) goto L6;
        int r101 = R.drawable.commerce_inflow_top_cover_deep;
    L7:
        this.f175573h.setBackgroundResource(r101);
        return;
    L6:
        r101 = R.drawable.commerce_inflow_top_cover_light;
        goto L7
    L8:
        this.f175573h.setVisibility(8);
    }

    public InnerFeedPageHeadWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_product_feed_immersive_title_bar, this, true);
        this.f175585t = findViewById(R.id.layout_root);
        View r102 = findViewById(R.id.product_feed_ic_immersive_search);
        this.f175566a = r102;
        View r103 = findViewById(R.id.product_feed_ic_immersive_coupon);
        this.f175567b = r103;
        this.f175568c = findViewById(R.id.right_entrance_container);
        View r104 = findViewById(R.id.product_feed_ic_immersive_mall);
        this.f175569d = r104;
        ECLottieAnimationView r105 = (ECLottieAnimationView) findViewById(R.id.product_feed_ic_immersive_cart);
        r105.setImageAssetsFolder("images");
        int r106 = ld3.c.f508687a;
        r105.setAnimation("shoppingcar_2.json");
        Unit r107 = Unit.INSTANCE;
        this.f175570e = r105;
        View r108 = findViewById(R.id.product_feed_ic_immersive_cart_container);
        this.f175571f = r108;
        this.f175572g = (TextView) findViewById(R.id.product_feed_ic_immersive_add_cart_dot_count);
        com.bytedance.android.ec.core.widget.f.c(r102, null, "bind_product_flow_card", new AnonymousClass2(this), 1);
        if (ld3.c.i() == false) goto L5;
        com.bytedance.android.ec.core.widget.f.c(r103, null, "bind_product_flow_card", new AnonymousClass3(this), 1);
    L5:
        FrameLayout r109 = (FrameLayout) findViewById(R.id.product_feed_ic_immersive_close);
        this.f175581p = r109;
        this.f175582q = (ViewGroup) findViewById(R.id.coupon_urge_container);
        this.f175573h = findViewById(R.id.product_feed_head_cover);
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L15;
        if (r109 == null) goto L9;
        r109.setContentDescription(com.bytedance.android.shopping.extensions.j.c(R.string.ec_accessibility_close_text));
    L9:
        r102.setContentDescription(com.bytedance.android.shopping.extensions.j.c(R.string.ec_accessibility_search_text));
        if (r104 == null) goto L12;
        r104.setContentDescription(com.bytedance.android.shopping.extensions.j.c(R.string.ec_accessibility_mall_text));
    L12:
        if (r108 == null) goto L16;
        r108.setContentDescription(com.bytedance.android.shopping.extensions.j.c(R.string.ec_accessibility_cart_text));
        return;
    L16:
        return;
    }

    public final void b(final ProductFeedViewModel r100, ProductFeedContentFragment.b r101) {
        Intrinsics.checkNotNullParameter(r100, "productViewModel");
        Intrinsics.checkNotNullParameter(r101, "closeListener");
        this.f175580o = r100;
        WeakReference<View> r102 = com.bytedance.android.shopping.feed.utils.i.f175451a;
        com.bytedance.android.shopping.feed.utils.i.f175451a = new WeakReference(this.f175570e);
        FrameLayout r103 = this.f175581p;
        if (r103 == null) goto L5;
        r103.setOnClickListener(r101);
    L5:
        AnchorV3Param r104 = r100.m8290getAnchorV3Param();
        if (r104 != null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == true) goto L13;
        e();
    L14:
        View r106 = this.f175571f;
        if (r106 == null) goto L17;
        com.bytedance.android.ec.core.widget.f.c(r106, null, "bind_product_flow_card", new InnerFeedPageHeadWidget$bind$1(this, r100), 1);
    L17:
        View r107 = this.f175569d;
        if (r107 == null) goto L20;
        com.bytedance.android.ec.core.widget.f.c(r107, null, "bind_product_flow_card", new InnerFeedPageHeadWidget$bind$2(this, r100), 1);
    L20:
        int r108 = ECSdk.f48106a;
        IEShoppingService r109 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r109 == null) goto L57;
        if (r109.shouldShowSaasCouponUrge() == false) goto L57;
        AnchorV3Param r110 = r100.m8290getAnchorV3Param();
        if (r110 == null) goto L31;
        PromotionProductStruct r111 = r110.getCurrentPromotion();
        if (r111 == null) goto L31;
        PromotionProductPrivilegesStruct r112 = r111.getPrivilegeInfo();
        if (r112 == null) goto L31;
        PromotionProductCouponsStruct r113 = r112.getCoupons();
    L32:
        Context r114 = getContext();
        if (r113 == null) goto L37;
        InnerFlowCouponExtra r115 = r113.getInnerFlowCouponExtra();
        if (r115 == null) goto L37;
        CouponUrgeInfo r116 = r115.getCouponUrgeInfo();
    L38:
        if (r116 == null) goto L55;
        this.f175582q.setVisibility(0);
        if (this.f175583r != null) goto L48;
        IEShoppingService r117 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r117 == null) goto L44;
        n83.j r118 = r117.newCouponUrgeView(r114, 2);
    L45:
        this.f175583r = r118;
        if (r118 == null) goto L48;
        this.f175582q.addView(r118.i(), new FrameLayout.LayoutParams(-2, -1));
        goto L48
    L44:
        r118 = null;
    L48:
        n83.j r119 = this.f175583r;
        if (r119 == null) goto L57;
        ProductFeedViewModel r120 = this.f175580o;
        if (r120 == null) goto L53;
        AnchorV3Param r121 = r120.m8290getAnchorV3Param();
    L54:
        r119.a(r113, r121);
        goto L57
    L53:
        r121 = null;
        goto L54
    L55:
        this.f175582q.setVisibility(8);
    L37:
        r116 = null;
    L31:
        r113 = null;
    L57:
        if (this.f175577l == true) goto L66;
        String r122 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c0472.d0205", Boolean.FALSE).withView(this.f175566a).build());
        e2 r123 = new e2();
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r124 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        r123.appendParam("btm_id", r122, r124);
        r123.appendParam("enter_from", "search_order_center_video_ecom_inflow_half_screen", r124);
        int r125 = com.bytedance.android.shopping.feed.fragment.head.e.f175081a;
        AnchorV3Param r126 = r100.m8290getAnchorV3Param();
        if (r126 == null) goto L64;
        AnchorV3PromotionRequestParam r127 = r126.getRequestParam();
        if (r127 == null) goto L64;
        String r128 = r127.getEnterFrom();
        if (r128 == null) goto L64;
    L65:
        r123.appendParam(ECFindSimilarConfig.ENTER_FROM_SECOND, com.bytedance.android.shopping.feed.fragment.head.e.a(r128), r124);
        r123.appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE);
        r123.post(null, null);
        this.f175577l = true;
    L64:
        r128 = "";
    L66:
        ProductFeedViewModel r129 = this.f175580o;
        if (r129 == null) goto L73;
        InnerFlowPageStyleDTO r130 = r129.getInnerFlowPageStyle();
        if (r130 == null) goto L73;
        PageStyle r131 = r130.getPageStyle();
        if (r131 == null) goto L73;
        Integer r132 = r131.getHeaderCouponDisplay();
    L74:
        if (r132 != null) goto L77;
        return;
    L77:
        if (r132.intValue() != 1) goto L94;
        ProductFeedViewModel r133 = this.f175580o;
        if (r133 == null) goto L83;
        String r134 = r133.getHalfScreenCouponPageSchema();
        if (r134 == null) goto L83;
    L91:
        com.bytedance.android.shopping.feed.event.q r135 = new com.bytedance.android.shopping.feed.event.q();
        r135.appendParam("btm", "a1.b7365c0472.d493768");
        r135.appendParam("url", r134);
        com.bytedance.android.shopping.feed.event.g.c(r135, getContext(), null);
        return;
    L83:
        ProductFeedViewModel r136 = this.f175580o;
        if (r136 == null) goto L90;
        InnerFlowPageStyleDTO r137 = r136.getInnerFlowPageStyle();
        if (r137 == null) goto L90;
        PageStyle r138 = r137.getPageStyle();
        if (r138 == null) goto L90;
        r134 = r138.getHeaderCouponHalfScreenSchema();
    L90:
        r134 = null;
        goto L91
    L94:
        return;
    L73:
        r132 = null;
        goto L74
    L13:
        d();
        goto L14
    L8:
        if (r104.isFullScreen() != true) goto L10;
        r105 = true;
        goto L11
    }

    public final void f(PageStyle r100, ProductFeedViewModel r101) {
        if (r100 == null) goto L4;
        Integer r102 = r100.getHeaderCartDisplay();
    L6:
        if (r102 != null) goto L9;
    L48:
        View r103 = this.f175571f;
        if (r103 == null) goto L56;
        r103.setVisibility(8);
        return;
    L56:
        return;
    L9:
        if (r102.intValue() != 1) goto L48;
        Integer r104 = r100.getHeaderSearchDisplay();
        if (r104 != null) goto L14;
    L25:
        View r105 = this.f175571f;
        if (r105 == null) goto L28;
        r105.setVisibility(0);
    L28:
        PromotionProductStruct r106 = r101.getPromotion();
        if (r106 == null) goto L33;
        PromotionProductExtraStruct r107 = r106.getExtraInfo();
        if (r107 == null) goto L33;
        int r108 = r107.getCartNum();
    L34:
        if (r108 <= 0) goto L45;
        TextView r109 = this.f175572g;
        if (r109 == null) goto L38;
        r109.setVisibility(0);
    L38:
        TextView r110 = this.f175572g;
        if (r110 != null) goto L41;
        return;
    L41:
        if (r108 <= 99) goto L43;
        String r111 = "99+";
    L44:
        r110.setText(r111);
        return;
    L43:
        r111 = String.valueOf(r108);
        goto L44
    L45:
        TextView r112 = this.f175572g;
        if (r112 == null) goto L54;
        r112.setVisibility(8);
        return;
    L54:
        return;
    L33:
        r108 = 0;
        goto L34
    L14:
        if (r104.intValue() != 3) goto L25;
        Integer r113 = r100.getHeaderSearchDisplay();
        if (r113 == null) goto L48;
        if (r113.intValue() != 3) goto L48;
        Integer r114 = r100.getHeaderMallDisplay();
        if (r114 == null) goto L48;
        if (r114.intValue() != 0) goto L48;
    L4:
        r102 = null;
        goto L6
    }
}
