package F9;

import java.io.EOFException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: F9.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0237o implements InterfaceC0224b, InterfaceC0239q {
    public static final C0237o c = new C0237o();

    public static final C0232j b(C0237o c0237o, String str) {
        C0232j c0232j = new C0232j(str);
        C0232j.d.put(str, c0232j);
        return c0232j;
    }

    public static String c(String str, int i, boolean z10, String str2, int i6, int i10) throws EOFException {
        int i11 = (i10 & 1) != 0 ? 0 : i;
        int length = (i10 & 2) != 0 ? str.length() : i6;
        boolean z11 = (i10 & 8) != 0 ? false : z10;
        boolean z12 = (i10 & 16) == 0;
        boolean z13 = (i10 & 32) == 0;
        boolean z14 = (i10 & 64) == 0;
        kotlin.jvm.internal.k.f(str, "<this>");
        int iCharCount = i11;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i12 = 128;
            int i13 = 32;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z14) || j9.m.i0(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z11 || (z12 && !e(iCharCount, length, str)))) || (iCodePointAt == 43 && z13)))) {
                V9.g gVar = new V9.g();
                gVar.Q(i11, iCharCount, str);
                V9.g gVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z11 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z13) {
                            gVar.R(z11 ? "+" : "%2B");
                        } else if (iCodePointAt2 < i13 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i12 && !z14) || j9.m.i0(str2, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z11 || (z12 && !e(iCharCount, length, str)))))) {
                            if (gVar2 == null) {
                                gVar2 = new V9.g();
                            }
                            gVar2.S(iCodePointAt2);
                            while (!gVar2.n()) {
                                byte b = gVar2.readByte();
                                gVar.L(37);
                                char[] cArr = y.k;
                                gVar.L(cArr[((b & 255) >> 4) & 15]);
                                gVar.L(cArr[b & 15]);
                            }
                        } else {
                            gVar.S(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i12 = 128;
                    i13 = 32;
                }
                return gVar.G();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = str.substring(i11, length);
        kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static boolean e(int i, int i6, String str) {
        int i10 = i + 2;
        return i10 < i6 && str.charAt(i) == '%' && G9.b.p(str.charAt(i + 1)) != -1 && G9.b.p(str.charAt(i10)) != -1;
    }

    public static String f(String str, int i, int i6, int i10) {
        int i11;
        if ((i10 & 1) != 0) {
            i = 0;
        }
        if ((i10 & 2) != 0) {
            i6 = str.length();
        }
        boolean z10 = (i10 & 4) == 0;
        kotlin.jvm.internal.k.f(str, "<this>");
        int iCharCount = i;
        while (iCharCount < i6) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                V9.g gVar = new V9.g();
                gVar.Q(i, iCharCount, str);
                while (iCharCount < i6) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i11 = iCharCount + 2) < i6) {
                        int iP = G9.b.p(str.charAt(iCharCount + 1));
                        int iP2 = G9.b.p(str.charAt(i11));
                        if (iP == -1 || iP2 == -1) {
                            gVar.S(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            gVar.L((iP << 4) + iP2);
                            iCharCount = Character.charCount(iCodePointAt) + i11;
                        }
                    } else if (iCodePointAt == 43 && z10) {
                        gVar.L(32);
                        iCharCount++;
                    } else {
                        gVar.S(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return gVar.G();
            }
            iCharCount++;
        }
        String strSubstring = str.substring(i, i6);
        kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static ArrayList g(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iP0 = j9.m.p0(str, '&', i, 4);
            if (iP0 == -1) {
                iP0 = str.length();
            }
            int iP02 = j9.m.p0(str, '=', i, 4);
            if (iP02 == -1 || iP02 > iP0) {
                String strSubstring = str.substring(i, iP0);
                kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring);
                arrayList.add(null);
            } else {
                String strSubstring2 = str.substring(i, iP02);
                kotlin.jvm.internal.k.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring2);
                String strSubstring3 = str.substring(iP02 + 1, iP0);
                kotlin.jvm.internal.k.e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring3);
            }
            i = iP0 + 1;
        }
        return arrayList;
    }

    @Override // F9.InterfaceC0239q
    public List a(String hostname) throws UnknownHostException {
        kotlin.jvm.internal.k.f(hostname, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(hostname);
            kotlin.jvm.internal.k.e(allByName, "getAllByName(hostname)");
            return D7.q.I0(allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostname));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }

    @Override // F9.InterfaceC0224b
    public G authenticate(Q q5, M response) {
        kotlin.jvm.internal.k.f(response, "response");
        return null;
    }

    public synchronized C0232j d(String javaName) {
        C0232j c0232j;
        String strConcat;
        try {
            kotlin.jvm.internal.k.f(javaName, "javaName");
            LinkedHashMap linkedHashMap = C0232j.d;
            c0232j = (C0232j) linkedHashMap.get(javaName);
            if (c0232j == null) {
                if (j9.t.e0(javaName, "TLS_", false)) {
                    String strSubstring = javaName.substring(4);
                    kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                    strConcat = "SSL_".concat(strSubstring);
                } else if (j9.t.e0(javaName, "SSL_", false)) {
                    String strSubstring2 = javaName.substring(4);
                    kotlin.jvm.internal.k.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    strConcat = "TLS_".concat(strSubstring2);
                } else {
                    strConcat = javaName;
                }
                c0232j = (C0232j) linkedHashMap.get(strConcat);
                if (c0232j == null) {
                    c0232j = new C0232j(javaName);
                }
                linkedHashMap.put(javaName, c0232j);
            }
        } catch (Throwable th) {
            throw th;
        }
        return c0232j;
    }
}
