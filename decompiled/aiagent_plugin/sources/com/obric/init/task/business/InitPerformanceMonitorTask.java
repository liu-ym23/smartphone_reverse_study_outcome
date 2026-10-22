package com.obric.init.task.business;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.performance.IPerformanceMonitor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitPerformanceMonitorTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitPerformanceMonitorTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_PERFORMANCE_MONITOR_TASK";

    /* JADX INFO: compiled from: InitPerformanceMonitorTask.kt */
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

    public InitPerformanceMonitorTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IPerformanceMonitor r2 = (IPerformanceMonitor) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPerformanceMonitor.class), IPerformanceMonitor.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.init();
        return;
    }
}
