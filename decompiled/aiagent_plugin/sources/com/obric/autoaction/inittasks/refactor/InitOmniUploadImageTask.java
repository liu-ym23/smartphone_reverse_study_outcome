package com.obric.autoaction.inittasks.refactor;

import com.obric.autogui.agents.vlm.models.omni.upload.e;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: InitOmniUploadImageTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitOmniUploadImageTask implements IAutoActionFoundationReadyTask {
    public InitOmniUploadImageTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        e.f28643a.a();
        return x.f38692a;
    }
}
