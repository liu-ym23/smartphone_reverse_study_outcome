package com.bytedance.lego.init.util;

import androidx.core.os.n;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitTaskInfo;
import d.h.b.o;

/* JADX INFO: compiled from: InitTraceUtil.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitTraceUtil {
    public static final InitTraceUtil INSTANCE = null;

    static {
        INSTANCE = new InitTraceUtil();
    }

    private InitTraceUtil() {
    }

    public final void beginTask(InitTaskInfo r2) {
        o.d(r2, "taskInfo");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        n.a("Task:" + r2.taskId);
    }

    public final void endTask() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        n.a();
    }

    public final void beginSection(String r2) {
        o.d(r2, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        n.a("Task:" + r2);
    }

    public final void endSection() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        n.a();
    }
}
