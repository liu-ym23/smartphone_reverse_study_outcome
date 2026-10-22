package com.obric.autogui.agents.vlm.models.impl;

import android.content.Context;
import android.os.Bundle;
import android.util.EventsUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.api.ILegacyTimerApi;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskAction;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.s;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: StandardModelSetTimerTaskStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends e implements com.obric.autogui.agents.vlm.models.a.b {
    private static final String TAG = "M-Std-Step/ST";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f27963c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f27965e;
    private String g;

    /* JADX INFO: compiled from: StandardModelSetTimerTaskStep.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StandardModelSetTimerTaskStep.kt */
    @d.c.b.a.f(b = "StandardModelSetTimerTaskStep.kt", c = {71, EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "executeStep", e = "com.obric.autogui.agents.vlm.models.impl.StandardModelSetTimerTaskStep")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f27970e;
        int f;

        b(m r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27970e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27969d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f27970e.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModelSetTimerTaskStep.kt */
    @d.c.b.a.f(b = "StandardModelSetTimerTaskStep.kt", c = {183, 186}, d = "getAvailableTask", e = "com.obric.autogui.agents.vlm.models.impl.StandardModelSetTimerTaskStep")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f27973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27974d;

        c(m r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27973c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27972b = r3;
            this.f27974d |= Integer.MIN_VALUE;
            return m.a(this.f27973c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27963c = new a(null);
    }

    private static final String E() {
        return "[set-timer-task]";
    }

    private static final String F() {
        return "executeStep， setup timer task failed, reached max task count limit";
    }

    private static final String G() {
        return "[set-timer-task]";
    }

    public static /* synthetic */ x lambda$0R4Tv30_08kpunQ6vWVL_5iKV0g(Bundle r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$U72aG4ru1SIfiBgahWTsE7JR-V0, reason: not valid java name */
    public static /* synthetic */ String m758lambda$U72aG4ru1SIfiBgahWTsE7JRV0(int r0, int r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$UetUfNSQm9kmMjJ26-P2Ku9SYSA, reason: not valid java name */
    public static /* synthetic */ String m759lambda$UetUfNSQm9kmMjJ26P2Ku9SYSA(m r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$c8xfugsHVgKi-Y3ibRR7zEotGW4, reason: not valid java name */
    public static /* synthetic */ x m760lambda$c8xfugsHVgKiY3ibRR7zEotGW4(Bundle r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$iu-HPjCe7Z8NKDfBB73mK1EuCfk, reason: not valid java name */
    public static /* synthetic */ String m761lambda$iuHPjCe7Z8NKDfBB73mK1EuCfk() {
        return G();
    }

    public static /* synthetic */ String lambda$mjHkQiBvs5U3M7E4orbv0W5D_qw() {
        return E();
    }

    /* JADX INFO: renamed from: lambda$ny-hTj6u_CM5kECb983TmJYkKCQ, reason: not valid java name */
    public static /* synthetic */ String m762lambda$nyhTj6u_CM5kECb983TmJYkKCQ(TimerTaskResult r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$wSgi_yVsv80fZtVgC2AkY67K8-s, reason: not valid java name */
    public static /* synthetic */ String m763lambda$wSgi_yVsv80fZtVgC2AkY67K8s() {
        return F();
    }

    public static final /* synthetic */ Object a(m r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public m() {
    }

    public final void j(String r1) {
        this.f27964d = r1;
    }

    public final void k(String r1) {
        this.f27965e = r1;
    }

    public final void l(String r1) {
        this.g = r1;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g
    public Object a(com.obric.autogui.session.a r34, d.c.d<? super com.obric.autogui.operator.g> r35) {
        final m r0 = this;
        com.obric.autogui.session.a r1 = r34;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        if ((r5.f & Integer.MIN_VALUE) == 0) goto L7;
        r5.f -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f27969d;
        Object r6 = d.c.a.b.a();
        int r7 = r5.f;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        com.obric.autogui.session.a r2 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r5.f27967b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        m r8 = (m) ZeusTransformUtils.preCheckCast(r5.f27966a, m.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        String r31 = "";
        TimerTaskV2 r14 = null;
    L60:
        final TimerTaskResult r9 = (TimerTaskResult) ZeusTransformUtils.preCheckCast(r4, TimerTaskResult.class, "com.obric.aiagent.plugin");
        m r32 = r8;
        r1 = r2;
        r0 = r32;
    L62:
        Loog.INSTANCE.dp(TAG, new $$Lambda$m$nyhTj6u_CM5kECb983TmJYkKCQ(r9), $$Lambda$m$iuHPjCe7Z8NKDfBB73mK1EuCfk.INSTANCE);
        if (r9 == null) goto L65;
        int r10 = r9.getCode();
    L66:
        if (r9 == null) goto L69;
        String r11 = r9.getMsg();
        if (r11 == null) goto L69;
    L70:
        r0.a(r1, r10, r11);
        if (r9 != null) goto L73;
    L82:
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r13 = ZeusTransformUtils.mapRes(R.string.obric_timer_task_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_timer_task_failed");
        Object[] r15 = new Object[2];
        r15[0] = r0.f27964d;
        if (r9 == null) goto L88;
        String r16 = r9.getMsg();
        if (r16 == null) goto L88;
        String r17 = r16;
    L89:
        r15[1] = r17;
        String r18 = r12.getString(r13, r15);
        d.h.b.o.c(r18, "getString(...)");
        r0.i(r18);
        return com.obric.autogui.operator.g.f29918b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
    L88:
        r17 = r31;
        goto L89
    L73:
        if (r9.getCode() != 0) goto L82;
        String r19 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_timer_task_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_timer_task_success"), new Object[]{r0.f27964d});
        d.h.b.o.c(r19, "getString(...)");
        r0.i(r19);
        r1.l().getInternalExtras().put("_set_timer_task_success", d.c.b.a.b.a(true));
        List<TimerTask> r20 = r9.getData();
        if (r20 == null) goto L79;
        TimerTask r21 = (TimerTask) ZeusTransformUtils.preCheckCast(d.a.p.l(r20), TimerTask.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L79;
        TimerTaskV2 r22 = r21.toTimerTaskV2();
    L81:
        return new com.obric.autogui.operator.o((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(new com.obric.autogui.common.d(true, null, 0, r22, 6, null), com.obric.autogui.common.e.class, "com.obric.aiagent.plugin"), true);
    L79:
        r22 = r14;
    L69:
        r11 = "msg is null";
        goto L70
    L65:
        r10 = -3;
        goto L66
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.obric.autogui.session.a r23 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r5.f27968c, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r1 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r5.f27967b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        m r24 = (m) ZeusTransformUtils.preCheckCast(r5.f27966a, m.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        com.obric.autogui.session.a r25 = r23;
        r0 = r24;
    L31:
        final int r26 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();
        final int r27 = AutoActionConfigs.INSTANCE.getIntCfg("vlm.task.max_number", 5);
        if (r26 < r27) goto L35;
        Loog.INSTANCE.ep(TAG, new $$Lambda$m$U72aG4ru1SIfiBgahWTsE7JRV0(r26, r27), $$Lambda$m$wSgi_yVsv80fZtVgC2AkY67K8s.INSTANCE);
        IAutoActionAgentApi r110 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        String r28 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_agent_timer_task_limit_reached, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_agent_timer_task_limit_reached"));
        d.h.b.o.c(r28, "getString(...)");
        IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default(r110, null, r28, 104005, null, null, 24, null);
        r0.a(r1, -1, "timer task count exceeds " + r27);
        return com.obric.autogui.operator.g.f29918b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
    L35:
        ILegacyTimerApi r29 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L61;
        String r30 = r0.g;
        if (r30 != null) goto L40;
        String r210 = "";
    L41:
        String r33 = r0.f27964d;
        if (r33 != null) goto L44;
        r33 = "";
        r31 = r33;
    L45:
        String r211 = new TimerTaskAction(r33, null, 2, null).toString();
        d.m[] r36 = new d.m[5];
        String r37 = r0.f27965e;
        if (r37 != null) goto L48;
        r37 = r31;
    L48:
        r36[0] = s.a("timeCondition", r37);
        Long r38 = r1.l().doubaoMessageId();
        if (r38 == null) goto L52;
        String r39 = r38.toString();
        if (r39 == null) goto L52;
    L53:
        r36[1] = s.a("doubaoMessageId", r39);
        r36[2] = s.a("sessionKey", r25.a());
        r36[3] = s.a(ObricMemoryConstants.KEY_SESSION_ID, r25.b());
        String r40 = r25.l().getUserTask();
        if (r40 != null) goto L56;
        r40 = r31;
    L56:
        r36[4] = s.a(DownloadConstants.QUERY_KEY, r40);
        TimerTask r41 = new TimerTask(r210, null, r211, null, null, null, null, null, ao.a(r36), ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION, null);
        r5.f27966a = r0;
        r5.f27967b = r1;
        r14 = null;
        r5.f27968c = null;
        r5.f = 2;
        r4 = r29.addTimerTask(r41, r5);
        if (r4 != r6) goto L59;
        return r6;
    L59:
        com.obric.autogui.session.a r310 = r1;
        r8 = r0;
        r2 = r310;
    L52:
        r39 = r31;
        goto L53
    L44:
        r31 = "";
        goto L45
    L40:
        r210 = r30;
        goto L41
    L61:
        r31 = "";
        r14 = null;
        r9 = null;
        goto L62
    L16:
        d.o.a(r4);
        Loog.INSTANCE.ip(TAG, new $$Lambda$m$UetUfNSQm9kmMjJ26P2Ku9SYSA(r0), $$Lambda$m$mjHkQiBvs5U3M7E4orbv0W5D_qw.INSTANCE);
        r25 = com.obric.autogui.session.c.f30777a.b();
        if (r25 != null) goto L20;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r0), "executeStep， cannot enter set-timer-task; no ongoing session.");
        r0.a(r1, -2, "no ongoing session");
        return com.obric.autogui.operator.g.f29918b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
    L20:
        String r42 = r0.g;
        if (r42 == null) goto L91;
        if (r42 == null) goto L24;
        String r43 = r42.toLowerCase();
        d.h.b.o.c(r43, "toLowerCase(...)");
    L26:
        if (d.h.b.o.a(r43, "unsupported") == true) goto L91;
        r5.f27966a = r0;
        r5.f27967b = r1;
        r5.f27968c = r25;
        r5.f = 1;
        r4 = r0.b(r5);
        if (r4 != r6) goto L31;
        return r6;
    L24:
        r43 = null;
    L91:
        String r44 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_timer_task_unsupported_cron, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_timer_task_unsupported_cron"));
        d.h.b.o.c(r44, "getString(...)");
        r0.i(r44);
        r0.a(r1, -1, "cron is unsupported");
        return com.obric.autogui.operator.g.f29918b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
    L7:
        r5 = new b(r0, r3);
        goto L8
    }

    private static final String a(m r2) {
        return "[set-timer-task] - condition=" + r2.f27965e + ", instruction=" + r2.f27964d + " ,cron=" + r2.g + ", ";
    }

    private static final String a(int r2, int r3) {
        return "executeStep， setup timer task failed，current timer task count " + r2 + " reached max " + r3;
    }

    private static final String a(TimerTaskResult r2) {
        return "[set-timer-task] result: " + r2;
    }

    private final void a(com.obric.autogui.session.a r16, int r17, String r18) {
        if (r17 != 0) goto L5;
        r16.J().a($$Lambda$m$0R4Tv30_08kpunQ6vWVL_5iKV0g.INSTANCE);
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r16.p(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r2.hasNext() == false) goto L24;
        IAutoActionAgentEventListener.AgentStepInfo r7 = ((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).T();
        boolean r8 = true;
        if (r7 != null) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L17;
        r5 = r5 + 1;
    L17:
        if (r7 != null) goto L19;
    L21:
        r8 = false;
    L22:
        if (r8 == false) goto L8;
        r6 = r6 + 1;
        goto L8
    L19:
        if (r7.getActionType() != 1) goto L21;
    L12:
        if (r7.getActionType() != 3) goto L14;
        r9 = true;
        goto L15
    L24:
        IAutoActionTrackingApi r10 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r11 = new JSONObject();
        r11.put(MonitorConstants.CODE, r17);
        r11.put("message", r18);
        String r1 = this.f27965e;
        String r3 = "";
        if (r1 != null) goto L27;
        r1 = "";
    L27:
        r11.put("condition", r1);
        String r0 = this.g;
        if (r0 == null) goto L31;
        r3 = r0;
    L31:
        r11.put("cron", r3);
        r11.put("clarify_count", r5);
        r11.put("operation_count", r6);
        com.obric.autogui.session.c.b.a(r11, r16);
        x r4 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r10, "set_timer_task", r11, false, false, null, 28, null);
        return;
    L5:
        r16.J().a($$Lambda$m$c8xfugsHVgKiY3ibRR7zEotGW4.INSTANCE);
        goto L6
    }

    private static final x a(Bundle r2) {
        d.h.b.o.e(r2, "$this$withTaskEndReports");
        r2.putInt("set_timer_task_success_count", r2.getInt("set_timer_task_success_count", 0) + 1);
        return x.f38692a;
    }

    private static final x b(Bundle r2) {
        d.h.b.o.e(r2, "$this$withTaskEndReports");
        r2.putInt("set_timer_task_failed_count", r2.getInt("set_timer_task_failed_count", 0) + 1);
        return x.f38692a;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.a.b
    public String e() {
        return "设置任务:" + this.f27965e + this.f27964d;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public com.obric.autogui.agents.vlm.models.a.d.b C() {
        return com.obric.autogui.agents.vlm.models.a.d.b.f27246e;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.operator.e
    public void a(JSONObject r2) {
        d.h.b.o.e(r2, "metricsForUpload");
        super.a(r2);
    }

    private final Object b(d.c.d<? super Integer> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r11, c.class, "com.obric.aiagent.plugin");
        if ((r0.f27974d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27974d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f27972b;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f27974d;
        int r6 = 0;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        int r13 = r0.f27971a;
        d.o.a(r9);
    L49:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L71;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L54;
    L56:
        Iterator r16 = r15.iterator();
        int r1 = 0;
    L58:
        if (r16.hasNext() == false) goto L70;
        Integer r3 = ((EventTask) ZeusTransformUtils.preCheckCast(r16.next(), EventTask.class, "com.obric.aiagent.plugin")).getEnableStatus();
        if (r3 != null) goto L63;
    L65:
        boolean r4 = false;
    L66:
        if (r4 == false) goto L58;
        r1 = r1 + 1;
        if (r1 >= 0) goto L58;
        d.a.p.d();
        goto L58
    L63:
        if (r3.intValue() != 0) goto L65;
        r4 = true;
        goto L66
    L70:
        r6 = r1;
    L74:
        return d.c.b.a.b.a(r13 + r6);
    L54:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L56;
    L71:
        int r5 = r13;
    L72:
        r13 = r5;
        goto L74
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r9);
    L21:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L42;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L26;
    L28:
        Iterator r19 = r18.iterator();
        r5 = 0;
    L30:
        if (r19.hasNext() == false) goto L43;
        Integer r7 = ((EventTask) ZeusTransformUtils.preCheckCast(r19.next(), EventTask.class, "com.obric.aiagent.plugin")).getEnableStatus();
        if (r7 != null) goto L35;
    L37:
        boolean r8 = false;
    L38:
        if (r8 == false) goto L30;
        r5 = r5 + 1;
        if (r5 >= 0) goto L30;
        d.a.p.d();
        goto L30
    L35:
        if (r7.intValue() != 0) goto L37;
        r8 = true;
    L43:
        IEventTaskApi r20 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L72;
        r0.f27971a = r5;
        r0.f27974d = 2;
        r9 = r20.getEventTasksByType(2, 0, Integer.MAX_VALUE, r0);
        if (r9 != r12) goto L48;
        return r12;
    L48:
        r13 = r5;
        goto L49
    L26:
        if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L28;
    L42:
        r5 = 0;
        goto L43
    L16:
        d.o.a(r9);
        IEventTaskApi r21 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L42;
        r0.f27974d = 1;
        r9 = r21.getEventTasksByType(1, 0, Integer.MAX_VALUE, r0);
        if (r9 != r12) goto L21;
        return r12;
    L7:
        r0 = new c(this, r11);
        goto L8
    }
}
