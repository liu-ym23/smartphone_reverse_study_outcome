package com.google.zxing.qrcode.encoder;

import D3.f;
import M3.b;
import M3.c;
import M3.d;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f21859a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f21860b = StandardCharsets.ISO_8859_1;

    /* renamed from: com.google.zxing.qrcode.encoder.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0240a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21861a;

        static {
            int[] iArr = new int[Mode.values().length];
            f21861a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21861a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21861a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21861a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(String str, D3.a aVar, Charset charset) {
        for (byte b10 : str.getBytes(charset)) {
            aVar.f(b10, 8);
        }
    }

    public static void b(CharSequence charSequence, D3.a aVar) throws WriterException {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int iP = p(charSequence.charAt(i10));
            if (iP == -1) {
                throw new WriterException();
            }
            int i11 = i10 + 1;
            if (i11 < length) {
                int iP2 = p(charSequence.charAt(i11));
                if (iP2 == -1) {
                    throw new WriterException();
                }
                aVar.f((iP * 45) + iP2, 11);
                i10 += 2;
            } else {
                aVar.f(iP, 6);
                i10 = i11;
            }
        }
    }

    public static void c(String str, Mode mode, D3.a aVar, Charset charset) throws WriterException {
        int i10 = C0240a.f21861a[mode.ordinal()];
        if (i10 == 1) {
            h(str, aVar);
            return;
        }
        if (i10 == 2) {
            b(str, aVar);
            return;
        }
        if (i10 == 3) {
            a(str, aVar, charset);
        } else {
            if (i10 == 4) {
                e(str, aVar);
                return;
            }
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    public static void d(CharacterSetECI characterSetECI, D3.a aVar) {
        aVar.f(Mode.ECI.getBits(), 4);
        aVar.f(characterSetECI.getValue(), 8);
    }

    public static void e(String str, D3.a aVar) throws WriterException {
        int i10;
        Charset charset = f.f2261b;
        if (charset == null) {
            throw new WriterException("SJIS Charset not supported on this platform");
        }
        byte[] bytes = str.getBytes(charset);
        if (bytes.length % 2 != 0) {
            throw new WriterException("Kanji byte size not even");
        }
        int length = bytes.length - 1;
        for (int i11 = 0; i11 < length; i11 += 2) {
            int i12 = ((bytes[i11] & 255) << 8) | (bytes[i11 + 1] & 255);
            int i13 = 33088;
            if (i12 >= 33088 && i12 <= 40956) {
                i10 = i12 - i13;
            } else if (i12 < 57408 || i12 > 60351) {
                i10 = -1;
            } else {
                i13 = 49472;
                i10 = i12 - i13;
            }
            if (i10 == -1) {
                throw new WriterException("Invalid byte sequence");
            }
            aVar.f(((i10 >> 8) * 192) + (i10 & 255), 13);
        }
    }

    public static void f(int i10, L3.a aVar, Mode mode, D3.a aVar2) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(aVar);
        int i11 = 1 << characterCountBits;
        if (i10 < i11) {
            aVar2.f(i10, characterCountBits);
            return;
        }
        throw new WriterException(i10 + " is bigger than " + (i11 - 1));
    }

    public static void g(Mode mode, D3.a aVar) {
        aVar.f(mode.getBits(), 4);
    }

    public static void h(CharSequence charSequence, D3.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int iCharAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                aVar.f((iCharAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    aVar.f((iCharAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    aVar.f(iCharAt, 4);
                }
            }
        }
    }

    public static int i(Mode mode, D3.a aVar, D3.a aVar2, L3.a aVar3) {
        return aVar.j() + mode.getCharacterCountBits(aVar3) + aVar2.j();
    }

    public static int j(b bVar) {
        return c.a(bVar) + c.c(bVar) + c.d(bVar) + c.e(bVar);
    }

    public static int k(D3.a aVar, ErrorCorrectionLevel errorCorrectionLevel, L3.a aVar2, b bVar) throws WriterException {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            d.a(aVar, errorCorrectionLevel, aVar2, i12, bVar);
            int iJ = j(bVar);
            if (iJ < i10) {
                i11 = i12;
                i10 = iJ;
            }
        }
        return i11;
    }

    public static Mode l(String str, Charset charset) {
        Charset charset2 = f.f2261b;
        if (charset2 != null && charset2.equals(charset) && s(str)) {
            return Mode.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z11 = true;
            } else {
                if (p(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z10 = true;
            }
        }
        return z10 ? Mode.ALPHANUMERIC : z11 ? Mode.NUMERIC : Mode.BYTE;
    }

    public static L3.a m(int i10, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i11 = 1; i11 <= 40; i11++) {
            L3.a aVarE = L3.a.e(i11);
            if (v(i10, aVarE, errorCorrectionLevel)) {
                return aVarE;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static M3.e n(java.lang.String r6, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r7, java.util.Map<com.google.zxing.EncodeHintType, ?> r8) throws java.lang.NumberFormatException, com.google.zxing.WriterException {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.a.n(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):M3.e");
    }

    public static byte[] o(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        new E3.c(E3.a.f2365l).b(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    public static int p(int i10) {
        int[] iArr = f21859a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public static void q(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) throws WriterException {
        if (i13 >= i12) {
            throw new WriterException("Block ID too large");
        }
        int i14 = i10 % i12;
        int i15 = i12 - i14;
        int i16 = i10 / i12;
        int i17 = i16 + 1;
        int i18 = i11 / i12;
        int i19 = i18 + 1;
        int i20 = i16 - i18;
        int i21 = i17 - i19;
        if (i20 != i21) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i12 != i15 + i14) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i10 != ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i13 < i15) {
            iArr[0] = i18;
            iArr2[0] = i20;
        } else {
            iArr[0] = i19;
            iArr2[0] = i21;
        }
    }

    public static D3.a r(D3.a aVar, int i10, int i11, int i12) throws WriterException {
        if (aVar.k() != i11) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i12);
        int i13 = 0;
        int i14 = 0;
        int iMax = 0;
        int iMax2 = 0;
        while (i13 < i12) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int i15 = i10;
            int i16 = i11;
            int i17 = i12;
            q(i15, i16, i17, i13, iArr, iArr2);
            int i18 = iArr[0];
            byte[] bArr = new byte[i18];
            aVar.o(i14 * 8, bArr, 0, i18);
            byte[] bArrO = o(bArr, iArr2[0]);
            arrayList.add(new M3.a(bArr, bArrO));
            iMax = Math.max(iMax, i18);
            iMax2 = Math.max(iMax2, bArrO.length);
            i14 += iArr[0];
            i13++;
            i10 = i15;
            i11 = i16;
            i12 = i17;
        }
        int i19 = i10;
        if (i11 != i14) {
            throw new WriterException("Data bytes does not match offset");
        }
        D3.a aVar2 = new D3.a();
        for (int i20 = 0; i20 < iMax; i20++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrA = ((M3.a) it.next()).a();
                if (i20 < bArrA.length) {
                    aVar2.f(bArrA[i20], 8);
                }
            }
        }
        for (int i21 = 0; i21 < iMax2; i21++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrB = ((M3.a) it2.next()).b();
                if (i21 < bArrB.length) {
                    aVar2.f(bArrB[i21], 8);
                }
            }
        }
        if (i19 == aVar2.k()) {
            return aVar2;
        }
        throw new WriterException("Interleaving error: " + i19 + " and " + aVar2.k() + " differ.");
    }

    public static boolean s(String str) {
        byte[] bytes = str.getBytes(f.f2261b);
        int length = bytes.length;
        if (length % 2 != 0) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10 += 2) {
            int i11 = bytes[i10] & 255;
            if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                return false;
            }
        }
        return true;
    }

    public static L3.a t(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, D3.a aVar, D3.a aVar2) throws WriterException {
        return m(i(mode, aVar, aVar2, m(i(mode, aVar, aVar2, L3.a.e(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void u(int i10, D3.a aVar) throws WriterException {
        int i11 = i10 * 8;
        if (aVar.j() > i11) {
            throw new WriterException("data bits cannot fit in the QR Code" + aVar.j() + " > " + i11);
        }
        for (int i12 = 0; i12 < 4 && aVar.j() < i11; i12++) {
            aVar.a(false);
        }
        int iJ = aVar.j() & 7;
        if (iJ > 0) {
            while (iJ < 8) {
                aVar.a(false);
                iJ++;
            }
        }
        int iK = i10 - aVar.k();
        for (int i13 = 0; i13 < iK; i13++) {
            aVar.f((i13 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.j() != i11) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    public static boolean v(int i10, L3.a aVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return aVar.d() - aVar.c(errorCorrectionLevel).d() >= (i10 + 7) / 8;
    }
}
