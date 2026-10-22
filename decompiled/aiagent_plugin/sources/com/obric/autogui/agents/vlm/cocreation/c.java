package com.obric.autogui.agents.vlm.cocreation;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import d.h.b.o;

/* JADX INFO: compiled from: OmniLabelingTaskTriggerTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f27232a = null;

    static {
        f27232a = new c();
    }

    private c() {
    }

    public final String a(com.obric.autogui.session.a r1) {
        o.e(r1, SensitiveType.SESSION);
        IAutoActionAgentEventListener.SessionInfo r0 = r1.d();
        return b.a(r0.getInstructionType(), r0.getRecommendTaskType());
    }
}
