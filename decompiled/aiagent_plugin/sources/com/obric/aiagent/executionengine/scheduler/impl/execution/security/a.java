package com.obric.aiagent.executionengine.scheduler.impl.execution.security;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.obric.agent.auth.IAgentAuthService;
import com.obric.agent.trace.IIntentTraceService;
import com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.authentication.license.LicenseExecutePolicyInfo;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.h;
import d.c.b.a.l;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.aa;
import d.o;
import d.s;
import d.x;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AuthenticationProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AuthenticationProcessor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final IntentExecutePolicyItem f18429b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f18430c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f18431d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, IntentExecutePolicyGroup> f18432e = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.execution.security.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AuthenticationProcessor.kt */
    @d.c.b.a.f(b = "AuthenticationProcessor.kt", c = {208}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.execution.security.AuthenticationProcessor$getAuthTypeForDora$1")
    static final class C0382a extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18434b;

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.execution.security.a$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: AuthenticationProcessor.kt */
        @d.c.b.a.f(b = "AuthenticationProcessor.kt", c = {415}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.execution.security.AuthenticationProcessor$getAuthTypeForDora$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super Integer>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f18435a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f18436b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f18437c;

            AnonymousClass1(int r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f18437c = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super Integer> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f18437c, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f18436b;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r7);
            L16:
                return r7;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r7);
                final int r8 = this.f18437c;
                this.f18435a = r8;
                this.f18436b = 1;
                kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
                r4.e();
                final n r2 = (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin");
                IFlowUiIDL r3 = aw.a(aa.b(IFlowUiIDL.class));
                if (r3 == null) goto L11;
                r3.shouldDowngradeAuthForDora(r8, (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.preCheckCast(new AuthenticationProcessor$getAuthTypeForDora$1$1$1$1(r2, r8), IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin"));
            L11:
                r7 = r4.h();
                if (r7 != d.c.a.b.a()) goto L14;
                h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            L14:
                if (r7 != r0) goto L16;
                return r0;
            }
        }

        C0382a(int r3, d.c.d<? super C0382a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18434b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((C0382a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0382a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0382a(this.f18434b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18433a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L14;
            int r7 = r9.intValue();
        L16:
            return d.c.b.a.b.a(r7);
        L14:
            r7 = this.f18434b;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            m r10 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f18434b, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18433a = 1;
            r8 = dg.b(300, r10, r2);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AuthenticationProcessor.kt */
    @d.c.b.a.f(b = "AuthenticationProcessor.kt", c = {246, 256, 264}, d = "processRequiresAuthentication", e = "com.obric.aiagent.executionengine.scheduler.impl.execution.security.AuthenticationProcessor")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18441d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f18442e;
        final /* synthetic */ a f;
        int g;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18442e = r3;
            this.g |= Integer.MIN_VALUE;
            return a.a(this.f, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AuthenticationProcessor.kt */
    @d.c.b.a.f(b = "AuthenticationProcessor.kt", c = {358, 365, 388}, d = "processRequiresNotVoiceprintAuthentication", e = "com.obric.aiagent.executionengine.scheduler.impl.execution.security.AuthenticationProcessor")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18446d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f18447e;
        final /* synthetic */ a f;
        int g;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18447e = r3;
            this.g |= Integer.MIN_VALUE;
            return a.d(this.f, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AuthenticationProcessor.kt */
    @d.c.b.a.f(b = "AuthenticationProcessor.kt", c = {296}, d = "processRequiresOnlyVoiceprintAuthentication", e = "com.obric.aiagent.executionengine.scheduler.impl.execution.security.AuthenticationProcessor")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f18450c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18451d;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18450c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18449b = r3;
            this.f18451d |= Integer.MIN_VALUE;
            return a.b(this.f18450c, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AuthenticationProcessor.kt */
    @d.c.b.a.f(b = "AuthenticationProcessor.kt", c = {326, 337}, d = "processRequiresScreenUnlock", e = "com.obric.aiagent.executionengine.scheduler.impl.execution.security.AuthenticationProcessor")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f18454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18455d;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18454c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18453b = r3;
            this.f18455d |= Integer.MIN_VALUE;
            return a.c(this.f18454c, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$0eGZslWiRIYbGOsCgMRsyk4aT-A, reason: not valid java name */
    public static /* synthetic */ KeyguardManager m187lambda$0eGZslWiRIYbGOsCgMRsyk4aTA() {
        return d();
    }

    private a() {
    }

    public static final /* synthetic */ Object a(a r2, String r3, String r4, IMAppActionExt r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(a r2, String r3, String r4, IMAppActionExt r5, d.c.d r6) {
        return r2.b(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object c(a r2, String r3, String r4, IMAppActionExt r5, d.c.d r6) {
        return r2.c(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object d(a r2, String r3, String r4, IMAppActionExt r5, d.c.d r6) {
        return r2.d(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f18428a = new a();
        f18429b = new IntentExecutePolicyItem(4, "appfunc_execute");
        f18430c = ao.a(new d.m[]{s.a("common_chat_and_online_qa", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_CHAT_AND_ONLINE_QA), s.a("common_local_app_data_access", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("common_simple_command_execute", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE), s.a("common_auto_gui_execute", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_AUTO_GUI_EXECUTE), s.a("common_chat_history_access", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_CHAT_HISTORY_ACCESS), s.a("common_global_memory_access", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_GLOBAL_MEMORY_ACCESS), s.a("doubao_rtc", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_CHAT_AND_ONLINE_QA), s.a("new_conversation", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_CHAT_AND_ONLINE_QA), s.a("history_conversation", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_CHAT_HISTORY_ACCESS), s.a("camera", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE), s.a("system_settings", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE), s.a("audio_control", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE), s.a("netease_music", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE), s.a("clock_simple", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE), s.a("realtimecontext", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE), s.a("weather", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE), s.a("contacts", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("phone", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("messages", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("notes", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("system_settings_sensitive", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("personalcontext", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("clock", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("office", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a(IFlowAppIntentIDL.PERMISSION_CALENDAR, IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("recorder", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS), s.a("memory", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_GLOBAL_MEMORY_ACCESS), s.a("autogui", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_AUTO_GUI_EXECUTE), s.a("appfunc_execute", IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS)});
        f18431d = g.a($$Lambda$a$0eGZslWiRIYbGOsCgMRsyk4aTA.INSTANCE);
        f18432e = com.obric.aiagent.executionengine.scheduler.impl.execution.security.b.f18456a.a();
    }

    public final IntentExecutePolicyItem a() {
        return f18429b;
    }

    private final KeyguardManager b() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(f18431d.b(), KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private static final KeyguardManager d() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ Object a(a r10, String r11, String r12, IntentParams r13, IMAppActionExt r14, String r15, IntentExecutePolicyItem r16, d.c.d r17, int r18, Object r19) {
        IntentParams r5 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r13, IntentParams.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.m<Integer, String>> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r18 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        IntentExecutePolicyItem r8 = null;
    L11:
        return r10.a(r11, r12, r5, r14, r7, r8, r9);
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    public final Object a(String r3, String r4, IntentParams r5, IMAppActionExt r6, String r7, IntentExecutePolicyItem r8, d.c.d<? super d.m<Integer, String>> r9) {
        IntentParams r10 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r5, IntentParams.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.m<Integer, String>> r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        Integer r12 = a(r4, r10, r7, r8);
        if (r12 == null) goto L10;
        if (r12.intValue() != 0) goto L10;
        ILogDepend.Companion.i(TAG, r4 + " ALWAYS_ALLOWED");
        return null;
    L10:
        if (r12 == null) goto L17;
        if (r12.intValue() != 1) goto L17;
        return a(r3, r4, r6, r11);
    L17:
        if (r12 == null) goto L24;
        if (r12.intValue() != 2) goto L24;
        return b(r3, r4, r6, r11);
    L24:
        if (r12 == null) goto L31;
        if (r12.intValue() != 3) goto L31;
        return d(r3, r4, r6, r11);
    L31:
        if (r12 == null) goto L38;
        if (r12.intValue() != 4) goto L38;
        return c(r3, r4, r6, r11);
    L38:
        if (r12 == null) goto L45;
        if (r12.intValue() != 99) goto L45;
        return new d.m(d.c.b.a.b.a(112), ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_security_biometric_auth_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_security_biometric_auth_error")));
    L45:
        return new d.m(d.c.b.a.b.a(111), ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_security_auth_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_security_auth_error")));
    }

    private final Integer a(String r5, IntentParams r6, String r7, IntentExecutePolicyItem r8) {
        IntentParams r9 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r6, IntentParams.class, "com.obric.aiagent.plugin");
        IntentExecutePolicyGroup r0 = (IntentExecutePolicyGroup) ZeusTransformUtils.preCheckCast(f18432e.get(r5), IntentExecutePolicyGroup.class, "com.obric.aiagent.plugin");
        IntentExecutePolicyItem r2 = null;
        String r3 = null;
        if (r0 == null) goto L7;
        if (r9 == null) goto L6;
        r3 = r9.getSubActionValue();
    L6:
        r2 = r0.getSubActionPolicy(r3);
    L7:
        if (r2 != null) goto L19;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == true) goto L19;
        LicenseExecutePolicyInfo r12 = com.obric.aiagent.authentication.license.a.f16384a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r7, r5);
        if (r12 == null) goto L19;
        ILogDepend.Companion.i(TAG, "getPolicyType use license policy of " + r7 + " for " + r5 + ": type=" + r12.getType() + ", settingKey=" + r12.getSettingKey());
        r2 = new IntentExecutePolicyItem(r12.getType(), r12.getSettingKey());
        goto L19
    L11:
        if (r10.length() == 0) goto L14;
        r11 = false;
    L19:
        if (r2 != null) goto L23;
        if (r8 == null) goto L22;
    L24:
        String r13 = r8.getSettingKey();
        if (r13 == null) goto L32;
        Integer r4 = a(r13);
        if (r4 == null) goto L29;
        int r14 = r4.intValue();
    L33:
        return Integer.valueOf(r14);
    L29:
        r14 = r8.getType();
        goto L33
    L32:
        return Integer.valueOf(r8.getType());
    L22:
        return 3;
    L23:
        r8 = r2;
        goto L24
    }

    private final Integer a(String r9) {
        ILogDepend.Companion.i(TAG, "getAuthenticationTypeOnLockScreen " + r9);
        if (d.h.b.o.a(r9, "doubao_rtc") == true) goto L5;
        String r8 = (String) ZeusTransformUtils.preCheckCast(f18430c.get(r9), String.class, "com.obric.aiagent.plugin");
        IFlowSettingsIDL r1 = at.a(aa.b(IFlowSettingsIDL.class));
        Integer r4 = null;
        if (r1 == null) goto L9;
        Integer r10 = Integer.valueOf(f18428a.a(r1.getAuthenticationTypeOnLockScreen(r8)));
    L11:
        if (r10 != null) goto L14;
    L16:
        int r5 = 2;
        if (r10 != null) goto L20;
    L28:
        if (r10 != null) goto L31;
    L33:
        if (r10 != null) goto L36;
    L38:
        ILogDepend.Companion.i(TAG, "getAuthenticationTypeOnLockScreen " + r9 + " type = " + r4);
        return r4;
    L36:
        if (r10.intValue() != 3) goto L38;
        r4 = 99;
        goto L38
    L31:
        if (r10.intValue() != 2) goto L33;
        r4 = 0;
        goto L38
    L20:
        if (r10.intValue() != 1) goto L28;
        if (d.h.b.o.a(r9, "new_conversation") == false) goto L24;
    L27:
        r4 = Integer.valueOf(r5);
        goto L38
    L24:
        if (d.h.b.o.a(r9, "doubao_rtc") == true) goto L27;
        r5 = 1;
        goto L27
    L14:
        if (r10.intValue() != 0) goto L16;
        r4 = 3;
        goto L38
    L9:
        r10 = null;
        goto L11
    L5:
        return Integer.valueOf(c());
    }

    private final int c() {
        IFlowSettingsIDL r5 = at.a(aa.b(IFlowSettingsIDL.class));
        int r0 = 3;
        if (r5 != null) goto L5;
        return 3;
    L5:
        int r1 = r5.getAuthenticationTypeOnLockScreen(IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS);
        int r6 = r5.getAuthenticationTypeOnLockScreen(IFlowSettingsIDL.AUTHENTICATION_TYPE_SCENE_CHAT_HISTORY_ACCESS);
        if (r1 != 2) goto L9;
        if (r6 != 2) goto L9;
        r0 = 0;
    L9:
        ILogDepend.Companion.i(TAG, "getRealtimeCallPolicyTypeOnLockScreen localAppDataAuthType=" + r1 + ", chatHistoryAuthType=" + r6 + ", policyType=" + r0);
        return r0;
    }

    private final int a(int r3) {
        ILogDepend.Companion.i(TAG, "getAuthTypeForDora " + r3);
        return ((Number) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new C0382a(r3, null), m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    private final Object a(String r19, String r20, IMAppActionExt r21, d.c.d<? super d.m<Integer, String>> r22) {
        String r1 = r19;
        String r2 = r20;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L7;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        if ((r6.g & Integer.MIN_VALUE) == 0) goto L7;
        r6.g -= Integer.MIN_VALUE;
    L8:
        b r12 = r6;
        Object r5 = r12.f18442e;
        Object r7 = d.c.a.b.a();
        int r8 = r12.g;
        boolean r15 = false;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.f18438a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);
        boolean r3 = true;
    L116:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != r3) goto L118;
        r15 = r3;
    L118:
        ILogDepend.Companion.i(TAG, "requestDismissKeyguard " + r15);
        if (r15 == false) goto L125;
        IIntentTraceService r9 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L134;
        r9.onAuthEnd(r0);
        return null;
    L134:
        return null;
    L125:
        IIntentTraceService r10 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L129;
        r10.onAuthEnd(r0);
    L129:
        return new d.m(d.c.b.a.b.a(112), ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_security_biometric_auth_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_security_biometric_auth_error")));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Bundle r11 = (Bundle) ZeusTransformUtils.preCheckCast(r12.f18441d, Bundle.class, "com.obric.aiagent.plugin");
        IAgentAuthService r13 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(r12.f18440c, IAgentAuthService.class, "com.obric.aiagent.plugin");
        r2 = (String) ZeusTransformUtils.preCheckCast(r12.f18439b, String.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r12.f18438a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);
    L83:
        Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin");
        IAgentAuthService r17 = r13;
        r1 = r14;
        Integer r18 = r16;
    L85:
        ILogDepend.Companion.i(TAG, "requestBiometricAuth " + r18);
        if (r18 != null) goto L89;
    L95:
        Bundle r110 = r11;
        r0 = r1;
        String r23 = r2;
        IAgentAuthService r24 = r17;
    L96:
        if (r18 == null) goto L101;
        if (r18.intValue() == 2) goto L125;
    L101:
        if (r18 != null) goto L104;
    L105:
        if (r24 == null) goto L118;
        if (r18 != null) goto L108;
        boolean r25 = true;
    L110:
        boolean r111 = r25;
    L112:
        r12.f18438a = r0;
        r12.f18439b = null;
        r12.f18440c = null;
        r12.f18441d = null;
        r12.g = 3;
        r3 = r25;
        r5 = r24.requestDismissKeyguard(r23, r0, r111, r110, r12);
        if (r5 != r7) goto L116;
        return r7;
    L108:
        r25 = true;
        if (r18.intValue() != 1) goto L110;
        r111 = false;
        goto L112
    L104:
        if (r18.intValue() == 4) goto L125;
    L89:
        if (r18.intValue() != 0) goto L95;
        IIntentTraceService r26 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r26 == null) goto L133;
        r26.onAuthEnd(r1);
        return null;
    L133:
        return null;
    L17:
        r11 = (Bundle) ZeusTransformUtils.preCheckCast(r12.f18441d, Bundle.class, "com.obric.aiagent.plugin");
        IAgentAuthService r27 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(r12.f18440c, IAgentAuthService.class, "com.obric.aiagent.plugin");
        r2 = (String) ZeusTransformUtils.preCheckCast(r12.f18439b, String.class, "com.obric.aiagent.plugin");
        String r28 = (String) ZeusTransformUtils.preCheckCast(r12.f18438a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r17 = r27;
        r1 = r28;
        Object r29 = r5;
    L40:
        Integer r30 = (Integer) ZeusTransformUtils.preCheckCast(r29, Integer.class, "com.obric.aiagent.plugin");
    L42:
        if (r30 != null) goto L45;
    L47:
        boolean r31 = false;
    L48:
        ILogDepend.Companion.i(TAG, "requestVoiceprintAuth " + r31);
        if (r31 == false) goto L55;
        IIntentTraceService r32 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r32 == null) goto L132;
        r32.onAuthEnd(r1);
        return null;
    L132:
        return null;
    L55:
        IFlowUiIDL r33 = aw.a(aa.b(IFlowUiIDL.class));
        if (r33 == null) goto L60;
        boolean r34 = true;
        if (r33.isAudioMessage(r1) != true) goto L61;
        boolean r112 = true;
    L62:
        if (r112 == false) goto L78;
        IFlowUiIDL r35 = aw.a(aa.b(IFlowUiIDL.class));
        if (r35 != null) goto L66;
    L68:
        boolean r36 = false;
    L69:
        if (r36 == false) goto L78;
        if (r30 == null) goto L75;
        if (r30.intValue() == 3) goto L78;
    L75:
        if (ObricProductSdk.INSTANCE.featureService().isFeatureEnable("obric_feature_check_device_locked") == false) goto L78;
        r110 = r11;
        r0 = r1;
        r23 = r2;
        r24 = r17;
        r18 = null;
        goto L96
    L66:
        if (r35.isAssistantRequestFromAIKey() != r34) goto L68;
        r36 = true;
    L78:
        if (r17 == null) goto L84;
        r12.f18438a = r1;
        r12.f18439b = r2;
        r12.f18440c = r17;
        r12.f18441d = r11;
        r12.g = 2;
        Object r37 = r17.requestBiometricAuth(r2, r1, r11, r12);
        if (r37 != r7) goto L82;
        return r7;
    L82:
        r14 = r1;
        r13 = r17;
        r5 = r37;
        goto L83
    L84:
        r18 = null;
    L61:
        r112 = false;
        goto L62
    L60:
        r34 = true;
        goto L61
    L45:
        if (r30.intValue() != 0) goto L47;
        r31 = true;
        goto L48
    L18:
        o.a(r5);
        r17 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");
        boolean r38 = b().isDeviceLocked();
        if (r17 == null) goto L25;
        Authentication r113 = r17.isAuthPass(r2, r1);
        if (r113 == null) goto L25;
        if (r113.isPass() != true) goto L25;
        boolean r114 = true;
    L26:
        boolean r39 = a(r21, r2);
        boolean r40 = a(r21);
        r11 = a(r1, r21);
        ILogDepend.Companion.i(TAG, r2 + " REQUIRES_AUTHENTICATION isDeviceLocked = " + r38 + " isAuthPass = " + r114 + " isComplexTask = " + r39 + " shouldSkipAuthentication = " + r40);
        IFlowUiIDL r41 = aw.a(aa.b(IFlowUiIDL.class));
        if (r41 == null) goto L29;
        r41.processRequiresAuthentication();
    L29:
        if (r39 == true) goto L130;
        if (r40 == true) goto L135;
        if (r38 == false) goto L136;
        if (r114 == true) goto L137;
        IIntentTraceService r42 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r42 == null) goto L36;
        r42.onAuthBegin(r1, 0);
    L36:
        if (r17 == null) goto L41;
        r12.f18438a = r1;
        r12.f18439b = r2;
        r12.f18440c = r17;
        r12.f18441d = r11;
        r12.g = 1;
        r29 = r17.requestVoiceprintAuth(r2, r1, r11, r12);
        if (r29 != r7) goto L40;
        return r7;
    L41:
        r30 = null;
        goto L42
    L137:
        return null;
    L136:
        return null;
    L135:
        return null;
    L130:
        return null;
    L25:
        r114 = false;
    L7:
        r6 = new b(this, r4);
        goto L8
    }

    private final Object b(String r17, String r18, IMAppActionExt r19, d.c.d<? super d.m<Integer, String>> r20) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L7;
        d r6 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
        if ((r6.f18451d & Integer.MIN_VALUE) == 0) goto L7;
        r6.f18451d -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.f18449b;
        Object r7 = d.c.a.b.a();
        int r8 = r6.f18451d;
        boolean r11 = false;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.f18448a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);
        boolean r3 = true;
    L35:
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin");
    L37:
        if (r1 != null) goto L40;
    L42:
        ILogDepend.Companion.i(TAG, "requestVoiceprintAuth " + r11);
        if (r11 == false) goto L49;
        IIntentTraceService r2 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L56;
        r2.onAuthEnd(r0);
        return null;
    L56:
        return null;
    L49:
        IIntentTraceService r9 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L53;
        r9.onAuthEnd(r0);
    L53:
        return new d.m(d.c.b.a.b.a(112), ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_security_biometric_auth_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_security_biometric_auth_error")));
    L40:
        if (r1.intValue() != 0) goto L42;
        r11 = r3;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r5);
        IAgentAuthService r10 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");
        boolean r12 = b().isDeviceLocked();
        if (r10 == null) goto L21;
        Authentication r13 = r10.isAuthPass(r18, r17);
        if (r13 == null) goto L21;
        if (r13.isPass() != true) goto L21;
        boolean r14 = true;
    L22:
        boolean r15 = a(r19, r18);
        boolean r16 = a(r19);
        Bundle r21 = a(r17, r19);
        ILogDepend.Companion.i(TAG, r18 + " REQUIRES_AUTHENTICATION isDeviceLocked = " + r12 + " isAuthPass = " + r14 + " isComplexTask = " + r15 + " shouldSkipAuthentication = " + r16);
        if (r15 == true) goto L54;
        if (r16 == true) goto L57;
        if (r12 == false) goto L58;
        if (r14 == true) goto L59;
        IIntentTraceService r22 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L30;
        r22.onAuthBegin(r17, 0);
    L30:
        if (r10 == null) goto L36;
        r6.f18448a = r17;
        r3 = true;
        r6.f18451d = 1;
        r5 = r10.requestVoiceprintAuth(r18, r17, r21, r6);
        if (r5 != r7) goto L34;
        return r7;
    L34:
        r0 = r17;
        goto L35
    L36:
        r3 = true;
        r0 = r17;
        r1 = null;
        goto L37
    L59:
        return null;
    L58:
        return null;
    L57:
        return null;
    L54:
        return null;
    L21:
        r14 = false;
    L7:
        r6 = new d(this, r4);
        goto L8
    }

    private final Object c(String r18, String r19, IMAppActionExt r20, d.c.d<? super d.m<Integer, String>> r21) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L7;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if ((r4.f18455d & Integer.MIN_VALUE) == 0) goto L7;
        r4.f18455d -= Integer.MIN_VALUE;
    L8:
        e r5 = r4;
        Object r6 = r5.f18453b;
        Object r10 = d.c.a.b.a();
        int r7 = r5.f18455d;
        boolean r13 = false;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r5.f18452a, String.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L52:
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin");
    L54:
        IIntentTraceService r2 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L63;
        r2.onAuthEnd(r0);
        return null;
    L63:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5.f18452a, String.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L31:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != true) goto L34;
        r13 = true;
    L34:
        IIntentTraceService r9 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L37;
        r9.onAuthEnd(r8);
    L37:
        ILogDepend.Companion.i(TAG, "requestDismissKeyguard " + r13);
        if (r13 == false) goto L41;
        return null;
    L41:
        return new d.m(d.c.b.a.b.a(112), ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_security_lockscreen_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_security_lockscreen_error")));
    L16:
        o.a(r6);
        boolean r11 = b().isDeviceLocked();
        boolean r12 = b().isKeyguardLocked();
        boolean r14 = a(r20, r19);
        boolean r15 = a(r20);
        Bundle r16 = a(r18, r20);
        ILogDepend.Companion.i(TAG, r19 + " REQUIRES_SCREEN_UNLOCK isDeviceLocked = " + r11 + " isKeyguardLocked = " + r12 + " isComplexTask = " + r14 + " shouldSkipAuthentication = " + r15);
        if (r14 == true) goto L59;
        if (r15 == true) goto L64;
        if (r11 == false) goto L42;
        IIntentTraceService r17 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L24;
        r17.onAuthBegin(r18, 0);
    L24:
        IAgentAuthService r22 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L33;
        r5.f18452a = r18;
        r5.f18455d = 1;
        r6 = IAgentAuthService.b.a(r22, r19, r18, false, r16, r5, 4, null);
        if (r6 != r10) goto L29;
        return r10;
    L29:
        r8 = r18;
        goto L31
    L33:
        r8 = r18;
        goto L34
    L42:
        if (r12 == false) goto L62;
        IIntentTraceService r23 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L46;
        r23.onAuthBegin(r18, 0);
    L46:
        IAgentAuthService r24 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L53;
        r5.f18452a = r18;
        r5.f18455d = 2;
        r6 = IAgentAuthService.b.a(r24, r19, r18, false, r16, r5, 4, null);
        if (r6 != r10) goto L51;
        return r10;
    L51:
        r0 = r18;
        goto L52
    L53:
        r0 = r18;
        goto L54
    L62:
        return null;
    L64:
        return null;
    L59:
        return null;
    L7:
        r4 = new e(this, r3);
        goto L8
    }

    private final Object d(String r20, String r21, IMAppActionExt r22, d.c.d<? super d.m<Integer, String>> r23) {
        String r8 = r20;
        String r1 = r21;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L7;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        c r15 = r4;
        Object r5 = r15.f18447e;
        Object r7 = d.c.a.b.a();
        int r6 = r15.g;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r15.f18443a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);
        Object r17 = null;
    L116:
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin");
    L118:
        IIntentTraceService r9 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L121;
        r9.onAuthEnd(r0);
    L121:
        return r17;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r15.f18443a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);
        Object r11 = r5;
        boolean r12 = true;
        boolean r13 = false;
        Object r18 = null;
    L83:
        r8 = r10;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != r12) goto L86;
        boolean r14 = r12;
    L88:
        ILogDepend.Companion.i(TAG, "requestDismissKeyguard " + r14);
        if (r14 == false) goto L94;
        IIntentTraceService r16 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L93;
        r16.onAuthEnd(r8);
    L93:
        return r18;
    L94:
        IIntentTraceService r19 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L98;
        r19.onAuthEnd(r8);
    L98:
        return new d.m(d.c.b.a.b.a(112), ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_security_biometric_auth_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_security_biometric_auth_error")));
    L86:
        r14 = r13;
        goto L88
    L17:
        Bundle r24 = (Bundle) ZeusTransformUtils.preCheckCast(r15.f18446d, Bundle.class, "com.obric.aiagent.plugin");
        IAgentAuthService r25 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(r15.f18445c, IAgentAuthService.class, "com.obric.aiagent.plugin");
        String r26 = (String) ZeusTransformUtils.preCheckCast(r15.f18444b, String.class, "com.obric.aiagent.plugin");
        String r27 = (String) ZeusTransformUtils.preCheckCast(r15.f18443a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r8 = r27;
        boolean r28 = false;
        IAgentAuthService r29 = r25;
        r1 = r26;
        Object r30 = r5;
    L51:
        Integer r31 = (Integer) ZeusTransformUtils.preCheckCast(r30, Integer.class, "com.obric.aiagent.plugin");
        Bundle r110 = r24;
        String r111 = r1;
        IAgentAuthService r112 = r29;
    L53:
        ILogDepend.Companion.i(TAG, "requestBiometricAuth " + r31);
        if (r31 != null) goto L57;
    L63:
        if (r31 == null) goto L68;
        if (r31.intValue() == 2) goto L94;
    L68:
        if (r31 != null) goto L71;
    L72:
        if (r112 == null) goto L87;
        if (r31 != null) goto L75;
        r12 = true;
    L77:
        boolean r113 = r12;
    L79:
        r15.f18443a = r8;
        r15.f18444b = null;
        r15.f18445c = null;
        r15.f18446d = null;
        r15.g = 2;
        r13 = r28;
        r18 = null;
        Object r32 = r112.requestDismissKeyguard(r111, r8, r113, r110, r15);
        if (r32 != r7) goto L82;
        return r7;
    L82:
        r11 = r32;
        r10 = r8;
        goto L83
    L75:
        r12 = true;
        if (r31.intValue() != 1) goto L77;
        r113 = r28;
        goto L79
    L87:
        r13 = r28;
        r18 = null;
        goto L86
    L71:
        if (r31.intValue() == 4) goto L94;
    L57:
        if (r31.intValue() != 0) goto L63;
        IIntentTraceService r33 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r33 == null) goto L122;
        r33.onAuthEnd(r8);
        return null;
    L122:
        return null;
    L18:
        o.a(r5);
        r29 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");
        boolean r34 = b().isDeviceLocked();
        if (r29 == null) goto L35;
        Authentication r114 = r29.isAuthPass(r1, r8);
        if (r114 == null) goto L35;
        if (r114.isPass() == false) goto L35;
        Integer r115 = r114.getType();
        if (r115 != null) goto L28;
    L29:
        Integer r116 = r114.getType();
        if (r116 == null) goto L35;
        if (r116.intValue() != 3) goto L35;
    L34:
        boolean r117 = true;
    L36:
        boolean r118 = a(r22, r1);
        boolean r35 = a(r22);
        Bundle r36 = a(r8, r22);
        ILogDepend.Companion.i(TAG, r1 + " REQUIRES_NOT_VOICEPRINT_AUTHENTICATION isDeviceLocked = " + r34 + " isAuthPass = " + r117 + " isComplexTask = " + r118 + " shouldSkipAuthentication = " + r35);
        IFlowUiIDL r119 = aw.a(aa.b(IFlowUiIDL.class));
        if (r119 == null) goto L39;
        r119.processRequiresAuthentication();
    L39:
        if (r118 == true) goto L99;
        if (r35 == true) goto L99;
        if (r34 == false) goto L99;
        if (r117 == true) goto L99;
        IIntentTraceService r37 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        r28 = false;
        if (r37 == null) goto L46;
        r37.onAuthBegin(r8, 0);
    L46:
        if (r29 == null) goto L52;
        r15.f18443a = r8;
        r15.f18444b = r1;
        r15.f18445c = r29;
        r15.f18446d = r36;
        r15.g = 1;
        Object r38 = r29.requestBiometricAuth(r1, r8, r36, r15);
        if (r38 != r7) goto L50;
        return r7;
    L50:
        r30 = r38;
        r24 = r36;
        goto L51
    L52:
        r111 = r1;
        r110 = r36;
        r112 = r29;
        r31 = null;
    L99:
        r17 = null;
        String r39 = ObricProductSdk.INSTANCE.featureService().getObricProductName();
        if (d.h.b.o.a(r39, IFeatureServiceKt.PRODUCT_GENESIS_R) == true) goto L104;
        if (d.h.b.o.a(r39, IFeatureServiceKt.PRODUCT_GENESIS_M) == false) goto L121;
    L104:
        if (d.h.b.o.a(r1, "Notes_Create") == false) goto L121;
        if (b().isKeyguardLocked() == false) goto L121;
        IIntentTraceService r40 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r40 == null) goto L110;
        r40.onAuthBegin(r8, 0);
    L110:
        IAgentAuthService r41 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");
        if (r41 == null) goto L117;
        r15.f18443a = r8;
        r15.g = 3;
        r5 = IAgentAuthService.b.a(r41, r21, r20, false, r36, r15, 4, null);
        if (r5 != r7) goto L115;
        return r7;
    L115:
        r0 = r8;
        goto L116
    L117:
        r0 = r8;
        goto L118
    L28:
        if (r115.intValue() == 2) goto L34;
    L35:
        r117 = false;
    L7:
        r4 = new c(this, r3);
        goto L8
    }

    private final boolean a(IMAppActionExt r4, String r5) {
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L7:
        if (d.h.b.o.a(r1, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == true) goto L13;
        if (r4 == null) goto L11;
        r0 = (String) ZeusTransformUtils.preCheckCast(r4.get("long_task_state"), String.class, "com.obric.aiagent.plugin");
    L11:
        if (d.h.b.o.a(r0, InitTaskProcess.MAIN) == true) goto L13;
    L17:
        return false;
    L13:
        if (d.h.b.o.a(r5, "System_UserAuthorize") == true) goto L17;
        if (d.h.b.o.a(r5, "Doubao_RealTimeScreenShare") == true) goto L17;
        return true;
    L5:
        r1 = null;
        goto L7
    }

    private final boolean a(IMAppActionExt r2) {
        if (r2 == null) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r2.get("o_skip_authentication"), String.class, "com.obric.aiagent.plugin");
    L6:
        return d.h.b.o.a(r1, "1");
    L4:
        r1 = null;
        goto L6
    }

    private final Bundle a(String r2, IMAppActionExt r3) {
        Bundle r1 = new Bundle();
        r1.putString("message_id", r2);
        if (r3 == null) goto L5;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L6:
        r1.putInt("is_omni", d.h.b.o.a(r4, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) ? 1 : 0);
        return r1;
    L5:
        r4 = null;
        goto L6
    }
}
