package h4;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f4143a = Charset.forName("UTF-8");

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
    
        if (r7 != 4) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.j.a(java.lang.String):byte[]");
    }

    public static byte[] b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = i.f4142c;
        int i2 = (length / 3) * 4;
        if (length % 3 > 0) {
            i2 += 4;
        }
        byte[] bArr3 = new byte[i2];
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        while (true) {
            int i13 = i10 + 3;
            if (i13 > length) {
                break;
            }
            int i14 = (bArr[i10 + 2] & 255) | ((bArr[i10] & 255) << 16) | ((bArr[i10 + 1] & 255) << 8);
            bArr3[i11] = bArr2[(i14 >> 18) & 63];
            bArr3[i11 + 1] = bArr2[(i14 >> 12) & 63];
            bArr3[i11 + 2] = bArr2[(i14 >> 6) & 63];
            bArr3[i11 + 3] = bArr2[i14 & 63];
            int i15 = i11 + 4;
            i12--;
            if (i12 == 0) {
                i11 += 5;
                bArr3[i15] = 10;
                i12 = 19;
            } else {
                i11 = i15;
            }
            i10 = i13;
        }
        if (i10 == length - 1) {
            int i16 = (bArr[i10] & 255) << 4;
            bArr3[i11] = bArr2[(i16 >> 6) & 63];
            bArr3[i11 + 1] = bArr2[i16 & 63];
            bArr3[i11 + 2] = 61;
            bArr3[i11 + 3] = 61;
            return bArr3;
        }
        if (i10 == length - 2) {
            int i17 = ((bArr[i10 + 1] & 255) << 2) | ((bArr[i10] & 255) << 10);
            bArr3[i11] = bArr2[(i17 >> 12) & 63];
            bArr3[i11 + 1] = bArr2[(i17 >> 6) & 63];
            bArr3[i11 + 2] = bArr2[i17 & 63];
            bArr3[i11 + 3] = 61;
        }
        return bArr3;
    }
}
