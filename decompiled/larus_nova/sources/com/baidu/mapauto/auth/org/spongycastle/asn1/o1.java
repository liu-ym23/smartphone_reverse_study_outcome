package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class o1 extends t1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f31866e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f31867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31868d;

    static {
        f31866e = new byte[0];
    }

    public o1(int r100, InputStream r101) {
        super(r100, r101);
        if (r100 < 0) goto L9;
        this.f31867c = r100;
        this.f31868d = r100;
        if (r100 != 0) goto L10;
        b();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.t1
    public final int a() {
        return this.f31868d;
    }

    public final byte[] c() throws IOException {
        int r100 = this.f31868d;
        if (r100 == 0) goto L5;
        byte[] r101 = new byte[r100];
        InputStream r102 = this.f31889a;
        int r103 = 0;
    L7:
        if (r103 >= r100) goto L12;
        int r104 = r102.read(r101, 0 + r103, r100 - r103);
        if (r104 < 0) goto L12;
        r103 = r103 + r104;
    L12:
        int r105 = r100 - r103;
        this.f31868d = r105;
        if (r105 != 0) goto L16;
        b();
        return r101;
    L16:
        StringBuilder r106 = com.baidu.mapauto.auth.b.a("DEF length ");
        r106.append(this.f31867c);
        r106.append(" object truncated by ");
        r106.append(this.f31868d);
        throw new EOFException(r106.toString());
    L5:
        return f31866e;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f31868d != 0) goto L6;
        return -1;
    L6:
        int r100 = this.f31889a.read();
        if (r100 < 0) goto L12;
        int r101 = this.f31868d - 1;
        this.f31868d = r101;
        if (r101 != 0) goto L11;
        b();
    L11:
        return r100;
    L12:
        StringBuilder r102 = com.baidu.mapauto.auth.b.a("DEF length ");
        r102.append(this.f31867c);
        r102.append(" object truncated by ");
        r102.append(this.f31868d);
        throw new EOFException(r102.toString());
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.f31868d;
        if (r103 != 0) goto L6;
        return -1;
    L6:
        int r104 = Math.min(r102, r103);
        int r105 = this.f31889a.read(r100, r101, r104);
        if (r105 < 0) goto L12;
        int r106 = this.f31868d - r105;
        this.f31868d = r106;
        if (r106 != 0) goto L11;
        b();
    L11:
        return r105;
    L12:
        StringBuilder r107 = com.baidu.mapauto.auth.b.a("DEF length ");
        r107.append(this.f31867c);
        r107.append(" object truncated by ");
        r107.append(this.f31868d);
        throw new EOFException(r107.toString());
    }
}
