package com.obric.aiagent.security;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.google.protobuf.DescriptorProtos;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.account.IAccountService;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: AiAgentSecurityServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AiAgentSecurityServiceImpl implements IAiAgentSecurityService {
    public static final a Companion = null;
    private static final String HTTPS = "https://";
    private static final String MSSDK_PASSPORT_TOKEN = "mssdk.bytedance.com";
    private static final String TAG = "AiAgentSecurityServiceImpl";

    /* JADX INFO: compiled from: AiAgentSecurityServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AiAgentSecurityServiceImpl.kt */
    @f(b = "AiAgentSecurityServiceImpl.kt", c = {126}, d = "invokeSuspend", e = "com.obric.aiagent.security.AiAgentSecurityServiceImpl$initMsInternal$2")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18924a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18924a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            ILogDepend.Companion.i(AiAgentSecurityServiceImpl.TAG, "switch to default collect mode after 30s");
            com.bytedance.mobsec.metasec.ml.d.a(String.valueOf(IAppContext.Companion.getOldAiagentAppId())).a(DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18924a = 1;
            if (ax.a(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, r7) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AiAgentSecurityServiceImpl.kt */
    public static final class c implements com.obric.aiagent.account.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AiAgentSecurityServiceImpl f18925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f18926b;

        public static /* synthetic */ x lambda$p_OsoaiPpC7C_NlWpKYWOKtuON0(AiAgentSecurityServiceImpl r0, Context r1, String r2, String r3, String r4) {
            return a(r0, r1, r2, r3, r4);
        }

        @Override // com.obric.aiagent.account.a
        public void a() {
        }

        c(AiAgentSecurityServiceImpl r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f18925a = r3;
            this.f18926b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.account.a
        public void b() {
            ITraceDepend.Companion r0 = ITraceDepend.Companion;
            final AiAgentSecurityServiceImpl r1 = this.f18925a;
            final Context r2 = this.f18926b;
            r0.awaitTraceId(new $$Lambda$AiAgentSecurityServiceImpl$c$p_OsoaiPpC7C_NlWpKYWOKtuON0(r1, r2));
            IAccountService r3 = (IAccountService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAccountService.class), IAccountService.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L6;
            r3.unregisterAccountStatusCallback((com.obric.aiagent.account.a) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.account.a.class, "com.obric.aiagent.plugin"));
            return;
        }

        private static final x a(AiAgentSecurityServiceImpl r2, Context r3, String r4, String r5, String r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "<unused var>");
            d.h.b.o.e(r5, "<unused var>");
            d.h.b.o.e(r6, "<unused var>");
            AiAgentSecurityServiceImpl.access$report(r2, r7, "login", true);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: AiAgentSecurityServiceImpl.kt */
    @f(b = "AiAgentSecurityServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.security.AiAgentSecurityServiceImpl$report$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f18929c;

        d(String r3, boolean r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18928b = r3;
            this.f18929c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f18928b, this.f18929c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f18927a != 0) goto L29;
            o.a(r7);
            com.bytedance.mobsec.metasec.ml.c r8 = com.bytedance.mobsec.metasec.ml.d.a(String.valueOf(IAppContext.Companion.getOldAiagentAppId()));
            ILogDepend.Companion.i(AiAgentSecurityServiceImpl.TAG, "report, scene: " + this.f18928b + ", withDid: " + this.f18929c + ", mgr: " + r8);
            String r1 = null;
            boolean r2 = true;
            if (this.f18929c == false) goto L15;
            String r0 = ITraceDepend.Companion.getDeviceId();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == true) goto L13;
            r0 = null;
        L13:
            if (r0 == null) goto L15;
            r8.a(r0);
            goto L15
        L9:
            r5 = false;
        L15:
            String r3 = ITraceDepend.Companion.getInstallId();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L19;
            r2 = false;
        L19:
            if (r2 == false) goto L21;
            r1 = r3;
        L21:
            if (r1 == null) goto L23;
            r8.b(r1);
        L23:
            r8.d(this.f18928b);
            IAppLog r9 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L27;
            JSONObject r4 = new JSONObject();
            r4.put(DBHelper.BATTERY_COL_SCENE, this.f18928b);
            x r6 = x.f38692a;
            r9.report("ai_agent_ms_report", r4);
        L27:
            return x.f38692a;
        L29:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ boolean lambda$5d7CJRh97C3jgHy2lHgRRqr9mqY(String r0) {
        return initMsInternal$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$Z4POsQMQS0fQuUpWK9sraKQcTMk(AiAgentSecurityServiceImpl r0, Context r1, IFlowAppIntentIDL r2) {
        msInit$lambda$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$sFlSxDjxAkKX6O-hdDQ_--mTPhk, reason: not valid java name */
    public static /* synthetic */ x m248lambda$sFlSxDjxAkKX6OhdDQ_mTPhk(AiAgentSecurityServiceImpl r0, Context r1, String r2, String r3, String r4) {
        return msInit$lambda$1$lambda$0(r0, r1, r2, r3, r4);
    }

    public AiAgentSecurityServiceImpl() {
    }

    public static final /* synthetic */ void access$report(AiAgentSecurityServiceImpl r2, Context r3, String r4, boolean r5) {
        r2.report((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.obric.aiagent.security.IAiAgentSecurityService
    public void msInit(Context r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "appContext");
        ILogDepend.Companion.i(TAG, "msInit isLogin, register IPC");
        r.a(aa.b(IFlowAppIntentIDL.class), false, false, new $$Lambda$AiAgentSecurityServiceImpl$Z4POsQMQS0fQuUpWK9sraKQcTMk(this, r9), 3, null);
    }

    private static final void msInit$lambda$1(final AiAgentSecurityServiceImpl r7, Context r8, IFlowAppIntentIDL r9) {
        final Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        IFlowAppIntentIDL r11 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r9, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "it");
        boolean r0 = false;
        if (r11.isLogin() != true) goto L5;
        boolean r12 = true;
    L6:
        ILogDepend.Companion.i(TAG, "msInit isLogin: " + r12);
        r7.initMsInternal(r10, r12, r12);
        if (r12 == false) goto L14;
        ISecureLogDepend.Companion.i(TAG, "msInit, before awaitTraceId, " + ITraceDepend.Companion.getDeviceId());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(ITraceDepend.Companion.getDeviceId(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        r0 = true;
    L11:
        if (r0 == false) goto L13;
        ILogDepend.Companion.i(TAG, "msInit, before awaitTraceId, direct report");
        r7.report(r10, "cold_start", true);
        return;
    L13:
        ITraceDepend.Companion.awaitTraceId(new $$Lambda$AiAgentSecurityServiceImpl$sFlSxDjxAkKX6OhdDQ_mTPhk(r7, r10));
        return;
    L14:
        r7.report(r10, "cold_start", false);
        IAccountService r13 = (IAccountService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAccountService.class), IAccountService.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L20;
        r13.registerAccountStatusCallback((com.obric.aiagent.account.a) ZeusTransformUtils.preCheckCast(new c(r7, r10), com.obric.aiagent.account.a.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        return;
    L5:
        r12 = false;
        goto L6
    }

    private static final x msInit$lambda$1$lambda$0(AiAgentSecurityServiceImpl r2, Context r3, String r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "did");
        d.h.b.o.e(r5, WsConstants.KEY_INSTALL_ID);
        d.h.b.o.e(r6, "ssid");
        ILogDepend.Companion.i(TAG, "msInit awaitTraceId, success");
        r2.report(r7, "cold_start", true);
        return x.f38692a;
    }

    @Override // com.obric.aiagent.security.IAiAgentSecurityService
    public void msReport(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        d.h.b.o.e(r4, DBHelper.BATTERY_COL_SCENE);
        IFlowAppIntentIDL r0 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r0 == null) goto L5;
        boolean r1 = r0.isLogin();
    L6:
        report(r5, r4, r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initMsInternal(Context r10, boolean r11, boolean r12) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.mobsec.metasec.ml.b.a r13 = new com.bytedance.mobsec.metasec.ml.b.a(String.valueOf(IAppContext.Companion.getOldAiagentAppId()), IAppContext.Companion.getMsSdkLicense(), 810);
        ILogDepend.Companion.i(TAG, "initMsInternal, isLogin: " + r11 + ", privacyAccepted: " + r12 + ", IAppContext.getOldAiagentAppId(): " + IAppContext.Companion.getOldAiagentAppId());
        r13.b("kS1", "1");
        r13.b($$Lambda$AiAgentSecurityServiceImpl$5d7CJRh97C3jgHy2lHgRRqr9mqY.INSTANCE);
        boolean r14 = false;
        r13.b(0);
        r13.h(IAppContext.Companion.getBuildChannel());
        r13.f("https://mssdk.bytedance.com");
        if (r12 == false) goto L10;
        String r2 = ITraceDepend.Companion.getDeviceId();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L7;
        Object[] r3 = true;
    L8:
        if (r3 == false) goto L10;
        r13.g(r2);
        int r4 = 1;
    L11:
        String r5 = ITraceDepend.Companion.getInstallId();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L14;
        r14 = true;
    L14:
        if (r14 == false) goto L16;
        r13.i(r5);
    L16:
        com.bytedance.mobsec.metasec.ml.d.a(r9, r13.c());
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 3, null);
        IAppLog r15 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L20;
        JSONObject r16 = new JSONObject();
        r16.put("with_did", r4);
        r16.put("privacy_accepted", r12 ? 1 : 0);
        x r17 = x.f38692a;
        r15.report("ai_agent_ms_sdk_init", r16);
        return;
    L20:
        return;
    L7:
        r3 = false;
    L10:
        r4 = 0;
        goto L11
    }

    private static final boolean initMsInternal$lambda$2(String r3) {
        ILogDepend.Companion.i(TAG, "isComplianceScene " + r3);
        return com.obric.aiagent.security.a.f18930a.a().contains(r3);
    }

    private final void report(Context r8, String r9, boolean r10) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new d(r9, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
