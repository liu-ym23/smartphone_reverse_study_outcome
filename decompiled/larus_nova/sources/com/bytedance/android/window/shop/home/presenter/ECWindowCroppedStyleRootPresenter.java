package com.bytedance.android.window.shop.home.presenter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.window.base.shop.ECWindowAwemeFeedVideoZoomController;
import com.bytedance.android.ec.window.base.utils.window.ECWindowShopLiveData;
import com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.header.WindowHeaderFragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowCroppedStyleRootPresenter;", "Lcom/bytedance/android/window/shop/home/presenter/AbsECWindowPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onStop", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowCroppedStyleRootPresenter extends AbsECWindowPresenter implements LifecycleObserver {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f188285s = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f188286m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f188287n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ECWindowAwemeFeedVideoZoomController f188288o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f188289p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImmersionBar f188290q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f188291r;

    public final class a extends IECFeedControllerPresenter {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECWindowCroppedStyleRootPresenter f188292d;

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final Context b() {
            ECWindowCroppedStyleRootPresenter r100 = this.f188292d;
            int r101 = ECWindowCroppedStyleRootPresenter.f188285s;
            return r100.u().c();
        }

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final ECWindowShopLiveData c() {
            return this.f188292d.O().getCroppedState();
        }

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final LifecycleOwner d() {
            return this.f188292d.U();
        }

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final boolean e() {
            return this.f188292d.Q();
        }

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final boolean f() {
            return this.f188292d.T();
        }

        public a(ECWindowCroppedStyleRootPresenter r100) {
            this.f188292d = r100;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowCroppedStyleRootPresenter f188293a;

        public b(ECWindowCroppedStyleRootPresenter r100) {
            this.f188293a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f188293a.D();
        }
    }

    public static final class c implements ECWindowOverScrollExpandBehavior.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowCroppedStyleRootPresenter f188294a;

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final void b() {
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final boolean d() {
            return false;
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final long f() {
            return 200;
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final int a() {
            return this.f188294a.G() / 2;
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final void e() {
            this.f188294a.D();
        }

        public c(ECWindowCroppedStyleRootPresenter r100) {
            this.f188294a = r100;
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final void c(int r100) {
            ECWindowCroppedStyleRootPresenter r101 = this.f188294a;
            ECWindowAwemeFeedVideoZoomController r102 = r101.f188288o;
            if (r102 == null) goto L25;
            int r103 = ((Number) r101.f188243f.getValue()).intValue() - r100;
            ValueAnimator r104 = r102.f49562a;
            if (r104 != null) goto L7;
        L8:
            ValueAnimator r105 = r102.f49567f;
            if (r105 != null) goto L11;
        L13:
            boolean r106 = false;
        L14:
            if (r106 == true) goto L26;
            ValueAnimator r107 = r102.f49565d;
            if (r107 != null) goto L19;
        L23:
            r102.b(r103);
            return;
        L19:
            if (r107.isRunning() != true) goto L23;
            ValueAnimator r108 = r102.f49565d;
            if (r108 == null) goto L23;
            r108.cancel();
            goto L23
        L26:
            return;
        L11:
            if (r105.isRunning() != true) goto L13;
        L12:
            r106 = true;
            goto L14
        L7:
            if (r104.isRunning() == true) goto L12;
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final void onRelease(int r100) {
            ECWindowAwemeFeedVideoZoomController r101 = this.f188294a.f188288o;
            if (r101 == null) goto L11;
            ValueAnimator r102 = ValueAnimator.ofInt(new int[]{r101.f49566e, r101.f49568g});
            r101.f49565d = r102;
            if (r102 == null) goto L7;
            r102.setDuration(100);
            r102.addUpdateListener(new com.bytedance.android.ec.window.base.shop.a(r101));
        L7:
            ValueAnimator r103 = r101.f49565d;
            if (r103 == null) goto L11;
            r103.start();
        L11:
            if (r100 <= ((int) (this.f188294a.G() * 1.35f))) goto L14;
            this.f188294a.D();
            return;
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        a r100 = this.f188286m;
        r100.c().removeObserver((Observer) r100.f49781b.getValue());
        r100.d().getLifecycle().removeObserver((LifecycleEventObserver) r100.f49782c.getValue());
        U().getLifecycle().removeObserver(this);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        ImmersionBar r102 = this.f188290q;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.destroy();     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        this.f188290q = null;
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public ECWindowCroppedStyleRootPresenter() {
        this.f188286m = new a(this);
        this.f188287n = LazyKt.lazy(new ECWindowCroppedStyleRootPresenter$doDragShowFullShopWindowEventReportOnce$2(this));
        this.f188289p = new c(this);
        this.f188291r = LazyKt.lazy(new ECWindowCroppedStyleRootPresenter$slideNoticeView$2(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        boolean r100 = O().getShopParam().getStatusBarDarkFont();
        QContext r101 = u();
        FragmentActivity r102 = com.bytedance.android.ec.core.utils.l0.c(r101.c());
        if ((r102 instanceof FragmentActivity) == true) goto L5;
        r102 = null;
    L5:
        if (r102 != null) goto L7;
        r102 = r101.a();
    L7:
        int r103 = com.bytedance.android.ec.core.utils.y1.f45751a;
        com.bytedance.android.ec.core.utils.y1.c(r102, r102.getWindow(), r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f188286m.a();
        w().b(R.id.ec_shop_info_area_container_wrapper).f().setOnClickListener(new t(this));
        w().b(R.id.ec_shop_info_area_container_wrapper).g(4);
        O().getHeaderResponse().a(U(), new u(this), true);
        O().getHeaderResponse().a(U(), new v(this), true);
        O().getOffsetState().a(U(), new w(this), false);
        O().getCroppedState().observe(U(), new s(this));
        Fragment r101 = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if ((r101 instanceof DialogFragment) == true) goto L5;
        r101 = null;
    L5:
        DialogFragment r102 = (DialogFragment) r101;
        if (r102 != null) goto L245;
    L15:
        View r103 = y().findViewById(R.id.ec_store_live_container);
        if (r103 == null) goto L18;
        r103.setVisibility(0);
        r103.setOnClickListener(new b(this));
    L18:
        View r104 = y();
    L19:
        if (r104 == null) goto L27;
        View r105 = com.bytedance.android.ec.window.base.utils.c.a(X(), ECWindowCroppedStyleRootPresenter$setupOverScrollController$owner$1.INSTANCE);
        if (r105 != null) goto L22;
        Object r106 = r104.getParent();
        if ((r106 instanceof View) == true) goto L26;
        r106 = null;
    L26:
        r104 = (View) r106;
        goto L19
    L22:
        r104 = r105;
    L27:
        if (r104 == null) goto L29;
        ViewGroup.LayoutParams r107 = r104.getLayoutParams();
    L31:
        if ((r107 instanceof CoordinatorLayout.LayoutParams) == true) goto L33;
        r107 = null;
    L33:
        CoordinatorLayout.LayoutParams r108 = (CoordinatorLayout.LayoutParams) r107;
        if (r108 == null) goto L43;
        CoordinatorLayout.Behavior r109 = r108.getBehavior();
        if (r109 == null) goto L43;
        if ((r109 instanceof ECWindowOverScrollExpandBehavior) == true) goto L41;
        r109 = null;
    L41:
        if (r109 == null) goto L43;
        ((ECWindowOverScrollExpandBehavior) r109).setExpandController(this.f188289p);
    L43:
        U().getLifecycle().addObserver(this);
        int r110 = com.bytedance.android.ec.window.base.shop.r.f49656a;
        int r111 = com.bytedance.android.ec.core.opt.ab.m.f45240a;
        Object r112 = 0;
        boolean r113 = ECServiceManager.f42805a;
        s83.g r114 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r114 == null) goto L49;
        s83.a r115 = r114.q();
        if (r115 == null) goto L49;
        Object r116 = r115.e("ec_store_video_zoom");
        if (r116 == null) goto L49;
    L214:
        if (((Number) r116).intValue() != 1) goto L220;
        Uri r117 = O().getSchema();
        if (r117 == null) goto L220;
        String r118 = UriProtector.getQueryParameter(r117, "video_zoom_controller_hash");
        if (r118 == null) goto L220;
        ECWindowAwemeFeedVideoZoomController r119 = new ECWindowAwemeFeedVideoZoomController(((Number) this.f188243f.getValue()).intValue() - G(), CastIntegerProtector.parseInt(r118));
        U().getLifecycle().addObserver(r119);
        Unit r120 = Unit.INSTANCE;
        this.f188288o = r119;
    L220:
        ECWindowDialogFragment r121 = (ECWindowDialogFragment) ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if (r121 == null) goto L251;
        FragmentManager r122 = r121.getChildFragmentManager();
        if (r122 == null) goto L252;
        FragmentTransaction r123 = r122.beginTransaction();
        if (r123 == null) goto L253;
        WindowHeaderFragment r124 = new WindowHeaderFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r123, r124, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.ec_shop_info_area_container) == true) goto L230;
        r123 = r123.replace(R.id.ec_shop_info_area_container, r124);
    L230:
        if (r123 == null) goto L254;
        r123.commit();
        return;
    L254:
        return;
    L253:
        return;
    L252:
        return;
    L251:
        return;
    L49:
        int r125 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r126 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L204
        Object r128 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_store_video_zoom");     // Catch: Throwable -> L100
        if (r128 != null) goto L55;
    L97:
        Object r129 = null;
    L98:
        Object r130 = Result.m9449constructorimpl(r129);     // Catch: Throwable -> L100
    L102:
        Throwable r131 = Result.m9452exceptionOrNullimpl(r130);     // Catch: Throwable -> L204
        if (r131 == null) goto L106;
        EnsureManager.ensureNotReachHere(r131);     // Catch: Throwable -> L204
    L106:
        if (Result.m9455isFailureimpl(r130) == false) goto L109;
        r130 = null;
    L109:
        if ((r130 instanceof Integer) == true) goto L111;
        r130 = null;
    L111:
        r116 = (Integer) r130;     // Catch: Throwable -> L204
        if (r116 != null) goto L118;
        Object r132 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_store_video_zoom");     // Catch: Throwable -> L204
        if ((r132 instanceof Integer) == true) goto L117;
        r132 = null;
    L117:
        r116 = (Integer) r132;     // Catch: Throwable -> L204
    L118:
        if (r116 != null) goto L214;
        int r133 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L204
        Object r134 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_store_video_zoom");     // Catch: Throwable -> L170
        if (r134 != null) goto L125;
    L167:
        Object r135 = null;
    L168:
        Object r136 = Result.m9449constructorimpl(r135);     // Catch: Throwable -> L170
    L172:
        Throwable r137 = Result.m9452exceptionOrNullimpl(r136);     // Catch: Throwable -> L195
        if (r137 == null) goto L176;
        EnsureManager.ensureNotReachHere(r137);     // Catch: Throwable -> L195
    L176:
        if (Result.m9455isFailureimpl(r136) == false) goto L179;
        r136 = null;
    L179:
        if ((r136 instanceof Integer) == true) goto L181;
        r136 = null;
    L181:
        r116 = (Integer) r136;     // Catch: Throwable -> L195
        if (r116 != null) goto L202;
        IHybridHostService r138 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L195
        if (r138 == null) goto L187;
        Object r139 = r138.getHostABValue("ec_store_video_zoom", r112);     // Catch: Throwable -> L195
    L188:
        if (r139 != null) goto L190;
    L201:
        r116 = r112;
        goto L202
    L190:
        if ((r139 instanceof Integer) == true) goto L192;
        r139 = null;
    L192:
        r116 = (Integer) r139;     // Catch: Throwable -> L195
        if (r116 != null) goto L202;
    L195:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L204
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L204
        Throwable r141 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L204
        if (r141 == null) goto L200;
        EnsureManager.ensureNotReachHere(r141);     // Catch: Throwable -> L204
    L200:
        if (Result.m9455isFailureimpl(r116) == false) goto L202;
    L187:
        r139 = null;
    L202:
        com.bytedance.android.ec.base.settings.d.d("ec_store_video_zoom", r116);     // Catch: Throwable -> L204
        goto L214
    L125:
        if ((r134 instanceof Integer) == true) goto L127;
        Object r142 = null;
    L128:
        r135 = (Integer) r142;     // Catch: Throwable -> L170
        if (r135 != null) goto L168;
        if ((r134 instanceof Number) == false) goto L155;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L140;
        Float r143 = Float.valueOf(((Number) r134).floatValue());     // Catch: Throwable -> L170
        if ((r143 instanceof Integer) == true) goto L138;
        r143 = null;
    L138:
        r135 = (Integer) r143;     // Catch: Throwable -> L170
        goto L168
    L140:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L146;
        Double r144 = Double.valueOf(((Number) r134).doubleValue());     // Catch: Throwable -> L170
        if ((r144 instanceof Integer) == true) goto L144;
        r144 = null;
    L144:
        r135 = (Integer) r144;     // Catch: Throwable -> L170
        goto L168
    L146:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L149;
        r135 = Integer.valueOf(((Number) r134).intValue());     // Catch: Throwable -> L170
        goto L168
    L149:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L155;
        Long r145 = Long.valueOf(((Number) r134).longValue());     // Catch: Throwable -> L170
        if ((r145 instanceof Integer) == true) goto L153;
        r145 = null;
    L153:
        r135 = (Integer) r145;     // Catch: Throwable -> L170
    L155:
        if ((r134 instanceof JSONObject) == false) goto L157;
    L235:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L163
        Object r146 = SDKSettingsCacheManager.a().fromJson(r134.toString(), Integer.class);     // Catch: Throwable -> L163
        if ((r146 instanceof Integer) == true) goto L161;
        r146 = null;
    L161:
        Object r147 = Result.m9449constructorimpl((Integer) r146);     // Catch: Throwable -> L163
    L165:
        r135 = r147;
        if (Result.m9455isFailureimpl(r135) == false) goto L168;
    L163:
        th = move-exception;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L170
        r147 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        goto L165
    L157:
        if ((r134 instanceof JSONArray) == false) goto L167;
    L127:
        r142 = r134;
    L170:
        th = move-exception;
        Result.Companion r149 = Result.Companion;     // Catch: Throwable -> L195
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L195
        goto L172
    L55:
        if ((r128 instanceof Integer) == true) goto L57;
        Object r150 = null;
    L58:
        r129 = (Integer) r150;     // Catch: Throwable -> L100
        if (r129 != null) goto L98;
        if ((r128 instanceof Number) == false) goto L85;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L70;
        Float r151 = Float.valueOf(((Number) r128).floatValue());     // Catch: Throwable -> L100
        if ((r151 instanceof Integer) == true) goto L68;
        r151 = null;
    L68:
        r129 = (Integer) r151;     // Catch: Throwable -> L100
        goto L98
    L70:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L76;
        Double r152 = Double.valueOf(((Number) r128).doubleValue());     // Catch: Throwable -> L100
        if ((r152 instanceof Integer) == true) goto L74;
        r152 = null;
    L74:
        r129 = (Integer) r152;     // Catch: Throwable -> L100
        goto L98
    L76:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L79;
        r129 = Integer.valueOf(((Number) r128).intValue());     // Catch: Throwable -> L100
        goto L98
    L79:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L85;
        Long r153 = Long.valueOf(((Number) r128).longValue());     // Catch: Throwable -> L100
        if ((r153 instanceof Integer) == true) goto L83;
        r153 = null;
    L83:
        r129 = (Integer) r153;     // Catch: Throwable -> L100
    L85:
        if ((r128 instanceof JSONObject) == false) goto L87;
    L233:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L93
        Object r154 = SDKSettingsCacheManager.a().fromJson(r128.toString(), Integer.class);     // Catch: Throwable -> L93
        if ((r154 instanceof Integer) == true) goto L91;
        r154 = null;
    L91:
        Object r155 = Result.m9449constructorimpl((Integer) r154);     // Catch: Throwable -> L93
    L95:
        r129 = r155;
        if (Result.m9455isFailureimpl(r129) == false) goto L98;
    L93:
        th = move-exception;
        Result.Companion r156 = Result.Companion;     // Catch: Throwable -> L100
        r155 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L100
        goto L95
    L87:
        if ((r128 instanceof JSONArray) == false) goto L97;
    L57:
        r150 = r128;
    L100:
        th = move-exception;
        Result.Companion r157 = Result.Companion;     // Catch: Throwable -> L204
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L204
    L204:
        th = move-exception;
        Result.Companion r158 = Result.Companion;
        Object r159 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r160 = Result.m9452exceptionOrNullimpl(r159);
        if (r160 == null) goto L209;
        EnsureManager.ensureNotReachHere(r160);
    L209:
        if (Result.m9455isFailureimpl(r159) == true) goto L212;
        r112 = r159;
    L212:
        r116 = r112;
        goto L214
    L29:
        r107 = null;
        goto L31
    L245:
        Result.Companion r161 = Result.Companion;     // Catch: Throwable -> L9
        Object r162 = Result.m9449constructorimpl(ImmersionBar.with(r102));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r162) == false) goto L14;
        r162 = null;
    L14:
        this.f188290q = (ImmersionBar) r162;
    L9:
        th = move-exception;
        Result.Companion r163 = Result.Companion;
        r162 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
