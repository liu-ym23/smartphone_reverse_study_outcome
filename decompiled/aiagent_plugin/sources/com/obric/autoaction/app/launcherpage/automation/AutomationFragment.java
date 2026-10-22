package com.obric.autoaction.app.launcherpage.automation;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ad;
import com.obric.autoaction.app.launcherpage.main.IMainTab;
import com.obric.autoaction.app.launcherpage.main.LauncherPageBaseTabFragment;
import com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskList;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.oui.button.OButton;
import com.obric.oui.status.OPageStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.p;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: AutomationFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutomationFragment extends LauncherPageBaseTabFragment {
    private ad binding;
    private long createStartTime;
    private String focusTaskId;
    private boolean hasReportedRenderDuration;
    private final d.f managementViewModel$delegate;
    private final d.f tracker$delegate;
    private final d.f viewModel$delegate;

    /* JADX INFO: compiled from: AutomationFragment.kt */
    @d.c.b.a.f(b = "AutomationFragment.kt", c = {85}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.automation.AutomationFragment$onViewCreated$2$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutomationFragment f22894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f22895c;

        a(AutomationFragment r3, List<String> r4, d.c.d<? super a> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22894b = r3;
            this.f22895c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f22894b, this.f22895c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22893a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L15;
            AutomationFragment.access$getViewModel(this.f22894b).c();
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.autoaction.app.launcherpage.module.b r7 = AutomationFragment.access$getViewModel(this.f22894b);
            List<String> r2 = this.f22895c;
            d.c.d<? super Boolean> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22893a = 1;
            r6 = r7.a(r2, r4);
            if (r6 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AutomationFragment.kt */
    @d.c.b.a.f(b = "AutomationFragment.kt", c = {93}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.automation.AutomationFragment$onViewCreated$3")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutomationFragment f22897b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.automation.AutomationFragment$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: AutomationFragment.kt */
        static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AutomationFragment f22898a;

            AnonymousClass1(AutomationFragment r1) {
                this.f22898a = r1;
            }

            public static /* synthetic */ x lambda$pf392BnMjbvXZZp4FMSU_DgznQA(AutomationFragment r0, List r1, List r2) {
                return a(r0, r1, r2);
            }

            @Override // kotlinx.coroutines.b.i
            public /* synthetic */ Object emit(Object r3, d.c.d r4) {
                d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), r5);
            }

            public final Object a(List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r3, d.c.d<? super x> r4) {
                final List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                if (r5 == null) goto L5;
                ad r7 = AutomationFragment.access$getBinding$p(this.f22898a);
                if (r7 != null) goto L9;
                d.h.b.o.c("binding");
                r7 = null;
            L9:
                AutoActionTaskList r8 = r7.f22718c;
                final AutomationFragment r2 = this.f22898a;
                r8.submitData(r5, new $$Lambda$AutomationFragment$b$1$pf392BnMjbvXZZp4FMSU_DgznQA(r2, r5));
                return x.f38692a;
            L5:
                return x.f38692a;
            }

            private static final x a(AutomationFragment r2, List r3, List r4) {
                List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                d.h.b.o.e((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), "it");
                AutomationFragment.access$reportRenderDurationIfNeeded(r2);
                ad r6 = AutomationFragment.access$getBinding$p(r2);
                if (r6 != null) goto L5;
                d.h.b.o.c("binding");
                r6 = null;
            L5:
                AutomationFragment.access$reportPageEnterSuccessOnPreDraw(r2, (View) ZeusTransformUtils.preCheckCast(r6.f22718c, View.class, "com.obric.aiagent.plugin"));
                AutomationFragment.access$focusTask(r2, r5);
                return x.f38692a;
            }
        }

        b(AutomationFragment r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22897b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22897b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22896a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.x<List<com.obric.autoaction.app.launcherpage.module.a.a.f>> r7 = AutomationFragment.access$getViewModel(this.f22897b).b();
            i<? super List<com.obric.autoaction.app.launcherpage.module.a.a.f>> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22897b), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22896a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AutomationFragment.kt */
    @d.c.b.a.f(b = "AutomationFragment.kt", c = {104}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.automation.AutomationFragment$onViewCreated$4")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutomationFragment f22900b;

        c(AutomationFragment r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22900b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f22900b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22899a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            ab<com.obric.autoaction.app.launcherpage.module.a> r7 = AutomationFragment.access$getManagementViewModel(this.f22900b).b();
            final AutomationFragment r3 = this.f22900b;
            i<? super com.obric.autoaction.app.launcherpage.module.a> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22899a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class d extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f22902a;

        public d(Fragment r1) {
            this.f22902a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f22902a.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            d.h.b.o.b(r2, "requireActivity()");
            ao r3 = r2.getViewModelStore();
            d.h.b.o.b(r3, "requireActivity().viewModelStore");
            return r3;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class e extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f22903a;

        public e(Fragment r1) {
            this.f22903a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f22903a.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            d.h.b.o.b(r2, "requireActivity()");
            ao r3 = r2.getViewModelStore();
            d.h.b.o.b(r3, "requireActivity().viewModelStore");
            return r3;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class f extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f22904a;

        public f(Fragment r1) {
            this.f22904a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f22904a.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            d.h.b.o.b(r2, "requireActivity()");
            ao r3 = r2.getViewModelStore();
            d.h.b.o.b(r3, "requireActivity().viewModelStore");
            return r3;
        }
    }

    public static /* synthetic */ void lambda$ENiMmaeDe70X5BCsT7wbMoqRapY(AutomationFragment r0, List r1) {
        onCreate$lambda$2$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ void lambda$HGQytB0lUaWghSxEx6xDYRqsCYE(AutomationFragment r0, View r1) {
        onViewCreated$lambda$5(r0, r1);
    }

    public static /* synthetic */ void lambda$htmoTS2pWodMY05nIpgA_TudhCY(AutomationFragment r0, int r1) {
        focusTask$lambda$7(r0, r1);
    }

    public static /* synthetic */ x lambda$muHNh8Tmc6hWBQVhB0Hs7Hi8NtU(AutomationFragment r0, List r1) {
        return onViewCreated$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$xT-nuqYjnjpEBbLJmAJPg4J6CgY, reason: not valid java name */
    public static /* synthetic */ void m444lambda$xTnuqYjnjpEBbLJmAJPg4J6CgY(AutomationFragment r0, String r1, Bundle r2) {
        onCreate$lambda$2(r0, r1, r2);
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment
    public String getPageEnterPageName() {
        return "condition_list";
    }

    public AutomationFragment() {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = r.a(r0, aa.b(com.obric.autoaction.app.launcherpage.module.b.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r0), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        this.managementViewModel$delegate = r.a(r1, aa.b(com.obric.autoaction.app.launcherpage.module.d.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r1), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        this.tracker$delegate = r.a(r2, aa.b(com.obric.event.task.base.report.p.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r2), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    public static final /* synthetic */ void access$focusTask(AutomationFragment r2, List r3) {
        r2.focusTask((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ad access$getBinding$p(AutomationFragment r0) {
        return r0.binding;
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.d access$getManagementViewModel(AutomationFragment r0) {
        return r0.getManagementViewModel();
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.b access$getViewModel(AutomationFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ void access$reportPageEnterSuccessOnPreDraw(AutomationFragment r0, View r1) {
        r0.reportPageEnterSuccessOnPreDraw(r1);
    }

    public static final /* synthetic */ void access$reportRenderDurationIfNeeded(AutomationFragment r0) {
        r0.reportRenderDurationIfNeeded();
    }

    private final com.obric.autoaction.app.launcherpage.module.b getViewModel() {
        return (com.obric.autoaction.app.launcherpage.module.b) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.module.b.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autoaction.app.launcherpage.module.d getManagementViewModel() {
        return (com.obric.autoaction.app.launcherpage.module.d) ZeusTransformUtils.preCheckCast(this.managementViewModel$delegate.b(), com.obric.autoaction.app.launcherpage.module.d.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.event.task.base.report.p getTracker() {
        return (com.obric.event.task.base.report.p) ZeusTransformUtils.preCheckCast(this.tracker$delegate.b(), com.obric.event.task.base.report.p.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.createStartTime = SystemClock.elapsedRealtime();
        getParentFragmentManager().a(IMainTab.Companion.b() + "_args", (androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin"), new $$Lambda$AutomationFragment$xTnuqYjnjpEBbLJmAJPg4J6CgY(this));
    }

    private static final void onCreate$lambda$2(final AutomationFragment r1, String r2, Bundle r3) {
        d.h.b.o.e(r2, "key");
        d.h.b.o.e(r3, "result");
        r1.focusTaskId = r3.getString("key_task_id");
        final List r4 = (List) ZeusTransformUtils.preCheckCast(r1.getViewModel().b().c(), List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        ad r5 = r1.binding;
        if (r5 != null) goto L7;
        d.h.b.o.c("binding");
        r5 = null;
    L7:
        r5.b().postDelayed(new $$Lambda$AutomationFragment$ENiMmaeDe70X5BCsT7wbMoqRapY(r1, r4), 500);
        return;
    }

    private static final void onCreate$lambda$2$lambda$1$lambda$0(AutomationFragment r2, List r3) {
        r2.focusTask((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        d.h.b.o.e(r1, "inflater");
        ad r4 = null;
        ad r5 = ad.a(getLayoutInflater(), null, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.binding = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
    L7:
        return (View) ZeusTransformUtils.preCheckCast(r4.b(), View.class, "com.obric.aiagent.plugin");
    L5:
        r4 = r5;
        goto L7
    }

    @Override // com.obric.autoaction.app.launcherpage.main.LauncherPageBaseTabFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        d.h.b.o.e(r10, "view");
        super.onViewCreated(r10, r11);
        ad r12 = this.binding;
        ad r0 = null;
        if (r12 != null) goto L5;
        d.h.b.o.c("binding");
        r12 = null;
    L5:
        OPageStatus r13 = r12.f22716a;
        r13.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.repeat_task_management_page_empty_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "repeat_task_management_page_empty_title")), CharSequence.class, "com.obric.aiagent.plugin"));
        ad r14 = this.binding;
        if (r14 != null) goto L8;
        d.h.b.o.c("binding");
        r14 = null;
    L8:
        AutoActionTaskList r15 = r14.f22718c;
        ad r1 = this.binding;
        if (r1 != null) goto L11;
        d.h.b.o.c("binding");
        r1 = null;
    L11:
        r15.bindEmptyView((View) ZeusTransformUtils.preCheckCast(r1.f22716a, View.class, "com.obric.aiagent.plugin"));
        ad r16 = this.binding;
        if (r16 != null) goto L14;
        d.h.b.o.c("binding");
        r16 = null;
    L14:
        AutoActionTaskList.applyBottomNavInsetPadding$default(r16.f22718c, false, 1, null);
        ad r17 = this.binding;
        if (r17 != null) goto L17;
        d.h.b.o.c("binding");
        r17 = null;
    L17:
        r17.f22718c.attachSortController(new $$Lambda$AutomationFragment$muHNh8Tmc6hWBQVhB0Hs7Hi8NtU(this));
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        ad r18 = this.binding;
        if (r18 != null) goto L20;
        d.h.b.o.c("binding");
        r18 = null;
    L20:
        OButton r19 = r18.f22719d.getMLeftActionBack();
        if (r19 == null) goto L23;
        r19.setOnClickListener(new $$Lambda$AutomationFragment$HGQytB0lUaWghSxEx6xDYRqsCYE(this));
    L23:
        ad r9 = this.binding;
        if (r9 != null) goto L26;
        d.h.b.o.c("binding");
    L27:
        r0.f22719d.setVisibility(8);
        return;
    L26:
        r0 = r9;
        goto L27
    }

    private static final x onViewCreated$lambda$4(AutomationFragment r8, List r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "orderedTaskIds");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r8, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new a(r8, r10, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        return x.f38692a;
    }

    private static final void onViewCreated$lambda$5(AutomationFragment r1, View r2) {
        FragmentActivity r3 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }

    private final void reportRenderDurationIfNeeded() {
        if (this.hasReportedRenderDuration == false) goto L5;
        return;
    L5:
        if (this.createStartTime <= 0) goto L10;
        this.hasReportedRenderDuration = true;
        com.obric.event.task.base.report.l.f32861a.b(SystemClock.elapsedRealtime() - this.createStartTime);
        return;
    }

    private final void focusTask(List<? extends h> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        ad r3 = null;
        if (this.focusTaskId == null) goto L28;
        Iterator r11 = r10.iterator();
        final int r4 = 0;
    L6:
        if (r11.hasNext() == false) goto L16;
        h r5 = (h) ZeusTransformUtils.preCheckCast(r11.next(), h.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autoaction.app.launcherpage.module.a.a.b.class) == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == true) goto L17;
        r4 = r4 + 1;
    L17:
        if (r4 == (-1)) goto L36;
        ad r12 = this.binding;
        if (r12 != null) goto L21;
        d.h.b.o.c("binding");
        r12 = null;
    L21:
        r12.f22718c.focusPosition(r4);
        ad r13 = this.binding;
        if (r13 != null) goto L24;
        d.h.b.o.c("binding");
        r13 = null;
    L24:
        r13.f22718c.notifyItemChanged();
        ad r14 = this.binding;
        if (r14 != null) goto L27;
        d.h.b.o.c("binding");
        r14 = null;
    L27:
        r14.f22718c.post(new $$Lambda$AutomationFragment$htmoTS2pWodMY05nIpgA_TudhCY(this, r4));
        this.focusTaskId = null;
        return;
    L36:
        return;
    L10:
        if (d.h.b.o.a(((com.obric.autoaction.app.launcherpage.module.a.a.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.module.a.a.b.class, "com.obric.aiagent.plugin")).a(), this.focusTaskId) == false) goto L12;
        r6 = true;
        goto L13
    L16:
        r4 = -1;
        goto L17
    L28:
        ad r8 = this.binding;
        if (r8 != null) goto L31;
        d.h.b.o.c("binding");
    L32:
        r3.f22718c.maybeScrollToTop();
        return;
    L31:
        r3 = r8;
        goto L32
    }

    private static final void focusTask$lambda$7(AutomationFragment r0, int r1) {
        ad r2 = r0.binding;
        if (r2 != null) goto L5;
        d.h.b.o.c("binding");
        r2 = null;
    L5:
        r2.f22718c.highLightPosition(r1);
    }
}
