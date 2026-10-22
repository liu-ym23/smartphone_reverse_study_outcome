package com.obric.aiagent.skill.ovirt.impl.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.assistant.idl.IAgentSkillManagerIDLSPI;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerStatusKeys;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.ovirt.impl.reporting.OVirtReporter;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.n;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: SkillSettingsActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillSettingsActivity extends AppCompatActivity {
    private static final a Companion = null;
    private com.obric.aiagent.skill.ovirt.impl.b.a binding;
    private boolean extensionEnabled;
    private boolean openAppAuthorized;
    private final am uiScope;
    private boolean updatingSwitch;

    /* JADX INFO: compiled from: SkillSettingsActivity.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillSettingsActivity.kt */
    @f(b = "SkillSettingsActivity.kt", c = {161}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillSettingsActivity$refreshOpenAppAuthState$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillSettingsActivity f21518b;

        /* JADX INFO: compiled from: SkillSettingsActivity.kt */
        @f(b = "SkillSettingsActivity.kt", c = {165}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.SkillSettingsActivity$refreshOpenAppAuthState$1$isAuthorized$1")
        static final class a extends l implements m<am, d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21519a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private /* synthetic */ Object f21520b;

            a(d<? super a> r3) {
                super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d<? super Boolean> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r2, d<?> r3) {
                a r4 = new a((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
                r4.f21520b = r2;
                return (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super Boolean> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21519a;
                boolean r4 = true;
                if (r1 == 0) goto L9;
                if (r1 != 1) goto L8;
                o.a(r6);     // Catch: Throwable -> L28
                Object r5 = ((n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L28
            L18:
                if (n.b(r5) == false) goto L20;
                r5 = null;
            L20:
                com.obric.aiagent.skill.credentials.api.a r7 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
                if (r7 != null) goto L23;
            L25:
                r4 = false;
            L26:
                Object r8 = n.f(d.c.b.a.b.a(r4));     // Catch: Throwable -> L28
            L30:
                Boolean r9 = d.c.b.a.b.a(false);
                if (n.b(r8) == true) goto L33;
                return r8;
            L33:
                return r9;
            L23:
                if (r7.b() != true) goto L25;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                o.a(r6);
                am r10 = (am) ZeusTransformUtils.preCheckCast(this.f21520b, am.class, "com.obric.aiagent.plugin");
                n.a r11 = n.f38560a;     // Catch: Throwable -> L28
                ISkillCredentialService r12 = ISkillCredentialService.Companion.a();     // Catch: Throwable -> L28
                if (r12 == null) goto L25;
                ISkillCredentialService.a r13 = r12.getAccount();     // Catch: Throwable -> L28
                if (r13 == null) goto L25;
                com.obric.aiagent.skill.credentials.api.f r2 = com.obric.aiagent.skill.credentials.api.f.f18949a;     // Catch: Throwable -> L28
                this.f21519a = 1;     // Catch: Throwable -> L28
                r5 = r13.b(r2, this);     // Catch: Throwable -> L28
                if (r5 != r0) goto L18;
                return r0;
            L28:
                th = move-exception;
                n.a r14 = n.f38560a;
                r8 = n.f(o.a(th));
                goto L30
            }
        }

        b(SkillSettingsActivity r3, d<? super b> r4) {
            SkillSettingsActivity r5 = (SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSettingsActivity.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f21518b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f21518b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21517a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L15:
            boolean r9 = ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            if (SkillSettingsActivity.access$getExtensionEnabled$p(this.f21518b) == true) goto L19;
            SkillSettingsActivity.access$setOpenAppAuthorized$p(this.f21518b, false);
            SkillSettingsActivity.access$renderOpenAppManagementVisibility(this.f21518b);
            return x.f38692a;
        L19:
            SkillSettingsActivity.access$setOpenAppAuthorized$p(this.f21518b, r9);
            com.obric.aiagent.skill.ovirt.impl.b.a r2 = SkillSettingsActivity.access$getBinding$p(this.f21518b);
            if (r2 != null) goto L22;
            d.h.b.o.c("binding");
            r2 = null;
        L22:
            OCardListItem r3 = r2.f21112b;
            SkillSettingsActivity r4 = this.f21518b;
            if (r9 == false) goto L25;
            int r10 = ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_authorized, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_authorized");
        L26:
            OCardListItem.setEndDetailText$default(r3, (CharSequence) ZeusTransformUtils.preCheckCast(r4.getString(r10), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
            SkillSettingsActivity.access$renderOpenAppManagementVisibility(this.f21518b);
            return x.f38692a;
        L25:
            r10 = ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_unauthorized, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_unauthorized");
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            if (SkillSettingsActivity.access$readOmniSkillAvailable(this.f21518b) == true) goto L12;
            SkillSettingsActivity.access$renderPageAvailability(this.f21518b, false);
            return x.f38692a;
        L12:
            g r11 = (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin");
            m r5 = (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f21517a = 1;
            r8 = i.a(r11, r5, r6);
            if (r8 != r0) goto L15;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$PaAOyuB1_Vrlji4y-sHV8xn8yU8, reason: not valid java name */
    public static /* synthetic */ void m367lambda$PaAOyuB1_Vrlji4ysHV8xn8yU8(SkillSettingsActivity r0, CompoundButton r1, boolean r2) {
        setupExtensionItem$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$_1a8VW1WovXsHR0YxBg674CSihs(SkillSettingsActivity r0, View r1) {
        setupExtensionItem$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ void lambda$hOxXTqE009_GmGuFDIRuR3HeqRM(SkillSettingsActivity r0, View r1) {
        setupTitleBar$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ void lambda$htxCYpOtCFdUEwoNLtSOUyM3EyE(SkillSettingsActivity r0, View r1) {
        renderOpenAppManagementAccess$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$p2tWf7AxIXEx8s-3yIZXBoFAnZg, reason: not valid java name */
    public static /* synthetic */ void m368lambda$p2tWf7AxIXEx8s3yIZXBoFAnZg(SkillSettingsActivity r0, View r1) {
        setupOpenAppManagementItem$lambda$7$lambda$6(r0, r1);
    }

    public SkillSettingsActivity() {
        this.uiScope = an.a(ce.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.b().a(), g.class, "com.obric.aiagent.plugin")));
    }

    public static final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.b.a access$getBinding$p(SkillSettingsActivity r2) {
        return ((SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSettingsActivity.class, "com.obric.aiagent.plugin")).binding;
    }

    public static final /* synthetic */ boolean access$getExtensionEnabled$p(SkillSettingsActivity r2) {
        return ((SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSettingsActivity.class, "com.obric.aiagent.plugin")).extensionEnabled;
    }

    public static final /* synthetic */ boolean access$readOmniSkillAvailable(SkillSettingsActivity r2) {
        return ((SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSettingsActivity.class, "com.obric.aiagent.plugin")).readOmniSkillAvailable();
    }

    public static final /* synthetic */ void access$renderOpenAppManagementVisibility(SkillSettingsActivity r2) {
        ((SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSettingsActivity.class, "com.obric.aiagent.plugin")).renderOpenAppManagementVisibility();
    }

    public static final /* synthetic */ void access$renderPageAvailability(SkillSettingsActivity r2, boolean r3) {
        ((SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSettingsActivity.class, "com.obric.aiagent.plugin")).renderPageAvailability(r3);
    }

    public static final /* synthetic */ void access$setExtensionEnabled(SkillSettingsActivity r2, boolean r3) {
        ((SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSettingsActivity.class, "com.obric.aiagent.plugin")).setExtensionEnabled(r3);
    }

    public static final /* synthetic */ void access$setOpenAppAuthorized$p(SkillSettingsActivity r2, boolean r3) {
        ((SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSettingsActivity.class, "com.obric.aiagent.plugin")).openAppAuthorized = r3;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        com.obric.aiagent.skill.ovirt.impl.ui.b.a((AppCompatActivity) ZeusTransformUtils.preCheckCast(this, AppCompatActivity.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.ovirt.impl.b.a r6 = com.obric.aiagent.skill.ovirt.impl.b.a.a(getLayoutInflater());
        d.h.b.o.c(r6, "inflate(...)");
        this.binding = r6;
        com.obric.aiagent.skill.ovirt.impl.b.a r1 = null;
        if (r6 != null) goto L5;
        d.h.b.o.c("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.b(), View.class, "com.obric.aiagent.plugin"));
        setupTitleBar();
        setupExtensionItem();
        setupOpenAppManagementItem();
        com.obric.aiagent.skill.ovirt.impl.b.a r7 = this.binding;
        if (r7 != null) goto L8;
        d.h.b.o.c("binding");
        r7 = null;
    L8:
        LinearLayout r8 = r7.f21111a;
        d.h.b.o.c(r8, "contentContainer");
        View r9 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.b.a r0 = this.binding;
        if (r0 != null) goto L11;
        d.h.b.o.c("binding");
    L12:
        OFloatingTitleBar r2 = r1.h;
        d.h.b.o.c(r2, "titleBar");
        com.obric.aiagent.skill.ovirt.impl.ui.b.a(r9, r2);
        refreshPageState();
        return;
    L11:
        r1 = r0;
        goto L12
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        refreshPageState();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        an.a(this.uiScope, null, 1, null);
        super.onDestroy();
    }

    private final void setupTitleBar() {
        com.obric.aiagent.skill.ovirt.impl.b.a r0 = this.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r1 = r0.h;
        r1.setFloatingTransitionEnabled(true);
        OFloatingTitleBar.removeAllStartAction$default(r1, false, 1, null);
        OFloatingTitleBar.removeAllEndAction$default(r1, false, 1, null);
        r1.setCenterTitle(ZeusTransformUtils.mapRes(R.string.obric_skill_extension_settings_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_extension_settings_title"));
        OFloatingTitleBar.addStartAction$default(r1, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$SkillSettingsActivity$hOxXTqE009_GmGuFDIRuR3HeqRM(this), 2, null);
        r1.removeCenterCustomView();
        r1.showCenterCustomView(false);
    }

    private static final void setupTitleBar$lambda$1$lambda$0(SkillSettingsActivity r1, View r2) {
        ((SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillSettingsActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private final void setupExtensionItem() {
        com.obric.aiagent.skill.ovirt.impl.b.a r0 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.a r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f;
        OCardListItem.setCardPosition$default(r1, 0, false, 2, null);
        r1.showDivider(false);
        r1.setOnContentClickListener(new $$Lambda$SkillSettingsActivity$_1a8VW1WovXsHR0YxBg674CSihs(this));
        renderSwitch();
        com.obric.aiagent.skill.ovirt.impl.b.a r3 = this.binding;
        if (r3 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        OSwitch r4 = r2.f.getEndSwitch();
        if (r4 == null) goto L13;
        r4.setOnCheckedChangeListener(new $$Lambda$SkillSettingsActivity$PaAOyuB1_Vrlji4ysHV8xn8yU8(this));
        return;
    L13:
        return;
    L8:
        r2 = r3;
        goto L9
    }

    private static final void setupExtensionItem$lambda$3$lambda$2(SkillSettingsActivity r1, View r2) {
        SkillSettingsActivity r3 = (SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillSettingsActivity.class, "com.obric.aiagent.plugin");
        if (r3.extensionEnabled == false) goto L5;
        r3.setExtensionEnabled(false);
        return;
    L5:
        r3.showEnableConfirmDialog();
    }

    private static final void setupExtensionItem$lambda$4(SkillSettingsActivity r1, CompoundButton r2, boolean r3) {
        SkillSettingsActivity r4 = (SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillSettingsActivity.class, "com.obric.aiagent.plugin");
        if (r4.updatingSwitch == false) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        r4.renderSwitch();
        r4.showEnableConfirmDialog();
        return;
    L7:
        r4.setExtensionEnabled(false);
    }

    private final void refreshPageState() {
        boolean r0 = readOmniSkillAvailable();
        renderPageAvailability(r0);
        if (r0 == true) goto L6;
        this.openAppAuthorized = false;
        return;
    L6:
        refreshSkillExtensionState();
        refreshOpenAppAuthState();
    }

    private final void refreshSkillExtensionState() {
        this.extensionEnabled = readSkillExtensionEnabled();
        this.openAppAuthorized = false;
        renderSwitch();
        renderOpenAppManagementVisibility();
    }

    private final void setupOpenAppManagementItem() {
        com.obric.aiagent.skill.ovirt.impl.b.a r0 = this.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f21112b;
        OCardListItem.setCardPosition$default(r1, 0, false, 2, null);
        r1.setDefaultTailIcon(0);
        r1.showTailIcon(false);
        r1.setDefaultCustomEndView(3);
        r1.showCustomEnd(true);
        r1.showSubTitle(true);
        OCardListItem.setEndDetailText$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_unauthorized, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_unauthorized")), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        com.obric.aiagent.skill.ovirt.impl.b.a r2 = this.binding;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        OCardListItem r3 = r2.f21114d;
        OCardListItem.setCardPosition$default(r3, 0, false, 2, null);
        r3.setDefaultTailIcon(0);
        r3.showTailIcon(true);
        r3.showSubTitle(false);
        r3.setOnContentClickListener(new $$Lambda$SkillSettingsActivity$p2tWf7AxIXEx8s3yIZXBoFAnZg(this));
        renderOpenAppManagementAccess();
    }

    private static final void setupOpenAppManagementItem$lambda$7$lambda$6(SkillSettingsActivity r4, View r5) {
        SkillSettingsActivity r6 = (SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillSettingsActivity.class, "com.obric.aiagent.plugin");
        if (r6.extensionEnabled == true) goto L5;
        return;
    L5:
        AppCompatActivity r7 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(r6, AppCompatActivity.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.b.a r1 = r6.binding;
        if (r1 != null) goto L8;
        d.h.b.o.c("binding");
        r1 = null;
    L8:
        OFloatingTitleBar r2 = r1.h;
        d.h.b.o.c(r2, "titleBar");
        com.obric.aiagent.skill.ovirt.impl.ui.b.a(r7, r2, new Intent((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"), ShellManagementActivity.class));
    }

    private final void refreshOpenAppAuthState() {
        if (this.extensionEnabled == true) goto L6;
        this.openAppAuthorized = false;
        renderOpenAppManagementVisibility();
        return;
    L6:
        this.openAppAuthorized = false;
        com.obric.aiagent.skill.ovirt.impl.b.a r0 = this.binding;
        if (r0 != null) goto L9;
        d.h.b.o.c("binding");
        r0 = null;
    L9:
        OCardListItem.setEndDetailText$default(r0.f21112b, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_open_app_unauthorized, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_open_app_unauthorized")), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        renderOpenAppManagementVisibility();
        i.a(this.uiScope, null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void showEnableConfirmDialog() {
        com.obric.oui.dialog.v2.alert.a r8 = com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_extension_confirm_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_extension_confirm_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_extension_confirm_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_extension_confirm_message")), CharSequence.class, "com.obric.aiagent.plugin")), false, 1, null);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_extension_confirm_enable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_extension_confirm_enable"));
        d.h.b.o.c(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r14 = com.obric.oui.dialog.v2.alert.a.a(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null);
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_extension_confirm_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_extension_confirm_cancel"));
        d.h.b.o.c(r0, "getString(...)");
        com.obric.oui.dialog.v2.alert.a.b(r14, (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new AnonymousClass2(), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null).h();
    }

    private final void setExtensionEnabled(boolean r2) {
        if (writeSkillExtensionEnabled(r2) == true) goto L6;
        renderSwitch();
        return;
    L6:
        reportSkillExtensionSwitch(r2);
        this.extensionEnabled = r2;
        if (r2 == true) goto L9;
        this.openAppAuthorized = false;
    L9:
        renderSwitch();
        renderOpenAppManagementVisibility();
        if (r2 == false) goto L13;
        refreshOpenAppAuthState();
        return;
    }

    private final boolean readSkillExtensionEnabled() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L11
        SkillSettingsActivity r4 = (SkillSettingsActivity) ZeusTransformUtils.preCheckCast(this, SkillSettingsActivity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        IAgentSkillManagerIDLSPI r5 = (IAgentSkillManagerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentSkillManagerIDLSPI.class), IAgentSkillManagerIDLSPI.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        OSkillManagerConfig r6 = r5.getSkillManagerConfig();     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r6.getValue(OSkillManagerConfig.KEY_SKILL_EXTENSION_ENABLED, true), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L11
    L9:
        Object r8 = n.f(Boolean.valueOf(r7));     // Catch: Throwable -> L11
    L14:
        if (n.b(r8) == false) goto L17;
        r8 = false;
    L17:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L8:
        r7 = false;
    L11:
        th = move-exception;
        n.a r3 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L14
    }

    private final boolean readOmniSkillAvailable() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L13
        SkillSettingsActivity r4 = (SkillSettingsActivity) ZeusTransformUtils.preCheckCast(this, SkillSettingsActivity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        IAgentSkillManagerIDLSPI r5 = (IAgentSkillManagerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentSkillManagerIDLSPI.class), IAgentSkillManagerIDLSPI.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        boolean r3 = true;
        if (r5 == null) goto L10;
        String r6 = r5.getSkillManagerStatus(OSkillManagerStatusKeys.KEY_OMNI_SKILL_AVAILABLE);     // Catch: Throwable -> L13
        if (r6 == null) goto L10;
        if (d.o.o.a(r6, "true", true) != true) goto L10;
    L11:
        Object r7 = n.f(Boolean.valueOf(r3));     // Catch: Throwable -> L13
    L16:
        if (n.b(r7) == false) goto L19;
        r7 = false;
    L19:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L10:
        r3 = false;
    L13:
        th = move-exception;
        n.a r8 = n.f38560a;
        r7 = n.f(o.a(th));
        goto L16
    }

    private final boolean writeSkillExtensionEnabled(boolean r4) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L11
        SkillSettingsActivity r3 = (SkillSettingsActivity) ZeusTransformUtils.preCheckCast(this, SkillSettingsActivity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Bundle r5 = new Bundle();     // Catch: Throwable -> L11
        r5.putBoolean(OSkillManagerConfig.KEY_SKILL_EXTENSION_ENABLED, r4);     // Catch: Throwable -> L11
        IAgentSkillManagerIDLSPI r6 = (IAgentSkillManagerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentSkillManagerIDLSPI.class), IAgentSkillManagerIDLSPI.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        boolean r7 = true;
        if (r6 != null) goto L6;
    L8:
        r7 = false;
    L9:
        Object r8 = n.f(Boolean.valueOf(r7));     // Catch: Throwable -> L11
    L14:
        if (n.b(r8) == false) goto L17;
        r8 = false;
    L17:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        if (r6.setSkillManagerConfigValues(r5) != true) goto L8;
    L11:
        th = move-exception;
        n.a r9 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L14
    }

    private final void reportSkillExtensionSwitch(boolean r1) {
        OVirtReporter.Companion.a(r1);
    }

    private final void renderSwitch() {
        this.updatingSwitch = true;
        com.obric.aiagent.skill.ovirt.impl.b.a r0 = this.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OSwitch r1 = r0.f.getEndSwitch();
        if (r1 == null) goto L8;
        r1.setChecked(this.extensionEnabled);
    L8:
        this.updatingSwitch = false;
    }

    private final void renderOpenAppManagementVisibility() {
        boolean r0 = this.extensionEnabled;
        int r1 = 0;
        if (r0 == true) goto L5;
    L7:
        int r3 = 8;
    L8:
        if (r0 == true) goto L10;
    L12:
        r1 = 8;
    L13:
        com.obric.aiagent.skill.ovirt.impl.b.a r2 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.a r4 = null;
        if (r2 != null) goto L16;
        d.h.b.o.c("binding");
        r2 = null;
    L16:
        r2.f21113c.setVisibility(r3);
        com.obric.aiagent.skill.ovirt.impl.b.a r5 = this.binding;
        if (r5 != null) goto L19;
        d.h.b.o.c("binding");
        r5 = null;
    L19:
        r5.f21112b.setVisibility(r3);
        com.obric.aiagent.skill.ovirt.impl.b.a r6 = this.binding;
        if (r6 != null) goto L22;
        d.h.b.o.c("binding");
        r6 = null;
    L22:
        r6.f21115e.setVisibility(r1);
        com.obric.aiagent.skill.ovirt.impl.b.a r7 = this.binding;
        if (r7 != null) goto L25;
        d.h.b.o.c("binding");
    L26:
        r4.f21114d.setVisibility(r1);
        renderOpenAppManagementAccess();
        return;
    L25:
        r4 = r7;
        goto L26
    L10:
        if (al.f19195a.a().G() == false) goto L12;
    L5:
        if (this.openAppAuthorized == false) goto L7;
        r3 = 0;
        goto L8
    }

    private final void renderOpenAppManagementAccess() {
        if (this.extensionEnabled == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        com.obric.aiagent.skill.ovirt.impl.b.a r2 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.a r4 = null;
        if (r2 != null) goto L11;
        d.h.b.o.c("binding");
        r2 = null;
    L11:
        r2.f21112b.setEnabled(true);
        com.obric.aiagent.skill.ovirt.impl.b.a r1 = this.binding;
        if (r1 != null) goto L14;
        d.h.b.o.c("binding");
        r1 = null;
    L14:
        r1.f21112b.showTailIcon(r0);
        com.obric.aiagent.skill.ovirt.impl.b.a r3 = this.binding;
        if (r3 != null) goto L17;
        d.h.b.o.c("binding");
        r3 = null;
    L17:
        OCardListItem r5 = r3.f21112b;
        if (r0 == false) goto L20;
        View.OnClickListener r6 = new $$Lambda$SkillSettingsActivity$htxCYpOtCFdUEwoNLtSOUyM3EyE(this);
    L21:
        r5.setOnContentClickListener(r6);
        com.obric.aiagent.skill.ovirt.impl.b.a r7 = this.binding;
        if (r7 != null) goto L24;
        d.h.b.o.c("binding");
        r7 = null;
    L24:
        r7.f21112b.getContentContainer().setClickable(r0);
        com.obric.aiagent.skill.ovirt.impl.b.a r8 = this.binding;
        if (r8 != null) goto L27;
        d.h.b.o.c("binding");
        r8 = null;
    L27:
        r8.f21114d.setEnabled(this.extensionEnabled);
        com.obric.aiagent.skill.ovirt.impl.b.a r9 = this.binding;
        if (r9 != null) goto L30;
        d.h.b.o.c("binding");
    L31:
        r4.f21114d.showTailIcon(this.extensionEnabled);
        return;
    L30:
        r4 = r9;
        goto L31
    L20:
        r6 = null;
        goto L21
    L5:
        if (this.openAppAuthorized == false) goto L7;
        r0 = true;
        goto L8
    }

    private static final void renderOpenAppManagementAccess$lambda$12(SkillSettingsActivity r4, View r5) {
        SkillSettingsActivity r6 = (SkillSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillSettingsActivity.class, "com.obric.aiagent.plugin");
        AppCompatActivity r7 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(r6, AppCompatActivity.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.b.a r1 = r6.binding;
        if (r1 != null) goto L5;
        d.h.b.o.c("binding");
        r1 = null;
    L5:
        OFloatingTitleBar r2 = r1.h;
        d.h.b.o.c(r2, "titleBar");
        com.obric.aiagent.skill.ovirt.impl.ui.b.a(r7, r2, new Intent((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"), SkillOpenAppManagementActivity.class));
    }

    private final void renderPageAvailability(boolean r7) {
        com.obric.aiagent.skill.ovirt.impl.b.a r0 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.a r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        LinearLayout r2 = r0.f21111a;
        int r3 = 0;
        if (r7 == false) goto L8;
        int r5 = 0;
    L9:
        r2.setVisibility(r5);
        com.obric.aiagent.skill.ovirt.impl.b.a r4 = this.binding;
        if (r4 != null) goto L12;
        d.h.b.o.c("binding");
        r4 = null;
    L12:
        OFloatingTitleBar r6 = r4.h;
        if (r7 == false) goto L15;
        int r8 = 0;
    L16:
        r6.setVisibility(r8);
        com.obric.aiagent.skill.ovirt.impl.b.a r9 = this.binding;
        if (r9 != null) goto L19;
        d.h.b.o.c("binding");
    L20:
        FrameLayout r10 = r1.i;
        if (r7 == false) goto L23;
        r3 = 8;
    L23:
        r10.setVisibility(r3);
        return;
    L19:
        r1 = r9;
        goto L20
    L15:
        r8 = 8;
        goto L16
    L8:
        r5 = 8;
        goto L9
    }
}
