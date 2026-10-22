package com.obric.autoaction.app.launcherpage.discovery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ap;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.q;
import com.obric.autoaction.app.launcherpage.main.LauncherPageBaseTabFragment;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.g;
import d.h.a.m;
import d.h.b.h;
import d.k;
import d.l.n;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: DiscoveryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DiscoveryFragment extends LauncherPageBaseTabFragment {
    public static final a Companion = null;
    private static final int TAB_CONTENT_OVERLAP_DP = 40;
    private static final int TAB_START_INSET_DP = 12;
    private q binding;
    private boolean isUpdatingTabs;
    private int lastTopInset;
    private final e pageChangeCallback;
    private final d.f pagerAdapter$delegate;
    private int tabDesignTopMargin;
    private final d.f viewModel$delegate;

    /* JADX INFO: compiled from: DiscoveryFragment.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: DiscoveryFragment.kt */
    @d.c.b.a.f(b = "DiscoveryFragment.kt", c = {97}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.discovery.DiscoveryFragment$onViewCreated$3")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DiscoveryFragment f23554b;

        b(DiscoveryFragment r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23554b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23554b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23553a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.x<Boolean> r7 = DiscoveryFragment.access$getViewModel(this.f23554b).c();
            final DiscoveryFragment r3 = this.f23554b;
            i<? super Boolean> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23553a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DiscoveryFragment.kt */
    @d.c.b.a.f(b = "DiscoveryFragment.kt", c = {111}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.discovery.DiscoveryFragment$onViewCreated$4")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DiscoveryFragment f23557b;

        c(DiscoveryFragment r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23557b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23557b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23556a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.x<List<com.obric.autoaction.app.launcherpage.discovery.a.a>> r7 = DiscoveryFragment.access$getViewModel(this.f23557b).e();
            final DiscoveryFragment r3 = this.f23557b;
            i<? super List<com.obric.autoaction.app.launcherpage.discovery.a.a>> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23556a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DiscoveryFragment.kt */
    @d.c.b.a.f(b = "DiscoveryFragment.kt", c = {117}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.discovery.DiscoveryFragment$onViewCreated$5")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DiscoveryFragment f23560b;

        d(DiscoveryFragment r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23560b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23560b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23559a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.x<List<com.obric.autoaction.app.launcherpage.discovery.a.b>> r7 = DiscoveryFragment.access$getViewModel(this.f23560b).b();
            final DiscoveryFragment r3 = this.f23560b;
            i<? super List<com.obric.autoaction.app.launcherpage.discovery.a.b>> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23559a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DiscoveryFragment.kt */
    public static final class e extends ViewPager2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DiscoveryFragment f23562a;

        e(DiscoveryFragment r1) {
            this.f23562a = r1;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(int r1, float r2, int r3) {
            q r0 = DiscoveryFragment.access$getBinding$p(this.f23562a);
            if (r0 != null) goto L5;
            d.h.b.o.c("binding");
            r0 = null;
        L5:
            r0.f22851b.setScrollPosition(r1, r2, true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void b(int r3) {
            if (DiscoveryFragment.access$isUpdatingTabs$p(this.f23562a) == false) goto L5;
            return;
        L5:
            DiscoveryFragment.access$setUpdatingTabs$p(this.f23562a, true);
            q r0 = DiscoveryFragment.access$getBinding$p(this.f23562a);
            if (r0 != null) goto L8;
            d.h.b.o.c("binding");
            r0 = null;
        L8:
            r0.f22851b.selectTab(r3);
            DiscoveryFragment.access$setUpdatingTabs$p(this.f23562a, false);
        }
    }

    /* JADX INFO: compiled from: DiscoveryFragment.kt */
    public static final class f implements OTabLayoutBase.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DiscoveryFragment f23563a;

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void b(OTabLayoutBase.e r1) {
            d.h.b.o.e(r1, "tab");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void c(OTabLayoutBase.e r1) {
            d.h.b.o.e(r1, "tab");
        }

        f(DiscoveryFragment r1) {
            this.f23563a = r1;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void a(OTabLayoutBase.e r2) {
            d.h.b.o.e(r2, "tab");
            if (DiscoveryFragment.access$isUpdatingTabs$p(this.f23563a) == false) goto L5;
            return;
        L5:
            q r1 = DiscoveryFragment.access$getBinding$p(this.f23563a);
            if (r1 != null) goto L8;
            d.h.b.o.c("binding");
            r1 = null;
        L8:
            r1.f22852c.setCurrentItem(r2.c(), true);
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-8gtTK-chUi0hTOjYYXvXgkAym8, reason: not valid java name */
    public static /* synthetic */ void m491lambda$8gtTKchUi0hTOjYYXvXgkAym8(DiscoveryFragment r0) {
        updateContentTopPadding$lambda$4(r0);
    }

    /* JADX INFO: renamed from: lambda$F3-4r83Q7N406VHQVoUQkJNBssE, reason: not valid java name */
    public static /* synthetic */ com.obric.autoaction.app.launcherpage.discovery.a m492lambda$F34r83Q7N406VHQVoUQkJNBssE(DiscoveryFragment r0) {
        return pagerAdapter_delegate$lambda$1(r0);
    }

    public static /* synthetic */ com.obric.autoaction.app.launcherpage.discovery.b lambda$_swgOy0vh_E6FUocnav1Afc0dRI(DiscoveryFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$ahFGS6J7mybDYxIZu4bsU5QBH-4, reason: not valid java name */
    public static /* synthetic */ void m493lambda$ahFGS6J7mybDYxIZu4bsU5QBH4(DiscoveryFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        onViewCreated$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ x lambda$xBGZw70LhEX2VPME95aKKpYpe9M(DiscoveryFragment r0) {
        return onViewCreated$lambda$3(r0);
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment
    public String getPageEnterPageName() {
        return "discovery";
    }

    public DiscoveryFragment() {
        this.viewModel$delegate = g.a(new $$Lambda$DiscoveryFragment$_swgOy0vh_E6FUocnav1Afc0dRI(this));
        this.pagerAdapter$delegate = g.a(new $$Lambda$DiscoveryFragment$F34r83Q7N406VHQVoUQkJNBssE(this));
        this.tabDesignTopMargin = -1;
        this.pageChangeCallback = new e(this);
    }

    public static final /* synthetic */ void access$bindCategories(DiscoveryFragment r2, List r3) {
        r2.bindCategories((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ q access$getBinding$p(DiscoveryFragment r0) {
        return r0.binding;
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.discovery.b access$getViewModel(DiscoveryFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ boolean access$isUpdatingTabs$p(DiscoveryFragment r0) {
        return r0.isUpdatingTabs;
    }

    public static final /* synthetic */ void access$reportPageEnterSuccessOnPreDraw(DiscoveryFragment r0, View r1) {
        r0.reportPageEnterSuccessOnPreDraw(r1);
    }

    public static final /* synthetic */ void access$setUpdatingTabs$p(DiscoveryFragment r0, boolean r1) {
        r0.isUpdatingTabs = r1;
    }

    private final com.obric.autoaction.app.launcherpage.discovery.b getViewModel() {
        return (com.obric.autoaction.app.launcherpage.discovery.b) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.discovery.b.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autoaction.app.launcherpage.discovery.b viewModel_delegate$lambda$0(DiscoveryFragment r3) {
        return (com.obric.autoaction.app.launcherpage.discovery.b) ZeusTransformUtils.preCheckCast(new androidx.lifecycle.am((ap) ZeusTransformUtils.preCheckCast(r3, ap.class, "com.obric.aiagent.plugin")).a(com.obric.autoaction.app.launcherpage.discovery.b.class), com.obric.autoaction.app.launcherpage.discovery.b.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autoaction.app.launcherpage.discovery.a getPagerAdapter() {
        return (com.obric.autoaction.app.launcherpage.discovery.a) ZeusTransformUtils.preCheckCast(this.pagerAdapter$delegate.b(), com.obric.autoaction.app.launcherpage.discovery.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autoaction.app.launcherpage.discovery.a pagerAdapter_delegate$lambda$1(DiscoveryFragment r3) {
        FragmentManager r1 = r3.getChildFragmentManager();
        d.h.b.o.c(r1, "getChildFragmentManager(...)");
        androidx.lifecycle.i r4 = r3.getLifecycle();
        d.h.b.o.c(r4, "<get-lifecycle>(...)");
        return new com.obric.autoaction.app.launcherpage.discovery.a(r1, r4);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        d.h.b.o.e(r1, "inflater");
        q r4 = q.a(r1, r2, false);
        d.h.b.o.c(r4, "inflate(...)");
        this.binding = r4;
        if (r4 != null) goto L5;
        d.h.b.o.c("binding");
        r4 = null;
    L5:
        ConstraintLayout r0 = r4.b();
        d.h.b.o.c(r0, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.main.LauncherPageBaseTabFragment
    public void applyTopInset(int r6) {
        q r0 = this.binding;
        if (r0 != null) goto L5;
        return;
    L5:
        this.lastTopInset = r6;
        q r2 = null;
        if (r0 != null) goto L8;
        d.h.b.o.c("binding");
        r0 = null;
    L8:
        ViewGroup.LayoutParams r1 = r0.f22851b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L11;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L12:
        if (r3 != null) goto L15;
        return;
    L15:
        if (this.tabDesignTopMargin >= 0) goto L17;
        this.tabDesignTopMargin = r3.topMargin;
    L17:
        r3.topMargin = r6 + this.tabDesignTopMargin;
        q r5 = this.binding;
        if (r5 != null) goto L20;
        d.h.b.o.c("binding");
    L21:
        r2.f22851b.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        r2 = r5;
        goto L21
    L11:
        r3 = null;
        goto L12
    }

    @Override // com.obric.autoaction.app.launcherpage.main.LauncherPageBaseTabFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r11, Bundle r12) {
        d.h.b.o.e(r11, "view");
        super.onViewCreated(r11, r12);
        getViewModel().g();
        q r13 = this.binding;
        if (r13 != null) goto L5;
        d.h.b.o.c("binding");
        r13 = null;
    L5:
        r13.f22852c.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(getPagerAdapter(), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        q r14 = this.binding;
        if (r14 != null) goto L8;
        d.h.b.o.c("binding");
        r14 = null;
    L8:
        r14.f22850a.addOnLayoutChangeListener(new $$Lambda$DiscoveryFragment$ahFGS6J7mybDYxIZu4bsU5QBH4(this));
        q r15 = this.binding;
        if (r15 != null) goto L11;
        d.h.b.o.c("binding");
        r15 = null;
    L11:
        r15.f22853d.bindRefresh(new $$Lambda$DiscoveryFragment$xBGZw70LhEX2VPME95aKKpYpe9M(this));
        setupTabAndPagerSync();
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(androidx.lifecycle.q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(androidx.lifecycle.q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(androidx.lifecycle.q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private static final void onViewCreated$lambda$2(DiscoveryFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r0.updateContentTopPadding();
    }

    private static final x onViewCreated$lambda$3(DiscoveryFragment r0) {
        r0.getViewModel().h();
        return x.f38692a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        q r0 = this.binding;
        q r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22851b.clearOnTabSelectedListeners();
        q r2 = this.binding;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        r1.f22852c.unregisterOnPageChangeCallback((ViewPager2.e) ZeusTransformUtils.preCheckCast(this.pageChangeCallback, ViewPager2.e.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void updateContentTopPadding() {
        if (getView() != null) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        q r1 = this.binding;
        q r2 = null;
        if (r1 != null) goto L12;
        d.h.b.o.c("binding");
        r1 = null;
    L12:
        if (r1.f22851b.getVisibility() == 0) goto L15;
        getViewModel().f().b(Integer.valueOf(n.c(this.lastTopInset, 0)));
        return;
    L15:
        q r3 = this.binding;
        if (r3 != null) goto L18;
        d.h.b.o.c("binding");
    L19:
        OBlurMaskView r4 = r2.f22850a;
        d.h.b.o.c(r4, "categoryTabBlurMask");
        if (r4.getBottom() > 0) goto L23;
        r4.post(new $$Lambda$DiscoveryFragment$8gtTKchUi0hTOjYYXvXgkAym8(this));
        return;
    L23:
        getViewModel().f().b(Integer.valueOf(n.c(r4.getBottom() - com.obric.oui.common.util.g.a(r0, 40), 0)));
        return;
    L18:
        r2 = r3;
        goto L19
    }

    private static final void updateContentTopPadding$lambda$4(DiscoveryFragment r0) {
        r0.updateContentTopPadding();
    }

    private final void setupTabAndPagerSync() {
        q r0 = this.binding;
        q r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22851b.addOnTabSelectedListener((OTabLayoutBase.d) ZeusTransformUtils.preCheckCast(new f(this), OTabLayoutBase.d.class, "com.obric.aiagent.plugin"));
        q r2 = this.binding;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        r1.f22852c.registerOnPageChangeCallback((ViewPager2.e) ZeusTransformUtils.preCheckCast(this.pageChangeCallback, ViewPager2.e.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void bindCategories(List<? extends com.obric.autoaction.app.launcherpage.discovery.a.a> r9) {
        List<? extends com.obric.autoaction.app.launcherpage.discovery.a.a> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        this.isUpdatingTabs = true;
        q r2 = this.binding;
        q r3 = null;
        if (r2 != null) goto L5;
        d.h.b.o.c("binding");
        r2 = null;
    L5:
        r2.f22851b.removeAllTabs();
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        int r6 = 0;
        if (r4.hasNext() == false) goto L15;
        com.obric.autoaction.app.launcherpage.discovery.a.a r5 = (com.obric.autoaction.app.launcherpage.discovery.a.a) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.autoaction.app.launcherpage.discovery.a.a.class, "com.obric.aiagent.plugin");
        q r7 = this.binding;
        if (r7 != null) goto L11;
        d.h.b.o.c("binding");
        r7 = null;
    L11:
        OTabLayoutBase.e r8 = r7.f22851b.newTab(0).a(categoryTitle(r5));
        d.h.b.o.c(r8, "setText(...)");
        q r11 = this.binding;
        if (r11 != null) goto L14;
        d.h.b.o.c("binding");
        r11 = null;
    L14:
        r11.f22851b.addTab(r8);
        goto L6
    L15:
        this.isUpdatingTabs = false;
        q r1 = this.binding;
        if (r1 != null) goto L18;
        d.h.b.o.c("binding");
    L19:
        OTabLayout r12 = r3.f22851b;
        if (r10.size() > 1) goto L23;
        r6 = 8;
    L23:
        r12.setVisibility(r6);
        applyFirstTabStartInset();
        updateContentTopPadding();
        getPagerAdapter().a(r10);
        return;
    L18:
        r3 = r1;
        goto L19
    }

    private final void applyFirstTabStartInset() {
        q r0 = this.binding;
        ViewGroup.MarginLayoutParams r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        View r2 = r0.f22851b.getTabContainer().getChildAt(0);
        if (r2 != null) goto L8;
        return;
    L8:
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L11;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L11:
        if (r1 != null) goto L13;
        return;
    L13:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "requireContext(...)");
        r1.leftMargin = com.obric.oui.common.util.g.a(r5, 12);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    private final CharSequence categoryTitle(com.obric.autoaction.app.launcherpage.discovery.a.a r4) {
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.discovery.a.a.C0523a.class) == false) goto L6;
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.discovery_category_all, WsChannelMultiProcessSharedProvider.STRING_TYPE, "discovery_category_all"));
        d.h.b.o.c(r3, "getString(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.discovery.a.a.b.class) == false) goto L10;
        return (CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.discovery.a.a.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.discovery.a.a.b.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin");
    L10:
        throw new k();
    }
}
