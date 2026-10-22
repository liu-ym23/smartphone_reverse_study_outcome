package com.obric.aiagent.product;

import com.obric.aiagent.platform.AIAgentPlatform;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.aiagent.product.feature.api.IFeatureService;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricProductSdk.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricProductSdk {
    public static final ObricProductSdk INSTANCE = null;

    static {
        INSTANCE = new ObricProductSdk();
    }

    private ObricProductSdk() {
    }

    public final void init(IAIAgentPlatform r2) {
        IAIAgentPlatform r1 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        AIAgentPlatform.INSTANCE.init(r1);
    L5:
        a.f18767a.a().init();
    }

    public final boolean isInited() {
        return a.f18767a.a().getInitialize();
    }

    public final void destroy() {
        a.f18767a.a().destroy();
    }

    public final IPlatformService platformService() {
        return a.f18767a.a().platformService();
    }

    public final IFeatureService featureService() {
        return a.f18767a.a().featureService();
    }
}
