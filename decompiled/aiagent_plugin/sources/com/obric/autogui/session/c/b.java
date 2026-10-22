package com.obric.autogui.session.c;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.agents.vlm.models.omni.intent.g;
import com.obric.autogui.agents.vlm.models.omni.intent.j;
import com.obric.autogui.agents.vlm.models.omni.l;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.t;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: AOSessionBizTrackingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ x lambda$7EjeG8FqxtKkQL6PTpxp4GQdYX4(JSONObject r0, r r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ x lambda$HBBEVj5zm0JUg61aBLbksVgGQlo(JSONObject r0, r r1) {
        return c(r0, r1);
    }

    public static final void a(final JSONObject r2, com.obric.autogui.session.a r3) {
        o.e(r2, "<this>");
        o.e(r3, SensitiveType.SESSION);
        r2.put("session_id", r3.b());
        r2.put("instruction_id", r3.b());
        r2.put("session_key", r3.a());
        r2.put("is_omni", r3.c());
        r3.a(new $$Lambda$b$7EjeG8FqxtKkQL6PTpxp4GQdYX4(r2));
        a(r2, r3.l());
        r3.a(new $$Lambda$b$HBBEVj5zm0JUg61aBLbksVgGQlo(r2));
    }

    private static final x b(JSONObject r1, r r2) {
        o.e(r2, "it");
        r1.put("inner_log_id", r2.b());
        return x.f38692a;
    }

    private static final x c(JSONObject r1, r r2) {
        o.e(r2, "omniSession");
        a(r1, r2);
        return x.f38692a;
    }

    public static final void a(JSONObject r2, IAutoActionAgentEventListener.SessionInfo r3) {
        o.e(r2, "<this>");
        o.e(r3, SensitiveType.SESSION);
        r2.put("session_id", r3.getSessionId());
        r2.put("instruction_id", r3.getSessionId());
        r2.put("session_key", r3.getSessionKey());
        r2.put("is_omni", r3.getTask().isOmni());
        t r0 = t.f28523a;
        String r1 = r3.getSessionId();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r r4 = r0.a(r1);
        if (r4 == null) goto L8;
        r2.put("inner_log_id", r4.b());
    L8:
        b(r2, r3);
        a(r2, r3.getTask());
    }

    public static final void a(JSONObject r6, AutoOperateTask r7) {
        o.e(r6, "<this>");
        o.e(r7, "task");
        r6.put("session_origin", r7.getLaunchOrigin());
        Bundle r0 = r7.getTaskExtras();
        String r2 = null;
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.getLong("doubao_message_id"));
    L6:
        if (r1 == null) goto L8;
        r6.put("doubao_message_id", r1.longValue());
    L8:
        IAutoActionPresentationApi r3 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        IAutoActionPresentationApi.PlayerVisibility r4 = r3.getPlayerVisibility((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L13:
        if (r4 != IAutoActionPresentationApi.PlayerVisibility.Visible) goto L15;
        boolean r5 = true;
    L16:
        r6.put("player_visible", r5);
        if (r7.getTimerTaskId() == null) goto L47;
        r6.put("is_timer_task", true);
        Bundle r8 = r7.getTaskExtras();
        if (r8 == null) goto L21;
        Boolean r9 = Boolean.valueOf(r8.getBoolean("isRepeatTimerTask", false));
    L22:
        r6.put("is_repeat_timer_task", r9);
        Bundle r10 = r7.getTaskExtras();
        if (r10 == null) goto L25;
        Long r11 = Long.valueOf(r10.getLong("trigger_time"));
    L26:
        if (r11 == null) goto L28;
        r6.put("from_trigger_duration", AOSystemTools.INSTANCE.nowTimeMillis() - r11.longValue());
    L28:
        r6.put("timer_task_id", r7.getTimerTaskId());
        Bundle r12 = r7.getTaskExtras();
        if (r12 == null) goto L31;
        r2 = r12.getString("task_log_extras");
    L31:
        if (r2 == null) goto L48;
        n.a r13 = n.f38560a;     // Catch: Throwable -> L38
        JSONObject r14 = new JSONObject(r2);     // Catch: Throwable -> L38
        Iterator<String> r15 = r14.keys();     // Catch: Throwable -> L38
        o.c(r15, "keys(...)");     // Catch: Throwable -> L38
    L34:
        if (r15.hasNext() == false) goto L36;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        r6.put(r16, r14.get(r16));     // Catch: Throwable -> L38
        goto L34
    L36:
        Object r17 = n.f(x.f38692a);     // Catch: Throwable -> L38
    L41:
        if (n.c(r17) == null) goto L49;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r6), "Failed to parse task_log_extras");
        return;
    L49:
        return;
    L38:
        th = move-exception;
        n.a r18 = n.f38560a;
        r17 = n.f(d.o.a(th));
        goto L41
    L48:
        return;
    L25:
        r11 = null;
        goto L26
    L21:
        r9 = null;
        goto L22
    L47:
        return;
    L15:
        r5 = false;
        goto L16
    L11:
        r4 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public static final void a(JSONObject r2, r r3) {
        o.e(r2, "<this>");
        o.e(r3, SensitiveType.SESSION);
        l r4 = r3.f();
        if (r4 == null) goto L16;
        g r5 = r4.a();
        if (r5 == null) goto L17;
        r2.put("current_tool_id", r5.g());
        r2.put("current_tool_name", r5.h());
        r2.put("instruction_type", r5.i());
        j r0 = r5.c();
        if (r0 == null) goto L10;
        String r1 = r0.a();
    L11:
        if (r1 == null) goto L13;
        String r6 = r5.c().a();
    L14:
        r2.put("action_type", r6);
        return;
    L13:
        r6 = "multi_action";
        goto L14
    L10:
        r1 = null;
        goto L11
    L17:
        return;
    }

    public static final void b(JSONObject r2, IAutoActionAgentEventListener.SessionInfo r3) {
        o.e(r2, "<this>");
        o.e(r3, SensitiveType.SESSION);
        r2.put("current_tool_id", r3.getToolId());
        r2.put("current_tool_name", r3.getToolName());
        r2.put("instruction_type", r3.getInstructionType());
        if (r3.getActionType() == null) goto L5;
        String r4 = r3.getActionType();
    L6:
        r2.put("action_type", r4);
        return;
    L5:
        r4 = "multi_action";
        goto L6
    }
}
