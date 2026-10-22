package com.bytedance.apm.perf.memory.utils;

import android.os.HandlerThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class PreparedHandlerThread extends HandlerThread {
    private a preparedCallBack;

    public interface a {
        void a();
    }

    public PreparedHandlerThread(String r1) {
        super(r1);
    }

    public PreparedHandlerThread(String r1, int r2) {
        super(r1, r2);
    }

    public void setPreparedCallBack(a r3) {
        this.preparedCallBack = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        monitor-enter(PreparedHandlerThread.class);
        a r1 = this.preparedCallBack;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(PreparedHandlerThread.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
