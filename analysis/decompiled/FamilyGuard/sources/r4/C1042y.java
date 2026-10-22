package r4;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: r4.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1042y extends C1041x {
    public static boolean l(String str, String str2, boolean z5) {
        j4.k.g(str, "<this>");
        j4.k.g(str2, "suffix");
        return !z5 ? str.endsWith(str2) : m(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static final boolean m(String str, int i5, String str2, int i6, int i7, boolean z5) {
        j4.k.g(str, "<this>");
        j4.k.g(str2, "other");
        return !z5 ? str.regionMatches(i5, str2, i6, i7) : str.regionMatches(z5, i5, str2, i6, i7);
    }

    public static final String n(String str, String str2, String str3, boolean z5) {
        j4.k.g(str, "<this>");
        j4.k.g(str2, "oldValue");
        j4.k.g(str3, "newValue");
        int i5 = 0;
        int iY = C1015B.y(str, str2, 0, z5);
        if (iY < 0) {
            return str;
        }
        int length = str2.length();
        int iB = kotlin.ranges.l.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i5, iY);
            sb.append(str3);
            i5 = iY + length;
            if (iY >= str.length()) {
                break;
            }
            iY = C1015B.y(str, str2, iY + iB, z5);
        } while (iY > 0);
        sb.append((CharSequence) str, i5, str.length());
        String string = sb.toString();
        j4.k.f(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String o(String str, String str2, String str3, boolean z5, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        return n(str, str2, str3, z5);
    }

    public static boolean p(String str, String str2, boolean z5) {
        j4.k.g(str, "<this>");
        j4.k.g(str2, "prefix");
        return !z5 ? str.startsWith(str2) : m(str, 0, str2, 0, str2.length(), z5);
    }

    public static /* synthetic */ boolean q(String str, String str2, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return p(str, str2, z5);
    }
}
