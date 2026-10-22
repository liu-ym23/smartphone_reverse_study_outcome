package com.obric.autogui.agents.vlm.models.impl.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.space.errtrack.AppErrorTracker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OperatingAppFeedbackUpdater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements b {
    public e() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.b.b
    public void a(com.obric.autogui.agents.vlm.b.C0677b r4, com.obric.autogui.agents.vlm.models.c.b r5, a r6) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        o.e(r5, "preparation");
        o.e(r3, "requestEnvironment");
        int r7 = AppErrorTracker.INSTANCE.getCurrentError();
        if (r7 == 0) goto L6;
        if (r7 == 99) goto L6;
        String r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_error_met, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_error_met"));
        o.c(r8, "getString(...)");
        r3.c(r8);
        return;
    L6:
        if (r7 != 99) goto L10;
        String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_error_multiple_met, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_error_multiple_met"));
        o.c(r9, "getString(...)");
        r3.c(r9);
        return;
    }
}
