package com.obric.init.task.business;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.wakeup.IWakeupDataProcess;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitWakeupTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitWakeupTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_WAKEUP_TASK";

    /* JADX INFO: compiled from: InitWakeupTask.kt */
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

    public InitWakeupTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IWakeupDataProcess r2 = (IWakeupDataProcess) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IWakeupDataProcess.class), IWakeupDataProcess.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.initEnrollData();
        return;
    }
}
