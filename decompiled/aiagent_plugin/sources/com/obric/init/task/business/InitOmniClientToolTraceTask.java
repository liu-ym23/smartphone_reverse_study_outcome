package com.obric.init.task.business;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitOmniClientToolTraceTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitOmniClientToolTraceTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_CLIENT_TOOL_TRACE_TASK";

    /* JADX INFO: compiled from: InitOmniClientToolTraceTask.kt */
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

    public InitOmniClientToolTraceTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IOmniClientToolTraceService r2 = (IOmniClientToolTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniClientToolTraceService.class), IOmniClientToolTraceService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.initialize();
        return;
    }
}
