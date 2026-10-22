package com.obric.autoaction.inittasks;

import android.content.Context;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.model.IAutoActionLocalModelProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InitLocalAITask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitLocalAITask implements IInitTask {
    public InitLocalAITask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        IAutoActionLocalModelProvider r0 = (IAutoActionLocalModelProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionLocalModelProvider.class), IAutoActionLocalModelProvider.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.init(r3);
        return;
    }
}
