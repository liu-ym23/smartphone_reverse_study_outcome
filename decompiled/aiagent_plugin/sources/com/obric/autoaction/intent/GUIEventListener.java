package com.obric.autoaction.intent;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.session.state.a.e;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: GUIEventListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GUIEventListener implements IAutoActionAgentEventListener {
    public static final a Companion = null;
    private static final String EVENT_PROACTIVE_PAUSE = "obric_omni_proactive_pause";
    private boolean isNeedCallback;
    private QueueStatus lastQueueStatus;

    /* JADX INFO: compiled from: GUIEventListener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: GUIEventListener.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24720a = null;

        static {
            int[] r0 = new int[BizStatus.values().length];
            r0[BizStatus.PREPARING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[BizStatus.OPERATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[BizStatus.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[BizStatus.USER_INTERRUPTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f24720a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ String lambda$Zr8UzDCsfIe3KArc5Yr4wdCWua4(int r0, String r1) {
        return onBizStatusChanged$lambda$0(r0, r1);
    }

    private final String terminationTypeToString(int r2) {
        if (r2 == 104005) goto L13;
        switch(r2) {
            case 0: goto L12;
            case 1: goto L15;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L15;
        };
    L6:
        return "服务器错误";
    L7:
        return "模型推理超时";
    L8:
        return "网络错误";
    L9:
        return "模型推理出错";
    L10:
        return "未能成功开始执行";
    L11:
        return "用户手动停止";
    L12:
        return "执行成功";
    L15:
        return "未知原因错误";
    L13:
        return "创建自动指令数超过限制";
    }

    public GUIEventListener() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.OperatingAppInfo r2) {
        IAutoActionAgentEventListener.DefaultImpls.onOperatingAppChanged(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onUIOperationHangup(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return IAutoActionAgentEventListener.DefaultImpls.order(this);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r9) {
        o.e(r9, "sessionInfo");
        boolean r0 = c.f24728a.a();
        this.isNeedCallback = r0;
        if (r0 == true) goto L5;
        return;
    L5:
        c r1 = c.f24728a;
        String r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.appintent_start_task_success_background_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_start_task_success_background_tips"));
        o.c(r2, "getString(...)");
        String r3 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.appintent_start_task_success_background_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_start_task_success_background_tips"));
        o.c(r3, "getString(...)");
        String r8 = r9.getSessionId();
        if (r8 != null) goto L8;
        r8 = r9.getSessionKey();
    L8:
        c.a(r1, r2, r3, r8, false, 8, null);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r5, IAutoActionAgentEventListener.AgentStepInfo r6, IAutoActionAgentEventListener.AgentStepExecInfo r7) {
        o.e(r5, "sessionInfo");
        o.e(r6, "stepInfo");
        o.e(r7, "execInfo");
        if (this.isNeedCallback == true) goto L5;
        return;
    L5:
        IAutoActionAgentEventListener.DefaultImpls.afterAgentStep(this, r5, r6, r7);
        if (r6.isLastStep() == true) goto L8;
        return;
    L8:
        if (r6.isSuccess() == false) goto L10;
        int r8 = 0;
    L14:
        String r0 = r5.getSessionId();
        if (r0 != null) goto L17;
        r0 = r5.getSessionKey();
    L17:
        Bundle r1 = r5.getTask().getTaskExtras();
        String r2 = null;
        if (r1 == null) goto L24;
        Object r3 = r1.get("doubao_message_id");
        if (r3 == null) goto L24;
        String r4 = r3.toString();
        if (r4 == null) goto L24;
        Long r9 = d.o.o.e(r4);
    L26:
        if (r6.isSuccess() == true) goto L29;
        r2 = r6.getThought();
    L29:
        if (r2 == null) goto L31;
        updateIntentResult(r5, getLastIntentResult(r2, r2, r0, r8), r9);
        return;
    L31:
        updateIntentResult(r5, getLastIntentResult(r6.getRawAction(), r6.getRawThought(), r0, r8), r9);
        return;
    L24:
        r9 = null;
        goto L26
    L10:
        Bundle r10 = r6.getExtras();
        if (r10 == null) goto L13;
        r8 = r10.getInt("term_reason_type");
        goto L14
    L13:
        r8 = 1;
        goto L14
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r10, BizStatus r11, BizStatus r12, int r13, BizStatus.StatusChangedReasonStruct r14, Bundle r15) {
        o.e(r10, "sessionInfo");
        o.e(r11, "oldStatus");
        o.e(r12, "status");
        o.e(r14, "reasonDetails");
        handleBizStatusChanged(r12, r13, r15, r10);
        if (r11 != BizStatus.QUEUEING) goto L16;
        if (r12 != BizStatus.IDLE) goto L16;
        if (r13 != e.f31232c.a()) goto L16;
        boolean r16 = c.f24728a.a();
        this.isNeedCallback = r16;
        if (r16 == true) goto L11;
        return;
    L11:
        c r3 = c.f24728a;
        String r17 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.appintent_agent_cannot_start_system_login_not_logged_in, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_agent_cannot_start_system_login_not_logged_in"));
        o.c(r17, "getString(...)");
        String r5 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.appintent_agent_cannot_start_system_login_not_logged_in, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_agent_cannot_start_system_login_not_logged_in"));
        o.c(r5, "getString(...)");
        String r18 = r10.getSessionId();
        if (r18 != null) goto L14;
        r18 = r10.getSessionKey();
    L14:
        r3.a(r17, r5, r18, ErrorCode.AutoGui.AUTO_GUI_SYSTEM_ACCOUNT_NOT_LOGIN, 104003);
    L16:
        if (r11 == BizStatus.PREPARING) goto L18;
        return;
    L18:
        if (r12 != BizStatus.TERMINATED) goto L36;
        boolean r19 = c.f24728a.a();
        this.isNeedCallback = r19;
        if (r19 == true) goto L22;
        return;
    L22:
        if (r15 == null) goto L24;
        int r110 = r15.getInt("term_reason_type");
    L25:
        final int r8 = r110;
        if (r15 == null) goto L29;
        String r111 = r15.getString("early_term_reason");
        if (r111 == null) goto L29;
    L30:
        final String r6 = r111;
        Loog.INSTANCE.dp(LogUtil.INSTANCE.getCLAZZ_TAG(this), new $$Lambda$GUIEventListener$Zr8UzDCsfIe3KArc5Yr4wdCWua4(r8, r6));
        c r4 = c.f24728a;
        String r9 = r10.getSessionId();
        if (r9 != null) goto L33;
        r9 = r10.getSessionKey();
    L33:
        r4.a(r6, r6, r9, -2002, r8);
        return;
    L29:
        r111 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.appintent_agent_cannot_start_prepare_terminate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_agent_cannot_start_prepare_terminate"));
        o.c(r111, "getString(...)");
        goto L30
    L24:
        r110 = -1;
        goto L25
    }

    private static final String onBizStatusChanged$lambda$0(int r2, String r3) {
        return "Preparing -> Terminated: tr=" + r2 + ", tru=" + r3;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r4, QueueStatus r5) {
        o.e(r4, "sessionInfo");
        o.e(r5, "queueStatus");
        IAutoActionAgentEventListener.DefaultImpls.onQueueStatusChanged(this, r4, r5);
        if (this.lastQueueStatus == null) goto L5;
    L7:
        this.lastQueueStatus = r5;
        return;
    L5:
        if (r5.isQueueCompleted() == true) goto L7;
        updateProThoughtStatus((com.obric.autoaction.intent.a) ZeusTransformUtils.preCheckCast(com.obric.autoaction.intent.a.d.f24726a, com.obric.autoaction.intent.a.class, "com.obric.aiagent.plugin"), r4);
        goto L7
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r4, IAutoActionAgentEventListener.AgentStepInfo r5) {
        o.e(r4, "sessionInfo");
        o.e(r5, "stepInfo");
        IAutoActionAgentEventListener.DefaultImpls.onAgentStep(this, r4, r5);
        if (r5.isLastStep() == true) goto L6;
        updateProThoughtStatus((com.obric.autoaction.intent.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.intent.a.C0572a(Integer.valueOf(r5.getActionType()), r5.getThought(), r5.getAction()), com.obric.autoaction.intent.a.class, "com.obric.aiagent.plugin"), r4);
        return;
    }

    private final void handleBizStatusChanged(BizStatus r8, int r9, Bundle r10, IAutoActionAgentEventListener.SessionInfo r11) {
        int r12 = b.f24720a[r8.ordinal()];
        if (r12 != 1) goto L5;
        this.lastQueueStatus = null;
        updateProThoughtStatus((com.obric.autoaction.intent.a) ZeusTransformUtils.preCheckCast(com.obric.autoaction.intent.a.c.f24725a, com.obric.autoaction.intent.a.class, "com.obric.aiagent.plugin"), r11);
        return;
    L5:
        if (r12 != 2) goto L7;
        updateProThoughtStatus((com.obric.autoaction.intent.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.intent.a.C0572a(null, null, null, 7, null), com.obric.autoaction.intent.a.class, "com.obric.aiagent.plugin"), r11);
        return;
    L7:
        if (r12 != 3) goto L9;
        updateProThoughtStatus((com.obric.autoaction.intent.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.intent.a.b(r9), com.obric.autoaction.intent.a.class, "com.obric.aiagent.plugin"), r11);
        return;
    L9:
        if (r12 != 4) goto L19;
        updateProThoughtStatus((com.obric.autoaction.intent.a) ZeusTransformUtils.preCheckCast(com.obric.autoaction.intent.a.e.f24727a, com.obric.autoaction.intent.a.class, "com.obric.aiagent.plugin"), r11);
        return;
    }

    public final void updateProThoughtStatus(com.obric.autoaction.intent.a r19, IAutoActionAgentEventListener.SessionInfo r20) {
        o.e(r19, "status");
        o.e(r20, "sessionInfo");
        Integer r3 = r20.getTask().getTaskMode();
        boolean r5 = true;
        if (r3 != null) goto L6;
    L8:
        r5 = false;
    L10:
        if (ZeusTransformUtils.instanceOf(r19, com.obric.autoaction.intent.a.e.class) == false) goto L12;
        reportProactivePause(r20);
    L12:
        if (r5 == true) goto L14;
        return;
    L14:
        Bundle r4 = r20.getTask().getTaskExtras();
        if (r4 == null) goto L21;
        Object r6 = r4.get("doubao_message_id");
        if (r6 == null) goto L21;
        String r7 = r6.toString();
        if (r7 == null) goto L21;
        Long r8 = d.o.o.e(r7);
    L22:
        IntentResult<?> r15 = new IntentResult(0, null, null, r19.a(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r15.setFinal(false);
        IMAppActionExt r1 = new IMAppActionExt();
        r1.put("obric_report_execution_step", "1");
        r15.setExt((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r1, ConcurrentHashMap.class, "com.obric.aiagent.plugin"));
        updateIntentResult(r20, r15, r8);
        return;
    L21:
        r8 = null;
        goto L22
    L6:
        if (r3.intValue() != 1) goto L8;
        goto L8
    }

    private final void reportProactivePause(IAutoActionAgentEventListener.SessionInfo r12) {
        Bundle r0 = r12.getTask().getTaskExtras();
        String r2 = "";
        if (r0 == null) goto L9;
        Object r1 = r0.get("doubao_message_id");
        if (r1 == null) goto L9;
        String r3 = r1.toString();
        if (r3 == null) goto L9;
    L13:
        JSONObject r5 = new JSONObject();
        String r4 = r12.getToolName();
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r5.put("current_tool_name", r4);
        String r6 = r12.getInstructionType();
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        r5.put("instruction_type", r6);
        String r7 = r12.getSessionId();
        if (r7 != null) goto L22;
        r7 = r12.getSessionKey();
    L22:
        r5.put("instruction_id", r7);
        r5.put("doubao_message_id", r3);
        String r13 = r12.getToolId();
        if (r13 == null) goto L26;
        r2 = r13;
    L26:
        r5.put("current_tool_id", r2);
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "reportProactivePause event=obric_omni_proactive_pause, params=" + r5);
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), EVENT_PROACTIVE_PAUSE, r5, false, false, null, 16, null);
        return;
    L9:
        Long r8 = r12.getRefMsgId();
        if (r8 == null) goto L12;
        r3 = r8.toString();
        goto L13
    L12:
        r3 = "";
        goto L13
    }

    private final IntentResult<?> getLastIntentResult(String r15, String r16, String r17, int r18) {
        IntentResult<?> r13 = new IntentResult(0, null, null, r15, false, false, 1, null, null, null, 950, null);
        r13.setFinal(true);
        IMAppActionExt r0 = new IMAppActionExt();
        r0.put("session_id", r17);
        r0.put("o_app_error_code", String.valueOf(r18));
        r13.setExt((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r0, ConcurrentHashMap.class, "com.obric.aiagent.plugin"));
        ILogDepend.Companion.d("GUIEventListener", "getIntentResult end");
        return r13;
    }

    private final void updateIntentResult(IAutoActionAgentEventListener.SessionInfo r9, IntentResult<?> r10, Long r11) {
        DispatchContext r12 = getDoubaoDispatchContext(r9);
        if (r12 != null) goto L5;
        r12 = c.f24728a.b();
    L5:
        if (r12 == null) goto L7;
        AtomicCapabilitySdk.INSTANCE.updateIntentResult(r10, r12, true);
    L10:
        ILogDepend.Companion.d("GUIEventListener", "updateLastStepResult");
        return;
    L7:
        GUIEventListener r8 = (GUIEventListener) ZeusTransformUtils.preCheckCast(this, GUIEventListener.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L10;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).longValue();
        AtomicCapabilitySdk.updateIntentResult$default(AtomicCapabilitySdk.INSTANCE, r10, r2, true, null, 8, null);
        goto L10
    }

    private final DispatchContext getDoubaoDispatchContext(IAutoActionAgentEventListener.SessionInfo r7) {
        Bundle r6 = r7.getTask().getTaskExtras();
        Map r8 = null;
        if (r6 == null) goto L25;
        Bundle r9 = r6.getBundle("doubao_dispatch_context");
        if (r9 == null) goto L25;
        if (r9.containsKey("questionId") == false) goto L10;
        Long r0 = Long.valueOf(r9.getLong("questionId"));
    L11:
        Bundle r10 = r9.getBundle("ext");
        if (r10 == null) goto L24;
        Set<String> r2 = r10.keySet();
        if (r2 == null) goto L24;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        LinkedHashMap r3 = new LinkedHashMap(n.c(ao.a(p.a(r11, 10)), 16));
        Iterator r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L22;
        Object r4 = r12.next();
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin");
        String r13 = r10.getString((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        r5.put(r4, r13);
        goto L17
    L22:
        r8 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin");
    L24:
        return new DispatchContext((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0, r8);
    L10:
        r0 = null;
    L25:
        return null;
    }
}
