package com.obric.autoaction.app.launcherpage.history;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ag;
import com.obric.autoaction.app.launcherpage.base.BaseTaskHistoryActivity;
import com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskList;
import com.obric.autoaction.app.launcherpage.ui.j;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.oui.common.util.k;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.p;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: TaskHistoryActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskHistoryActivity extends BaseTaskHistoryActivity implements com.obric.autoaction.app.launcherpage.b.a {
    private final String TAG;
    private ag binding;
    private Integer maybeFocusTimerTaskId;
    private final j searchBarAnimationHelper;
    private final d.f tracker$delegate;
    private final d.f viewModel$delegate;

    /* JADX INFO: compiled from: TaskHistoryActivity.kt */
    @d.c.b.a.f(b = "TaskHistoryActivity.kt", c = {220}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.history.TaskHistoryActivity$initSearchBox$4")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskHistoryActivity f23828b;

        a(TaskHistoryActivity r3, d.c.d<? super a> r4) {
            TaskHistoryActivity r5 = (TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, TaskHistoryActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23828b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f23828b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23827a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.x<String> r7 = TaskHistoryActivity.access$getViewModel(this.f23828b).c();
            final TaskHistoryActivity r3 = this.f23828b;
            i<? super String> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23827a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskHistoryActivity.kt */
    @d.c.b.a.f(b = "TaskHistoryActivity.kt", c = {91}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.history.TaskHistoryActivity$onCreate$4")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskHistoryActivity f23831b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.history.TaskHistoryActivity$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: TaskHistoryActivity.kt */
        static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ TaskHistoryActivity f23832a;

            AnonymousClass1(TaskHistoryActivity r3) {
                this.f23832a = (TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, TaskHistoryActivity.class, "com.obric.aiagent.plugin");
            }

            public static /* synthetic */ x lambda$io3mSWFKLlVHo5cbUJcwZfLWg2w(TaskHistoryActivity r0, List r1, List r2) {
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
                ag r7 = TaskHistoryActivity.access$getBinding$p(this.f23832a);
                if (r7 != null) goto L5;
                d.h.b.o.c("binding");
                r7 = null;
            L5:
                AutoActionTaskList r8 = r7.f22732d;
                if (r5 == null) goto L8;
                final TaskHistoryActivity r2 = this.f23832a;
                r8.submitData(r5, new $$Lambda$TaskHistoryActivity$b$1$io3mSWFKLlVHo5cbUJcwZfLWg2w(r2, r5));
                return x.f38692a;
            L8:
                return x.f38692a;
            }

            private static final x a(TaskHistoryActivity r2, List r3, List r4) {
                TaskHistoryActivity r5 = (TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, TaskHistoryActivity.class, "com.obric.aiagent.plugin");
                List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                d.h.b.o.e((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), "it");
                TaskHistoryActivity.access$maybeFocusNewTimerTask(r5, r6);
                ag r7 = TaskHistoryActivity.access$getBinding$p(r5);
                if (r7 != null) goto L5;
                d.h.b.o.c("binding");
                r7 = null;
            L5:
                TaskHistoryActivity.access$reportPageEnterSuccessOnPreDraw(r5, (View) ZeusTransformUtils.preCheckCast(r7.f22732d, View.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }
        }

        b(TaskHistoryActivity r3, d.c.d<? super b> r4) {
            TaskHistoryActivity r5 = (TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, TaskHistoryActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23831b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23831b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23830a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.x<List<com.obric.autoaction.app.launcherpage.module.a.a.f>> r7 = TaskHistoryActivity.access$getViewModel(this.f23831b).b();
            i<? super List<com.obric.autoaction.app.launcherpage.module.a.a.f>> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23831b), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23830a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class c extends p implements d.h.a.a<androidx.lifecycle.am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23833a;

        public c(ComponentActivity r3) {
            this.f23833a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.am.b invoke() {
            return a();
        }

        public final androidx.lifecycle.am.b a() {
            androidx.lifecycle.am.b r1 = this.f23833a.getDefaultViewModelProviderFactory();
            d.h.b.o.c(r1, "defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class d extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23834a;

        public d(ComponentActivity r3) {
            this.f23834a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final ao a() {
            ao r1 = this.f23834a.getViewModelStore();
            d.h.b.o.c(r1, "viewModelStore");
            return r1;
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class e extends p implements d.h.a.a<androidx.lifecycle.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23836b;

        public e(d.h.a.a r3, ComponentActivity r4) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
            this.f23835a = r5;
            this.f23836b = r6;
            super(0);
        }

        public final androidx.lifecycle.a.a a() {
            d.h.a.a r0 = this.f23835a;
            if (r0 == null) goto L6;
            androidx.lifecycle.a.a r1 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r0.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            androidx.lifecycle.a.a r2 = this.f23836b.getDefaultViewModelCreationExtras();
            d.h.b.o.c(r2, "this.defaultViewModelCreationExtras");
            return r2;
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.a.a invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class f extends p implements d.h.a.a<androidx.lifecycle.am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23837a;

        public f(ComponentActivity r3) {
            this.f23837a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.am.b invoke() {
            return a();
        }

        public final androidx.lifecycle.am.b a() {
            androidx.lifecycle.am.b r1 = this.f23837a.getDefaultViewModelProviderFactory();
            d.h.b.o.c(r1, "defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class g extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23838a;

        public g(ComponentActivity r3) {
            this.f23838a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final ao a() {
            ao r1 = this.f23838a.getViewModelStore();
            d.h.b.o.c(r1, "viewModelStore");
            return r1;
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class h extends p implements d.h.a.a<androidx.lifecycle.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23840b;

        public h(d.h.a.a r3, ComponentActivity r4) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
            this.f23839a = r5;
            this.f23840b = r6;
            super(0);
        }

        public final androidx.lifecycle.a.a a() {
            d.h.a.a r0 = this.f23839a;
            if (r0 == null) goto L6;
            androidx.lifecycle.a.a r1 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r0.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            androidx.lifecycle.a.a r2 = this.f23840b.getDefaultViewModelCreationExtras();
            d.h.b.o.c(r2, "this.defaultViewModelCreationExtras");
            return r2;
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.a.a invoke() {
            return a();
        }
    }

    public static /* synthetic */ void lambda$E_rIMEmH1Ykr2JF2917uOyEeB_A(List r0, TaskHistoryActivity r1) {
        maybeFocusNewTimerTask$lambda$8(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$HSYztvbiVfJVNZHL3ue_U-oYVMY, reason: not valid java name */
    public static /* synthetic */ void m510lambda$HSYztvbiVfJVNZHL3ue_UoYVMY(TaskHistoryActivity r0, View r1) {
        initTitleBarActionBtn$lambda$11$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$MH44VcIO-CQKhD68sLq6eIr3TWI, reason: not valid java name */
    public static /* synthetic */ x m511lambda$MH44VcIOCQKhD68sLq6eIr3TWI(com.obric.autoaction.common.base.a r0) {
        return configExtension$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$Ob3E7zbfosBN6B02zbFh8UvOicM(LinearLayout r0, TaskHistoryActivity r1) {
        initSearchBox$lambda$15$lambda$14$lambda$13(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$QmQ-J8Hg7F5UCq1oWi6hd0BH9fk, reason: not valid java name */
    public static /* synthetic */ x m512lambda$QmQJ8Hg7F5UCq1oWi6hd0BH9fk(TaskHistoryActivity r0, OFloatingTitleBar r1) {
        return initTitleBarActionBtn$lambda$11(r0, r1);
    }

    public static /* synthetic */ x lambda$k8OtpHKdsSiotX_6eWlVC7w9_D4(TaskHistoryActivity r0) {
        return changeToNormalMode$lambda$12(r0);
    }

    public static /* synthetic */ void lambda$m6qFiIcE9z1Auzr9dDi6tD5L1Q0(TaskHistoryActivity r0, View r1) {
        initSearchBox$lambda$16(r0, r1);
    }

    public static /* synthetic */ x lambda$njExHByvCZvEHXUQO7Pi2dtPLhI(TaskHistoryActivity r0) {
        return onCreate$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$pl5qrtzJon09-knT598UCX8QN3w, reason: not valid java name */
    public static /* synthetic */ void m513lambda$pl5qrtzJon09knT598UCX8QN3w(TaskHistoryActivity r0, View r1) {
        initTitleBarActionBtn$lambda$11$lambda$9(r0, r1);
    }

    public static /* synthetic */ WindowInsets lambda$zDzbUqGQWMnEM_LsY2A9iSLS3YY(TaskHistoryActivity r0, LinearLayout r1, View r2, WindowInsets r3) {
        return initSearchBox$lambda$15$lambda$14(r0, r1, r2, r3);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity
    public d.h.a.b<com.obric.autoaction.common.base.a, x> configExtension() {
        return $$Lambda$TaskHistoryActivity$MH44VcIOCQKhD68sLq6eIr3TWI.INSTANCE;
    }

    @Override // com.obric.autoaction.app.launcherpage.base.BaseTaskHistoryActivity
    public String getPageEnterPageName() {
        return "session_list_page";
    }

    public TaskHistoryActivity() {
        this.TAG = "TaskHistoryActivity";
        ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = (d.f) ZeusTransformUtils.preCheckCast(new al(aa.b(com.obric.autoaction.app.launcherpage.module.c.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r0), d.h.a.a.class, "com.obric.aiagent.plugin"), r2, (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(null, r0), d.h.a.a.class, "com.obric.aiagent.plugin")), d.f.class, "com.obric.aiagent.plugin");
        ComponentActivity r1 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r1), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.tracker$delegate = (d.f) ZeusTransformUtils.preCheckCast(new al(aa.b(com.obric.event.task.base.report.p.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r1), d.h.a.a.class, "com.obric.aiagent.plugin"), r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(null, r1), d.h.a.a.class, "com.obric.aiagent.plugin")), d.f.class, "com.obric.aiagent.plugin");
        this.searchBarAnimationHelper = new j();
    }

    public static final /* synthetic */ ag access$getBinding$p(TaskHistoryActivity r2) {
        return ((TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, TaskHistoryActivity.class, "com.obric.aiagent.plugin")).binding;
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.c access$getViewModel(TaskHistoryActivity r2) {
        return ((TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, TaskHistoryActivity.class, "com.obric.aiagent.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$maybeFocusNewTimerTask(TaskHistoryActivity r2, List r3) {
        ((TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, TaskHistoryActivity.class, "com.obric.aiagent.plugin")).maybeFocusNewTimerTask((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$reportPageEnterSuccessOnPreDraw(TaskHistoryActivity r2, View r3) {
        ((TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, TaskHistoryActivity.class, "com.obric.aiagent.plugin")).reportPageEnterSuccessOnPreDraw(r3);
    }

    private final com.obric.autoaction.app.launcherpage.module.c getViewModel() {
        return (com.obric.autoaction.app.launcherpage.module.c) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.module.c.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.event.task.base.report.p getTracker() {
        return (com.obric.event.task.base.report.p) ZeusTransformUtils.preCheckCast(this.tracker$delegate.b(), com.obric.event.task.base.report.p.class, "com.obric.aiagent.plugin");
    }

    private final LinearLayout getSearchBarContainer() {
        ag r1 = this.binding;
        if (r1 != null) goto L5;
        d.h.b.o.c("binding");
        r1 = null;
    L5:
        LinearLayout r2 = r1.g;
        d.h.b.o.c(r2, "searchbarContainer");
        return r2;
    }

    private static final x configExtension$lambda$0(com.obric.autoaction.common.base.a r5) {
        d.h.b.o.e(r5, "<this>");
        r5.a((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b("session_list_page", false, 2, null), com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.base.BaseTaskHistoryActivity, com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r9) {
        super.onCreate(r9);
        ag r0 = null;
        ag r10 = ag.a(getLayoutInflater(), null, false);
        d.h.b.o.c(r10, "inflate(...)");
        this.binding = r10;
        com.obric.event.task.base.report.p r11 = getTracker();
        Intent r2 = getIntent();
        d.h.b.o.c(r2, "getIntent(...)");
        r11.a(r2, "session_list_page");
        BaseActivity.Companion.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false);
        ag r12 = this.binding;
        if (r12 != null) goto L5;
        d.h.b.o.c("binding");
        r12 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r12.b(), View.class, "com.obric.aiagent.plugin"));
        Intent r13 = getIntent();
        if (r13 == null) goto L8;
        Integer r14 = Integer.valueOf(r13.getIntExtra("focus_timer_task_id", -1));
    L9:
        this.maybeFocusTimerTaskId = r14;
        if (r14 != null) goto L13;
    L14:
        ag r15 = this.binding;
        if (r15 != null) goto L17;
        d.h.b.o.c("binding");
        r15 = null;
    L17:
        r15.f22732d.setNeedScrollToTodayOnFirstLoad(false);
    L18:
        ag r16 = this.binding;
        if (r16 != null) goto L21;
        d.h.b.o.c("binding");
        r16 = null;
    L21:
        OPageStatus r17 = r16.f22731c;
        r17.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.launcher_page_empty_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "launcher_page_empty_title")), CharSequence.class, "com.obric.aiagent.plugin"));
        r17.setMessage((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.launcher_page_empty_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "launcher_page_empty_desc")), CharSequence.class, "com.obric.aiagent.plugin"));
        ag r18 = this.binding;
        if (r18 != null) goto L24;
        d.h.b.o.c("binding");
        r18 = null;
    L24:
        OPageStatus r19 = r18.f22730b;
        r19.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.launcher_page_empty_seach_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "launcher_page_empty_seach_title")), CharSequence.class, "com.obric.aiagent.plugin"));
        ag r20 = this.binding;
        if (r20 != null) goto L27;
        d.h.b.o.c("binding");
        r20 = null;
    L27:
        AutoActionTaskList r21 = r20.f22732d;
        ag r4 = this.binding;
        if (r4 != null) goto L30;
        d.h.b.o.c("binding");
        r4 = null;
    L30:
        r21.bindEmptyView((View) ZeusTransformUtils.preCheckCast(r4.f22731c, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.module.c.a(getViewModel(), false, 1, null);
        ag r22 = this.binding;
        if (r22 != null) goto L33;
        d.h.b.o.c("binding");
        r22 = null;
    L33:
        r22.f22732d.setLoadMoreAction(new $$Lambda$TaskHistoryActivity$njExHByvCZvEHXUQO7Pi2dtPLhI(this));
        q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")).b((m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"));
        ag r23 = this.binding;
        if (r23 != null) goto L36;
        d.h.b.o.c("binding");
        r23 = null;
    L36:
        AutoActionTaskList r24 = r23.f22732d;
        d.h.b.o.c(r24, "lpTaskList");
        View r25 = (View) ZeusTransformUtils.preCheckCast(r24, View.class, "com.obric.aiagent.plugin");
        ag r5 = this.binding;
        if (r5 != null) goto L39;
        d.h.b.o.c("binding");
        r5 = null;
    L39:
        OFloatingTitleBar r6 = r5.f22733e;
        d.h.b.o.c(r6, "lpTitleBar");
        com.obric.autoaction.app.launcherpage.utils.p.a(r25, r6, false, 2, null);
        com.obric.autoaction.app.launcherpage.utils.p.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), false, 1, null);
        ag r26 = this.binding;
        if (r26 != null) goto L42;
        d.h.b.o.c("binding");
    L43:
        r0.f22732d.applyBottomNavInsetPadding(true);
        initTitleBarActionBtn();
        initSearchBox();
        changeToNormalMode();
        return;
    L42:
        r0 = r26;
        goto L43
    L13:
        if (r14.intValue() == (-1)) goto L18;
    L8:
        r14 = null;
        goto L9
    }

    private static final x onCreate$lambda$3(TaskHistoryActivity r2) {
        ((TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, TaskHistoryActivity.class, "com.obric.aiagent.plugin")).getViewModel().e();
        return x.f38692a;
    }

    private final void maybeFocusNewTimerTask(List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
        return;
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.k((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(getViewModel().f(), Collection.class, "com.obric.aiagent.plugin"), this.maybeFocusTimerTaskId), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L6:
        int r4 = -1;
        int r6 = 0;
        if (r1.hasNext() == false) goto L21;
        Object r3 = r1.next();
        Iterator r7 = r13.iterator();
        int r8 = 0;
    L10:
        if (r7.hasNext() == false) goto L20;
        com.obric.autoaction.app.launcherpage.module.a.a.f r9 = (com.obric.autoaction.app.launcherpage.module.a.a.f) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.autoaction.app.launcherpage.module.a.a.f.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autoaction.app.launcherpage.module.a.a.j.class) == true) goto L14;
    L16:
        boolean r10 = false;
    L17:
        if (r10 == true) goto L18;
        r8 = r8 + 1;
        goto L10
    L18:
        r4 = r8;
        goto L20
    L14:
        if (d.h.b.o.a(((com.obric.autoaction.app.launcherpage.module.a.a.j) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.app.launcherpage.module.a.a.j.class, "com.obric.aiagent.plugin")).a(), r3) == false) goto L16;
        r10 = true;
    L20:
        r2.add(Integer.valueOf(r4));
        goto L6
    L21:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.m((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L30;
        Object r11 = r15.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue() == (-1)) goto L27;
        boolean r16 = true;
    L28:
        if (r16 == false) goto L23;
        r5.add(r11);
        goto L23
    L27:
        r16 = false;
        goto L28
    L30:
        final List r17 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L53;
        ag r18 = null;
        this.maybeFocusTimerTaskId = null;
        Integer r19 = (Integer) ZeusTransformUtils.preCheckCast(d.a.p.l(r17), Integer.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L35;
        r6 = r19.intValue();
    L35:
        ag r20 = this.binding;
        if (r20 != null) goto L38;
        d.h.b.o.c("binding");
        r20 = null;
    L38:
        r20.f22732d.focusPosition(r6);
        ag r21 = this.binding;
        if (r21 != null) goto L41;
        d.h.b.o.c("binding");
    L42:
        r18.f22732d.post(new $$Lambda$TaskHistoryActivity$E_rIMEmH1Ykr2JF2917uOyEeB_A(r17, this));
        return;
    L41:
        r18 = r21;
        goto L42
    }

    private static final void maybeFocusNewTimerTask$lambda$8(List r3, TaskHistoryActivity r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        TaskHistoryActivity r6 = (TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r4, TaskHistoryActivity.class, "com.obric.aiagent.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.aiagent.plugin")).intValue();
        ag r2 = r6.binding;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        r2.f22732d.highLightPosition(r0);
        goto L4
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
    }

    private final void initTitleBarActionBtn() {
        ag r0 = this.binding;
        ag r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22733e.batchSet(false, new $$Lambda$TaskHistoryActivity$QmQJ8Hg7F5UCq1oWi6hd0BH9fk(this));
        ag r5 = this.binding;
        if (r5 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        OFloatingTitleBar r6 = r1.f22733e;
        d.h.b.o.c(r6, "lpTitleBar");
        com.obric.autoaction.app.launcherpage.b.c.a(r6);
        return;
    L8:
        r1 = r5;
        goto L9
    }

    private static final x initTitleBarActionBtn$lambda$11(TaskHistoryActivity r12, OFloatingTitleBar r13) {
        final TaskHistoryActivity r14 = (TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r12, TaskHistoryActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "$this$batchSet");
        OFloatingTitleBar.removeAllEndAction$default(r13, false, 1, null);
        OFloatingTitleBar.removeAllStartAction$default(r13, false, 1, null);
        r13.setCenterTitle(ZeusTransformUtils.mapRes(R.string.main_menu_history, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_history"));
        r13.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        OFloatingTitleBar.addStartAction$default(r13, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$TaskHistoryActivity$pl5qrtzJon09knT598UCX8QN3w(r14), 2, null);
        r13.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        OFloatingTitleBar.addEndAction$default(r13, ZeusTransformUtils.mapRes(R.drawable.oic_magnifier_search, "drawable", "oic_magnifier_search"), 0, new $$Lambda$TaskHistoryActivity$HSYztvbiVfJVNZHL3ue_UoYVMY(r14), 2, null);
        r13.removeCenterCustomView();
        r13.showCenterCustomView(false);
        return x.f38692a;
    }

    private static final void initTitleBarActionBtn$lambda$11$lambda$9(TaskHistoryActivity r1, View r2) {
        ((TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r1, TaskHistoryActivity.class, "com.obric.aiagent.plugin")).onBackPressed();
    }

    private static final void initTitleBarActionBtn$lambda$11$lambda$10(TaskHistoryActivity r1, View r2) {
        ((TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r1, TaskHistoryActivity.class, "com.obric.aiagent.plugin")).changeToSearchMode();
    }

    @Override // com.obric.autoaction.app.launcherpage.b.a
    public OFloatingTitleBar getFloatingTransitionSourceTitleBar() {
        ag r0 = this.binding;
        ag r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 != null) goto L8;
        d.h.b.o.c("binding");
        r0 = null;
    L8:
        if (r0.f22733e.getVisibility() != 0) goto L16;
        ag r3 = this.binding;
        if (r3 != null) goto L12;
        d.h.b.o.c("binding");
    L14:
        return r1.f22733e;
    L12:
        r1 = r3;
        goto L14
    L16:
        return null;
    }

    private final void changeToNormalMode() {
        j r0 = this.searchBarAnimationHelper;
        ag r1 = this.binding;
        if (r1 != null) goto L5;
        d.h.b.o.c("binding");
        r1 = null;
    L5:
        LinearLayout r2 = r1.g;
        d.h.b.o.c(r2, "searchbarContainer");
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
        Object[] r4 = new Object[2];
        ag r5 = this.binding;
        if (r5 != null) goto L8;
        d.h.b.o.c("binding");
        r5 = null;
    L8:
        r4[0] = r5.f;
        ag r6 = this.binding;
        if (r6 != null) goto L11;
        d.h.b.o.c("binding");
        r6 = null;
    L11:
        r4[1] = r6.f22729a;
        j.b(r0, r3, d.a.p.b(r4), 0, new $$Lambda$TaskHistoryActivity$k8OtpHKdsSiotX_6eWlVC7w9_D4(this), 4, null);
        ag r7 = this.binding;
        if (r7 != null) goto L14;
        d.h.b.o.c("binding");
        r7 = null;
    L14:
        AutoActionTaskList r8 = r7.f22732d;
        ag r9 = this.binding;
        if (r9 != null) goto L17;
        d.h.b.o.c("binding");
        r9 = null;
    L17:
        r8.bindEmptyView((View) ZeusTransformUtils.preCheckCast(r9.f22731c, View.class, "com.obric.aiagent.plugin"));
        ag r10 = this.binding;
        if (r10 != null) goto L20;
        d.h.b.o.c("binding");
        r10 = null;
    L20:
        r10.f22730b.setVisibility(8);
        ag r11 = this.binding;
        if (r11 != null) goto L23;
        d.h.b.o.c("binding");
        r11 = null;
    L23:
        r11.f.getInputView().clearFocus();
        getViewModel().c().b(null);
    }

    private static final x changeToNormalMode$lambda$12(TaskHistoryActivity r2) {
        ag r3 = ((TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, TaskHistoryActivity.class, "com.obric.aiagent.plugin")).binding;
        if (r3 != null) goto L5;
        d.h.b.o.c("binding");
        r3 = null;
    L5:
        OFloatingTitleBar r4 = r3.f22733e;
        d.h.b.o.c(r4, "lpTitleBar");
        k.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private final int getTitleTopMargin() {
        ag r4 = this.binding;
        ViewGroup.MarginLayoutParams r0 = null;
        if (r4 != null) goto L5;
        d.h.b.o.c("binding");
        r4 = null;
    L5:
        ViewGroup.LayoutParams r5 = r4.f22733e.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, DbHelper.COL_ID, "title_bar_container")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == false) goto L8;
        r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L8:
        if (r0 != null) goto L12;
        return 0;
    L12:
        return r0.topMargin;
    }

    private final void initSearchBox() {
        ag r0 = this.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        final LinearLayout r1 = r0.g;
        com.obric.autoaction.app.launcherpage.utils.p.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), 0, getTitleTopMargin(), 0, 0, 13, null);
        r1.setOnApplyWindowInsetsListener(new $$Lambda$TaskHistoryActivity$zDzbUqGQWMnEM_LsY2A9iSLS3YY(this, r1));
        ag r2 = this.binding;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        r2.f22729a.setOnClickListener(new $$Lambda$TaskHistoryActivity$m6qFiIcE9z1Auzr9dDi6tD5L1Q0(this));
        ag r3 = this.binding;
        if (r3 != null) goto L11;
        d.h.b.o.c("binding");
        r3 = null;
    L11:
        r3.f.getInputView().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this), TextWatcher.class, "com.obric.aiagent.plugin"));
        ag r4 = this.binding;
        if (r4 != null) goto L14;
        d.h.b.o.c("binding");
        r4 = null;
    L14:
        com.obric.autoaction.app.launcherpage.utils.p.b((View) ZeusTransformUtils.preCheckCast(r4.f.getInputView(), View.class, "com.obric.aiagent.plugin"));
        q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")).a((m) ZeusTransformUtils.preCheckCast(new a(this, null), m.class, "com.obric.aiagent.plugin"));
    }

    private static final WindowInsets initSearchBox$lambda$15$lambda$14(TaskHistoryActivity r2, final LinearLayout r3, View r4, WindowInsets r5) {
        final TaskHistoryActivity r6 = (TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, TaskHistoryActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<unused var>");
        d.h.b.o.e(r5, "insets");
        ag r7 = r6.binding;
        if (r7 != null) goto L5;
        d.h.b.o.c("binding");
        r7 = null;
    L5:
        r7.g.post(new $$Lambda$TaskHistoryActivity$Ob3E7zbfosBN6B02zbFh8UvOicM(r3, r6));
        return r5;
    }

    private static final void initSearchBox$lambda$15$lambda$14$lambda$13(LinearLayout r7, TaskHistoryActivity r8) {
        TaskHistoryActivity r9 = (TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r8, TaskHistoryActivity.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.utils.p.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 0, r9.getTitleTopMargin(), 0, 0, 13, null);
    }

    private static final void initSearchBox$lambda$16(TaskHistoryActivity r1, View r2) {
        ((TaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r1, TaskHistoryActivity.class, "com.obric.aiagent.plugin")).changeToNormalMode();
    }

    private final void changeToSearchMode() {
        ag r0 = this.binding;
        ag r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22733e.finishFloatingTransitionForUserInteraction();
        ag r2 = this.binding;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        OFloatingTitleBar r3 = r2.f22733e;
        d.h.b.o.c(r3, "lpTitleBar");
        k.b((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        j r5 = this.searchBarAnimationHelper;
        ag r4 = this.binding;
        if (r4 != null) goto L11;
        d.h.b.o.c("binding");
        r4 = null;
    L11:
        LinearLayout r6 = r4.g;
        d.h.b.o.c(r6, "searchbarContainer");
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin");
        Object[] r8 = new Object[2];
        ag r9 = this.binding;
        if (r9 != null) goto L14;
        d.h.b.o.c("binding");
        r9 = null;
    L14:
        r8[0] = r9.f;
        ag r10 = this.binding;
        if (r10 != null) goto L17;
        d.h.b.o.c("binding");
        r10 = null;
    L17:
        r8[1] = r10.f22729a;
        j.a(r5, r7, d.a.p.b(r8), 0, null, 12, null);
        ag r11 = this.binding;
        if (r11 != null) goto L20;
        d.h.b.o.c("binding");
        r11 = null;
    L20:
        r11.f.getInputView().requestFocus();
        kotlinx.coroutines.b.x<String> r12 = getViewModel().c();
        ag r13 = this.binding;
        if (r13 != null) goto L23;
        d.h.b.o.c("binding");
    L24:
        r12.b(r1.f.getText().toString());
        return;
    L23:
        r1 = r13;
        goto L24
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r3) {
        super.onNewIntent(r3);
        if (r3 == null) goto L5;
        setIntent(r3);
    L5:
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.getIntExtra("focus_timer_task_id", -1));
    L8:
        this.maybeFocusTimerTaskId = r4;
        return;
    L7:
        r4 = null;
        goto L8
    }
}
