package com.bumptech.glide.load.resource.bitmap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class w extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile byte[] f3839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3843e;
    private final com.bumptech.glide.load.engine.a.b f;

    /* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
    static class a extends IOException {
        a(String r1) {
            super(r1);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public w(InputStream r3, com.bumptech.glide.load.engine.a.b r4) {
        this(r3, (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin"), 65536);
    }

    w(InputStream r4, com.bumptech.glide.load.engine.a.b r5, int r6) {
        com.bumptech.glide.load.engine.a.b r7 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        super(r4);
        this.f3842d = -1;
        this.f = r7;
        this.f3839a = (byte[]) ZeusTransformUtils.preCheckCast(r7.a(r6, byte[].class), byte[].class, "com.obric.aiagent.plugin");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        monitor-enter(this);
        InputStream r0 = this.in;     // Catch: Throwable -> L12
        if (this.f3839a == null) goto L11;
        if (r0 == null) goto L11;
        int r1 = (this.f3840b - this.f3843e) + r0.available();
        monitor-exit(this);
        return r1;
    L11:
        throw c();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private static IOException c() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        monitor-enter(this);
        this.f3841c = this.f3839a.length;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f3839a == null) goto L6;
        this.f.a(this.f3839a);     // Catch: Throwable -> L8
        this.f3839a = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f3839a == null) goto L5;
        this.f.a(this.f3839a);
        this.f3839a = null;
    L5:
        InputStream r0 = this.in;
        this.in = null;
        if (r0 == null) goto L9;
        r0.close();
        return;
    }

    private int a(InputStream r7, byte[] r8) {
        int r1 = this.f3842d;
        if (r1 == (-1)) goto L25;
        int r4 = this.f3843e - r1;
        int r5 = this.f3841c;
        if (r4 >= r5) goto L25;
        if (r1 == 0) goto L9;
    L17:
        if (r1 <= 0) goto L19;
        System.arraycopy(r8, r1, r8, 0, r8.length - r1);
    L19:
        int r0 = this.f3843e - this.f3842d;
        this.f3843e = r0;
        this.f3842d = 0;
        this.f3840b = 0;
        int r9 = r7.read(r8, r0, r8.length - r0);
        int r10 = this.f3843e;
        if (r9 <= 0) goto L23;
        r10 = r10 + r9;
    L23:
        this.f3840b = r10;
        return r9;
    L9:
        if (r5 <= r8.length) goto L17;
        if (this.f3840b != r8.length) goto L17;
        int r2 = r8.length * 2;
        if (r2 > r5) goto L16;
        r5 = r2;
    L16:
        byte[] r3 = (byte[]) ZeusTransformUtils.preCheckCast(this.f.a(r5, byte[].class), byte[].class, "com.obric.aiagent.plugin");
        System.arraycopy(r8, 0, r3, 0, r8.length);
        this.f3839a = r3;
        this.f.a(r8);
        r8 = r3;
    L25:
        int r11 = r7.read(r8);
        if (r11 <= 0) goto L28;
        this.f3842d = -1;
        this.f3843e = 0;
        this.f3840b = r11;
    L28:
        return r11;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        this.f3841c = Math.max(this.f3841c, r2);     // Catch: Throwable -> L6
        this.f3842d = this.f3843e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        monitor-enter(this);
        byte[] r0 = this.f3839a;     // Catch: Throwable -> L29
        InputStream r1 = this.in;     // Catch: Throwable -> L29
        if (r0 == null) goto L28;
        if (r1 == null) goto L28;
        if (this.f3843e < this.f3840b) goto L13;
        if (a(r1, r0) != (-1)) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        if (r0 == this.f3839a) goto L19;
        r0 = this.f3839a;     // Catch: Throwable -> L29
        if (r0 != null) goto L19;
        throw c();     // Catch: Throwable -> L29
    L19:
        int r2 = this.f3840b;     // Catch: Throwable -> L29
        int r3 = this.f3843e;     // Catch: Throwable -> L29
        if ((r2 - r3) <= 0) goto L25;
        this.f3843e = r3 + 1;     // Catch: Throwable -> L29
        int r4 = r0[r3] & 255;
        monitor-exit(this);
        return r4;
    L25:
        monitor-exit(this);
        return -1;
    L28:
        throw c();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r7, int r8, int r9) {
        monitor-enter(this);
        byte[] r0 = this.f3839a;     // Catch: Throwable -> L70
        if (r0 == null) goto L69;
        if (r9 == 0) goto L7;
        InputStream r1 = this.in;     // Catch: Throwable -> L70
        if (r1 == null) goto L67;
        int r2 = this.f3843e;     // Catch: Throwable -> L70
        int r3 = this.f3840b;     // Catch: Throwable -> L70
        if (r2 < r3) goto L14;
        int r4 = r9;
    L26:
        int r5 = -1;
        if (this.f3842d != (-1)) goto L38;
        if (r4 < r0.length) goto L38;
        int r6 = r1.read(r7, r8, r4);     // Catch: Throwable -> L70
        if (r6 == (-1)) goto L32;
    L56:
        r4 = r4 - r6;
        if (r4 == 0) goto L58;
        if (r1.available() == 0) goto L62;
        r8 = r8 + r6;
        goto L26
    L62:
        int r10 = r9 - r4;
        monitor-exit(this);
        return r10;
    L58:
        monitor-exit(this);
        return r9;
    L32:
        if (r4 == r9) goto L35;
        r5 = r9 - r4;
    L35:
        monitor-exit(this);
        return r5;
    L38:
        if (a(r1, r0) == (-1)) goto L39;
        if (r0 == this.f3839a) goto L51;
        r0 = this.f3839a;     // Catch: Throwable -> L70
        if (r0 != null) goto L51;
        throw c();     // Catch: Throwable -> L70
    L51:
        int r11 = this.f3840b;     // Catch: Throwable -> L70
        int r12 = this.f3843e;     // Catch: Throwable -> L70
        if ((r11 - r12) < r4) goto L54;
        r6 = r4;
    L55:
        System.arraycopy(r0, r12, r7, r8, r6);     // Catch: Throwable -> L70
        this.f3843e += r6;     // Catch: Throwable -> L70
        goto L56
    L54:
        r6 = r11 - r12;     // Catch: Throwable -> L70
        goto L55
    L39:
        if (r4 == r9) goto L42;
        r5 = r9 - r4;
    L42:
        monitor-exit(this);
        return r5;
    L14:
        if ((r3 - r2) < r9) goto L16;
        int r13 = r9;
    L17:
        System.arraycopy(r0, r2, r7, r8, r13);     // Catch: Throwable -> L70
        this.f3843e += r13;     // Catch: Throwable -> L70
        if (r13 != r9) goto L20;
    L23:
        monitor-exit(this);
        return r13;
    L20:
        if (r1.available() == 0) goto L23;
        r8 = r8 + r13;
        r4 = r9 - r13;
        goto L26
    L16:
        r13 = r3 - r2;     // Catch: Throwable -> L70
        goto L17
    L67:
        throw c();     // Catch: Throwable -> L70
    L7:
        monitor-exit(this);
        return 0;
    L69:
        throw c();     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f3839a == null) goto L13;
        int r1 = this.f3842d;     // Catch: Throwable -> L14
        if ((-1) == r1) goto L11;
        this.f3843e = r1;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        throw new a("Mark has been invalidated, pos: " + this.f3843e + " markLimit: " + this.f3841c);     // Catch: Throwable -> L14
    L13:
        throw new IOException("Stream is closed");     // Catch: Throwable -> L14
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long r9) {
        monitor-enter(this);
        if (r9 < 1) goto L6;
        byte[] r0 = this.f3839a;     // Catch: Throwable -> L44
        if (r0 == null) goto L43;
        InputStream r1 = this.in;     // Catch: Throwable -> L44
        if (r1 == null) goto L41;
        int r2 = this.f3840b;     // Catch: Throwable -> L44
        int r3 = this.f3843e;     // Catch: Throwable -> L44
        if ((r2 - r3) < r9) goto L17;
        this.f3843e = (int) (((long) r3) + r9);     // Catch: Throwable -> L44
        monitor-exit(this);
        return r9;
    L17:
        long r4 = ((long) r2) - ((long) r3);
        this.f3843e = r2;     // Catch: Throwable -> L44
        if (this.f3842d == (-1)) goto L37;
        if (r9 > this.f3841c) goto L37;
        if (a(r1, r0) != (-1)) goto L26;
        monitor-exit(this);
        return r4;
    L26:
        int r5 = this.f3840b;     // Catch: Throwable -> L44
        int r6 = this.f3843e;     // Catch: Throwable -> L44
        if ((r5 - r6) < (r9 - r4)) goto L31;
        this.f3843e = (int) ((((long) r6) + r9) - r4);     // Catch: Throwable -> L44
        monitor-exit(this);
        return r9;
    L31:
        long r7 = (r4 + ((long) r5)) - ((long) r6);
        this.f3843e = r5;     // Catch: Throwable -> L44
        monitor-exit(this);
        return r7;
    L37:
        long r8 = r4 + r1.skip(r9 - r4);
        monitor-exit(this);
        return r8;
    L41:
        throw c();     // Catch: Throwable -> L44
    L43:
        throw c();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    L6:
        monitor-exit(this);
        return 0;
    }
}
