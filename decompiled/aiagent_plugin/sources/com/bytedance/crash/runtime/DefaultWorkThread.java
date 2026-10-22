package com.bytedance.crash.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.crash.o.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class DefaultWorkThread extends HandlerThread {
    private static final int MAX_CRASH_TIME = 5;
    private static volatile DefaultWorkThread mInstance;
    private final Queue<a> mCacheQueue;
    private int mCrashTimes;
    private Handler mHandler;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Runnable f7731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f7732b;

        a(Runnable r3, long r4) {
            this.f7731a = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            this.f7732b = r4;
        }
    }

    private DefaultWorkThread() {
        super("npth-worker");
        this.mCacheQueue = new ConcurrentLinkedQueue();
    }

    private static DefaultWorkThread instance() {
        if (mInstance != null) goto L15;
        monitor-enter(DefaultWorkThread.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new DefaultWorkThread();     // Catch: Throwable -> L11
        mInstance.start();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DefaultWorkThread.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private void postCachedRunnable() {
        Queue<a> r0 = this.mCacheQueue;
        monitor-enter(r0);
    L18:
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCacheQueue.isEmpty() == true) goto L10;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.mCacheQueue.poll(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        Message r2 = Message.obtain(this.mHandler, r1.f7731a);     // Catch: Throwable -> L15
        this.mHandler.sendMessageAtTime(r2, r1.f7732b);     // Catch: Throwable -> L15
        goto L18
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    private void updateThrowable(Throwable r3) {
        int r0 = this.mCrashTimes;     // Catch: Throwable -> L10
        if (r0 > 5) goto L8;
        if (r0 != 5) goto L6;
        String r1 = "NPTH_ERR_MAX";
    L7:
        com.bytedance.crash.c.b.b(r1, r3);     // Catch: Throwable -> L10
        goto L8
    L6:
        r1 = "NPTH_CATCH";
    L8:
        this.mCrashTimes++;     // Catch: Throwable -> L10
        return;
    }

    /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.mHandler = new Handler(Looper.myLooper());
        postCachedRunnable();
    L7:
        Looper.loop();     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r.b(th);
        updateThrowable(th);
        goto L7
    }

    private void postInner(Runnable r4, long r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        if (r5 >= 0) goto L5;
        r5 = 0;
    L5:
        postRunnableAtTime(r6, SystemClock.uptimeMillis() + r5);
    }

    private void postRunnableAtTime(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.mHandler != null) goto L16;
        Queue<a> r0 = this.mCacheQueue;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mHandler != null) goto L11;
        this.mCacheQueue.add(new a(r5, r4));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L16:
        Message r6 = Message.obtain(this.mHandler, r5);
        this.mHandler.sendMessageAtTime(r6, r4);
    }

    private void removeRunnable(Runnable r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.aiagent.plugin");
        Queue<a> r0 = this.mCacheQueue;
        monitor-enter(r0);
        Iterator<a> r1 = this.mCacheQueue.iterator();     // Catch: Throwable -> L15
    L6:
        if (r1.hasNext() == false) goto L10;
        if (((a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin")).f7731a.equals(r7) == false) goto L6;
        r1.remove();     // Catch: Throwable -> L15
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L15
        Handler r5 = this.mHandler;
        if (r5 == null) goto L25;
        r5.removeCallbacks(r7);
        return;
    L25:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static void post(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        instance().postInner(r4, 0);
    }

    public static void postDelayed(Runnable r2, long r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        instance().postInner(r4, r3);
    }

    public static void postAtFront(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        instance().postRunnableAtTime(r4, 0);
    }

    public static void removeCallbacks(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        instance().removeRunnable(r3);
    }

    public static Handler getHandler() {
        return instance().mHandler;
    }

    public static Thread getThread() {
        return instance();
    }

    public static boolean isCurrentThread() {
        if (Thread.currentThread() != getThread()) goto L6;
        return true;
    L6:
        return false;
    }
}
