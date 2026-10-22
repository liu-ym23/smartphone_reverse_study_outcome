package W3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: W3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0400k extends C0399j {
    public static final <T> boolean l(T[] tArr, T t5) {
        j4.k.g(tArr, "<this>");
        return r(tArr, t5) >= 0;
    }

    public static <T> List<T> m(T[] tArr) {
        j4.k.g(tArr, "<this>");
        return (List) n(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C n(T[] tArr, C c6) {
        j4.k.g(tArr, "<this>");
        j4.k.g(c6, "destination");
        for (T t5 : tArr) {
            if (t5 != null) {
                c6.add(t5);
            }
        }
        return c6;
    }

    public static final <T> int o(T[] tArr) {
        j4.k.g(tArr, "<this>");
        return tArr.length - 1;
    }

    public static Boolean p(boolean[] zArr, int i5) {
        j4.k.g(zArr, "<this>");
        if (i5 < 0 || i5 >= zArr.length) {
            return null;
        }
        return Boolean.valueOf(zArr[i5]);
    }

    public static <T> T q(T[] tArr, int i5) {
        j4.k.g(tArr, "<this>");
        if (i5 < 0 || i5 >= tArr.length) {
            return null;
        }
        return tArr[i5];
    }

    public static final <T> int r(T[] tArr, T t5) {
        j4.k.g(tArr, "<this>");
        int i5 = 0;
        if (t5 == null) {
            int length = tArr.length;
            while (i5 < length) {
                if (tArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i5 < length2) {
            if (j4.k.b(t5, tArr[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static char s(char[] cArr) {
        j4.k.g(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T t(T[] tArr) {
        j4.k.g(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static <T> List<T> u(T[] tArr) {
        j4.k.g(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? v(tArr) : o.b(tArr[0]) : p.h();
    }

    public static <T> List<T> v(T[] tArr) {
        j4.k.g(tArr, "<this>");
        return new ArrayList(p.e(tArr, false, 1, null));
    }
}
