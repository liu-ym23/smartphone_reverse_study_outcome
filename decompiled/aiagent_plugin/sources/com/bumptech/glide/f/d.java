package com.bumptech.glide.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: ExceptionCatchingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Queue<d> f3322a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputStream f3323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IOException f3324c;

    static {
        f3322a = k.a(0);
    }

    public static d a(InputStream r4) {
        Queue<d> r0 = f3322a;
        monitor-enter(r0);
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.poll(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new d();
    L8:
        r1.b(r4);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    d() {
    }

    void b(InputStream r1) {
        this.f3323b = r1;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f3323b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3323b.close();
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
        this.f3323b.mark(r1);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f3323b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] r2) {
        return this.f3323b.read(r2);
    L4:
        e = move-exception;
        this.f3324c = e;
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        return this.f3323b.read(r2, r3, r4);
    L4:
        e = move-exception;
        this.f3324c = e;
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        this.f3323b.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r2) {
        return this.f3323b.skip(r2);
    L4:
        e = move-exception;
        this.f3324c = e;
        return 0;
    }

    @Override // java.io.InputStream
    public int read() {
        return this.f3323b.read();
    L4:
        e = move-exception;
        this.f3324c = e;
        return -1;
    }

    public IOException a() {
        return this.f3324c;
    }

    public void b() {
        this.f3324c = null;
        this.f3323b = null;
        Queue<d> r0 = f3322a;
        monitor-enter(r0);
        r0.offer(this);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
