package com.obric.autoaction.presentation.doubao;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: AssistRemoteCardUpdateImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistRemoteCardUpdateImpl extends AutoAgentWidgetStateDefaultListener {
    private final int toInt(boolean r1) {
        return r1 ? 1 : 0;
    }

    public AssistRemoteCardUpdateImpl() {
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPreparing(WidgetState.Preparing r3) {
        o.e(r3, "state");
        super.onPreparing(r3);
        createCard$default(this, (WidgetState) ZeusTransformUtils.preCheckCast(r3, WidgetState.class, "com.obric.aiagent.plugin"), null, 2, null);
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onCallUser(WidgetState.CallUser r3) {
        o.e(r3, "state");
        super.onCallUser(r3);
        createCard((WidgetState) ZeusTransformUtils.preCheckCast(r3, WidgetState.class, "com.obric.aiagent.plugin"), r3.getStepInfo().getAction());
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onClarify(WidgetState.Clarify r3) {
        o.e(r3, "state");
        super.onClarify(r3);
        createCard((WidgetState) ZeusTransformUtils.preCheckCast(r3, WidgetState.class, "com.obric.aiagent.plugin"), r3.getStepInfo().getAction());
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onSetTimerTask(WidgetState.SetTimerTask r3) {
        o.e(r3, "state");
        super.onSetTimerTask(r3);
        createCard((WidgetState) ZeusTransformUtils.preCheckCast(r3, WidgetState.class, "com.obric.aiagent.plugin"), null);
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onLastStep(WidgetState.LastStep r3) {
        o.e(r3, "state");
        super.onLastStep(r3);
        if (r3.isPureTimerTask() == true) goto L5;
    L7:
        createCard((WidgetState) ZeusTransformUtils.preCheckCast(r3, WidgetState.class, "com.obric.aiagent.plugin"), null);
        return;
    L5:
        if (r3.getEndType() != 1) goto L7;
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateChange(WidgetState r4, WidgetState r5) {
        o.e(r5, "state");
        Long r0 = doubaoMessageId(r5);
        if (r0 == null) goto L28;
        r0.longValue();
        if (ZeusTransformUtils.instanceOf(r5, WidgetState.Terminated.class) == false) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, WidgetState.Prepared.class) == false) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, WidgetState.Queue.class) == false) goto L12;
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, WidgetState.LastStep.class) == false) goto L17;
        if (((WidgetState.LastStep) ZeusTransformUtils.preCheckCast(r5, WidgetState.LastStep.class, "com.obric.aiagent.plugin")).isPureTimerTask() == false) goto L17;
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r4, WidgetState.Prepared.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r4, WidgetState.Operating.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r5, WidgetState.Operating.class) == false) goto L24;
        createCard$default(this, r5, null, 2, null);
    L24:
        if (ZeusTransformUtils.instanceOf(r5, WidgetState.Queue.class) == false) goto L26;
        createCard(r5, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_current_server_busy_wait, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_current_server_busy_wait")));
    L26:
        updateCard(r5);
        return;
    }

    public static /* synthetic */ void createCard$default(AssistRemoteCardUpdateImpl r0, WidgetState r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.createCard(r1, r2);
    }

    public final void createCard(WidgetState r21, String r22) {
        o.e(r21, "state");
        Long r2 = doubaoMessageId(r21);
        if (r2 == null) goto L17;
        long r5 = r2.longValue();
        String r3 = f.f24886a.a(r21).toString();
        o.c(r3, "toString(...)");
        IntentResult<?> r4 = new IntentResult(0, null, null, r22, false, false, UiType.FLAG_REMOTE_CARD, null, null, null, 950, null);
        r4.setFinal(false);
        JSONObject r7 = new JSONObject();
        if (r21.getSessionInfo().getTask().getTimerTaskId() == null) goto L7;
        boolean r8 = true;
    L8:
        r7.put("is_timer_task", toInt(r8));
        Bundle r9 = r21.getSessionInfo().getTask().getTaskExtras();
        if (r9 == null) goto L11;
        Object r6 = Integer.valueOf(toInt(r9.getBoolean("isRepeatTimerTask", false)));
    L12:
        r7.put("is_repeat_timer_task", r6);
        r7.put("widget_state_enum", r21.getWidgetStateType());
        IMAppActionExt r10 = new IMAppActionExt();
        r10.put("obric_session_info", r7.toString());
        r10.put("obric_remoteCardViewUri", r3);
        r10.put("obric_remoteCardViewExtraParams", new JSONObject().put("widget_state", j.f24894a.a().toJson(r21)).put("doubao_message_id", r5).toString());
        r10.put("obric_remoteCardViewHeight", "140");
        r4.setExt((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r10, ConcurrentHashMap.class, "com.obric.aiagent.plugin"));
        ILogDepend.Companion.d("AssistRemoteCard", "create card: " + r21);
        DispatchContext r1 = doubaoDispatchContext(r21);
        if (r1 == null) goto L15;
        AtomicCapabilitySdk.INSTANCE.updateIntentResult(r4, r1, true);
        return;
    L15:
        AssistRemoteCardUpdateImpl r0 = (AssistRemoteCardUpdateImpl) ZeusTransformUtils.preCheckCast(this, AssistRemoteCardUpdateImpl.class, "com.obric.aiagent.plugin");
        AtomicCapabilitySdk.updateIntentResult$default(AtomicCapabilitySdk.INSTANCE, r4, r5, true, null, 8, null);
        return;
    L11:
        r6 = false;
        goto L12
    L7:
        r8 = false;
        goto L8
    }

    public final void updateCard(WidgetState r6) {
        o.e(r6, "state");
        Long r5 = doubaoMessageId(r6);
        if (r5 == null) goto L6;
        long r0 = r5.longValue();
        Uri r7 = f.f24886a.a(r6);
        JSONObject r1 = new JSONObject().put("widget_state", j.f24894a.a().toJson(r6)).put("doubao_message_id", r0);
        ILogDepend.Companion.d("AssistRemoteCard", "update card: " + r6 + ' ' + r7);
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a(r7, r1);
        return;
    }

    private final Long doubaoMessageId(WidgetState r1) {
        Bundle r0 = r1.getSessionInfo().getTask().getTaskExtras();
        if (r0 == null) goto L9;
        Object r2 = r0.get("doubao_message_id");
        if (r2 == null) goto L9;
        String r3 = r2.toString();
        if (r3 == null) goto L9;
        return d.o.o.e(r3);
    L9:
        return null;
    }

    private final DispatchContext doubaoDispatchContext(WidgetState r7) {
        Bundle r6 = r7.getSessionInfo().getTask().getTaskExtras();
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
