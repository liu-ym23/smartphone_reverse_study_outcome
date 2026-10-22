package com.bytedance.vmsdk.a.a;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: LeakyBufferedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends BufferedInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11696b;

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public b(InputStream r1, int r2) {
        super(r1, r2);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        c();     // Catch: Throwable -> L6
        this.f11696b = true;     // Catch: Throwable -> L6
        super.mark(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        c();     // Catch: Throwable -> L6
        this.f11696b = false;     // Catch: Throwable -> L6
        super.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized InputStream a() {
        monitor-enter(this);
        c();     // Catch: Throwable -> L6
        d();     // Catch: Throwable -> L6
        this.f11695a = true;     // Catch: Throwable -> L6
        a r1 = new a(new InputStream[]{new ByteArrayInputStream(b()), this.in});     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    private byte[] b() {
        int r0 = this.count - this.pos;
        byte[] r1 = new byte[r0];
        System.arraycopy(this.buf, this.pos, r1, 0, r0);
        this.pos = 0;
        this.count = 0;
        return r1;
    }

    private void c() {
        if (this.f11695a == true) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    private void d() {
        if (this.f11696b == true) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }
}
