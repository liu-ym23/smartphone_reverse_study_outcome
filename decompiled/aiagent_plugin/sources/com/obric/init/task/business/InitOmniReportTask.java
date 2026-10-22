package com.obric.init.task.business;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.agent.trace.IOmniReportService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitOmniReportTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitOmniReportTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_OMNI_REPORT_TASK";

    /* JADX INFO: compiled from: InitOmniReportTask.kt */
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

    public InitOmniReportTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IOmniReportService r2 = (IOmniReportService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniReportService.class), IOmniReportService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.init();
        return;
    }
}
