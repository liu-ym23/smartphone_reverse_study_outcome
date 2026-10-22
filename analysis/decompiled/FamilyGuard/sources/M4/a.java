package M4;

import L4.b;
import L4.c;
import L4.h;
import V3.s;
import j4.k;
import java.util.Arrays;
import r4.C1031n;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f4160a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static final h f4161b = h.f3943e.c(new byte[0]);

    /* JADX WARN: Code restructure failed: missing block: B:116:0x010b, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x01a8, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005d, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x009d, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int a(byte[] r18, int r19) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.a.a(byte[], int):int");
    }

    public static final String b(h hVar) {
        k.h(hVar, "$receiver");
        return L4.a.b(hVar.j(), null, 1, null);
    }

    public static final int c(h hVar, h hVar2) {
        k.h(hVar, "$receiver");
        k.h(hVar2, "other");
        int iW = hVar.w();
        int iW2 = hVar2.w();
        int iMin = Math.min(iW, iW2);
        for (int i5 = 0; i5 < iMin; i5++) {
            int i6 = hVar.i(i5) & 255;
            int i7 = hVar2.i(i5) & 255;
            if (i6 != i7) {
                return i6 < i7 ? -1 : 1;
            }
        }
        if (iW == iW2) {
            return 0;
        }
        return iW < iW2 ? -1 : 1;
    }

    public static final h d(String str) {
        k.h(str, "$receiver");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            bArr[i5] = (byte) ((t(str.charAt(i6)) << 4) + t(str.charAt(i6 + 1)));
        }
        return new h(bArr);
    }

    public static final h e(String str) {
        k.h(str, "$receiver");
        h hVar = new h(b.b(str));
        hVar.t(str);
        return hVar;
    }

    public static final boolean f(h hVar, Object obj) {
        k.h(hVar, "$receiver");
        if (obj == hVar) {
            return true;
        }
        if (obj instanceof h) {
            h hVar2 = (h) obj;
            if (hVar2.w() == hVar.j().length && hVar2.r(0, hVar.j(), 0, hVar.j().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte g(h hVar, int i5) {
        k.h(hVar, "$receiver");
        return hVar.j()[i5];
    }

    public static final int h(h hVar) {
        k.h(hVar, "$receiver");
        return hVar.j().length;
    }

    public static final int i(h hVar) {
        k.h(hVar, "$receiver");
        int iK = hVar.k();
        if (iK != 0) {
            return iK;
        }
        hVar.s(Arrays.hashCode(hVar.j()));
        return hVar.k();
    }

    public static final String j(h hVar) {
        k.h(hVar, "$receiver");
        char[] cArr = new char[hVar.j().length * 2];
        int i5 = 0;
        for (byte b6 : hVar.j()) {
            int i6 = i5 + 1;
            char[] cArr2 = f4160a;
            cArr[i5] = cArr2[(b6 >> 4) & 15];
            i5 += 2;
            cArr[i6] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    public static final h k(byte[] bArr) {
        k.h(bArr, "data");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        k.c(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new h(bArrCopyOf);
    }

    public static final boolean l(h hVar, int i5, h hVar2, int i6, int i7) {
        k.h(hVar, "$receiver");
        k.h(hVar2, "other");
        return hVar2.r(i6, hVar.j(), i5, i7);
    }

    public static final boolean m(h hVar, int i5, byte[] bArr, int i6, int i7) {
        k.h(hVar, "$receiver");
        k.h(bArr, "other");
        return i5 >= 0 && i5 <= hVar.j().length - i7 && i6 >= 0 && i6 <= bArr.length - i7 && c.a(hVar.j(), i5, bArr, i6, i7);
    }

    public static final boolean n(h hVar, h hVar2) {
        k.h(hVar, "$receiver");
        k.h(hVar2, "prefix");
        return hVar.q(0, hVar2, 0, hVar2.w());
    }

    public static final h o(h hVar, int i5, int i6) {
        k.h(hVar, "$receiver");
        if (i5 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (i6 > hVar.j().length) {
            throw new IllegalArgumentException(("endIndex > length(" + hVar.j().length + ')').toString());
        }
        int i7 = i6 - i5;
        if (i7 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i5 == 0 && i6 == hVar.j().length) {
            return hVar;
        }
        byte[] bArr = new byte[i7];
        b.a(hVar.j(), i5, bArr, 0, i7);
        return new h(bArr);
    }

    public static final h p(h hVar) {
        byte b6;
        k.h(hVar, "$receiver");
        for (int i5 = 0; i5 < hVar.j().length; i5++) {
            byte b7 = hVar.j()[i5];
            byte b8 = (byte) 65;
            if (b7 >= b8 && b7 <= (b6 = (byte) 90)) {
                byte[] bArrJ = hVar.j();
                byte[] bArrCopyOf = Arrays.copyOf(bArrJ, bArrJ.length);
                k.c(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i5] = (byte) (b7 + 32);
                for (int i6 = i5 + 1; i6 < bArrCopyOf.length; i6++) {
                    byte b9 = bArrCopyOf[i6];
                    if (b9 >= b8 && b9 <= b6) {
                        bArrCopyOf[i6] = (byte) (b9 + 32);
                    }
                }
                return new h(bArrCopyOf);
            }
        }
        return hVar;
    }

    public static final byte[] q(h hVar) {
        k.h(hVar, "$receiver");
        byte[] bArrJ = hVar.j();
        byte[] bArrCopyOf = Arrays.copyOf(bArrJ, bArrJ.length);
        k.c(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    public static final String r(h hVar) {
        k.h(hVar, "$receiver");
        if (hVar.j().length == 0) {
            return "[size=0]";
        }
        int iA = a(hVar.j(), 64);
        if (iA == -1) {
            if (hVar.j().length <= 64) {
                return "[hex=" + hVar.n() + ']';
            }
            return "[size=" + hVar.j().length + " hex=" + o(hVar, 0, 64).n() + "…]";
        }
        String strC = hVar.C();
        if (strC == null) {
            throw new s("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strC.substring(0, iA);
        k.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strO = C1031n.o(C1031n.o(C1031n.o(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (iA >= strC.length()) {
            return "[text=" + strO + ']';
        }
        return "[size=" + hVar.j().length + " text=" + strO + "…]";
    }

    public static final String s(h hVar) {
        k.h(hVar, "$receiver");
        String strM = hVar.m();
        if (strM != null) {
            return strM;
        }
        String strC = b.c(hVar.j());
        hVar.t(strC);
        return strC;
    }

    private static final int t(char c6) {
        if ('0' <= c6 && '9' >= c6) {
            return c6 - '0';
        }
        if ('a' <= c6 && 'f' >= c6) {
            return c6 - 'W';
        }
        if ('A' <= c6 && 'F' >= c6) {
            return c6 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c6);
    }

    public static final h u() {
        return f4161b;
    }
}
