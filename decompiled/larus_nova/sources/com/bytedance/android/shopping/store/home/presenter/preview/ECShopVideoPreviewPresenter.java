package com.bytedance.android.shopping.store.home.presenter.preview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.view.ECHeaderSlideIndicator;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.shopping.store.home.ECShopHeaderVideoManager;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.moments.vo.Author;
import com.bytedance.android.shopping.store.moments.vo.Aweme;
import com.bytedance.android.shopping.store.moments.vo.Video;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoInfoVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\nJ\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/preview/ECShopVideoPreviewPresenter;", "Lcom/bytedance/android/shopping/store/home/frame/presenter/a;", "Lcom/bytedance/android/shopping/store/repository/vo/ShopHeaderVideoVO;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/store/home/presenter/preview/q;", "", "onResume", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopVideoPreviewPresenter extends com.bytedance.android.shopping.store.home.frame.presenter.a<ShopHeaderVideoVO> implements View.OnClickListener, LifecycleObserver, q {
    public static final /* synthetic */ int E = 0;
    public final Lazy A;
    public final Lazy B;
    public ShopHeaderVideoVO C;
    public boolean D;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f184327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f184328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f184329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f184330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SimpleDraweeView f184331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f184332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f184333p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f184334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f184335r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f184336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ECHeaderSlideIndicator f184337t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f184338u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f184339v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f184340w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<String> f184341x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, String> f184342y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f184343z;

    public static final class a {
    }

    static {
    }

    public ECShopVideoPreviewPresenter() {
        this(null);
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void j0() {
    }

    public final ECShopVideoPreviewGroupPresenter.b l0() {
        return (ECShopVideoPreviewGroupPresenter.b) this.f184343z.getValue();
    }

    public final ECShopHeaderVideoManager m0() {
        return (ECShopHeaderVideoManager) this.B.getValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (this.f184338u == false) goto L8;
        ECShopHeaderVideoManager r100 = m0();
        if (r100 == null) goto L9;
        r100.e();
        return;
    L9:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ECShopHeaderVideoManager r100 = m0();
        if (r100 == null) goto L8;
        ViewGroup r101 = this.f184330m;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L7:
        r100.g(r101);
    L8:
        e0().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ECShopVideoPreviewGroupPresenter.b r100 = l0();
        if (r100 == null) goto L11;
        Float r101 = r100.f184324b.getCollapseFactor().getValue();
        if (r101 == null) goto L7;
        float r102 = r101.floatValue();
    L9:
        if (Float.valueOf(r102).floatValue() >= 1.0f) goto L11;
        boolean r103 = true;
    L12:
        this.f184339v = false;
        if (this.D == false) goto L21;
        if (this.f184340w == false) goto L21;
        ECShopVideoPreviewGroupPresenter.a r104 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r104 == null) goto L19;
        r104.f184322a.getChangeStateEvent().setValue(new ui3.c(4, ShopStatus.PREVIEW_EXPANDED, 2));
    L19:
        this.f184340w = false;
    L21:
        if (this.f184338u == false) goto L27;
        if (r103 == false) goto L28;
        ECShopHeaderVideoManager r105 = m0();
        if (r105 == null) goto L29;
        r105.h();
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L7:
        r102 = 0.0f;
    L11:
        r103 = false;
        goto L12
    }

    public ECShopVideoPreviewPresenter(Fragment r100) {
        Intrinsics.checkNotNull(r100);
        super(r100);
        this.f184327j = com.bytedance.android.shopping.extensions.b.b(100);
        this.f184341x = new ArrayList();
        this.f184342y = new LinkedHashMap();
        this.f184343z = LazyKt.lazy(new ECShopVideoPreviewPresenter$modelAdapter$2(this));
        this.A = LazyKt.lazy(new ECShopVideoPreviewPresenter$behaviorAdapter$2(this));
        this.B = LazyKt.lazy(new ECShopVideoPreviewPresenter$videoManager$2(this));
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void i0(ShopHeaderVideoVO r110) {
        this.C = r110;
        ShoppingAsyncInflater.a r100 = ShoppingAsyncInflater.f45268e;
        Context r101 = th.a.e(Y().c(), true);
        r100.getClass();
        ShoppingAsyncInflater r102 = ShoppingAsyncInflater.a.a(r101);
        View r103 = a0();
        if (r103 == null) goto L157;
        View r104 = r102.aU(R.layout.ec_shop_layout_header_video, (ViewGroup) r103, false);
        View r105 = a0();
        if (r105 == null) goto L155;
        ((ViewGroup) r105).addView(r104);
        com.bytedance.android.shopping.store.home.frame.presenter.e r106 = this.f183776h;
        ShopContainerType r107 = ShopContainerType.LIVE_PREVIEW_CONTAINER;
        View r108 = r106.c(r107);
        ECUrlModel r109 = null;
        if ((r108 instanceof ViewGroup) == true) goto L9;
        r108 = null;
    L9:
        ViewGroup r111 = (ViewGroup) r108;
        if (r111 == null) goto L13;
        this.f184328k = r111;
        this.f184329l = (ViewGroup) a0().findViewById(R.id.ec_shop_header_video_container_layer);
        this.f184330m = (ViewGroup) a0().findViewById(R.id.fl_video_container);
        this.f184331n = (SimpleDraweeView) a0().findViewById(R.id.iv_video_cover);
        this.f184332o = (ViewGroup) a0().findViewById(R.id.ec_shop_header_video_element_layer);
        this.f184333p = a0().findViewById(R.id.ec_shop_header_video_sound_button);
        this.f184334q = a0().findViewById(R.id.ec_header_video_top_mask);
        this.f184335r = a0().findViewById(R.id.ec_header_video_bottom_Info_area_mask);
        this.f184336s = a0().findViewById(R.id.ec_header_video_bottom_gradual_mask);
        this.f184337t = (ECHeaderSlideIndicator) a0().findViewById(R.id.ec_header_video_slide_indicator);
    L13:
        ECShopVideoPreviewGroupPresenter.b r112 = l0();
        if (r112 == null) goto L16;
        int[] r113 = {(int) j0.G2_OTA_SPACE_RESERVE_BYTES, 0};
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME)));
        r114.gravity = 80;
        r114.bottomMargin = 0;
        Unit r115 = Unit.INSTANCE;
        Drawable r116 = th.a.e(r112.f184323a, true).getDrawable(R.drawable.store_bg_header_live_bottom_mask_gradient_47);
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(47));
        r117.gravity = 80;
        r117.bottomMargin = 0;
        GradientDrawable r118 = new GradientDrawable();
        qc3.a.f(r118, new int[]{0, 1291845632});
        GradientDrawable r119 = new GradientDrawable();
        qc3.a.f(r119, r113);
        r r120 = new r();
        r120.f184357a = r116;
        r120.f184358b = r117;
        r120.f184359c = r118;
        r120.f184360d = r114;
        r120.f184361e = r119;
    L17:
        if (r120 == null) goto L19;
        Drawable r121 = r120.f184361e;
    L20:
        if (r121 == null) goto L25;
        View r122 = this.f184334q;
        if (r122 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("videoTopMask");
    L24:
        qc3.a.e(r122, r121);
    L25:
        if (r120 == null) goto L27;
        Drawable r123 = r120.f184359c;
    L28:
        if (r120 == null) goto L30;
        FrameLayout.LayoutParams r124 = r120.f184360d;
    L32:
        if (r123 == null) goto L37;
        View r125 = this.f184335r;
        if (r125 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
    L36:
        qc3.a.e(r125, r123);
    L37:
        if (r124 == null) goto L42;
        View r126 = this.f184335r;
        if (r126 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
    L41:
        r126.setLayoutParams(r124);
    L42:
        if (r120 == null) goto L44;
        Drawable r127 = r120.f184357a;
    L45:
        if (r120 == null) goto L47;
        FrameLayout.LayoutParams r128 = r120.f184358b;
    L49:
        if (r127 == null) goto L54;
        View r129 = this.f184336s;
        if (r129 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
    L53:
        r129.setBackground(r127);
    L54:
        if (r128 == null) goto L59;
        View r130 = this.f184336s;
        if (r130 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
    L58:
        r130.setLayoutParams(r128);
    L59:
        ViewGroup r131 = this.f184328k;
        if (r131 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L62:
        int r132 = r131.getLayoutParams().width;
        ECShopVideoPreviewGroupPresenter.b r133 = l0();
        if (r133 == null) goto L65;
        int r134 = th.a.e(r133.f184323a, true).getResources().getDimensionPixelSize(R.dimen.ec_shop_header_video_height);
    L66:
        this.f183776h.a(r107, new vi3.c(r132, r134));
        if (l0() == null) goto L72;
        ECHeaderSlideIndicator r135 = this.f184337t;
        if (r135 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L71:
        r135.setVisibility(0);
    L76:
        ECHeaderSlideIndicator r136 = this.f184337t;
        if (r136 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L79:
        r136.setText(R.string.ec_store_header_video_expand_tips_brand);
        ShopHeaderVideoVO r137 = this.C;
        String r138 = "";
        if (r137 == null) goto L100;
        List<ShopHeaderVideoInfoVO> r139 = r137.getFeedData();
        if (r139 == null) goto L100;
        Iterator<T> r140 = r139.iterator();
    L85:
        if (r140.hasNext() == false) goto L100;
        String r141 = ((ShopHeaderVideoInfoVO) r140.next()).getAwemedata();
        if (r141 == null) goto L85;
        int r142 = com.bytedance.android.ec.store.utils.h.f48668a;
        Aweme r143 = (Aweme) GsonProtectorUtils.fromJson(new Gson(), r141, new l().getType());
        String r144 = r143.getAwemeId();
        if (r144 != null) goto L91;
        r144 = "";
    L91:
        boolean r145 = ECServiceManager.f42805a;
        s83.f r146 = ((s83.g) ECServiceManager.c(s83.g.class)).p();
        if (r146 == null) goto L94;
        r146.r(r144);
    L94:
        ((ArrayList) this.f184341x).add(r144);
        Map<String, String> r147 = this.f184342y;
        Author r148 = r143.getAuthor();
        if (r148 == null) goto L98;
        String r149 = r148.getUid();
        if (r149 == null) goto L98;
    L99:
        r147.put(r144, r149);
    L98:
        r149 = "";
    L100:
        ShopHeaderVideoVO r150 = this.C;
        if (r150 == null) goto L141;
        List<ShopHeaderVideoInfoVO> r151 = r150.getFeedData();
        if (r151 == null) goto L141;
        ShopHeaderVideoInfoVO r152 = (ShopHeaderVideoInfoVO) CollectionsKt.first(r151);
        if (r152 == null) goto L141;
        String r153 = r152.getAwemedata();
        if (r153 == null) goto L141;
        int r154 = com.bytedance.android.ec.store.utils.h.f48668a;
        Aweme r155 = (Aweme) GsonProtectorUtils.fromJson(new Gson(), r153, new m().getType());
        ECShopHeaderVideoManager r156 = m0();
        if (r156 == null) goto L111;
        r156.b(this.f184341x);
    L111:
        SimpleDraweeView r157 = this.f184331n;
        if (r157 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
    L114:
        Video r158 = r155.getVideo();
        if (r158 == null) goto L117;
        r109 = r158.getOriginCover();
    L117:
        h0.d(r157, r109, null, null, null, null, null, 120);
        ViewGroup r159 = this.f184332o;
        if (r159 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
    L120:
        r159.setVisibility(0);
        ECShopHeaderVideoManager r160 = m0();
        if (r160 == null) goto L129;
        Context r161 = Y().c();
        ViewGroup r162 = this.f184330m;
        if (r162 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L125:
        SimpleDraweeView r163 = this.f184331n;
        if (r163 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
    L128:
        r160.f(r161, r162, r163);
    L129:
        this.f184338u = true;
        ECShopHeaderVideoManager r164 = m0();
        if (r164 == null) goto L133;
        String r165 = r164.f183544b;
        if (r165 == null) goto L133;
    L134:
        ECShopVideoPreviewGroupPresenter.a r166 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r166 == null) goto L141;
        Pair[] r167 = new Pair[2];
        r167[0] = TuplesKt.to("video_id", r165);
        String r168 = (String) ((LinkedHashMap) this.f184342y).get(r165);
        if (r168 == null) goto L140;
        r138 = r168;
    L140:
        r167[1] = TuplesKt.to("author_id", r138);
        Intrinsics.checkNotNullParameter("store_video_show", "eventName");
        Intrinsics.checkNotNullParameter(r167, "params");
        r166.f184322a.doEventAction("store_video_show", (Pair[]) Arrays.copyOf(r167, 2));
    L133:
        r165 = "";
    L141:
        View r169 = this.f184333p;
        if (r169 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L144:
        r169.setOnClickListener(this);
        ViewGroup r170 = this.f184332o;
        if (r170 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
    L147:
        r170.setOnClickListener(this);
        ECShopHeaderVideoManager r171 = m0();
        if (r171 == null) goto L152;
        jm.a<Boolean> r172 = r171.f183548f;
        if (r172 == null) goto L152;
        r172.a(h0(), new n(this), false);
    L152:
        this.D = true;
        e0().addObserver(this);
        return;
    L72:
        ECHeaderSlideIndicator r173 = this.f184337t;
        if (r173 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L75:
        r173.setVisibility(8);
        goto L76
    L65:
        r134 = 0;
        goto L66
    L47:
        r128 = null;
        goto L49
    L44:
        r127 = null;
        goto L45
    L30:
        r124 = null;
        goto L32
    L27:
        r123 = null;
        goto L28
    L19:
        r121 = null;
        goto L20
    L16:
        r120 = null;
        goto L17
    L155:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L157:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void k0(int r100) {
        if (this.f184340w == false) goto L5;
        return;
    L5:
        this.f184340w = true;
        Context r101 = Y().c();
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L10;
        String r102 = "slide";
    L12:
        if (r100 == 1) goto L14;
        ECShopHeaderVideoManager r103 = m0();
        if (r103 == null) goto L31;
        ViewGroup r104 = this.f184330m;
        if (r104 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L30:
        r103.a(r101, r104, this.f450897e);
    L31:
        ECShopHeaderVideoManager r105 = m0();
        String r106 = "";
        if (r105 == null) goto L35;
        String r107 = r105.f183544b;
        if (r107 == null) goto L35;
    L36:
        String r108 = (String) ((LinkedHashMap) this.f184342y).get(r107);
        if (r108 == null) goto L40;
        r106 = r108;
    L40:
        ECShopVideoPreviewGroupPresenter.a r109 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r109 == null) goto L44;
        Intrinsics.checkNotNullParameter(r107, "videoId");
        Intrinsics.checkNotNullParameter(r106, "authorId");
        Intrinsics.checkNotNullParameter(r102, "clickType");
        r109.f184322a.getVideoManager().f183550h.setValue(Boolean.TRUE);
        r109.f184322a.doEventAction("store_video_click", new Pair[]{TuplesKt.to("video_id", r107), TuplesKt.to("click_type", r102), TuplesKt.to("author_id", r106)});
        return;
    L44:
        return;
    L35:
        r107 = "";
        goto L36
    L14:
        if (this.f184339v == true) goto L31;
        this.f184339v = true;
        ECShopVideoPreviewGroupPresenter.a r110 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r110 == null) goto L19;
        r110.f184322a.getChangeStateEvent().setValue(new ui3.c(5, ShopStatus.HIDE, 2));
    L19:
        ECShopHeaderVideoManager r111 = m0();
        if (r111 == null) goto L31;
        ViewGroup r112 = this.f184330m;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L24:
        r111.a(r101, r112, this.f450897e);
    L10:
        r102 = "click";
        goto L12
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = kn.a.f504133a;
        if (kn.a.a(r100.getId()) == true) goto L37;
        ECShopVideoPreviewGroupPresenter.b r102 = l0();
        if (r102 != null) goto L7;
    L9:
        int r103 = r100.getId();
        if (r103 != R.id.ec_shop_header_video_sound_button) goto L34;
        ECShopHeaderVideoManager r104 = m0();
        if (r104 != null) goto L14;
    L17:
        ECShopHeaderVideoManager r105 = m0();
        String r106 = null;
        if (r105 == null) goto L22;
        jm.a<Boolean> r107 = r105.f183548f;
        if (r107 == null) goto L22;
        Boolean r108 = r107.getValue();
    L23:
        ECShopVideoPreviewGroupPresenter.a r109 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r109 == null) goto L38;
        Pair[] r110 = new Pair[2];
        ECShopHeaderVideoManager r111 = m0();
        if (r111 == null) goto L28;
        r106 = r111.f183544b;
    L28:
        r110[0] = TuplesKt.to("video_id", r106);
        if (Intrinsics.areEqual(r108, Boolean.FALSE) == false) goto L31;
        String r112 = "on";
    L32:
        r110[1] = TuplesKt.to("status_to", r112);
        Intrinsics.checkNotNullParameter("store_video_audio_click", "eventName");
        Intrinsics.checkNotNullParameter(r110, "params");
        r109.f184322a.doEventAction("store_video_audio_click", (Pair[]) Arrays.copyOf(r110, 2));
        return;
    L31:
        r112 = "off";
        goto L32
    L38:
        return;
    L22:
        r108 = null;
        goto L23
    L14:
        if (r104.c() == false) goto L16;
        r104.i();
        goto L17
    L16:
        r104.d();
        goto L17
    L34:
        if (r103 != R.id.ec_shop_header_video_element_layer) goto L40;
        k0(0);
        return;
    L40:
        return;
    L7:
        if ((!r102.f184324b.getStoreParam().isPreview()) == true) goto L9;
        return;
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.preview.q
    public final void O(float r100, int r101, boolean r102, int r103, boolean r104) {
        int r105 = 0;
        if (r100 < 1.0f) goto L5;
        int r106 = 4;
    L6:
        ViewGroup r107 = this.f184328k;
        if (r107 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L10:
        if (r107.getVisibility() == r106) goto L15;
        ViewGroup r108 = this.f184328k;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L14:
        r108.setVisibility(r106);
    L15:
        ViewGroup r109 = this.f184329l;
        if (r109 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
    L19:
        if (r109.getVisibility() == r106) goto L24;
        ViewGroup r110 = this.f184329l;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
    L23:
        r110.setVisibility(r106);
    L24:
        if (r106 != 0) goto L28;
        ECShopHeaderVideoManager r111 = m0();
        if (r111 == null) goto L32;
        r111.h();
    L32:
        if (r100 > 0) goto L51;
        int r112 = r101 * (-1);
        if (r112 >= 0) goto L38;
        return;
    L38:
        if (r112 > this.f184327j) goto L40;
    L43:
        ViewGroup r113 = this.f184328k;
        if (r113 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L46:
        ECShopVideoPreviewGroupPresenter.b r114 = l0();
        if (r114 == null) goto L49;
        r105 = th.a.e(r114.f184323a, true).getResources().getDimensionPixelSize(R.dimen.ec_shop_header_video_height);
    L49:
        wg.a.d(r113, r105 + r112);
        return;
    L40:
        if (this.f184340w == true) goto L43;
        if (r103 != 1) goto L43;
        k0(1);
        goto L43
    L51:
        return;
    L28:
        ECShopHeaderVideoManager r115 = m0();
        if (r115 == null) goto L32;
        r115.e();
        goto L32
    L5:
        r106 = 0;
        goto L6
    }
}
