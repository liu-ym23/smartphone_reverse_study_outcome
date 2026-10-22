package gc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class o extends n {
    public static boolean e0(String str, String suffix, boolean z) {
        kotlin.jvm.internal.g.f(str, "<this>");
        kotlin.jvm.internal.g.f(suffix, "suffix");
        return !z ? str.endsWith(suffix) : g0(str.length() - suffix.length(), 0, suffix.length(), str, suffix, true);
    }

    public static boolean f0(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static boolean g0(int i10, int i11, int i12, String str, String other, boolean z) {
        kotlin.jvm.internal.g.f(str, "<this>");
        kotlin.jvm.internal.g.f(other, "other");
        return !z ? str.regionMatches(i10, other, i11, i12) : str.regionMatches(z, i10, other, i11, i12);
    }

    public static String h0(String str, char c9, char c10) {
        kotlin.jvm.internal.g.f(str, "<this>");
        String strReplace = str.replace(c9, c10);
        kotlin.jvm.internal.g.e(strReplace, "replace(...)");
        return strReplace;
    }

    public static String i0(String str, String oldValue, String str2) {
        kotlin.jvm.internal.g.f(str, "<this>");
        kotlin.jvm.internal.g.f(oldValue, "oldValue");
        int iO0 = q.o0(str, oldValue, 0, false);
        if (iO0 < 0) {
            return str;
        }
        int length = oldValue.length();
        int i10 = length >= 1 ? length : 1;
        int length2 = str2.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        int i11 = 0;
        do {
            sb2.append((CharSequence) str, i11, iO0);
            sb2.append(str2);
            i11 = iO0 + length;
            if (iO0 >= str.length()) {
                break;
            }
            iO0 = q.o0(str, oldValue, iO0 + i10, false);
        } while (iO0 > 0);
        sb2.append((CharSequence) str, i11, str.length());
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public static boolean j0(int i10, String str, String str2, boolean z) {
        kotlin.jvm.internal.g.f(str, "<this>");
        return !z ? str.startsWith(str2, i10) : g0(i10, 0, str2.length(), str, str2, z);
    }

    public static boolean k0(String str, String prefix, boolean z) {
        kotlin.jvm.internal.g.f(str, "<this>");
        kotlin.jvm.internal.g.f(prefix, "prefix");
        return !z ? str.startsWith(prefix) : g0(0, 0, prefix.length(), str, prefix, z);
    }
}
