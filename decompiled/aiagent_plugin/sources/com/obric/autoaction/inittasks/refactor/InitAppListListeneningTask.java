package com.obric.autoaction.inittasks.refactor;

import android.content.Context;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: InitAppListListeneningTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitAppListListeneningTask implements IAutoActionFoundationReadyTask {
    public InitAppListListeneningTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r3) {
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        AOPlatformTools.INSTANCE.packages().init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }
}
