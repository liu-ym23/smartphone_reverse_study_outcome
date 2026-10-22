package com.obric.autoaction.inittasks;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;

/* JADX INFO: compiled from: InitAutoActionAgentTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitAutoActionAgentTask implements IInitTask {
    public InitAutoActionAgentTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cleaning dangling tasks (if any)");
        AutoActionAgent.INSTANCE.cleanDanglingTask();
    }
}
