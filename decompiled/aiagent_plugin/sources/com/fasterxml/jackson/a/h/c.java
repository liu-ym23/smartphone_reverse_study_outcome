package com.fasterxml.jackson.a.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: ByteArrayBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f12093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedList<byte[]> f12095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f12097e;
    private int f;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    static {
        f12093a = new byte[0];
    }

    public c() {
        this(null);
    }

    public c(a r2) {
        this(r2, 500);
    }

    public c(int r2) {
        this(null, r2);
    }

    public c(a r2, int r3) {
        this.f12095c = new LinkedList();
        this.f12094b = r2;
        if (r3 <= 131072) goto L5;
        r3 = 131072;
    L5:
        if (r2 != null) goto L7;
        byte[] r4 = new byte[r3];
    L8:
        this.f12097e = r4;
        return;
    L7:
        r4 = r2.a(2);
        goto L8
    }

    public void a() {
        this.f12096d = 0;
        this.f = 0;
        if (this.f12095c.isEmpty() == true) goto L6;
        this.f12095c.clear();
        return;
    }

    public void a(int r4) {
        if (this.f < this.f12097e.length) goto L5;
        c();
    L5:
        byte[] r0 = this.f12097e;
        int r1 = this.f;
        this.f = r1 + 1;
        r0[r1] = (byte) r4;
    }

    public void b(int r5) {
        int r0 = this.f;
        int r1 = r0 + 1;
        byte[] r2 = this.f12097e;
        if (r1 >= r2.length) goto L5;
        int r3 = r0 + 1;
        this.f = r3;
        r2[r0] = (byte) (r5 >> 8);
        this.f = r3 + 1;
        r2[r3] = (byte) r5;
        return;
    L5:
        a(r5 >> 8);
        a(r5);
    }

    public void c(int r5) {
        int r0 = this.f;
        int r1 = r0 + 2;
        byte[] r2 = this.f12097e;
        if (r1 >= r2.length) goto L5;
        int r3 = r0 + 1;
        this.f = r3;
        r2[r0] = (byte) (r5 >> 16);
        int r4 = r3 + 1;
        this.f = r4;
        r2[r3] = (byte) (r5 >> 8);
        this.f = r4 + 1;
        r2[r4] = (byte) r5;
        return;
    L5:
        a(r5 >> 16);
        a(r5 >> 8);
        a(r5);
    }

    public byte[] b() {
        int r0 = this.f12096d + this.f;
        if (r0 == 0) goto L5;
        byte[] r1 = new byte[r0];
        Iterator<byte[]> r2 = this.f12095c.iterator();
        int r4 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        byte[] r5 = (byte[]) ZeusTransformUtils.preCheckCast(r2.next(), byte[].class, "com.obric.aiagent.plugin");
        int r6 = r5.length;
        System.arraycopy(r5, 0, r1, r4, r6);
        r4 = r4 + r6;
        goto L8
    L10:
        System.arraycopy(this.f12097e, 0, r1, r4, this.f);
        int r7 = r4 + this.f;
        if (r7 != r0) goto L17;
        if (this.f12095c.isEmpty() == true) goto L15;
        a();
    L15:
        return r1;
    L17:
        throw new RuntimeException("Internal error: total len assumed to be " + r0 + ", copied " + r7 + " bytes");
    L5:
        return f12093a;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) {
        write(r3, 0, r3.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r4, int r5, int r6) {
    L2:
        int r0 = Math.min(this.f12097e.length - this.f, r6);
        if (r0 <= 0) goto L5;
        System.arraycopy(r4, r5, this.f12097e, this.f, r0);
        r5 = r5 + r0;
        this.f += r0;
        r6 = r6 - r0;
    L5:
        if (r6 <= 0) goto L6;
        c();
        goto L2
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        a(r1);
    }

    private void c() {
        int r0 = this.f12096d + this.f12097e.length;
        if (r0 < 0) goto L10;
        this.f12096d = r0;
        int r1 = Math.max(r0 >> 1, 1000);
        if (r1 <= 131072) goto L7;
        r1 = 131072;
    L7:
        this.f12095c.add(this.f12097e);
        this.f12097e = new byte[r1];
        this.f = 0;
        return;
    L10:
        throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
    }
}
