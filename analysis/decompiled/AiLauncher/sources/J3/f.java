package J3;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.pdf417.encoder.Compaction;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f3727c;

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f3725a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f3726b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f3728d = new byte[128];

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f3729e = StandardCharsets.ISO_8859_1;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3730a;

        static {
            int[] iArr = new int[Compaction.values().length];
            f3730a = iArr;
            try {
                iArr[Compaction.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3730a[Compaction.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3730a[Compaction.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class b implements D3.d {

        /* renamed from: a, reason: collision with root package name */
        public String f3731a;

        public /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        @Override // D3.d
        public boolean a(int i10) {
            return false;
        }

        @Override // D3.d
        public int b(int i10) {
            return -1;
        }

        @Override // D3.d
        public char charAt(int i10) {
            return this.f3731a.charAt(i10);
        }

        @Override // D3.d
        public int length() {
            return this.f3731a.length();
        }

        @Override // D3.d
        public CharSequence subSequence(int i10, int i11) {
            return this.f3731a.subSequence(i10, i11);
        }

        public String toString() {
            return this.f3731a;
        }

        public b(String str) {
            this.f3731a = str;
        }
    }

    static {
        byte[] bArr = new byte[128];
        f3727c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f3725a;
            if (i11 >= bArr2.length) {
                break;
            }
            byte b10 = bArr2[i11];
            if (b10 > 0) {
                f3727c[b10] = (byte) i11;
            }
            i11++;
        }
        Arrays.fill(f3728d, (byte) -1);
        while (true) {
            byte[] bArr3 = f3726b;
            if (i10 >= bArr3.length) {
                return;
            }
            byte b11 = bArr3[i10];
            if (b11 > 0) {
                f3728d[b11] = (byte) i10;
            }
            i10++;
        }
    }

    public static void a(String str, int i10, String str2) throws WriterException {
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (str.charAt(i11) > i10) {
                throw new WriterException("Non-encodable character detected: " + str.charAt(i11) + " (Unicode: " + ((int) str.charAt(i11)) + ") at position #" + i11 + " - " + str2);
            }
        }
    }

    public static int b(D3.d dVar, int i10, Charset charset) throws WriterException {
        CharsetEncoder charsetEncoderNewEncoder = charset == null ? null : charset.newEncoder();
        int length = dVar.length();
        int i11 = i10;
        while (i11 < length) {
            int i12 = 0;
            int i13 = i11;
            while (i12 < 13 && !dVar.a(i13) && m(dVar.charAt(i13)) && (i13 = i11 + (i12 = i12 + 1)) < length) {
            }
            if (i12 >= 13) {
                return i11 - i10;
            }
            if (charsetEncoderNewEncoder != null && !charsetEncoderNewEncoder.canEncode(dVar.charAt(i11))) {
                char cCharAt = dVar.charAt(i11);
                throw new WriterException("Non-encodable character detected: " + cCharAt + " (Unicode: " + ((int) cCharAt) + ')');
            }
            i11++;
        }
        return i11 - i10;
    }

    public static int c(D3.d dVar, int i10) {
        int length = dVar.length();
        int i11 = 0;
        if (i10 < length) {
            while (i10 < length && !dVar.a(i10) && m(dVar.charAt(i10))) {
                i11++;
                i10++;
            }
        }
        return i11;
    }

    public static int d(D3.d dVar, int i10) {
        int length = dVar.length();
        int i11 = i10;
        while (i11 < length) {
            int i12 = 0;
            while (i12 < 13 && i11 < length && !dVar.a(i11) && m(dVar.charAt(i11))) {
                i12++;
                i11++;
            }
            if (i12 >= 13) {
                return (i11 - i10) - i12;
            }
            if (i12 <= 0) {
                if (dVar.a(i11) || !p(dVar.charAt(i11))) {
                    break;
                }
                i11++;
            }
        }
        return i11 - i10;
    }

    public static void e(byte[] bArr, int i10, int i11, int i12, StringBuilder sb2) {
        int i13;
        if (i11 == 1 && i12 == 0) {
            sb2.append((char) 913);
        } else if (i11 % 6 == 0) {
            sb2.append((char) 924);
        } else {
            sb2.append((char) 901);
        }
        if (i11 >= 6) {
            char[] cArr = new char[5];
            i13 = i10;
            while ((i10 + i11) - i13 >= 6) {
                long j10 = 0;
                for (int i14 = 0; i14 < 6; i14++) {
                    j10 = (j10 << 8) + (bArr[i13 + i14] & 255);
                }
                for (int i15 = 0; i15 < 5; i15++) {
                    cArr[i15] = (char) (j10 % 900);
                    j10 /= 900;
                }
                for (int i16 = 4; i16 >= 0; i16--) {
                    sb2.append(cArr[i16]);
                }
                i13 += 6;
            }
        } else {
            i13 = i10;
        }
        while (i13 < i10 + i11) {
            sb2.append((char) (bArr[i13] & 255));
            i13++;
        }
    }

    public static String f(String str, Compaction compaction, Charset charset, boolean z10) throws WriterException {
        D3.d bVar;
        CharacterSetECI characterSetECI;
        if (str.isEmpty()) {
            throw new WriterException("Empty message not allowed");
        }
        if (Compaction.TEXT == compaction) {
            a(str, 127, "Consider specifying Compaction.AUTO instead of Compaction.TEXT");
        }
        if (charset == null && !z10) {
            a(str, 255, "Consider specifying EncodeHintType.PDF417_AUTO_ECI and/or EncodeTypeHint.CHARACTER_SET");
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        a aVar = null;
        if (z10) {
            bVar = new D3.e(str, charset, -1);
        } else {
            bVar = new b(str, aVar);
            if (charset == null) {
                charset = f3729e;
            } else if (!f3729e.equals(charset) && (characterSetECI = CharacterSetECI.getCharacterSetECI(charset)) != null) {
                j(characterSetECI.getValue(), sb2);
            }
        }
        int length = bVar.length();
        int i10 = a.f3730a[compaction.ordinal()];
        if (i10 == 1) {
            i(bVar, 0, length, sb2, 0);
        } else if (i10 != 2) {
            if (i10 != 3) {
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                while (i11 < length) {
                    while (i11 < length && bVar.a(i11)) {
                        j(bVar.b(i11), sb2);
                        i11++;
                    }
                    if (i11 >= length) {
                        break;
                    }
                    int iC = c(bVar, i11);
                    if (iC >= 13) {
                        sb2.append((char) 902);
                        h(bVar, i11, iC, sb2);
                        i11 += iC;
                        i12 = 0;
                        i13 = 2;
                    } else {
                        int iD = d(bVar, i11);
                        if (iD >= 5 || iC == length) {
                            if (i13 != 0) {
                                sb2.append((char) 900);
                                i12 = 0;
                                i13 = 0;
                            }
                            i12 = i(bVar, i11, iD, sb2, i12);
                            i11 += iD;
                        } else {
                            int iB = b(bVar, i11, z10 ? null : charset);
                            if (iB == 0) {
                                iB = 1;
                            }
                            byte[] bytes = z10 ? null : bVar.subSequence(i11, i11 + iB).toString().getBytes(charset);
                            if ((!(bytes == null && iB == 1) && (bytes == null || bytes.length != 1)) || i13 != 0) {
                                if (z10) {
                                    g(bVar, i11, i11 + iB, i13, sb2);
                                } else {
                                    e(bytes, 0, bytes.length, i13, sb2);
                                }
                                i13 = 1;
                                i12 = 0;
                            } else if (z10) {
                                g(bVar, i11, 1, 0, sb2);
                            } else {
                                e(bytes, 0, 1, 0, sb2);
                            }
                            i11 += iB;
                        }
                    }
                }
            } else {
                sb2.append((char) 902);
                h(bVar, 0, length, sb2);
            }
        } else if (z10) {
            g(bVar, 0, bVar.length(), 0, sb2);
        } else {
            byte[] bytes2 = bVar.toString().getBytes(charset);
            e(bytes2, 0, bytes2.length, 1, sb2);
        }
        return sb2.toString();
    }

    public static void g(D3.d dVar, int i10, int i11, int i12, StringBuilder sb2) throws WriterException {
        int iMin = Math.min(i11 + i10, dVar.length());
        int i13 = i10;
        while (true) {
            if (i13 >= iMin || !dVar.a(i13)) {
                int i14 = i13;
                while (i14 < iMin && !dVar.a(i14)) {
                    i14++;
                }
                int i15 = i14 - i13;
                if (i15 <= 0) {
                    return;
                }
                e(q(dVar, i13, i14), 0, i15, i13 == i10 ? i12 : 1, sb2);
                i13 = i14;
            } else {
                j(dVar.b(i13), sb2);
                i13++;
            }
        }
    }

    public static void h(D3.d dVar, int i10, int i11, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder((i11 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i12 = 0;
        while (i12 < i11) {
            sb3.setLength(0);
            int iMin = Math.min(44, i11 - i12);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("1");
            int i13 = i10 + i12;
            sb4.append((Object) dVar.subSequence(i13, i13 + iMin));
            BigInteger bigInteger = new BigInteger(sb4.toString());
            do {
                sb3.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb3.length() - 1; length >= 0; length--) {
                sb2.append(sb3.charAt(length));
            }
            i12 += iMin;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010b A[EDGE_INSN: B:80:0x010b->B:60:0x010b BREAK  A[LOOP:0: B:3:0x000f->B:98:0x000f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int i(D3.d r16, int r17, int r18, java.lang.StringBuilder r19, int r20) throws com.google.zxing.WriterException {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J3.f.i(D3.d, int, int, java.lang.StringBuilder, int):int");
    }

    public static void j(int i10, StringBuilder sb2) throws WriterException {
        if (i10 >= 0 && i10 < 900) {
            sb2.append((char) 927);
            sb2.append((char) i10);
            return;
        }
        if (i10 < 810900) {
            sb2.append((char) 926);
            sb2.append((char) ((i10 / 900) - 1));
            sb2.append((char) (i10 % 900));
        } else if (i10 < 811800) {
            sb2.append((char) 925);
            sb2.append((char) (810900 - i10));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i10);
        }
    }

    public static boolean k(char c10) {
        if (c10 != ' ') {
            return c10 >= 'a' && c10 <= 'z';
        }
        return true;
    }

    public static boolean l(char c10) {
        if (c10 != ' ') {
            return c10 >= 'A' && c10 <= 'Z';
        }
        return true;
    }

    public static boolean m(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    public static boolean n(char c10) {
        return f3727c[c10] != -1;
    }

    public static boolean o(char c10) {
        return f3728d[c10] != -1;
    }

    public static boolean p(char c10) {
        if (c10 == '\t' || c10 == '\n' || c10 == '\r') {
            return true;
        }
        return c10 >= ' ' && c10 <= '~';
    }

    public static byte[] q(D3.d dVar, int i10, int i11) {
        byte[] bArr = new byte[i11 - i10];
        for (int i12 = i10; i12 < i11; i12++) {
            bArr[i12 - i10] = (byte) (dVar.charAt(i12) & 255);
        }
        return bArr;
    }
}
