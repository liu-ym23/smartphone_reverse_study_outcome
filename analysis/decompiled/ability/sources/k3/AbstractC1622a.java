package k3;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: k3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1622a {
    public static String a(int i, int i6, String str) {
        if (i < 0) {
            return h("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i6 >= 0) {
            return h("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException(B7.a.h(i6, "negative size: "));
    }

    public static void b(int i, int i6) {
        String strH;
        if (i < 0 || i >= i6) {
            if (i < 0) {
                strH = h("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i6 < 0) {
                    throw new IllegalArgumentException(B7.a.h(i6, "negative size: "));
                }
                strH = h("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i6));
            }
            throw new IndexOutOfBoundsException(strH);
        }
    }

    public static void c(int i, int i6) {
        if (i < 0 || i > i6) {
            throw new IndexOutOfBoundsException(a(i, i6, "index"));
        }
    }

    public static void d(int i, int i6, int i10) {
        if (i < 0 || i6 < i || i6 > i10) {
            throw new IndexOutOfBoundsException((i < 0 || i > i10) ? a(i, i10, "start index") : (i6 < 0 || i6 > i10) ? a(i6, i10, "end index") : h("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i)));
        }
    }

    public static void e(long j5, String str, boolean z10) {
        if (!z10) {
            throw new IllegalStateException(h(str, Long.valueOf(j5)));
        }
    }

    public static void f(String str, boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException(h(str, obj));
        }
    }

    public static Object g(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static String h(String str, Object... objArr) {
        int iIndexOf;
        String string;
        int i = 0;
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e);
                    StringBuilder sbV = B7.a.v("<", str2, " threw ");
                    sbV.append(e.getClass().getName());
                    sbV.append(">");
                    string = sbV.toString();
                }
            }
            objArr[i6] = string;
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + str.length());
        int i10 = 0;
        while (i < objArr.length && (iIndexOf = str.indexOf("%s", i10)) != -1) {
            sb.append((CharSequence) str, i10, iIndexOf);
            sb.append(objArr[i]);
            i10 = iIndexOf + 2;
            i++;
        }
        sb.append((CharSequence) str, i10, str.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i11 = i + 1; i11 < objArr.length; i11++) {
                sb.append(", ");
                sb.append(objArr[i11]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String i(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (c >= 'A' && c <= 'Z') {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }
}
