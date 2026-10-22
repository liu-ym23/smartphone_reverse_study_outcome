package com.stepos.agentframework.chatcore.intent;

import La.H;
import La.K;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import java.util.Map;
import kotlin.Metadata;
import u4.m;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b*\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/e;", "prev", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/intent/e;Lcom/stepos/agentframework/chatcore/intent/e;)V", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/intent/e;Lcom/stepos/agentframework/chatcore/intent/e;)Z", "", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatcore/intent/e;)Ljava/lang/String;", "", "", "c", "(Lcom/stepos/agentframework/chatcore/intent/e;)Ljava/util/Map;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class f {
    public static final void a(AgentTool agentTool, AgentTool prev) {
        kotlin.jvm.internal.p.i(agentTool, "<this>");
        kotlin.jvm.internal.p.i(prev, "prev");
        if (kotlin.jvm.internal.p.d(agentTool.getClientRenderSource(), com.stepos.ailauncher.chat.trace.f.ENTRY_HISTORY) && kotlin.jvm.internal.p.d(prev.getClientRenderSource(), "realtime")) {
            agentTool.y(prev.getClientRenderSource());
        }
        if (agentTool.getAppUIData() == null && b(agentTool, prev)) {
            agentTool.x(prev.getAppUIData());
        }
        if (agentTool.getIsUpdate()) {
            agentTool.B(prev.getHidden());
            agentTool.z(prev.getDisplayName());
        } else {
            if (prev.getHidden() || !agentTool.getHidden()) {
                return;
            }
            agentTool.B(false);
            agentTool.z(prev.getDisplayName());
        }
    }

    public static final boolean b(AgentTool agentTool, AgentTool agentTool2) {
        AppUIData appUIData = agentTool2.getAppUIData();
        if (!kotlin.jvm.internal.p.d(appUIData != null ? appUIData.getAppUIName() : null, m.TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE)) {
            return false;
        }
        String name = agentTool.getName();
        if (H.x0(name)) {
            name = null;
        }
        if (name == null && (name = agentTool.getApiName()) == null) {
            String name2 = agentTool2.getName();
            String str = H.x0(name2) ? null : name2;
            name = str == null ? agentTool2.getApiName() : str;
        }
        return q4.i.INSTANCE.l(name, agentTool.getParameter());
    }

    public static final Map<String, Object> c(AgentTool agentTool) {
        kotlin.jvm.internal.p.i(agentTool, "<this>");
        return kotlin.collections.a.m(Y8.j.a("toolCallId", agentTool.getToolCallId()), Y8.j.a("name", agentTool.getName()), Y8.j.a("apiName", agentTool.getApiName()), Y8.j.a("isFinished", Boolean.valueOf(agentTool.getIsFinished())), Y8.j.a("paramLen", Integer.valueOf(agentTool.getParameter().length())), Y8.j.a("resultLen", Integer.valueOf(agentTool.getResult().length())));
    }

    public static final String d(AgentTool agentTool) {
        kotlin.jvm.internal.p.i(agentTool, "<this>");
        return agentTool.getName() + "(id=" + K.S1(agentTool.getToolCallId(), 8) + ", finished=" + agentTool.getIsFinished() + ", paramLen=" + agentTool.getParameter().length() + ", resultLen=" + agentTool.getResult().length() + ")";
    }
}
