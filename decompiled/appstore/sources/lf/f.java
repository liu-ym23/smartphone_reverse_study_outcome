package lf;

import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class f implements Executor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f21987g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockingQueue f21988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterruptedIOException f21991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RuntimeException f21992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f21993f;

    static {
        f21987g = new AtomicBoolean(false);
    }

    public f() {
        this.f21993f = -1;
        this.f21988a = new LinkedBlockingQueue();
    }

    public void a() {
        b(0);
    }

    public void b(int r10) {
        long r11 = System.nanoTime();
        long r12 = TimeUnit.NANOSECONDS.convert(r10, TimeUnit.MILLISECONDS);
        if (this.f21990c == false) goto L10;
        InterruptedIOException r13 = this.f21991d;
        if (r13 == null) goto L8;
        throw r13;
    L8:
        throw this.f21992e;
    L10:
        if (this.f21989b == true) goto L34;
        this.f21989b = true;
    L13:
        if (this.f21989b == false) goto L32;
        if (r10 == 0) goto L35;
        e(true, (r12 - System.nanoTime()) + r11).run();     // Catch: RuntimeException -> L18 InterruptedIOException -> L20 SocketTimeoutException -> L22
        goto L13
    L35:
        e(false, 0).run();     // Catch: RuntimeException -> L18 InterruptedIOException -> L20 SocketTimeoutException -> L22
    L20:
        e = move-exception;
        this.f21989b = false;
        this.f21990c = true;
        this.f21991d = e;
        throw e;
    L18:
        e = move-exception;
        this.f21989b = false;
        this.f21990c = true;
        this.f21992e = e;
        throw e;
    L22:
        e = move-exception;
        this.f21989b = false;
        this.f21990c = true;
        throw e;
    L32:
        return;
    L34:
        throw new IllegalStateException("Cannot run loop when it is already running.");
    }

    public void c() {
        this.f21989b = false;
    }

    public void d() {
        this.f21990c = false;
    }

    public final Runnable e(boolean r10, long r11) {
        if (r10 == true) goto L6;
        Runnable r12 = (Runnable) this.f21988a.take();     // Catch: InterruptedException -> L4
    L7:
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new SocketTimeoutException("ttnet");
    L6:
        r12 = (Runnable) this.f21988a.poll(r11, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L4
    L4:
        e = move-exception;
        InterruptedIOException r13 = new InterruptedIOException();
        r13.initCause(e);
        throw r13;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        if (r10 == null) goto L9;
        this.f21988a.put(r10);     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        throw new RejectedExecutionException(e);
    L9:
        throw new IllegalArgumentException();
    }
}
