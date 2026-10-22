package x;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import b5.r;
import b5.u;
import j6.k;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import kotlin.jvm.internal.p;
import org.bouncycastle.util.Pack;
import x5.j;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {
    public static boolean A(long[] jArr, long[] jArr2) {
        for (int i8 = 3; i8 >= 0; i8--) {
            if (jArr[i8] != jArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    public static long A0(long j4) {
        return f.q(f.q(f.q(f.q(f.q(j4, 1, 2459565876494606882L), 2, 868082074056920076L), 4, 67555025218437360L), 8, 280375465148160L), 16, 4294901760L);
    }

    public static long B(int i8) {
        return (((r6 >>> 1) & 1431655765) << 32) | (1431655765 & f.p(f.p(f.p(f.p(i8, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1));
    }

    public static final void B0(int i8, String str, String str2) {
        StringBuilder sbU = a8.b.u("Expected ", i8, str2, " at index ", ", but was '");
        sbU.append(str.charAt(i8));
        sbU.append('\'');
        throw new IllegalArgumentException(sbU.toString());
    }

    public static void C(int i8, long j4, long[] jArr) {
        long jQ = f.q(f.q(f.q(f.q(f.q(j4, 16, 4294901760L), 8, 280375465148160L), 4, 67555025218437360L), 2, 868082074056920076L), 1, 2459565876494606882L);
        jArr[i8] = jQ & 6148914691236517205L;
        jArr[i8 + 1] = (jQ >>> 1) & 6148914691236517205L;
    }

    public static void C0(j6.a aVar, byte[] buffer) {
        int length = buffer.length;
        p.e(buffer, "buffer");
        aVar.s(buffer, length);
    }

    public static void D(int i8, long[] jArr, long[] jArr2) {
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            C(i9, jArr[i10], jArr2);
            i9 += 2;
        }
    }

    public static void D0(j6.a aVar, String text) {
        int length = text.length();
        Charset charset = x5.a.f6276a;
        p.e(text, "text");
        p.e(charset, "charset");
        k.i(aVar, text.toString(), 0, length);
    }

    public static void E(int i8, long j4, long[] jArr) {
        long jQ = f.q(f.q(f.q(f.q(f.q(j4, 16, 4294901760L), 8, 280375465148160L), 4, 67555025218437360L), 2, 868082074056920076L), 1, 2459565876494606882L);
        jArr[i8] = jQ & (-6148914691236517206L);
        jArr[i8 + 1] = (jQ << 1) & (-6148914691236517206L);
    }

    public static Font F(FontFamily fontFamily, int i8) {
        FontStyle fontStyle = new FontStyle((i8 & 1) != 0 ? 700 : 400, (i8 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iM = M(fontStyle, font.getStyle());
        for (int i9 = 1; i9 < fontFamily.getSize(); i9++) {
            Font font2 = fontFamily.getFont(i9);
            int iM2 = M(fontStyle, font2.getStyle());
            if (iM2 < iM) {
                font = font2;
                iM = iM2;
            }
        }
        return font;
    }

    public static final void G(long j4, byte[] bArr, int i8, int i9, int i10) {
        int i11 = 7 - i9;
        int i12 = 8 - i10;
        if (i12 > i11) {
            return;
        }
        while (true) {
            int i13 = x5.e.f6287a[(int) ((j4 >> (i11 << 3)) & 255)];
            int i14 = i8 + 1;
            bArr[i8] = (byte) (i13 >> 8);
            i8 += 2;
            bArr[i14] = (byte) i13;
            if (i11 == i12) {
                return;
            } else {
                i11--;
            }
        }
    }

    public static int[] H(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[6];
        for (int i8 = 0; i8 < 6; i8++) {
            iArr[i8] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static int[] I(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[8];
        for (int i8 = 0; i8 < 8; i8++) {
            iArr[i8] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static int J(int[] iArr) {
        return iArr[0] & 1;
    }

    public static int K(int[] iArr) {
        return iArr[0] & 1;
    }

    public static int M(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    public static boolean N(int[] iArr, int[] iArr2) {
        for (int i8 = 3; i8 >= 0; i8--) {
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

    public static boolean O(int[] iArr, int[] iArr2) {
        for (int i8 = 5; i8 >= 0; i8--) {
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

    public static boolean P(int[] iArr, int[] iArr2) {
        for (int i8 = 7; i8 >= 0; i8--) {
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

    public static boolean Q(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i8 = 1; i8 < 4; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean R(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i8 = 1; i8 < 6; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean S(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i8 = 1; i8 < 8; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean T(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i8 = 1; i8 < 4; i8++) {
            if (jArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean U(int[] iArr) {
        for (int i8 = 0; i8 < 4; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean V(int[] iArr) {
        for (int i8 = 0; i8 < 6; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean W(int[] iArr) {
        for (int i8 = 0; i8 < 8; i8++) {
            if (iArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean X(long[] jArr) {
        for (int i8 = 0; i8 < 3; i8++) {
            if (jArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean Y(long[] jArr) {
        for (int i8 = 0; i8 < 4; i8++) {
            if (jArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean Z(long[] jArr) {
        for (int i8 = 0; i8 < 9; i8++) {
            if (jArr[i8] != 0) {
                return false;
            }
        }
        return true;
    }

    public static final j a(Matcher matcher, int i8, CharSequence charSequence) {
        if (matcher.find(i8)) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    public static void a0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = 4294967295L;
        long j8 = iArr2[0] & 4294967295L;
        int i8 = 1;
        long j9 = iArr2[1] & 4294967295L;
        long j10 = iArr2[2] & 4294967295L;
        long j11 = iArr2[3] & 4294967295L;
        long j12 = iArr[0] & 4294967295L;
        long j13 = j12 * j8;
        iArr3[0] = (int) j13;
        long j14 = (j12 * j9) + (j13 >>> 32);
        iArr3[1] = (int) j14;
        long j15 = (j12 * j10) + (j14 >>> 32);
        iArr3[2] = (int) j15;
        long j16 = (j12 * j11) + (j15 >>> 32);
        iArr3[3] = (int) j16;
        iArr3[4] = (int) (j16 >>> 32);
        for (int i9 = 4; i8 < i9; i9 = 4) {
            long j17 = iArr[i8] & j4;
            long j18 = (j17 * j8) + (iArr3[i8] & j4);
            iArr3[i8] = (int) j18;
            int i10 = i8 + 1;
            long j19 = j4;
            long j20 = (j17 * j9) + (iArr3[i10] & j19) + (j18 >>> 32);
            iArr3[i10] = (int) j20;
            long j21 = (j17 * j10) + (iArr3[r11] & j19) + (j20 >>> 32);
            iArr3[i8 + 2] = (int) j21;
            long j22 = j21 >>> 32;
            long j23 = (j17 * j11) + (iArr3[r3] & j19) + j22;
            iArr3[i8 + 3] = (int) j23;
            iArr3[i8 + 4] = (int) (j23 >>> 32);
            i8 = i10;
            j4 = j19;
        }
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
        long j12 = (iArr[5] & 4294967295L) + (iArr2[5] & 4294967295L) + (j11 >>> 32);
        iArr3[5] = (int) j12;
        return (int) (j12 >>> 32);
    }

    public static void b0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = iArr2[0] & 4294967295L;
        long j8 = iArr2[1] & 4294967295L;
        long j9 = iArr2[2] & 4294967295L;
        long j10 = iArr2[3] & 4294967295L;
        long j11 = iArr2[4] & 4294967295L;
        long j12 = iArr2[5] & 4294967295L;
        int i8 = 1;
        long j13 = iArr[0] & 4294967295L;
        long j14 = j13 * j4;
        iArr3[0] = (int) j14;
        long j15 = (j13 * j8) + (j14 >>> 32);
        iArr3[1] = (int) j15;
        long j16 = (j13 * j9) + (j15 >>> 32);
        iArr3[2] = (int) j16;
        long j17 = (j13 * j10) + (j16 >>> 32);
        iArr3[3] = (int) j17;
        long j18 = (j13 * j11) + (j17 >>> 32);
        iArr3[4] = (int) j18;
        long j19 = (j13 * j12) + (j18 >>> 32);
        iArr3[5] = (int) j19;
        int i9 = 6;
        iArr3[6] = (int) (j19 >>> 32);
        while (true) {
            int i10 = i8;
            if (i10 >= i9) {
                return;
            }
            long j20 = iArr[i10] & 4294967295L;
            long j21 = (j20 * j4) + (iArr3[i10] & 4294967295L);
            iArr3[i10] = (int) j21;
            i8 = i10 + 1;
            long j22 = j11;
            long j23 = (j20 * j8) + (iArr3[i8] & 4294967295L) + (j21 >>> 32);
            iArr3[i8] = (int) j23;
            long j24 = (j20 * j9) + (iArr3[r5] & 4294967295L) + (j23 >>> 32);
            iArr3[i10 + 2] = (int) j24;
            long j25 = (j20 * j10) + (iArr3[r5] & 4294967295L) + (j24 >>> 32);
            iArr3[i10 + 3] = (int) j25;
            long j26 = (j20 * j22) + (iArr3[r5] & 4294967295L) + (j25 >>> 32);
            iArr3[i10 + 4] = (int) j26;
            long j27 = (j20 * j12) + (iArr3[r5] & 4294967295L) + (j26 >>> 32);
            iArr3[i10 + 5] = (int) j27;
            iArr3[i10 + 6] = (int) (j27 >>> 32);
            j11 = j22;
            i9 = 6;
        }
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
        long j14 = (iArr[7] & 4294967295L) + (iArr2[7] & 4294967295L) + (j13 >>> 32);
        iArr3[7] = (int) j14;
        return (int) (j14 >>> 32);
    }

    public static void c0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = iArr2[0] & 4294967295L;
        long j8 = iArr2[1] & 4294967295L;
        long j9 = iArr2[2] & 4294967295L;
        long j10 = iArr2[3] & 4294967295L;
        long j11 = iArr2[4] & 4294967295L;
        long j12 = iArr2[5] & 4294967295L;
        long j13 = iArr2[6] & 4294967295L;
        long j14 = iArr2[7] & 4294967295L;
        long j15 = iArr[0] & 4294967295L;
        long j16 = j15 * j4;
        iArr3[0] = (int) j16;
        long j17 = (j15 * j8) + (j16 >>> 32);
        iArr3[1] = (int) j17;
        long j18 = (j15 * j9) + (j17 >>> 32);
        iArr3[2] = (int) j18;
        long j19 = (j15 * j10) + (j18 >>> 32);
        iArr3[3] = (int) j19;
        long j20 = (j15 * j11) + (j19 >>> 32);
        iArr3[4] = (int) j20;
        long j21 = (j15 * j12) + (j20 >>> 32);
        iArr3[5] = (int) j21;
        long j22 = (j15 * j13) + (j21 >>> 32);
        iArr3[6] = (int) j22;
        long j23 = (j15 * j14) + (j22 >>> 32);
        iArr3[7] = (int) j23;
        int i8 = (int) (j23 >>> 32);
        iArr3[8] = i8;
        int i9 = 1;
        for (int i10 = 8; i9 < i10; i10 = 8) {
            long j24 = iArr[i9] & 4294967295L;
            long j25 = j11;
            long j26 = (j24 * j4) + (iArr3[i9] & 4294967295L);
            iArr3[i9] = (int) j26;
            int i11 = i9 + 1;
            long j27 = (j24 * j8) + (iArr3[i11] & 4294967295L) + (j26 >>> 32);
            iArr3[i11] = (int) j27;
            long j28 = (j24 * j9) + (iArr3[r25] & 4294967295L) + (j27 >>> 32);
            iArr3[i9 + 2] = (int) j28;
            long j29 = (j24 * j10) + (iArr3[r25] & 4294967295L) + (j28 >>> 32);
            iArr3[i9 + 3] = (int) j29;
            long j30 = (j24 * j25) + (iArr3[r25] & 4294967295L) + (j29 >>> 32);
            iArr3[i9 + 4] = (int) j30;
            long j31 = (j24 * j12) + (iArr3[r25] & 4294967295L) + (j30 >>> 32);
            iArr3[i9 + 5] = (int) j31;
            long j32 = (j24 * j13) + (iArr3[r25] & 4294967295L) + (j31 >>> 32);
            iArr3[i9 + 6] = (int) j32;
            long j33 = j32 >>> 32;
            long j34 = (j24 * j14) + (iArr3[r14] & 4294967295L) + j33;
            iArr3[i9 + 7] = (int) j34;
            iArr3[i9 + 8] = (int) (j34 >>> 32);
            i9 = i11;
            j11 = j25;
        }
    }

    public static int d(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + (iArr3[0] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L) + (iArr3[1] & 4294967295L) + (j4 >>> 32);
        iArr3[1] = (int) j8;
        long j9 = (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L) + (iArr3[2] & 4294967295L) + (j8 >>> 32);
        iArr3[2] = (int) j9;
        long j10 = (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L) + (iArr3[3] & 4294967295L) + (j9 >>> 32);
        iArr3[3] = (int) j10;
        return (int) (j10 >>> 32);
    }

    public static void d0(int[] iArr, int[] iArr2, int[] iArr3) {
        b0(iArr, iArr2, iArr3);
        long j4 = iArr2[6] & 4294967295L;
        long j8 = iArr2[7] & 4294967295L;
        long j9 = iArr2[8] & 4294967295L;
        long j10 = iArr2[9] & 4294967295L;
        long j11 = iArr2[10] & 4294967295L;
        long j12 = iArr2[11] & 4294967295L;
        long j13 = iArr[6] & 4294967295L;
        long j14 = j13 * j4;
        iArr3[12] = (int) j14;
        long j15 = (j13 * j8) + (j14 >>> 32);
        iArr3[13] = (int) j15;
        long j16 = (j13 * j9) + (j15 >>> 32);
        iArr3[14] = (int) j16;
        long j17 = (j13 * j10) + (j16 >>> 32);
        iArr3[15] = (int) j17;
        long j18 = (j13 * j11) + (j17 >>> 32);
        iArr3[16] = (int) j18;
        long j19 = (j13 * j12) + (j18 >>> 32);
        iArr3[17] = (int) j19;
        iArr3[18] = (int) (j19 >>> 32);
        int i8 = 12;
        int i9 = 1;
        while (i9 < 6) {
            int i10 = i8 + 1;
            int i11 = i9;
            long j20 = iArr[6 + i9] & 4294967295L;
            long j21 = j9;
            long j22 = (j20 * j4) + (iArr3[i10] & 4294967295L);
            iArr3[i10] = (int) j22;
            long j23 = (j20 * j8) + (iArr3[r5] & 4294967295L) + (j22 >>> 32);
            iArr3[i8 + 2] = (int) j23;
            long j24 = (j20 * j21) + (iArr3[r5] & 4294967295L) + (j23 >>> 32);
            iArr3[i8 + 3] = (int) j24;
            long j25 = (j20 * j10) + (iArr3[r5] & 4294967295L) + (j24 >>> 32);
            iArr3[i8 + 4] = (int) j25;
            long j26 = (j20 * j11) + (iArr3[r5] & 4294967295L) + (j25 >>> 32);
            iArr3[i8 + 5] = (int) j26;
            long j27 = (j20 * j12) + (iArr3[r5] & 4294967295L) + (j26 >>> 32);
            iArr3[i8 + 6] = (int) j27;
            iArr3[i8 + 7] = (int) (j27 >>> 32);
            i9 = i11 + 1;
            i8 = i10;
            j9 = j21;
        }
        int i12 = i(iArr3, iArr3);
        int iG = g(18, iArr3, 12, iArr3, g(0, iArr3, 6, iArr3, 0) + i12) + i12;
        int[] iArr4 = new int[6];
        int[] iArr5 = new int[6];
        boolean z = v(iArr, iArr, iArr4) != v(iArr2, iArr2, iArr5);
        int[] iArr6 = new int[12];
        b0(iArr4, iArr5, iArr6);
        f.m(iArr3, 24, iG + (z ? f.i(12, 6, iArr6, iArr3) : f.H0(12, 6, iArr6, iArr3)), 18);
    }

    public static int e(int[] iArr, int[] iArr2, int[] iArr3) {
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
        return (int) (j12 >>> 32);
    }

    public static int e0(int[] iArr, int[] iArr2, int[] iArr3) {
        int i8 = 0;
        long j4 = iArr2[0] & 4294967295L;
        long j8 = iArr2[1] & 4294967295L;
        long j9 = iArr2[2] & 4294967295L;
        long j10 = iArr2[3] & 4294967295L;
        long j11 = iArr2[4] & 4294967295L;
        long j12 = iArr2[5] & 4294967295L;
        long j13 = 0;
        while (i8 < 6) {
            long j14 = j4;
            int i9 = i8;
            long j15 = iArr[i8] & 4294967295L;
            long j16 = (iArr3[i9] & 4294967295L) + (j15 * j14);
            iArr3[i9] = (int) j16;
            int i10 = i9 + 1;
            long j17 = (j15 * j8) + (iArr3[i10] & 4294967295L) + (j16 >>> 32);
            iArr3[i10] = (int) j17;
            long j18 = (j15 * j9) + (iArr3[r15] & 4294967295L) + (j17 >>> 32);
            iArr3[i9 + 2] = (int) j18;
            long j19 = (j15 * j10) + (iArr3[r2] & 4294967295L) + (j18 >>> 32);
            iArr3[i9 + 3] = (int) j19;
            long j20 = (j15 * j11) + (iArr3[r2] & 4294967295L) + (j19 >>> 32);
            iArr3[i9 + 4] = (int) j20;
            long j21 = (j15 * j12) + (iArr3[r2] & 4294967295L) + (j20 >>> 32);
            iArr3[i9 + 5] = (int) j21;
            long j22 = (j21 >>> 32) + (iArr3[r2] & 4294967295L) + j13;
            iArr3[i9 + 6] = (int) j22;
            j13 = j22 >>> 32;
            i8 = i10;
            j4 = j14;
        }
        return (int) j13;
    }

    public static int f(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j14 = (iArr[7] & 4294967295L) + (iArr2[7] & 4294967295L) + (iArr3[7] & 4294967295L) + (j13 >>> 32);
        iArr3[7] = (int) j14;
        return (int) (j14 >>> 32);
    }

    public static int f0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = iArr2[0] & 4294967295L;
        long j8 = iArr2[1] & 4294967295L;
        long j9 = iArr2[2] & 4294967295L;
        long j10 = iArr2[3] & 4294967295L;
        long j11 = iArr2[4] & 4294967295L;
        long j12 = iArr2[5] & 4294967295L;
        long j13 = iArr2[6] & 4294967295L;
        long j14 = iArr2[7] & 4294967295L;
        long j15 = 0;
        int i8 = 0;
        while (i8 < 8) {
            long j16 = iArr[i8] & 4294967295L;
            long j17 = (j16 * j4) + (iArr3[i8] & 4294967295L);
            int i9 = i8;
            iArr3[i9] = (int) j17;
            int i10 = i9 + 1;
            long j18 = (j16 * j8) + (iArr3[i10] & 4294967295L) + (j17 >>> 32);
            iArr3[i10] = (int) j18;
            long j19 = (j16 * j9) + (iArr3[r4] & 4294967295L) + (j18 >>> 32);
            iArr3[i9 + 2] = (int) j19;
            long j20 = (j16 * j10) + (iArr3[r4] & 4294967295L) + (j19 >>> 32);
            iArr3[i9 + 3] = (int) j20;
            long j21 = (j16 * j11) + (iArr3[r4] & 4294967295L) + (j20 >>> 32);
            iArr3[i9 + 4] = (int) j21;
            long j22 = (j16 * j12) + (iArr3[r4] & 4294967295L) + (j21 >>> 32);
            iArr3[i9 + 5] = (int) j22;
            long j23 = (j16 * j13) + (iArr3[r4] & 4294967295L) + (j22 >>> 32);
            iArr3[i9 + 6] = (int) j23;
            long j24 = (j16 * j14) + (iArr3[r4] & 4294967295L) + (j23 >>> 32);
            iArr3[i9 + 7] = (int) j24;
            long j25 = (j24 >>> 32) + (iArr3[r4] & 4294967295L) + j15;
            iArr3[i9 + 8] = (int) j25;
            j15 = j25 >>> 32;
            i8 = i10;
        }
        return (int) j15;
    }

    public static int g(int i8, int[] iArr, int i9, int[] iArr2, int i10) {
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
        long j12 = (iArr[i8 + 5] & 4294967295L) + (4294967295L & iArr2[r11]) + (j11 >>> 32);
        iArr2[i9 + 5] = (int) j12;
        return (int) (j12 >>> 32);
    }

    public static String g0(j6.j jVar, Charset charset) {
        p.e(jVar, "<this>");
        p.e(charset, "charset");
        return charset.equals(x5.a.f6276a) ? k.g(jVar) : u(charset.newDecoder(), jVar);
    }

    public static int h(int i8, int[] iArr, int i9, int[] iArr2, int i10) {
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
        long j13 = (iArr[i8 + 6] & 4294967295L) + (iArr2[r6] & 4294967295L) + (j12 >>> 32);
        iArr2[i9 + 6] = (int) j13;
        long j14 = (iArr[i8 + 7] & 4294967295L) + (4294967295L & iArr2[r11]) + (j13 >>> 32);
        iArr2[i9 + 7] = (int) j14;
        return (int) (j14 >>> 32);
    }

    public static void h0(int[] iArr, int[] iArr2) {
        long j4 = iArr[0] & 4294967295L;
        int i8 = 8;
        int i9 = 0;
        int i10 = 3;
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
                int i14 = i13 >>> 31;
                long j14 = iArr[2] & 4294967295L;
                long j15 = (j14 * j4) + (iArr2[2] & 4294967295L) + (j13 >>> 32);
                int i15 = (int) j15;
                iArr2[2] = i14 | (i15 << 1);
                long jH = a8.b.h(j14, j12, j15 >>> 32, iArr2[3] & 4294967295L);
                long j16 = (iArr2[4] & 4294967295L) + (jH >>> 32);
                long j17 = iArr[3] & 4294967295L;
                long j18 = (iArr2[5] & 4294967295L) + (j16 >>> 32);
                long j19 = (j4 * j17) + (jH & 4294967295L);
                int i16 = (int) j19;
                iArr2[3] = (i15 >>> 31) | (i16 << 1);
                long jH2 = a8.b.h(j17, j12, j19 >>> 32, j16 & 4294967295L);
                long jH3 = a8.b.h(j17, j14, jH2 >>> 32, j18 & 4294967295L);
                long j20 = (iArr2[6] & 4294967295L) + (j18 >>> 32) + (jH3 >>> 32);
                int i17 = (int) jH2;
                iArr2[4] = (i16 >>> 31) | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) (jH3 & 4294967295L);
                iArr2[5] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j20;
                iArr2[6] = i20 | (i21 << 1);
                iArr2[7] = (i21 >>> 31) | ((iArr2[7] + ((int) (j20 >>> 32))) << 1);
                return;
            }
            i10 = i11;
        }
    }

    public static int i(int[] iArr, int[] iArr2) {
        long j4 = (iArr[6] & 4294967295L) + (iArr2[12] & 4294967295L);
        int i8 = (int) j4;
        iArr[6] = i8;
        iArr2[12] = i8;
        long j8 = (iArr[7] & 4294967295L) + (iArr2[13] & 4294967295L) + (j4 >>> 32);
        int i9 = (int) j8;
        iArr[7] = i9;
        iArr2[13] = i9;
        long j9 = (iArr[8] & 4294967295L) + (iArr2[14] & 4294967295L) + (j8 >>> 32);
        int i10 = (int) j9;
        iArr[8] = i10;
        iArr2[14] = i10;
        long j10 = (iArr[9] & 4294967295L) + (iArr2[15] & 4294967295L) + (j9 >>> 32);
        int i11 = (int) j10;
        iArr[9] = i11;
        iArr2[15] = i11;
        long j11 = (iArr[10] & 4294967295L) + (iArr2[16] & 4294967295L) + (j10 >>> 32);
        int i12 = (int) j11;
        iArr[10] = i12;
        iArr2[16] = i12;
        long j12 = (iArr[11] & 4294967295L) + (4294967295L & iArr2[17]) + (j11 >>> 32);
        int i13 = (int) j12;
        iArr[11] = i13;
        iArr2[17] = i13;
        return (int) (j12 >>> 32);
    }

    public static void i0(int[] iArr, int[] iArr2) {
        long j4 = iArr[0] & 4294967295L;
        int i8 = 12;
        int i9 = 0;
        int i10 = 5;
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
                long jH10 = a8.b.h(j31, j24, jH9 >>> 32, j35);
                long j37 = j34 + (jH10 >>> 32);
                int i21 = (int) jH7;
                iArr2[6] = (i21 << 1) | i20;
                int i22 = (int) jH8;
                iArr2[7] = (i21 >>> 31) | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) jH9;
                iArr2[8] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) jH10;
                iArr2[9] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j37;
                iArr2[10] = i27 | (i28 << 1);
                iArr2[11] = ((iArr2[11] + ((int) (j37 >>> 32))) << 1) | (i28 >>> 31);
                return;
            }
            i10 = i11;
        }
    }

    public static int j(int[] iArr, int[] iArr2) {
        long j4 = (iArr[8] & 4294967295L) + (iArr2[16] & 4294967295L);
        int i8 = (int) j4;
        iArr[8] = i8;
        iArr2[16] = i8;
        long j8 = (iArr[9] & 4294967295L) + (iArr2[17] & 4294967295L) + (j4 >>> 32);
        int i9 = (int) j8;
        iArr[9] = i9;
        iArr2[17] = i9;
        long j9 = (iArr[10] & 4294967295L) + (iArr2[18] & 4294967295L) + (j8 >>> 32);
        int i10 = (int) j9;
        iArr[10] = i10;
        iArr2[18] = i10;
        long j10 = (iArr[11] & 4294967295L) + (iArr2[19] & 4294967295L) + (j9 >>> 32);
        int i11 = (int) j10;
        iArr[11] = i11;
        iArr2[19] = i11;
        long j11 = (iArr[12] & 4294967295L) + (iArr2[20] & 4294967295L) + (j10 >>> 32);
        int i12 = (int) j11;
        iArr[12] = i12;
        iArr2[20] = i12;
        long j12 = (iArr[13] & 4294967295L) + (iArr2[21] & 4294967295L) + (j11 >>> 32);
        int i13 = (int) j12;
        iArr[13] = i13;
        iArr2[21] = i13;
        long j13 = (iArr[14] & 4294967295L) + (iArr2[22] & 4294967295L) + (j12 >>> 32);
        int i14 = (int) j13;
        iArr[14] = i14;
        iArr2[22] = i14;
        long j14 = (iArr[15] & 4294967295L) + (4294967295L & iArr2[23]) + (j13 >>> 32);
        int i15 = (int) j14;
        iArr[15] = i15;
        iArr2[23] = i15;
        return (int) (j14 >>> 32);
    }

    public static void j0(int[] iArr, int[] iArr2) {
        long j4 = iArr[0] & 4294967295L;
        int i8 = 16;
        int i9 = 0;
        int i10 = 7;
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
                long j24 = jH3 & 4294967295L;
                long j25 = iArr[4] & 4294967295L;
                long j26 = (iArr2[7] & 4294967295L) + (j23 >>> 32);
                long j27 = (iArr2[8] & 4294967295L) + (j26 >>> 32);
                long j28 = j26 & 4294967295L;
                long j29 = (j25 * j4) + (jH2 & 4294967295L);
                int i17 = (int) j29;
                iArr2[4] = i16 | (i17 << 1);
                long jH4 = a8.b.h(j25, j12, j29 >>> 32, j24);
                long jH5 = a8.b.h(j25, j14, jH4 >>> 32, j23 & 4294967295L);
                long jH6 = a8.b.h(j25, j17, jH5 >>> 32, j28);
                long j30 = jH5 & 4294967295L;
                long j31 = j27 + (jH6 >>> 32);
                long j32 = jH6 & 4294967295L;
                long j33 = iArr[5] & 4294967295L;
                long j34 = (iArr2[9] & 4294967295L) + (j31 >>> 32);
                long j35 = (j33 * j4) + (jH4 & 4294967295L);
                int i18 = (int) j35;
                iArr2[5] = (i17 >>> 31) | (i18 << 1);
                int i19 = i18 >>> 31;
                long jH7 = a8.b.h(j33, j12, j35 >>> 32, j30);
                long jH8 = a8.b.h(j33, j14, jH7 >>> 32, j32);
                long jH9 = a8.b.h(j33, j17, jH8 >>> 32, j31 & 4294967295L);
                long j36 = jH8 & 4294967295L;
                long jH10 = a8.b.h(j33, j25, jH9 >>> 32, j34 & 4294967295L);
                long j37 = jH9 & 4294967295L;
                long j38 = (iArr2[10] & 4294967295L) + (j34 >>> 32) + (jH10 >>> 32);
                long j39 = iArr[6] & 4294967295L;
                long j40 = (iArr2[11] & 4294967295L) + (j38 >>> 32);
                long j41 = (iArr2[12] & 4294967295L) + (j40 >>> 32);
                long j42 = (j39 * j4) + (jH7 & 4294967295L);
                int i20 = (int) j42;
                iArr2[6] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                long jH11 = a8.b.h(j39, j12, j42 >>> 32, j36);
                long jH12 = a8.b.h(j39, j14, jH11 >>> 32, j37);
                long jH13 = a8.b.h(j39, j17, jH12 >>> 32, jH10 & 4294967295L);
                long j43 = jH12 & 4294967295L;
                long jH14 = a8.b.h(j39, j25, jH13 >>> 32, j38 & 4294967295L);
                long j44 = jH13 & 4294967295L;
                long jH15 = a8.b.h(j39, j33, jH14 >>> 32, j40 & 4294967295L);
                long j45 = j41 + (jH15 >>> 32);
                long j46 = iArr[7] & 4294967295L;
                long j47 = (iArr2[13] & 4294967295L) + (j45 >>> 32);
                long j48 = (iArr2[14] & 4294967295L) + (j47 >>> 32);
                long j49 = j47 & 4294967295L;
                long j50 = (j46 * j4) + (jH11 & 4294967295L);
                int i22 = (int) j50;
                iArr2[7] = (i22 << 1) | i21;
                int i23 = i22 >>> 31;
                long jH16 = a8.b.h(j46, j12, j50 >>> 32, j43);
                long jH17 = a8.b.h(j46, j14, jH16 >>> 32, j44);
                long jH18 = a8.b.h(j46, j17, jH17 >>> 32, jH14 & 4294967295L);
                long jH19 = a8.b.h(j46, j25, jH18 >>> 32, jH15 & 4294967295L);
                long jH20 = a8.b.h(j46, j33, jH19 >>> 32, j45 & 4294967295L);
                long jH21 = a8.b.h(j46, j39, jH20 >>> 32, j49);
                long j51 = j48 + (jH21 >>> 32);
                int i24 = (int) jH16;
                iArr2[8] = (i24 << 1) | i23;
                int i25 = (int) jH17;
                iArr2[9] = (i24 >>> 31) | (i25 << 1);
                int i26 = i25 >>> 31;
                int i27 = (int) jH18;
                iArr2[10] = i26 | (i27 << 1);
                int i28 = i27 >>> 31;
                int i29 = (int) jH19;
                iArr2[11] = i28 | (i29 << 1);
                int i30 = i29 >>> 31;
                int i31 = (int) jH20;
                iArr2[12] = i30 | (i31 << 1);
                int i32 = i31 >>> 31;
                int i33 = (int) jH21;
                iArr2[13] = i32 | (i33 << 1);
                int i34 = i33 >>> 31;
                int i35 = (int) j51;
                iArr2[14] = i34 | (i35 << 1);
                iArr2[15] = ((iArr2[15] + ((int) (j51 >>> 32))) << 1) | (i35 >>> 31);
                return;
            }
            i10 = i11;
        }
    }

    public static void k(String str) {
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        Trace.beginSection(str);
    }

    public static void k0(int[] iArr, int[] iArr2) {
        i0(iArr, iArr2);
        long j4 = 4294967295L;
        long j8 = iArr[6] & 4294967295L;
        int i8 = 5;
        int i9 = 12;
        int i10 = 0;
        while (true) {
            int i11 = i8 - 1;
            long j9 = iArr[i8 + 6] & j4;
            long j10 = j9 * j9;
            long j11 = j4;
            iArr2[i9 + 11] = ((int) (j10 >>> 33)) | (i10 << 31);
            int i12 = i9 - 2;
            iArr2[i9 + 10] = (int) (j10 >>> 1);
            i10 = (int) j10;
            if (i11 <= 0) {
                long j12 = j8 * j8;
                iArr2[12] = (int) j12;
                long j13 = iArr[7] & j11;
                long j14 = (j13 * j8) + (((i10 << 31) & j11) | (j12 >>> 33));
                int i13 = (int) j14;
                iArr2[13] = (i13 << 1) | (((int) (j12 >>> 32)) & 1);
                long j15 = iArr[8] & j11;
                long j16 = (j15 * j8) + (iArr2[14] & j11) + (j14 >>> 32);
                int i14 = (int) j16;
                iArr2[14] = (i14 << 1) | (i13 >>> 31);
                long jH = a8.b.h(j15, j13, j16 >>> 32, iArr2[15] & j11);
                long j17 = (iArr2[16] & j11) + (jH >>> 32);
                long j18 = iArr[9] & j11;
                long j19 = (iArr2[17] & j11) + (j17 >>> 32);
                long j20 = (j18 * j8) + (jH & j11);
                int i15 = (int) j20;
                iArr2[15] = (i14 >>> 31) | (i15 << 1);
                long jH2 = a8.b.h(j18, j13, j20 >>> 32, j17 & j11);
                long jH3 = a8.b.h(j18, j15, jH2 >>> 32, j19 & j11);
                long j21 = (iArr2[18] & j11) + (j19 >>> 32) + (jH3 >>> 32);
                long j22 = jH3 & j11;
                long j23 = iArr[10] & j11;
                long j24 = (iArr2[19] & j11) + (j21 >>> 32);
                long j25 = j21 & j11;
                long j26 = (iArr2[20] & j11) + (j24 >>> 32);
                long j27 = j24 & j11;
                long j28 = (j23 * j8) + (jH2 & j11);
                int i16 = (int) j28;
                iArr2[16] = (i16 << 1) | (i15 >>> 31);
                long jH4 = a8.b.h(j23, j13, j28 >>> 32, j22);
                long jH5 = a8.b.h(j23, j15, jH4 >>> 32, j25);
                long jH6 = a8.b.h(j23, j18, jH5 >>> 32, j27);
                long j29 = jH5 & j11;
                long j30 = j26 + (jH6 >>> 32);
                long j31 = jH6 & j11;
                long j32 = iArr[11] & j11;
                long j33 = (iArr2[21] & j11) + (j30 >>> 32);
                long j34 = j30 & j11;
                long j35 = (iArr2[22] & j11) + (j33 >>> 32);
                long j36 = j33 & j11;
                long j37 = (j32 * j8) + (jH4 & j11);
                int i17 = (int) j37;
                iArr2[17] = (i16 >>> 31) | (i17 << 1);
                int i18 = i17 >>> 31;
                long jH7 = a8.b.h(j32, j13, j37 >>> 32, j29);
                long jH8 = a8.b.h(j32, j15, jH7 >>> 32, j31);
                long jH9 = a8.b.h(j32, j18, jH8 >>> 32, j34);
                long jH10 = a8.b.h(j32, j23, jH9 >>> 32, j36);
                long j38 = j35 + (jH10 >>> 32);
                int i19 = (int) jH7;
                iArr2[18] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) jH8;
                iArr2[19] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) jH9;
                iArr2[20] = i22 | (i23 << 1);
                int i24 = i23 >>> 31;
                int i25 = (int) jH10;
                iArr2[21] = i24 | (i25 << 1);
                int i26 = i25 >>> 31;
                int i27 = (int) j38;
                iArr2[22] = i26 | (i27 << 1);
                iArr2[23] = ((iArr2[23] + ((int) (j38 >>> 32))) << 1) | (i27 >>> 31);
                int i28 = i(iArr2, iArr2);
                int iG = g(18, iArr2, 12, iArr2, g(0, iArr2, 6, iArr2, 0) + i28) + i28;
                int[] iArr3 = new int[6];
                v(iArr, iArr, iArr3);
                int[] iArr4 = new int[12];
                i0(iArr3, iArr4);
                f.m(iArr2, 24, f.H0(12, 6, iArr4, iArr2) + iG, 18);
                return;
            }
            i9 = i12;
            i8 = i11;
            j4 = j11;
        }
    }

    public static void l(int i8, int[] iArr, int[] iArr2) {
        iArr2[i8] = iArr[0];
        iArr2[i8 + 1] = iArr[1];
        iArr2[i8 + 2] = iArr[2];
        iArr2[i8 + 3] = iArr[3];
    }

    public static int l0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = (iArr[0] & 4294967295L) - (iArr2[0] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = ((iArr[1] & 4294967295L) - (iArr2[1] & 4294967295L)) + (j4 >> 32);
        iArr3[1] = (int) j8;
        long j9 = ((iArr[2] & 4294967295L) - (iArr2[2] & 4294967295L)) + (j8 >> 32);
        iArr3[2] = (int) j9;
        long j10 = ((iArr[3] & 4294967295L) - (iArr2[3] & 4294967295L)) + (j9 >> 32);
        iArr3[3] = (int) j10;
        return (int) (j10 >> 32);
    }

    public static void m(int i8, int[] iArr, int[] iArr2) {
        iArr2[i8] = iArr[0];
        iArr2[i8 + 1] = iArr[1];
        iArr2[i8 + 2] = iArr[2];
        iArr2[i8 + 3] = iArr[3];
        iArr2[i8 + 4] = iArr[4];
        iArr2[i8 + 5] = iArr[5];
    }

    public static void m0(int[] iArr, int i8, int[] iArr2, int i9, int[] iArr3) {
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
        iArr3[5] = (int) (((iArr[i8 + 5] & 4294967295L) - (iArr2[i9 + 5] & 4294967295L)) + (j11 >> 32));
    }

    public static void n(int i8, int[] iArr, int[] iArr2) {
        iArr2[i8] = iArr[0];
        iArr2[i8 + 1] = iArr[1];
        iArr2[i8 + 2] = iArr[2];
        iArr2[i8 + 3] = iArr[3];
        iArr2[i8 + 4] = iArr[4];
        iArr2[i8 + 5] = iArr[5];
        iArr2[i8 + 6] = iArr[6];
        iArr2[i8 + 7] = iArr[7];
    }

    public static int n0(int[] iArr, int[] iArr2, int[] iArr3) {
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
        return (int) (j12 >> 32);
    }

    public static void o(int i8, long[] jArr, long[] jArr2) {
        jArr2[i8] = jArr[0];
        jArr2[i8 + 1] = jArr[1];
    }

    public static void o0(int[] iArr, int i8, int[] iArr2, int i9, int[] iArr3) {
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
        long j13 = ((iArr[i8 + 6] & 4294967295L) - (iArr2[i9 + 6] & 4294967295L)) + (j12 >> 32);
        iArr3[6] = (int) j13;
        iArr3[7] = (int) (((iArr[i8 + 7] & 4294967295L) - (iArr2[i9 + 7] & 4294967295L)) + (j13 >> 32));
    }

    public static void p(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static int p0(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j14 = ((iArr[7] & 4294967295L) - (iArr2[7] & 4294967295L)) + (j13 >> 32);
        iArr3[7] = (int) j14;
        return (int) (j14 >> 32);
    }

    public static void q(int i8, long[] jArr, long[] jArr2) {
        jArr2[i8] = jArr[0];
        jArr2[i8 + 1] = jArr[1];
        jArr2[i8 + 2] = jArr[2];
    }

    public static void q0(int[] iArr, int[] iArr2) {
        long j4 = (iArr2[0] & 4294967295L) - (iArr[0] & 4294967295L);
        iArr2[0] = (int) j4;
        long j8 = ((iArr2[1] & 4294967295L) - (iArr[1] & 4294967295L)) + (j4 >> 32);
        iArr2[1] = (int) j8;
        long j9 = ((iArr2[2] & 4294967295L) - (iArr[2] & 4294967295L)) + (j8 >> 32);
        iArr2[2] = (int) j9;
        long j10 = ((iArr2[3] & 4294967295L) - (iArr[3] & 4294967295L)) + (j9 >> 32);
        iArr2[3] = (int) j10;
        long j11 = ((iArr2[4] & 4294967295L) - (iArr[4] & 4294967295L)) + (j10 >> 32);
        iArr2[4] = (int) j11;
        iArr2[5] = (int) (((iArr2[5] & 4294967295L) - (4294967295L & iArr[5])) + (j11 >> 32));
    }

    public static void r(int i8, long[] jArr, long[] jArr2) {
        jArr2[i8] = jArr[0];
        jArr2[i8 + 1] = jArr[1];
        jArr2[i8 + 2] = jArr[2];
        jArr2[i8 + 3] = jArr[3];
    }

    public static void r0(int[] iArr, int[] iArr2) {
        long j4 = (iArr2[0] & 4294967295L) - (iArr[0] & 4294967295L);
        iArr2[0] = (int) j4;
        long j8 = ((iArr2[1] & 4294967295L) - (iArr[1] & 4294967295L)) + (j4 >> 32);
        iArr2[1] = (int) j8;
        long j9 = ((iArr2[2] & 4294967295L) - (iArr[2] & 4294967295L)) + (j8 >> 32);
        iArr2[2] = (int) j9;
        long j10 = ((iArr2[3] & 4294967295L) - (iArr[3] & 4294967295L)) + (j9 >> 32);
        iArr2[3] = (int) j10;
        long j11 = ((iArr2[4] & 4294967295L) - (iArr[4] & 4294967295L)) + (j10 >> 32);
        iArr2[4] = (int) j11;
        long j12 = ((iArr2[5] & 4294967295L) - (iArr[5] & 4294967295L)) + (j11 >> 32);
        iArr2[5] = (int) j12;
        long j13 = ((iArr2[6] & 4294967295L) - (iArr[6] & 4294967295L)) + (j12 >> 32);
        iArr2[6] = (int) j13;
        iArr2[7] = (int) (((iArr2[7] & 4294967295L) - (4294967295L & iArr[7])) + (j13 >> 32));
    }

    public static void s(int i8, long[] jArr, long[] jArr2) {
        jArr2[i8] = jArr[0];
        jArr2[i8 + 1] = jArr[1];
        jArr2[i8 + 2] = jArr[2];
        jArr2[i8 + 3] = jArr[3];
        jArr2[i8 + 4] = jArr[4];
        jArr2[i8 + 5] = jArr[5];
        jArr2[i8 + 6] = jArr[6];
        jArr2[i8 + 7] = jArr[7];
        jArr2[i8 + 8] = jArr[8];
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object s0(java.net.HttpURLConnection r4, f4.d r5, x3.b r6, h5.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof x3.h
            if (r0 == 0) goto L13
            r0 = r7
            x3.h r0 = (x3.h) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            x3.h r0 = new x3.h
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f6274c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Throwable r4 = r0.f6273b
            f4.d r5 = r0.f6272a
            a.a.c0(r7)
            goto L49
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            a.a.c0(r7)
            java.lang.Object r4 = r6.invoke(r4)     // Catch: java.lang.Throwable -> L3b
            return r4
        L3b:
            r4 = move-exception
            r0.f6272a = r5
            r0.f6273b = r4
            r0.d = r3
            java.lang.Object r6 = a6.i0.D(r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            boolean r6 = r4 instanceof java.net.SocketTimeoutException
            if (r6 != 0) goto L64
            boolean r6 = r4 instanceof java.net.ConnectException
            r7 = 0
            if (r6 == 0) goto L63
            java.lang.String r6 = r4.getMessage()
            if (r6 == 0) goto L5f
            java.lang.String r0 = "timed out"
            boolean r6 = x5.n.g1(r6, r0, r7)
            goto L60
        L5f:
            r6 = r7
        L60:
            if (r6 == 0) goto L63
            goto L64
        L63:
            r3 = r7
        L64:
            if (r3 == 0) goto Lae
            z7.b r6 = z3.t0.f6508a
            java.lang.String r6 = "request"
            kotlin.jvm.internal.p.e(r5, r6)
            y3.a r6 = new y3.a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Connect timeout has expired [url="
            r7.<init>(r0)
            k4.h0 r0 = r5.f2596a
            r7.append(r0)
            java.lang.String r0 = ", connect_timeout="
            r7.append(r0)
            r4.d r5 = r5.f2600f
            r4.a r0 = w3.f.f6192a
            java.lang.Object r5 = r5.d(r0)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 == 0) goto L93
            z3.q0 r0 = z3.q0.f6496a
            java.lang.Object r5 = r5.get(r0)
            goto L94
        L93:
            r5 = 0
        L94:
            z3.r0 r5 = (z3.r0) r5
            if (r5 == 0) goto L9c
            java.lang.Long r5 = r5.f6499b
            if (r5 != 0) goto L9e
        L9c:
            java.lang.String r5 = "unknown"
        L9e:
            r7.append(r5)
            java.lang.String r5 = " ms]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5, r4)
            r4 = r6
        Lae:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: x.e.s0(java.net.HttpURLConnection, f4.d, x3.b, h5.c):java.lang.Object");
    }

    public static BigInteger t0(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i8 = 0; i8 < 6; i8++) {
            int i9 = iArr[i8];
            if (i9 != 0) {
                Pack.intToBigEndian(i9, bArr, (5 - i8) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static final String u(CharsetDecoder charsetDecoder, j6.j input) {
        p.e(charsetDecoder, "<this>");
        p.e(input, "input");
        StringBuilder sb = new StringBuilder((int) Math.min(Integer.MAX_VALUE, input.c().f3512c));
        Charset charset = charsetDecoder.charset();
        p.b(charset);
        if (charset.equals(x5.a.f6276a)) {
            sb.append((CharSequence) k.g(input));
        } else {
            f.W(input);
            byte[] bArrF = k.f(input, -1);
            Charset charset2 = charsetDecoder.charset();
            p.b(charset2);
            sb.append((CharSequence) new String(bArrF, charset2));
        }
        return sb.toString();
    }

    public static BigInteger u0(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i8 = 0; i8 < 8; i8++) {
            int i9 = iArr[i8];
            if (i9 != 0) {
                Pack.intToBigEndian(i9, bArr, (7 - i8) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static boolean v(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z;
        int i8 = 5;
        while (true) {
            z = true;
            if (i8 < 0) {
                break;
            }
            int i9 = iArr[6 + i8] ^ Integer.MIN_VALUE;
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
            m0(iArr, 6, iArr2, 0, iArr3);
            return z;
        }
        m0(iArr2, 0, iArr, 6, iArr3);
        return z;
    }

    public static BigInteger v0(long[] jArr) {
        byte[] bArr = new byte[24];
        for (int i8 = 0; i8 < 3; i8++) {
            long j4 = jArr[i8];
            if (j4 != 0) {
                Pack.longToBigEndian(j4, bArr, (2 - i8) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static boolean w(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z;
        int i8 = 7;
        while (true) {
            z = true;
            if (i8 < 0) {
                break;
            }
            int i9 = iArr[8 + i8] ^ Integer.MIN_VALUE;
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
            o0(iArr, 8, iArr2, 0, iArr3);
            return z;
        }
        o0(iArr2, 0, iArr, 8, iArr3);
        return z;
    }

    public static BigInteger w0(long[] jArr) {
        byte[] bArr = new byte[32];
        for (int i8 = 0; i8 < 4; i8++) {
            long j4 = jArr[i8];
            if (j4 != 0) {
                Pack.longToBigEndian(j4, bArr, (3 - i8) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static final void x(CharsetEncoder charsetEncoder, j6.a aVar, CharSequence input, int i8, int i9) {
        p.e(charsetEncoder, "<this>");
        p.e(input, "input");
        if (i8 >= i9) {
            return;
        }
        do {
            byte[] bArrH = f.H(charsetEncoder, input, i8, i9);
            aVar.s(bArrH, bArrH.length);
            int length = bArrH.length;
            if (length < 0) {
                throw new IllegalStateException("Check failed.");
            }
            i8 += length;
        } while (i8 < i9);
    }

    public static final byte[] x0(String str, Charset charset) throws CharacterCodingException {
        p.e(str, "<this>");
        p.e(charset, "charset");
        Charset charset2 = x5.a.f6276a;
        if (!charset.equals(charset2)) {
            return f.H(charset.newEncoder(), str, 0, str.length());
        }
        int length = str.length();
        a.a.i(0, length, str.length());
        CharsetEncoder charsetEncoderNewEncoder = charset2.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        ByteBuffer byteBufferEncode = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).encode(CharBuffer.wrap(str, 0, length));
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            int iRemaining = byteBufferEncode.remaining();
            byte[] bArrArray = byteBufferEncode.array();
            p.b(bArrArray);
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBufferEncode.array();
                p.b(bArrArray2);
                return bArrArray2;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    public static boolean y(int[] iArr, int[] iArr2) {
        for (int i8 = 5; i8 >= 0; i8--) {
            if (iArr[i8] != iArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    public static final r y0(String str) {
        int i8;
        f.r(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char cCharAt = str.charAt(0);
        if (p.g(cCharAt, 48) < 0) {
            i8 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i8 = 0;
        }
        int iDivideUnsigned = 119304647;
        while (i8 < length) {
            int iDigit = Character.digit((int) str.charAt(i8), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i9, iDivideUnsigned) > 0) {
                if (iDivideUnsigned != 119304647) {
                    return null;
                }
                iDivideUnsigned = Integer.divideUnsigned(-1, 10);
                if (Integer.compareUnsigned(i9, iDivideUnsigned) > 0) {
                    return null;
                }
            }
            int i10 = i9 * 10;
            int i11 = iDigit + i10;
            if (Integer.compareUnsigned(i11, i10) < 0) {
                return null;
            }
            i8++;
            i9 = i11;
        }
        return new r(i9);
    }

    public static boolean z(int[] iArr, int[] iArr2) {
        for (int i8 = 7; i8 >= 0; i8--) {
            if (iArr[i8] != iArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    public static final u z0(String str) {
        p.e(str, "<this>");
        f.r(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char cCharAt = str.charAt(0);
        if (p.g(cCharAt, 48) < 0) {
            i8 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long j4 = 10;
        long j8 = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i8 < length) {
            int iDigit = Character.digit((int) str.charAt(i8), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Long.compareUnsigned(j8, jDivideUnsigned) > 0) {
                if (jDivideUnsigned != 512409557603043100L) {
                    return null;
                }
                jDivideUnsigned = Long.divideUnsigned(-1L, j4);
                if (Long.compareUnsigned(j8, jDivideUnsigned) > 0) {
                    return null;
                }
            }
            long j9 = j8 * j4;
            long j10 = (iDigit & 4294967295L) + j9;
            if (Long.compareUnsigned(j10, j9) < 0) {
                return null;
            }
            i8++;
            j8 = j10;
        }
        return new u(j8);
    }

    public final FontFamily L(b0.k[] kVarArr, ContentResolver contentResolver) throws IOException {
        Font fontBuild;
        String str;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        Font fontF;
        FontFamily.Builder builder = null;
        for (b0.k kVar : kVarArr) {
            if (Objects.equals(kVar.f834a.getScheme(), "systemfont")) {
                Uri uri = kVar.f834a;
                boolean zEquals = Objects.equals(uri.getScheme(), "systemfont");
                String str2 = kVar.f837e;
                fontBuild = null;
                String authority = zEquals ? uri.getAuthority() : null;
                if (authority != null) {
                    Typeface typefaceCreate = Typeface.create(authority, 0);
                    Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
                    if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                        typefaceCreate = null;
                    }
                    if (typefaceCreate != null && (fontF = d.f(typefaceCreate)) != null) {
                        if (TextUtils.isEmpty(str2)) {
                            fontBuild = fontF;
                        } else {
                            try {
                                fontBuild = new Font.Builder(fontF).setFontVariationSettings(str2).build();
                            } catch (IOException unused) {
                                Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
                            }
                        }
                    }
                }
            } else {
                try {
                    Uri uri2 = kVar.f834a;
                    str = kVar.f837e;
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri2, "r", null);
                } catch (IOException e9) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    fontBuild = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(kVar.f836c).setSlant(kVar.d ? 1 : 0).setTtcIndex(kVar.f835b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        fontBuild = ttcIndex.build();
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
            if (fontBuild != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public final Typeface t(Context context, List list, int i8) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyL = L((b0.k[]) list.get(0), contentResolver);
            if (fontFamilyL == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyL);
            for (int i9 = 1; i9 < list.size(); i9++) {
                FontFamily fontFamilyL2 = L((b0.k[]) list.get(i9), contentResolver);
                if (fontFamilyL2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyL2);
                }
            }
            return customFallbackBuilder.setStyle(F(fontFamilyL, i8).getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            return null;
        }
    }
}
