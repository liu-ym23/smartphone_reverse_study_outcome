package com.obric.autogui.agents.vlm.models.impl.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: InputMethodFeedbackUpdater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {
    public c() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.b.b
    public void a(com.obric.autogui.agents.vlm.b.C0677b r3, com.obric.autogui.agents.vlm.models.c.b r4, a r5) {
        a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        o.e(r3, SensitiveType.SESSION);
        o.e(r4, "preparation");
        o.e(r2, "requestEnvironment");
        if (r4.j() == false) goto L6;
        return;
    L6:
        if ((r4.d() & 8) == 0) goto L9;
        return;
    L9:
        if ((r4.d() & 4) == 0) goto L11;
        String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_ime_ready, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_ime_ready"));
        o.c(r6, "getString(...)");
        r2.c(r6);
        return;
    L11:
        String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_ime_not_ready, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_ime_not_ready"));
        o.c(r7, "getString(...)");
        r2.c(r7);
    }
}
