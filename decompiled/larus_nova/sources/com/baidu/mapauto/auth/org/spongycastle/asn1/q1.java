package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class q1 extends t1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f31877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f31879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f31880f;

    public q1(int r100, InputStream r101) throws IOException {
        super(r100, r101);
        this.f31879e = false;
        this.f31880f = true;
        this.f31877c = r101.read();
        int r102 = r101.read();
        this.f31878d = r102;
        if (r102 < 0) goto L7;
        c();
        return;
    L7:
        throw new EOFException();
    }

    public final boolean c() {
        if (this.f31879e == true) goto L12;
        if (this.f31880f == false) goto L12;
        if (this.f31877c != 0) goto L12;
        if (this.f31878d != 0) goto L12;
        this.f31879e = true;
        b();
    L12:
        return this.f31879e;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (c() == false) goto L6;
        return -1;
    L6:
        int r100 = this.f31889a.read();
        if (r100 < 0) goto L11;
        int r101 = this.f31877c;
        this.f31877c = this.f31878d;
        this.f31878d = r100;
        return r101;
    L11:
        throw new EOFException();
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        if (this.f31880f == true) goto L22;
        if (r102 < 3) goto L22;
        if (this.f31879e == false) goto L11;
        return -1;
    L11:
        int r103 = this.f31889a.read(r100, r101 + 2, r102 - 2);
        if (r103 < 0) goto L20;
        r100[r101] = (byte) this.f31877c;
        r100[r101 + 1] = (byte) this.f31878d;
        this.f31877c = this.f31889a.read();
        int r104 = this.f31889a.read();
        this.f31878d = r104;
        if (r104 < 0) goto L18;
        return r103 + 2;
    L18:
        throw new EOFException();
    L20:
        throw new EOFException();
    L22:
        return super.read(r100, r101, r102);
    }
}
