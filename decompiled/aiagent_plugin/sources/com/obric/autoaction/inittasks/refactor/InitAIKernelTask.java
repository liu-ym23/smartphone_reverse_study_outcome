package com.obric.autoaction.inittasks.refactor;

import android.content.Context;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.model.IAutoActionLocalModelProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: InitAIKernelTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitAIKernelTask implements IAutoActionFoundationReadyTask {
    public InitAIKernelTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r3) {
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ObricProductSdk.INSTANCE.platformService().romInfo().isOautoModelPreinstalled(r4) == false) goto L6;
        Loog.INSTANCE.i("InitAIKernelTask", "Oauto model is preinstalled, skip AIKernel init on startup.");
        return x.f38692a;
    L6:
        IAutoActionLocalModelProvider r5 = (IAutoActionLocalModelProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionLocalModelProvider.class), IAutoActionLocalModelProvider.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        r5.init(r4);
    L10:
        return x.f38692a;
    }
}
