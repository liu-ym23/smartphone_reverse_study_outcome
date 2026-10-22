package com.obric.init.task.business;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.performance.IMemoryReportService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitMemoryReportTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitMemoryReportTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_MEMORY_REPORT_TASK";

    /* JADX INFO: compiled from: InitMemoryReportTask.kt */
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

    public InitMemoryReportTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IMemoryReportService r2 = (IMemoryReportService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IMemoryReportService.class), IMemoryReportService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.init();
        return;
    }
}
