package com.bytedance.frameworks.baselib.network.http.retrofit;

import com.bytedance.frameworks.baselib.network.dispatcher.ApiTask;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue;
import com.bytedance.frameworks.baselib.network.dispatcher.RequestQueue;
import com.bytedance.frameworks.baselib.network.dispatcher.ThreadPoolConfig;
import com.bytedance.retrofit2.SsRunnable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class SsHttpExecutor implements Executor {
    private static volatile IRequestQueue sRequestQueue;

    static {
    }

    public SsHttpExecutor() {
    }

    public static void setRequestQueue(RequestQueue r0) {
        sRequestQueue = r0;
    }

    public static void setThreadPoolConfig(ThreadPoolConfig r0) {
        RequestQueue.setThreadPoolConfig(r0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r9) {
        if (r9 == null) goto L31;
        IRequest.Priority r8 = IRequest.Priority.NORMAL;
        if ((r9 instanceof SsRunnable) == false) goto L22;
        SsRunnable r10 = (SsRunnable) r9;
        int r0 = r10.priority();
        if (r0 != 0) goto L9;
        IRequest.Priority r1 = IRequest.Priority.LOW;
    L21:
        boolean r2 = r10.isStreaming();
        int r5 = r10.getRequestDelayTime();
        IRequest.Priority r4 = r1;
    L24:
        if (sRequestQueue != null) goto L26;
        sRequestQueue = RequestQueue.getDefaultRequestQueue();
    L26:
        ApiTask r11 = new ApiTask("NetExecutor", r4, r5, r9, r2);
        if (r2 == false) goto L29;
        sRequestQueue.addDownload(r11);
        return;
    L29:
        sRequestQueue.add(r11);
        return;
    L9:
        if (1 != r0) goto L12;
        r1 = IRequest.Priority.NORMAL;
        goto L21
    L12:
        if (2 != r0) goto L15;
        r1 = IRequest.Priority.HIGH;
        goto L21
    L15:
        if (3 != r0) goto L18;
        r1 = IRequest.Priority.IMMEDIATE;
        goto L21
    L18:
        if ((-1) != r0) goto L20;
        r1 = IRequest.Priority.LOWEST;
        goto L21
    L20:
        r1 = IRequest.Priority.NORMAL;
        goto L21
    L22:
        r2 = false;
        r4 = r8;
        r5 = 0;
        goto L24
    }
}
