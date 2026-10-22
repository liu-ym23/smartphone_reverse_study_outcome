package com.bytedance.apm.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class ThreadWithHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final j.a<b, Runnable> f4860b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final j.a<Message, Runnable> f4861c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Handler f4862a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HandlerThread f4863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Queue<b> f4864e;
    private final Queue<Message> f;
    private long g;
    private final Object h;

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

        /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = ThreadWithHandler.a(this.this$0);
            monitor-enter(r0);
            ThreadWithHandler r1 = this.this$0;     // Catch: Throwable -> L11
            r1.f4862a = new Handler();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.this$0.f4862a.post(new a(this.this$0));
        L16:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            com.bytedance.apm.j.a().b(th, "apm_error");
        L11:
            th = move-exception;
            throw th;
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ThreadWithHandler f4865a;

        a(ThreadWithHandler r1) {
            this.f4865a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            a();
        }

        void a() {
        L3:
            if (ThreadWithHandler.b(this.f4865a).isEmpty() == true) goto L14;
            Object r0 = ThreadWithHandler.a(this.f4865a);
            monitor-enter(r0);
            b r1 = (b) ZeusTransformUtils.preCheckCast(ThreadWithHandler.b(this.f4865a).poll(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            if (this.f4865a.f4862a == null) goto L9;
            this.f4865a.f4862a.sendMessageAtTime(r1.f4866a, r1.f4867b);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        void b() {
        L3:
            if (ThreadWithHandler.c(this.f4865a).isEmpty() == true) goto L14;
            Object r0 = ThreadWithHandler.a(this.f4865a);
            monitor-enter(r0);
            if (this.f4865a.f4862a == null) goto L9;
            this.f4865a.f4862a.sendMessageAtFrontOfQueue((Message) ZeusTransformUtils.preCheckCast(ThreadWithHandler.c(this.f4865a).poll(), Message.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f4866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f4867b;

        b(Message r1, long r2) {
            this.f4866a = r1;
            this.f4867b = r2;
        }
    }

    static /* synthetic */ Object a(ThreadWithHandler r0) {
        return r0.h;
    }

    static /* synthetic */ Queue b(ThreadWithHandler r0) {
        return r0.f4864e;
    }

    static /* synthetic */ Queue c(ThreadWithHandler r0) {
        return r0.f;
    }

    public ThreadWithHandler(String r3) {
        this.f4864e = new ConcurrentLinkedQueue();
        this.f = new ConcurrentLinkedQueue();
        this.g = 0;
        this.h = new Object();
        this.f4863d = new InnerThread(this, r3);
    }

    public void a() {
        this.f4863d.start();
    }

    public boolean b() {
        if (this.f4862a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Message a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return Message.obtain(this.f4862a, r4);
    }

    public final boolean b(Runnable r3) {
        return a(a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin")), 0);
    }

    public final boolean a(Runnable r3, long r4) {
        return a(a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin")), r4);
    }

    static {
        f4860b = new AnonymousClass1();
        f4861c = new AnonymousClass2();
    }

    public final void c(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f4864e.isEmpty() == true) goto L5;
    L6:
        j.a(this.f4864e, r4, f4860b);
        j.a(this.f, r4, f4861c);
    L8:
        if (this.f4862a == null) goto L11;
        this.f4862a.removeCallbacks(r4);
        return;
    L11:
        return;
    L5:
        if (this.f.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean a(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return b(r4, SystemClock.uptimeMillis() + r5);
    }

    public final boolean b(Message r3, long r4) {
        if (this.f4862a != null) goto L17;
        Object r0 = this.h;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f4862a != null) goto L11;
        this.f4864e.add(new b(r3, r4));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L17:
        return this.f4862a.sendMessageAtTime(r3, r4);
    }
}
