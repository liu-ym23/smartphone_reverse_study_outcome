package com.obric.init.task.comon;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.apm.IApm;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitApmTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitApmTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_APM_TASK";

    /* JADX INFO: compiled from: InitApmTask.kt */
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

    public InitApmTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IApm r2 = (IApm) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IApm.class), IApm.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.initApm();
        return;
    }
}
