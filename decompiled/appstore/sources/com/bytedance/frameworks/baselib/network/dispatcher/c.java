package com.bytedance.frameworks.baselib.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AtomicInteger f7147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f7148g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHandler f7149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f7150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ThreadPoolExecutor f7151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f7152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadPoolExecutor f7153e;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n4.a f7154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f7155d;

        public a(c r10, n4.a r11, n4.a r12) {
            this.f7155d = r10;
            this.f7154c = r12;
            super(r10, r11);
        }

        public int b(b r10) {
            n4.a r11 = this.f7154c;
            if (r11 != null) goto L5;
            return 0;
        L5:
            return r11.compareTo(b.a(r10));
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return b((b) r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7154c.d() == false) goto L5;
            return;
        L5:
            if (this.f7154c.getPriority() != IRequest.Priority.IMMEDIATE) goto L7;
            c.a(this.f7155d).execute(this.f7154c);
            return;
        L7:
            c.b(this.f7155d).execute(this.f7154c);
        }
    }

    public abstract class b implements Runnable, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n4.a f7156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f7157b;

        public b(c r10, n4.a r11) {
            this.f7157b = r10;
            this.f7156a = r11;
        }

        public static /* synthetic */ n4.a a(b r10) {
            return r10.f7156a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.dispatcher.c$c, reason: collision with other inner class name */
    public static class ThreadFactoryC0093c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f7158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7159b;

        /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.dispatcher.c$c$a */
        public class a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ThreadFactoryC0093c f7160a;

            public a(ThreadFactoryC0093c r10, Runnable r11, String r12) {
                this.f7160a = r10;
                super(r11, r12);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        public ThreadFactoryC0093c(String r10) {
            this.f7158a = new AtomicInteger(1);
            this.f7159b = "ApiExecutor";
            if (TextUtils.isEmpty(r10) == true) goto L6;
            this.f7159b = r10;
            return;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            a r11 = new a(this, r10, this.f7159b + "#" + this.f7158a.getAndIncrement());
            r11.setDaemon(false);
            return r11;
        }
    }

    static {
        f7147f = new AtomicInteger();
        f7148g = new c();
    }

    public c() {
        this.f7149a = new WeakHandler(Looper.getMainLooper(), this);
    }

    public static /* synthetic */ ExecutorService a(c r10) {
        return r10.g();
    }

    public static /* synthetic */ ExecutorService b(c r10) {
        return r10.e();
    }

    public static int j() {
        return f7147f.incrementAndGet();
    }

    public void c(n4.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.b() == true) goto L21;
        r10.e(j());
        if (r10.c() == false) goto L10;
        h().execute(i(r10));
        return;
    L10:
        if (r10.getPriority() != IRequest.Priority.IMMEDIATE) goto L12;
        g().execute(r10);
        return;
    L12:
        long r11 = r10.a();
        if (r11 <= 0) goto L15;
        Message r12 = Message.obtain();
        r12.what = 0;
        r12.obj = r10;
        this.f7149a.sendMessageDelayed(r12, r11);
        return;
    L15:
        e().execute(r10);
        return;
    }

    public void d(n4.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.b() == true) goto L17;
        r10.e(j());
        if (r10.getPriority() != IRequest.Priority.IMMEDIATE) goto L9;
        g().execute(r10);
        return;
    L9:
        long r11 = r10.a();
        if (r11 <= 0) goto L12;
        Message r12 = Message.obtain();
        r12.what = 1;
        r12.obj = r10;
        this.f7149a.sendMessageDelayed(r12, r11);
        return;
    L12:
        f().execute(r10);
        return;
    }

    public final synchronized ExecutorService e() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f7151c != null) goto L10;
        ThreadPoolExecutor r10 = k().k();     // Catch: Throwable -> L8
        this.f7151c = r10;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        ThreadPoolExecutor r11 = new ThreadPoolExecutor(k().b(), k().i(), k().a(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0093c("NetNormal"));     // Catch: Throwable -> L8
        this.f7151c = r11;     // Catch: Throwable -> L8
        r11.allowCoreThreadTimeOut(n4.b.b().l());     // Catch: Throwable -> L8
    L10:
        ThreadPoolExecutor r12 = this.f7151c;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r12;
    }

    public final synchronized ExecutorService f() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f7152d != null) goto L10;
        ThreadPoolExecutor r10 = k().e();     // Catch: Throwable -> L8
        this.f7152d = r10;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        ThreadPoolExecutor r11 = new ThreadPoolExecutor(k().c(), k().j(), k().d(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0093c("NetDownload"));     // Catch: Throwable -> L8
        this.f7152d = r11;     // Catch: Throwable -> L8
        r11.allowCoreThreadTimeOut(n4.b.b().l());     // Catch: Throwable -> L8
    L10:
        ThreadPoolExecutor r12 = this.f7152d;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r12;
    }

    public final synchronized ExecutorService g() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f7150b != null) goto L10;
        ThreadPoolExecutor r10 = k().g();     // Catch: Throwable -> L8
        this.f7150b = r10;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        this.f7150b = new ThreadPoolExecutor(0, Channel.UNLIMITED, k().f(), TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryC0093c("NetImmediate"));     // Catch: Throwable -> L8
    L10:
        ThreadPoolExecutor r11 = this.f7150b;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    }

    public final synchronized ExecutorService h() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f7153e != null) goto L10;
        ThreadPoolExecutor r10 = k().h();     // Catch: Throwable -> L8
        this.f7153e = r10;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        this.f7153e = new ThreadPoolExecutor(1, 1, k().f(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0093c("NetLocal"));     // Catch: Throwable -> L8
    L10:
        ThreadPoolExecutor r11 = this.f7153e;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if ((r10.obj instanceof Runnable) == false) goto L23;
        int r11 = r10.what;     // Catch: Throwable -> L12
        if (r11 != 0) goto L9;
        e().execute((Runnable) r10.obj);     // Catch: Throwable -> L12
    L18:
        return;
    L9:
        if (r11 != 1) goto L18;
        g().execute((Runnable) r10.obj);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public final b i(n4.a r10) {
        return new a(this, r10, r10);
    }

    public final n4.c k() {
        return n4.b.b();
    }
}
