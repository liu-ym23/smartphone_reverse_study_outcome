package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: RequestFutureTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class f<R> implements c<R>, g<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f3923a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f3926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f3927e;
    private R f;
    private d g;
    private boolean h;
    private boolean i;
    private boolean j;
    private q k;

    /* JADX INFO: compiled from: RequestFutureTarget.java */
    static class a {
        a() {
        }

        void a(Object r1, long r2) {
            r1.wait(r2);
        }

        void a(Object r1) {
            r1.notifyAll();
        }
    }

    @Override // com.bumptech.glide.request.target.i
    public void a(Drawable r1) {
    }

    @Override // com.bumptech.glide.request.target.i
    public void b(com.bumptech.glide.request.target.h r2) {
        com.bumptech.glide.request.target.h r1 = (com.bumptech.glide.request.target.h) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.request.target.h.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.request.target.i
    public void c(Drawable r1) {
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    static {
        f3923a = new a();
    }

    public f(int r3, int r4) {
        this(r3, r4, true, f3923a);
    }

    f(int r1, int r2, boolean r3, a r4) {
        this.f3924b = r1;
        this.f3925c = r2;
        this.f3926d = r3;
        this.f3927e = r4;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r3) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (isDone() == true) goto L6;
        this.h = true;     // Catch: Throwable -> L15
        this.f3927e.a(this);     // Catch: Throwable -> L15
        d r1 = null;
        if (r3 == false) goto L11;
        d r4 = this.g;     // Catch: Throwable -> L15
        this.g = null;     // Catch: Throwable -> L15
        r1 = r4;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r1 == null) goto L14;
        r1.b();
    L14:
        return true;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L15
        return false;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r0 = this.h;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.h == false) goto L6;
    L11:
        boolean r0 = true;
    L12:
        monitor-exit(this);
        return r0;
    L6:
        if (this.i == true) goto L11;
        if (this.j == true) goto L11;
        r0 = false;
        goto L12
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return a(null);
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // java.util.concurrent.Future
    public R get(long r1, TimeUnit r3) {
        return a(Long.valueOf(r3.toMillis(r1)));
    }

    @Override // com.bumptech.glide.request.target.i
    public void a(com.bumptech.glide.request.target.h r3) {
        ((com.bumptech.glide.request.target.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.h.class, "com.obric.aiagent.plugin")).a(this.f3924b, this.f3925c);
    }

    @Override // com.bumptech.glide.request.target.i
    public synchronized void a(d r3) {
        monitor-enter(this);
        this.g = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.target.i
    public synchronized d a() {
        monitor-enter(this);
        d r0 = this.g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.target.i
    public synchronized void b(Drawable r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.bumptech.glide.request.target.i
    public synchronized void a(R r2, com.bumptech.glide.request.a.b<? super R> r3) {
        monitor-enter(this);
        com.bumptech.glide.request.a.b r4 = (com.bumptech.glide.request.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized R a(Long r5) {
        monitor-enter(this);
    L51:
        th = move-exception;
        throw th;
    L4:
        if (this.f3926d == false) goto L9;
        if (isDone() == true) goto L9;
        com.bumptech.glide.f.k.b();     // Catch: Throwable -> L51
    L9:
        if (this.h == true) goto L50;
        if (this.j == true) goto L48;
        if (this.i == false) goto L18;
        R r6 = this.f;     // Catch: Throwable -> L51
        monitor-exit(this);
        return r6;
    L18:
        if (r5 != null) goto L21;
        this.f3927e.a(this, 0);     // Catch: Throwable -> L51
    L29:
        if (Thread.interrupted() == true) goto L46;
        if (this.j == true) goto L44;
        if (this.h == true) goto L42;
        if (this.i == false) goto L40;
        R r7 = this.f;     // Catch: Throwable -> L51
        monitor-exit(this);
        return r7;
    L40:
        throw new TimeoutException();     // Catch: Throwable -> L51
    L42:
        throw new CancellationException();     // Catch: Throwable -> L51
    L44:
        throw new ExecutionException(this.k);     // Catch: Throwable -> L51
    L46:
        throw new InterruptedException();     // Catch: Throwable -> L51
    L21:
        if (r5.longValue() <= 0) goto L29;
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L51
        long r2 = r5.longValue() + r0;     // Catch: Throwable -> L51
    L24:
        if (isDone() == true) goto L29;
        if (r0 >= r2) goto L29;
        this.f3927e.a(this, r2 - r0);     // Catch: Throwable -> L51
        r0 = System.currentTimeMillis();     // Catch: Throwable -> L51
        goto L24
    L48:
        throw new ExecutionException(this.k);     // Catch: Throwable -> L51
    L50:
        throw new CancellationException();     // Catch: Throwable -> L51
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean a(q r1, Object r2, com.bumptech.glide.request.target.i<R> r3, boolean r4) {
        monitor-enter(this);
        com.bumptech.glide.request.target.i r5 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        this.j = true;     // Catch: Throwable -> L7
        this.k = r1;     // Catch: Throwable -> L7
        this.f3927e.a(this);     // Catch: Throwable -> L7
        monitor-exit(this);
        return false;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean a(R r1, Object r2, com.bumptech.glide.request.target.i<R> r3, com.bumptech.glide.load.a r4, boolean r5) {
        monitor-enter(this);
        com.bumptech.glide.request.target.i r6 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        this.i = true;     // Catch: Throwable -> L7
        this.f = r1;     // Catch: Throwable -> L7
        this.f3927e.a(this);     // Catch: Throwable -> L7
        monitor-exit(this);
        return false;
    L7:
        th = move-exception;
        throw th;
    }
}
