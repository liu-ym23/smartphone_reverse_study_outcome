package com.obric.autogui.ipc;

import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: OpeartorSessionPrecreator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FlowMessageListenerRegister implements IAutoActionFoundationReadyTask {
    public FlowMessageListenerRegister() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        a.f29125a.a();
        return x.f38692a;
    }
}
