package com.obric.autoaction.inittasks.refactor;

import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.agents.vlm.models.omni.intent.a;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: InitFrameWorkUnMuteWhiteListInjectTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitFrameWorkUnMuteWhiteListInjectTask implements IAutoActionFoundationReadyTask {
    public InitFrameWorkUnMuteWhiteListInjectTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        a.a(ObricProductSdk.INSTANCE);
        return x.f38692a;
    }
}
