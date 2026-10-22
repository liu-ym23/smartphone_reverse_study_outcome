package com.obric.autoaction.vdplayer.b.a;

import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.aa;
import d.m;
import d.s;
import d.x;

/* JADX INFO: compiled from: SelectClarificationOptionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public g() {
    }

    public final Object a(String r7, IAutoActionAgentEventListener.SessionInfo r8, boolean r9, d.c.d<? super x> r10) {
        d.c.d<? super com.obric.autogui.common.e> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        IAutoActionAgentApi r11 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAgentApi.class), IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        if (r9 == false) goto L10;
        if (r8 == null) goto L10;
        if (r8.getTask().isOmni() == false) goto L10;
        IFlowMessageIDL r0 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r0 == null) goto L10;
        r0.sendMessageWithExtra(null, r7, "omni_gui_reply", "", ao.a(new m[]{s.a("o_omni_intention", "task_reply"), s.a("o_omni_task_id", r8.getSessionId()), s.a("o_task_type", IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK), s.a("o_complex_source_type", "gui")}));
    L10:
        if (r11 == null) goto L17;
        Object r12 = r11.exitUserClarify(r7, "gui_player_btn", r6);
        if (r12 != d.c.a.b.a()) goto L15;
        return r12;
    L15:
        return x.f38692a;
    L17:
        return x.f38692a;
    }
}
