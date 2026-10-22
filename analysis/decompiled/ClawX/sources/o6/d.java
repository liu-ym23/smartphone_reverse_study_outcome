package o6;

import c7.h;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f4327a = new byte[0];

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0142, code lost:
    
        continue;
     */
    static {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.d.<clinit>():void");
    }

    public static final void a(Closeable closeable) throws IOException {
        p.e(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e9) {
            throw e9;
        } catch (Exception unused) {
        }
    }

    public static final int b(int i8, int i9, String str, String str2) {
        p.e(str, "<this>");
        while (i8 < i9) {
            if (n.h1(str2, str.charAt(i8))) {
                return i8;
            }
            i8++;
        }
        return i9;
    }

    public static final int c(String str, char c3, int i8, int i9) {
        p.e(str, "<this>");
        while (i8 < i9) {
            if (str.charAt(i8) == c3) {
                return i8;
            }
            i8++;
        }
        return i9;
    }

    public static /* synthetic */ int d(String str, char c3, int i8, int i9, int i10) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = str.length();
        }
        return c(str, c3, i8, i9);
    }

    public static final boolean e(String[] strArr, String[] strArr2, Comparator comparator) {
        p.e(strArr, "<this>");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final int f(String str) {
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (p.g(cCharAt, 31) <= 0 || p.g(cCharAt, 127) >= 0) {
                return i8;
            }
        }
        return -1;
    }

    public static final int g(int i8, int i9, String str) {
        while (i8 < i9) {
            char cCharAt = str.charAt(i8);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i8;
            }
            i8++;
        }
        return i9;
    }

    public static final int h(int i8, int i9, String str) {
        int i10 = i9 - 1;
        if (i8 <= i10) {
            while (true) {
                char cCharAt = str.charAt(i10);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i10 + 1;
                }
                if (i10 == i8) {
                    break;
                }
                i10--;
            }
        }
        return i8;
    }

    public static final String[] i(String[] strArr, String[] other, Comparator comparator) {
        p.e(strArr, "<this>");
        p.e(other, "other");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i8]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i8++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean j(String name) {
        p.e(name, "name");
        return name.equalsIgnoreCase("Authorization") || name.equalsIgnoreCase("Cookie") || name.equalsIgnoreCase("Proxy-Authorization") || name.equalsIgnoreCase("Set-Cookie");
    }

    public static final int k(char c3) {
        if ('0' <= c3 && c3 < ':') {
            return c3 - '0';
        }
        if ('a' <= c3 && c3 < 'g') {
            return c3 - 'W';
        }
        if ('A' > c3 || c3 >= 'G') {
            return -1;
        }
        return c3 - '7';
    }

    public static final int l(h hVar) {
        p.e(hVar, "<this>");
        return (hVar.readByte() & 255) | ((hVar.readByte() & 255) << 16) | ((hVar.readByte() & 255) << 8);
    }

    public static final int m(int i8, String str) throws NumberFormatException {
        if (str == null) {
            return i8;
        }
        try {
            long j4 = Long.parseLong(str);
            if (j4 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j4 < 0) {
                return 0;
            }
            return (int) j4;
        } catch (NumberFormatException unused) {
            return i8;
        }
    }

    public static final String n(int i8, int i9, String str) {
        int iG = g(i8, i9, str);
        String strSubstring = str.substring(iG, h(iG, i9, str));
        p.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}
