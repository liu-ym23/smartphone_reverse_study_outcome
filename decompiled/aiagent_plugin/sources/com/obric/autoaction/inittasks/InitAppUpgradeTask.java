package com.obric.autoaction.inittasks;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.autogui.tools.api.IAutoActionAppUpgradeApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InitAppUpgradeTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitAppUpgradeTask implements IInitTask {
    public InitAppUpgradeTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IAutoActionAppUpgradeApi r2 = (IAutoActionAppUpgradeApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAppUpgradeApi.class), IAutoActionAppUpgradeApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.initAppUpgrade();
        return;
    }
}
