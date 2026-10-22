package ab;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f498a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final b f499b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final b f500c = new b();

    public static final g a(b bVar, String str) {
        g gVar = new g(str);
        g.f530d.put(str, gVar);
        return gVar;
    }

    public static String b(String str, int i2, int i10, String str2, int i11) throws EOFException {
        int i12 = (i11 & 1) != 0 ? 0 : i2;
        int length = (i11 & 2) != 0 ? str.length() : i10;
        boolean z4 = (i11 & 8) == 0;
        boolean z10 = (i11 & 16) == 0;
        boolean z11 = (i11 & 32) == 0;
        boolean z12 = (i11 & 64) == 0;
        q7.k.e(str, "<this>");
        int iCharCount = i12;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i13 = 128;
            int i14 = 32;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z12) || ga.k.l0(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z4 || (z10 && !d(str, iCharCount, length)))) || (iCodePointAt == 43 && z11)))) {
                ob.h hVar = new ob.h();
                hVar.V(str, i12, iCharCount);
                ob.h hVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z4 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z11) {
                            hVar.U(z4 ? "+" : "%2B");
                        } else if (iCodePointAt2 < i14 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i13 && !z12) || ga.k.l0(str2, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z4 || (z10 && !d(str, iCharCount, length)))))) {
                            if (hVar2 == null) {
                                hVar2 = new ob.h();
                            }
                            hVar2.W(iCodePointAt2);
                            while (!hVar2.e()) {
                                byte b10 = hVar2.readByte();
                                hVar.Q(37);
                                char[] cArr = p.f587j;
                                hVar.Q(cArr[((b10 & 255) >> 4) & 15]);
                                hVar.Q(cArr[b10 & 15]);
                            }
                        } else {
                            hVar.W(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i13 = 128;
                    i14 = 32;
                }
                return hVar.z();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = str.substring(i12, length);
        q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static boolean d(String str, int i2, int i10) {
        int i11 = i2 + 2;
        return i11 < i10 && str.charAt(i2) == '%' && bb.b.r(str.charAt(i2 + 1)) != -1 && bb.b.r(str.charAt(i11)) != -1;
    }

    public static String e(String str, int i2, int i10, int i11) {
        int i12;
        if ((i11 & 1) != 0) {
            i2 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        boolean z4 = (i11 & 4) == 0;
        q7.k.e(str, "<this>");
        int iCharCount = i2;
        while (iCharCount < i10) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z4)) {
                ob.h hVar = new ob.h();
                hVar.V(str, i2, iCharCount);
                while (iCharCount < i10) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i12 = iCharCount + 2) < i10) {
                        int iR = bb.b.r(str.charAt(iCharCount + 1));
                        int iR2 = bb.b.r(str.charAt(i12));
                        if (iR == -1 || iR2 == -1) {
                            hVar.W(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            hVar.Q((iR << 4) + iR2);
                            iCharCount = Character.charCount(iCodePointAt) + i12;
                        }
                    } else if (iCodePointAt == 43 && z4) {
                        hVar.Q(32);
                        iCharCount++;
                    } else {
                        hVar.W(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return hVar.z();
            }
            iCharCount++;
        }
        String strSubstring = str.substring(i2, i10);
        q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static ArrayList f(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int iQ0 = ga.k.q0(str, '&', i2, 4);
            if (iQ0 == -1) {
                iQ0 = str.length();
            }
            int iQ02 = ga.k.q0(str, '=', i2, 4);
            if (iQ02 == -1 || iQ02 > iQ0) {
                String strSubstring = str.substring(i2, iQ0);
                q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring);
                arrayList.add(null);
            } else {
                String strSubstring2 = str.substring(i2, iQ02);
                q7.k.d(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring2);
                String strSubstring3 = str.substring(iQ02 + 1, iQ0);
                q7.k.d(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring3);
            }
            i2 = iQ0 + 1;
        }
        return arrayList;
    }

    public synchronized g c(String str) {
        g gVar;
        String strConcat;
        try {
            q7.k.e(str, "javaName");
            LinkedHashMap linkedHashMap = g.f530d;
            gVar = (g) linkedHashMap.get(str);
            if (gVar == null) {
                if (ga.r.g0(str, "TLS_", false)) {
                    String strSubstring = str.substring(4);
                    q7.k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
                    strConcat = "SSL_".concat(strSubstring);
                } else if (ga.r.g0(str, "SSL_", false)) {
                    String strSubstring2 = str.substring(4);
                    q7.k.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    strConcat = "TLS_".concat(strSubstring2);
                } else {
                    strConcat = str;
                }
                gVar = (g) linkedHashMap.get(strConcat);
                if (gVar == null) {
                    gVar = new g(str);
                }
                linkedHashMap.put(str, gVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return gVar;
    }
}
