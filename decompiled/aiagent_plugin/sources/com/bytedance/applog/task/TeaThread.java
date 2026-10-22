package com.bytedance.applog.task;

import android.os.Handler;
import android.os.HandlerThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class TeaThread extends HandlerThread {
    private static final int LIMIT_RUN_SIZE = 1000;
    private static final String TAG = "TeaThread";
    private static volatile TeaThread sInst;
    private final LinkedList<Runnable> afterLooperPrepared;
    private volatile boolean isLooperPrepared;
    private final Object lock;
    private volatile Handler mHandler;

    private TeaThread() {
        super(TAG);
        this.lock = new Object();
        this.isLooperPrepared = false;
        this.afterLooperPrepared = new LinkedList();
    }

    private TeaThread(String r1) {
        super(r1);
        this.lock = new Object();
        this.isLooperPrepared = false;
        this.afterLooperPrepared = new LinkedList();
    }

    public static TeaThread getInst() {
        if (sInst != null) goto L15;
        monitor-enter(TeaThread.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInst != null) goto L9;
        sInst = new TeaThread();     // Catch: Throwable -> L11
        sInst.start();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TeaThread.class);     // Catch: Throwable -> L11
    L15:
        return sInst;
    }

    public static TeaThread createNewThread(String r1) {
        return new TeaThread(r1);
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        Object r0 = this.lock;
        monitor-enter(r0);
        this.isLooperPrepared = true;     // Catch: Throwable -> L13
        ArrayList r1 = new ArrayList(this.afterLooperPrepared);     // Catch: Throwable -> L13
        this.afterLooperPrepared.clear();     // Catch: Throwable -> L13
        if (r1.isEmpty() == true) goto L11;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L11;
        post((Runnable) ZeusTransformUtils.preCheckCast(r2.next(), Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void ensureTeaThreadLite(Runnable r3) {
        ensureTeaThreadLiteDelay((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), 0);
    }

    public void ensureTeaThreadLiteDelay(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.isLooperPrepared == false) goto L8;
        postDelay(r5, r4);
        return;
    L8:
        Object r0 = this.lock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L11:
        if (this.isLooperPrepared == false) goto L14;
        postDelay(r5, r4);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L14:
        if (this.afterLooperPrepared.size() <= 1000) goto L16;
        this.afterLooperPrepared.poll();     // Catch: Throwable -> L19
    L16:
        this.afterLooperPrepared.add(r5);     // Catch: Throwable -> L19
        goto L17
    }

    public void post(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        getTeaHandler().post(r4);
        return;
    }

    public void repost(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        removeCallbacks(r4);
        post(r4);
        return;
    }

    public void repost(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        removeCallbacks(r5);
        postDelay(r5, r4);
        return;
    }

    public void postDelay(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        getTeaHandler().postDelayed(r5, r4);
        return;
    }

    public void removeCallbacks(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        getTeaHandler().removeCallbacks(r4);
    }

    public void ensureTeaThread(Runnable r3) {
        ensureTeaThreadLite((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"));
    }

    public Handler getTeaHandler() {
        if (this.mHandler != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mHandler != null) goto L8;
        this.mHandler = new Handler(getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mHandler;
    }

    public Handler createTeaHandler() {
        return new Handler(getLooper());
    }
}
