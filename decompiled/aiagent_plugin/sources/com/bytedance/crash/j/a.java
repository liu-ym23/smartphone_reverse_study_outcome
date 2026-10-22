package com.bytedance.crash.j;

/* JADX INFO: compiled from: BufferWriter.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f7520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7521b;

    public a() {
        this(512);
    }

    public a(int r2) {
        this.f7520a = null;
        this.f7521b = 0;
        if (r2 <= 0) goto L6;
        this.f7520a = new byte[r2];
        return;
    }

    public byte[] a() {
        return this.f7520a;
    }

    public int b() {
        return this.f7520a.length - this.f7521b;
    }

    public int c() {
        return this.f7521b;
    }

    public void a(byte[] r3) {
        a(r3, 0, r3.length);
    }

    public void a(byte[] r3, int r4, int r5) {
        e(r5);
        System.arraycopy(r3, r4, this.f7520a, this.f7521b, r5);
        this.f7521b += r5;
    }

    public void a(int r2, int r3) {
        int r0 = this.f7521b;
        this.f7521b = r2;
        b(r3);
        this.f7521b = r0;
    }

    public void a(long r6) {
        e(10);
    L3:
        byte r0 = (byte) (127 & r6);
        r6 = r6 >>> 7;
        if (r6 == 0) goto L6;
        r0 = (byte) (r0 | 128);
    L6:
        byte[] r2 = this.f7520a;
        int r3 = this.f7521b;
        this.f7521b = r3 + 1;
        r2[r3] = r0;
        if (r6 != 0) goto L3;
    }

    public void a(String r1) {
        b(r1.getBytes());
    }

    public void b(byte[] r3) {
        a(r3.length);
        a(r3);
        a(0);
    }

    public void a(int r4) {
        e(1);
        byte[] r0 = this.f7520a;
        int r1 = this.f7521b;
        this.f7521b = r1 + 1;
        r0[r1] = (byte) (r4 & 255);
    }

    public void b(int r5) {
        d(4);
        e(4);
        byte[] r0 = this.f7520a;
        int r1 = this.f7521b;
        int r2 = r1 + 1;
        this.f7521b = r2;
        r0[r1] = (byte) (r5 & 255);
        int r3 = r2 + 1;
        this.f7521b = r3;
        r0[r2] = (byte) ((r5 >>> 8) & 255);
        int r4 = r3 + 1;
        this.f7521b = r4;
        r0[r3] = (byte) ((r5 >>> 16) & 255);
        this.f7521b = r4 + 1;
        r0[r4] = (byte) ((r5 >>> 24) & 255);
    }

    public void b(long r5) {
        d(8);
        b((int) (r5 & 4294967295L));
        b((int) ((r5 >>> 32) & 4294967295L));
    }

    public int c(int r2) {
        d(4);
        int r0 = c();
        b(r2);
        return r0;
    }

    public void d(int r6) {
        int r0 = this.f7521b;
        int r1 = ((((r0 + r6) - 1) / r6) * r6) - r0;
        e(r1);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        byte[] r3 = this.f7520a;
        int r4 = this.f7521b;
        this.f7521b = r4 + 1;
        r3[r4] = 0;
        r2 = r2 + 1;
        goto L3
    }

    private void e(int r4) {
        if (b() >= r4) goto L6;
        int r0 = this.f7520a.length;
        byte[] r5 = new byte[r0 + Math.max(r0, r4)];
        System.arraycopy(this.f7520a, 0, r5, 0, this.f7521b);
        this.f7520a = r5;
        return;
    }
}
