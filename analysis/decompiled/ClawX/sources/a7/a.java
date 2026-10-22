package a7;

import c7.f;
import java.io.EOFException;
import kotlin.jvm.internal.p;
import o6.d;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f234a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str, int i8, int i9, String str2, int i10) throws EOFException {
        int i11 = (i10 & 1) != 0 ? 0 : i8;
        int length = (i10 & 2) != 0 ? str.length() : i9;
        boolean z = (i10 & 8) == 0;
        boolean z2 = (i10 & 16) == 0;
        boolean z8 = (i10 & 32) == 0;
        boolean z9 = (i10 & 64) == 0;
        p.e(str, "<this>");
        int iCharCount = i11;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i12 = 32;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z9) || n.h1(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z || (z2 && !b(iCharCount, length, str)))) || (iCodePointAt == 43 && z8)))) {
                f fVar = new f();
                fVar.H(i11, iCharCount, str);
                f fVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == i12 && str2 == " !\"#$&'()+,/:;<=>?@[\\]^`{|}~") {
                            fVar.I("+");
                        } else if (iCodePointAt2 == 43 && z8) {
                            fVar.I(z ? "+" : "%2B");
                        } else {
                            if (iCodePointAt2 >= i12 && iCodePointAt2 != 127) {
                                if ((iCodePointAt2 < 128 || z9) && !n.h1(str2, (char) iCodePointAt2) && (iCodePointAt2 != 37 || (z && (!z2 || b(iCharCount, length, str))))) {
                                    fVar.J(iCodePointAt2);
                                }
                            }
                            if (fVar2 == null) {
                                fVar2 = new f();
                            }
                            fVar2.J(iCodePointAt2);
                            while (!fVar2.q()) {
                                byte b9 = fVar2.readByte();
                                fVar.A(37);
                                char[] cArr = f234a;
                                fVar.A(cArr[((b9 & 255) >> 4) & 15]);
                                fVar.A(cArr[b9 & 15]);
                            }
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i12 = 32;
                }
                return fVar.o();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = str.substring(i11, length);
        p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean b(int i8, int i9, String str) {
        p.e(str, "<this>");
        int i10 = i8 + 2;
        return i10 < i9 && str.charAt(i8) == '%' && d.k(str.charAt(i8 + 1)) != -1 && d.k(str.charAt(i10)) != -1;
    }

    public static String c(String str, int i8, int i9, int i10) {
        int i11;
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        boolean z = (i10 & 4) == 0;
        p.e(str, "<this>");
        int iCharCount = i8;
        while (iCharCount < i9) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                f fVar = new f();
                fVar.H(i8, iCharCount, str);
                while (iCharCount < i9) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i11 = iCharCount + 2) < i9) {
                        int iK = d.k(str.charAt(iCharCount + 1));
                        int iK2 = d.k(str.charAt(i11));
                        if (iK == -1 || iK2 == -1) {
                            fVar.J(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            fVar.A((iK << 4) + iK2);
                            iCharCount = Character.charCount(iCodePointAt) + i11;
                        }
                    } else if (iCodePointAt == 43 && z) {
                        fVar.A(32);
                        iCharCount++;
                    } else {
                        fVar.J(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return fVar.o();
            }
            iCharCount++;
        }
        String strSubstring = str.substring(i8, i9);
        p.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}
