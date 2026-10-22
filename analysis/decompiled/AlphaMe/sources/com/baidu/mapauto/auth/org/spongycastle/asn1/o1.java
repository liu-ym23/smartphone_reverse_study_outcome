package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class o1 extends t1 {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f7746e = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public final int f7747c;

    /* renamed from: d, reason: collision with root package name */
    public int f7748d;

    public o1(int i4, InputStream inputStream) {
        super(i4, inputStream);
        if (i4 < 0) {
            throw new IllegalArgumentException("negative lengths not allowed");
        }
        this.f7747c = i4;
        this.f7748d = i4;
        if (i4 == 0) {
            b();
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.t1
    public final int a() {
        return this.f7748d;
    }

    public final byte[] c() throws IOException {
        int i4 = this.f7748d;
        if (i4 == 0) {
            return f7746e;
        }
        byte[] bArr = new byte[i4];
        InputStream inputStream = this.f7769a;
        int i5 = 0;
        while (i5 < i4) {
            int i6 = inputStream.read(bArr, i5, i4 - i5);
            if (i6 < 0) {
                break;
            }
            i5 += i6;
        }
        int i7 = i4 - i5;
        this.f7748d = i7;
        if (i7 == 0) {
            b();
            return bArr;
        }
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("DEF length ");
        sbA.append(this.f7747c);
        sbA.append(" object truncated by ");
        sbA.append(this.f7748d);
        throw new EOFException(sbA.toString());
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f7748d == 0) {
            return -1;
        }
        int i4 = this.f7769a.read();
        if (i4 >= 0) {
            int i5 = this.f7748d - 1;
            this.f7748d = i5;
            if (i5 == 0) {
                b();
            }
            return i4;
        }
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("DEF length ");
        sbA.append(this.f7747c);
        sbA.append(" object truncated by ");
        sbA.append(this.f7748d);
        throw new EOFException(sbA.toString());
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = this.f7748d;
        if (i6 == 0) {
            return -1;
        }
        int i7 = this.f7769a.read(bArr, i4, Math.min(i5, i6));
        if (i7 >= 0) {
            int i8 = this.f7748d - i7;
            this.f7748d = i8;
            if (i8 == 0) {
                b();
            }
            return i7;
        }
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("DEF length ");
        sbA.append(this.f7747c);
        sbA.append(" object truncated by ");
        sbA.append(this.f7748d);
        throw new EOFException(sbA.toString());
    }
}
