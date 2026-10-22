package com.bytedance.apm.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ApmHandlerThread {
    private static volatile Handler defaultMainHandler;
    private static HashSet<HandlerThread> handlerThreads;

    public ApmHandlerThread() {
    }

    static {
        handlerThreads = new HashSet();
        defaultMainHandler = new Handler(Looper.getMainLooper());
    }

    public static Handler getDefaultMainHandler() {
        return defaultMainHandler;
    }

    public static HandlerThread getNewHandlerThread(String r1) {
        return getNewHandlerThread(r1, -1);
    }

    public static HandlerThread getNewHandlerThread(String r2, int r3) {
        Iterator<HandlerThread> r0 = handlerThreads.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().isAlive() == true) goto L4;
        r0.remove();
        goto L4
    L8:
        HandlerThread r1 = new HandlerThread(r2);
        if (r3 == (-1)) goto L11;
        r1.setPriority(r3);
    L11:
        r1.start();
        handlerThreads.add(r1);
        return r1;
    }

    public static ThreadWithHandler getThreadWithHandler(String r1) {
        ThreadWithHandler r0 = new ThreadWithHandler(r1);
        r0.start();
        return r0;
    }
}
