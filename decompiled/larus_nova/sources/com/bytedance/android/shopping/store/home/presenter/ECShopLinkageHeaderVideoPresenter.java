package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.view.ECHeaderSlideIndicator;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.shopping.store.home.ECShopHeaderVideoManager;
import com.bytedance.android.shopping.store.home.api.StoreUIParam;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopLinkageHeaderVideoPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopLinkageHeaderVideoPresenter extends ECShopBasePresenter implements View.OnClickListener, LifecycleObserver {
    public static final /* synthetic */ int K = 0;
    public View A;
    public View B;
    public View C;
    public View D;
    public ECHeaderSlideIndicator E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final List<String> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Map<String, String> f183965J;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Pair<Integer, Integer> f183966u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup f183967v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewGroup f183968w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewGroup f183969x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public SimpleDraweeView f183970y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewGroup f183971z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLinkageHeaderVideoPresenter f183972a;

        public b(ECShopLinkageHeaderVideoPresenter r100) {
            this.f183972a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ShopHeaderVideoVO r101 = (ShopHeaderVideoVO) r100;
            StoreUIParam r102 = this.f183972a.T().getStoreParam().getStoreUIParam();
            if (this.f183972a.I() == true) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r102.setHasHeaderVideo(r103);
            ShoppingAsyncInflater.a r104 = ShoppingAsyncInflater.f45268e;
            Context r105 = th.a.e(this.f183972a.u().c(), true);
            r104.getClass();
            ShoppingAsyncInflater r106 = ShoppingAsyncInflater.a.a(r105);
            View r107 = this.f183972a.y();
            if (r107 == null) goto L90;
            View r108 = r106.aU(R.layout.ec_shop_layout_header_video, (ViewGroup) r107, false);
            View r109 = this.f183972a.y();
            if (r109 == null) goto L88;
            ((ViewGroup) r109).addView(r108);
            ECShopLinkageHeaderVideoPresenter r110 = this.f183972a;
            View r111 = r110.o0();
            CoordinatorLayout r112 = (CoordinatorLayout) r111.findViewById(R.id.ec_store_coordinator_layout);
            ViewGroup r113 = (ViewGroup) r111.findViewById(R.id.ec_store_live_container_lowest);
            r110.f183967v = r113;
            if (r113 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        L15:
            ViewGroup r114 = (ViewGroup) r113.findViewById(R.id.ec_shop_header_video_container_layer);
            r110.f183968w = r114;
            if (r114 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
        L18:
            r110.f183969x = (ViewGroup) r114.findViewById(R.id.fl_video_container);
            ViewGroup r115 = r110.f183968w;
            if (r115 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
        L21:
            r110.f183970y = (SimpleDraweeView) r115.findViewById(R.id.iv_video_cover);
            ViewGroup r116 = r110.f183968w;
            if (r116 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
        L24:
            ViewGroup r117 = (ViewGroup) r116.findViewById(R.id.ec_shop_header_video_element_layer);
            r110.f183971z = r117;
            if (r117 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L27:
            r110.A = r117.findViewById(R.id.ec_shop_header_video_sound_button);
            ViewGroup r118 = r110.f183971z;
            if (r118 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L30:
            r110.B = r118.findViewById(R.id.ec_header_video_top_mask);
            ViewGroup r119 = r110.f183971z;
            if (r119 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L33:
            r110.C = r119.findViewById(R.id.ec_header_video_bottom_Info_area_mask);
            ViewGroup r120 = r110.f183971z;
            if (r120 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L36:
            r110.D = r120.findViewById(R.id.ec_header_video_bottom_gradual_mask);
            ViewGroup r121 = r110.f183971z;
            if (r121 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L39:
            r110.E = (ECHeaderSlideIndicator) r121.findViewById(R.id.ec_header_video_slide_indicator);
            ECShopLinkageHeaderVideoPresenter r122 = this.f183972a;
            if (r122.f183966u != null) goto L42;
            r122.f183966u = new Pair(0, Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(100)));
        L42:
            Pair<Integer, Integer> r123 = r122.f183966u;
            Intrinsics.checkNotNull(r123);
            int r124 = r123.getFirst().intValue();
            ViewGroup r125 = r122.f183967v;
            if (r125 != null) goto L45;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        L45:
            ViewGroup.LayoutParams r126 = r125.getLayoutParams();
            if (r126 == null) goto L48;
            r126.height = r124;
        L48:
            r125.requestLayout();
            int[] r127 = {(int) com.larus.dora.impl.ota.g2.j0.G2_OTA_SPACE_RESERVE_BYTES, 0};
            View r128 = r122.B;
            if (r128 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("videoTopMask");
        L51:
            GradientDrawable r129 = new GradientDrawable();
            qc3.a.f(r129, r127);
            Unit r130 = Unit.INSTANCE;
            qc3.a.e(r128, r129);
            View r131 = r122.B;
            if (r131 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("videoTopMask");
        L54:
            r131.requestLayout();
            int[] r132 = {0, 1291845632};
            View r133 = r122.C;
            if (r133 != null) goto L57;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
        L57:
            GradientDrawable r134 = new GradientDrawable();
            qc3.a.f(r134, r132);
            qc3.a.e(r133, r134);
            View r135 = r122.C;
            if (r135 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
        L60:
            r135.requestLayout();
            View r136 = r122.D;
            if (r136 != null) goto L63;
            Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
        L63:
            ViewGroup.LayoutParams r137 = r136.getLayoutParams();
            if (r137 == null) goto L66;
            r137.height = com.bytedance.android.shopping.extensions.b.b(47);
            ((ViewGroup.MarginLayoutParams) r137).bottomMargin = 0;
        L66:
            View r138 = r122.D;
            if (r138 != null) goto L69;
            Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
        L69:
            r138.setBackground(th.a.e(r122.u().c(), true).getDrawable(R.drawable.store_bg_header_live_bottom_mask_gradient_47));
            View r139 = r122.D;
            if (r139 != null) goto L72;
            Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
        L72:
            r139.requestLayout();
            ECHeaderSlideIndicator r140 = r122.E;
            if (r140 != null) goto L75;
            Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
        L75:
            ViewGroup.LayoutParams r141 = r140.getLayoutParams();
            if (r141 == null) goto L86;
            ((ViewGroup.MarginLayoutParams) r141).bottomMargin = com.bytedance.android.shopping.extensions.b.b(120);
            r140.setText(R.string.ec_store_header_video_expand_tips_brand);
            r122.T().getCollapseFactor().a(r122.W(), new r0(r122), false);
            r122.T().getVideoInfo().a(ECQuickUtilKt.a(r122.u()), new u0(r122), false);
            View r142 = r122.A;
            if (r142 != null) goto L80;
            Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
        L80:
            r142.setOnClickListener(r122);
            ViewGroup r143 = r122.f183971z;
            if (r143 != null) goto L83;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L83:
            r143.setOnClickListener(r122);
            r122.T().getVideoManager().f183548f.a(r122.W(), new v0(r122), false);
            this.f183972a.k0().addObserver(this.f183972a);
            this.f183972a.T().getCollapseFactor().a(this.f183972a.W(), new w0(this), false);
            return;
        L86:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        L88:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L90:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L5:
            if (this.f183972a.U() == true) goto L7;
            r103 = true;
            goto L8
        }
    }

    static {
    }

    public ECShopLinkageHeaderVideoPresenter() {
        super(null);
        this.I = new ArrayList();
        this.f183965J = new LinkedHashMap();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (this.F == false) goto L6;
        T().getVideoManager().e();
        return;
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter
    public final View o0() {
        View r100 = y();
    L4:
        if ((r100.getParent() instanceof ViewGroup) == false) goto L22;
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L21;
        if (((ViewGroup) r101).getId() == R.id.ec_store_root_container) goto L9;
        Object r102 = r100.getParent();
        if (r102 == null) goto L19;
        r100 = (View) r102;
        goto L4
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L9:
        Object r103 = r100.getParent();
        if (r103 == null) goto L14;
        return (View) r103;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L22:
        int r104 = ye.a.f567357a;
        ye.a.a(Log.getStackTraceString(new Throwable()));
        return super.o0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ECShopHeaderVideoManager r100 = T().getVideoManager();
        ViewGroup r101 = this.f183969x;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L5:
        r100.g(r101);
        k0().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Float r100 = T().getCollapseFactor().getValue();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        this.G = false;
        if (I() == false) goto L14;
        if (this.H == false) goto L14;
        T().getChangeStateEvent().setValue(new ui3.c(4, null, 6));
    L14:
        if (this.F == false) goto L18;
        if (r101 == false) goto L19;
        T().getVideoManager().h();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r100.floatValue() >= 1.0f) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        T().getVideoInfo().a(W(), new b(this), false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = kn.a.f504133a;
        if (kn.a.a(r100.getId()) == false) goto L5;
        return;
    L5:
        if (T().getStoreParam().isPreview() == true) goto L25;
        int r102 = r100.getId();
        if (r102 != R.id.ec_shop_header_video_sound_button) goto L19;
        ECShopHeaderVideoManager r103 = T().getVideoManager();
        if (r103.c() == false) goto L12;
        r103.i();
    L13:
        Boolean r104 = T().getVideoManager().f183548f.getValue();
        ECStoreViewModel r105 = T();
        Pair<String, String>[] r106 = new Pair[2];
        r106[0] = TuplesKt.to("video_id", T().getVideoManager().f183544b);
        if (Intrinsics.areEqual(r104, Boolean.FALSE) == false) goto L16;
        String r107 = "on";
    L17:
        r106[1] = TuplesKt.to("status_to", r107);
        r105.doEventAction("store_video_audio_click", r106);
        return;
    L16:
        r107 = "off";
        goto L17
    L12:
        r103.d();
        goto L13
    L19:
        if (r102 != R.id.ec_shop_header_video_element_layer) goto L24;
        q0(0);
        return;
    L24:
        return;
    }

    public final void q0(int r100) {
        Boolean r101 = T().getVideoManager().f183550h.getValue();
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L5;
        return;
    L5:
        this.H = true;
        Context r103 = u().c();
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L10;
        String r104 = "slide";
    L11:
        T().getVideoManager().f183550h.setValue(r102);
        if (r100 == 1) goto L14;
        ECShopHeaderVideoManager r105 = T().getVideoManager();
        ViewGroup r106 = this.f183969x;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L23:
        r105.a(r103, r106, this.f183834h);
    L24:
        ECStoreViewModel r107 = T();
        Pair<String, String>[] r108 = new Pair[3];
        r108[0] = TuplesKt.to("video_id", T().getVideoManager().f183544b);
        r108[1] = TuplesKt.to("click_type", r104);
        Map<String, String> r109 = this.f183965J;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        String r111 = (String) r110.get(T().getVideoManager().f183544b);
        if (r111 != null) goto L27;
        r111 = "";
    L27:
        r108[2] = TuplesKt.to("author_id", r111);
        r107.doEventAction("store_video_click", r108);
        return;
    L14:
        if (this.G == true) goto L24;
        this.G = true;
        T().getChangeStateEvent().setValue(new ui3.c(5, null, 6));
        ECShopHeaderVideoManager r112 = T().getVideoManager();
        ViewGroup r113 = this.f183969x;
        if (r113 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L19:
        r112.a(r103, r113, this.f183834h);
    L10:
        r104 = "click";
        goto L11
    }
}
