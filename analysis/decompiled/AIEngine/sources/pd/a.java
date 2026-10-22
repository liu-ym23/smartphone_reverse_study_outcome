package pd;

import bd.i;
import com.stepos.core.common.util.TraceIdKeys;
import gc.q;
import java.io.EOFException;
import kotlin.jvm.internal.g;
import sd.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f11481a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str, String str2, int i10, int i11, int i12) {
        int i13 = (i12 & 1) != 0 ? 0 : i10;
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        int i14 = i11;
        boolean z = (i12 & 8) == 0;
        boolean z3 = (i12 & 16) == 0;
        boolean z10 = (i12 & 32) == 0;
        boolean z11 = (i12 & 64) == 0;
        g.f(str, "<this>");
        return b(str, i13, i14, str2, z, z3, z10, z11, TraceIdKeys.MAX_LENGTH);
    }

    public static String b(String str, int i10, int i11, String str2, boolean z, boolean z3, boolean z10, boolean z11, int i12) throws EOFException {
        int i13 = (i12 & 1) != 0 ? 0 : i10;
        int length = (i12 & 2) != 0 ? str.length() : i11;
        boolean z12 = (i12 & 8) != 0 ? false : z;
        boolean z13 = (i12 & 16) != 0 ? false : z3;
        boolean z14 = (i12 & 64) == 0 ? z11 : false;
        g.f(str, "<this>");
        int iCharCount = i13;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i14 = TraceIdKeys.MAX_LENGTH;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z14) || q.m0(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z12 || (z13 && !c(iCharCount, length, str)))) || (iCodePointAt == 43 && z10)))) {
                e eVar = new e();
                eVar.T0(i13, iCharCount, str);
                e eVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z12 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 32 && str2 == " !\"#$&'()+,/:;<=>?@[\\]^`{|}~") {
                            eVar.U0("+");
                        } else if (iCodePointAt2 == 43 && z10) {
                            eVar.U0(z12 ? "+" : "%2B");
                        } else if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i14 && !z14) || q.m0(str2, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z12 || (z13 && !c(iCharCount, length, str)))))) {
                            if (eVar2 == null) {
                                eVar2 = new e();
                            }
                            eVar2.V0(iCodePointAt2);
                            while (!eVar2.f0()) {
                                byte b10 = eVar2.readByte();
                                eVar.O0(37);
                                char[] cArr = f11481a;
                                eVar.O0(cArr[((b10 & 255) >> 4) & 15]);
                                eVar.O0(cArr[b10 & 15]);
                            }
                        } else {
                            eVar.V0(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i14 = TraceIdKeys.MAX_LENGTH;
                }
                return eVar.J0();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = str.substring(i13, length);
        g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean c(int i10, int i11, String str) {
        g.f(str, "<this>");
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && i.l(str.charAt(i10 + 1)) != -1 && i.l(str.charAt(i12)) != -1;
    }

    public static String d(int i10, String str, int i11, int i12) {
        int i13;
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        boolean z = (i12 & 4) == 0;
        g.f(str, "<this>");
        int iCharCount = i10;
        while (iCharCount < i11) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                e eVar = new e();
                eVar.T0(i10, iCharCount, str);
                while (iCharCount < i11) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i13 = iCharCount + 2) < i11) {
                        int iL = i.l(str.charAt(iCharCount + 1));
                        int iL2 = i.l(str.charAt(i13));
                        if (iL == -1 || iL2 == -1) {
                            eVar.V0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            eVar.O0((iL << 4) + iL2);
                            iCharCount = Character.charCount(iCodePointAt) + i13;
                        }
                    } else if (iCodePointAt == 43 && z) {
                        eVar.O0(32);
                        iCharCount++;
                    } else {
                        eVar.V0(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return eVar.J0();
            }
            iCharCount++;
        }
        String strSubstring = str.substring(i10, i11);
        g.e(strSubstring, "substring(...)");
        return strSubstring;
    }
}
