package com.obric.aikernel.phx;

import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: SdkContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SdkContext {
    public static final SdkContext INSTANCE = null;

    static {
        INSTANCE = new SdkContext();
    }

    private SdkContext() {
    }

    public final Object getBinder(d<? super AIKBinder> r7) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        return AIKernelApi.getBinder$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), 0, r3, 1, null);
    }

    public final boolean isLegacyArch() {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().getLegacyArch();
    }
}
