package com.autonavi.aps.protocol.aps.common.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private ByteArrayOutputStream f18501a = new ByteArrayOutputStream();

    static {
        Charset.forName("UTF-8");
    }

    public static int c(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public void a(int i10) throws IOException {
        if (i10 >= 0) {
            b(i10);
        } else {
            a(i10);
        }
    }

    public final void b(int i10, int i11) throws IOException {
        b((i10 << 3) | i11);
    }

    public final void d(int i10, int i11) throws IOException {
        b(i10, 0);
        b(i11);
    }

    public final void e(int i10, int i11) throws IOException {
        d(i10, c(i11));
    }

    public final void b(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f18501a.write((byte) ((i10 & 127) | 128));
            i10 >>>= 7;
        }
        this.f18501a.write((byte) i10);
    }

    public final void c(int i10, int i11) throws IOException {
        b(i10, 0);
        a(i11);
    }

    public final void a(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f18501a.write((byte) ((((int) j10) & 127) | 128));
            j10 >>>= 7;
        }
        this.f18501a.write((byte) j10);
    }

    public final void b(int i10, long j10) throws IOException {
        b(i10, 0);
        a(j10);
    }

    public final void a(int i10, byte[] bArr) throws IOException {
        b(i10, 2);
        a(bArr);
    }

    public final void a(byte[] bArr) throws IOException {
        b(bArr.length);
        this.f18501a.write(bArr, 0, bArr.length);
    }

    public final void a(byte[] bArr, int i10, int i11) throws IOException {
        b(i11);
        this.f18501a.write(bArr, i10, i11);
    }

    public final void a(int i10, long j10) throws IOException {
        b(i10, j10);
    }

    public final void a(int i10, String str) throws IOException {
        b(i10, 2);
        a(str);
    }

    public final void a(String str) throws IOException {
        int i10;
        char cCharAt;
        int length = str.length() * 3;
        byte[] bArr = new byte[length];
        int length2 = str.length();
        int i11 = 0;
        while (i11 < length2 && i11 < length && (cCharAt = str.charAt(i11)) < 128) {
            bArr[i11] = (byte) cCharAt;
            i11++;
        }
        if (i11 != length2) {
            int i12 = i11;
            while (i11 < length2) {
                char cCharAt2 = str.charAt(i11);
                if (cCharAt2 < 128 && i12 < length) {
                    bArr[i12] = (byte) cCharAt2;
                    i12++;
                } else if (cCharAt2 < 2048 && i12 <= length - 2) {
                    int i13 = i12 + 1;
                    bArr[i12] = (byte) ((cCharAt2 >>> 6) | 960);
                    i12 += 2;
                    bArr[i13] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i12 > length - 3) {
                        if (i12 <= length - 4) {
                            i11++;
                            if (i11 != str.length()) {
                                char cCharAt3 = str.charAt(i11);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    bArr[i12] = (byte) ((codePoint >>> 18) | 240);
                                    bArr[i12 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i14 = i12 + 3;
                                    bArr[i12 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i12 += 4;
                                    bArr[i14] = (byte) ((codePoint & 63) | 128);
                                }
                            }
                            throw new RuntimeException("utf16Length");
                        }
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i11 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i10)))) {
                            throw new RuntimeException("utf16Length");
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i12);
                    }
                    bArr[i12] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i15 = i12 + 2;
                    bArr[i12 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i12 += 3;
                    bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
                }
                i11++;
            }
            length2 = i12;
        }
        a(bArr, 0, length2);
    }

    public final void a(int i10, b bVar) throws IOException {
        b(i10, 2);
        a(bVar);
    }

    public final void a(b bVar) throws IOException {
        c cVar = new c();
        bVar.a(cVar);
        a(cVar.f18501a.toByteArray());
    }

    public byte[] a() {
        return this.f18501a.toByteArray();
    }
}
