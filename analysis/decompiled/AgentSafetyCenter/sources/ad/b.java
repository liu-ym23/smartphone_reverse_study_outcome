package ad;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f433a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final b f434b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final b f435c = new b();

    public static final g a(b bVar, String str) {
        g gVar = new g(str);
        g.f487d.put(str, gVar);
        return gVar;
    }

    public static String b(String str, int i, int i3, String str2, int i10) {
        int i11 = (i10 & 1) != 0 ? 0 : i;
        int length = (i10 & 2) != 0 ? str.length() : i3;
        boolean z10 = (i10 & 8) == 0;
        boolean z11 = (i10 & 16) == 0;
        boolean z12 = (i10 & 32) == 0;
        boolean z13 = (i10 & 64) == 0;
        str.getClass();
        int iCharCount = i11;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i12 = 128;
            int i13 = 32;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z13) || hc.h.Y(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z10 || (z11 && !d(iCharCount, length, str)))) || (iCodePointAt == 43 && z12)))) {
                od.i iVar = new od.i();
                iVar.f0(i11, iCharCount, str);
                od.i iVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z10 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z12) {
                            iVar.g0(z10 ? "+" : "%2B");
                        } else if (iCodePointAt2 < i13 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i12 && !z13) || hc.h.Y(str2, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z10 || (z11 && !d(iCharCount, length, str)))))) {
                            if (iVar2 == null) {
                                iVar2 = new od.i();
                            }
                            iVar2.h0(iCodePointAt2);
                            while (!iVar2.A()) {
                                byte bN = iVar2.N();
                                iVar.b0(37);
                                char[] cArr = q.f558k;
                                iVar.b0(cArr[((bN & 255) >> 4) & 15]);
                                iVar.b0(cArr[bN & 15]);
                            }
                        } else {
                            iVar.h0(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i12 = 128;
                    i13 = 32;
                }
                return iVar.U();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i11, length);
    }

    public static boolean d(int i, int i3, String str) {
        int i10 = i + 2;
        return i10 < i3 && str.charAt(i) == '%' && bd.b.q(str.charAt(i + 1)) != -1 && bd.b.q(str.charAt(i10)) != -1;
    }

    public static String e(String str, int i, int i3, int i10) {
        int i11;
        if ((i10 & 1) != 0) {
            i = 0;
        }
        if ((i10 & 2) != 0) {
            i3 = str.length();
        }
        boolean z10 = (i10 & 4) == 0;
        str.getClass();
        int iCharCount = i;
        while (iCharCount < i3) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                od.i iVar = new od.i();
                iVar.f0(i, iCharCount, str);
                while (iCharCount < i3) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i11 = iCharCount + 2) < i3) {
                        int iQ = bd.b.q(str.charAt(iCharCount + 1));
                        int iQ2 = bd.b.q(str.charAt(i11));
                        if (iQ == -1 || iQ2 == -1) {
                            iVar.h0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            iVar.b0((iQ << 4) + iQ2);
                            iCharCount = Character.charCount(iCodePointAt) + i11;
                        }
                    } else if (iCodePointAt == 43 && z10) {
                        iVar.b0(32);
                        iCharCount++;
                    } else {
                        iVar.h0(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return iVar.U();
            }
            iCharCount++;
        }
        return str.substring(i, i3);
    }

    public static ArrayList f(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iD0 = hc.h.d0(str, '&', i, 4);
            if (iD0 == -1) {
                iD0 = str.length();
            }
            int iD02 = hc.h.d0(str, '=', i, 4);
            if (iD02 == -1 || iD02 > iD0) {
                arrayList.add(str.substring(i, iD0));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iD02));
                arrayList.add(str.substring(iD02 + 1, iD0));
            }
            i = iD0 + 1;
        }
        return arrayList;
    }

    public static void g(StringBuilder sb2, ArrayList arrayList) {
        arrayList.getClass();
        ec.f fVarL = p5.f.L(p5.f.O(0, arrayList.size()), 2);
        int i = fVarL.f3758c;
        int i3 = fVarL.f3759f;
        int i10 = fVarL.f3760g;
        if ((i10 <= 0 || i > i3) && (i10 >= 0 || i3 > i)) {
            return;
        }
        while (true) {
            String str = (String) arrayList.get(i);
            String str2 = (String) arrayList.get(i + 1);
            if (i > 0) {
                sb2.append('&');
            }
            sb2.append(str);
            if (str2 != null) {
                sb2.append('=');
                sb2.append(str2);
            }
            if (i == i3) {
                return;
            } else {
                i += i10;
            }
        }
    }

    public synchronized g c(String str) {
        g gVar;
        try {
            str.getClass();
            LinkedHashMap linkedHashMap = g.f487d;
            gVar = (g) linkedHashMap.get(str);
            if (gVar == null) {
                gVar = (g) linkedHashMap.get(hc.o.U(str, "TLS_", false) ? "SSL_".concat(str.substring(4)) : hc.o.U(str, "SSL_", false) ? "TLS_".concat(str.substring(4)) : str);
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
