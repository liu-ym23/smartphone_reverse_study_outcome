package com.obric.appstore.buss.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.s;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.WebParam;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.privacy.PrivacyChecker;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.WebActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.buss.search.transition.SearchTransition;
import com.obric.appstore.common.core.ui.view.AppItemViewStyle;
import com.obric.appstore.common.core.ui.view.AppStatusBtnStyle;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.smt.obric.appstore.ui.app.AppStatusViewModel;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001VB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\u0007*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J!\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\u0004R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020#068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR$\u0010L\u001a\u00020#2\u0006\u0010H\u001a\u00020#8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bI\u0010%\"\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0006\u0012\u0002\b\u00030M8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lcom/obric/appstore/buss/detail/AppDetailFragment;", "Lcom/obric/appstore/base/BaseFragment;", "Lcom/bytedanceos/common/privacy/PrivacyChecker$Observer;", "<init>", "()V", "Lcom/bytedanceos/common/model/AppInfo;", "req", "", "i0", "(Lcom/bytedanceos/common/model/AppInfo;)V", "Lcom/obric/oui/paneltitlebar/OPanelTitleBar;", "Landroid/view/View;", "actionView", "j0", "(Lcom/obric/oui/paneltitlebar/OPanelTitleBar;Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onDestroy", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", FixCard.FixStyle.KEY_X, "()Landroid/os/Bundle;", "N", "Lcom/obric/oui/status/OPageStatus;", "retry", "S", "(Lcom/obric/oui/status/OPageStatus;)V", "onDestroyView", "", "L", "()Z", "onPrivacyAgreed", "Lcom/obric/appstore/buss/detail/AppDetailVM;", "k", "Lkotlin/Lazy;", "e0", "()Lcom/obric/appstore/buss/detail/AppDetailVM;", "appDetailVM", "Lcom/smt/obric/appstore/ui/app/AppStatusViewModel;", "l", "f0", "()Lcom/smt/obric/appstore/ui/app/AppStatusViewModel;", "appStatusVM", "Lsa/p;", "m", "Lsa/p;", "detailBinding", "Lcom/obric/appstore/util/f;", "n", "Lcom/obric/appstore/util/f;", "mDisableScrollSelect", "o", "Lcom/bytedanceos/common/model/AppInfo;", "argAppInfo", "p", "Z", "argDoInstall", "Lkotlinx/coroutines/Job;", "q", "Lkotlinx/coroutines/Job;", "jobHandleInstall", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "r", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "searchScene2", CommonKey.KEY_VALUE, "g0", "p0", "(Z)V", "doInstallHandled", "Lcom/obric/appstore/base/k;", "h0", "()Lcom/obric/appstore/base/k;", "vm", "", "w", "()I", "layoutId", "s", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDetailFragment.kt\ncom/obric/appstore/buss/detail/AppDetailFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,573:1\n106#2,15:574\n106#2,15:589\n1#3:604\n260#4:605\n260#4:606\n*S KotlinDebug\n*F\n+ 1 AppDetailFragment.kt\ncom/obric/appstore/buss/detail/AppDetailFragment\n*L\n73#1:574,15\n79#1:589,15\n204#1:605\n206#1:606\n*E\n"})
public final class AppDetailFragment extends BaseFragment implements PrivacyChecker.Observer {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f10612s = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f10613k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f10614l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public sa.p f10615m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.obric.appstore.util.f f10616n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AppInfo f10617o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f10618p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Job f10619q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SearchTransition.b f10620r;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Bundle a(AppInfo r10, boolean r11) {
            q.g(r10, "appInfo");
            Bundle r12 = new Bundle();
            r12.putSerializable("original_data", r10);
            r12.putBoolean("original_do_install", r11);
            return r12;
        }

        public a() {
        }
    }

    public static final class b implements OTabSegmentedLayout.TabSelectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppDetailFragment f10621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sa.p f10622b;

        public b(AppDetailFragment r10, sa.p r11) {
            this.f10621a = r10;
            this.f10622b = r11;
        }

        @Override // com.obric.oui.segmentedtab.OTabSegmentedLayout.TabSelectListener
        public void onReselect(int r10) {
        }

        @Override // com.obric.oui.segmentedtab.OTabSegmentedLayout.TabSelectListener
        public void onSelect(int r10) {
            AppDetailFragment.b0(this.f10621a).d(Boolean.TRUE);
            LinearLayout r11 = this.f10622b.f24652q.b();
            q.f(r11, "getRoot(...)");
            if (r11.getVisibility() == 0) goto L5;
        L7:
            LinearLayout r12 = this.f10622b.f24659x.b();
            q.f(r12, "getRoot(...)");
            if (r12.getVisibility() == 0) goto L10;
        L12:
            this.f10622b.f24649n.smoothScrollTo(0, 0);
            return;
        L10:
            if (r10 != 1) goto L12;
            sa.p r13 = this.f10622b;
            r13.f24649n.smoothScrollTo(0, r13.f24659x.b().getTop());
            return;
        L5:
            if (r10 != 2) goto L7;
            sa.p r14 = this.f10622b;
            r14.f24649n.smoothScrollTo(0, r14.f24652q.b().getTop());
        }
    }

    public static final class c implements AppBarLayout.OnOffsetChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sa.p f10624b;

        public c(sa.p r10) {
            this.f10624b = r10;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout r10, int r11) {
            if (this.f10623a != r11) goto L5;
            return;
        L5:
            this.f10623a = r11;
            defpackage.a r12 = defpackage.a.f1a;
            sa.p r13 = this.f10624b;
            q.f(r13, "$this_apply");
            r12.a(r11, r13);
        }
    }

    static {
        f10612s = new a(null);
    }

    public AppDetailFragment() {
        final Function0<Fragment> r10 = new AppDetailFragment$special$$inlined$viewModels$default$1(this);
        LazyThreadSafetyMode r11 = LazyThreadSafetyMode.NONE;
        final Lazy r12 = kotlin.b.a(r11, new AppDetailFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r13 = null;
        this.f10613k = FragmentViewModelLazyKt.c(this, u.b(AppDetailVM.class), new AppDetailFragment$special$$inlined$viewModels$default$3(r12), new AppDetailFragment$special$$inlined$viewModels$default$4(r13, r12), new AppDetailFragment$special$$inlined$viewModels$default$5(this, r12));
        Function0<ViewModelProvider.Factory> r14 = new AppDetailFragment$appStatusVM$2(this);
        final Function0<Fragment> r15 = new AppDetailFragment$special$$inlined$viewModels$default$6(this);
        final Lazy r16 = kotlin.b.a(r11, new AppDetailFragment$special$$inlined$viewModels$default$7(r15));
        this.f10614l = FragmentViewModelLazyKt.c(this, u.b(AppStatusViewModel.class), new AppDetailFragment$special$$inlined$viewModels$default$8(r16), new AppDetailFragment$special$$inlined$viewModels$default$9(r13, r16), r14);
        this.f10616n = new com.obric.appstore.util.f(500);
        this.f10620r = new SearchTransition.b();
    }

    public static /* synthetic */ void U(AppDetailFragment r10, View r11) {
        m0(r10, r11);
    }

    public static /* synthetic */ void V(AppDetailFragment r10, sa.p r11, View r12, int r13, int r14, int r15, int r16) {
        n0(r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void W(AppDetailFragment r10, sa.p r11, View r12) {
        l0(r10, r11, r12);
    }

    public static /* synthetic */ void X(AppDetailFragment r10, View r11) {
        o0(r10, r11);
    }

    public static /* synthetic */ void Y(OPanelTitleBar r10, TextView r11, int r12) {
        k0(r10, r11, r12);
    }

    public static final /* synthetic */ AppDetailVM Z(AppDetailFragment r10) {
        return r10.e0();
    }

    public static final /* synthetic */ AppStatusViewModel a0(AppDetailFragment r10) {
        return r10.f0();
    }

    public static final /* synthetic */ com.obric.appstore.util.f b0(AppDetailFragment r10) {
        return r10.f10616n;
    }

    public static final /* synthetic */ void c0(AppDetailFragment r10, OPanelTitleBar r11, View r12) {
        r10.j0(r11, r12);
    }

    public static final /* synthetic */ void d0(AppDetailFragment r10, boolean r11) {
        r10.p0(r11);
    }

    private final AppStatusViewModel f0() {
        return (AppStatusViewModel) this.f10614l.getValue();
    }

    public static final void k0(OPanelTitleBar r10, TextView r11, int r12) {
        q.g(r10, "$this_limitTitleMaxWidthWithAction");
        q.g(r11, "$titleView");
        int r13 = (int) (((r10.getWidth() - r11.getLeft()) - r12) - tc.f.g(16.0f));
        if (r13 <= 0) goto L6;
        r11.setMaxWidth(r13);
        return;
    }

    public static final void l0(AppDetailFragment r10, sa.p r11, View r12) {
        q.g(r10, "this$0");
        q.g(r11, "$this_apply");
        FragmentActivity r13 = r10.getActivity();
        if (r13 != null) goto L5;
        return;
    L5:
        com.obric.appstore.buss.detail.a r14 = (com.obric.appstore.buss.detail.a) r10.e0().k().e();
        if (r14 == null) goto L16;
        AppInfo r15 = r14.a();
        if (r15 == null) goto L17;
        String r16 = r15.privacyAgreementUrl;
        if (r16 != null) goto L14;
        com.bytedanceos.common.toolbox.j.n("AppDetailFragment privacyAgreementUrl is null");
        return;
    L14:
        WebParam r17 = new WebParam();
        r17.setTitle(r10.getString(R.string.title_privacy_agreement));
        Unit r18 = Unit.f21064a;
        WebActivity.start(r13, r16, r17);
        return;
    L17:
        return;
    }

    public static final void m0(AppDetailFragment r10, View r11) {
        q.g(r10, "this$0");
        FragmentActivity r12 = r10.getActivity();
        if (r12 != null) goto L5;
        return;
    L5:
        com.obric.appstore.buss.detail.a r13 = (com.obric.appstore.buss.detail.a) r10.e0().k().e();
        if (r13 == null) goto L12;
        AppInfo r14 = r13.a();
        if (r14 == null) goto L13;
        com.obric.appstore.util.n.f11086a.i(r12, r14);
        return;
    L13:
        return;
    }

    public static final void n0(AppDetailFragment r10, sa.p r11, View r12, int r13, int r14, int r15, int r16) {
        q.g(r10, "this$0");
        q.g(r11, "$this_apply");
        if (q.b(r10.f10616n.b(), Boolean.TRUE) == false) goto L5;
        return;
    L5:
        LinearLayout r17 = r11.f24652q.b();
        q.f(r17, "getRoot(...)");
        if (r17.getVisibility() == 0) goto L8;
    L12:
        LinearLayout r18 = r11.f24659x.b();
        q.f(r18, "getRoot(...)");
        if (r18.getVisibility() == 0) goto L15;
    L17:
        int r19 = 0;
    L19:
        if (r11.f24650o.getTabCount() <= 0) goto L22;
        OTabSegmentedLayout r20 = r11.f24650o;
        r20.setCurrentTab(Math.min(r19, r20.getTabCount() - 1));
        return;
    L22:
        return;
    L15:
        if (r14 < r11.f24659x.b().getTop()) goto L17;
        r19 = 1;
        goto L19
    L8:
        if (r14 >= r11.f24652q.b().getTop()) goto L11;
        ONestedScrollView r21 = r11.f24649n;
        q.f(r21, "appinfoScrollview");
        if (n.a(r21) == false) goto L12;
    L11:
        r19 = 2;
        goto L19
    }

    public static final void o0(AppDetailFragment r10, View r11) {
        q.g(r10, "this$0");
        FragmentActivity r12 = r10.getActivity();
        if (r12 != null) goto L5;
        return;
    L5:
        com.obric.appstore.buss.detail.a r13 = (com.obric.appstore.buss.detail.a) r10.e0().k().e();
        if (r13 == null) goto L12;
        AppInfo r14 = r13.a();
        if (r14 == null) goto L13;
        l8.a.a(r12, r11, r14, r10.getPageSource());
        return;
    L13:
        return;
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        final sa.p r11 = sa.p.a(r10);
        NetworkImageView r12 = r11.f24641f;
        int r13 = R.drawable.oui_default_app_icon;
        r12.setErrorImageResId(r13);
        r11.f24641f.setDefaultImageResId(r13);
        r11.f24642g.p(AppItemViewStyle.APP_INFO);
        ObricAppItemView r14 = r11.f24642g;
        q.f(r14, "appInfoItem");
        o.d(r14);
        r11.f24642g.showLine(false);
        r11.f24650o.setOnTabSelectListener(new b(this, r11));
        ONestedScrollView r15 = r11.f24649n;
        q.f(r15, "appinfoScrollview");
        u8.c.c(r15, AppDetailFragment$onCreateContentView$binding$1$2.INSTANCE);
        r11.f24649n.setOnScrollChangeListener(new com.obric.appstore.buss.detail.b(this, r11));
        r11.f24646k.v(AppStatusBtnStyle.DETAIL);
        r11.f24646k.setOnClickListener(new com.obric.appstore.buss.detail.c(this));
        r11.f24647l.addOnOffsetChangedListener(new c(r11));
        r11.A.setOnClickListener(new d(this, r11));
        r11.f24661z.setOnClickListener(new e(this));
        this.f10615m = r11;
        q.f(r11, "apply(...)");
        e0().k().i(getViewLifecycleOwner(), new n.a(new AppDetailFragment$onCreateContentView$1(this, r11)));
        e0().v().i(getViewLifecycleOwner(), new n.a(new AppDetailFragment$onCreateContentView$2(r11)));
        AppInfo r16 = this.f10617o;
        if (r16 != null) goto L5;
        return;
    L5:
        i0(r16);
    }

    @Override // com.obric.appstore.base.BaseFragment
    public /* bridge */ /* synthetic */ ILoadViewModel K() {
        return h0();
    }

    @Override // com.obric.appstore.base.BaseFragment
    public boolean L() {
        com.obric.appstore.buss.detail.a r10 = (com.obric.appstore.buss.detail.a) e0().k().e();
        if (r10 == null) goto L5;
        AppInfo r11 = r10.a();
    L6:
        if (r11 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.obric.appstore.base.BaseFragment
    public void N() {
        super.N();
        e0().m().i(getViewLifecycleOwner(), new n.a(new AppDetailFragment$observeState$1(this)));
    }

    @Override // com.obric.appstore.base.BaseFragment
    public void S(OPageStatus r10) {
        q.g(r10, "retry");
        com.obric.appstore.network.g r11 = (com.obric.appstore.network.g) e0().m().e();
        if (r11 != null) goto L5;
    L7:
        super.S(r10);
        return;
    L5:
        if (com.obric.appstore.network.h.b(r11) != true) goto L7;
    }

    public final AppDetailVM e0() {
        return (AppDetailVM) this.f10613k.getValue();
    }

    public final boolean g0() {
        return requireArguments().getBoolean("do_install_handled", false);
    }

    public com.obric.appstore.base.k h0() {
        return e0();
    }

    public final void i0(AppInfo r10) {
        if (this.f10618p == true) goto L5;
        return;
    L5:
        if (g0() == true) goto L15;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppDetailFragment] handle install req start, argAppInfo = " + com.bytedanceos.common.d.a(r10));
        Job r11 = this.f10619q;
        if (r11 != null) goto L9;
    L12:
        this.f10619q = kotlinx.coroutines.h.d(s.a(this), null, null, new AppDetailFragment$handleInstallReq$1(this, r10, null), 3, null);
        return;
    L9:
        if (r11.isActive() != true) goto L12;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppDetailFragment] handle install req: skip, jobHandleInstall is active, argAppInfo = " + com.bytedanceos.common.d.a(r10));
        return;
    }

    public final void j0(final OPanelTitleBar r10, View r11) {
        r11.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        final int r12 = r11.getMeasuredWidth();
        final TextView r13 = (TextView) r10.findViewById(R.id.panel_title);
        if (r13 != null) goto L5;
        return;
    L5:
        r10.post(new f(r10, r13, r12));
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        Bundle r11 = requireArguments();
        q.f(r11, "requireArguments(...)");
        Object r12 = null;
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L6
        Serializable r14 = r11.getSerializable("original_data");     // Catch: Throwable -> L6
        if ((r14 instanceof AppInfo) == false) goto L8;
        AppInfo r15 = (AppInfo) r14;     // Catch: Throwable -> L6
    L9:
        Object r16 = Result.m35constructorimpl(r15);     // Catch: Throwable -> L6
    L13:
        if (Result.m41isFailureimpl(r16) == false) goto L15;
        r16 = null;
    L15:
        AppInfo r17 = (AppInfo) r16;
        this.f10617o = r17;
        boolean r18 = false;
        Object r19 = Result.m35constructorimpl(Boolean.valueOf(r11.getBoolean("original_do_install", false)));     // Catch: Throwable -> L18
    L21:
        if (Result.m41isFailureimpl(r19) == true) goto L24;
        r12 = r19;
    L24:
        Boolean r20 = (Boolean) r12;
        if (r20 == null) goto L27;
        r18 = r20.booleanValue();
    L27:
        this.f10618p = r18;
        if (r17 != null) goto L31;
        requireActivity().finish();
        return;
    L31:
        e0().w(r17);
        PrivacyChecker.f9899a.a(this);
        return;
    L18:
        th = move-exception;
        Result.a r21 = Result.Companion;
        r19 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L21
    L8:
        r15 = null;
    L6:
        th = move-exception;
        Result.a r22 = Result.Companion;
        r16 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L13
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PrivacyChecker.f9899a.c(this);
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10615m = null;
    }

    @Override // com.bytedanceos.common.privacy.PrivacyChecker.Observer
    public void onPrivacyAgreed() {
        ILoadViewModel.s(e0(), false, false, 3, null);
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.obric.appstore.util.m.a("appstore_page_show", AnonymousClass1.INSTANCE);
    }

    @Override // com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        OFloatingTitleBar r12 = y();
        if (r12 == null) goto L6;
        m(r12);
        r12.setMaskBlurRadius(8.0f);
        this.f10620r.a(r12);
        return;
    }

    public final void p0(boolean r10) {
        requireArguments().putBoolean("do_install_handled", r10);
    }

    @Override // com.obric.appstore.base.e
    public int w() {
        return R.layout.obric_fragment_app_detail;
    }

    @Override // com.obric.appstore.base.e
    public Bundle x() {
        SearchTransition.b r10 = this.f10620r;
        FragmentActivity r11 = getActivity();
        if (r11 != null) goto L7;
        return null;
    L7:
        return r10.b(r11);
    }
}
