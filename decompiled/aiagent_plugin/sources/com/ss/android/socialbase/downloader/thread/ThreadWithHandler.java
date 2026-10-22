package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes4.dex */
public class ThreadWithHandler {
    private InnerThread handlerThread;
    private Object lock;
    private Queue<MessageEntity> mCacheQueue;
    private Handler mHandler;

    private class InnerThread extends HandlerThread {
        final /* synthetic */ ThreadWithHandler this$0;

        InnerThread(ThreadWithHandler r1, String r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper r0 = getLooper();
            Object r1 = ThreadWithHandler.access$000(this.this$0);
            monitor-enter(r1);
            ThreadWithHandler.access$102(this.this$0, new Handler(r0));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
        L7:
            if (ThreadWithHandler.access$200(this.this$0).isEmpty() == true) goto L11;
            MessageEntity r2 = (MessageEntity) ZeusTransformUtils.preCheckCast(ThreadWithHandler.access$200(this.this$0).poll(), MessageEntity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L7;
            ThreadWithHandler.access$100(this.this$0).postDelayed(r2.target, r2.delayMillis);
            goto L7
        L11:
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    private class MessageEntity {
        public long delayMillis;
        public Runnable target;
        final /* synthetic */ ThreadWithHandler this$0;

        public MessageEntity(ThreadWithHandler r3, Runnable r4, long r5) {
            Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.target = r6;
            this.delayMillis = r5;
        }
    }

    static /* synthetic */ Object access$000(ThreadWithHandler r0) {
        return r0.lock;
    }

    static /* synthetic */ Handler access$100(ThreadWithHandler r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Handler access$102(ThreadWithHandler r0, Handler r1) {
        r0.mHandler = r1;
        return r1;
    }

    static /* synthetic */ Queue access$200(ThreadWithHandler r0) {
        return r0.mCacheQueue;
    }

    public ThreadWithHandler(String r2) {
        this.lock = new Object();
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.handlerThread = new InnerThread(this, r2);
    }

    public void start() {
        this.handlerThread.start();
    }

    public void post(Runnable r3) {
        postDelayed((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), 0);
    }

    public void postDelayed(Runnable r4, long r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        if (this.mHandler != null) goto L16;
        Object r0 = this.lock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mHandler != null) goto L11;
        this.mCacheQueue.add(new MessageEntity(this, r6, r5));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L16:
        this.mHandler.postDelayed(r6, r5);
    }

    public void quit() {
        this.handlerThread.quit();
    }
}
