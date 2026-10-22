package com.obric.autoaction.app.launcherpage.main;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ab;
import com.obric.autoaction.app.launcherpage.donation.DataDonationTaskListActivity;
import com.obric.autoaction.app.launcherpage.history.TaskHistoryActivity;
import com.obric.autoaction.app.launcherpage.widget.OAutoTipContainer;
import com.obric.autoaction.common.base.BaseFragment;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.p;
import d.n;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: MainFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MainFragment extends BaseFragment {
    private static final String ACTION_ADD_ICON_RESULT = "com.obric.autoaction.action.ADD_LAUNCHER_ICON_RESULT";
    public static final a Companion = null;
    private PluginBroadcastReceiver addIconResultReceiver;
    private final f binding$delegate;
    private View coachmarkAnchor;
    private final f mainViewModel$delegate;
    private com.obric.autoaction.app.launcherpage.main.d tabManager;

    /* JADX INFO: compiled from: MainFragment.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: MainFragment.kt */
    @d.c.b.a.f(b = "MainFragment.kt", c = {80, 82}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.main.MainFragment$onResume$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MainFragment f23958b;

        b(MainFragment r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23958b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23958b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23957a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r8);
        L18:
            com.obric.autoaction.app.launcherpage.utils.a r9 = com.obric.autoaction.app.launcherpage.utils.a.f24463a;
            FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23958b.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r2, "requireActivity(...)");
            r9.a((Activity) ZeusTransformUtils.preCheckCast(r2, Activity.class, "com.obric.aiagent.plugin"), MainFragment.access$getCoachmarkAnchor$p(this.f23958b));
        L20:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r8);
        L14:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L20;
            com.obric.autoaction.app.launcherpage.utils.a.f24463a.b();
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23957a = 2;
            if (ax.a(1000, r10) != r0) goto L18;
            return r0;
        L10:
            o.a(r8);
            com.obric.autoaction.app.launcherpage.utils.a r11 = com.obric.autoaction.app.launcherpage.utils.a.f24463a;
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23958b.requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r3, "requireContext(...)");
            d.c.d<? super Boolean> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23957a = 1;
            r8 = r11.b(r3, r5);
            if (r8 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: MainFragment.kt */
    public static final class c extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MainFragment f23959a;

        c(MainFragment r1) {
            this.f23959a = r1;
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.i("MainMenu", "add launcher icon result received, report event#4");
            com.obric.event.task.base.report.a.b(com.obric.event.task.base.report.a.f32756a, null, null, 3, null);
            MainFragment r2 = this.f23959a;
            if (r5 != null) goto L5;
            return;
        L5:
            MainFragment.access$unregisterAddIconResultReceiver(r2, r5);
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class d extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f23960a;

        public d(Fragment r1) {
            this.f23960a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23960a.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            d.h.b.o.b(r2, "requireActivity()");
            ao r3 = r2.getViewModelStore();
            d.h.b.o.b(r3, "requireActivity().viewModelStore");
            return r3;
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$2WIKQTknSbMM5kTbHeK-bvA2obw, reason: not valid java name */
    public static /* synthetic */ ab m533lambda$2WIKQTknSbMM5kTbHeKbvA2obw(MainFragment r0) {
        return binding_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$4d_334Ry-A2TyqzznJfK6oqXAE0, reason: not valid java name */
    public static /* synthetic */ void m534lambda$4d_334RyA2TyqzznJfK6oqXAE0(MainFragment r0) {
        onViewCreated$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ void lambda$5gQsQ_8G35lvplj6RoZTW2GyXfE(MainFragment r0, int r1, IMainTab r2) {
        onViewCreated$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$D81grPNWJCvedjSJBjg8QSuEsqs(MainFragment r0, View r1) {
        onViewCreated$lambda$6(r0, r1);
    }

    public static /* synthetic */ x lambda$FNXh4d3IRGrIqYafdU2tQLwFWOw(OPopoverEntranceMenuView.a r0, d.h.a.a r1, View r2, int r3) {
        return showMoreMenu$lambda$23$lambda$16(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$KVfRMfTV3i71PTWzrlVuHtMqEN4(OPopoverEntranceMenuView.a r0, DialogInterface r1, int r2) {
        showMoreMenu$lambda$23$lambda$21$lambda$20(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Kh7Xina-VsMNUoYyhLQtVhE8Pro, reason: not valid java name */
    public static /* synthetic */ x m535lambda$Kh7XinaVsMNUoYyhLQtVhE8Pro(MainFragment r0, boolean r1) {
        return onViewCreated$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$LFxRj3DHC8SdrRYYE2OPrXmns-Q, reason: not valid java name */
    public static /* synthetic */ void m536lambda$LFxRj3DHC8SdrRYYE2OPrXmnsQ(MainFragment r0, View r1) {
        onViewCreated$lambda$5(r0, r1);
    }

    public static /* synthetic */ x lambda$WjqAeHt8bwGCJL9XNwQj4saiBQ8(MainFragment r0, boolean r1, OPopoverEntranceMenuView.a r2, d.h.a.a r3) {
        return showMoreMenu$lambda$23(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$XmwCkaJWz_kSmZTwYYKqegVnPJI(MainFragment r0, d.h.a.a r1, View r2, int r3) {
        return showAddTaskMenu$lambda$13$lambda$12(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$gLXV95IKcQY8Tv9M_gevV0JPaGE(MainFragment r0, d.h.a.a r1, View r2, int r3) {
        return showAddTaskMenu$lambda$13$lambda$11(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$j29vuL068b6MfKwc5DpbVHqKEYs(MainFragment r0, String r1, Bundle r2) {
        onCreate$lambda$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$kcrJ5Q6SXfg5zbJ2y7WNkL-U8xw, reason: not valid java name */
    public static /* synthetic */ x m537lambda$kcrJ5Q6SXfg5zbJ2y7WNkLU8xw(MainFragment r0, OPopoverEntranceMenuView.a r1, d.h.a.a r2) {
        return showAddTaskMenu$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$sf2v8WlTjWlCcAW74mIRhzkxz7M(MainFragment r0, View r1) {
        return initTitleBarActionBtn$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ x lambda$v3RrzjpWpNgemC3VX2C9K9_BOG4(OPopoverEntranceMenuView.a r0, MainFragment r1, d.h.a.a r2, View r3, int r4) {
        return showMoreMenu$lambda$23$lambda$18(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$w_KsrOYXZyShdAJ1qm5tb1aU_1s(MainFragment r0, OFloatingTitleBar r1, View r2) {
        initTitleBarActionBtn$lambda$10$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$yslRBAquS_YkUo4LCksMTjZdAsY(OPopoverEntranceMenuView.a r0, MainFragment r1, d.h.a.a r2, View r3, int r4) {
        return showMoreMenu$lambda$23$lambda$21(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$zBgwMfRAYcRuuOUSBvyRN5iFoTo(MainFragment r0, d.h.a.a r1, View r2, int r3) {
        return showMoreMenu$lambda$23$lambda$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$zF8rqTAy0Mrm563jeoxKOzcV2Ak(MainFragment r0, View r1) {
        initTitleBarActionBtn$lambda$10$lambda$7(r0, r1);
    }

    public MainFragment() {
        this.binding$delegate = g.a(new $$Lambda$MainFragment$2WIKQTknSbMM5kTbHeKbvA2obw(this));
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        this.mainViewModel$delegate = r.a(r0, aa.b(com.obric.autoaction.app.launcherpage.main.a.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r0), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    public static final /* synthetic */ View access$getCoachmarkAnchor$p(MainFragment r0) {
        return r0.coachmarkAnchor;
    }

    public static final /* synthetic */ void access$unregisterAddIconResultReceiver(MainFragment r2, Context r3) {
        r2.unregisterAddIconResultReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    private final ab getBinding() {
        return (ab) ZeusTransformUtils.preCheckCast(this.binding$delegate.b(), ab.class, "com.obric.aiagent.plugin");
    }

    private static final ab binding_delegate$lambda$0(MainFragment r1) {
        ab r2 = ab.a(r1.getLayoutInflater());
        d.h.b.o.c(r2, "inflate(...)");
        return r2;
    }

    private final com.obric.autoaction.app.launcherpage.main.a getMainViewModel() {
        return (com.obric.autoaction.app.launcherpage.main.a) ZeusTransformUtils.preCheckCast(this.mainViewModel$delegate.b(), com.obric.autoaction.app.launcherpage.main.a.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        getParentFragmentManager().a("activity_pass_though_params", (androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin"), new $$Lambda$MainFragment$j29vuL068b6MfKwc5DpbVHqKEYs(this));
    }

    private static final void onCreate$lambda$1(MainFragment r1, String r2, Bundle r3) {
        d.h.b.o.e(r2, "<unused var>");
        d.h.b.o.e(r3, "bundle");
        r1.onNewIntentParams(r3);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        d.h.b.o.e(r1, "inflater");
        return (View) ZeusTransformUtils.preCheckCast(getBinding().b(), View.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r7, Bundle r8) {
        d.h.b.o.e(r7, "view");
        super.onViewCreated(r7, r8);
        OBottomNavigationBar r9 = getBinding().f22706a;
        d.h.b.o.c(r9, "bottomTabLayout");
        ViewPager2 r0 = getBinding().f22709d;
        d.h.b.o.c(r0, "viewPager");
        this.tabManager = new com.obric.autoaction.app.launcherpage.main.d(this, r9, r0, new $$Lambda$MainFragment$5gQsQ_8G35lvplj6RoZTW2GyXfE(this));
        initTitleBarActionBtn();
        OAutoTipContainer r10 = getBinding().f22707b;
        d.h.b.o.c(r10, "tipContainer");
        View r1 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin");
        OFloatingTitleBar r2 = getBinding().f22708c;
        d.h.b.o.c(r2, "titleBar");
        com.obric.autoaction.app.launcherpage.utils.p.a(r1, r2, d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), false, 4, null);
        getBinding().f22707b.setVisibilityListener(new $$Lambda$MainFragment$Kh7XinaVsMNUoYyhLQtVhE8Pro(this));
        getBinding().f22707b.getAddIconGuideView().setOnConfirmListener(new $$Lambda$MainFragment$LFxRj3DHC8SdrRYYE2OPrXmnsQ(this));
        getBinding().f22707b.getAddIconGuideView().setOnCancelListener(new $$Lambda$MainFragment$D81grPNWJCvedjSJBjg8QSuEsqs(this));
    }

    private static final void onViewCreated$lambda$2(MainFragment r3, int r4, IMainTab r5) {
        IMainTab r6 = (IMainTab) ZeusTransformUtils.wrapperContextForParams(r5, IMainTab.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "tab");
        r3.getBinding().f22708c.finishFloatingTransitionForUserInteraction();
        OFloatingTitleBar r7 = r3.getBinding().f22708c;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r0, "requireContext(...)");
        r7.setStartTitle(r6.tabConfig(r0).a());
        r3.getBinding().f22708c.showMask(r6.titleBarMaskEnabled());
    }

    private static final x onViewCreated$lambda$4(final MainFragment r2, boolean r3) {
        r2.getMainViewModel().b().b(Boolean.valueOf(r3));
        if (r3 == true) goto L5;
    L7:
        if (r3 == true) goto L9;
    L11:
        r2.getMainViewModel().c().b(0);
    L13:
        return x.f38692a;
    L9:
        if (r2.getBinding().f22707b.getHeight() != 0) goto L11;
        r2.getBinding().f22707b.post(new $$Lambda$MainFragment$4d_334RyA2TyqzznJfK6oqXAE0(r2));
        goto L13
    L5:
        if (r2.getBinding().f22707b.getHeight() == 0) goto L7;
        r2.getMainViewModel().c().b(Integer.valueOf(r2.getBinding().f22707b.getHeight()));
        goto L13
    }

    private static final void onViewCreated$lambda$4$lambda$3(MainFragment r1) {
        r1.getMainViewModel().c().b(Integer.valueOf(r1.getBinding().f22707b.getHeight()));
    }

    private static final void onViewCreated$lambda$5(MainFragment r6, View r7) {
        com.obric.event.task.base.report.a.a(com.obric.event.task.base.report.a.f32756a, "confirm", null, 2, null);
        com.obric.autoaction.app.launcherpage.utils.e r8 = com.obric.autoaction.app.launcherpage.utils.e.f24474a;
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r0, "requireActivity(...)");
        r8.a((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin"), r6.buildAddIconResultCallback());
        com.obric.autoaction.app.launcherpage.utils.a.f24463a.c();
        OAutoTipContainer.dismissWithAnimation$default(r6.getBinding().f22707b, 0, null, 2, null);
    }

    private static final void onViewCreated$lambda$6(MainFragment r6, View r7) {
        com.obric.event.task.base.report.a.a(com.obric.event.task.base.report.a.f32756a, "ignore", null, 2, null);
        com.obric.autoaction.app.launcherpage.utils.a.f24463a.c();
        com.obric.autoaction.app.launcherpage.utils.a.f24463a.d();
        OAutoTipContainer.dismissWithAnimation$default(r6.getBinding().f22707b, 0, null, 2, null);
    }

    private final void onNewIntentParams(Bundle r3) {
        String r0 = r3.getString("tab_tag");
        if (r0 == null) goto L11;
        Bundle r4 = r3.getBundle("tab_args");
        if (r4 != null) goto L7;
        r4 = new Bundle();
    L7:
        com.obric.autoaction.app.launcherpage.main.d r2 = this.tabManager;
        if (r2 == null) goto L12;
        r2.a(r0, r4);
        return;
    L12:
        return;
    }

    private final void initTitleBarActionBtn() {
        final OFloatingTitleBar r0 = getBinding().f22708c;
        OFloatingTitleBar.removeAllEndAction$default(r0, false, 1, null);
        r0.setEndButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        OFloatingTitleBar.addEndAction$default(r0, ZeusTransformUtils.mapRes(R.drawable.ic_add_task, "drawable", "ic_add_task"), 0, new $$Lambda$MainFragment$zF8rqTAy0Mrm563jeoxKOzcV2Ak(this), 2, null);
        View r1 = OFloatingTitleBar.addEndAction$default(r0, ZeusTransformUtils.mapRes(R.drawable.main_fragment_more_menu, "drawable", "main_fragment_more_menu"), 0, new $$Lambda$MainFragment$w_KsrOYXZyShdAJ1qm5tb1aU_1s(this, r0), 2, null);
        this.coachmarkAnchor = r1;
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r1.setOnLongClickListener(new $$Lambda$MainFragment$sf2v8WlTjWlCcAW74mIRhzkxz7M(this));
    L5:
        d.h.b.o.a(r0);
        com.obric.autoaction.app.launcherpage.b.c.a(r0);
    }

    private static final void initTitleBarActionBtn$lambda$10$lambda$7(MainFragment r0, View r1) {
        r0.showAddTaskMenu();
    }

    private static final void initTitleBarActionBtn$lambda$10$lambda$8(MainFragment r2, OFloatingTitleBar r3, View r4) {
        com.obric.autoaction.app.launcherpage.donation.c r5 = com.obric.autoaction.app.launcherpage.donation.c.f23730a;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r6, "getContext(...)");
        r2.showMoreMenu(r5.a(r6));
    }

    private static final boolean initTitleBarActionBtn$lambda$10$lambda$9(MainFragment r3, View r4) {
        ZeusTransformUtils.startActivity(r3, new Intent((Context) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.forName("com.obric.autoaction.DebugActivity", "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin");
        return true;
    }

    public final OFloatingTitleBar getFloatingTitleBar() {
        if (getView() != null) goto L7;
        return null;
    L7:
        return getBinding().f22708c;
    }

    private final void showAddTaskMenu() {
        com.obric.autoaction.app.launcherpage.module.a.h r0 = com.obric.autoaction.app.launcherpage.module.a.h.f24077a;
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "requireActivity(...)");
        com.obric.autoaction.app.launcherpage.module.a.h.a(r0, (Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(getBinding().f22708c.getEndButtonGroup(), View.class, "com.obric.aiagent.plugin"), 53, null, new $$Lambda$MainFragment$kcrJ5Q6SXfg5zbJ2y7WNkLU8xw(this), 8, null);
    }

    private static final x showAddTaskMenu$lambda$13(final MainFragment r19, OPopoverEntranceMenuView.a r20, d.h.a.a r21) {
        final d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r20, "$this$showPopup");
        d.h.b.o.e(r1, "dismiss");
        OPopoverEntranceMenuView.a.a(r20, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.o_ic_arrow_up_right_circle_dark, "drawable", "o_ic_arrow_up_right_circle_dark")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.main_menu_create_shortcut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_create_shortcut")), CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$MainFragment$gLXV95IKcQY8Tv9M_gevV0JPaGE(r19, r1), 246, null);
        OPopoverEntranceMenuView.a.a(r20, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oic_text_a_circle_dark, "drawable", "oic_text_a_circle_dark")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.main_menu_create_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_create_task")), CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$MainFragment$XmwCkaJWz_kSmZTwYYKqegVnPJI(r19, r1), 246, null);
        return x.f38692a;
    }

    private static final x showAddTaskMenu$lambda$13$lambda$11(MainFragment r9, d.h.a.a r10, View r11, int r12) {
        d.h.a.a r13 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "v");
        com.obric.autoaction.app.launcherpage.detail.shortcut.a r1 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.f23480a;
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "requireActivity(...)");
        com.obric.autoaction.app.launcherpage.detail.shortcut.a.a(r1, r2, "enter_from_auto_right_btn", null, null, false, 28, null);
        r13.invoke();
        return x.f38692a;
    }

    private static final x showAddTaskMenu$lambda$13$lambda$12(MainFragment r7, d.h.a.a r8, View r9, int r10) {
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "v");
        com.obric.autoaction.app.launcherpage.detail.condition.a r1 = com.obric.autoaction.app.launcherpage.detail.condition.a.f23400a;
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "requireActivity(...)");
        com.obric.autoaction.app.launcherpage.detail.condition.a.a(r1, r2, "enter_from_auto_right_btn", null, 4, null);
        r11.invoke();
        return x.f38692a;
    }

    private final void showMoreMenu(final boolean r9) {
        com.obric.autoaction.app.launcherpage.module.a.h r0 = com.obric.autoaction.app.launcherpage.module.a.h.f24077a;
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "requireActivity(...)");
        com.obric.autoaction.app.launcherpage.module.a.h.a(r0, (Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(getBinding().f22708c.getEndButtonGroup(), View.class, "com.obric.aiagent.plugin"), 53, null, new $$Lambda$MainFragment$WjqAeHt8bwGCJL9XNwQj4saiBQ8(this, r9), 8, null);
    }

    private static final x showMoreMenu$lambda$23(final MainFragment r20, boolean r21, final OPopoverEntranceMenuView.a r22, d.h.a.a r23) {
        final d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r22, "$this$showPopup");
        d.h.b.o.e(r15, "dismiss");
        OPopoverEntranceMenuView.a.a(r22, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oic_article, "drawable", "oic_article")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r20.getString(ZeusTransformUtils.mapRes(R.string.main_menu_history, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_history")), CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$MainFragment$zBgwMfRAYcRuuOUSBvyRN5iFoTo(r20, r15), 246, null).a(OPopoverEntranceMenuView.e.f36017a);
        if (r21 == false) goto L5;
        Integer r2 = Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oic_cloud_face, "drawable", "oic_cloud_face"));
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r20.getString(ZeusTransformUtils.mapRes(R.string.main_menu_data_donation, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_data_donation")), CharSequence.class, "com.obric.aiagent.plugin");
        m r10 = new $$Lambda$MainFragment$FNXh4d3IRGrIqYafdU2tQLwFWOw(r22, r15);
        String r19 = "drawable";
        String r13 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        OPopoverEntranceMenuView.a.a(r22, r2, null, null, r5, null, null, false, null, r10, 246, null).a(OPopoverEntranceMenuView.e.f36017a);
    L7:
        if (com.obric.autoaction.app.launcherpage.utils.e.f24474a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L9;
        OPopoverEntranceMenuView.a.a(r22, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oic_phone_desktop, r19, "oic_phone_desktop")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r20.getString(ZeusTransformUtils.mapRes(R.string.main_menu_show_launcher_icon, r13, "main_menu_show_launcher_icon")), CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$MainFragment$v3RrzjpWpNgemC3VX2C9K9_BOG4(r22, r20, r15), 246, null).a(OPopoverEntranceMenuView.e.f36017a);
    L13:
        return x.f38692a;
    L9:
        String r1 = r13;
        if (com.obric.autoaction.app.launcherpage.utils.e.f24474a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L13;
        OPopoverEntranceMenuView.a.a(r22, null, null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r20.getString(ZeusTransformUtils.mapRes(R.string.main_menu_hide_launcher_icon, r1, "main_menu_hide_launcher_icon")), CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$MainFragment$yslRBAquS_YkUo4LCksMTjZdAsY(r22, r20, r15), 247, null).a(OPopoverEntranceMenuView.e.f36017a);
        goto L13
    L5:
        r19 = "drawable";
        r13 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        goto L7
    }

    private static final x showMoreMenu$lambda$23$lambda$14(MainFragment r2, d.h.a.a r3, View r4, int r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "v");
        com.obric.autoaction.app.launcherpage.b.b.f22905a.a((Context) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        ZeusTransformUtils.startActivity((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), new Intent((Context) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), TaskHistoryActivity.class), "com.obric.aiagent.plugin");
        r6.invoke();
        return x.f38692a;
    }

    private static final x showMoreMenu$lambda$23$lambda$16(OPopoverEntranceMenuView.a r2, d.h.a.a r3, View r4, int r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "v");
        Loog.INSTANCE.i("MainMenu", "data donation clicked");
        if (com.obric.autoaction.app.launcherpage.donation.b.f23724a.b() == false) goto L5;
        com.obric.autoaction.app.launcherpage.donation.b.f23724a.c();
    L6:
        r6.invoke();
        return x.f38692a;
    L5:
        DataDonationTaskListActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        goto L6
    }

    private static final x showMoreMenu$lambda$23$lambda$18(OPopoverEntranceMenuView.a r2, MainFragment r3, d.h.a.a r4, View r5, int r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<unused var>");
        Loog.INSTANCE.i("MainMenu", "show icon clicked");
        if (com.obric.autoaction.app.launcherpage.utils.e.f24474a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3.buildAddIconResultCallback()) == false) goto L5;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.main_menu_show_launcher_icon_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_show_launcher_icon_success"), 1).show();
    L5:
        r7.invoke();
        return x.f38692a;
    }

    private static final x showMoreMenu$lambda$23$lambda$21(final OPopoverEntranceMenuView.a r11, MainFragment r12, d.h.a.a r13, View r14, int r15) {
        d.h.a.a r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, "<unused var>");
        Loog.INSTANCE.i("MainMenu", "hide icon clicked");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r2 = r12.getString(ZeusTransformUtils.mapRes(R.string.common_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "common_tips"));
        d.h.b.o.c(r2, "getString(...)");
        String r3 = r12.getString(ZeusTransformUtils.mapRes(R.string.main_menu_hide_launcher_icon_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_hide_launcher_icon_confirm"));
        d.h.b.o.c(r3, "getString(...)");
        com.obric.autoaction.app.launcherpage.utils.p.a(r1, r2, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), r12.getString(ZeusTransformUtils.mapRes(R.string.task_delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete")), null, false, false, new $$Lambda$MainFragment$KVfRMfTV3i71PTWzrlVuHtMqEN4(r11), 112, null);
        r16.invoke();
        return x.f38692a;
    }

    private static final void showMoreMenu$lambda$23$lambda$21$lambda$20(OPopoverEntranceMenuView.a r3, DialogInterface r4, int r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.utils.e.f24474a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.main_menu_hide_launcher_icon_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_hide_launcher_icon_success"), 1).show();
        r6.dismiss();
    }

    private final PendingIntent buildAddIconResultCallback() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r0);
        registerAddIconResultReceiver(r0);
        Intent r3 = new Intent(ACTION_ADD_ICON_RESULT);
        r3.setPackage(r0.getPackageName());
        if (Build.VERSION.SDK_INT < 31) goto L5;
        int r1 = 201326592;
    L6:
        PendingIntent r4 = PendingIntent.getBroadcast(r0, 0, r3, r1);
        d.h.b.o.c(r4, "getBroadcast(...)");
        return r4;
    L5:
        r1 = 134217728;
        goto L6
    }

    private final void registerAddIconResultReceiver(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (this.addIconResultReceiver == null) goto L5;
        return;
    L5:
        c r0 = new c(this);
        this.addIconResultReceiver = (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r0, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin");
        androidx.core.content.a.registerReceiver(r5, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r0, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), new IntentFilter(ACTION_ADD_ICON_RESULT), 4);
    }

    private final void unregisterAddIconResultReceiver(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        PluginBroadcastReceiver r0 = this.addIconResultReceiver;
        if (r0 == null) goto L19;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L7
        MainFragment r3 = (MainFragment) ZeusTransformUtils.preCheckCast(this, MainFragment.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        ZeusTransformUtils.unregisterReceiver(r6, r0, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r7 = n.f(x.f38692a);     // Catch: Throwable -> L7
    L10:
        if (n.a(r7) == false) goto L12;
        x r1 = (x) ZeusTransformUtils.preCheckCast(r7, x.class, "com.obric.aiagent.plugin");
        this.addIconResultReceiver = null;
    L12:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L15;
        Loog.INSTANCE.w("MainMenu", "unregisterAddIconResultReceiver failed", r8);
    L15:
        n.g(r7);
        return;
    L7:
        th = move-exception;
        n.a r9 = n.f38560a;
        r7 = n.f(o.a(th));
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        unregisterAddIconResultReceiver(r0);
        return;
    }
}
