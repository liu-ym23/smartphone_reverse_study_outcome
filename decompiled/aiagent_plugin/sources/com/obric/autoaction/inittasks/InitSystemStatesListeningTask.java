package com.obric.autoaction.inittasks;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.IAutoActionSystemStatesApi;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InitSystemStatesListeningTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitSystemStatesListeningTask implements IInitTask {
    public InitSystemStatesListeningTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IAutoActionThermalStateApi r5 = (IAutoActionThermalStateApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionThermalStateApi.class), IAutoActionThermalStateApi.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L5;
        Loog.INSTANCE.i("InitSystemState", " - initialising thermal manager...");
        r5.initThermalStateMonitor();
        Loog.INSTANCE.i("InitSystemState", " - thermal state: " + r5.getThermalLevelState());
    L5:
        IAutoActionSystemStatesApi r6 = (IAutoActionSystemStatesApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionSystemStatesApi.class), IAutoActionSystemStatesApi.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L9;
        r6.initStatesListening();
        Loog.INSTANCE.i("InitSystemState", " - initialised system-states...");
        return;
    }
}
