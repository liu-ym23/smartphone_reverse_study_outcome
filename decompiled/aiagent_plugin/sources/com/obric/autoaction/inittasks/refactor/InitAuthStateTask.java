package com.obric.autoaction.inittasks.refactor;

import android.content.Context;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.util.b.a.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: InitAuthStateTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitAuthStateTask implements IAutoActionFoundationReadyTask {
    public InitAuthStateTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r3) {
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        a.f31498a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }
}
