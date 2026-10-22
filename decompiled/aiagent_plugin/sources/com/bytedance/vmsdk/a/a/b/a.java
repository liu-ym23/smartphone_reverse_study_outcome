package com.bytedance.vmsdk.a.a.b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: Frame.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte f11701e;
    public boolean f;
    public long g;
    public byte[] h;
    public byte[] i;

    private static byte[] a(long r10) {
        if (r10 > 125) goto L7;
        return new byte[]{(byte) r10};
    L7:
        if (r10 > 65535) goto L11;
        return new byte[]{126, (byte) ((r10 >> 8) & 255), (byte) (r10 & 255)};
    L11:
        return new byte[]{127, (byte) ((r10 >> 56) & 255), (byte) ((r10 >> 48) & 255), (byte) ((r10 >> 40) & 255), (byte) ((r10 >> 32) & 255), (byte) ((r10 >> 24) & 255), (byte) ((r10 >> 16) & 255), (byte) ((r10 >> 8) & 255), (byte) (r10 & 255)};
    }

    a() {
    }

    public void a(BufferedInputStream r6) {
        a(b(r6));
        byte r0 = b(r6);
        if ((r0 & 128) == 0) goto L5;
        boolean r1 = true;
    L6:
        this.f = r1;
        this.g = a((byte) (r0 & (-129)), r6);
        if (this.f == false) goto L9;
        byte[] r2 = a(r6);
    L10:
        this.h = r2;
        long r3 = this.g;
        byte[] r4 = new byte[(int) r3];
        this.i = r4;
        a(r6, r4, 0, (int) r3);
        c.a(this.h, this.i, 0, (int) this.g);
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public void a(BufferedOutputStream r6) {
        r6.write(a());
        byte[] r0 = a(this.g);
        if (this.f == false) goto L5;
        r0[0] = (byte) (r0[0] | 128);
    L5:
        r6.write(r0, 0, r0.length);
        if (this.f == true) goto L10;
        r6.write(this.i, 0, (int) this.g);
        return;
    L10:
        throw new UnsupportedOperationException("Writing masked data not implemented");
    }

    private void a(byte r4) {
        boolean r1 = true;
        if ((r4 & 128) == 0) goto L5;
        boolean r0 = true;
    L6:
        this.f11697a = r0;
        if ((r4 & 64) == 0) goto L9;
        boolean r2 = true;
    L10:
        this.f11698b = r2;
        if ((r4 & 32) == 0) goto L13;
        boolean r3 = true;
    L14:
        this.f11699c = r3;
        if ((r4 & 16) != 0) goto L18;
        r1 = false;
    L18:
        this.f11700d = r1;
        this.f11701e = (byte) (r4 & 15);
        return;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private byte a() {
        if (this.f11697a == false) goto L5;
        byte r0 = (byte) 128;
    L7:
        if (this.f11698b == false) goto L10;
        r0 = (byte) (r0 | 64);
    L10:
        if (this.f11699c == false) goto L13;
        r0 = (byte) (r0 | 32);
    L13:
        if (this.f11700d == false) goto L16;
        r0 = (byte) (r0 | 16);
    L16:
        return (byte) ((this.f11701e & 15) | r0);
    L5:
        r0 = 0;
        goto L7
    }

    private long a(byte r5, InputStream r6) {
        if (r5 > 125) goto L7;
        return r5;
    L7:
        if (r5 != 126) goto L11;
        return ((b(r6) & 255) << 8) | (b(r6) & 255);
    L11:
        if (r5 != 127) goto L17;
        long r4 = 0;
        int r1 = 0;
    L13:
        if (r1 >= 8) goto L15;
        r4 = (r4 << 8) | ((long) (b(r6) & 255));
        r1 = r1 + 1;
        goto L13
    L15:
        return r4;
    L17:
        throw new IOException("Unexpected length byte: " + r5);
    }

    private static byte[] a(InputStream r3) {
        byte[] r1 = new byte[4];
        a(r3, r1, 0, 4);
        return r1;
    }

    private static void a(InputStream r2, byte[] r3, int r4, int r5) {
    L2:
        if (r5 <= 0) goto L8;
        int r0 = r2.read(r3, r4, r5);
        if (r0 == (-1)) goto L7;
        r5 = r5 - r0;
        r4 = r4 + r0;
        goto L2
    L7:
        throw new EOFException();
    }

    private static byte b(InputStream r1) {
        int r2 = r1.read();
        if (r2 == (-1)) goto L7;
        return (byte) r2;
    L7:
        throw new EOFException();
    }
}
