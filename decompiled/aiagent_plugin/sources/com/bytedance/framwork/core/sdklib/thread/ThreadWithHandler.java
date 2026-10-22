package com.bytedance.framwork.core.sdklib.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.framwork.core.sdklib.b.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class ThreadWithHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d.a<b, Runnable> f8653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final d.a<Message, Runnable> f8654b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HandlerThread f8655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue<b> f8656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Queue<Message> f8657e;
    private volatile Handler f;
    private final Object g;

    class InnerThread extends HandlerThread {
        final /* synthetic */ ThreadWithHandler this$0;

        InnerThread(ThreadWithHandler r1, String r2) {
            this.this$0 = r1;
            super(r2);
        }

        InnerThread(ThreadWithHandler r1, String r2, int r3) {
            this.this$0 = r1;
            super(r2, r3);
        }

        /* JADX INFO: Infinite loop detected, blocks: 7, insns: 0 */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = ThreadWithHandler.a(this.this$0);
            monitor-enter(r0);
            ThreadWithHandler.a(this.this$0, new Handler());     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            ThreadWithHandler.b(this.this$0).post(new a(this.this$0));
        L13:
            Looper.loop();     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            throw th;
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ThreadWithHandler f8658a;

        a(ThreadWithHandler r1) {
            this.f8658a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            a();
        }

        void a() {
        L3:
            if (ThreadWithHandler.c(this.f8658a).isEmpty() == true) goto L7;
            b r0 = (b) ZeusTransformUtils.preCheckCast(ThreadWithHandler.c(this.f8658a).poll(), b.class, "com.obric.aiagent.plugin");
            if (ThreadWithHandler.b(this.f8658a) == null) goto L3;
            ThreadWithHandler.b(this.f8658a).sendMessageAtTime(r0.f8659a, r0.f8660b);
            goto L3
        }

        void b() {
        L3:
            if (ThreadWithHandler.d(this.f8658a).isEmpty() == true) goto L7;
            if (ThreadWithHandler.b(this.f8658a) == null) goto L3;
            ThreadWithHandler.b(this.f8658a).sendMessageAtFrontOfQueue((Message) ZeusTransformUtils.preCheckCast(ThreadWithHandler.d(this.f8658a).poll(), Message.class, "com.obric.aiagent.plugin"));
            goto L3
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f8659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f8660b;

        b(Message r1, long r2) {
            this.f8659a = r1;
            this.f8660b = r2;
        }
    }

    static /* synthetic */ Handler a(ThreadWithHandler r0, Handler r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ Object a(ThreadWithHandler r0) {
        return r0.g;
    }

    static /* synthetic */ Handler b(ThreadWithHandler r0) {
        return r0.f;
    }

    static /* synthetic */ Queue c(ThreadWithHandler r0) {
        return r0.f8656d;
    }

    static /* synthetic */ Queue d(ThreadWithHandler r0) {
        return r0.f8657e;
    }

    public ThreadWithHandler(String r2) {
        this.f8656d = new ConcurrentLinkedQueue();
        this.f8657e = new ConcurrentLinkedQueue();
        this.g = new Object();
        this.f8655c = new InnerThread(this, r2);
    }

    public void a() {
        this.f8655c.start();
    }

    private Message c(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return Message.obtain(this.f, r4);
    }

    public final boolean a(Runnable r3) {
        return a(c((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin")), 0);
    }

    public final boolean a(Runnable r3, long r4) {
        return a(c((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin")), r4);
    }

    static {
        f8653a = new AnonymousClass1();
        f8654b = new AnonymousClass2();
    }

    public final void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f8656d.isEmpty() == true) goto L5;
    L6:
        d.a(this.f8656d, r4, f8653a);
        d.a(this.f8657e, r4, f8654b);
    L8:
        if (this.f == null) goto L11;
        this.f.removeCallbacks(r4);
        return;
    L11:
        return;
    L5:
        if (this.f8657e.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean a(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return b(r4, SystemClock.uptimeMillis() + r5);
    }

    public final boolean b(Message r3, long r4) {
        if (this.f != null) goto L17;
        Object r0 = this.g;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f != null) goto L11;
        this.f8656d.add(new b(r3, r4));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L17:
        return this.f.sendMessageAtTime(r3, r4);
    }
}
