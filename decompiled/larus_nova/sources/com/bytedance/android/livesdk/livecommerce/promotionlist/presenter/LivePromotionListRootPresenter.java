package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.Toggle;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.promotionlist.widget.LivePromotionListTopTabLayout;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePromotionListRootPresenter extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f150985t = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewPager f150986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LivePromotionListTopTabLayout f150987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f150988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f150989m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f150990n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LivePromotionListViewModel f150991o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public QUIManager f150992p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public nj2.a f150993q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LivePromotionListRootPresenter$getOnPageChangeListener$1 f150994r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Toggle f150995s;

    public static final class a {
    }

    static {
    }

    public final void h0() {
        LivePromotionListRootPresenter$getOnPageChangeListener$1 r100 = this.f150994r;
        if (r100 == null) goto L8;
        ViewPager r101 = this.f150986j;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L7:
        r101.removeOnPageChangeListener(r100);
    L8:
        this.f150994r = null;
        QUIManager r102 = this.f150992p;
        if (r102 == null) goto L11;
        r102.r(nj2.a.class);
    L11:
        this.f150992p = null;
        LivePromotionListViewModel r103 = this.f150991o;
        if (r103 == null) goto L14;
        r103.onDestroy();
    L14:
        this.f150991o = null;
        d0().setSecondViewModel(null);
        this.f150993q = null;
        this.f150990n = false;
        this.f150989m = false;
        this.f150995s = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View j0() {
        QUIManager r100 = this.f150992p;
        if (r100 != null) goto L5;
        Context r101 = Y().c();
        View r102 = a0();
        if (r102 == null) goto L43;
        final View r103 = th.a.c(r101, R.layout.shopping_layout_live_promotion_list_tab, (ViewGroup) r102, false);
        Fragment r104 = Y().d().i();
        if (r104 != 0) goto L11;
    L41:
        return r103;
    L11:
        if (this.f150992p != null) goto L14;
        this.f150992p = new QUIManager();
    L14:
        if (this.f150993q != null) goto L17;
        this.f150993q = new nj2.a(r103, r104, true, "live_list_second_view_model");
    L17:
        if (this.f150991o != null) goto L27;
        LivePromotionListViewModel r105 = (LivePromotionListViewModel) new ViewModelProvider(r104.getViewModelStore(), ((QViewModelOwner) r104).o6()).get("live_list_second_view_model", LivePromotionListViewModel.class);
        this.f150991o = r105;
        if (r105 == null) goto L22;
        r105.setGetCurrentTab(new LivePromotionListRootPresenter$getSecondView$$inlined$also$lambda$1(this, r103));
    L22:
        if (d0().isInSplitScreen() == false) goto L26;
        LivePromotionListViewModel r106 = this.f150991o;
        if (r106 == null) goto L26;
        r106.setInSplitScreen(d0().isInSplitScreen());
    L26:
        d0().setSecondViewModel(this.f150991o);
    L27:
        nj2.a r107 = this.f150993q;
        if (r107 == null) goto L32;
        QUIManager r108 = this.f150992p;
        if (r108 == null) goto L32;
        r108.l(r107, r104.requireContext(), true);
    L32:
        QUIManager r109 = this.f150992p;
        if (r109 == null) goto L35;
        r109.f450906a = r104;
    L35:
        LivePromotionListViewModel r110 = this.f150991o;
        if (r110 == null) goto L38;
        r110.setForceHideTopModule(true);
    L38:
        LivePromotionListViewModel r111 = this.f150991o;
        if (r111 == null) goto L41;
        r111.setDefaultTab(false);
        goto L41
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        return r100.p();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a, com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        h0();
        super.c0();
        s0.e(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void e0() {
        this.f150986j = (ViewPager) Z().b(R.id.vp_promotion_list).f();
        this.f150987k = (LivePromotionListTopTabLayout) Z().b(R.id.tl_promotion_list).f();
        LifecycleOwner r100 = ECQuickUtilKt.a(Y());
        com.bytedance.android.ec.core.arch.state.c.a(d0(), r100, LivePromotionListRootPresenter$init$1.INSTANCE, new LivePromotionListRootPresenter$init$2(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), r100, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.f0.class), new LivePromotionListRootPresenter$init$3(this));
        s0.c(this);
    }

    public LivePromotionListRootPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100, null);
    }

    public final void i0(boolean r100) {
        if (r100 == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        d0().setForceHideTopModule(!r101);
        if (r101 == false) goto L11;
        Y().d().c(nj2.f.class, null);
        Y().d().q(nj2.f.class, 0);
        return;
    L11:
        Y().d().r(nj2.f.class);
        Y().d().q(nj2.f.class, 8);
        return;
    L5:
        if (d0().disableUpdateInteractionData() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveTopFragmentStatusChanged(wk.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f150989m == false) goto L15;
        LivePromotionListTopTabLayout r101 = this.f150987k;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L8:
        if (r101.getVisibility() != 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        return;
    L14:
        throw null;
    L10:
        r102 = false;
        goto L11
    }
}
