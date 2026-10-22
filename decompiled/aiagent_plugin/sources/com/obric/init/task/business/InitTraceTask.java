package com.obric.init.task.business;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.trace.ITraceReport;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitTraceTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitTraceTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_TRACE_TASK";

    /* JADX INFO: compiled from: InitTraceTask.kt */
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

    public InitTraceTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ITraceReport r2 = (ITraceReport) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITraceReport.class), ITraceReport.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.init();
        return;
    }
}
