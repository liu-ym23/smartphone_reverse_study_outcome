package com.obric.autoaction.app.launcherpage.knowledge;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.EventsUtils;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.aa;
import com.obric.autoaction.app.launcherpage.knowledge.dialog.EditKnowledgeDialogFragment;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.event.task.base.report.k;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.menu.PopoverMenuLinearLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.toast.OToast;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import d.n;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: KnowledgeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KnowledgeActivity extends BaseActivity {
    private static final long BLOCKED_TOAST_DURATION = 2000;
    public static final a Companion = null;
    public static final String KEY_TASK_ID = "task_id";
    public static final String KEY_TASK_TYPE = "task_type";
    private static final String SECURITY_MODEL_WARMUP_PROBE = "预热";
    private final d.f binding$delegate;
    private final d.f knowledgeInput$delegate;
    private final d.f knowledgeViewModel$delegate;
    private long lastBlockedToastTime;
    private String taskId;
    private int taskType;

    /* JADX INFO: compiled from: KnowledgeActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final void a(Context r3, String r4, int r5) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            o.e(r4, DBDefinition.TASK_ID);
            com.obric.autoaction.app.launcherpage.b.b.f22905a.a(r2);
            Intent r6 = new Intent(r2, KnowledgeActivity.class);
            r6.putExtra(KnowledgeActivity.KEY_TASK_ID, r4);
            r6.putExtra(KnowledgeActivity.KEY_TASK_TYPE, r5);
            ZeusTransformUtils.startActivity(r2, r6, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: KnowledgeActivity.kt */
    @d.c.b.a.f(b = "KnowledgeActivity.kt", c = {EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity$onCreate$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ KnowledgeActivity f23897b;

        b(KnowledgeActivity r3, d.c.d<? super b> r4) {
            KnowledgeActivity r5 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r3, KnowledgeActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23897b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23897b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23896a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.x<String> r7 = KnowledgeActivity.access$getKnowledgeViewModel(this.f23897b).b();
            final KnowledgeActivity r3 = this.f23897b;
            i<? super String> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23896a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: KnowledgeActivity.kt */
    @d.c.b.a.f(b = "KnowledgeActivity.kt", c = {95}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity$onCreate$2")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ KnowledgeActivity f23900b;

        c(KnowledgeActivity r3, d.c.d<? super c> r4) {
            KnowledgeActivity r5 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r3, KnowledgeActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23900b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23900b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23899a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.x<Boolean> r7 = KnowledgeActivity.access$getKnowledgeViewModel(this.f23900b).c();
            final KnowledgeActivity r3 = this.f23900b;
            i<? super Boolean> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23899a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: KnowledgeActivity.kt */
    @d.c.b.a.f(b = "KnowledgeActivity.kt", c = {336}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity$openEditKnowledgeSheet$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ KnowledgeActivity f23903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f23904c;

        d(KnowledgeActivity r3, String r4, d.c.d<? super d> r5) {
            KnowledgeActivity r6 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r3, KnowledgeActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23903b = r6;
            this.f23904c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23903b, this.f23904c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23902a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            String r12 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L15;
            KnowledgeActivity.access$getKnowledgeViewModel(this.f23903b).a((com.obric.autoaction.app.launcherpage.knowledge.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.knowledge.a.c(r12), com.obric.autoaction.app.launcherpage.knowledge.a.class, "com.obric.aiagent.plugin"));
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            EditKnowledgeDialogFragment.a r4 = EditKnowledgeDialogFragment.Companion;
            AppCompatActivity r5 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(this.f23903b, AppCompatActivity.class, "com.obric.aiagent.plugin");
            String r6 = this.f23904c;
            String r7 = KnowledgeActivity.access$getTaskId$p(this.f23903b);
            int r8 = KnowledgeActivity.access$getTaskType$p(this.f23903b);
            d.c.d<? super String> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23902a = 1;
            r11 = r4.a(r5, r6, r7, r8, r9);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: KnowledgeActivity.kt */
    @d.c.b.a.f(b = "KnowledgeActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity$preloadSecurityContentModel$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f23906b;

        e(d.c.d<? super e> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            e r4 = new e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f23906b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f23905a != 0) goto L12;
            d.o.a(r2);
            am r1 = (am) ZeusTransformUtils.preCheckCast(this.f23906b, am.class, "com.obric.aiagent.plugin");
            n.a r3 = n.f38560a;     // Catch: Throwable -> L7
            n.f(d.c.b.a.b.a(AOPlatformTools.INSTANCE.security().checkSensitiveWord(KnowledgeActivity.SECURITY_MODEL_WARMUP_PROBE)));     // Catch: Throwable -> L7
        L10:
            return x.f38692a;
        L7:
            th = move-exception;
            n.a r4 = n.f38560a;
            n.f(d.o.a(th));
            goto L10
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class f extends p implements d.h.a.a<androidx.lifecycle.am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23907a;

        public f(ComponentActivity r3) {
            this.f23907a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.am.b invoke() {
            return a();
        }

        public final androidx.lifecycle.am.b a() {
            androidx.lifecycle.am.b r1 = this.f23907a.getDefaultViewModelProviderFactory();
            o.c(r1, "defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class g extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23908a;

        public g(ComponentActivity r3) {
            this.f23908a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final ao a() {
            ao r1 = this.f23908a.getViewModelStore();
            o.c(r1, "viewModelStore");
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
        final /* synthetic */ d.h.a.a f23909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23910b;

        public h(d.h.a.a r3, ComponentActivity r4) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
            this.f23909a = r5;
            this.f23910b = r6;
            super(0);
        }

        public final androidx.lifecycle.a.a a() {
            d.h.a.a r0 = this.f23909a;
            if (r0 == null) goto L6;
            androidx.lifecycle.a.a r1 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r0.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            androidx.lifecycle.a.a r2 = this.f23910b.getDefaultViewModelCreationExtras();
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

    /* JADX INFO: renamed from: lambda$3-Gzr9MC360x18MyIMeG2EhMNjQ, reason: not valid java name */
    public static /* synthetic */ void m520lambda$3Gzr9MC360x18MyIMeG2EhMNjQ(KnowledgeActivity r0, boolean r1, DialogInterface r2, int r3) {
        showAutoLearnSwitchSheet$lambda$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$CRdKlRdnpQhqgGODqeeiXyJ_FgU(boolean r0, KnowledgeActivity r1, String r2, boolean r3, OPopoverEntranceMenuView.a r4, d.h.a.a r5) {
        return showKnowledgeMoreMenu$lambda$13(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$E3Yr5g9PUEjWZhr0R3UJbvTYVTk(KnowledgeActivity r0, View r1) {
        initView$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$FS_6D8fYHzzyjkp8Q-ojeZ0aGdI, reason: not valid java name */
    public static /* synthetic */ x m521lambda$FS_6D8fYHzzyjkp8QojeZ0aGdI(boolean r0, OPopoverEntranceMenuView r1) {
        return showKnowledgeMoreMenu$lambda$8(r0, r1);
    }

    public static /* synthetic */ x lambda$IrH54AIBxXxPAt6rbLzbET0Uq50(d.h.a.a r0, boolean r1, boolean r2, KnowledgeActivity r3, View r4, int r5) {
        return showKnowledgeMoreMenu$lambda$13$lambda$11(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$Tg9T3Lpwrvdb7253uuQiaQdqvcI(KnowledgeActivity r0, View r1) {
        initView$lambda$4(r0, r1);
    }

    public static /* synthetic */ boolean lambda$WrizFJlq2UMZuVF5mP4UvuBL6eQ(GestureDetector r0, View r1, MotionEvent r2) {
        return createTapOnlyTouchListener$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ OInputLayout lambda$gvAiHSsqv7b1n5dStUOvwJZAUoI(KnowledgeActivity r0) {
        return knowledgeInput_delegate$lambda$2(r0);
    }

    public static /* synthetic */ aa lambda$rpGK3OkkBPFKGgQbAcjUdZd8GQc(KnowledgeActivity r0) {
        return binding_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$z6dcuwO6ENvKB-vw7ofD3fUTFE4, reason: not valid java name */
    public static /* synthetic */ x m522lambda$z6dcuwO6ENvKBvw7ofD3fUTFE4(d.h.a.a r0, boolean r1, KnowledgeActivity r2, String r3, View r4, int r5) {
        return showKnowledgeMoreMenu$lambda$13$lambda$9(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ x lambda$zQLbypxT7SoA3ENbZWHwn09jFYU(boolean r0, KnowledgeActivity r1, String r2) {
        return renderKnowledgeInput$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$zm3_QSKXnqpiHcvAnUEyKrpjXMA(KnowledgeActivity r0, OSwitch r1, View r2) {
        initAutoLearnSwitch$lambda$5(r0, r1, r2);
    }

    public KnowledgeActivity() {
        this.binding$delegate = d.g.a(new $$Lambda$KnowledgeActivity$rpGK3OkkBPFKGgQbAcjUdZd8GQc(this));
        this.knowledgeInput$delegate = d.g.a(new $$Lambda$KnowledgeActivity$gvAiHSsqv7b1n5dStUOvwJZAUoI(this));
        ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.knowledgeViewModel$delegate = (d.f) ZeusTransformUtils.preCheckCast(new al(d.h.b.aa.b(com.obric.autoaction.app.launcherpage.knowledge.b.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r0), d.h.a.a.class, "com.obric.aiagent.plugin"), r2, (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(null, r0), d.h.a.a.class, "com.obric.aiagent.plugin")), d.f.class, "com.obric.aiagent.plugin");
        this.taskId = "";
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.knowledge.b access$getKnowledgeViewModel(KnowledgeActivity r2) {
        return ((KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r2, KnowledgeActivity.class, "com.obric.aiagent.plugin")).getKnowledgeViewModel();
    }

    public static final /* synthetic */ String access$getTaskId$p(KnowledgeActivity r2) {
        return ((KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r2, KnowledgeActivity.class, "com.obric.aiagent.plugin")).taskId;
    }

    public static final /* synthetic */ int access$getTaskType$p(KnowledgeActivity r2) {
        return ((KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r2, KnowledgeActivity.class, "com.obric.aiagent.plugin")).taskType;
    }

    public static final /* synthetic */ void access$renderKnowledgePage(KnowledgeActivity r2) {
        ((KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r2, KnowledgeActivity.class, "com.obric.aiagent.plugin")).renderKnowledgePage();
    }

    private final aa getBinding() {
        return (aa) ZeusTransformUtils.preCheckCast(this.binding$delegate.b(), aa.class, "com.obric.aiagent.plugin");
    }

    private static final aa binding_delegate$lambda$0(KnowledgeActivity r2) {
        aa r3 = aa.a(((KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r2, KnowledgeActivity.class, "com.obric.aiagent.plugin")).getLayoutInflater(), null, false);
        o.c(r3, "inflate(...)");
        return r3;
    }

    private final OInputLayout getKnowledgeInput() {
        return (OInputLayout) ZeusTransformUtils.preCheckCast(this.knowledgeInput$delegate.b(), OInputLayout.class, "com.obric.aiagent.plugin");
    }

    private static final OInputLayout knowledgeInput_delegate$lambda$2(KnowledgeActivity r5) {
        KnowledgeActivity r6 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r5, KnowledgeActivity.class, "com.obric.aiagent.plugin");
        View r7 = ZeusTransformUtils.inflate(r6.getLayoutInflater(), ZeusTransformUtils.mapRes(R.layout.autoaction_knowledge_input, "layout", "autoaction_knowledge_input"), (ViewGroup) ZeusTransformUtils.preCheckCast(r6.getBinding().f, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        o.a(r7, "null cannot be cast to non-null type com.obric.oui.forms.OInputLayout");
        OInputLayout r8 = (OInputLayout) ZeusTransformUtils.preCheckCast(r7, OInputLayout.class, "com.obric.aiagent.plugin");
        r8.setType(1);
        return r8;
    }

    private final com.obric.autoaction.app.launcherpage.knowledge.b getKnowledgeViewModel() {
        return (com.obric.autoaction.app.launcherpage.knowledge.b) ZeusTransformUtils.preCheckCast(this.knowledgeViewModel$delegate.b(), com.obric.autoaction.app.launcherpage.knowledge.b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r12) {
        super.onCreate(r12);
        setContentView((View) ZeusTransformUtils.preCheckCast(getBinding().b(), View.class, "com.obric.aiagent.plugin"));
        BaseActivity.a.a(BaseActivity.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 1, null);
        String r13 = getIntent().getStringExtra(KEY_TASK_ID);
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        this.taskId = r13;
        this.taskType = getIntent().getIntExtra(KEY_TASK_TYPE, 0);
        getKnowledgeViewModel().a(this.taskId, this.taskType);
        initView();
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        k.f32860a.a();
        preloadSecurityContentModel();
    }

    private final void preloadSecurityContentModel() {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new e(null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void initView() {
        initKnowledgeInput();
        LinearLayout r0 = getBinding().f22704d;
        o.c(r0, "knowledgeContent");
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        OFloatingTitleBar r2 = getBinding().g;
        o.c(r2, "titleBar");
        com.obric.autoaction.app.launcherpage.utils.p.a(r1, r2, d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), false, 4, null);
        OFloatingTitleBar r3 = getBinding().g;
        o.c(r3, "titleBar");
        com.obric.autoaction.app.launcherpage.b.c.a(r3);
        OFloatingTitleBar r4 = getBinding().g;
        o.c(r4, "titleBar");
        com.obric.autoaction.app.launcherpage.knowledge.a.a.b(r4, new $$Lambda$KnowledgeActivity$E3Yr5g9PUEjWZhr0R3UJbvTYVTk(this), new $$Lambda$KnowledgeActivity$Tg9T3Lpwrvdb7253uuQiaQdqvcI(this));
        initAutoLearnSwitch();
    }

    private static final void initView$lambda$3(KnowledgeActivity r1, View r2) {
        ((KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r1, KnowledgeActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private static final void initView$lambda$4(KnowledgeActivity r1, View r2) {
        ((KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r1, KnowledgeActivity.class, "com.obric.aiagent.plugin")).showKnowledgeMoreMenu();
    }

    private final void initKnowledgeInput() {
        getBinding().f.setCustomStartView((View) ZeusTransformUtils.preCheckCast(getKnowledgeInput(), View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.utils.p.b((View) ZeusTransformUtils.preCheckCast(getKnowledgeInput(), View.class, "com.obric.aiagent.plugin"));
    }

    private final void initAutoLearnSwitch() {
        final OSwitch r0 = getBinding().f22702b.getEndSwitch();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setChecked(((Boolean) ZeusTransformUtils.preCheckCast(getKnowledgeViewModel().c().c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        r0.setClickable(true);
        r0.setOnClickListener(new $$Lambda$KnowledgeActivity$zm3_QSKXnqpiHcvAnUEyKrpjXMA(this, r0));
    }

    private static final void initAutoLearnSwitch$lambda$5(KnowledgeActivity r4, OSwitch r5, View r6) {
        KnowledgeActivity r7 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r4, KnowledgeActivity.class, "com.obric.aiagent.plugin");
        boolean r8 = ((Boolean) ZeusTransformUtils.preCheckCast(r7.getKnowledgeViewModel().c().c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        boolean r1 = !r8;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7.getKnowledgeViewModel().b().c(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r1 == true) goto L9;
        if (r2 == true) goto L9;
        r7.getKnowledgeViewModel().a((com.obric.autoaction.app.launcherpage.knowledge.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.knowledge.a.C0540a(r1), com.obric.autoaction.app.launcherpage.knowledge.a.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        r5.setChecked(r8);
        r7.showAutoLearnSwitchSheet(r1);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final void renderKnowledgePage() {
        String r0 = (String) ZeusTransformUtils.preCheckCast(getKnowledgeViewModel().b().c(), String.class, "com.obric.aiagent.plugin");
        boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(getKnowledgeViewModel().c().c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        OSwitch r5 = getBinding().f22702b.getEndSwitch();
        if (r5 == null) goto L9;
        r5.setChecked(r1);
    L9:
        getBinding().f22704d.setVisibility(0);
        getBinding().f22703c.setVisibility(8);
        if (r2 == false) goto L13;
        String r4 = r0;
    L16:
        renderAutoLearnDesc(r1);
        renderKnowledgeInput(r4, r1, r0, !r2);
        return;
    L13:
        if (r1 == false) goto L15;
        r4 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_auto_learning, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_auto_learning"));
        o.a(r4);
        goto L16
    L15:
        r4 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_empty_placeholder, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_empty_placeholder"));
        o.a(r4);
        goto L16
    L5:
        r2 = false;
        goto L6
    }

    private final void renderKnowledgeInput(String r5, final boolean r6, final String r7, boolean r8) {
        getKnowledgeInput().setVisibility(0);
        getKnowledgeInput().getVInput().setCursorVisible(false);
        if (r8 == true) goto L7;
        if (r6 == true) goto L7;
        int r9 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1");
    L8:
        getKnowledgeInput().getVInput().setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r9));
        getKnowledgeInput().setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        getKnowledgeInput().getVInput().setGravity(48);
        getKnowledgeInput().getVInput().setFocusable(false);
        getKnowledgeInput().getVInput().setFocusableInTouchMode(false);
        getKnowledgeInput().getVInput().clearFocus();
        View.OnTouchListener r10 = createTapOnlyTouchListener(new $$Lambda$KnowledgeActivity$zQLbypxT7SoA3ENbZWHwn09jFYU(r6, this, r7));
        getKnowledgeInput().setOnTouchListener(r10);
        getKnowledgeInput().getVInput().setOnTouchListener(r10);
        return;
    L7:
        r9 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3");
        goto L8
    }

    private static final x renderKnowledgeInput$lambda$6(boolean r2, KnowledgeActivity r3, String r4) {
        KnowledgeActivity r5 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r3, KnowledgeActivity.class, "com.obric.aiagent.plugin");
        if (r2 == false) goto L5;
        r5.showAutoLearnBlockedToast();
    L7:
        return x.f38692a;
    L5:
        r5.openEditKnowledgeSheet(r4);
        goto L7
    }

    private final View.OnTouchListener createTapOnlyTouchListener(d.h.a.a<x> r4) {
        final d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        final GestureDetector r0 = new GestureDetector((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), (GestureDetector.OnGestureListener) ZeusTransformUtils.preCheckCast(new KnowledgeActivity$createTapOnlyTouchListener$detector$1(r5), GestureDetector.OnGestureListener.class, "com.obric.aiagent.plugin"));
        return new $$Lambda$KnowledgeActivity$WrizFJlq2UMZuVF5mP4UvuBL6eQ(r0);
    }

    private static final boolean createTapOnlyTouchListener$lambda$7(GestureDetector r0, View r1, MotionEvent r2) {
        r0.onTouchEvent(r2);
        return false;
    }

    private final void showKnowledgeMoreMenu() {
        final String r0 = (String) ZeusTransformUtils.preCheckCast(getKnowledgeViewModel().b().c(), String.class, "com.obric.aiagent.plugin");
        final boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(getKnowledgeViewModel().c().c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        final boolean r3 = true;
    L6:
        com.obric.autoaction.app.launcherpage.module.a.h.f24077a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(getBinding().g.getEndButtonGroup(), View.class, "com.obric.aiagent.plugin"), 53, new $$Lambda$KnowledgeActivity$FS_6D8fYHzzyjkp8QojeZ0aGdI(r3), new $$Lambda$KnowledgeActivity$CRdKlRdnpQhqgGODqeeiXyJ_FgU(r1, this, r0, r3));
        return;
    L5:
        r3 = false;
        goto L6
    }

    private static final x showKnowledgeMoreMenu$lambda$8(boolean r1, OPopoverEntranceMenuView r2) {
        o.e(r2, "menu");
        if (r1 == true) goto L8;
        PopoverMenuLinearLayout r3 = r2.getItemView(1);
        if (r3 == null) goto L8;
        r3.setAlpha(0.3f);
    L8:
        return x.f38692a;
    }

    private static final x showKnowledgeMoreMenu$lambda$13(final boolean r21, KnowledgeActivity r22, final String r23, final boolean r24, OPopoverEntranceMenuView.a r25, d.h.a.a r26) {
        final KnowledgeActivity r1 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r22, KnowledgeActivity.class, "com.obric.aiagent.plugin");
        final d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r25, "$this$showPopup");
        o.e(r3, "dismiss");
        String r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r25.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_edit_knowledge, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_edit_knowledge"));
        OPopoverEntranceMenuView.a.a(r25, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.edit_menu, "drawable", "edit_menu")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$KnowledgeActivity$z6dcuwO6ENvKBvw7ofD3fUTFE4(r3, r21, r1, r23), 246, null).a(OPopoverEntranceMenuView.e.f36017a);
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r25.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_delete_knowledge, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_delete_knowledge"));
        int r6 = ZeusTransformUtils.mapRes(R.drawable.ic_delete, "drawable", "ic_delete");
        int r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r25.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6"));
        OPopoverEntranceMenuView.a.a(r25, Integer.valueOf(r6), null, Integer.valueOf(r7), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), null, null, true, null, new $$Lambda$KnowledgeActivity$IrH54AIBxXxPAt6rbLzbET0Uq50(r3, r24, r21, r1), 178, null).a(OPopoverEntranceMenuView.e.f36017a);
        return x.f38692a;
    }

    private static final x showKnowledgeMoreMenu$lambda$13$lambda$9(d.h.a.a r1, boolean r2, KnowledgeActivity r3, String r4, View r5, int r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        KnowledgeActivity r8 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r3, KnowledgeActivity.class, "com.obric.aiagent.plugin");
        o.e(r5, "<unused var>");
        r7.invoke();
        if (r2 == false) goto L5;
        r8.showAutoLearnBlockedToast();
    L7:
        return x.f38692a;
    L5:
        r8.openEditKnowledgeSheet(r4);
        goto L7
    }

    private static final x showKnowledgeMoreMenu$lambda$13$lambda$11(d.h.a.a r1, boolean r2, boolean r3, KnowledgeActivity r4, View r5, int r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        KnowledgeActivity r8 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r4, KnowledgeActivity.class, "com.obric.aiagent.plugin");
        o.e(r5, "<unused var>");
        r7.invoke();
        if (r2 == false) goto L8;
        if (r3 == false) goto L6;
        r8.showAutoLearnBlockedToast();
        goto L8
    L6:
        r8.getKnowledgeViewModel().a((com.obric.autoaction.app.launcherpage.knowledge.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.knowledge.a.b(true, (Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.aiagent.plugin")), com.obric.autoaction.app.launcherpage.knowledge.a.class, "com.obric.aiagent.plugin"));
    L8:
        return x.f38692a;
    }

    private final void renderAutoLearnDesc(boolean r1) {
        OTextView r0 = getBinding().f22701a;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    private final void showAutoLearnBlockedToast() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.lastBlockedToastTime) >= BLOCKED_TOAST_DURATION) goto L5;
        return;
    L5:
        this.lastBlockedToastTime = r0;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin");
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_auto_learn_blocked_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_auto_learn_blocked_toast"));
        o.c(r5, "getString(...)");
        new OToast(r4, r5, 0, true, null, 0, 52, null).a(Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.knowledge_auto_learn_blocked_toast, "drawable", "knowledge_auto_learn_blocked_toast"))).f();
    }

    private final void openEditKnowledgeSheet(String r9) {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void showAutoLearnSwitchSheet(final boolean r10) {
        if (r10 == false) goto L5;
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_auto_learn_enable_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_auto_learn_enable_title"));
    L6:
        String r3 = r1;
        o.a(r3);
        if (r10 == false) goto L9;
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_auto_learn_enable_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_auto_learn_enable_message"));
    L10:
        String r4 = r2;
        o.a(r4);
        if (r10 == false) goto L13;
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_enable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_enable"));
    L14:
        String r6 = r5;
        o.a(r6);
        if (r10 == false) goto L17;
        int r7 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, "color", "oui_accent_6_bg"));
    L18:
        int r8 = r7;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin");
        String r11 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_cancel"));
        o.c(r11, "getString(...)");
        com.obric.autoaction.app.launcherpage.utils.p.a(r9, r3, r4, r6, r11, r8, new $$Lambda$KnowledgeActivity$3Gzr9MC360x18MyIMeG2EhMNjQ(this, r10));
        return;
    L17:
        r7 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"));
        goto L18
    L13:
        r5 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_confirm"));
        goto L14
    L9:
        r2 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_auto_learn_disable_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_auto_learn_disable_message"));
        goto L10
    L5:
        r1 = getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_auto_learn_disable_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_auto_learn_disable_title"));
        goto L6
    }

    private static final void showAutoLearnSwitchSheet$lambda$14(KnowledgeActivity r1, boolean r2, DialogInterface r3, int r4) {
        KnowledgeActivity r5 = (KnowledgeActivity) ZeusTransformUtils.wrapperContextForParams(r1, KnowledgeActivity.class, "com.obric.aiagent.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        r5.getKnowledgeViewModel().a((com.obric.autoaction.app.launcherpage.knowledge.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.knowledge.a.C0540a(r2), com.obric.autoaction.app.launcherpage.knowledge.a.class, "com.obric.aiagent.plugin"));
        r6.dismiss();
    }
}
