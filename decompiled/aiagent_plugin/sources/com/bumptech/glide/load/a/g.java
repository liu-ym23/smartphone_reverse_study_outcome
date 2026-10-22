package com.bumptech.glide.load.a;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: ExifOrientationStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f3376a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f3377b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f3378c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte f3379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3380e;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    static {
        byte[] r0 = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f3376a = r0;
        int r1 = r0.length;
        f3377b = r1;
        f3378c = r1 + 2;
    }

    public g(InputStream r2, int r3) {
        super(r2);
        if (r3 < (-1)) goto L9;
        if (r3 > 8) goto L9;
        this.f3379d = (byte) r3;
        return;
    L9:
        throw new IllegalArgumentException("Cannot add invalid orientation: " + r3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = this.f3380e;
        if (r0 < 2) goto L10;
        int r2 = f3378c;
        if (r0 > r2) goto L10;
        if (r0 != r2) goto L9;
        int r1 = this.f3379d;
    L12:
        if (r1 == (-1)) goto L14;
        this.f3380e++;
    L14:
        return r1;
    L9:
        r1 = f3376a[r0 - 2] & 255;
    L10:
        r1 = super.read();
        goto L12
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r4, int r5, int r6) {
        int r0 = this.f3380e;
        int r1 = f3378c;
        if (r0 <= r1) goto L5;
        int r7 = super.read(r4, r5, r6);
    L11:
        if (r7 <= 0) goto L13;
        this.f3380e += r7;
    L13:
        return r7;
    L5:
        if (r0 != r1) goto L8;
        r4[r5] = this.f3379d;
        r7 = 1;
        goto L11
    L8:
        if (r0 >= 2) goto L10;
        r7 = super.read(r4, r5, 2 - r0);
        goto L11
    L10:
        int r8 = Math.min(r1 - r0, r6);
        System.arraycopy(f3376a, this.f3380e - 2, r4, r5, r8);
        r7 = r8;
        goto L11
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r3) {
        long r4 = super.skip(r3);
        if (r4 <= 0) goto L5;
        this.f3380e = (int) (((long) this.f3380e) + r4);
    L5:
        return r4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }
}
