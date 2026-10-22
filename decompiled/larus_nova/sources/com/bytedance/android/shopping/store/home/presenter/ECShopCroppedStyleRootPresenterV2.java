package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopCroppedStyleRootPresenterV2;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopCroppedStyleRootPresenterV2 extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int H = 0;
    public ViewGroup A;
    public View B;
    public boolean C;
    public ImmersionBar D;
    public Boolean E;
    public ECStoreAwemeFeedVideoZoomController F;
    public View G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s83.d f183907u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Float f183908v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CoordinatorLayout f183909w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f183910x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewGroup f183911y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f183912z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f183913a = null;

        static {
            f183913a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 f183914a;

        public c(ECShopCroppedStyleRootPresenterV2 r100) {
            this.f183914a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.android.shopping.store.home.entity.n r101 = (com.bytedance.android.shopping.store.home.entity.n) r100;
            ECShopCroppedStyleRootPresenterV2 r102 = this.f183914a;
            r102.getClass();
            int r103 = com.bytedance.android.shopping.store.home.p.f183795a;
            if (r102.U() == false) goto L6;
            ((Number) r102.f183904q.getValue()).intValue();
            r102.h0();
            r102.f0();
        L16:
            ECShopCroppedStyleRootPresenterV2 r104 = this.f183914a;
            r104.getClass();
            com.bytedance.android.shopping.store.home.entity.p r105 = r101.f183754h;
            if (r105 == null) goto L25;
            Double r106 = r105.b();
            if (r106 == null) goto L26;
            int r107 = Color.argb((int) (255 * r106.doubleValue()), 0, 0, 0);
            View r108 = r104.G;
            if (r108 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        L23:
            r108.setBackgroundColor(r107);
            return;
        L26:
            return;
        L25:
            return;
        L6:
            if (r102.E() == false) goto L9;
            ((Number) r102.f183902o.getValue()).intValue();
            r102.f0();
            goto L16
        L9:
            if (r102.I() == true) goto L11;
        L13:
            boolean r109 = false;
        L14:
            if (r109 == false) goto L16;
            ((Number) r102.f183903p.getValue()).intValue();
            r102.f0();
            goto L16
        L11:
            if (r102.U() == true) goto L13;
            r109 = true;
            goto L14
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 f183915a;

        public d(ECShopCroppedStyleRootPresenterV2 r100) {
            this.f183915a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f183915a.Q();
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 f183916a;

        public e(ECShopCroppedStyleRootPresenterV2 r100) {
            this.f183916a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            ECShopCroppedStyleRootPresenterV2 r102 = this.f183916a;
            if (r102.C == false) goto L5;
        L7:
            this.f183916a.r0();
            this.f183916a.s0(false);
            this.f183916a.V();
            if (r101 != null) goto L11;
        L13:
            boolean r103 = false;
        L14:
            CoordinatorLayout r104 = this.f183916a.f183909w;
            if (r104 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        L17:
            ViewGroup.LayoutParams r105 = r104.getLayoutParams();
            if (r105 != null) goto L20;
        L33:
            r104.requestLayout();
            View r106 = this.f183916a.f183910x;
            if (r106 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("rootTabBarContainer");
        L36:
            r106.setAlpha(this.f183916a.b0());
            ECShopCroppedStyleRootPresenterV2 r107 = this.f183916a;
            boolean r108 = r107.V();
            ViewGroup r109 = r107.A;
            if (r109 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("tipsContainer");
        L39:
            Iterator<T> r110 = com.bytedance.commerce.base.view.b.a(r109).iterator();
        L41:
            if (r110.hasNext() == false) goto L49;
            View r111 = (View) r110.next();
            if ((r111 instanceof com.bytedance.android.shopping.store.home.view.p) == false) goto L41;
            com.bytedance.android.shopping.store.home.view.p r112 = (com.bytedance.android.shopping.store.home.view.p) r111;
            if (r108 == false) goto L47;
            int r113 = 0;
        L48:
            r112.setVisibility(r113);
            goto L41
        L47:
            r113 = 4;
            goto L48
        L49:
            return;
        L20:
            if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L23;
            r105 = null;
        L23:
            if (r105 == null) goto L33;
            ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r105;
            if (r103 == true) goto L27;
        L31:
            int r115 = 0;
        L32:
            r114.bottomMargin = r115;
            goto L33
        L27:
            if ((!Intrinsics.areEqual(this.f183916a.T().isBrandShop().getValue(), Boolean.TRUE)) == false) goto L31;
            if (this.f183916a.T().isMiddleTabFramework() == true) goto L31;
            r115 = this.f183916a.e0();
            goto L32
        L11:
            if (r101.intValue() != 2) goto L13;
            r103 = true;
            goto L14
        L5:
            if (r102.V() == false) goto L7;
            this.f183916a.T().reportEnterCroppedStyleStoreOnFullScreenState();
            this.f183916a.C = true;
            goto L7
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 f183917a;

        public f(ECShopCroppedStyleRootPresenterV2 r100) {
            this.f183917a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            Boolean r100 = (Boolean) r110;
            ECShopCroppedStyleRootPresenterV2 r101 = this.f183917a;
            int r102 = ECShopCroppedStyleRootPresenterV2.H;
            r101.q0();
            ECShopCroppedStyleRootPresenterV2 r103 = this.f183917a;
            boolean r104 = r103.T().getStoreParam().getStoreUIParam().getLiveDefaultMute();
            im.b r105 = r103.T().getLiveManager();
            boolean r106 = r103.U();
            StoreV3LiveRoomVO r107 = r103.T().getLiveInfo().getValue();
            Context r108 = r103.u().c();
            DialogFragment r111 = r103.S();
            View r109 = r103.o0();
            if ((r109 instanceof FrameLayout) == true) goto L5;
            r109 = null;
        L5:
            im.b.c(r105, null, r106, r107, r104, new im.o(r108, r111, (FrameLayout) r109, r103.T().getLiveInfo().getValue(), r103.T().getPassThroughLogData(), r103.T().getStoreParam().getSearchParams(), ((Number) r103.T().getStoreSizeConfig().f183656m.getValue()).intValue(), r103.T().getStoreParam().getShopId()), false, r103.T().getStoreParam().getStoreUIParam().getCanShowFloatLive(), 160);
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 f183918a;

        public g(ECShopCroppedStyleRootPresenterV2 r100) {
            this.f183918a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            ECShopCroppedStyleRootPresenterV2 r102 = this.f183918a;
            int r103 = ECShopCroppedStyleRootPresenterV2.H;
            r102.q0();
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 f183919a;

        public h(ECShopCroppedStyleRootPresenterV2 r100) {
            this.f183919a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            ECShopCroppedStyleRootPresenterV2 r102 = this.f183919a;
            int r103 = ECShopCroppedStyleRootPresenterV2.H;
            float r104 = r102.Z();
            r102.q0();
            boolean r105 = true;
            if ((!Intrinsics.areEqual(r104, r102.f183908v)) == true) goto L5;
        L8:
            View r106 = r102.f183910x;
            if (r106 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("rootTabBarContainer");
        L11:
            r106.setAlpha(r102.b0());
            r102.f183908v = Float.valueOf(r104);
            if (r101.floatValue() <= 0.0f) goto L16;
            if (r101.floatValue() >= 1.0f) goto L16;
            return;
        L16:
            if (r101.floatValue() > 0) goto L18;
            int r107 = 1;
        L19:
            jm.a<Integer> r108 = this.f183919a.T().getCroppedState();
            Integer r109 = r108.getValue();
            if (r109 != null) goto L23;
        L26:
            if (r105 == true) goto L29;
            r108 = null;
        L29:
            if (r108 == null) goto L33;
            r108.setValue(Integer.valueOf(r107));
            return;
        L33:
            return;
        L23:
            if (r109.intValue() != r107) goto L26;
            r105 = false;
            goto L26
        L18:
            r107 = 2;
            goto L19
        L5:
            if (r104 <= 0.75f) goto L7;
            im.b.i(r102.T().getLiveManager(), false, false, 3);
            goto L8
        L7:
            im.b r110 = r102.T().getLiveManager();
            int r111 = im.b.f490366q;
            r110.a(false);
            goto L8
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Boolean r100 = this.E;
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == true) goto L5;
    L24:
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L28;
        r103.cancelMuteLiveRoom();
        return;
    L28:
        return;
    L5:
        if (Intrinsics.areEqual(T().getFlagJumpToFeedVideoPage().getValue(), r101) == false) goto L9;
        s83.d r104 = this.f183907u;
        if (r104 == null) goto L12;
        r104.f();
    L12:
        s83.d r105 = this.f183907u;
        if (r105 == null) goto L15;
        Boolean r106 = Boolean.valueOf(r105.isPlaying());
    L17:
        if (com.bytedance.android.shopping.extensions.k.i(r106) == true) goto L21;
        s83.d r107 = this.f183907u;
        if (r107 == null) goto L21;
        r107.c();
    L21:
        s83.d r108 = this.f183907u;
        if (r108 == null) goto L24;
        r108.h();
        goto L24
    L15:
        r106 = null;
        goto L17
    L9:
        s83.d r109 = this.f183907u;
        if (r109 == null) goto L12;
        r109.e(false, u().c());
        goto L12
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (Intrinsics.areEqual(this.E, Boolean.FALSE) == false) goto L15;
        Fragment r100 = this.f183834h;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L16;
        s83.d r102 = this.f183907u;
        if (r102 == null) goto L17;
        r102.e(true, u().c());
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (r100.isRemoving() != true) goto L9;
        r101 = true;
        goto L10
    }

    public final void r0() {
        Boolean r100 = this.E;
        if (r100 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == true) goto L8;
        s83.d r101 = this.f183907u;
        if (r101 == null) goto L26;
        r101.g();
        return;
    L26:
        return;
    L8:
        if (V() == false) goto L12;
        s83.d r102 = this.f183907u;
        if (r102 == null) goto L22;
        r102.g();
        return;
    L22:
        return;
    L12:
        s83.d r103 = this.f183907u;
        if (r103 == null) goto L15;
        r103.c();
    L15:
        s83.d r104 = this.f183907u;
        if (r104 == null) goto L24;
        r104.h();
        return;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        im.b r100 = T().getLiveManager();
        int r101 = im.b.f490366q;
        r100.a(false);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        ImmersionBar r103 = this.D;     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r103.destroy();     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        this.D = null;
        return;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Boolean r100 = null;
        if (V() == true) goto L5;
        T().getLiveManager().a(true);
    L24:
        r0();
        s0(true);
        if (this.E != null) goto L31;
        s83.d r101 = this.f183907u;
        if (r101 == null) goto L29;
        r100 = Boolean.valueOf(r101.isPlaying());
    L29:
        this.E = Boolean.valueOf(com.bytedance.android.shopping.extensions.k.i(r100));
        return;
    L31:
        return;
    L5:
        im.b r102 = T().getLiveManager();
        r102.getClass();
        int r103 = ECSdk.f48106a;
        IAdapterService r104 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r104 == null) goto L12;
        wu1.a r105 = r104.getECLiveStateController();
        if (r105 == null) goto L12;
        Scene r106 = Scene.LIVE;
        Pair r107 = r105.c();
        if (r107 == null) goto L12;
        FloatWindowState r108 = (FloatWindowState) r107.getFirst();
    L13:
        if (r108 == null) goto L15;
        int r109 = im.c.f490389b[r108.ordinal()];
        if (r109 == 1) goto L23;
        if (r109 != 2) goto L24;
        r102.a(true);
        goto L24
    L23:
        im.b.i(r102, true, false, 2);
        goto L24
    L15:
        if (r102.d() == false) goto L17;
        r102.h(true, true);
        goto L24
    L17:
        r102.a(true);
    L12:
        r108 = null;
        goto L13
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        if (V() == true) goto L12;
        Fragment r100 = this.f183834h;
        if (r100 == null) goto L9;
        boolean r101 = true;
        if (r100.isRemoving() != true) goto L9;
    L10:
        if (r101 == true) goto L12;
        im.b r102 = T().getLiveManager();
        int r103 = im.b.f490366q;
        r102.f(false);
    L9:
        r101 = false;
    L12:
        boolean r104 = T().getStoreParam().getStatusBarDarkFont();
        Activity r105 = X();
        int r106 = com.bytedance.android.ec.core.utils.y1.f45751a;
        com.bytedance.android.ec.core.utils.y1.c(r105, r105.getWindow(), r104);
    }

    public final void q0() {
        Integer r100 = T().getStoreInfoAreaWithoutTipsHeight().getValue();
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        if (r102 != 0) goto L8;
        return;
    L8:
        float r103 = b0();
        float r104 = a0(0.5f);
        h0();
        if (D() == false) goto L11;
        d0();
    L11:
        m0();
        Integer r105 = T().getLynxProductComponentHeight().getValue();
        if (r105 == null) goto L14;
        r105.intValue();
    L14:
        boolean r106 = i0();
        float r107 = 1 - r103;
        if (this.f183912z == null) goto L17;
        boolean r108 = true;
    L18:
        int r109 = 857085987;
        int r110 = 4;
        if (r108 == true) goto L24;
        View r111 = new View(u().c());
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(32), com.bytedance.android.shopping.extensions.b.b(4));
        r112.gravity = 49;
        r112.topMargin = com.bytedance.android.shopping.extensions.b.b(7);
        Unit r113 = Unit.INSTANCE;
        r111.setLayoutParams(r112);
        GradientDrawable r114 = new GradientDrawable();
        r114.setColor(857085987);
        r114.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(4));
        int r115 = qc3.a.f532459a;
        Intrinsics.checkNotNullParameter(r111, "$this$setBackgroundCompat");
        r111.setBackground(r114);
        ViewGroup r116 = this.f183911y;
        if (r116 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("infoGroupAreaContainer");
    L23:
        r116.addView(r111);
        this.f183912z = r111;
    L24:
        View r117 = this.f183912z;
        if (r117 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L27:
        Drawable r118 = r117.getBackground();
        Unit r119 = null;
        if ((r118 instanceof GradientDrawable) == true) goto L30;
        r118 = null;
    L30:
        GradientDrawable r120 = (GradientDrawable) r118;
        if (r120 == null) goto L35;
        if (r106 == false) goto L34;
        r109 = -1;
    L34:
        r120.setColor(r109);
    L35:
        View r121 = this.f183912z;
        if (r121 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L38:
        r121.setAlpha(r107);
        if (this.B == null) goto L41;
        boolean r122 = true;
    L42:
        if (r122 == true) goto L50;
        ShoppingAsyncInflater.a r123 = ShoppingAsyncInflater.f45268e;
        Context r124 = u().c();
        r123.getClass();
        ShoppingAsyncInflater r125 = ShoppingAsyncInflater.a.a(r124);
        ViewGroup r126 = this.A;
        if (r126 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("tipsContainer");
    L46:
        View r127 = r125.aU(R.layout.ec_store_layout_cropped_style_slide_tips, r126, false);
        GradientDrawable r128 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, (int) 2768240640L});
        r128.setGradientType(0);
        Unit r129 = Unit.INSTANCE;
        qc3.a.e(r127, r128);
        r127.setOnClickListener(b.f183913a);
        ViewGroup r130 = this.A;
        if (r130 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("tipsContainer");
    L49:
        r130.addView(r127);
        this.B = r127;
    L50:
        View r131 = this.B;
        if (r131 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("slideTips");
    L53:
        r131.setAlpha(r107);
        View r132 = this.B;
        if (r132 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("slideTips");
    L57:
        if (r103 >= 1.0f) goto L60;
        r110 = 0;
    L60:
        r132.setVisibility(r110);
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L79
        if (T().getStoreParam().getStatusBarDarkFont() == false) goto L68;
        ImmersionBar r134 = this.D;     // Catch: Throwable -> L79
        if (r134 == null) goto L77;
        ImmersionBar r135 = r134.statusBarDarkFont(!r106);     // Catch: Throwable -> L79
        if (r135 == null) goto L77;
        r135.init();     // Catch: Throwable -> L79
        r119 = Unit.INSTANCE;     // Catch: Throwable -> L79
    L77:
        Result.m9449constructorimpl(r119);     // Catch: Throwable -> L79
        return;
    L68:
        ImmersionBar r136 = this.D;     // Catch: Throwable -> L79
        if (r136 == null) goto L77;
        if (r104 <= 0.0f) goto L74;
        if (r106 == true) goto L74;
        r101 = true;
    L74:
        ImmersionBar r137 = r136.statusBarDarkFont(r101);     // Catch: Throwable -> L79
        if (r137 == null) goto L77;
        r137.init();     // Catch: Throwable -> L79
        r119 = Unit.INSTANCE;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L41:
        r122 = false;
        goto L42
    L17:
        r108 = false;
        goto L18
    L5:
        r102 = 0;
        goto L6
    }

    public ECShopCroppedStyleRootPresenterV2(Fragment r100) {
        super(r100);
        boolean r101 = ECServiceManager.f42805a;
        this.f183907u = ((s83.g) ECServiceManager.c(s83.g.class)).N();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if (U() == true) goto L5;
        return;
    L5:
        Fragment r101 = this.f183834h;
        Object r102 = null;
        if ((r101 instanceof com.bytedance.android.shopping.store.tabkit.f) == false) goto L11;
        if (r101 == null) goto L9;
        r101 = r101.getParentFragment();
        goto L11
    L9:
        r101 = null;
    L11:
        if ((r101 instanceof DialogFragment) == true) goto L13;
        r101 = null;
    L13:
        DialogFragment r103 = (DialogFragment) r101;
        if (r103 != null) goto L218;
    L23:
        this.f183909w = (CoordinatorLayout) w().b(R.id.ec_store_coordinator_layout).f();
        this.G = y().findViewById(R.id.ec_store_root_container);
        T().getHeaderArea().a(W(), new c(this), false);
        View r104 = w().b(R.id.ec_store_root_tab_bar_container).f();
        r104.setAlpha(0.0f);
        Unit r105 = Unit.INSTANCE;
        this.f183910x = r104;
        this.f183911y = (ViewGroup) w().b(R.id.ec_store_info_group_area_container).f();
        this.A = (ViewGroup) w().b(R.id.ec_store_tips_container).f();
        Z();
        T().getSlideDistance().a(W(), new w(this), false);
        View r106 = y().findViewById(R.id.ec_shop_click_for_finish_area);
        if (r106 == null) goto L26;
        r106.setOnClickListener(new d(this));
    L26:
        q0();
        T().getCroppedState().a(W(), new e(this), false);
        T().isLiveOn().a(W(), new f(this), false);
        T().getSelectedTabLocation().a(W(), new g(this), false);
        T().getCollapseFactor().a(W(), new h(this), false);
        k0().addObserver(this);
        int r107 = hk3.e.f485546a;
        int r108 = com.bytedance.android.ec.core.opt.ab.m.f45240a;
        Object r109 = 0;
        boolean r110 = ECServiceManager.f42805a;
        s83.g r111 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r111 == null) goto L32;
        s83.a r112 = r111.q();
        if (r112 == null) goto L32;
        Object r113 = r112.e("ec_store_video_zoom");
        if (r113 == null) goto L32;
    L199:
        if (((Number) r113).intValue() != 1) goto L220;
        Uri r114 = T().getSchema();
        if (r114 == null) goto L221;
        String r115 = UriProtector.getQueryParameter(r114, "video_zoom_controller_hash");
        if (r115 == null) goto L222;
        int r116 = CastIntegerProtector.parseInt(r115);
        int r117 = ((Number) this.f183905r.getValue()).intValue();
        int r118 = com.bytedance.android.shopping.store.home.p.f183795a;
        ECStoreAwemeFeedVideoZoomController r119 = new ECStoreAwemeFeedVideoZoomController(r117 - ((Number) this.f183904q.getValue()).intValue(), r116);
        k0().addObserver(r119);
        Unit r120 = Unit.INSTANCE;
        this.F = r119;
        return;
    L222:
        return;
    L221:
        return;
    L220:
        return;
    L32:
        int r121 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r122 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L189
        Object r124 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_store_video_zoom");     // Catch: Throwable -> L83
        if (r124 != null) goto L38;
    L80:
        Object r125 = null;
    L81:
        Object r126 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L83
    L85:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);     // Catch: Throwable -> L189
        if (r127 == null) goto L89;
        EnsureManager.ensureNotReachHere(r127);     // Catch: Throwable -> L189
    L89:
        if (Result.m9455isFailureimpl(r126) == false) goto L92;
        r126 = null;
    L92:
        if ((r126 instanceof Integer) == true) goto L94;
        r126 = null;
    L94:
        r113 = (Integer) r126;     // Catch: Throwable -> L189
        if (r113 != null) goto L101;
        Object r128 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_store_video_zoom");     // Catch: Throwable -> L189
        if ((r128 instanceof Integer) == true) goto L100;
        r128 = null;
    L100:
        r113 = (Integer) r128;     // Catch: Throwable -> L189
    L101:
        if (r113 != null) goto L199;
        int r129 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L189
        Object r130 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_store_video_zoom");     // Catch: Throwable -> L153
        if (r130 != null) goto L108;
    L150:
        Object r131 = null;
    L151:
        Object r132 = Result.m9449constructorimpl(r131);     // Catch: Throwable -> L153
    L155:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r132);     // Catch: Throwable -> L180
        if (r133 == null) goto L159;
        EnsureManager.ensureNotReachHere(r133);     // Catch: Throwable -> L180
    L159:
        if (Result.m9455isFailureimpl(r132) == false) goto L162;
        r132 = null;
    L162:
        if ((r132 instanceof Integer) == true) goto L164;
        r132 = null;
    L164:
        r113 = (Integer) r132;     // Catch: Throwable -> L180
        if (r113 != null) goto L187;
        IHybridHostService r134 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L180
        if (r134 == null) goto L170;
        Object r135 = r134.getHostABValue("ec_store_video_zoom", r109);     // Catch: Throwable -> L180
    L171:
        if (r135 != null) goto L173;
    L186:
        r113 = r109;
        goto L187
    L173:
        if ((r135 instanceof Integer) == false) goto L176;
        r102 = r135;
    L176:
        Integer r136 = (Integer) r102;     // Catch: Throwable -> L180
        if (r136 == null) goto L186;
        r113 = r136;
        goto L187
    L180:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L189
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L189
        Throwable r138 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L189
        if (r138 == null) goto L185;
        EnsureManager.ensureNotReachHere(r138);     // Catch: Throwable -> L189
    L185:
        if (Result.m9455isFailureimpl(r113) == false) goto L187;
    L170:
        r135 = null;
    L187:
        com.bytedance.android.ec.base.settings.d.d("ec_store_video_zoom", r113);     // Catch: Throwable -> L189
        goto L199
    L108:
        if ((r130 instanceof Integer) == true) goto L110;
        Object r139 = null;
    L111:
        r131 = (Integer) r139;     // Catch: Throwable -> L153
        if (r131 != null) goto L151;
        if ((r130 instanceof Number) == false) goto L138;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L123;
        Float r140 = Float.valueOf(((Number) r130).floatValue());     // Catch: Throwable -> L153
        if ((r140 instanceof Integer) == true) goto L121;
        r140 = null;
    L121:
        r131 = (Integer) r140;     // Catch: Throwable -> L153
        goto L151
    L123:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L129;
        Double r141 = Double.valueOf(((Number) r130).doubleValue());     // Catch: Throwable -> L153
        if ((r141 instanceof Integer) == true) goto L127;
        r141 = null;
    L127:
        r131 = (Integer) r141;     // Catch: Throwable -> L153
        goto L151
    L129:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L132;
        r131 = Integer.valueOf(((Number) r130).intValue());     // Catch: Throwable -> L153
        goto L151
    L132:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L138;
        Long r142 = Long.valueOf(((Number) r130).longValue());     // Catch: Throwable -> L153
        if ((r142 instanceof Integer) == true) goto L136;
        r142 = null;
    L136:
        r131 = (Integer) r142;     // Catch: Throwable -> L153
    L138:
        if ((r130 instanceof JSONObject) == false) goto L140;
    L208:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L146
        Object r143 = SDKSettingsCacheManager.a().fromJson(r130.toString(), Integer.class);     // Catch: Throwable -> L146
        if ((r143 instanceof Integer) == true) goto L144;
        r143 = null;
    L144:
        Object r144 = Result.m9449constructorimpl((Integer) r143);     // Catch: Throwable -> L146
    L148:
        r131 = r144;
        if (Result.m9455isFailureimpl(r131) == false) goto L151;
    L146:
        th = move-exception;
        Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L153
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
        goto L148
    L140:
        if ((r130 instanceof JSONArray) == false) goto L150;
    L110:
        r139 = r130;
    L153:
        th = move-exception;
        Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L180
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
        goto L155
    L38:
        if ((r124 instanceof Integer) == true) goto L40;
        Object r147 = null;
    L41:
        r125 = (Integer) r147;     // Catch: Throwable -> L83
        if (r125 != null) goto L81;
        if ((r124 instanceof Number) == false) goto L68;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L53;
        Float r148 = Float.valueOf(((Number) r124).floatValue());     // Catch: Throwable -> L83
        if ((r148 instanceof Integer) == true) goto L51;
        r148 = null;
    L51:
        r125 = (Integer) r148;     // Catch: Throwable -> L83
        goto L81
    L53:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L59;
        Double r149 = Double.valueOf(((Number) r124).doubleValue());     // Catch: Throwable -> L83
        if ((r149 instanceof Integer) == true) goto L57;
        r149 = null;
    L57:
        r125 = (Integer) r149;     // Catch: Throwable -> L83
        goto L81
    L59:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L62;
        r125 = Integer.valueOf(((Number) r124).intValue());     // Catch: Throwable -> L83
        goto L81
    L62:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L68;
        Long r150 = Long.valueOf(((Number) r124).longValue());     // Catch: Throwable -> L83
        if ((r150 instanceof Integer) == true) goto L66;
        r150 = null;
    L66:
        r125 = (Integer) r150;     // Catch: Throwable -> L83
    L68:
        if ((r124 instanceof JSONObject) == false) goto L70;
    L206:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L76
        Object r151 = SDKSettingsCacheManager.a().fromJson(r124.toString(), Integer.class);     // Catch: Throwable -> L76
        if ((r151 instanceof Integer) == true) goto L74;
        r151 = null;
    L74:
        Object r152 = Result.m9449constructorimpl((Integer) r151);     // Catch: Throwable -> L76
    L78:
        r125 = r152;
        if (Result.m9455isFailureimpl(r125) == false) goto L81;
    L76:
        th = move-exception;
        Result.Companion r153 = Result.Companion;     // Catch: Throwable -> L83
        r152 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L83
        goto L78
    L70:
        if ((r124 instanceof JSONArray) == false) goto L80;
    L40:
        r147 = r124;
    L83:
        th = move-exception;
        Result.Companion r154 = Result.Companion;     // Catch: Throwable -> L189
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L189
    L189:
        th = move-exception;
        Result.Companion r155 = Result.Companion;
        Object r156 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r157 = Result.m9452exceptionOrNullimpl(r156);
        if (r157 == null) goto L194;
        EnsureManager.ensureNotReachHere(r157);
    L194:
        if (Result.m9455isFailureimpl(r156) == true) goto L197;
        r109 = r156;
    L197:
        r113 = r109;
        goto L199
    L218:
        Result.Companion r158 = Result.Companion;     // Catch: Throwable -> L17
        Object r159 = Result.m9449constructorimpl(ImmersionBar.with(r103));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r159) == false) goto L22;
        r159 = null;
    L22:
        this.D = (ImmersionBar) r159;
    L17:
        th = move-exception;
        Result.Companion r160 = Result.Companion;
        r159 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public final void s0(boolean r100) {
        boolean r101 = V();
        if (r101 == false) goto L5;
        T().getLiveManager().f(r100);
    L5:
        if (r101 == true) goto L15;
        im.b r102 = T().getLiveManager();
        if (r102.d() == false) goto L16;
        int r103 = im.l.f490406a;
        boolean r104 = ECServiceManager.f42805a;
        if (Intrinsics.areEqual(((s83.g) ECServiceManager.c(s83.g.class)).E(), Boolean.TRUE) == false) goto L17;
        int r105 = ECSdk.f48106a;
        IAdapterService r106 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r106 == null) goto L13;
        r106.cancelMuteLiveRoom();
    L13:
        r102.f490376j = false;
        return;
    L17:
        return;
    L16:
        return;
    }
}
