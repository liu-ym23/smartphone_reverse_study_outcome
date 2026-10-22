package c7;

import androidx.collection.SieveCacheKt;
import java.nio.charset.StandardCharsets;

/* renamed from: c7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0881a extends AbstractC0883c {

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f2092j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final byte[] k = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    public final byte[] f;
    public final byte[] g;
    public final byte[] h;
    public final int i;

    public C0881a(byte[] bArr) {
        super(bArr.length);
        this.g = k;
        for (byte b : bArr) {
            if (this.f2094a != b) {
                if (b >= 0) {
                    byte[] bArr2 = this.g;
                    if (b >= bArr2.length || bArr2[b] == -1) {
                    }
                }
            }
            throw new IllegalArgumentException(B7.a.m("lineSeparator must not contain base64 characters: [", new String(bArr, StandardCharsets.UTF_8), "]"));
        }
        this.i = 4;
        this.h = null;
        this.f = f2092j;
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C0881a c0881a = new C0881a(AbstractC0883c.e);
        int length = bArr.length;
        int i = c0881a.b;
        long j5 = (((length + i) - 1) / i) * c0881a.c;
        if (j5 > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.q(j5, "Input array too big, the output array would be bigger (", ") than the specified maximum size of 2147483647"));
        }
        if (bArr.length != 0) {
            int length2 = bArr.length;
            if (bArr.length != 0) {
                C0882b c0882b = new C0882b();
                c0881a.b(bArr, length2, c0882b);
                c0881a.b(bArr, -1, c0882b);
                int i6 = c0882b.c - c0882b.d;
                byte[] bArr2 = new byte[i6];
                if (c0882b.b != null) {
                    int iMin = Math.min(i6, i6);
                    System.arraycopy(c0882b.b, c0882b.d, bArr2, 0, iMin);
                    int i10 = c0882b.d + iMin;
                    c0882b.d = i10;
                    if (i10 >= c0882b.c) {
                        c0882b.b = null;
                    }
                }
                return bArr2;
            }
        }
        return bArr;
    }

    public final void b(byte[] bArr, int i, C0882b c0882b) {
        if (c0882b.e) {
            return;
        }
        int i6 = this.i;
        byte[] bArr2 = this.f;
        int i10 = this.d;
        byte[] bArr3 = this.h;
        if (i >= 0) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < i) {
                byte[] bArrA = AbstractC0883c.a(i6, c0882b);
                int i13 = (c0882b.g + 1) % 3;
                c0882b.g = i13;
                int i14 = i12 + 1;
                int i15 = bArr[i12];
                if (i15 < 0) {
                    i15 += 256;
                }
                int i16 = (c0882b.f2093a << 8) + i15;
                c0882b.f2093a = i16;
                if (i13 == 0) {
                    int i17 = c0882b.c;
                    int i18 = i17 + 1;
                    c0882b.c = i18;
                    bArrA[i17] = bArr2[(i16 >> 18) & 63];
                    int i19 = i17 + 2;
                    c0882b.c = i19;
                    bArrA[i18] = bArr2[(i16 >> 12) & 63];
                    int i20 = i17 + 3;
                    c0882b.c = i20;
                    bArrA[i19] = bArr2[(i16 >> 6) & 63];
                    int i21 = i17 + 4;
                    c0882b.c = i21;
                    bArrA[i20] = bArr2[i16 & 63];
                    int i22 = c0882b.f + 4;
                    c0882b.f = i22;
                    if (i10 > 0 && i10 <= i22) {
                        System.arraycopy(bArr3, 0, bArrA, i21, bArr3.length);
                        c0882b.c += bArr3.length;
                        c0882b.f = 0;
                    }
                }
                i11++;
                i12 = i14;
            }
            return;
        }
        c0882b.e = true;
        if (c0882b.g == 0 && i10 == 0) {
            return;
        }
        byte[] bArrA2 = AbstractC0883c.a(i6, c0882b);
        int i23 = c0882b.c;
        int i24 = c0882b.g;
        if (i24 != 0) {
            byte b = this.f2094a;
            byte[] bArr4 = f2092j;
            if (i24 == 1) {
                int i25 = i23 + 1;
                c0882b.c = i25;
                int i26 = c0882b.f2093a;
                bArrA2[i23] = bArr2[(i26 >> 2) & 63];
                int i27 = i23 + 2;
                c0882b.c = i27;
                bArrA2[i25] = bArr2[(i26 << 4) & 63];
                if (bArr2 == bArr4) {
                    int i28 = i23 + 3;
                    c0882b.c = i28;
                    bArrA2[i27] = b;
                    c0882b.c = i23 + 4;
                    bArrA2[i28] = b;
                }
            } else {
                if (i24 != 2) {
                    throw new IllegalStateException("Impossible modulus " + c0882b.g);
                }
                int i29 = i23 + 1;
                c0882b.c = i29;
                int i30 = c0882b.f2093a;
                bArrA2[i23] = bArr2[(i30 >> 10) & 63];
                int i31 = i23 + 2;
                c0882b.c = i31;
                bArrA2[i29] = bArr2[(i30 >> 4) & 63];
                int i32 = i23 + 3;
                c0882b.c = i32;
                bArrA2[i31] = bArr2[(i30 << 2) & 63];
                if (bArr2 == bArr4) {
                    c0882b.c = i23 + 4;
                    bArrA2[i32] = b;
                }
            }
        }
        int i33 = c0882b.f;
        int i34 = c0882b.c;
        int i35 = (i34 - i23) + i33;
        c0882b.f = i35;
        if (i10 <= 0 || i35 <= 0) {
            return;
        }
        System.arraycopy(bArr3, 0, bArrA2, i34, bArr3.length);
        c0882b.c += bArr3.length;
    }
}
