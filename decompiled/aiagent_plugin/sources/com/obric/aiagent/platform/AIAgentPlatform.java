package com.obric.aiagent.platform;

import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AIAgentPlatform.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AIAgentPlatform {
    public static final AIAgentPlatform INSTANCE = null;
    private static IAIAgentPlatform platform;

    static {
        INSTANCE = new AIAgentPlatform();
    }

    private AIAgentPlatform() {
    }

    public final void init(IAIAgentPlatform r2) {
        IAIAgentPlatform r1 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
        o.e(r1, WsConstants.KEY_PLATFORM);
        platform = r1;
    }

    public final IAIAgentPlatform get$platform_release() {
        IAIAgentPlatform r2 = platform;
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (IAIAgentPlatform) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAIAgentPlatform.class), IAIAgentPlatform.class, "com.obric.aiagent.plugin");
    }
}
