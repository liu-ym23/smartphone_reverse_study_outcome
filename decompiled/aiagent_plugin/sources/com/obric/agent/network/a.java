package com.obric.agent.network;

import android.graphics.Bitmap;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.obric.agent.trace.IIntentTraceService;
import com.obric.agent.trace.IOmniReportService;
import com.obric.agent.trace.toolmetrics.h;
import com.obric.agent.trace.toolmetrics.i;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.api.IOAutoStateManager;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.funcall_api.IIntentActionService;
import com.obric.funcall_api.bean.AppActionRequest;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.z;
import d.n;
import d.o;
import d.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.cx;
import org.json.JSONObject;

/* JADX INFO: compiled from: AgentNetworkManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AgentNetworkManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Keva f15207b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f15208c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final am f15209d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.obric.agent.network.b f15210e = null;

    /* JADX INFO: renamed from: com.obric.agent.network.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentNetworkManager.kt */
    @d.c.b.a.f(b = "AgentNetworkManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.network.AgentNetworkManager$addToKeva$2")
    static final class C0310a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppActionRequest f15213c;

        C0310a(String r3, AppActionRequest r4, d.c.d<? super C0310a> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15212b = r3;
            this.f15213c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0310a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0310a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0310a(this.f15212b, this.f15213c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15211a != 0) goto L18;
            o.a(r4);
            String r5 = a.b().getString(this.f15212b, "");     // Catch: Exception -> L10
            Set r6 = (Set) ZeusTransformUtils.preCheckCast(a.a(a.f15206a).fromJson(r5, new AgentNetworkManager$addToKeva$2$remainList$1().getType()), Set.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
            if (r6 != null) goto L8;
            r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        L8:
            r6.add(this.f15213c);     // Catch: Exception -> L10
            a.b().storeString(this.f15212b, a.a(a.f15206a).toJson(r6));     // Catch: Exception -> L10
        L16:
            return x.f38692a;
        L10:
            e = move-exception;
            JSONObject r7 = new JSONObject();
            r7.put("app_intent_add_keva_exception", String.valueOf(e));
            e.printStackTrace();
            r7.put("app_intent_add_keva_exception_trace", String.valueOf(x.f38692a));
            IAppLog r0 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L14;
            r0.reportToFlow("o_app_intent_add_keva_error", r7);
        L14:
            ILogDepend.Companion r8 = ILogDepend.Companion;
            StringBuilder r1 = new StringBuilder().append("addToKeva failed: ").append(e).append(' ');
            e.printStackTrace();
            r8.e(a.TAG, r1.append(x.f38692a).toString());
            goto L16
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentNetworkManager.kt */
    @d.c.b.a.f(b = "AgentNetworkManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.network.AgentNetworkManager$sendIMAction$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntentAppAction f15215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f15216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f15217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f15218e;

        b(IntentAppAction r3, boolean r4, boolean r5, boolean r6, d.c.d<? super b> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15215b = r3;
            this.f15216c = r4;
            this.f15217d = r5;
            this.f15218e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f15215b, this.f15216c, this.f15217d, this.f15218e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r24) {
            d.c.a.b.a();
            if (this.f15214a != 0) goto L35;
            o.a(r24);
            ILogDepend.Companion.i(a.TAG, "send IM Action: -> Text #" + this.f15215b.getMessageId());
            com.obric.agent.b.a r1 = (com.obric.agent.b.a) ZeusTransformUtils.preCheckCast(a.a(a.f15206a).fromJson(this.f15215b.getContent(), com.obric.agent.b.a.class), com.obric.agent.b.a.class, "com.obric.aiagent.plugin");
            IIntentTraceService r4 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L14;
            String r5 = String.valueOf(this.f15215b.getQuestionId());
            if ((r1.d() & UiType.FLAG_NO_FEEDBACK) == 0) goto L9;
        L12:
            boolean r2 = true;
        L13:
            IIntentTraceService.a.a(r4, r5, "no_feedback", d.c.b.a.b.a(r2), 0, 8, null);
            goto L14
        L9:
            if (this.f15216c == true) goto L12;
            r2 = false;
        L14:
            AppActionRequest r3 = a.a(a.f15206a, new AppActionRequest(this.f15215b.getId(), this.f15215b.getMessageId(), this.f15215b.getQuestionId(), System.currentTimeMillis(), this.f15215b.getContent(), this.f15215b.getScreenshot(), this.f15215b.getExt()));
            int r6 = a.b(a.f15206a);
            if (r6 != 2) goto L17;
        L19:
            if (r6 == 1) goto L27;
            if (this.f15217d == true) goto L27;
            if (this.f15218e == false) goto L25;
            i.f15892a.a(this.f15215b.getMessageId());
        L25:
            a.a(a.f15206a, p.a(r3), "normal", false, 4, null);
            ILogDepend.Companion.i(a.TAG, "sendToHttpForCompensation: after changed is : Text #" + this.f15215b.getMessageId());
        L27:
            if (this.f15217d == false) goto L33;
            if (this.f15218e == false) goto L31;
            a.b(a.f15206a, p.a(r3), "normal", false, 4, null);
            ILogDepend.Companion.i(a.TAG, "sendToHttpForAsyncNotify: after changed is : Text #" + this.f15215b.getMessageId());
            goto L33
        L31:
            a r7 = a.f15206a;
            String r8 = String.valueOf(r3.getMessageId());
            String r9 = a.a(a.f15206a).toJson(r3);
            d.h.b.o.c(r9, "toJson(...)");
            a.a(r7, r8, r9, MemorySourceLinkType.INTENT);
            ILogDepend.Companion.i(a.TAG, "sendToHttpNormal: after changed is : Text #" + this.f15215b.getMessageId());
        L33:
            return x.f38692a;
        L17:
            if (this.f15217d == true) goto L19;
            a.a(a.f15206a, r3, String.valueOf(this.f15215b.getQuestionId()));
            ILogDepend.Companion.i(a.TAG, "send IM Action: after changed is : Text #" + this.f15215b.getMessageId() + " sendToFrontier");
            goto L19
        L35:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentNetworkManager.kt */
    @d.c.b.a.f(b = "AgentNetworkManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.network.AgentNetworkManager$tryToReSend$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15219a;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15219a != 0) goto L7;
            o.a(r2);
            ILogDepend.Companion.i(a.TAG, "tryToReSend");
            a.a(a.f15206a, "agent_network_compensation_failed");
            a.a(a.f15206a, "agent_network_async_failed");
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentNetworkManager.kt */
    @d.c.b.a.f(b = "AgentNetworkManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.network.AgentNetworkManager$uploadFrontierUplink$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f15221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15222c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15223d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f15224e;
        final /* synthetic */ boolean f;

        d(boolean r3, String r4, String r5, long r6, boolean r8, d.c.d<? super d> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15221b = r3;
            this.f15222c = r4;
            this.f15223d = r5;
            this.f15224e = r6;
            this.f = r8;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f15221b, this.f15222c, this.f15223d, this.f15224e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15220a != 0) goto L10;
            o.a(r4);
            JSONObject r5 = new JSONObject();
            r5.put("app_intent_frontier_uplink", this.f15221b);
            r5.put("app_intent_frontier_uplink_id", this.f15222c);
            r5.put("app_intent_frontier_uplink_reason", this.f15223d);
            r5.put("app_intent_frontier_uplink_cost", this.f15224e);
            r5.put("app_intent_frontier_uplink_has_screenshot", this.f);
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            r3.reportToFlow("o_app_intent_frontier_uplink", r5);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentNetworkManager.kt */
    @d.c.b.a.f(b = "AgentNetworkManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.network.AgentNetworkManager$uploadHttpUplink$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f15226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f15229e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ boolean h;

        e(boolean r3, String r4, String r5, long r6, String r8, String r9, boolean r10, d.c.d<? super e> r11) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15226b = r3;
            this.f15227c = r4;
            this.f15228d = r5;
            this.f15229e = r6;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f15226b, this.f15227c, this.f15228d, this.f15229e, this.f, this.g, this.h, r10), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15225a != 0) goto L10;
            o.a(r4);
            JSONObject r5 = new JSONObject();
            r5.put("app_intent_http_uplink", this.f15226b);
            r5.put("app_intent_frontier_http_id", this.f15227c);
            r5.put("app_intent_frontier_http_reason", this.f15228d);
            r5.put("app_intent_frontier_http_cost", this.f15229e);
            r5.put("app_intent_frontier_http_scene", this.f);
            r5.put("app_intent_frontier_http_method", this.g);
            r5.put("app_intent_frontier_http_has_screenshot", this.h);
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            r3.reportToFlow("o_app_intent_http_uplink", r5);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ x lambda$1nn9uTlCiZOj3bvo6b7udBAeZAA(long r0, boolean r2, String r3) {
        return a(r0, r2, r3);
    }

    public static /* synthetic */ x lambda$22hGNJwtLPndYPffVpCBv_X9fa0(String r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$3RerVAXynowYWIw7UdAeDewz-xU, reason: not valid java name */
    public static /* synthetic */ x m92lambda$3RerVAXynowYWIw7UdAeDewzxU(com.obric.agent.network.b.a r0, h r1, List r2, long r3, boolean r5, List r6, String r7, boolean r8, boolean r9, String r10, Map r11) {
        return a(r0, r1, r2, r3, r5, r6, r7, r8, r9, r10, r11);
    }

    /* JADX INFO: renamed from: lambda$85welVCcSaf-3E5_8kWb-OqAKOk, reason: not valid java name */
    public static /* synthetic */ Gson m93lambda$85welVCcSaf3E5_8kWbOqAKOk() {
        return e();
    }

    /* JADX INFO: renamed from: lambda$ClZsTZr206nrcmNlEm4WxVBxd-Q, reason: not valid java name */
    public static /* synthetic */ x m94lambda$ClZsTZr206nrcmNlEm4WxVBxdQ(h r0, List r1, long r2, boolean r4, List r5, String r6, z.a r7, boolean r8, String r9, Map r10) {
        return a(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10);
    }

    /* JADX INFO: renamed from: lambda$Lahtp4f-j97eVVvTsRc24urRNYE, reason: not valid java name */
    public static /* synthetic */ x m95lambda$Lahtp4fj97eVVvTsRc24urRNYE(String r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$bPEAfOLNXsKVKxKLcnyTjI-Fvcs, reason: not valid java name */
    public static /* synthetic */ x m96lambda$bPEAfOLNXsKVKxKLcnyTjIFvcs(long r0, String r2, boolean r3, String r4) {
        return a(r0, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$phAk3OATcZqUquYtgtDdDp5Xtvw(long r0, IIntentTraceService r2, String r3, AppActionRequest r4, boolean r5, String r6) {
        return a(r0, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: lambda$s6GpGmemOhWKD_M5USKZ8QW-u5c, reason: not valid java name */
    public static /* synthetic */ x m97lambda$s6GpGmemOhWKD_M5USKZ8QWu5c(String r0, String r1, Exception r2) {
        return a(r0, r1, r2);
    }

    private a() {
    }

    public static final /* synthetic */ Gson a(a r0) {
        return r0.c();
    }

    public static final /* synthetic */ AppActionRequest a(a r0, AppActionRequest r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ void a(a r0, AppActionRequest r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(a r0, String r1, String r2, String r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ int b(a r0) {
        return r0.d();
    }

    public static final /* synthetic */ Keva b() {
        return f15207b;
    }

    static {
        f15206a = new a();
        f15207b = Keva.getRepo("agent-network", 0);
        f15208c = g.a($$Lambda$a$85welVCcSaf3E5_8kWbOqAKOk.INSTANCE);
        f15209d = an.a(bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
        f15210e = new com.obric.agent.network.b(null, $$Lambda$a$Lahtp4fj97eVVvTsRc24urRNYE.INSTANCE, $$Lambda$a$22hGNJwtLPndYPffVpCBv_X9fa0.INSTANCE, $$Lambda$a$s6GpGmemOhWKD_M5USKZ8QWu5c.INSTANCE, 1, null);
    }

    private final Gson c() {
        return (Gson) ZeusTransformUtils.preCheckCast(f15208c.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson e() {
        return new Gson();
    }

    private static final x b(String r3) {
        d.h.b.o.e(r3, "requestToken");
        IOAutoStateManager r0 = (IOAutoStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOAutoStateManager.class), IOAutoStateManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.onOmniInferenceImageUploadStarted(r3);
    L6:
        return x.f38692a;
    }

    private static final x c(String r3) {
        d.h.b.o.e(r3, "requestToken");
        IOAutoStateManager r0 = (IOAutoStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOAutoStateManager.class), IOAutoStateManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.onOmniInferenceImageUploadFinished(r3);
    L6:
        return x.f38692a;
    }

    private static final x a(String r3, String r4, Exception r5) {
        d.h.b.o.e(r3, "phase");
        d.h.b.o.e(r4, "requestToken");
        d.h.b.o.e(r5, WsConstants.KEY_CONNECTION_ERROR);
        ILogDepend.Companion.e(TAG, "Omni inference image upload lifecycle " + r3 + " failed, token=" + r4 + ", error=" + r5.getClass().getSimpleName());
        return x.f38692a;
    }

    public static /* synthetic */ void a(a r0, IntentAppAction r1, boolean r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = true;
    L8:
        r0.a(r1, r2, r3, r4);
    }

    public final void a(IntentAppAction r12, boolean r13, boolean r14, boolean r15) {
        d.h.b.o.e(r12, "result");
        if (r14 == false) goto L6;
        if (r15 == false) goto L6;
        i.f15892a.b(r12.getMessageId());
    L6:
        kotlinx.coroutines.i.a(f15209d, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new b(r12, r13, r14, r15, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final AppActionRequest a(AppActionRequest r16) {
        Bitmap r0 = r16.getScreenshot();
        if (r0 != null) goto L5;
        return r16;
    L5:
        ConcurrentHashMap<String, String> r1 = r16.getExt();
        if (r1 == null) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get("has_screenshot"), String.class, "com.obric.aiagent.plugin");
    L10:
        if (d.h.b.o.a(r2, "1") == true) goto L12;
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r3.put("message_id", String.valueOf(r16.getMessageId()));
        IIntentActionService r5 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        r5.cacheScreenshot(r0, r3);
    L16:
        ConcurrentHashMap r12 = new ConcurrentHashMap();
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(r16.getExt(), Map.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L19;
        r4 = ao.b();
    L19:
        r12.putAll(r4);
        r12.put("has_screenshot", "1");
        return AppActionRequest.copy$default(r16, 0, 0, 0, 0, null, null, r12, 31, null);
    L12:
        return AppActionRequest.copy$default(r16, 0, 0, 0, 0, null, null, null, 95, null);
    L8:
        r2 = null;
        goto L10
    }

    public final void a() {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void a(String r8) {
        String r2 = f15207b.getString(r8, "");     // Catch: Exception -> L28
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        boolean r4 = true;
        if (r3 != null) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        return;
    L12:
        Set r6 = (Set) ZeusTransformUtils.preCheckCast(c().fromJson(r2, new AgentNetworkManager$reSend$remainList$1().getType()), Set.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        if (r7 != null) goto L15;
    L18:
        if (r4 == false) goto L20;
        return;
    L20:
        ILogDepend.Companion.i(TAG, "tryToReSend, key: " + r8 + ", listSize: " + r6.size());     // Catch: Exception -> L28
        if (d.h.b.o.a(r8, "agent_network_compensation_failed") == false) goto L25;
        a(p.o((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")), "resend", false);     // Catch: Exception -> L28
        return;
    L25:
        if (d.h.b.o.a(r8, "agent_network_async_failed") == false) goto L33;
        b(p.o((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")), "resend", false);     // Catch: Exception -> L28
        return;
    L33:
        return;
    L15:
        if (r7.isEmpty() == true) goto L18;
        r4 = false;
        goto L18
    L6:
        if (d.o.o.d(r3) == true) goto L9;
        r5 = false;
    L28:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "tryToReSend key:" + r8 + " failed: " + e);
    }

    private static final x a(long r13, IIntentTraceService r15, String r16, AppActionRequest r17, boolean r18, String r19) {
        IIntentTraceService r0 = (IIntentTraceService) ZeusTransformUtils.wrapperContextForParams(r15, IIntentTraceService.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r19, "msg");
        long r11 = System.currentTimeMillis() - r13;
        ILogDepend.Companion.i(TAG, "sendToFrontier: result is : " + r18 + ", " + r19 + ", duration: " + r11);
        if (r0 == null) goto L5;
        IIntentTraceService.a.a(r0, r16, "frontier_upload", Boolean.valueOf(r18), 0, 8, null);
    L5:
        if (r18 == true) goto L8;
        if (r0 == null) goto L8;
        r0.addStateParams(r16, "error_msg", r19, 1);
    L8:
        a r1 = f15206a;
        String r4 = String.valueOf(r17.getMessageId());
        ConcurrentHashMap<String, String> r5 = r17.getExt();
        if (r5 == null) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r5.get("has_screenshot"), String.class, "com.obric.aiagent.plugin");
    L12:
        r1.a(r4, r18, r19, r11, d.h.b.o.a(r2, "1"));
        return x.f38692a;
    L11:
        r2 = null;
        goto L12
    }

    static /* synthetic */ void a(a r1, List r2, String r3, boolean r4, int r5, Object r6) {
        List<AppActionRequest> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = true;
    L5:
        r1.a(r7, r3, r4);
    }

    private final void a(List<AppActionRequest> r11, final String r12, final boolean r13) {
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        final h r2 = i.f15892a.a();
        final long r4 = System.currentTimeMillis();
        final z.a r9 = new z.a();
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r10.iterator();
    L4:
        if (r15.hasNext() == false) goto L13;
        AppActionRequest r1 = (AppActionRequest) ZeusTransformUtils.preCheckCast(r15.next(), AppActionRequest.class, "com.obric.aiagent.plugin");
        if (r9.f38499a == true) goto L12;
        ConcurrentHashMap<String, String> r3 = r1.getExt();
        if (r3 == null) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3.get("has_screenshot"), String.class, "com.obric.aiagent.plugin");
    L11:
        r9.f38499a = d.h.b.o.a(r5, "1");
        goto L12
    L10:
        r5 = null;
    L12:
        r14.add(f15206a.a(r1));
        goto L4
    L13:
        final List<AppActionRequest> r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        IIntentActionService r17 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L20;
        r17.sendAppActionForCompensationByHttp(r16, r13, new $$Lambda$a$ClZsTZr206nrcmNlEm4WxVBxdQ(r2, r16, r4, r13, r7, r12, r9));
        return;
    }

    private static final x a(h r14, List r15, long r16, boolean r18, List r19, String r20, z.a r21, boolean r22, String r23, Map r24) {
        List<AppActionRequest> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r23, "msg");
        d.h.b.o.e(r5, "params");
        i.f15892a.a(r14, r10, r22, r23, r5);
        long r4 = System.currentTimeMillis() - r16;
        ILogDepend.Companion.i(TAG, "sendToHttpForCompensation: result is : " + r22 + ", " + r23 + ", duration: " + r4);
        Long r0 = null;
        if (r18 == false) goto L11;
        if (r22 == true) goto L11;
        a r1 = f15206a;
        AppActionRequest r2 = (AppActionRequest) ZeusTransformUtils.preCheckCast(p.l(r11), AppActionRequest.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        Long r3 = Long.valueOf(r2.getMessageId());
    L9:
        r1.a(String.valueOf(r3), r23);
    L31:
        a r6 = f15206a;
        AppActionRequest r7 = (AppActionRequest) ZeusTransformUtils.preCheckCast(p.l(r10), AppActionRequest.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L34;
        r0 = Long.valueOf(r7.getMessageId());
    L34:
        r6.a(String.valueOf(r0), r22, r23, r4, r20, "agent_network_compensation_failed", r21.f38499a);
        return x.f38692a;
    L8:
        r3 = null;
    L11:
        if (r22 == false) goto L13;
    L27:
        if (r22 == false) goto L31;
        if (d.h.b.o.a(r20, "resend") == false) goto L31;
        f15207b.erase("agent_network_compensation_failed");
        goto L31
    L13:
        if (d.h.b.o.a(r20, "resend") == true) goto L27;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r8.iterator();
    L16:
        if (r12.hasNext() == false) goto L24;
        Object r13 = r12.next();
        ConcurrentHashMap<String, String> r17 = ((AppActionRequest) ZeusTransformUtils.preCheckCast(r13, AppActionRequest.class, "com.obric.aiagent.plugin")).getExt();
        if (r17 == null) goto L20;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r17.get("has_screenshot"), String.class, "com.obric.aiagent.plugin");
    L22:
        if ((!d.h.b.o.a(r110, "1")) == false) goto L16;
        r9.add(r13);
        goto L16
    L20:
        r110 = null;
        goto L22
    L24:
        List<AppActionRequest> r25 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L31;
        f15206a.a(r25, "agent_network_compensation_failed");
        goto L31
    }

    static /* synthetic */ void b(a r1, List r2, String r3, boolean r4, int r5, Object r6) {
        List<AppActionRequest> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = true;
    L5:
        r1.b(r7, r3, r4);
    }

    private final void b(List<AppActionRequest> r16, final String r17, final boolean r18) {
        final List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        final h r5 = i.f15892a.a();
        final long r7 = System.currentTimeMillis();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r3.add(f15206a.a((AppActionRequest) ZeusTransformUtils.preCheckCast(r1.next(), AppActionRequest.class, "com.obric.aiagent.plugin")));
        goto L4
    L6:
        final List<AppActionRequest> r2 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L9;
    L11:
        Iterator r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L10;
        ConcurrentHashMap<String, String> r8 = ((AppActionRequest) ZeusTransformUtils.preCheckCast(r6.next(), AppActionRequest.class, "com.obric.aiagent.plugin")).getExt();
        if (r8 == null) goto L17;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.get("has_screenshot"), String.class, "com.obric.aiagent.plugin");
    L19:
        if (d.h.b.o.a(r9, "1") == false) goto L13;
        final boolean r12 = true;
    L21:
        final com.obric.agent.network.b.a r13 = f15210e.a(r12);
        IIntentActionService r11 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30
        if (r11 != null) goto L28;
        if (r13 == null) goto L26;
        r13.a();     // Catch: Exception -> L30
    L26:
        ILogDepend.Companion.e(TAG, "sendToHttpForAsyncNotify: intent action service is null");     // Catch: Exception -> L30
        return;
    L28:
        r11.sendAppActionForAsyncNotifyByHttp(r2, r18, new $$Lambda$a$3RerVAXynowYWIw7UdAeDewzxU(r13, r5, r2, r7, r18, r10, r17, r12));     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        if (r13 == null) goto L33;
        r13.a();
    L33:
        ILogDepend.Companion.e(TAG, "sendToHttpForAsyncNotify: synchronous dispatch failed, error=" + e.getClass().getSimpleName());
        throw e;
    L17:
        r9 = null;
    L10:
        r12 = false;
        goto L21
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
        goto L10
    }

    private static final x a(com.obric.agent.network.b.a r14, h r15, List r16, long r17, boolean r19, List r20, String r21, boolean r22, boolean r23, String r24, Map r25) {
        List<AppActionRequest> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r24, "msg");
        d.h.b.o.e(r5, "params");
        if (r14 == null) goto L5;
        r14.a();
    L5:
        i.f15892a.b(r15, r10, r23, r24, r5);
        long r4 = System.currentTimeMillis() - r17;
        ILogDepend.Companion.i(TAG, "sendToHttpForAsyncNotify: result is : " + r23 + ", " + r24 + ", duration: " + r4);
        Long r0 = null;
        if (r19 == false) goto L14;
        if (r23 == true) goto L14;
        a r1 = f15206a;
        AppActionRequest r2 = (AppActionRequest) ZeusTransformUtils.preCheckCast(p.l(r11), AppActionRequest.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        Long r3 = Long.valueOf(r2.getMessageId());
    L12:
        r1.a(String.valueOf(r3), r24);
    L34:
        a r6 = f15206a;
        AppActionRequest r7 = (AppActionRequest) ZeusTransformUtils.preCheckCast(p.l(r10), AppActionRequest.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L37;
        r0 = Long.valueOf(r7.getMessageId());
    L37:
        r6.a(String.valueOf(r0), r23, r24, r4, r21, "agent_network_async_failed", r22);
        return x.f38692a;
    L11:
        r3 = null;
    L14:
        if (r23 == false) goto L16;
    L30:
        if (r23 == false) goto L34;
        if (d.h.b.o.a(r21, "resend") == false) goto L34;
        f15207b.erase("agent_network_async_failed");
        goto L34
    L16:
        if (d.h.b.o.a(r21, "resend") == true) goto L30;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r8.iterator();
    L19:
        if (r12.hasNext() == false) goto L27;
        Object r13 = r12.next();
        ConcurrentHashMap<String, String> r18 = ((AppActionRequest) ZeusTransformUtils.preCheckCast(r13, AppActionRequest.class, "com.obric.aiagent.plugin")).getExt();
        if (r18 == null) goto L23;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r18.get("has_screenshot"), String.class, "com.obric.aiagent.plugin");
    L25:
        if ((!d.h.b.o.a(r110, "1")) == false) goto L19;
        r9.add(r13);
        goto L19
    L23:
        r110 = null;
        goto L25
    L27:
        List<AppActionRequest> r26 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r26, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L34;
        f15206a.a(r26, "agent_network_async_failed");
        goto L34
    }

    public final void a(IntentAppAction r17) {
        d.h.b.o.e(r17, "result");
        ILogDepend.Companion.i(TAG, "sendOAutoStep begin");
        com.obric.agent.utils.b.f15994a.b(r17);
        AppActionRequest r1 = new AppActionRequest(r17.getId(), r17.getMessageId(), r17.getQuestionId(), System.currentTimeMillis(), r17.getContent(), null, r17.getExt(), 32, null);
        String r0 = String.valueOf(r17.getMessageId());
        String r2 = c().toJson(r1);
        d.h.b.o.c(r2, "toJson(...)");
        a(r0, r2, "multiAgentOauto");
    }

    private final void a(final String r10, String r11, String r12) {
        ILogDepend.Companion.i(TAG, "sendToHttpNormal begin " + r12);
        final long r0 = System.currentTimeMillis();
        IIntentActionService r2 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        IIntentActionService.b.a(r2, r12, r11, false, new $$Lambda$a$bPEAfOLNXsKVKxKLcnyTjIFvcs(r0, r10), 4, null);
        return;
    }

    private static final x a(long r3, String r5, boolean r6, String r7) {
        d.h.b.o.e(r7, "msg");
        ILogDepend.Companion.i(TAG, "sendToHttpNormal: result is : " + r6 + ", " + r7 + ", duration: " + (System.currentTimeMillis() - r3));
        if (r6 == true) goto L6;
        f15206a.a(r5, r7);
    L6:
        return x.f38692a;
    }

    private final void a(String r13, boolean r14, String r15, long r16, boolean r18) {
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new d(r14, r13, r15, r16, r18, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void a(String r3, String r4) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Type r5 = new AgentNetworkManager$recordErrorInfo$map$1$type$1().getType();     // Catch: Throwable -> L5
        Object r6 = n.f((Map) ZeusTransformUtils.preCheckCast(r2.c().fromJson(r4, r5), Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L8:
        if (n.b(r6) == false) goto L10;
        r6 = null;
    L10:
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L13;
        r7 = ao.b();
    L13:
        IOmniReportService r8 = (IOmniReportService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniReportService.class), IOmniReportService.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L29;
        Object r0 = r7.get(MonitorConstants.CODE);
        if (r0 == null) goto L19;
        String r9 = r0.toString();
        if (r9 == null) goto L19;
    L20:
        Object r10 = r7.get("msg");
        if (r10 == null) goto L24;
        String r11 = r10.toString();
        if (r11 == null) goto L24;
    L25:
        r8.recordNetworkError(r3, r9, r11);
        return;
    L24:
        r11 = "unknown network error";
    L19:
        r9 = "-1";
        goto L20
    L29:
        return;
    L5:
        th = move-exception;
        n.a r12 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L8
    }

    private final void a(String r15, boolean r16, String r17, long r18, String r20, String r21, boolean r22) {
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new e(r16, r15, r17, r18, r20, r21, r22, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void a(List<AppActionRequest> r3, String r4) {
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        AppActionRequest r5 = (AppActionRequest) ZeusTransformUtils.preCheckCast(r2.next(), AppActionRequest.class, "com.obric.aiagent.plugin");
        f15206a.b(r5, r4);
        goto L4
    }

    private final void b(AppActionRequest r9, String r10) {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new C0310a(r10, r9, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final int d() {
        IFlowSettingsIDL r0 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getIntentUploadStrategyForDebug();
    }

    public final void a(String r8, String r9, String r10, Map<?, ?> r11) {
        Map<?, ?> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        final long r1 = System.currentTimeMillis();
        IIntentActionService r7 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L6;
        r7.replyAskUserUploadByHttp(r8, r9, r10, r5, new $$Lambda$a$1nn9uTlCiZOj3bvo6b7udBAeZAA(r1));
        return;
    }

    private static final x a(long r3, boolean r5, String r6) {
        d.h.b.o.e(r6, "msg");
        ILogDepend.Companion.i(TAG, "replyAskUserUploadByHttp: result is : " + r5 + ", " + r6 + ", duration: " + (System.currentTimeMillis() - r3));
        return x.f38692a;
    }

    private final void a(final AppActionRequest r9, final String r10) {
        final IIntentTraceService r5 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        final long r3 = System.currentTimeMillis();
        IIntentActionService r8 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L6;
        r8.sendAppAction(r9, new $$Lambda$a$phAk3OATcZqUquYtgtDdDp5Xtvw(r3, r5, r10, r9));
        return;
    }
}
