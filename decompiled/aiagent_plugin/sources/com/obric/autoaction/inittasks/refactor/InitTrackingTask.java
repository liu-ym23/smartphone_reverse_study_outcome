package com.obric.autoaction.inittasks.refactor;

import android.content.Context;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: InitTrackingTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitTrackingTask implements IAutoActionFoundationReadyTask {
    public InitTrackingTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r3) {
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        if (ObricProductSdk.INSTANCE.featureService().isEmulatorOs() == true) goto L5;
        AOPlatformTools.INSTANCE.tracking().init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L5:
        return x.f38692a;
    }
}
