package com.obric.autoaction.common.base;

import android.R;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.g;
import androidx.core.view.ViewCompat;
import androidx.core.view.ai;
import androidx.core.view.al;
import androidx.core.view.am;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.privacy.IPrivacyService;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.app.IAutoActionHostResProvider;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalStatus;
import com.obric.autogui.common.api.assistant.LaunchMethodClient;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.account.IAutoActionAccountApi;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: BaseActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseActivity extends AppCompatActivity {
    public static final a Companion = null;
    private static final String TAG = "BaseActivity";
    private final com.obric.autoaction.common.base.a extensionHolder;
    private volatile boolean isActive;

    /* JADX INFO: compiled from: BaseActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        public static /* synthetic */ al lambda$izCgGsc9Ash5ISlP1iKWOJ6bOqk(View r0, al r1) {
            return b(r0, r1);
        }

        public static /* synthetic */ al lambda$oElb2Fq8ZZcPceI6HtSU82JEf6Y(View r0, al r1) {
            return a(r0, r1);
        }

        private a() {
        }

        public static /* synthetic */ void a(a r1, FragmentActivity r2, boolean r3, int r4, Object r5) {
            FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L5;
            r3 = true;
        L5:
            r1.a(r6, r3);
        }

        public final void a(FragmentActivity r3, boolean r4) {
            FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
            o.e(r5, "<this>");
            if ((ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
            boolean r0 = true;
        L6:
            a(r5, r0, r4);
            a(r5);
            return;
        L5:
            r0 = false;
            goto L6
        }

        private final void a(FragmentActivity r3, boolean r4, boolean r5) {
            FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
            ai.a(r2.getWindow(), false);
            r2.getWindow().setStatusBarColor(0);
            if (r5 == false) goto L7;
            r2.getWindow().setNavigationBarColor(0);
            if (Build.VERSION.SDK_INT < 29) goto L7;
            r2.getWindow().setNavigationBarContrastEnforced(false);
        L7:
            ViewCompat.a(r2.findViewById(R.id.content), $$Lambda$BaseActivity$a$oElb2Fq8ZZcPceI6HtSU82JEf6Y.INSTANCE);
            am r6 = ai.a(r2.getWindow(), r2.getWindow().getDecorView());
            o.c(r6, "getInsetsController(...)");
            if (r4 == false) goto L12;
            r6.a(false);
            if (r5 == false) goto L16;
            r6.b(false);
            return;
        L16:
            return;
        L12:
            r6.a(true);
            if (r5 == false) goto L18;
            r6.b(true);
            return;
        }

        private static final al a(View r4, al r5) {
            o.e(r4, "view");
            o.e(r5, "windowInsets");
            g r0 = r5.a(al.m.f());
            o.c(r0, "getInsets(...)");
            r4.setPadding(r0.f1210b, r0.f1211c, r0.f1212d, 0);
            return r5;
        }

        private final void a(FragmentActivity r2) {
            FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.aiagent.plugin");
            r1.getWindow().setStatusBarColor(0);
            ViewCompat.a(r1.findViewById(R.id.content), $$Lambda$BaseActivity$a$izCgGsc9Ash5ISlP1iKWOJ6bOqk.INSTANCE);
        }

        private static final al b(View r3, al r4) {
            o.e(r3, "view");
            o.e(r4, "windowInsets");
            g r0 = r4.a(al.m.f());
            o.c(r0, "getInsets(...)");
            r3.setPadding(r0.f1210b, 0, r0.f1212d, 0);
            return r4;
        }
    }

    /* JADX INFO: compiled from: BaseActivity.kt */
    @f(b = "BaseActivity.kt", c = {210}, d = "checkLoggedOn", e = "com.obric.autoaction.common.base.BaseActivity")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f24621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseActivity f24622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f24623c;

        b(BaseActivity r3, d.c.d<? super b> r4) {
            BaseActivity r5 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r3, BaseActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24622b = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24621a = r3;
            this.f24623c |= Integer.MIN_VALUE;
            return BaseActivity.access$checkLoggedOn(this.f24622b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: BaseActivity.kt */
    @f(b = "BaseActivity.kt", c = {151, 154, 165}, d = "ensureUserLoginStatus", e = "com.obric.autoaction.common.base.BaseActivity")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseActivity f24626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24627d;

        c(BaseActivity r3, d.c.d<? super c> r4) {
            BaseActivity r5 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r3, BaseActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24626c = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24625b = r3;
            this.f24627d |= Integer.MIN_VALUE;
            return BaseActivity.access$ensureUserLoginStatus(this.f24626c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: BaseActivity.kt */
    @f(b = "BaseActivity.kt", c = {132}, d = "invokeSuspend", e = "com.obric.autoaction.common.base.BaseActivity$onResume$1")
    static final class d extends l implements m<kotlinx.coroutines.am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseActivity f24629b;

        d(BaseActivity r3, d.c.d<? super d> r4) {
            BaseActivity r5 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r3, BaseActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24629b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f24629b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24628a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            BaseActivity r6 = this.f24629b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24628a = 1;
            if (BaseActivity.access$ensureUserLoginStatus(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: BaseActivity.kt */
    @f(b = "BaseActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.common.base.BaseActivity$shutdown$1")
    static final class e extends l implements m<kotlinx.coroutines.am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseActivity f24631b;

        e(BaseActivity r3, d.c.d<? super e> r4) {
            BaseActivity r5 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r3, BaseActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24631b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f24631b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f24630a != 0) goto L7;
            d.o.a(r2);
            this.f24631b.finish();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$VLqbGStam6mE75MywYxX_laNZpk(com.obric.autoaction.common.base.a r0) {
        return configExtension$lambda$1(r0);
    }

    public d.h.a.b<com.obric.autoaction.common.base.a, x> configExtension() {
        return $$Lambda$BaseActivity$VLqbGStam6mE75MywYxX_laNZpk.INSTANCE;
    }

    public boolean skipPrivacyAndLoginCheck() {
        return false;
    }

    public BaseActivity() {
        this.extensionHolder = new com.obric.autoaction.common.base.a();
    }

    public static final /* synthetic */ Object access$checkLoggedOn(BaseActivity r2, d.c.d r3) {
        return ((BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.aiagent.plugin")).checkLoggedOn((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$ensureUserLoginStatus(BaseActivity r2, d.c.d r3) {
        return ((BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.aiagent.plugin")).ensureUserLoginStatus((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        LaunchMethodClient.INSTANCE.consumeLaunchMethod((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), getIntent());
        super.onCreate(r5);
        setupTaskDescription();
        configExtension().invoke(this.extensionHolder);
        this.extensionHolder.a((AppCompatActivity) ZeusTransformUtils.preCheckCast(this, AppCompatActivity.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.isActive = true;
        if (skipPrivacyAndLoginCheck() == false) goto L6;
        Loog.INSTANCE.i(TAG, "skip privacy and login check for " + this);
        return;
    L6:
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new d(this, null), m.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        this.isActive = false;
    }

    private final Object ensureUserLoginStatus(d.c.d<? super x> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r14, c.class, "com.obric.aiagent.plugin");
        if ((r1.f24627d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f24627d -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.f24625b;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f24627d;
        boolean r11 = true;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        BaseActivity this = (BaseActivity) ZeusTransformUtils.preCheckCast(r1.f24624a, BaseActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
    L36:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L41;
        if (this.isActive == false) goto L41;
        Loog.INSTANCE.e(TAG, "Not init the activity (" + this + ") as user not logged on.");
        String r16 = this.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.base_activity_user_not_logged_on, WsChannelMultiProcessSharedProvider.STRING_TYPE, "base_activity_user_not_logged_on"));
        o.c(r16, "getString(...)");
        this.shutdown(r16, 104003);
    L41:
        return x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        this = (BaseActivity) ZeusTransformUtils.preCheckCast(r1.f24624a, BaseActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
    L24:
        AssistantPrivacyApprovalStatus r17 = (AssistantPrivacyApprovalStatus) ZeusTransformUtils.preCheckCast(r15, AssistantPrivacyApprovalStatus.class, "com.obric.aiagent.plugin");
        IPrivacyService r0 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L27;
    L29:
        r11 = false;
    L30:
        if (r11 == false) goto L32;
        Loog.INSTANCE.e(TAG, "Not init the activity (" + this + ") as AssistantPrivacyApproval status = " + r17);
        String r18 = this.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.base_activity_privacy_not_approved, WsChannelMultiProcessSharedProvider.STRING_TYPE, "base_activity_privacy_not_approved"));
        o.c(r18, "getString(...)");
        this.shutdown(r18, 105002);
        goto L41
    L32:
        r1.f24624a = this;
        r1.f24627d = 3;
        r15 = this.checkLoggedOn(r1);
        if (r15 != r3) goto L36;
        return r3;
    L27:
        if (r0.isAgreed() == true) goto L29;
    L17:
        this = (BaseActivity) ZeusTransformUtils.preCheckCast(r1.f24624a, BaseActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
    L21:
        AssistantAbilityHelper r19 = AssistantAbilityHelper.INSTANCE;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r1.f24624a = this;
        r1.f24627d = 2;
        r15 = r19.checkPrivacyApprovalAsync(r2, r1);
        if (r15 != r3) goto L24;
        return r3;
    L18:
        d.o.a(r15);
        AutoActionFoundation r110 = AutoActionFoundation.INSTANCE;
        r1.f24624a = this;
        r1.f24627d = 1;
        if (r110.suspendUntilReady(r1) != r3) goto L21;
        return r3;
    L7:
        r1 = new c(this, r14);
        goto L8
    }

    private final void shutdown(String r9, int r10) {
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new e(this, null), m.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        AssistantAbilityHelper r1 = AssistantAbilityHelper.INSTANCE;     // Catch: Throwable -> L5
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        String r8 = getPackageName();     // Catch: Throwable -> L5
        o.c(r8, "getPackageName(...)");     // Catch: Throwable -> L5
        r1.openLogin(r2, r8);     // Catch: Throwable -> L5
        IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default((IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin"), null, r9, r10, null, null, 24, null);     // Catch: Throwable -> L5
        return;
    }

    private final Object checkLoggedOn(d.c.d<? super Boolean> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if ((r0.f24623c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24623c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f24621a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f24623c;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        d.o.a(r8);     // Catch: Throwable -> L21
    L19:
        Object r5 = n.f((IAutoActionAccountApi.LoggedOnCheckResult) ZeusTransformUtils.preCheckCast(r8, IAutoActionAccountApi.LoggedOnCheckResult.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
    L23:
        IAutoActionAccountApi.LoggedOnType r1 = null;
        if (n.b(r5) == false) goto L26;
        r5 = null;
    L26:
        IAutoActionAccountApi.LoggedOnCheckResult r9 = (IAutoActionAccountApi.LoggedOnCheckResult) ZeusTransformUtils.preCheckCast(r5, IAutoActionAccountApi.LoggedOnCheckResult.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "checkLoggedOn result: " + r9);
        if (r9 == null) goto L29;
        IAutoActionAccountApi.LoggedOnType r10 = r9.getType();
    L31:
        if (r10 == IAutoActionAccountApi.LoggedOnType.DOUBAO_NOT_LOGGED_ON) goto L38;
        if (r9 == null) goto L35;
        r1 = r9.getType();
    L35:
        if (r1 == IAutoActionAccountApi.LoggedOnType.SYSTEM_NOT_LOGGED_ON) goto L38;
        boolean r11 = false;
    L40:
        return d.c.b.a.b.a(!r11);
    L38:
        r11 = true;
        goto L40
    L29:
        r10 = null;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r8);
        n.a r12 = n.f38560a;     // Catch: Throwable -> L21
        BaseActivity r13 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        IAutoActionAccountApi r14 = AOPlatformTools.INSTANCE.account();     // Catch: Throwable -> L21
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        r0.f24623c = 1;     // Catch: Throwable -> L21
        r8 = r14.checkLoggedOn(r15, r0);     // Catch: Throwable -> L21
        if (r8 != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        n.a r16 = n.f38560a;
        r5 = n.f(d.o.a(th));
    L7:
        r0 = new b(this, r7);
        goto L8
    }

    private static final x configExtension$lambda$1(com.obric.autoaction.common.base.a r1) {
        o.e(r1, "<this>");
        return x.f38692a;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r4) {
        LaunchMethodClient.INSTANCE.consumeLaunchMethod((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r4);
        super.onNewIntent(r4);
    }

    public void finish() {
        super.finish();
    }

    private final void setupTaskDescription() {
    L17:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "setupTaskDescription failed", th);
        return;
    L4:
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return;
    L6:
        aa.b(IAutoActionHostResProvider.class);     // Catch: Throwable -> L17
        IAutoActionHostResProvider r1 = (IAutoActionHostResProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionHostResProvider.class), IAutoActionHostResProvider.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Drawable r2 = null;
        if (r1 == null) goto L9;
        Integer r3 = Integer.valueOf(r1.getAppIconRes());     // Catch: Throwable -> L17
    L10:
        if (r3 == null) goto L12;
        r2 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L17
    L12:
        String r4 = getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oauto_display_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_display_name"));     // Catch: Throwable -> L17
        o.c(r4, "getString(...)");     // Catch: Throwable -> L17
        if (r2 == null) goto L15;
        Bitmap r0 = Bitmap.createBitmap(d.l.n.c(r2.getIntrinsicWidth(), 1), d.l.n.c(r2.getIntrinsicHeight(), 1), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L17
        o.c(r0, "createBitmap(...)");     // Catch: Throwable -> L17
        Canvas r5 = new Canvas(r0);     // Catch: Throwable -> L17
        r2.setBounds(0, 0, r5.getWidth(), r5.getHeight());     // Catch: Throwable -> L17
        r2.draw(r5);     // Catch: Throwable -> L17
        setTaskDescription(new ActivityManager.TaskDescription(r4, r0));     // Catch: Throwable -> L17
        return;
    L15:
        ((BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.aiagent.plugin")).setTaskDescription(new ActivityManager.TaskDescription(r4));     // Catch: Throwable -> L17
        return;
    L9:
        r3 = null;
        goto L10
    }
}
