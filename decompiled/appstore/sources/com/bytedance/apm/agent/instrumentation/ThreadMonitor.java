package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.util.a;
import com.bytedance.apm.util.u;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class ThreadMonitor {
    private static final String TAG = "ThreadMonitor";

    public ThreadMonitor() {
    }

    private static boolean isDebuggable() {
        return a.c(c.g());
    }

    private static boolean isLocalChannel() {
        return c.E();
    }

    public static void sleepMonitor(long r10) throws InterruptedException {
        if (u.a() == true) goto L5;
    L9:
        Thread.sleep(r10);
        return;
    L5:
        if (r10 <= 10) goto L9;
        if (isDebuggable() == true) goto L9;
        isLocalChannel();
        goto L9
    }
}
