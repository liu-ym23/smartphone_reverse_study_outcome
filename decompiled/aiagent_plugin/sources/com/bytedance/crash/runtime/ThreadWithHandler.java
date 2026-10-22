package com.bytedance.crash.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ThreadWithHandler {
    private static final b<c, Runnable> f = null;
    private static final b<Message, Runnable> g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f7733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue<c> f7734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<Message> f7735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Handler f7736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f7737e;

    class InnerThread extends HandlerThread {
        static final int MAX_CRASH_TIME = 5;
        volatile int mCrashTimes;
        volatile boolean mUploadTimes;
        final /* synthetic */ ThreadWithHandler this$0;

        InnerThread(ThreadWithHandler r1, String r2) {
            this.this$0 = r1;
            super(r2);
        }

        InnerThread(ThreadWithHandler r1, String r2, int r3) {
            this.this$0 = r1;
            super(r2, r3);
        }

        /* JADX INFO: Infinite loop detected, blocks: 19, insns: 0 */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = ThreadWithHandler.a(this.this$0);
            monitor-enter(r0);
            ThreadWithHandler.a(this.this$0, new Handler());     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            ThreadWithHandler.b(this.this$0).post(new a(this.this$0));
        L24:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (this.mCrashTimes >= 5) goto L14;
            com.bytedance.crash.c.b.a(th);     // Catch: Throwable -> L21
        L16:
            this.mCrashTimes++;     // Catch: Throwable -> L21
            goto L24
        L14:
            if (this.mUploadTimes == true) goto L16;
            this.mUploadTimes = true;     // Catch: Throwable -> L21
            com.bytedance.crash.c.b.b("NPTH_ERR_MAX", new RuntimeException());     // Catch: Throwable -> L21
        L18:
            th = move-exception;
            throw th;
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ThreadWithHandler f7738a;

        a(ThreadWithHandler r1) {
            this.f7738a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            a();
        }

        void a() {
        L3:
            if (ThreadWithHandler.c(this.f7738a).isEmpty() == true) goto L8;
            c r0 = (c) ZeusTransformUtils.preCheckCast(ThreadWithHandler.c(this.f7738a).poll(), c.class, "com.obric.aiagent.plugin");
            if (ThreadWithHandler.b(this.f7738a) == null) goto L3;
            ThreadWithHandler.b(this.f7738a).sendMessageAtTime(r0.f7739a, r0.f7740b);     // Catch: Throwable -> L9
            goto L3
        }

        void b() {
        L3:
            if (ThreadWithHandler.d(this.f7738a).isEmpty() == true) goto L8;
            if (ThreadWithHandler.b(this.f7738a) == null) goto L3;
            ThreadWithHandler.b(this.f7738a).sendMessageAtFrontOfQueue((Message) ZeusTransformUtils.preCheckCast(ThreadWithHandler.d(this.f7738a).poll(), Message.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
            goto L3
        }
    }

    interface b<A, B> {
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f7739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f7740b;

        c(Message r1, long r2) {
            this.f7739a = r1;
            this.f7740b = r2;
        }
    }

    static /* synthetic */ Handler a(ThreadWithHandler r0, Handler r1) {
        r0.f7736d = r1;
        return r1;
    }

    static /* synthetic */ Object a(ThreadWithHandler r0) {
        return r0.f7737e;
    }

    static /* synthetic */ Handler b(ThreadWithHandler r0) {
        return r0.f7736d;
    }

    static /* synthetic */ Queue c(ThreadWithHandler r0) {
        return r0.f7734b;
    }

    static /* synthetic */ Queue d(ThreadWithHandler r0) {
        return r0.f7735c;
    }

    public ThreadWithHandler(String r2) {
        this.f7734b = new ConcurrentLinkedQueue();
        this.f7735c = new ConcurrentLinkedQueue();
        this.f7737e = new Object();
        this.f7733a = new InnerThread(this, r2);
    }

    public void a() {
        this.f7733a.start();
    }

    public HandlerThread b() {
        return this.f7733a;
    }

    private Message a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return Message.obtain(this.f7736d, r4);
    }

    public final boolean a(Runnable r3, long r4) {
        return a(a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin")), r4);
    }

    static {
        f = new AnonymousClass1();
        g = new AnonymousClass2();
    }

    private boolean a(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return b(r4, SystemClock.uptimeMillis() + r5);
    }

    private boolean b(Message r4, long r5) {
        if (this.f7736d != null) goto L19;
        Object r0 = this.f7737e;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f7736d != null) goto L11;
        this.f7734b.add(new c(r4, r5));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L19:
        return this.f7736d.sendMessageAtTime(r4, r5);
    L18:
        return true;
    }
}
