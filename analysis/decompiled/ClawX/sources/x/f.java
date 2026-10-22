package x;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import j6.j;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.p;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f {
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0056 -> B:26:0x0075). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0067 -> B:25:0x006e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object A(io.ktor.utils.io.p r17, java.io.OutputStream r18, long r19, h5.c r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.f.A(io.ktor.utils.io.p, java.io.OutputStream, long, h5.c):java.lang.Object");
    }

    public static void A0(int[] iArr, int[] iArr2) {
        long j4 = iArr[0] & 4294967295L;
        int i8 = 10;
        int i9 = 0;
        int i10 = 4;
        while (true) {
            int i11 = i10 - 1;
            long j8 = iArr[i10] & 4294967295L;
            long j9 = j8 * j8;
            iArr2[i8 - 1] = (i9 << 31) | ((int) (j9 >>> 33));
            i8 -= 2;
            iArr2[i8] = (int) (j9 >>> 1);
            i9 = (int) j9;
            if (i11 <= 0) {
                long j10 = j4 * j4;
                long j11 = (j10 >>> 33) | ((i9 << 31) & 4294967295L);
                iArr2[0] = (int) j10;
                int i12 = ((int) (j10 >>> 32)) & 1;
                long j12 = iArr[1] & 4294967295L;
                long j13 = (j12 * j4) + j11;
                int i13 = (int) j13;
                iArr2[1] = i12 | (i13 << 1);
                long j14 = iArr[2] & 4294967295L;
                long j15 = (j14 * j4) + (iArr2[2] & 4294967295L) + (j13 >>> 32);
                int i14 = (int) j15;
                iArr2[2] = (i14 << 1) | (i13 >>> 31);
                long jH = a8.b.h(j14, j12, j15 >>> 32, iArr2[3] & 4294967295L);
                long j16 = (iArr2[4] & 4294967295L) + (jH >>> 32);
                long j17 = iArr[3] & 4294967295L;
                long j18 = (iArr2[5] & 4294967295L) + (j16 >>> 32);
                long j19 = j16 & 4294967295L;
                long j20 = (iArr2[6] & 4294967295L) + (j18 >>> 32);
                long j21 = j18 & 4294967295L;
                long j22 = (j17 * j4) + (jH & 4294967295L);
                int i15 = (int) j22;
                iArr2[3] = (i14 >>> 31) | (i15 << 1);
                int i16 = i15 >>> 31;
                long jH2 = a8.b.h(j17, j12, j22 >>> 32, j19);
                long jH3 = a8.b.h(j17, j14, jH2 >>> 32, j21);
                long j23 = j20 + (jH3 >>> 32);
                long j24 = iArr[4] & 4294967295L;
                long j25 = (iArr2[7] & 4294967295L) + (j23 >>> 32);
                long j26 = j23 & 4294967295L;
                long j27 = (iArr2[8] & 4294967295L) + (j25 >>> 32);
                long j28 = (j24 * j4) + (jH2 & 4294967295L);
                int i17 = (int) j28;
                iArr2[4] = i16 | (i17 << 1);
                int i18 = i17 >>> 31;
                long jH4 = a8.b.h(j24, j12, j28 >>> 32, jH3 & 4294967295L);
                long jH5 = a8.b.h(j24, j14, jH4 >>> 32, j26);
                long jH6 = a8.b.h(j24, j17, jH5 >>> 32, j25 & 4294967295L);
                long j29 = j27 + (jH6 >>> 32);
                int i19 = (int) jH4;
                iArr2[5] = (i19 << 1) | i18;
                int i20 = (int) jH5;
                iArr2[6] = (i19 >>> 31) | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) jH6;
                iArr2[7] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j29;
                iArr2[8] = i23 | (i24 << 1);
                iArr2[9] = ((iArr2[9] + ((int) (j29 >>> 32))) << 1) | (i24 >>> 31);
                return;
            }
            i10 = i11;
        }
    }

    public static int B(int i8, int i9, int[] iArr) {
        while (i9 < i8) {
            int i10 = iArr[i9] - 1;
            iArr[i9] = i10;
            if (i10 != -1) {
                return 0;
            }
            i9++;
        }
        return -1;
    }

    public static void B0(int[] iArr, int[] iArr2) {
        long j4 = iArr[0] & 4294967295L;
        int i8 = 14;
        int i9 = 0;
        int i10 = 6;
        while (true) {
            int i11 = i10 - 1;
            long j8 = iArr[i10] & 4294967295L;
            long j9 = j8 * j8;
            iArr2[i8 - 1] = (i9 << 31) | ((int) (j9 >>> 33));
            i8 -= 2;
            iArr2[i8] = (int) (j9 >>> 1);
            i9 = (int) j9;
            if (i11 <= 0) {
                long j10 = j4 * j4;
                long j11 = (j10 >>> 33) | ((i9 << 31) & 4294967295L);
                iArr2[0] = (int) j10;
                int i12 = ((int) (j10 >>> 32)) & 1;
                long j12 = iArr[1] & 4294967295L;
                long j13 = (j12 * j4) + j11;
                int i13 = (int) j13;
                iArr2[1] = i12 | (i13 << 1);
                long j14 = iArr[2] & 4294967295L;
                long j15 = (j14 * j4) + (iArr2[2] & 4294967295L) + (j13 >>> 32);
                int i14 = (int) j15;
                iArr2[2] = (i14 << 1) | (i13 >>> 31);
                long jH = a8.b.h(j14, j12, j15 >>> 32, iArr2[3] & 4294967295L);
                long j16 = (iArr2[4] & 4294967295L) + (jH >>> 32);
                long j17 = iArr[3] & 4294967295L;
                long j18 = (iArr2[5] & 4294967295L) + (j16 >>> 32);
                long j19 = j16 & 4294967295L;
                long j20 = (iArr2[6] & 4294967295L) + (j18 >>> 32);
                long j21 = j18 & 4294967295L;
                long j22 = (j17 * j4) + (jH & 4294967295L);
                int i15 = (int) j22;
                iArr2[3] = (i14 >>> 31) | (i15 << 1);
                int i16 = i15 >>> 31;
                long jH2 = a8.b.h(j17, j12, j22 >>> 32, j19);
                long jH3 = a8.b.h(j17, j14, jH2 >>> 32, j21);
                long j23 = j20 + (jH3 >>> 32);
                long j24 = iArr[4] & 4294967295L;
                long j25 = (iArr2[7] & 4294967295L) + (j23 >>> 32);
                long j26 = j23 & 4294967295L;
                long j27 = (iArr2[8] & 4294967295L) + (j25 >>> 32);
                long j28 = j25 & 4294967295L;
                long j29 = (j24 * j4) + (jH2 & 4294967295L);
                int i17 = (int) j29;
                iArr2[4] = i16 | (i17 << 1);
                int i18 = i17 >>> 31;
                long jH4 = a8.b.h(j24, j12, j29 >>> 32, jH3 & 4294967295L);
                long jH5 = a8.b.h(j24, j14, jH4 >>> 32, j26);
                long jH6 = a8.b.h(j24, j17, jH5 >>> 32, j28);
                long j30 = j27 + (jH6 >>> 32);
                long j31 = iArr[5] & 4294967295L;
                long j32 = (iArr2[9] & 4294967295L) + (j30 >>> 32);
                long j33 = j30 & 4294967295L;
                long j34 = (iArr2[10] & 4294967295L) + (j32 >>> 32);
                long j35 = j32 & 4294967295L;
                long j36 = (j31 * j4) + (jH4 & 4294967295L);
                int i19 = (int) j36;
                iArr2[5] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                long jH7 = a8.b.h(j31, j12, j36 >>> 32, jH5 & 4294967295L);
                long jH8 = a8.b.h(j31, j14, jH7 >>> 32, jH6 & 4294967295L);
                long jH9 = a8.b.h(j31, j17, jH8 >>> 32, j33);
                long j37 = jH8 & 4294967295L;
                long jH10 = a8.b.h(j31, j24, jH9 >>> 32, j35);
                long j38 = j34 + (jH10 >>> 32);
                long j39 = jH10 & 4294967295L;
                long j40 = iArr[6] & 4294967295L;
                long j41 = (iArr2[11] & 4294967295L) + (j38 >>> 32);
                long j42 = j38 & 4294967295L;
                long j43 = (iArr2[12] & 4294967295L) + (j41 >>> 32);
                long j44 = j41 & 4294967295L;
                long j45 = (j40 * j4) + (jH7 & 4294967295L);
                int i21 = (int) j45;
                iArr2[6] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                long jH11 = a8.b.h(j40, j12, j45 >>> 32, j37);
                long jH12 = a8.b.h(j40, j14, jH11 >>> 32, jH9 & 4294967295L);
                long jH13 = a8.b.h(j40, j17, jH12 >>> 32, j39);
                long jH14 = a8.b.h(j40, j24, jH13 >>> 32, j42);
                long jH15 = a8.b.h(j40, j31, jH14 >>> 32, j44);
                long j46 = j43 + (jH15 >>> 32);
                int i23 = (int) jH11;
                iArr2[7] = (i23 << 1) | i22;
                int i24 = (int) jH12;
                iArr2[8] = (i23 >>> 31) | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) jH13;
                iArr2[9] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) jH14;
                iArr2[10] = i27 | (i28 << 1);
                int i29 = i28 >>> 31;
                int i30 = (int) jH15;
                iArr2[11] = i29 | (i30 << 1);
                int i31 = i30 >>> 31;
                int i32 = (int) j46;
                iArr2[12] = i31 | (i32 << 1);
                iArr2[13] = ((iArr2[13] + ((int) (j46 >>> 32))) << 1) | (i32 >>> 31);
                return;
            }
            i10 = i11;
        }
    }

    public static void C(int i8, int[] iArr, int[] iArr2) {
        int i9 = 0;
        long j4 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i8 > 0) {
            while (i9 < Math.min(32, i8)) {
                j4 |= iArr[i10] << i9;
                i9 += 30;
                i10++;
            }
            iArr2[i11] = (int) j4;
            j4 >>>= 32;
            i9 -= 32;
            i8 -= 32;
            i11++;
        }
    }

    public static int C0(int[] iArr, int[] iArr2, int i8, int[] iArr3) {
        long j4 = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            long j8 = ((iArr[i9] & 4294967295L) - (4294967295L & iArr2[i9])) + j4;
            iArr3[i9] = (int) j8;
            j4 = j8 >> 32;
        }
        return (int) j4;
    }

    public static boolean D(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z;
        int i8 = 6;
        while (true) {
            z = true;
            if (i8 < 0) {
                break;
            }
            int i9 = iArr[7 + i8] ^ Integer.MIN_VALUE;
            int i10 = Integer.MIN_VALUE ^ iArr2[i8];
            if (i9 < i10) {
                z = false;
                break;
            }
            if (i9 > i10) {
                break;
            }
            i8--;
        }
        if (z) {
            E0(iArr, 7, iArr2, 0, iArr3);
            return z;
        }
        E0(iArr2, 0, iArr, 7, iArr3);
        return z;
    }

    public static int D0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = (iArr[0] & 4294967295L) - (iArr2[0] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = ((iArr[1] & 4294967295L) - (iArr2[1] & 4294967295L)) + (j4 >> 32);
        iArr3[1] = (int) j8;
        long j9 = ((iArr[2] & 4294967295L) - (iArr2[2] & 4294967295L)) + (j8 >> 32);
        iArr3[2] = (int) j9;
        long j10 = ((iArr[3] & 4294967295L) - (iArr2[3] & 4294967295L)) + (j9 >> 32);
        iArr3[3] = (int) j10;
        long j11 = ((iArr[4] & 4294967295L) - (iArr2[4] & 4294967295L)) + (j10 >> 32);
        iArr3[4] = (int) j11;
        return (int) (j11 >> 32);
    }

    public static final long E(j jVar, long j4) throws EOFException {
        p.e(jVar, "<this>");
        jVar.k(j4);
        long jMin = Math.min(j4, W(jVar));
        jVar.c().skip(jMin);
        return jMin;
    }

    public static void E0(int[] iArr, int i8, int[] iArr2, int i9, int[] iArr3) {
        long j4 = (iArr[i8] & 4294967295L) - (iArr2[i9] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = ((iArr[i8 + 1] & 4294967295L) - (iArr2[i9 + 1] & 4294967295L)) + (j4 >> 32);
        iArr3[1] = (int) j8;
        long j9 = ((iArr[i8 + 2] & 4294967295L) - (iArr2[i9 + 2] & 4294967295L)) + (j8 >> 32);
        iArr3[2] = (int) j9;
        long j10 = ((iArr[i8 + 3] & 4294967295L) - (iArr2[i9 + 3] & 4294967295L)) + (j9 >> 32);
        iArr3[3] = (int) j10;
        long j11 = ((iArr[i8 + 4] & 4294967295L) - (iArr2[i9 + 4] & 4294967295L)) + (j10 >> 32);
        iArr3[4] = (int) j11;
        long j12 = ((iArr[i8 + 5] & 4294967295L) - (iArr2[i9 + 5] & 4294967295L)) + (j11 >> 32);
        iArr3[5] = (int) j12;
        iArr3[6] = (int) (((iArr[i8 + 6] & 4294967295L) - (iArr2[i9 + 6] & 4294967295L)) + (j12 >> 32));
    }

    public static int F(int[] iArr, int i8, int i9, int i10) {
        int i11;
        int i12 = 30;
        int i13 = 1;
        int i14 = 1;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            int iNumberOfTrailingZeros = Integers.numberOfTrailingZeros(((-1) << i12) | i10);
            int i17 = i10 >> iNumberOfTrailingZeros;
            i13 <<= iNumberOfTrailingZeros;
            i15 <<= iNumberOfTrailingZeros;
            i8 -= iNumberOfTrailingZeros;
            i12 -= iNumberOfTrailingZeros;
            if (i12 <= 0) {
                iArr[0] = i13;
                iArr[1] = i15;
                iArr[2] = i16;
                iArr[3] = i14;
                return i8;
            }
            if (i8 <= 0) {
                i8 = 2 - i8;
                int i18 = -i9;
                int i19 = -i13;
                int i20 = -i15;
                i11 = ((-1) >>> (32 - (i8 > i12 ? i12 : i8))) & 63 & (((i17 * i17) - 2) * i17 * i18);
                i17 = i18;
                i9 = i17;
                int i21 = i16;
                i16 = i19;
                i13 = i21;
                int i22 = i14;
                i14 = i20;
                i15 = i22;
            } else {
                i11 = ((-1) >>> (32 - (i8 > i12 ? i12 : i8))) & 15 & (((((i9 + 1) & 4) << 1) + i9) * (-i17));
            }
            i10 = i17 + (i9 * i11);
            i16 += i13 * i11;
            i14 += i11 * i15;
        }
    }

    public static int F0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = (iArr[0] & 4294967295L) - (iArr2[0] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = ((iArr[1] & 4294967295L) - (iArr2[1] & 4294967295L)) + (j4 >> 32);
        iArr3[1] = (int) j8;
        long j9 = ((iArr[2] & 4294967295L) - (iArr2[2] & 4294967295L)) + (j8 >> 32);
        iArr3[2] = (int) j9;
        long j10 = ((iArr[3] & 4294967295L) - (iArr2[3] & 4294967295L)) + (j9 >> 32);
        iArr3[3] = (int) j10;
        long j11 = ((iArr[4] & 4294967295L) - (iArr2[4] & 4294967295L)) + (j10 >> 32);
        iArr3[4] = (int) j11;
        long j12 = ((iArr[5] & 4294967295L) - (iArr2[5] & 4294967295L)) + (j11 >> 32);
        iArr3[5] = (int) j12;
        long j13 = ((iArr[6] & 4294967295L) - (iArr2[6] & 4294967295L)) + (j12 >> 32);
        iArr3[6] = (int) j13;
        return (int) (j13 >> 32);
    }

    public static void G(int i8, int[] iArr, int[] iArr2) {
        int i9 = 0;
        long j4 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i8 > 0) {
            if (i9 < Math.min(30, i8)) {
                j4 |= (iArr[i10] & 4294967295L) << i9;
                i9 += 32;
                i10++;
            }
            iArr2[i11] = ((int) j4) & 1073741823;
            j4 >>>= 30;
            i9 -= 30;
            i8 -= 30;
            i11++;
        }
    }

    public static void G0(int i8, int i9, int[] iArr) {
        long j4 = (iArr[0] & 4294967295L) - (i9 & 4294967295L);
        iArr[0] = (int) j4;
        long j8 = ((4294967295L & iArr[1]) - 1) + (j4 >> 32);
        iArr[1] = (int) j8;
        if ((j8 >> 32) == 0) {
            return;
        }
        B(i8, 2, iArr);
    }

    public static final byte[] H(CharsetEncoder charsetEncoder, CharSequence input, int i8, int i9) {
        p.e(charsetEncoder, "<this>");
        p.e(input, "input");
        if (input instanceof String) {
            if (i8 == 0) {
                String str = (String) input;
                if (i9 == str.length()) {
                    byte[] bytes = str.getBytes(charsetEncoder.charset());
                    p.d(bytes, "getBytes(...)");
                    return bytes;
                }
            }
            String strSubstring = ((String) input).substring(i8, i9);
            p.d(strSubstring, "substring(...)");
            byte[] bytes2 = strSubstring.getBytes(charsetEncoder.charset());
            p.d(bytes2, "getBytes(...)");
            return bytes2;
        }
        ByteBuffer byteBufferEncode = charsetEncoder.encode(CharBuffer.wrap(input, i8, i9));
        byte[] bArr = null;
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            byte[] bArrArray = byteBufferEncode.array();
            if (bArrArray.length == byteBufferEncode.remaining()) {
                bArr = bArrArray;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr2);
        return bArr2;
    }

    public static int H0(int i8, int i9, int[] iArr, int[] iArr2) {
        long j4 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            long j8 = ((iArr2[r3] & 4294967295L) - (4294967295L & iArr[i10])) + j4;
            iArr2[i9 + i10] = (int) j8;
            j4 = j8 >> 32;
        }
        return (int) j4;
    }

    public static boolean I(int i8, int[] iArr, int[] iArr2) {
        for (int i9 = i8 - 1; i9 >= 0; i9--) {
            if (iArr[i9] != iArr2[i9]) {
                return false;
            }
        }
        return true;
    }

    public static void I0(int i8, int[] iArr, int[] iArr2) {
        long j4 = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            long j8 = ((iArr2[i9] & 4294967295L) - (4294967295L & iArr[i9])) + j4;
            iArr2[i9] = (int) j8;
            j4 = j8 >> 32;
        }
    }

    public static boolean J(int[] iArr, int[] iArr2) {
        for (int i8 = 4; i8 >= 0; i8--) {
            if (iArr[i8] != iArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    public static void J0(int[] iArr, int[] iArr2) {
        long j4 = (iArr2[0] & 4294967295L) - (iArr[0] & 4294967295L);
        iArr2[0] = (int) j4;
        long j8 = ((iArr2[1] & 4294967295L) - (iArr[1] & 4294967295L)) + (j4 >> 32);
        iArr2[1] = (int) j8;
        long j9 = ((iArr2[2] & 4294967295L) - (iArr[2] & 4294967295L)) + (j8 >> 32);
        iArr2[2] = (int) j9;
        long j10 = ((iArr2[3] & 4294967295L) - (iArr[3] & 4294967295L)) + (j9 >> 32);
        iArr2[3] = (int) j10;
        iArr2[4] = (int) (((iArr2[4] & 4294967295L) - (4294967295L & iArr[4])) + (j10 >> 32));
    }

    public static boolean K(int[] iArr, int[] iArr2) {
        for (int i8 = 6; i8 >= 0; i8--) {
            if (iArr[i8] != iArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    public static BigInteger K0(int i8, int[] iArr) {
        byte[] bArr = new byte[i8 << 2];
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = iArr[i9];
            if (i10 != 0) {
                Pack.intToBigEndian(i10, bArr, ((i8 - 1) - i9) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int L(int i8, int i9, int[] iArr) {
        int i10 = i9 ^ iArr[0];
        for (int i11 = 1; i11 < i8; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static BigInteger L0(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i8 = 0; i8 < 5; i8++) {
            int i9 = iArr[i8];
            if (i9 != 0) {
                Pack.intToBigEndian(i9, bArr, (4 - i8) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static boolean M(int i8, int i9, int[] iArr) {
        int i10 = i9 ^ iArr[0];
        if (i10 == 0) {
            for (int i11 = 1; i11 < i8; i11++) {
                i10 |= iArr[i11];
            }
            if (i10 == 0) {
                return true;
            }
        }
        return false;
    }

    public static BigInteger M0(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i8 = 0; i8 < 7; i8++) {
            int i9 = iArr[i8];
            if (i9 != 0) {
                Pack.intToBigEndian(i9, bArr, (6 - i8) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static final boolean N(char c3, char c8, boolean z) {
        if (c3 == c8) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c3);
        char upperCase2 = Character.toUpperCase(c8);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static int N0(int i8, int[] iArr, int[] iArr2) {
        int i9 = i8 - 1;
        int i10 = iArr[i9];
        int i11 = iArr2[i9];
        int i12 = i8 - 2;
        if (((i12 >> 31) | ((i10 >> 31) ^ i10) | ((i11 >> 31) ^ i11)) != 0) {
            return i8;
        }
        iArr[i12] = (i10 << 30) | iArr[i12];
        iArr2[i12] = iArr2[i12] | (i11 << 30);
        return i8 - 1;
    }

    public static int[] O(int i8, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i8) {
            throw new IllegalArgumentException();
        }
        int i9 = (i8 + 31) >> 5;
        int[] iArr = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr[i10] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static void O0(int i8, int i9, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i10 = i8;
        int i11 = iArr3[0];
        int i12 = iArr3[1];
        int i13 = iArr3[2];
        int i14 = iArr3[3];
        int i15 = i10 - 1;
        int i16 = iArr[i15] >> 31;
        int i17 = iArr2[i15] >> 31;
        int i18 = (i11 & i16) + (i12 & i17);
        int i19 = (i16 & i13) + (i17 & i14);
        int i20 = iArr4[0];
        long j4 = i11;
        long j8 = iArr[0];
        long j9 = i12;
        long j10 = iArr2[0];
        long j11 = (j9 * j10) + (j4 * j8);
        long j12 = i13;
        long j13 = i14;
        long j14 = (j13 * j10) + (j8 * j12);
        int i21 = i18 - (((((int) j11) * i9) + i18) & 1073741823);
        long j15 = i20;
        long j16 = i21;
        long j17 = (j15 * j16) + j11;
        long j18 = i19 - (((((int) j14) * i9) + i19) & 1073741823);
        char c3 = 30;
        long j19 = j17 >> 30;
        long j20 = ((j15 * j18) + j14) >> 30;
        int i22 = 1;
        while (i22 < i10) {
            int i23 = iArr4[i22];
            char c8 = c3;
            long j21 = j18;
            long j22 = iArr[i22];
            long j23 = j4 * j22;
            long j24 = iArr2[i22];
            long j25 = i23;
            long j26 = j16;
            long jH = a8.b.h(j25, j26, (j9 * j24) + j23, j19);
            long jH2 = a8.b.h(j25, j21, (j24 * j13) + (j12 * j22), j20);
            int i24 = i22 - 1;
            iArr[i24] = ((int) jH) & 1073741823;
            j19 = jH >> c8;
            iArr2[i24] = ((int) jH2) & 1073741823;
            j20 = jH2 >> c8;
            i22++;
            i10 = i8;
            c3 = c8;
            j16 = j26;
            j18 = j21;
        }
        iArr[i15] = (int) j19;
        iArr2[i15] = (int) j20;
    }

    public static int[] P(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[5];
        for (int i8 = 0; i8 < 5; i8++) {
            iArr[i8] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static void P0(int[] iArr, int[] iArr2, int i8, int[] iArr3) {
        int i9 = iArr3[0];
        int i10 = 1;
        int i11 = iArr3[1];
        int i12 = iArr3[2];
        int i13 = iArr3[3];
        long j4 = i9;
        long j8 = iArr[0];
        long j9 = i11;
        long j10 = iArr2[0];
        long j11 = (j9 * j10) + (j4 * j8);
        long j12 = i12;
        long j13 = i13;
        long j14 = ((j10 * j13) + (j8 * j12)) >> 30;
        int i14 = 1;
        long j15 = j11 >> 30;
        while (i14 < i8) {
            long j16 = iArr[i14];
            int i15 = i10;
            long j17 = j12;
            long j18 = iArr2[i14];
            long jH = a8.b.h(j9, j18, j4 * j16, j15);
            long j19 = j13;
            long jH2 = a8.b.h(j19, j18, j17 * j16, j14);
            int i16 = i14 - 1;
            iArr[i16] = ((int) jH) & 1073741823;
            j15 = jH >> 30;
            iArr2[i16] = ((int) jH2) & 1073741823;
            j14 = jH2 >> 30;
            i14++;
            i10 = i15;
            j13 = j19;
            j12 = j17;
        }
        int i17 = i8 - i10;
        iArr[i17] = (int) j15;
        iArr2[i17] = (int) j14;
    }

    public static int[] Q(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[7];
        for (int i8 = 0; i8 < 7; i8++) {
            iArr[i8] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static long[] R(int i8, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i8) {
            throw new IllegalArgumentException();
        }
        int i9 = (i8 + 63) >> 6;
        long[] jArr = new long[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            jArr[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArr;
    }

    public static int S(int[] iArr) {
        return iArr[0] & 1;
    }

    public static int T(int[] iArr) {
        return iArr[0] & 1;
    }

    public static int U(int[] iArr) {
        return iArr[0] & 1;
    }

    public static final String V(Charset charset) {
        p.e(charset, "<this>");
        String strName = charset.name();
        p.d(strName, "name(...)");
        return strName;
    }

    public static final long W(j jVar) {
        p.e(jVar, "<this>");
        return jVar.c().f3512c;
    }

    public static boolean X(int i8, int[] iArr, int[] iArr2) {
        for (int i9 = i8 - 1; i9 >= 0; i9--) {
            int i10 = iArr[i9] ^ Integer.MIN_VALUE;
            int i11 = Integer.MIN_VALUE ^ iArr2[i9];
            if (i10 < i11) {
                return false;
            }
            if (i10 > i11) {
                return true;
            }
        }
        return true;
    }

    public static boolean Y(int[] iArr, int[] iArr2) {
        for (int i8 = 4; i8 >= 0; i8--) {
            int i9 = iArr[i8] ^ Integer.MIN_VALUE;
            int i10 = Integer.MIN_VALUE ^ iArr2[i8];
            if (i9 < i10) {
                return false;
            }
            if (i9 > i10) {
                return true;
            }
        }
        return true;
    }

    public static boolean Z(int[] iArr, int[] iArr2) {
        for (int i8 = 6; i8 >= 0; i8--) {
            int i9 = iArr[i8] ^ Integer.MIN_VALUE;
            int i10 = Integer.MIN_VALUE ^ iArr2[i8];
            if (i9 < i10) {
                return false;
            }
            if (i9 > i10) {
                return true;
            }
        }
        return true;
    }

    public static int a(int[] iArr, int[] iArr2, int i8, int[] iArr3) {
        long j4 = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            long j8 = (iArr[i9] & 4294967295L) + (4294967295L & iArr2[i9]) + j4;
            iArr3[i9] = (int) j8;
            j4 = j8 >>> 32;
        }
        return (int) j4;
    }

    public static int a0(int[] iArr, int i8, int i9, int i10) {
        int i11 = 1073741824;
        int i12 = 1073741824;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < 30; i15++) {
            int i16 = i8 >> 31;
            int i17 = -(i10 & 1);
            int i18 = i10 - ((i9 ^ i16) & i17);
            int i19 = i14 - ((i11 ^ i16) & i17);
            int i20 = i12 - ((i13 ^ i16) & i17);
            int i21 = (~i16) & i17;
            i8 = (i8 ^ i21) + 1;
            i9 += i18 & i21;
            i11 += i19 & i21;
            i13 += i21 & i20;
            i10 = i18 >> 1;
            i14 = i19 >> 1;
            i12 = i20 >> 1;
        }
        iArr[0] = i11;
        iArr[1] = i13;
        iArr[2] = i14;
        iArr[3] = i12;
        return i8;
    }

    public static int b(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L) + (j4 >>> 32);
        iArr3[1] = (int) j8;
        long j9 = (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L) + (j8 >>> 32);
        iArr3[2] = (int) j9;
        long j10 = (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L) + (j9 >>> 32);
        iArr3[3] = (int) j10;
        long j11 = (iArr[4] & 4294967295L) + (iArr2[4] & 4294967295L) + (j10 >>> 32);
        iArr3[4] = (int) j11;
        return (int) (j11 >>> 32);
    }

    public static int b0(int i8, int[] iArr, int[] iArr2) {
        int i9 = 0;
        while (i9 < i8) {
            int i10 = iArr[i9] + 1;
            iArr2[i9] = i10;
            i9++;
            if (i10 != 0) {
                while (i9 < i8) {
                    iArr2[i9] = iArr[i9];
                    i9++;
                }
                return 0;
            }
        }
        return 1;
    }

    public static int c(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L) + (j4 >>> 32);
        iArr3[1] = (int) j8;
        long j9 = (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L) + (j8 >>> 32);
        iArr3[2] = (int) j9;
        long j10 = (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L) + (j9 >>> 32);
        iArr3[3] = (int) j10;
        long j11 = (iArr[4] & 4294967295L) + (iArr2[4] & 4294967295L) + (j10 >>> 32);
        iArr3[4] = (int) j11;
        long j12 = (iArr[5] & 4294967295L) + (iArr2[5] & 4294967295L) + (j11 >>> 32);
        iArr3[5] = (int) j12;
        long j13 = (iArr[6] & 4294967295L) + (iArr2[6] & 4294967295L) + (j12 >>> 32);
        iArr3[6] = (int) j13;
        return (int) (j13 >>> 32);
    }

    public static int c0(int[] iArr) {
        for (int i8 = 0; i8 < 16; i8++) {
            int i9 = iArr[i8] + 1;
            iArr[i8] = i9;
            if (i9 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int d(int i8, int[] iArr, int[] iArr2) {
        int i9 = i8 - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = iArr[i11] + iArr2[i11] + i10;
            iArr[i11] = 1073741823 & i12;
            i10 = i12 >> 30;
        }
        int i13 = iArr[i9] + iArr2[i9] + i10;
        iArr[i9] = i13;
        return i13 >> 30;
    }

    public static int d0(int i8, int i9, int[] iArr) {
        while (i9 < i8) {
            int i10 = iArr[i9] + 1;
            iArr[i9] = i10;
            if (i10 != 0) {
                return 0;
            }
            i9++;
        }
        return 1;
    }

    public static void e(int i8, int i9, int[] iArr) {
        long j4 = (iArr[0] & 4294967295L) + (i9 & 4294967295L);
        iArr[0] = (int) j4;
        long j8 = (4294967295L & iArr[1]) + 1 + (j4 >>> 32);
        iArr[1] = (int) j8;
        if ((j8 >>> 32) == 0) {
            return;
        }
        d0(i8, 2, iArr);
    }

    public static int e0(int i8, int i9, int[] iArr) {
        while (i9 < i8) {
            int i10 = iArr[i9] + 1;
            iArr[i9] = i10;
            if (i10 != 0) {
                return 0;
            }
            i9++;
        }
        return 1;
    }

    public static int f(int[] iArr, int[] iArr2, int i8, int[] iArr3) {
        long j4 = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            long j8 = (iArr[i9] & 4294967295L) + (iArr2[i9] & 4294967295L) + (4294967295L & iArr3[i9]) + j4;
            iArr3[i9] = (int) j8;
            j4 = j8 >>> 32;
        }
        return (int) j4;
    }

    public static int f0(int i8) {
        int i9 = (2 - (i8 * i8)) * i8;
        int i10 = (2 - (i8 * i9)) * i9;
        int i11 = (2 - (i8 * i10)) * i10;
        return (2 - (i8 * i11)) * i11;
    }

    public static int g(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + (iArr3[0] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L) + (iArr3[1] & 4294967295L) + (j4 >>> 32);
        iArr3[1] = (int) j8;
        long j9 = (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L) + (iArr3[2] & 4294967295L) + (j8 >>> 32);
        iArr3[2] = (int) j9;
        long j10 = (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L) + (iArr3[3] & 4294967295L) + (j9 >>> 32);
        iArr3[3] = (int) j10;
        long j11 = (iArr[4] & 4294967295L) + (iArr2[4] & 4294967295L) + (iArr3[4] & 4294967295L) + (j10 >>> 32);
        iArr3[4] = (int) j11;
        return (int) (j11 >>> 32);
    }

    public static boolean g0(int i8, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i9 = 1; i9 < i8; i9++) {
            if (iArr[i9] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int h(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + (iArr3[0] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L) + (iArr3[1] & 4294967295L) + (j4 >>> 32);
        iArr3[1] = (int) j8;
        long j9 = (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L) + (iArr3[2] & 4294967295L) + (j8 >>> 32);
        iArr3[2] = (int) j9;
        long j10 = (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L) + (iArr3[3] & 4294967295L) + (j9 >>> 32);
        iArr3[3] = (int) j10;
        long j11 = (iArr[4] & 4294967295L) + (iArr2[4] & 4294967295L) + (iArr3[4] & 4294967295L) + (j10 >>> 32);
        iArr3[4] = (int) j11;
        long j12 = (iArr[5] & 4294967295L) + (iArr2[5] & 4294967295L) + (iArr3[5] & 4294967295L) + (j11 >>> 32);
        iArr3[5] = (int) j12;
        long j13 = (iArr[6] & 4294967295L) + (iArr2[6] & 4294967295L) + (iArr3[6] & 4294967295L) + (j12 >>> 32);
        iArr3[6] = (int) j13;
        return (int) (j13 >>> 32);
    }

    public static boolean h0(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i8 = 1; i8 < 5; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int i(int i8, int i9, int[] iArr, int[] iArr2) {
        long j4 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            long j8 = (iArr[i10] & 4294967295L) + (4294967295L & iArr2[r7]) + j4;
            iArr2[i9 + i10] = (int) j8;
            j4 = j8 >>> 32;
        }
        return (int) j4;
    }

    public static boolean i0(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i8 = 1; i8 < 7; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int j(int i8, int[] iArr, int i9, int[] iArr2, int i10) {
        long j4 = (iArr[i8] & 4294967295L) + (iArr2[i9] & 4294967295L) + (i10 & 4294967295L);
        iArr2[i9] = (int) j4;
        long j8 = (iArr[i8 + 1] & 4294967295L) + (iArr2[r6] & 4294967295L) + (j4 >>> 32);
        iArr2[i9 + 1] = (int) j8;
        long j9 = (iArr[i8 + 2] & 4294967295L) + (iArr2[r6] & 4294967295L) + (j8 >>> 32);
        iArr2[i9 + 2] = (int) j9;
        long j10 = (iArr[i8 + 3] & 4294967295L) + (iArr2[r6] & 4294967295L) + (j9 >>> 32);
        iArr2[i9 + 3] = (int) j10;
        long j11 = (iArr[i8 + 4] & 4294967295L) + (iArr2[r6] & 4294967295L) + (j10 >>> 32);
        iArr2[i9 + 4] = (int) j11;
        long j12 = (iArr[i8 + 5] & 4294967295L) + (iArr2[r6] & 4294967295L) + (j11 >>> 32);
        iArr2[i9 + 5] = (int) j12;
        long j13 = (iArr[i8 + 6] & 4294967295L) + (4294967295L & iArr2[r11]) + (j12 >>> 32);
        iArr2[i9 + 6] = (int) j13;
        return (int) (j13 >>> 32);
    }

    public static boolean j0(char c3) {
        return Character.isWhitespace(c3) || Character.isSpaceChar(c3);
    }

    public static int k(int i8, int[] iArr, int[] iArr2) {
        long j4 = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            long j8 = (iArr[i9] & 4294967295L) + (4294967295L & iArr2[i9]) + j4;
            iArr2[i9] = (int) j8;
            j4 = j8 >>> 32;
        }
        return (int) j4;
    }

    public static boolean k0(int i8, int[] iArr) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (iArr[i9] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int l(int[] iArr, int[] iArr2) {
        long j4 = (iArr[7] & 4294967295L) + (iArr2[14] & 4294967295L);
        int i8 = (int) j4;
        iArr[7] = i8;
        iArr2[14] = i8;
        long j8 = (iArr[8] & 4294967295L) + (iArr2[15] & 4294967295L) + (j4 >>> 32);
        int i9 = (int) j8;
        iArr[8] = i9;
        iArr2[15] = i9;
        long j9 = (iArr[9] & 4294967295L) + (iArr2[16] & 4294967295L) + (j8 >>> 32);
        int i10 = (int) j9;
        iArr[9] = i10;
        iArr2[16] = i10;
        long j10 = (iArr[10] & 4294967295L) + (iArr2[17] & 4294967295L) + (j9 >>> 32);
        int i11 = (int) j10;
        iArr[10] = i11;
        iArr2[17] = i11;
        long j11 = (iArr[11] & 4294967295L) + (iArr2[18] & 4294967295L) + (j10 >>> 32);
        int i12 = (int) j11;
        iArr[11] = i12;
        iArr2[18] = i12;
        long j12 = (iArr[12] & 4294967295L) + (iArr2[19] & 4294967295L) + (j11 >>> 32);
        int i13 = (int) j12;
        iArr[12] = i13;
        iArr2[19] = i13;
        long j13 = (iArr[13] & 4294967295L) + (4294967295L & iArr2[20]) + (j12 >>> 32);
        int i14 = (int) j13;
        iArr[13] = i14;
        iArr2[20] = i14;
        return (int) (j13 >>> 32);
    }

    public static boolean l0(int[] iArr) {
        for (int i8 = 0; i8 < 5; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void m(int[] iArr, int i8, int i9, int i10) {
        long j4 = (i9 & 4294967295L) + (4294967295L & iArr[i10]);
        iArr[i10] = (int) j4;
        if ((j4 >>> 32) == 0) {
            return;
        }
        d0(i8, i10 + 1, iArr);
    }

    public static boolean m0(int[] iArr) {
        for (int i8 = 0; i8 < 7; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int n(int i8, int i9, int[] iArr) {
        long j4 = (i9 & 4294967295L) + (4294967295L & iArr[0]);
        iArr[0] = (int) j4;
        if ((j4 >>> 32) == 0) {
            return 0;
        }
        return d0(i8, 1, iArr);
    }

    public static int n0(int i8, int[] iArr, int[] iArr2) {
        long j4 = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            j4 = (((iArr[i9] & 4294967295L) - (4294967295L & iArr2[i9])) + j4) >> 32;
        }
        return (int) j4;
    }

    public static void o(StringBuilder sb, Object obj, l lVar) {
        if (lVar != null) {
            sb.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static MappedByteBuffer o0(Context context, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static int p(int i8, int i9, int i10) {
        int i11 = i9 & ((i8 >>> i10) ^ i8);
        return i8 ^ (i11 ^ (i11 << i10));
    }

    public static int p0(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int iNumberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr[length - 1]);
        int i8 = (iNumberOfLeadingZeros + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i8];
        int[] iArr6 = new int[i8];
        int[] iArr7 = new int[i8];
        int[] iArr8 = new int[i8];
        int[] iArr9 = new int[i8];
        iArr6[0] = 1;
        G(iNumberOfLeadingZeros, iArr2, iArr8);
        G(iNumberOfLeadingZeros, iArr, iArr9);
        System.arraycopy(iArr9, 0, iArr7, 0, i8);
        int iF0 = f0(iArr9[0]);
        int i9 = (int) (((iNumberOfLeadingZeros * 150964) + 99243) >>> 16);
        int iA0 = 0;
        for (int i10 = 0; i10 < i9; i10 += 30) {
            iA0 = a0(iArr4, iA0, iArr7[0], iArr8[0]);
            O0(i8, iF0, iArr5, iArr6, iArr4, iArr9);
            P0(iArr7, iArr8, i8, iArr4);
        }
        int i11 = i8 - 1;
        int i12 = iArr7[i11] >> 31;
        u(i8, i12, iArr7);
        int i13 = iArr5[i11] >> 31;
        int i14 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = (((iArr5[i15] + (iArr9[i15] & i13)) ^ i12) - i12) + i14;
            iArr5[i15] = i16 & 1073741823;
            i14 = i16 >> 30;
        }
        int i17 = (((iArr5[i11] + (i13 & iArr9[i11])) ^ i12) - i12) + i14;
        iArr5[i11] = i17;
        int i18 = i17 >> 31;
        int i19 = 0;
        for (int i20 = 0; i20 < i11; i20++) {
            int i21 = iArr5[i20] + (iArr9[i20] & i18) + i19;
            iArr5[i20] = i21 & 1073741823;
            i19 = i21 >> 30;
        }
        iArr5[i11] = iArr5[i11] + (i18 & iArr9[i11]) + i19;
        C(iNumberOfLeadingZeros, iArr5, iArr3);
        return L(i8, 1, iArr7) & L(i8, 0, iArr8);
    }

    public static long q(long j4, int i8, long j8) {
        long j9 = j8 & ((j4 >>> i8) ^ j4);
        return j4 ^ (j9 ^ (j9 << i8));
    }

    public static boolean q0(int[] iArr, int[] iArr2, int[] iArr3) {
        int iNumberOfLeadingZeros;
        int length = iArr.length;
        int i8 = length << 5;
        int i9 = length - 1;
        int iNumberOfLeadingZeros2 = i8 - Integers.numberOfLeadingZeros(iArr[i9]);
        int i10 = (iNumberOfLeadingZeros2 + 29) / 30;
        while (true) {
            if (i9 < 0) {
                iNumberOfLeadingZeros = 0;
                break;
            }
            int i11 = iArr2[i9];
            if (i11 != 0) {
                iNumberOfLeadingZeros = ((i9 * 32) + 32) - Integers.numberOfLeadingZeros(i11);
                break;
            }
            i9--;
        }
        int i12 = iNumberOfLeadingZeros2 - iNumberOfLeadingZeros;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i10];
        int[] iArr6 = new int[i10];
        int[] iArr7 = new int[i10];
        int[] iArr8 = new int[i10];
        int[] iArr9 = new int[i10];
        iArr6[0] = 1;
        G(iNumberOfLeadingZeros2, iArr2, iArr8);
        G(iNumberOfLeadingZeros2, iArr, iArr9);
        System.arraycopy(iArr9, 0, iArr7, 0, i10);
        int iF = -i12;
        int iF0 = f0(iArr9[0]);
        int i13 = (int) (((iNumberOfLeadingZeros2 * 188898) + (iNumberOfLeadingZeros2 < 46 ? 308405 : 181188)) >>> 16);
        int iN0 = i10;
        while (!M(iN0, 0, iArr8)) {
            if (i12 >= i13) {
                return false;
            }
            i12 += 30;
            iF = F(iArr4, iF, iArr7[0], iArr8[0]);
            O0(i10, iF0, iArr5, iArr6, iArr4, iArr9);
            P0(iArr7, iArr8, iN0, iArr4);
            iN0 = N0(iN0, iArr7, iArr8);
        }
        int i14 = iArr7[iN0 - 1] >> 31;
        int iW0 = iArr5[i10 - 1] >> 31;
        if (iW0 < 0) {
            iW0 = d(i10, iArr5, iArr9);
        }
        if (i14 < 0) {
            iW0 = w0(i10, iArr5);
            w0(iN0, iArr7);
        }
        if (!M(iN0, 1, iArr7)) {
            return false;
        }
        if (iW0 < 0) {
            d(i10, iArr5, iArr9);
        }
        C(iNumberOfLeadingZeros2, iArr5, iArr3);
        return true;
    }

    public static void r(int i8) {
        if (2 > i8 || i8 >= 37) {
            StringBuilder sbS = a8.b.s(i8, "radix ", " was not in valid range ");
            sbS.append(new u5.f(2, 36, 1));
            throw new IllegalArgumentException(sbS.toString());
        }
    }

    public static void r0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = iArr2[0] & 4294967295L;
        long j8 = iArr2[1] & 4294967295L;
        long j9 = iArr2[2] & 4294967295L;
        long j10 = iArr2[3] & 4294967295L;
        long j11 = iArr2[4] & 4294967295L;
        long j12 = iArr[0] & 4294967295L;
        int i8 = 1;
        long j13 = j12 * j4;
        iArr3[0] = (int) j13;
        char c3 = ' ';
        long j14 = (j13 >>> 32) + (j12 * j8);
        iArr3[1] = (int) j14;
        long j15 = (j14 >>> 32) + (j12 * j9);
        iArr3[2] = (int) j15;
        long j16 = (j15 >>> 32) + (j12 * j10);
        iArr3[3] = (int) j16;
        long j17 = (j12 * j11) + (j16 >>> 32);
        iArr3[4] = (int) j17;
        int i9 = 5;
        iArr3[5] = (int) (j17 >>> 32);
        while (true) {
            int i10 = i8;
            if (i10 >= i9) {
                return;
            }
            long j18 = iArr[i10] & 4294967295L;
            long j19 = (j18 * j4) + (iArr3[i10] & 4294967295L);
            iArr3[i10] = (int) j19;
            i8 = i10 + 1;
            char c8 = c3;
            long j20 = (j18 * j8) + (iArr3[i8] & 4294967295L) + (j19 >>> c3);
            iArr3[i8] = (int) j20;
            long j21 = j11;
            long j22 = (j18 * j9) + (iArr3[r8] & 4294967295L) + (j20 >>> c8);
            iArr3[i10 + 2] = (int) j22;
            long j23 = j22 >>> c8;
            long j24 = (j18 * j10) + (iArr3[r6] & 4294967295L) + j23;
            iArr3[i10 + 3] = (int) j24;
            long j25 = j24 >>> c8;
            long j26 = (j18 * j21) + (iArr3[r2] & 4294967295L) + j25;
            iArr3[i10 + 4] = (int) j26;
            iArr3[i10 + 5] = (int) (j26 >>> c8);
            c3 = c8;
            j11 = j21;
            i9 = 5;
        }
    }

    public static void s(int[] iArr, int[] iArr2, int[] iArr3) {
        if (p0(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void s0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = iArr2[0] & 4294967295L;
        long j8 = iArr2[1] & 4294967295L;
        long j9 = iArr2[2] & 4294967295L;
        long j10 = iArr2[3] & 4294967295L;
        long j11 = iArr2[4] & 4294967295L;
        long j12 = iArr2[5] & 4294967295L;
        long j13 = iArr2[6] & 4294967295L;
        long j14 = iArr[0] & 4294967295L;
        long j15 = j14 * j4;
        iArr3[0] = (int) j15;
        long j16 = (j14 * j8) + (j15 >>> 32);
        iArr3[1] = (int) j16;
        long j17 = (j14 * j9) + (j16 >>> 32);
        iArr3[2] = (int) j17;
        long j18 = (j14 * j10) + (j17 >>> 32);
        iArr3[3] = (int) j18;
        long j19 = (j14 * j11) + (j18 >>> 32);
        iArr3[4] = (int) j19;
        long j20 = (j14 * j12) + (j19 >>> 32);
        iArr3[5] = (int) j20;
        long j21 = (j14 * j13) + (j20 >>> 32);
        iArr3[6] = (int) j21;
        iArr3[7] = (int) (j21 >>> 32);
        int i8 = 1;
        for (int i9 = 7; i8 < i9; i9 = 7) {
            long j22 = iArr[i8] & 4294967295L;
            long j23 = (j22 * j4) + (iArr3[i8] & 4294967295L);
            iArr3[i8] = (int) j23;
            int i10 = i8 + 1;
            long j24 = j11;
            long j25 = (j22 * j8) + (iArr3[i10] & 4294967295L) + (j23 >>> 32);
            iArr3[i10] = (int) j25;
            long j26 = (j22 * j9) + (iArr3[r7] & 4294967295L) + (j25 >>> 32);
            iArr3[i8 + 2] = (int) j26;
            long j27 = (j22 * j10) + (iArr3[r7] & 4294967295L) + (j26 >>> 32);
            iArr3[i8 + 3] = (int) j27;
            long j28 = (j22 * j24) + (iArr3[r7] & 4294967295L) + (j27 >>> 32);
            iArr3[i8 + 4] = (int) j28;
            long j29 = (j22 * j12) + (iArr3[r7] & 4294967295L) + (j28 >>> 32);
            iArr3[i8 + 5] = (int) j29;
            long j30 = (j22 * j13) + (iArr3[r7] & 4294967295L) + (j29 >>> 32);
            iArr3[i8 + 6] = (int) j30;
            iArr3[i8 + 7] = (int) (j30 >>> 32);
            i8 = i10;
            j11 = j24;
        }
    }

    public static int t(int i8, int i9, int i10) {
        return i8 < i9 ? i9 : i8 > i10 ? i10 : i8;
    }

    public static int t0(int[] iArr, int[] iArr2, int[] iArr3) {
        int i8 = 0;
        long j4 = 4294967295L;
        long j8 = iArr2[0] & 4294967295L;
        long j9 = iArr2[1] & 4294967295L;
        long j10 = iArr2[2] & 4294967295L;
        long j11 = iArr2[3] & 4294967295L;
        long j12 = iArr2[4] & 4294967295L;
        long j13 = 0;
        while (i8 < 5) {
            long j14 = j4;
            long j15 = iArr[i8] & j14;
            int i9 = i8;
            long j16 = (j15 * j8) + (iArr3[i8] & j14);
            iArr3[i9] = (int) j16;
            int i10 = i9 + 1;
            long j17 = (j15 * j9) + (iArr3[i10] & j14) + (j16 >>> 32);
            iArr3[i10] = (int) j17;
            long j18 = (j15 * j10) + (iArr3[r15] & j14) + (j17 >>> 32);
            iArr3[i9 + 2] = (int) j18;
            long j19 = (j15 * j11) + (iArr3[r2] & j14) + (j18 >>> 32);
            iArr3[i9 + 3] = (int) j19;
            long j20 = (j15 * j12) + (iArr3[r2] & j14) + (j19 >>> 32);
            iArr3[i9 + 4] = (int) j20;
            long j21 = (j20 >>> 32) + (iArr3[r2] & j14) + j13;
            iArr3[i9 + 5] = (int) j21;
            j13 = j21 >>> 32;
            j4 = j14;
            j8 = j8;
            i8 = i10;
        }
        return (int) j13;
    }

    public static void u(int i8, int i9, int[] iArr) {
        int i10 = i8 - 1;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = ((iArr[i12] ^ i9) - i9) + i11;
            iArr[i12] = 1073741823 & i13;
            i11 = i13 >> 30;
        }
        iArr[i10] = ((iArr[i10] ^ i9) - i9) + i11;
    }

    public static int u0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = iArr2[0] & 4294967295L;
        long j8 = iArr2[1] & 4294967295L;
        long j9 = iArr2[2] & 4294967295L;
        long j10 = iArr2[3] & 4294967295L;
        long j11 = iArr2[4] & 4294967295L;
        long j12 = iArr2[5] & 4294967295L;
        long j13 = iArr2[6] & 4294967295L;
        long j14 = 0;
        int i8 = 0;
        while (i8 < 7) {
            long j15 = j13;
            long j16 = iArr[i8] & 4294967295L;
            long j17 = (iArr3[i8] & 4294967295L) + (j16 * j4);
            iArr3[i8] = (int) j17;
            int i9 = i8 + 1;
            long j18 = (j16 * j8) + (iArr3[i9] & 4294967295L) + (j17 >>> 32);
            iArr3[i9] = (int) j18;
            long j19 = (j16 * j9) + (iArr3[r15] & 4294967295L) + (j18 >>> 32);
            int i10 = i8;
            iArr3[i8 + 2] = (int) j19;
            long j20 = (j16 * j10) + (iArr3[r2] & 4294967295L) + (j19 >>> 32);
            iArr3[i10 + 3] = (int) j20;
            long j21 = (j16 * j11) + (iArr3[r2] & 4294967295L) + (j20 >>> 32);
            iArr3[i10 + 4] = (int) j21;
            long j22 = (j16 * j12) + (iArr3[r2] & 4294967295L) + (j21 >>> 32);
            iArr3[i10 + 5] = (int) j22;
            long j23 = (j16 * j15) + (iArr3[r2] & 4294967295L) + (j22 >>> 32);
            iArr3[i10 + 6] = (int) j23;
            long j24 = (j23 >>> 32) + (iArr3[r2] & 4294967295L) + j14;
            iArr3[i10 + 7] = (int) j24;
            j14 = j24 >>> 32;
            i8 = i9;
            j13 = j15;
        }
        return (int) j14;
    }

    public static void v(int i8, int[] iArr, int[] iArr2) {
        iArr2[i8] = iArr[0];
        iArr2[i8 + 1] = iArr[1];
        iArr2[i8 + 2] = iArr[2];
        iArr2[i8 + 3] = iArr[3];
        iArr2[i8 + 4] = iArr[4];
    }

    public static int v0(int i8, int[] iArr, int i9, int[] iArr2, int i10) {
        long j4 = i9 & 4294967295L;
        long j8 = 0;
        int i11 = 0;
        do {
            long j9 = ((iArr[i11] & 4294967295L) * j4) + (iArr2[r8] & 4294967295L) + j8;
            iArr2[i10 + i11] = (int) j9;
            j8 = j9 >>> 32;
            i11++;
        } while (i11 < i8);
        return (int) j8;
    }

    public static void w(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static int w0(int i8, int[] iArr) {
        int i9 = i8 - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = i10 - iArr[i11];
            iArr[i11] = 1073741823 & i12;
            i10 = i12 >> 30;
        }
        int i13 = i10 - iArr[i9];
        iArr[i9] = i13;
        return i13 >> 30;
    }

    public static void x(int i8, int[] iArr, int[] iArr2) {
        iArr2[i8] = iArr[0];
        iArr2[i8 + 1] = iArr[1];
        iArr2[i8 + 2] = iArr[2];
        iArr2[i8 + 3] = iArr[3];
        iArr2[i8 + 4] = iArr[4];
        iArr2[i8 + 5] = iArr[5];
        iArr2[i8 + 6] = iArr[6];
    }

    public static int x0(int i8, int i9, int[] iArr, int[] iArr2) {
        int i10 = 0;
        while (i10 < i8) {
            int i11 = iArr[i10];
            iArr2[i10] = (i9 >>> 31) | (i11 << 1);
            i10++;
            i9 = i11;
        }
        return i9 >>> 31;
    }

    public static void y(int i8, long[] jArr, long[] jArr2) {
        jArr2[i8] = jArr[0];
        jArr2[i8 + 1] = jArr[1];
        jArr2[i8 + 2] = jArr[2];
        jArr2[i8 + 3] = jArr[3];
        jArr2[i8 + 4] = jArr[4];
    }

    public static int y0(int i8, int[] iArr) {
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int i11 = iArr[i9];
            iArr[i9] = (i10 >>> (-2)) | (i11 << 2);
            i9++;
            i10 = i11;
        }
        return i10 >>> (-2);
    }

    public static void z(int i8, long[] jArr, long[] jArr2) {
        jArr2[i8] = jArr[0];
        jArr2[i8 + 1] = jArr[1];
        jArr2[i8 + 2] = jArr[2];
        jArr2[i8 + 3] = jArr[3];
        jArr2[i8 + 4] = jArr[4];
        jArr2[i8 + 5] = jArr[5];
        jArr2[i8 + 6] = jArr[6];
    }

    public static int z0(int i8, int[] iArr, int[] iArr2) {
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int i11 = iArr[i9];
            iArr2[i9] = (i10 >>> (-3)) | (i11 << 3);
            i9++;
            i10 = i11;
        }
        return i10 >>> (-3);
    }
}
