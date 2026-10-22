package com.obric.appstore.buss.recommend;

import android.content.res.Resources;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.b0;
import androidx.recyclerview.widget.RecyclerView;
import bytedanceos.view.animation.TweenInterpolator;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.privacy.PrivacyChecker;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;
import com.bytedanceos.common.ui.widget.oui.ViewExtKt;
import com.bytedanceos.common.utils.PerformanceMonitor;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseListFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.LocaleChangeAwareKt;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.buss.search.SearchContainerFragment;
import com.obric.appstore.buss.search.transition.SearchTransition;
import com.obric.appstore.ui.adapter.FixedEntranceItemProvider;
import com.obric.appstore.ui.adapter.HomeCardItemProvider;
import com.obric.appstore.ui.adapter.HorGridAppsItemProvider;
import com.obric.appstore.ui.adapter.TemplateUILoadMoreAdapter;
import com.obric.appstore.util.m;
import com.obric.appstore.util.n;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.IFPSCallBack;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import org.apache.http.message.TokenParser;
import x7.c0;
import x7.k;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001qB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u0005J!\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001fH\u0002¢\u0006\u0004\b%\u0010\"J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010\u001bJ\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0005J\u0017\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J!\u0010-\u001a\u00020\b2\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010,\u001a\u00020\u001fH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b/\u00100J#\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\u001f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b2\u00103J\u001f\u00108\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u0019\u0010;\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\u001fH\u0002¢\u0006\u0004\b;\u0010\"R\u001a\u0010@\u001a\u0002048\u0014X\u0094D¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010E\u001a\u00020\u001f8\u0014X\u0094D¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010K\u001a\u00020F8\u0014X\u0094\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR,\u0010Z\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030S0R8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010`R\u0016\u0010c\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010BR\u0014\u0010e\u001a\u00020L8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bd\u0010PR\u0014\u0010i\u001a\u00020f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR$\u0010m\u001a\u00020\u001f2\u0006\u0010j\u001a\u00020\u001f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bk\u0010D\"\u0004\bl\u0010\"R$\u0010p\u001a\u00020\u001f2\u0006\u0010j\u001a\u00020\u001f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bn\u0010D\"\u0004\bo\u0010\"¨\u0006r"}, d2 = {"Lcom/obric/appstore/buss/recommend/RecommendFragment;", "Lcom/obric/appstore/base/BaseListFragment;", "Lza/f;", "Lcom/bytedanceos/common/privacy/PrivacyChecker$Observer;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "onPrivacyAgreed", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "toolBar", "D", "(Lcom/obric/oui/titlebar/OFloatingTitleBar;)V", "Landroid/widget/FrameLayout;", "container", "C", "(Landroid/widget/FrameLayout;)V", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "Lcom/obric/appstore/util/s;", "P", "(Landroid/view/View;)Lcom/obric/appstore/util/s;", "", "hidden", "onHiddenChanged", "(Z)V", "v0", "needTransition", "w0", "C0", "n0", "Lcom/obric/oui/bouncelayout/ONestedScrollView;", "recommendContainer", "k0", "(Lcom/obric/oui/bouncelayout/ONestedScrollView;)V", "fromScroll", "M0", "(Lcom/obric/oui/bouncelayout/ONestedScrollView;Z)V", "L0", "(Lcom/obric/oui/bouncelayout/ONestedScrollView;)Z", "visible", "F0", "(ZLcom/obric/oui/titlebar/OFloatingTitleBar;)V", "", "count", "Lcom/obric/oui/badge/OBadgeView;", "updateCount", "J0", "(ILcom/obric/oui/badge/OBadgeView;)V", "anim", "I0", "o", "I", "w", "()I", "layoutId", "p", "Z", "u", "()Z", "fullContent", "Lcom/obric/appstore/ui/adapter/TemplateUILoadMoreAdapter;", "q", "Lcom/obric/appstore/ui/adapter/TemplateUILoadMoreAdapter;", "o0", "()Lcom/obric/appstore/ui/adapter/TemplateUILoadMoreAdapter;", "adapter", "Lcom/obric/appstore/buss/recommend/RecommendVM;", "r", "Lkotlin/Lazy;", "r0", "()Lcom/obric/appstore/buss/recommend/RecommendVM;", "recommendVM", "Landroidx/lifecycle/Observer;", "Lcom/obric/appstore/network/g;", "s", "Landroidx/lifecycle/Observer;", "q0", "()Landroidx/lifecycle/Observer;", "D0", "(Landroidx/lifecycle/Observer;)V", "observer", "Lx7/k;", "t", "Lx7/k;", "bind", "Lcom/obric/oui/popover/v2/OPopover;", "Lcom/obric/oui/popover/v2/OPopover;", "menu", "v", "isAddedSearch", "p0", "listVM", "Landroidx/lifecycle/b0;", "s0", "()Landroidx/lifecycle/b0;", "savedStateHandle", CommonKey.KEY_VALUE, "u0", "K0", "useTransition", "t0", "E0", "searchActionVisible", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecommendFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecommendFragment.kt\ncom/obric/appstore/buss/recommend/RecommendFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 7 FragmentTransaction.kt\nandroidx/fragment/app/FragmentTransactionKt\n+ 8 View.kt\nandroidx/core/view/ViewKt\n+ 9 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,502:1\n106#2,15:503\n181#3,3:518\n180#3,5:521\n181#3,3:526\n180#3,5:529\n181#3,3:556\n180#3,5:559\n37#4,2:534\n28#5,6:536\n34#5,6:549\n13309#6,2:542\n39#7,5:544\n84#8:555\n1#9:564\n*S KotlinDebug\n*F\n+ 1 RecommendFragment.kt\ncom/obric/appstore/buss/recommend/RecommendFragment\n*L\n91#1:503,15\n248#1:518,3\n248#1:521,5\n249#1:526,3\n249#1:529,5\n409#1:556,3\n409#1:559,5\n303#1:534,2\n323#1:536,6\n323#1:549,6\n326#1:542,2\n331#1:544,5\n392#1:555\n*E\n"})
public final class RecommendFragment extends BaseListFragment<za.f> implements PrivacyChecker.Observer {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f10805w = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10806o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f10807p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TemplateUILoadMoreAdapter f10808q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f10809r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Observer f10810s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public k f10811t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public OPopover f10812u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10813v;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecommendFragment f10815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ONestedScrollView f10816c;

        public b(View r10, RecommendFragment r11, ONestedScrollView r12) {
            this.f10814a = r10;
            this.f10815b = r11;
            this.f10816c = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecommendFragment.N0(this.f10815b, this.f10816c, false, 2, null);
        }
    }

    public static final class c implements IFPSCallBack {
        public c() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.commonmonitor.fps.IFPSCallBack
        public void fpsCallBack(dc.d r10) {
            j.e("RecommendFragment fpsCallBack " + r10);
        }
    }

    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f10817a;

        public d(Function1 r10) {
            q.g(r10, "function");
            this.f10817a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f10817a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f10817a.invoke(r10);
        }
    }

    static {
        f10805w = new a(null);
    }

    public RecommendFragment() {
        this.f10806o = R.layout.fragment_recommend_layout;
        this.f10807p = true;
        this.f10808q = new TemplateUILoadMoreAdapter();
        final Function0<Fragment> r10 = new RecommendFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new RecommendFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10809r = FragmentViewModelLazyKt.c(this, u.b(RecommendVM.class), new RecommendFragment$special$$inlined$viewModels$default$3(r11), new RecommendFragment$special$$inlined$viewModels$default$4(r12, r11), new RecommendFragment$special$$inlined$viewModels$default$5(this, r11));
    }

    public static final void A0(RecommendFragment r10, View r11) {
        q.g(r10, "this$0");
        n.e(n.f11086a, r10.getActivity(), 0, 2, null);
    }

    public static final void B0(RecommendFragment r10, View r11) {
        q.g(r10, "this$0");
        q.d(r11);
        r10.C0(r11);
    }

    public static /* synthetic */ void G0(RecommendFragment r10, boolean r11, OFloatingTitleBar r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = r10.y();
    L5:
        r10.F0(r11, r12);
    }

    public static final void H0(RecommendFragment r10, View r11) {
        q.g(r10, "this$0");
        r10.w0(false);
    }

    public static /* synthetic */ void N0(RecommendFragment r10, ONestedScrollView r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = false;
    L5:
        r10.M0(r11, r12);
    }

    public static /* synthetic */ void a0(RecommendFragment r10, Locale r11) {
        y0(r10, r11);
    }

    public static /* synthetic */ void b0(RecommendFragment r10, View r11) {
        A0(r10, r11);
    }

    public static /* synthetic */ void c0(RecommendFragment r10, View r11) {
        H0(r10, r11);
    }

    public static /* synthetic */ void d0(RecommendFragment r10, View r11) {
        z0(r10, r11);
    }

    public static /* synthetic */ void e0(RecommendFragment r10, com.obric.appstore.network.g r11) {
        x0(r10, r11);
    }

    public static /* synthetic */ void f0(RecommendFragment r10, ONestedScrollView r11) {
        l0(r10, r11);
    }

    public static /* synthetic */ void g0(RecommendFragment r10, View r11) {
        B0(r10, r11);
    }

    public static /* synthetic */ void h0(RecommendFragment r10, ONestedScrollView r11, NestedScrollView r12, int r13, int r14, int r15, int r16) {
        m0(r10, r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ void i0(RecommendFragment r10) {
        r10.n0();
    }

    public static final /* synthetic */ void j0(RecommendFragment r10, int r11, OBadgeView r12) {
        r10.J0(r11, r12);
    }

    public static final void l0(RecommendFragment r10, ONestedScrollView r11) {
        q.g(r10, "this$0");
        q.g(r11, "$recommendContainer");
        N0(r10, r11, false, 2, null);
    }

    public static final void m0(RecommendFragment r10, ONestedScrollView r11, NestedScrollView r12, int r13, int r14, int r15, int r16) {
        q.g(r10, "this$0");
        q.g(r11, "$recommendContainer");
        q.g(r12, "<anonymous parameter 0>");
        r10.M0(r11, true);
    }

    private final b0 s0() {
        return r0().w();
    }

    private final void v0() {
        TemplateUILoadMoreAdapter r10 = o0();
        r10.addItemProvider(new HomeCardItemProvider(getPageSource()));
        r10.addItemProvider(new FixedEntranceItemProvider(getPageSource(), new RecommendFragment$initItemProvider$1$1(this)));
        r10.addItemProvider(new HorGridAppsItemProvider(getPageSource()));
    }

    public static final void x0(RecommendFragment r10, com.obric.appstore.network.g r11) {
        q.g(r10, "this$0");
        q.g(r11, "it");
        PerformanceMonitor.end(PerformanceMonitor.Event.COLD_LAUNCH);
        cc.a.f6118j.a().g("userdata_real_show");
        r10.r0().m().n(r10.q0());
    }

    public static final void y0(RecommendFragment r10, Locale r11) {
        q.g(r10, "this$0");
        q.g(r11, "locale");
        j.n("RecommendFragment localeChangeAware " + r11 + TokenParser.SP + r10.getClass().getName());
        ILoadViewModel.s(r10.r0(), true, false, 2, null);
    }

    public static final void z0(RecommendFragment r10, View r11) {
        q.g(r10, "this$0");
        r10.w0(true);
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        k r11 = k.a(r10);
        q.f(r11, "bind(...)");
        ONestedScrollView r12 = r11.f25631d;
        q.f(r12, "recommendContainer");
        k0(r12);
        r11.f25632e.f24683d.getInputView().setFocusable(false);
        ViewCompat.H0(r11.f25632e.f24683d, SearchTransition.TRANSITION_NAME_SEARCH_BAR_IN_MAIN);
        OSearchBar r13 = r11.f25632e.f24683d;
        q.f(r13, "searchbarView");
        View r14 = com.obric.appstore.common.core.ui.view.a.a(r13);
        if (r14 == null) goto L5;
        ViewCompat.H0(r14, SearchTransition.TRANSITION_NAME_SEARCH_BAR_BG_IN_MAIN);
    L5:
        r11.f25632e.f24681b.setOnClickListener(new com.obric.appstore.buss.recommend.d(this));
        r11.f25632e.f24683d.getInputView().setHint(R.string.search_bar_hint);
        this.f10811t = r11;
    }

    @Override // com.obric.appstore.base.e
    public void C(FrameLayout r10) {
        q.g(r10, "container");
        super.C(r10);
        final c0 r11 = c0.c(LayoutInflater.from(getContext()), r10, true);
        ViewGroup.LayoutParams r12 = r11.b().getLayoutParams();
        q.e(r12, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.topMargin = yf.b.b(TypedValue.applyDimension(1, 42, Resources.getSystem().getDisplayMetrics()));
        r13.rightMargin = yf.b.b(TypedValue.applyDimension(1, 52, Resources.getSystem().getDisplayMetrics()));
        AppsManager.f10585a.e().i(getViewLifecycleOwner(), new d(new RecommendFragment$onCreateNotify$1$2(r11, this)));
    }

    public final void C0(View r31) {
        final FragmentActivity r10 = getActivity();
        if (r10 != null) goto L5;
        return;
    L5:
        r31.getLocationInWindow(new int[2]);
        OPopover r11 = ((OPopover.a) new OPopover.a(r10).I(OPopoverEntranceMenuView.Builder.c(OPopoverEntranceMenuView.Builder.c(new OPopoverEntranceMenuView.Builder(r10), Integer.valueOf(R.drawable.oui_icon_setting), null, null, getString(R.string.settings), null, null, false, null, new RecommendFragment$openRightTopMenu$1(this), 246, null), Integer.valueOf(R.drawable.ic_about_app), null, null, getString(R.string.about_app_store), null, null, false, null, new RecommendFragment$openRightTopMenu$2(r10, this), 246, null).d())).b();
        this.f10812u = r11;
        com.obric.oui.popover.v2.g r12 = com.obric.oui.popover.v2.g.f16354a;
        q.d(r11);
        com.obric.oui.popover.v2.g.f(r12, r11, r31, 53, true, 0, false, 0, 0, 240, null);
    }

    @Override // com.obric.appstore.base.e
    public void D(OFloatingTitleBar r10) {
        q.g(r10, "toolBar");
        super.D(r10);
        r10.y();
        r10.setStartTitle(getString(R.string.recommend_title_appstore));
        r10.setMaskBlurRadius(8.0f);
        F0(t0(), r10);
        r10.h(R.drawable.ic_app_manager, -1, new e(this));
        r10.h(R.drawable.oui_app_store_manager_icon, -1, new f(this));
    }

    public final void D0(Observer r10) {
        q.g(r10, "<set-?>");
        this.f10810s = r10;
    }

    public final void E0(boolean r10) {
        s0().g("search_action_visible", Boolean.valueOf(r10));
    }

    public final void F0(boolean r10, OFloatingTitleBar r11) {
        E0(r10);
        if (r10 != this.f10813v) goto L5;
        return;
    L5:
        this.f10813v = r10;
        if (r10 == false) goto L9;
        if (r11 == null) goto L12;
        r11.h(R.drawable.oui_title_bar_search, 0, new i(this));
        return;
    L12:
        return;
    L9:
        if (r11 == null) goto L14;
        r11.z(0);
        return;
    }

    public final void I0(boolean r10) {
        if (r10 == false) goto L4;
        TransitionSet r11 = new TransitionSet();
        Fade r12 = new Fade();
        r12.setInterpolator(new TweenInterpolator(2));
        Token$Duration r13 = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2;
        r12.setDuration(r13.getDuration());
        r11.addTransition(r12);
        setExitTransition(r11);
        TransitionSet r14 = new TransitionSet();
        Fade r15 = new Fade();
        r15.setInterpolator(new TweenInterpolator(1));
        r15.setDuration(r13.getDuration());
        r14.addTransition(r15);
        setReenterTransition(r14);
        return;
    L4:
        setExitTransition(null);
        setReenterTransition(null);
    }

    public final void J0(int r10, OBadgeView r11) {
        if (r10 != 0) goto L5;
    L18:
        r11.setVisibility(8);
        return;
    L5:
        if (s.m(getContext()) == false) goto L18;
        Integer r12 = kotlin.text.n.g(r11.getText().toString());
        if (r12 != null) goto L11;
    L14:
        if (r10 <= 0) goto L16;
        r11.setText(String.valueOf(r10));
        r11.setVisibility(0);
        return;
    L16:
        r11.setVisibility(8);
        return;
    L11:
        if (r12.intValue() != r10) goto L14;
        r11.setVisibility(0);
    }

    public final void K0(boolean r10) {
        s0().g("use_transition", Boolean.valueOf(r10));
    }

    public final boolean L0(ONestedScrollView r10) {
        if (r10.getScrollY() <= yf.b.b(TypedValue.applyDimension(1, 28, Resources.getSystem().getDisplayMetrics()))) goto L6;
        return true;
    L6:
        if (this.f10811t != null) goto L8;
        return false;
    L8:
        OFloatingTitleBar r11 = y();
        if (r11 != null) goto L12;
        return false;
    L12:
        if (r11.getHeight() == 0) goto L31;
        k r12 = this.f10811t;
        k r13 = null;
        if (r12 != null) goto L17;
        q.y("bind");
        r12 = null;
    L17:
        if (r12.f25632e.b().getHeight() == 0) goto L31;
        int[] r14 = new int[2];
        int[] r15 = new int[2];
        r11.getLocationOnScreen(r14);
        k r16 = this.f10811t;
        if (r16 != null) goto L22;
        q.y("bind");
        r16 = null;
    L22:
        r16.f25632e.b().getLocationOnScreen(r15);
        int r17 = r14[1] + r11.getHeight();
        int r18 = r15[1];
        k r19 = this.f10811t;
        if (r19 != null) goto L25;
        q.y("bind");
    L27:
        if ((r18 + r13.f25632e.b().getHeight()) > r17) goto L30;
        return true;
    L30:
        return false;
    L25:
        r13 = r19;
    L31:
        return false;
    }

    public final void M0(ONestedScrollView r10, boolean r11) {
        if (L0(r10) == true) goto L9;
        if (r11 == false) goto L6;
    L8:
        boolean r12 = false;
    L10:
        G0(this, r12, null, 2, null);
        return;
    L6:
        if (t0() == false) goto L8;
    L9:
        r12 = true;
        goto L10
    }

    @Override // com.obric.appstore.base.BaseFragment
    public com.obric.appstore.util.s P(View r10) {
        q.g(r10, ServerElements.CONTENT);
        return super.P(ViewExtKt.findView(r10, R.id.page_status));
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return o0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ ILoadViewModel X() {
        return p0();
    }

    public final void k0(final ONestedScrollView r10) {
        q.f(androidx.core.view.j.a(r10, new b(r10, this, r10)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        r10.post(new g(this, r10));
        r10.setOnScrollChangeListener(new h(this, r10));
    }

    public final void n0() {
        OPopover r10 = this.f10812u;
        if (r10 == null) goto L5;
        r10.dismiss();
    L5:
        this.f10812u = null;
    }

    public TemplateUILoadMoreAdapter o0() {
        return this.f10808q;
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        cc.a.C0070a r11 = cc.a.f6118j;
        r11.a().h("home_fragment_create");
        super.onCreate(r10);
        m.a("appstore_page_show", AnonymousClass1.INSTANCE);
        v0();
        D0(new com.obric.appstore.buss.recommend.b(this));
        r0().m().i(this, q0());
        PrivacyChecker.f9899a.a(this);
        LocaleChangeAwareKt.a(this, new com.obric.appstore.buss.recommend.c(this));
        r11.a().g("home_fragment_create");
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PrivacyChecker.f9899a.c(this);
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r10) {
        super.onHiddenChanged(r10);
        if (r10 == true) goto L6;
        m.a("appstore_page_show", C04441.INSTANCE);
        return;
    }

    @Override // com.bytedanceos.common.privacy.PrivacyChecker.Observer
    public void onPrivacyAgreed() {
        cc.a.f6118j.a().h("userdata_real_show");
        ILoadViewModel.s(r0(), false, false, 3, null);
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        cc.a.C0070a r12 = cc.a.f6118j;
        r12.a().h("home_fragment_create_view");
        super.onViewCreated(r10, r11);
        postponeEnterTransition();
        I0(u0());
        startPostponedEnterTransition();
        r12.a().g("home_fragment_create_view");
        RecyclerView r13 = Y();
        if (r13 == null) goto L6;
        dc.b.a("appstore_recommend_listview", r13, true, new c());
        return;
    }

    public RecommendVM p0() {
        return r0();
    }

    public final Observer q0() {
        Observer r10 = this.f10810s;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("observer");
        return null;
    }

    public final RecommendVM r0() {
        return (RecommendVM) this.f10809r.getValue();
    }

    public final boolean t0() {
        Boolean r10 = (Boolean) s0().c("search_action_visible");
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.booleanValue();
    }

    @Override // com.obric.appstore.base.e
    public boolean u() {
        return this.f10807p;
    }

    public final boolean u0() {
        Boolean r10 = (Boolean) s0().c("use_transition");
        if (r10 != null) goto L7;
        return true;
    L7:
        return r10.booleanValue();
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.e
    public int w() {
        return this.f10806o;
    }

    public final void w0(boolean r10) {
        K0(r10);
        I0(r10);
        List r11 = kotlin.collections.s.c();
        if (r10 == false) goto L13;
        k r12 = this.f10811t;
        if (r12 != null) goto L7;
        q.y("bind");
        r12 = null;
    L7:
        r11.add(kotlin.d.a(r12.f25632e.f24683d, SearchTransition.TRANSITION_NAME_SEARCH_BAR_IN_SEARCH));
        k r13 = this.f10811t;
        if (r13 != null) goto L10;
        q.y("bind");
        r13 = null;
    L10:
        OSearchBar r14 = r13.f25632e.f24683d;
        q.f(r14, "searchbarView");
        View r15 = com.obric.appstore.common.core.ui.view.a.a(r14);
        if (r15 == null) goto L13;
        r11.add(kotlin.d.a(r15, SearchTransition.TRANSITION_NAME_SEARCH_BAR_BG_IN_SEARCH));
    L13:
        int r16 = 0;
        Pair[] r17 = (Pair[]) kotlin.collections.s.a(r11).toArray(new Pair[0]);
        FragmentManager r18 = getParentFragmentManager();
        q.f(r18, "getParentFragmentManager(...)");
        FragmentTransaction r19 = r18.o();
        q.f(r19, "beginTransaction()");
        r19.z(true);
        if (r10 == false) goto L18;
        int r20 = r17.length;
    L16:
        if (r16 >= r20) goto L18;
        Pair r21 = r17[r16];
        r19.g((View) r21.getFirst(), (String) r21.getSecond());
        r16 = r16 + 1;
    L18:
        r19.r(this);
        Bundle r22 = new Bundle();
        if (r10 == false) goto L21;
        r22.putBoolean("transition_slide", true);
        r22.putInt("transition_cancel_btn_scene", 1);
    L21:
        q.f(r19.c(R.id.nav_host_fragment, SearchContainerFragment.class, r22, null), "add(containerViewId, F::class.java, args, tag)");
        r19.h("SearchContainerFragment");
        r19.j();
    }
}
