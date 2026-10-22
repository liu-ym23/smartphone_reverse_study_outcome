package com.obric.autoaction.app.launcherpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ac;
import com.obric.autoaction.app.launcherpage.base.BaseTaskHistoryActivity;
import com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskList;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: RepeatTaskHistoryActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RepeatTaskHistoryActivity extends BaseTaskHistoryActivity implements com.obric.autoaction.app.launcherpage.b.a {
    public static final a Companion = null;
    private static final String PARAMS_TIMER_TASK_ID = "timerTaskId";
    private static final String PARAMS_TIMER_TAS_QUERY = "timerTaskQuery";
    private ac binding;
    private int taskType;
    private final d.f tracker$delegate;
    private final d.f viewModel$delegate;

    /* JADX INFO: compiled from: RepeatTaskHistoryActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final void a(Context r4, String r5, String r6) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r3, "context");
            o.e(r5, RepeatTaskHistoryActivity.PARAMS_TIMER_TASK_ID);
            o.e(r6, DownloadConstants.QUERY_KEY);
            com.obric.autoaction.app.launcherpage.b.b.f22905a.a(r3);
            Intent r1 = new Intent(r3, RepeatTaskHistoryActivity.class);
            r1.putExtra(RepeatTaskHistoryActivity.PARAMS_TIMER_TASK_ID, r5);
            r1.putExtra(RepeatTaskHistoryActivity.PARAMS_TIMER_TAS_QUERY, r6);
            if (ZeusTransformUtils.instanceOf(r3, Activity.class) == false) goto L9;
            Bundle r7 = ((Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.aiagent.plugin")).getIntent().getExtras();
            if (r7 == null) goto L9;
            String r8 = r7.getString("log_extras");
            if (r8 == null) goto L9;
            r1.putExtra("log_extras", r8);
        L9:
            ZeusTransformUtils.startActivity(r3, r1, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: RepeatTaskHistoryActivity.kt */
    public static final class b implements com.obric.autoaction.app.launcherpage.module.a.i {
        @Override // com.obric.autoaction.app.launcherpage.module.a.i
        public boolean a() {
            return false;
        }

        @Override // com.obric.autoaction.app.launcherpage.module.a.i
        public boolean b() {
            return false;
        }

        b() {
        }
    }

    /* JADX INFO: compiled from: RepeatTaskHistoryActivity.kt */
    @d.c.b.a.f(b = "RepeatTaskHistoryActivity.kt", c = {80}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.RepeatTaskHistoryActivity$onCreate$4")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RepeatTaskHistoryActivity f22654b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.RepeatTaskHistoryActivity$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: RepeatTaskHistoryActivity.kt */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RepeatTaskHistoryActivity f22655a;

            AnonymousClass1(RepeatTaskHistoryActivity r3) {
                this.f22655a = (RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin");
            }

            public static /* synthetic */ x lambda$oaIAIC2idzq2EyH3T7oMj2YiMMM(RepeatTaskHistoryActivity r0, List r1) {
                return a(r0, r1);
            }

            @Override // kotlinx.coroutines.b.i
            public /* synthetic */ Object emit(Object r3, d.c.d r4) {
                d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), r5);
            }

            public final Object a(List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r3, d.c.d<? super x> r4) {
                List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                if (r5 == null) goto L5;
                ac r7 = RepeatTaskHistoryActivity.access$getBinding$p(this.f22655a);
                if (r7 != null) goto L9;
                o.c("binding");
                r7 = null;
            L9:
                AutoActionTaskList r8 = r7.f22713c;
                final RepeatTaskHistoryActivity r2 = this.f22655a;
                r8.submitData(r5, new $$Lambda$RepeatTaskHistoryActivity$c$1$oaIAIC2idzq2EyH3T7oMj2YiMMM(r2));
                return x.f38692a;
            L5:
                return x.f38692a;
            }

            private static final x a(RepeatTaskHistoryActivity r2, List r3) {
                RepeatTaskHistoryActivity r4 = (RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin");
                o.e((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), "it");
                ac r5 = RepeatTaskHistoryActivity.access$getBinding$p(r4);
                if (r5 != null) goto L5;
                o.c("binding");
                r5 = null;
            L5:
                RepeatTaskHistoryActivity.access$reportPageEnterSuccessOnPreDraw(r4, (View) ZeusTransformUtils.preCheckCast(r5.f22713c, View.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }
        }

        c(RepeatTaskHistoryActivity r3, d.c.d<? super c> r4) {
            RepeatTaskHistoryActivity r5 = (RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22654b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f22654b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22653a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.x<List<com.obric.autoaction.app.launcherpage.module.a.a.f>> r7 = RepeatTaskHistoryActivity.access$getViewModel(this.f22654b).b();
            kotlinx.coroutines.b.i<? super List<com.obric.autoaction.app.launcherpage.module.a.a.f>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22654b), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22653a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: RepeatTaskHistoryActivity.kt */
    @d.c.b.a.f(b = "RepeatTaskHistoryActivity.kt", c = {112}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.RepeatTaskHistoryActivity$setUserQuery$1$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RepeatTaskHistoryActivity f22657b;

        d(RepeatTaskHistoryActivity r3, d.c.d<? super d> r4) {
            RepeatTaskHistoryActivity r5 = (RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22657b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f22657b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f22656a;
            ac r4 = null;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r18);
            Object r3 = r18;
        L15:
            EventTask r5 = (EventTask) ZeusTransformUtils.preCheckCast(r3, EventTask.class, "com.obric.aiagent.plugin");
        L17:
            RepeatTaskHistoryActivity r6 = this.f22657b;
            if (r5 == null) goto L20;
            int r7 = r5.getType();
        L21:
            RepeatTaskHistoryActivity.access$setTaskType$p(r6, r7);
            ac r8 = RepeatTaskHistoryActivity.access$getBinding$p(this.f22657b);
            if (r8 != null) goto L24;
            o.c("binding");
            r8 = null;
        L24:
            r8.f22715e.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(this.f22657b.getIntent().getStringExtra(RepeatTaskHistoryActivity.PARAMS_TIMER_TAS_QUERY), CharSequence.class, "com.obric.aiagent.plugin"));
            ac r9 = RepeatTaskHistoryActivity.access$getBinding$p(this.f22657b);
            if (r9 != null) goto L27;
            o.c("binding");
            r9 = null;
        L27:
            OTextView r10 = r9.f22715e.getTitleView();
            r10.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_1_Bold, "style", "Title_1_Bold"));
            r10.setMaxLines(2);
            if (ZeusTransformUtils.instanceOf(r5, ConditionTask.class) == false) goto L39;
            ac r11 = RepeatTaskHistoryActivity.access$getBinding$p(this.f22657b);
            if (r11 != null) goto L32;
            o.c("binding");
            r11 = null;
        L32:
            r11.f22715e.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.condition.a.a.a(com.obric.autoaction.app.launcherpage.condition.a.a.a(((ConditionTask) ZeusTransformUtils.preCheckCast(r5, ConditionTask.class, "com.obric.aiagent.plugin")).getConditions()), (Context) ZeusTransformUtils.preCheckCast(this.f22657b, Context.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin"));
            ac r12 = RepeatTaskHistoryActivity.access$getBinding$p(this.f22657b);
            if (r12 != null) goto L35;
            o.c("binding");
            r12 = null;
        L35:
            r12.f22715e.showSubTitle(true);
            ac r13 = RepeatTaskHistoryActivity.access$getBinding$p(this.f22657b);
            if (r13 != null) goto L38;
            o.c("binding");
            r13 = null;
        L38:
            OTextView r14 = r13.f22715e.getSubTitleView();
            RepeatTaskHistoryActivity r0 = this.f22657b;
            p.a((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin"), 0, d.i.a.a(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), 0, 0, 13, null);
            r14.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Subtitle_3_Regular, "style", "Subtitle_3_Regular"));
            r14.setTextColor(p.b(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"), (Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin"), null, 2, null));
            r14.setLineSpacing(3.0f, 1.1f);
        L45:
            return x.f38692a;
        L39:
            ac r15 = RepeatTaskHistoryActivity.access$getBinding$p(this.f22657b);
            if (r15 != null) goto L42;
            o.c("binding");
        L43:
            r4.f22715e.showSubTitle(false);
            goto L45
        L42:
            r4 = r15;
            goto L43
        L20:
            r7 = 0;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r18);
            String r16 = this.f22657b.getIntent().getStringExtra(RepeatTaskHistoryActivity.PARAMS_TIMER_TASK_ID);
            IEventTaskApi r17 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L16;
            if (r16 != null) goto L12;
            r16 = "";
        L12:
            d.c.d<? super EventTask> r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22656a = 1;
            r3 = r17.getEventTask(r16, r19);
            if (r3 != r1) goto L15;
            return r1;
        L16:
            r5 = null;
            goto L17
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class e extends d.h.b.p implements d.h.a.a<androidx.lifecycle.am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f22658a;

        public e(ComponentActivity r3) {
            this.f22658a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.am.b invoke() {
            return a();
        }

        public final androidx.lifecycle.am.b a() {
            androidx.lifecycle.am.b r1 = this.f22658a.getDefaultViewModelProviderFactory();
            o.c(r1, "defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class f extends d.h.b.p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f22659a;

        public f(ComponentActivity r3) {
            this.f22659a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final ao a() {
            ao r1 = this.f22659a.getViewModelStore();
            o.c(r1, "viewModelStore");
            return r1;
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class g extends d.h.b.p implements d.h.a.a<androidx.lifecycle.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f22660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f22661b;

        public g(d.h.a.a r3, ComponentActivity r4) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
            this.f22660a = r5;
            this.f22661b = r6;
            super(0);
        }

        public final androidx.lifecycle.a.a a() {
            d.h.a.a r0 = this.f22660a;
            if (r0 == null) goto L6;
            androidx.lifecycle.a.a r1 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r0.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            androidx.lifecycle.a.a r2 = this.f22661b.getDefaultViewModelCreationExtras();
            o.c(r2, "this.defaultViewModelCreationExtras");
            return r2;
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.a.a invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class h extends d.h.b.p implements d.h.a.a<androidx.lifecycle.am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f22662a;

        public h(ComponentActivity r3) {
            this.f22662a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.am.b invoke() {
            return a();
        }

        public final androidx.lifecycle.am.b a() {
            androidx.lifecycle.am.b r1 = this.f22662a.getDefaultViewModelProviderFactory();
            o.c(r1, "defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class i extends d.h.b.p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f22663a;

        public i(ComponentActivity r3) {
            this.f22663a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final ao a() {
            ao r1 = this.f22663a.getViewModelStore();
            o.c(r1, "viewModelStore");
            return r1;
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class j extends d.h.b.p implements d.h.a.a<androidx.lifecycle.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f22664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f22665b;

        public j(d.h.a.a r3, ComponentActivity r4) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
            this.f22664a = r5;
            this.f22665b = r6;
            super(0);
        }

        public final androidx.lifecycle.a.a a() {
            d.h.a.a r0 = this.f22664a;
            if (r0 == null) goto L6;
            androidx.lifecycle.a.a r1 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r0.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            androidx.lifecycle.a.a r2 = this.f22665b.getDefaultViewModelCreationExtras();
            o.c(r2, "this.defaultViewModelCreationExtras");
            return r2;
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.a.a invoke() {
            return a();
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$CQGQKlc10W3yD7IWnkYl0-PwHPU, reason: not valid java name */
    public static /* synthetic */ void m442lambda$CQGQKlc10W3yD7IWnkYl0PwHPU(RepeatTaskHistoryActivity r0, View r1) {
        onCreate$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ void lambda$UF195lb9swviaaH1LudF1Q5InR8(RepeatTaskHistoryActivity r0) {
        setUserQuery$lambda$5(r0);
    }

    /* JADX INFO: renamed from: lambda$V8dgv8-h2Vw2-vF7Xlwb5ncVtRM, reason: not valid java name */
    public static /* synthetic */ x m443lambda$V8dgv8h2Vw2vF7Xlwb5ncVtRM(com.obric.autoaction.common.base.a r0) {
        return configExtension$lambda$0(r0);
    }

    public static /* synthetic */ x lambda$djRulwMxYGeetXqqkYSLgcoCZmE(RepeatTaskHistoryActivity r0) {
        return onCreate$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$g6NKSOlhkAqlLPXX9s3aFysIthk(RepeatTaskHistoryActivity r0, boolean r1, boolean r2) {
        listenListScroll$lambda$6(r0, r1, r2);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity
    public d.h.a.b<com.obric.autoaction.common.base.a, x> configExtension() {
        return $$Lambda$RepeatTaskHistoryActivity$V8dgv8h2Vw2vF7Xlwb5ncVtRM.INSTANCE;
    }

    @Override // com.obric.autoaction.app.launcherpage.base.BaseTaskHistoryActivity
    public String getPageEnterPageName() {
        return "repeated_task_history_detail";
    }

    public RepeatTaskHistoryActivity() {
        ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = (d.f) ZeusTransformUtils.preCheckCast(new al(aa.b(com.obric.autoaction.app.launcherpage.module.c.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r0), d.h.a.a.class, "com.obric.aiagent.plugin"), r2, (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(null, r0), d.h.a.a.class, "com.obric.aiagent.plugin")), d.f.class, "com.obric.aiagent.plugin");
        ComponentActivity r1 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(r1), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.tracker$delegate = (d.f) ZeusTransformUtils.preCheckCast(new al(aa.b(com.obric.event.task.base.report.p.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new i(r1), d.h.a.a.class, "com.obric.aiagent.plugin"), r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new j(null, r1), d.h.a.a.class, "com.obric.aiagent.plugin")), d.f.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ ac access$getBinding$p(RepeatTaskHistoryActivity r2) {
        return ((RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin")).binding;
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.c access$getViewModel(RepeatTaskHistoryActivity r2) {
        return ((RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$reportPageEnterSuccessOnPreDraw(RepeatTaskHistoryActivity r2, View r3) {
        ((RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin")).reportPageEnterSuccessOnPreDraw(r3);
    }

    public static final /* synthetic */ void access$setTaskType$p(RepeatTaskHistoryActivity r2, int r3) {
        ((RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin")).taskType = r3;
    }

    private final com.obric.autoaction.app.launcherpage.module.c getViewModel() {
        return (com.obric.autoaction.app.launcherpage.module.c) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.module.c.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.event.task.base.report.p getTracker() {
        return (com.obric.event.task.base.report.p) ZeusTransformUtils.preCheckCast(this.tracker$delegate.b(), com.obric.event.task.base.report.p.class, "com.obric.aiagent.plugin");
    }

    private static final x configExtension$lambda$0(com.obric.autoaction.common.base.a r5) {
        o.e(r5, "<this>");
        r5.a((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b("repeated_task_history_detail", false, 2, null), com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.base.BaseTaskHistoryActivity, com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r12) {
        super.onCreate(r12);
        com.obric.event.task.base.report.p r13 = getTracker();
        Intent r0 = getIntent();
        o.c(r0, "getIntent(...)");
        r13.a(r0, "repeated_task_history_detail");
        ac r1 = null;
        ac r14 = ac.a(getLayoutInflater(), null, false);
        o.c(r14, "inflate(...)");
        this.binding = r14;
        if (r14 != null) goto L5;
        o.c("binding");
        r14 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r14.b(), View.class, "com.obric.aiagent.plugin"));
        ac r15 = this.binding;
        if (r15 != null) goto L8;
        o.c("binding");
        r15 = null;
    L8:
        OPageStatus r16 = r15.f22711a;
        r16.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.event_task_history_empty_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "event_task_history_empty_title")), CharSequence.class, "com.obric.aiagent.plugin"));
        ac r17 = this.binding;
        if (r17 != null) goto L11;
        o.c("binding");
        r17 = null;
    L11:
        AutoActionTaskList r18 = r17.f22713c;
        ac r3 = this.binding;
        if (r3 != null) goto L14;
        o.c("binding");
        r3 = null;
    L14:
        r18.bindEmptyView((View) ZeusTransformUtils.preCheckCast(r3.f22711a, View.class, "com.obric.aiagent.plugin"));
        getViewModel().a(getIntent().getStringExtra(PARAMS_TIMER_TASK_ID));
        getViewModel().a(true);
        ac r19 = this.binding;
        if (r19 != null) goto L17;
        o.c("binding");
        r19 = null;
    L17:
        r19.f22713c.setLoadMoreAction(new $$Lambda$RepeatTaskHistoryActivity$djRulwMxYGeetXqqkYSLgcoCZmE(this));
        ac r110 = this.binding;
        if (r110 != null) goto L20;
        o.c("binding");
        r110 = null;
    L20:
        r110.f22713c.addListControl((com.obric.autoaction.app.launcherpage.module.a.i) ZeusTransformUtils.preCheckCast(new b(), com.obric.autoaction.app.launcherpage.module.a.i.class, "com.obric.aiagent.plugin"));
        q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")).b((m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"));
        ac r111 = this.binding;
        if (r111 != null) goto L23;
        o.c("binding");
        r111 = null;
    L23:
        OFloatingTitleBar r112 = r111.f22714d;
        OFloatingTitleBar.addStartAction$default(r112, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$RepeatTaskHistoryActivity$CQGQKlc10W3yD7IWnkYl0PwHPU(this), 2, null);
        o.a(r112);
        com.obric.autoaction.app.launcherpage.b.c.a(r112);
        setUserQuery();
        BaseActivity.Companion.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false);
        p.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), false, 1, null);
        ac r113 = this.binding;
        if (r113 != null) goto L26;
        o.c("binding");
        r113 = null;
    L26:
        r113.f22713c.applyBottomNavInsetPadding(true);
        listenListScroll();
        ac r114 = this.binding;
        if (r114 != null) goto L29;
        o.c("binding");
        r114 = null;
    L29:
        OCardListItem r115 = r114.f22715e;
        o.c(r115, "taskQuery");
        View r4 = (View) ZeusTransformUtils.preCheckCast(r115, View.class, "com.obric.aiagent.plugin");
        ac r11 = this.binding;
        if (r11 != null) goto L32;
        o.c("binding");
    L33:
        OFloatingTitleBar r5 = r1.f22714d;
        o.c(r5, "lpTitleBar");
        p.a(r4, r5, 0, false, 6, null);
        return;
    L32:
        r1 = r11;
        goto L33
    }

    private static final x onCreate$lambda$2(RepeatTaskHistoryActivity r2) {
        ((RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin")).getViewModel().e();
        return x.f38692a;
    }

    private static final void onCreate$lambda$4$lambda$3(RepeatTaskHistoryActivity r1, View r2) {
        ((RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r1, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private final void setUserQuery() {
        ac r0 = this.binding;
        if (r0 != null) goto L5;
        o.c("binding");
        r0 = null;
    L5:
        r0.b().post(new $$Lambda$RepeatTaskHistoryActivity$UF195lb9swviaaH1LudF1Q5InR8(this));
    }

    private static final void setUserQuery$lambda$5(RepeatTaskHistoryActivity r8) {
        RepeatTaskHistoryActivity r9 = (RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r8, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r9, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new d(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void listenListScroll() {
        ac r0 = this.binding;
        if (r0 != null) goto L5;
        o.c("binding");
        r0 = null;
    L5:
        r0.f22713c.setScrollStateChangedListener(new $$Lambda$RepeatTaskHistoryActivity$g6NKSOlhkAqlLPXX9s3aFysIthk(this));
    }

    private static final void listenListScroll$lambda$6(RepeatTaskHistoryActivity r1, boolean r2, boolean r3) {
        ac r4 = ((RepeatTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r1, RepeatTaskHistoryActivity.class, "com.obric.aiagent.plugin")).binding;
        if (r4 != null) goto L5;
        o.c("binding");
        r4 = null;
    L5:
        View r5 = r4.f22712b;
        if (r2 == false) goto L8;
        int r6 = 8;
    L9:
        r5.setVisibility(r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.b.a
    public OFloatingTitleBar getFloatingTransitionSourceTitleBar() {
        ac r0 = this.binding;
        ac r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 != null) goto L8;
        o.c("binding");
        r0 = null;
    L8:
        if (r0.f22714d.getVisibility() != 0) goto L16;
        ac r3 = this.binding;
        if (r3 != null) goto L12;
        o.c("binding");
    L14:
        return r1.f22714d;
    L12:
        r1 = r3;
        goto L14
    L16:
        return null;
    }
}
