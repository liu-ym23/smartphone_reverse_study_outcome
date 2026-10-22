package com.obric.init.task.business;

import android.app.Application;
import android.content.Context;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.agent.IAgentService;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitAppIntentTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitAppIntentTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_APP_INTENT_TASK";

    /* JADX INFO: compiled from: InitAppIntentTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public InitAppIntentTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ILogDepend.Companion.i("InitAppIntentTask", "run() called");
        IAgentService r5 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i("InitAppIntentTask", "IAgentService: " + r5);
        if (r5 == null) goto L5;
        r5.init((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L5:
        ILogDepend.Companion.i("InitAppIntentTask", "IAgentService.init() done");
        IDialogStateManager r6 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L8;
        r6.init((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L8:
        ILogDepend.Companion.i("InitAppIntentTask", "run() completed");
    }
}
