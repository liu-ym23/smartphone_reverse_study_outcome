package com.bytedance.android.shopping.anchorv4.containers;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.compat.AdNationalTaskInfo;
import com.bytedance.android.shopping.anchorv4.components.l0;
import com.bytedance.android.shopping.anchorv4.containers.page.BaseProductDetailPage;
import com.bytedance.android.shopping.anchorv4.containers.page.FullScreenProductDetailPage;
import com.bytedance.android.shopping.anchorv4.containers.page.PageLifeCycleOwner;
import com.bytedance.android.shopping.anchorv4.containers.page.u;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.helper.PdpBottomNavBarHelper;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.voavhs.headgausee.HeadGaussRecyclerView;
import com.bytedance.android.shopping.api.PageDestroyTypeEvent;
import com.bytedance.android.shopping.service.ECAnchorV3Service;
import com.bytedance.android.shopping.utils.y;
import com.gyf.barlibrary.ImmersionBar;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0004:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/containers/ProductDetailMergeFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/android/shopping/anchorv4/containers/page/m;", "Lcom/bytedance/android/shopping/anchorv4/containers/h;", "", "Lp83/g;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductDetailMergeFragment extends AppCompatDialogFragment implements com.bytedance.android.shopping.anchorv4.containers.page.m, h, p83.g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f166202n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f166203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImmersionBar f166204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f166205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u f166206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f166207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l0 f166208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f166209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public cf.p f166210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f166211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f166212m;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.shopping.anchorv4.containers.page.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProductDetailMergeFragment f166213a;

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final Fragment getFragment() {
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void k(boolean r100) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final boolean a() {
            ProductDetailMergeFragment r100 = this.f166213a;
            int r101 = ProductDetailMergeFragment.f166202n;
            return r100.U90();
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final PageFinder getPageFinder() {
            return (PageFinder) this.f166213a.f166207h.getValue();
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final View getRootView() {
            return this.f166213a.getView();
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final Object o() {
            return this.f166213a;
        }

        public b(ProductDetailMergeFragment r100) {
            this.f166213a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void e(boolean r100) {
            ProductDetailMergeFragment r101 = this.f166213a;
            int r102 = ProductDetailMergeFragment.f166202n;
            Dialog r103 = r101.getDialog();
            if (r103 == null) goto L8;
            Window r104 = r103.getWindow();
            if (r104 == null) goto L9;
            com.bytedance.android.shopping.extensions.m.a(r104, r100);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void g(boolean r100) {
            this.f166213a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void h(RecyclerView r100) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void i(PackResponseDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "packDTO");
            Intrinsics.checkNotNullParameter(r100, "packDTO");
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final FragmentManager j(boolean r100) {
            if (r100 == true) goto L6;
            FragmentManager r101 = this.f166213a.getFragmentManager();
            int r102 = ProductDetailMergeFragment.f166202n;
            return r101;
        L6:
            return this.f166213a.getChildFragmentManager();
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void l(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r100, "scene");
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void m(BaseProductDetailPage r100) {
            Intrinsics.checkNotNullParameter(r100, "page");
            u r101 = this.f166213a.f166206g;
            if (r101 == null) goto L6;
            r101.c(r100);
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void n(HeadGaussRecyclerView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void p(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r100, "scene");
        }

        @Override // com.bytedance.android.shopping.anchorv4.containers.page.l
        public final void f(RecyclerView r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            cf.p r102 = this.f166213a.f166210k;
            if (r102 == null) goto L5;
            r102.b(r101);
        L5:
            String r103 = this.f166213a.S90();
            if (r103 == null) goto L11;
            Iterator<Function2<String, Integer, Unit>> r104 = ECAnchorV3Service.f182587b.iterator();
        L9:
            if (r104.hasNext() == false) goto L13;
            r104.next().invoke(r103, Integer.valueOf(r101));
            goto L9
        L13:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.h
    public final void J1() {
        u r100 = this.f166206g;
        if (r100 == null) goto L8;
        com.bytedance.android.shopping.anchorv4.containers.page.n r101 = r100.f166325a;
        if (r101 == null) goto L9;
        r101.j();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.f
    public final View N() {
        u r100 = this.f166206g;
        if (r100 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.containers.page.n r101 = r100.f166325a;
        if (r101 == null) goto L7;
        return r101.N();
    L7:
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        Iterator<Function2<String, String, Unit>> r100 = ECAnchorV3Service.f182593h.iterator();
    L4:
        if (r100.hasNext() == false) goto L18;
        Function2<String, String, Unit> r101 = r100.next();
        AnchorV4Param r102 = O00();
        String r103 = null;
        if (r102 == null) goto L10;
        V4NativeParams r104 = r102.getNativeParams();
        if (r104 == null) goto L10;
        String r105 = r104.getFractionListenerId();
    L11:
        u r106 = this.f166206g;
        if (r106 == null) goto L16;
        com.bytedance.android.shopping.anchorv4.containers.page.n r107 = r106.f166325a;
        if (r107 == null) goto L16;
        r103 = r107.f();
    L16:
        r101.invoke(r105, r103);
    L10:
        r105 = null;
        goto L11
    L18:
        if (U90() == false) goto L29;
        nj.d r108 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r108 == null) goto L29;
        getActivity();
        r108.m();
    L29:
        super.dismissAllowingStateLoss();     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r109 = DialogFragmentLancet.sLastShowStack;
        if (r109 == null) goto L35;
        com.bytedance.crash.d.d(r109, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.h
    public final String getSessionId() {
        u r100 = this.f166206g;
        if (r100 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.containers.page.n r101 = r100.f166325a;
        if (r101 == null) goto L7;
        return r101.getSessionId();
    L7:
        return null;
    }

    public ProductDetailMergeFragment() {
        this.f166207h = LazyKt.lazy(new ProductDetailMergeFragment$pageFinder$2(this));
        this.f166208i = new l0();
        this.f166209j = LazyKt.lazy(ProductDetailMergeFragment$adTurnaroundHelper$2.INSTANCE);
        this.f166211l = LazyKt.lazy(ProductDetailMergeFragment$hostService$2.INSTANCE);
        this.f166212m = System.identityHashCode(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.page.m
    public final AnchorV4Param O00() {
        Bundle r100 = getArguments();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("param_key");
    L7:
        if ((r102 instanceof AnchorV4Param) == false) goto L11;
        r101 = r102;
    L11:
        return (AnchorV4Param) r101;
    L5:
        r102 = null;
        goto L7
    }

    public final String S90() {
        AnchorV4Param r100 = O00();
        if (r100 == null) goto L12;
        V4NativeParams r101 = r100.getNativeParams();
        if (r101 == null) goto L13;
        String r102 = r101.getFractionListenerId();
        if (r102 != null) goto L9;
        return null;
    L9:
        if (com.bytedance.android.shopping.extensions.k.c(r102) == true) goto L11;
        return null;
    L11:
        return r102;
    L13:
        return null;
    L12:
        return null;
    }

    public final boolean T90() {
        AnchorV4Param r100 = O00();
        if (r100 == null) goto L12;
        V4NativeParams r101 = r100.getNativeParams();
        if (r101 == null) goto L13;
        String r102 = r101.getSourceBtmToken();
        if (r102 != null) goto L9;
        return false;
    L9:
        if (StringsKt.startsWith$default(r102, "a1.b1923", false, 2, null) != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public final boolean U90() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getBoolean("is_split_screen", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        if (U90() == false) goto L14;
        nj.d r100 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r100 == null) goto L14;
        getActivity();
        r100.m();
    L14:
        super.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.f166203d == false) goto L5;
        return;
    L5:
        u r100 = this.f166206g;
        if (r100 == null) goto L8;
        u.a(r100.f166325a);
    L8:
        ImmersionBar r101 = this.f166204e;
        if (r101 == null) goto L11;
        r101.destroy();
    L11:
        String r102 = S90();
        if (r102 == null) goto L17;
        Iterator<Function1<String, Unit>> r103 = ECAnchorV3Service.f182591f.iterator();
    L15:
        if (r103.hasNext() == false) goto L17;
        r103.next().invoke(r102);
    L17:
        cf.p r104 = this.f166210k;
        if (r104 == null) goto L20;
        r104.onDestroy();
    L20:
        int r105 = ECSdk.f48106a;
        IECUserTrackerService r106 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r106 == null) goto L23;
        r106.leavePage(new of.b((FragmentActivity) getContext(), com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, true, null, 24));
    L23:
        IECUserTrackerService r107 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r107 == null) goto L28;
        of.a r108 = r107.getMarketingService();
        if (r108 == null) goto L28;
        r108.a(com.bytedance.android.ec.core.event.a.VALUE_VISIT_SECONDS, PostActionType.END_DURATION, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
    L28:
        s0.a(PageDestroyTypeEvent.PRODUCT_DETAIL_FULL);
        l0 r109 = this.f166208i;
        AnchorV4Param r110 = O00();
        r109.getClass();
        l0.a(null, r110);
        s83.g r111 = (s83.g) this.f166211l.getValue();
        if (r111 == null) goto L33;
        r111.X(this.f166212m);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        cf.p r100 = this.f166210k;
        if (r100 == null) goto L5;
        r100.onPause();
    L5:
        s83.g r101 = (s83.g) this.f166211l.getValue();
        if (r101 == null) goto L8;
        r101.I(this.f166212m);
    L8:
        AnchorV4Param r102 = O00();
        if (r102 == null) goto L13;
        V4NativeParams r103 = r102.getNativeParams();
        if (r103 == null) goto L13;
        AdNationalTaskInfo r104 = r103.getTaskInfo();
    L14:
        com.bytedance.android.shopping.anchorv3.compat.b.a(r104);
        if (getShowsDialog() == true) goto L17;
        return;
    L17:
        if (T90() == false) goto L25;
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L26;
        int r106 = ECSdk.f48106a;
        s83.g r107 = (s83.g) ECSdk.a(s83.g.class);
        if (r107 == null) goto L27;
        r107.e0(r105, false);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L13:
        r104 = null;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        String r100 = S90();
        if (r100 == null) goto L8;
        Iterator<Function1<String, Unit>> r101 = ECAnchorV3Service.f182589d.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().invoke(r100);
    L8:
        cf.p r102 = this.f166210k;
        if (r102 == null) goto L11;
        r102.onResume();
    L11:
        AdNationalTaskInfo r103 = null;
        this.f166208i.d(null);
        s83.g r104 = (s83.g) this.f166211l.getValue();
        if (r104 == null) goto L14;
        r104.c(this.f166212m);
    L14:
        AnchorV4Param r105 = O00();
        if (r105 == null) goto L19;
        V4NativeParams r106 = r105.getNativeParams();
        if (r106 == null) goto L19;
        r103 = r106.getTaskInfo();
    L19:
        com.bytedance.android.shopping.anchorv3.compat.b.b(r103);
        int r107 = com.bytedance.android.ec.core.opt.b.f45274a;
        if (getShowsDialog() == true) goto L22;
        return;
    L22:
        if (T90() == false) goto L31;
        FragmentActivity r108 = getActivity();
        if (r108 == null) goto L32;
        int r109 = ECSdk.f48106a;
        s83.g r110 = (s83.g) ECSdk.a(s83.g.class);
        if (r110 == null) goto L33;
        r110.e0(r108, true);
        return;
    L33:
        return;
    L32:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        cf.p r100 = this.f166210k;
        if (r100 == null) goto L5;
        r100.onStart();
    L5:
        this.f166208i.e(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        String r100 = S90();
        if (r100 == null) goto L8;
        CopyOnWriteArrayList<Function2<String, Float, Unit>> r101 = ECAnchorV3Service.f182586a;
        Iterator<T> r102 = ECAnchorV3Service.f182590e.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((Function1) r102.next()).invoke(r100);
    L8:
        cf.p r103 = this.f166210k;
        if (r103 == null) goto L11;
        r103.onStop();
    L11:
        this.f166208i.f(null, getContext());
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        u r101 = this.f166206g;
        if (r101 == null) goto L8;
        com.bytedance.android.shopping.anchorv4.containers.page.n r102 = r101.f166325a;
        if (r102 == null) goto L9;
        r102.onConfigurationChanged(r100);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        int r111 = y.f187160a;
        if (y.a() == true) goto L13;
        this.f166203d = true;
        dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        Set<String> r112 = ECProcessMonitor.f45118a;
        ECProcessMonitor.o().j(-3, "插件加载失败");
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r113 = DialogFragmentLancet.sLastShowStack;
        if (r113 == null) goto L11;
        com.bytedance.crash.d.d(r113, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    L13:
        BtmSDK r114 = BtmSDK.INSTANCE;
        AnchorV4Param r100 = O00();
        cf.p r101 = null;
        if (r100 == null) goto L18;
        V4NativeParams r102 = r100.getNativeParams();
        if (r102 == null) goto L18;
        String r103 = r102.getSourceBtmToken();
    L19:
        r114.registerBtmPageOnCreate(this, "a1.b8094", r103);
        int r115 = ECSdk.f48106a;
        IECUserTrackerService r116 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r116 == null) goto L22;
        r116.enterPage(new of.b((FragmentActivity) getContext(), com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, true, null, 24));
    L22:
        IECUserTrackerService r117 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r117 == null) goto L27;
        of.a r118 = r117.getMarketingService();
        if (r118 == null) goto L27;
        r118.a(com.bytedance.android.ec.core.event.a.VALUE_VISIT_SECONDS, PostActionType.START_DURATION, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
    L27:
        String r119 = S90();
        if (r119 == null) goto L33;
        Iterator<Function1<String, Unit>> r104 = ECAnchorV3Service.f182592g.iterator();
    L31:
        if (r104.hasNext() == false) goto L33;
        r104.next().invoke(r119);
    L33:
        AnchorV4Param r120 = O00();
        if (r120 == null) goto L43;
        V4NativeParams r121 = r120.getNativeParams();
        if (r121 == null) goto L43;
        if (com.bytedance.android.shopping.extensions.k.c(r121.getPageStateListenerId()) == false) goto L43;
        int r105 = ECSdk.f48106a;
        IECCommonService r106 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r106 == null) goto L42;
        r101 = r106.createPageStateListenerHelper(r121.getPageStateListenerId(), r121.getPageStateListenerExtra());
    L42:
        this.f166210k = r101;
    L43:
        cf.p r122 = this.f166210k;
        if (r122 == null) goto L46;
        r122.onCreate();
    L46:
        this.f166208i.h(true, true);
        s83.g r123 = (s83.g) this.f166211l.getValue();
        if (r123 == null) goto L49;
        r123.O(this.f166212m);
    L49:
        s0.a(new hl.c());
        return;
    L18:
        r103 = null;
        goto L19
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        return new o(getContext());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        u r101 = this.f166206g;
        if (r101 == null) goto L8;
        com.bytedance.android.shopping.anchorv4.containers.page.n r102 = r101.f166325a;
        if (r102 == null) goto L9;
        r102.onSaveInstanceState(r100);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FragmentActivity r102 = (FragmentActivity) getContext();
        FrameLayout r103 = this.f166205f;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        Window r104 = null;
        u r105 = new u(r102, new com.bytedance.android.shopping.anchorv4.containers.page.g(r103, null, null), this);
        this.f166206g = r105;
        r105.b(r101);
        if (getShowsDialog() == false) goto L15;
        Dialog r106 = getDialog();
        if (r106 == null) goto L12;
        Window r107 = r106.getWindow();
        if (r107 == null) goto L12;
        com.bytedance.android.shopping.extensions.m.a(r107, true);
    L12:
        Map<String, String> r108 = PdpBottomNavBarHelper.f166907c;
        PdpBottomNavBarHelper.a.a(this, -1);
        Dialog r109 = getDialog();
        if (r109 == null) goto L26;
        r109.setOnKeyListener(new p(this));
    L26:
        l0 r110 = this.f166208i;
        Dialog r111 = getDialog();
        if (r111 == null) goto L29;
        r104 = r111.getWindow();
    L29:
        r110.i(r104);
        return;
    L15:
        FragmentActivity r112 = getActivity();
        if (r112 == null) goto L18;
        ImmersionBar r113 = ImmersionBar.with(r112);
    L19:
        this.f166204e = r113;
        if (r113 == null) goto L26;
        ImmersionBar r114 = r113.reset();
        if (r114 == null) goto L26;
        ImmersionBar r115 = r114.statusBarDarkFont(true);
        if (r115 == null) goto L26;
        r115.init();
        goto L26
    L18:
        r113 = null;
        goto L19
    }

    @Override // com.bytedance.android.shopping.anchorv4.containers.page.m
    public final com.bytedance.android.shopping.anchorv4.containers.page.n e20(AnchorV4Param r110, Bundle r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "viewModelKey");
        return new FullScreenProductDetailPage((FragmentActivity) getContext(), new PageLifeCycleOwner(this), getViewModelStore(), r112, r110, r111, new b(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout((FragmentActivity) getContext());
        this.f166205f = r103;
        return r103;
    }
}
