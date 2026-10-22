package com.obric.agent.f;

import android.app.Application;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.agent.IAppIntentFeedback;
import com.obric.agent.ObricService;
import com.obric.agent.dm.e;
import com.obric.agent.utils.n;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.SystemSwitchModeParams;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: SystemSwitchModeProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.obric.agent.f.a {
    private static final String TAG = "SystemSwitchModeProcess";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14553a = null;

    /* JADX INFO: compiled from: SystemSwitchModeProcessor.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SystemSwitchModeProcessor.kt */
    public static final class b implements n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IntentAppAction f14554a;

        /* JADX INFO: compiled from: SystemSwitchModeProcessor.kt */
        @f(b = "SystemSwitchModeProcessor.kt", c = {136}, d = "invokeSuspend", e = "com.obric.agent.internal.SystemSwitchModeProcessor$addSwitchModeDeferIntent$1$runAfterServerReply$1")
        static final class a extends l implements m<am, d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f14555a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ IntentAppAction f14556b;

            a(IntentAppAction r3, d<? super a> r4) {
                d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                this.f14556b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r2, d<?> r3) {
                d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new a(this.f14556b, r4), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f14555a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L11:
                com.obric.capability.schedulekit.a r7 = com.obric.capability.schedulekit.a.f31846a;
                String r5 = ObricService.INSTANCE.getGson().toJson(this.f14556b);
                d.h.b.o.c(r5, "toJson(...)");
                r7.a(r5, false);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                d r8 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
                this.f14555a = 1;
                if (ax.a(WsConstants.EXIT_DELAY_TIME, r8) != r0) goto L11;
                return r0;
            }
        }

        b(IntentAppAction r1) {
            this.f14554a = r1;
        }

        @Override // com.obric.agent.utils.n.a
        public void a() {
            i.a(com.obric.agent.a.f14212a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new a(this.f14554a, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.f.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SystemSwitchModeProcessor.kt */
    public static final class C0290c implements com.obric.agent.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f14557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f14558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IntentAppAction f14559c;

        C0290c(long r1, c r3, IntentAppAction r4) {
            this.f14557a = r1;
            this.f14558b = r3;
            this.f14559c = r4;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r7, JobResult r8, d<? super x> r9) {
            d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            if (r7.getMessageId() != this.f14557a) goto L25;
            ILogDepend.Companion.d(c.TAG, "System_SettingsAvailable local action finished");
            boolean r11 = true;
            if (r8 == null) goto L11;
            List<IntentExecutionRecord> r2 = r8.getExecRecords();
            if (r2 == null) goto L11;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L11;
        L12:
            if (r11 == false) goto L21;
            int r12 = ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r8.getExecRecords().get(0), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getResult().getRet();
            ILogDepend.Companion.d(c.TAG, "System_SettingsAvailable resultCode: " + r12);
            if (r12 != 0) goto L17;
            c.a(this.f14558b, this.f14559c);
            goto L21
        L17:
            if (r12 != (-2005)) goto L19;
            String r13 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_exec_close_network_failed_no_impl_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_exec_close_network_failed_no_impl_found"));
        L20:
            c.a(this.f14558b, this.f14559c, r12, r13);
            goto L21
        L19:
            r13 = ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r8.getExecRecords().get(0), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getResult().getDetails();
        L21:
            IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L25;
            r14.removeActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(this, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
        L11:
            r11 = false;
        L25:
            return x.f38692a;
        }
    }

    static {
        f14553a = new a(null);
    }

    public c() {
    }

    public static final /* synthetic */ void a(c r0, IntentAppAction r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(c r0, IntentAppAction r1, int r2, String r3) {
        r0.a(r1, r2, r3);
    }

    @Override // com.obric.agent.f.a
    public boolean a(IntentAppAction r5, String r6) {
        d.h.b.o.e(r5, "action");
        d.h.b.o.e(r6, "actionName");
        if (d.h.b.o.a("System_SwitchMode", r6) == false) goto L35;
        e r4 = (e) ZeusTransformUtils.preCheckCast(ObricService.INSTANCE.getGson().fromJson(JsonParser.parseString(r5.getContent()).getAsJsonObject().get("Content").getAsString(), e.class), e.class, "com.obric.aiagent.plugin");
        JsonObject r7 = null;
        if (r4 == null) goto L13;
        List<com.obric.agent.dm.f> r8 = r4.a();
        if (r8 == null) goto L13;
        com.obric.agent.dm.f r9 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(p.l(r8), com.obric.agent.dm.f.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        List<com.obric.agent.dm.b> r10 = r9.a();
        if (r10 == null) goto L13;
        com.obric.agent.dm.b r11 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(p.n(r10), com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");
    L14:
        if (r11 == null) goto L18;
        JsonObject r12 = r11.c();
        if (r12 == null) goto L18;
        r7 = r12.getAsJsonObject();
    L18:
        if (r7 == null) goto L35;
        SystemSwitchModeParams r13 = (SystemSwitchModeParams) ZeusTransformUtils.preCheckCast(com.obric.agent.utils.b.f15994a.a(r7, SystemSwitchModeParams.class), SystemSwitchModeParams.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L35;
        if (d.h.b.o.a(r13.getEnable(), true) == false) goto L26;
        if (d.h.b.o.a(r13.getMode(), "airplane") == false) goto L26;
    L33:
        ILogDepend.Companion.d(TAG, "canProcess called, return true");
        return true;
    L26:
        if (d.h.b.o.a(r13.getEnable(), false) == false) goto L30;
        if (d.h.b.o.a(r13.getMode(), "wifi") == true) goto L33;
    L30:
        if (d.h.b.o.a(r13.getEnable(), false) == false) goto L35;
        if (d.h.b.o.a(r13.getMode(), SensitiveType.MOBILE) == false) goto L35;
    L13:
        r11 = null;
    L35:
        ILogDepend.Companion.d(TAG, "canProcess called, return false");
        return false;
    }

    @Override // com.obric.agent.f.a
    public void b(IntentAppAction r10, String r11) {
        d.h.b.o.e(r10, "action");
        d.h.b.o.e(r11, "actionName");
        long r4 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        C0290c r12 = new C0290c(r4, this, r10);
        IAppIntentFeedback r9 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L5;
        r9.addLocalActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(r12, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
    L5:
        ILogDepend.Companion.d(TAG, "process called, reqId:" + r4 + ", questionId:" + r10.getQuestionId());
        com.obric.agent.utils.b.f15994a.a("System_SettingsAvailable", null, null, r4, r10.getQuestionId(), (Map) ZeusTransformUtils.preCheckCast(r10.getExt(), Map.class, "com.obric.aiagent.plugin"));
    }

    private final void a(IntentAppAction r25) {
        ILogDepend.Companion.d(TAG, "doSettingsAvailableOnSuccess called");
        b(r25);
        com.obric.agent.b.a r0 = new com.obric.agent.b.a(0, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_defer_exe_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_defer_exe_success")), null, 0, null, null, 60, null);
        String r9 = new Gson().toJson(r0);
        ConcurrentHashMap r14 = new ConcurrentHashMap();
        x r1 = x.f38692a;
        IntentAppAction r18 = IntentAppAction.copy$default(r25, 0, 0, 0, r9, null, 0, 0, r14, IdlErrors.E_RejectInferDeviceOverheat, null);
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, r18, false, false, false, 12, null);
    }

    private final void a(IntentAppAction r25, int r26, String r27) {
        ILogDepend.Companion.d(TAG, "doSettingsAvailableOnFail called, resultCode:" + r26 + ", details:" + r27);
        String r9 = new Gson().toJson(new com.obric.agent.b.a(r26, r27, null, 0, null, null, 60, null));
        ConcurrentHashMap r14 = new ConcurrentHashMap();
        x r0 = x.f38692a;
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r25, 0, 0, 0, r9, null, 0, 0, r14, IdlErrors.E_RejectInferDeviceOverheat, null), false, false, false, 12, null);
    }

    private final void b(IntentAppAction r4) {
        ILogDepend.Companion.d(TAG, "addSwitchModeDeferIntent called");
        n.f16046a.a(String.valueOf(r4.getQuestionId()), (n.a) ZeusTransformUtils.preCheckCast(new b(r4), n.a.class, "com.obric.aiagent.plugin"));
    }
}
