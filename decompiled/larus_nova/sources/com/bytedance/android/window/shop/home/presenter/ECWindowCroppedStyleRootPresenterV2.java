package com.bytedance.android.window.shop.home.presenter;

import android.content.Context;
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
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.utils.window.ECWindowShopLiveData;
import com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.header.WindowHeaderFragment;
import com.bytedance.android.window.shop.repository.header.utils.WindowHeaderStrategy;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowCroppedStyleRootPresenterV2;", "Lcom/bytedance/android/window/shop/home/presenter/AbsECWindowPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onStop", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowCroppedStyleRootPresenterV2 extends AbsECWindowPresenter implements LifecycleObserver {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f188295r = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f188296m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f188297n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f188298o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImmersionBar f188299p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f188300q;

    public final class a extends IECFeedControllerPresenter {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 f188301d;

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final Context b() {
            ECWindowCroppedStyleRootPresenterV2 r100 = this.f188301d;
            int r101 = ECWindowCroppedStyleRootPresenterV2.f188295r;
            return r100.u().c();
        }

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final ECWindowShopLiveData c() {
            return this.f188301d.O().getCroppedState();
        }

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final LifecycleOwner d() {
            return this.f188301d.U();
        }

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final boolean e() {
            return this.f188301d.Q();
        }

        @Override // com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter
        public final boolean f() {
            return this.f188301d.T();
        }

        public a(ECWindowCroppedStyleRootPresenterV2 r100) {
            this.f188301d = r100;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 f188302a;

        public b(ECWindowCroppedStyleRootPresenterV2 r100) {
            this.f188302a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f188302a.D();
        }
    }

    public static final class c implements ECWindowOverScrollExpandBehavior.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 f188303a;

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final void b() {
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final boolean d() {
            return true;
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final long f() {
            return 200;
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final int a() {
            return this.f188303a.G() / 2;
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final void e() {
            this.f188303a.D();
        }

        public c(ECWindowCroppedStyleRootPresenterV2 r100) {
            this.f188303a = r100;
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final void c(int r100) {
            this.f188303a.O().getPullOffset().setValue(Integer.valueOf(r100));
        }

        @Override // com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior.c
        public final void onRelease(int r100) {
            if (r100 <= ((int) (this.f188303a.G() * 1.35f))) goto L6;
            this.f188303a.D();
            return;
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        a r100 = this.f188296m;
        r100.c().removeObserver((Observer) r100.f49781b.getValue());
        r100.d().getLifecycle().removeObserver((LifecycleEventObserver) r100.f49782c.getValue());
        U().getLifecycle().removeObserver(this);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        ImmersionBar r102 = this.f188299p;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.destroy();     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        this.f188299p = null;
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public ECWindowCroppedStyleRootPresenterV2() {
        this.f188296m = new a(this);
        this.f188297n = LazyKt.lazy(new ECWindowCroppedStyleRootPresenterV2$doDragShowFullShopWindowEventReportOnce$2(this));
        this.f188298o = new c(this);
        this.f188300q = LazyKt.lazy(new ECWindowCroppedStyleRootPresenterV2$slideNoticeView$2(this));
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
        this.f188296m.a();
        w().b(R.id.ec_shop_info_area_container_wrapper).f().setOnTouchListener(new z());
        w().b(R.id.ec_shop_info_area_container_wrapper).g(4);
        O().getHeaderResponse().a(U(), new a0(this), true);
        O().getHeaderResponse().a(U(), new b0(this), true);
        O().getOffsetState().a(U(), new c0(this), false);
        O().getCroppedState().observe(U(), new y(this));
        Fragment r101 = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        CoordinatorLayout.Behavior r102 = null;
        if ((r101 instanceof DialogFragment) == true) goto L5;
        r101 = null;
    L5:
        DialogFragment r103 = (DialogFragment) r101;
        if (r103 != null) goto L79;
    L15:
        View r104 = y().findViewById(R.id.ec_store_live_container);
        if (r104 == null) goto L18;
        r104.setVisibility(0);
        r104.setOnClickListener(new b(this));
    L18:
        View r105 = y();
    L19:
        if (r105 == null) goto L27;
        View r106 = com.bytedance.android.ec.window.base.utils.c.a(X(), ECWindowCroppedStyleRootPresenterV2$setupOverScrollController$owner$1.INSTANCE);
        if (r106 != null) goto L22;
        Object r107 = r105.getParent();
        if ((r107 instanceof View) == true) goto L26;
        r107 = null;
    L26:
        r105 = (View) r107;
        goto L19
    L22:
        r105 = r106;
    L27:
        if (r105 == null) goto L29;
        ViewGroup.LayoutParams r108 = r105.getLayoutParams();
    L31:
        if ((r108 instanceof CoordinatorLayout.LayoutParams) == true) goto L33;
        r108 = null;
    L33:
        CoordinatorLayout.LayoutParams r109 = (CoordinatorLayout.LayoutParams) r108;
        if (r109 == null) goto L42;
        CoordinatorLayout.Behavior r110 = r109.getBehavior();
        if (r110 == null) goto L42;
        if ((r110 instanceof ECWindowOverScrollExpandBehavior) == false) goto L40;
        r102 = r110;
    L40:
        if (r102 == null) goto L42;
        ((ECWindowOverScrollExpandBehavior) r102).setExpandController(this.f188298o);
    L42:
        U().getLifecycle().addObserver(this);
        ECWindowDialogFragment r111 = (ECWindowDialogFragment) ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if (r111 == null) goto L54;
        FragmentManager r112 = r111.getChildFragmentManager();
        if (r112 == null) goto L54;
        FragmentTransaction r113 = r112.beginTransaction();
        if (r113 == null) goto L54;
        WindowHeaderFragment r114 = new WindowHeaderFragment();
        String r115 = String.valueOf(WindowHeaderStrategy.ONLY_SHOW_IN_FULLSCREEN.getStrategy());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r113, r114, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r115, R.id.ec_window_full_screen_header_container) == true) goto L52;
        r113 = r113.replace(R.id.ec_window_full_screen_header_container, r114, r115);
    L52:
        if (r113 == null) goto L54;
        r113.commit();
    L54:
        ECWindowDialogFragment r116 = (ECWindowDialogFragment) ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if (r116 == null) goto L66;
        FragmentManager r117 = r116.getChildFragmentManager();
        if (r117 == null) goto L66;
        FragmentTransaction r118 = r117.beginTransaction();
        if (r118 == null) goto L66;
        WindowHeaderFragment r119 = new WindowHeaderFragment();
        String r120 = String.valueOf(WindowHeaderStrategy.ONLY_SHOW_IN_SPLIT.getStrategy());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r118, r119, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r120, R.id.ec_shop_info_area_container) == true) goto L64;
        r118 = r118.replace(R.id.ec_shop_info_area_container, r119, r120);
    L64:
        if (r118 == null) goto L66;
        r118.commit();
    L66:
        ECWindowDialogFragment r121 = (ECWindowDialogFragment) ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if (r121 == null) goto L85;
        FragmentManager r122 = r121.getChildFragmentManager();
        if (r122 == null) goto L86;
        FragmentTransaction r123 = r122.beginTransaction();
        if (r123 == null) goto L87;
        WindowHeaderFragment r124 = new WindowHeaderFragment();
        String r125 = String.valueOf(WindowHeaderStrategy.ALWAYS_SHOWING.getStrategy());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r123, r124, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r125, R.id.ec_window_cropped_pinned_list_container) == true) goto L76;
        r123 = r123.replace(R.id.ec_window_cropped_pinned_list_container, r124, r125);
    L76:
        if (r123 == null) goto L88;
        r123.commit();
        return;
    L88:
        return;
    L87:
        return;
    L86:
        return;
    L85:
        return;
    L29:
        r108 = null;
        goto L31
    L79:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L9
        Object r127 = Result.m9449constructorimpl(ImmersionBar.with(r103));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r127) == false) goto L14;
        r127 = null;
    L14:
        this.f188299p = (ImmersionBar) r127;
    L9:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
