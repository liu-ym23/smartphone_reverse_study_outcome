package com.ttnet.org.chromium.net.urlconnection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: MessageLoop.java */
/* JADX INFO: loaded from: classes4.dex */
public class g implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f38292a = true;
    private static final AtomicBoolean h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<Runnable> f38293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InterruptedIOException f38296e;
    private RuntimeException f;
    private long g;

    static {
        h = new AtomicBoolean(false);
    }

    public g() {
        this.g = -1;
        this.f38293b = new LinkedBlockingQueue();
    }

    private boolean e() {
        if (h.get() == false) goto L5;
        return true;
    L5:
        long r2 = this.g;
        if (r2 != (-1)) goto L10;
        this.g = Thread.currentThread().getId();
        return true;
    L10:
        if (r2 == Thread.currentThread().getId()) goto L14;
        return false;
    L14:
        return true;
    }

    public boolean a() {
        long r0 = this.g;
        if (r0 != (-1)) goto L5;
    L8:
        return true;
    L5:
        if (r0 == Thread.currentThread().getId()) goto L8;
        return false;
    }

    private Runnable a(boolean r2, long r3) {
        if (r2 == true) goto L5;
        Runnable r1 = (Runnable) ZeusTransformUtils.preCheckCast(this.f38293b.take(), Runnable.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L10
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new SocketTimeoutException("ttnet");
    L5:
        r1 = (Runnable) ZeusTransformUtils.preCheckCast(this.f38293b.poll(r3, TimeUnit.NANOSECONDS), Runnable.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        InterruptedIOException r4 = new InterruptedIOException();
        r4.initCause(e);
        throw r4;
    }

    public void a(int r9) {
        if (f38292a == false) goto L5;
    L9:
        long r0 = System.nanoTime();
        long r2 = TimeUnit.NANOSECONDS.convert(r9, TimeUnit.MILLISECONDS);
        if (this.f38295d == false) goto L17;
        InterruptedIOException r10 = this.f38296e;
        if (r10 == null) goto L15;
        throw r10;
    L15:
        throw this.f;
    L17:
        if (this.f38294c == true) goto L38;
        this.f38294c = true;
    L20:
        if (this.f38294c == false) goto L36;
        if (r9 == 0) goto L39;
        a(true, (r2 - System.nanoTime()) + r0).run();     // Catch: RuntimeException -> L27 InterruptedIOException -> L30 SocketTimeoutException -> L33
        goto L20
    L39:
        a(false, 0).run();     // Catch: RuntimeException -> L27 InterruptedIOException -> L30 SocketTimeoutException -> L33
    L30:
        e = move-exception;
        this.f38294c = false;
        this.f38295d = true;
        this.f38296e = e;
        throw e;
    L27:
        e = move-exception;
        this.f38294c = false;
        this.f38295d = true;
        this.f = e;
        throw e;
    L33:
        e = move-exception;
        this.f38294c = false;
        this.f38295d = true;
        throw e;
    L36:
        return;
    L38:
        throw new IllegalStateException("Cannot run loop when it is already running.");
    L5:
        if (e() == true) goto L9;
        throw new AssertionError();
    }

    public void b() {
        if (f38292a == false) goto L5;
    L9:
        this.f38295d = false;
        return;
    L5:
        if (e() == true) goto L9;
        throw new AssertionError();
    }

    public static void a(boolean r1) {
        h.set(r1);
    }

    public void c() {
        if (f38292a == false) goto L5;
    L9:
        this.f38294c = false;
        return;
    L5:
        if (e() == true) goto L9;
        throw new AssertionError();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        this.f38293b.put(r4);     // Catch: InterruptedException -> L6
        return;
    L6:
        e = move-exception;
        throw new RejectedExecutionException(e);
    L10:
        throw new IllegalArgumentException();
    }

    public boolean d() {
        return this.f38294c;
    }
}
