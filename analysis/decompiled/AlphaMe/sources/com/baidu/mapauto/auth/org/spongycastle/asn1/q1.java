package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class q1 extends t1 {

    /* renamed from: c, reason: collision with root package name */
    public int f7757c;

    /* renamed from: d, reason: collision with root package name */
    public int f7758d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7759e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7760f;

    public q1(int i4, InputStream inputStream) throws IOException {
        super(i4, inputStream);
        this.f7759e = false;
        this.f7760f = true;
        this.f7757c = inputStream.read();
        int i5 = inputStream.read();
        this.f7758d = i5;
        if (i5 < 0) {
            throw new EOFException();
        }
        c();
    }

    public final boolean c() {
        if (!this.f7759e && this.f7760f && this.f7757c == 0 && this.f7758d == 0) {
            this.f7759e = true;
            b();
        }
        return this.f7759e;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (c()) {
            return -1;
        }
        int i4 = this.f7769a.read();
        if (i4 < 0) {
            throw new EOFException();
        }
        int i5 = this.f7757c;
        this.f7757c = this.f7758d;
        this.f7758d = i4;
        return i5;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i4, int i5) throws IOException {
        if (this.f7760f || i5 < 3) {
            return super.read(bArr, i4, i5);
        }
        if (this.f7759e) {
            return -1;
        }
        int i6 = this.f7769a.read(bArr, i4 + 2, i5 - 2);
        if (i6 < 0) {
            throw new EOFException();
        }
        bArr[i4] = (byte) this.f7757c;
        bArr[i4 + 1] = (byte) this.f7758d;
        this.f7757c = this.f7769a.read();
        int i7 = this.f7769a.read();
        this.f7758d = i7;
        if (i7 >= 0) {
            return i6 + 2;
        }
        throw new EOFException();
    }
}
