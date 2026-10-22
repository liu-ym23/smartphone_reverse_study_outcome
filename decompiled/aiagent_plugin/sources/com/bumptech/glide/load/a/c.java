package com.bumptech.glide.load.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;

/* JADX INFO: compiled from: BufferedOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f3369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f3370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a.b f3371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3372d;

    public c(OutputStream r3, com.bumptech.glide.load.engine.a.b r4) {
        this(r3, (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin"), 65536);
    }

    c(OutputStream r4, com.bumptech.glide.load.engine.a.b r5, int r6) {
        com.bumptech.glide.load.engine.a.b r7 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        this.f3369a = r4;
        this.f3371c = r7;
        this.f3370b = (byte[]) ZeusTransformUtils.preCheckCast(r7.a(r6, byte[].class), byte[].class, "com.obric.aiagent.plugin");
    }

    @Override // java.io.OutputStream
    public void write(int r4) {
        byte[] r0 = this.f3370b;
        int r1 = this.f3372d;
        this.f3372d = r1 + 1;
        r0[r1] = (byte) r4;
        b();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) {
        write(r3, 0, r3.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r6, int r7, int r8) {
        int r0 = 0;
    L3:
        int r1 = r8 - r0;
        int r2 = r7 + r0;
        int r3 = this.f3372d;
        if (r3 == 0) goto L6;
    L9:
        int r4 = Math.min(r1, this.f3370b.length - r3);
        System.arraycopy(r6, r2, this.f3370b, this.f3372d, r4);
        this.f3372d += r4;
        r0 = r0 + r4;
        b();
        if (r0 < r8) goto L3;
        return;
    L6:
        if (r1 < this.f3370b.length) goto L9;
        this.f3369a.write(r6, r2, r1);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f3369a.flush();
    }

    private void a() {
        int r0 = this.f3372d;
        if (r0 <= 0) goto L6;
        this.f3369a.write(this.f3370b, 0, r0);
        this.f3372d = 0;
        return;
    }

    private void b() {
        if (this.f3372d != this.f3370b.length) goto L6;
        a();
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flush();     // Catch: Throwable -> L5
        this.f3369a.close();
        c();
        return;
    L5:
        th = move-exception;
        this.f3369a.close();
        throw th;
    }

    private void c() {
        byte[] r0 = this.f3370b;
        if (r0 == null) goto L6;
        this.f3371c.a(r0);
        this.f3370b = null;
        return;
    }
}
