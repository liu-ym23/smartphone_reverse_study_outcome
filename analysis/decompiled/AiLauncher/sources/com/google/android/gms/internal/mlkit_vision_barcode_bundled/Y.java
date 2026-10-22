package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class Y {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f20071a = 100;

    public static int a(byte[] bArr, int i10, X x10) throws zzer {
        int iJ = j(bArr, i10, x10);
        int i11 = x10.f20064a;
        if (i11 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i11 > bArr.length - iJ) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i11 == 0) {
            x10.f20066c = zzdf.f20159b;
            return iJ;
        }
        x10.f20066c = zzdf.A(bArr, iJ, i11);
        return iJ + i11;
    }

    public static int b(int i10, byte[] bArr, int i11, int i12, C0 c02, E0 e02, M1 m12, X x10) throws IOException {
        C1778w0 c1778w0 = c02.zzb;
        zzhf zzhfVar = e02.f20017b.f20012b;
        Object objValueOf = null;
        if (zzhfVar == zzhf.zzn) {
            j(bArr, i11, x10);
            throw null;
        }
        switch (zzhfVar.ordinal()) {
            case 0:
                i11 += 8;
                objValueOf = Double.valueOf(Double.longBitsToDouble(q(bArr, i11)));
                break;
            case 1:
                i11 += 4;
                objValueOf = Float.valueOf(Float.intBitsToFloat(c(bArr, i11)));
                break;
            case 2:
            case 3:
                i11 = m(bArr, i11, x10);
                objValueOf = Long.valueOf(x10.f20065b);
                break;
            case 4:
            case 12:
                i11 = j(bArr, i11, x10);
                objValueOf = Integer.valueOf(x10.f20064a);
                break;
            case 5:
            case 15:
                i11 += 8;
                objValueOf = Long.valueOf(q(bArr, i11));
                break;
            case 6:
            case 14:
                i11 += 4;
                objValueOf = Integer.valueOf(c(bArr, i11));
                break;
            case 7:
                i11 = m(bArr, i11, x10);
                objValueOf = Boolean.valueOf(x10.f20065b != 0);
                break;
            case 8:
                i11 = h(bArr, i11, x10);
                objValueOf = x10.f20066c;
                break;
            case 9:
                int i13 = ((i10 >>> 3) << 3) | 4;
                InterfaceC1791z1 interfaceC1791z1B = C1752p1.a().b(e02.f20016a.getClass());
                Object objE = c1778w0.e(e02.f20017b);
                if (objE == null) {
                    objE = interfaceC1791z1B.zze();
                    c1778w0.i(e02.f20017b, objE);
                }
                return n(objE, interfaceC1791z1B, bArr, i11, i12, i13, x10);
            case 10:
                InterfaceC1791z1 interfaceC1791z1B2 = C1752p1.a().b(e02.f20016a.getClass());
                Object objE2 = c1778w0.e(e02.f20017b);
                if (objE2 == null) {
                    objE2 = interfaceC1791z1B2.zze();
                    c1778w0.i(e02.f20017b, objE2);
                }
                return o(objE2, interfaceC1791z1B2, bArr, i11, i12, x10);
            case 11:
                i11 = a(bArr, i11, x10);
                objValueOf = x10.f20066c;
                break;
            case 13:
                throw new IllegalStateException("Shouldn't reach here.");
            case 16:
                i11 = j(bArr, i11, x10);
                objValueOf = Integer.valueOf(C1727j0.a(x10.f20064a));
                break;
            case 17:
                i11 = m(bArr, i11, x10);
                objValueOf = Long.valueOf(C1727j0.b(x10.f20065b));
                break;
        }
        c1778w0.i(e02.f20017b, objValueOf);
        return i11;
    }

    public static int c(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = bArr[i10 + 1] & 255;
        int i13 = bArr[i10 + 2] & 255;
        return ((bArr[i10 + 3] & 255) << 24) | (i12 << 8) | i11 | (i13 << 16);
    }

    public static int d(InterfaceC1791z1 interfaceC1791z1, byte[] bArr, int i10, int i11, int i12, X x10) throws IOException {
        Object objZze = interfaceC1791z1.zze();
        int iN = n(objZze, interfaceC1791z1, bArr, i10, i11, i12, x10);
        interfaceC1791z1.a(objZze);
        x10.f20066c = objZze;
        return iN;
    }

    public static int e(InterfaceC1791z1 interfaceC1791z1, byte[] bArr, int i10, int i11, X x10) throws IOException {
        Object objZze = interfaceC1791z1.zze();
        int iO = o(objZze, interfaceC1791z1, bArr, i10, i11, x10);
        interfaceC1791z1.a(objZze);
        x10.f20066c = objZze;
        return iO;
    }

    public static int f(InterfaceC1791z1 interfaceC1791z1, int i10, byte[] bArr, int i11, int i12, M0 m02, X x10) throws IOException {
        int iE = e(interfaceC1791z1, bArr, i11, i12, x10);
        m02.add(x10.f20066c);
        while (iE < i12) {
            int iJ = j(bArr, iE, x10);
            if (i10 != x10.f20064a) {
                break;
            }
            iE = e(interfaceC1791z1, bArr, iJ, i12, x10);
            m02.add(x10.f20066c);
        }
        return iE;
    }

    public static int g(byte[] bArr, int i10, M0 m02, X x10) throws IOException {
        G0 g02 = (G0) m02;
        int iJ = j(bArr, i10, x10);
        int i11 = x10.f20064a + iJ;
        while (iJ < i11) {
            iJ = j(bArr, iJ, x10);
            g02.f(x10.f20064a);
        }
        if (iJ == i11) {
            return iJ;
        }
        throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int h(byte[] bArr, int i10, X x10) throws zzer {
        int iJ = j(bArr, i10, x10);
        int i11 = x10.f20064a;
        if (i11 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i11 == 0) {
            x10.f20066c = "";
            return iJ;
        }
        x10.f20066c = new String(bArr, iJ, i11, N0.f20038a);
        return iJ + i11;
    }

    public static int i(int i10, byte[] bArr, int i11, int i12, N1 n12, X x10) throws zzer {
        if ((i10 >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int iM = m(bArr, i11, x10);
            n12.j(i10, Long.valueOf(x10.f20065b));
            return iM;
        }
        if (i13 == 1) {
            n12.j(i10, Long.valueOf(q(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int iJ = j(bArr, i11, x10);
            int i14 = x10.f20064a;
            if (i14 < 0) {
                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i14 > bArr.length - iJ) {
                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i14 == 0) {
                n12.j(i10, zzdf.f20159b);
            } else {
                n12.j(i10, zzdf.A(bArr, iJ, i14));
            }
            return iJ + i14;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw new zzer("Protocol message contained an invalid tag (zero).");
            }
            n12.j(i10, Integer.valueOf(c(bArr, i11)));
            return i11 + 4;
        }
        int i15 = (i10 & (-8)) | 4;
        N1 n1F = N1.f();
        int i16 = x10.f20068e + 1;
        x10.f20068e = i16;
        r(i16);
        int i17 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int iJ2 = j(bArr, i11, x10);
            int i18 = x10.f20064a;
            if (i18 == i15) {
                i17 = i18;
                i11 = iJ2;
                break;
            }
            i11 = i(i18, bArr, iJ2, i12, n1F, x10);
            i17 = i18;
        }
        x10.f20068e--;
        if (i11 > i12 || i17 != i15) {
            throw new zzer("Failed to parse the message.");
        }
        n12.j(i10, n1F);
        return i11;
    }

    public static int j(byte[] bArr, int i10, X x10) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return k(b10, bArr, i11, x10);
        }
        x10.f20064a = b10;
        return i11;
    }

    public static int k(int i10, byte[] bArr, int i11, X x10) {
        byte b10 = bArr[i11];
        int i12 = i11 + 1;
        int i13 = i10 & 127;
        if (b10 >= 0) {
            x10.f20064a = i13 | (b10 << 7);
            return i12;
        }
        int i14 = i13 | ((b10 & 127) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            x10.f20064a = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            x10.f20064a = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            x10.f20064a = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                x10.f20064a = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    public static int l(int i10, byte[] bArr, int i11, int i12, M0 m02, X x10) {
        G0 g02 = (G0) m02;
        int iJ = j(bArr, i11, x10);
        g02.f(x10.f20064a);
        while (iJ < i12) {
            int iJ2 = j(bArr, iJ, x10);
            if (i10 != x10.f20064a) {
                break;
            }
            iJ = j(bArr, iJ2, x10);
            g02.f(x10.f20064a);
        }
        return iJ;
    }

    public static int m(byte[] bArr, int i10, X x10) {
        long j10 = bArr[i10];
        int i11 = i10 + 1;
        if (j10 >= 0) {
            x10.f20065b = j10;
            return i11;
        }
        int i12 = i10 + 2;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | ((b10 & 127) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            i13 += 7;
            j11 |= (r10 & 127) << i13;
            b10 = bArr[i12];
            i12 = i14;
        }
        x10.f20065b = j11;
        return i12;
    }

    public static int n(Object obj, InterfaceC1791z1 interfaceC1791z1, byte[] bArr, int i10, int i11, int i12, X x10) throws IOException {
        int i13 = x10.f20068e + 1;
        x10.f20068e = i13;
        r(i13);
        int iX = ((C1732k1) interfaceC1791z1).x(obj, bArr, i10, i11, i12, x10);
        x10.f20068e--;
        x10.f20066c = obj;
        return iX;
    }

    public static int o(Object obj, InterfaceC1791z1 interfaceC1791z1, byte[] bArr, int i10, int i11, X x10) throws IOException {
        int iK = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iK = k(i12, bArr, iK, x10);
            i12 = x10.f20064a;
        }
        int i13 = iK;
        if (i12 < 0 || i12 > i11 - i13) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i14 = x10.f20068e + 1;
        x10.f20068e = i14;
        r(i14);
        int i15 = i13 + i12;
        interfaceC1791z1.g(obj, bArr, i13, i15, x10);
        x10.f20068e--;
        x10.f20066c = obj;
        return i15;
    }

    public static int p(int i10, byte[] bArr, int i11, int i12, X x10) throws zzer {
        if ((i10 >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            return m(bArr, i11, x10);
        }
        if (i13 == 1) {
            return i11 + 8;
        }
        if (i13 == 2) {
            return j(bArr, i11, x10) + x10.f20064a;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                return i11 + 4;
            }
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (i11 < i12) {
            i11 = j(bArr, i11, x10);
            i15 = x10.f20064a;
            if (i15 == i14) {
                break;
            }
            i11 = p(i15, bArr, i11, i12, x10);
        }
        if (i11 > i12 || i15 != i14) {
            throw new zzer("Failed to parse the message.");
        }
        return i11;
    }

    public static long q(byte[] bArr, int i10) {
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48) | ((bArr[i10 + 7] & 255) << 56);
    }

    public static void r(int i10) throws zzer {
        if (i10 >= f20071a) {
            throw new zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
