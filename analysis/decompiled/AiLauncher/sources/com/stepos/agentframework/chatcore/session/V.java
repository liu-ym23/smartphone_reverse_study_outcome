package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/V;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/intent/e;)Z", "", "guiAgentModelName", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/intent/e;Ljava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class V {
    public static final V INSTANCE = new V();

    public final boolean a(AgentTool tool) {
        kotlin.jvm.internal.p.i(tool, "tool");
        return kotlin.jvm.internal.p.d(tool.getToolId(), "0") || kotlin.jvm.internal.p.d(tool.getName(), "gui_agent");
    }

    public final void b(AgentTool tool, String guiAgentModelName) {
        kotlin.jvm.internal.p.i(tool, "tool");
        if (a(tool) && tool.getAppUIData() == null) {
            int iC = AppUIData.INSTANCE.c();
            String json = ExtKt.l().toJson(new RobotArguments(tool.getParameter(), 0, null, 4, null));
            kotlin.jvm.internal.p.h(json, "toJson(...)");
            tool.x(new AppUIData(null, iC, null, false, "task_robot_running", null, null, json, null, null, null, null, null, guiAgentModelName == null ? "doubao-1.5-ui-tars" : guiAgentModelName, false, false, 57197, null));
        }
    }
}
