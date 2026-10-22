package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AsyncTask.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<Result> {
    private static final String TAG = "AsyncTask";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f37740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f37741b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f37742c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Callable<Result> f37743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a<Result>.C1026a f37744e;
    private volatile int f;
    private final AtomicBoolean g;
    private final AtomicBoolean h;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.task.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTask.java */
    class C1026a extends FutureTask<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f37746a;

        C1026a(a r3, Callable<Result> r4) {
            Callable r5 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.aiagent.plugin");
            this.f37746a = r3;
            super(r5);
        }

        Class a() {
            return this.f37746a.getClass();
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            TraceEvent r0 = TraceEvent.a("AsyncTask.run: " + a.c(this.f37746a).a().getName());
            super.run();     // Catch: Throwable -> L7
            if (r0 == null) goto L18;
            r0.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (r0 != null) goto L14;
        L13:
            throw th;
        L14:
            r0.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            a.b(this.f37746a, get());     // Catch: CancellationException -> L4 ExecutionException -> L5 InterruptedException -> L8
        L14:
            return;
        L8:
            e = move-exception;
            com.ttnet.org.chromium.base.j.d(a.TAG, e.toString(), new Object[0]);
            return;
        L4:
            a.b(this.f37746a, null);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException("An error occurred while executing doInBackground()", e.getCause());
        }
    }

    /* JADX INFO: compiled from: AsyncTask.java */
    private static class b implements RejectedExecutionHandler {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r1, ThreadPoolExecutor r2) {
            Runnable r0 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r1, Runnable.class, "com.obric.aiagent.plugin");
            a.f37740a.execute(r0);
        }
    }

    public static /* synthetic */ void lambda$SEFUSxDnBXbCDOXzrCtpiBtEqeQ(a r0, Object r1) {
        r0.f(r1);
    }

    public static /* synthetic */ void lambda$inDRTxmsc8Dtrd5cNgUwGGcVutg(Runnable r0) {
        a(r0);
    }

    public abstract Result a();

    public abstract void a(Result r1);

    public void b() {
    }

    static /* synthetic */ AtomicBoolean a(a r0) {
        return r0.h;
    }

    static /* synthetic */ void a(a r0, Object r1) {
        r0.d(r1);
    }

    static /* synthetic */ AtomicBoolean b(a r0) {
        return r0.g;
    }

    static /* synthetic */ void b(a r0, Object r1) {
        r0.c(r1);
    }

    static /* synthetic */ C1026a c(a r0) {
        return r0.f37744e;
    }

    static {
        f37740a = $$Lambda$a$inDRTxmsc8Dtrd5cNgUwGGcVutg.INSTANCE;
        f37741b = new h();
        f37742c = new b(null);
    }

    private static /* synthetic */ void a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        PostTask.a(n.f37771b, r3);
    }

    public a() {
        this.f = 0;
        this.g = new AtomicBoolean();
        this.h = new AtomicBoolean();
        Callable<Result> r0 = new AnonymousClass1(this);
        this.f37743d = r0;
        this.f37744e = new C1026a(this, r0);
    }

    private void c(Result r2) {
        if (this.h.get() == true) goto L6;
        d(r2);
        return;
    }

    private void d(final Result r2) {
        if (ZeusTransformUtils.instanceOf(this, com.ttnet.org.chromium.base.task.b.class) == false) goto L5;
        this.f = 2;
        return;
    L5:
        ThreadUtils.b(new $$Lambda$a$SEFUSxDnBXbCDOXzrCtpiBtEqeQ(this, r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void f(Object r1) {
        e(r1);
    }

    public void b(Result r1) {
        b();
    }

    public final boolean c() {
        return this.g.get();
    }

    private void e(Result r2) {
        if (c() == false) goto L5;
        b(r2);
    L6:
        this.f = 2;
        return;
    L5:
        a(r2);
        goto L6
    }
}
