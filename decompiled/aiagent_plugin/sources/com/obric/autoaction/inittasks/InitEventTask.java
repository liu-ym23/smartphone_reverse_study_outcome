package com.obric.autoaction.inittasks;

import android.app.Application;
import android.content.Context;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.eventkit.EventsTaskSdk;
import com.obric.eventkit.logger.ILogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: InitEventTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitEventTask implements IInitTask {
    public InitEventTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r2, "null cannot be cast to non-null type android.app.Application");
        EventsTaskSdk.init(new EventsTaskSdk.InitConfig((Application) ZeusTransformUtils.preCheckCast(r2, Application.class, "com.obric.aiagent.plugin")));
        EventsTaskSdk.setLogger((ILogger) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), ILogger.class, "com.obric.aiagent.plugin"));
    }
}
