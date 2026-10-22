package l2;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f3779a = Charset.forName("UTF-8");

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
        throw new UnsupportedOperationException("Method not decompiled: l2.f.a(java.lang.String):byte[]");
    }

    public static byte[] b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = e.f3778c;
        int i8 = (length / 3) * 4;
        if (length % 3 > 0) {
            i8 += 4;
        }
        byte[] bArr3 = new byte[i8];
        int i9 = 0;
        int i10 = 0;
        int i11 = -1;
        while (true) {
            int i12 = i9 + 3;
            if (i12 > length) {
                break;
            }
            int i13 = (bArr[i9 + 2] & 255) | ((bArr[i9] & 255) << 16) | ((bArr[i9 + 1] & 255) << 8);
            bArr3[i10] = bArr2[(i13 >> 18) & 63];
            bArr3[i10 + 1] = bArr2[(i13 >> 12) & 63];
            bArr3[i10 + 2] = bArr2[(i13 >> 6) & 63];
            bArr3[i10 + 3] = bArr2[i13 & 63];
            int i14 = i10 + 4;
            i11--;
            if (i11 == 0) {
                i10 += 5;
                bArr3[i14] = 10;
                i11 = 19;
            } else {
                i10 = i14;
            }
            i9 = i12;
        }
        if (i9 == length - 1) {
            int i15 = (bArr[i9] & 255) << 4;
            bArr3[i10] = bArr2[(i15 >> 6) & 63];
            bArr3[i10 + 1] = bArr2[i15 & 63];
            bArr3[i10 + 2] = 61;
            bArr3[i10 + 3] = 61;
            return bArr3;
        }
        if (i9 == length - 2) {
            int i16 = ((bArr[i9 + 1] & 255) << 2) | ((bArr[i9] & 255) << 10);
            bArr3[i10] = bArr2[(i16 >> 12) & 63];
            bArr3[i10 + 1] = bArr2[(i16 >> 6) & 63];
            bArr3[i10 + 2] = bArr2[i16 & 63];
            bArr3[i10 + 3] = 61;
        }
        return bArr3;
    }
}
