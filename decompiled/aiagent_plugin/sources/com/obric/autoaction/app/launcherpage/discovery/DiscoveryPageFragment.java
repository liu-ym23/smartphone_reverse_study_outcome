package com.obric.autoaction.app.launcherpage.discovery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ap;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.obric.autoaction.app.launcherpage.a.r;
import com.obric.autoaction.app.launcherpage.discovery.view.DiscoveryList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.d;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: DiscoveryPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DiscoveryPageFragment extends Fragment {
    private static final String ARG_GROUP_TITLE = "arg_group_title";
    public static final a Companion = null;
    private r _binding;
    private final f category$delegate;
    private final f viewModel$delegate;

    /* JADX INFO: compiled from: DiscoveryPageFragment.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final DiscoveryPageFragment a(com.obric.autoaction.app.launcherpage.discovery.a.a r5) {
            o.e(r5, "category");
            DiscoveryPageFragment r4 = new DiscoveryPageFragment();
            Bundle r0 = new Bundle();
            String r2 = null;
            if (ZeusTransformUtils.instanceOf(r5, com.obric.autoaction.app.launcherpage.discovery.a.a.b.class) == false) goto L5;
            com.obric.autoaction.app.launcherpage.discovery.a.a.b r6 = (com.obric.autoaction.app.launcherpage.discovery.a.a.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.discovery.a.a.b.class, "com.obric.aiagent.plugin");
        L6:
            if (r6 == null) goto L8;
            r2 = r6.a();
        L8:
            r0.putString(DiscoveryPageFragment.ARG_GROUP_TITLE, r2);
            r4.setArguments(r0);
            return r4;
        L5:
            r6 = null;
            goto L6
        }
    }

    /* JADX INFO: compiled from: DiscoveryPageFragment.kt */
    @d.c.b.a.f(b = "DiscoveryPageFragment.kt", c = {75}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.discovery.DiscoveryPageFragment$onViewCreated$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DiscoveryPageFragment f23565b;

        b(DiscoveryPageFragment r3, d<? super b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f23565b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f23565b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23564a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.x<List<com.obric.autoaction.app.launcherpage.discovery.a.b>> r7 = DiscoveryPageFragment.access$getViewModel(this.f23565b).b();
            final DiscoveryPageFragment r3 = this.f23565b;
            i<? super List<com.obric.autoaction.app.launcherpage.discovery.a.b>> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d<?> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23564a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DiscoveryPageFragment.kt */
    @d.c.b.a.f(b = "DiscoveryPageFragment.kt", c = {82}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.discovery.DiscoveryPageFragment$onViewCreated$2")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DiscoveryPageFragment f23568b;

        c(DiscoveryPageFragment r3, d<? super c> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f23568b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.f23568b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23567a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.x<Integer> r7 = DiscoveryPageFragment.access$getViewModel(this.f23568b).f();
            final DiscoveryPageFragment r3 = this.f23568b;
            i<? super Integer> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d<?> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23567a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$Q-0WhHflfTiboFN3AIWkaU4um-4, reason: not valid java name */
    public static /* synthetic */ com.obric.autoaction.app.launcherpage.discovery.b m494lambda$Q0WhHflfTiboFN3AIWkaU4um4(DiscoveryPageFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ com.obric.autoaction.app.launcherpage.discovery.a.a lambda$rgur7QL5X012uZ1nbE8g8A67tGQ(DiscoveryPageFragment r0) {
        return category_delegate$lambda$2(r0);
    }

    public DiscoveryPageFragment() {
        this.viewModel$delegate = g.a(new $$Lambda$DiscoveryPageFragment$Q0WhHflfTiboFN3AIWkaU4um4(this));
        this.category$delegate = g.a(new $$Lambda$DiscoveryPageFragment$rgur7QL5X012uZ1nbE8g8A67tGQ(this));
    }

    public static final /* synthetic */ r access$getBinding(DiscoveryPageFragment r0) {
        return r0.getBinding();
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.discovery.a.a access$getCategory(DiscoveryPageFragment r0) {
        return r0.getCategory();
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.discovery.b access$getViewModel(DiscoveryPageFragment r0) {
        return r0.getViewModel();
    }

    private final r getBinding() {
        return this._binding;
    }

    private final com.obric.autoaction.app.launcherpage.discovery.b getViewModel() {
        return (com.obric.autoaction.app.launcherpage.discovery.b) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.discovery.b.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autoaction.app.launcherpage.discovery.b viewModel_delegate$lambda$0(DiscoveryPageFragment r3) {
        Fragment r4 = r3.requireParentFragment();
        o.c(r4, "requireParentFragment(...)");
        return (com.obric.autoaction.app.launcherpage.discovery.b) ZeusTransformUtils.preCheckCast(new androidx.lifecycle.am((ap) ZeusTransformUtils.preCheckCast(r4, ap.class, "com.obric.aiagent.plugin")).a(com.obric.autoaction.app.launcherpage.discovery.b.class), com.obric.autoaction.app.launcherpage.discovery.b.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autoaction.app.launcherpage.discovery.a.a getCategory() {
        return (com.obric.autoaction.app.launcherpage.discovery.a.a) ZeusTransformUtils.preCheckCast(this.category$delegate.b(), com.obric.autoaction.app.launcherpage.discovery.a.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autoaction.app.launcherpage.discovery.a.a category_delegate$lambda$2(DiscoveryPageFragment r2) {
        Bundle r3 = r2.getArguments();
        if (r3 == null) goto L8;
        String r4 = r3.getString(ARG_GROUP_TITLE);
        if (r4 == null) goto L8;
        return (com.obric.autoaction.app.launcherpage.discovery.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.discovery.a.a.b(r4), com.obric.autoaction.app.launcherpage.discovery.a.a.class, "com.obric.aiagent.plugin");
    L8:
        return (com.obric.autoaction.app.launcherpage.discovery.a.a) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.discovery.a.a.C0523a.f23571a, com.obric.autoaction.app.launcherpage.discovery.a.a.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        o.e(r1, "inflater");
        r r4 = r.a(r1, r2, false);
        o.c(r4, "inflate(...)");
        this._binding = r4;
        DiscoveryList r0 = r4.b();
        o.c(r0, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r9, Bundle r10) {
        o.e(r9, "view");
        super.onViewCreated(r9, r10);
        r r11 = getBinding();
        if (r11 == null) goto L7;
        DiscoveryList r12 = r11.f22855a;
        if (r12 == null) goto L7;
        r12.addControl((com.obric.autoaction.app.launcherpage.discovery.view.b) ZeusTransformUtils.preCheckCast(getViewModel(), com.obric.autoaction.app.launcherpage.discovery.view.b.class, "com.obric.aiagent.plugin"));
    L7:
        r r13 = getBinding();
        if (r13 == null) goto L12;
        DiscoveryList r14 = r13.f22855a;
        if (r14 == null) goto L12;
        r14.applyBottomNavInsetPadding();
    L12:
        p r15 = getViewLifecycleOwner();
        o.c(r15, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a(r15), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        p r16 = getViewLifecycleOwner();
        o.c(r16, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a(r16), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
