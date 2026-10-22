package com.obric.init.task.business;

import android.app.Application;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.eventkit.ITaskManagerApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitEventTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitEventTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_EVENT_TASK_TASK";

    /* JADX INFO: compiled from: InitEventTask.kt */
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

    public InitEventTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ITaskManagerApi r3 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.init((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
        return;
    }
}
